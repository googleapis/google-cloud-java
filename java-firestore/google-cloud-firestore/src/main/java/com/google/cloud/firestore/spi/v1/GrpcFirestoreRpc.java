/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.firestore.spi.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreSettings;
import com.google.cloud.firestore.v1.stub.FirestoreStub;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.cloud.firestore.v1.stub.GrpcFirestoreStub;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.DatabaseRootName;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.protobuf.Empty;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * GRPC client implementation of the Firestore RPC methods. Exposes FirestoreOptions on top of the
 * GRPC-based Firestore GAPIC client.
 */
public class GrpcFirestoreRpc implements FirestoreRpc {

  private final FirestoreStub firestoreStub;
  private final ScheduledExecutorService executor;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;
  private final ClientContext clientContext;

  private boolean closed;

  public GrpcFirestoreRpc(final FirestoreOptions options) throws IOException {
    GrpcTransportOptions transportOptions = (GrpcTransportOptions) options.getTransportOptions();
    executorFactory = transportOptions.getExecutorFactory();
    executor = executorFactory.get();
    ClientContext createdClientContext = null;
    TransportChannel createdTransportChannel = null;
    try {
      if (options.getHost().contains("localhost")
          || NoCredentials.getInstance().equals(options.getCredentials())) {
        ManagedChannel managedChannel =
            ManagedChannelBuilder.forTarget(options.getHost())
                .usePlaintext()
                .executor(executor)
                .build();
        createdTransportChannel = GrpcTransportChannel.create(managedChannel);
        createdClientContext =
            ClientContext.newBuilder()
                .setCredentials(null)
                .setExecutor(executor)
                .setTransportChannel(createdTransportChannel)
                .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
                .setBackgroundResources(Collections.singletonList(createdTransportChannel))
                .build();
      } else {
        createdClientContext = ClientContext.create(createFirestoreSettings(options));
      }
      clientContext = createdClientContext;

      FirestoreStubSettings.Builder firestoreBuilder =
          FirestoreStubSettings.newBuilder(clientContext);
      RetrySettings retrySettings = options.getRetrySettings();

      // Override retry settings only if customer provides settings different from default.
      if (retrySettings.equals(ServiceOptions.getDefaultRetrySettings())) {
        // We are manually setting `setMaxAttempts(5)` to follow
        // the `firestore_grpc_service_config.json` configuration.
        // This code should be removed when following issue is fixed:
        // https://github.com/googleapis/sdk-platform-java/issues/2306
        firestoreBuilder.applyToAllUnaryMethods(
            builder -> {
              builder.retrySettings().setMaxAttempts(5);
              return null;
            });
        // Manually apply the retry settings to streaming methods
        firestoreBuilder.runQuerySettings().retrySettings().setMaxAttempts(5);
        firestoreBuilder.runAggregationQuerySettings().retrySettings().setMaxAttempts(5);
        firestoreBuilder.batchGetDocumentsSettings().retrySettings().setMaxAttempts(5);
        firestoreBuilder.executePipelineSettings().retrySettings().setMaxAttempts(5);
      } else {
        firestoreBuilder.applyToAllUnaryMethods(
            builder -> {
              builder.setRetrySettings(retrySettings);
              return null;
            });
        // Manually apply the retry settings to streaming methods
        firestoreBuilder.runQuerySettings().setRetrySettings(retrySettings);
        firestoreBuilder.runAggregationQuerySettings().setRetrySettings(retrySettings);
        firestoreBuilder.batchGetDocumentsSettings().setRetrySettings(retrySettings);
        firestoreBuilder.executePipelineSettings().setRetrySettings(retrySettings);
      }

      ApiTracerFactory apiTracerFactory = options.getApiTracerFactory();
      if (apiTracerFactory != null) {
        firestoreBuilder.setTracerFactory(apiTracerFactory);
      }

      firestoreStub = GrpcFirestoreStub.create(firestoreBuilder.build());
    } catch (Exception e) {
      if (createdClientContext != null) {
        for (BackgroundResource resource : createdClientContext.getBackgroundResources()) {
          try {
            resource.close();
          } catch (Exception suppressed) {
            e.addSuppressed(suppressed);
          }
        }
      } else if (createdTransportChannel != null) {
        try {
          createdTransportChannel.close();
        } catch (Exception suppressed) {
          e.addSuppressed(suppressed);
        }
      }
      try {
        executorFactory.release(executor);
      } catch (Exception suppressed) {
        e.addSuppressed(suppressed);
      }
      throw new IOException(e);
    }
  }

