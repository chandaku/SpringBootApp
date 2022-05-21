package com.learn.core.thread;

import java.util.Queue;

public class Producer implements Runnable {

    Queue<String> queue;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        int index = 0;
        while (true) {
            synchronized (queue) {
                try {
                    if (!queue.isEmpty()) {
                        System.out.println("Waiting to get Data Consumed by Consumer");
                        queue.wait();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getCause());
                }
                if(queue.isEmpty()) {
                    System.out.println("Going to insert data in queue");
                    queue.add("" + index++);
                    System.out.println("Inserted value");
                }
                synchronized (queue) {
                    queue.notifyAll();
                }

            }
        }
    }
}
