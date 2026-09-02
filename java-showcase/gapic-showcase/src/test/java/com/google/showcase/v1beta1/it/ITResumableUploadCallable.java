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

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.HttpRequestFormatter;
import com.google.api.gax.httpjson.HttpResponseParser;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
import com.google.api.gax.httpjson.RestSerializationException;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ResumableUploadCallSettings;
import com.google.api.gax.rpc.ResumableUploadCallable;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.io.CharStreams;
import com.google.protobuf.TypeRegistry;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Integration test for happy-path ResumableUploadCallable upload sessions against Showcase. */
class ITResumableUploadCallable {

  private static final int SHOWCASE_CHUNK_SIZE = 256 * 1024; // 256KB

  private static final HttpResponseParser<String> STRING_RESPONSE_PARSER =
      new HttpResponseParser<String>() {
        @Override
        public String parse(InputStream httpContent) {
          try (Reader reader = new InputStreamReader(httpContent, StandardCharsets.UTF_8)) {
            return CharStreams.toString(reader);
          } catch (IOException e) {
            throw new RestSerializationException("Failed to read response body as string", e);
          }
        }

        @Override
        public String parse(InputStream httpContent, TypeRegistry registry) {
          return parse(httpContent);
        }

        @Override
        public String parse(Reader httpContent, TypeRegistry registry) {
          try {
            return CharStreams.toString(httpContent);
          } catch (IOException e) {
            throw new RestSerializationException("Failed to read response body as string", e);
          }
        }

        @Override
        public String serialize(String response) {
          return response;
        }
      };

