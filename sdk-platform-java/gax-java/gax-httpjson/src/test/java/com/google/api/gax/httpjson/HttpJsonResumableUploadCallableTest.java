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
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.TypeRegistry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
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
    Mockito.lenient().when(requestFormatter.getPath(Mockito.anyString())).thenReturn("/upload/resource");
    Mockito.lenient().when(requestFormatter.getRequestBody(Mockito.anyString())).thenReturn("{\"metadata\":\"value\"}");
    Mockito.lenient().when(requestFormatter.getQueryParamNames(Mockito.anyString())).thenReturn(Collections.emptyMap());
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

    MockHttpTransport transport = new MockHttpTransport() {
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
    Mockito.when(responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("SUCCESS_RESPONSE");

    List<ResumableUploadStatus> progressHistory = new ArrayList<>();
    ResumableUploadProgressListener listener = progressHistory::add;

    ResumableUploadRequest<String> request = ResumableUploadRequest.<String>newBuilder()
        .setRequest("META")
        .setStreamProvider(streamProvider)
        .setTotalBytes(data.length)
        .setProgressListener(listener)
        .build();

    HttpJsonCallSettings<String, String> settings = HttpJsonCallSettings.<String, String>newBuilder()
        .setMethodDescriptor(methodDescriptor)
        .build();

    HttpJsonResumableUploadCallable<String, String> callable = new HttpJsonResumableUploadCallable<>(settings, clientContext);

    String response = callable.call(request);

    assertThat(response).isEqualTo("SUCCESS_RESPONSE");
    assertThat(progressHistory).isNotEmpty();
    
    // Verify progress tracking states
    assertThat(progressHistory.get(0).getState()).isEqualTo(ResumableUploadProgressListener.State.NOT_STARTED);
    
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
    mockResponses.add(new MockLowLevelHttpResponse().setStatusCode(503).setReasonPhrase("Service Unavailable").setContent(""));
    
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

    MockHttpTransport transport = new MockHttpTransport() {
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
    Mockito.when(responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("OK_REP");

    ResumableUploadRequest<String> request = ResumableUploadRequest.<String>newBuilder()
        .setRequest("META")
        .setStreamProvider(streamProvider)
        .build();

    HttpJsonCallSettings<String, String> settings = HttpJsonCallSettings.<String, String>newBuilder()
        .setMethodDescriptor(methodDescriptor)
        .build();

    HttpJsonResumableUploadCallable<String, String> callable = new HttpJsonResumableUploadCallable<>(settings, clientContext);

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

    MockHttpTransport transport = new MockHttpTransport() {
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
    Mockito.when(responseParser.parse(Mockito.any(Reader.class), Mockito.nullable(TypeRegistry.class)))
        .thenReturn("RECOVERY_REP");

    List<ResumableUploadStatus> progressHistory = new ArrayList<>();
    ResumableUploadProgressListener listener = progressHistory::add;

    ResumableUploadRequest<String> request = ResumableUploadRequest.<String>newBuilder()
        .setRequest("META")
        .setStreamProvider(streamProvider)
        .setTotalBytes(data.length)
        .setProgressListener(listener)
        .build();

    HttpJsonCallSettings<String, String> settings = HttpJsonCallSettings.<String, String>newBuilder()
        .setMethodDescriptor(methodDescriptor)
        .build();

    HttpJsonResumableUploadCallable<String, String> callable = new HttpJsonResumableUploadCallable<>(settings, clientContext);

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
    mockResponses.add(new MockLowLevelHttpResponse().setStatusCode(403).setReasonPhrase("Forbidden").setContent(""));

    MockHttpTransport transport = new MockHttpTransport() {
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

    ResumableUploadRequest<String> request = ResumableUploadRequest.<String>newBuilder()
        .setRequest("META")
        .setStreamProvider(streamProvider)
        .build();

    HttpJsonCallSettings<String, String> settings = HttpJsonCallSettings.<String, String>newBuilder()
        .setMethodDescriptor(methodDescriptor)
        .build();

    HttpJsonResumableUploadCallable<String, String> callable = new HttpJsonResumableUploadCallable<>(settings, clientContext);

    assertThrows(ApiException.class, () -> callable.call(request));
  }
}
