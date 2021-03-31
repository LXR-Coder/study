package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/31
 **/
public class TestWait {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA){
                        System.out.println("A get A lock");

                        synchronized (resourceB){
                            System.out.println("A get B lock");

                            System.out.println("A release A lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    synchronized (resourceA){
                        System.out.println("B get A lock");

                        System.out.println("B try get B lock");

                        synchronized (resourceB){
                            System.out.println("B get B lock");

                            System.out.println("B release A lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadA.join();

        System.out.println("main over");
    }
}
