import java.util.*;

/**
 * Created by Administrator on 12/04/2018.
 */
public class URL {
    private Map<String, String> mapQuery = new LinkedHashMap<>();
    private String url = "https://www.google.com.vn/search?" +
            "q=string+java+practice&" +
            "rlz=1C1CHZL_viVN741VN741&" +
            "oq=string&" +
            "aqs=chrome.2.69i57j69i60j69i59j69i60.232j0j1&" +
            "sourceid=chrome&" +
            "ie=UTF-8";
    private String url1 = "https://www.google.com.vn/search?ei=mMzOWoDvDornvATpppvwBQ&q=strung+trong" +
            "+java&oq=strung+trong+java&gs_l=psy-ab.3..0i13k1l3j0i13i5i30k1l7.1688906.1689511" +
            ".0.1689688.6.5.0.0.0.0.145.385.0j3.3.0....0...1c.1.64.psy-ab..3.3.383...0i7i30k1.0.zdNMkcHleMc";
    private String domainName;

    public URL() {
        getDomainName();
        getQueryParam();
        newURl();
    }

    public void getDomainName() {
        domainName = url1.split("/")[2];
        System.out.println("DomainName: " + domainName + "\n");
    }

    public void getQueryParam() {
        System.out.print("Các query param có trong url:");
        String s = url.split("/")[3];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 38 || a == 63)
                s = s.replace(a + "", " ");
        }
        for (String d : s.trim().split(" ")
                ) {
            for (int i = 0; i < d.length(); i++) {
                char a = d.charAt(i);
                if (a == 61) {
//                    System.out.print(d.split("=")[0]+"="+ d.split("=")[1]+"  ");
                    mapQuery.put(d.split("=")[0], d.split("=")[1]);
                }
            }

        }
        System.out.println( mapQuery + "\n");
    }

    public void newURl() {
        String queryParam = "";
        for (Map.Entry<String, String> entry : mapQuery.entrySet()) {
            queryParam += entry.getKey() + "=";
            String s = "";
            for (int i = 0; i < entry.getValue().length(); i++) {
                char a = entry.getValue().charAt(i);
                switch (a) {
                    case 43:
                        s += "+";
                        break;
                    case 95:
                        s += "_";
                        break;
                    case 46:
                        s += ".";
                        break;
                    case 45:
                        s += "-";
                        break;
                    default:
                        int r = getRandom(1, 4);
                        switch (r) {
                            case 1:
                                s += (char) getRandom(48, 58);
                                break;
                            case 2:
                                s += (char) getRandom(65, 91);
                                break;
                            case 3:
                                s += (char) getRandom(97, 123);
                                break;
                        }
                        break;
                }

            }
            queryParam += s + "&";
        }

        queryParam = queryParam.substring(0, queryParam.length() - 1);
        System.out.println("Old URL:"+url);
        System.out.println("New URL:https://" + domainName + "/search?" + queryParam);

    }


    public int getRandom(int min, int max) {
        Random r = new Random();
        return min + r.nextInt(max - min);
    }
}
