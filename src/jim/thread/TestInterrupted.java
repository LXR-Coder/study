package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().interrupted()){

                }

                System.out.println("threadOne isInterrupted:"+Thread.currentThread().isInterrupted());
            }
        });

        threadOne.start();

        threadOne.interrupt();


        threadOne.join();


        System.out.println("over");
    }
}
