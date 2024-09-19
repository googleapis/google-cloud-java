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
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_ALLOCATE_IDS;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_BEGIN_TRANSACTION;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_COMMIT;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_LOOKUP;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_RESERVE_IDS;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_ROLLBACK;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_RUN_AGGREGATION_QUERY;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_RUN_QUERY;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_TRANSACTION_COMMIT;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_TRANSACTION_LOOKUP;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_TRANSACTION_RUN;
import static com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_TRANSACTION_RUN_QUERY;
import static com.google.common.truth.Truth.assertThat;
import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.SERVICE_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.Datastore;
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
import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.common.base.Preconditions;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.testing.junit.testparameterinjector.TestParameter;
import com.google.testing.junit.testparameterinjector.TestParameterInjector;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

// This End-to-End test verifies Client-side Tracing Functionality instrumented using the
// OpenTelemetry API.
// The test depends on the following external APIs/Services:
// 1. Java OpenTelemetry SDK
// 2. Cloud Trace Exporter
// 3. TraceServiceClient from Cloud Trace API v1.
//
// Permissions required to run this test (https://cloud.google.com/trace/docs/iam#trace-roles):
// 1. gcloud auth application-default login must be run with the test user.
// 2. To write traces, test user must have one of roles/cloudtrace.[admin|agent|user] roles.
// 3. To read traces, test user must have one of roles/cloudtrace.[admin|user] roles.
//
// Each test-case has the following workflow:
// 1. OpenTelemetry SDK is initialized with Cloud Trace Exporter and 100% Trace Sampling
// 2. On initialization, Datastore client is provided the OpenTelemetry SDK object from (1)
// 3. A custom TraceID is generated and injected using a custom SpanContext
// 4. Datastore operations are run inside a root TraceSpan created using the custom SpanContext from
// (3).
// 5. Traces are read-back using TraceServiceClient and verified against expected Call Stacks.
@RunWith(TestParameterInjector.class)
public class ITE2ETracingTest {

  protected boolean isUsingGlobalOpenTelemetrySDK() {
    return useGlobalOpenTelemetrySDK;
  }

  protected String datastoreNamedDatabase() {
    return datastoreNamedDatabase;
  }

  // Helper class to track call-stacks in a trace
  protected static class TraceContainer {

    // Maps Span ID to TraceSpan
    private final Map<Long, TraceSpan> idSpanMap;

    // Maps Parent Span ID to a list of Child SpanIDs, useful for top-down traversal
    private final Map<Long, List<Long>> parentChildIdMap;

    // Tracks the Root Span ID
    private long rootId;

    public TraceContainer(String rootSpanName, Trace trace) {
      idSpanMap = new TreeMap<>();
      parentChildIdMap = new TreeMap<>();
      for (TraceSpan span : trace.getSpansList()) {
        long spanId = span.getSpanId();
        idSpanMap.put(spanId, span);
        if (rootSpanName.equals(span.getName())) {
          rootId = span.getSpanId();
        }

        // Add self as a child of the parent span
        if (!parentChildIdMap.containsKey(span.getParentSpanId())) {
          parentChildIdMap.put(span.getParentSpanId(), new ArrayList<>());
        }
        parentChildIdMap.get(span.getParentSpanId()).add(spanId);
      }
    }

    String spanName(long spanId) {
      return idSpanMap.get(spanId).getName();
    }

    List<Long> childSpans(long spanId) {
      return parentChildIdMap.get(spanId);
    }

    // This method only works for matching call stacks with traces which have children of distinct
    // type at all levels. This is good enough as the intention is to validate if the e2e path is
    // WAI - the intention is not to validate Cloud Trace's correctness w.r.t. durability of all
    // kinds of traces.
    boolean containsCallStack(String... callStack) throws RuntimeException {
      List<String> expectedCallStack = Arrays.asList(callStack);
      if (expectedCallStack.isEmpty()) {
        throw new RuntimeException("Input callStack is empty");
      }
      return dfsContainsCallStack(rootId, expectedCallStack);
    }

