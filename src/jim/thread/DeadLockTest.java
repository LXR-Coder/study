package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class DeadLockTest {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread()+"get A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread()+"wait B");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+"get B");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread()+"get B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread()+"wait A");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread()+"get A");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
