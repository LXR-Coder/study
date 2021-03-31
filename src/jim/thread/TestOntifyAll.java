package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/31
 **/
public class TestOntifyAll {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("A get A lock");

                    try {
                        System.out.println("A begin wait");
                        resourceA.wait();
                        System.out.println("A end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("B get A lock");

                    try {
                        System.out.println("B begin wait");
                        resourceA.wait();
                        System.out.println("B end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("C begin notify");
                    resourceA.notify();

                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