    // Depth-first check for call stack in the trace
    private boolean dfsContainsCallStack(long spanId, List<String> expectedCallStack) {
      logger.info(
          "span="
              + spanName(spanId)
              + ", expectedCallStack[0]="
              + (expectedCallStack.isEmpty() ? "null" : expectedCallStack.get(0)));
      if (expectedCallStack.isEmpty()) {
        return false;
      }
      if (spanName(spanId).equals(expectedCallStack.get(0))) {
        // Recursion termination
        if (childSpans(spanId) == null) {
          logger.info("No more children for " + spanName(spanId));
          return expectedCallStack.size() <= 1;
        } else {
          // Examine the child spans
          for (Long childSpan : childSpans(spanId)) {
            int callStackListSize = expectedCallStack.size();
            logger.info(
                "childSpan="
                    + spanName(childSpan)
                    + ", expectedCallStackSize="
                    + callStackListSize);
            if (dfsContainsCallStack(
                childSpan,
                expectedCallStack.subList(
                    /*fromIndexInclusive=*/ 1, /*toIndexExclusive*/ callStackListSize))) {
              return true;
            }
          }
        }
      } else {
        logger.info(spanName(spanId) + " didn't match " + expectedCallStack.get(0));
      }
      return false;
    }
  }

  private static final Logger logger = Logger.getLogger(ITE2ETracingTest.class.getName());

  private static final String RUN_AGGREGATION_QUERY_RPC_NAME = "RunAggregationQuery";

  private static final String RUN_QUERY_RPC_NAME = "RunQuery";

  private static final int NUM_TRACE_ID_BYTES = 32;

  private static final int NUM_SPAN_ID_BYTES = 16;

  private static final int GET_TRACE_RETRY_COUNT = 60;

  private static final int GET_TRACE_RETRY_BACKOFF_MILLIS = 1000;

  private static final int TRACE_FORCE_FLUSH_MILLIS = 5000;

  private static final int TRACE_PROVIDER_SHUTDOWN_MILLIS = 1000;

  private static Key KEY1;

  private static Key KEY2;

  private static Key KEY3;

  private static Key KEY4;

  // Random int generator for trace ID and span ID
  private static Random random;

  private static TraceExporter traceExporter;

  // Required for reading back traces from Cloud Trace for validation
  private static TraceServiceClient traceClient_v1;

  // Custom SpanContext for each test, required for TraceID injection
  private static SpanContext customSpanContext;

  // Trace read back from Cloud Trace using traceClient_v1 for verification
  private static Trace retrievedTrace;

  private static String rootSpanName;
  private static Tracer tracer;

  // Required to set custom-root span
  private static OpenTelemetrySdk openTelemetrySdk;

  private static String projectId;

  private static DatastoreOptions options;

  private static Datastore datastore;

  private static RemoteDatastoreHelper remoteDatastoreHelper;

  @TestParameter boolean useGlobalOpenTelemetrySDK;

  @TestParameter({
    /*(default)*/
    "",
    "test-db"
  })
  String datastoreNamedDatabase;

  @BeforeClass
  public static void setup() throws IOException {
    projectId = DatastoreOptions.getDefaultProjectId();
    traceExporter =
        TraceExporter.createWithConfiguration(
            TraceConfiguration.builder().setProjectId(projectId).build());
    traceClient_v1 = TraceServiceClient.create();
    random = new Random();
  }

