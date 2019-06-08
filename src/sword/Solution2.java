package sword;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
        则经过替换之后的字符串为We%20Are%20Happy。
*/

public class Solution2 {

  /*  void replaceSpace(char *str,int length) {
        if(str == NULL || length < 0)
            return;

        int oldnumber = 0;
        int replacenumber = 0;
        int i = 0;
        while(str[i] != '\0') {
            oldnumber++;
            if(str[i] == ' ') {
                replacenumber++;
            }
            i++;
        }

        int newlength = oldnumber + replacenumber * 2;
        if(newlength > length)
            return;

        int pOldlength = oldnumber; //注意不要减一因为隐藏个‘\0’也要算里
        int pNewlength = newlength;

        while(pOldlength >= 0 && pNewlength >= pOldlength) {
            if(str[pOldlength] == ' ') {
                str[pNewlength--] = '0';
                str[pNewlength--] = '2';
                str[pNewlength--] = '%';
            } else{
                str[pNewlength--] = str[pOldlength];
            }

            pOldlength--;
        }
    }*/
}
