package jim.thread;

/**
 * @Author jim
 * @Date 2021/4/1
 **/
public class ThreadLocalTest {
    static void print(String str){
        System.out.println(str+":"+localVariable.get());
        localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("one");
                print("threadOne");

                System.out.println("threadOne remove after"+localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("Two");
                print("threadTwo");

                System.out.println("threadTwo remove after"+localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();


    }
}
