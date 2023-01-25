package ru.micode.ImplHolder.service.impl;

import org.springframework.stereotype.Service;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.model.ResultProcess;
import ru.micode.ImplHolder.service.ProcessService;

import java.util.UUID;

/**
 * Первая реализация.
 */
@Service
public class OneProcessServiceImpl implements ProcessService {

    private final String implId;

    public OneProcessServiceImpl() {
        implId = UUID.randomUUID().toString();
    }

    @Override
    public ImplType getKey() {
        return ImplType.ONE;
    }

    @Override
    public ResultProcess process() {
        final ResultProcess resultProcess = new ResultProcess();
        resultProcess.setImplId(implId);
        resultProcess.setMessage("Impl service for " + getKey());
        return resultProcess;
    }
}
