package ru.micode.ImplHolder.lib;

/**
 * Исключение отсутствия реализации.
 */
public class UnsupportedImplException extends RuntimeException {

    public UnsupportedImplException() {
        super("not found implementation");
    }
}
