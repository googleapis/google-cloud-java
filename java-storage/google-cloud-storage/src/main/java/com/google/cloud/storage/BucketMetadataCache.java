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

import java.util.LinkedHashMap;
import java.util.Map;

final class BucketMetadataCache {

  static final class BucketMetadata {
    final String resource;
    final String location;

    BucketMetadata(String resource, String location) {
      this.resource = resource;
      this.location = location;
    }
  }

  private final Object lock = new Object();
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

  BucketMetadata get(String bucketName) {
    synchronized (lock) {
      return cache.get(bucketName);
    }
  }

  void put(String bucketName, BucketMetadata metadata) {
    synchronized (lock) {
      cache.put(bucketName, metadata);
    }
  }

  void remove(String bucketName) {
    synchronized (lock) {
      cache.remove(bucketName);
    }
  }

  void clear() {
    synchronized (lock) {
      cache.clear();
    }
  }

  boolean containsKey(String bucketName) {
    synchronized (lock) {
      return cache.containsKey(bucketName);
    }
  }
}
