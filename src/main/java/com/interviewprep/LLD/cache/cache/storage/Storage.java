package com.interviewprep.LLD.cache.cache.storage;


import com.interviewprep.LLD.cache.cache.exceptions.NotFoundException;
import com.interviewprep.LLD.cache.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;
}