  @Override
  public void close() throws Exception {
    if (!closed) {
      firestoreStub.close();
      for (BackgroundResource resource : clientContext.getBackgroundResources()) {
        resource.close();
      }
      executorFactory.release(executor);
      closed = true;
    }
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.awaitTermination(1, TimeUnit.SECONDS);
    }
  }

  @Override
  public void shutdown() {
    if (closed) {
      return;
    }
    firestoreStub.shutdown();
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.shutdown();
    }
    executorFactory.release(executor);
    closed = true;
  }

  @Override
  public void shutdownNow() {
    if (closed) {
      return;
    }
    firestoreStub.shutdownNow();
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.shutdownNow();
    }
    executorFactory.release(executor);
    closed = true;
  }

  @Override
  public ScheduledExecutorService getExecutor() {
    return executor;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return firestoreStub.commitCallable();
  }

  @Override
  public UnaryCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable() {
    return firestoreStub.batchWriteCallable();
  }

  @Override
  public ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return firestoreStub.batchGetDocumentsCallable();
  }

  @Override
  public ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return firestoreStub.runQueryCallable();
  }

  @Override
  public ServerStreamingCallable<ExecutePipelineRequest, ExecutePipelineResponse>
      executePipelineCallable() {
    return firestoreStub.executePipelineCallable();
  }

  @Override
  public ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return firestoreStub.runAggregationQueryCallable();
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return firestoreStub.beginTransactionCallable();
  }

  @Override
  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return firestoreStub.rollbackCallable();
  }

  @Override
  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    return firestoreStub.listCollectionIdsPagedCallable();
  }

  @Override
  public UnaryCallable<PartitionQueryRequest, FirestoreClient.PartitionQueryPagedResponse>
      partitionQueryPagedCallable() {
    return firestoreStub.partitionQueryPagedCallable();
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return firestoreStub.listDocumentsPagedCallable();
  }

  @Override
  public BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    return firestoreStub.listenCallable();
  }

  /** Returns the {@link ClientContext} created for this RPC instance. */
  @VisibleForTesting
  ClientContext getClientContext() {
    return clientContext;
  }

  /**
   * Builds {@link FirestoreSettings} from {@link FirestoreOptions}, propagating {@code
   * universeDomain} and leaving the endpoint unset when the default host is used so GAX resolves
   * the endpoint from the universe domain.
   */
  @VisibleForTesting
  static FirestoreSettings createFirestoreSettings(FirestoreOptions options) throws IOException {
    FirestoreSettingsBuilder settingsBuilder = new FirestoreSettingsBuilder();

    DatabaseRootName databaseName =
        DatabaseRootName.of(options.getProjectId(), options.getDatabaseId());

    settingsBuilder.setCredentialsProvider(options.getCredentialsProvider());
    settingsBuilder.setTransportChannelProvider(options.getTransportChannelProvider());
    // Forward any explicitly configured universe domain so GAX resolves the endpoint
    // and validates credentials against it.
    if (options.getUniverseDomain() != null) {
      settingsBuilder.setUniverseDomain(options.getUniverseDomain());
    }
    // Preserve custom host overrides; leave the endpoint unset for the default host so GAX
    // resolves firestore.<universeDomain>:443 automatically.
    if (options.getHost() != null
        && !FirestoreSettings.getDefaultEndpoint().equals(options.getHost())) {
      settingsBuilder.setEndpoint(options.getHost());
    }

    HeaderProvider internalHeaderProvider =
        FirestoreSettings.defaultApiClientHeaderProviderBuilder()
            .setClientLibToken(
                ServiceOptions.getGoogApiClientLibName(),
                GaxProperties.getLibraryVersion(options.getClass()))
            .setResourceToken(databaseName.toString())
            .build();

    settingsBuilder.setInternalHeaderProvider(internalHeaderProvider);
    settingsBuilder.setHeaderProvider(options.getMergedHeaderProvider(new NoHeaderProvider()));

    return settingsBuilder.build();
  }

  // This class is needed solely to get access to protected method setInternalHeaderProvider()
  private static class FirestoreSettingsBuilder extends FirestoreSettings.Builder {
    private FirestoreSettingsBuilder() {
      super(FirestoreStubSettings.newBuilder());
    }

    @Override
    protected FirestoreSettings.Builder setInternalHeaderProvider(
        HeaderProvider internalHeaderProvider) {
      return super.setInternalHeaderProvider(internalHeaderProvider);
    }
  }
}
