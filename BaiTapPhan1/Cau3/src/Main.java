import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File dir=new File("F:\\VCCrop\\ThucTap\\BaiTap\\input3");
        File[] listFiles =dir.listFiles(new txtFileTer());


        ExecutorService threadPool = Executors.newFixedThreadPool(6);
        CompletionService<Map<String, Integer>> pool = new ExecutorCompletionService<Map<String, Integer>>(threadPool);

        for (int i = 0; i < listFiles.length; i++) {
            pool.submit(new DocFile(listFiles[i].toString())).toString();
        }
        Map<String, Integer> map1 = null;
        try {
            map1 = pool.take().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Map<String ,Integer> map2=new LinkedHashMap<>();
        for (int i = 0; i < listFiles.length - 1; i++) {
            try {
                for (Map.Entry<String, Integer> mapTuMoi : pool.take().get().entrySet()
                        )
                    for (Map.Entry<String, Integer> mapTop : map1.entrySet()
                            ) {
                        if (mapTuMoi.getKey().equals(mapTop.getKey())) {
                            map2.put(mapTop.getKey(),mapTuMoi.getValue()+mapTop.getValue());
                        }else {
                            map2.put(mapTuMoi.getKey(),mapTuMoi.getValue());
                        }
                    }
                map1.putAll(map2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        map2.clear();Map<String, Integer> result;
        result = map1.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Integer> m : result.entrySet()) {
            map2.put(m.getKey(), m.getValue());
            if (map2.size() >=10)
            {
                break;
            }
        }

        result = map1.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Integer> m : result.entrySet()) {
            map2.put(m.getKey(), m.getValue());
            if (map2.size() >=20)
            {
                break;
            }
        }
        System.out.println( map2.toString());
        threadPool.shutdown();
    }
}
