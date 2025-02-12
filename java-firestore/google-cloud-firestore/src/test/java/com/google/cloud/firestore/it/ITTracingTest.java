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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.telemetry.TelemetryConstants.*;
import static com.google.cloud.firestore.telemetry.TraceUtil.*;
import static io.opentelemetry.semconv.ResourceAttributes.SERVICE_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.firestore.BulkWriter;
import com.google.cloud.firestore.BulkWriterOptions;
import com.google.cloud.firestore.CollectionGroup;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldMask;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOpenTelemetryOptions;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteBatch;
import com.google.common.base.Preconditions;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.StatusCode;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
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

public abstract class ITTracingTest {
  protected abstract boolean isUsingGlobalOpenTelemetrySDK();

  private static final Logger logger =
      Logger.getLogger(com.google.cloud.firestore.it.ITTracingTest.class.getName());

  private static final int TRACE_FORCE_FLUSH_MILLIS = 1000;
  private static final int TRACE_PROVIDER_SHUTDOWN_MILLIS = 1000;
  private static final int IN_MEMORY_SPAN_EXPORTER_DELAY_MILLIS = 50;
  private static final String SERVICE = "google.firestore.v1.Firestore/";
  private static final String BATCH_GET_DOCUMENTS_RPC_NAME = "BatchGetDocuments";
  private static final String COMMIT_RPC_NAME = "Commit";
  private static final String LIST_DOCUMENTS_RPC_NAME = "ListDocuments";
  private static final String LIST_COLLECTIONS_RPC_NAME = "ListCollectionIds";
  private static final String BATCH_WRITE_RPC_NAME = "BatchWrite";
  private static final String RUN_QUERY_RPC_NAME = "RunQuery";
  private static final String RUN_AGGREGATION_QUERY_RPC_NAME = "RunAggregationQuery";
  private static final String BEGIN_TRANSACTION_RPC_NAME = "BeginTransaction";
  private static final String ROLLBACK_RPC_NAME = "Rollback";

  private static OpenTelemetrySdk openTelemetrySdk;

  // We use an InMemorySpanExporter for testing which keeps all generated trace spans
  // in memory so that we can check their correctness.
  protected InMemorySpanExporter inMemorySpanExporter;

