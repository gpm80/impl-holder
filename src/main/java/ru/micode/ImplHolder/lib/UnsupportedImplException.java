package ru.micode.ImplHolder.lib;

/**
 * Created by Petr Gusarov
 */
public class UnsupportedImplException extends RuntimeException {

    public UnsupportedImplException() {
        super("not found implementation");
    }
}
