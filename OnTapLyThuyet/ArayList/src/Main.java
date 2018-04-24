import java.util.ArrayList;
import java.util.List;

public class Main  {
    public static void main(String[] args) {
        List<HocSinh> arrHocSinh=new ArrayList<>();
        arrHocSinh.add(new HocSinh("Thanh",22));
        arrHocSinh.add(new HocSinh("Nam",20));
        arrHocSinh.add(new HocSinh("Lan",15));
        arrHocSinh.add(new HocSinh("Nam",32));
        HocSinh hs=new HocSinh("Nam");
        System.out.println(arrHocSinh.indexOf(hs));
    }
}
