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
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.GrpcTransport;
import com.google.api.gax.grpc.GrpcTransportProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.Transport;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings.Builder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.v1beta1.FirestoreClient;
import com.google.cloud.firestore.v1beta1.FirestoreSettings;
import com.google.cloud.firestore.v1beta1.stub.FirestoreStub;
import com.google.cloud.firestore.v1beta1.stub.GrpcFirestoreStub;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.DatabaseName;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsResponse;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
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
        clientContext =
            ClientContext.newBuilder()
                .setCredentials(null)
                .setExecutor(executor)
                .setTransportContext(GrpcTransport.newBuilder().setChannel(managedChannel).build())
                .build();
      } else {
        DatabaseName databaseName = DatabaseName
            .create(options.getProjectId(), options.getDatabaseId());
        Credentials credentials =
            GrpcTransportOptions.setUpCredentialsProvider(options).getCredentials();
        InstantiatingChannelProvider.Builder channelBuilder = FirestoreSettings
            .defaultGrpcChannelProviderBuilder();
        channelBuilder.setGoogleCloudResourcePrefix(databaseName.toString());
        ChannelProvider channelProvider =
            GrpcTransportOptions.setUpChannelProvider(channelBuilder, options);
        GrpcTransportProvider transportProviders =
            GrpcTransportProvider.newBuilder().setChannelProvider(channelProvider).build();
        Transport transport;
        if (transportProviders.needsExecutor()) {
          transport = transportProviders.getTransport(executor);
        } else {
          transport = transportProviders.getTransport();
        }
        clientContext =
            ClientContext.newBuilder()
                .setCredentials(credentials)
                .setExecutor(executor)
                .setTransportContext(transport)
                .setBackgroundResources(transport.getBackgroundResources())
                .build();
      }
      ApiFunction<UnaryCallSettings.Builder, Void> retrySettingsSetter =
          new ApiFunction<Builder, Void>() {
            @Override
            public Void apply(UnaryCallSettings.Builder builder) {
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
  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
  listCollectionIdsCallable() {
    return firestoreStub.listCollectionIdsCallable();
  }
}
