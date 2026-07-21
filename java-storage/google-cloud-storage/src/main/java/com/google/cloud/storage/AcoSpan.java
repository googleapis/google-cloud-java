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

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import java.util.concurrent.TimeUnit;

final class AcoSpan implements Span {
  private final Span delegate;
  private final String bucketName;
  private final OtelStorageDecorator parent;

  AcoSpan(Span delegate, String bucketName, OtelStorageDecorator parent) {
    this.delegate = delegate;
    this.bucketName = bucketName;
    this.parent = parent;
  }

  private void applyCacheAttributes() {
    if (bucketName != null && parent != null) {
      BucketMetadataCache cache = parent.acoContext.getCache();
      if (cache != null) {
        BucketMetadataCache.BucketMetadata md = cache.get(bucketName);
        if (md != null && !md.fetchPending) {
          delegate.setAttribute("gcp.resource.destination.id", md.resource);
          delegate.setAttribute("gcp.resource.destination.location", md.location);
        }
      }
    }
  }

  @Override
  public void end() {
    applyCacheAttributes();
    delegate.end();
  }

  @Override
  public void end(long timestamp, TimeUnit unit) {
    applyCacheAttributes();
    delegate.end(timestamp, unit);
  }

  @Override
  public Span recordException(Throwable exception) {
    delegate.recordException(exception);
    handleException(exception);
    return this;
  }

  @Override
  public Span recordException(Throwable exception, Attributes attributes) {
    delegate.recordException(exception, attributes);
    handleException(exception);
    return this;
  }

  private void handleException(Throwable exception) {
    if (exception instanceof StorageException && parent != null) {
      StorageException se = (StorageException) exception;
      if (se.getCode() == 404 && se.getMessage() != null) {
        String msg = se.getMessage().toLowerCase(java.util.Locale.US);
        if (msg.contains("bucket not found") || msg.contains("bucket does not exist")) {
          BucketMetadataCache cache = parent.acoContext.getCache();
          if (cache != null) {
            cache.remove(bucketName);
          }
        }
      }
    }
  }

  @Override
  public Span setAttribute(String k, String v) {
    delegate.setAttribute(k, v);
    return this;
  }

  @Override
  public Span setAttribute(String k, long v) {
    delegate.setAttribute(k, v);
    return this;
  }

  @Override
  public Span setAttribute(String k, double v) {
    delegate.setAttribute(k, v);
    return this;
  }

  @Override
  public Span setAttribute(String k, boolean v) {
    delegate.setAttribute(k, v);
    return this;
  }

  @Override
  public <T> Span setAttribute(AttributeKey<T> k, T v) {
    delegate.setAttribute(k, v);
    return this;
  }

  @Override
  public Span addEvent(String n) {
    delegate.addEvent(n);
    return this;
  }

  @Override
  public Span addEvent(String n, Attributes a) {
    delegate.addEvent(n, a);
    return this;
  }

  @Override
  public Span addEvent(String n, long t, TimeUnit u) {
    delegate.addEvent(n, t, u);
    return this;
  }

  @Override
  public Span addEvent(String n, Attributes a, long t, TimeUnit u) {
    delegate.addEvent(n, a, t, u);
    return this;
  }

  @Override
  public Span setStatus(StatusCode c) {
    delegate.setStatus(c);
    return this;
  }

  @Override
  public Span setStatus(StatusCode c, String d) {
    delegate.setStatus(c, d);
    return this;
  }

  @Override
  public Span updateName(String name) {
    delegate.updateName(name);
    return this;
  }

  @Override
  public SpanContext getSpanContext() {
    return delegate.getSpanContext();
  }

  @Override
  public boolean isRecording() {
    return delegate.isRecording();
  }
}
