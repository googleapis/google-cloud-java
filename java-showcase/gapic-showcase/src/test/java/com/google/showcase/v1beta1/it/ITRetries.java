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
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableSet;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.AttemptSequenceRequest;
import com.google.showcase.v1beta1.CreateSequenceRequest;
import com.google.showcase.v1beta1.GetSequenceReportRequest;
import com.google.showcase.v1beta1.Sequence;
import com.google.showcase.v1beta1.SequenceReport;
import com.google.showcase.v1beta1.SequenceServiceClient;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
    // Create a custom client with these retry settings on attemptSequence
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createGrpcSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence createdSequence =
          grpcClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(STANDARD_SEQUENCE).build());

      // 3. Trigger the sequence attempts using the retrying client
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      // 4. Retrieve the sequence report to inspect delay measurements
      SequenceReport report =
          grpcClient.getSequenceReport(
              GetSequenceReportRequest.newBuilder()
                  .setName(createdSequence.getName() + "/sequenceReport")
                  .build());

      // 5. Assert attempts count and delays
      verifySequenceReport(report);
    }
  }

  @Test
  @SuppressWarnings("deprecation")
  void testHttpJson_retryExponentialBackoff() throws Exception {
    // Create a custom client with these retry settings on attemptSequence
    try (SequenceServiceClient retryClient =
        TestClientInitializer.createHttpJsonSequenceClientWithRetrySettings(
            STANDARD_RETRY_SETTINGS, ImmutableSet.of(StatusCode.Code.UNAVAILABLE))) {

      Sequence createdSequence =
          httpjsonClient.createSequence(
              CreateSequenceRequest.newBuilder().setSequence(STANDARD_SEQUENCE).build());

      // 3. Trigger the sequence attempts using the retrying client
      retryClient.attemptSequence(
          AttemptSequenceRequest.newBuilder().setName(createdSequence.getName()).build());

      // 4. Retrieve the sequence report to inspect delay measurements
      SequenceReport report =
          httpjsonClient.getSequenceReport(
              GetSequenceReportRequest.newBuilder()
                  .setName(createdSequence.getName() + "/sequenceReport")
                  .build());

      // 5. Assert attempts count and delays
      verifySequenceReport(report);
    }
  }

  private void verifySequenceReport(SequenceReport report) {
    List<SequenceReport.Attempt> attempts = report.getAttemptsList();
    assertThat(attempts).hasSize(4);

    // Verify the status of each attempt
    assertThat(attempts.get(0).getStatus().getCode())
        .isEqualTo(com.google.rpc.Code.UNAVAILABLE.getNumber());
    assertThat(attempts.get(1).getStatus().getCode())
        .isEqualTo(com.google.rpc.Code.UNAVAILABLE.getNumber());
    assertThat(attempts.get(2).getStatus().getCode())
        .isEqualTo(com.google.rpc.Code.UNAVAILABLE.getNumber());
    assertThat(attempts.get(3).getStatus().getCode()).isEqualTo(com.google.rpc.Code.OK.getNumber());

    // Verify delay intervals are at least the expected exponential backoff thresholds:
    // Attempt 1 -> 2: scheduled 100ms. Must be at least 80ms (no upper bound)
    long delay1 = getDelayMs(attempts.get(1));
    assertThat(delay1).isAtLeast(80L);

    // Attempt 2 -> 3: scheduled 200ms. Must be at least 180ms (no upper bound)
    long delay2 = getDelayMs(attempts.get(2));
    assertThat(delay2).isAtLeast(180L);

    // Attempt 3 -> 4: scheduled 400ms. Must be at least 380ms (no upper bound)
    long delay3 = getDelayMs(attempts.get(3));
    assertThat(delay3).isAtLeast(380L);
  }

  private long getDelayMs(SequenceReport.Attempt attempt) {
    com.google.protobuf.Duration attemptDelay = attempt.getAttemptDelay();
    return attemptDelay.getSeconds() * 1000 + attemptDelay.getNanos() / 1_000_000;
  }
}
