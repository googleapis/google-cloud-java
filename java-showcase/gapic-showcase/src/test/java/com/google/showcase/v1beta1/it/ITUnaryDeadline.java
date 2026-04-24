/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableSet;
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.threeten.bp.Duration;

/**
 * For this test, we test a combination of various RetrySettings to try and ensure that the timeouts
 * set by the customer are cancelled when timeouts have exceeded their limits
 *
 * <p>Each test attempts to get the number of attempts done in each call. The attemptCount is
 * incremented by 1 as the first attempt is zero indexed.
 */
class ITUnaryDeadline {

  @Test
  void testGRPC_unarySuccessfulResponse_doesNotExceedTotalTimeout() throws Exception {
    RetrySettings defaultNoRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(5000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(5000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            // Explicitly set retries as disabled (maxAttempts == 1)
            .setMaxAttempts(1)
            .build();
    EchoClient grpcClient =
        TestClientInitializer.createGrpcEchoClientCustomBlockSettings(
            defaultNoRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(BlockResponse.newBuilder().setContent("gRPCBlockContent_3sDelay_noRetry"))
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(3).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) grpcClient.blockCallable().futureCall(blockRequest);
      BlockResponse blockResponse = retryingFuture.get(10, TimeUnit.SECONDS);
      assertThat(blockResponse.getContent()).isEqualTo("gRPCBlockContent_3sDelay_noRetry");
      // Guarantee that this only runs once
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isEqualTo(1);
    } finally {
      grpcClient.close();
      grpcClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testHttpJson_unarySuccessfulResponse_doesNotExceedTotalTimeout() throws Exception {
    RetrySettings defaultNoRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(5000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(5000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            // Explicitly set retries as disabled (maxAttempts == 1)
            .setMaxAttempts(1)
            .build();
    EchoClient httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientCustomBlockSettings(
            defaultNoRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(
                  BlockResponse.newBuilder().setContent("httpjsonBlockContent_3sDelay_noRetry"))
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(3).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) httpjsonClient.blockCallable().futureCall(blockRequest);
      BlockResponse blockResponse = retryingFuture.get(10, TimeUnit.SECONDS);
      assertThat(blockResponse.getContent()).isEqualTo("httpjsonBlockContent_3sDelay_noRetry");
      // Guarantee that this only runs once
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isEqualTo(1);
    } finally {
      httpjsonClient.close();
      httpjsonClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // Retry is configured by setting the initial RPC timeout (1.5s) to be less than
  // the RPC delay (2s). The next RPC timeout (3s) will wait long enough for the delay.
  @Test
  void testGRPC_unarySuccessfulResponse_exceedsRPCDeadlineButWithinTotalTimeout() throws Exception {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(1500L))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeout(Duration.ofMillis(3000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            .build();
    EchoClient grpcClient =
        TestClientInitializer.createGrpcEchoClientCustomBlockSettings(
            defaultRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(BlockResponse.newBuilder().setContent("gRPCBlockContent_2sDelay_Retry"))
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(2).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) grpcClient.blockCallable().futureCall(blockRequest);
      BlockResponse blockResponse = retryingFuture.get(10, TimeUnit.SECONDS);
      assertThat(blockResponse.getContent()).isEqualTo("gRPCBlockContent_2sDelay_Retry");
      // Guarantee that this only runs twice
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isEqualTo(2);
    } finally {
      grpcClient.close();
      grpcClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // Retry is configured by setting the initial RPC timeout (1.5s) to be less than
  // the RPC delay (2s). The next RPC timeout (3s) will wait long enough for the delay.
  @Test
  void testHttpJson_unarySuccessfulResponse_exceedsRPCDeadlineButWithinTotalTimeout()
      throws Exception {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(1500L))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeout(Duration.ofMillis(3000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            .build();
    EchoClient httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientCustomBlockSettings(
            defaultRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(
                  BlockResponse.newBuilder().setContent("httpjsonBlockContent_2sDelay_Retry"))
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(2).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) httpjsonClient.blockCallable().futureCall(blockRequest);
      BlockResponse blockResponse = retryingFuture.get(10, TimeUnit.SECONDS);
      assertThat(blockResponse.getContent()).isEqualTo("httpjsonBlockContent_2sDelay_Retry");
      // Guarantee that this only runs twice
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isEqualTo(2);
    } finally {
      httpjsonClient.close();
      httpjsonClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // Request is set to block for 6 seconds to allow the RPC to timeout. If retries are
  // disabled, the RPC timeout is set to be the totalTimeout (5s).
  @Test
  void
      testGRPC_unaryUnsuccessfulResponse_exceedsRPCTimeoutAndTotalTimeout_throwsDeadlineExceededException()
          throws Exception {
    RetrySettings defaultNoRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(5000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(5000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            // Explicitly set retries as disabled (maxAttempts == 1)
            .setMaxAttempts(1)
            .build();
    EchoClient grpcClient =
        TestClientInitializer.createGrpcEchoClientCustomBlockSettings(
            defaultNoRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(BlockResponse.newBuilder().setContent("gRPCBlockContent_6sDelay_noRetry"))
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(6).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) grpcClient.blockCallable().futureCall(blockRequest);
      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
      DeadlineExceededException deadlineExceededException =
          (DeadlineExceededException) exception.getCause();
      assertThat(deadlineExceededException.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
      // We can guarantee that this only runs once
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isEqualTo(1);
    } finally {
      grpcClient.close();
      grpcClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // Request is set to block for 6 seconds to allow the RPC to timeout. If retries are
  // disabled, the RPC timeout is set to be the totalTimeout (5s).
  @Test
  void
      testHttpJson_unaryUnsuccessfulResponse_exceedsRPCTimeoutAndTotalTimeout_throwsDeadlineExceededException()
          throws Exception {
    RetrySettings defaultNoRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(5000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(5000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            // Explicitly set retries as disabled (maxAttempts == 1)
            .setMaxAttempts(1)
            .build();
    EchoClient httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientCustomBlockSettings(
            defaultNoRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(
                  BlockResponse.newBuilder().setContent("httpjsonBlockContent_6sDelay_noRetry"))
              .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(6).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) httpjsonClient.blockCallable().futureCall(blockRequest);
      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
      DeadlineExceededException deadlineExceededException =
          (DeadlineExceededException) exception.getCause();
      assertThat(deadlineExceededException.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
      // We can guarantee that this only runs once
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isEqualTo(1);
    } finally {
      httpjsonClient.close();
      httpjsonClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // The purpose of this test is to ensure that the deadlineScheduleExecutor is able
  // to properly cancel the HttpRequest for each retry attempt. This test attempts to
  // make a call every 100ms for 1 second. If the requestRunnable blocks until we
  // receive a response from the server (200ms) regardless of it was cancelled, then
  // we would expect at most 50 responses.
  @Test
  void testGRPC_unaryCallableRetry_deadlineExecutorTimesOutRequest_throwsDeadlineExceededException()
      throws Exception {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(100L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(100L))
            .setTotalTimeout(Duration.ofMillis(1000L))
            .build();
    EchoClient grpcClient =
        TestClientInitializer.createGrpcEchoClientCustomBlockSettings(
            defaultRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(
                  BlockResponse.newBuilder().setContent("gRPCBlockContent_200msDelay_Retry"))
              // Set the timeout to be longer than the RPC timeout
              .setResponseDelay(
                  com.google.protobuf.Duration.newBuilder().setNanos(200000000).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) grpcClient.blockCallable().futureCall(blockRequest);
      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
      DeadlineExceededException deadlineExceededException =
          (DeadlineExceededException) exception.getCause();
      assertThat(deadlineExceededException.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
      // We cannot guarantee the number of attempts. The RetrySettings should be configured
      // such that there is no delay between the attempts, but the execution takes time
      // to run. Theoretically this should run exactly 100 times.
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isGreaterThan(5);
      assertThat(attemptCount).isAtMost(10);
    } finally {
      grpcClient.close();
      grpcClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // The purpose of this test is to ensure that the deadlineScheduleExecutor is able
  // to properly cancel the HttpRequest for each retry attempt. This test attempts to
  // make a call every 100ms for 1 second. If the requestRunnable blocks until we
  // receive a response from the server (200ms) regardless of it was cancelled, then
  // we would expect at most 50 responses.
  @Test
  void
      testHttpJson_unaryCallableRetry_deadlineExecutorTimesOutRequest_throwsDeadlineExceededException()
          throws Exception {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(100L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(100L))
            .setTotalTimeout(Duration.ofMillis(10000L))
            .build();
    EchoClient httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientCustomBlockSettings(
            defaultRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
    try {
      BlockRequest blockRequest =
          BlockRequest.newBuilder()
              .setSuccess(
                  BlockResponse.newBuilder().setContent("httpjsonBlockContent_200msDelay_Retry"))
              // Set the timeout to be longer than the RPC timeout
              .setResponseDelay(
                  com.google.protobuf.Duration.newBuilder().setNanos(200000000).build())
              .build();
      RetryingFuture<BlockResponse> retryingFuture =
          (RetryingFuture<BlockResponse>) httpjsonClient.blockCallable().futureCall(blockRequest);
      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> retryingFuture.get(15, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
      DeadlineExceededException deadlineExceededException =
          (DeadlineExceededException) exception.getCause();
      assertThat(deadlineExceededException.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
      // We cannot guarantee the number of attempts. The RetrySettings should be configured
      // such that there is no delay between the attempts, but the execution takes time
      // to run. Theoretically this should run exactly 100 times.
      int attemptCount = retryingFuture.getAttemptSettings().getAttemptCount() + 1;
      assertThat(attemptCount).isGreaterThan(80);
      assertThat(attemptCount).isAtMost(100);
    } finally {
      httpjsonClient.close();
      httpjsonClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }
}
