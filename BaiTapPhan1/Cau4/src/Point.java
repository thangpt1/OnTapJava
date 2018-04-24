import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            if (point.getX() == this.x) {
                return true;
            }
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}' + "\n";
    }

    @Override
    public int hashCode() {
        int hash=17;
        hash=hash*31+x;
        hash=hash*31+y;
        return hash;
//        return x;
    }

//    public static void main(String[] args) {
//        Point point1 = new Point(1, 2);
//        Point point2 = new Point(1, 2);
//        Set<Point> pointSet = new LinkedHashSet<>();
//        pointSet.add(point1);
//        System.out.println(pointSet.contains(point2));
//    }

}