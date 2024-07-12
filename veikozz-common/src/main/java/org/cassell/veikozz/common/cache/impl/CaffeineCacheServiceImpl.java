package org.cassell.veikozz.common.cache.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.cassell.veikozz.common.cache.CacheService;

import java.time.Duration;

public class CaffeineCacheServiceImpl<K, V> implements CacheService<K, V> {

    private final Cache<K, V> cache;

    public CaffeineCacheServiceImpl(final int initialCapacity,
                                    final int maximumSize,
                                    final Duration expireAfterWrite,
                                    boolean useWeakKey) {
        if (useWeakKey) {
            this.cache = Caffeine.newBuilder()
                    .weakKeys()
                    .initialCapacity(initialCapacity)
                    .maximumSize(maximumSize)
                    .expireAfterWrite(expireAfterWrite)
                    .build();
        } else {
            this.cache = Caffeine.newBuilder()
                    .initialCapacity(initialCapacity)
                    .maximumSize(maximumSize)
                    .expireAfterWrite(expireAfterWrite)
                    .build();
        }
    }

    @Override
    public V get(K key) {
        return cache.getIfPresent(key);
    }

    @Override
    public V put(K key, V value) {
        V val = get(key);
        cache.put(key, value);
        return val;
    }

    @Override
    public V remove(K key) {
        V val = get(key);
        cache.invalidate(key);
        cache.cleanUp();
        return val;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public void clear() {
        cache.invalidateAll();
        cache.cleanUp();
    }

}
