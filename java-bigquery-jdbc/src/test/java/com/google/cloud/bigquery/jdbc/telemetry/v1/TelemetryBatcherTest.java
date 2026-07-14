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
          ConnectionAttempt.newBuilder().setStatus(Status.STATUS_SUCCESS).build());
      batcher.offerStatementExecution(
          StatementExecution.newBuilder().setStatus(Status.STATUS_SUCCESS).build());
      batcher.offerErrorMetric(
          ErrorMetric.newBuilder().setErrorCode("ERR_001").setCount(1).build());
      batcher.offerFeatureUsage(
          FeatureUsage.newBuilder().setDriverFeature(DriverFeature.DRIVER_FEATURE_CUSTOM).build());

      assertEquals(4, batcher.getPendingEventCount());
      assertFalse(batcher.isEmpty());

      TransportResult result = batcher.flush();
      assertTrue(result.isSuccess());
      assertEquals(1, requestCount.get());
      assertEquals(0, batcher.getPendingEventCount());
      assertTrue(batcher.isEmpty());
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
                response.setStatusCode(500);
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
          ConnectionAttempt.newBuilder().setStatus(Status.STATUS_ERROR).build());

      assertEquals(1, batcher.getPendingEventCount());

      TransportResult result = batcher.flush();
      assertFalse(result.isSuccess());
      assertEquals(1, requestCount.get());

      // Events should be retained for next retry attempt
      assertEquals(1, batcher.getPendingEventCount());
      assertFalse(batcher.isEmpty());
    }
  }

  @Test
  public void testBatchSizeAndPayloadLimitTrimming() {
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
            .setBatchSizeThreshold(5)
            .setDriverEnvironment(driverEnvironment)
            .build();
    ClearcutTransport transport = new ClearcutTransport(mockTransport, config);

    try (TelemetryBatcher batcher =
        new TelemetryBatcher(config, transport, executorService, false)) {
      for (int i = 0; i < 12; i++) {
        batcher.offerConnectionAttempt(
            ConnectionAttempt.newBuilder().setStatus(Status.STATUS_SUCCESS).build());
      }

      assertEquals(12, batcher.getPendingEventCount());

      // First flush drains up to batchSizeThreshold (5 items)
      TransportResult result1 = batcher.flush();
      assertTrue(result1.isSuccess());
      assertEquals(7, batcher.getPendingEventCount());

      // Second flush drains another batchSizeThreshold (5 items)
      TransportResult result2 = batcher.flush();
      assertTrue(result2.isSuccess());
      assertEquals(2, batcher.getPendingEventCount());

      // Third flush drains remaining 2 items
      TransportResult result3 = batcher.flush();
      assertTrue(result3.isSuccess());
      assertEquals(0, batcher.getPendingEventCount());
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
        ConnectionAttempt.newBuilder().setStatus(Status.STATUS_SUCCESS).build());

    assertEquals(1, batcher.getPendingEventCount());

    batcher.close();

    assertEquals(1, requestCount.get());
    assertEquals(0, batcher.getPendingEventCount());

    // Should not accept new events after close
    batcher.offerConnectionAttempt(
        ConnectionAttempt.newBuilder().setStatus(Status.STATUS_SUCCESS).build());
    assertEquals(0, batcher.getPendingEventCount());
  }
}
