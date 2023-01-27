package ru.micode.ImplHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.micode.ImplHolder.lib.UnsupportedImplException;
import ru.micode.ImplHolder.model.ImplType;
import ru.micode.ImplHolder.service.BusinessService;
import ru.micode.ImplHolder.service.OtherService;

@SpringBootTest
class ImplHolderApplicationTests {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private OtherService otherService;

    @Test
    void wrapperTest() {
        assertEquals(ImplType.ONE.name(), businessService.name(ImplType.ONE));
        assertEquals(ImplType.TWO.name(), businessService.name(ImplType.TWO));
        assertEquals(ImplType.ONE.ordinal(), businessService.ordinal(ImplType.ONE));
        assertEquals(ImplType.TWO.ordinal(), businessService.ordinal(ImplType.TWO));
        // Проверка оберток на отличие экземпляров
        assertNotEquals(businessService.getIdNameService(), businessService.getIdOrdinalService());
        // Проверка идентичности экземпляров из разных DI приложения
        assertSame(businessService.getPrintService(ImplType.ONE), otherService.getPrintService(ImplType.ONE));
        assertSame(businessService.getPrintService(ImplType.TWO), otherService.getPrintService(ImplType.TWO));
        // Исключение на отсутствие реализации сервиса
        try {
            businessService.name(ImplType.NOT_EXISTS);
            fail("expected exception");
        } catch (UnsupportedImplException e) {
        }
    }
}
