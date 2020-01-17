package com.codewithinoussa.ThreadsConcurrency;

import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;

public class DownloadStatus {
    private volatile boolean isDone;
    public int totalBytes;
    //private AtomicInteger totalBytes = new AtomicInteger(); // for Atomic Object approach
    //private LongAdder totalBytes = new LongAdder(); // for Atomic Object approach
    private int totalFiles;

    // private Lock lock = new ReentrantLock(); // used for synchronization
    private Object totalBytesLock = new Object(); // monitoring object ofr totalBytes
    private Object totalFilesLock = new Object(); //monitoring object for totalFiles

    public DownloadStatus() {
    }


    // method to increment the totalByte
   /* public void increment(){
        lock.lock(); // lock for other threads to wait for the current thread to complete before executing increm operation
       //always use try --catch for complex lock to ensure the operation is unlock after
        try {
            totalBytes++;
        }
        finally {
            lock.unlock();
        }
    }*/
   // ww to make sure that only o1 thread at a time can execute this piece of code
    // we do it by wrapping the code inside the synchronized keyword as every obj in java has a built-in lock

    public void incrementTotalBytes(){
       // now we synchronize w/t totalBytesLock obj instead of using "this"
       synchronized (totalBytesLock){
           totalBytes++;
       }
   }

   //Atomic Object Approach - faster and easier to use
   /*public void incrementTotalBytes(){
   //now multiples threads can modify this field concurrently without waiting for each other
      totalBytes.incrementAndGet(); //or getAndIncrement()
   }*/

    public void incrementTotalFiles(){
           synchronized (totalFilesLock){
               totalFiles++;
           }
   }
    /*public synchronized void incrementTotalFiles(){
         totalFiles++;
    }*/
    public int getTotalFiles() {
        return totalFiles;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }

    //we don't want to create a setter to avoid resetting the totalByte accidentally in a thread.
    public int getTotalBytes() {
        return totalBytes;
    }

    // for Adder approach
    /*public int getTotalBytes() {
        return totalBytes.intValue();
    }*/
}
