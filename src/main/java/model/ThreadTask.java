package model;

public class ThreadTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i<=4; i++){
            System.out.println(i + "///" + Thread.currentThread().getName());

        }
    }
}
