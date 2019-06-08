package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;

public class DownloadingWebpage {
    public static void main(String[] args) throws Exception {
        FileReader m=new FileReader("E:/PMIDs_Train.txt");
        BufferedReader reader1=new BufferedReader(m);
        for(int i=1;i<=94942;i++){
            String nextline=reader1.readLine();
            System.out.println("got:"+nextline);
            URL url = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&id="+nextline+" ");
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:/datasets/pubmed"+nextline+".txt"));
            String line;

            while ((line = reader2.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader2.close();
            writer.close();

            System.out.println("\n\n"+nextline+"finished!");
        }
        reader1.close();
    }
}
