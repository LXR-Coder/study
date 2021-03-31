package jim.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jim
 * @Date 2021/3/31
 **/
public class SleepTest2 {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("A is in sleep");

                    Thread.sleep(10000);

                    System.out.println("A is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("B is in sleep");

                    Thread.sleep(10000);

                    System.out.println("B is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
