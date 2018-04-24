import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12/04/2018.
 */
public class Main {
    public static void main(String[] args) {
        XeTai xeTai1 = new XeTai();
        XeTai xeTai2 = new XeTai();
        XeTai xeTai3 = new XeTai();

        Oto oto1 = new Oto();
        Oto oto2 = new Oto();
        Oto oto3 = new Oto();

        VanTai xeDap1 = new XeDap();
        VanTai xeDap2 = new XeDap();
        VanTai xeDap3 = new XeDap();

        List<VanTai> vanTais = new ArrayList<>();

        vanTais.add(xeDap1);
        vanTais.add(xeDap2);
        vanTais.add(xeDap3);

        vanTais.add(xeTai1);
        vanTais.add(xeTai2);
        vanTais.add(xeTai3);

        vanTais.add(oto1);
        vanTais.add(oto2);
        vanTais.add(oto3);

        for (VanTai vt:vanTais
             ){
//            if(vt instanceof Oto){
//                System.out.print("Oto: ");vt.diChuyen();
//            }
            vt.diChuyen();

        }
    }
}
