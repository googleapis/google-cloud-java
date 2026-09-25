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

import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.ResumableUploadOptions;
import com.google.showcase.v1beta1.ResumableUploadServiceClient;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
      UploadMediaResponse response = client.uploadMedia(request, stream, DEFAULT_TEST_OPTIONS);
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
          client.uploadMediaCallable().futureCall(request, stream, (ResumableUploadOptions) null);

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
      UploadMediaResponse response = client.uploadMedia(request, stream, DEFAULT_TEST_OPTIONS);
      assertThat(response.getName()).isEqualTo("it-client-multi-chunk.txt");
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
        UploadMediaResponse response =
            grpcClient.uploadMedia(request, stream, DEFAULT_TEST_OPTIONS);
        assertThat(response.getName()).isEqualTo("it-grpc-delegation.txt");
        assertThat(response.getSize()).isEqualTo(Files.size(file));
      }

      try (InputStream stream = Files.newInputStream(file)) {
        ResumableUploadFuture<UploadMediaResponse> future =
            grpcClient
                .uploadMediaCallable()
                .futureCall(request, stream, (ResumableUploadOptions) null);
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
  void testGeneratedClient_uploadMedia_withCustomOptions(@TempDir Path tempDir) throws Exception {
    // 600KB payload with custom per-call 512KB chunk size override (default is 256KB)
    int totalBytes = 600 * 1024;
    Path file = createTempFile(tempDir, "it-client-custom-call-settings.txt", totalBytes);
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-client-custom-call-settings.txt").build();
    ResumableUploadOptions options =
        ResumableUploadOptions.newBuilder().setChunkSize(512 * 1024).build();

    try (InputStream stream = Files.newInputStream(file)) {
      UploadMediaResponse response = client.uploadMedia(request, stream, options);
      assertThat(response.getName()).isEqualTo("it-client-custom-call-settings.txt");
      assertThat(response.getSize()).isEqualTo(Files.size(file));
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
