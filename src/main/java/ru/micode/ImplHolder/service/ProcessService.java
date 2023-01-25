package ru.micode.ImplHolder.service;

import ru.micode.ImplHolder.lib.ImplHolder;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.model.ResultProcess;

/**
 * Интерфейс по типу.
 */
public interface ProcessService extends ImplHolder.Key<ImplType> {

    ResultProcess process();
}
