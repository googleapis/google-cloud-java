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
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  // Test sequence consisting of 4 attempts: 3 consecutive UNAVAILABLE failures followed by 1 OK.
  private static final Sequence FOUR_ATTEMPTS_SEQUENCE =
      buildSequence(Code.UNAVAILABLE, Code.UNAVAILABLE, Code.UNAVAILABLE, Code.OK);

  // Test sequence consisting of 1 UNAVAILABLE failure followed by 1 OK.
  private static final Sequence SINGLE_FAIL_SEQUENCE = buildSequence(Code.UNAVAILABLE, Code.OK);

  // Test sequence consisting of 1 non-retryable INVALID_ARGUMENT failure followed by 1 OK.
  private static final Sequence NON_RETRYABLE_SEQUENCE =
      buildSequence(Code.INVALID_ARGUMENT, Code.OK);

  // Test sequence consisting of different status codes: UNAVAILABLE -> RESOURCE_EXHAUSTED ->
  // DEADLINE_EXCEEDED -> OK.
  private static final Sequence MULTIPLE_STATUS_SEQUENCE =
      buildSequence(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED, Code.DEADLINE_EXCEEDED, Code.OK);

  // Test sequence with cumulative delays (200ms and 2s) to trigger totalTimeout exhaustion.
  private static final Sequence TOTAL_TIMEOUT_SEQUENCE =
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

  // Baseline RetrySettings builder defining shared initial delays, backoff multipliers, timeout
  // limits, and disabled jitter to prevent code duplication across test configuration instances.
  private static RetrySettings.Builder baseRetrySettingsBuilder() {
    return RetrySettings.newBuilder()
        .setInitialRetryDelayDuration(Duration.ofMillis(100L))
        .setRetryDelayMultiplier(2.0)
        .setMaxRetryDelayDuration(Duration.ofMillis(1000L))
        .setInitialRpcTimeoutDuration(Duration.ofMillis(1000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeoutDuration(Duration.ofMillis(1000L))
        .setTotalTimeoutDuration(Duration.ofMillis(5000L))
        .setJittered(false);
  }

  // Configures 4 attempts total (1 initial + 3 retries) with exponential backoff and disabled
  // jitter, matching FOUR_ATTEMPTS_SEQUENCE.
  private static final RetrySettings FOUR_ATTEMPTS_RETRY_SETTINGS =
      baseRetrySettingsBuilder().setMaxAttempts(4).build();

  // Configures maxAttempts = 1 so retries are not used and the client fails immediately on the
  // first
  // attempt. Note that baseline retry delay values from baseRetrySettingsBuilder() are required by
  // AutoValue to build the object but are ignored.
  private static final RetrySettings SINGLE_ATTEMPT_RETRY_SETTINGS =
      baseRetrySettingsBuilder().setMaxAttempts(1).build();

  // Configures rpcTimeout = 100ms so that server delay (200ms) in attempt calls exceeds the
  // per-attempt RPC timeout.
  private static final RetrySettings RPC_TIMEOUT_RETRY_SETTINGS =
      baseRetrySettingsBuilder()
          .setInitialRpcTimeoutDuration(Duration.ofMillis(100L))
          .setMaxRpcTimeoutDuration(Duration.ofMillis(100L))
          .setMaxAttempts(10)
          .build();

  // Configures totalTimeout = 1000ms so that cumulative delay in TOTAL_TIMEOUT_SEQUENCE (200ms +
  // 2s = 2.2s) exceeds the total operation deadline on attempt 2.
  private static final RetrySettings TOTAL_TIMEOUT_RETRY_SETTINGS =
      baseRetrySettingsBuilder()
          .setTotalTimeoutDuration(Duration.ofMillis(1000L))
          .setMaxAttempts(10)
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
  // receiving OK over gRPC.
  @Test
  void testGrpc_retryExponentialBackoff() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            FOUR_ATTEMPTS_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(FOUR_ATTEMPTS_SEQUENCE).build());

      // Act
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      // Assert
      SequenceReport report = getSequenceReport(grpcClient, createdSequence.getName(), 4);
      assertAttemptSequence(report, Code.UNAVAILABLE, Code.UNAVAILABLE, Code.UNAVAILABLE, Code.OK);
    }
  }

  // Tests that the client retries on UNAVAILABLE errors up to maxAttempts (4) and succeeds when
  // receiving OK over HTTP/JSON.
  @Test
  void testHttpJson_retryExponentialBackoff() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            FOUR_ATTEMPTS_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(FOUR_ATTEMPTS_SEQUENCE).build());

      // Act
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      // Assert
      SequenceReport report = getSequenceReport(httpjsonClient, createdSequence.getName(), 4);
      assertAttemptSequence(report, Code.UNAVAILABLE, Code.UNAVAILABLE, Code.UNAVAILABLE, Code.OK);
    }
  }

  // Tests that configuring maxAttempts = 1 causes the client to fail immediately on the first error
  // without retrying over gRPC.
  @Test
  void testGrpc_noRetry() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            SINGLE_ATTEMPT_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(SINGLE_FAIL_SEQUENCE).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);

      SequenceReport report = getSequenceReport(grpcClient, createdSequence.getName(), 1);
      assertAttemptSequence(report, Code.UNAVAILABLE);
    }
  }

  // Tests that configuring maxAttempts = 1 causes the client to fail immediately on the first error
  // without retrying over HTTP/JSON.
  @Test
  void testHttpJson_noRetry() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            SINGLE_ATTEMPT_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(SINGLE_FAIL_SEQUENCE).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);

      SequenceReport report = getSequenceReport(httpjsonClient, createdSequence.getName(), 1);
      assertAttemptSequence(report, Code.UNAVAILABLE);
    }
  }

  // Tests that encountering a non-retryable error (INVALID_ARGUMENT) stops retries immediately,
  // even if maxAttempts > 1 over gRPC.
  @Test
  void testGrpc_nonRetryableError() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            FOUR_ATTEMPTS_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(NON_RETRYABLE_SEQUENCE).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);

      SequenceReport report = getSequenceReport(grpcClient, createdSequence.getName(), 1);
      assertAttemptSequence(report, Code.INVALID_ARGUMENT);
    }
  }

  // Tests that encountering a non-retryable error (INVALID_ARGUMENT) stops retries immediately,
  // even if maxAttempts > 1 over HTTP/JSON.
  @Test
  void testHttpJson_nonRetryableError() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            FOUR_ATTEMPTS_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(NON_RETRYABLE_SEQUENCE).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);

      SequenceReport report = getSequenceReport(httpjsonClient, createdSequence.getName(), 1);
      assertAttemptSequence(report, Code.INVALID_ARGUMENT);
    }
  }

  // Tests that the client retries through a sequence of different retryable status codes
  // (UNAVAILABLE -> RESOURCE_EXHAUSTED -> DEADLINE_EXCEEDED) over gRPC.
  @Test
  void testGrpc_retryMultipleStatus() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            FOUR_ATTEMPTS_RETRY_SETTINGS,
            ImmutableSet.of(
                StatusCode.Code.UNAVAILABLE,
                StatusCode.Code.RESOURCE_EXHAUSTED,
                StatusCode.Code.DEADLINE_EXCEEDED))) {

      // Arrange
      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(MULTIPLE_STATUS_SEQUENCE).build());

      // Act
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      // Assert
      SequenceReport report = getSequenceReport(grpcClient, createdSequence.getName(), 4);
      assertAttemptSequence(
          report, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED, Code.DEADLINE_EXCEEDED, Code.OK);
    }
  }

  // Tests that the client retries through a sequence of different retryable status codes
  // (UNAVAILABLE -> RESOURCE_EXHAUSTED -> DEADLINE_EXCEEDED) over HTTP/JSON.
  @Test
  void testHttpJson_retryMultipleStatus() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            FOUR_ATTEMPTS_RETRY_SETTINGS,
            ImmutableSet.of(
                StatusCode.Code.UNAVAILABLE,
                StatusCode.Code.RESOURCE_EXHAUSTED,
                StatusCode.Code.DEADLINE_EXCEEDED))) {

      // Arrange
      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(MULTIPLE_STATUS_SEQUENCE).build());

      // Act
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      // Assert
      SequenceReport report = getSequenceReport(httpjsonClient, createdSequence.getName(), 4);
      assertAttemptSequence(
          report, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED, Code.DEADLINE_EXCEEDED, Code.OK);
    }
  }

  // Tests that individual attempt timeouts (rpcTimeout) trigger a retry when the server response
  // delay exceeds the timeout over gRPC.
  @Test
  void testGrpc_retryOnRpcTimeoutExceeded() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            RPC_TIMEOUT_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED))) {

      // Arrange
      Sequence.Builder sequenceBuilder = Sequence.newBuilder();
      for (int i = 0; i < 10; i++) {
        sequenceBuilder.addResponses(
            Sequence.Response.newBuilder()
                .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                .setDelay(Durations.fromMillis(200L))
                .build());
      }

      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(sequenceBuilder.build()).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);

      SequenceReport report = getSequenceReport(grpcClient, createdSequence.getName(), 7);
      List<SequenceReport.Attempt> attempts = report.getAttemptsList();
      assertThat(attempts.size()).isAtLeast(1);

      for (int i = 0; i < attempts.size(); i++) {
        assertThat(attempts.get(i).getStatus().getCode())
            .isIn(ImmutableSet.of(Code.OK.getNumber(), Code.DEADLINE_EXCEEDED.getNumber()));
      }
    }
  }

  // Tests that individual attempt timeouts (rpcTimeout) trigger a retry when the server response
  // delay exceeds the timeout over HTTP/JSON.
  @Test
  void testHttpJson_retryOnRpcTimeoutExceeded() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            RPC_TIMEOUT_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED))) {

      // Arrange
      Sequence.Builder sequenceBuilder = Sequence.newBuilder();
      for (int i = 0; i < 10; i++) {
        sequenceBuilder.addResponses(
            Sequence.Response.newBuilder()
                .setStatus(Status.newBuilder().setCode(Code.OK.getNumber()).build())
                .setDelay(Durations.fromMillis(200L))
                .build());
      }

      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(sequenceBuilder.build()).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);

      SequenceReport report = getSequenceReport(httpjsonClient, createdSequence.getName(), 7);
      List<SequenceReport.Attempt> attempts = report.getAttemptsList();
      assertThat(attempts.size()).isAtLeast(1);

      for (int i = 0; i < attempts.size(); i++) {
        assertThat(attempts.get(i).getStatus().getCode())
            .isIn(ImmutableSet.of(Code.OK.getNumber(), Code.DEADLINE_EXCEEDED.getNumber()));
      }
    }
  }

  // Tests that the operation deadline (totalTimeout) halts the retry loop when cumulative delay
  // exceeds totalTimeout over gRPC.
  @Test
  void testGrpc_retryTotalTimeoutExceeded() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            TOTAL_TIMEOUT_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(TOTAL_TIMEOUT_SEQUENCE).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);

      SequenceReport report = getSequenceReport(grpcClient, createdSequence.getName(), 2);
      assertAttemptSequence(report, Code.UNAVAILABLE, Code.UNAVAILABLE);
    }
  }

  // Tests that the operation deadline (totalTimeout) halts the retry loop when cumulative delay
  // exceeds totalTimeout over HTTP/JSON.
  @Test
  void testHttpJson_retryTotalTimeoutExceeded() throws Exception {
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            TOTAL_TIMEOUT_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      // Arrange
      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(TOTAL_TIMEOUT_SEQUENCE).build());

      // Act
      ApiException exception =
          assertThrows(
              ApiException.class,
              () ->
                  retryClient.attemptSequence(
                      AttemptSequenceRequest.newBuilder()
                          .setName(createdSequence.getName())
                          .build()));

      // Assert
      assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);

      SequenceReport report = getSequenceReport(httpjsonClient, createdSequence.getName(), 2);
      assertAttemptSequence(report, Code.UNAVAILABLE, Code.UNAVAILABLE);
    }
  }

  private static Sequence buildSequence(Code... codes) {
    Sequence.Builder builder = Sequence.newBuilder();
    for (Code code : codes) {
      builder.addResponses(
          Sequence.Response.newBuilder()
              .setStatus(Status.newBuilder().setCode(code.getNumber()).build())
              .build());
    }
    return builder.build();
  }

  private static void assertAttemptSequence(SequenceReport report, Code... expectedCodes) {
    List<SequenceReport.Attempt> attempts = report.getAttemptsList();
    assertThat(attempts).hasSize(expectedCodes.length);
    for (int i = 0; i < expectedCodes.length; i++) {
      assertThat(attempts.get(i).getStatus().getCode()).isEqualTo(expectedCodes[i].getNumber());
      if (i == 0) {
        assertThat(Durations.toMillis(attempts.get(i).getAttemptDelay())).isAtLeast(0L);
      } else {
        assertThat(Durations.toMillis(attempts.get(i).getAttemptDelay())).isAtLeast(1L);
      }
    }
  }

  private SequenceReport getSequenceReport(
      SequenceServiceClient client, String sequenceName, int expectedAttempts) {
    String reportName = sequenceName + "/sequenceReport";
    return Awaitility.await()
        .atMost(Duration.ofSeconds(3))
        .until(
            () ->
                client.getSequenceReport(
                    GetSequenceReportRequest.newBuilder().setName(reportName).build()),
            report -> report.getAttemptsCount() >= expectedAttempts);
  }
}
