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
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.core.NanoClock;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonCallOptions;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonChannel;
import com.google.api.gax.httpjson.HttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonClientInterceptor;
import com.google.api.gax.httpjson.HttpJsonMetadata;
import com.google.api.gax.httpjson.HttpJsonResumableUploadClient;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.HttpRequestFormatter;
import com.google.api.gax.httpjson.HttpResponseParser;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
import com.google.api.gax.httpjson.RestSerializationException;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadProgressListener;
import com.google.api.gax.resumable.ResumableUploadResultRetryAlgorithm;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.ResumableUploadStatus;
import com.google.api.gax.retrying.AdaptiveRetryingCallable;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.ResumableUploadCallSettings;
import com.google.api.gax.rpc.ResumableUploadCallable;
import com.google.api.gax.rpc.ResumableUploadCallableImpl;
import com.google.api.gax.rpc.ResumableUploadFuture;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerContext;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.OpenTelemetryTracingFactory;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.CharStreams;
import com.google.protobuf.ByteString;
import com.google.protobuf.TypeRegistry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * Integration test for resumable uploads.
 *
 * <p>NB: This IT will gradually evolve to operate at the proper level of abstraction (it's too
 * low-level right now).
 *
 * <p>NB: This IT tests both low-level HttpJsonResumableUploadClient operations and high-level
 * ResumableUploadCallable streaming pipelines.
 */
class ITResumableUploadCallable {

