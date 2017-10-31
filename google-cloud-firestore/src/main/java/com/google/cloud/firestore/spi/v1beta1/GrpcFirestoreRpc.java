/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.firestore.spi.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings.Builder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.v1beta1.FirestoreSettings;
import com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListCollectionIdsPagedResponse;
import com.google.cloud.firestore.v1beta1.stub.FirestoreStub;
import com.google.cloud.firestore.v1beta1.stub.GrpcFirestoreStub;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.DatabaseRootName;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.protobuf.Empty;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

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
    try {
      if (options.getHost().contains("localhost")
          || NoCredentials.getInstance().equals(options.getCredentials())) {
        ManagedChannel managedChannel =
            ManagedChannelBuilder.forTarget(options.getHost())
                .usePlaintext(true)
                .executor(executor)
                .build();
        TransportChannel transportChannel = GrpcTransportChannel.create(managedChannel);
        clientContext =
            ClientContext.newBuilder()
                .setCredentials(null)
                .setExecutor(executor)
                .setTransportChannel(transportChannel)
                .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
                .setBackgroundResources(Collections.<BackgroundResource>singletonList(transportChannel))
                .build();
      } else {
        FirestoreSettings.Builder settingsBuilder = FirestoreSettings.newBuilder();

        DatabaseRootName databaseName = DatabaseRootName
            .create(options.getProjectId(), options.getDatabaseId());

        settingsBuilder.setCredentialsProvider(GrpcTransportOptions.setUpCredentialsProvider(options));
        settingsBuilder.setTransportChannelProvider(
            GrpcTransportOptions.setUpChannelProvider(FirestoreSettings.defaultGrpcTransportProviderBuilder(), options));

        ApiClientHeaderProvider.Builder headerProvider =
            FirestoreSettings.defaultApiClientHeaderProviderBuilder();
        headerProvider.setGoogleCloudResourcePrefix(databaseName.toString());

        settingsBuilder.setHeaderProvider(
            GrpcTransportOptions.setUpHeaderProvider(headerProvider, options));

        clientContext = ClientContext.create(settingsBuilder.build());
      }
      ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> retrySettingsSetter =
          new ApiFunction<Builder<?, ?>, Void>() {
            @Override
            public Void apply(UnaryCallSettings.Builder<?, ?> builder) {
              builder.setRetrySettings(options.getRetrySettings());
              return null;
            }
          };
      FirestoreSettings.Builder firestoreBuilder =
          FirestoreSettings.newBuilder(clientContext)
              .applyToAllUnaryMethods(retrySettingsSetter);
      firestoreStub = GrpcFirestoreStub.create(firestoreBuilder.build());
    } catch (Exception e) {
      throw new IOException(e);
    }
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    firestoreStub.close();
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.close();
    }
    executorFactory.release(executor);
  }

  @Override
  public Executor getExecutor() {
    return executor;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return firestoreStub.commitCallable();
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
}
