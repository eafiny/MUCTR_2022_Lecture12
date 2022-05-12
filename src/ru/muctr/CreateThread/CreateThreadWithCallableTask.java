package ru.muctr.CreateThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Evgenia Skichko
 */
public class CreateThreadWithCallableTask {
    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> result = service.submit(new CallableTask());


        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println(System.currentTimeMillis() - time);
        System.out.println("Приложение заканчивает работу");
    }
}
