package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/31
 **/
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("one over");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("two over");
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait child");

        threadOne.join();
        threadTwo.join();

        System.out.println("over");
    }

}
