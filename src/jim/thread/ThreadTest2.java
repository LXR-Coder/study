package jim.thread;

/**
 * @Author jim
 * @Date 2021/3/30
 **/
public class ThreadTest2 {

    public static class RunableTask implements Runnable{
        private Integer num = 1;
        @Override
        public void run() {
            System.out.println(num++);
            System.out.println("child thread");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