  @Before
  public void before() throws Exception {
    // Set up OTel SDK
    Resource resource =
        Resource.getDefault().merge(Resource.builder().put(SERVICE_NAME, "Sparky").build());

    if (isUsingGlobalOpenTelemetrySDK()) {
      openTelemetrySdk =
          OpenTelemetrySdk.builder()
              .setTracerProvider(
                  SdkTracerProvider.builder()
                      .setResource(resource)
                      .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build())
                      .setSampler(Sampler.alwaysOn())
                      .build())
              .buildAndRegisterGlobal();
    } else {
      openTelemetrySdk =
          OpenTelemetrySdk.builder()
              .setTracerProvider(
                  SdkTracerProvider.builder()
                      .setResource(resource)
                      .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build())
                      .setSampler(Sampler.alwaysOn())
                      .build())
              .build();
    }

    // Initialize the Datastore DB w/ the OTel SDK. Ideally we'd do this is the @BeforeAll method
    // but because gRPC traces need to be deterministically force-flushed for every test
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
    // Set up the tracer for custom TraceID injection
    rootSpanName =
        String.format("%s%d", this.getClass().getSimpleName(), System.currentTimeMillis());
    if (isUsingGlobalOpenTelemetrySDK()) {
      tracer = GlobalOpenTelemetry.getTracer(rootSpanName);
    } else {
      tracer =
          datastore
              .getOptions()
              .getOpenTelemetryOptions()
              .getOpenTelemetry()
              .getTracer(rootSpanName);
    }

    // Get up a new SpanContext (ergo TraceId) for each test
    customSpanContext = getNewSpanContext();
    assertNotNull(customSpanContext);
    assertNull(retrievedTrace);
  }

  @After
  public void after() throws Exception {
    if (isUsingGlobalOpenTelemetrySDK()) {
      GlobalOpenTelemetry.resetForTest();
    }
    remoteDatastoreHelper.deleteNamespace();
    rootSpanName = null;
    tracer = null;
    retrievedTrace = null;
    customSpanContext = null;
    openTelemetrySdk = null;
  }

  @AfterClass
  public static void teardown() throws Exception {
    traceClient_v1.close();
  }

  // Generates a random hex string of length `numBytes`
  private String generateRandomHexString(int numBytes) {
    StringBuilder newTraceId = new StringBuilder();
    while (newTraceId.length() < numBytes) {
      newTraceId.append(Integer.toHexString(random.nextInt()));
    }
    return newTraceId.substring(0, numBytes);
  }

  protected String generateNewTraceId() {
    return generateRandomHexString(NUM_TRACE_ID_BYTES);
  }

  // Generates a random 16-byte hex string
  protected String generateNewSpanId() {
    return generateRandomHexString(NUM_SPAN_ID_BYTES);
  }

  // Generates a new SpanContext w/ random traceId,spanId
  protected SpanContext getNewSpanContext() {
    String traceId = generateNewTraceId();
    String spanId = generateNewSpanId();
    logger.info("traceId=" + traceId + ", spanId=" + spanId);

    return SpanContext.create(traceId, spanId, TraceFlags.getSampled(), TraceState.getDefault());
  }

  protected Span getNewRootSpanWithContext() {
    // Execute the DB operation in the context of the custom root span.
    return tracer
        .spanBuilder(rootSpanName)
        .setParent(Context.root().with(Span.wrap(customSpanContext)))
        .startSpan();
  }

  protected void waitForTracesToComplete() throws Exception {
    logger.info("Flushing traces...");
    CompletableResultCode completableResultCode =
        openTelemetrySdk.getSdkTracerProvider().forceFlush();
    completableResultCode.join(TRACE_FORCE_FLUSH_MILLIS, TimeUnit.MILLISECONDS);
  }

  // Validates `retrievedTrace`. Cloud Trace indexes traces w/ eventual consistency, even when
  // indexing traceId, therefore the test must retry a few times before the complete trace is
  // available.
  // For Transaction traces, there may be more spans than in the trace than specified in
  // `callStack`. So `numExpectedSpans` is the expected total number of spans (and not just the
  // spans in `callStack`)
  protected void fetchAndValidateTrace(
      String traceId, int numExpectedSpans, List<List<String>> callStackList)
      throws InterruptedException {
    // Large enough count to accommodate eventually consistent Cloud Trace backend
    int numRetries = GET_TRACE_RETRY_COUNT;
    // Account for rootSpanName
    numExpectedSpans++;

    // Fetch traces
    do {
      try {
        retrievedTrace = traceClient_v1.getTrace(projectId, traceId);
        assertEquals(traceId, retrievedTrace.getTraceId());

        logger.info(
            "expectedSpanCount="
                + numExpectedSpans
                + ", retrievedSpanCount="
                + retrievedTrace.getSpansCount());
      } catch (NotFoundException notFound) {
        logger.info("Trace not found, retrying in " + GET_TRACE_RETRY_BACKOFF_MILLIS + " ms");
      } catch (IndexOutOfBoundsException outOfBoundsException) {
        logger.info("Call stack not found in trace. Retrying.");
      }
      if (retrievedTrace == null || numExpectedSpans != retrievedTrace.getSpansCount()) {
        Thread.sleep(GET_TRACE_RETRY_BACKOFF_MILLIS);
      }
    } while (numRetries-- > 0
        && (retrievedTrace == null || numExpectedSpans != retrievedTrace.getSpansCount()));

    if (retrievedTrace == null || numExpectedSpans != retrievedTrace.getSpansCount()) {
      throw new RuntimeException(
          "Expected number of spans: "
              + numExpectedSpans
              + ", Actual number of spans: "
              + (retrievedTrace != null
                  ? retrievedTrace.getSpansList().toString()
                  : "Trace NOT_FOUND"));
    }

    TraceContainer traceContainer = new TraceContainer(rootSpanName, retrievedTrace);

    for (List<String> callStack : callStackList) {
      // Update all call stacks to be rooted at rootSpanName
      ArrayList<String> expectedCallStack = new ArrayList<>(callStack);

      // numExpectedSpans should account for rootSpanName (not passed in callStackList)
      expectedCallStack.add(0, rootSpanName);

      // *May be* the full trace was returned
      logger.info("Checking if TraceContainer contains the callStack");
      String[] expectedCallList = new String[expectedCallStack.size()];
      if (!traceContainer.containsCallStack(expectedCallStack.toArray(expectedCallList))) {
        throw new RuntimeException(
            "Expected spans: "
                + Arrays.toString(expectedCallList)
                + ", Actual spans: "
                + (retrievedTrace != null
                    ? retrievedTrace.getSpansList().toString()
                    : "Trace NOT_FOUND"));
      }
      logger.severe("CallStack not found in TraceContainer.");
    }
  }

  // Validates `retrievedTrace`. Cloud Trace indexes traces w/ eventual consistency, even when
  // indexing traceId, therefore the test must retry a few times before the complete trace is
  // available.
  // For Non-Transaction traces, there is a 1:1 ratio of spans in `spanNames` and in the trace.
  protected void fetchAndValidateTrace(String traceId, String... spanNames)
      throws InterruptedException {
    fetchAndValidateTrace(traceId, spanNames.length, Arrays.asList(Arrays.asList(spanNames)));
  }

  @Test
  public void traceContainerTest() throws Exception {
    // Make sure the test has a new SpanContext (and TraceId for injection)
    assertNotNull(customSpanContext);

    // Inject new trace ID
    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Entity entity = datastore.get(KEY1);
      assertNull(entity);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    Trace traceResp = null;
    int expectedSpanCount = 2;

    int numRetries = GET_TRACE_RETRY_COUNT;
    do {
      try {
        traceResp = traceClient_v1.getTrace(projectId, customSpanContext.getTraceId());
        if (traceResp.getSpansCount() == expectedSpanCount) {
          logger.info("Success: Got " + expectedSpanCount + " spans.");
          break;
        }
      } catch (NotFoundException notFoundException) {
        Thread.sleep(GET_TRACE_RETRY_BACKOFF_MILLIS);
        logger.info("Trace not found, retrying in " + GET_TRACE_RETRY_BACKOFF_MILLIS + " ms");
      }
      logger.info(
          "Trace Found. The trace did not contain "
              + expectedSpanCount
              + " spans. Going to retry.");
      numRetries--;
    } while (numRetries > 0);

    // Make sure we got as many spans as we expected.
    assertNotNull(traceResp);
    assertEquals(expectedSpanCount, traceResp.getSpansCount());

    TraceContainer traceCont = new TraceContainer(rootSpanName, traceResp);

    // Contains exact path
    assertTrue(traceCont.containsCallStack(rootSpanName, SPAN_NAME_LOOKUP));

    // Top-level mismatch
    assertFalse(traceCont.containsCallStack(SPAN_NAME_LOOKUP, RUN_QUERY_RPC_NAME));

    // Leaf-level mismatch/missing
    assertFalse(
        traceCont.containsCallStack(
            rootSpanName, SPAN_NAME_LOOKUP, RUN_AGGREGATION_QUERY_RPC_NAME));
  }

  @Test
  public void lookupTraceTest() throws Exception {
    // Make sure the test has a new SpanContext (and TraceId for injection)
    assertNotNull(customSpanContext);

    // Inject new trace ID
    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Entity entity = datastore.get(KEY1);
      assertNull(entity);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_LOOKUP);
  }

  @Test
  public void allocateIdsTraceTest() throws Exception {
    assertNotNull(customSpanContext);

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      String kind1 = "kind1";
      KeyFactory keyFactory = datastore.newKeyFactory().setKind(kind1);
      IncompleteKey pk1 = keyFactory.newKey();
      Key key1 = datastore.allocateId(pk1);
      assertEquals(key1.getProjectId(), pk1.getProjectId());
      assertEquals(key1.getNamespace(), pk1.getNamespace());
      assertEquals(key1.getAncestors(), pk1.getAncestors());
      assertEquals(key1.getKind(), pk1.getKind());
      assertTrue(key1.hasId());
      assertFalse(key1.hasName());
      assertEquals(Key.newBuilder(pk1, key1.getId()).build(), key1);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_ALLOCATE_IDS);
  }

  @Test
  public void reserveIdsTraceTest() throws Exception {
    assertNotNull(customSpanContext);

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
      Key key1 = keyFactory.newKey(10);
      Key key2 = keyFactory.newKey("name");
      List<Key> keyList = datastore.reserveIds(key1, key2);
      assertEquals(2, keyList.size());
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_RESERVE_IDS);
  }

  @Test
  public void commitTraceTest() throws Exception {
    assertNotNull(customSpanContext);

    Span rootSpan = getNewRootSpanWithContext();

    Entity entity1 = Entity.newBuilder(KEY1).set("test_key", "test_value").build();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Entity response = datastore.add(entity1);
      assertEquals(entity1, response);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_COMMIT);
  }

  @Test
  public void putTraceTest() throws Exception {
    assertNotNull(customSpanContext);

    Span rootSpan = getNewRootSpanWithContext();

    Entity entity1 = Entity.newBuilder(KEY1).set("test_key", "test_value").build();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Entity response = datastore.put(entity1);
      assertEquals(entity1, response);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_COMMIT);
  }

  @Test
  public void updateTraceTest() throws Exception {
    assertNotNull(customSpanContext);

    Entity entity1 = Entity.newBuilder(KEY1).set("test_field", "test_value1").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("test_field", "test_value2").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Entity entity1_update =
          Entity.newBuilder(entity1).set("test_field", "new_test_value1").build();
      Entity entity2_update =
          Entity.newBuilder(entity2).set("test_field", "new_test_value1").build();
      datastore.update(entity1_update, entity2_update);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_COMMIT);
  }

  @Test
  public void deleteTraceTest() throws Exception {
    assertNotNull(customSpanContext);

    Entity entity1 = Entity.newBuilder(KEY1).set("test_key", "test_value").build();
    Entity response = datastore.put(entity1);
    assertEquals(entity1, response);

    Span rootSpan = getNewRootSpanWithContext();

    try (Scope ignored = rootSpan.makeCurrent()) {
      datastore.delete(entity1.getKey());
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();
    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_COMMIT);
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

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      PropertyFilter filter = PropertyFilter.eq("test_field", entity1.getValue("test_field"));
      Query<Entity> query =
          Query.newEntityQueryBuilder().setKind(KEY1.getKind()).setFilter(filter).build();
      QueryResults<Entity> queryResults = datastore.run(query);
      assertTrue(queryResults.hasNext());
      assertEquals(entity1, queryResults.next());
      assertFalse(queryResults.hasNext());
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_RUN_QUERY);
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

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      PropertyFilter mediumSpicyFilters = PropertyFilter.lt("max_scoville_level", 100000);
      StructuredQuery<Entity> mediumSpicyQuery =
          Query.newEntityQueryBuilder()
              .setKind(KEY1.getKind())
              .setFilter(mediumSpicyFilters)
              .build();
      AggregationQuery countSpicyPeppers =
          Query.newAggregationQueryBuilder()
              .addAggregation(count().as("count"))
              .over(mediumSpicyQuery)
              .build();
      AggregationResults results = datastore.runAggregation(countSpicyPeppers);
      assertThat(results.size()).isEqualTo(1);
      AggregationResult result = results.get(0);
      assertThat(result.getLong("count")).isEqualTo(2L);
    } finally {
      rootSpan.end();
    }

    waitForTracesToComplete();

    fetchAndValidateTrace(customSpanContext.getTraceId(), SPAN_NAME_RUN_AGGREGATION_QUERY);
  }

  @Test
  public void newTransactionReadTest() throws Exception {
    assertNotNull(customSpanContext);

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Transaction transaction = datastore.newTransaction();
      Entity entity = datastore.get(KEY1, ReadOption.transactionId(transaction.getTransactionId()));
      transaction.commit();
      assertNull(entity);
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(
        customSpanContext.getTraceId(),
        /*numExpectedSpans=*/ 3,
        Arrays.asList(
            Collections.singletonList(SPAN_NAME_BEGIN_TRANSACTION),
            Collections.singletonList(SPAN_NAME_TRANSACTION_LOOKUP),
            Collections.singletonList(SPAN_NAME_TRANSACTION_COMMIT)));
  }

  @Test
  public void newTransactionQueryTest() throws Exception {
    // Set up
    Entity entity1 = Entity.newBuilder(KEY1).set("test_field", "test_value1").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("test_field", "test_value2").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    assertNotNull(customSpanContext);

    // Test
    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
      Transaction transaction = datastore.newTransaction();
      PropertyFilter filter = PropertyFilter.eq("test_field", entity1.getValue("test_field"));
      Query<Entity> query =
          Query.newEntityQueryBuilder().setKind(KEY1.getKind()).setFilter(filter).build();
      QueryResults<Entity> queryResults = transaction.run(query);
      transaction.commit();
      assertTrue(queryResults.hasNext());
      assertEquals(entity1, queryResults.next());
      assertFalse(queryResults.hasNext());
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(
        customSpanContext.getTraceId(),
        /*numExpectedSpans=*/ 3,
        Arrays.asList(
            Collections.singletonList(SPAN_NAME_BEGIN_TRANSACTION),
            Collections.singletonList(SPAN_NAME_TRANSACTION_RUN_QUERY),
            Collections.singletonList(SPAN_NAME_TRANSACTION_COMMIT)));
  }

  @Test
  public void newTransactionReadWriteTraceTest() throws Exception {
    // Set up
    Entity entity1 = Entity.newBuilder(KEY1).set("pepper_type", "jalapeno").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("pepper_type", "habanero").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    String simplified_spice_level = "not_spicy";
    Entity entity1update =
        Entity.newBuilder(entity1).set("spice_level", simplified_spice_level).build();

    assertNotNull(customSpanContext);

    // Test
    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
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
      transaction.commit();
      assertFalse(transaction.isActive());
    } finally {
      rootSpan.end();
    }

    waitForTracesToComplete();

    List<Entity> list = datastore.fetch(KEY1, KEY2);
    assertEquals(list.get(0), entity1update);
    assertNull(list.get(1));

    fetchAndValidateTrace(
        customSpanContext.getTraceId(),
        /*numExpectedSpans=*/ 3,
        Arrays.asList(
            Collections.singletonList(SPAN_NAME_BEGIN_TRANSACTION),
            Collections.singletonList(SPAN_NAME_TRANSACTION_LOOKUP),
            Collections.singletonList(SPAN_NAME_TRANSACTION_COMMIT)));
  }

  @Test
  public void newTransactionRollbackTest() throws Exception {
    // Set up
    Entity entity1 = Entity.newBuilder(KEY1).set("pepper_type", "jalapeno").build();
    Entity entity2 = Entity.newBuilder(KEY2).set("pepper_type", "habanero").build();
    List<Entity> entityList = new ArrayList<>();
    entityList.add(entity1);
    entityList.add(entity2);

    List<Entity> response = datastore.add(entity1, entity2);
    assertEquals(entityList, response);

    String simplified_spice_level = "not_spicy";
    Entity entity1update =
        Entity.newBuilder(entity1).set("spice_level", simplified_spice_level).build();

    assertNotNull(customSpanContext);

    // Test
    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
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
    } finally {
      rootSpan.end();
    }

    waitForTracesToComplete();

    List<Entity> list = datastore.fetch(KEY1, KEY2);
    assertEquals(list.get(0), entity1);
    assertEquals(list.get(1), entity2);

    fetchAndValidateTrace(
        customSpanContext.getTraceId(),
        /*numExpectedSpans=*/ 3,
        Arrays.asList(
            Collections.singletonList(SPAN_NAME_BEGIN_TRANSACTION),
            Collections.singletonList(SPAN_NAME_TRANSACTION_LOOKUP),
            Collections.singletonList(SPAN_NAME_ROLLBACK)));
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

    assertNotNull(customSpanContext);

    Span rootSpan = getNewRootSpanWithContext();
    try (Scope ignored = rootSpan.makeCurrent()) {
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
    } finally {
      rootSpan.end();
    }
    waitForTracesToComplete();

    fetchAndValidateTrace(
        customSpanContext.getTraceId(),
        /*numExpectedSpans=*/ 4,
        Arrays.asList(
            Arrays.asList(SPAN_NAME_TRANSACTION_RUN, SPAN_NAME_BEGIN_TRANSACTION),
            Arrays.asList(SPAN_NAME_TRANSACTION_RUN, SPAN_NAME_RUN_QUERY),
            Arrays.asList(SPAN_NAME_TRANSACTION_RUN, SPAN_NAME_TRANSACTION_COMMIT)));
  }
}
