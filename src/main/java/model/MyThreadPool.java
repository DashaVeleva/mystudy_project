package model;


import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.*;

public class MyThreadPool implements Executor {
    private final BlockingQueue<Runnable> queue;
    private volatile boolean isRunning = true;

    public MyThreadPool(int queueSize) {

        queue = new LinkedBlockingQueue<>(queueSize);

        for (int i = 0; i < queueSize; i++){
            new Thread(new Worker()).start();
        }

    }

    public void execute(Runnable task) {
      if (isRunning){
          queue.offer(task);
      }

    }

    synchronized public void shutdown() {
      isRunning = false;
    }


    class Worker implements Runnable {

        @Override
        public void run() {
            while (isRunning){
                Runnable task = queue.poll();
                if(task != null){
                    task.run();
                }
            }

        }
    }
}

