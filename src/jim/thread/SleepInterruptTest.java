package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/31
 **/
public class SleepInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("A is in sleep");

                    Thread.sleep(10000);

                    System.out.println("A is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        Thread.sleep(-1);

        thread.interrupt();
    }

}
