package jim.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author jim
 * @Date 2021/4/13
 **/
public class ParkTest {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            System.out.println("child begin");

            while (!Thread.currentThread().isInterrupted()){
                LockSupport.park();
            }

            System.out.println("child end");
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpack");

        thread.interrupt();
    }
}
