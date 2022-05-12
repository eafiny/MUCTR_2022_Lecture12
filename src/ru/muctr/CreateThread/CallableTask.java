package ru.muctr.CreateThread;

import java.util.concurrent.Callable;

/**
 * @author Evgenia Skichko
 */
public class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
