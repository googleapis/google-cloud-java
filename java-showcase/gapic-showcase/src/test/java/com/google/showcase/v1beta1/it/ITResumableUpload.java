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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ResumableUploadCallSettings;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.ResumableUploadStatus;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.showcase.v1beta1.ResumableUploadServiceClient;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
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
  private static final Credentials DUMMY_CREDENTIALS =
      OAuth2Credentials.create(new AccessToken("fake-token", new Date(Long.MAX_VALUE)));
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
      UploadMediaResponse response = client.uploadMedia(request, stream);
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
      UploadMediaResponse response = client.uploadMedia(request, stream);
      assertThat(response.getName()).isEqualTo("it-client-multi-chunk.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
    }
  }

  @Test
  void testGeneratedClient_zeroByteUpload() throws Exception {
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-zero-byte.txt").build();

    try (InputStream stream = new ByteArrayInputStream(new byte[0])) {
      UploadMediaResponse response = client.uploadMedia(request, stream);
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
      UploadMediaResponse response = client.uploadMedia(request, stream);
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
        TestClientInitializer.createGrpcResumableUploadClient(
            NoCredentialsProvider.create(), SHOWCASE_CHUNK_SIZE)) {
      try (InputStream stream = Files.newInputStream(file)) {
        UploadMediaResponse response = grpcClient.uploadMedia(request, stream);
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

      assertThat(future.isDone()).isTrue();
      assertThat(future.isCancelled()).isFalse();
      assertThat(future.getUploadSessionUrl()).isNotNull();
      assertThat(response.getName()).isEqualTo("it-chunk-retry-success.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));

      List<ResumableUploadStatus.State> states = new ArrayList<>();
      for (ResumableUploadStatus s : reportedStatuses) {
        states.add(s.getState());
      }
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

      assertThat(future.isDone()).isTrue();
      assertThat(future.isCancelled()).isFalse();
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

      assertThat(future.isDone()).isTrue();
      assertThat(future.isCancelled()).isFalse();
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
