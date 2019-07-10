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

import com.google.api.core.NanoClock;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.InstantiatingWatchdogProvider;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.WatchdogProvider;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.ServiceOptions;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStub;
import com.google.cloud.spanner.admin.database.v1.stub.GrpcDatabaseAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.GrpcInstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStub;
import com.google.cloud.spanner.v1.stub.GrpcSpannerStub;
import com.google.cloud.spanner.v1.stub.SpannerStub;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
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
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import io.grpc.Context;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/** Implementation of Cloud Spanner remote calls using Gapic libraries. */
public class GapicSpannerRpc implements SpannerRpc {
  /**
   * {@link ExecutorProvider} that keeps track of the executors that are created and shuts these
   * down when the {@link SpannerRpc} is closed.
   */
  private static final class ManagedInstantiatingExecutorProvider implements ExecutorProvider {
    private static final int DEFAULT_THREAD_COUNT = 4;
    private final List<ScheduledExecutorService> executors = new LinkedList<>();
    private final ThreadFactory threadFactory;

    private ManagedInstantiatingExecutorProvider(ThreadFactory threadFactory) {
      this.threadFactory = threadFactory;
    }

    @Override
    public boolean shouldAutoClose() {
      return false;
    }

    @Override
    public ScheduledExecutorService getExecutor() {
      ScheduledExecutorService executor =
          new ScheduledThreadPoolExecutor(DEFAULT_THREAD_COUNT, threadFactory);
      synchronized (this) {
        executors.add(executor);
      }
      return executor;
    }

    /** Shuts down all executors that have been created by this {@link ExecutorProvider}. */
    private synchronized void shutdown() {
      for (ScheduledExecutorService executor : executors) {
        executor.shutdown();
      }
    }
  }

  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate OPERATION_NAME_TEMPLATE =
      PathTemplate.create("{database=projects/*/instances/*/databases/*}/operations/{operation}");
  private static final int MAX_MESSAGE_SIZE = 100 * 1024 * 1024;
  private static final int MAX_METADATA_SIZE = 32 * 1024; // bytes
  private static final String PROPERTY_TIMEOUT_SECONDS =
      "com.google.cloud.spanner.watchdogTimeoutSeconds";
  private static final String PROPERTY_PERIOD_SECONDS =
      "com.google.cloud.spanner.watchdogPeriodSeconds";
  private static final int DEFAULT_TIMEOUT_SECONDS = 30 * 60;
  private static final int DEFAULT_PERIOD_SECONDS = 10;

  private final ManagedInstantiatingExecutorProvider executorProvider;
  private boolean rpcIsClosed;
  private final SpannerStub spannerStub;
  private final InstanceAdminStub instanceAdminStub;
  private final DatabaseAdminStub databaseAdminStub;
  private final String projectId;
  private final String projectName;
  private final SpannerMetadataProvider metadataProvider;
  private final Duration waitTimeout =
      systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
  private final Duration idleTimeout =
      systemProperty(PROPERTY_TIMEOUT_SECONDS, DEFAULT_TIMEOUT_SECONDS);
  private final Duration checkInterval =
      systemProperty(PROPERTY_PERIOD_SECONDS, DEFAULT_PERIOD_SECONDS);

  private final ScheduledExecutorService spannerWatchdog;

  public static GapicSpannerRpc create(SpannerOptions options) {
    return new GapicSpannerRpc(options);
  }

