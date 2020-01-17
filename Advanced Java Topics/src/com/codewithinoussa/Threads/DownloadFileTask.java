package com.codewithinoussa.Threads;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        /*try {
            Thread.sleep(5000); //pausing a thread for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        for (var i=0; i<Integer.MAX_VALUE; i++){
            if(Thread.currentThread().isInterrupted()) return; // or break;
            System.out.println("Downloading byte :" +i);
        }

        System.out.println("Downloading completed" + Thread.currentThread().getName());
    }
}
