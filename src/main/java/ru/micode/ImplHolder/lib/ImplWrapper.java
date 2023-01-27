package ru.micode.ImplHolder.lib;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Абстрактная обертка карты реализаций сервиса.
 *
 * @param <K> тип ключа реализации
 * @param <T> тип интерфейса сервиса
 */
public abstract class ImplWrapper<K, T extends ImplKey<K>> {

    private final String wrapperId = UUID.randomUUID().toString();
    /**
     * Карта реализаций.
     */
    private final Map<K, T> implMap;

    /**
     * Конструктор
     *
     * @param services реализации
     */
    protected ImplWrapper(List<T> services) {
        implMap = services.stream().collect(Collectors.toMap(ImplKey::getKey, Function.identity(), (impl, implDup) -> {
            throw new NoUniqueBeanDefinitionException(implDup.getClass(), 2, "duplicate bean implementation");
        }));
    }

    /**
     * Возвращает реализацию по ключу.
     *
     * @param key ключ реализации
     * @return реализация интерфейса.
     */
    public Optional<T> get(K key) {
        return Optional.ofNullable(implMap.get(key));
    }

    /**
     * Возвращает UUID обертки.
     *
     * @return UUID обертки
     */
    public String getWrapperId() {
        return wrapperId;
    }
}
