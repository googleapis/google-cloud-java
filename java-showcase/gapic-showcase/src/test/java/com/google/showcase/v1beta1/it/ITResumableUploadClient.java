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
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonResumableUploadClient;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.HttpRequestFormatter;
import com.google.api.gax.httpjson.HttpResponseParser;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
import com.google.api.gax.httpjson.RestSerializationException;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.CharStreams;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
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
 */
class ITResumableUploadClient {

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
                  return PathTemplate.create("**");
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

  @BeforeAll
  static void createClient() throws Exception {
    Logger httpLogger = Logger.getLogger(HttpTransport.class.getName());
    httpLogger.setLevel(Level.ALL);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    httpLogger.addHandler(handler);

    channel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
            .setHttpTransport(new NetHttpTransport.Builder().doNotValidateCertificate().build())
            .build();

    ClientContext clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(HttpJsonCallContext.createDefault().withChannel(channel))
            .setTransportChannel(HttpJsonTransportChannel.create(channel))
            .setEndpoint(DEFAULT_HTTPJSON_ENDPOINT)
            .build();

    uploadClient = HttpJsonResumableUploadClient.create(clientContext, UPLOAD_METHOD_DESCRIPTOR);
  }

  @AfterAll
  static void destroyClient() throws InterruptedException {
    if (channel != null) {
      channel.shutdown();
      channel.awaitTermination(10, TimeUnit.SECONDS);
    }
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

  @Test
  void testStartUpload_happyPath_returnsValidSession() throws Exception {
    ShowcaseUploadRequest request =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"test-file.txt\"}")
            .build();

    ResumableUploadSession session = uploadClient.startUploadCallable().call(request);

    assertThat(session.getUploadUrl()).isNotNull();
    assertThat(session.getUploadUrl()).contains("sid=");
    assertThat(session.getChunkGranularity()).isEqualTo(DEFAULT_SHOWCASE_CHUNK_GRANULARITY);
  }

  @Test
  void testStartUpload_withQueryParamsAndPayload_returnsValidSession() throws Exception {
    Map<String, List<String>> queryParams = new HashMap<>();
    queryParams.put("uploadType", Collections.singletonList("resumable"));
    queryParams.put("name", Collections.singletonList("custom-upload.txt"));

    ShowcaseUploadRequest request =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"contentType\":\"text/plain\"}")
            .setQueryParams(queryParams)
            .build();

    ResumableUploadSession session = uploadClient.startUploadCallable().call(request);

