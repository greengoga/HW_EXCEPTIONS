package ru.netology.hw_exeptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String c) {
        super(c);
    }
}


