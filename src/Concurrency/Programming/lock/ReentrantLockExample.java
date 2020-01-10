package Concurrency.Programming.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        // 获取锁
        lock.lock();
        try {
            a++;
        } finally {
            // 释放锁
            lock.unlock();
        }
    }


    public void reader() {
        // 获取锁
        lock.lock();
        try {
            int i = a;
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        Thread threadWriter = new Thread(new Runnable() {//线程A
            @Override
            public void run() {
                example.writer();
            }
        });

        Thread threadRead = new Thread(new Runnable() {//线程B
            @Override
            public void run() {
                example.reader();
            }
        });

        threadWriter.start();
        threadRead.start();
    }
}
