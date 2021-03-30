package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/30
 **/
public class ThreadTest {
    public static class MyThread extends Thread{
        private String name = " ";

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(name);
            System.out.println("child thread");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread("jim");
        thread.start();

        MyThread thread2 = new MyThread("tom");
        thread2.start();
    }
}
