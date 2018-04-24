public class HelloThread  extends Thread{

    // doan code trong threa se chay khi goi HelloThread.start
    @Override
    public void run() {
        super.run();
        int index=1;
        for (int i = 0; i < 10; i++) {
            System.out.println("   -hello thread rungning: TTT"+index++);
            try {
                Thread.sleep(1030);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped");
    }
}
