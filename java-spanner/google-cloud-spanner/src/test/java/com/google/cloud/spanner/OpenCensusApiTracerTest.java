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
import com.google.cloud.spanner.FailOnOverkillTraceComponentImpl.TestSpan;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerOptions.SpannerEnvironment;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.grpc.Status;
import io.opencensus.trace.Status.CanonicalCode;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.lang.reflect.Modifier;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(TracerTest.class)
@RunWith(JUnit4.class)
@Ignore("OpenCensus is too intrusive and affects other tests, so this test is by default disabled")
public class OpenCensusApiTracerTest extends AbstractMockServerTest {
  private static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM random");

  private static final Statement UPDATE_RANDOM = Statement.of("UPDATE random SET foo=1 WHERE id=1");
  private static final FailOnOverkillTraceComponentImpl failOnOverkillTraceComponent =
      new FailOnOverkillTraceComponentImpl();

  private DatabaseClient client;

  @BeforeClass
  public static void setupOpenTelemetry() throws Exception {
    Assume.assumeTrue(
        "This test is only supported on JDK11 and lower",
        JavaVersionUtil.getJavaMajorVersion() < 12);

    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenCensusTraces();

    // Use a little reflection to set the test tracer.
    // This is not possible in Java 12 and later.
    java.lang.reflect.Field field = Tracing.class.getDeclaredField("traceComponent");
    field.setAccessible(true);
    java.lang.reflect.Field modifiersField = null;
    try {
      modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
    } catch (NoSuchFieldException e) {
      // Halt the test and ignore it.
      Assume.assumeTrue(
          "Skipping test as reflection is not allowed on reflection class in this JDK build",
          false);
    }
    modifiersField.setAccessible(true);
    // Remove the final modifier from the 'traceComponent' field.
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    field.set(null, failOnOverkillTraceComponent);
  }

  @BeforeClass
  public static void setupResults() {
    RandomResultSetGenerator generator = new RandomResultSetGenerator(1);
    mockSpanner.putStatementResult(StatementResult.query(SELECT_RANDOM, generator.generate()));
    mockSpanner.putStatementResults(StatementResult.update(UPDATE_RANDOM, 1L));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
    failOnOverkillTraceComponent.clearSpans();
    failOnOverkillTraceComponent.clearAnnotations();
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

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertContains("CloudSpanner.ReadOnlyTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("Spanner.ExecuteStreamingSql", spans);
  }

  @Test
  public void testExecuteUpdate() {
    assertNotNull(
        client.readWriteTransaction().run(transaction -> transaction.executeUpdate(UPDATE_RANDOM)));

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteUpdate", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
    assertContains("Spanner.ExecuteSql", spans);
    assertContains("Spanner.Commit", spans);
  }

  @Test
  public void testBatchUpdate() {
    assertNotNull(
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.batchUpdate(ImmutableList.of(UPDATE_RANDOM, UPDATE_RANDOM))));

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.BatchUpdate", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
    assertContains("Spanner.ExecuteBatchDml", spans);
    assertContains("Spanner.Commit", spans);
  }

