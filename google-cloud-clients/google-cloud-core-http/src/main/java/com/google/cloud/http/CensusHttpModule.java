/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.http;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.common.annotations.VisibleForTesting;
import io.opencensus.contrib.http.util.HttpPropagationUtil;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.propagation.TextFormat;
import java.io.IOException;
import javax.annotation.Nullable;

/**
 * Provides utilities for Open Census to record http stats/trace information and propagate tracing
 * context.
 */
public final class CensusHttpModule {

  /**
   * OpenCensus tracing component. When no OpenCensus implementation is provided, it will return a
   * no-op tracer.
   */
  private final Tracer tracer;

  /** {@link TextFormat} used in tracing context propagation. */
  @Nullable private final TextFormat propagationTextFormat;

  /** {@link TextFormat.Setter} for {@link #propagationTextFormat}. */
  @Nullable private final TextFormat.Setter<HttpHeaders> propagationTextFormatSetter;

  /** Whether spans are stored locally. */
  private final boolean isRecordEvents;

  /** Default HTTP propagation text formatter. */
  @VisibleForTesting
  static final class DefaultPropagationTextFormatSetter extends TextFormat.Setter<HttpHeaders> {
    static final TextFormat.Setter<HttpHeaders> INSTANCE = new DefaultPropagationTextFormatSetter();

    @Override
    public void put(HttpHeaders carrier, String key, String value) {
      carrier.set(key, value);
    }
  }

  /**
   * An {@link HttpExecuteInterceptor} implementation to inject HTTP request and add getContext
   * information before it is executed.
   */
  @VisibleForTesting
  final class CensusHttpExecuteInterceptor implements HttpExecuteInterceptor {
    @Nullable HttpExecuteInterceptor interceptor;

    CensusHttpExecuteInterceptor(HttpExecuteInterceptor interceptor) {
      this.interceptor = interceptor;
    }

    @Override
    public void intercept(HttpRequest request) throws IOException {
      checkNotNull(request);
      if (this.interceptor != null) {
        this.interceptor.intercept(request);
      }
      if (propagationTextFormat != null && propagationTextFormatSetter != null) {
        SpanContext spanContext = tracer.getCurrentSpan().getContext();
        if (!SpanContext.INVALID.equals(spanContext)) {
          propagationTextFormat.inject(
              spanContext, request.getHeaders(), propagationTextFormatSetter);
        }
      }
    }
  }

  /**
   * An {@link HttpRequestInitializer} implementation to set {@link CensusHttpExecuteInterceptor} as
   * interceptor.
   */
  @VisibleForTesting
  final class CensusHttpRequestInitializer implements HttpRequestInitializer {
    @Nullable HttpRequestInitializer initializer;

    CensusHttpRequestInitializer(HttpRequestInitializer initializer) {
      this.initializer = initializer;
    }

    @Override
    public void initialize(HttpRequest request) throws IOException {
      checkNotNull(request);
      if (this.initializer != null) {
        this.initializer.initialize(request);
      }
      request.setInterceptor(new CensusHttpExecuteInterceptor(request.getInterceptor()));
    }
  }

  /**
   * Creates a {@link CensusHttpModule} with given parameters.
   *
   * @param tracer the OpenCensus {@code Tracer}.
   * @param isRecordEvents whether spans are stored locally.
   */
  public CensusHttpModule(Tracer tracer, boolean isRecordEvents) {
    checkNotNull(tracer, "tracer");
    this.tracer = tracer;
    this.isRecordEvents = isRecordEvents;
    this.propagationTextFormat = HttpPropagationUtil.getCloudTraceFormat();
    this.propagationTextFormatSetter = DefaultPropagationTextFormatSetter.INSTANCE;
  }

  /**
   * Returns the tracing component of OpenCensus.
   *
   * @return the tracing component of OpenCensus.
   */
  public Tracer getTracer() {
    return tracer;
  }

  /**
   * Returns whether spans are stored locally.
   *
   * @return whether spans are stored locally.
   */
  public boolean isRecordEvents() {
    return isRecordEvents;
  }

  /**
   * Returns the {@link HttpExecuteInterceptor} used when initializing the {@link HttpRequest}.
   *
   * @param initializer the original initializer which will be executed before this initializer.
   * @return the {@code HttpExecuteInterceptor}.
   */
  public HttpRequestInitializer getHttpRequestInitializer(HttpRequestInitializer initializer) {
    return new CensusHttpRequestInitializer(initializer);
  }
}
