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

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.InputStreamProvider;
import com.google.api.gax.rpc.ResumableUploadProgressListener;
import com.google.api.gax.rpc.ResumableUploadRequest;
import com.google.api.gax.rpc.ResumableUploadStatus;
import com.google.protobuf.TypeRegistry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HttpJsonResumableUploadCallableTest {

  @Mock private ApiMethodDescriptor<String, String> methodDescriptor;
  @Mock private HttpRequestFormatter<String> requestFormatter;
  @Mock private HttpResponseParser<String> responseParser;
  @Mock private ClientContext clientContext;
  @Mock private HttpJsonTransportChannel transportChannel;
  @Mock private ManagedHttpJsonChannel managedChannel;

  private java.util.concurrent.ScheduledExecutorService executor;

  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
    Mockito.lenient().when(clientContext.getExecutor()).thenReturn(executor);
    Mockito.lenient().when(clientContext.getTransportChannel()).thenReturn(transportChannel);
    Mockito.lenient().when(transportChannel.getManagedChannel()).thenReturn(managedChannel);
    Mockito.lenient().when(managedChannel.getEndpoint()).thenReturn("localhost");

    // Wire formatter and parser mocking
    Mockito.lenient().when(methodDescriptor.getRequestFormatter()).thenReturn(requestFormatter);
    Mockito.lenient().when(methodDescriptor.getResponseParser()).thenReturn(responseParser);
    Mockito.lenient()
        .when(requestFormatter.getPath(Mockito.anyString()))
        .thenReturn("/upload/resource");
    Mockito.lenient()
        .when(requestFormatter.getRequestBody(Mockito.anyString()))
        .thenReturn("{\"metadata\":\"value\"}");
    Mockito.lenient()
        .when(requestFormatter.getQueryParamNames(Mockito.anyString()))
        .thenReturn(Collections.emptyMap());
  }

  @AfterEach
  void tearDown() {
    executor.shutdown();
  }

  @Test
  void happyPathUpload() throws Exception {
    byte[] data = "Hello, World! Resumable upload".getBytes();
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    // Sequence of mock HTTP responses
    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();

    // 1. Session start response
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));

    // 2. Finalize upload response
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"success\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                MockLowLevelHttpResponse response = mockResponses.poll();
                if (response == null) {
                  throw new IOException("Unexpected out-of-bounds mock request: " + url);
                }
                return response;
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_RESPONSE");

    List<ResumableUploadStatus> progressHistory = new ArrayList<>();
    ResumableUploadProgressListener listener = progressHistory::add;

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setTotalBytes(data.length)
            .setProgressListener(listener)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);

    assertThat(response).isEqualTo("SUCCESS_RESPONSE");
    assertThat(progressHistory).isNotEmpty();

    // Verify progress tracking states
    assertThat(progressHistory.get(0).getState())
        .isEqualTo(ResumableUploadProgressListener.State.NOT_STARTED);

    ResumableUploadStatus lastStatus = progressHistory.get(progressHistory.size() - 1);
    assertThat(lastStatus.getState()).isEqualTo(ResumableUploadProgressListener.State.COMPLETED);
    assertThat(lastStatus.getBytesUploaded()).isEqualTo(data.length);
  }

  @Test
  void retryOnTransientStartError() throws Exception {
    byte[] data = "Short stream".getBytes();
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();

    // 1. Session start transient failure (503)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(503)
            .setReasonPhrase("Service Unavailable")
            .setContent(""));

    // 2. Retry start session success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));

    // 3. Finalize upload success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"ok\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("OK_REP");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("OK_REP");
  }

  @Test
  void stateMismatchRecoveryAndResume() throws Exception {
    byte[] data = "First segment of data... Second segment of data".getBytes();
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();

    // 1. Session start success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));

    // 2. Transmit failure with Category 2 (400 Bad Request)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(400)
            .setReasonPhrase("Bad Request - offset mismatch")
            .setContent(""));

    // 3. Query offset command (server has received 24 bytes)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-Size-Received", "24"));

    // 4. Upload rest starting from offset 24 success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"restored\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("RECOVERY_REP");

    List<ResumableUploadStatus> progressHistory = new ArrayList<>();
    ResumableUploadProgressListener listener = progressHistory::add;

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setTotalBytes(data.length)
            .setProgressListener(listener)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);

    assertThat(response).isEqualTo("RECOVERY_REP");

    // Verify recovery state was logged
    boolean hasRecoveringState = false;
    for (ResumableUploadStatus status : progressHistory) {
      if (status.getState() == ResumableUploadProgressListener.State.RECOVERING) {
        hasRecoveringState = true;
        break;
      }
    }
    assertThat(hasRecoveringState).isTrue();
  }

  @Test
  void fatalErrorFailsImmediately() {
    byte[] data = "test data".getBytes();
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();

    // 1. Session start returns 403 Forbidden (Category 3 Fatal)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(403)
            .setReasonPhrase("Forbidden")
            .setContent(""));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    assertThrows(ApiException.class, () -> callable.call(request));
  }

  @Test
  void chunkedUploadHappyPath() throws Exception {
    byte[] data = "0123456789012345678901234".getBytes(); // 25 bytes
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();
    // 1. Session start
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));
    // 2. Chunk 1 (0-10)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 3. Chunk 2 (10-20)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 4. Chunk 3 (20-25)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"chunked_success\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_CHUNKED");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setChunkSize(10)
            .setTotalBytes(data.length)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("SUCCESS_CHUNKED");
  }

  @Test
  void chunkedUploadWithTransientError() throws Exception {
    byte[] data = "012345678901234".getBytes(); // 15 bytes
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();
    // 1. Session start
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));
    // 2. Chunk 1 (0-10) -> Transient 503 error
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(503)
            .setReasonPhrase("Service Unavailable")
            .setContent(""));
    // 3. Retry Chunk 1 (0-10) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 4. Chunk 2 (10-15) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"transient_retry_success\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_TRANSIENT");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setChunkSize(10)
            .setTotalBytes(data.length)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("SUCCESS_TRANSIENT");
  }

  @Test
  void chunkedUploadWithMismatchRecoveryInMemory() throws Exception {
    byte[] data = "0123456789012345678901234".getBytes(); // 25 bytes
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();
    // 1. Session start
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));
    // 2. Chunk 1 (0-10) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 3. Chunk 2 (10-20) -> Mismatch 400 error
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(400)
            .setReasonPhrase("Bad Request")
            .setContent(""));
    // 4. Query offset -> Server returns 10 (mismatch recovery offset matches currentChunkOffset)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-Size-Received", "10"));
    // 5. Retry Chunk 2 (10-20) from memory buffer -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 6. Chunk 3 (20-25) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"mismatch_success\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_MISMATCH");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setChunkSize(10)
            .setTotalBytes(data.length)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("SUCCESS_MISMATCH");
  }

  @Test
  void chunkedUploadWithRecoveryFromPreviousChunk() throws Exception {
    byte[] data = "0123456789012345678901234".getBytes(); // 25 bytes
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();
    // 1. Session start
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));
    // 2. Chunk 1 (0-10) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 3. Chunk 2 (10-20) -> Mismatch 400 error
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(400)
            .setReasonPhrase("Bad Request")
            .setContent(""));
    // 4. Query offset -> Server returns 0 (which matches previousChunkOffset)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-Size-Received", "0"));
    // 5. Resend Chunk 1 (0-10) from memory buffer -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 6. Send Chunk 2 (10-20) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 7. Chunk 3 (20-25) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"prev_chunk_success\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_PREV_CHUNK");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setChunkSize(10)
            .setTotalBytes(data.length)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("SUCCESS_PREV_CHUNK");
  }

  @Test
  void chunkedUploadWithRecoveryBySeekingStream() throws Exception {
    byte[] data = "01234567890123456789012345678901234".getBytes(); // 35 bytes
    java.util.concurrent.atomic.AtomicInteger streamCreationCount =
        new java.util.concurrent.atomic.AtomicInteger(0);
    InputStreamProvider streamProvider =
        () -> {
          streamCreationCount.incrementAndGet();
          return new ByteArrayInputStream(data);
        };

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();
    // 1. Session start
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345"));
    // 2. Chunk 1 (0-10) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 3. Chunk 2 (10-20) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 4. Chunk 3 (20-30) -> Mismatch 400 error
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(400)
            .setReasonPhrase("Bad Request")
            .setContent(""));
    // 5. Query offset -> Server returns 5 (outside the 2-chunk buffer: previous offset was 10,
    // current is 20)
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-Size-Received", "5"));
    // 6. Client seeks stream to 5. Sends upload (offset 5, length 10, i.e., bytes 5-15) -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 7. Sends chunk 15-25 -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 8. Sends chunk 25-35 -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"seek_success\"}"));

    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_SEEK");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setChunkSize(10)
            .setTotalBytes(data.length)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("SUCCESS_SEEK");
    // Verify that the stream was recreated (once initially, and once on seek recovery)
    assertThat(streamCreationCount.get()).isEqualTo(2);
  }

  @Test
  void granularityAlignment() throws Exception {
    byte[] data = "01234567890123456789".getBytes(); // 20 bytes
    InputStreamProvider streamProvider = () -> new ByteArrayInputStream(data);

    Queue<MockLowLevelHttpResponse> mockResponses = new ConcurrentLinkedQueue<>();
    // 1. Session start with granularity constraint = 8
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active")
            .addHeader("X-Goog-Upload-URL", "https://localhost/session/12345")
            .addHeader("X-Goog-Upload-Chunk-Granularity", "8"));
    // 2. First chunk: adjusted chunk size = 8 (largest multiple of 8 <= 10). Length = 8. -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 3. Second chunk: length = 8 -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "active"));
    // 4. Third chunk (last chunk): length = 4 -> Success
    mockResponses.add(
        new MockLowLevelHttpResponse()
            .setStatusCode(200)
            .addHeader("X-Goog-Upload-Status", "final")
            .setContent("{\"response\":\"granularity_success\"}"));

    List<String> requestCommandsAndOffsets = new ArrayList<>();
    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                String cmd = getFirstHeaderValue("X-Goog-Upload-Command");
                String offset = getFirstHeaderValue("X-Goog-Upload-Offset");
                if (cmd != null) {
                  requestCommandsAndOffsets.add(cmd + ":" + offset);
                }
                return mockResponses.poll();
              }
            };
          }
        };

    Mockito.when(managedChannel.getHttpTransport()).thenReturn(transport);
    Mockito.when(
            responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_GRANULARITY");

    ResumableUploadRequest<String> request =
        ResumableUploadRequest.<String>newBuilder()
            .setRequest("META")
            .setStreamProvider(streamProvider)
            .setChunkSize(10) // 10 is user-requested, will be aligned down to 8
            .setTotalBytes(data.length)
            .build();

    HttpJsonCallSettings<String, String> settings =
        HttpJsonCallSettings.<String, String>newBuilder()
            .setMethodDescriptor(methodDescriptor)
            .build();

    HttpJsonResumableUploadCallable<String, String> callable =
        new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);
    assertThat(response).isEqualTo("SUCCESS_GRANULARITY");

    // Verify command sequences and offsets:
    // Chunk 1: upload:0
    // Chunk 2: upload:8
    // Chunk 3: upload, finalize:16
    assertThat(requestCommandsAndOffsets)
        .containsExactly("start:null", "upload:0", "upload:8", "upload, finalize:16");
  }
}
