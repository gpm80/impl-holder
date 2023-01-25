# Держатель множественных реализаций интерфейса сервиса Spring

## Проблема

У вас в проекте есть интерфейс сервиса, который реализуется более чем одной реализацией, то варианты DI определенной
реализации сводится к одному из следующих вариантов:

* @Autowired List<Object> c ручным выбором реализации из списка;
* @Autowired Map<String, Object> map, где ключ это id реализации сервиса (выданный Spring или установленный в ручную
* через @Spring("value"));
* DI через @Qualifier тех реализаций которые вам необходимы.
* @Primary, но в данном случае выбор отличной от дефолтной реализации сводится к применению одного из выше перечисленных
  методов.

## Решение

Компонент ImplHolder<K, T extends ImplHolder.Key<K>>, который хранит в себе карту сервисов с любой реализацией ключа
выбора.

### Ограничения

Интерфейс сервиса, который планируется использовать через ImplHolder должен наследовать ImplHolder.Key<K>, а все реализации
возвращать ключ своей реализации типа <K>

```java
/**
 * Ключ реализации.
 */
public enum ImplType {
  ONE, TWO
}

/**
 * Интерфейс сервиса.
 */
public interface ProcessService extends ImplHolder.Key<ImplType> {
    String process();
}

@Service
public class OneProcessServiceImpl implements ProcessService {

  /**
   * Уникальный ключ реализации.
   * @return {@link ImplType} 
   */
  @Override
  public ImplType getKey() {
    return ImplType.ONE;
  }

  @Override
  public String process() {
    return "Impl service for " + getKey();
  }
}
```

### Использование
```java
@Service
public class ConsumerService {

  /**
   * Holder реализаций сервиса ProcessService.
   */
  private final ImplHolder<ImplType, ProcessService> processServiceImplHolder;

  public ConsumerService(ImplHolder<ImplType, ProcessService> processServiceImplHolder) {
    this.processServiceImplHolder = processServiceImplHolder;
  }

  /**
   * Пример вызова реализации по enum ImplType.
   *
   * @param implType ключ реализации сервиса
   * @return
   */
  public ResultProcess call(ImplType implType) {
    return processServiceImplHolder.get(implType)
            .orElseThrow(UnsupportedImplException::new)
            .process();
  }
}
```


