/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore.telemetry;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.cloud.datastore.telemetry.TraceUtil.Context;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerProvider;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Tracing utility implementation, used to stub out tracing instrumentation when tracing is
 * disabled.
 */
@InternalApi
public class DisabledTraceUtil implements TraceUtil {
  static class Span implements TraceUtil.Span {
    @Override
    public void end() {}

    @Override
    public void end(Throwable error) {}

    @Override
    public <T> void endAtFuture(ApiFuture<T> futureValue) {}

    @Override
    public TraceUtil.Span addEvent(String name) {
      return this;
    }

    @Override
    public TraceUtil.Span addEvent(String name, Map<String, Object> attributes) {
      return this;
    }

    @Override
    public TraceUtil.Span setAttribute(String key, int value) {
      return this;
    }

    @Override
    public TraceUtil.Span setAttribute(String key, String value) {
      return this;
    }

    @Override
    public TraceUtil.Span setAttribute(String key, boolean value) {
      return this;
    }

    public io.opentelemetry.api.trace.Span getSpan() {
      return null;
    }

    @Override
    public Scope makeCurrent() {
      return new Scope();
    }
  }

  static class Context implements TraceUtil.Context {
    @Override
    public Scope makeCurrent() {
      return new Scope();
    }
  }

  static class Scope implements TraceUtil.Scope {
    @Override
    public void close() {}
  }

  @Nullable
  @Override
  public ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> getChannelConfigurator() {
    return null;
  }

  @Override
  public Span startSpan(String spanName) {
    return new Span();
  }

  @Override
  public TraceUtil.Span startSpan(String spanName, TraceUtil.Span parentSpan) {
    return new Span();
  }

  public SpanBuilder addSettingsAttributesToCurrentSpan(SpanBuilder spanBuilder) {
    return getTracer().spanBuilder("TRACING_DISABLED_NO_OP");
  }

  @Nonnull
  @Override
  public TraceUtil.Span getCurrentSpan() {
    return new Span();
  }

  @Nonnull
  @Override
  public TraceUtil.Context getCurrentContext() {
    return new Context();
  }

  @Override
  public Tracer getTracer() {
    return TracerProvider.noop().get(LIBRARY_NAME);
  }
}
