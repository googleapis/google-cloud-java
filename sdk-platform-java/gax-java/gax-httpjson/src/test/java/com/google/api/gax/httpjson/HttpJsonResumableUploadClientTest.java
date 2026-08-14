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

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.InternalApi;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Strings;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@InternalApi
class HttpJsonResumableUploadClientTest {

  private static final String TEST_UPLOAD_URL =
      "https://test.googleapis.com/upload/session/test-session-id";

  private static ExecutorService executorService;

  @BeforeAll
  static void setUp() {
    executorService = Executors.newFixedThreadPool(2);
  }

  @AfterAll
  static void tearDown() {
    executorService.shutdownNow();
  }

  @Nested
  class StartUpload {

    @Test
    void startUpload_validHeaders_returnsSession() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-URL", TEST_UPLOAD_URL);
      httpResponse.addHeader("X-Goog-Upload-Chunk-Granularity", "262144");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      TestRequest request = new TestRequest("upload/v1/resources");

      ResumableUploadSession session = client.startUploadCallable().call(request);

      assertThat(session.getUploadUrl()).isEqualTo(TEST_UPLOAD_URL);
      assertThat(session.getChunkGranularity()).isEqualTo(262144L);
    }

    @Test
    void startUpload_caseInsensitiveHeaders_returnsSession() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader(
          "x-goog-upload-url", "https://test.googleapis.com/upload/session/case-insensitive");
      httpResponse.addHeader("x-goog-upload-chunk-granularity", "524288");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      TestRequest request = new TestRequest("upload/v1/resources");

      ResumableUploadSession session = client.startUploadCallable().call(request);

