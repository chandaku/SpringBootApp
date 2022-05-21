package com.learn.core.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Thread t1 = new Thread(new ConsumerOdd(queue));
        Thread t3 = new Thread(new ConsumerEven(queue));
        Thread t2 = new Thread(new Producer(queue));
        t1.start();
        t2.start();
        t3.start();

    }
}
