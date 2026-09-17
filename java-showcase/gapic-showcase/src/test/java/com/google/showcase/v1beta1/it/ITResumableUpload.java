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
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.ResumableUploadCallSettings;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.ResumableUploadStatus;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.showcase.v1beta1.ResumableUploadServiceClient;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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
  void testGeneratedClient_uploadMedia_synchronousConvenienceMethod(@TempDir Path tempDir)
      throws Exception {
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
  void testGeneratedClient_uploadMediaCallable_asynchronousFutureCall(@TempDir Path tempDir)
      throws Exception {
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
          client
              .uploadMediaCallable()
              .futureCall(request, stream, (ResumableUploadCallSettings) null);

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
  void testGeneratedClient_multiChunkUpload(@TempDir Path tempDir) throws Exception {
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
  void testGeneratedClient_zeroByteUpload() throws Exception {
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-zero-byte.txt").build();

    try (InputStream stream = new ByteArrayInputStream(new byte[0])) {
      UploadMediaResponse response = client.uploadMedia(request, stream, null);
      assertThat(response.getName()).isEqualTo("it-client-zero-byte.txt");
      assertThat(response.getSize()).isEqualTo(0);
    }
  }

  @Test
  void testGeneratedClient_exactChunkBoundaryUpload(@TempDir Path tempDir) throws Exception {
    // Exactly 2 full 256KB chunks (512KB total) -> triggers 0-byte finalize request
    int totalBytes = 512 * 1024;
    Path file = createTempFile(tempDir, "it-client-exact-chunks.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-exact-chunks.txt").build();

    try (InputStream stream = Files.newInputStream(file)) {
      UploadMediaResponse response = client.uploadMedia(request, stream, null);
      assertThat(response.getName()).isEqualTo("it-client-exact-chunks.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testGeneratedClient_grpcClientDelegation_uploadMedia(@TempDir Path tempDir)
      throws Exception {
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
            grpcClient
                .uploadMediaCallable()
                .futureCall(request, stream, (ResumableUploadCallSettings) null);
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
  void testGeneratedClient_uploadMedia_withCustomCallSettings(@TempDir Path tempDir)
      throws Exception {
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
  void testChunkRetry_nonFatalErrorOnChunkUpload_succeeds(@TempDir Path tempDir) throws Exception {
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
    Path file = createTempFile(tempDir, "it-chunk-retry-success.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-retry-success.txt").build();

    List<ResumableUploadStatus> reportedStatuses = new CopyOnWriteArrayList<>();
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
                      .build());
      future.addProgressListener(reportedStatuses::add, MoreExecutors.directExecutor());
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-retry-success.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));

      List<ResumableUploadStatus.State> states = new ArrayList<>();
      for (ResumableUploadStatus s : reportedStatuses) {
        states.add(s.getState());
      }
      assertThat(states).contains(ResumableUploadStatus.State.STARTED);
      assertThat(states).contains(ResumableUploadStatus.State.UPLOADING);
      assertThat(states).doesNotContain(ResumableUploadStatus.State.RECOVERING);
      assertThat(states).doesNotContain(ResumableUploadStatus.State.OFFSET_RECEIVED);
      assertThat(states).contains(ResumableUploadStatus.State.FINALIZED);
    }
  }

  @Test
  void testChunkRecovery_nonFatalError400OnChunkUpload_recoversAndSucceeds(@TempDir Path tempDir)
      throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":400,\"failure_count\":1,"
                        + "\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-recovery-success.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-recovery-success.txt").build();

    List<ResumableUploadStatus> reportedStatuses = new CopyOnWriteArrayList<>();
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
                      .build());
      future.addProgressListener(reportedStatuses::add, MoreExecutors.directExecutor());
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-recovery-success.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));

      List<ResumableUploadStatus.State> states = new ArrayList<>();
      List<Long> uploadedOffsets = new ArrayList<>();
      for (ResumableUploadStatus s : reportedStatuses) {
        states.add(s.getState());
        if (s.getBytesUploaded() > 0 && !uploadedOffsets.contains(s.getBytesUploaded())) {
          uploadedOffsets.add(s.getBytesUploaded());
        }
      }
      assertThat(states).contains(ResumableUploadStatus.State.RECOVERING);
      assertThat(states).contains(ResumableUploadStatus.State.OFFSET_RECEIVED);
      assertThat(states).contains(ResumableUploadStatus.State.FINALIZED);
      assertThat(uploadedOffsets).containsExactly(262144L, 524288L, 614400L).inOrder();
    }
  }

  @Test
  void testChunkRecovery_nonFatalError400OnFinalChunk_recoversAndFinalizes(@TempDir Path tempDir)
      throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    int afterOffset = 2 * SHOWCASE_CHUNK_SIZE; // 512KB, start of the 3rd (final) chunk
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
    Path file = createTempFile(tempDir, "it-chunk-recovery-final-chunk.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-recovery-final-chunk.txt").build();

    List<ResumableUploadStatus> reportedStatuses = new CopyOnWriteArrayList<>();
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
                      .build());
      future.addProgressListener(reportedStatuses::add, MoreExecutors.directExecutor());
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-recovery-final-chunk.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));

      List<ResumableUploadStatus.State> states = new ArrayList<>();
      for (ResumableUploadStatus s : reportedStatuses) {
        states.add(s.getState());
      }
      assertThat(states).contains(ResumableUploadStatus.State.RECOVERING);
      assertThat(states).contains(ResumableUploadStatus.State.OFFSET_RECEIVED);
      assertThat(states).contains(ResumableUploadStatus.State.FINALIZED);
    }
  }

  @Test
  void testGlobalTimeout_exhaustsTimeoutUnderFailures_failsWithDeadlineExceeded(
      @TempDir Path tempDir) throws Exception {
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

    // Warm up the HTTP connection pool so session initiation completes in ~5ms,
    // ensuring the global timeout fires during chunk upload retries rather than
    // racing JVM/connection setup.
    client.uploadMedia(
        UploadMediaRequest.newBuilder().setName("it-warmup.txt").build(),
        new ByteArrayInputStream(new byte[16]),
        null);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-global-timeout.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-global-timeout.txt").build();

    AtomicInteger closeCount = new AtomicInteger(0);
    InputStream rawStream = Files.newInputStream(file);
    InputStream stream =
        new FilterInputStream(rawStream) {
          private long totalRead = 0;

          @Override
          public int read(byte[] b, int off, int len) throws IOException {
            if (totalRead >= 2 * SHOWCASE_CHUNK_SIZE) {
              try {
                Thread.sleep(200);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Interrupted", e);
              }
            }
            int n = super.read(b, off, len);
            if (n > 0) {
              totalRead += n;
            }
            return n;
          }

          @Override
          public void close() throws IOException {
            closeCount.incrementAndGet();
            super.close();
          }
        };

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request,
                stream,
                callContext,
                ResumableUploadCallSettings.newBuilder()
                    .setChunkSize(SHOWCASE_CHUNK_SIZE)
                    .setGlobalTimeout(Duration.ofMillis(250))
                    .build());

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    DeadlineExceededException cause = (DeadlineExceededException) exception.getCause();
    assertThat(cause.getStatusCode().getCode()).isEqualTo(StatusCode.Code.DEADLINE_EXCEEDED);
    assertThat(cause.getMessage()).contains("timed out for session");
    assertThat(closeCount.get()).isEqualTo(1);
  }

  @Test
  void testProgressListener_multiChunkUploadWithCat2Recovery_reportsOrderedStatesAndMonotonicBytes(
      @TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    int afterOffset = SHOWCASE_CHUNK_SIZE; // 256KB, error injected on the second chunk
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
    Path file = createTempFile(tempDir, "it-progress-listener.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-progress-listener.txt").build();

    List<ResumableUploadStatus> reportedStatuses = new CopyOnWriteArrayList<>();
    ExecutorService customExecutor =
        Executors.newSingleThreadExecutor(r -> new Thread(r, "it-progress-worker"));
    AtomicBoolean executedOnCustomThread = new AtomicBoolean(false);

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
                      .build());

      future.addProgressListener(
          status -> {
            if ("it-progress-worker".equals(Thread.currentThread().getName())) {
              executedOnCustomThread.set(true);
            }
            reportedStatuses.add(status);
          },
          customExecutor);

      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(response.getName()).isEqualTo("it-progress-listener.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
      assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
      assertThat(future.getStatus().getBytesUploaded()).isEqualTo(totalBytes);
      assertThat(executedOnCustomThread.get()).isTrue();
    } finally {
      customExecutor.shutdownNow();
    }

    assertThat(reportedStatuses).isNotEmpty();

    long lastBytes = -1;
    for (ResumableUploadStatus status : reportedStatuses) {
      assertThat(status.getBytesUploaded()).isAtLeast(lastBytes);
      lastBytes = status.getBytesUploaded();
      if (status.getState() != ResumableUploadStatus.State.STARTING) {
        assertThat(status.getUploadUrl()).isNotNull();
      }
    }

    ResumableUploadStatus finalStatus = reportedStatuses.get(reportedStatuses.size() - 1);
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(totalBytes);

    List<ResumableUploadStatus.State> observedStates = new ArrayList<>();
    for (ResumableUploadStatus status : reportedStatuses) {
      observedStates.add(status.getState());
    }

    int startedIdx = observedStates.indexOf(ResumableUploadStatus.State.STARTED);
    int uploadingIdx = observedStates.indexOf(ResumableUploadStatus.State.UPLOADING);
    int recoveringIdx = observedStates.indexOf(ResumableUploadStatus.State.RECOVERING);
    int finalizedIdx = observedStates.lastIndexOf(ResumableUploadStatus.State.FINALIZED);

    assertThat(startedIdx).isNotEqualTo(-1);
    assertThat(uploadingIdx).isNotEqualTo(-1);
    assertThat(recoveringIdx).isNotEqualTo(-1);
    assertThat(finalizedIdx).isNotEqualTo(-1);

    assertThat(startedIdx).isLessThan(uploadingIdx);
    assertThat(uploadingIdx).isLessThan(recoveringIdx);
    assertThat(recoveringIdx).isLessThan(finalizedIdx);

    int offsetReceivedIdx = observedStates.indexOf(ResumableUploadStatus.State.OFFSET_RECEIVED);
    assertThat(offsetReceivedIdx).isNotEqualTo(-1);
    assertThat(recoveringIdx).isLessThan(offsetReceivedIdx);
    assertThat(offsetReceivedIdx).isLessThan(finalizedIdx);
  }

  @Test
  void testCancellation_midChunk_cancelsUploadAndClosesStreamOnce(@TempDir Path tempDir)
      throws Exception {
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
    CloseCountingInputStream stream = new CloseCountingInputStream(Files.newInputStream(file));

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request,
                stream,
                callContext,
                ResumableUploadCallSettings.newBuilder().setChunkSize(SHOWCASE_CHUNK_SIZE).build());

    future.addProgressListener(
        status -> {
          if (status.getState() == ResumableUploadStatus.State.STARTED
              || status.getState() == ResumableUploadStatus.State.UPLOADING) {
            uploadingLatch.countDown();
          }
        },
        MoreExecutors.directExecutor());

    assertThat(uploadingLatch.await(10, TimeUnit.SECONDS)).isTrue();
    future.cancel(true);

    assertThat(future.isCancelled()).isTrue();
    assertThrows(CancellationException.class, () -> future.get(10, TimeUnit.SECONDS));
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
    assertThat(future.getStatus().getException()).isInstanceOf(CancellationException.class);
    assertThat(stream.getCloseCount()).isEqualTo(1);
  }

  @Test
  void testRetryBudgetExhaustion_exhaustsAttemptsUnderFailures_failsWithUnavailableException(
      @TempDir Path tempDir) throws Exception {
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
    Path file = createTempFile(tempDir, "it-retry-exhaust.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-retry-exhaust.txt").build();

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
                      .setGlobalTimeout(Duration.ofMillis(1000))
                      .build());

      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> future.get(30, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
      assertThat(exception.getCause()).isNotInstanceOf(DeadlineExceededException.class);
      UnavailableException unavailable = (UnavailableException) exception.getCause();
      assertThat(unavailable.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
      assertThat(unavailable.getMessage()).contains(future.getUploadSessionUrl());
    }
  }

  @Test
  void testChunkUpload_fatalError404OnChunkUpload_failsFastWithoutRetry(@TempDir Path tempDir)
      throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":404,\"failure_count\":1,"
                        + "\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-404.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-404.txt").build();

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
                      .build());

      ExecutionException exception =
          assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
      assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
      NotFoundException notFoundException = (NotFoundException) exception.getCause();
      assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
      assertThat(notFoundException.getMessage()).contains(future.getUploadSessionUrl());
    }
  }

  @Test
  void testChunkUpload_serverRejectionWithFinalOrCancelledStatus_failsTerminallyWithoutRetry(
      @TempDir Path tempDir) throws Exception {
    for (String terminalStatus : ImmutableList.of("final", "cancelled")) {
      String clientUuid = UUID.randomUUID().toString();
      Map<String, List<String>> extraHeaders =
          ImmutableMap.of(
              "X-Goog-Test-Scenario",
              ImmutableList.of("non_fatal_error_on_chunk_upload"),
              "X-Goog-Test-Scenario-Config",
              ImmutableList.of(
                  String.format(
                      "{\"client_uuid\":\"%s\",\"error_code\":503,\"failure_count\":1,"
                          + "\"error_status\":\"%s\",\"after_offset\":0}",
                      clientUuid, terminalStatus)));
      ApiCallContext callContext =
          HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

      int totalBytes = 600 * 1024;
      Path file = createTempFile(tempDir, "it-chunk-reject-" + terminalStatus + ".txt", totalBytes);
      UploadMediaRequest request =
          UploadMediaRequest.newBuilder()
              .setName("it-chunk-reject-" + terminalStatus + ".txt")
              .build();

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
                        .build());

        ExecutionException exception =
            assertThrows(ExecutionException.class, () -> future.get(15, TimeUnit.SECONDS));
        assertThat(exception.getCause()).isInstanceOf(FailedPreconditionException.class);
        FailedPreconditionException failedPrecondition =
            (FailedPreconditionException) exception.getCause();
        assertThat(failedPrecondition.getStatusCode().getCode())
            .isEqualTo(StatusCode.Code.FAILED_PRECONDITION);
        assertThat(failedPrecondition.getMessage()).contains(future.getUploadSessionUrl());
      }
    }
  }

  @Test
  void testChunkRecovery_missingStatusHeaderOnUploadResponse_recoversAndSucceeds(
      @TempDir Path tempDir) throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":200,\"failure_count\":1,"
                        + "\"error_status\":\"omit\",\"after_offset\":0}",
                    clientUuid)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-missing-status.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-missing-status.txt").build();

    List<ResumableUploadStatus> reportedStatuses = new CopyOnWriteArrayList<>();
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
                      .build());
      future.addProgressListener(reportedStatuses::add, MoreExecutors.directExecutor());
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-missing-status.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));

      List<ResumableUploadStatus.State> states = new ArrayList<>();
      for (ResumableUploadStatus s : reportedStatuses) {
        states.add(s.getState());
      }
      assertThat(states).contains(ResumableUploadStatus.State.RECOVERING);
      assertThat(states).contains(ResumableUploadStatus.State.OFFSET_RECEIVED);
      assertThat(states).contains(ResumableUploadStatus.State.FINALIZED);
    }
  }

  @Test
  void testChunkRecovery_nonFatalError416OnChunkUpload_recoversAndSucceeds(@TempDir Path tempDir)
      throws Exception {
    String clientUuid = UUID.randomUUID().toString();
    int afterOffset = SHOWCASE_CHUNK_SIZE;
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of(
                String.format(
                    "{\"client_uuid\":\"%s\",\"error_code\":416,\"failure_count\":1,"
                        + "\"after_offset\":%d}",
                    clientUuid, afterOffset)));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-chunk-recovery-416.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-chunk-recovery-416.txt").build();

    List<ResumableUploadStatus> reportedStatuses = new CopyOnWriteArrayList<>();
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
                      .build());
      future.addProgressListener(reportedStatuses::add, MoreExecutors.directExecutor());
      UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);

      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-recovery-416.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));

      List<ResumableUploadStatus.State> states = new ArrayList<>();
      for (ResumableUploadStatus s : reportedStatuses) {
        states.add(s.getState());
      }
      assertThat(states).contains(ResumableUploadStatus.State.RECOVERING);
      assertThat(states).contains(ResumableUploadStatus.State.OFFSET_RECEIVED);
      assertThat(states).contains(ResumableUploadStatus.State.FINALIZED);
    }
  }

  @Test
  void testPayloadClosure_successPath_closesStreamExactlyOnce(@TempDir Path tempDir)
      throws Exception {
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-payload-close.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-payload-close.txt").build();

    CloseCountingInputStream stream = new CloseCountingInputStream(Files.newInputStream(file));

    ResumableUploadFuture<UploadMediaResponse> future =
        client
            .uploadMediaCallable()
            .futureCall(
                request,
                stream,
                null,
                ResumableUploadCallSettings.newBuilder().setChunkSize(SHOWCASE_CHUNK_SIZE).build());

    UploadMediaResponse response = future.get(30, TimeUnit.SECONDS);
    assertThat(response.getName()).isEqualTo("it-payload-close.txt");
    assertThat(response.getSize()).isEqualTo(Files.size(file));
    assertThat(stream.getCloseCount()).isEqualTo(1);
  }

  private static final class CloseCountingInputStream extends FilterInputStream {
    private final AtomicInteger closeCount = new AtomicInteger(0);

    CloseCountingInputStream(InputStream in) {
      super(in);
    }

    @Override
    public void close() throws IOException {
      closeCount.incrementAndGet();
      super.close();
    }

    int getCloseCount() {
      return closeCount.get();
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