      assertThat(session.getUploadUrl())
          .isEqualTo("https://test.googleapis.com/upload/session/case-insensitive");
      assertThat(session.getChunkGranularity()).isEqualTo(524288L);
    }

    @Test
    void startUpload_malformedChunkGranularityHeader_throwsException() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-URL", TEST_UPLOAD_URL);
      httpResponse.addHeader("X-Goog-Upload-Chunk-Granularity", "not-a-number");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      TestRequest request = new TestRequest("upload/v1/resources");

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.startUploadCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(InternalException.class);
      assertThat(exception.getCause().getCause()).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void startUpload_nonPositiveChunkGranularityHeader_throwsException() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-URL", TEST_UPLOAD_URL);
      httpResponse.addHeader("X-Goog-Upload-Chunk-Granularity", "-256");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      TestRequest request = new TestRequest("upload/v1/resources");

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.startUploadCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(InternalException.class);
      assertThat(exception.getCause())
          .hasMessageThat()
          .contains("Start upload response contained non-positive chunk granularity header: -256");
    }

    @Test
    void startUpload_missingSessionUrlHeader_throwsException() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-Chunk-Granularity", "262144");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      TestRequest request = new TestRequest("upload/v1/resources");

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.startUploadCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(InternalException.class);
      assertThat(exception.getCause())
          .hasMessageThat()
          .contains("Start upload response did not contain upload session URL header");
    }

    @Test
    void startUpload_withPayloadAndQueryParams_sendsCorrectRequest() {
      MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
      response.setStatusCode(200);
      response.addHeader("X-Goog-Upload-URL", TEST_UPLOAD_URL);

      CapturingHttpTransport transport = new CapturingHttpTransport(response);
      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(transport);

      Map<String, List<String>> queryParams =
          Collections.singletonMap("uploadType", Collections.singletonList("resumable"));
      TestRequest request =
          new TestRequest("upload/v1/resources", "{\"name\":\"my-resource.txt\"}", queryParams);

      client.startUploadCallable().call(request);

      assertThat(transport.capturedUrl)
          .isEqualTo("https://test.googleapis.com/upload/v1/resources?uploadType=resumable");
      assertThat(transport.capturedContent).isEqualTo("{\"name\":\"my-resource.txt\"}");
      assertThat(transport.capturedHeaders.get("x-goog-upload-protocol"))
          .containsExactly("resumable");
      assertThat(transport.capturedHeaders.get("x-goog-upload-command")).containsExactly("start");
    }

    @Test
    void startUpload_serverReturnsError_throwsApiException() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(404);
      httpResponse.setContent("{\"error\":{\"message\":\"Resource not found\"}}");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      TestRequest request = new TestRequest("upload/v1/nonexistent");

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.startUploadCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
      NotFoundException notFoundException = (NotFoundException) exception.getCause();
      assertThat(notFoundException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    }

    @Test
    void startUpload_withCustomExtraHeaders_preservesHeaders() {
      MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
      response.setStatusCode(200);
      response.addHeader("X-Goog-Upload-URL", TEST_UPLOAD_URL);

      CapturingHttpTransport transport = new CapturingHttpTransport(response);
      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(transport);

      TestRequest request = new TestRequest("upload/v1/resources");
      Map<String, List<String>> customHeaders =
          Collections.singletonMap("X-Custom-Header", Collections.singletonList("CustomValue"));

      ApiCallContext callContext =
          HttpJsonCallContext.createDefault().withExtraHeaders(customHeaders);

      client.startUploadCallable().call(request, callContext);

      assertThat(transport.capturedHeaders.get("x-custom-header")).containsExactly("CustomValue");
    }
  }

  @Nested
  class UploadChunk {

    @Test
    void uploadChunk_intermediateChunk_sendsUploadCommandAndReturnsActiveStatus() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-Status", "active");
      httpResponse.addHeader("X-Goog-Upload-Size-Received", "262144");

      CapturingHttpTransport transport = new CapturingHttpTransport(httpResponse);
      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(transport);

      ByteString payload = ByteString.copyFromUtf8("hello chunk data");
      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(payload)
              .setOffset(0L)
              .setFinal(false)
              .build();

      ChunkUploadResponse<String> response = client.uploadChunkCallable().call(request);

      assertThat(response.isComplete()).isFalse();
      assertThat(response.getCommittedOffset()).isEqualTo(262144L);
      assertThat(response.getResponse()).isNull();

      assertThat(transport.capturedUrl).isEqualTo(TEST_UPLOAD_URL);
      assertThat(transport.capturedHeaders.get("x-goog-upload-command")).containsExactly("upload");
      assertThat(transport.capturedHeaders.get("x-goog-upload-offset")).containsExactly("0");
    }

    @Test
    void uploadChunk_finalChunk_sendsUploadFinalizeAndReturnsResponseBody() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-Status", "final");
      httpResponse.addHeader("X-Goog-Upload-Size-Received", "524288");
      httpResponse.setContent("{\"name\":\"uploaded-file.txt\",\"size\":524288}");

      CapturingHttpTransport transport = new CapturingHttpTransport(httpResponse);
      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(transport);

      ByteString payload = ByteString.copyFromUtf8("final chunk data");
      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(payload)
              .setOffset(262144L)
              .setFinal(true)
              .build();

      ChunkUploadResponse<String> response = client.uploadChunkCallable().call(request);

      assertThat(response.isComplete()).isTrue();
      assertThat(response.getCommittedOffset()).isEqualTo(524288L);
      assertThat(response.getResponse())
          .isEqualTo("{\"name\":\"uploaded-file.txt\",\"size\":524288}");

      assertThat(transport.capturedHeaders.get("x-goog-upload-command"))
          .containsExactly("upload, finalize");
      assertThat(transport.capturedHeaders.get("x-goog-upload-offset")).containsExactly("262144");
    }

    @Test
    void uploadChunk_emptyPayloadFinal_sendsFinalizeCommandAndReturnsResponseBody() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-Status", "final");
      httpResponse.addHeader("X-Goog-Upload-Size-Received", "1048576");
      httpResponse.setContent("{\"name\":\"uploaded-file.txt\",\"size\":1048576}");

      CapturingHttpTransport transport = new CapturingHttpTransport(httpResponse);
      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(transport);

      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(ByteString.EMPTY)
              .setOffset(1048576L)
              .setFinal(true)
              .build();

      ChunkUploadResponse<String> response = client.uploadChunkCallable().call(request);

      assertThat(response.isComplete()).isTrue();
      assertThat(response.getCommittedOffset()).isEqualTo(1048576L);
      assertThat(response.getResponse())
          .isEqualTo("{\"name\":\"uploaded-file.txt\",\"size\":1048576}");

      assertThat(transport.capturedHeaders.get("x-goog-upload-command"))
          .containsExactly("finalize");
      assertThat(transport.capturedHeaders.get("x-goog-upload-offset")).containsExactly("1048576");
    }

    @Test
    void uploadChunk_withCustomExtraHeaders_preservesHeaders() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-Status", "active");

      CapturingHttpTransport transport = new CapturingHttpTransport(httpResponse);
      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(transport);

      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(ByteString.copyFromUtf8("data"))
              .setOffset(0L)
              .build();

      Map<String, List<String>> customHeaders =
          Collections.singletonMap(
              "X-Custom-Chunk-Header", Collections.singletonList("CustomChunkValue"));

      ApiCallContext callContext =
          HttpJsonCallContext.createDefault().withExtraHeaders(customHeaders);

      client.uploadChunkCallable().call(request, callContext);

      assertThat(transport.capturedHeaders.get("x-custom-chunk-header"))
          .containsExactly("CustomChunkValue");
    }

    @Test
    void uploadChunk_serverReturnsConflictOrError_throwsException() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(409);
      httpResponse.setContent("{\"error\":{\"message\":\"Invalid offset\"}}");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(ByteString.copyFromUtf8("data"))
              .setOffset(100L)
              .build();

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.uploadChunkCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(AbortedException.class);
      AbortedException abortedException = (AbortedException) exception.getCause();
      assertThat(abortedException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.ABORTED);
    }

    @Test
    void uploadChunk_missingSizeReceivedHeader_calculatesFromPayload() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);
      httpResponse.addHeader("X-Goog-Upload-Status", "active");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      ByteString payload = ByteString.copyFromUtf8("1234567890");
      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(payload)
              .setOffset(50L)
              .build();

      ChunkUploadResponse<String> response = client.uploadChunkCallable().call(request);

      assertThat(response.getCommittedOffset()).isEqualTo(60L);
      assertThat(response.isComplete()).isFalse();
      assertThat(response.getResponse()).isNull();
    }

    @Test
    void uploadChunk_missingUploadStatusHeader_throwsInternalException() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(200);

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(ByteString.copyFromUtf8("data"))
              .setOffset(0L)
              .build();

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.uploadChunkCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(InternalException.class);
      assertThat(exception.getCause())
          .hasMessageThat()
          .contains("Upload chunk response did not contain valid X-Goog-Upload-Status header");
    }

    @Test
    void uploadChunk_serverReturnsFinalStatusOnNon200_marksExceptionNonRetryable() {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(503);
      httpResponse.addHeader("X-Goog-Upload-Status", "final");
      httpResponse.setContent("{\"error\":{\"message\":\"Upload rejected by backend\"}}");

      HttpJsonResumableUploadClient<TestRequest, String> client = createClient(httpResponse);
      ChunkUploadRequest request =
          ChunkUploadRequest.newBuilder()
              .setUploadUrl(TEST_UPLOAD_URL)
              .setPayload(ByteString.copyFromUtf8("data"))
              .setOffset(0L)
              .build();

      ExecutionException exception =
          assertThrows(
              ExecutionException.class,
              () -> client.uploadChunkCallable().futureCall(request).get());

      assertThat(exception.getCause()).isInstanceOf(ApiException.class);
      ApiException apiException = (ApiException) exception.getCause();
      assertThat(apiException.isRetryable()).isFalse();
      assertThat(apiException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
    }
  }

  private static HttpJsonResumableUploadClient<TestRequest, String> createClient(
      HttpTransport transport) {
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

    return HttpJsonResumableUploadClient.create(clientContext, TEST_METHOD_DESCRIPTOR);
  }

  private static HttpJsonResumableUploadClient<TestRequest, String> createClient(
      MockLowLevelHttpResponse response) {
    return createClient(new MockHttpTransport.Builder().setLowLevelHttpResponse(response).build());
  }

  /** A mock transport that captures request URL, headers, and body for verification. */
  private static class CapturingHttpTransport extends MockHttpTransport {
    private final MockLowLevelHttpResponse response;
    final Map<String, List<String>> capturedHeaders = new HashMap<>();
    @Nullable String capturedUrl;
    @Nullable String capturedContent;

    CapturingHttpTransport(MockLowLevelHttpResponse response) {
      this.response = response;
    }

    @Override
    public LowLevelHttpRequest buildRequest(String method, String url) {
      this.capturedUrl = url;
      return new MockLowLevelHttpRequest() {
        @Override
        public LowLevelHttpResponse execute() throws IOException {
          capturedHeaders.putAll(getHeaders());
          capturedContent = getContentAsString();
          return response;
        }
      };
    }
  }

  private static final ApiMethodDescriptor<TestRequest, String> TEST_METHOD_DESCRIPTOR =
      ApiMethodDescriptor.<TestRequest, String>newBuilder()
          .setFullMethodName("ResumableUpload/StartUpload")
          .setHttpMethod(HttpMethods.POST)
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              new HttpRequestFormatter<TestRequest>() {
                @Override
                public Map<String, List<String>> getQueryParamNames(TestRequest request) {
                  return request.queryParams;
                }

                @Override
                public String getRequestBody(TestRequest request) {
                  return Strings.nullToEmpty(request.jsonPayload);
                }

                @Override
                public String getPath(TestRequest request) {
                  return request.path;
                }

                @Override
                public PathTemplate getPathTemplate() {
                  return PathTemplate.create("{+path}");
                }
              })
          .setResponseParser(ResumableUploadResponseParser.create())
          .build();

  private static class TestRequest {
    final String path;
    @Nullable final String jsonPayload;
    final Map<String, List<String>> queryParams;

    TestRequest(String path) {
      this(path, null, Collections.emptyMap());
    }

    TestRequest(String path, @Nullable String jsonPayload, Map<String, List<String>> queryParams) {
      this.path = path;
      this.jsonPayload = jsonPayload;
      this.queryParams = queryParams;
    }
  }
}
