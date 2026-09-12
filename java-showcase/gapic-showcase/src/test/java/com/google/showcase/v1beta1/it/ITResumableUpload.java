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

import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.ResumableUploadOptions;
import com.google.api.gax.rpc.ResumableUploadProgress;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.showcase.v1beta1.ResumableUploadServiceClient;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Integration tests for generated {@link ResumableUploadServiceClient} against the Showcase server.
 */
class ITResumableUpload {

  private static final int SHOWCASE_CHUNK_SIZE = 256 * 1024; // 256KB
  private static final ResumableUploadOptions DEFAULT_TEST_OPTIONS =
      ResumableUploadOptions.newBuilder().setChunkSize(SHOWCASE_CHUNK_SIZE).build();
  private static ResumableUploadServiceClient client;

  @BeforeAll
  static void createClients() throws Exception {
    client = TestClientInitializer.createHttpJsonResumableUploadClient(SHOWCASE_CHUNK_SIZE);
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    if (client != null) {
      client.close();
      client.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testSynchronousUpload(@TempDir Path tempDir) throws Exception {
    Path file =
        createTempFile(
            tempDir,
            "it-client-sync.txt",
            "Hello from generated ResumableUploadServiceClient synchronous convenience method!"
                .getBytes(StandardCharsets.UTF_8));
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-sync.txt").build();

    UploadMediaResponse response =
        client.uploadMedia(request, () -> Files.newInputStream(file), DEFAULT_TEST_OPTIONS);
    assertThat(response.getName()).isEqualTo("it-client-sync.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
  }

  @Test
  void testAsynchronousUpload(@TempDir Path tempDir) throws Exception {
    Path file =
        createTempFile(
            tempDir,
            "it-client-callable.txt",
            "Hello from generated ResumableUploadServiceClient callable futureCall!"
                .getBytes(StandardCharsets.UTF_8));
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-callable.txt").build();

    ResumableUploadFuture<UploadMediaResponse> future =
        client.uploadMediaCallable().futureCall(request, () -> Files.newInputStream(file), null);

    UploadMediaResponse response = future.get(10, TimeUnit.SECONDS);
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
    assertThat(future.getUploadSessionUrl()).isNotNull();
    assertThat(future.getUploadSessionUrl()).contains("/resumable/upload");
    assertThat(response.getName()).isEqualTo("it-client-callable.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
  }

  @Test
  void testMultiChunkUpload(@TempDir Path tempDir) throws Exception {
    // 600KB payload = 2 full 256KB chunks + 1 partial 88KB chunk
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-client-multi-chunk.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-multi-chunk.txt").build();

    UploadMediaResponse response =
        client.uploadMedia(request, () -> Files.newInputStream(file), DEFAULT_TEST_OPTIONS);
    assertThat(response.getName()).isEqualTo("it-client-multi-chunk.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
  }

  @Test
  void testGrpcClientDelegation(@TempDir Path tempDir) throws Exception {
    Path file =
        createTempFile(
            tempDir,
            "it-grpc-delegation.txt",
            "Hello from generated ResumableUploadServiceClient gRPC delegation!"
                .getBytes(StandardCharsets.UTF_8));
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-grpc-delegation.txt").build();

    try (ResumableUploadServiceClient grpcClient =
        TestClientInitializer.createGrpcResumableUploadClient(SHOWCASE_CHUNK_SIZE)) {
      UploadMediaResponse syncResponse =
          grpcClient.uploadMedia(request, () -> Files.newInputStream(file), DEFAULT_TEST_OPTIONS);
      assertThat(syncResponse.getName()).isEqualTo("it-grpc-delegation.txt");
      assertThat(syncResponse.getSize()).isEqualTo(Files.size(file));

      ResumableUploadFuture<UploadMediaResponse> future =
          grpcClient
              .uploadMediaCallable()
              .futureCall(request, () -> Files.newInputStream(file), null);
      UploadMediaResponse asyncResponse = future.get(10, TimeUnit.SECONDS);
      assertThat(future.isDone()).isTrue();
      assertThat(future.isCancelled()).isFalse();
      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(future.getUploadSessionUrl()).contains("/resumable/upload");
      assertThat(asyncResponse.getName()).isEqualTo("it-grpc-delegation.txt");
      assertThat(asyncResponse.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testCustomOptions(@TempDir Path tempDir) throws Exception {
    // 600KB payload with custom per-call 512KB chunk size override (default is 256KB)
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-client-custom-call-settings.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-custom-call-settings.txt").build();
    ResumableUploadOptions options =
        ResumableUploadOptions.newBuilder().setChunkSize(512 * 1024).build();

    UploadMediaResponse response =
        client.uploadMedia(request, () -> Files.newInputStream(file), options);
    assertThat(response.getName()).isEqualTo("it-client-custom-call-settings.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
  }

  @Test
  void testChunkRetry(@TempDir Path tempDir) throws Exception {
    // First chunk fails once with 503 (transient), gets retried, and the upload succeeds without
    // needing recovery
    ApiCallContext callContext = faultInjectionContext(503, 1, 0);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-retry.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-retry.txt").build();

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request, () -> Files.newInputStream(file), callContext, DEFAULT_TEST_OPTIONS);
    UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

    assertThat(future.getUploadSessionUrl()).isNotNull();
    assertThat(response.getName()).isEqualTo("it-chunk-retry.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
  }

  @Test
  void testChunkRecovery(@TempDir Path tempDir) throws Exception {
    // First chunk succeeds, then the second chunk fails once with 400 (recoverable). The client
    // queries status, gets committed offset 256KB back, and resends the second chunk
    ApiCallContext callContext = faultInjectionContext(400, 1, SHOWCASE_CHUNK_SIZE);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-recovery.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-recovery.txt").build();

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request, () -> Files.newInputStream(file), callContext, DEFAULT_TEST_OPTIONS);
    UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

    assertThat(future.getUploadSessionUrl()).isNotNull();
    assertThat(response.getName()).isEqualTo("it-chunk-recovery.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
  }

  @Test
  void testChunkFatalError(@TempDir Path tempDir) throws Exception {
    // First chunk fails with 404, which is fatal, so the upload fails without retry or recovery
    ApiCallContext callContext = faultInjectionContext(404, 1, 0);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-fatal.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-fatal.txt").build();

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request, () -> Files.newInputStream(file), callContext, DEFAULT_TEST_OPTIONS);

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
    assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
    NotFoundException notFoundException = (NotFoundException) exception.getCause();
    assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    assertThat(notFoundException.getMessage()).contains(future.getUploadSessionUrl());
  }

  @Test
  void testGlobalTimeout(@TempDir Path tempDir) throws Exception {
    // Every chunk fails with 400 (recoverable), so the client keeps cycling through recovery until
    // the 200ms global timeout fires
    ApiCallContext callContext = faultInjectionContext(400, 1000, 0);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-global-timeout.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-global-timeout.txt").build();

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request,
                () -> Files.newInputStream(file),
                callContext,
                ResumableUploadOptions.newBuilder()
                    .setChunkSize(SHOWCASE_CHUNK_SIZE)
                    .setGlobalTimeout(Duration.ofMillis(200))
                    .build());

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    DeadlineExceededException cause = (DeadlineExceededException) exception.getCause();
    assertThat(cause.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
  }

  @Test
  void testCancellation(@TempDir Path tempDir) throws Exception {
    // Every chunk fails with 503 (transient), keeping the upload stuck in retries so the cancel
    // lands mid-upload rather than after completion
    ApiCallContext callContext = faultInjectionContext(503, 100, 0);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-cancel.txt", totalBytes);
    UploadMediaRequest request = UploadMediaRequest.newBuilder().setName("it-cancel.txt").build();

    CountDownLatch uploadingLatch = new CountDownLatch(1);
    ResumableUploadOptions options =
        DEFAULT_TEST_OPTIONS.toBuilder()
            .setProgressListener(
                status -> {
                  if ("STARTED".equals(status.getState())
                      || "UPLOADING".equals(status.getState())) {
                    uploadingLatch.countDown();
                  }
                })
            .build();
    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(request, () -> Files.newInputStream(file), callContext, options);

    // Wait for the upload to be started before cancelling
    assertThat(uploadingLatch.await(10, TimeUnit.SECONDS)).isTrue();

    future.cancel(true);

    assertThat(future.isCancelled()).isTrue();
    assertThrows(CancellationException.class, () -> future.get(10, TimeUnit.SECONDS));
  }

  @Test
  void testProgressListener(@TempDir Path tempDir) throws Exception {
    // No fault injection - 600KB payload uploads as 256KB + 256KB + 88KB chunks
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-progress.txt", totalBytes);
    UploadMediaRequest request = UploadMediaRequest.newBuilder().setName("it-progress.txt").build();

    List<ResumableUploadProgress> reportedStatuses = new CopyOnWriteArrayList<>();
    CountDownLatch finalizedLatch = new CountDownLatch(1);
    ResumableUploadOptions options =
        DEFAULT_TEST_OPTIONS.toBuilder()
            .setProgressListener(
                status -> {
                  reportedStatuses.add(status);
                  if ("FINALIZED".equals(status.getState())) {
                    finalizedLatch.countDown();
                  }
                })
            .build();
    ResumableUploadFuture<UploadMediaResponse> future =
        client.uploadMediaCallable().futureCall(request, () -> Files.newInputStream(file), options);
    UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);
    assertThat(finalizedLatch.await(10, TimeUnit.SECONDS)).isTrue();

    assertThat(response.getName()).isEqualTo("it-progress.txt");
    assertThat(response.getSize()).isEqualTo(totalBytes);

    List<String> states =
        reportedStatuses.stream()
            .map(ResumableUploadProgress::getState)
            .collect(Collectors.toList());
    assertThat(states)
        .containsExactly("STARTING", "STARTED", "UPLOADING", "UPLOADING", "FINALIZED")
        .inOrder();
    List<Long> bytesUploaded =
        reportedStatuses.stream()
            .map(ResumableUploadProgress::getBytesUploaded)
            .collect(Collectors.toList());
    assertThat(bytesUploaded).containsExactly(0L, 0L, 262144L, 524288L, 614400L).inOrder();

    // STARTING fires before the session exists; every later event carries the session URL
    String sessionUrl = future.getUploadSessionUrl();
    assertThat(sessionUrl).isNotNull();
    for (ResumableUploadProgress status : reportedStatuses.subList(1, reportedStatuses.size())) {
      assertThat(status.getUploadUrl()).isEqualTo(sessionUrl);
    }
  }

  private static Path createTempFile(Path dir, String fileName, byte[] data) throws IOException {
    Path path = dir.resolve(fileName);
    Files.write(path, data);
    return path;
  }

  private static Path createTempFile(Path dir, String fileName, int size) throws IOException {
    byte[] data = new byte[size];
    for (int i = 0; i < size; i++) {
      data[i] = (byte) (i % 256);
    }
    return createTempFile(dir, fileName, data);
  }

  /**
   * Returns a call context that makes Showcase fail the first {@code failureCount} chunk uploads at
   * or after {@code afterOffset} with HTTP {@code errorCode}.
   */
  private static ApiCallContext faultInjectionContext(
      int errorCode, int failureCount, long afterOffset) {
    String config =
        String.format(
            "{\"client_uuid\":\"%s\",\"error_code\":%d,\"failure_count\":%d,\"after_offset\":%d}",
            UUID.randomUUID(), errorCode, failureCount, afterOffset);
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            // Misnomer - Showcase injects the configured error code whether it's fatal or not
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(config));
    return HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);
  }
}
