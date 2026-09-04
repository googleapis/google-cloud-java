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

/**
 * A cache for bucket metadata (resource and location) used by App-Centric Observability (ACO).
 *
 * <p>To prevent blocking the application's critical path, bucket metadata resolution is done
 * asynchronously. When a cache miss occurs, a placeholder entry is created in the cache with {@code
 * fetchPending = true}. This prevents concurrent threads from submitting duplicate fetch requests
 * for the same bucket. Once the asynchronous fetch completes, the cache is updated with the
 * resolved metadata and {@code fetchPending} is set to {@code false}.
 */
final class BucketMetadataCache {

  private static final int DEFAULT_CAPACITY = 10000;
  private final ReentrantLock lock = new ReentrantLock();
  private final Map<String, BucketMetadata> cache;

  BucketMetadataCache(int capacity) {
    this.cache =
        new LinkedHashMap<String, BucketMetadata>(capacity, 0.75f, true) {
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

  /**
   * Puts bucket metadata into the cache.
   *
   * @param bucketName the name of the bucket
   * @param resource the resource path associated with the bucket
   * @param location the location of the bucket
   * @param pending whether a fetch for this bucket's metadata is currently pending (used to prevent
   *     duplicate background fetches)
   */
  void put(String bucketName, String resource, String location, boolean pending) {
    lock.lock();
    try {
      cache.put(bucketName, new BucketMetadata(resource, location, pending));
    } finally {
      lock.unlock();
    }
  }

  /**
   * Puts bucket metadata into the cache using a layout tuple containing resource and location.
   *
   * @param bucketName the name of the bucket
   * @param layout a tuple containing (resource, location)
   * @param pending whether a fetch for this bucket's metadata is currently pending (used to prevent
   *     duplicate background fetches)
   */
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

  /**
   * Atomically checks if the bucket is present in the cache. If absent, inserts a placeholder
   * metadata entry with {@code fetchPending = true} and returns {@code true} to signal that a
   * background fetch task should be initiated.
   *
   * @param bucketName the name of the bucket
   * @param resource the placeholder resource prefix to use until resolved
   * @param location the placeholder location to use until resolved
   * @return {@code true} if the entry was absent and placeholder was inserted; {@code false} if the
   *     entry was already present (meaning a fetch is either pending or completed)
   */
  boolean putPendingIfAbsent(String bucketName, String resource, String location) {
    lock.lock();
    try {
      if (cache.containsKey(bucketName)) {
        return false;
      }
      cache.put(bucketName, new BucketMetadata(resource, location, true));
      return true;
    } finally {
      lock.unlock();
    }
  }

  static final class BucketMetadata {
    final String resource;
    final String location;

    /**
     * Whether a background metadata fetch is currently pending/in-progress for this bucket (used to
     * prevent duplicate background fetches). While {@code true}, the resource and location fields
     * contain temporary placeholder values.
     */
    final boolean fetchPending;

    BucketMetadata(String resource, String location, boolean fetchPending) {
      this.resource = resource;
      this.location = location;
      this.fetchPending = fetchPending;
    }
  }
}
