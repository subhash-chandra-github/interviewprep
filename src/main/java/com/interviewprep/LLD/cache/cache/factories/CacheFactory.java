package com.interviewprep.LLD.cache.cache.factories;


import com.interviewprep.LLD.cache.cache.Cache;
import com.interviewprep.LLD.cache.cache.policies.LRUEvictionPolicy;
import com.interviewprep.LLD.cache.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
