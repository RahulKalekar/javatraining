package day6.Q1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//get the links
class FileUtil{
    public static List<String> readFiles(String fileName){
        List<String> files=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line=null;
            while ((line=br.readLine())!=null){
                files.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return files;
    }
}
// create downloader
class DownloadManager{
    public static void download(String url){
        System.out.println(Thread.currentThread().getName()+" starting download "+ url);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" done downloaded "+ url);
    }
}

public class Q1 {
    public static void main(String[] args) {
        List<String> urls=FileUtil.readFiles("link.txt");

        for(String url: urls){
            DownloadManager.download(url);
        }
    }
}