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
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonResumableUploadClient;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnavailableException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
}
