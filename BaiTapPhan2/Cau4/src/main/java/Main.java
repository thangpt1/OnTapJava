import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        port(1233);
        get("/hello/n", (request, response) -> {
//            LoadingCache<Integer,String> cache= CacheBuilder.newBuilder().expireAfterWrite(2000,TimeUnit.MILLISECONDS).build(new CacheLoader<Integer, String>() {
//                @Override
//                public String load(Integer integer) throws Exception {
//                    String s=DaySoNguyenTo(integer);
//                    return s;
//                }
//            });
            String s=":n";
            return s;
        });
    }
    public static String DaySoNguyenTo(int a){
        String s="";
        for (int i = 2; i <= a; i++) {
            if(soNguyenTo(i)){
                s+=i+"\t";
            }
        }
        return s.trim();
    }
    public static boolean soNguyenTo(int i){
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i%j==0)
                return false;
        }
        return true;
    }
}
