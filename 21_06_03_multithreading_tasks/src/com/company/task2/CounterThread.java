package com.company.task2;

public class CounterThread extends Thread {

    private Counter counterClass;
    private String threadName;

    public CounterThread(Counter counterClass, String threadName) {
        this.counterClass = counterClass;
        this.threadName = threadName;
    }

//    public CounterThread(String name, Counter counterClass) {
//        super(name);
//        this.counterClass = counterClass;
//    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);

        synchronized (Counter.class) {
            for (int i = 0; i < 4; i++) {
                counterClass.setCounter(counterClass.getCounter() + 1);
                System.out.println("Th name: " + Thread.currentThread().getName() + " ,counter: " + counterClass.getCounter());
            }
        }

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
