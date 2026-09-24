/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClearcutTransportTest {

  @BeforeEach
  @AfterEach
  public void resetTelemetry() {
    TelemetryTestUtils.reset();
  }

  @Test
  public void testSendWhenDisabled() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest();
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(false).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(TelemetryPayload.getDefaultInstance());
    assertFalse(result.isSuccess());
    assertEquals(-1, result.getNextRequestWaitMillis());
    assertEquals(0, requestCount.get());
  }

  @Test
  public void testSendNullPayloadFailsSilently() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest();
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(null);
    assertFalse(result.isSuccess());
    assertEquals(-1, result.getNextRequestWaitMillis());
    assertEquals(0, requestCount.get());
  }

  @Test
  public void testSendSuccess() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                return response;
              }
            };
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(TelemetryPayload.getDefaultInstance());
    assertTrue(result.isSuccess());
    assertEquals(-1, result.getNextRequestWaitMillis());
    assertEquals(1, requestCount.get());
  }

  @Test
  public void testSendServerErrorStatusCodeReturnsFalse() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(500);
                return response;
              }
            };
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(TelemetryPayload.getDefaultInstance());
    assertFalse(result.isSuccess());
    assertEquals(-1, result.getNextRequestWaitMillis());
    assertEquals(1, requestCount.get());
  }

  @Test
  public void testSendClientErrorStatusCodeReturnsFalse() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(400);
                return response;
              }
            };
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(TelemetryPayload.getDefaultInstance());
    assertFalse(result.isSuccess());
    assertEquals(-1, result.getNextRequestWaitMillis());
    assertEquals(1, requestCount.get());
  }

  @Test
  public void testSendIOExceptionReturnsFalse() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            requestCount.incrementAndGet();
            throw new IOException("Network unreachable");
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(TelemetryPayload.getDefaultInstance());
    assertFalse(result.isSuccess());
    assertEquals(-1, result.getNextRequestWaitMillis());
    assertEquals(1, requestCount.get());
  }

  @Test
  public void testSendServerErrorWithNextRequestWaitMillis() {
    AtomicInteger requestCount = new AtomicInteger(0);
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(429);
                LogResponse logResponse =
                    LogResponse.newBuilder().setNextRequestWaitMillis(10).build();
                response.setContent(logResponse.toByteArray());
                return response;
              }
            };
          }
        };

    TelemetryConfiguration config = TelemetryConfiguration.newBuilder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TransportResult result = transport.send(TelemetryPayload.getDefaultInstance());
    assertFalse(result.isSuccess());
    assertEquals(1, requestCount.get());
    assertEquals(10, result.getNextRequestWaitMillis());
  }

  @Test
  public void testRecordError_reachesPayload() throws Exception {
    AtomicReference<byte[]> captured = new AtomicReference<>();
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                getStreamingContent().writeTo(out);
                captured.set(out.toByteArray());
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                return response;
              }
            };
          }
        };
    TelemetryConfiguration config =
        TelemetryConfiguration.newBuilder()
            .setEnabled(true)
            .setDriverEnvironment(
                DriverEnvironment.newBuilder().setDriverName("SimulatedDriver").build())
            .build();
    TelemetryManager.init(config, new ClearcutTransport(mockTransport, config));
    TelemetryManager.recordError(404, "42000", "executeQuery");
    TelemetryManager.getInstance().getBatcher().flush();
    LogRequest request = LogRequest.parseFrom(captured.get());
    TelemetryPayload payload =
        TelemetryPayload.parseFrom(request.getLogEvents(0).getSourceExtension());
    assertEquals(1, payload.getErrorsCount());
    ErrorMetric error = payload.getErrors(0);
    assertEquals(404, error.getErrorCode());
    assertEquals("42000", error.getErrorSqlState());
    assertEquals("executeQuery", error.getMethodName());
    assertEquals(1, error.getCount());
  }
}
