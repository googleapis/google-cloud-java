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
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.common.collect.ImmutableList;
import io.grpc.ClientInterceptor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * For internal use only. An interceptor provider that provides a list of grpc interceptors for
 * {@code GapicSpannerRpc} to handle logging and error augmentation by intercepting grpc calls.
 */
@InternalApi("Exposed for testing")
public class SpannerInterceptorProvider implements GrpcInterceptorProvider {

  private static final List<ClientInterceptor> defaultInterceptors =
      ImmutableList.of(
          new SpannerErrorInterceptor(),
          new LoggingInterceptor(Logger.getLogger(GapicSpannerRpc.class.getName()), Level.FINER));

  private final List<ClientInterceptor> clientInterceptors;

  private SpannerInterceptorProvider(List<ClientInterceptor> clientInterceptors) {
    this.clientInterceptors = clientInterceptors;
  }

  public static SpannerInterceptorProvider createDefault() {
    return new SpannerInterceptorProvider(defaultInterceptors);
  }

  public SpannerInterceptorProvider with(ClientInterceptor clientInterceptor) {
    List<ClientInterceptor> interceptors =
        ImmutableList.<ClientInterceptor>builder()
            .addAll(this.clientInterceptors)
            .add(clientInterceptor)
            .build();
    return new SpannerInterceptorProvider(interceptors);
  }

  @Override
  public List<ClientInterceptor> getInterceptors() {
    return clientInterceptors;
  }
}
