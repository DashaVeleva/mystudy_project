package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LoadTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        int threadCount = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try {

                    HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080").openConnection();
                    connection.connect();

                    System.out.println("successful " + Thread.currentThread().getName());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            });
        }

        Thread.sleep(5000);
        executorService.shutdown();

    }
}

