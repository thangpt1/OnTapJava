import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class GauvaTest {
//    public static void main1(String[] args) {
//        try {
//            Cache cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MILLISECONDS).
////            System.out.println("cache size 1 : " + cache.size());
//
//            cache.put(2,  "Phan Thang");
//            cache.put(3,"Phan Than1g");
////            System.out.println("size 3 : "+ cache.size());
//            if (cache.getUnchecked(2) != null)
//                System.out.println(cache.getUnchecked(2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

/*    public Student getStudentUsingGuava(int id) {
        LoadingCache<Integer, Student> cache = StudentGuavaCache.getLoadingCache();
        System.out.println("cache size :" + cache.size());
        Student student = null;
        try {
            student = cache.get(id);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return student;
    }*/
//    public static void main(String[] args) {
//
//
//        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
//            @Override
//            public String load(String s) throws Exception {
//                return slowMethod(s);
//            }
//        });
//        try {
//            System.out.println(loadingCache.get("key"));
//            System.out.println(loadingCache.get("key"));
//
//
//
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static String slowMethod(String s) {
//        return "aaaa";
//    }

    public static void main(String[] args) {
        try {
            CacheLoader<String, String> loader;
            loader = new CacheLoader<String, String>() {
                @Override
                public String load(String key) {
                    return key.toUpperCase();
                }
            };

            LoadingCache<String, String> cache;
            cache = CacheBuilder.newBuilder()
                    .expireAfterWrite(2,TimeUnit.MILLISECONDS)
                    .build(loader);

            cache.getUnchecked("hello");
            assertEquals(1, cache);
            Thread.sleep(300);
            cache.getUnchecked("test");
            assertEquals(1, cache);
            String s = (cache.getIfPresent("hello"));
            if(s == null){
                System.out.println("oke");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void assertEquals(int number, LoadingCache<String, String> cache){
        if (number == cache.size()){
            System.out.println("oke");
        }
    }
}
