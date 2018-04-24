import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> intSet1 = new LinkedHashSet<>();
        Set<Integer> intSet2 = new LinkedHashSet<>();
        Set<Integer> intSet3 = new LinkedHashSet<>();
        intSet1.add(1);
        intSet1.add(2);
        intSet1.add(3);
        intSet1.add(4);
        intSet1.add(5);

        intSet2.add(1);
        intSet2.add(2);
        intSet2.add(10);
        intSet2.add(8);
        intSet2.add(9);

        System.out.println(intSet1.toString());
        System.out.println(intSet2.toString());

        intSet1.retainAll(intSet2);
        System.out.println(intSet1.size());//toString());
        System.out.println(intSet1.toString());
    }
}
