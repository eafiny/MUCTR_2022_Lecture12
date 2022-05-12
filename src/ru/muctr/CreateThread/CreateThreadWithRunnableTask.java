package ru.muctr.CreateThread;

/**
 * @author Evgenia Skichko
 */
public class CreateThreadWithRunnableTask {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        dividebyZero();

        Thread thread1 = new Thread(() -> {
            System.out.println("Поток " + Thread.currentThread().getName());
        });
        thread1.start();
        try {
            thread1.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("В потоке main");
    }

    private static void dividebyZero() {
        System.out.println(5/0);
    }
}
