package Concurrency.Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    AtomicInteger test = new AtomicInteger(0);
    private volatile int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> list = new ArrayList<Thread>(600);
        // long start = System.currentTimeMillis();
        for (int i = 0; i < 99; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            list.add(t);
        }

        for(Thread t : list) {
            t.start();
        }

        Thread ThreadTest = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10000; i++) {
                    cas.test();
                }
            }
        });
        ThreadTest.start();


        // 等待所有线程执行完
        for(Thread t : list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        // System.out.println(cas.test.get());
    }


    private void safeCount() {
        // 如果i的值变动，循环
        while (true) {
            int i = atomicInteger.get();
            // CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
            // 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if(suc) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }

    private void test() {
        while (true) {
            int i = test.get();
            boolean suc = test.compareAndSet(i, ++i);
            if(suc) {
                break;
            }
        }
    }
}
