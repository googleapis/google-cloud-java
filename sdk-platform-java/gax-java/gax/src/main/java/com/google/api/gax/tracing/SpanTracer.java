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
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link ApiTracer} that uses a {@link TraceManager} to record traces. This
 * implementation is agnostic to the specific {@link TraceManager} in order to allow extensions that
 * interact with other backends.
 */
@BetaApi
@InternalApi
public class SpanTracer implements ApiTracer {
  public static final String LANGUAGE_ATTRIBUTE = "gcp.client.language";

  public static final String DEFAULT_LANGUAGE = "Java";

  private final TraceManager traceManager;
  private final Map<String, String> attemptAttributes;
  private final String attemptSpanName;
  private final ApiTracerContext apiTracerContext;
  private TraceManager.Span attemptHandle;

  /**
   * Creates a new instance of {@code SpanTracer}.
   *
   * @param traceManager the {@link TraceManager} to use for recording spans
   * @param attemptSpanName the name of the individual attempt spans
   */
  public SpanTracer(
      TraceManager traceManager, ApiTracerContext apiTracerContext, String attemptSpanName) {
    this.traceManager = traceManager;
    this.attemptSpanName = attemptSpanName;
    this.apiTracerContext = apiTracerContext;
    this.attemptAttributes = new HashMap<>();
    buildAttributes();
  }

  private void buildAttributes() {
    this.attemptAttributes.put(LANGUAGE_ATTRIBUTE, DEFAULT_LANGUAGE);
    this.attemptAttributes.putAll(this.apiTracerContext.getAttemptAttributes());
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    Map<String, String> attemptAttributes = new HashMap<>(this.attemptAttributes);
    // Start the specific attempt span with the operation span as parent
    this.attemptHandle = traceManager.createSpan(attemptSpanName, attemptAttributes);
  }

  @Override
  public void attemptSucceeded() {
    endAttempt();
  }

  private void endAttempt() {
    if (attemptHandle != null) {
      attemptHandle.end();
      attemptHandle = null;
    }
  }
}
