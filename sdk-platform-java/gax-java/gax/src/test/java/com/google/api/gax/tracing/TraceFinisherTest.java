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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TraceFinisherTest {
  @Mock private ApiTracer mockTracer;

  @Test
  void testSuccess() {
    ApiFuture<String> future = ApiFutures.immediateFuture("result");
    ApiFutures.addCallback(
        future, new TraceFinisher<String>(mockTracer), MoreExecutors.directExecutor());

    verify(mockTracer, times(1)).operationSucceeded();
  }

  @Test
  void testCancellation() {
    ApiFuture<String> future = ApiFutures.immediateCancelledFuture();
    ApiFutures.addCallback(
        future, new TraceFinisher<String>(mockTracer), MoreExecutors.directExecutor());

    verify(mockTracer, times(1)).operationCancelled();
  }

  @Test
  void testFailure() {
    RuntimeException expectedError = new RuntimeException("fake");
    ApiFuture<String> future = ApiFutures.immediateFailedFuture(expectedError);
    ApiFutures.addCallback(
        future, new TraceFinisher<String>(mockTracer), MoreExecutors.directExecutor());

    verify(mockTracer, times(1)).operationFailed(expectedError);
  }
}
