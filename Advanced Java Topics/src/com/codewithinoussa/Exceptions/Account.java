package com.codewithinoussa.Exceptions;

import java.io.*;

public class Account {
    private float balance;
    public void deposit(float value) throws IOException {
        //defensive programming
        if (value <= 0)
            //throw new IllegalArgumentException();
            throw new IOException(); //if we want to throw is a diff type of exceptions
    }
    public void withdraw(float value) throws AccountException {
        if (value > balance) {
           // var fundsException = new InsufficientFundsException();
            throw new AccountException(new InsufficientFundsException());
         //   accountException.initCause(fundsException);
          //  throw accountException;
        }
    }
}
