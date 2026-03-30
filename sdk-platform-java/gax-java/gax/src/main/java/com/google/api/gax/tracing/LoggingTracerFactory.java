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

/** A {@link ApiTracerFactory} that creates instances of {@link LoggingTracer}. */
@BetaApi
@InternalApi
public class LoggingTracerFactory implements ApiTracerFactory {
  private final ApiTracerContext apiTracerContext;

  public LoggingTracerFactory() {
    this(ApiTracerContext.empty());
  }

  private LoggingTracerFactory(ApiTracerContext apiTracerContext) {
    this.apiTracerContext = apiTracerContext;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    return new LoggingTracer(apiTracerContext);
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, ApiTracerContext context) {
    return new LoggingTracer(apiTracerContext.merge(context));
  }

  @Override
  public ApiTracerContext getApiTracerContext() {
    return apiTracerContext;
  }

  @Override
  public ApiTracerFactory withContext(ApiTracerContext context) {
    return new LoggingTracerFactory(apiTracerContext.merge(context));
  }
}
