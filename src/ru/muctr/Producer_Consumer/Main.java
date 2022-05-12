package ru.muctr.Producer_Consumer;

class Producer implements Runnable {      //класс, описывающий задачу
    private Store store;                  //потока - "поставщика"

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            store.put(); //добавить товар

        }
    }
}

class Consumer implements Runnable {     //класс, описывающий задачу
    private Store store;                 //потока - "покупателя"

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            store.get();   //купить товар
        }
    }
}

class Store {
    private int product;
    private final Object mon = new Object();   //монитор

    public void get() {
        synchronized (mon) {
            while (product <= 0) {
                try {
                    mon.wait();      //если продуктов нет, поток - "покупатель" ждет
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров осталось: " + product);
            mon.notify();     //уведомить второй поток об освобождении монитора
        }
    }

    public void put() {
        synchronized (mon) {
            while (product >= 5) {
                try {
                    mon.wait();    //если склад заполнен, поток - "поставщик" ждет
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product++;
            System.out.println("Изготовитель добавил 1 товар");
            System.out.println("Товаров осталось: " + product);
            mon.notify();   //уведомить второй поток об освобождении монитора
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
