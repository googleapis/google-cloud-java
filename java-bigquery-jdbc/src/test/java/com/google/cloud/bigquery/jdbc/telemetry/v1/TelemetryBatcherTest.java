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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

      batcher.offer(
          ConnectionAttempt.newBuilder()
              .setStatus(Status.STATUS_SUCCESS)
              .setErrorCode(0)
              .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
              .build());
      batcher.offer(
          StatementExecution.newBuilder()
              .setStatementType(StatementType.STATEMENT_TYPE_SELECT)
              .setQueryApiType(QueryApiType.QUERY_API_TYPE_STANDARD_REST_API)
              .setStatus(Status.STATUS_SUCCESS)
              .setErrorCode(0)
              .build(),
          150);
      batcher.offer(
          ErrorMetric.newBuilder()
              .setErrorCode(1)
              .setErrorXdbcCode(100)
              .setMethodName("executeQuery")
              .build());
      batcher.offer(
          FeatureUsage.newBuilder()
              .setDriverFeature(DriverFeature.DRIVER_FEATURE_CUSTOM)
              .setCustomFeatureName("MyFeature")
              .build());

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

      batcher.offer(
          ConnectionAttempt.newBuilder()
              .setStatus(Status.STATUS_ERROR)
              .setErrorCode(0)
              .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
              .build());

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
    batcher.offer(
        ConnectionAttempt.newBuilder()
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
            .build());

    batcher.close();
    assertEquals(1, requestCount.get());

    // Should not accept new events after close
    batcher.offer(
        ConnectionAttempt.newBuilder()
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
            .build());
    batcher.flush();
    // Flush should return disabled and not send a request
    assertEquals(1, requestCount.get());
  }

  @Test
  public void testTelemetryKeyFactoryAndEquality() {
    StatementExecution stmt1 =
        StatementExecution.newBuilder()
            .setStatementType(StatementType.STATEMENT_TYPE_SELECT)
            .setQueryApiType(QueryApiType.QUERY_API_TYPE_STANDARD_REST_API)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();
    StatementExecution stmt2 =
        StatementExecution.newBuilder()
            .setStatementType(StatementType.STATEMENT_TYPE_SELECT)
            .setQueryApiType(QueryApiType.QUERY_API_TYPE_STANDARD_REST_API)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();
    StatementExecution stmtDiff =
        StatementExecution.newBuilder()
            .setStatementType(StatementType.STATEMENT_TYPE_INSERT)
            .setQueryApiType(QueryApiType.QUERY_API_TYPE_STANDARD_REST_API)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();

    ConnectionAttempt conn1 =
        ConnectionAttempt.newBuilder()
            .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();
    ConnectionAttempt conn2 =
        ConnectionAttempt.newBuilder()
            .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();

    TelemetryBatcher.TelemetryKey keyStmt1 = TelemetryBatcher.TelemetryKey.from(stmt1);
    TelemetryBatcher.TelemetryKey keyStmt2 = TelemetryBatcher.TelemetryKey.from(stmt2);
    TelemetryBatcher.TelemetryKey keyStmtDiff = TelemetryBatcher.TelemetryKey.from(stmtDiff);
    TelemetryBatcher.TelemetryKey keyConn1 = TelemetryBatcher.TelemetryKey.from(conn1);
    TelemetryBatcher.TelemetryKey keyConn2 = TelemetryBatcher.TelemetryKey.from(conn2);

    assertEquals(keyStmt1, keyStmt2);
    assertEquals(keyStmt1.hashCode(), keyStmt2.hashCode());
    assertNotEquals(keyStmt1, keyStmtDiff);
    assertNotEquals(keyStmt1, keyConn1);
    assertNotEquals(keyStmt1, null);
    assertNotEquals(keyStmt1, new Object());
    assertEquals(keyConn1, keyConn2);
    assertEquals(keyConn1.hashCode(), keyConn2.hashCode());

    assertTrue(keyStmt1.createAccumulator() instanceof TelemetryBatcher.StatementAccumulator);
    assertTrue(keyConn1.createAccumulator() instanceof TelemetryBatcher.ConnectionAccumulator);

    assertThrows(
        IllegalArgumentException.class,
        () -> TelemetryBatcher.TelemetryKey.from(DurationHistogram.getDefaultInstance()));
  }

  @Test
  public void testTelemetryAccumulatorWithMultipleProtos() {
    // 1. Setup keys & accumulators from multiple distinct proto types
    StatementExecution stmtProto =
        StatementExecution.newBuilder()
            .setStatementType(StatementType.STATEMENT_TYPE_SELECT)
            .setQueryApiType(QueryApiType.QUERY_API_TYPE_STANDARD_REST_API)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();
    ConnectionAttempt connProto =
        ConnectionAttempt.newBuilder()
            .setAuthType(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)
            .setStatus(Status.STATUS_SUCCESS)
            .setErrorCode(0)
            .build();
    ErrorMetric errorProto =
        ErrorMetric.newBuilder()
            .setErrorCode(101)
            .setErrorXdbcCode(202)
            .setMethodName("executeQuery")
            .build();
    FeatureUsage featureProto =
        FeatureUsage.newBuilder()
            .setDriverFeature(DriverFeature.DRIVER_FEATURE_CUSTOM)
            .setCustomFeatureName("CustomFeature")
            .build();

    TelemetryBatcher.TelemetryAccumulator stmtAcc1 =
        TelemetryBatcher.TelemetryKey.from(stmtProto).createAccumulator();
    stmtAcc1.accumulate(90);

    TelemetryBatcher.TelemetryAccumulator stmtAcc2 =
        TelemetryBatcher.TelemetryKey.from(stmtProto).createAccumulator();
    stmtAcc2.accumulate(250);

    TelemetryBatcher.TelemetryAccumulator connAcc1 =
        TelemetryBatcher.TelemetryKey.from(connProto).createAccumulator();
    connAcc1.accumulate(0);

    TelemetryBatcher.TelemetryAccumulator connAcc2 =
        TelemetryBatcher.TelemetryKey.from(connProto).createAccumulator();
    connAcc2.accumulate(0);
    connAcc2.accumulate(0);

    TelemetryBatcher.TelemetryAccumulator errorAcc1 =
        TelemetryBatcher.TelemetryKey.from(errorProto).createAccumulator();
    errorAcc1.accumulate(0);

    TelemetryBatcher.TelemetryAccumulator errorAcc2 =
        TelemetryBatcher.TelemetryKey.from(errorProto).createAccumulator();
    errorAcc2.accumulate(0);

    TelemetryBatcher.TelemetryAccumulator featureAcc =
        TelemetryBatcher.TelemetryKey.from(featureProto).createAccumulator();
    featureAcc.accumulate(0);

    // 2. Test merge behavior across accumulators
    stmtAcc1.merge(stmtAcc2);
    connAcc1.merge(connAcc2);
    errorAcc1.merge(errorAcc2);

    // 3. Test polymorphic addToPayload into a single payload builder
    TelemetryPayload.Builder payloadBuilder = TelemetryPayload.newBuilder();
    java.util.List<TelemetryBatcher.TelemetryAccumulator> accumulators =
        java.util.Arrays.asList(stmtAcc1, connAcc1, errorAcc1, featureAcc);
    for (TelemetryBatcher.TelemetryAccumulator acc : accumulators) {
      acc.addToPayload(payloadBuilder);
    }

    // 4. Verify each metric type in the resulting payload
    assertEquals(1, payloadBuilder.getStatementExecutionsCount());
    StatementExecution exec = payloadBuilder.getStatementExecutions(0);
    assertEquals(StatementType.STATEMENT_TYPE_SELECT, exec.getStatementType());
    assertEquals(2, exec.getCount());
    assertEquals(340, exec.getDuration().getSum());
    assertEquals(2, exec.getDuration().getCount());
    assertEquals(1, exec.getDuration().getBucketCounts(1));
    assertEquals(1, exec.getDuration().getBucketCounts(3));

    assertEquals(1, payloadBuilder.getConnectionAttemptsCount());
    ConnectionAttempt conn = payloadBuilder.getConnectionAttempts(0);
    assertEquals(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT, conn.getAuthType());
    assertEquals(Status.STATUS_SUCCESS, conn.getStatus());
    assertEquals(3, conn.getCount());

    assertEquals(1, payloadBuilder.getErrorsCount());
    ErrorMetric err = payloadBuilder.getErrors(0);
    assertEquals(101, err.getErrorCode());
    assertEquals(202, err.getErrorXdbcCode());
    assertEquals("executeQuery", err.getMethodName());
    assertEquals(2, err.getCount());

    assertEquals(1, payloadBuilder.getFeatureUsagesCount());
    FeatureUsage feat = payloadBuilder.getFeatureUsages(0);
    assertEquals(DriverFeature.DRIVER_FEATURE_CUSTOM, feat.getDriverFeature());
    assertEquals("CustomFeature", feat.getCustomFeatureName());
    assertEquals(1, feat.getCount());
  }

  @Test
  public void testCalculateBucket() {
    int index1 = TelemetryBatcher.StatementAccumulator.calculateBucket(5); // < 50, index 0
    assertEquals(0, index1);

    int index2 = TelemetryBatcher.StatementAccumulator.calculateBucket(150); // < 250, index 2
    assertEquals(2, index2);

    int index3 = TelemetryBatcher.StatementAccumulator.calculateBucket(20000); // < 30000, index 9
    assertEquals(9, index3);

    int index4 =
        TelemetryBatcher.StatementAccumulator.calculateBucket(
            4000000); // Overflow > 3600000 (1 hr), index 17
    assertEquals(17, index4);
  }
}
