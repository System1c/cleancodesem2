package com.apiit.assignment.server;

import java.time.Instant;

public class AlgorithmServer {

    public long wordCount(StringBuilder text){
        Instant start = Instant.now();
        long wordCount = 0;
        String[] words = text.toString().split(" ");
        for (String word : words){
            if (word.trim().length()>0)
            {
                wordCount++;
            }
        }
        Instant end = Instant.now();
        return wordCount;
    }

    public long nthPrime(int n) {
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
