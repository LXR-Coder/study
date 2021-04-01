package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class UserThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("main over");
    }
}
