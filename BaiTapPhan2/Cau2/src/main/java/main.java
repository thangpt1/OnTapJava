import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import sun.nio.cs.UTF_32;

import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class main {
    public static void main(String[] args) {

        Document doc;
        String s="";
        try {
            //lấy ngày h
            DateFormat dateFormat=new SimpleDateFormat("ddMMyy_HHmm");
            Calendar calendar=Calendar.getInstance();


            // tạo đường dẫn
            File apath=new File("D:\\Moon\\java\\OnTapJava\\BaiTapPhan2\\Cau2\\"+dateFormat.format(calendar.getTime())+".txt");

            //tạo thư mục cha nếu cha chưa tồn tại
            apath.getParentFile().mkdirs();

            // tạo file con nếu nó chưa tồn tại
            apath.createNewFile();

            // tao Data output để ghi file
            FileOutputStream fos=new FileOutputStream(apath);
            DataOutputStream dos=new DataOutputStream(fos);




            doc = Jsoup.connect("http://dantri.com.vn/the-gioi/video-dac-nhiem-nga-tieu-diet-nhom-phien-quan-khung-bo-20180423072747532.htm").get();
            String title = doc.title();


//          ghi title
            s+="title: "+title+"\n";



            // lấy elemrnt href của thẻ a;
            Elements links=doc.select("a[href]");
            s+="links ("+links.size()+"):";
            for (Element link:links
                 ) {
                // lấy nội dung trong href
                // lấy nội dung mô tả link
                s+="\n\t*a:"+link.attr("abs:href")+" ("+link.text()+" )";

            }



            // lấy link ảnh:
            Elements medias=doc.select("[src]");
            s+="\nMedia ("+medias.size()+"):";
            for (Element src:medias
                 ) {
                if(src.tagName().equals("img"))
                s+="\n\t*"+src.tagName()+": "+src.attr("abs:src")+" "+src.attr("width")+"x"+src.attr("height")+"("+src.attr("alt")+")";
                // anh nay ko co width ang height
                else
                    s+="\n\t*"+src.tagName()+": "+src.attr("abs:src");
            }



            // lay Import
            Elements imports=doc.select("link[href]");
//            System.out.println("Inport+("+imports.size()+"):");
            s+="\nInport ("+imports.size()+"):";
            for (Element link:imports
                 ) {
//                System.out.println("\t *" + link.tagName() + ": " + link.attr("abs:href"));
                s+="\n\t*" + link.tagName() + ": " + link.attr("abs:href");
            }





//          Lấy thẻ meta
            Elements metas=doc.select("meta[content]");
//            System.out.println("meta content ("+metas.size()+"):");
            s+="\nmeta content ("+metas.size()+"):";
            for (Element meta:metas){
//                System.out.println("\t"+meta.tagName()+": "+meta.attr("abs:content"));
                s+="\n\t*"+meta.tagName()+": "+meta.attr("abs:content");
           }




            // lấy nội dung thẻ <p>
            Elements divs = doc.getElementsByTag("p");
//            System.out.println("thẻ nội dung <p> ("+divs.size()+"):");
            s+="\nnội dung thẻ <p> ("+divs.size()+"):";
            for (Element div : divs) {
//                    System.out.println("\t"+div.tagName()+": "+div.text());
                    s+="\n\t*"+div.tagName()+": "+div.text();
            }
            System.out.println(s);
            dos.writeBytes(convertToUTF8(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String convertToUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }

}