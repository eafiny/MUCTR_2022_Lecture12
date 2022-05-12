package ru.muctr.CreateThread;

/**
 * @author Evgenia Skichko
 */
public class RunnableTask implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
