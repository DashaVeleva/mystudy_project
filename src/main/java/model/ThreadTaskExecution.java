package model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTaskExecution {
    public static void main(String[] args) {


        MyThreadPool myThreadPool = new MyThreadPool(3);

        for (int i = 0; i < 4; i++) {
            myThreadPool.execute(new ThreadTask());
        }

        myThreadPool.shutdown();

    }
}
