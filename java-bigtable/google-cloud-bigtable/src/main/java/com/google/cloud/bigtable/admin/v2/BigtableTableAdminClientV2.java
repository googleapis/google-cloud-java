/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.admin.v2;

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.grpc.ProtoOperationTransformers.MetadataTransformer;
import com.google.api.gax.grpc.ProtoOperationTransformers.ResponseTransformer;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.OptimizeRestoredTableMetadata;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.stub.AwaitConsistencyCallableV2;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.cloud.bigtable.admin.v2.stub.GrpcBigtableTableAdminStub;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.Marshaller;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * Modern Cloud Bigtable Table Admin Client.
 *
 * <p>This client extends the {@link BaseBigtableTableAdminClient} to provide enhanced convenience
 * methods for table administration. It improves the user experience by handling chained Long
 * Running Operations (such as seamlessly restoring and then optimizing a table) and provides
 * built-in, automated polling for consistency tokens.
 */
public class BigtableTableAdminClientV2 extends BaseBigtableTableAdminClient {
  private final AwaitConsistencyCallableV2 awaitConsistencyCallable;
  private final OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
      optimizeRestoredTableOperationBaseCallable;
  private final ScheduledExecutorService backgroundExecutor;
  private final boolean shouldAutoClose;

  private static final RetrySettings AWAIT_CONSISTENCY_POLLING_SETTINGS_BASE =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofSeconds(10))
          .setRetryDelayMultiplier(1.0)
          .setMaxRetryDelayDuration(Duration.ofSeconds(10))
          .setInitialRpcTimeoutDuration(Duration.ZERO)
          .setMaxRpcTimeoutDuration(Duration.ZERO)
          .setRpcTimeoutMultiplier(1.0)
          .build();

  private static final RetrySettings OPTIMIZE_RESTORED_TABLE_POLLING_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(Duration.ofMillis(500L))
          .setRetryDelayMultiplier(1.5)
          .setMaxRetryDelayDuration(Duration.ofMillis(5000L))
          .setInitialRpcTimeoutDuration(Duration.ZERO)
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeoutDuration(Duration.ZERO)
          .setTotalTimeoutDuration(Duration.ofMillis(600000L))
          .build();

  /** Constructs an instance of BigtableTableAdminClientV2 with the given settings. */
  public static final BigtableTableAdminClientV2 create(BaseBigtableTableAdminSettings settings)
      throws IOException {
    GrpcBigtableTableAdminStub stub =
        (GrpcBigtableTableAdminStub)
            ((BigtableTableAdminStubSettings) settings.getStubSettings()).createStub();
    ScheduledExecutorService backgroundExecutor =
        settings.getStubSettings().getBackgroundExecutorProvider().getExecutor();
    boolean shouldAutoClose =
        settings.getStubSettings().getBackgroundExecutorProvider().shouldAutoClose();

    AwaitConsistencyCallableV2 awaitConsistencyCallable =
        createAwaitConsistencyCallable(
            stub,
            (BigtableTableAdminStubSettings) settings.getStubSettings(),
            settings.getStubSettings().getClock(),
            backgroundExecutor);

    OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
        optimizeRestoredTableOperationBaseCallable =
            createOptimizeRestoredTableOperationBaseCallable(
                stub, settings.getStubSettings().getClock(), backgroundExecutor);

    return new BigtableTableAdminClientV2(
        stub,
        backgroundExecutor,
        shouldAutoClose,
        awaitConsistencyCallable,
        optimizeRestoredTableOperationBaseCallable);
  }

  /**
   * Package-private factory method to construct an instance of {@link BigtableTableAdminClientV2}
   * by reusing an existing stub, settings, clock, and background executor.
   *
   * <p>This is used by the legacy {@code BigtableTableAdminClient}'s escape hatch ({@code
   * getBaseClient()}) to wrap the legacy client's active stub, ensuring the underlying gRPC channel
   * and resources are shared rather than recreated.
   */
  static BigtableTableAdminClientV2 create(
      GrpcBigtableTableAdminStub stub,
      BigtableTableAdminStubSettings settings,
      ApiClock clock,
      ScheduledExecutorService backgroundExecutor,
      boolean shouldAutoClose)
      throws IOException {
    AwaitConsistencyCallableV2 awaitConsistencyCallable =
        createAwaitConsistencyCallable(stub, settings, clock, backgroundExecutor);
    OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
        optimizeRestoredTableOperationBaseCallable =
            createOptimizeRestoredTableOperationBaseCallable(stub, clock, backgroundExecutor);
    return new BigtableTableAdminClientV2(
        stub,
        backgroundExecutor,
        shouldAutoClose,
        awaitConsistencyCallable,
        optimizeRestoredTableOperationBaseCallable);
  }

  protected BigtableTableAdminClientV2(
      GrpcBigtableTableAdminStub stub,
      @Nullable ScheduledExecutorService backgroundExecutor,
      boolean shouldAutoClose,
      @Nullable AwaitConsistencyCallableV2 awaitConsistencyCallable,
      @Nullable
          OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
              optimizeRestoredTableOperationBaseCallable) {
    super(stub);
    this.backgroundExecutor = backgroundExecutor;
    this.shouldAutoClose = shouldAutoClose;
    this.awaitConsistencyCallable = awaitConsistencyCallable;
    this.optimizeRestoredTableOperationBaseCallable = optimizeRestoredTableOperationBaseCallable;
  }

  private static AwaitConsistencyCallableV2 createAwaitConsistencyCallable(
      GrpcBigtableTableAdminStub stub,
      BigtableTableAdminStubSettings settings,
      ApiClock clock,
      ScheduledExecutorService executor) {
    // TODO(igorbernstein2): expose polling settings
    RetrySettings pollingSettings =
        AWAIT_CONSISTENCY_POLLING_SETTINGS_BASE.toBuilder()
            .setTotalTimeoutDuration(
                settings.checkConsistencySettings().getRetrySettings().getTotalTimeoutDuration())
            .build();

    return AwaitConsistencyCallableV2.create(
        stub.generateConsistencyTokenCallable(),
        stub.checkConsistencyCallable(),
        clock,
        executor,
        pollingSettings);
  }

  private static OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
      createOptimizeRestoredTableOperationBaseCallable(
          GrpcBigtableTableAdminStub stub,
          ApiClock clock,
          ScheduledExecutorService backgroundExecutor)
          throws IOException {

    // Reusing getRestoreTableMethod() as a placeholder descriptor for LRO optimization tracking.
    // Since there is no dedicated gRPC LRO method descriptor generated for OptimizeRestoredTable
    // LRO, we reuse getRestoreTableMethod() (which is an LRO and returns a
    // google.longrunning.Operation) and attach a throwing Marshaller for Void to satisfy the
    // OperationCallable constructor requirements. Note: We do not plumb the gRPC ManagedChannel
    // into the ClientContext below because this callable is only used for resumeFutureCall()
    // (polling existing LROs via OperationsStub), which already encapsulates its own channel.
    // The initial RPC is never called through this OperationCallable.
    MethodDescriptor<Void, Operation> fakeDescriptor =
        MethodDescriptor.<Void, Operation>newBuilder()
            .setType(MethodDescriptor.MethodType.UNARY)
            .setFullMethodName(
                MethodDescriptor.generateFullMethodName(
                    "google.bigtable.admin.v2.BigtableTableAdmin", "RestoreTable"))
            .setRequestMarshaller(
                new Marshaller<Void>() {
                  @Override
                  public InputStream stream(Void value) {
                    throw new UnsupportedOperationException();
                  }

                  @Override
                  public Void parse(InputStream stream) {
                    throw new UnsupportedOperationException();
                  }
                })
            .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
            .build();

    GrpcCallSettings<Void, Operation> unusedInitialCallSettings =
        GrpcCallSettings.create(fakeDescriptor);

    final MetadataTransformer<OptimizeRestoredTableMetadata> protoMetadataTransformer =
        MetadataTransformer.create(OptimizeRestoredTableMetadata.class);

    final ResponseTransformer<Empty> protoResponseTransformer =
        ResponseTransformer.create(Empty.class);

    OperationCallSettings<Void, Empty, OptimizeRestoredTableMetadata> operationCallSettings =
        OperationCallSettings.<Void, Empty, OptimizeRestoredTableMetadata>newBuilder()
            .setInitialCallSettings(
                UnaryCallSettings.<Void, OperationSnapshot>newUnaryCallSettingsBuilder()
                    .setSimpleTimeoutNoRetriesDuration(Duration.ZERO)
                    .build())
            .setMetadataTransformer(
                new ApiFunction<OperationSnapshot, OptimizeRestoredTableMetadata>() {
                  @Override
                  public OptimizeRestoredTableMetadata apply(OperationSnapshot input) {
                    return protoMetadataTransformer.apply(input);
                  }
                })
            .setResponseTransformer(
                new ApiFunction<OperationSnapshot, Empty>() {
                  @Override
                  public Empty apply(OperationSnapshot input) {
                    return protoResponseTransformer.apply(input);
                  }
                })
            .setPollingAlgorithm(
                OperationTimedPollAlgorithm.create(OPTIMIZE_RESTORED_TABLE_POLLING_SETTINGS))
            .build();

    // Note: The clientContext created here only contains the basic clock and executor settings
    // required by the polling algorithm to schedule polling attempts. We do not need to populate
    // the channel or call context details here because the operations stub
    // (stub.getOperationsStub()) already encapsulates the fully-configured default call context
    // (including channels, credentials, and headers) for executing the polling RPCs.
    ClientContext clientContext =
        ClientContext.newBuilder()
            .setClock(clock)
            .setExecutor(backgroundExecutor)
            .setDefaultCallContext(GrpcCallContext.createDefault())
            .build();

    return GrpcCallableFactory.createOperationCallable(
        unusedInitialCallSettings, operationCallSettings, clientContext, stub.getOperationsStub());
  }

  /**
   * Awaits the completion of the "Optimize Restored Table" operation.
   *
   * <p>This method blocks until the restore operation is complete, extracts the optimization token,
   * and returns an ApiFuture for the optimization phase.
   *
   * @param restoreFuture The future returned by restoreTableAsync().
   * @return An ApiFuture that tracks the optimization progress.
   */
  public ApiFuture<Empty> awaitOptimizeRestoredTable(ApiFuture<RestoredTableResult> restoreFuture) {
    return ApiFutures.transformAsync(
        restoreFuture,
        result -> {
          OptimizeRestoredTableOperationToken token =
              result.getOptimizeRestoredTableOperationToken();

          if (token == null || Strings.isNullOrEmpty(token.getOperationName())) {
            return ApiFutures.immediateFuture(Empty.getDefaultInstance());
          }

          return getOptimizeRestoredTableCallable().resumeFutureCall(token.getOperationName());
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Awaits a restored table is fully optimized.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * RestoredTableResult result =
   *     client.restoreTable(RestoreTableRequest.of(clusterId, backupId).setTableId(tableId));
   * client.awaitOptimizeRestoredTable(result.getOptimizeRestoredTableOperationToken());
   * }</pre>
   */
  public void awaitOptimizeRestoredTable(OptimizeRestoredTableOperationToken token) {
    ApiExceptions.callAndTranslateApiException(awaitOptimizeRestoredTableAsync(token));
  }

  /**
   * Awaits a restored table is fully optimized asynchronously.
   *
   * <p>Sample code
   *
   * <pre>{@code
   * RestoredTableResult result =
   *     client.restoreTable(RestoreTableRequest.of(clusterId, backupId).setTableId(tableId));
   * ApiFuture<Void> future = client.awaitOptimizeRestoredTableAsync(
   *     result.getOptimizeRestoredTableOperationToken());
   *
   * ApiFutures.addCallback(
   *   future,
   *   new ApiFutureCallback<Void>() {
   *     public void onSuccess(Void unused) {
   *       System.out.println("The optimization of the restored table is done.");
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   * }</pre>
   */
  public ApiFuture<Void> awaitOptimizeRestoredTableAsync(
      OptimizeRestoredTableOperationToken token) {
    ApiFuture<Empty> emptyFuture =
        getOptimizeRestoredTableCallable().resumeFutureCall(token.getOperationName());
    return ApiFutures.transform(emptyFuture, input -> null, MoreExecutors.directExecutor());
  }

  /**
   * Polls an existing consistency token until table replication is consistent across all clusters.
   * Useful for checking consistency of a token generated in a separate process. Blocks until
   * completion.
   *
   * @param tableName The fully qualified table name to check.
   * @param consistencyToken The token to poll.
   */
  public void waitForConsistency(String tableName, String consistencyToken) {
    ApiExceptions.callAndTranslateApiException(
        waitForConsistencyAsync(tableName, consistencyToken));
  }

  /**
   * Polls an existing consistency token until table replication is consistent across all clusters.
   * Useful for checking consistency of a token generated in a separate process. Blocks until
   * completion.
   *
   * @param tableName The typesafe fully qualified table name to check.
   * @param consistencyToken The token to poll.
   */
  public void waitForConsistency(TableName tableName, String consistencyToken) {
    waitForConsistency(tableName.toString(), consistencyToken);
  }

  /**
   * Asynchronously polls the consistency token. Returns a future that completes when table
   * replication is consistent across all clusters.
   *
   * @param tableName The fully qualified table name to check.
   * @param consistencyToken The token to poll.
   */
  public ApiFuture<Void> waitForConsistencyAsync(String tableName, String consistencyToken) {
    return getAwaitConsistencyCallable()
        .futureCall(ConsistencyRequest.forReplicationFromTableName(tableName, consistencyToken));
  }

  /**
   * Asynchronously polls the consistency token. Returns a future that completes when table
   * replication is consistent across all clusters.
   *
   * @param tableName The typesafe fully qualified table name to check.
   * @param consistencyToken The token to poll.
   */
  public ApiFuture<Void> waitForConsistencyAsync(TableName tableName, String consistencyToken) {
    return waitForConsistencyAsync(tableName.toString(), consistencyToken);
  }

  private UnaryCallable<ConsistencyRequest, Void> getAwaitConsistencyCallable() {
    if (awaitConsistencyCallable != null) {
      return awaitConsistencyCallable;
    }
    throw new IllegalStateException(
        "AwaitConsistencyCallable not initialized. BigtableTableAdminClientV2 must be "
            + "initialized via BigtableTableAdminClientV2.create(BaseBigtableTableAdminSettings) "
            + "to use this functionality.");
  }

  private OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
      getOptimizeRestoredTableCallable() {
    if (optimizeRestoredTableOperationBaseCallable != null) {
      return optimizeRestoredTableOperationBaseCallable;
    }
    throw new IllegalStateException(
        "OptimizeRestoredTableCallable not initialized. BigtableTableAdminClientV2 must be "
            + "initialized via BigtableTableAdminClientV2.create(BaseBigtableTableAdminSettings) "
            + "to use this functionality.");
  }

  @Override
  public void close() {
    if (backgroundExecutor != null && shouldAutoClose) {
      backgroundExecutor.shutdown();
    }
    super.close();
  }

  @Override
  public void shutdown() {
    if (backgroundExecutor != null && shouldAutoClose) {
      backgroundExecutor.shutdown();
    }
    super.shutdown();
  }

  @Override
  public void shutdownNow() {
    if (backgroundExecutor != null && shouldAutoClose) {
      backgroundExecutor.shutdownNow();
    }
    super.shutdownNow();
  }

  @Override
  public boolean isShutdown() {
    return (backgroundExecutor == null || !shouldAutoClose || backgroundExecutor.isShutdown())
        && super.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return (backgroundExecutor == null || !shouldAutoClose || backgroundExecutor.isTerminated())
        && super.isTerminated();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    long startNanos = System.nanoTime();
    boolean terminated = true;
    if (backgroundExecutor != null && shouldAutoClose) {
      terminated = backgroundExecutor.awaitTermination(duration, unit);
    }
    if (!terminated) {
      return false;
    }
    long remainingNanos = unit.toNanos(duration) - (System.nanoTime() - startNanos);
    return super.awaitTermination(Math.max(0, remainingNanos), TimeUnit.NANOSECONDS);
  }
}
