/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import com.google.cloud.Tuple;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

final class BucketMetadataCache {

  private static final int DEFAULT_CAPACITY = 10000;
  private final ReentrantLock lock = new ReentrantLock();
  private final Map<String, BucketMetadata> cache;

  BucketMetadataCache(int capacity) {
    this.cache =
        new LinkedHashMap<String, BucketMetadata>(16, 0.75f, true) {
          @Override
          protected boolean removeEldestEntry(Map.Entry<String, BucketMetadata> eldest) {
            return size() > capacity;
          }
        };
  }

  static BucketMetadataCache getBucketMetadataCache() {
    return new BucketMetadataCache(DEFAULT_CAPACITY);
  }

  BucketMetadata get(String bucketName) {
    lock.lock();
    try {
      return cache.get(bucketName);
    } finally {
      lock.unlock();
    }
  }

  void put(String bucketName, BucketMetadata metadata) {
    lock.lock();
    try {
      cache.put(bucketName, metadata);
    } finally {
      lock.unlock();
    }
  }

  void put(String bucketName, String resource, String location, boolean pending) {
    lock.lock();
    try {
      cache.put(bucketName, new BucketMetadata(resource, location, pending));
    } finally {
      lock.unlock();
    }
  }

  void put(String bucketName, Tuple<String, String> layout, boolean pending) {
    lock.lock();
    try {
      cache.put(bucketName, new BucketMetadata(layout.x(), layout.y(), pending));
    } finally {
      lock.unlock();
    }
  }

  void remove(String bucketName) {
    lock.lock();
    try {
      cache.remove(bucketName);
    } finally {
      lock.unlock();
    }
  }

  void clear() {
    lock.lock();
    try {
      cache.clear();
    } finally {
      lock.unlock();
    }
  }

  boolean containsKey(String bucketName) {
    lock.lock();
    try {
      return cache.containsKey(bucketName);
    } finally {
      lock.unlock();
    }
  }

  static final class BucketMetadata {
    final String resource;
    final String location;
    final boolean fetchPending;

    BucketMetadata(String resource, String location, boolean fetchPending) {
      this.resource = resource;
      this.location = location;
      this.fetchPending = fetchPending;
    }
  }
}