  protected Firestore firestore;

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
    FirestoreOptions.Builder optionsBuilder = FirestoreOptions.newBuilder();
    FirestoreOpenTelemetryOptions.Builder otelOptionsBuilder =
        FirestoreOpenTelemetryOptions.newBuilder();
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
      optionsBuilder.setOpenTelemetryOptions(otelOptionsBuilder.build());
    } else {
      openTelemetrySdk = openTelemetrySdkBuilder.build();
      optionsBuilder.setOpenTelemetryOptions(
          otelOptionsBuilder.setOpenTelemetry(openTelemetrySdk).build());
    }

    String namedDb = System.getProperty("FIRESTORE_NAMED_DATABASE");
    if (namedDb != null) {
      logger.log(
          Level.INFO,
          String.format(
              "Integration test using named database %s for test %s",
              namedDb, testName.getMethodName()));
      optionsBuilder = optionsBuilder.setDatabaseId(namedDb);
    } else {
      logger.log(
          Level.INFO,
          String.format(
              "Integration test using default database for test %s", testName.getMethodName()));
    }
    firestore = optionsBuilder.build().getService();

    // Clean up existing maps.
    spanNameToSpanId.clear();
    spanIdToParentSpanId.clear();
    spanNameToSpanData.clear();
  }

  @After
  public void after() throws Exception {
    Preconditions.checkNotNull(
        firestore,
        "Error instantiating Firestore. Check that the service account credentials were properly set.");
    firestore.shutdown();
    inMemorySpanExporter.reset();
  }

  @AfterClass
  public static void teardown() {
    CompletableResultCode completableResultCode =
        openTelemetrySdk.getSdkTracerProvider().shutdown();
    completableResultCode.join(TRACE_PROVIDER_SHUTDOWN_MILLIS, TimeUnit.MILLISECONDS);
  }

  void waitForTracesToComplete() throws Exception {
    // We need to call `firestore.close()` because that will also close the
    // gRPC channel and hence force the gRPC instrumentation library to flush
    // its spans.
    firestore.close();

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
  // and that Firestore-generated spans contain the expected Firestore attributes.
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
      // gRPC spans do not have Firestore attributes.
      if (!parentSpanName.startsWith(SERVICE)) {
        assertHasExpectedAttributes(parentSpan);
      }
      if (!childSpanName.startsWith(SERVICE)) {
        assertHasExpectedAttributes(childSpan);
      }
    }
  }

  void assertHasExpectedAttributes(SpanData spanData, String... additionalExpectedAttributes) {
    // All Firestore-generated spans have the settings attributes.
    List<String> expectedAttributes =
        Arrays.asList(
            "gcp.firestore.memory_utilization",
            "gcp.firestore.settings.host",
            "gcp.firestore.settings.project_id",
            "gcp.firestore.settings.database_id",
            "gcp.firestore.settings.channel.needs_credentials",
            "gcp.firestore.settings.channel.needs_endpoint",
            "gcp.firestore.settings.channel.needs_headers",
            "gcp.firestore.settings.channel.should_auto_close",
            "gcp.firestore.settings.channel.transport_name",
            "gcp.firestore.settings.retry_settings.max_rpc_timeout",
            "gcp.firestore.settings.retry_settings.retry_delay_multiplier",
            "gcp.firestore.settings.retry_settings.initial_retry_delay",
            "gcp.firestore.settings.credentials.authentication_type",
            "gcp.firestore.settings.retry_settings.max_attempts",
            "gcp.firestore.settings.retry_settings.max_retry_delay",
            "gcp.firestore.settings.retry_settings.rpc_timeout_multiplier",
            "gcp.firestore.settings.retry_settings.total_timeout",
            "gcp.firestore.settings.retry_settings.initial_rpc_timeout");

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
  public void aggregateQueryGet() throws Exception {
    firestore.collection("col").count().get().get();
    waitForTracesToComplete();
    List<SpanData> spans = inMemorySpanExporter.getFinishedSpanItems();
    buildSpanMaps(spans);
    assertEquals(2, spans.size());
    SpanData getSpan = getSpanByName(METHOD_NAME_AGGREGATION_QUERY_GET);
    SpanData grpcSpan = getGrpcSpanByName(METHOD_NAME_RUN_AGGREGATION_QUERY);
    assertNotNull(getSpan);
    assertNotNull(grpcSpan);
    assertEquals(grpcSpan.getParentSpanId(), getSpan.getSpanId());
    assertSameTrace(getSpan, grpcSpan);
    assertHasExpectedAttributes(getSpan);
    List<EventData> events = getSpan.getEvents();
    assertTrue(events.size() > 0);
    assertTrue(events.get(0).getAttributes().size() > 0);
    assertEquals(events.get(0).getName(), "RunAggregationQuery Stream started.");
    assertEquals(
        events.get(0).getAttributes().get(AttributeKey.longKey(ATTRIBUTE_KEY_ATTEMPT)).longValue(),
        0);
  }

  @Test
  public void bulkWriterCommit() throws Exception {
    ScheduledExecutorService bulkWriterExecutor = Executors.newSingleThreadScheduledExecutor();
    BulkWriter bulkWriter =
        firestore.bulkWriter(BulkWriterOptions.builder().setExecutor(bulkWriterExecutor).build());
    bulkWriter.set(
        firestore.collection("col").document("foo"),
        Collections.singletonMap("bulk-foo", "bulk-bar"));
    bulkWriter.close();
    bulkWriterExecutor.awaitTermination(100, TimeUnit.MILLISECONDS);

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_BULK_WRITER_COMMIT, grpcSpanName(BATCH_WRITE_RPC_NAME));
  }

  @Test
  public void partitionQuery() throws Exception {
    CollectionGroup collectionGroup = firestore.collectionGroup("col");
    collectionGroup.getPartitions(3).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_PARTITION_QUERY, grpcSpanName(METHOD_NAME_PARTITION_QUERY));
  }

  @Test
  public void collectionListDocuments() throws Exception {
    firestore.collection("col").listDocuments();

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_COL_REF_LIST_DOCUMENTS, grpcSpanName(LIST_DOCUMENTS_RPC_NAME));
  }

  @Test
  public void docRefCreate() throws Exception {
    firestore.collection("col").document().create(Collections.singletonMap("foo", "bar")).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_CREATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefCreate2() throws Exception {
    firestore.collection("col").document().create(new Pojo(1)).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_CREATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefSet() throws Exception {
    firestore.collection("col").document("foo").set(Collections.singletonMap("foo", "bar")).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_SET, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefSet2() throws Exception {
    firestore
        .collection("col")
        .document("foo")
        .set(Collections.singletonMap("foo", "bar"), SetOptions.merge())
        .get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_SET, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefSet3() throws Exception {
    firestore.collection("col").document("foo").set(new Pojo(1)).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_SET, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefSet4() throws Exception {
    firestore.collection("col").document("foo").set(new Pojo(1), SetOptions.merge()).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_SET, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefUpdate() throws Exception {
    firestore
        .collection("col")
        .document("foo")
        .update(Collections.singletonMap("foo", "bar"))
        .get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_UPDATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefUpdate2() throws Exception {
    firestore
        .collection("col")
        .document("foo")
        .update(Collections.singletonMap("foo", "bar"), Precondition.NONE)
        .get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_UPDATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefUpdate3() throws Exception {
    firestore.collection("col").document("foo").update("key", "value", "key2", "value2").get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_UPDATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefUpdate4() throws Exception {
    firestore
        .collection("col")
        .document("foo")
        .update(FieldPath.of("key"), "value", FieldPath.of("key2"), "value2")
        .get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_UPDATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefUpdate5() throws Exception {
    firestore
        .collection("col")
        .document("foo")
        .update(Precondition.NONE, "key", "value", "key2", "value2")
        .get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_UPDATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefUpdate6() throws Exception {
    firestore
        .collection("col")
        .document("foo")
        .update(Precondition.NONE, FieldPath.of("key"), "value", FieldPath.of("key2"), "value2")
        .get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_UPDATE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefDelete() throws Exception {
    firestore.collection("col").document("doc0").delete().get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_DELETE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefDelete2() throws Exception {
    firestore.collection("col").document("doc0").delete(Precondition.NONE).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(3, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_DELETE, METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
  }

  @Test
  public void docRefGet() throws Exception {
    firestore.collection("col").document("doc0").get().get();

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_DOC_REF_GET, grpcSpanName(BATCH_GET_DOCUMENTS_RPC_NAME));
  }

  @Test
  public void docRefGet2() throws Exception {
    firestore.collection("col").document("doc0").get(FieldMask.of("foo")).get();

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_DOC_REF_GET, grpcSpanName(BATCH_GET_DOCUMENTS_RPC_NAME));
  }

  @Test
  public void docListCollections() throws Exception {
    firestore.collection("col").document("doc0").listCollections();

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_DOC_REF_LIST_COLLECTIONS, grpcSpanName(LIST_COLLECTIONS_RPC_NAME));
  }

  @Test
  public void getAll() throws Exception {
    DocumentReference docRef0 = firestore.collection("col").document();
    DocumentReference docRef1 = firestore.collection("col").document();
    DocumentReference[] docs = {docRef0, docRef1};
    firestore.getAll(docs).get();
    List<SpanData> spans = prepareSpans();
    assertEquals(1, spans.size());
    SpanData span = getSpanByName(grpcSpanName(BATCH_GET_DOCUMENTS_RPC_NAME));
    assertTrue(hasEvent(span, "BatchGetDocuments: First response received", null));
    assertTrue(
        hasEvent(
            span,
            "BatchGetDocuments: Completed with 2 responses.",
            Attributes.builder().put(ATTRIBUTE_KEY_NUM_RESPONSES, 2).build()));
  }

  @Test
  public void queryGet() throws Exception {
    firestore.collection("col").whereEqualTo("foo", "my_non_existent_value").get().get();
    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_QUERY_GET, grpcSpanName(RUN_QUERY_RPC_NAME));
    SpanData span = getSpanByName(METHOD_NAME_QUERY_GET);
    assertTrue(
        hasEvent(
            span,
            "RunQuery",
            Attributes.builder()
                .put(ATTRIBUTE_KEY_IS_RETRY_WITH_CURSOR, false)
                .put(ATTRIBUTE_KEY_IS_TRANSACTIONAL, false)
                .build()));
    assertTrue(
        hasEvent(
            span,
            "RunQuery: Completed",
            Attributes.builder().put(ATTRIBUTE_KEY_DOC_COUNT, 0).build()));
  }

  @Test
  public void transaction() throws Exception {
    firestore
        .runTransaction(
            transaction -> {
              Query q = firestore.collection("col").whereGreaterThan("bla", "");
              DocumentReference d = firestore.collection("col").document("foo");
              DocumentReference[] docList = {d, d};
              // Document Query.
              transaction.get(q).get();

              // Aggregation Query.
              transaction.get(q.count());

              // Get multiple documents.
              transaction.getAll(d, d).get();

              // Commit 2 documents.
              transaction.set(
                  firestore.collection("foo").document("bar"),
                  Collections.singletonMap("foo", "bar"));
              transaction.set(
                  firestore.collection("foo").document("bar2"),
                  Collections.singletonMap("foo2", "bar2"));
              return 0;
            })
        .get();

    /*
    Transaction.Run
    |_ Transaction.Begin
    |_ Transaction.Get.Query
    |_ Transaction.Get.AggregateQuery
    |_ Transaction.Get.Documents
    |_ Transaction.Get.Documents
    |_ Transaction.Get.Commit
    */
    List<SpanData> spans = prepareSpans();
    assertEquals(11, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN,
        METHOD_NAME_TRANSACTION_BEGIN,
        grpcSpanName(BEGIN_TRANSACTION_RPC_NAME));
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN,
        METHOD_NAME_TRANSACTION_GET_QUERY,
        grpcSpanName(RUN_QUERY_RPC_NAME));
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN,
        METHOD_NAME_TRANSACTION_GET_AGGREGATION_QUERY,
        grpcSpanName(RUN_AGGREGATION_QUERY_RPC_NAME));
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN,
        METHOD_NAME_TRANSACTION_GET_DOCUMENTS,
        grpcSpanName(BATCH_GET_DOCUMENTS_RPC_NAME));
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN, METHOD_NAME_TRANSACTION_COMMIT, grpcSpanName(COMMIT_RPC_NAME));

    Attributes commitAttributes = getSpanByName(METHOD_NAME_TRANSACTION_COMMIT).getAttributes();
    assertEquals(
        2L,
        commitAttributes
            .get(AttributeKey.longKey("gcp.firestore." + ATTRIBUTE_KEY_DOC_COUNT))
            .longValue());

    Attributes runTransactionAttributes =
        getSpanByName(METHOD_NAME_TRANSACTION_RUN).getAttributes();
    assertEquals(
        5L,
        runTransactionAttributes
            .get(AttributeKey.longKey("gcp.firestore." + ATTRIBUTE_KEY_ATTEMPTS_ALLOWED))
            .longValue());
    assertEquals(
        5L,
        runTransactionAttributes
            .get(AttributeKey.longKey("gcp.firestore." + ATTRIBUTE_KEY_ATTEMPTS_REMAINING))
            .longValue());
    assertEquals(
        "READ_WRITE",
        runTransactionAttributes.get(
            AttributeKey.stringKey("gcp.firestore." + ATTRIBUTE_KEY_TRANSACTION_TYPE)));
  }

  @Test
  public void transactionRollback() throws Exception {
    String myErrorMessage = "My error message.";
    try {
      firestore
          .runTransaction(
              transaction -> {
                if (true) {
                  throw (new Exception(myErrorMessage));
                }
                return 0;
              })
          .get();
    } catch (Exception e) {
      // Catch and move on.
    }

    /*
    Transaction.Run
    |_ Transaction.Begin
    |_ Transaction.Rollback
    */
    List<SpanData> spans = prepareSpans();
    assertEquals(5, spans.size());
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN,
        METHOD_NAME_TRANSACTION_BEGIN,
        grpcSpanName(BEGIN_TRANSACTION_RPC_NAME));
    assertSpanHierarchy(
        METHOD_NAME_TRANSACTION_RUN,
        METHOD_NAME_TRANSACTION_ROLLBACK,
        grpcSpanName(ROLLBACK_RPC_NAME));

    SpanData runTransactionSpanData = getSpanByName(METHOD_NAME_TRANSACTION_RUN);
    assertEquals(StatusCode.ERROR, runTransactionSpanData.getStatus().getStatusCode());
    assertEquals(1, runTransactionSpanData.getEvents().size());
    assertEquals(
        myErrorMessage,
        runTransactionSpanData
            .getEvents()
            .get(0)
            .getAttributes()
            .get(AttributeKey.stringKey("exception.message")));
    assertEquals(
        "java.lang.Exception",
        runTransactionSpanData
            .getEvents()
            .get(0)
            .getAttributes()
            .get(AttributeKey.stringKey("exception.type")));
    assertTrue(
        runTransactionSpanData
            .getEvents()
            .get(0)
            .getAttributes()
            .get(AttributeKey.stringKey("exception.stacktrace"))
            .startsWith("java.lang.Exception: My error message."));
  }

  @Test
  public void writeBatch() throws Exception {
    WriteBatch batch = firestore.batch();
    DocumentReference docRef = firestore.collection("foo").document();
    batch.create(docRef, Collections.singletonMap("foo", "bar"));
    batch.update(docRef, Collections.singletonMap("foo", "bar"));
    batch.delete(docRef);
    batch.commit().get();

    List<SpanData> spans = prepareSpans();
    assertEquals(2, spans.size());
    assertSpanHierarchy(METHOD_NAME_BATCH_COMMIT, grpcSpanName(COMMIT_RPC_NAME));
    assertEquals(
        false,
        getSpanByName(METHOD_NAME_BATCH_COMMIT)
            .getAttributes()
            .get(AttributeKey.booleanKey("gcp.firestore." + ATTRIBUTE_KEY_IS_TRANSACTIONAL))
            .booleanValue());
    assertEquals(
        3L,
        getSpanByName(METHOD_NAME_BATCH_COMMIT)
            .getAttributes()
            .get(AttributeKey.longKey("gcp.firestore." + ATTRIBUTE_KEY_DOC_COUNT))
            .longValue());
  }
}
