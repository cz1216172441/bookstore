package com.notalent.bookstore.storage;

/**
 * 存储异常
 * @author noTalent
 * @version 1.0
 * 2019.05.18
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
