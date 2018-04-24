import java.util.concurrent.*;

public class MainThreadPools {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        CompletionService<String> pool = new ExecutorCompletionService<String>(threadPool);
        for (int i = 0; i < 10; i++) {
            pool.submit(new StringTask("a","b"));
        }
        for (int i = 0; i < 10; i++) {
            try {
                String result = pool.take().get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }

    private static class  StringTask implements java.util.concurrent.Callable<String> {
        String a,b;
        public StringTask(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public String call() {
            //Long operations
            return "Run"+a+b;
        }
    }
}
