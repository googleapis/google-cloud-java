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
  private static final String MULTI_REGION = "multi-region";
  private static final String DUAL_REGION = "dual-region";
  private static final String PLACEHOLDER_BUCKET_LOCATION = "global";
  private static final String PLACEHOLDER_RESOURCE_PREFIX = "projects/_/buckets/";

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
    if ("gsutil.uri".equals(key)) {
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
      BucketMetadataCache cache = parent.acoContext.getCache();
      ExecutorService cacheExecutor = parent.acoContext.getCacheExecutor();
      if (cache != null && cacheExecutor != null) {
        checkCacheAndTriggerFetch(parent.delegate, cache, cacheExecutor, bucketName);
        return new AcoSpan(delegate.startSpan(), bucketName, parent);
      }
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
            poolSize,
            poolSize,
            5L,
            TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(10000),
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
    Bucket bucket =
        delegate.get(
            bucketName,
            Storage.BucketGetOption.fields(
                Storage.BucketField.LOCATION,
                Storage.BucketField.LOCATION_TYPE,
                Storage.BucketField.PROJECT));
    if (bucket == null) {
      return null;
    }

    String projectId = bucket.getProject() != null ? bucket.getProject().toString() : null;
    String resource;
    if (projectId != null && !projectId.isEmpty()) {
      resource = "projects/" + projectId + "/buckets/" + bucketName;
    } else {
      resource = PLACEHOLDER_RESOURCE_PREFIX + bucketName;
    }

    String location =
        bucket.getLocation() != null ? bucket.getLocation().toLowerCase(Locale.US) : "global";
    String locationType =
        bucket.getLocationType() != null
            ? bucket.getLocationType().toLowerCase(Locale.US)
            : "region";

    if (MULTI_REGION.equals(locationType) || DUAL_REGION.equals(locationType)) {
      location = "global";
    }

    return Tuple.of(resource, location);
  }

  static void checkCacheAndTriggerFetch(
      Storage delegate,
      BucketMetadataCache bucketMetadataCache,
      ExecutorService cacheExecutor,
      String bucketName) {
    if (!bucketMetadataCache.putPendingIfAbsent(
        bucketName, PLACEHOLDER_RESOURCE_PREFIX + bucketName, PLACEHOLDER_BUCKET_LOCATION)) {
      return;
    }

    try {
      cacheExecutor.submit(
          () -> {
            try {
              Tuple<String, String> layout = fetch(delegate, bucketName);
              if (layout != null) {
                bucketMetadataCache.put(bucketName, layout, false);
              } else {
                bucketMetadataCache.remove(bucketName);
              }
            } catch (StorageException e) {
              if (e.getCode() == 404) {
                bucketMetadataCache.remove(bucketName);
              } else if (e.getCode() == 403) {
                bucketMetadataCache.put(
                    bucketName,
                    PLACEHOLDER_RESOURCE_PREFIX + bucketName,
                    PLACEHOLDER_BUCKET_LOCATION,
                    false);
              } else {
                LOGGER.log(Level.WARNING, "Background GetBucket failed", e);
                bucketMetadataCache.remove(bucketName);
              }
            } catch (Exception e) {
              LOGGER.log(Level.WARNING, "Background GetBucket failed", e);
              bucketMetadataCache.remove(bucketName);
            }
          });
    } catch (java.util.concurrent.RejectedExecutionException e) {
      LOGGER.log(Level.WARNING, "Background prefetch task rejected due to pool saturation", e);
      bucketMetadataCache.remove(bucketName);
    }
  }
}
