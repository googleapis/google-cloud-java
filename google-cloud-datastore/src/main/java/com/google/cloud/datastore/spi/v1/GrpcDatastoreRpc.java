/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.datastore.spi.v1;

import static com.google.cloud.datastore.DatastoreUtils.isEmulator;
import static com.google.cloud.datastore.DatastoreUtils.removeScheme;
import static com.google.cloud.datastore.spi.v1.RpcUtils.retrySettingSetter;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.cloud.datastore.v1.stub.GrpcDatastoreStub;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.base.Strings;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Collections;

@InternalApi
public class GrpcDatastoreRpc implements DatastoreRpc {

  private final GrpcDatastoreStub datastoreStub;
  private final ClientContext clientContext;
  private boolean closed;

  public GrpcDatastoreRpc(DatastoreOptions datastoreOptions) throws IOException {
    try {
      clientContext =
          isEmulator(datastoreOptions)
              ? getClientContextForEmulator(datastoreOptions)
              : getClientContext(datastoreOptions);

      /* For grpc transport options, configure default gRPC Connection pool with minChannelCount = 1 and maxChannelCount = 4 */
      DatastoreStubSettings datastoreStubSettings =
          DatastoreStubSettings.newBuilder(clientContext)
              .applyToAllUnaryMethods(retrySettingSetter(datastoreOptions))
              .setTransportChannelProvider(
                  DatastoreSettings.defaultGrpcTransportProviderBuilder()
                      .setChannelPoolSettings(
                          ChannelPoolSettings.builder()
                              .setInitialChannelCount(DatastoreOptions.INIT_CHANNEL_COUNT)
                              .setMinChannelCount(DatastoreOptions.MIN_CHANNEL_COUNT)
                              .setMaxChannelCount(DatastoreOptions.MAX_CHANNEL_COUNT)
                              .build())
                      .build())
              .build();
      datastoreStub = GrpcDatastoreStub.create(datastoreStubSettings);
    } catch (IOException e) {
      throw new IOException(e);
    }
  }

  @Override
  public void close() throws Exception {
    if (!closed) {
      datastoreStub.close();
      for (BackgroundResource resource : clientContext.getBackgroundResources()) {
        resource.close();
      }
      closed = true;
    }
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.awaitTermination(1, SECONDS);
    }
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    return datastoreStub.allocateIdsCallable().call(request);
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreException {
    return datastoreStub.beginTransactionCallable().call(request);
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    return datastoreStub.commitCallable().call(request);
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    return datastoreStub.lookupCallable().call(request);
  }

  @Override
  public ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    return datastoreStub.reserveIdsCallable().call(request);
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    return datastoreStub.rollbackCallable().call(request);
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    return datastoreStub.runQueryCallable().call(request);
  }

  @Override
  public RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    return datastoreStub.runAggregationQueryCallable().call(request);
  }

  @Override
  public boolean isClosed() {
    return closed && datastoreStub.isShutdown();
  }

  private ClientContext getClientContextForEmulator(DatastoreOptions datastoreOptions)
      throws IOException {
    ManagedChannel managedChannel =
        ManagedChannelBuilder.forTarget(removeScheme(datastoreOptions.getHost()))
            .usePlaintext()
            .build();
    TransportChannel transportChannel = GrpcTransportChannel.create(managedChannel);
    return ClientContext.newBuilder()
        .setCredentials(null)
        .setTransportChannel(transportChannel)
        .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
        .setBackgroundResources(Collections.singletonList(transportChannel))
        .build();
  }

  private ClientContext getClientContext(DatastoreOptions datastoreOptions) throws IOException {
    HeaderProvider internalHeaderProvider =
        DatastoreSettings.defaultApiClientHeaderProviderBuilder()
            .setClientLibToken(
                ServiceOptions.getGoogApiClientLibName(),
                GaxProperties.getLibraryVersion(datastoreOptions.getClass()))
            .setResourceToken(getResourceToken(datastoreOptions))
            .build();

    DatastoreSettingsBuilder settingsBuilder =
        new DatastoreSettingsBuilder(DatastoreSettings.newBuilder().build());
    settingsBuilder.setCredentialsProvider(
        GrpcTransportOptions.setUpCredentialsProvider(datastoreOptions));
    settingsBuilder.setTransportChannelProvider(datastoreOptions.getTransportChannelProvider());
    settingsBuilder.setInternalHeaderProvider(internalHeaderProvider);
    settingsBuilder.setHeaderProvider(
        datastoreOptions.getMergedHeaderProvider(new NoHeaderProvider()));
    return ClientContext.create(settingsBuilder.build());
  }

  private String getResourceToken(DatastoreOptions datastoreOptions) {
    StringBuilder builder = new StringBuilder("project_id=");
    builder.append(datastoreOptions.getProjectId());
    if (!Strings.isNullOrEmpty(datastoreOptions.getDatabaseId())) {
      builder.append("&database_id=");
      builder.append(datastoreOptions.getDatabaseId());
    }
    return builder.toString();
  }
}
