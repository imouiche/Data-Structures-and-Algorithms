package com.codewithinoussa.Threads;

public class ThreadDemo {
    public static void show(){

        System.out.println(Thread.currentThread().getName());
    // start a new thread
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();
        // 1- Join a thread
     // scanning each downloaded file on another thread
        /*try {
            thread.join(); // with join() we tell to current thread to wait for the completion of another thread
            // the drawback is that while waiting it cannot do other things even respond to events
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned.");
        */

        // 2- Interrupting a thread
        try {
            thread.sleep(1000); // we want to interrupt teh thread after 1s
        } catch (InterruptedException e) {
            // if the thread is sleeping and send an interrupt request to it, it throws an exception,
            // and that's why we have to handle the exception here
            e.printStackTrace();
        }
        //interrupting the current thread by sending the interrupt request
        // However, in the running method we have to capture this interrupt request and take specific action to break the method
        thread.interrupt();
        System.out.println("File is ready to be scanned.");

    }
}
