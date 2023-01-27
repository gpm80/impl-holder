package ru.micode.ImplHolder.service;

import ru.micode.ImplHolder.lib.ImplKey;
import ru.micode.ImplHolder.model.ImplType;

/**
 * Сервис номера.
 */
public interface PrintOrdinalService extends ImplKey<ImplType> {

    int ordinal();
}
