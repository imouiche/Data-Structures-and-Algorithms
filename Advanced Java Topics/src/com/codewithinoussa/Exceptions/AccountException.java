package com.codewithinoussa.Exceptions;

public class AccountException extends Exception{
    public AccountException(Exception cause){
        super(cause);
    }
}
