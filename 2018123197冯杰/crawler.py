from pyspider.libs.base_handler import *
import random
import pymysql

class Handler(BaseHandler):
    crawl_config = {
        'headers': {
            'Accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8'
        }
    }
    
    def __init__(self):
        self.db = pymysql.connect('localhost', 'root', '123', 'wenda', charset='utf8')
    
    def add_question(self, title, content, comment_count):
        try:
            cursor = self.db.cursor()
            sql = 'insert into question(title, content, user_id, created_date,comment_count) values ("%s","%s",%d, %s, %d)' % (title,content,random.randint(1, 10),'now()', comment_count);
            cursor.execute(sql)
            qid = cursor.lastrowid
            self.db.commit()
            return qid
        except Exception as e:
            print(e)
            self.db.rollback()
        return 0
            
    def add_comment(self, qid, comment):
        try:
            cursor = self.db.cursor()
            sql = 'insert into comment(content, entity_type, entity_id, user_id, created_date) values ("%s", %d, %d, %d, %s)' % (comment, 1, qid, random.randint(1, 10) , 'now()');
            cursor.execute(sql)
            self.db.commit()
        except Exception as e:
            print(e)
            self.db.rollback()

    @every(minutes=24 * 60)
    def on_start(self):
        self.crawl('https://www.v2ex.com/?tab=tech', callback=self.index_page, validate_cert=False)

    @config(age=10 * 24 * 60 * 60)
    def index_page(self, response):
        for each in response.doc('a[href^="https://www.v2ex.com/?tab="]').items():
            self.crawl(each.attr.href, callback=self.tab_page, validate_cert=False)
            
    @config(age=10 * 24 * 60 * 60) 
    def tab_page(self, response):
        for each in response.doc('a[href^="https://www.v2ex.com/go/"]').items():
            self.crawl(each.attr.href, callback=self.board_page, validate_cert=False)

    
    @config(priority=2)
    def board_page(self, response):
        for each in response.doc('a[href^="https://www.v2ex.com/t/"]').items():
            url = each.attr.href
            if url.find('#reply') > 0:
                url = url[0:url.find('#')]
            self.crawl(url, callback=self.detail_page, validate_cert=False)
        for each in response.doc('a.page_normal').items():
            self.crawl(each.attr.href, callback=self.board_page, validate_cert=False)
    
    @config(priority=20)
    def detail_page(self, response):
        title = response.doc('h1').text()
        html = response.doc('div.topic_content').html()
        content = html.replace('"', '\\"')
        items = response.doc('div.reply_content').items()
        count = sum(1 for x in items)
        qid = self.add_question(title, content, count)
        for each in response.doc('div.reply_content').items():
            self.add_comment(qid, each.html().replace('"', '\\"'))
           
        return {
            'url': response.url,
            'title': title,
            'content': content
        }
            