
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.json.JsonObject;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        User user2;
        User user1;
        float i=1,size1=0,size2=0;
        Logger logger = LoggerFactory.getLogger("");
        try {
            while (true) {
                URL url = new URL("http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn");
                StringBuilder content = new StringBuilder();
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bf = new BufferedReader(inputStreamReader);
                String line = "";

                while ((line = bf.readLine()) != null) {
                    content.append(line);
                }
                bf.close();
                inputStreamReader.close();

                ObjectMapper mapper = new ObjectMapper();

                user1 = (User) mapper.readValue(content.toString(), User.class);
                size1=user1.getSource().size();
            if (i <= 1) {
                    user2 = user1;
                    size2 = size1;
                    logger.debug(user2.toString());
                    System.out.println(size2 + ":" + user2.toString());
                    i += 1;
                    continue;
            }
            if (((size1 - size2) / size2 * 100) >=3) {
                user2 = user1;
                logger = LoggerFactory.getLogger("");
                logger.debug(user2.toString());
                size2 = user2.getSource().size();
                System.out.println(user2.getSource().size() + ":" + user2.toString());

            }else if (i==6){
                user2 = user1;
                logger = LoggerFactory.getLogger("");
                logger.debug(user2.toString());
                size2 = user2.getSource().size();
                System.out.println(user2.getSource().size() + ":" + user2.toString());
                i=0;
            }
            i+=1;
                System.out.println(i*2000);
            Thread.sleep(2000);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
