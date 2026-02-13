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

package com.google.cloud.datastore.it;

import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.cloud.datastore.telemetry.TraceUtil.*;
import static com.google.common.truth.Truth.assertThat;
import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.SERVICE_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Transaction;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.common.base.Preconditions;
import com.google.testing.junit.testparameterinjector.TestParameter;
import com.google.testing.junit.testparameterinjector.TestParameterInjector;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.OpenTelemetrySdkBuilder;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

@RunWith(TestParameterInjector.class)
public class ITTracingTest {
  protected boolean isUsingGlobalOpenTelemetrySDK() {
    return useGlobalOpenTelemetrySDK;
  }

  protected String datastoreNamedDatabase() {
    return datastoreNamedDatabase;
  }

  private static final Logger logger =
      Logger.getLogger(com.google.cloud.datastore.it.ITTracingTest.class.getName());

  private static final int TRACE_FORCE_FLUSH_MILLIS = 1000;
  private static final int TRACE_PROVIDER_SHUTDOWN_MILLIS = 1000;
  private static final int IN_MEMORY_SPAN_EXPORTER_DELAY_MILLIS = 50;
  private static final String SERVICE = "google.datastore.v1.Datastore/";

  private static Key KEY1;

  private static Key KEY2;

  private static Key KEY3;

  private static Key KEY4;

  private static OpenTelemetrySdk openTelemetrySdk;

  // We use an InMemorySpanExporter for testing which keeps all generated trace spans
  // in memory so that we can check their correctness.
  protected InMemorySpanExporter inMemorySpanExporter;
  private static DatastoreOptions options;

  protected Datastore datastore;
  private static RemoteDatastoreHelper remoteDatastoreHelper;

  @TestParameter boolean useGlobalOpenTelemetrySDK;

  @TestParameter({
    /*(default)*/
    "",
    "test-db"
  })
  String datastoreNamedDatabase;

  Map<String, String> spanNameToSpanId = new HashMap<>();
  Map<String, String> spanIdToParentSpanId = new HashMap<>();
  Map<String, SpanData> spanNameToSpanData = new HashMap<>();

  @Rule public TestName testName = new TestName();

  @Before
  public void before() {
    inMemorySpanExporter = InMemorySpanExporter.create();

    Resource resource =
        Resource.getDefault().merge(Resource.builder().put(SERVICE_NAME, "Sparky").build());
    SpanProcessor inMemorySpanProcessor = SimpleSpanProcessor.create(inMemorySpanExporter);
    DatastoreOptions.Builder optionsBuilder = DatastoreOptions.newBuilder();
    DatastoreOpenTelemetryOptions.Builder otelOptionsBuilder =
        DatastoreOpenTelemetryOptions.newBuilder();
    OpenTelemetrySdkBuilder openTelemetrySdkBuilder =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .setResource(resource)
                    .addSpanProcessor(inMemorySpanProcessor)
                    .setSampler(Sampler.alwaysOn())
                    .build());

    if (isUsingGlobalOpenTelemetrySDK()) {
      GlobalOpenTelemetry.resetForTest();
      openTelemetrySdk = openTelemetrySdkBuilder.buildAndRegisterGlobal();
      optionsBuilder.setOpenTelemetryOptions(otelOptionsBuilder.setTracingEnabled(true).build());
    } else {
      openTelemetrySdk = openTelemetrySdkBuilder.build();
      optionsBuilder.setOpenTelemetryOptions(
          otelOptionsBuilder.setTracingEnabled(true).setOpenTelemetry(openTelemetrySdk).build());
    }

    String namedDb = datastoreNamedDatabase();
    logger.log(Level.INFO, "Integration test using named database " + namedDb);
    remoteDatastoreHelper = RemoteDatastoreHelper.create(namedDb, openTelemetrySdk);
    options = remoteDatastoreHelper.getOptions();
    datastore = options.getService();

    Preconditions.checkNotNull(
        datastore,
        "Error instantiating Datastore. Check that the service account credentials "
            + "were properly set.");

