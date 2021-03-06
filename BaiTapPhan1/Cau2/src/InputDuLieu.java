import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputDuLieu {
    private String URL;
    private Map<String, Integer> mapTu = new HashMap<>();

    public InputDuLieu(String URL) {
        this.URL = URL;
    }

    // doc tung dong du lieu tong file
    public void docGhiDL() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(URL));
            String s;
            while ((s = br.readLine()) != null) {
                docTungTu(s.trim());

            }
            FileWriter fw = new FileWriter("OutPut2.txt");
            fw.write(mapTu.toString());
            System.out.println("ok");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docTungTu(String s1) {
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            if ((32 <= a && a <= 47) || (58 <= a && a <= 64) || (91 <= a && a <= 96) || (123 <= a && a <= 126 || a == '\uFEFF' || a == '—')) {
                s1 = s1.replace(a + "", " ");
            }
        }
        s1 = s1.toLowerCase();
        while (s1.contains("  "))
            s1 = s1.replace("  ", " ");

        for (String s : s1.trim().split(" ")
                ) {
            if (mapTu.containsKey(s))
                mapTu.put(s, mapTu.get(s) + 1);
            else
                mapTu.put(s, 1);
        }
    }
}
