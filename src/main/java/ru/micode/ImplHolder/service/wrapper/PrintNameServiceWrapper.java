package ru.micode.ImplHolder.service.wrapper;

import org.springframework.stereotype.Component;
import ru.micode.ImplHolder.lib.ImplWrapper;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.PrintNameService;

import java.util.List;

/**
 * Обертка.
 */
@Component
public class PrintNameServiceWrapper extends ImplWrapper<ImplType, PrintNameService> {
    protected PrintNameServiceWrapper(List<PrintNameService> services) {
        super(services);
    }
}