    String projectId = options.getProjectId();
    String kind1 = "kind1";
    KEY1 =
        Key.newBuilder(projectId, kind1, "key1", options.getDatabaseId())
            .setNamespace(options.getNamespace())
            .build();
    KEY2 =
        Key.newBuilder(projectId, kind1, "key2", options.getDatabaseId())
            .setNamespace(options.getNamespace())
            .build();
    KEY3 =
        Key.newBuilder(projectId, kind1, "key3", options.getDatabaseId())
            .setNamespace(options.getNamespace())
            .build();
    KEY4 =
        Key.newBuilder(projectId, kind1, "key4", options.getDatabaseId())
            .setNamespace(options.getNamespace())
            .build();
    cleanupTestSpanContext();
  }

  @After
  public void after() throws Exception {
    if (isUsingGlobalOpenTelemetrySDK()) {
      GlobalOpenTelemetry.resetForTest();
    }
    remoteDatastoreHelper.deleteNamespace();
    inMemorySpanExporter.reset();
    CompletableResultCode completableResultCode =
        openTelemetrySdk.getSdkTracerProvider().shutdown();
    completableResultCode.join(TRACE_PROVIDER_SHUTDOWN_MILLIS, TimeUnit.MILLISECONDS);
    openTelemetrySdk = null;
  }

  @AfterClass
  public static void teardown() {}

  void waitForTracesToComplete() throws Exception {
    // The same way that querying the Cloud Trace backend may not give us the
    // full trace on the first try, querying the in-memory traces may not result
    // in the full trace immediately. Note that performing the `flush` is not
    // enough. This doesn't pose an issue in practice, but can make tests flaky.
    // Therefore, we're adding a delay to make sure we avoid any flakiness.
    inMemorySpanExporter.flush().join(IN_MEMORY_SPAN_EXPORTER_DELAY_MILLIS, TimeUnit.MILLISECONDS);
    TimeUnit.MILLISECONDS.sleep(IN_MEMORY_SPAN_EXPORTER_DELAY_MILLIS);

    CompletableResultCode completableResultCode =
        openTelemetrySdk.getSdkTracerProvider().forceFlush();
    completableResultCode.join(TRACE_FORCE_FLUSH_MILLIS, TimeUnit.MILLISECONDS);
  }

  // Prepares all the spans in memory for inspection.
  List<SpanData> prepareSpans() throws Exception {
    waitForTracesToComplete();
    List<SpanData> spans = inMemorySpanExporter.getFinishedSpanItems();
    buildSpanMaps(spans);
    printSpans();
    return spans;
  }

  void buildSpanMaps(List<SpanData> spans) {
    for (SpanData spanData : spans) {
      spanNameToSpanData.put(spanData.getName(), spanData);
      spanNameToSpanId.put(spanData.getName(), spanData.getSpanId());
      spanIdToParentSpanId.put(spanData.getSpanId(), spanData.getParentSpanId());
    }
  }

  // Returns the SpanData object for the span with the given name.
  // Returns null if no span with the given name exists.
  @Nullable
  SpanData getSpanByName(String spanName) {
    return spanNameToSpanData.get(spanName);
  }

  // Returns the SpanData object for the gRPC span with the given RPC name.
  // Returns null if no such span exists.
  @Nullable
  SpanData getGrpcSpanByName(String rpcName) {
    return getSpanByName(SERVICE + rpcName);
  }

  String grpcSpanName(String rpcName) {
    return SERVICE + rpcName;
  }

  void assertSameTrace(SpanData... spans) {
    if (spans.length > 1) {
      String traceId = spans[0].getTraceId();
      for (SpanData spanData : spans) {
        assertEquals(traceId, spanData.getTraceId());
      }
    }
  }

  // Helper to see the spans in standard output while developing tests
  void printSpans() {
    for (SpanData spanData : spanNameToSpanData.values()) {
      logger.log(
          Level.FINE,
          String.format(
              "SPAN ID:%s, ParentID:%s, KIND:%s, TRACE ID:%s, NAME:%s, ATTRIBUTES:%s, EVENTS:%s\n",
              spanData.getSpanId(),
              spanData.getParentSpanId(),
              spanData.getKind(),
              spanData.getTraceId(),
              spanData.getName(),
              spanData.getAttributes().toString(),
              spanData.getEvents().toString()));
    }
  }

  // Asserts that the span hierarchy exists for the given span names. The hierarchy starts with the
  // root span, followed
  // by the child span, grandchild span, and so on. It also asserts that all the given spans belong
  // to the same trace,
  // and that datastore-generated spans contain the expected datastore attributes.
  void assertSpanHierarchy(String... spanNamesHierarchy) {
    List<String> spanNames = Arrays.asList(spanNamesHierarchy);

    for (int i = 0; i + 1 < spanNames.size(); ++i) {
      String parentSpanName = spanNames.get(i);
      String childSpanName = spanNames.get(i + 1);
      SpanData parentSpan = getSpanByName(parentSpanName);
      SpanData childSpan = getSpanByName(childSpanName);
      assertNotNull(parentSpan);
      assertNotNull(childSpan);
      assertEquals(childSpan.getParentSpanId(), parentSpan.getSpanId());
      assertSameTrace(childSpan, parentSpan);
      // gRPC spans do not have datastore attributes.
      if (!parentSpanName.startsWith(SERVICE)) {
        assertHasExpectedAttributes(parentSpan);
      }
      if (!childSpanName.startsWith(SERVICE)) {
        assertHasExpectedAttributes(childSpan);
      }
    }
  }

  void assertHasExpectedAttributes(SpanData spanData, String... additionalExpectedAttributes) {
    // All datastore-generated spans have the settings attributes.
    List<String> expectedAttributes =
        Arrays.asList(
            "gcp.datastore.memoryUtilization",
            "gcp.datastore.settings.host",
            "gcp.datastore.settings.databaseId",
            "gcp.datastore.settings.retrySettings.maxRpcTimeout",
            "gcp.datastore.settings.retrySettings.retryDelayMultiplier",
            "gcp.datastore.settings.retrySettings.initialRetryDelay",
            "gcp.datastore.settings.credentials.authenticationType",
            "gcp.datastore.settings.retrySettings.maxAttempts",
            "gcp.datastore.settings.retrySettings.maxRetryDelay",
            "gcp.datastore.settings.retrySettings.rpcTimeoutMultiplier",
            "gcp.datastore.settings.retrySettings.totalTimeout",
            "gcp.datastore.settings.retrySettings.initialRpcTimeout");

    expectedAttributes.addAll(Arrays.asList(additionalExpectedAttributes));

    Attributes spanAttributes = spanData.getAttributes();
    for (String expectedAttribute : expectedAttributes) {
      assertNotNull(spanAttributes.get(AttributeKey.stringKey(expectedAttribute)));
    }
  }

  // Returns true if and only if the given span data contains an event with the given name and the
  // given expected
  // attributes.
  boolean hasEvent(SpanData spanData, String eventName, @Nullable Attributes expectedAttributes) {
    if (spanData == null) {
      return false;
    }

    logger.log(
        Level.INFO,
        String.format(
            "Checking if span named '%s' (ID='%s') contains an event named '%s'",
            spanData.getName(), spanData.getSpanId(), eventName));

    List<EventData> events = spanData.getEvents();
    for (EventData event : events) {
      if (event.getName().equals(eventName)) {
        if (expectedAttributes == null) {
          return true;
        }

        // Make sure attributes also match.
        Attributes eventAttributes = event.getAttributes();
        return expectedAttributes.equals(eventAttributes);
      }
    }
    return false;
  }

  void cleanupTestSpanContext() {
    inMemorySpanExporter.reset();
    spanNameToSpanId.clear();
    spanIdToParentSpanId.clear();
    spanNameToSpanData.clear();
  }

  // This is a POJO used for testing APIs that take a POJO.
  public static class Pojo {
    public int bar;

    public Pojo() {
      bar = 0;
    }

    public Pojo(int bar) {
      this.bar = bar;
    }

    public int getBar() {
      return bar;
    }

    public void setBar(int bar) {
      this.bar = bar;
    }
  }

  @Test
  public void lookupTraceTest() throws Exception {
    Entity entity = datastore.get(KEY1);
    assertNull(entity);

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_LOOKUP);
    SpanData span = getSpanByName(SPAN_NAME_LOOKUP);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_LOOKUP + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_RECEIVED, 0)
                .put(ATTRIBUTES_KEY_MISSING, 1)
                .put(ATTRIBUTES_KEY_DEFERRED, 0)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, false)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, "")
                .build()));
  }

  @Test
  public void allocateIdsTraceTest() throws Exception {
    String kind1 = "kind1";
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(kind1);
    IncompleteKey pk1 = keyFactory.newKey();
    Key key1 = datastore.allocateId(pk1);

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_ALLOCATE_IDS);
  }

  @Test
  public void reserveIdsTraceTest() throws Exception {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key key1 = keyFactory.newKey(10);
    Key key2 = keyFactory.newKey("name");
    List<Key> keyList = datastore.reserveIds(key1, key2);
    assertEquals(2, keyList.size());

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_RESERVE_IDS);
  }

  @Test
  public void commitTraceTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("test_key", "test_value").build();
    Entity response = datastore.add(entity1);
    assertEquals(entity1, response);

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_COMMIT);
  }

  @Test
  public void putTraceTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("test_key", "test_value").build();
    Entity response = datastore.put(entity1);
    assertEquals(entity1, response);

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_COMMIT);
  }

  @Test
  public void updateTraceTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("test_field", "test_value1").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("test_field", "test_value2").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_COMMIT);

    SpanData spanData = getSpanByName(SPAN_NAME_COMMIT);
    assertTrue(
        hasEvent(
            spanData,
            SPAN_NAME_COMMIT + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DOCUMENT_COUNT, response.size())
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, false)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, "")
                .build()));

    // Clean Up test span context to verify update spans
    cleanupTestSpanContext();

    Entity entity1_update = Entity.newBuilder(entity1).set("test_field", "new_test_value1").build();
    Entity entity2_update = Entity.newBuilder(entity2).set("test_field", "new_test_value1").build();
    datastore.update(entity1_update, entity2_update);

    waitForTracesToComplete();

    spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_COMMIT);
  }

  @Test
  public void deleteTraceTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("test_key", "test_value").build();
    Entity response = datastore.put(entity1);
    assertEquals(entity1, response);

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_COMMIT);

    SpanData spanData = getSpanByName(SPAN_NAME_COMMIT);
    assertTrue(
        hasEvent(
            spanData,
            SPAN_NAME_COMMIT + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DOCUMENT_COUNT, 1)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, false)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, "")
                .build()));

    // Clean Up test span context to verify update spans
    cleanupTestSpanContext();

    datastore.delete(entity1.getKey());

    waitForTracesToComplete();

    spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_COMMIT);

    spanData = getSpanByName(SPAN_NAME_COMMIT);
    assertTrue(
        hasEvent(
            spanData,
            SPAN_NAME_COMMIT + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DOCUMENT_COUNT, 1)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, false)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, "")
                .build()));
  }

  @Test
  public void runQueryTraceTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("test_field", "test_value1").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("test_field", "test_value2").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    // Clean Up test span context to verify RunQuery spans
    cleanupTestSpanContext();

    PropertyFilter filter = PropertyFilter.eq("test_field", entity1.getValue("test_field"));
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind(KEY1.getKind()).setFilter(filter).build();
    QueryResults<Entity> queryResults = datastore.run(query);
    assertTrue(queryResults.hasNext());
    assertEquals(entity1, queryResults.next());
    assertFalse(queryResults.hasNext());

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_RUN_QUERY);

    SpanData span = getSpanByName(SPAN_NAME_RUN_QUERY);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_RUN_QUERY + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DOCUMENT_COUNT, 1)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, false)
                .put(ATTRIBUTES_KEY_READ_CONSISTENCY, "READ_CONSISTENCY_UNSPECIFIED")
                .put(ATTRIBUTES_KEY_MORE_RESULTS, "NO_MORE_RESULTS")
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, "")
                .build()));
  }

  @Test
  public void runAggregationQueryTraceTest() throws Exception {
    Entity entity1 =
        Entity.newBuilder(KEY1)
            .set("pepper_name", "jalapeno")
            .set("max_scoville_level", 10000)
            .build();
    Entity entity2 =
        Entity.newBuilder(KEY2)
            .set("pepper_name", "serrano")
            .set("max_scoville_level", 25000)
            .build();
    Entity entity3 =
        Entity.newBuilder(KEY3)
            .set("pepper_name", "habanero")
            .set("max_scoville_level", 350000)
            .build();
    Entity entity4 =
        Entity.newBuilder(KEY4)
            .set("pepper_name", "ghost")
            .set("max_scoville_level", 1500000)
            .build();

    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);
    entityList.add(entity3);
    entityList.add(entity4);

    List<Entity> response = datastore.add(entity1, entity2, entity3, entity4);
    assertEquals(entityList, response);

    // Clean Up test span context to verify RunAggregationQuery spans
    cleanupTestSpanContext();

    PropertyFilter mediumSpicyFilters = PropertyFilter.lt("max_scoville_level", 100000);
    StructuredQuery<Entity> mediumSpicyQuery =
        Query.newEntityQueryBuilder().setKind(KEY1.getKind()).setFilter(mediumSpicyFilters).build();
    AggregationQuery countSpicyPeppers =
        Query.newAggregationQueryBuilder()
            .addAggregation(count().as("count"))
            .over(mediumSpicyQuery)
            .build();
    AggregationResults results = datastore.runAggregation(countSpicyPeppers);
    assertThat(results.size()).isEqualTo(1);
    AggregationResult result = results.get(0);
    assertThat(result.getLong("count")).isEqualTo(2L);

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    assertSpanHierarchy(SPAN_NAME_RUN_AGGREGATION_QUERY);
  }

  @Test
  public void newTransactionReadWriteTraceTest() throws Exception {
    // Transaction.Begin
    Transaction transaction = datastore.newTransaction();

    // Transaction.Lookup
    Entity entity = datastore.get(KEY1, ReadOption.transactionId(transaction.getTransactionId()));
    assertNull(entity);

    Entity updatedEntity = Entity.newBuilder(KEY1).set("test_field", "new_test_value1").build();
    transaction.put(updatedEntity);

    // Transaction.Commit
    transaction.commit();

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());

    assertSpanHierarchy(SPAN_NAME_BEGIN_TRANSACTION);
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_LOOKUP);
    SpanData span = getSpanByName(SPAN_NAME_TRANSACTION_LOOKUP);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_TRANSACTION_LOOKUP + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DEFERRED, 0)
                .put(ATTRIBUTES_KEY_MISSING, 1)
                .put(ATTRIBUTES_KEY_RECEIVED, 0)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, true)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, transaction.getTransactionId().toStringUtf8())
                .build()));

    assertSpanHierarchy(SPAN_NAME_TRANSACTION_COMMIT);
    span = getSpanByName(SPAN_NAME_TRANSACTION_COMMIT);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_TRANSACTION_COMMIT + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DOCUMENT_COUNT, 1)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, true)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, transaction.getTransactionId().toStringUtf8())
                .build()));
  }

  @Test
  public void newTransactionQueryTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("test_field", "test_value1").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("test_field", "test_value2").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    // Clean Up test span context to verify Transaction RunQuery spans
    cleanupTestSpanContext();

    Transaction transaction = datastore.newTransaction();
    PropertyFilter filter = PropertyFilter.eq("test_field", entity1.getValue("test_field"));
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind(KEY1.getKind()).setFilter(filter).build();
    QueryResults<Entity> queryResults = transaction.run(query);
    transaction.commit();
    assertTrue(queryResults.hasNext());
    assertEquals(entity1, queryResults.next());
    assertFalse(queryResults.hasNext());

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());

    assertSpanHierarchy(SPAN_NAME_BEGIN_TRANSACTION);
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_RUN_QUERY);
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_COMMIT);
    SpanData span = getSpanByName(SPAN_NAME_TRANSACTION_RUN_QUERY);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_TRANSACTION_RUN_QUERY + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DOCUMENT_COUNT, 1)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, true)
                .put(ATTRIBUTES_KEY_READ_CONSISTENCY, "READ_CONSISTENCY_UNSPECIFIED")
                .put(ATTRIBUTES_KEY_MORE_RESULTS, "NO_MORE_RESULTS")
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, transaction.getTransactionId().toStringUtf8())
                .build()));
  }

  @Test
  public void newTransactionRollbackTest() throws Exception {
    Entity entity1 = Entity.newBuilder(KEY1).set("pepper_type", "jalapeno").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("pepper_type", "habanero").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    // Clean Up test span context to verify Transaction Rollback spans
    cleanupTestSpanContext();

    String simplified_spice_level = "not_spicy";
    Entity entity1update =
        Entity.newBuilder(entity1).set("spice_level", simplified_spice_level).build();
    Transaction transaction = datastore.newTransaction();
    entity1 = transaction.get(KEY1);
    switch (entity1.getString("pepper_type")) {
      case "jalapeno":
        simplified_spice_level = "mild";
        break;

      case "habanero":
        simplified_spice_level = "hot";
        break;
    }
    transaction.update(entity1update);
    transaction.delete(KEY2);
    transaction.rollback();
    assertFalse(transaction.isActive());

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());

    assertSpanHierarchy(SPAN_NAME_BEGIN_TRANSACTION);
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_LOOKUP);
    SpanData span = getSpanByName(SPAN_NAME_TRANSACTION_LOOKUP);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_TRANSACTION_LOOKUP + " complete.",
            Attributes.builder()
                .put(ATTRIBUTES_KEY_DEFERRED, 0)
                .put(ATTRIBUTES_KEY_MISSING, 0)
                .put(ATTRIBUTES_KEY_RECEIVED, 1)
                .put(ATTRIBUTES_KEY_TRANSACTIONAL, true)
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, transaction.getTransactionId().toStringUtf8())
                .build()));

    assertSpanHierarchy(SPAN_NAME_ROLLBACK);
    span = getSpanByName(SPAN_NAME_ROLLBACK);
    assertTrue(
        hasEvent(
            span,
            SPAN_NAME_ROLLBACK,
            Attributes.builder()
                .put(ATTRIBUTES_KEY_TRANSACTION_ID, transaction.getTransactionId().toStringUtf8())
                .build()));
  }

  @Test
  public void runInTransactionQueryTest() throws Exception {
    // Set up
    Entity entity1 = Entity.newBuilder(KEY1).set("test_field", "test_value1").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("test_field", "test_value2").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    // Clean Up test span context to verify Transaction Rollback spans
    cleanupTestSpanContext();

    PropertyFilter filter = PropertyFilter.eq("test_field", entity1.getValue("test_field"));
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind(KEY1.getKind()).setFilter(filter).build();
    Datastore.TransactionCallable<Boolean> callable =
        transaction -> {
          QueryResults<Entity> queryResults = datastore.run(query);
          assertTrue(queryResults.hasNext());
          assertEquals(entity1, queryResults.next());
          assertFalse(queryResults.hasNext());
          return true;
        };
    datastore.runInTransaction(callable);

    waitForTracesToComplete();

    List<SpanData> spans = prepareSpans();
    assertEquals(4, spans.size());

    // Since the runInTransaction method runs the TransactionCallable opaquely in a transaction
    // there is no way for the API user to know the transaction ID, so we will not validate it here.
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_RUN, SPAN_NAME_BEGIN_TRANSACTION);
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_RUN, SPAN_NAME_RUN_QUERY);
    assertSpanHierarchy(SPAN_NAME_TRANSACTION_RUN, SPAN_NAME_TRANSACTION_COMMIT);
  }
}
