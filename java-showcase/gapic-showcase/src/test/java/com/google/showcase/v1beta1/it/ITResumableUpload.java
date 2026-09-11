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

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.showcase.v1beta1.ResumableUploadServiceClient;
import com.google.showcase.v1beta1.ResumableUploadServiceSettings;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import io.grpc.ManagedChannelBuilder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
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
    ResumableUploadServiceSettings.Builder settingsBuilder =
        ResumableUploadServiceSettings.newHttpJsonBuilder();
    settingsBuilder
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setTransportChannelProvider(
            ResumableUploadServiceSettings.defaultHttpJsonTransportProviderBuilder()
                .setHttpTransport(new NetHttpTransport.Builder().doNotValidateCertificate().build())
                .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
                .build());
    settingsBuilder.uploadMediaSettings().setChunkSize(SHOWCASE_CHUNK_SIZE);
    client = ResumableUploadServiceClient.create(settingsBuilder.build());
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
    // Note on test harness architecture (4A & 4B):
    // In production Google Front End (GFE) deployments, both gRPC and HTTP/REST traffic are served
    // on standard port 443. However, the local Showcase server binds gRPC to port 7469 and HTTP
    // to port 7470.
    // The custom TransportChannelProvider below routes the primary transport stub to gRPC on
    // port 7469 while allowing the client endpoint to be configured to port 7470
    // (TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT) so the internal HTTP/REST resumable upload
    // stub can successfully communicate with Showcase's HTTP port without altering the gRPC
    // endpoint.
    //
    // Additionally, DUMMY_CREDENTIALS is provided to satisfy the CL-R2.2 pre-constructed channel
    // guard,
    // which requires credentials to be present when instantiating the HTTP/REST transport stub for
    // resumable uploads, even in this unauthenticated local test environment.
    TransportChannelProvider grpcTransportChannelProvider =
        new TransportChannelProvider() {
          private final TransportChannelProvider delegate =
              ResumableUploadServiceSettings.defaultGrpcTransportProviderBuilder()
                  .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                  .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
                  .build();

          @Override
          public boolean shouldAutoClose() {
            return delegate.shouldAutoClose();
          }

          @Override
          public boolean needsExecutor() {
            return delegate.needsExecutor();
          }

          @Override
          public TransportChannelProvider withExecutor(java.util.concurrent.Executor executor) {
            return delegate.withExecutor(executor);
          }

          @Override
          public TransportChannelProvider withExecutor(
              java.util.concurrent.ScheduledExecutorService executor) {
            return delegate.withExecutor(executor);
          }

          @Override
          public boolean needsHeaders() {
            return delegate.needsHeaders();
          }

          @Override
          public TransportChannelProvider withHeaders(java.util.Map<String, String> headers) {
            return delegate.withHeaders(headers);
          }

          @Override
          public boolean needsEndpoint() {
            return false;
          }

          @Override
          public TransportChannelProvider withEndpoint(String endpoint) {
            return this;
          }

          @Override
          public boolean acceptsPoolSize() {
            return delegate.acceptsPoolSize();
          }

          @Override
          public TransportChannelProvider withPoolSize(int size) {
            return delegate.withPoolSize(size);
          }

          @Override
          public boolean needsCredentials() {
            return delegate.needsCredentials();
          }

          @Override
          public TransportChannelProvider withCredentials(Credentials credentials) {
            return delegate.withCredentials(credentials);
          }

          @Override
          public com.google.api.gax.rpc.TransportChannel getTransportChannel() throws IOException {
            return delegate.getTransportChannel();
          }

          @Override
          public String getTransportName() {
            return delegate.getTransportName();
          }

          @Override
          public String getEndpoint() {
            return null;
          }
        };

    ResumableUploadServiceSettings.Builder grpcSettingsBuilder =
        ResumableUploadServiceSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(DUMMY_CREDENTIALS))
            .setTransportChannelProvider(grpcTransportChannelProvider)
            .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT);
    grpcSettingsBuilder.uploadMediaSettings().setChunkSize(SHOWCASE_CHUNK_SIZE);

    Path file =
        createTempFile(
            tempDir,
            "it-grpc-delegation.txt",
            "Hello from generated ResumableUploadServiceClient gRPC delegation!"
                .getBytes(StandardCharsets.UTF_8));
    UploadMediaRequest request =
        UploadMediaRequest.newBuilder().setName("it-grpc-delegation.txt").build();

    ResumableUploadServiceClient grpcClient =
        ResumableUploadServiceClient.create(grpcSettingsBuilder.build());
    try {
      // 1. Synchronous convenience method delegation
      try (InputStream stream = Files.newInputStream(file)) {
        UploadMediaResponse response = grpcClient.uploadMedia(request, stream);
        assertThat(response.getName()).isEqualTo("it-grpc-delegation.txt");
        assertThat(response.getSize()).isEqualTo(Files.size(file));
      }

      // 2. Asynchronous callable futureCall delegation
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
    } finally {
      grpcClient.close();
      assertThat(grpcClient.awaitTermination(5, TimeUnit.SECONDS)).isTrue();
    }
  }

  @Test
  void testChannelGuards_grpcChannelOnly_throwsFailedPreconditionException(@TempDir Path tempDir)
      throws Exception {
    ResumableUploadServiceSettings grpcSettings =
        ResumableUploadServiceSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                ResumableUploadServiceSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .build();

    Path file =
        createTempFile(
            tempDir, "guard-test.txt", "guard test data".getBytes(StandardCharsets.UTF_8));

    try (ResumableUploadServiceClient grpcClient =
        ResumableUploadServiceClient.create(grpcSettings)) {
      UploadMediaRequest request =
          UploadMediaRequest.newBuilder().setName("guard-test.txt").build();

      try (InputStream stream1 = Files.newInputStream(file)) {
        // 1. Verify synchronous convenience call fails fast
        FailedPreconditionException syncException =
            assertThrows(
                FailedPreconditionException.class, () -> grpcClient.uploadMedia(request, stream1));
        assertThat(syncException.getMessage())
            .contains("Resumable uploads execute over HTTP/REST and require credentials");
      }

      // 2. Verify callable getter fails fast
      FailedPreconditionException callableException =
          assertThrows(FailedPreconditionException.class, () -> grpcClient.uploadMediaCallable());
      assertThat(callableException.getMessage())
          .contains("Resumable uploads execute over HTTP/REST and require credentials");
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
