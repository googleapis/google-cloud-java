/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.ServiceOptions;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStub;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.database.v1.stub.GrpcDatabaseAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.GrpcInstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.cloud.spanner.v1.stub.GrpcSpannerStub;
import com.google.cloud.spanner.v1.stub.SpannerStub;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.base.MoreObjects;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import io.grpc.Context;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/** Implementation of Cloud Spanner remote calls using Gapic libraries. */
public class GapicSpannerRpc implements SpannerRpc {

  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");

  private final SpannerStub stub;
  private final InstanceAdminStub instanceStub;
  private final DatabaseAdminStub databaseStub;
  private final String projectId;
  private final String projectName;
  private final SpannerMetadataProvider metadataProvider;

  public GapicSpannerRpc(SpannerOptions options) throws IOException {
    this.projectId = options.getProjectId();
    this.projectName = PROJECT_NAME_TEMPLATE.instantiate("project", this.projectId);

    ApiClientHeaderProvider.Builder internalHeaderProviderBuilder =
        ApiClientHeaderProvider.newBuilder();
    ApiClientHeaderProvider internalHeaderProvider =
        internalHeaderProviderBuilder
            .setClientLibToken(
                ServiceOptions.getGoogApiClientLibName(),
                GaxProperties.getLibraryVersion(options.getClass()))
            .setTransportToken(
                GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion())
            .build();

    HeaderProvider mergedHeaderProvider = options.getMergedHeaderProvider(internalHeaderProvider);
    this.metadataProvider =
        SpannerMetadataProvider.create(
            mergedHeaderProvider.getHeaders(),
            internalHeaderProviderBuilder.getResourceHeaderKey());

    // TODO(pongad): make channel pool work

    // TODO(pongad): make RPC logging work (formerly LoggingInterceptor)
    // TODO(pongad): add watchdog
    // TODO(pongad): make error augmentation work (formerly SpannerErrorInterceptor)

    TransportChannelProvider channelProvider =
        FixedTransportChannelProvider.create(
            GrpcTransportChannel.newBuilder()
                .setManagedChannel(options.getRpcChannels().get(0))
                .build());
    CredentialsProvider credentialsProvider =
        GrpcTransportOptions.setUpCredentialsProvider(options);

    this.stub =
        GrpcSpannerStub.create(
            SpannerStubSettings.newBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .build());
    this.instanceStub =
        GrpcInstanceAdminStub.create(
            InstanceAdminStubSettings.newBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .build());
    this.databaseStub =
        GrpcDatabaseAdminStub.create(
            DatabaseAdminStubSettings.newBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .build());
  }

  @Override
  public Paginated<InstanceConfig> listInstanceConfigs(int pageSize, @Nullable String pageToken)
      throws SpannerException {
    ListInstanceConfigsRequest.Builder requestBuilder = 
        ListInstanceConfigsRequest.newBuilder().setParent(projectName).setPageSize(pageSize);
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    ListInstanceConfigsRequest request = requestBuilder.build();

    // TODO: put projectName in metadata
    ListInstanceConfigsResponse response = 
        get(instanceStub.listInstanceConfigsCallable().futureCall(request));
    return new Paginated<>(response.getInstanceConfigsList(), response.getNextPageToken());
  }

  @Override
  public InstanceConfig getInstanceConfig(String instanceConfigName) throws SpannerException {
    GetInstanceConfigRequest request = 
        GetInstanceConfigRequest.newBuilder().setName(instanceConfigName).build();

    // TODO: put projectName in metadata
    return get(instanceStub.getInstanceConfigCallable().futureCall(request));
  }

  @Override
  public Paginated<Instance> listInstances(
      int pageSize, @Nullable String pageToken, @Nullable String filter) throws SpannerException {
    ListInstancesRequest.Builder requestBuilder =
        ListInstancesRequest.newBuilder().setParent(projectName).setPageSize(pageSize);
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    if (filter != null) {
      requestBuilder.setFilter(filter);
    }
    ListInstancesRequest request = requestBuilder.build();
    
    // TODO: put projectName in metadata
    ListInstancesResponse response = 
        get(instanceStub.listInstancesCallable().futureCall(request));
    return new Paginated<>(response.getInstancesList(), response.getNextPageToken());
  }

  @Override
  public Operation createInstance(String parent, String instanceId, Instance instance)
      throws SpannerException {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    // TODO: put parent in metadata
    return get(instanceStub.createInstanceCallable().futureCall(request));
  }

  @Override
  public Operation updateInstance(Instance instance, FieldMask fieldMask) throws SpannerException {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setFieldMask(fieldMask).build();
    // TODO: put instance.getName() in metadata
    return get(instanceStub.updateInstanceCallable().futureCall(request));
  }

