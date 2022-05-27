/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatcherImpl;
import com.google.api.gax.batching.BatchingDescriptor;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor;
import com.google.cloud.bigtable.misc_utilities.MethodComparator;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.opencensus.impl.stats.StatsComponentImpl;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tags;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class MetricsTracerTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String APP_PROFILE_ID = "default";
  private static final String TABLE_ID = "fake-table";

  private static final ReadRowsResponse DEFAULT_READ_ROWS_RESPONSES =
      ReadRowsResponse.newBuilder()
          .addChunks(
              CellChunk.newBuilder()
                  .setRowKey(ByteString.copyFromUtf8("fake-key"))
                  .setFamilyName(StringValue.of("cf"))
                  .setQualifier(BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("q")))
                  .setTimestampMicros(1_000)
                  .setValue(ByteString.copyFromUtf8("value"))
                  .setCommitRow(true))
          .build();

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  private Server server;

  @Mock(answer = Answers.CALLS_REAL_METHODS)
  private BigtableGrpc.BigtableImplBase mockService;

  private final StatsComponentImpl localStats = new StatsComponentImpl();
  private EnhancedBigtableStub stub;
  private BigtableDataSettings settings;

  @Before
  public void setUp() throws Exception {
    server = FakeServiceBuilder.create(mockService).start();

    RpcViews.registerBigtableClientViews(localStats.getViewManager());

    settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .build();
    EnhancedBigtableStubSettings stubSettings =
        EnhancedBigtableStub.finalizeSettings(
            settings.getStubSettings(), Tags.getTagger(), localStats.getStatsRecorder());
    stub = new EnhancedBigtableStub(stubSettings, ClientContext.create(stubSettings));
  }

  @After
  public void tearDown() {
    stub.close();
    server.shutdown();
  }

  @Test
  public void testReadRowsLatency() throws InterruptedException {
    final long sleepTime = 50;

    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) throws Throwable {
                @SuppressWarnings("unchecked")
                StreamObserver<ReadRowsResponse> observer =
                    (StreamObserver<ReadRowsResponse>) invocation.getArguments()[1];
                Thread.sleep(sleepTime);
                observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), any());

    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long opLatency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_OP_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(opLatency).isIn(Range.closed(sleepTime, elapsed));
  }

  @Test
  public void testReadRowsOpCount() throws InterruptedException {
    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) {
                @SuppressWarnings("unchecked")
                StreamObserver<ReadRowsResponse> observer =
                    (StreamObserver<ReadRowsResponse>) invocation.getArguments()[1];
                observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), any());

    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long opLatency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_COMPLETED_OP_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(opLatency).isEqualTo(2);
  }

  @Test
  public void testReadRowsFirstRow() throws InterruptedException {
    final long beforeSleep = 50;
    final long afterSleep = 50;

    SettableFuture<Void> gotFirstRow = SettableFuture.create();

    ExecutorService executor = Executors.newCachedThreadPool();
    doAnswer(
            invocation -> {
              StreamObserver<ReadRowsResponse> observer = invocation.getArgument(1);
              executor.submit(
                  () -> {
                    Thread.sleep(beforeSleep);
                    observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                    // wait until the first row is consumed before padding the operation span
                    gotFirstRow.get();
                    Thread.sleep(afterSleep);
                    observer.onCompleted();
                    return null;
                  });
              return null;
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), any());

    Stopwatch stopwatch = Stopwatch.createStarted();

    // Get the first row and notify the mock that it can start padding the operation span
    Iterator<Row> it = stub.readRowsCallable().call(Query.create(TABLE_ID)).iterator();
    it.next();
    gotFirstRow.set(null);
    // finish the stream
    while (it.hasNext()) {
      it.next();
    }
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);
    executor.shutdown();

    long firstRowLatency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY_VIEW,
            ImmutableMap.<TagKey, TagValue>of(),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);

    assertThat(firstRowLatency).isIn(Range.closed(beforeSleep, elapsed - afterSleep));
  }

  @Test
  public void testReadRowsAttemptsPerOp() throws InterruptedException {
    final AtomicInteger callCount = new AtomicInteger(0);

    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) {
                @SuppressWarnings("unchecked")
                StreamObserver<ReadRowsResponse> observer =
                    (StreamObserver<ReadRowsResponse>) invocation.getArguments()[1];

                // First call will trigger a transient error
                if (callCount.getAndIncrement() == 0) {
                  observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
                  return null;
                }

                // Next attempt will return a row
                observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), any());

    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long opLatency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_ATTEMPTS_PER_OP_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(opLatency).isEqualTo(2);
  }

  @Test
  public void testReadRowsAttemptLatency() throws InterruptedException {
    final long sleepTime = 50;
    final AtomicInteger callCount = new AtomicInteger(0);

    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) throws Throwable {
                @SuppressWarnings("unchecked")
                StreamObserver<ReadRowsResponse> observer =
                    (StreamObserver<ReadRowsResponse>) invocation.getArguments()[1];

                Thread.sleep(sleepTime);

                // First attempt will return a transient error
                if (callCount.getAndIncrement() == 0) {
                  observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
                  return null;
                }
                // Next attempt will be ok
                observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), any());

    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long attemptLatency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_ATTEMPT_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    // Average attempt latency will be just a single wait (as opposed to op latency which will be 2x
    // sleeptime)
    assertThat(attemptLatency).isIn(Range.closed(sleepTime, elapsed - sleepTime));
  }

  @Test
  public void testInvalidRequest() throws InterruptedException {
    try {
      stub.bulkMutateRowsCallable().call(BulkMutation.create(TABLE_ID));
      Assert.fail("Invalid request should throw exception");
    } catch (IllegalStateException e) {
      Thread.sleep(100);
      // Verify that the latency is recorded with an error code (in this case UNKNOWN)
      long attemptLatency =
          StatsTestUtils.getAggregationValueAsLong(
              localStats,
              RpcViewConstants.BIGTABLE_ATTEMPT_LATENCY_VIEW,
              ImmutableMap.of(
                  RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.MutateRows"),
                  RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("UNKNOWN")),
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE_ID);
      assertThat(attemptLatency).isAtLeast(0);
    }
  }

  @Test
  public void testBatchReadRowsThrottledTime() throws Exception {
    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) {
                @SuppressWarnings("unchecked")
                StreamObserver<ReadRowsResponse> observer =
                    (StreamObserver<ReadRowsResponse>) invocation.getArguments()[1];
                observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), any());

    try (Batcher batcher =
        stub.newBulkReadRowsBatcher(Query.create(TABLE_ID), GrpcCallContext.createDefault())) {
      batcher.add(ByteString.copyFromUtf8("row1"));
      batcher.sendOutstanding();

      // Give OpenCensus a chance to update the views asynchronously.
      Thread.sleep(100);

      long throttledTimeMetric =
          StatsTestUtils.getAggregationValueAsLong(
              localStats,
              RpcViewConstants.BIGTABLE_BATCH_THROTTLED_TIME_VIEW,
              ImmutableMap.of(
                  RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows")),
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE_ID);
      assertThat(throttledTimeMetric).isEqualTo(0);
    }
  }

  @Test
  public void testBatchMutateRowsThrottledTime() throws Exception {
    FlowController flowController = Mockito.mock(FlowController.class);
    BatchingDescriptor batchingDescriptor = Mockito.mock(MutateRowsBatchingDescriptor.class);
    // Mock throttling
    final long throttled = 50;
    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(throttled);
                return null;
              }
            })
        .when(flowController)
        .reserve(any(Long.class), any(Long.class));
    when(flowController.getMaxElementCountLimit()).thenReturn(null);
    when(flowController.getMaxRequestBytesLimit()).thenReturn(null);
    when(batchingDescriptor.countBytes(any())).thenReturn(1l);
    when(batchingDescriptor.newRequestBuilder(any())).thenCallRealMethod();

    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) {
                @SuppressWarnings("unchecked")
                StreamObserver<MutateRowsResponse> observer =
                    (StreamObserver<MutateRowsResponse>) invocation.getArguments()[1];
                observer.onNext(MutateRowsResponse.getDefaultInstance());
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .mutateRows(any(MutateRowsRequest.class), any());

    ApiCallContext defaultContext = GrpcCallContext.createDefault();

    Batcher batcher =
        new BatcherImpl(
            batchingDescriptor,
            stub.bulkMutateRowsCallable().withDefaultCallContext(defaultContext),
            BulkMutation.create(TABLE_ID),
            settings.getStubSettings().bulkMutateRowsSettings().getBatchingSettings(),
            Executors.newSingleThreadScheduledExecutor(),
            flowController,
            defaultContext);

    batcher.add(RowMutationEntry.create("key"));
    batcher.sendOutstanding();

    Thread.sleep(100);
    long throttledTimeMetric =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_BATCH_THROTTLED_TIME_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.MutateRows")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(throttledTimeMetric).isAtLeast(throttled);
  }

  @Test
  public void testMethodsOverride() {
    Method[] baseMethods = BigtableTracer.class.getDeclaredMethods();
    Method[] metricsTracerMethods = MetricsTracer.class.getDeclaredMethods();
    assertThat(Arrays.asList(metricsTracerMethods))
        .comparingElementsUsing(MethodComparator.METHOD_CORRESPONDENCE)
        .containsAtLeastElementsIn(baseMethods);
  }

  @SuppressWarnings("unchecked")
  private static <T> StreamObserver<T> anyObserver(Class<T> returnType) {
    return (StreamObserver<T>) any(returnType);
  }
}
