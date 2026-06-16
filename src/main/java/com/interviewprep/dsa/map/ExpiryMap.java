package com.interviewprep.dsa.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ExpiryMap<K, V> {

    private static class Entry<V> {
        final V value;
        final long ttlMillis;
        long lastAccessedAt;

        Entry(V value, long ttlMillis) {
            this.value = value;
            this.ttlMillis = ttlMillis;
            this.lastAccessedAt = System.currentTimeMillis();
        }

        boolean isExpired() {
            return System.currentTimeMillis() - lastAccessedAt > ttlMillis;
        }

        void touch() {
            this.lastAccessedAt = System.currentTimeMillis();
        }
    }

    private final Map<K, Entry<V>> store = new HashMap<>();


    public void put(K key, V value, long duration, TimeUnit unit) {
        long ttlMillis = unit.toMillis(duration);
        store.put(key, new Entry<>(value, ttlMillis));
    }


    public V get(K key) {
        Entry<V> entry = store.get(key);
        if (entry == null) return null;

        if (entry.isExpired()) {
            store.remove(key);
            return null;
        }

        entry.touch();
        return entry.value;
    }

    public boolean containsKey(K key) {
        Entry<V> entry = store.get(key);
        if (entry == null) return false;

        if (entry.isExpired()) {
            store.remove(key);
            return false;
        }

        entry.touch();
        return true;
    }

    public V remove(K key) {
        Entry<V> entry = store.remove(key);
        if (entry == null || entry.isExpired()) return null;
        return entry.value;
    }


    public int size() {
        evictExpired();
        return store.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        evictExpired();
        return store.keySet();
    }


    private void evictExpired() {
        Iterator<Map.Entry<K, Entry<V>>> it = store.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().isExpired()) {
                it.remove();
            }
        }
    }
}