  @Override
  public Instance getInstance(String instanceName) throws SpannerException {
    GetInstanceRequest request = 
        GetInstanceRequest.newBuilder().setName(instanceName).build();
    
    // TODO: put instanceName in metadata
    return get(instanceStub.getInstanceCallable().futureCall(request));
  }

  @Override
  public void deleteInstance(String instanceName) throws SpannerException {
    DeleteInstanceRequest request = 
        DeleteInstanceRequest.newBuilder().setName(instanceName).build();

    // TODO: put instanceName in metadata
    get(instanceStub.deleteInstanceCallable().futureCall(request));
  }

  @Override
  public Paginated<Database> listDatabases(
      String instanceName, int pageSize, @Nullable String pageToken) throws SpannerException {
    ListDatabasesRequest.Builder requestBuilder =
        ListDatabasesRequest.newBuilder().setParent(instanceName).setPageSize(pageSize);
    if (pageToken != null) {
      requestBuilder.setPageToken(pageToken);
    }
    ListDatabasesRequest request = requestBuilder.build();
    
    // TODO: put instanceName in metadata
    ListDatabasesResponse response = get(databaseStub.listDatabasesCallable().futureCall(request));
    return new Paginated<>(response.getDatabasesList(), response.getNextPageToken());
  }

  @Override
  public Operation createDatabase(String instanceName, String createDatabaseStatement,
      Iterable<String> additionalStatements) throws SpannerException {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(instanceName)
            .setCreateStatement(createDatabaseStatement)
            .addAllExtraStatements(additionalStatements)
            .build();
    // TODO: put instanceName in metadata
    return get(databaseStub.createDatabaseCallable().futureCall(request));
  }

  @Override
  public Operation updateDatabaseDdl(String databaseName, Iterable<String> updateDatabaseStatements,
      @Nullable String updateId) throws SpannerException {
    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(databaseName)
            .addAllStatements(updateDatabaseStatements)
            .setOperationId(MoreObjects.firstNonNull(updateId, ""))
            .build();
    // TODO: put databaseName in metadata
    return get(databaseStub.updateDatabaseDdlCallable().futureCall(request));
  }

  @Override
  public void dropDatabase(String databaseName) throws SpannerException {
    DropDatabaseRequest request =
        DropDatabaseRequest.newBuilder().setDatabase(databaseName).build();
    
    // TODO: put databaseName in metadata
    get(databaseStub.dropDatabaseCallable().futureCall(request));
  }

  @Override
  public Database getDatabase(String databaseName) throws SpannerException {
    GetDatabaseRequest request = 
        GetDatabaseRequest.newBuilder()
        .setName(databaseName)
        .build();

    // TODO: put databaseName in metadata
    return get(databaseStub.getDatabaseCallable().futureCall(request));
  }

  @Override
  public List<String> getDatabaseDdl(String databaseName) throws SpannerException {
    GetDatabaseDdlRequest request = 
        GetDatabaseDdlRequest.newBuilder().setDatabase(databaseName).build();

    // TODO: put databaseName in metadata
    return get(databaseStub.getDatabaseDdlCallable().futureCall(request))
               .getStatementsList();
  }

  @Override
  public Operation getOperation(String name) throws SpannerException {
    GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    // TODO: put name in metadata
    return get(databaseStub.getOperationsStub().getOperationCallable().futureCall(request));
  }

  @Override
  public Session createSession(String databaseName, @Nullable Map<String, String> labels,
      @Nullable Map<Option, ?> options) throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public void deleteSession(String sessionName, @Nullable Map<Option, ?> options)
      throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public StreamingCall read(
      ReadRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public StreamingCall executeQuery(
      ExecuteSqlRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public Transaction beginTransaction(
      BeginTransactionRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public CommitResponse commit(CommitRequest commitRequest, @Nullable Map<Option, ?> options)
      throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public void rollback(RollbackRequest request, @Nullable Map<Option, ?> options)
      throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public PartitionResponse partitionQuery(
      PartitionQueryRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  @Override
  public PartitionResponse partitionRead(
      PartitionReadRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    // TODO(pongad): Figure out metadata
    // TODO(pongad): Figure out channel affinity
    return get(stub.partitionReadCallable().futureCall(request));
  }

  /** Gets the result of an async RPC call, handling any exceptions encountered. */
  private static <T> T get(final Future<T> future) throws SpannerException {
    final Context context = Context.current();
    try {
      return future.get();
    } catch (InterruptedException e) {
      // We are the sole consumer of the future, so cancel it.
      future.cancel(true);
      throw SpannerExceptionFactory.propagateInterrupt(e);
    } catch (ExecutionException | CancellationException e) {
      throw newSpannerException(context, e);
    }
  }
}
