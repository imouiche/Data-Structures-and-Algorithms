package com.codewithinoussa.ThreadsConcurrency;

public class VolatileDemo {
    public static void show(){
     // ww to create 2 threads: 1 simulating the download of files and another checks to see if the download is finished
    var status = new DownloadStatus();

    var thread1 = new Thread(new DownloadFileTask(status));
    var thread2 = new Thread(() -> {
        //check if the download status is done
        while (!status.isDone()){
            synchronized (status) {
                try {
                    status.wait(); // goes into sleep mode if the isDone field is not true in the first iteration
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } // wait till the isDone field become true
        System.out.println(status.getTotalBytes());
    }); //()->{} is a Runnable interface to create a thread
     // lets start both threads
     thread1.start();
     thread2.start();
    }
}
