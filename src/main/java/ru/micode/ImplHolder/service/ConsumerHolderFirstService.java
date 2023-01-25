package ru.micode.ImplHolder.service;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.lib.ImplHolder;
import ru.micode.ImplHolder.lib.UnsupportedImplException;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.model.ResultProcess;

/**
 * Сервис использующий сервис держателя реализация.
 */
@Service
public class ConsumerHolderFirstService {

    private final ImplHolder<ImplType, ProcessService> processServiceImplHolder;

    public ConsumerHolderFirstService(ImplHolder<ImplType, ProcessService> processServiceImplHolder) {
        this.processServiceImplHolder = processServiceImplHolder;
    }

    public String getHolderId(){
        return processServiceImplHolder.getHolderId();
    }

    public ResultProcess call(ImplType implType) {
        return processServiceImplHolder.get(implType)
            .orElseThrow(UnsupportedImplException::new)
            .process();
    }
}
