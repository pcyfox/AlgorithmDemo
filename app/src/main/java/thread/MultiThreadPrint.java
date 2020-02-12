package thread;


import java.util.concurrent.atomic.AtomicInteger;
//两个线程交替输出奇偶数
public class MultiThreadPrint {
    private static AtomicInteger i = new AtomicInteger(0);
    private static volatile int index = 2;
    private static Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            while (i.get() < 100) {
                if (i.get() % 2 == 0 && index == 2) {
                    System.out.println("runnable2 i=" + i.get());
                    i.addAndGet(1);
                    index = 1;
                    sleep();
                }
            }

        }
    };

    private static Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            while (i.get() < 100) {
                if (i.get() % 2 != 0 && index == 1) {
                    System.out.println("runnable1 i=" + i.get());
                    i.addAndGet(1);
                    index = 2;
                    sleep();
                }
            }
        }
    };


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread2.start();
       thread1.start();



    }


}
