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
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import java.util.concurrent.TimeUnit;

final class AcoSpanBuilder implements SpanBuilder {
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
      String name = OtelStorageDecorator.extractBucketName(value);
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
      String name = OtelStorageDecorator.extractBucketName((String) value);
      if (name != null && !name.isEmpty()) {
        this.bucketName = name;
      }
    }
    return this;
  }

  @Override
  public Span startSpan() {
    if (bucketName != null && parent != null) {
      parent.checkCacheAndTriggerFetch(bucketName);
      BucketMetadataCache.BucketMetadata md =
          parent.getBucketMetadataCache().get(bucketName);
      if (md != null) {
        delegate.setAttribute("gcp.resource.destination.id", md.resource);
        delegate.setAttribute("gcp.resource.destination.location", md.location);
      }
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
}
