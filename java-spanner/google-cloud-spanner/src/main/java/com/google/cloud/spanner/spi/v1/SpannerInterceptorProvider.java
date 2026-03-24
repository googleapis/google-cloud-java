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
package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.cloud.spanner.SpannerRpcMetrics;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import io.grpc.ClientInterceptor;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * For internal use only. An interceptor provider that provides a list of grpc interceptors for
 * {@code GapicSpannerRpc} to handle logging and error augmentation by intercepting grpc calls.
 */
@InternalApi("Exposed for testing")
public class SpannerInterceptorProvider implements GrpcInterceptorProvider {
  private final List<ClientInterceptor> clientInterceptors;

  private SpannerInterceptorProvider(List<ClientInterceptor> clientInterceptors) {
    this.clientInterceptors = clientInterceptors;
  }

  @ObsoleteApi("This method always uses Global OpenTelemetry")
  public static SpannerInterceptorProvider createDefault() {
    return createDefault(GlobalOpenTelemetry.get());
  }

  public static SpannerInterceptorProvider createDefault(OpenTelemetry openTelemetry) {
    return createDefault(
        openTelemetry,
        Suppliers.memoize(
            () -> {
              return false;
            }));
  }

  @ObsoleteApi("DirectPathEnabledSupplier is not used")
  public static SpannerInterceptorProvider createDefault(
      OpenTelemetry openTelemetry, Supplier<Boolean> directPathEnabledSupplier) {
    List<ClientInterceptor> defaultInterceptorList = new ArrayList<>();
    defaultInterceptorList.add(new SpannerErrorInterceptor());
    defaultInterceptorList.add(
        new LoggingInterceptor(Logger.getLogger(GapicSpannerRpc.class.getName()), Level.FINER));
    defaultInterceptorList.add(new HeaderInterceptor(new SpannerRpcMetrics(openTelemetry)));
    defaultInterceptorList.add(new RequestIdInterceptor());
    return new SpannerInterceptorProvider(ImmutableList.copyOf(defaultInterceptorList));
  }

  static SpannerInterceptorProvider create(GrpcInterceptorProvider provider) {
    return new SpannerInterceptorProvider(ImmutableList.copyOf(provider.getInterceptors()));
  }

  public SpannerInterceptorProvider with(ClientInterceptor clientInterceptor) {
    List<ClientInterceptor> interceptors =
        ImmutableList.<ClientInterceptor>builder()
            .addAll(this.clientInterceptors)
            .add(clientInterceptor)
            .build();
    return new SpannerInterceptorProvider(interceptors);
  }

  SpannerInterceptorProvider withEncoding(String encoding) {
    if (encoding != null) {
      return with(new EncodingInterceptor(encoding));
    }
    return this;
  }

  SpannerInterceptorProvider withTraceContext(
      boolean endToEndTracingEnabled, OpenTelemetry openTelemetry) {
    if (endToEndTracingEnabled) {
      return with(new TraceContextInterceptor(openTelemetry));
    }
    return this;
  }

  @Override
  public List<ClientInterceptor> getInterceptors() {
    return clientInterceptors;
  }
}