  private static final String DEFAULT_HTTPJSON_ENDPOINT = "http://localhost:7469";
  private static final long DEFAULT_SHOWCASE_CHUNK_GRANULARITY = 256 * 1024L;

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
                  return request.queryParams;
                }

                @Override
                public String getRequestBody(ShowcaseUploadRequest request) {
                  return Strings.nullToEmpty(request.jsonPayload);
                }

                @Override
                public String getPath(ShowcaseUploadRequest request) {
                  return request.path;
                }

                @Override
                public PathTemplate getPathTemplate() {
                  return PathTemplate.create("{+path}");
                }
              })
          .setResponseParser(STRING_RESPONSE_PARSER)
          .build();

  private static class ShowcaseUploadRequest {
    private final String path;
    @Nullable private final String jsonPayload;
    private final Map<String, List<String>> queryParams;

    private ShowcaseUploadRequest(
        String path, @Nullable String jsonPayload, Map<String, List<String>> queryParams) {
      this.path = path;
      this.jsonPayload = jsonPayload;
      this.queryParams = queryParams;
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static class Builder {
      private String path = "v1beta1/files:upload";
      @Nullable private String jsonPayload = null;
      private Map<String, List<String>> queryParams = Collections.emptyMap();

      public Builder setPath(String path) {
        this.path = path;
        return this;
      }

      public Builder setJsonPayload(@Nullable String jsonPayload) {
        this.jsonPayload = jsonPayload;
        return this;
      }

      public Builder setQueryParams(Map<String, List<String>> queryParams) {
        this.queryParams = queryParams;
        return this;
      }

      public ShowcaseUploadRequest build() {
        return new ShowcaseUploadRequest(path, jsonPayload, queryParams);
      }
    }
  }

  private static ManagedHttpJsonChannel channel;
  private static HttpJsonResumableUploadClient<ShowcaseUploadRequest, String> uploadClient;
  private static ScheduledExecutorService executor;
  private static ClientContext clientContext;

  @BeforeAll
  static void createClient() throws Exception {
    Logger httpLogger = Logger.getLogger(HttpTransport.class.getName());
    httpLogger.setLevel(Level.ALL);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    httpLogger.addHandler(handler);

    executor = Executors.newScheduledThreadPool(4);

    channel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
            .setHttpTransport(new NetHttpTransport.Builder().doNotValidateCertificate().build())
            .build();

    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(HttpJsonCallContext.createDefault().withChannel(channel))
            .setTransportChannel(HttpJsonTransportChannel.create(channel))
            .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
            .setExecutor(executor)
            .build();

    uploadClient = HttpJsonResumableUploadClient.create(clientContext, UPLOAD_METHOD_DESCRIPTOR);
  }

  @AfterAll
  static void destroyClient() throws InterruptedException {
    if (executor != null) {
      executor.shutdownNow();
    }
    if (channel != null) {
      channel.shutdown();
      channel.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  private ResumableUploadCallable<ShowcaseUploadRequest, String> createUploadCallable(
      int chunkSize, @Nullable ApiCallContext customCallContext) {
    return createUploadCallable(chunkSize, customCallContext, null);
  }

  private ResumableUploadCallable<ShowcaseUploadRequest, String> createUploadCallable(
      int chunkSize,
      @Nullable ApiCallContext customCallContext,
      @Nullable RetrySettings customRetrySettings) {
    RetrySettings retrySettings =
        customRetrySettings != null
            ? customRetrySettings
            : RetrySettings.newBuilder()
                .setInitialRetryDelayDuration(Duration.ofMillis(50))
                .setRetryDelayMultiplier(1.5)
                .setMaxRetryDelayDuration(Duration.ofMillis(500))
                .setTotalTimeoutDuration(Duration.ofSeconds(10))
                .build();

    ResumableUploadCallSettings settings =
        ResumableUploadCallSettings.newBuilder()
            .setChunkSize(chunkSize)
            .setRetrySettings(retrySettings)
            .build();

    ClientContext context =
        clientContext.toBuilder()
            .setDefaultCallContext(
                customCallContext != null
                    ? customCallContext
                    : HttpJsonCallContext.createDefault().withChannel(channel))
            .setExecutor(executor)
            .build();

    return HttpJsonCallableFactory.createResumableUploadCallable(uploadClient, settings, context);
  }

  @BeforeEach
  void logTestStart(TestInfo testInfo) {
    System.out.println("\n>>> ================================================================");
    System.out.println(">>> STARTING TEST: " + testInfo.getDisplayName());
    System.out.println(">>> ================================================================");
  }

  @AfterEach
  void logTestEnd(TestInfo testInfo) {
    System.out.println(">>> ================================================================");
    System.out.println(">>> FINISHED TEST: " + testInfo.getDisplayName());
    System.out.println(">>> ================================================================\n");
  }

  // ==========================================================================
  // ResumableUploadCallable High-Level Tests
  // ==========================================================================

  @Test
  void testUploadCallable_singleChunk_happyPath() throws Exception {
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable((int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-single-chunk.txt\"}")
            .build();

    byte[] content =
        "Hello world from ResumableUploadCallable single chunk!".getBytes(StandardCharsets.UTF_8);
    InputStream inputStream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, inputStream, null);
    String responseBody = future.get();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + content.length);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(future.getStatus().getBytesUploaded()).isEqualTo(content.length);
  }

  @Test
  void testUploadCallable_multiChunk_happyPathWithProgress() throws Exception {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-multi-chunk.txt\"}")
            .build();

    // 600KB payload = 2 full 256KB chunks + 1 partial 88KB chunk
    int totalBytes = 600 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream inputStream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, inputStream, null);
    future.addProgressListener(listener);
    String responseBody = future.get();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(future.getStatus().getBytesUploaded()).isEqualTo(totalBytes);

    // Verify progress transitions
    assertThat(progressEvents).isNotEmpty();
    assertThat(progressEvents.get(0).getState()).isEqualTo(ResumableUploadStatus.State.STARTING);
    ResumableUploadStatus finalStatus = progressEvents.get(progressEvents.size() - 1);
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(totalBytes);
  }

  @Test
  void testUploadCallable_exactMultipleChunkSize_happyPath() throws Exception {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-exact-multiple.txt\"}")
            .build();

    // Exactly 2 full 256KB chunks (512KB total) -> triggers 0-byte finalize request
    int totalBytes = 512 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream inputStream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, inputStream, null);
    future.addProgressListener(listener);
    String responseBody = future.get();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(future.getStatus().getBytesUploaded()).isEqualTo(totalBytes);

    // Verify progress transitions
    assertThat(progressEvents).isNotEmpty();
    assertThat(progressEvents.get(0).getState()).isEqualTo(ResumableUploadStatus.State.STARTING);
    ResumableUploadStatus finalStatus = progressEvents.get(progressEvents.size() - 1);
    assertThat(finalStatus.getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(finalStatus.getBytesUploaded()).isEqualTo(totalBytes);
  }

  @Test
  void testUploadCallable_networkGlitchOnChunk_recoversAutomatically() throws Exception {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of("{\"error_code\":503,\"failure_count\":1,\"after_offset\":0}"));
    ApiCallContext callContext =
        HttpJsonCallContext.createDefault().withChannel(channel).withExtraHeaders(extraHeaders);

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, callContext);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-recovery-test.txt\"}")
            .build();

    // 600KB payload (2 full 256KB chunks + 88KB partial chunk: not an exact chunk multiple)
    int totalBytes = 600 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream inputStream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, inputStream, null);
    future.addProgressListener(listener);
    String responseBody = future.get();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(future.getStatus().getBytesUploaded()).isEqualTo(totalBytes);

    // Verify that RECOVERING state was triggered and recorded
    boolean hadRecovery =
        progressEvents.stream()
            .anyMatch(p -> p.getState() == ResumableUploadStatus.State.RECOVERING);
    assertThat(hadRecovery).isTrue();

    // Verify that OFFSET_RECEIVED state was triggered and recorded
    boolean hadOffsetReceived =
        progressEvents.stream()
            .anyMatch(p -> p.getState() == ResumableUploadStatus.State.OFFSET_RECEIVED);
    assertThat(hadOffsetReceived).isTrue();
  }

  @Test
  void testUploadCallable_category2ErrorOnChunk_recoversViaQueryStatus() throws Exception {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    // Inject a non-fatal Category 2 error (HTTP 400 INVALID_ARGUMENT) on chunk upload
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of("{\"error_code\":400,\"failure_count\":1,\"after_offset\":0}"));
    ApiCallContext callContext =
        HttpJsonCallContext.createDefault().withChannel(channel).withExtraHeaders(extraHeaders);

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, callContext);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-cat2-recovery-test.txt\"}")
            .build();

    int totalBytes = 600 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream inputStream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, inputStream, null);
    future.addProgressListener(listener);
    String responseBody = future.get();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(future.getStatus().getBytesUploaded()).isEqualTo(totalBytes);

    // Verify that RECOVERING state was triggered and recorded
    boolean hadRecovery =
        progressEvents.stream()
            .anyMatch(p -> p.getState() == ResumableUploadStatus.State.RECOVERING);
    assertThat(hadRecovery).isTrue();

    // Verify that OFFSET_RECEIVED state was triggered and recorded
    boolean hadOffsetReceived =
        progressEvents.stream()
            .anyMatch(p -> p.getState() == ResumableUploadStatus.State.OFFSET_RECEIVED);
    assertThat(hadOffsetReceived).isTrue();
  }

  @Test
  void testUploadCallable_resumeExistingSession() throws Exception {
    // 1. Initiate session and upload first 256KB chunk via low-level client
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-resume-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    byte[] chunk1 = new byte[chunkSize];
    ChunkUploadRequest chunk1Request =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(ByteString.copyFrom(chunk1))
            .setOffset(0L)
            .setFinal(false)
            .build();
    ChunkUploadResponse chunk1Response = uploadClient.uploadChunkCallable().call(chunk1Request);
    assertThat(chunk1Response.getCommittedOffset()).isEqualTo(chunkSize);

    // 2. Resume session via high-level ResumableUploadCallable with the full stream
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, null);

    int totalBytes = 384 * 1024; // 256KB + 128KB
    byte[] fullContent = new byte[totalBytes];
    InputStream fullStream = new ByteArrayInputStream(fullContent);

    ResumableUploadFuture<String> future =
        callable.resumeCall(session.getUploadUrl(), fullStream, null);
    String responseBody = future.get();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
  }

  @Test
  void testUploadCallable_retryTotalTimeoutExceeded_failsAndReportsFailedStatus() throws Exception {
    // Inject persistent 503 errors on chunk upload
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of("{\"error_code\":503,\"failure_count\":100,\"after_offset\":0}"));
    ApiCallContext callContext =
        HttpJsonCallContext.createDefault().withChannel(channel).withExtraHeaders(extraHeaders);

    // Set tight retry timeout so retries exhaust quickly
    RetrySettings shortRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(20))
            .setRetryDelayMultiplier(1.2)
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setTotalTimeoutDuration(Duration.ofMillis(200))
            .setMaxAttempts(3)
            .build();

    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(
            (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY, callContext, shortRetrySettings);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-timeout-fail.txt\"}")
            .build();

    byte[] content = new byte[512 * 1024];
    InputStream stream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, stream, null);
    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> future.get(10, TimeUnit.SECONDS));

    assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
    assertThat(future.getStatus().getException()).isInstanceOf(UnavailableException.class);
  }

  @Test
  void testUploadCallable_callerGetWithTimeout() throws Exception {
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable((int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-future-get-timeout.txt\"}")
            .build();

    int totalBytes = 600 * 1024;
    byte[] content = new byte[totalBytes];
    InputStream stream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, stream, null);

    // 1. Immediately requesting with 0/1 nanosecond timeout throws TimeoutException
    assertThrows(TimeoutException.class, () -> future.get(1, TimeUnit.NANOSECONDS));

    // 2. Caller can still wait with adequate timeout and successfully receive result
    String responseBody = future.get(10, TimeUnit.SECONDS);
    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FINALIZED);
  }

  @Test
  void testUploadCallable_cancelInFlight_haltsUploadAndDispatchesCancelledStatus()
      throws Exception {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable((int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-cancel.txt\"}")
            .build();

    // 768KB payload (3 chunks of 256KB)
    int totalBytes = 768 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream stream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, stream, null);
    future.addProgressListener(listener);

    // Cancel after brief wait
    Thread.sleep(20);
    boolean cancelled = future.cancel(true);
    assertThat(cancelled).isTrue();
    assertThat(future.isCancelled()).isTrue();
    assertThat(future.isDone()).isTrue();

    // Calling get() on cancelled future must throw CancellationException
    assertThrows(CancellationException.class, future::get);

    // Verify progress listener received FAILED state with CancellationException
    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
    assertThat(future.getStatus().getException()).isInstanceOf(CancellationException.class);
  }

  @Test
  void testUploadCallable_cancelInFlightAndResumeSession_succeeds() throws Exception {
    CountDownLatch chunk1Committed = new CountDownLatch(1);
    ResumableUploadProgressListener listener =
        status -> {
          if (status.getState() == ResumableUploadStatus.State.UPLOADING
              && status.getBytesUploaded() >= 256 * 1024) {
            chunk1Committed.countDown();
          }
        };

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-cancel-resume.txt\"}")
            .build();

    // 768KB payload (3 chunks of 256KB)
    int totalBytes = 768 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream stream = new ByteArrayInputStream(content);

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, stream, null);
    future.addProgressListener(listener);

    // Wait until chunk 1 is committed, then cancel remainder
    boolean committed = chunk1Committed.await(5, TimeUnit.SECONDS);
    assertThat(committed).isTrue();

    future.cancel(true);
    assertThat(future.isCancelled()).isTrue();
    assertThrows(CancellationException.class, future::get);

    // Brief pause to allow cancelled socket teardown to complete on server
    Thread.sleep(100);

    String sessionUrl = future.getUploadSessionUrl();
    assertThat(sessionUrl).isNotNull();

    // Resume the cancelled session with the full stream via callable.resumeCall
    InputStream resumeStream = new ByteArrayInputStream(content);
    ResumableUploadFuture<String> resumedFuture =
        callable.resumeCall(sessionUrl, resumeStream, null);
    String responseBody = resumedFuture.get(10, TimeUnit.SECONDS);

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);
    assertThat(resumedFuture.getStatus().getState())
        .isEqualTo(ResumableUploadStatus.State.FINALIZED);
    assertThat(resumedFuture.getStatus().getBytesUploaded()).isEqualTo(totalBytes);
  }

  @Test
  void testUploadCallable_resumeAlreadyFinalizedSession_returnsCompleteWithoutTransmitting()
      throws Exception {
    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, null);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-already-finalized.txt\"}")
            .build();

    byte[] content = "already-finalized-test-content".getBytes(StandardCharsets.UTF_8);
    InputStream inputStream = new ByteArrayInputStream(content);

    // Perform initial upload and finalize it
    ResumableUploadFuture<String> initialFuture =
        callable.futureCall(startRequest, inputStream, null);
    String initialResponse = initialFuture.get(5, TimeUnit.SECONDS);
    assertThat(initialResponse).isNotNull();
    assertThat(initialResponse).contains("\"size\":" + content.length);

    String sessionUrl = initialFuture.getUploadSessionUrl();
    assertThat(sessionUrl).isNotNull();

    // Resume the already finalized session using a separate stream that should never be read
    InputStream dummyStream =
        new InputStream() {
          @Override
          public int read() throws IOException {
            throw new IOException("Stream should not be read for already-finalized session");
          }
        };

    List<ResumableUploadStatus> resumeEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener resumeListener = resumeEvents::add;
    ResumableUploadCallable<ShowcaseUploadRequest, String> resumeCallable =
        createUploadCallable(chunkSize, null);

    ResumableUploadFuture<String> resumeFuture =
        resumeCallable.resumeCall(sessionUrl, dummyStream, null);
    resumeFuture.addProgressListener(resumeListener);
    String resumeResponse = resumeFuture.get(5, TimeUnit.SECONDS);

    assertThat(resumeResponse).isEqualTo(initialResponse);
    assertThat(resumeFuture.getStatus().getState())
        .isEqualTo(ResumableUploadStatus.State.FINALIZED);

    // Verify progress listener received FINALIZED
    assertThat(resumeEvents).isNotEmpty();
    assertThat(resumeEvents.get(resumeEvents.size() - 1).getState())
        .isEqualTo(ResumableUploadStatus.State.FINALIZED);
  }

  @Test
  void testUploadCallable_resumeNonExistentSession_throwsNotFoundException() {
    List<ResumableUploadStatus> progressEvents = new CopyOnWriteArrayList<>();
    ResumableUploadProgressListener listener = progressEvents::add;

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        createUploadCallable(chunkSize, null);

    String invalidUrl = DEFAULT_HTTPJSON_ENDPOINT + "/upload?sid=non-existent-sid";
    InputStream stream = new ByteArrayInputStream("data".getBytes(StandardCharsets.UTF_8));

    ResumableUploadFuture<String> future = callable.resumeCall(invalidUrl, stream, null);
    future.addProgressListener(listener);
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);

    assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
    NotFoundException notFound = (NotFoundException) exception.getCause();
    assertThat(notFound.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    assertThat(notFound.getStatusCode().getTransportCode()).isEqualTo(404);

    assertThat(future.getStatus().getState()).isEqualTo(ResumableUploadStatus.State.FAILED);
    assertThat(future.getStatus().getException()).isInstanceOf(NotFoundException.class);

    assertThat(progressEvents).isNotEmpty();
    assertThat(progressEvents.get(progressEvents.size() - 1).getState())
        .isEqualTo(ResumableUploadStatus.State.FAILED);
  }

  @Test
  void testUploadCallable_openTelemetryTracePropagation_success() throws Exception {
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(tracerProvider)
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .build();

    LibraryMetadata libraryMetadata =
        LibraryMetadata.newBuilder()
            .setArtifactName("google-cloud-showcase")
            .setVersion("0.0.1")
            .build();

    OpenTelemetryTracingFactory baseTracingFactory =
        new OpenTelemetryTracingFactory(openTelemetrySdk);
    ApiTracerFactory tracingFactory =
        baseTracingFactory.withContext(
            ApiTracerContext.newBuilder().setLibraryMetadata(libraryMetadata).build());

    List<HttpJsonMetadata> capturedHeaders = new CopyOnWriteArrayList<>();
    HttpJsonClientInterceptor interceptor =
        new HttpJsonClientInterceptor() {
          @Override
          public <ReqT, RespT> HttpJsonClientCall<ReqT, RespT> interceptCall(
              ApiMethodDescriptor<ReqT, RespT> method,
              HttpJsonCallOptions callOptions,
              HttpJsonChannel next) {
            HttpJsonClientCall<ReqT, RespT> call = next.newCall(method, callOptions);
            return new ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall<ReqT, RespT>(
                call) {
              @Override
              public void start(Listener<RespT> responseListener, HttpJsonMetadata headers) {
                capturedHeaders.add(headers);
                super.start(responseListener, headers);
              }
            };
          }
        };

    InstantiatingHttpJsonChannelProvider channelProvider =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
            .setHeaderProvider(FixedHeaderProvider.create())
            .setHttpTransport(new NetHttpTransport.Builder().doNotValidateCertificate().build())
            .setInterceptorProvider(() -> ImmutableList.of(interceptor))
            .build();

    HttpJsonTransportChannel transportChannel =
        (HttpJsonTransportChannel) channelProvider.getTransportChannel();
    ManagedHttpJsonChannel interceptedChannel = transportChannel.getManagedChannel();

    ClientContext tracedClientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(
                HttpJsonCallContext.createDefault().withChannel(interceptedChannel))
            .setTransportChannel(transportChannel)
            .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
            .setTracerFactory(tracingFactory)
            .build();

    HttpJsonResumableUploadClient<ShowcaseUploadRequest, String> tracedUploadClient =
        HttpJsonResumableUploadClient.create(tracedClientContext, UPLOAD_METHOD_DESCRIPTOR);

    int chunkSize = (int) DEFAULT_SHOWCASE_CHUNK_GRANULARITY; // 256KB
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(50))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(500))
            .setTotalTimeoutDuration(Duration.ofSeconds(10))
            .build();

    RetryAlgorithm<String> retryAlgorithm =
        new RetryAlgorithm<>(
            ResumableUploadResultRetryAlgorithm.create(),
            new ExponentialRetryAlgorithm(retrySettings, NanoClock.getDefaultClock()));

    AdaptiveRetryingCallable<String> adaptiveRetryingCallable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    ResumableUploadCallSettings settings =
        ResumableUploadCallSettings.newBuilder().setChunkSize(chunkSize).build();

    ApiTracer tracer =
        tracingFactory.newTracer(
            null,
            ApiTracerContext.newBuilder()
                .setFullMethodName("google.showcase.v1beta1.Files/Upload")
                .setHttpMethod("POST")
                .setHttpPathTemplate("v1beta1/files:upload")
                .setTransport(ApiTracerContext.Transport.HTTP)
                .setLibraryMetadata(libraryMetadata)
                .build());

    ApiCallContext callContext =
        HttpJsonCallContext.createDefault().withChannel(interceptedChannel).withTracer(tracer);

    ResumableUploadCallable<ShowcaseUploadRequest, String> callable =
        new ResumableUploadCallableImpl<>(
            tracedUploadClient, adaptiveRetryingCallable, settings, callContext);

    // 512KB payload = 2 chunks (256KB each)
    int totalBytes = 512 * 1024;
    byte[] content = new byte[totalBytes];
    for (int i = 0; i < totalBytes; i++) {
      content[i] = (byte) (i % 256);
    }
    InputStream stream = new ByteArrayInputStream(content);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"callable-otel-tracing.txt\"}")
            .build();

    ResumableUploadFuture<String> future = callable.futureCall(startRequest, stream, null);
    String responseBody = future.get(10, TimeUnit.SECONDS);
    tracer.operationSucceeded();

    assertThat(responseBody).isNotNull();
    assertThat(responseBody).contains("\"size\":" + totalBytes);

    List<SpanData> finishedSpans = spanExporter.getFinishedSpanItems();
    assertThat(finishedSpans).isNotEmpty();

    SpanData attemptSpan = finishedSpans.get(0);
    String expectedTraceId = attemptSpan.getSpanContext().getTraceId();
    String expectedSpanId = attemptSpan.getSpanContext().getSpanId();
    String expectedTraceFlags = attemptSpan.getSpanContext().getTraceFlags().asHex();
    String expectedTraceparent =
        "00-" + expectedTraceId + "-" + expectedSpanId + "-" + expectedTraceFlags;

    // 1 startUpload call + 2 uploadChunk calls + 1 finalize call = 4 HTTP wire calls
    assertThat(capturedHeaders).hasSize(4);

    // Verify all HTTP wire requests have the matching traceparent header injected
    for (HttpJsonMetadata headers : capturedHeaders) {
      assertThat(headers.getHeaders()).containsKey("traceparent");
      Object val = headers.getHeaders().get("traceparent");
      if (val instanceof List) {
        assertThat((List<?>) val).contains(expectedTraceparent);
      } else {
        assertThat(String.valueOf(val)).isEqualTo(expectedTraceparent);
      }
    }

    transportChannel.shutdown();
    transportChannel.getManagedChannel().awaitTermination(10, TimeUnit.SECONDS);
    openTelemetrySdk.close();
  }
}
