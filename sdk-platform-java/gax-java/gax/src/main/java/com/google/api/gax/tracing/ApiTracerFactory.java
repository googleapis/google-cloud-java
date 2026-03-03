/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;

/**
 * A factory to create new instances of {@link ApiTracer}s.
 *
 * <p>In general a single instance of an {@link ApiTracer} will correspond to a single logical
 * operation.
 *
 * <p>For internal use only. google-cloud-java libraries should extend {@link BaseApiTracerFactory}.
 */
@InternalApi
@InternalExtensionOnly
public interface ApiTracerFactory {
  /** The type of operation the {@link ApiTracer} is tracing. */
  enum OperationType {
    Unary,
    Batching,
    LongRunning,
    ServerStreaming,
    ClientStreaming,
    BidiStreaming
  }

  /**
   * Create a new {@link ApiTracer} that will be a child of the current context.
   *
   * @param parent the parent of this tracer
   * @param spanName the name of the new span
   * @param operationType the type of operation that the tracer will trace
   */
  ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType);

  /**
   * Returns a new {@link ApiTracerFactory} that will use the provided context to infer attributes
   * for all tracers created by the factory.
   *
   * @param context an {@link ApiTracerContext} object containing information to construct
   *     attributes
   */
  default ApiTracerFactory withContext(ApiTracerContext context) {
    return this;
  }
}
