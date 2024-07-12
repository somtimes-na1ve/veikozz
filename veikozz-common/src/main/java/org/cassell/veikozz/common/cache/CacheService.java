package org.cassell.veikozz.common.cache;

public interface CacheService<K, V> {

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    boolean contains(K key);

    void clear();

}
