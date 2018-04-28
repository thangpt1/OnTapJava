import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        port(1233);
        get("/hello/:n", (request, response) -> {
            LoadingCache<String,String> cache= CacheBuilder.newBuilder().expireAfterWrite(20000,TimeUnit.MILLISECONDS).build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return DaySoNguyenTo(s);
                }
            });
            String s=":n";
            return cache.getUnchecked(request.params(":n"));
        });
    }
    public static String DaySoNguyenTo(String s){
        int a=Integer.parseInt(s);
        String s1="";
        for (int i = 2; i <a ; i++) {
            if(isPrime(i)){
                s1 += i + "\t";
            }

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s1.trim();
    }

    public static boolean isPrime(int a){
        for (int j = 2; j <=Math.sqrt(a); j++) {
            if(a%j == 0){
             return false;
            }
        }
        return true;
    }
}