  public GapicSpannerRpc(final SpannerOptions options) {
    this.projectId = options.getProjectId();
    this.projectName = PROJECT_NAME_TEMPLATE.instantiate("project", this.projectId);

    // create a metadataProvider which combines both internal headers and
    // per-method-call extra headers for channelProvider to inject the headers
    // for rpc calls
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

    // Create a managed executor provider.
    this.executorProvider =
        new ManagedInstantiatingExecutorProvider(
            new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat("Cloud-Spanner-TransportChannel-%d")
                .build());
    // First check if SpannerOptions provides a TransportChannerProvider. Create one
    // with information gathered from SpannerOptions if none is provided
    TransportChannelProvider channelProvider =
        MoreObjects.firstNonNull(
            options.getChannelProvider(),
            InstantiatingGrpcChannelProvider.newBuilder()
                .setChannelConfigurator(options.getChannelConfigurator())
                .setEndpoint(options.getEndpoint())
                .setMaxInboundMessageSize(MAX_MESSAGE_SIZE)
                .setMaxInboundMetadataSize(MAX_METADATA_SIZE)
                .setPoolSize(options.getNumChannels())
                .setExecutorProvider(executorProvider)

                // Then check if SpannerOptions provides an InterceptorProvider. Create a default
                // SpannerInterceptorProvider if none is provided
                .setInterceptorProvider(
                    MoreObjects.firstNonNull(
                        options.getInterceptorProvider(),
                        SpannerInterceptorProvider.createDefault()))
                .setHeaderProvider(mergedHeaderProvider)
                .build());

    CredentialsProvider credentialsProvider =
        GrpcTransportOptions.setUpCredentialsProvider(options);

    spannerWatchdog =
        Executors.newSingleThreadScheduledExecutor(
            new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat("Cloud-Spanner-WatchdogProvider-%d")
                .build());
    WatchdogProvider watchdogProvider =
        InstantiatingWatchdogProvider.create()
            .withExecutor(spannerWatchdog)
            .withCheckInterval(checkInterval)
            .withClock(NanoClock.getDefaultClock());

    try {
      this.spannerStub =
          GrpcSpannerStub.create(
              options
                  .getSpannerStubSettings()
                  .toBuilder()
                  .setTransportChannelProvider(channelProvider)
                  .setCredentialsProvider(credentialsProvider)
                  .setStreamWatchdogProvider(watchdogProvider)
                  .build());

      this.instanceAdminStub =
          GrpcInstanceAdminStub.create(
              options
                  .getInstanceAdminStubSettings()
                  .toBuilder()
                  .setTransportChannelProvider(channelProvider)
                  .setCredentialsProvider(credentialsProvider)
                  .setStreamWatchdogProvider(watchdogProvider)
                  .build());

      this.databaseAdminStub =
          GrpcDatabaseAdminStub.create(
              options
                  .getDatabaseAdminStubSettings()
                  .toBuilder()
                  .setTransportChannelProvider(channelProvider)
                  .setCredentialsProvider(credentialsProvider)
                  .setStreamWatchdogProvider(watchdogProvider)
                  .build());
    } catch (Exception e) {
      throw newSpannerException(e);
    }
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

    GrpcCallContext context = newCallContext(null, projectName);
    ListInstanceConfigsResponse response =
        get(instanceAdminStub.listInstanceConfigsCallable().futureCall(request, context));
    return new Paginated<>(response.getInstanceConfigsList(), response.getNextPageToken());
  }

  @Override
  public InstanceConfig getInstanceConfig(String instanceConfigName) throws SpannerException {
    GetInstanceConfigRequest request =
        GetInstanceConfigRequest.newBuilder().setName(instanceConfigName).build();

    GrpcCallContext context = newCallContext(null, projectName);
    return get(instanceAdminStub.getInstanceConfigCallable().futureCall(request, context));
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

    GrpcCallContext context = newCallContext(null, projectName);
    ListInstancesResponse response =
        get(instanceAdminStub.listInstancesCallable().futureCall(request, context));
    return new Paginated<>(response.getInstancesList(), response.getNextPageToken());
  }

  @Override
  public OperationFuture<Instance, CreateInstanceMetadata> createInstance(
      String parent, String instanceId, Instance instance) throws SpannerException {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .build();
    GrpcCallContext context = newCallContext(null, parent);
    return instanceAdminStub.createInstanceOperationCallable().futureCall(request, context);
  }

  @Override
  public OperationFuture<Instance, UpdateInstanceMetadata> updateInstance(
      Instance instance, FieldMask fieldMask) throws SpannerException {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setFieldMask(fieldMask).build();
    GrpcCallContext context = newCallContext(null, instance.getName());
    return instanceAdminStub.updateInstanceOperationCallable().futureCall(request, context);
  }

  @Override
  public Instance getInstance(String instanceName) throws SpannerException {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(instanceName).build();

    GrpcCallContext context = newCallContext(null, instanceName);
    return get(instanceAdminStub.getInstanceCallable().futureCall(request, context));
  }

  @Override
  public void deleteInstance(String instanceName) throws SpannerException {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(instanceName).build();

    GrpcCallContext context = newCallContext(null, instanceName);
    get(instanceAdminStub.deleteInstanceCallable().futureCall(request, context));
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

    GrpcCallContext context = newCallContext(null, instanceName);
    ListDatabasesResponse response =
        get(databaseAdminStub.listDatabasesCallable().futureCall(request, context));
    return new Paginated<>(response.getDatabasesList(), response.getNextPageToken());
  }

