

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.Connection;

/**
 * Created by Administrator on 09/04/2018.
 */
public class Main {
    public static void main(String[] args) {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        try {
//            char c=(char)br.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//---------------------------------
//        String text;
//        InputStreamReader inputStream=new InputStreamReader(System.in);
//        BufferedReader br=new BufferedReader(inputStream);
//        try {
//            text=br.readLine();
//            System.out.println("Ban Vua Nhap:"+text);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//--------------------------------------------
        try {
           // File fl = new File("F:/Vccrop/myfile.txt");
            File fl = new File("");
            BufferedReader br = new BufferedReader(new FileReader("F:\\VCCrop\\ThucTap\\BaiTap\\aa.txt"));
            String s;
            String s1 = "";
            File fl1 = new File("F:/java vcc/myfile1.txt");
            FileWriter fw = new FileWriter(fl1);

            while ((s = br.readLine()) != null) {
                System.out.println(s);
               // s1+=s+"\n";
            }
            //fw.write(s1);
            fw.close();
            System.out.println(s);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
