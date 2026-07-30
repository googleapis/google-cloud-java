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

class ITRetries {

  private static final Sequence STANDARD_SEQUENCE =
      Sequence.newBuilder()
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(
                      Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE.getNumber())
                          .build())
                  .build())
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(
                      Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE.getNumber())
                          .build())
                  .build())
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(
                      Status.newBuilder()
                          .setCode(com.google.rpc.Code.UNAVAILABLE.getNumber())
                          .build())
                  .build())
          .addResponses(
              Sequence.Response.newBuilder()
                  .setStatus(
                      Status.newBuilder().setCode(com.google.rpc.Code.OK.getNumber()).build())
                  .build())
          .build();

  @SuppressWarnings("deprecation")
  private static final RetrySettings STANDARD_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100L))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1000L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(1000L))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(1000L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(5000L))
          .setMaxAttempts(4)
          .setJittered(false)
          .build();

  @SuppressWarnings("deprecation")
  private static final RetrySettings NO_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100L))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1000L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(1000L))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(1000L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(5000L))
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

  @Test
  @SuppressWarnings("deprecation")
  void testGrpc_retryExponentialBackoff() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      TestResult result = runAttempt(grpcClient, retryClient, STANDARD_SEQUENCE, 4);

      assertThat(result.exception).isNull();
      verifySequenceReport(result.report);
    }
  }

  @Test
  @SuppressWarnings("deprecation")
  void testHttpJson_retryExponentialBackoff() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      TestResult result = runAttempt(httpjsonClient, retryClient, STANDARD_SEQUENCE, 4);

      assertThat(result.exception).isNull();
      verifySequenceReport(result.report);
    }
  }

  @Test
  @SuppressWarnings("deprecation")
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

  @Test
  @SuppressWarnings("deprecation")
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

  @Test
  @SuppressWarnings("deprecation")
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

  @Test
  @SuppressWarnings("deprecation")
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

  @Test
  @SuppressWarnings("deprecation")
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

  @Test
  @SuppressWarnings("deprecation")
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

  @Test
  @SuppressWarnings("deprecation")
  void testGrpc_retryOnRpcTimeoutExceeded() throws Exception {
    RetrySettings timeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(100L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(10000L))
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
                .setDelay(com.google.protobuf.Duration.newBuilder().setNanos(200_000_000).build())
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

  @Test
  @SuppressWarnings("deprecation")
  void testHttpJson_retryOnRpcTimeoutExceeded() throws Exception {
    RetrySettings timeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(100L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(10000L))
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
                .setDelay(com.google.protobuf.Duration.newBuilder().setNanos(200_000_000).build())
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

  @Test
  @SuppressWarnings("deprecation")
  void testGrpc_retryTotalTimeoutExceeded() throws Exception {
    RetrySettings totalTimeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(100L))
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(2000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(2000L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(1500L))
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
                      .setDelay(com.google.protobuf.Duration.newBuilder().setSeconds(1L).build())
                      .build())
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                      .setDelay(com.google.protobuf.Duration.newBuilder().setSeconds(1L).build())
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

  @Test
  @SuppressWarnings("deprecation")
  void testHttpJson_retryTotalTimeoutExceeded() throws Exception {
    RetrySettings totalTimeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(2000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(2000L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(1000L))
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
                      .setDelay(
                          com.google.protobuf.Duration.newBuilder().setNanos(200_000_000).build())
                      .build())
              .addResponses(
                  Sequence.Response.newBuilder()
                      .setStatus(Status.newBuilder().setCode(Code.UNAVAILABLE.getNumber()).build())
                      .setDelay(com.google.protobuf.Duration.newBuilder().setSeconds(2L).build())
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
