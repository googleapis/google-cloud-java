/*
 * Copyright 2026 Google LLC
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

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.AttemptSequenceRequest;
import com.google.showcase.v1beta1.CreateSequenceRequest;
import com.google.showcase.v1beta1.GetSequenceReportRequest;
import com.google.showcase.v1beta1.Sequence;
import com.google.showcase.v1beta1.SequenceReport;
import com.google.showcase.v1beta1.SequenceServiceClient;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Integration tests for verifying that client libraries correctly handle retry behaviors and
 * timeout settings over gRPC and HTTP/JSON transports.
 */
class ITRetries {

  private static final Sequence STANDARD_SEQUENCE =
      Sequence.newBuilder()
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                  .build())
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                  .build())
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                  .build())
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                  .build())
          .build();

  @SuppressWarnings("deprecation")
  private static final RetrySettings STANDARD_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofMillis(100L))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelayDuration(Duration.ofMillis(1000L))
          .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
          .setTotalTimeoutDuration(Duration.ofMillis(5000L))
          .setMaxAttempts(4)
          .setJittered(false)
          .build();

  @SuppressWarnings("deprecation")
  private static final RetrySettings NO_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofMillis(100L))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelayDuration(Duration.ofMillis(1000L))
          .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
          .setTotalTimeoutDuration(Duration.ofMillis(5000L))
          .setMaxAttempts(1)
          .setJittered(false)
          .build();

  private static SequenceServiceClient grpcClient;
  private static SequenceServiceClient httpjsonClient;

  @BeforeAll
  static void createClients() throws Exception {
    grpcClient = TestClientInitializer.createGrpcSequenceClient();
    httpjsonClient = TestClientInitializer.createHttpJsonSequenceClient();
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  // Tests that the client retries on UNAVAILABLE errors up to maxAttempts (4) and succeeds when
  // receiving OK.
  @Test
  void testGrpc_retryExponentialBackoff() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      TestResult result = runAttempt(grpcClient, retryClient, STANDARD_SEQUENCE, 4);

      assertThat(result.exception).isNull();
      verifySequenceReport(result.report);
    }
  }

  // Tests that the client retries on UNAVAILABLE errors up to maxAttempts (4) and succeeds when
  // receiving OK.
  @Test
  void testHttpJson_retryExponentialBackoff() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      TestResult result = runAttempt(httpjsonClient, retryClient, STANDARD_SEQUENCE, 4);

      assertThat(result.exception).isNull();
      verifySequenceReport(result.report);
    }
  }

  // Tests that configuring maxAttempts = 1 causes the client to fail immediately on the first error
  // without retrying.
  @Test
  void testGrpc_noRetry() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            NO_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence sequence = buildSequence(Code.UNAVAILABLE, Code.OK);

      TestResult result = runAttempt(grpcClient, retryClient, sequence, 1);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
      assertThat(result.report.getAttempts(0).getStatus().getCode())
          .isEqualTo(Code.UNAVAILABLE.getNumber());
    }
  }

  // Tests that configuring maxAttempts = 1 causes the client to fail immediately on the first error
  // without retrying.
  @Test
  void testHttpJson_noRetry() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            NO_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence sequence = buildSequence(Code.UNAVAILABLE, Code.OK);

      TestResult result = runAttempt(httpjsonClient, retryClient, sequence, 1);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
      assertThat(result.report.getAttempts(0).getStatus().getCode())
          .isEqualTo(Code.UNAVAILABLE.getNumber());
    }
  }

  // Tests that encountering a non-retryable error (INVALID_ARGUMENT) stops retries immediately,
  // even if maxAttempts > 1.
  @Test
  void testGrpc_nonRetryableError() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence sequence = buildSequence(Code.INVALID_ARGUMENT, Code.OK);

      TestResult result = runAttempt(grpcClient, retryClient, sequence, 1);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
      assertThat(result.report.getAttempts(0).getStatus().getCode())
          .isEqualTo(Code.INVALID_ARGUMENT.getNumber());
    }
  }

  // Tests that encountering a non-retryable error (INVALID_ARGUMENT) stops retries immediately,
  // even if maxAttempts > 1.
  @Test
  void testHttpJson_nonRetryableError() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence sequence = buildSequence(Code.INVALID_ARGUMENT, Code.OK);

      TestResult result = runAttempt(httpjsonClient, retryClient, sequence, 1);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
      assertThat(result.report.getAttempts(0).getStatus().getCode())
          .isEqualTo(Code.INVALID_ARGUMENT.getNumber());
    }
  }

  // Tests that the client retries through a sequence of different retryable status codes
  // (UNAVAILABLE -> RESOURCE_EXHAUSTED -> DEADLINE_EXCEEDED).
  @Test
  void testGrpc_retryMultipleStatus() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS,
            ImmutableSet.of(
                StatusCode.Code.UNAVAILABLE,
                StatusCode.Code.RESOURCE_EXHAUSTED,
                StatusCode.Code.DEADLINE_EXCEEDED))) {

      Sequence sequence =
          buildSequence(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED, Code.DEADLINE_EXCEEDED, Code.OK);

      TestResult result = runAttempt(grpcClient, retryClient, sequence, 4);

      assertThat(result.exception).isNull();
      List<SequenceReport.Attempt> attempts = result.report.getAttemptsList();
      assertThat(attempts.get(0).getStatus().getCode()).isEqualTo(Code.UNAVAILABLE.getNumber());
      assertThat(attempts.get(1).getStatus().getCode())
          .isEqualTo(Code.RESOURCE_EXHAUSTED.getNumber());
      assertThat(attempts.get(2).getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());
      assertThat(attempts.get(3).getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    }
  }

  // Tests that the client retries through a sequence of different retryable status codes
  // (UNAVAILABLE -> RESOURCE_EXHAUSTED -> DEADLINE_EXCEEDED).
  @Test
  void testHttpJson_retryMultipleStatus() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS,
            ImmutableSet.of(
                StatusCode.Code.UNAVAILABLE,
                StatusCode.Code.RESOURCE_EXHAUSTED,
                StatusCode.Code.DEADLINE_EXCEEDED))) {

      Sequence sequence =
          buildSequence(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED, Code.DEADLINE_EXCEEDED, Code.OK);

      TestResult result = runAttempt(httpjsonClient, retryClient, sequence, 4);

      assertThat(result.exception).isNull();
      List<SequenceReport.Attempt> attempts = result.report.getAttemptsList();
      assertThat(attempts.get(0).getStatus().getCode()).isEqualTo(Code.UNAVAILABLE.getNumber());
      assertThat(attempts.get(1).getStatus().getCode())
          .isEqualTo(Code.RESOURCE_EXHAUSTED.getNumber());
      assertThat(attempts.get(2).getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());
      assertThat(attempts.get(3).getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    }
  }

  // Tests that individual attempt timeouts (rpcTimeout) trigger a retry when the server response
  // delay exceeds the timeout.
  @Test
  void testGrpc_retryOnRpcTimeoutExceeded() throws Exception {
    RetrySettings timeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(10L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(100L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(100L))
            .setTotalTimeoutDuration(Duration.ofMillis(10000L))
            .setMaxAttempts(10)
            .setJittered(false)
            .build();

    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            timeoutRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED))) {

      Sequence.Builder sequenceBuilder = Sequence.newBuilder();
      for (int i = 0; i < 10; i++) {
        sequenceBuilder.addResponses(
            Sequence.Response.newBuilder()
                .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                .setDelay(Durations.fromMillis(200L))
                .build());
      }

      TestResult result = runAttempt(grpcClient, retryClient, sequenceBuilder.build(), 10);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
      for (int i = 0; i < 10; i++) {
        assertThat(result.report.getAttempts(i).getStatus().getCode())
            .isIn(ImmutableSet.of(Code.OK.getNumber(), Code.DEADLINE_EXCEEDED.getNumber()));
      }
    }
  }

  // Tests that individual attempt timeouts (rpcTimeout) trigger a retry when the server response
  // delay exceeds the timeout.
  @Test
  void testHttpJson_retryOnRpcTimeoutExceeded() throws Exception {
    RetrySettings timeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(10L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(100L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(100L))
            .setTotalTimeoutDuration(Duration.ofMillis(10000L))
            .setMaxAttempts(10)
            .setJittered(false)
            .build();

    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            timeoutRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED))) {

      Sequence.Builder sequenceBuilder = Sequence.newBuilder();
      for (int i = 0; i < 10; i++) {
        sequenceBuilder.addResponses(
            Sequence.Response.newBuilder()
                .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                .setDelay(Durations.fromMillis(200L))
                .build());
      }

      TestResult result = runAttempt(httpjsonClient, retryClient, sequenceBuilder.build(), 10);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
      for (int i = 0; i < 10; i++) {
        assertThat(result.report.getAttempts(i).getStatus().getCode())
            .isIn(ImmutableSet.of(Code.OK.getNumber(), Code.DEADLINE_EXCEEDED.getNumber()));
      }
    }
  }

  // Tests that the operation deadline (totalTimeout) halts the retry loop when cumulative delay
  // exceeds totalTimeout.
  @Test
  void testGrpc_retryTotalTimeoutExceeded() throws Exception {
    RetrySettings totalTimeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(100L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(100L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(2000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(2000L))
            .setTotalTimeoutDuration(Duration.ofMillis(1500L))
            .setMaxAttempts(10)
            .setJittered(false)
            .build();

    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            totalTimeoutRetrySettings, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence sequence =
          Sequence.newBuilder()
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                      .setDelay(Durations.fromSeconds(1L))
                      .build())
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                      .setDelay(Durations.fromSeconds(1L))
                      .build())
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                      .build())
              .build();

      TestResult result = runAttempt(grpcClient, retryClient, sequence, 2);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
    }
  }

  // Tests that the operation deadline (totalTimeout) halts the retry loop when cumulative delay
  // exceeds totalTimeout.
  @Test
  void testHttpJson_retryTotalTimeoutExceeded() throws Exception {
    RetrySettings totalTimeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(10L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(2000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofMillis(2000L))
            .setTotalTimeoutDuration(Duration.ofMillis(1000L))
            .setMaxAttempts(10)
            .setJittered(false)
            .build();

    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            totalTimeoutRetrySettings, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence sequence =
          Sequence.newBuilder()
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                      .setDelay(Durations.fromMillis(200L))
                      .build())
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                      .setDelay(Durations.fromSeconds(2L))
                      .build())
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                      .build())
              .build();

      TestResult result = runAttempt(httpjsonClient, retryClient, sequence, 2);

      assertThat(result.exception).isNotNull();
      assertThat(result.exception.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
    }
  }

  private void verifySequenceReport(SequenceReport report) {
    List<SequenceReport.Attempt> attempts = report.getAttemptsList();
    assertThat(attempts).hasSize(4);

    // Verify the status of each attempt
    assertThat(attempts.get(0).getStatus().getCode()).isEqualTo(Code.UNAVAILABLE.getNumber());
    assertThat(attempts.get(1).getStatus().getCode()).isEqualTo(Code.UNAVAILABLE.getNumber());
    assertThat(attempts.get(2).getStatus().getCode()).isEqualTo(Code.UNAVAILABLE.getNumber());
    assertThat(attempts.get(3).getStatus().getCode()).isEqualTo(Code.OK.getNumber());
  }

  private Sequence buildSequence(Code... codes) {
    Sequence.Builder builder = Sequence.newBuilder();
    for (Code code : codes) {
      builder.addResponses(
          Sequence.Response.newBuilder()
              .setStatus(Status.newBuilder().setCode(code.getNumber()).build())
              .build());
    }
    return builder.build();
  }

  private static class TestResult {
    private final SequenceReport report;
    private final ApiException exception;

    private TestResult(SequenceReport report, ApiException exception) {
      this.report = report;
      this.exception = exception;
    }
  }

  private TestResult runAttempt(
      SequenceServiceClient client,
      SequenceServiceClient retryClient,
      Sequence sequence,
      int expectedAttempts) {
    Sequence createdSequence =
        client.createSequence(CreateSequenceRequest.newBuilder().setSequence(sequence).build());

    ApiException exception = null;
    try {
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());
    } catch (ApiException e) {
      exception = e;
    }

    Awaitility.await()
        .atMost(Duration.ofSeconds(3))
        .untilAsserted(
            () -> {
              SequenceReport report =
                  client.getSequenceReport(
                      GetSequenceReportRequest.newBuilder()
                          .setName(createdSequence.getName() + "/sequenceReport")
                          .build());
              assertThat(report.getAttemptsCount()).isEqualTo(expectedAttempts);
            });

    SequenceReport finalReport =
        client.getSequenceReport(
            GetSequenceReportRequest.newBuilder()
                .setName(createdSequence.getName() + "/sequenceReport")
                .build());

    return new TestResult(finalReport, exception);
  }
}
