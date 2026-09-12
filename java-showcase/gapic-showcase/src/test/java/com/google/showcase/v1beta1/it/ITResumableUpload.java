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
import com.google.api.gax.rpc.ResumableUploadCallSettings;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.ResumableUploadProgress;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.showcase.v1beta1.ResumableUploadServiceClient;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Integration tests for generated {@link ResumableUploadServiceClient} against the Showcase server.
 */
class ITResumableUpload {

  private static final int SHOWCASE_CHUNK_SIZE = 256 * 1024; // 256KB
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

    try (InputStream stream = Files.newInputStream(file)) {
      UploadMediaResponse response = client.uploadMedia(request, stream, null);
      assertThat(response.getName()).isEqualTo("it-client-sync.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
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

    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, null);

      UploadMediaResponse response = future.get(10, TimeUnit.SECONDS);
      assertThat(future.isDone()).isTrue();
      assertThat(future.isCancelled()).isFalse();
      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(future.getUploadSessionUrl()).contains("/resumable/upload");
      assertThat(response.getName()).isEqualTo("it-client-callable.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testMultiChunkUpload(@TempDir Path tempDir) throws Exception {
    // 600KB payload = 2 full 256KB chunks + 1 partial 88KB chunk
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-client-multi-chunk.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-multi-chunk.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      UploadMediaResponse response = client.uploadMedia(request, stream, null);
      assertThat(response.getName()).isEqualTo("it-client-multi-chunk.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
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
      try (InputStream stream = Files.newInputStream(file)) {
        UploadMediaResponse response = grpcClient.uploadMedia(request, stream, null);
        assertThat(response.getName()).isEqualTo("it-grpc-delegation.txt");
        assertThat(response.getSize()).isEqualTo(Files.size(file));
      }

      try (InputStream stream = Files.newInputStream(file)) {
        ResumableUploadFuture<UploadMediaResponse> future =
            grpcClient.uploadMediaCallable().futureCall(request, stream, null);
        UploadMediaResponse response = future.get(10, TimeUnit.SECONDS);
        assertThat(future.isDone()).isTrue();
        assertThat(future.isCancelled()).isFalse();
        assertThat(future.getUploadSessionUrl()).isNotNull();
        assertThat(future.getUploadSessionUrl()).contains("/resumable/upload");
        assertThat(response.getName()).isEqualTo("it-grpc-delegation.txt");
        assertThat(response.getSize()).isEqualTo(Files.size(file));
      }
    }
  }

  @Test
  void testCustomCallSettings(@TempDir Path tempDir) throws Exception {
    // 600KB payload with custom per-call 512KB chunk size override (default is 256KB)
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-client-custom-call-settings.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-custom-call-settings.txt").build();
    ResumableUploadCallSettings callSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(512 * 1024).build();

    try (InputStream stream = Files.newInputStream(file)) {
      UploadMediaResponse response = client.uploadMedia(request, stream, callSettings);
      assertThat(response.getName()).isEqualTo("it-client-custom-call-settings.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testChunkRetry(@TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":503,\"failure_count\":1,"
                        + "\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-retry.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-retry.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, callContext, null);
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-retry.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testChunkRecovery(@TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    int afterOffset = SHOWCASE_CHUNK_SIZE;
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":400,\"failure_count\":1,"
                        + "\"after_offset\":%d}",
                    clientUuid, afterOffset)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-recovery.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-recovery.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, callContext, null);
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-recovery.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testChunkFatalError(@TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            // Test scenario header value is a misnomer - 404 is a fatal error
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":404,\"failure_count\":1,"
                        + "\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-fatal.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-fatal.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, callContext, null);

      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
      NotFoundException notFoundException = (NotFoundException) exception.getCause();
      assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
      assertThat(notFoundException.getMessage()).contains(future.getUploadSessionUrl());
    }
  }

  @Test
  void testChunkServerRejection(@TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":503,\"failure_count\":1,"
                        + "\"after_offset\":0,\"error_status\":\"final\"}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-rejection.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-rejection.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, callContext, null);

      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
      assertThat(exception.getCause())
          .hasMessageThat()
          .contains("Server terminated upload session with HTTP status: 503");
    }
  }

  @Test
  void testGlobalTimeout(@TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":400,\"failure_count\":1000,"
                        + "\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-global-timeout.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-global-timeout.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client
              .uploadMediaCallable()
              .futureCall(
                  request,
                  stream,
                  callContext,
                  ResumableUploadCallSettings.newBuilder()
                      .setChunkSize(SHOWCASE_CHUNK_SIZE)
                      .setGlobalTimeout(Duration.ofMillis(200))
                      .build());

      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
      DeadlineExceededException cause = (DeadlineExceededException) exception.getCause();
      assertThat(cause.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
    }
  }

  @Test
  void testCancellation(@TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":503,\"failure_count\":100,"
                        + "\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-cancel.txt", totalBytes);
    UploadMediaRequest request = UploadMediaRequest.newBuilder().setName("it-cancel.txt").build();

    CountDownLatch uploadingLatch = new CountDownLatch(1);
    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, callContext, null);

      // Wait for the upload to be started before cancelling
      future.addProgressListener(
          status -> {
            if (status.getState() == ResumableUploadProgress.State.STARTED
                || status.getState() == ResumableUploadProgress.State.UPLOADING) {
              uploadingLatch.countDown();
            }
          },
          MoreExecutors.directExecutor());
      assertThat(uploadingLatch.await(10, TimeUnit.SECONDS)).isTrue();

      future.cancel(true);

      assertThat(future.isCancelled()).isTrue();
      assertThrows(CancellationException.class, () -> future.get(10, TimeUnit.SECONDS));
    }
  }

  @Test
  void testProgressListener(@TempDir Path tempDir) throws Exception {
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-progress.txt", totalBytes);
    UploadMediaRequest request = UploadMediaRequest.newBuilder().setName("it-progress.txt").build();

    List<ResumableUploadProgress> reportedStatuses = new CopyOnWriteArrayList<>();
    try (InputStream stream = Files.newInputStream(file)) {
      ResumableUploadFuture<UploadMediaResponse> future =
          client.uploadMediaCallable().futureCall(request, stream, null);
      future.addProgressListener(reportedStatuses::add, MoreExecutors.directExecutor());
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(response.getName()).isEqualTo("it-progress.txt");
      assertThat(response.getSize()).isEqualTo(totalBytes);
      assertThat(reportedStatuses).isNotEmpty();

      long previousBytes = 0L;
      List<Long> uploadedOffsets = new ArrayList<>();
      for (ResumableUploadProgress status : reportedStatuses) {
        assertThat(status.getBytesUploaded()).isAtLeast(previousBytes);
        previousBytes = status.getBytesUploaded();
        if (status.getBytesUploaded() > 0 && !uploadedOffsets.contains(status.getBytesUploaded())) {
          uploadedOffsets.add(status.getBytesUploaded());
        }
      }
      assertThat(uploadedOffsets).containsExactly(262144L, 524288L, 614400L).inOrder();

      ResumableUploadProgress finalStatus = reportedStatuses.get(reportedStatuses.size() - 1);
      assertThat(finalStatus.getState()).isEqualTo(ResumableUploadProgress.State.FINALIZED);
      assertThat(finalStatus.getBytesUploaded()).isEqualTo(totalBytes);
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
}
