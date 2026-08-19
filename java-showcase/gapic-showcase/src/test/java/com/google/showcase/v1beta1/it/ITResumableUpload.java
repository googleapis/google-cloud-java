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

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonResumableUploadClient;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
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
class ITResumableUpload {

  private static final String DEFAULT_HTTPJSON_ENDPOINT = "http://localhost:7469";
  private static final long DEFAULT_SHOWCASE_CHUNK_GRANULARITY = 256 * 1024L;

  private static ManagedHttpJsonChannel channel;
  private static HttpJsonResumableUploadClient uploadClient;

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

    uploadClient = HttpJsonResumableUploadClient.create(clientContext);
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
    StartUploadRequest request =
        StartUploadRequest.newBuilder()
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

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
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

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
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

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
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

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
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
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"single-chunk-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    ByteString payload = ByteString.copyFromUtf8("hello world");
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), payload, 0L, true);

    ChunkUploadResponse response = uploadClient.uploadChunkCallable().call(chunkRequest);

    assertThat(response.isComplete()).isTrue();
    assertThat(response.getCommittedOffset()).isEqualTo(11L);
    assertThat(response.getResponseBody()).isNotNull();
    assertThat(response.getResponseBody()).contains("\"size\":11");
  }

  @Test
  void testUploadChunk_multiChunk_happyPath_completesSuccessfully() throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"multi-chunk-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Chunk 1 (intermediate)
    ByteString chunk1Payload = ByteString.copyFromUtf8("first-chunk-");
    ChunkUploadRequest chunk1Request =
        ChunkUploadRequest.create(session.getUploadUrl(), chunk1Payload, 0L, false);

    ChunkUploadResponse chunk1Response = uploadClient.uploadChunkCallable().call(chunk1Request);

    assertThat(chunk1Response.isComplete()).isFalse();
    assertThat(chunk1Response.getCommittedOffset()).isEqualTo(12L);
    assertThat(chunk1Response.getResponseBody()).isEmpty();

    // Chunk 2 (final)
    ByteString chunk2Payload = ByteString.copyFromUtf8("second-chunk");
    ChunkUploadRequest chunk2Request =
        ChunkUploadRequest.create(session.getUploadUrl(), chunk2Payload, 12L, true);

    ChunkUploadResponse chunk2Response = uploadClient.uploadChunkCallable().call(chunk2Request);

    assertThat(chunk2Response.isComplete()).isTrue();
    assertThat(chunk2Response.getCommittedOffset()).isEqualTo(24L);
    assertThat(chunk2Response.getResponseBody()).isNotNull();
    assertThat(chunk2Response.getResponseBody()).contains("\"size\":24");
  }

  @Test
  void testUploadChunk_multiChunkWithSeparateZeroByteFinalize_completesSuccessfully()
      throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"separate-finalize-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Chunk 1 (intermediate, 12 bytes)
    ByteString chunk1Payload = ByteString.copyFromUtf8("hello-world-");
    ChunkUploadRequest chunk1Request =
        ChunkUploadRequest.create(session.getUploadUrl(), chunk1Payload, 0L, false);

    ChunkUploadResponse chunk1Response = uploadClient.uploadChunkCallable().call(chunk1Request);
    assertThat(chunk1Response.isComplete()).isFalse();
    assertThat(chunk1Response.getCommittedOffset()).isEqualTo(12L);

    // Chunk 2 (0-byte separate finalize request)
    ChunkUploadRequest finalizeRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), ByteString.EMPTY, 12L, true);

    ChunkUploadResponse finalizeResponse = uploadClient.uploadChunkCallable().call(finalizeRequest);

    assertThat(finalizeResponse.isComplete()).isTrue();
    assertThat(finalizeResponse.getCommittedOffset()).isEqualTo(12L);
    assertThat(finalizeResponse.getResponseBody()).isNotNull();
    assertThat(finalizeResponse.getResponseBody()).contains("\"size\":12");
  }

  @Test
  void testUploadChunk_zeroByteUpload_finalizesSuccessfully() throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"zero-byte-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), ByteString.EMPTY, 0L, true);

    ChunkUploadResponse response = uploadClient.uploadChunkCallable().call(chunkRequest);

    assertThat(response.isComplete()).isTrue();
    assertThat(response.getCommittedOffset()).isEqualTo(0L);
    assertThat(response.getResponseBody()).isNotNull();
    assertThat(response.getResponseBody()).contains("\"size\":0");
  }

  @Test
  void testUploadChunk_offsetMismatch_throwsException() throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"offset-mismatch-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    ByteString payload = ByteString.copyFromUtf8("mismatched data");
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), payload, 100L, false);

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

    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"granularity-chunks.txt\"}")
            .build();
    ResumableUploadSession session =
        uploadClient.startUploadCallable().call(startRequest, callContext);

    assertThat(session.getChunkGranularity()).isEqualTo(256L);

    // 1. Unaligned intermediate chunk (100 bytes is not a multiple of 256) should fail with 400 Bad
    // Request
    ByteString unalignedPayload = ByteString.copyFrom(new byte[100]);
    ChunkUploadRequest unalignedRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), unalignedPayload, 0L, false);

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
    ByteString alignedPayload = ByteString.copyFrom(new byte[256]);
    ChunkUploadRequest alignedRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), alignedPayload, 0L, false);

    ChunkUploadResponse alignedResponse = uploadClient.uploadChunkCallable().call(alignedRequest);

    assertThat(alignedResponse.isComplete()).isFalse();
    assertThat(alignedResponse.getCommittedOffset()).isEqualTo(256L);

    // 3. Final chunk of arbitrary size (50 bytes) at offset 256 should succeed
    ByteString finalPayload = ByteString.copyFrom(new byte[50]);
    ChunkUploadRequest finalRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), finalPayload, 256L, true);

    ChunkUploadResponse finalResponse = uploadClient.uploadChunkCallable().call(finalRequest);

    assertThat(finalResponse.isComplete()).isTrue();
    assertThat(finalResponse.getCommittedOffset()).isEqualTo(306L);
    assertThat(finalResponse.getResponseBody()).isNotNull();
    assertThat(finalResponse.getResponseBody()).contains("\"size\":306");
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

    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"retry-test.txt\"}")
            .build();
    ResumableUploadSession session =
        uploadClient.startUploadCallable().call(startRequest, callContext);

    ByteString payload = ByteString.copyFromUtf8("resilient-data");
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), payload, 0L, true);

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
    ChunkUploadResponse response = uploadClient.uploadChunkCallable().call(chunkRequest);

    assertThat(response.isComplete()).isTrue();
    assertThat(response.getCommittedOffset()).isEqualTo(14L);
    assertThat(response.getResponseBody()).isNotNull();
    assertThat(response.getResponseBody()).contains("\"size\":14");
  }

  @Test
  void testUploadChunk_uploadAfterFinalize_throwsException() throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"finalize-test.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    ByteString payload = ByteString.copyFromUtf8("initial");
    ChunkUploadRequest finalChunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), payload, 0L, true);

    ChunkUploadResponse response = uploadClient.uploadChunkCallable().call(finalChunkRequest);
    assertThat(response.isComplete()).isTrue();

    // Subsequent upload attempt to finalized session should return 400 Bad Request
    ByteString morePayload = ByteString.copyFromUtf8("extra");
    ChunkUploadRequest extraChunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), morePayload, 7L, false);

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
    ByteString payload = ByteString.copyFromUtf8("orphan data");
    ChunkUploadRequest chunkRequest = ChunkUploadRequest.create(invalidUrl, payload, 0L, false);

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
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-status-new-session.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());
    QueryStatusResponse queryResponse = uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(queryResponse.isComplete()).isFalse();
    assertThat(queryResponse.getCommittedOffset()).isEqualTo(0L);
    assertThat(queryResponse.getResponseBody()).isEmpty();
  }

  @Test
  void testQueryStatus_afterIntermediateChunk_returnsCommittedOffset() throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-status-intermediate.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Upload intermediate chunk (15 bytes)
    ByteString payload = ByteString.copyFromUtf8("intermediate-15");
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), payload, 0L, false);
    ChunkUploadResponse chunkResponse = uploadClient.uploadChunkCallable().call(chunkRequest);
    assertThat(chunkResponse.isComplete()).isFalse();
    assertThat(chunkResponse.getCommittedOffset()).isEqualTo(15L);

    // Query status should report active and 15 bytes committed
    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());
    QueryStatusResponse queryResponse = uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(queryResponse.isComplete()).isFalse();
    assertThat(queryResponse.getCommittedOffset()).isEqualTo(15L);
    assertThat(queryResponse.getResponseBody()).isEmpty();
  }

  @Test
  void testQueryStatus_finalizedSession_returnsCompleteAndResponseBody() throws Exception {
    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
            .setPath("v1beta1/files:upload")
            .setJsonPayload("{\"name\":\"query-status-finalized.txt\"}")
            .build();
    ResumableUploadSession session = uploadClient.startUploadCallable().call(startRequest);

    // Upload final chunk (13 bytes)
    ByteString payload = ByteString.copyFromUtf8("final-payload");
    ChunkUploadRequest chunkRequest =
        ChunkUploadRequest.create(session.getUploadUrl(), payload, 0L, true);
    ChunkUploadResponse chunkResponse = uploadClient.uploadChunkCallable().call(chunkRequest);
    assertThat(chunkResponse.isComplete()).isTrue();
    assertThat(chunkResponse.getCommittedOffset()).isEqualTo(13L);

    // Query status on finalized session
    QueryStatusRequest queryRequest = QueryStatusRequest.create(session.getUploadUrl());
    QueryStatusResponse queryResponse = uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(queryResponse.isComplete()).isTrue();
    assertThat(queryResponse.getResponseBody()).isNotNull();
    assertThat(queryResponse.getResponseBody()).contains("\"size\":13");
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

    StartUploadRequest startRequest =
        StartUploadRequest.newBuilder()
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
    QueryStatusResponse response = uploadClient.queryStatusCallable().call(queryRequest);

    assertThat(response.isComplete()).isFalse();
    assertThat(response.getCommittedOffset()).isEqualTo(0L);
    assertThat(response.getResponseBody()).isEmpty();
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
