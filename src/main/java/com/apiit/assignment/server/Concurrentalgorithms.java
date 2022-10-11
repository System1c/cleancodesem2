package com.apiit.assignment.server;

import java.util.concurrent.*;

public class Concurrentalgorithms {

    long result;
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public long cwordCount(StringBuilder text){
        Future<Long> future = (Future<Long>) executorService.submit(() ->{
            long wordCount = 0;
            String[] words = text.toString().split(" ");
            for (String word : words){
                if (word.trim().length()>0)
                {
                    wordCount++;
                }
            }
            return wordCount;
        });
        try {
            result = future.get(3000, TimeUnit.MILLISECONDS);
            executorService.shutdown();
            return result;
        } catch (InterruptedException | ExecutionException | TimeoutException e){
            future.cancel(true);
            future.isDone();
            future.isCancelled();
        }
        return result;
    }

    public long cnthPrime(int n) {
        Future<Long> future = (Future<Long>) executorService.submit(() ->{
            long num = 1;
            for (int i = 1; i<=n; i++) {
                while (!isPrime(num)) {
                    num++;
                }
                if (i == n) {
                    return num;
                }else{
                    num++;
                }
            }
            return num;
        });
        try {
            result = future.get(3000, TimeUnit.MILLISECONDS);
            executorService.shutdown();
            return result;
        } catch (InterruptedException | ExecutionException | TimeoutException e){
            future.cancel(true);
            future.isDone();
            future.isCancelled();
        }
        return result;
    }

    private boolean isPrime(long num) {
        if (num == 1) return true;
        for(long i=num-1; i>1; i--) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