  @Test
  public void testMultiUseReadOnlyQuery() {
    try (ReadOnlyTransaction readOnlyTransaction = client.readOnlyTransaction()) {
      try (ResultSet resultSet = readOnlyTransaction.executeQuery(SELECT_RANDOM)) {
        assertTrue(resultSet.next());
        assertFalse(resultSet.next());
      }
    }

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertContains("CloudSpanner.ReadOnlyTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("Spanner.ExecuteStreamingSql", spans);
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

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertContains("CloudSpanner.ReadWriteTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("CloudSpannerOperation.Commit", spans);
  }

  // TODO: Enable test when the problem with overkilling the span has been fixed.
  @Ignore("The client.write method overkills the span")
  @Test
  public void testRetryUnaryRpc() {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(Status.UNAVAILABLE.asRuntimeException()));

    // Execute a simple read/write transaction using only mutations. This will use the
    // BeginTransaction RPC to start the transaction. That RPC will first return UNAVAILABLE, then
    // be retried by Gax, and succeed. The retry should show up in the tracing.
    client.write(ImmutableList.of(Mutation.newInsertBuilder("foo").set("bar").to(1L).build()));

    List<TestSpan> spans = failOnOverkillTraceComponent.getTestSpans();
    TestSpan span = getSpan("Spanner.BeginTransaction", spans);
    assertNotNull(span.getStatus());
    assertEquals(CanonicalCode.OK, span.getStatus().getCanonicalCode());
  }

  @Test
  public void testRetryQuery() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(Status.UNAVAILABLE.asRuntimeException()));

    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM)) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    List<TestSpan> spans = failOnOverkillTraceComponent.getTestSpans();
    // UNAVAILABLE errors for the ExecuteStreamingSql RPC is manually retried by the Spanner client
    // library, and not by Gax. This means that we get two Gax spans, instead of one with a retry
    // attempt.
    List<TestSpan> executeStreamingSqlSpans = getSpans("Spanner.ExecuteStreamingSql", spans);
    assertEquals(2, executeStreamingSqlSpans.size());
    TestSpan span1 = executeStreamingSqlSpans.get(0);
    assertNull(span1.getStatus());
    TestSpan span2 = executeStreamingSqlSpans.get(1);
    assertNull(span2.getStatus());
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

    List<TestSpan> spans = failOnOverkillTraceComponent.getTestSpans();
    TestSpan updateDatabaseDdl = getSpan("DatabaseAdmin.UpdateDatabaseDdl", spans);
    assertNotNull(updateDatabaseDdl);
    assertEquals(1, updateDatabaseDdl.getAnnotations().size());
    assertEquals("Attempt succeeded", updateDatabaseDdl.getAnnotations().get(0));

    TestSpan updateDatabaseDdlOperation =
        getSpan("DatabaseAdmin.UpdateDatabaseDdlOperation", spans);
    assertTrue(updateDatabaseDdlOperation.getAnnotations().size() >= 2);
    assertContainsEvent("Operation started", updateDatabaseDdlOperation.getAnnotations());
    if (updateDatabaseDdlOperation.getAnnotations().size() > 2) {
      assertContainsEvent("Scheduling next poll", updateDatabaseDdlOperation.getAnnotations());
    }
    assertContainsEvent("Polling completed", updateDatabaseDdlOperation.getAnnotations());

    // Verify that there are two GetOperations calls for polling the lro.
    List<TestSpan> polls = getSpans("Operations.GetOperation", spans);
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

    List<TestSpan> spans = failOnOverkillTraceComponent.getTestSpans();
    TestSpan updateDatabaseDdl = getSpan("DatabaseAdmin.UpdateDatabaseDdl", spans);
    assertEquals(1, updateDatabaseDdl.getAnnotations().size());
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

    List<TestSpan> spans = failOnOverkillTraceComponent.getTestSpans();
    // Creating the LRO succeeds.
    TestSpan updateDatabaseDdl = getSpan("DatabaseAdmin.UpdateDatabaseDdl", spans);
    assertEquals(1, updateDatabaseDdl.getAnnotations().size());
    assertEquals("Attempt succeeded", updateDatabaseDdl.getAnnotations().get(0));

    // The LRO itself returns an error.
    TestSpan updateDatabaseDdlOperation =
        getSpan("DatabaseAdmin.UpdateDatabaseDdlOperation", spans);
    assertTrue(updateDatabaseDdlOperation.getAnnotations().size() >= 2);
    assertContainsEvent("Operation started", updateDatabaseDdlOperation.getAnnotations());
    if (updateDatabaseDdlOperation.getAnnotations().size() > 2) {
      assertContainsEvent("Starting poll attempt 0", updateDatabaseDdlOperation.getAnnotations());
    }
    assertContainsEvent("Polling completed", updateDatabaseDdlOperation.getAnnotations());
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
                    .build())
            .build()
            .getService();
    DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));

    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM)) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertContains("CloudSpanner.ReadOnlyTransaction", spans);
    assertContains("CloudSpannerOperation.ExecuteStreamingQuery", spans);
    assertContains("Spanner.ExecuteStreamingSql", spans);
  }

  void assertContains(String expected, Map<String, Boolean> spans) {
    assertTrue(
        "Expected " + spansToString(spans) + " to contain " + expected,
        spans.keySet().stream().anyMatch(span -> span.equals(expected)));
  }

  void assertContainsEvent(String expected, List<String> events) {
    assertTrue(
        "Expected " + eventsToString(events) + " to contain " + expected,
        events.stream().anyMatch(event -> event.equals(expected)));
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

  TestSpan getSpan(String name, List<TestSpan> spans) {
    return spans.stream()
        .filter(span -> span.getSpanName().equals(name))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Span " + name + " not found"));
  }

  List<TestSpan> getSpans(String name, List<TestSpan> spans) {
    return spans.stream()
        .filter(span -> Objects.equals(span.getSpanName(), name))
        .collect(Collectors.toList());
  }

  private String spansToString(Map<String, Boolean> spans) {
    return spans.keySet().stream().collect(Collectors.joining("\n", "\n", "\n"));
  }

  private String eventsToString(List<String> events) {
    return events.stream().collect(Collectors.joining("\n", "\n", "\n"));
  }
}
