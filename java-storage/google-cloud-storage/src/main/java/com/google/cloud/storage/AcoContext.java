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

import io.opentelemetry.api.trace.SpanBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

abstract class AcoContext implements AutoCloseable {

  abstract SpanBuilder wrap(SpanBuilder spanBuilder, OtelStorageDecorator parent);

  abstract BucketMetadataCache getCache();

  abstract ExecutorService getCacheExecutor();

  @Override
  public abstract void close();

  static AcoContext create(boolean enabled) {
    return enabled ? new EnabledAcoContext() : new DisabledAcoContext();
  }

  private static final class EnabledAcoContext extends AcoContext {
    private final BucketMetadataCache bucketMetadataCache =
        BucketMetadataCache.getBucketMetadataCache();
    private volatile ExecutorService cacheExecutor;

    @Override
    SpanBuilder wrap(SpanBuilder spanBuilder, OtelStorageDecorator parent) {
      return new AcoSpanBuilder(spanBuilder, parent);
    }

    @Override
    BucketMetadataCache getCache() {
      return bucketMetadataCache;
    }

    @Override
    ExecutorService getCacheExecutor() {
      ExecutorService result = cacheExecutor;
      if (result == null) {
        synchronized (this) {
          result = cacheExecutor;
          if (result == null) {
            cacheExecutor = result = AcoSpanBuilder.newCacheExecutor();
          }
        }
      }
      return result;
    }

    @Override
    public void close() {
      bucketMetadataCache.clear();
      synchronized (this) {
        if (cacheExecutor != null) {
          cacheExecutor.shutdownNow();
          try {
            cacheExecutor.awaitTermination(5, TimeUnit.SECONDS);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }

  private static final class DisabledAcoContext extends AcoContext {
    @Override
    SpanBuilder wrap(SpanBuilder spanBuilder, OtelStorageDecorator parent) {
      return spanBuilder;
    }

    @Override
    BucketMetadataCache getCache() {
      return null;
    }

    @Override
    ExecutorService getCacheExecutor() {
      return null;
    }

    @Override
    public void close() {}
  }
}
