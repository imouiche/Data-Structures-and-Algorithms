package com.codewithinoussa.ThreadsConcurrency;

public class DownloadFileTask implements Runnable {
    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }
    public DownloadFileTask() {
        this.status = new DownloadStatus();
    }
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (var i=0; i<1_000_000; i++){
           // if(Thread.currentThread().isInterrupted()) return; // or break;
            //System.out.println("Downloading byte :" +i);
            status.incrementTotalBytes();
        }
        status.done(); // sending the done status
        synchronized (status) {
            //notifying the second thread to wake up as the status field has changed
            status.notifyAll(); //Need to wrap it with synchronized to avoid runtime exception by JVM
        }
        System.out.println("Downloading completed " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
