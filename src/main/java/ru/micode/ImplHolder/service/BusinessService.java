package ru.micode.ImplHolder.service;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.lib.UnsupportedImplException;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.wrapper.PrintNameServiceWrapper;
import ru.micode.ImplHolder.service.wrapper.PrintOrdinalServiceWrapper;

/**
 * Бизнес логика.
 */
@Service
public class BusinessService {

    private final PrintNameServiceWrapper printNameServiceWrapper;
    private final PrintOrdinalServiceWrapper printOrdinalServiceWrapper;

    public BusinessService(PrintNameServiceWrapper printNameServiceWrapper,
                           PrintOrdinalServiceWrapper printOrdinalServiceWrapper) {
        this.printNameServiceWrapper = printNameServiceWrapper;
        this.printOrdinalServiceWrapper = printOrdinalServiceWrapper;
    }

    public PrintNameService getPrintService(ImplType implType){
        return printNameServiceWrapper.find(implType).orElseThrow(UnsupportedImplException::new);
    }

    public String name(ImplType implType) {
        return getPrintService(implType).name();
    }

    public int ordinal(ImplType implType) {
        return printOrdinalServiceWrapper.get(implType).ordinal();
    }

    public String getIdNameService() {
        return printNameServiceWrapper.getWrapperId();
    }

    public String getIdOrdinalService() {
        return printOrdinalServiceWrapper.getWrapperId();
    }
}
