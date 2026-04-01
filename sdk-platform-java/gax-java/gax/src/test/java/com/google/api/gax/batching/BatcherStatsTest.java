/*
 * Copyright 2019 Google LLC
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
package com.google.api.gax.batching;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class BatcherStatsTest {

  @Test
  void testWhenNoException() {
    BatcherStats batcherStats = new BatcherStats();
    assertThat(batcherStats.asException()).isNull();
  }

  @Test
  void testRequestFailuresOnly() {
    BatcherStats batcherStats = new BatcherStats();

    batcherStats.recordBatchFailure(
        ApiExceptionFactory.createException(
            "fake api error",
            new RuntimeException(),
            FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT),
            false));

    batcherStats.recordBatchFailure(new RuntimeException("Request failed"));

    BatchingException exception = batcherStats.asException();
    assertThat(exception).isNotNull();
    assertThat(exception).hasMessageThat().contains("2 batches failed to apply");
    assertThat(exception).hasMessageThat().contains("1 RuntimeException");
    assertThat(exception).hasMessageThat().contains("1 ApiException(1 INVALID_ARGUMENT)");
    assertThat(exception).hasMessageThat().contains("and 0 partial failures.");
    assertThat(exception)
        .hasMessageThat()
        .contains(
            "com.google.api.gax.rpc.InvalidArgumentException: fake api error, java.lang.RuntimeException: Request failed.");
  }

  @Test
  void testEntryFailureOnly() {
    BatcherStats batcherStats = new BatcherStats();

    SettableApiFuture<Integer> batchOneResult = SettableApiFuture.create();
    batchOneResult.setException(new IllegalStateException("local element failure"));
    batcherStats.recordBatchElementsCompletion(
        ImmutableList.of(BatchEntry.create(1, batchOneResult)));

    SettableApiFuture<Integer> batchTwoResult = SettableApiFuture.create();
    batchTwoResult.setException(
        ApiExceptionFactory.createException(
            "fake entry error",
            new RuntimeException(),
            FakeStatusCode.of(StatusCode.Code.UNAVAILABLE),
            false));
    batcherStats.recordBatchElementsCompletion(
        ImmutableList.of(BatchEntry.create(2, batchTwoResult)));

    BatchingException ex = batcherStats.asException();
    assertThat(ex)
        .hasMessageThat()
        .contains("The 2 partial failures contained 2 entries that failed with:");
    assertThat(ex).hasMessageThat().contains("1 ApiException(1 UNAVAILABLE)");
    assertThat(ex).hasMessageThat().contains("1 IllegalStateException");
    assertThat(ex)
        .hasMessageThat()
        .contains(
            "Sample of entry errors: java.lang.IllegalStateException: local element failure, com.google.api.gax.rpc.UnavailableException: fake entry error.");
  }

  @Test
  void testRequestAndEntryFailures() {
    BatcherStats batcherStats = new BatcherStats();

    batcherStats.recordBatchFailure(new RuntimeException("Batch failure"));

    SettableApiFuture<Integer> future = SettableApiFuture.create();
    future.setException(
        ApiExceptionFactory.createException(
            new RuntimeException(), FakeStatusCode.of(StatusCode.Code.ALREADY_EXISTS), false));

    batcherStats.recordBatchElementsCompletion(ImmutableList.of(BatchEntry.create(1, future)));

    BatchingException ex = batcherStats.asException();
    assertThat(ex)
        .hasMessageThat()
        .contains(
            "Batching finished with 1 batches failed to apply due to: 1 RuntimeException and 1 "
                + "partial failures. The 1 partial failures contained 1 entries that failed with:"
                + " 1 ApiException(1 ALREADY_EXISTS)."
                + " Sample of RPC errors: java.lang.RuntimeException: Batch failure."
                + " Sample of entry errors: com.google.api.gax.rpc.AlreadyExistsException: java.lang.RuntimeException.");
  }
}
