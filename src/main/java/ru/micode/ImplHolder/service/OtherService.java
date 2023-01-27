package ru.micode.ImplHolder.service;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.lib.UnsupportedImplException;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.wrapper.PrintNameServiceWrapper;

/**
 * Другой сервис.
 */
@Service
public class OtherService {

    private final PrintNameServiceWrapper printNameServiceWrapper;

    public OtherService(PrintNameServiceWrapper printNameServiceWrapper) {
        this.printNameServiceWrapper = printNameServiceWrapper;
    }

    public PrintNameService getPrintService(ImplType implType) {
        return printNameServiceWrapper.find(implType).orElseThrow(UnsupportedImplException::new);
    }

    /**
     * Вызов реализации по ключу.
     *
     * @param implType ключ реализации.
     */
    public String name(ImplType implType) {
        return getPrintService(implType).name();
    }
}
