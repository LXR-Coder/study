package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class TestInterrupt2 {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin sleep for 20s");
                try {
                    Thread.sleep(20000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                }
            }
        });

        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("over");
    }
}
