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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;

/**
 * A {@link ApiTracerFactory} to build instances of {@link SpanTracer}.
 *
 * <p>This class wraps the {@link TraceManager} and pass it to {@link SpanTracer}. It will be used
 * to record traces in {@link SpanTracer}.
 *
 * <p>This class is expected to be initialized once during client initialization.
 */
@BetaApi
@InternalApi
public class SpanTracerFactory implements ApiTracerFactory {
  private final TraceManager traceManager;

  private final ApiTracerContext apiTracerContext;

  /** Creates a SpanTracerFactory */
  public SpanTracerFactory(TraceManager traceManager) {
    this(traceManager, ApiTracerContext.empty());
  }

  /**
   * Pass in a Map of client level attributes which will be added to every single SpanTracer created
   * from the ApiTracerFactory. This is package private since span attributes are determined
   * internally.
   */
  @VisibleForTesting
  SpanTracerFactory(TraceManager traceManager, ApiTracerContext apiTracerContext) {
    this.traceManager = traceManager;
    this.apiTracerContext = apiTracerContext;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    // TODO(diegomarquezp): this is a placeholder for span names and will be adjusted as the
    // feature is developed.
    String attemptSpanName = spanName.getClientName() + "/" + spanName.getMethodName() + "/attempt";

    SpanTracer spanTracer = new SpanTracer(traceManager, this.apiTracerContext, attemptSpanName);
    return spanTracer;
  }

  @Override
  public ApiTracerFactory withContext(ApiTracerContext context) {
    return new SpanTracerFactory(traceManager, context);
  }
}
