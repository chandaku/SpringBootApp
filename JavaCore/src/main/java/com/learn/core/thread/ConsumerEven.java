package com.learn.core.thread;

import java.util.Queue;

public class ConsumerEven implements Runnable {

    private final Queue<String> queue;

    public ConsumerEven(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {
                try {
                    if (queue.isEmpty()) {
                        System.out.println("EVEN::: Consumer is Empty now so waiting to get data produced");
                        queue.wait();
                    }
                    int value = Integer.valueOf(queue.poll());
                    if (value % 2 == 0) {
                        System.out.println("Consuming Even only    **" + value);
                    } else {
                        queue.add("" + value);
                    }

                } catch (InterruptedException e) {
                    System.out.println(e.getCause());
                }
                synchronized (queue) {
                    queue.notifyAll();
                }

            }
        }

    }
}
