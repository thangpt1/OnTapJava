import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        long start, end;

//        start = System.nanoTime();  // start lấy thời gian theo nanosecond
//        for (int i=0; i<100; i++);
//        end = System.nanoTime();    // start lấy thời gian theo nanosecond
//        System.out.println("Time Nano: " + (end - start));

        start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
        System.out.println(start + "");

        Set<Integer> intSet1 = new LinkedHashSet<>();
        Random r = new Random();
        while (intSet1.size() < 2000000) {
            intSet1.add(r.nextInt(3000000));

        }
        System.out.println(intSet1.size());
        end = System.currentTimeMillis();   // start lấy thời gian theo millisecond
        System.out.println(end + "");

        System.out.println("Time Millis: " + (end - start) / 1000);

//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // tạo 1 đối tượng có định dạng thời gian yyyy-MM-dd HH:mm:ss
//        Date date = new Date(); // lấy thời gian hệ thống
//        String stringDate = dateFormat.format(date);//Định dạng thời gian theo trên
//        System.out.println("Date: " + stringDate);
    }
}
