package model;


import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

public class MyThreadPool implements Executor {
    BlockingQueue<Runnable> queue;
    int queueSize;

    public MyThreadPool(int queueSize) {
        this.queueSize = queueSize;
        this.createQueue();

    }

    synchronized public void createQueue(){
        queue = new ArrayBlockingQueue<>(queueSize);
        for (int i = 1; i <= queueSize; i++) {
            Thread thread = new Thread();
            thread.setName("thread-" + i);
            try {
                queue.put(thread);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    synchronized public void execute(Runnable r) {
        if (queue.size() == 0) {
            this.createQueue();
        }
        Thread thread = (Thread) queue.poll();
        String name = thread.getName();
        thread = new Thread(r);
        thread.setName(name);
        thread.start();

    }

    synchronized public void shutdown() {
        for (int i = 0; i < queue.size(); i++) {
            Thread thread = (Thread) queue.poll();
            thread.interrupt();
        }
    }

}
