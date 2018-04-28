import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 12/04/2018.
 */
public class main {


    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
        for (long i=0; i<100000000; i++);    //vòng lặp không thực hiện thêm lệnh nào

        Set<Integer> intSet1 = new LinkedHashSet<>();
        Set<Integer> intSet2 = new LinkedHashSet<>();
        Set<Integer> intSet3 = new LinkedHashSet<>();
        Set<Integer> intSet4 = new LinkedHashSet<>();
        Set<Integer> intSet5 = new LinkedHashSet<>();
        Set<Integer> intSet6 = new LinkedHashSet<>();
        try {
            Random r = new Random();
            while (intSet1.size() < 400000 || intSet2.size() < 400000 || intSet3.size() < 400000 || intSet4.size() < 400000 || intSet5.size() < 400000) {
                intSet1.add(r.nextInt(400000));
                intSet2.add(400001 + r.nextInt(800001 - 400001));
                intSet3.add(800001 + r.nextInt(1200001 - 800001));
                intSet4.add(1200001 + r.nextInt(1600001 - 1200001));
                intSet5.add(1600001 + r.nextInt(2000001 - 1600001));
            }

            intSet1.addAll(intSet2);
            intSet1.addAll(intSet4);
            intSet1.addAll(intSet3);
            intSet1.addAll(intSet5);
            intSet3.clear();
            intSet4.clear();
            intSet5.clear();

            FileWriter fw1 = new FileWriter("D:\\Moon\\java\\OnTapJava\\BaiTapPhan1\\intSet1.txt");
            fw1.write(String.valueOf(intSet1));
            fw1.close();
            while (intSet3.size() < 400000 || intSet4.size() < 400000 || intSet5.size() < 400000 || intSet6.size() < 400000) {
                intSet3.add(1600001 + r.nextInt(2000001 - 1600001));
                intSet4.add(2000001 + r.nextInt(2400001 - 2000001));
                intSet5.add(2400001 + r.nextInt(2800001 - 2400001));
                intSet6.add(3200001 + r.nextInt(3600001 - 3200001));
            }

            intSet2.addAll(intSet6);
            intSet2.addAll(intSet4);
            intSet2.addAll(intSet3);
            intSet2.addAll(intSet5);

            intSet3.clear();
            intSet4.clear();
            intSet5.clear();
            intSet6.clear();

            FileWriter fw2 = new FileWriter("D:\\Moon\\java\\OnTapJava\\BaiTapPhan1\\intSet2.txt");
            fw2.write(String.valueOf(intSet2));
            fw2.close();

            hopCua2TapHop(intSet1, intSet2, intSet3);
            giaoCua2TapHop(intSet1, intSet2, intSet4);

            end = System.currentTimeMillis();   // start lấy thời gian theo millisecond
            System.out.println("thời gian thực hiện: " + (end - start)/1000+"s");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void hopCua2TapHop(Set<Integer> intSet1, Set<Integer> intSet2, Set<Integer> intSet3) {

        try {
            intSet3.addAll(intSet1);
            intSet3.addAll(intSet2);
            FileWriter fw3 = new FileWriter("BaiTap\\intSet3.txt");
            fw3.write(String.valueOf(intSet3));
            fw3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void giaoCua2TapHop(Set<Integer> intSet1, Set<Integer> intSet2, Set<Integer> intSet4) {
        try {
            intSet4.addAll(intSet1);
            intSet4.retainAll(intSet2);
            FileWriter fw4 = new FileWriter("BaiTap\\intSet4.txt");
            fw4.write(String.valueOf(intSet4));
            fw4.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
