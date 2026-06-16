package com.interviewprep.lld.cache.cache.policies;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();
}
