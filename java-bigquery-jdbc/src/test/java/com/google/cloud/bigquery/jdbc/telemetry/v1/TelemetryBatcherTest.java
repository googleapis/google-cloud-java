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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TelemetryBatcherTest {

  private ScheduledExecutorService executorService;
  private DriverEnvironment driverEnvironment;

  @BeforeEach
  public void setUp() {
    executorService = Executors.newSingleThreadScheduledExecutor();
    driverEnvironment =
        DriverEnvironment.newBuilder()
            .setDriverName("SimulatedDriver")
            .setDriverVersion("1.0.0")
            .build();
  }

  @AfterEach
  public void tearDown() {
    if (executorService != null && !executorService.isShutdown()) {
      executorService.shutdownNow();
    }
  }

  @Test
  public void testOfferAndFlushSuccess() {
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

    TelemetryConfiguration config =
        TelemetryConfiguration.newBuilder()
            .setEnabled(true)
            .setDriverEnvironment(driverEnvironment)
            .build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    try (TelemetryBatcher batcher =
        new TelemetryBatcher(config, transport, executorService, false)) {

      batcher.offerConnectionAttempt(
          Status.STATUS_SUCCESS, 0, AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT);
      batcher.offerStatementExecution(
          StatementType.STATEMENT_TYPE_SELECT,
          QueryApiType.QUERY_API_TYPE_STANDARD_REST_API,
          Status.STATUS_SUCCESS,
          0,
          150,
          3);
      batcher.offerErrorMetric(1, 100, "executeQuery");
      batcher.offerFeatureUsage(DriverFeature.DRIVER_FEATURE_CUSTOM, "MyFeature");

      TransportResult result = batcher.flush();
      assertTrue(result.isSuccess());
      assertEquals(1, requestCount.get());

      // Secondary flush should be empty
      TransportResult result2 = batcher.flush();
      assertFalse(result2.isSuccess()); // empty flush returns disabled or unsuccess
      assertEquals(1, requestCount.get()); // no new request sent
    }
  }

  @Test
  public void testFlushFailureRequeuesEvents() {
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
                response.setStatusCode(500); // simulate failure
                return response;
              }
            };
          }
        };

    TelemetryConfiguration config =
        TelemetryConfiguration.newBuilder()
            .setEnabled(true)
            .setDriverEnvironment(driverEnvironment)
            .build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    try (TelemetryBatcher batcher =
        new TelemetryBatcher(config, transport, executorService, false)) {

      batcher.offerConnectionAttempt(
          Status.STATUS_ERROR, 0, AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT);

      TransportResult result = batcher.flush();
      assertFalse(result.isSuccess());
      assertEquals(1, requestCount.get());

      // Because it failed, the connection attempt should be merged back into the active map.
      // We can verify this by flushing again with a working transport (we can't change transport
      // mid-flight here,
      // but we can verify it attempts another request).
      TransportResult result2 = batcher.flush();
      assertEquals(2, requestCount.get());
    }
  }

  @Test
  public void testCloseFlushesAndShutsDown() {
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

    TelemetryConfiguration config =
        TelemetryConfiguration.newBuilder()
            .setEnabled(true)
            .setDriverEnvironment(driverEnvironment)
            .build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    TelemetryBatcher batcher = new TelemetryBatcher(config, transport);
    batcher.offerConnectionAttempt(
        Status.STATUS_SUCCESS, 0, AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT);

    batcher.close();
    assertEquals(1, requestCount.get());

    // Should not accept new events after close
    batcher.offerConnectionAttempt(
        Status.STATUS_SUCCESS, 0, AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT);
    batcher.flush();
    // Flush should return disabled and not send a request
    assertEquals(1, requestCount.get());
  }
}
