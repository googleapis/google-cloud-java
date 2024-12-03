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

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatcherImpl;
import com.google.api.gax.batching.BatchingException;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.InstantiatingWatchdogProvider;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.Filters;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.Statement;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import com.google.cloud.bigtable.data.v2.stub.sql.ExecuteQueryCallable;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlServerStream;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import com.google.rpc.Code;
import com.google.rpc.Status;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.Server;
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
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class EnhancedBigtableStubTest {

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String TABLE_NAME =
      NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID);
  private static final String APP_PROFILE_ID = "app-profile-id";
  private static final String WAIT_TIME_TABLE_ID = "test-wait-timeout";
  private static final String WAIT_TIME_QUERY = "test-wait-timeout";
  private static final Duration WATCHDOG_CHECK_DURATION = Duration.ofMillis(100);

  private Server server;
  private MetadataInterceptor metadataInterceptor;
  private ContextInterceptor contextInterceptor;
  private FakeDataService fakeDataService;
  private EnhancedBigtableStubSettings defaultSettings;
  private EnhancedBigtableStub enhancedBigtableStub;

  @Before
  public void setUp() throws IOException, IllegalAccessException, InstantiationException {
    metadataInterceptor = new MetadataInterceptor();
    contextInterceptor = new ContextInterceptor();
    fakeDataService = Mockito.spy(new FakeDataService());

    server =
        FakeServiceBuilder.create(fakeDataService)
            .intercept(contextInterceptor)
            .intercept(metadataInterceptor)
            .start();

    defaultSettings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setAppProfileId(APP_PROFILE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setMetricsProvider(NoopMetricsProvider.INSTANCE)
            .build()
            .getStubSettings();

    enhancedBigtableStub = EnhancedBigtableStub.create(defaultSettings);
  }

  @After
  public void tearDown() {
    enhancedBigtableStub.close();
    server.shutdown();
  }

  @Test
  public void testJwtAudience()
      throws InterruptedException, IOException, NoSuchAlgorithmException, ExecutionException {
    // Create fake jwt creds
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    KeyPair keyPair = keyGen.genKeyPair();

    ServiceAccountJwtAccessCredentials jwtCreds =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId("fake-id")
            .setClientEmail("fake@example.com")
            .setPrivateKey(keyPair.getPrivate())
            .setPrivateKeyId("fake-private-key")
            .build();

    // Create a stub with overridden audience
    String expectedAudience = "http://localaudience";
    EnhancedBigtableStubSettings settings =
        defaultSettings
            .toBuilder()
            .setJwtAudienceMapping(ImmutableMap.of("localhost", expectedAudience))
            .setCredentialsProvider(FixedCredentialsProvider.create(jwtCreds))
            .build();
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings)) {
      stub.readRowCallable().futureCall(Query.create("fake-table")).get();
    }
    // Send rpc and grab the credentials sent
    Metadata metadata = metadataInterceptor.headers.take();

    String authValue = metadata.get(Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER));
    String expectedPrefix = "Bearer ";
    assertThat(authValue).startsWith(expectedPrefix);
    String jwtStr = authValue.substring(expectedPrefix.length());
    JsonWebSignature parsed = JsonWebSignature.parse(GsonFactory.getDefaultInstance(), jwtStr);
    assertThat(parsed.getPayload().getAudience()).isEqualTo(expectedAudience);
  }

  @Test
  public void testBatchJwtAudience()
      throws InterruptedException, IOException, NoSuchAlgorithmException, ExecutionException {
    // Create fake jwt creds
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    KeyPair keyPair = keyGen.genKeyPair();

    ServiceAccountJwtAccessCredentials jwtCreds =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId("fake-id")
            .setClientEmail("fake@example.com")
            .setPrivateKey(keyPair.getPrivate())
            .setPrivateKeyId("fake-private-key")
            .build();

    EnhancedBigtableStubSettings settings =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .setEndpoint("batch-bigtable.googleapis.com:443")
            .setCredentialsProvider(FixedCredentialsProvider.create(jwtCreds))
            .setMetricsProvider(NoopMetricsProvider.INSTANCE)
            // Use a fixed channel that will ignore the default endpoint and connect to the emulator
            .setTransportChannelProvider(
                FixedTransportChannelProvider.create(
                    GrpcTransportChannel.create(
                        ManagedChannelBuilder.forAddress("localhost", server.getPort())
                            .usePlaintext()
                            .build())))
            // Channel refreshing doesn't work with FixedTransportChannelProvider. Disable it for
            // the test
            .setRefreshingChannel(false)
            .build();

    Metadata metadata;
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings)) {
      // Send rpc and grab the credentials sent
      stub.readRowCallable().futureCall(Query.create("fake-table")).get();
      metadata = metadataInterceptor.headers.take();
    }

    String authValue = metadata.get(Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER));
    String expectedPrefix = "Bearer ";
    assertThat(authValue).startsWith(expectedPrefix);
    String jwtStr = authValue.substring(expectedPrefix.length());
    JsonWebSignature parsed = JsonWebSignature.parse(GsonFactory.getDefaultInstance(), jwtStr);
    assertThat(parsed.getPayload().getAudience()).isEqualTo("https://bigtable.googleapis.com/");
  }

  @Test
  public void testFeatureFlags() throws InterruptedException, IOException, ExecutionException {
    enhancedBigtableStub.readRowCallable().futureCall(Query.create("fake-table")).get();
    Metadata metadata = metadataInterceptor.headers.take();

    String encodedFeatureFlags =
        metadata.get(Key.of("bigtable-features", Metadata.ASCII_STRING_MARSHALLER));
    FeatureFlags featureFlags =
        FeatureFlags.parseFrom(BaseEncoding.base64Url().decode(encodedFeatureFlags));

    assertThat(featureFlags.getReverseScans()).isTrue();
    assertThat(featureFlags.getLastScannedRowResponses()).isTrue();
  }

  @Test
  public void testPingAndWarmFeatureFlags()
      throws InterruptedException, IOException, ExecutionException {
    EnhancedBigtableStubSettings settings =
        defaultSettings.toBuilder().setRefreshingChannel(true).build();
    try (EnhancedBigtableStub ignored = EnhancedBigtableStub.create(settings)) {
      Preconditions.checkState(
          !fakeDataService.pingRequests.isEmpty(), "Ping request was not sent during setup");
      Metadata metadata = metadataInterceptor.headers.take();

      String encodedFeatureFlags =
          metadata.get(Key.of("bigtable-features", Metadata.ASCII_STRING_MARSHALLER));
      FeatureFlags featureFlags =
          FeatureFlags.parseFrom(BaseEncoding.base64Url().decode(encodedFeatureFlags));

      assertThat(featureFlags.getReverseScans()).isTrue();
      assertThat(featureFlags.getLastScannedRowResponses()).isTrue();
      assertThat(featureFlags.getRoutingCookie()).isTrue();
      assertThat(featureFlags.getRetryInfo()).isTrue();
    }
  }

  @Test
  public void testCheckAndMutateRequestResponseConversion()
      throws ExecutionException, InterruptedException {
    ConditionalRowMutation req =
        ConditionalRowMutation.create(TableId.of("my-table"), "my-key")
            .condition(Filters.FILTERS.pass())
            .then(Mutation.create().deleteRow());

    ApiFuture<Boolean> f = enhancedBigtableStub.checkAndMutateRowCallable().futureCall(req, null);
    f.get();

    CheckAndMutateRowRequest protoReq =
        fakeDataService.checkAndMutateRowRequests.poll(1, TimeUnit.SECONDS);
    assertThat(protoReq)
        .isEqualTo(req.toProto(RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID)));
    assertThat(f.get()).isEqualTo(true);
  }

  @Test
  public void testRMWRequestResponseConversion() throws ExecutionException, InterruptedException {
    ReadModifyWriteRow req =
        ReadModifyWriteRow.create(TableId.of("my-table"), "my-key").append("f", "q", "v");

    ApiFuture<Row> f = enhancedBigtableStub.readModifyWriteRowCallable().futureCall(req, null);
    f.get();

    ReadModifyWriteRowRequest protoReq = fakeDataService.rmwRequests.poll(1, TimeUnit.SECONDS);
    assertThat(protoReq)
        .isEqualTo(req.toProto(RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID)));
    assertThat(f.get().getKey()).isEqualTo(ByteString.copyFromUtf8("my-key"));
  }

  @Test
  public void testMutateRowRequestResponseConversion()
      throws ExecutionException, InterruptedException {
    RowMutation req = RowMutation.create(TableId.of("my-table"), "my-key").deleteRow();
    CallOptions.Key<String> testKey = CallOptions.Key.create("test-key");

    GrpcCallContext ctx =
        GrpcCallContext.createDefault()
            .withCallOptions(CallOptions.DEFAULT.withOption(testKey, "callopt-value"));
    ApiFuture<Void> f = enhancedBigtableStub.mutateRowCallable().futureCall(req, ctx);
    f.get();

    MutateRowRequest protoReq = fakeDataService.mutateRowRequests.poll(1, TimeUnit.SECONDS);
    assertThat(protoReq)
        .isEqualTo(req.toProto(RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID)));
    assertThat(f.get()).isEqualTo(null);
  }

  @Test
  public void testMutateRowRequestParams() throws ExecutionException, InterruptedException {
    RowMutation req = RowMutation.create(TableId.of(TABLE_ID), "my-key").deleteRow();

    ApiFuture<Void> f = enhancedBigtableStub.mutateRowCallable().futureCall(req, null);
    f.get();

    Metadata reqMetadata = metadataInterceptor.headers.poll(1, TimeUnit.SECONDS);

    // RequestParamsExtractor
    String reqParams =
        reqMetadata.get(Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER));
    assertThat(reqParams).contains("table_name=" + TABLE_NAME.replace("/", "%2F"));
    assertThat(reqParams).contains(String.format("app_profile_id=%s", APP_PROFILE_ID));

    // StatsHeadersUnaryCallable
    assertThat(reqMetadata.keys()).contains("bigtable-client-attempt-epoch-usec");

    assertThat(f.get()).isEqualTo(null);
  }

  @Test
  public void testMutateRowErrorPropagation() {
    AtomicInteger invocationCount = new AtomicInteger();
    Mockito.doAnswer(
            invocationOnMock -> {
              StreamObserver<MutateRowResponse> observer = invocationOnMock.getArgument(1);
              if (invocationCount.getAndIncrement() == 0) {
                observer.onError(io.grpc.Status.UNAVAILABLE.asRuntimeException());
              } else {
                observer.onError(io.grpc.Status.FAILED_PRECONDITION.asRuntimeException());
              }
              return null;
            })
        .when(fakeDataService)
        .mutateRow(Mockito.any(), Mockito.any(StreamObserver.class));

    RowMutation req = RowMutation.create(TableId.of(TABLE_ID), "my-key").deleteRow();
    ApiFuture<Void> f = enhancedBigtableStub.mutateRowCallable().futureCall(req, null);

    ExecutionException e = assertThrows(ExecutionException.class, f::get);
    assertThat(e.getCause()).isInstanceOf(FailedPreconditionException.class);
    assertThat(invocationCount.get()).isEqualTo(2);
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
        defaultSettings.toBuilder().setRefreshingChannel(true).build();

    try (EnhancedBigtableStub ignored = EnhancedBigtableStub.create(settings)) {
      assertThat(fakeDataService.pingRequests).hasSize(1);
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
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
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

  @Test
  public void testBulkMutationFlowControlFeatureFlagIsSet() throws Exception {
    BulkMutation bulkMutation =
        BulkMutation.create("my-table")
            .add(RowMutationEntry.create("row-key").setCell("cf", "q", "value"));

    // Test the header is set when the feature is enabled
    EnhancedBigtableStubSettings.Builder settings = defaultSettings.toBuilder();
    settings.bulkMutateRowsSettings().setServerInitiatedFlowControl(true);
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.build())) {
      stub.bulkMutateRowsCallable().call(bulkMutation);
    }
    assertThat(metadataInterceptor.headers).hasSize(1);
    Metadata metadata = metadataInterceptor.headers.take();
    String encodedFlags =
        metadata.get(Metadata.Key.of("bigtable-features", Metadata.ASCII_STRING_MARSHALLER));
    byte[] decodedFlags = Base64.getDecoder().decode(encodedFlags);
    FeatureFlags featureFlags = FeatureFlags.parseFrom(decodedFlags);
    assertThat(featureFlags.getMutateRowsRateLimit()).isTrue();
    assertThat(featureFlags.getMutateRowsRateLimit2()).isTrue();
  }

  @Test
  public void testBulkMutationFlowControlFeatureFlagIsNotSet() throws Exception {
    BulkMutation bulkMutation =
        BulkMutation.create("my-table")
            .add(RowMutationEntry.create("row-key").setCell("cf", "q", "value"));

    EnhancedBigtableStubSettings.Builder settings = defaultSettings.toBuilder();
    settings.bulkMutateRowsSettings().setServerInitiatedFlowControl(false);
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.build())) {
      stub.bulkMutateRowsCallable().call(bulkMutation);
    }
    assertThat(metadataInterceptor.headers).hasSize(1);
    Metadata metadata = metadataInterceptor.headers.take();
    String encodedFlags =
        metadata.get(Metadata.Key.of("bigtable-features", Metadata.ASCII_STRING_MARSHALLER));
    byte[] decodedFlags = Base64.getDecoder().decode(encodedFlags);
    FeatureFlags featureFlags = FeatureFlags.parseFrom(decodedFlags);
    assertThat(featureFlags.getMutateRowsRateLimit()).isFalse();
    assertThat(featureFlags.getMutateRowsRateLimit2()).isFalse();
  }

  @Test
  public void testWaitTimeoutIsSet() throws Exception {
    EnhancedBigtableStubSettings.Builder settings = defaultSettings.toBuilder();
    // Set a shorter wait timeout and make watchdog checks more frequently
    settings.readRowsSettings().setWaitTimeout(WATCHDOG_CHECK_DURATION.dividedBy(2));
    settings.setStreamWatchdogProvider(
        InstantiatingWatchdogProvider.create().withCheckInterval(WATCHDOG_CHECK_DURATION));

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.build())) {
      ServerStream<Row> results = stub.readRowsCallable().call(Query.create(WAIT_TIME_TABLE_ID));
      WatchdogTimeoutException ex =
          assertThrows(WatchdogTimeoutException.class, () -> results.iterator().next());

      assertThat(ex).hasMessageThat().contains("Canceled due to timeout waiting for next response");
    }
  }

  @Test
  public void testReadChangeStreamWaitTimeoutIsSet() throws Exception {
    EnhancedBigtableStubSettings.Builder settings = defaultSettings.toBuilder();
    // Set a shorter wait timeout and make watchdog checks more frequently
    settings.readChangeStreamSettings().setWaitTimeout(WATCHDOG_CHECK_DURATION.dividedBy(2));
    settings.setStreamWatchdogProvider(
        InstantiatingWatchdogProvider.create().withCheckInterval(WATCHDOG_CHECK_DURATION));

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.build())) {
      ServerStream<ChangeStreamRecord> results =
          stub.readChangeStreamCallable().call(ReadChangeStreamQuery.create(WAIT_TIME_TABLE_ID));
      WatchdogTimeoutException ex =
          assertThrows(WatchdogTimeoutException.class, () -> results.iterator().next());
      assertThat(ex).hasMessageThat().contains("Canceled due to timeout waiting for next response");
    }
  }

  @Test
  public void testBatchMutationsPartialFailure() {
    Batcher<RowMutationEntry, Void> batcher =
        enhancedBigtableStub.newMutateRowsBatcher("table1", GrpcCallContext.createDefault());

    batcher.add(RowMutationEntry.create("key0").deleteRow());
    batcher.add(RowMutationEntry.create("key1").deleteRow());

    Mockito.doAnswer(
            invocationOnMock -> {
              StreamObserver<MutateRowsResponse> observer = invocationOnMock.getArgument(1);
              observer.onNext(
                  MutateRowsResponse.newBuilder()
                      .addEntries(
                          MutateRowsResponse.Entry.newBuilder()
                              .setIndex(0)
                              .setStatus(Status.newBuilder().setCode(Code.OK_VALUE))
                              .build())
                      .addEntries(
                          MutateRowsResponse.Entry.newBuilder()
                              .setIndex(1)
                              .setStatus(
                                  Status.newBuilder()
                                      .setCode(Code.PERMISSION_DENIED_VALUE)
                                      .setMessage("fake partial error"))
                              .build())
                      .build());
              observer.onCompleted();
              return null;
            })
        .when(fakeDataService)
        .mutateRows(Mockito.any(MutateRowsRequest.class), Mockito.any(StreamObserver.class));
    BatchingException batchingException =
        assertThrows(BatchingException.class, () -> batcher.close());
    assertThat(batchingException.getMessage())
        .contains(
            "Batching finished with 1 partial failures. The 1 partial failures contained 1 entries that failed with: 1 ApiException(1 PERMISSION_DENIED).");
    assertThat(batchingException.getMessage()).contains("fake partial error");
    assertThat(batchingException.getMessage()).doesNotContain("INTERNAL");
  }

  @Test
  public void testBatchMutationRPCErrorCode() {
    Batcher<RowMutationEntry, Void> batcher =
        enhancedBigtableStub.newMutateRowsBatcher("table1", GrpcCallContext.createDefault());

    Mockito.doAnswer(
            invocationOnMock -> {
              StreamObserver<MutateRowsResponse> observer = invocationOnMock.getArgument(1);
              observer.onError(io.grpc.Status.PERMISSION_DENIED.asException());
              return null;
            })
        .when(fakeDataService)
        .mutateRows(Mockito.any(MutateRowsRequest.class), Mockito.any(StreamObserver.class));

    batcher.add(RowMutationEntry.create("key0").deleteRow());
    BatchingException batchingException =
        assertThrows(BatchingException.class, () -> batcher.close());
    assertThat(batchingException.getMessage())
        .contains(
            "Batching finished with 1 batches failed to apply due to: 1 ApiException(1 PERMISSION_DENIED) and 0 partial failures");
  }

  @Test
  public void testCreateExecuteQueryCallable() throws InterruptedException {
    ExecuteQueryCallable streamingCallable = enhancedBigtableStub.createExecuteQueryCallable();

    SqlServerStream sqlServerStream = streamingCallable.call(Statement.of("SELECT * FROM table"));
    ExecuteQueryRequest expectedRequest =
        ExecuteQueryRequest.newBuilder()
            .setInstanceName(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setAppProfileId(APP_PROFILE_ID)
            .setQuery("SELECT * FROM table")
            .build();
    assertThat(sqlServerStream.rows().iterator().next()).isNotNull();
    assertThat(sqlServerStream.metadataFuture().isDone()).isTrue();
    assertThat(fakeDataService.popLastExecuteQueryRequest()).isEqualTo(expectedRequest);
  }

  @Test
  public void testExecuteQueryWaitTimeoutIsSet() throws IOException {
    EnhancedBigtableStubSettings.Builder settings = defaultSettings.toBuilder();
    // Set a shorter wait timeout and make watchdog checks more frequently
    settings.executeQuerySettings().setWaitTimeout(WATCHDOG_CHECK_DURATION.dividedBy(2));
    settings.setStreamWatchdogProvider(
        InstantiatingWatchdogProvider.create().withCheckInterval(WATCHDOG_CHECK_DURATION));

    EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.build());
    Iterator<SqlRow> iterator =
        stub.executeQueryCallable().call(Statement.of(WAIT_TIME_QUERY)).rows().iterator();
    WatchdogTimeoutException e = assertThrows(WatchdogTimeoutException.class, iterator::next);
    assertThat(e).hasMessageThat().contains("Canceled due to timeout waiting for next response");
  }

  @Test
  public void testExecuteQueryWaitTimeoutWorksWithMetadataFuture()
      throws IOException, InterruptedException {
    EnhancedBigtableStubSettings.Builder settings = defaultSettings.toBuilder();
    // Set a shorter wait timeout and make watchdog checks more frequently
    settings.executeQuerySettings().setWaitTimeout(WATCHDOG_CHECK_DURATION.dividedBy(2));
    settings.setStreamWatchdogProvider(
        InstantiatingWatchdogProvider.create().withCheckInterval(WATCHDOG_CHECK_DURATION));

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.build())) {
      ApiFuture<ResultSetMetadata> future =
          stub.executeQueryCallable().call(Statement.of(WAIT_TIME_QUERY)).metadataFuture();

      ExecutionException e = assertThrows(ExecutionException.class, future::get);
      assertThat(e.getCause()).isInstanceOf(WatchdogTimeoutException.class);
      assertThat(e.getCause().getMessage())
          .contains("Canceled due to timeout waiting for next response");
      assertThat(e).hasMessageThat().contains("Canceled due to timeout waiting for next response");
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
    final BlockingQueue<ReadChangeStreamRequest> readChangeReadStreamRequests =
        Queues.newLinkedBlockingDeque();
    final BlockingQueue<PingAndWarmRequest> pingRequests = Queues.newLinkedBlockingDeque();
    final BlockingQueue<ExecuteQueryRequest> executeQueryRequests = Queues.newLinkedBlockingDeque();
    final BlockingQueue<MutateRowRequest> mutateRowRequests = Queues.newLinkedBlockingDeque();
    final BlockingQueue<CheckAndMutateRowRequest> checkAndMutateRowRequests =
        Queues.newLinkedBlockingDeque();
    final BlockingQueue<ReadModifyWriteRowRequest> rmwRequests = Queues.newLinkedBlockingDeque();

    @SuppressWarnings("unchecked")
    ReadRowsRequest popLastRequest() throws InterruptedException {
      return requests.poll(1, TimeUnit.SECONDS);
    }

    ExecuteQueryRequest popLastExecuteQueryRequest() throws InterruptedException {
      return executeQueryRequests.poll(1, TimeUnit.SECONDS);
    }

    @Override
    public void mutateRow(
        MutateRowRequest request, StreamObserver<MutateRowResponse> responseObserver) {
      mutateRowRequests.add(request);

      responseObserver.onNext(MutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void checkAndMutateRow(
        CheckAndMutateRowRequest request,
        StreamObserver<CheckAndMutateRowResponse> responseObserver) {
      checkAndMutateRowRequests.add(request);
      responseObserver.onNext(
          CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build());
      responseObserver.onCompleted();
    }

    @Override
    public void readModifyWriteRow(
        ReadModifyWriteRowRequest request,
        StreamObserver<ReadModifyWriteRowResponse> responseObserver) {
      rmwRequests.add(request);
      responseObserver.onNext(
          ReadModifyWriteRowResponse.newBuilder()
              .setRow(com.google.bigtable.v2.Row.newBuilder().setKey(request.getRowKey()))
              .build());
      responseObserver.onCompleted();
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
      if (request.getTableName().contains(WAIT_TIME_TABLE_ID)) {
        try {
          Thread.sleep(WATCHDOG_CHECK_DURATION.toMillis() * 2);
        } catch (Exception e) {

        }
      }
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

    @Override
    public void readChangeStream(
        ReadChangeStreamRequest request,
        StreamObserver<ReadChangeStreamResponse> responseObserver) {
      if (request.getTableName().contains(WAIT_TIME_TABLE_ID)) {
        try {
          Thread.sleep(WATCHDOG_CHECK_DURATION.toMillis() * 2);
        } catch (Exception e) {

        }
      }
      readChangeReadStreamRequests.add(request);
      // Dummy row for stream
      responseObserver.onNext(ReadChangeStreamResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void pingAndWarm(
        PingAndWarmRequest request, StreamObserver<PingAndWarmResponse> responseObserver) {
      pingRequests.add(request);
      responseObserver.onNext(PingAndWarmResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void executeQuery(
        ExecuteQueryRequest request, StreamObserver<ExecuteQueryResponse> responseObserver) {
      if (request.getQuery().contains(WAIT_TIME_QUERY)) {
        try {
          Thread.sleep(WATCHDOG_CHECK_DURATION.toMillis() * 2);
        } catch (Exception e) {

        }
      }
      executeQueryRequests.add(request);
      responseObserver.onNext(metadata(columnMetadata("foo", stringType())));
      responseObserver.onNext(partialResultSetWithToken(stringValue("test")));
    }
  }
}
