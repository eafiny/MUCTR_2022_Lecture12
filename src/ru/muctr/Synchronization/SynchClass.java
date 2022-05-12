package ru.muctr.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Evgenia Skichko
 */
public class SynchClass {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Object monitor = new Object();

        Lock myLock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 1_000_000; i++){
//               synchronized (monitor) {
               myLock.lock();
                   counter.increment();
                   myLock.unlock();
//               }
           }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++){
//                synchronized (monitor) {
                    counter.decrement();
//                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getI());
    }
}
