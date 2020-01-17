package com.codewithinoussa.Executors;

import java.util.concurrent.*;

//powerful technique to use in our app
public class MailService {
    public void send(){
        LongTask.simulate(); // call our long running task
        System.out.println("Mail was sent: ");
    }

    //let define our send() using Asynchronous approach
    public CompletableFuture<Void> sendAsync(){
        return CompletableFuture.runAsync(() -> send()); // convert to Async by wraping it with CompletableFuture obj
    }
}
