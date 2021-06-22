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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatcherImpl;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceHelper;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Queues;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.BindableService;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.internal.GrpcUtil;
import io.grpc.stub.StreamObserver;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.export.SpanData;
import io.opencensus.trace.export.SpanExporter.Handler;
import io.opencensus.trace.samplers.Samplers;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class EnhancedBigtableStubTest {

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_NAME =
      NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, "fake-table");
  private static final String APP_PROFILE_ID = "app-profile-id";

  FakeServiceHelper serviceHelper;
  private MetadataInterceptor metadataInterceptor;
  private ContextInterceptor contextInterceptor;
  private FakeDataService fakeDataService;
  private EnhancedBigtableStubSettings defaultSettings;
  private EnhancedBigtableStub enhancedBigtableStub;

  @Before
  public void setUp() throws IOException, IllegalAccessException, InstantiationException {
    metadataInterceptor = new MetadataInterceptor();
    contextInterceptor = new ContextInterceptor();
    fakeDataService = new FakeDataService();

    serviceHelper =
        new FakeServiceHelper(
            ImmutableList.of(contextInterceptor, metadataInterceptor),
            null,
            ImmutableList.<BindableService>of(fakeDataService));
    serviceHelper.start();

    defaultSettings =
        BigtableDataSettings.newBuilderForEmulator(serviceHelper.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build()
            .getStubSettings();

    enhancedBigtableStub = EnhancedBigtableStub.create(defaultSettings);
  }

  @After
  public void tearDown() {
    enhancedBigtableStub.close();
    serviceHelper.shutdown();
  }

  @Test
  public void testCreateReadRowsCallable() throws InterruptedException {
    ServerStreamingCallable<Query, Row> streamingCallable =
        enhancedBigtableStub.createReadRowsCallable(new DefaultRowAdapter());

    Query request = Query.create("table-id").rowKey("row-key");
    streamingCallable.call(request).iterator().next();
    ReadRowsRequest expected =
        request.toProto(RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID));
    assertThat(fakeDataService.popLastRequest()).isEqualTo(expected);
  }

  @Test
  public void testCreateReadRowsRawCallable() throws InterruptedException {
    ServerStreamingCallable<ReadRowsRequest, Row> callable =
        enhancedBigtableStub.createReadRowsRawCallable(new DefaultRowAdapter());

    ReadRowsRequest expectedRequest =
        ReadRowsRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setAppProfileId("app-profile-1")
            .setRows(RowSet.newBuilder().addRowKeys(ByteString.copyFromUtf8("test-row-key")))
            .build();
    callable.call(expectedRequest).iterator().next();
    assertThat(fakeDataService.popLastRequest()).isEqualTo(expectedRequest);

    ReadRowsRequest expectedRequest2 =
        ReadRowsRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setAppProfileId("app-profile-2")
            .build();
    callable.call(expectedRequest2).iterator().next();
    assertThat(fakeDataService.popLastRequest()).isEqualTo(expectedRequest2);
  }

  @Test
  public void testChannelPrimerConfigured() throws IOException {
    EnhancedBigtableStubSettings settings =
        defaultSettings
            .toBuilder()
            .setRefreshingChannel(true)
            .setPrimedTableIds("table1", "table2")
            .build();

    try (EnhancedBigtableStub ignored = EnhancedBigtableStub.create(settings)) {
      // priming will issue a request per table on startup
      assertThat(fakeDataService.requests).hasSize(2);
    }
  }

  @Test
  public void testUserAgent() throws InterruptedException {
    ServerStreamingCallable<Query, Row> streamingCallable =
        enhancedBigtableStub.createReadRowsCallable(new DefaultRowAdapter());

    Query request = Query.create("table-id").rowKey("row-key");
    streamingCallable.call(request).iterator().next();

    assertThat(metadataInterceptor.headers).hasSize(1);
    Metadata metadata = metadataInterceptor.headers.take();
    assertThat(metadata.get(Metadata.Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER)))
        .containsMatch("bigtable-java/\\d+\\.\\d+\\.\\d+(?:-SNAPSHOT)?");
  }

  @Test
  public void testSpanAttributes() throws InterruptedException {
    final BlockingQueue<SpanData> spans = new ArrayBlockingQueue<>(100);

    // inject a temporary trace exporter
    String handlerName = "stub-test-exporter";

    Tracing.getExportComponent()
        .getSpanExporter()
        .registerHandler(
            handlerName,
            new Handler() {
              @Override
              public void export(Collection<SpanData> collection) {
                spans.addAll(collection);
              }
            });

    SpanData foundSpanData = null;
    // Issue the rpc and grab the span
    try {
      try (Scope ignored =
          Tracing.getTracer()
              .spanBuilder("fake-parent-span")
              .setSampler(Samplers.alwaysSample())
              .startScopedSpan()) {
        enhancedBigtableStub.readRowCallable().call(Query.create("table-id").rowKey("row-key"));
      }

      for (int i = 0; i < 100; i++) {
        SpanData spanData = spans.poll(10, TimeUnit.SECONDS);
        if ("Bigtable.ReadRow".equals(spanData.getName())) {
          foundSpanData = spanData;
          break;
        }
      }
    } finally {
      // cleanup
      Tracing.getExportComponent().getSpanExporter().unregisterHandler(handlerName);
    }

    // Examine the caught span
    assertThat(foundSpanData).isNotNull();
    assertThat(foundSpanData.getAttributes().getAttributeMap())
        .containsEntry("gapic", AttributeValue.stringAttributeValue(Version.VERSION));
    assertThat(foundSpanData.getAttributes().getAttributeMap())
        .containsEntry(
            "grpc",
            AttributeValue.stringAttributeValue(
                GrpcUtil.getGrpcBuildVersion().getImplementationVersion()));
    assertThat(foundSpanData.getAttributes().getAttributeMap())
        .containsEntry(
            "gax", AttributeValue.stringAttributeValue(GaxGrpcProperties.getGaxGrpcVersion()));
  }

  @Test
  public void testBulkMutationFlowControllerConfigured() throws Exception {
    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setProjectId("my-project")
            .setInstanceId("my-instance")
            .setCredentialsProvider(defaultSettings.getCredentialsProvider())
            .enableBatchMutationLatencyBasedThrottling(10L);

    settings
        .stubSettings()
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            BatchingSettings.newBuilder()
                .setElementCountThreshold(50L)
                .setRequestByteThreshold(500L)
                .setFlowControlSettings(
                    FlowControlSettings.newBuilder()
                        .setMaxOutstandingElementCount(100L)
                        .setMaxOutstandingRequestBytes(1000L)
                        .setLimitExceededBehavior(LimitExceededBehavior.Block)
                        .build())
                .build())
        .build();

    try (EnhancedBigtableStub stub1 =
            EnhancedBigtableStub.create(settings.build().getStubSettings());
        EnhancedBigtableStub stub2 =
            EnhancedBigtableStub.create(settings.build().getStubSettings())) {

      // Creating 2 batchers from the same stub, they should share the same FlowController and
      // FlowControlEventStats
      try (BatcherImpl batcher1 = (BatcherImpl) stub1.newMutateRowsBatcher("my-table1", null);
          BatcherImpl batcher2 = (BatcherImpl) stub1.newMutateRowsBatcher("my-table2", null)) {
        assertThat(batcher1.getFlowController()).isNotNull();
        assertThat(batcher1.getFlowController().getFlowControlEventStats()).isNotNull();
        assertThat(batcher1).isNotSameInstanceAs(batcher2);
        assertThat(batcher1.getFlowController()).isSameInstanceAs(batcher2.getFlowController());
        assertThat(batcher1.getFlowController().getFlowControlEventStats())
            .isSameInstanceAs(batcher2.getFlowController().getFlowControlEventStats());
        // Verify flow controller settings
        assertThat(batcher1.getFlowController().getMaxElementCountLimit()).isEqualTo(100L);
        assertThat(batcher1.getFlowController().getMaxRequestBytesLimit()).isEqualTo(1000L);
        assertThat(batcher1.getFlowController().getCurrentElementCountLimit()).isLessThan(100L);
        assertThat(batcher1.getFlowController().getCurrentRequestBytesLimit()).isEqualTo(1000L);
        assertThat(batcher1.getFlowController().getMinElementCountLimit())
            .isAtLeast(
                settings
                    .stubSettings()
                    .bulkMutateRowsSettings()
                    .getBatchingSettings()
                    .getElementCountThreshold());
        assertThat(batcher1.getFlowController().getMinRequestBytesLimit()).isEqualTo(1000L);
      }

      // Creating 2 batchers from different stubs, they should not share the same FlowController and
      // FlowControlEventStats
      try (BatcherImpl batcher1 = (BatcherImpl) stub1.newMutateRowsBatcher("my-table1", null);
          BatcherImpl batcher2 = (BatcherImpl) stub2.newMutateRowsBatcher("my-table2", null)) {
        assertThat(batcher1.getFlowController()).isNotNull();
        assertThat(batcher1.getFlowController().getFlowControlEventStats()).isNotNull();
        assertThat(batcher1.getFlowController()).isNotSameInstanceAs(batcher2.getFlowController());
        assertThat(batcher1.getFlowController().getFlowControlEventStats())
            .isNotSameInstanceAs(batcher2.getFlowController().getFlowControlEventStats());
      }
    }
    try (EnhancedBigtableStub stub1 =
            EnhancedBigtableStub.create(settings.build().getStubSettings());
        EnhancedBigtableStub stub2 =
            EnhancedBigtableStub.create(
                settings
                    .disableBatchMutationLatencyBasedThrottling()
                    .build()
                    .getStubSettings()); ) {

      try (BatcherImpl batcher = (BatcherImpl) stub2.newMutateRowsBatcher("my-table", null)) {
        assertThat(batcher.getFlowController().getMaxElementCountLimit()).isEqualTo(100L);
        assertThat(batcher.getFlowController().getCurrentElementCountLimit()).isEqualTo(100L);
        assertThat(batcher.getFlowController().getMinElementCountLimit()).isEqualTo(100L);
      }
    }
  }

  @Test
  public void testCallContextPropagatedInMutationBatcher()
      throws IOException, InterruptedException, ExecutionException {
    EnhancedBigtableStubSettings settings =
        defaultSettings
            .toBuilder()
            .setRefreshingChannel(true)
            .setPrimedTableIds("table1", "table2")
            .build();

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings)) {
      // clear the previous contexts
      contextInterceptor.contexts.clear();

      // Override the timeout
      GrpcCallContext clientCtx =
          GrpcCallContext.createDefault().withTimeout(Duration.ofMinutes(10));

      // Send a batch
      try (Batcher<RowMutationEntry, Void> batcher =
          stub.newMutateRowsBatcher("table1", clientCtx)) {
        batcher.add(RowMutationEntry.create("key").deleteRow()).get();
      }

      // Ensure that the server got the overriden deadline
      Context serverCtx = contextInterceptor.contexts.poll();
      assertThat(serverCtx).isNotNull();
      assertThat(serverCtx.getDeadline()).isAtLeast(Deadline.after(8, TimeUnit.MINUTES));
    }
  }

  @Test
  public void testCallContextPropagatedInReadBatcher()
      throws IOException, InterruptedException, ExecutionException {
    EnhancedBigtableStubSettings settings =
        defaultSettings
            .toBuilder()
            .setRefreshingChannel(true)
            .setPrimedTableIds("table1", "table2")
            .build();

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings)) {
      // clear the previous contexts
      contextInterceptor.contexts.clear();

      // Override the timeout
      GrpcCallContext clientCtx =
          GrpcCallContext.createDefault().withTimeout(Duration.ofMinutes(10));

      // Send a batch
      try (Batcher<ByteString, Row> batcher =
          stub.newBulkReadRowsBatcher(Query.create("table1"), clientCtx)) {
        batcher.add(ByteString.copyFromUtf8("key")).get();
      }

      // Ensure that the server got the overriden deadline
      Context serverCtx = contextInterceptor.contexts.poll();
      assertThat(serverCtx).isNotNull();
      assertThat(serverCtx.getDeadline()).isAtLeast(Deadline.after(8, TimeUnit.MINUTES));
    }
  }

  private static class MetadataInterceptor implements ServerInterceptor {
    final BlockingQueue<Metadata> headers = Queues.newLinkedBlockingDeque();

    @Override
    public <ReqT, RespT> Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      headers.add(metadata);
      return serverCallHandler.startCall(serverCall, metadata);
    }
  }

  private static class ContextInterceptor implements ServerInterceptor {
    final BlockingQueue<Context> contexts = Queues.newLinkedBlockingDeque();

    @Override
    public <ReqT, RespT> Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      contexts.add(Context.current());
      return serverCallHandler.startCall(serverCall, metadata);
    }
  }

  private static class FakeDataService extends BigtableGrpc.BigtableImplBase {
    final BlockingQueue<ReadRowsRequest> requests = Queues.newLinkedBlockingDeque();

    @SuppressWarnings("unchecked")
    ReadRowsRequest popLastRequest() throws InterruptedException {
      return requests.poll(1, TimeUnit.SECONDS);
    }

    @Override
    public void mutateRows(
        MutateRowsRequest request, StreamObserver<MutateRowsResponse> responseObserver) {
      MutateRowsResponse.Builder builder = MutateRowsResponse.newBuilder();
      for (int i = 0; i < request.getEntriesCount(); i++) {
        builder.addEntries(MutateRowsResponse.Entry.newBuilder().setIndex(i).build());
      }
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      requests.add(request);
      // Dummy row for stream
      responseObserver.onNext(
          ReadRowsResponse.newBuilder()
              .addChunks(
                  ReadRowsResponse.CellChunk.newBuilder()
                      .setCommitRow(true)
                      .setRowKey(ByteString.copyFromUtf8("a"))
                      .setFamilyName(StringValue.getDefaultInstance())
                      .setQualifier(BytesValue.getDefaultInstance())
                      .setValueSize(0))
              .build());
      responseObserver.onCompleted();
    }
  }
}
