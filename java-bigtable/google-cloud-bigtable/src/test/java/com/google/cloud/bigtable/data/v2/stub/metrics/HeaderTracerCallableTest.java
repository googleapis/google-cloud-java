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
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnavailableException;
import com.google.bigtable.v2.BigtableGrpc.BigtableImplBase;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceHelper;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.collect.ImmutableMap;
import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.opencensus.impl.stats.StatsComponentImpl;
import io.opencensus.stats.StatsComponent;
import io.opencensus.stats.ViewData;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tags;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HeaderTracerCallableTest {
  private FakeServiceHelper serviceHelper;
  private FakeServiceHelper serviceHelperNoHeader;

  private FakeService fakeService = new FakeService();

  private final StatsComponent localStats = new StatsComponentImpl();
  private EnhancedBigtableStub stub;
  private EnhancedBigtableStub noHeaderStub;
  private int attempts;

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String APP_PROFILE_ID = "default";
  private static final String TABLE_ID = "fake-table";

  private static final long WAIT_FOR_METRICS_TIME_MS = 1_000;

  private AtomicInteger fakeServerTiming;

  @Before
  public void setUp() throws Exception {
    RpcViews.registerBigtableClientGfeViews(localStats.getViewManager());

    // Create a server that'll inject a server-timing header with a random number and a stub that
    // connects to this server.
    fakeServerTiming = new AtomicInteger(new Random().nextInt(1000) + 1);
    serviceHelper =
        new FakeServiceHelper(
            new ServerInterceptor() {
              @Override
              public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                  ServerCall<ReqT, RespT> serverCall,
                  Metadata metadata,
                  ServerCallHandler<ReqT, RespT> serverCallHandler) {
                return serverCallHandler.startCall(
                    new SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
                      @Override
                      public void sendHeaders(Metadata headers) {
                        headers.put(
                            Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER),
                            String.format("gfet4t7; dur=%d", fakeServerTiming.get()));
                        super.sendHeaders(headers);
                      }
                    },
                    metadata);
              }
            },
            fakeService);
    serviceHelper.start();

    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(serviceHelper.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .build();
    EnhancedBigtableStubSettings stubSettings =
        EnhancedBigtableStub.finalizeSettings(
            settings.getStubSettings(), Tags.getTagger(), localStats.getStatsRecorder());
    attempts = stubSettings.readRowsSettings().getRetrySettings().getMaxAttempts();
    stub = new EnhancedBigtableStub(stubSettings, ClientContext.create(stubSettings));

    // Create another server without injecting the server-timing header and another stub that
    // connects to it.
    serviceHelperNoHeader = new FakeServiceHelper(fakeService);
    serviceHelperNoHeader.start();

    BigtableDataSettings noHeaderSettings =
        BigtableDataSettings.newBuilderForEmulator(serviceHelperNoHeader.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .build();
    EnhancedBigtableStubSettings noHeaderStubSettings =
        EnhancedBigtableStub.finalizeSettings(
            noHeaderSettings.getStubSettings(), Tags.getTagger(), localStats.getStatsRecorder());
    noHeaderStub =
        new EnhancedBigtableStub(noHeaderStubSettings, ClientContext.create(noHeaderStubSettings));
  }

  @After
  public void tearDown() {
    stub.close();
    noHeaderStub.close();
    serviceHelper.shutdown();
    serviceHelperNoHeader.shutdown();
  }

  @Test
  public void testGFELatencyMetricReadRows() throws InterruptedException {
    stub.readRowsCallable().call(Query.create(TABLE_ID));

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);

    long latency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
            ImmutableMap.<TagKey, TagValue>of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);

    assertThat(latency).isEqualTo(fakeServerTiming.get());
  }

  @Test
  public void testGFELatencyMetricMutateRow() throws InterruptedException {
    stub.mutateRowCallable().call(RowMutation.create(TABLE_ID, "fake-key"));

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);

    long latency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.MutateRow"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);

    assertThat(latency).isEqualTo(fakeServerTiming.get());
  }

  @Test
  public void testGFELatencyMetricMutateRows() throws InterruptedException {
    BulkMutation mutations =
        BulkMutation.create(TABLE_ID)
            .add("key", Mutation.create().setCell("fake-family", "fake-qualifier", "fake-value"));
    stub.bulkMutateRowsCallable().call(mutations);

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);

    long latency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.MutateRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);

    assertThat(latency).isEqualTo(fakeServerTiming.get());
  }

  @Test
  public void testGFELatencySampleRowKeys() throws InterruptedException {
    stub.sampleRowKeysCallable().call(TABLE_ID);

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);
    long latency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.SampleRowKeys"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(latency).isEqualTo(fakeServerTiming.get());
  }

  @Test
  public void testGFELatencyCheckAndMutateRow() throws InterruptedException {
    ConditionalRowMutation mutation =
        ConditionalRowMutation.create(TABLE_ID, "fake-key")
            .then(Mutation.create().setCell("fake-family", "fake-qualifier", "fake-value"));
    stub.checkAndMutateRowCallable().call(mutation);

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);
    long latency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.CheckAndMutateRow"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(latency).isEqualTo(fakeServerTiming.get());
  }

  @Test
  public void testGFELatencyReadModifyWriteRow() throws InterruptedException {
    ReadModifyWriteRow request =
        ReadModifyWriteRow.create(TABLE_ID, "fake-key")
            .append("fake-family", "fake-qualifier", "suffix");
    stub.readModifyWriteRowCallable().call(request);

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);
    long latency =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadModifyWriteRow"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(latency).isEqualTo(fakeServerTiming.get());
  }

  @Test
  public void testGFEMissingHeaderMetric() throws InterruptedException {
    // Make a few calls to the server which will inject the server-timing header and the counter
    // should be 0.
    stub.readRowsCallable().call(Query.create(TABLE_ID));
    stub.mutateRowCallable().call(RowMutation.create(TABLE_ID, "key"));

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);
    long mutateRowMissingCount =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP,
                TagValue.create("Bigtable.MutateRow"),
                RpcMeasureConstants.BIGTABLE_STATUS,
                TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    long readRowsMissingCount =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW,
            ImmutableMap.<TagKey, TagValue>of(
                RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);

    assertThat(mutateRowMissingCount).isEqualTo(0);
    assertThat(readRowsMissingCount).isEqualTo(0);

    // Make a few more calls to the server which won't add the header and the counter should match
    // the number of requests sent.
    int readRowsCalls = new Random().nextInt(10) + 1;
    int mutateRowCalls = new Random().nextInt(10) + 1;
    for (int i = 0; i < mutateRowCalls; i++) {
      noHeaderStub.mutateRowCallable().call(RowMutation.create(TABLE_ID, "fake-key" + i));
    }
    for (int i = 0; i < readRowsCalls; i++) {
      noHeaderStub.readRowsCallable().call(Query.create(TABLE_ID));
    }

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);

    mutateRowMissingCount =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP,
                TagValue.create("Bigtable.MutateRow"),
                RpcMeasureConstants.BIGTABLE_STATUS,
                TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    readRowsMissingCount =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW,
            ImmutableMap.<TagKey, TagValue>of(
                RpcMeasureConstants.BIGTABLE_OP,
                TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS,
                TagValue.create("OK")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);

    assertThat(mutateRowMissingCount).isEqualTo(mutateRowCalls);
    assertThat(readRowsMissingCount).isEqualTo(readRowsCalls);
  }

  @Test
  public void testMetricsWithErrorResponse() throws InterruptedException {
    try {
      stub.readRowsCallable().call(Query.create("random-table-id")).iterator().next();
      fail("readrows should throw exception");
    } catch (Exception e) {
      assertThat(e).isInstanceOf(UnavailableException.class);
    }

    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);
    long missingCount =
        StatsTestUtils.getAggregationValueAsLong(
            localStats,
            RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW,
            ImmutableMap.of(
                RpcMeasureConstants.BIGTABLE_OP,
                TagValue.create("Bigtable.ReadRows"),
                RpcMeasureConstants.BIGTABLE_STATUS,
                TagValue.create("UNAVAILABLE")),
            PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID);
    assertThat(missingCount).isEqualTo(attempts);
  }

  @Test
  public void testCallableBypassed() throws InterruptedException {
    RpcViews.setGfeMetricsRegistered(false);
    stub.readRowsCallable().call(Query.create(TABLE_ID));
    Thread.sleep(WAIT_FOR_METRICS_TIME_MS);
    ViewData headerMissingView =
        localStats
            .getViewManager()
            .getView(RpcViewConstants.BIGTABLE_GFE_HEADER_MISSING_COUNT_VIEW.getName());
    ViewData latencyView =
        localStats.getViewManager().getView(RpcViewConstants.BIGTABLE_GFE_LATENCY_VIEW.getName());
    // Verify that the view is registered by it's not collecting metrics
    assertThat(headerMissingView).isNotNull();
    assertThat(latencyView).isNotNull();
    assertThat(headerMissingView.getAggregationMap()).isEmpty();
    assertThat(latencyView.getAggregationMap()).isEmpty();
  }

  private class FakeService extends BigtableImplBase {
    private final String defaultTableName =
        NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID);

    @Override
    public void readRows(ReadRowsRequest request, StreamObserver<ReadRowsResponse> observer) {
      if (!request.getTableName().equals(defaultTableName)) {
        observer.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        return;
      }
      observer.onNext(ReadRowsResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void mutateRow(MutateRowRequest request, StreamObserver<MutateRowResponse> observer) {
      observer.onNext(MutateRowResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void mutateRows(MutateRowsRequest request, StreamObserver<MutateRowsResponse> observer) {
      observer.onNext(MutateRowsResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void sampleRowKeys(
        SampleRowKeysRequest request, StreamObserver<SampleRowKeysResponse> observer) {
      observer.onNext(SampleRowKeysResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void checkAndMutateRow(
        CheckAndMutateRowRequest request, StreamObserver<CheckAndMutateRowResponse> observer) {
      observer.onNext(CheckAndMutateRowResponse.getDefaultInstance());
      observer.onCompleted();
    }

    @Override
    public void readModifyWriteRow(
        ReadModifyWriteRowRequest request, StreamObserver<ReadModifyWriteRowResponse> observer) {
      observer.onNext(ReadModifyWriteRowResponse.getDefaultInstance());
      observer.onCompleted();
    }
  }
}