    assertThat(session.getUploadUrl()).isNotNull();
    assertThat(session.getUploadUrl()).contains("sid=");
    assertThat(session.getChunkGranularity()).isEqualTo(DEFAULT_SHOWCASE_CHUNK_GRANULARITY);
  }

  @Test
  void testStartUpload_fatalErrorScenario_throwsException() {
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of("X-Goog-Test-Scenario", ImmutableList.of("fatal_error_on_start"));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    ShowcaseUploadRequest request =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"test-fail.txt\"}")
            .build();

    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.startUploadCallable().futureCall(request, callContext).get());

    assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
    UnavailableException unavailableException = (UnavailableException) exception.getCause();
    assertThat(unavailableException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.UNAVAILABLE);
    assertThat(unavailableException.getStatusCode().getTransportCode()).isEqualTo(503);
  }

  @Test
  void testStartUpload_customChunkGranularityScenario_parsesGranularity() throws Exception {
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of("X-Goog-Test-Scenario", ImmutableList.of("chunk_granularity"));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    ShowcaseUploadRequest request =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"test-granularity.txt\"}")
            .build();

    ResumableUploadSession session = uploadClient.startUploadCallable().call(request, callContext);

    assertThat(session.getUploadUrl()).isNotNull();
    assertThat(session.getUploadUrl()).contains("sid=");
    assertThat(session.getChunkGranularity()).isEqualTo(256L);
  }

  @Test
  void testStartUpload_caseInsensitiveHeadersScenario_success() throws Exception {
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of("x-goog-test-scenario", ImmutableList.of("chunk_granularity"));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    ShowcaseUploadRequest request =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"test-case-insensitivity.txt\"}")
            .build();

    ResumableUploadSession session = uploadClient.startUploadCallable().call(request, callContext);

    assertThat(session.getUploadUrl()).isNotNull();
    assertThat(session.getUploadUrl()).contains("sid=");
    assertThat(session.getChunkGranularity()).isEqualTo(256L);
  }

  @Test
  void testUploadChunk_singleChunk_happyPath_finalizesUpload() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"single-chunk-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    byte[] payload = "hello world".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(payload)
            .setOffset(0L)
            .setFinal(true)
            .build();

    ChunkUploadResponse<String> response = uploadClient.uploadChunkCallable().call(chunkRequest);

    assertThat(response.isComplete()).isTrue();
    assertThat(response.getResponse()).isNotNull();
    assertThat(response.getResponse()).contains("\"size\":11");
  }

  @Test
  void testUploadChunk_multiChunk_happyPath_completesSuccessfully() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"multi-chunk-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Chunk 1 (intermediate)
    byte[] chunk1Payload = "first-chunk-".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunk1Request =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(chunk1Payload)
            .setOffset(0L)
            .setFinal(false)
            .build();

    ChunkUploadResponse<String> chunk1Response =
        uploadClient.uploadChunkCallable().call(chunk1Request);

    assertThat(chunk1Response.isComplete()).isFalse();
    assertThat(chunk1Response.getResponse()).isNull();

    // Chunk 2 (final)
    byte[] chunk2Payload = "second-chunk".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunk2Request =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(chunk2Payload)
            .setOffset(12L)
            .setFinal(true)
            .build();

    ChunkUploadResponse<String> chunk2Response =
        uploadClient.uploadChunkCallable().call(chunk2Request);

    assertThat(chunk2Response.isComplete()).isTrue();
    assertThat(chunk2Response.getResponse()).isNotNull();
    assertThat(chunk2Response.getResponse()).contains("\"size\":24");
  }

  @Test
  void testUploadChunk_multiChunkWithSeparateZeroByteFinalize_completesSuccessfully()
      throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"separate-finalize-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Chunk 1 (intermediate, 12 bytes)
    byte[] chunk1Payload = "hello-world-".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunk1Request =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(chunk1Payload)
            .setOffset(0L)
            .setFinal(false)
            .build();

    ChunkUploadResponse<String> chunk1Response =
        uploadClient.uploadChunkCallable().call(chunk1Request);
    assertThat(chunk1Response.isComplete()).isFalse();

    // Chunk 2 (0-byte separate finalize request)
    ChunkUploadRequest finalizeRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(new byte[0])
            .setOffset(12L)
            .setFinal(true)
            .build();

    ChunkUploadResponse<String> finalizeResponse =
        uploadClient.uploadChunkCallable().call(finalizeRequest);

    assertThat(finalizeResponse.isComplete()).isTrue();
    assertThat(finalizeResponse.getResponse()).isNotNull();
    assertThat(finalizeResponse.getResponse()).contains("\"size\":12");
  }

  @Test
  void testUploadChunk_zeroByteUpload_finalizesSuccessfully() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"zero-byte-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(new byte[0])
            .setOffset(0L)
            .setFinal(true)
            .build();

    ChunkUploadResponse<String> response = uploadClient.uploadChunkCallable().call(chunkRequest);

    assertThat(response.isComplete()).isTrue();
    assertThat(response.getResponse()).isNotNull();
    assertThat(response.getResponse()).contains("\"size\":0");
  }

  @Test
  void testUploadChunk_offsetMismatch_throwsException() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"offset-mismatch-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    byte[] payload = "mismatched data".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(payload)
            .setOffset(100L)
            .setFinal(false)
            .build();

    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.uploadChunkCallable().futureCall(chunkRequest).get());

    assertThat(exception.getCause()).isInstanceOf(AbortedException.class);
    AbortedException abortedException = (AbortedException) exception.getCause();
    assertThat(abortedException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.ABORTED);
    assertThat(abortedException.getStatusCode().getTransportCode()).isEqualTo(409);
  }

  @Test
  void testUploadChunk_chunkGranularityScenario_enforcesAlignment() throws Exception {
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of("X-Goog-Test-Scenario", ImmutableList.of("chunk_granularity"));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"granularity-chunks.txt\"}")
            .build();
    ResumableUploadSession session =
        uploadClient.startUploadCallable().call(startRequest, callContext);

    assertThat(session.getChunkGranularity()).isEqualTo(256L);

    // 1. Unaligned intermediate chunk (100 bytes is not a multiple of 256) should fail with 400 Bad
    // Request
    byte[] unalignedPayload = new byte[100];
    ChunkUploadRequest unalignedRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(unalignedPayload)
            .setOffset(0L)
            .setFinal(false)
            .build();

    ExecutionException unalignedException =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.uploadChunkCallable().futureCall(unalignedRequest).get());

    assertThat(unalignedException.getCause()).isInstanceOf(InvalidArgumentException.class);
    InvalidArgumentException invalidArgumentException =
        (InvalidArgumentException) unalignedException.getCause();
    assertThat(invalidArgumentException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
    assertThat(invalidArgumentException.getStatusCode().getTransportCode()).isEqualTo(400);

    // 2. Aligned intermediate chunk (256 bytes) should succeed
    byte[] alignedPayload = new byte[256];
    ChunkUploadRequest alignedRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(alignedPayload)
            .setOffset(0L)
            .setFinal(false)
            .build();

    ChunkUploadResponse<String> alignedResponse =
        uploadClient.uploadChunkCallable().call(alignedRequest);

    assertThat(alignedResponse.isComplete()).isFalse();

    // 3. Final chunk of arbitrary size (50 bytes) at offset 256 should succeed
    byte[] finalPayload = new byte[50];
    ChunkUploadRequest finalRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(finalPayload)
            .setOffset(256L)
            .setFinal(true)
            .build();

    ChunkUploadResponse<String> finalResponse =
        uploadClient.uploadChunkCallable().call(finalRequest);

    assertThat(finalResponse.isComplete()).isTrue();
    assertThat(finalResponse.getResponse()).isNotNull();
    assertThat(finalResponse.getResponse()).contains("\"size\":306");
  }

  @Test
  void testUploadChunk_nonFatalErrorScenario_recoversOnRetry() throws Exception {
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_chunk_upload"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of("{\"error_code\":503,\"failure_count\":1,\"after_offset\":0}"));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"retry-test.txt\"}")
            .build();
    ResumableUploadSession session =
        uploadClient.startUploadCallable().call(startRequest, callContext);

    byte[] payload = "resilient-data".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(payload)
            .setOffset(0L)
            .setFinal(true)
            .build();

    // First attempt fails with injected 503
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.uploadChunkCallable().futureCall(chunkRequest).get());

    assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
    UnavailableException unavailableException = (UnavailableException) exception.getCause();
    assertThat(unavailableException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.UNAVAILABLE);
    assertThat(unavailableException.getStatusCode().getTransportCode()).isEqualTo(503);

    // Second attempt succeeds after exhausting failure_count=1
    ChunkUploadResponse<String> response = uploadClient.uploadChunkCallable().call(chunkRequest);

    assertThat(response.isComplete()).isTrue();
    assertThat(response.getResponse()).isNotNull();
    assertThat(response.getResponse()).contains("\"size\":14");
  }

  @Test
  void testUploadChunk_uploadAfterFinalize_throwsException() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"finalize-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    byte[] payload = "initial".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest finalChunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(payload)
            .setOffset(0L)
            .setFinal(true)
            .build();

    ChunkUploadResponse<String> response =
        uploadClient.uploadChunkCallable().call(finalChunkRequest);
    assertThat(response.isComplete()).isTrue();

    // Subsequent upload attempt to finalized session should return 400 Bad Request
    byte[] morePayload = "extra".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest extraChunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(morePayload)
            .setOffset(7L)
            .setFinal(false)
            .build();

    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.uploadChunkCallable().futureCall(extraChunkRequest).get());

    assertThat(exception.getCause()).isInstanceOf(InvalidArgumentException.class);
    InvalidArgumentException invalidArgumentException =
        (InvalidArgumentException) exception.getCause();
    assertThat(invalidArgumentException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
    assertThat(invalidArgumentException.getStatusCode().getTransportCode()).isEqualTo(400);
  }

  @Test
  void testUploadChunk_invalidSessionUrl_throwsException() {
    String invalidUrl = DEFAULT_HTTPJSON_ENDPOINT + "/upload?sid=non-existent-sid";
    byte[] payload = "orphan data".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(invalidUrl)
            .setPayload(payload)
            .setOffset(0L)
            .setFinal(false)
            .build();

    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.uploadChunkCallable().futureCall(chunkRequest).get());

    assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
    NotFoundException notFoundException = (NotFoundException) exception.getCause();
    assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    assertThat(notFoundException.getStatusCode().getTransportCode()).isEqualTo(404);
  }

  @Test
  void testQueryStatus_newSession_returnsZeroOffsetAndActiveStatus() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-status-new-session.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());
    QueryStatusResponse<String> queryResponse =
        uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(queryResponse.isComplete()).isFalse();
    assertThat(queryResponse.getCommittedOffset()).isEqualTo(0L);
    assertThat(queryResponse.getResponse()).isNull();
  }

  @Test
  void testQueryStatus_afterIntermediateChunk_returnsCommittedOffset() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-status-intermediate.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Upload intermediate chunk (15 bytes)
    byte[] payload = "intermediate-15".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(payload)
            .setOffset(0L)
            .setFinal(false)
            .build();
    ChunkUploadResponse<String> chunkResponse =
        uploadClient.uploadChunkCallable().call(chunkRequest);
    assertThat(chunkResponse.isComplete()).isFalse();

    // Query status should report active and 15 bytes committed
    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());
    QueryStatusResponse<String> queryResponse =
        uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(queryResponse.isComplete()).isFalse();
    assertThat(queryResponse.getCommittedOffset()).isEqualTo(15L);
    assertThat(queryResponse.getResponse()).isNull();
  }

  @Test
  void testQueryStatus_finalizedSession_returnsCompleteAndResponseBody() throws Exception {
    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-status-finalized.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Upload final chunk (13 bytes)
    byte[] payload = "final-payload".getBytes(StandardCharsets.UTF_8);
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.newBuilder()
            .setUploadUrl(session.getUploadUrl())
            .setPayload(payload)
            .setOffset(0L)
            .setFinal(true)
            .build();
    ChunkUploadResponse<String> chunkResponse =
        uploadClient.uploadChunkCallable().call(chunkRequest);
    assertThat(chunkResponse.isComplete()).isTrue();

    // Query status on finalized session
    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());
    QueryStatusResponse<String> queryResponse =
        uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(queryResponse.isComplete()).isTrue();
    assertThat(queryResponse.getResponse()).isNotNull();
    assertThat(queryResponse.getResponse()).contains("\"size\":13");
  }

  @Test
  void testQueryStatus_nonFatalErrorScenario_recoversOnRetry() throws Exception {
    Map<String, List<String>> extraHeaders =
        ImmutableMap.of(
            "X-Goog-Test-Scenario",
            ImmutableList.of("non_fatal_error_on_query"),
            "X-Goog-Test-Scenario-Config",
            ImmutableList.of("{\"error_code\":503,\"failure_count\":1}"));
    ApiCallContext callContext = HttpJsonCallContext.createDefault().withExtraHeaders(extraHeaders);

    ShowcaseUploadRequest startRequest =
        ShowcaseUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-retry-test.txt\"}")
            .build();
    ResumableUploadSession session =
        uploadClient.startUploadCallable().call(startRequest, callContext);

    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());

    // First attempt fails with injected 503
    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.queryStatusCallable().futureCall(queryRequest).get());

    assertThat(exception.getCause()).isInstanceOf(UnavailableException.class);
    UnavailableException unavailableException = (UnavailableException) exception.getCause();
    assertThat(unavailableException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.UNAVAILABLE);
    assertThat(unavailableException.getStatusCode().getTransportCode()).isEqualTo(503);

    // Second attempt succeeds after exhausting failure_count=1
    QueryStatusResponse<String> response = uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(response.isComplete()).isFalse();
    assertThat(response.getCommittedOffset()).isEqualTo(0L);
    assertThat(response.getResponse()).isNull();
  }

  @Test
  void testQueryStatus_invalidSessionUrl_throwsException() {
    String invalidUrl = DEFAULT_HTTPJSON_ENDPOINT + "/upload?sid=non-existent-sid";
    QueryStatusRequest queryRequest = QueryStatusRequest.create(invalidUrl);

    ExecutionException exception =
        assertThrows(
            ExecutionException.class,
            () -> uploadClient.queryStatusCallable().futureCall(queryRequest).get());

    assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
    NotFoundException notFoundException = (NotFoundException) exception.getCause();
    assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    assertThat(notFoundException.getStatusCode().getTransportCode()).isEqualTo(404);
  }
}
