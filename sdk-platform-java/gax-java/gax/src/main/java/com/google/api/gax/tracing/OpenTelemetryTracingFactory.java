/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.tracing;

import com.google.api.client.util.Strings;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.common.annotations.VisibleForTesting;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;

/**
 * A {@link ApiTracerFactory} to build instances of {@link OpenTelemetryTracingTracer}.
 *
 * <p>This class wraps the {@link Tracer} and pass it to {@link OpenTelemetryTracingTracer}. It will
 * be used to record traces in {@link OpenTelemetryTracingTracer}.
 *
 * <p>This class is expected to be initialized once during client initialization.
 */
public class OpenTelemetryTracingFactory implements ApiTracerFactory {
  private final Tracer tracer;
  private final OpenTelemetry openTelemetry;
  private final ApiTracerContext apiTracerContext;

  /**
   * Warning: Traces may contain sensitive data such as resource names, full URLs, and error
   * messages.
   *
   * <p>Before configuring subscribers or exporters for traces, review the contents of the spans and
   * consult the <a href="https://opentelemetry.io/docs/security/handling-sensitive-data/">
   * OpenTelemetry documentation</a> to set up filters and formatters to prevent leaking sensitive
   * information, depending on your intended use case.
   *
   * <p>See also the <a href="https://opentelemetry.io/docs/concepts/semantic-conventions/">
   * OpenTelemetry Semantic Conventions</a>.
   */
  public OpenTelemetryTracingFactory(OpenTelemetry openTelemetry) {
    this(openTelemetry, null, ApiTracerContext.empty());
  }

  /**
   * Pass in a Map of client level attributes which will be added to every single
   * OpenTelemetryTracingTracer created from the ApiTracerFactory. This is package private since
   * span attributes are determined internally.
   */
  @VisibleForTesting
  OpenTelemetryTracingFactory(
      OpenTelemetry openTelemetry, Tracer tracer, ApiTracerContext apiTracerContext) {
    this.openTelemetry = openTelemetry;
    this.tracer = tracer;
    this.apiTracerContext = apiTracerContext;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    if (tracer == null) {
      // Return a no-op tracer if withContext hasn't been called to initialize the tracer properly
      return new BaseApiTracer();
    }
    // TODO(diegomarquezp): this is a placeholder for span names and will be adjusted as the
    // feature is developed.
    String attemptSpanName = spanName.getClientName() + "/" + spanName.getMethodName() + "/attempt";

    return new OpenTelemetryTracingTracer(tracer, this.apiTracerContext, attemptSpanName);
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, ApiTracerContext apiTracerContext) {
    if (tracer == null) {
      // Return a no-op tracer if withContext hasn't been called to initialize the tracer properly
      return new BaseApiTracer();
    }
    ApiTracerContext mergedContext = this.apiTracerContext.merge(apiTracerContext);
    return new OpenTelemetryTracingTracer(tracer, mergedContext);
  }

  @Override
  public boolean needsContext() {
    return apiTracerContext == null || apiTracerContext.equals(ApiTracerContext.empty());
  }

  /**
   * Returns a new OpenTelemetryTracingFactory with the provided context. The Tracer is
   * re-initialized using the artifact name and version from the library metadata.
   */
  @Override
  public ApiTracerFactory withContext(ApiTracerContext context) {
    if (context == null) {
      return new BaseApiTracerFactory();
    }
    LibraryMetadata metadata = context.libraryMetadata();
    if (metadata == null || metadata.isEmpty() || Strings.isNullOrEmpty(metadata.artifactName())) {
      return new BaseApiTracerFactory();
    }
    Tracer newTracer = openTelemetry.getTracer(metadata.artifactName(), metadata.version());
    ApiTracerContext mergedContext = this.apiTracerContext.merge(context);
    return new OpenTelemetryTracingFactory(openTelemetry, newTracer, mergedContext);
  }
}
