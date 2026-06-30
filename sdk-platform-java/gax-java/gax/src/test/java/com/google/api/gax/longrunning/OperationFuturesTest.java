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
package com.google.api.gax.longrunning;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.util.concurrent.MoreExecutors.directExecutor;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeOperationSnapshot;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class OperationFuturesTest {
  @Test
  void testNotDone() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            OperationFutures.immediateOperationFuture(
                FakeOperationSnapshot.newBuilder()
                    .setName("required")
                    .setDone(false)
                    .setErrorCode(FakeStatusCode.of(Code.OK))
                    .build()));
  }

  @Test
  void testCompleted() throws Exception {
    OperationFuture<String, Integer> future =
        OperationFutures.<String, Integer>immediateOperationFuture(
            FakeOperationSnapshot.newBuilder()
                .setName("myName")
                .setDone(true)
                .setResponse("theResponse")
                .setMetadata(42)
                .setErrorCode(FakeStatusCode.of(StatusCode.Code.OK))
                .build());
    assertThat(future.getName()).isEqualTo("myName");
    assertThat(future.get()).isEqualTo("theResponse");
    assertThat(future.getMetadata().get()).isEqualTo(42);
  }

  @Test
  void testFailed() throws Exception {
    OperationFuture<String, Integer> future =
        OperationFutures.<String, Integer>immediateOperationFuture(
            FakeOperationSnapshot.newBuilder()
                .setName("myName")
                .setDone(true)
                .setMetadata(42)
                .setErrorCode(FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT))
                .build());
    assertThat(future.getName()).isEqualTo("myName");
    assertThat(future.getMetadata().get()).isEqualTo(42);
    try {
      future.get();
      fail();
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(ApiException.class);
    }
  }

  @Test
  void testTransform() throws Exception {
    // Test dependencies.
    MockRetryingFuture<OperationSnapshot> pollingFuture = new MockRetryingFuture<>();
    SettableApiFuture<OperationSnapshot> initialFuture = SettableApiFuture.create();
    ApiFunction<OperationSnapshot, String> responseTransform =
        new ApiFunction<OperationSnapshot, String>() {
          @Override
          public String apply(OperationSnapshot operationSnapshot) {
            return (String) operationSnapshot.getResponse();
          }
        };
    ApiFunction<OperationSnapshot, Integer> metadataTransform =
        new ApiFunction<OperationSnapshot, Integer>() {
          @Override
          public Integer apply(OperationSnapshot operationSnapshot) {
            return (int) operationSnapshot.getMetadata();
          }
        };

    pollingFuture.set(
        FakeOperationSnapshot.newBuilder()
            .setName("my-name")
            .setDone(true)
            .setErrorCode(FakeStatusCode.of(Code.OK))
            .setResponse("response")
            .build());

    // Subject of the test.
    OperationFuture<String, Integer> future =
        new OperationFutureImpl<>(
            pollingFuture, initialFuture, responseTransform, metadataTransform);

    // Actual test: make sure that ApiFutures can chain off the result.
    ApiFuture<String> transformedFuture =
        ApiFutures.transform(
            future,
            new ApiFunction<String, String>() {
              @Override
              public String apply(String s) {
                return "transformed: " + s;
              }
            },
            directExecutor());

    assertThat(transformedFuture.get(1, TimeUnit.SECONDS)).isEqualTo("transformed: response");
  }

  private static class MockRetryingFuture<ResponseT> extends AbstractApiFuture<ResponseT>
      implements RetryingFuture<ResponseT> {
    public boolean set(ResponseT value) {
      return super.set(value);
    }

    @Override
    public void setAttemptFuture(ApiFuture<ResponseT> attemptFuture) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Callable<ResponseT> getCallable() {
      throw new UnsupportedOperationException();
    }

    @Override
    public TimedAttemptSettings getAttemptSettings() {
      throw new UnsupportedOperationException();
    }

    @Override
    public ApiFuture<ResponseT> peekAttemptResult() {
      throw new UnsupportedOperationException();
    }

    @Override
    public ApiFuture<ResponseT> getAttemptResult() {
      throw new UnsupportedOperationException();
    }
  }
}
