/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HttpJsonResumableUploadClientTest {

  private static ExecutorService executorService;

  @BeforeAll
  static void setUp() {
    executorService = Executors.newFixedThreadPool(2);
  }

  @AfterAll
  static void tearDown() {
    executorService.shutdownNow();
  }

  private static HttpJsonResumableUploadClient createClient(HttpTransport transport) {
    ManagedHttpJsonChannel channel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint("test.googleapis.com")
            .setExecutor(executorService)
            .setHttpTransport(transport)
            .build();

    ClientContext clientContext =
        ClientContext.newBuilder()
            .setTransportChannel(HttpJsonTransportChannel.create(channel))
            .setDefaultCallContext(HttpJsonCallContext.createDefault().withChannel(channel))
            .build();

    return HttpJsonResumableUploadClient.create(clientContext);
  }

  private static HttpJsonResumableUploadClient createClient(MockLowLevelHttpResponse response) {
    return createClient(new MockHttpTransport.Builder().setLowLevelHttpResponse(response).build());
  }

  @Test
  void startUpload_withUploadUrlHeader_success() {
    MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.addHeader("X-Goog-Upload-URL", "https://test.googleapis.com/upload/session/abc");
    httpResponse.addHeader("X-Goog-Upload-Chunk-Granularity", "262144");

    HttpJsonResumableUploadClient client = createClient(httpResponse);
    StartUploadRequest request = StartUploadRequest.create("upload/v1/resources");

    ResumableUploadSession session = client.startUploadCallable().call(request);

    assertThat(session.getUploadUrl()).isEqualTo("https://test.googleapis.com/upload/session/abc");
    assertThat(session.getChunkGranularity()).isEqualTo(262144L);
  }

  @Test
  void startUpload_withLocationHeaderFallback_success() {
    MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.addHeader("Location", "https://test.googleapis.com/upload/session/xyz");

    HttpJsonResumableUploadClient client = createClient(httpResponse);
    StartUploadRequest request = StartUploadRequest.create("/upload/v1/resources");

    ResumableUploadSession session = client.startUploadCallable().call(request);

    assertThat(session.getUploadUrl()).isEqualTo("https://test.googleapis.com/upload/session/xyz");
    assertThat(session.getChunkGranularity()).isEqualTo(1L);
  }

  @Test
  void startUpload_caseInsensitiveHeaders_success() {
    MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.addHeader(
        "x-goog-upload-url", "https://test.googleapis.com/upload/session/case-insensitive");
    httpResponse.addHeader("x-goog-upload-chunk-granularity", "524288");

    HttpJsonResumableUploadClient client = createClient(httpResponse);
    StartUploadRequest request = StartUploadRequest.create("upload/v1/resources");

    ResumableUploadSession session = client.startUploadCallable().call(request);

    assertThat(session.getUploadUrl())
        .isEqualTo("https://test.googleapis.com/upload/session/case-insensitive");
    assertThat(session.getChunkGranularity()).isEqualTo(524288L);
  }

  @Test
  void startUpload_missingSessionUrlHeader_throwsException() {
    MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
    httpResponse.setStatusCode(200);

    HttpJsonResumableUploadClient client = createClient(httpResponse);
    StartUploadRequest request = StartUploadRequest.create("upload/v1/resources");

    ExecutionException exception =
        assertThrows(
            ExecutionException.class, () -> client.startUploadCallable().futureCall(request).get());

    assertThat(exception.getCause()).isInstanceOf(InternalException.class);
    assertThat(exception.getCause())
        .hasMessageThat()
        .contains("Start upload response did not contain upload session URL header");
  }

  @Test
  void startUpload_withJsonPayloadAndQueryParams_sendsCorrectRequest() {
    Map<String, List<String>> capturedHeaders = new HashMap<>();
    String[] capturedUrl = new String[1];
    String[] capturedContent = new String[1];

    HttpTransport httpTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            capturedUrl[0] = url;
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                capturedHeaders.putAll(getHeaders());
                capturedContent[0] = getContentAsString();
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                response.addHeader(
                    "X-Goog-Upload-URL", "https://test.googleapis.com/upload/session/123");
                return response;
              }
            };
          }
        };

    HttpJsonResumableUploadClient client = createClient(httpTransport);
    Map<String, List<String>> queryParams = new HashMap<>();
    queryParams.put("uploadType", Collections.singletonList("resumable"));
    queryParams.put("name", Collections.singletonList("my-resource.txt"));

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
            .setPath("upload/v1/resources")
            .setJsonPayload("{\"contentType\":\"text/plain\"}")
            .setQueryParams(queryParams)
            .build();

    ResumableUploadSession session = client.startUploadCallable().call(request);

    assertThat(session.getUploadUrl()).isEqualTo("https://test.googleapis.com/upload/session/123");
    assertThat(capturedUrl[0]).contains("https://test.googleapis.com/upload/v1/resources");
    assertThat(capturedUrl[0]).contains("uploadType=resumable");
    assertThat(capturedUrl[0]).contains("name=my-resource.txt");
    assertThat(capturedContent[0]).isEqualTo("{\"contentType\":\"text/plain\"}");
    assertThat(capturedHeaders).containsKey("x-goog-upload-protocol");
    assertThat(capturedHeaders.get("x-goog-upload-protocol")).contains("resumable");
    assertThat(capturedHeaders).containsKey("x-goog-upload-command");
    assertThat(capturedHeaders.get("x-goog-upload-command")).contains("start");
  }

  @Test
  void startUpload_serverReturnsError_throwsApiException() {
    MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
    httpResponse.setStatusCode(404);
    httpResponse.setContent("{\"error\":{\"message\":\"Resource not found\"}}");

    HttpJsonResumableUploadClient client = createClient(httpResponse);
    StartUploadRequest request = StartUploadRequest.create("upload/v1/nonexistent");

    ExecutionException exception =
        assertThrows(
            ExecutionException.class, () -> client.startUploadCallable().futureCall(request).get());

    assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
    NotFoundException notFoundException = (NotFoundException) exception.getCause();
    assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
  }

  @Test
  void startUpload_withCustomExtraHeaders_preservesHeaders() {
    Map<String, List<String>> capturedHeaders = new HashMap<>();

    HttpTransport httpTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                capturedHeaders.putAll(getHeaders());
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                response.addHeader(
                    "X-Goog-Upload-URL", "https://test.googleapis.com/upload/session/custom");
                return response;
              }
            };
          }
        };

    HttpJsonResumableUploadClient client = createClient(httpTransport);
    StartUploadRequest request = StartUploadRequest.create("upload/v1/resources");

    Map<String, List<String>> customHeaders = new HashMap<>();
    customHeaders.put("X-Custom-Header", Collections.singletonList("CustomValue"));

    ApiCallContext callContext =
        HttpJsonCallContext.createDefault().withExtraHeaders(customHeaders);

    ResumableUploadSession session = client.startUploadCallable().call(request, callContext);

    assertThat(session.getUploadUrl())
        .isEqualTo("https://test.googleapis.com/upload/session/custom");
    assertThat(capturedHeaders).containsKey("x-custom-header");
    assertThat(capturedHeaders.get("x-custom-header")).contains("CustomValue");
    assertThat(capturedHeaders).containsKey("x-goog-upload-protocol");
    assertThat(capturedHeaders.get("x-goog-upload-protocol")).contains("resumable");
  }
}
