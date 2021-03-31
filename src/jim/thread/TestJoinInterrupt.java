package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/31
 **/
public class TestJoinInterrupt {
    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" one begin");
                for(;;){

                }
            }
        });

        final Thread mainThread = Thread.currentThread();

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread "+e);
        }
    }
}
