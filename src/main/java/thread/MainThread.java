package main.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread started.");

        System.out.println("Thread finished.");
    }
}


public class MainThread {
    public static void main(String[] args) {
        // Thread
        Thread myThread = new Thread(new MyThread());
        myThread.setPriority(1);
        myThread.start();

        // Lock
        Lock myLock = new ReentrantLock();
        try {
            myLock.lock();
        } finally {
            myLock.unlock();
        }

        // ReadWriteLock

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        try {
            readWriteLock.readLock();
        } finally {
            readWriteLock.writeLock();
        }
    }
}