  private static final ApiMethodDescriptor<ShowcaseUploadRequest, String> UPLOAD_METHOD_DESCRIPTOR =
      ApiMethodDescriptor.<ShowcaseUploadRequest, String>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Files/Upload")
          .setHttpMethod(HttpMethods.POST)
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              new HttpRequestFormatter<ShowcaseUploadRequest>() {
                @Override
                public Map<String, List<String>> getQueryParamNames(ShowcaseUploadRequest request) {
                  return Collections.emptyMap();
                }

                @Override
                public String getRequestBody(ShowcaseUploadRequest request) {
                  return request.jsonPayload;
                }

                @Override
                public String getPath(ShowcaseUploadRequest request) {
                  return request.path;
                }

                @Override
                public PathTemplate getPathTemplate() {
                  return PathTemplate.create("**");
                }
              })
          .setResponseParser(STRING_RESPONSE_PARSER)
          .build();

  private static final HttpJsonCallSettings<ShowcaseUploadRequest, String>
      UPLOAD_HTTP_JSON_CALL_SETTINGS =
          HttpJsonCallSettings.<ShowcaseUploadRequest, String>newBuilder()
              .setMethodDescriptor(UPLOAD_METHOD_DESCRIPTOR)
              .build();

  private static class ShowcaseUploadRequest {
    final String path = "v1beta1/files:upload";
    final String jsonPayload;

    ShowcaseUploadRequest(String fileName) {
      this.jsonPayload = "{\"name\":\"" + fileName + "\"}";
    }
  }

  private static ManagedHttpJsonChannel channel;
  private static ScheduledExecutorService executor;
  private static ClientContext clientContext;
  private static ResumableUploadCallable<ShowcaseUploadRequest, String> uploadCallable;

  @BeforeAll
  static void createClients() throws Exception {
    executor = Executors.newScheduledThreadPool(4);

    channel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
            .setHttpTransport(new NetHttpTransport.Builder().doNotValidateCertificate().build())
            .build();

    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(HttpJsonCallContext.createDefault().withChannel(channel))
            .setTransportChannel(HttpJsonTransportChannel.create(channel))
            .setEndpoint(TestClientInitializer.DEFAULT_HTTPJSON_ENDPOINT)
            .setExecutor(executor)
            .build();

    ResumableUploadCallSettings callSettings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(SHOWCASE_CHUNK_SIZE).build();

    uploadCallable =
        HttpJsonCallableFactory.createResumableUploadCallable(
            UPLOAD_HTTP_JSON_CALL_SETTINGS, callSettings, clientContext);
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    if (executor != null) {
      executor.shutdownNow();
    }
    if (channel != null) {
      channel.shutdown();
      channel.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testUploadCallable_singleChunk_happyPath() throws Exception {
    byte[] content =
        "Hello world from ResumableUploadCallable single chunk!".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-single-chunk.txt"),
            new ByteArrayInputStream(content));

    String responseBody = future.get();
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
    assertThat(future.getUploadSessionUrl()).isNotNull();
  }

  @Test
  void testUploadCallable_multiChunk_happyPath() throws Exception {
    // 600KB payload = 2 full 256KB chunks + 1 partial 88KB chunk
    int totalBytes = 600 * 1024;
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-multi-chunk.txt"), payloadStream(totalBytes));

    String responseBody = future.get();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
    assertThat(future.getUploadSessionUrl()).isNotNull();
  }

  @Test
  void testUploadCallable_zeroByteUpload_finalizesSuccessfully() throws Exception {
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-zero-bytes.txt"),
            new ByteArrayInputStream(new byte[0]));

    String responseBody = future.get();
    assertThat(responseBody).contains("\"size\":0");
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
  }

  @Test
  void testUploadCallable_singleChunkWithSeparateZeroByteFinalize_completesSuccessfully()
      throws Exception {
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-exact-single-chunk.txt"),
            payloadStream(SHOWCASE_CHUNK_SIZE));

    String responseBody = future.get();
    assertThat(responseBody).contains("\"size\":" + SHOWCASE_CHUNK_SIZE);
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
  }

  @Test
  void testUploadCallable_multiChunkWithSeparateZeroByteFinalize_completesSuccessfully()
      throws Exception {
    // Exactly 2 full 256KB chunks (512KB total) -> triggers 0-byte finalize request
    int totalBytes = 512 * 1024;
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-exact-multiple.txt"),
            payloadStream(totalBytes));

    String responseBody = future.get();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
    assertThat(future.getUploadSessionUrl()).isNotNull();
  }

  @Test
  void testUploadCallable_callerGetWithTimeout() throws Exception {
    int totalBytes = 600 * 1024;
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-future-get-timeout.txt"),
            payloadStream(totalBytes));

    // 1. Immediately requesting with 1 nanosecond timeout throws TimeoutException
    assertThrows(TimeoutException.class, () -> future.get(1, TimeUnit.NANOSECONDS));

    // 2. Caller can still wait with adequate timeout and successfully receive result
    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testUploadCallable_cancelInFlight_haltsUpload() throws Exception {
    CountDownLatch readStarted = new CountDownLatch(1);
    CountDownLatch allowReadToProceed = new CountDownLatch(1);
    InputStream blockingStream =
        new InputStream() {
          @Override
          public int read() throws IOException {
            readStarted.countDown();
            try {
              allowReadToProceed.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              throw new IOException("Interrupted", e);
            }
            return 0;
          }
        };

    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-cancel.txt"), blockingStream);

    assertThat(readStarted.await(5, TimeUnit.SECONDS)).isTrue();
    boolean cancelled = future.cancel(true);
    allowReadToProceed.countDown();

    assertThat(cancelled).isTrue();
    assertThat(future.isCancelled()).isTrue();
    assertThat(future.isDone()).isTrue();

    // Calling get() on cancelled future must throw CancellationException
    assertThrows(CancellationException.class, future::get);
  }

  @Test
  void testUploadCallable_convenienceOverload_succeeds() throws Exception {
    byte[] content = "Convenience overload test".getBytes(StandardCharsets.UTF_8);
    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-convenience.txt"),
            new ByteArrayInputStream(content));

    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testUploadCallable_withCustomCallContextHeaders_succeeds() throws Exception {
    byte[] content = "Context headers test".getBytes(StandardCharsets.UTF_8);
    ApiCallContext context =
        HttpJsonCallContext.createDefault()
            .withExtraHeaders(
                Collections.singletonMap(
                    "X-Custom-Header", Collections.singletonList("custom-val")));

    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-custom-headers.txt"),
            new ByteArrayInputStream(content),
            context);

    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testUploadCallable_withCustomSettings_succeeds() throws Exception {
    byte[] content = "Custom settings test".getBytes(StandardCharsets.UTF_8);
    ResumableUploadCallSettings customSettings =
        ResumableUploadCallSettings.newBuilder()
            .setChunkSize(SHOWCASE_CHUNK_SIZE)
            .setGlobalTimeout(Duration.ofMinutes(2))
            .build();

    ResumableUploadCallable<ShowcaseUploadRequest, String> customCallable =
        HttpJsonCallableFactory.createResumableUploadCallable(
            UPLOAD_HTTP_JSON_CALL_SETTINGS, customSettings, clientContext);

    ResumableUploadFuture<String> future =
        customCallable.futureCall(
            new ShowcaseUploadRequest("callable-custom-settings.txt"),
            new ByteArrayInputStream(content));

    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testUploadCallable_withPerRequestSettings_succeeds() throws Exception {
    byte[] content = "Per-request settings test".getBytes(StandardCharsets.UTF_8);
    ResumableUploadCallSettings perRequestSettings =
        ResumableUploadCallSettings.newBuilder()
            .setChunkSize(SHOWCASE_CHUNK_SIZE)
            .setGlobalTimeout(Duration.ofMinutes(2))
            .build();

    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-per-request-settings.txt"),
            new ByteArrayInputStream(content),
            null,
            perRequestSettings);

    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testUploadCallable_withPerRequestSettingsOverload_succeeds() throws Exception {
    byte[] content = "Per-request settings 3-arg overload test".getBytes(StandardCharsets.UTF_8);
    ResumableUploadCallSettings perRequestSettings =
        ResumableUploadCallSettings.newBuilder()
            .setChunkSize(SHOWCASE_CHUNK_SIZE)
            .setGlobalTimeout(Duration.ofMinutes(2))
            .build();

    ResumableUploadFuture<String> future =
        uploadCallable.futureCall(
            new ShowcaseUploadRequest("callable-per-request-settings-overload.txt"),
            new ByteArrayInputStream(content),
            perRequestSettings);

    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.isDone()).isTrue();
  }

  private static InputStream payloadStream(int size) {
    byte[] data = new byte[size];
    for (int i = 0; i < size; i++) {
      data[i] = (byte) (i % 256);
    }
    return new ByteArrayInputStream(data);
  }
}
