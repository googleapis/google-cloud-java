/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.gaxx.tracing;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.SpanName;

/**
 * Simple wrapper around {@link ApiTracerFactory} to augment the client name of the generated
 * traces.
 *
 * <p>This is used to disambiguate traces in underlying GAPIC client from the manually written
 * overlay.
 *
 * <p>For internal use, public for technical reasons.
 */
@InternalApi
public class WrappedTracerFactory implements ApiTracerFactory {
  private final ApiTracerFactory innerFactory;
  private final String clientName;

  public WrappedTracerFactory(ApiTracerFactory tracerFactory, String clientName) {
    this.innerFactory = tracerFactory;
    this.clientName = clientName;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    spanName = SpanName.of(clientName, spanName.getMethodName());

    return innerFactory.newTracer(parent, spanName, operationType);
  }
}
