public class Main {
    public static void main(String[] args) {
//        int idx=1;
//        for (int i = 0; i < 2; i++) {
//            System.out.println("Main Thread running "+ idx++);
//            // ngủ 2000 mili giay
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//        HelloThread hlThread=new HelloThread();
//        hlThread.start();
//        for (int j = 0; j < 3; j++) {
//            System.out.println(" Main thread running: MMM"+j);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        for (int i = 0; i < 5; i++) {
            Thread thread1 = new Thread(new RunnabelDemon("Thang" + i));
            thread1.start();
            Thread thread2 = new Thread(new RunnabelDemon("Phan " + i));
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(""+i);
        }

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Thread Main");
    }
}
