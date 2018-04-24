import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Set<Point> setPoint1 = new HashSet<>();
        Set<Point> setPoint2 = new HashSet<>();
        Set<Point> setPoint3 = new HashSet<>();
        initSetPoint(800, 800, 400, 8000, setPoint1);
        initSetPoint(4000, 8000, 500, 10000, setPoint2);
        initSetPoint(2400, 2400, 600, 12000, setPoint3);
//        System.out.println("aaaa");

        setPoint1.addAll(setPoint2);
        setPoint1.addAll(setPoint3);

        setPoint2.clear();
        setPoint3.clear();

        try {
            FileWriter fw = new FileWriter("putput4.txt");
            fw.write(setPoint1.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(setPoint1.toString() + "size: " + setPoint1.size());

        Scanner s = new Scanner(System.in);

        System.out.print("x=");
        int x = s.nextInt();

        System.out.print("y=");
        int y = s.nextInt();

        Point point = new Point(x, y);

        System.out.println(setPoint1.contains(point));
    }

    private static void initSetPoint(int a, int b, int distance, int size, Set<Point> setPoint) {
        Random r = new Random();
        int x, y;
        float e;
        while (setPoint.size() < size) {
            x = r.nextInt(10000);
            y = r.nextInt(10000);
            e = (float) Math.sqrt((Math.pow(a - x, 2)) + (Math.pow(b - y, 2)));
            if (e <= distance)
                setPoint.add(new Point(x, y));
        }
    }
}
