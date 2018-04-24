import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class DocFile implements Callable<Map<String,Integer>> {
    private Map<String, Integer> mapTu = new HashMap<>();
    private String URL;


    public DocFile(String URL) {
        this.URL = URL;
        docDL(URL);
    }

    // doc tung dong du lieu tong file
    public void docDL(String URL) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(URL));
            String s;
            while ((s = br.readLine()) != null) {
                demTu(s);
            }
//            Map<String, Integer> result = mapTu.entrySet().stream().
//                    sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
//                    collect(Collectors.toMap(Map.Entry::getKey,
//                            Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> top10(Map<String, Integer> mapTu) {
        Map<String, Integer> mapTop = new LinkedHashMap<>();
        Map<String, Integer> result;
        result = mapTu.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            mapTop.put(m.getKey(), m.getValue());
            if (mapTop.size() >=10)
            {
                break;
            }
        }
        result = mapTu.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            mapTop.put(m.getKey(), m.getValue());
            if (mapTop.size() >=20)
            {
                break;
            }
        }
        return mapTop;
    }

    public void demTu(String s1) {
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            if ((32 <= a && a <= 47) || (58 <= a && a <= 64) || (91 <= a && a <= 96) || (123 <= a && a <= 126 || a == '\uFEFF' || a == '—')) {
                s1 = s1.replace(a + "", " ");
            }
        }
        s1 = s1.toLowerCase();
        while (s1.contains("  "))
            s1 = s1.replace("  ", " ");
        for (String s : s1.trim().split(" ")) {
            if (mapTu.containsKey(s))
                mapTu.put(s, mapTu.get(s) + 1);
            else
                mapTu.put(s, 1);
        }
    }


    @Override
    public Map<String, Integer> call() throws Exception {
        return top10(mapTu.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
    }
}
