/*
 * Copyright 2021 Google LLC
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
package com.google.api.gax.rpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Sets;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ApiResultRetryAlgorithmTest {

  @Test
  void testShouldRetryNoContext() {
    ApiException nonRetryable =
        new ApiException(null, new FakeStatusCode(Code.INTERNAL), /* retryable= */ false);
    ApiException retryable =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertFalse(algorithm.shouldRetry(nonRetryable, null));
    assertTrue(algorithm.shouldRetry(retryable, null));
  }

  @Test
  void testShouldRetryWithContextWithoutRetryableCodes() {
    ApiCallContext context = mock(ApiCallContext.class);
    // No retryable codes in the call context, means that the retry algorithm should fall back to
    // its default implementation.
    when(context.getRetryableCodes()).thenReturn(null);

    ApiException nonRetryable =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ false);
    ApiException retryable =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertFalse(algorithm.shouldRetry(context, nonRetryable, null));
    assertTrue(algorithm.shouldRetry(context, retryable, null));
  }

  @Test
  void testShouldRetryWithContextWithRetryableCodes() {
    ApiCallContext context = mock(ApiCallContext.class);
    when(context.getRetryableCodes())
        .thenReturn(
            Sets.newHashSet(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE));

    StatusCode unavailable = mock(StatusCode.class);
    when(unavailable.getCode()).thenReturn(Code.UNAVAILABLE);
    StatusCode dataLoss = mock(StatusCode.class);
    when(dataLoss.getCode()).thenReturn(Code.DATA_LOSS);

    // The return value of isRetryable() will be ignored, as UNAVAILABLE has been added as a
    // retryable code to the call context.
    ApiException unavailableException =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ false);
    ApiException dataLossException =
        new ApiException(null, new FakeStatusCode(Code.DATA_LOSS), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertTrue(algorithm.shouldRetry(context, unavailableException, null));
    assertFalse(algorithm.shouldRetry(context, dataLossException, null));
  }

  @Test
  void testShouldRetryWithContextWithEmptyRetryableCodes() {
    ApiCallContext context = mock(ApiCallContext.class);
    // This will effectively make the RPC non-retryable.
    when(context.getRetryableCodes()).thenReturn(Collections.<Code>emptySet());

    ApiException unavailableException =
        new ApiException(null, new FakeStatusCode(Code.UNAVAILABLE), /* retryable= */ true);

    ApiResultRetryAlgorithm<String> algorithm = new ApiResultRetryAlgorithm<>();
    assertFalse(algorithm.shouldRetry(context, unavailableException, null));
  }
}
