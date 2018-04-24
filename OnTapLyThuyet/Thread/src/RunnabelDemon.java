import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RunnabelDemon implements RunnableFuture {
    // 1 class ke thua runnable chac chan co run
    String a;

    public RunnabelDemon(String a) {
        this.a = a;
    }

    @Override
    public void run() {
        string();
    }
    public String string(){
        int i=1;
        for (int j = 0; j < 5; j++) {
            System.out.println("Hello from Runabel: "+a);
        }

       return i+"";
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
