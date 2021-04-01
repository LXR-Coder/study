package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class TestThreadLocal {

    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set("hello");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:"+threadLocal.get());
            }
        });

        thread.start();
        System.out.println("main:"+threadLocal.get());
    }
}
