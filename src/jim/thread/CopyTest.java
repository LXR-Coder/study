package jim.thread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyTest {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(()->{
            arrayList.set(1,"baba");
            arrayList.remove(2);
            arrayList.remove(3);
        });

        Iterator<String> itr = arrayList.iterator();

        threadOne.start();

        threadOne.join();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
