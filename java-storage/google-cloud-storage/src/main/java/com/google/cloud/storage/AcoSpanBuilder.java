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
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class AcoSpanBuilder implements SpanBuilder {

  private static final Logger LOGGER = Logger.getLogger(AcoSpanBuilder.class.getName());

  private final SpanBuilder delegate;
  private final OtelStorageDecorator parent;
  private String bucketName;

  AcoSpanBuilder(SpanBuilder delegate, OtelStorageDecorator parent) {
    this.delegate = delegate;
    this.parent = parent;
  }

  @Override
  public SpanBuilder setAttribute(String key, String value) {
    delegate.setAttribute(key, value);
    if ("gsutil.uri".equals(key) && value != null) {
      String name = extractBucketName(value);
      if (name != null && !name.isEmpty()) {
        this.bucketName = name;
      }
    }
    return this;
  }

  @Override
  public <T> SpanBuilder setAttribute(AttributeKey<T> key, T value) {
    delegate.setAttribute(key, value);
    if ("gsutil.uri".equals(key.getKey()) && value instanceof String) {
      String name = extractBucketName((String) value);
      if (name != null && !name.isEmpty()) {
        this.bucketName = name;
      }
    }
    return this;
  }

  @Override
  public Span startSpan() {
    if (bucketName != null && parent != null) {
      checkCacheAndTriggerFetch(
          parent.delegate, parent.bucketMetadataCache, parent.cacheExecutor, bucketName);
      return new AcoSpan(delegate.startSpan(), bucketName, parent);
    }
    return delegate.startSpan();
  }

  @Override
  public SpanBuilder setNoParent() {
    delegate.setNoParent();
    return this;
  }

  @Override
  public SpanBuilder setAttribute(String key, boolean value) {
    delegate.setAttribute(key, value);
    return this;
  }

  @Override
  public SpanBuilder setAttribute(String key, double value) {
    delegate.setAttribute(key, value);
    return this;
  }

  @Override
  public SpanBuilder setAttribute(String key, long value) {
    delegate.setAttribute(key, value);
    return this;
  }

  @Override
  public SpanBuilder setSpanKind(SpanKind k) {
    delegate.setSpanKind(k);
    return this;
  }

  @Override
  public SpanBuilder setStartTimestamp(long t, TimeUnit u) {
    delegate.setStartTimestamp(t, u);
    return this;
  }

  @Override
  public SpanBuilder setParent(Context c) {
    delegate.setParent(c);
    return this;
  }

  @Override
  public SpanBuilder addLink(SpanContext c) {
    delegate.addLink(c);
    return this;
  }

  @Override
  public SpanBuilder addLink(SpanContext c, Attributes a) {
    delegate.addLink(c, a);
    return this;
  }

  static ExecutorService newCacheExecutor() {
    int poolSize = Math.max(4, Runtime.getRuntime().availableProcessors());
    java.util.concurrent.ThreadPoolExecutor executor =
        new java.util.concurrent.ThreadPoolExecutor(
            poolSize, // core pool size dynamically scaled based on CPU cores
            poolSize, // max pool size dynamically scaled based on CPU cores
            5L, // 5 seconds keep-alive: terminates threads quickly when done
            TimeUnit.SECONDS,
            new java.util.concurrent
                .LinkedBlockingQueue<>(), // Unbounded queue ensures no tasks are ever rejected or
            // lost
            r -> {
              Thread t = new Thread(r);
              t.setDaemon(true);
              t.setName("gcs-aco-metadata-cache-pool");
              return t;
            });
    executor.allowCoreThreadTimeOut(true);
    return executor;
  }

  static String extractBucketName(String uri) {
    if (uri == null || !uri.startsWith("gs://")) {
      return null;
    }
    String remainder = uri.substring(5);
    int firstSlash = remainder.indexOf('/');
    if (firstSlash == -1) {
      return remainder;
    }
    return remainder.substring(0, firstSlash);
  }

  static Tuple<String, String> fetch(Storage delegate, String bucketName) {
    Bucket bucket = delegate.get(bucketName);
    if (bucket == null) {
      return null;
    }

    String projectId = bucket.getProject() != null ? bucket.getProject().toString() : null;
    String resource;
    if (projectId != null && !projectId.isEmpty()) {
      resource = "projects/" + projectId + "/buckets/" + bucketName;
    } else {
      resource = "projects/_/buckets/" + bucketName;
    }

    String location =
        bucket.getLocation() != null ? bucket.getLocation().toLowerCase(Locale.US) : "global";
    String locationType =
        bucket.getLocationType() != null
            ? bucket.getLocationType().toLowerCase(Locale.US)
            : "region";

    if ("multi-region".equals(locationType) || "dual-region".equals(locationType)) {
      location = "global";
    }

    return Tuple.of(resource, location);
  }

  static void checkCacheAndTriggerFetch(
      Storage delegate,
      BucketMetadataCache bucketMetadataCache,
      ExecutorService cacheExecutor,
      String bucketName) {
    if (bucketMetadataCache.containsKey(bucketName)) {
      return;
    }

    // Put fetchPending placeholder synchronously to block concurrent stampedes
    bucketMetadataCache.put(bucketName, "projects/_/buckets/" + bucketName, "global", true);

    cacheExecutor.submit(
        () -> {
          try {
            Tuple<String, String> layout = fetch(delegate, bucketName);
            if (layout != null) {
              bucketMetadataCache.put(bucketName, layout, false);
            } else {
              // Bucket does not exist (fetch returned null) -> Evict cache entry
              bucketMetadataCache.remove(bucketName);
            }
          } catch (StorageException e) {
            if (e.getCode() == 404) {
              // Bucket not found -> Evict cache entry
              bucketMetadataCache.remove(bucketName);
            } else if (e.getCode() == 403) {
              // Permission Denied -> Retain fallback values with fetchPending=false (Do Not Retry)
              bucketMetadataCache.put(
                  bucketName, "projects/_/buckets/" + bucketName, "global", false);
            } else {
              LOGGER.log(Level.WARNING, "Background GetBucket failed", e);
            }
          } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Background GetBucket failed", e);
          }
        });
  }
}
