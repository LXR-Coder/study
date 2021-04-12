package jim.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author jim
 * @Date 2021/4/12
 **/
public class RandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
