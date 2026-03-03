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
import java.util.Map;

/**
 * Provides an interface for metrics recording. The implementer is expected to use an observability
 * framework, e.g. OpenTelemetry. There should be only one instance of MetricsRecorder per client,
 * all the methods in this class are expected to be called from multiple threads, hence the
 * implementation must be thread safe.
 */
@BetaApi
@InternalApi
public interface MetricsRecorder {

  /** Records the latency of an RPC attempt */
  default void recordAttemptLatency(double attemptLatency, Map<String, String> attributes) {}

  /** Records the count of RPC attempts */
  default void recordAttemptCount(long count, Map<String, String> attributes) {}

  /**
   * Records the total end-to-end latency for an operation, including the initial RPC attempts and
   * subsequent retries.
   */
  default void recordOperationLatency(double operationLatency, Map<String, String> attributes) {}

  /** Records the count of operations */
  default void recordOperationCount(long count, Map<String, String> attributes) {}
}
