/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.AsyncTransactionManager.CommitTimestampFuture;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerOptions.SpannerEnvironment;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.grpc.Status;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.time.Duration;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OpenTelemetryApiTracerTest extends AbstractMockServerTest {
  private static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM random");

  private static final Statement UPDATE_RANDOM = Statement.of("UPDATE random SET foo=1 WHERE id=1");
  private static InMemorySpanExporter spanExporter;

  private static OpenTelemetrySdk openTelemetry;

  private DatabaseClient client;

  @BeforeClass
  public static void setupOpenTelemetry() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    GlobalOpenTelemetry.resetForTest();

    spanExporter = InMemorySpanExporter.create();

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();

    openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(tracerProvider)
            .buildAndRegisterGlobal();
  }

  @BeforeClass
  public static void setupResults() {
    RandomResultSetGenerator generator = new RandomResultSetGenerator(1);
    mockSpanner.putStatementResult(StatementResult.query(SELECT_RANDOM, generator.generate()));
    mockSpanner.putStatementResults(StatementResult.update(UPDATE_RANDOM, 1L));
  }

  @AfterClass
  public static void closeOpenTelemetry() {
    if (openTelemetry != null) {
      openTelemetry.close();
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
    spanExporter.reset();
  }

  @Override
  public void createSpannerInstance() {
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();
    // Set a quick polling algorithm to prevent this from slowing down the test unnecessarily.
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .updateDatabaseDdlOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRetryDelayDuration(Duration.ofNanos(1L))
                    .setMaxRetryDelayDuration(Duration.ofNanos(1L))
                    .setRetryDelayMultiplier(1.0)
                    .setTotalTimeoutDuration(Duration.ofMinutes(10L))
                    .build()));
    spanner =
        builder
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setWaitForMinSessionsDuration(Duration.ofSeconds(5L))
                    .setFailOnSessionLeak()
                    .setSkipVerifyingBeginTransactionForMuxRW(true)
                    .build())
            .setEnableApiTracing(true)
            .build()
            .getService();
    client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
  }

  @Test
  public void testSingleUseQuery() {
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM)) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadOnlyTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("Spanner.ExecuteStreamingSql", spans);
    assertParent(
        "CloudSpanner.ReadOnlyTransaction", "CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertParent(
        "CloudSpannerOperation.ExecuteStreamingQuery", "Spanner.ExecuteStreamingSql", spans);
  }

  @Test
  public void testExecuteUpdate() {
    assertNotNull(
        client.readWriteTransaction().run(transaction -> transaction.executeUpdate(UPDATE_RANDOM)));

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteUpdate", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
    assertContains("Spanner.ExecuteSql", spans);
    assertContains("Spanner.Commit", spans);

    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.ExecuteUpdate", spans);
    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.Commit", spans);
    assertParent("CloudSpannerOperation.ExecuteUpdate", "Spanner.ExecuteSql", spans);
  }

  @Test
  public void testBatchUpdate() {
    assertNotNull(
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.batchUpdate(ImmutableList.of(UPDATE_RANDOM, UPDATE_RANDOM))));

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.BatchUpdate", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
    assertContains("Spanner.ExecuteBatchDml", spans);
    assertContains("Spanner.Commit", spans);
    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.BatchUpdate", spans);
    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.Commit", spans);
    assertParent("CloudSpannerOperation.BatchUpdate", "Spanner.ExecuteBatchDml", spans);
    assertParent("CloudSpannerOperation.Commit", "Spanner.Commit", spans);
  }

  @Test
  public void testMultiUseReadOnlyQuery() {
    try (ReadOnlyTransaction readOnlyTransaction = client.readOnlyTransaction()) {
      try (ResultSet resultSet = readOnlyTransaction.executeQuery(SELECT_RANDOM)) {
        assertTrue(resultSet.next());
        assertFalse(resultSet.next());
      }
    }

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadOnlyTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("Spanner.ExecuteStreamingSql", spans);
    assertParent(
        "CloudSpanner.ReadOnlyTransaction",
        "CloudSpannerOperation.ExecuteStreamingQuery",
        Attributes.empty(),
        spans);
    assertParent(
        "CloudSpannerOperation.ExecuteStreamingQuery",
        "Spanner.ExecuteStreamingSql",
        Attributes.empty(),
        spans);
  }

  @Test
  public void testReadWriteTransactionQuery() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              try (ResultSet resultSet = transaction.executeQuery(SELECT_RANDOM)) {
                assertTrue(resultSet.next());
                assertFalse(resultSet.next());
              }
              return null;
            });

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
    assertParent(
        "CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.Commit", spans);
    assertParent(
        "CloudSpannerOperation.ExecuteStreamingQuery", "Spanner.ExecuteStreamingSql", spans);
  }

  @Test
  public void testRetryUnaryRpc() {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(Status.UNAVAILABLE.asRuntimeException()));

    // Execute a simple read/write transaction using only mutations. This will use the
    // BeginTransaction RPC to start the transaction. That RPC will first return UNAVAILABLE, then
    // be retried by Gax, and succeed. The retry should show up in the tracing.
    client.write(ImmutableList.of(Mutation.newInsertBuilder("foo").set("bar").to(1L).build()));

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    SpanData span = getSpan("Spanner.BeginTransaction", spans);
    assertEquals(StatusCode.OK, span.getStatus().getStatusCode());
    assertEquals(3, span.getTotalRecordedEvents());
    List<EventData> events = span.getEvents();
    assertEquals("Attempt failed, scheduling next attempt", events.get(0).getName());
    assertEquals("Starting RPC retry 1", events.get(1).getName());
    assertEquals("Attempt succeeded", events.get(2).getName());
  }

  @Test
  public void testRetryQuery() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(Status.UNAVAILABLE.asRuntimeException()));

    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM)) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    // UNAVAILABLE errors for the ExecuteStreamingSql RPC is manually retried by the Spanner client
    // library, and not by Gax. This means that we get two Gax spans, instead of one with a retry
    // attempt.
    List<SpanData> executeStreamingSqlSpans =
        getSpans("Spanner.ExecuteStreamingSql", Attributes.empty(), spans);
    assertEquals(2, executeStreamingSqlSpans.size());
    SpanData span1 = executeStreamingSqlSpans.get(0);
    assertEquals(StatusCode.ERROR, span1.getStatus().getStatusCode());
    SpanData span2 = executeStreamingSqlSpans.get(1);
    assertEquals(StatusCode.OK, span2.getStatus().getStatusCode());
  }

  @Test
  public void testLroSucceeded() throws Exception {
    addUpdateDdlResponse();

    OperationFuture<Void, UpdateDatabaseDdlMetadata> operationFuture =
        spanner
            .getDatabaseAdminClient()
            .updateDatabaseDdl(
                "i", "d", ImmutableList.of("create table foo (id int64) primary key (id)"), null);
    assertNull(operationFuture.get());

    // Wait until the last span has been exported, which can take a few microseconds, as it is
    // added by a gRPC executor thread.
    do {
      assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    } while (getSpans(
                "DatabaseAdmin.UpdateDatabaseDdlOperation",
                Attributes.empty(),
                spanExporter.getFinishedSpanItems())
            .isEmpty()
        || getSpans(
                    "Operations.GetOperation",
                    Attributes.empty(),
                    spanExporter.getFinishedSpanItems())
                .size()
            < 2);
    List<SpanData> spans = spanExporter.getFinishedSpanItems();

    SpanData updateDatabaseDdl = getSpan("DatabaseAdmin.UpdateDatabaseDdl", spans);
    assertEquals(1, updateDatabaseDdl.getTotalRecordedEvents());
    assertEquals("Attempt succeeded", updateDatabaseDdl.getEvents().get(0).getName());

    SpanData updateDatabaseDdlOperation =
        getSpan("DatabaseAdmin.UpdateDatabaseDdlOperation", spans);
    assertTrue(updateDatabaseDdlOperation.getTotalRecordedEvents() >= 5);
    assertContainsEvent("Operation started", updateDatabaseDdlOperation.getEvents());
    assertContainsEvent("Starting poll attempt 0", updateDatabaseDdlOperation.getEvents());
    assertContainsEvent("Scheduling next poll", updateDatabaseDdlOperation.getEvents());
    assertContainsEvent("Starting poll attempt 1", updateDatabaseDdlOperation.getEvents());
    assertContainsEvent("Polling completed", updateDatabaseDdlOperation.getEvents());

    // Verify that there are two GetOperations calls for polling the lro.
    List<SpanData> polls = getSpans("Operations.GetOperation", Attributes.empty(), spans);
    assertEquals(2, polls.size());
  }

  @Test
  public void testLroCreationFailed() {
    mockDatabaseAdmin.addException(Status.INVALID_ARGUMENT.asRuntimeException());

    OperationFuture<Void, UpdateDatabaseDdlMetadata> operationFuture =
        spanner
            .getDatabaseAdminClient()
            .updateDatabaseDdl(
                "i", "d", ImmutableList.of("create table foo (id int64) primary key (id)"), null);
    ExecutionException executionException =
        assertThrows(ExecutionException.class, operationFuture::get);
    assertEquals(
        ErrorCode.INVALID_ARGUMENT,
        SpannerExceptionFactory.asSpannerException(executionException.getCause()).getErrorCode());

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();

    SpanData updateDatabaseDdl = getSpan("DatabaseAdmin.UpdateDatabaseDdl", spans);
    assertEquals(1, updateDatabaseDdl.getTotalRecordedEvents());
    assertEquals(
        "Attempt failed, error not retryable", updateDatabaseDdl.getEvents().get(0).getName());
    assertEquals(StatusCode.ERROR, updateDatabaseDdl.getStatus().getStatusCode());
  }

  @Test
  public void testLroOperationFailed() {
    addUpdateDdlError();

    OperationFuture<Void, UpdateDatabaseDdlMetadata> operationFuture =
        spanner
            .getDatabaseAdminClient()
            .updateDatabaseDdl(
                "i", "d", ImmutableList.of("create table foo (id int64) primary key (id)"), null);
    ExecutionException executionException =
        assertThrows(ExecutionException.class, operationFuture::get);
    assertEquals(
        ErrorCode.FAILED_PRECONDITION,
        SpannerExceptionFactory.asSpannerException(executionException.getCause()).getErrorCode());

    // Wait until the last span has been exported, which can take a few microseconds, as it is
    // added by a gRPC executor thread.
    do {
      assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    } while (getSpans(
            "DatabaseAdmin.UpdateDatabaseDdlOperation",
            Attributes.empty(),
            spanExporter.getFinishedSpanItems())
        .isEmpty());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();

    // Creating the LRO succeeds.
    SpanData updateDatabaseDdl = getSpan("DatabaseAdmin.UpdateDatabaseDdl", spans);
    assertEquals(1, updateDatabaseDdl.getTotalRecordedEvents());
    assertEquals("Attempt succeeded", updateDatabaseDdl.getEvents().get(0).getName());
    assertEquals(StatusCode.OK, updateDatabaseDdl.getStatus().getStatusCode());

    // The LRO itself returns an error.
    SpanData updateDatabaseDdlOperation =
        getSpan("DatabaseAdmin.UpdateDatabaseDdlOperation", spans);
    assertEquals(3, updateDatabaseDdlOperation.getTotalRecordedEvents());
    assertContainsEvent("Operation started", updateDatabaseDdlOperation.getEvents());
    assertContainsEvent("Starting poll attempt 0", updateDatabaseDdlOperation.getEvents());
    assertContainsEvent("Polling completed", updateDatabaseDdlOperation.getEvents());
    assertEquals(StatusCode.ERROR, updateDatabaseDdlOperation.getStatus().getStatusCode());
  }

  @Test
  public void testEnableWithEnvVar() {
    SpannerOptions.useEnvironment(
        new SpannerEnvironment() {
          @Override
          public boolean isEnableApiTracing() {
            return true;
          }
        });
    // Create a Spanner instance without explicitly enabling API tracing.
    Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setWaitForMinSessionsDuration(Duration.ofSeconds(5L))
                    .setFailOnSessionLeak()
                    .setSkipVerifyingBeginTransactionForMuxRW(true)
                    .build())
            .build()
            .getService();
    DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM)) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadOnlyTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("Spanner.ExecuteStreamingSql", spans);
    assertParent(
        "CloudSpanner.ReadOnlyTransaction", "CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertParent(
        "CloudSpannerOperation.ExecuteStreamingQuery", "Spanner.ExecuteStreamingSql", spans);
  }

  @Test
  public void testAsyncTransactionManagerCommit() throws Exception {
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture transactionFuture = manager.beginAsync();
      CommitTimestampFuture commitTimestamp =
          transactionFuture
              .then(
                  (transaction, __) -> transaction.executeUpdateAsync(UPDATE_RANDOM),
                  MoreExecutors.directExecutor())
              .commitAsync();
      commitTimestamp.get();
    }

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteUpdate", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
    assertContains("Spanner.ExecuteSql", spans);
    assertContains("Spanner.Commit", spans);

    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.ExecuteUpdate", spans);
    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.Commit", spans);
    assertParent("CloudSpannerOperation.ExecuteUpdate", "Spanner.ExecuteSql", spans);
  }

  @Test
  public void testAsyncTransactionManagerRollback() throws Exception {
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture transactionFuture = manager.beginAsync();
      transactionFuture
          .then(
              (transaction, __) -> transaction.executeUpdateAsync(UPDATE_RANDOM),
              MoreExecutors.directExecutor())
          .get();
      manager.rollbackAsync().get();
    }

    assertEquals(CompletableResultCode.ofSuccess(), spanExporter.flush());
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteUpdate", spans);
    assertContains("Spanner.ExecuteSql", spans);
    assertContains("Spanner.Rollback", spans);

    assertParent("CloudSpanner.ReadWriteTransaction", "CloudSpannerOperation.ExecuteUpdate", spans);
    assertParent("CloudSpannerOperation.ExecuteUpdate", "Spanner.ExecuteSql", spans);
    SpanData transactionSpan = getSpan("CloudSpanner.ReadWriteTransaction", spans);
    assertNotNull(transactionSpan);
    assertContainsEvent("Transaction rolled back", transactionSpan.getEvents());
  }

  void assertContains(String expected, List<SpanData> spans) {
    assertTrue(
        "Expected " + spansToString(spans) + " to contain " + expected,
        spans.stream().anyMatch(span -> span.getName().equals(expected)));
  }

  void assertContainsEvent(String expected, List<EventData> events) {
    assertTrue(
        "Expected " + eventsToString(events) + " to contain " + expected,
        events.stream().anyMatch(event -> event.getName().equals(expected)));
  }

  boolean equalsSpan(SpanData span, String name, Attributes attributes) {
    if (!span.getName().equals(name)) {
      return false;
    }
    for (Entry<AttributeKey<?>, Object> entry : attributes.asMap().entrySet()) {
      if (!span.getAttributes().asMap().containsKey(entry.getKey())) {
        return false;
      }
      if (!Objects.equals(entry.getValue(), span.getAttributes().get(entry.getKey()))) {
        return false;
      }
    }
    return true;
  }

  void assertParent(String expectedParent, String child, List<SpanData> spans) {
    SpanData parentSpan = getSpan(expectedParent, spans);
    SpanData childSpan = getSpan(child, spans);
    assertEquals(parentSpan.getSpanId(), childSpan.getParentSpanId());
  }

  void assertParent(
      String expectedParent, String child, Attributes attributes, List<SpanData> spans) {
    SpanData parentSpan = getSpan(expectedParent, spans);
    List<SpanData> childSpans = getSpans(child, attributes, spans);
    for (SpanData childSpan : childSpans) {
      assertEquals(parentSpan.getSpanId(), childSpan.getParentSpanId());
    }
  }

  SpanData getSpan(String name, List<SpanData> spans) {
    return spans.stream()
        .filter(span -> span.getName().equals(name))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Span " + name + " not found"));
  }

  List<SpanData> getSpans(String name, Attributes attributes, List<SpanData> spans) {
    return spans.stream()
        .filter(span -> equalsSpan(span, name, attributes))
        .collect(Collectors.toList());
  }

  private String spansToString(List<SpanData> spans) {
    return spans.stream().map(SpanData::getName).collect(Collectors.joining("\n", "\n", "\n"));
  }

  private String eventsToString(List<EventData> events) {
    return events.stream().map(EventData::getName).collect(Collectors.joining("\n", "\n", "\n"));
  }
}