  @Override
  public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      String instanceName, String createDatabaseStatement, Iterable<String> additionalStatements)
      throws SpannerException {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(instanceName)
            .setCreateStatement(createDatabaseStatement)
            .addAllExtraStatements(additionalStatements)
            .build();
    GrpcCallContext context = newCallContext(null, instanceName);
    return databaseAdminStub.createDatabaseOperationCallable().futureCall(request, context);
  }

  @Override
  public OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
      String databaseName, Iterable<String> updateDatabaseStatements, @Nullable String updateId)
      throws SpannerException {
    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(databaseName)
            .addAllStatements(updateDatabaseStatements)
            .setOperationId(MoreObjects.firstNonNull(updateId, ""))
            .build();
    GrpcCallContext context = newCallContext(null, databaseName);
    OperationCallable<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata> callable =
        databaseAdminStub.updateDatabaseDdlOperationCallable();
    OperationFuture<Empty, UpdateDatabaseDdlMetadata> operationFuture =
        callable.futureCall(request, context);
    try {
      operationFuture.getInitialFuture().get();
    } catch (InterruptedException e) {
      throw newSpannerException(e);
    } catch (ExecutionException e) {
      Throwable t = e.getCause();
      if (t instanceof AlreadyExistsException) {
        String operationName =
            OPERATION_NAME_TEMPLATE.instantiate("database", databaseName, "operation", updateId);
        return callable.resumeFutureCall(operationName, context);
      }
    }
    return operationFuture;
  }

  @Override
  public void dropDatabase(String databaseName) throws SpannerException {
    DropDatabaseRequest request =
        DropDatabaseRequest.newBuilder().setDatabase(databaseName).build();

    GrpcCallContext context = newCallContext(null, databaseName);
    get(databaseAdminStub.dropDatabaseCallable().futureCall(request, context));
  }

  @Override
  public Database getDatabase(String databaseName) throws SpannerException {
    GetDatabaseRequest request = GetDatabaseRequest.newBuilder().setName(databaseName).build();

    GrpcCallContext context = newCallContext(null, databaseName);
    return get(databaseAdminStub.getDatabaseCallable().futureCall(request, context));
  }

  @Override
  public List<String> getDatabaseDdl(String databaseName) throws SpannerException {
    GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder().setDatabase(databaseName).build();

    GrpcCallContext context = newCallContext(null, databaseName);
    return get(databaseAdminStub.getDatabaseDdlCallable().futureCall(request, context))
        .getStatementsList();
  }

  @Override
  public Operation getOperation(String name) throws SpannerException {
    GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    GrpcCallContext context = newCallContext(null, name);
    return get(
        databaseAdminStub.getOperationsStub().getOperationCallable().futureCall(request, context));
  }

  @Override
  public Session createSession(
      String databaseName, @Nullable Map<String, String> labels, @Nullable Map<Option, ?> options)
      throws SpannerException {
    CreateSessionRequest.Builder requestBuilder =
        CreateSessionRequest.newBuilder().setDatabase(databaseName);
    if (labels != null && !labels.isEmpty()) {
      Session.Builder session = Session.newBuilder().putAllLabels(labels);
      requestBuilder.setSession(session);
    }
    CreateSessionRequest request = requestBuilder.build();
    GrpcCallContext context = newCallContext(options, databaseName);
    return get(spannerStub.createSessionCallable().futureCall(request, context));
  }

  @Override
  public void deleteSession(String sessionName, @Nullable Map<Option, ?> options)
      throws SpannerException {
    DeleteSessionRequest request = DeleteSessionRequest.newBuilder().setName(sessionName).build();
    GrpcCallContext context = newCallContext(options, sessionName);
    get(spannerStub.deleteSessionCallable().futureCall(request, context));
  }

  @Override
  public StreamingCall read(
      ReadRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
    GrpcCallContext context = newCallContext(options, request.getSession());
    SpannerResponseObserver responseObserver = new SpannerResponseObserver(consumer);
    spannerStub.streamingReadCallable().call(request, responseObserver, context);
    final StreamController controller = responseObserver.getController();
    return new StreamingCall() {
      @Override
      public void request(int numMessage) {
        controller.request(numMessage);
      }

      // TODO(hzyi): streamController currently does not support cancel with message. Add
      // this in gax and update this method later
      @Override
      public void cancel(String message) {
        controller.cancel();
      }
    };
  }

  @Override
  public ResultSet executeQuery(ExecuteSqlRequest request, @Nullable Map<Option, ?> options) {
    GrpcCallContext context = newCallContext(options, request.getSession());
    return get(spannerStub.executeSqlCallable().futureCall(request, context));
  }

  @Override
  public ResultSet executePartitionedDml(
      ExecuteSqlRequest request, @Nullable Map<Option, ?> options, Duration timeout) {
    GrpcCallContext context = newCallContext(options, request.getSession(), timeout);
    return get(spannerStub.executeSqlCallable().futureCall(request, context));
  }

  @Override
  public StreamingCall executeQuery(
      ExecuteSqlRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
    GrpcCallContext context = newCallContext(options, request.getSession());
    SpannerResponseObserver responseObserver = new SpannerResponseObserver(consumer);
    spannerStub.executeStreamingSqlCallable().call(request, responseObserver, context);
    final StreamController controller = responseObserver.getController();
    return new StreamingCall() {
      @Override
      public void request(int numMessage) {
        controller.request(numMessage);
      }

      // TODO(hzyi): streamController currently does not support cancel with message. Add
      // this in gax and update this method later
      @Override
      public void cancel(String message) {
        controller.cancel();
      }
    };
  }

  @Override
  public ExecuteBatchDmlResponse executeBatchDml(
      ExecuteBatchDmlRequest request, @Nullable Map<Option, ?> options) {

    GrpcCallContext context = newCallContext(options, request.getSession());
    return get(spannerStub.executeBatchDmlCallable().futureCall(request, context));
  }

  @Override
  public Transaction beginTransaction(
      BeginTransactionRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    GrpcCallContext context = newCallContext(options, request.getSession());
    return get(spannerStub.beginTransactionCallable().futureCall(request, context));
  }

  @Override
  public CommitResponse commit(CommitRequest commitRequest, @Nullable Map<Option, ?> options)
      throws SpannerException {
    GrpcCallContext context = newCallContext(options, commitRequest.getSession());
    return get(spannerStub.commitCallable().futureCall(commitRequest, context));
  }

  @Override
  public void rollback(RollbackRequest request, @Nullable Map<Option, ?> options)
      throws SpannerException {
    GrpcCallContext context = newCallContext(options, request.getSession());
    get(spannerStub.rollbackCallable().futureCall(request, context));
  }

  @Override
  public PartitionResponse partitionQuery(
      PartitionQueryRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    GrpcCallContext context = newCallContext(options, request.getSession());
    return get(spannerStub.partitionQueryCallable().futureCall(request, context));
  }

  @Override
  public PartitionResponse partitionRead(
      PartitionReadRequest request, @Nullable Map<Option, ?> options) throws SpannerException {
    GrpcCallContext context = newCallContext(options, request.getSession());
    return get(spannerStub.partitionReadCallable().futureCall(request, context));
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
    } catch (Exception e) {
      throw newSpannerException(context, e);
    }
  }

  private GrpcCallContext newCallContext(@Nullable Map<Option, ?> options, String resource) {
    return newCallContext(options, resource, null);
  }

  private GrpcCallContext newCallContext(
      @Nullable Map<Option, ?> options, String resource, Duration timeout) {
    GrpcCallContext context = GrpcCallContext.createDefault();
    if (options != null) {
      context = context.withChannelAffinity(Option.CHANNEL_HINT.getLong(options).intValue());
    }
    context = context.withExtraHeaders(metadataProvider.newExtraHeaders(resource, projectName));
    if (timeout != null) {
      context = context.withTimeout(timeout);
    }
    return context.withStreamWaitTimeout(waitTimeout).withStreamIdleTimeout(idleTimeout);
  }

  @Override
  public void shutdown() {
    this.rpcIsClosed = true;
    this.spannerStub.close();
    this.instanceAdminStub.close();
    this.databaseAdminStub.close();
    this.spannerWatchdog.shutdown();
    this.executorProvider.shutdown();
  }

  @Override
  public boolean isClosed() {
    return rpcIsClosed;
  }

  /**
   * A {@code ResponseObserver} that exposes the {@code StreamController} and delegates callbacks to
   * the {@link ResultStreamConsumer}.
   */
  private static class SpannerResponseObserver implements ResponseObserver<PartialResultSet> {
    private StreamController controller;
    private final ResultStreamConsumer consumer;

    public SpannerResponseObserver(ResultStreamConsumer consumer) {
      this.consumer = consumer;
    }

    @Override
    public void onStart(StreamController controller) {

      // Disable the auto flow control to allow client library
      // set the number of messages it prefers to request
      controller.disableAutoInboundFlowControl();
      this.controller = controller;
    }

    @Override
    public void onResponse(PartialResultSet response) {
      consumer.onPartialResultSet(response);
    }

    @Override
    public void onError(Throwable t) {
      consumer.onError(newSpannerException(t));
    }

    @Override
    public void onComplete() {
      consumer.onCompleted();
    }

    StreamController getController() {
      return Preconditions.checkNotNull(this.controller);
    }
  }

  private static Duration systemProperty(String name, int defaultValue) {
    String stringValue = System.getProperty(name, "");
    return Duration.ofSeconds(stringValue.isEmpty() ? defaultValue : Integer.parseInt(stringValue));
  }
}
