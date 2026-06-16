package com.interviewprep.lld.cache.cache.factories;


import com.interviewprep.lld.cache.cache.Cache;
import com.interviewprep.lld.cache.cache.policies.LRUEvictionPolicy;
import com.interviewprep.lld.cache.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
