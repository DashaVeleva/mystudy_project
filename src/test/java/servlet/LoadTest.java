package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadTest {
    public static void main(String[] args) throws IOException {
        int threadCount = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try {
                    URLConnection connection = new URL("http://localhost:8080").openConnection();
                    System.out.println("successful " + Thread.currentThread().getName());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            });
        }

    }
}

