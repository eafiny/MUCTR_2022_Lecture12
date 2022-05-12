package ru.muctr.Synchronization;

/**
 * @author Evgenia Skichko
 */
public class Counter {
    private int i;

    public Counter() {
        i = 0;
    }

    public int getI(){
        return i;
    }

    public void increment(){
        i = i + 1;
    }

    public void decrement(){
        i = i - 1;
    }
}
