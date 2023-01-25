package ru.micode.ImplHolder.lib;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Держатель реализаций интерфейса.
 *
 * @param <K> тип ключа реализации
 * @param <T> тип интерфейса
 */
@Component
public class ImplHolder<K, T extends ImplHolder.Key<K>> {

    protected final String holderId = UUID.randomUUID().toString();

    /**
     * Карта реализаций.
     */
    private final Map<K, T> implMap;

    /**
     * Конструктор.
     *
     * @param services список реализаций интерфейса.
     */
    public ImplHolder(List<T> services) {
        implMap = services.stream().collect(Collectors.toMap(Key::getKey, Function.identity()));
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
     * Id экземпляра держателя.
     *
     * @return уникальная строка экземпляра.
     */
    public String getHolderId() {
        return holderId;
    }

    /**
     * Интерфейс ключа реализации.
     */
    public interface Key<K> {

        /**
         * Возвращает ключ реализации.
         *
         * @return ключ реализации
         */
        K getKey();
    }
}