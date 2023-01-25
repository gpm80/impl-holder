package ru.micode.ImplHolder.service.impl;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.model.ResultProcess;
import ru.micode.ImplHolder.service.ProcessService;

import java.util.UUID;

/**
 * Вторая реализация.
 */
@Service
public class TwoProcessServiceImpl implements ProcessService {

    private final String implId;

    public TwoProcessServiceImpl() {
        implId = UUID.randomUUID().toString();
    }

    @Override
    public ImplType getKey() {
        return ImplType.TWO;
    }

    @Override
    public ResultProcess process() {
        final ResultProcess resultProcess = new ResultProcess();
        resultProcess.setImplId(implId);
        resultProcess.setMessage("Impl service for " + getKey());
        return resultProcess;
    }
}
