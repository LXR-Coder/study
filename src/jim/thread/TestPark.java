package jim.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author jim
 * @Date 2021/4/13
 **/
public class TestPark {

    public void testPark(){
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.testPark();
    }
}
