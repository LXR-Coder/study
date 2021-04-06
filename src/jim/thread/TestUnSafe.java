package jim.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author jim
 * @Date 2021/4/6
 **/
public class TestUnSafe {
    static final Unsafe unsafe ;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            field.setAccessible(true);

            unsafe = (Unsafe) field.get(null);


            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        Boolean sucess = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(sucess);
    }
}
