# Обертка реализаций интерфейса сервиса

## Проблема

У вас в проекте есть интерфейс сервиса, который реализуется более чем одной реализацией, то варианты DI определенной
реализации сводится к одному из следующих вариантов:

- `@Autowired List<Object>` c ручным выбором реализации из списка;
- `@Autowired Map<String, Object> map`, где ключ это id реализации сервиса (выданный Spring или установленный в ручную
  через `@Spring("value")`);
- DI через `@Qualifier` тех реализаций, которые вам необходимы.
- `@Primary`, но в данном случае выбор отличной от дефолтной реализации сводится к применению одного из выше
  перечисленных методов.

## Решение

Абстрактный класс обертка `public abstract class ImplWrapper<K, T extends ImplKey<K>>`, который хранит в себе карту
сервисов с любой реализацией ключа реализации.

### Ограничения

Интерфейс сервиса, который планируется использовать через `ImplWrapper` должен наследовать `ImplKey<K>`, а все
реализации возвращать ключ своей реализации типа `<K>`

```java
/**
 * Ключ реализации.
 */
public enum ImplType {
    ONE, TWO
}

/**
 * Интерфейс сервиса имени.
 */
public interface PrintNameService extends ImplKey<ImplType> {
    String name();
}

/**
 * Реализация сервиса имени.
 */
@Service
public class OnePrintNameService implements PrintNameService {

  @Override
  public ImplType getKey() {
    return ImplType.ONE;
  }

  @Override
  public String name() {
    return getKey().name();
  }
}

/**
 * Обертка реализаций.
 */
@Component
public class PrintNameServiceWrapper extends ImplWrapper<ImplType, PrintNameService> {
    protected PrintNameServiceWrapper(List<PrintNameService> services) {
        super(services);
    }
}
```

### Использование

```java
@Service
public class OtherService {

  private final PrintNameServiceWrapper printNameServiceWrapper;

  public OtherService(PrintNameServiceWrapper printNameServiceWrapper) {
    this.printNameServiceWrapper = printNameServiceWrapper;
  }

  /**
   * Вызов реализации по ключу.
   *
   * @param implType ключ реализации.
   */
  public String name(ImplType implType) {
    return printNameServiceWrapper.get(implType).orElseThrow(UnsupportedImplException::new).name();
  }
}
```


