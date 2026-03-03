/*
 * Copyright 2024 Google LLC
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
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/**
 * A {@link ApiTracerFactory} to build instances of {@link MetricsTracer}.
 *
 * <p>This class wraps the {@link MetricsRecorder} and pass it to {@link MetricsTracer}. It will be
 * used to record metrics in {@link MetricsTracer}.
 *
 * <p>This class is expected to be initialized once during client initialization.
 */
@BetaApi
@InternalApi
public class MetricsTracerFactory implements ApiTracerFactory {
  protected MetricsRecorder metricsRecorder;

  /** Mapping of client attributes that are set for every MetricsTracer */
  private final Map<String, String> attributes;

  /** Creates a MetricsTracerFactory with no additional client level attributes. */
  public MetricsTracerFactory(MetricsRecorder metricsRecorder) {
    this(metricsRecorder, ImmutableMap.of());
  }

  /**
   * Pass in a Map of client level attributes which will be added to every single MetricsTracer
   * created from the ApiTracerFactory.
   */
  public MetricsTracerFactory(MetricsRecorder metricsRecorder, Map<String, String> attributes) {
    this.metricsRecorder = metricsRecorder;
    this.attributes = ImmutableMap.copyOf(attributes);
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    MetricsTracer metricsTracer =
        new MetricsTracer(
            MethodName.of(spanName.getClientName(), spanName.getMethodName()), metricsRecorder);
    attributes.forEach(metricsTracer::addAttributes);
    return metricsTracer;
  }
}
