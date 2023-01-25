package ru.micode.ImplHolder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.model.ResultProcess;
import ru.micode.ImplHolder.service.ConsumerHolderFirstService;
import ru.micode.ImplHolder.service.ConsumerHolderSecondService;

@SpringBootTest
class ImplHolderApplicationTests {

    @Autowired
    private ConsumerHolderFirstService firstService;
    @Autowired
    private ConsumerHolderSecondService secondService;

    @Test
    void test() {
        Assertions.assertEquals(firstService.getHolderId(), secondService.getHolderId());
        Assertions.assertEquals(firstService.call(ImplType.ONE).getImplId(), secondService.call(ImplType.ONE).getImplId());
        Assertions.assertEquals(firstService.call(ImplType.TWO).getImplId(), secondService.call(ImplType.TWO).getImplId());
    }
}
