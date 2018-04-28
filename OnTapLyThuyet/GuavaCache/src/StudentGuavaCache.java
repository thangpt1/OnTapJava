//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;
//
//import java.util.concurrent.TimeUnit;
//
//public class StudentGuavaCache {
//    private static LoadingCache<Integer,Student> cache;
//    static {
//        cache= CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES).build(new CacheLoader<Integer, Student>() {
//            @Override
//            public Student load(Integer id) throws Exception {
//                return getEmployeeById(id);
//            }
//        });
//    }
//    public static LoadingCache<Integer,Student> getLoadingCache(){
//        return cache;
//    }
//    public static Student getEmployeeById(int id){
//        System.out.println("--Executing getStudent--");
//        Student student=new Student(id,"Thang Phan"+id);
//        return student;
//    }
//}
//
//class Student {
//    private int id;
//    private String name;
//
//    public Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
