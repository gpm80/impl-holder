package ru.micode.ImplHolder.service;

import ru.micode.ImplHolder.lib.ImplKey;
import ru.micode.ImplHolder.model.ImplType;

/**
 * Сервис имени.
 */
public interface PrintNameService extends ImplKey<ImplType> {
    String name();
}
