package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class TestIsInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"hello");
                }
            }
        });

        thread.setName("jim");
        thread.start();

        Thread.sleep(1000);

        System.out.println("interrupt child thread");
        thread.interrupt();



        System.out.println("over");
    }
}
