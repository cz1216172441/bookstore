package com.notalent.bookstore.storage;

/**
 * 未找到存储文件异常
 * @author noTalent
 * @version 1.0
 * 2019.05.18
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
