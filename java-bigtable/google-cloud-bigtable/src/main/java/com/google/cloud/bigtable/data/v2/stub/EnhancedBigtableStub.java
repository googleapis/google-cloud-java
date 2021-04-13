/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatcherImpl;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcRawCallableFactory;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetryingExecutorWithContext;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.OpencensusTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedServerStreamingCallable;
import com.google.api.gax.tracing.TracedUnaryCallable;
import com.google.auth.Credentials;
import com.google.bigtable.v2.BigtableGrpc;
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
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.DefaultRowAdapter;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.stub.metrics.CompositeTracerFactory;
import com.google.cloud.bigtable.data.v2.stub.metrics.HeaderTracerStreamingCallable;
import com.google.cloud.bigtable.data.v2.stub.metrics.HeaderTracerUnaryCallable;
import com.google.cloud.bigtable.data.v2.stub.metrics.MetricsTracerFactory;
import com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.BulkMutateRowsUserFacingCallable;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsRetryingCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.FilterMarkerRowsCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsBatchingDescriptor;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsConvertExceptionCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsResumptionStrategy;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsRetryCompletedCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsUserCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.RowMergingCallable;
import com.google.cloud.bigtable.gaxx.retrying.ApiResultRetryAlgorithm;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

/**
 * The core client that converts method calls to RPCs.
 *
 * <p>This class consists of a set of Callable chains that represent RPC methods. There is a chain
 * for each RPC method. Each chain starts with a transformation that takes a protobuf wrapper and
 * terminates in a Callable that a gax gRPC callable. This class is meant to be a semantically
 * complete facade for the Bigtable data API. However it is not meant to be consumed directly,
 * please use {@link com.google.cloud.bigtable.data.v2.BigtableDataClient}.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class EnhancedBigtableStub implements AutoCloseable {
  private static final String CLIENT_NAME = "Bigtable";
  private static final long FLOW_CONTROL_ADJUSTING_INTERVAL_MS = TimeUnit.SECONDS.toMillis(20);

  private final EnhancedBigtableStubSettings settings;
  private final ClientContext clientContext;
  private final RequestContext requestContext;
  private final FlowController bulkMutationFlowController;
  private final DynamicFlowControlStats bulkMutationDynamicFlowControlStats;

  private final ServerStreamingCallable<Query, Row> readRowsCallable;
  private final UnaryCallable<Query, Row> readRowCallable;
  private final UnaryCallable<String, List<KeyOffset>> sampleRowKeysCallable;
  private final UnaryCallable<RowMutation, Void> mutateRowCallable;
  private final UnaryCallable<BulkMutation, Void> bulkMutateRowsCallable;
  private final UnaryCallable<ConditionalRowMutation, Boolean> checkAndMutateRowCallable;
  private final UnaryCallable<ReadModifyWriteRow, Row> readModifyWriteRowCallable;

  public static EnhancedBigtableStub create(EnhancedBigtableStubSettings settings)
      throws IOException {
    settings = finalizeSettings(settings, Tags.getTagger(), Stats.getStatsRecorder());

    return new EnhancedBigtableStub(settings, ClientContext.create(settings));
  }

  public static EnhancedBigtableStubSettings finalizeSettings(
      EnhancedBigtableStubSettings settings, Tagger tagger, StatsRecorder stats)
      throws IOException {
    EnhancedBigtableStubSettings.Builder builder = settings.toBuilder();

    // TODO: this implementation is on the cusp of unwieldy, if we end up adding more features
    // consider splitting it up by feature.

    // Inject channel priming
    if (settings.isRefreshingChannel()) {
      // Fix the credentials so that they can be shared
      Credentials credentials = null;
      if (settings.getCredentialsProvider() != null) {
        credentials = settings.getCredentialsProvider().getCredentials();
      }
      builder.setCredentialsProvider(FixedCredentialsProvider.create(credentials));

      // Inject the primer
      InstantiatingGrpcChannelProvider transportProvider =
          (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();

      builder.setTransportChannelProvider(
          transportProvider
              .toBuilder()
              .setChannelPrimer(
                  BigtableChannelPrimer.create(
                      credentials,
                      settings.getProjectId(),
                      settings.getInstanceId(),
                      settings.getAppProfileId(),
                      settings.getPrimedTableIds()))
              .build());
    }

    ImmutableMap<TagKey, TagValue> attributes =
        ImmutableMap.<TagKey, TagValue>builder()
            .put(RpcMeasureConstants.BIGTABLE_PROJECT_ID, TagValue.create(settings.getProjectId()))
            .put(
                RpcMeasureConstants.BIGTABLE_INSTANCE_ID, TagValue.create(settings.getInstanceId()))
            .put(
                RpcMeasureConstants.BIGTABLE_APP_PROFILE_ID,
                TagValue.create(settings.getAppProfileId()))
            .build();
    // Inject Opencensus instrumentation
    builder.setTracerFactory(
        new CompositeTracerFactory(
            ImmutableList.of(
                // Add OpenCensus Tracing
                new OpencensusTracerFactory(
                    ImmutableMap.<String, String>builder()
                        // Annotate traces with the same tags as metrics
                        .put(
                            RpcMeasureConstants.BIGTABLE_PROJECT_ID.getName(),
                            settings.getProjectId())
                        .put(
                            RpcMeasureConstants.BIGTABLE_INSTANCE_ID.getName(),
                            settings.getInstanceId())
                        .put(
                            RpcMeasureConstants.BIGTABLE_APP_PROFILE_ID.getName(),
                            settings.getAppProfileId())
                        // Also annotate traces with library versions
                        .put("gax", GaxGrpcProperties.getGaxGrpcVersion())
                        .put("grpc", GaxGrpcProperties.getGrpcVersion())
                        .put(
                            "gapic",
                            GaxProperties.getLibraryVersion(EnhancedBigtableStubSettings.class))
                        .build()),
                // Add OpenCensus Metrics
                MetricsTracerFactory.create(tagger, stats, attributes),
                // Add user configured tracer
                settings.getTracerFactory())));
    builder.setHeaderTracer(
        builder
            .getHeaderTracer()
            .toBuilder()
            .setStats(stats)
            .setTagger(tagger)
            .setStatsAttributes(attributes)
            .build());
    return builder.build();
  }

  public EnhancedBigtableStub(EnhancedBigtableStubSettings settings, ClientContext clientContext) {
    this.settings = settings;
    this.clientContext = clientContext;
    this.requestContext =
        RequestContext.create(
            settings.getProjectId(), settings.getInstanceId(), settings.getAppProfileId());
    this.bulkMutationFlowController =
        new FlowController(settings.bulkMutateRowsSettings().getDynamicFlowControlSettings());
    this.bulkMutationDynamicFlowControlStats = new DynamicFlowControlStats();

    readRowsCallable = createReadRowsCallable(new DefaultRowAdapter());
    readRowCallable = createReadRowCallable(new DefaultRowAdapter());
    sampleRowKeysCallable = createSampleRowKeysCallable();
    mutateRowCallable = createMutateRowCallable();
    bulkMutateRowsCallable = createBulkMutateRowsCallable();
    checkAndMutateRowCallable = createCheckAndMutateRowCallable();
    readModifyWriteRowCallable = createReadModifyWriteRowCallable();
  }

  // <editor-fold desc="Callable creators">

  /**
   * Creates a callable chain to handle ReadRows RPCs. The chain will:
   *
   * <ul>
   *   <li>Dispatch the RPC with {@link ReadRowsRequest}.
   *   <li>Upon receiving the response stream, it will merge the {@link
   *       com.google.bigtable.v2.ReadRowsResponse.CellChunk}s in logical rows. The actual row
   *       implementation can be configured by the {@code rowAdapter} parameter.
   *   <li>Retry/resume on failure.
   *   <li>Filter out marker rows.
   * </ul>
   *
   * <p>NOTE: the caller is responsible for adding tracing & metrics.
   */
  @BetaApi("This surface is stable yet it might be removed in the future.")
  public <RowT> ServerStreamingCallable<ReadRowsRequest, RowT> createReadRowsRawCallable(
      RowAdapter<RowT> rowAdapter) {
    return createReadRowsBaseCallable(settings.readRowsSettings(), rowAdapter)
        .withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Creates a callable chain to handle streaming ReadRows RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link Query} into a {@link com.google.bigtable.v2.ReadRowsRequest} and
   *       dispatch the RPC.
   *   <li>Upon receiving the response stream, it will merge the {@link
   *       com.google.bigtable.v2.ReadRowsResponse.CellChunk}s in logical rows. The actual row
   *       implementation can be configured in by the {@code rowAdapter} parameter.
   *   <li>Retry/resume on failure.
   *   <li>Filter out marker rows.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  public <RowT> ServerStreamingCallable<Query, RowT> createReadRowsCallable(
      RowAdapter<RowT> rowAdapter) {
    ServerStreamingCallable<ReadRowsRequest, RowT> readRowsCallable =
        createReadRowsBaseCallable(settings.readRowsSettings(), rowAdapter);

    ServerStreamingCallable<Query, RowT> readRowsUserCallable =
        new ReadRowsUserCallable<>(readRowsCallable, requestContext);

    SpanName span = getSpanName("ReadRows");
    ServerStreamingCallable<Query, RowT> traced =
        new TracedServerStreamingCallable<>(
            readRowsUserCallable, clientContext.getTracerFactory(), span);

    return traced.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Creates a callable chain to handle point ReadRows RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link Query} into a {@link com.google.bigtable.v2.ReadRowsRequest} and
   *       dispatch the RPC.
   *   <li>Upon receiving the response stream, it will merge the {@link
   *       com.google.bigtable.v2.ReadRowsResponse.CellChunk}s in logical rows. The actual row
   *       implementation can be configured in by the {@code rowAdapter} parameter.
   *   <li>Retry/resume on failure.
   *   <li>Filter out marker rows.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  public <RowT> UnaryCallable<Query, RowT> createReadRowCallable(RowAdapter<RowT> rowAdapter) {
    ServerStreamingCallable<ReadRowsRequest, RowT> readRowsCallable =
        createReadRowsBaseCallable(
            ServerStreamingCallSettings.<ReadRowsRequest, Row>newBuilder()
                .setRetryableCodes(settings.readRowSettings().getRetryableCodes())
                .setRetrySettings(settings.readRowSettings().getRetrySettings())
                .setIdleTimeout(settings.readRowSettings().getRetrySettings().getTotalTimeout())
                .build(),
            rowAdapter);

    UnaryCallable<Query, RowT> readRowCallable =
        new ReadRowsUserCallable<>(readRowsCallable, requestContext).first();

    return createUserFacingUnaryCallable("ReadRow", readRowCallable);
  }

  /**
   * Creates a callable chain to handle ReadRows RPCs. The chain will:
   *
   * <ul>
   *   <li>Dispatch the RPC with {@link ReadRowsRequest}.
   *   <li>Upon receiving the response stream, it will merge the {@link
   *       com.google.bigtable.v2.ReadRowsResponse.CellChunk}s in logical rows. The actual row
   *       implementation can be configured by the {@code rowAdapter} parameter.
   *   <li>Add header tracer for tracking GFE metrics.
   *   <li>Retry/resume on failure.
   *   <li>Filter out marker rows.
   * </ul>
   *
   * <p>NOTE: the caller is responsible for adding tracing & metrics.
   */
  private <ReqT, RowT> ServerStreamingCallable<ReadRowsRequest, RowT> createReadRowsBaseCallable(
      ServerStreamingCallSettings<ReqT, Row> readRowsSettings, RowAdapter<RowT> rowAdapter) {

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> base =
        GrpcRawCallableFactory.createServerStreamingCallable(
            GrpcCallSettings.<ReadRowsRequest, ReadRowsResponse>newBuilder()
                .setMethodDescriptor(BigtableGrpc.getReadRowsMethod())
                .setParamsExtractor(
                    new RequestParamsExtractor<ReadRowsRequest>() {
                      @Override
                      public Map<String, String> extract(ReadRowsRequest readRowsRequest) {
                        return ImmutableMap.of(
                            "table_name", readRowsRequest.getTableName(),
                            "app_profile_id", readRowsRequest.getAppProfileId());
                      }
                    })
                .build(),
            readRowsSettings.getRetryableCodes());

    // Sometimes ReadRows connections are disconnected via an RST frame. This error is transient and
    // should be treated similar to UNAVAILABLE. However, this exception has an INTERNAL error code
    // which by default is not retryable. Convert the exception so it can be retried in the client.
    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> convertException =
        new ReadRowsConvertExceptionCallable<>(base);

    ServerStreamingCallable<ReadRowsRequest, RowT> merging =
        new RowMergingCallable<>(convertException, rowAdapter);

    // Copy settings for the middle ReadRowsRequest -> RowT callable (as opposed to the inner
    // ReadRowsRequest -> ReadRowsResponse callable).
    ServerStreamingCallSettings<ReadRowsRequest, RowT> innerSettings =
        ServerStreamingCallSettings.<ReadRowsRequest, RowT>newBuilder()
            .setResumptionStrategy(new ReadRowsResumptionStrategy<>(rowAdapter))
            .setRetryableCodes(readRowsSettings.getRetryableCodes())
            .setRetrySettings(readRowsSettings.getRetrySettings())
            .setIdleTimeout(readRowsSettings.getIdleTimeout())
            .build();

    ServerStreamingCallable<ReadRowsRequest, RowT> watched =
        Callables.watched(merging, innerSettings, clientContext);

    ServerStreamingCallable<ReadRowsRequest, RowT> withHeaderTracer =
        new HeaderTracerStreamingCallable<>(
            watched, settings.getHeaderTracer(), getSpanName("ReadRows").toString());

    // Retry logic is split into 2 parts to workaround a rare edge case described in
    // ReadRowsRetryCompletedCallable
    ServerStreamingCallable<ReadRowsRequest, RowT> retrying1 =
        new ReadRowsRetryCompletedCallable<>(withHeaderTracer);

    ServerStreamingCallable<ReadRowsRequest, RowT> retrying2 =
        Callables.retrying(retrying1, innerSettings, clientContext);

    return new FilterMarkerRowsCallable<>(retrying2, rowAdapter);
  }

  /**
   * Creates a callable chain to handle SampleRowKeys RPcs. The chain will:
   *
   * <ul>
   *   <li>Convert a table id to a {@link com.google.bigtable.v2.SampleRowKeysRequest}.
   *   <li>Dispatch the request to the GAPIC's {@link BigtableStub#sampleRowKeysCallable()}.
   *   <li>Spool responses into a list.
   *   <li>Retry on failure.
   *   <li>Convert the responses into {@link KeyOffset}s.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  private UnaryCallable<String, List<KeyOffset>> createSampleRowKeysCallable() {
    String methodName = "SampleRowKeys";

    ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse> base =
        GrpcRawCallableFactory.createServerStreamingCallable(
            GrpcCallSettings.<SampleRowKeysRequest, SampleRowKeysResponse>newBuilder()
                .setMethodDescriptor(BigtableGrpc.getSampleRowKeysMethod())
                .setParamsExtractor(
                    new RequestParamsExtractor<SampleRowKeysRequest>() {
                      @Override
                      public Map<String, String> extract(
                          SampleRowKeysRequest sampleRowKeysRequest) {
                        return ImmutableMap.of(
                            "table_name", sampleRowKeysRequest.getTableName(),
                            "app_profile_id", sampleRowKeysRequest.getAppProfileId());
                      }
                    })
                .build(),
            settings.sampleRowKeysSettings().getRetryableCodes());

    UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> spoolable = base.all();

    UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> withHeaderTracer =
        new HeaderTracerUnaryCallable<>(
            spoolable, settings.getHeaderTracer(), getSpanName(methodName).toString());

    UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> retryable =
        Callables.retrying(withHeaderTracer, settings.sampleRowKeysSettings(), clientContext);

    return createUserFacingUnaryCallable(
        methodName, new SampleRowKeysCallable(retryable, requestContext));
  }

  /**
   * Creates a callable chain to handle MutateRow RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link RowMutation} into a {@link com.google.bigtable.v2.MutateRowRequest}.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  private UnaryCallable<RowMutation, Void> createMutateRowCallable() {
    String methodName = "MutateRow";
    UnaryCallable<MutateRowRequest, MutateRowResponse> base =
        GrpcRawCallableFactory.createUnaryCallable(
            GrpcCallSettings.<MutateRowRequest, MutateRowResponse>newBuilder()
                .setMethodDescriptor(BigtableGrpc.getMutateRowMethod())
                .setParamsExtractor(
                    new RequestParamsExtractor<MutateRowRequest>() {
                      @Override
                      public Map<String, String> extract(MutateRowRequest mutateRowRequest) {
                        return ImmutableMap.of(
                            "table_name", mutateRowRequest.getTableName(),
                            "app_profile_id", mutateRowRequest.getAppProfileId());
                      }
                    })
                .build(),
            settings.mutateRowSettings().getRetryableCodes());

    UnaryCallable<MutateRowRequest, MutateRowResponse> withHeaderTracer =
        new HeaderTracerUnaryCallable<>(
            base, settings.getHeaderTracer(), getSpanName(methodName).toString());

    UnaryCallable<MutateRowRequest, MutateRowResponse> retrying =
        Callables.retrying(withHeaderTracer, settings.mutateRowSettings(), clientContext);

    return createUserFacingUnaryCallable(
        methodName, new MutateRowCallable(retrying, requestContext));
  }

  /**
   * Creates a callable chain to handle MutatesRows RPCs. This is meant to be used for manual
   * batching. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link BulkMutation} into a {@link MutateRowsRequest}.
   *   <li>Process the response and schedule retries. At the end of each attempt, entries that have
   *       been applied, are filtered from the next attempt. Also, any entries that failed with a
   *       nontransient error, are filtered from the next attempt. This will continue until there
   *       are no more entries or there are no more retry attempts left.
   *   <li>Wrap batch failures in a {@link
   *       com.google.cloud.bigtable.data.v2.models.MutateRowsException}.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  private UnaryCallable<BulkMutation, Void> createBulkMutateRowsCallable() {
    UnaryCallable<MutateRowsRequest, Void> baseCallable = createMutateRowsBaseCallable();

    UnaryCallable<MutateRowsRequest, Void> flowControlCallable = null;
    if (settings.bulkMutateRowsSettings().isLatencyBasedThrottlingEnabled()) {
      flowControlCallable =
          new DynamicFlowControlCallable(
              baseCallable,
              bulkMutationFlowController,
              bulkMutationDynamicFlowControlStats,
              settings.bulkMutateRowsSettings().getTargetRpcLatencyMs(),
              FLOW_CONTROL_ADJUSTING_INTERVAL_MS);
    }
    UnaryCallable<BulkMutation, Void> userFacing =
        new BulkMutateRowsUserFacingCallable(
            flowControlCallable != null ? flowControlCallable : baseCallable, requestContext);

    SpanName spanName = getSpanName("MutateRows");
    UnaryCallable<BulkMutation, Void> traced =
        new TracedUnaryCallable<>(userFacing, clientContext.getTracerFactory(), spanName);
    UnaryCallable<BulkMutation, Void> withHeaderTracer =
        new HeaderTracerUnaryCallable<>(traced, settings.getHeaderTracer(), spanName.toString());

    return withHeaderTracer.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Creates a {@link BatcherImpl} to handle {@link MutateRowsRequest.Entry} mutations. This is
   * meant to be used for automatic batching with flow control.
   *
   * <ul>
   *   <li>Uses {@link MutateRowsBatchingDescriptor} to spool the {@link RowMutationEntry} mutations
   *       and send them out as {@link BulkMutation}.
   *   <li>Uses {@link #bulkMutateRowsCallable()} to perform RPC.
   *   <li>Batching thresholds can be configured from {@link
   *       EnhancedBigtableStubSettings#bulkMutateRowsSettings()}.
   *   <li>Process the response and schedule retries. At the end of each attempt, entries that have
   *       been applied, are filtered from the next attempt. Also, any entries that failed with a
   *       nontransient error, are filtered from the next attempt. This will continue until there
   *       are no more entries or there are no more retry attempts left.
   *   <li>Wrap batch failures in a {@link
   *       com.google.cloud.bigtable.data.v2.models.MutateRowsException}.
   *   <li>Split the responses using {@link MutateRowsBatchingDescriptor}.
   * </ul>
   */
  public Batcher<RowMutationEntry, Void> newMutateRowsBatcher(@Nonnull String tableId) {
    return new BatcherImpl<>(
        settings.bulkMutateRowsSettings().getBatchingDescriptor(),
        bulkMutateRowsCallable,
        BulkMutation.create(tableId),
        settings.bulkMutateRowsSettings().getBatchingSettings(),
        clientContext.getExecutor(),
        bulkMutationFlowController);
  }

  /**
   * Creates a {@link BatcherImpl} to handle {@link Query#rowKey(String)}. This is meant for bulk
   * read with flow control.
   *
   * <ul>
   *   <li>Uses {@link ReadRowsBatchingDescriptor} to merge the row-keys and send them out as {@link
   *       Query}.
   *   <li>Uses {@link #readRowsCallable()} to perform RPC.
   *   <li>Batching thresholds can be configured from {@link
   *       EnhancedBigtableStubSettings#bulkReadRowsSettings()}.
   *   <li>Schedule retries for retryable exceptions until there are no more entries or there are no
   *       more retry attempts left.
   *   <li>Split the responses using {@link ReadRowsBatchingDescriptor}.
   * </ul>
   */
  public Batcher<ByteString, Row> newBulkReadRowsBatcher(@Nonnull Query query) {
    Preconditions.checkNotNull(query, "query cannot be null");
    return new BatcherImpl<>(
        settings.bulkReadRowsSettings().getBatchingDescriptor(),
        readRowsCallable().all(),
        query,
        settings.bulkReadRowsSettings().getBatchingSettings(),
        clientContext.getExecutor());
  }

  /**
   * Internal helper to create the base MutateRows callable chain. The chain is responsible for
   * retrying individual entry in case of error.
   *
   * <p>NOTE: the caller is responsible for adding tracing & metrics.
   *
   * @see MutateRowsRetryingCallable for more details
   */
  private UnaryCallable<MutateRowsRequest, Void> createMutateRowsBaseCallable() {
    ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> base =
        GrpcRawCallableFactory.createServerStreamingCallable(
            GrpcCallSettings.<MutateRowsRequest, MutateRowsResponse>newBuilder()
                .setMethodDescriptor(BigtableGrpc.getMutateRowsMethod())
                .setParamsExtractor(
                    new RequestParamsExtractor<MutateRowsRequest>() {
                      @Override
                      public Map<String, String> extract(MutateRowsRequest mutateRowsRequest) {
                        return ImmutableMap.of(
                            "table_name", mutateRowsRequest.getTableName(),
                            "app_profile_id", mutateRowsRequest.getAppProfileId());
                      }
                    })
                .build(),
            settings.bulkMutateRowsSettings().getRetryableCodes());

    RetryAlgorithm<Void> retryAlgorithm =
        new RetryAlgorithm<>(
            new ApiResultRetryAlgorithm<Void>(),
            new ExponentialRetryAlgorithm(
                settings.bulkMutateRowsSettings().getRetrySettings(), clientContext.getClock()));
    RetryingExecutorWithContext<Void> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());

    return new MutateRowsRetryingCallable(
        clientContext.getDefaultCallContext(),
        base,
        retryingExecutor,
        settings.bulkMutateRowsSettings().getRetryableCodes());
  }

  /**
   * Creates a callable chain to handle CheckAndMutateRow RPCs. THe chain will:
   *
   * <ul>
   *   <li>Convert {@link ConditionalRowMutation}s into {@link
   *       com.google.bigtable.v2.CheckAndMutateRowRequest}s.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  private UnaryCallable<ConditionalRowMutation, Boolean> createCheckAndMutateRowCallable() {
    String methodName = "CheckAndMutateRow";
    UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse> base =
        GrpcRawCallableFactory.createUnaryCallable(
            GrpcCallSettings.<CheckAndMutateRowRequest, CheckAndMutateRowResponse>newBuilder()
                .setMethodDescriptor(BigtableGrpc.getCheckAndMutateRowMethod())
                .setParamsExtractor(
                    new RequestParamsExtractor<CheckAndMutateRowRequest>() {
                      @Override
                      public Map<String, String> extract(
                          CheckAndMutateRowRequest checkAndMutateRowRequest) {
                        return ImmutableMap.of(
                            "table_name", checkAndMutateRowRequest.getTableName(),
                            "app_profile_id", checkAndMutateRowRequest.getAppProfileId());
                      }
                    })
                .build(),
            settings.checkAndMutateRowSettings().getRetryableCodes());

    UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse> withHeaderTracer =
        new HeaderTracerUnaryCallable<>(
            base, settings.getHeaderTracer(), getSpanName(methodName).toString());

    UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse> retrying =
        Callables.retrying(withHeaderTracer, settings.checkAndMutateRowSettings(), clientContext);

    return createUserFacingUnaryCallable(
        methodName, new CheckAndMutateRowCallable(retrying, requestContext));
  }

  /**
   * Creates a callable chain to handle ReadModifyWriteRow RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert {@link ReadModifyWriteRow}s into {@link
   *       com.google.bigtable.v2.ReadModifyWriteRowRequest}s.
   *   <li>Convert the responses into {@link Row}.
   *   <li>Add tracing & metrics.
   * </ul>
   */
  private UnaryCallable<ReadModifyWriteRow, Row> createReadModifyWriteRowCallable() {
    UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> base =
        GrpcRawCallableFactory.createUnaryCallable(
            GrpcCallSettings.<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>newBuilder()
                .setMethodDescriptor(BigtableGrpc.getReadModifyWriteRowMethod())
                .setParamsExtractor(
                    new RequestParamsExtractor<ReadModifyWriteRowRequest>() {
                      @Override
                      public Map<String, String> extract(ReadModifyWriteRowRequest request) {
                        return ImmutableMap.of(
                            "table_name", request.getTableName(),
                            "app_profile_id", request.getAppProfileId());
                      }
                    })
                .build(),
            settings.readModifyWriteRowSettings().getRetryableCodes());
    String methodName = "ReadModifyWriteRow";
    UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> withHeaderTracer =
        new HeaderTracerUnaryCallable<>(
            base, settings.getHeaderTracer(), getSpanName(methodName).toString());

    UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> retrying =
        Callables.retrying(withHeaderTracer, settings.readModifyWriteRowSettings(), clientContext);

    return createUserFacingUnaryCallable(
        methodName, new ReadModifyWriteRowCallable(retrying, requestContext));
  }

  /**
   * Wraps a callable chain in a user presentable callable that will inject the default call context
   * and trace the call.
   */
  private <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUserFacingUnaryCallable(
      String methodName, UnaryCallable<RequestT, ResponseT> inner) {

    UnaryCallable<RequestT, ResponseT> traced =
        new TracedUnaryCallable<>(inner, clientContext.getTracerFactory(), getSpanName(methodName));

    return traced.withDefaultCallContext(clientContext.getDefaultCallContext());
  }
  // </editor-fold>

  // <editor-fold desc="Callable accessors">
  /** Returns a streaming read rows callable */
  public ServerStreamingCallable<Query, Row> readRowsCallable() {
    return readRowsCallable;
  }

  /** Return a point read callable */
  public UnaryCallable<Query, Row> readRowCallable() {
    return readRowCallable;
  }

  public UnaryCallable<String, List<KeyOffset>> sampleRowKeysCallable() {
    return sampleRowKeysCallable;
  }

  public UnaryCallable<RowMutation, Void> mutateRowCallable() {
    return mutateRowCallable;
  }

  /**
   * Returns the callable chain created in {@link #createBulkMutateRowsCallable()} ()} during stub
   * construction.
   */
  public UnaryCallable<BulkMutation, Void> bulkMutateRowsCallable() {
    return bulkMutateRowsCallable;
  }

  /**
   * Returns the callable chain created in {@link #createCheckAndMutateRowCallable()} during stub
   * construction.
   */
  public UnaryCallable<ConditionalRowMutation, Boolean> checkAndMutateRowCallable() {
    return checkAndMutateRowCallable;
  }

  /**
   * Returns the callable chain created in {@link #createReadModifyWriteRowCallable()} ()} during
   * stub construction.
   */
  public UnaryCallable<ReadModifyWriteRow, Row> readModifyWriteRowCallable() {
    return readModifyWriteRowCallable;
  }
  // </editor-fold>

  private SpanName getSpanName(String methodName) {
    return SpanName.of(CLIENT_NAME, methodName);
  }

  @Override
  public void close() {
    for (BackgroundResource backgroundResource : clientContext.getBackgroundResources()) {
      backgroundResource.shutdown();
    }
  }
}
