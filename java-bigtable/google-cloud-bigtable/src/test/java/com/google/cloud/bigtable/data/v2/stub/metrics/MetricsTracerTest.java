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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;

import com.google.api.gax.rpc.ClientContext;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.opencensus.common.Function;
import io.opencensus.impl.stats.StatsComponentImpl;
import io.opencensus.stats.AggregationData;
import io.opencensus.stats.AggregationData.CountData;
import io.opencensus.stats.AggregationData.DistributionData;
import io.opencensus.stats.AggregationData.LastValueDataDouble;
import io.opencensus.stats.AggregationData.LastValueDataLong;
import io.opencensus.stats.AggregationData.SumDataDouble;
import io.opencensus.stats.AggregationData.SumDataLong;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewData;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tags;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Answers;
import org.mockito.Mock;
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

  private StatsComponentImpl localStats = new StatsComponentImpl();
  private EnhancedBigtableStub stub;

  @Before
  public void setUp() throws Exception {
    int port;
    try (ServerSocket ss = new ServerSocket(0)) {
      port = ss.getLocalPort();
    }
    server = ServerBuilder.forPort(port).addService(mockService).build();
    server.start();

    RpcViews.registerBigtableClientViews(localStats.getViewManager());

    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(port)
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
        .readRows(any(ReadRowsRequest.class), anyObserver(ReadRowsResponse.class));

    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long opLatency =
        getAggregationValueAsLong(
            RpcViewConstants.BIGTABLE_OP_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")));
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
        .readRows(any(ReadRowsRequest.class), anyObserver(ReadRowsResponse.class));

    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long opLatency =
        getAggregationValueAsLong(
            RpcViewConstants.BIGTABLE_COMPLETED_OP_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")));
    assertThat(opLatency).isEqualTo(2);
  }

  @Test
  public void testReadRowsFirstRow() throws InterruptedException {
    final long beforeSleep = 50;
    final long afterSleep = 50;

    doAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocation) throws Throwable {
                @SuppressWarnings("unchecked")
                StreamObserver<ReadRowsResponse> observer =
                    (StreamObserver<ReadRowsResponse>) invocation.getArguments()[1];
                Thread.sleep(beforeSleep);
                observer.onNext(DEFAULT_READ_ROWS_RESPONSES);
                Thread.sleep(afterSleep);
                observer.onCompleted();
                return null;
              }
            })
        .when(mockService)
        .readRows(any(ReadRowsRequest.class), anyObserver(ReadRowsResponse.class));

    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long firstRowLatency =
        getAggregationValueAsLong(
            RpcViewConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY_VIEW,
            ImmutableMap.<TagKey, TagValue>of());

    // adding buffer time to the upper range to allow for a race between the emulator and the client
    // recording the duration
    assertThat(firstRowLatency).isIn(Range.closed(beforeSleep, elapsed - afterSleep / 2));
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
        .readRows(any(ReadRowsRequest.class), anyObserver(ReadRowsResponse.class));

    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long opLatency =
        getAggregationValueAsLong(
            RpcViewConstants.BIGTABLE_ATTEMPTS_PER_OP_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")));
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
        .readRows(any(ReadRowsRequest.class), anyObserver(ReadRowsResponse.class));

    Stopwatch stopwatch = Stopwatch.createStarted();
    Lists.newArrayList(stub.readRowsCallable().call(Query.create(TABLE_ID)));
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    // Give OpenCensus a chance to update the views asynchronously.
    Thread.sleep(100);

    long attemptLatency =
        getAggregationValueAsLong(
            RpcViewConstants.BIGTABLE_ATTEMPT_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")));
    // Average attempt latency will be just a single wait (as opposed to op latency which will be 2x
    // sleeptime)
    assertThat(attemptLatency).isIn(Range.closed(sleepTime, elapsed - sleepTime));
  }

  @SuppressWarnings("unchecked")
  private static <T> StreamObserver<T> anyObserver(Class<T> returnType) {
    return (StreamObserver<T>) any(returnType);
  }

  private long getAggregationValueAsLong(View view, ImmutableMap<TagKey, TagValue> tags) {
    ViewData viewData = localStats.getViewManager().getView(view.getName());
    Map<List<TagValue>, AggregationData> aggregationMap =
        Objects.requireNonNull(viewData).getAggregationMap();

    List<TagValue> tagValues = new ArrayList<>();

    for (TagKey column : view.getColumns()) {
      if (RpcMeasureConstants.BIGTABLE_PROJECT_ID == column) {
        tagValues.add(TagValue.create(PROJECT_ID));
      } else if (RpcMeasureConstants.BIGTABLE_INSTANCE_ID == column) {
        tagValues.add(TagValue.create(INSTANCE_ID));
      } else if (RpcMeasureConstants.BIGTABLE_APP_PROFILE_ID == column) {
        tagValues.add(TagValue.create(APP_PROFILE_ID));
      } else {
        tagValues.add(tags.get(column));
      }
    }

    AggregationData aggregationData = aggregationMap.get(tagValues);

    return aggregationData.match(
        new Function<SumDataDouble, Long>() {
          @Override
          public Long apply(SumDataDouble arg) {
            return (long) arg.getSum();
          }
        },
        new Function<SumDataLong, Long>() {
          @Override
          public Long apply(SumDataLong arg) {
            return arg.getSum();
          }
        },
        new Function<CountData, Long>() {
          @Override
          public Long apply(CountData arg) {
            return arg.getCount();
          }
        },
        new Function<DistributionData, Long>() {
          @Override
          public Long apply(DistributionData arg) {
            return (long) arg.getMean();
          }
        },
        new Function<LastValueDataDouble, Long>() {
          @Override
          public Long apply(LastValueDataDouble arg) {
            return (long) arg.getLastValue();
          }
        },
        new Function<LastValueDataLong, Long>() {
          @Override
          public Long apply(LastValueDataLong arg) {
            return arg.getLastValue();
          }
        },
        new Function<AggregationData, Long>() {
          @Override
          public Long apply(AggregationData arg) {
            throw new UnsupportedOperationException();
          }
        });
  }
}
