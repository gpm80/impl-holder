package ru.micode.ImplHolder.service.impl;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.PrintNameService;

/**
 * Реализация сервиса имени.
 */
@Service
public class TwoPrintNameService implements PrintNameService {

    @Override
    public ImplType getKey() {
        return ImplType.TWO;
    }

    @Override
    public String name() {
        return getKey().name();
    }
}
