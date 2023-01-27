package ru.micode.ImplHolder.service.impl;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.PrintOrdinalService;

/**
 * Реализация сервиса номера.
 */
@Service
public class TwoPrintOrdinalService implements PrintOrdinalService {

    @Override
    public ImplType getKey() {
        return ImplType.TWO;
    }

    @Override
    public int ordinal() {
        return getKey().ordinal();
    }
}
