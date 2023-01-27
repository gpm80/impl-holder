package ru.micode.ImplHolder.service.wrapper;

import org.springframework.stereotype.Component;
import ru.micode.ImplHolder.lib.ImplWrapper;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.PrintOrdinalService;

import java.util.List;

/**
 * Обертка реализаций сервиса PrintOrdinalService.
 */
@Component
public class PrintOrdinalServiceWrapper extends ImplWrapper<ImplType, PrintOrdinalService> {
    /**
     * Конструктор
     *
     * @param services реализации
     */
    protected PrintOrdinalServiceWrapper(List<PrintOrdinalService> services) {
        super(services);
    }
}
