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

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetryingExecutor;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.ReadRowsRequest;
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
import com.google.cloud.bigtable.data.v2.stub.mutaterows.BulkMutateRowsUserFacingCallable;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsRetryingCallable;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsUserFacingCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.FilterMarkerRowsCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsResumptionStrategy;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsRetryCompletedCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsUserCallable;
import com.google.cloud.bigtable.data.v2.stub.readrows.RowMergingCallable;
import com.google.cloud.bigtable.gaxx.retrying.ApiResultRetryAlgorithm;
import java.io.IOException;
import java.util.List;
import org.threeten.bp.Duration;

/**
 * The core client that converts method calls to RPCs.
 *
 * <p>This class consists of a set of Callable chains that represent RPC methods. There is a chain
 * for each RPC method. Each chain starts with a transformation that takes a protobuf wrapper and
 * terminates in a Callable from {@link GrpcBigtableStub}. This class is meant to be a semantically
 * complete facade for the Bigtable data API. However it is not meant to be consumed directly,
 * please use {@link com.google.cloud.bigtable.data.v2.BigtableDataClient}.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class EnhancedBigtableStub implements AutoCloseable {
  private final EnhancedBigtableStubSettings settings;
  private final GrpcBigtableStub stub;
  private final ClientContext clientContext;
  private final RequestContext requestContext;

  private final ServerStreamingCallable<Query, Row> readRowsCallable;
  private final UnaryCallable<Query, Row> readRowCallable;
  private final UnaryCallable<String, List<KeyOffset>> sampleRowKeysCallable;
  private final UnaryCallable<RowMutation, Void> mutateRowCallable;
  private final UnaryCallable<BulkMutation, Void> bulkMutateRowsCallable;
  private final UnaryCallable<RowMutation, Void> bulkMutateRowsBatchingCallable;
  private final UnaryCallable<ConditionalRowMutation, Boolean> checkAndMutateRowCallable;
  private final UnaryCallable<ReadModifyWriteRow, Row> readModifyWriteRowCallable;

  public static EnhancedBigtableStub create(EnhancedBigtableStubSettings settings)
      throws IOException {
    // Configure the base settings
    BigtableStubSettings.Builder baseSettingsBuilder =
        BigtableStubSettings.newBuilder()
            .setTransportChannelProvider(settings.getTransportChannelProvider())
            .setEndpoint(settings.getEndpoint())
            .setCredentialsProvider(settings.getCredentialsProvider())
            .setStreamWatchdogProvider(settings.getStreamWatchdogProvider())
            .setStreamWatchdogCheckInterval(settings.getStreamWatchdogCheckInterval());

    // ReadRow retries are handled in the overlay: disable retries in the base layer (but make
    // sure to preserve the exception callable settings).
    baseSettingsBuilder
        .readRowsSettings()
        .setSimpleTimeoutNoRetries(Duration.ofHours(2))
        .setRetryableCodes(settings.readRowsSettings().getRetryableCodes())
        .setIdleTimeout(Duration.ZERO);

    // SampleRowKeys retries are handled in the overlay: disable retries in the base layer (but make
    // sure to preserve the exception callable settings.
    baseSettingsBuilder
        .sampleRowKeysSettings()
        .setSimpleTimeoutNoRetries(
            settings.sampleRowKeysSettings().getRetrySettings().getTotalTimeout())
        .setRetryableCodes(settings.sampleRowKeysSettings().getRetryableCodes());

    // MutateRow: copy outer settings to the underlying GAPIC client
    baseSettingsBuilder
        .mutateRowSettings()
        .setRetryableCodes(settings.mutateRowSettings().getRetryableCodes())
        .setRetrySettings(settings.mutateRowSettings().getRetrySettings());

    // MutateRows(BulkMutateRows) retries are handled in the overlay: disable retries in the base
    // layer
    baseSettingsBuilder
        .mutateRowsSettings()
        .setSimpleTimeoutNoRetries(Duration.ofMinutes(10))
        .setRetryableCodes(settings.bulkMutateRowsSettings().getRetryableCodes())
        .setIdleTimeout(Duration.ZERO);

    // CheckAndMutateRow is a simple passthrough
    baseSettingsBuilder
        .checkAndMutateRowSettings()
        .setRetryableCodes(settings.checkAndMutateRowSettings().getRetryableCodes())
        .setRetrySettings(settings.checkAndMutateRowSettings().getRetrySettings());

    // ReadModifyWriteRow is a simple passthrough
    baseSettingsBuilder
        .readModifyWriteRowSettings()
        .setRetryableCodes(settings.readModifyWriteRowSettings().getRetryableCodes())
        .setRetrySettings(settings.readModifyWriteRowSettings().getRetrySettings());

    BigtableStubSettings baseSettings = baseSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(baseSettings);
    GrpcBigtableStub stub = new GrpcBigtableStub(baseSettings, clientContext);

    return new EnhancedBigtableStub(settings, clientContext, stub);
  }

  @InternalApi("Visible for testing")
  EnhancedBigtableStub(
      EnhancedBigtableStubSettings settings, ClientContext clientContext, GrpcBigtableStub stub) {
    this.settings = settings;
    this.clientContext = clientContext;
    this.stub = stub;
    this.requestContext =
        RequestContext.create(
            settings.getProjectId(), settings.getInstanceId(), settings.getAppProfileId());

    readRowsCallable = createReadRowsCallable(new DefaultRowAdapter());
    readRowCallable = createReadRowCallable(new DefaultRowAdapter());
    sampleRowKeysCallable = createSampleRowKeysCallable();
    mutateRowCallable = createMutateRowCallable();
    bulkMutateRowsCallable = createBulkMutateRowsCallable();
    bulkMutateRowsBatchingCallable = createBulkMutateRowsBatchingCallable();
    checkAndMutateRowCallable = createCheckAndMutateRowCallable();
    readModifyWriteRowCallable = createReadModifyWriteRowCallable();
  }

  // <editor-fold desc="Callable creators">

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
   * </ul>
   */
  public <RowT> ServerStreamingCallable<Query, RowT> createReadRowsCallable(
      RowAdapter<RowT> rowAdapter) {
    return createReadRowsCallable(settings.readRowsSettings(), rowAdapter);
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
   * </ul>
   */
  public <RowT> UnaryCallable<Query, RowT> createReadRowCallable(RowAdapter<RowT> rowAdapter) {
    return createReadRowsCallable(
            ServerStreamingCallSettings.<Query, Row>newBuilder()
                .setRetryableCodes(settings.readRowSettings().getRetryableCodes())
                .setRetrySettings(settings.readRowSettings().getRetrySettings())
                .setIdleTimeout(settings.readRowSettings().getRetrySettings().getTotalTimeout())
                .build(),
            rowAdapter)
        .first();
  }

  /**
   * Creates a callable chain to handle ReadRows RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link Query} into a {@link com.google.bigtable.v2.ReadRowsRequest} and
   *       dispatch the RPC.
   *   <li>Upon receiving the response stream, it will merge the {@link
   *       com.google.bigtable.v2.ReadRowsResponse.CellChunk}s in logical rows. The actual row
   *       implementation can be configured in by the {@code rowAdapter} parameter.
   *   <li>Retry/resume on failure.
   *   <li>Filter out marker rows.
   * </ul>
   */
  private <RowT> ServerStreamingCallable<Query, RowT> createReadRowsCallable(
      ServerStreamingCallSettings<Query, Row> readRowsSettings, RowAdapter<RowT> rowAdapter) {

    ServerStreamingCallable<ReadRowsRequest, RowT> merging =
        new RowMergingCallable<>(stub.readRowsCallable(), rowAdapter);

    // Copy settings for the middle ReadRowsRequest -> RowT callable (as opposed to the outer
    // Query -> RowT callable or the inner ReadRowsRequest -> ReadRowsResponse callable).
    ServerStreamingCallSettings<ReadRowsRequest, RowT> innerSettings =
        ServerStreamingCallSettings.<ReadRowsRequest, RowT>newBuilder()
            .setResumptionStrategy(new ReadRowsResumptionStrategy<>(rowAdapter))
            .setRetryableCodes(readRowsSettings.getRetryableCodes())
            .setRetrySettings(readRowsSettings.getRetrySettings())
            .setIdleTimeout(readRowsSettings.getIdleTimeout())
            .build();

    // Retry logic is split into 2 parts to workaround a rare edge case described in
    // ReadRowsRetryCompletedCallable
    ServerStreamingCallable<ReadRowsRequest, RowT> retrying1 =
        new ReadRowsRetryCompletedCallable<>(merging);

    ServerStreamingCallable<ReadRowsRequest, RowT> retrying2 =
        Callables.retrying(retrying1, innerSettings, clientContext);

    FilterMarkerRowsCallable<RowT> filtering =
        new FilterMarkerRowsCallable<>(retrying2, rowAdapter);

    ServerStreamingCallable<ReadRowsRequest, RowT> withContext =
        filtering.withDefaultCallContext(clientContext.getDefaultCallContext());

    // NOTE: Ideally `withDefaultCallContext` should be the outer-most callable, however the
    // ReadRowsUserCallable overrides the first() method. This override would be lost if
    // ReadRowsUserCallable is wrapped by another callable.  At some point in the future,
    // gax-java should allow preserving these kind of overrides through callable chains, at which
    // point this should be re-ordered.
    return new ReadRowsUserCallable<>(withContext, requestContext);
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
   * </ul>
   */
  private UnaryCallable<String, List<KeyOffset>> createSampleRowKeysCallable() {
    UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> spoolable =
        stub.sampleRowKeysCallable().all();

    UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> retryable =
        Callables.retrying(spoolable, settings.sampleRowKeysSettings(), clientContext);

    UnaryCallable<String, List<KeyOffset>> userFacing =
        new SampleRowKeysCallable(retryable, requestContext);

    return userFacing.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Creates a callable chain to handle MutateRow RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link RowMutation} into a {@link com.google.bigtable.v2.MutateRowRequest}.
   * </ul>
   */
  private UnaryCallable<RowMutation, Void> createMutateRowCallable() {
    MutateRowCallable userFacing = new MutateRowCallable(stub.mutateRowCallable(), requestContext);

    return userFacing.withDefaultCallContext(clientContext.getDefaultCallContext());
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
   * </ul>
   */
  private UnaryCallable<BulkMutation, Void> createBulkMutateRowsCallable() {
    UnaryCallable<MutateRowsRequest, Void> baseCallable = createMutateRowsBaseCallable();
    return new BulkMutateRowsUserFacingCallable(baseCallable, requestContext);
  }

  /**
   * Creates a callable chain to handle MutatesRows RPCs. This is meant to be used for automatic
   * batching with flow control. The chain will:
   *
   * <ul>
   *   <li>Convert a {@link RowMutation} into a {@link MutateRowsRequest} with a single entry.
   *   <li>Using gax's {@link com.google.api.gax.rpc.BatchingCallable} to spool the requests and
   *       aggregate the {@link MutateRowsRequest.Entry}s.
   *   <li>Process the response and schedule retries. At the end of each attempt, entries that have
   *       been applied, are filtered from the next attempt. Also, any entries that failed with a
   *       nontransient error, are filtered from the next attempt. This will continue until there
   *       are no more entries or there are no more retry attempts left.
   *   <li>Wrap batch failures in a {@link
   *       com.google.cloud.bigtable.data.v2.models.MutateRowsException}.
   *   <li>Split the responses using {@link MutateRowsBatchingDescriptor}.
   * </ul>
   */
  private UnaryCallable<RowMutation, Void> createBulkMutateRowsBatchingCallable() {
    UnaryCallable<MutateRowsRequest, Void> baseCallable = createMutateRowsBaseCallable();

    BatchingCallSettings.Builder<MutateRowsRequest, Void> batchingCallSettings =
        BatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor())
            .setBatchingSettings(settings.bulkMutateRowsSettings().getBatchingSettings());

    UnaryCallable<MutateRowsRequest, Void> batching =
        Callables.batching(baseCallable, batchingCallSettings.build(), clientContext);

    MutateRowsUserFacingCallable userFacing =
        new MutateRowsUserFacingCallable(batching, requestContext);

    return userFacing.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Internal helper to create the base MutateRows callable chain. The chain is responsible for
   * retrying individual entry in case of error.
   *
   * @see MutateRowsRetryingCallable for more details
   */
  private UnaryCallable<MutateRowsRequest, Void> createMutateRowsBaseCallable() {
    RetryAlgorithm<Void> retryAlgorithm =
        new RetryAlgorithm<>(
            new ApiResultRetryAlgorithm<Void>(),
            new ExponentialRetryAlgorithm(
                settings.bulkMutateRowsSettings().getRetrySettings(), clientContext.getClock()));
    RetryingExecutor<Void> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());

    return new MutateRowsRetryingCallable(
        clientContext.getDefaultCallContext(),
        stub.mutateRowsCallable(),
        retryingExecutor,
        settings.bulkMutateRowsSettings().getRetryableCodes());
  }

  /**
   * Creates a callable chain to handle CheckAndMutateRow RPCs. THe chain will:
   *
   * <ul>
   *   <li>Convert {@link ConditionalRowMutation}s into {@link
   *       com.google.bigtable.v2.CheckAndMutateRowRequest}s.
   * </ul>
   */
  private UnaryCallable<ConditionalRowMutation, Boolean> createCheckAndMutateRowCallable() {
    CheckAndMutateRowCallable userFacing =
        new CheckAndMutateRowCallable(stub.checkAndMutateRowCallable(), requestContext);

    return userFacing.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Creates a callable chain to handle ReadModifyWriteRow RPCs. The chain will:
   *
   * <ul>
   *   <li>Convert {@link ReadModifyWriteRow}s into {@link
   *       com.google.bigtable.v2.ReadModifyWriteRowRequest}s.
   *   <li>Convert the responses into {@link Row}.
   * </ul>
   */
  private UnaryCallable<ReadModifyWriteRow, Row> createReadModifyWriteRowCallable() {
    ReadModifyWriteRowCallable userFacing =
        new ReadModifyWriteRowCallable(stub.readModifyWriteRowCallable(), requestContext);

    return userFacing.withDefaultCallContext(clientContext.getDefaultCallContext());
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
   * Returns the callable chain created in {@link #createBulkMutateRowsBatchingCallable()} ()}
   * during stub construction.
   */
  public UnaryCallable<RowMutation, Void> bulkMutateRowsBatchingCallable() {
    return bulkMutateRowsBatchingCallable;
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

  @Override
  public void close() throws Exception {
    stub.close();
  }
}
