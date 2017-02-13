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

package com.google.cloud.spanner.spi;

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;

import com.google.api.gax.protobuf.PathTemplate;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsGrpc;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceAdminGrpc;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.Transaction;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Context;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ClientResponseObserver;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/** Implementation of Cloud Spanner remote calls using gRPC. */
public class DefaultSpannerRpc implements SpannerRpc {
  private static final Logger logger = Logger.getLogger(DefaultSpannerRpc.class.getName());

  public static final String API_CLIENT =
      String.format(
          "google-cloud-java/%s",
          MoreObjects.firstNonNull(
              DefaultSpannerRpc.class.getPackage().getImplementationVersion(), ""));
  private static final Metadata.Key<String> API_CLIENT_KEY =
      Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> RESOURCE_PREFIX_KEY =
      Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);
  private static final Pattern DATABASE_PATTERN =
      Pattern.compile("^(?<database>projects/[^/]*/instances/[^/]*/databases/[^/]*)(.*)?");
  private static final Pattern INSTANCE_PATTERN =
      Pattern.compile("^(?<instance>projects/[^/]*/instances/[^/]*)(.*)?");
  private static final PathTemplate PROJECT_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");

  private final Random random = new Random();
  private final List<Channel> channels;
  private final String projectId;
  private final CallCredentials credentials;

  public DefaultSpannerRpc(SpannerOptions options) {
    this.projectId = options.getProjectId();
    this.credentials = callCredentials(options);
    ImmutableList.Builder<Channel> channelsBuilder = ImmutableList.builder();
    ImmutableList.Builder<SpannerGrpc.SpannerFutureStub> stubsBuilder = ImmutableList.builder();
    for (Channel channel : options.getRpcChannels()) {
      channel =
          ClientInterceptors.intercept(
              channel,
              new LoggingInterceptor(Level.FINER),
              WatchdogInterceptor.newDefaultWatchdogInterceptor(),
              new SpannerErrorInterceptor());
      channelsBuilder.add(channel);
      stubsBuilder.add(withCredentials(SpannerGrpc.newFutureStub(channel), credentials));
    }
    channels = channelsBuilder.build();
  }

  private static CallCredentials callCredentials(SpannerOptions options) {
    if (options.getCredentials() == null) {
      return null;
    }
    if (options.getCredentials().equals(NoCredentials.getInstance())) {
      return null;
    }
    return MoreCallCredentials.from(options.getScopedCredentials());
  }

  private <S extends AbstractStub<S>> S withCredentials(S stub, CallCredentials credentials) {
    if (credentials == null) {
      return stub;
    }
    return stub.withCallCredentials(credentials);
  }

  private String projectName() {
    return PROJECT_NAME_TEMPLATE.instantiate("project", projectId);
  }

  @Override
  public Paginated<InstanceConfig> listInstanceConfigs(int pageSize, @Nullable String pageToken)
      throws SpannerException {
    ListInstanceConfigsRequest.Builder request =
        ListInstanceConfigsRequest.newBuilder().setParent(projectName()).setPageSize(0);
    if (pageToken != null) {
      request.setPageToken(pageToken);
    }
    ListInstanceConfigsResponse response =
        get(
            doUnaryCall(
                InstanceAdminGrpc.METHOD_LIST_INSTANCE_CONFIGS,
                request.build(),
                projectName(),
                null));
    return new Paginated<>(response.getInstanceConfigsList(), response.getNextPageToken());
  }

  @Override
  public InstanceConfig getInstanceConfig(String instanceConfigName) throws SpannerException {
    GetInstanceConfigRequest request =
        GetInstanceConfigRequest.newBuilder().setName(instanceConfigName).build();
    return get(
        doUnaryCall(InstanceAdminGrpc.METHOD_GET_INSTANCE_CONFIG, request, projectName(), null));
  }

  @Override
  public Paginated<Instance> listInstances(
      int pageSize, @Nullable String pageToken, @Nullable String filter) throws SpannerException {
    ListInstancesRequest.Builder request =
        ListInstancesRequest.newBuilder().setParent(projectName()).setPageSize(pageSize);
    if (pageToken != null) {
      request.setPageToken(pageToken);
    }
    if (filter != null) {
      request.setFilter(filter);
    }
    ListInstancesResponse response =
        get(
            doUnaryCall(
                InstanceAdminGrpc.METHOD_LIST_INSTANCES, request.build(), projectName(), null));
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
    return get(doUnaryCall(InstanceAdminGrpc.METHOD_CREATE_INSTANCE, request, parent, null));
  }

  @Override
  public Operation updateInstance(Instance instance, FieldMask fieldMask) throws SpannerException {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setFieldMask(fieldMask).build();
    return get(
        doUnaryCall(InstanceAdminGrpc.METHOD_UPDATE_INSTANCE, request, instance.getName(), null));
  }

  @Override
  public Instance getInstance(String instanceName) throws SpannerException {
    return get(
        doUnaryCall(
            InstanceAdminGrpc.METHOD_GET_INSTANCE,
            GetInstanceRequest.newBuilder().setName(instanceName).build(),
            instanceName,
            null));
  }

  @Override
  public void deleteInstance(String instanceName) throws SpannerException {
    get(
        doUnaryCall(
            InstanceAdminGrpc.METHOD_DELETE_INSTANCE,
            DeleteInstanceRequest.newBuilder().setName(instanceName).build(),
            instanceName,
            null));
  }

  @Override
  public Paginated<Database> listDatabases(
      String instanceName, int pageSize, @Nullable String pageToken) throws SpannerException {
    ListDatabasesRequest.Builder builder =
        ListDatabasesRequest.newBuilder().setParent(instanceName).setPageSize(pageSize);
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    com.google.spanner.admin.database.v1.ListDatabasesResponse response =
        get(
            doUnaryCall(
                DatabaseAdminGrpc.METHOD_LIST_DATABASES, builder.build(), instanceName, null));
    return new Paginated<>(response.getDatabasesList(), response.getNextPageToken());
  }

  @Override
  public Operation createDatabase(
      String instanceName, String createDatabaseStatement, Iterable<String> additionalStatements)
      throws SpannerException {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(instanceName)
            .setCreateStatement(createDatabaseStatement)
            .addAllExtraStatements(additionalStatements)
            .build();
    return get(doUnaryCall(DatabaseAdminGrpc.METHOD_CREATE_DATABASE, request, instanceName, null));
  }

  @Override
  public Operation updateDatabaseDdl(
      String databaseName, Iterable<String> updateStatements, @Nullable String operationId)
      throws SpannerException {
    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(databaseName)
            .addAllStatements(updateStatements)
            .setOperationId(MoreObjects.firstNonNull(operationId, ""))
            .build();
    return get(
        doUnaryCall(DatabaseAdminGrpc.METHOD_UPDATE_DATABASE_DDL, request, databaseName, null));
  }

  @Override
  public void dropDatabase(String databaseName) throws SpannerException {
    get(
        doUnaryCall(
            DatabaseAdminGrpc.METHOD_DROP_DATABASE,
            DropDatabaseRequest.newBuilder().setDatabase(databaseName).build(),
            databaseName,
            null));
  }

  @Override
  public List<String> getDatabaseDdl(String databaseName) throws SpannerException {
    GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder().setDatabase(databaseName).build();
    return get(doUnaryCall(DatabaseAdminGrpc.METHOD_GET_DATABASE_DDL, request, databaseName, null))
        .getStatementsList();
  }

  @Override
  public Database getDatabase(String databaseName) throws SpannerException {
    return get(
        doUnaryCall(
            DatabaseAdminGrpc.METHOD_GET_DATABASE,
            GetDatabaseRequest.newBuilder().setName(databaseName).build(),
            databaseName,
            null));
  }

  @Override
  public Operation getOperation(String name) throws SpannerException {
    GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    return get(doUnaryCall(OperationsGrpc.METHOD_GET_OPERATION, request, name, null));
  }

  @Override
  public com.google.spanner.v1.Session createSession(
      String databaseName, @Nullable Map<Option, ?> options) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder().setDatabase(databaseName).build();
    return get(
        doUnaryCall(
            SpannerGrpc.METHOD_CREATE_SESSION,
            request,
            databaseName,
            Option.CHANNEL_HINT.getLong(options)));
  }

  @Override
  public void deleteSession(String sessionName, @Nullable Map<Option, ?> options) {
    DeleteSessionRequest request = DeleteSessionRequest.newBuilder().setName(sessionName).build();
    get(
        doUnaryCall(
            SpannerGrpc.METHOD_DELETE_SESSION,
            request,
            sessionName,
            Option.CHANNEL_HINT.getLong(options)));
  }

  @Override
  public StreamingCall read(
      ReadRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
    return doStreamingCall(
        SpannerGrpc.METHOD_STREAMING_READ,
        request,
        consumer,
        request.getSession(),
        Option.CHANNEL_HINT.getLong(options));
  }

  @Override
  public StreamingCall executeQuery(
      ExecuteSqlRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options) {
    return doStreamingCall(
        SpannerGrpc.METHOD_EXECUTE_STREAMING_SQL,
        request,
        consumer,
        request.getSession(),
        Option.CHANNEL_HINT.getLong(options));
  }

  @Override
  public Transaction beginTransaction(
      BeginTransactionRequest request, @Nullable Map<Option, ?> options) {
    return get(
        doUnaryCall(
            SpannerGrpc.METHOD_BEGIN_TRANSACTION,
            request,
            request.getSession(),
            Option.CHANNEL_HINT.getLong(options)));
  }

  @Override
  public CommitResponse commit(CommitRequest commitRequest, @Nullable Map<Option, ?> options) {
    return get(
        doUnaryCall(
            SpannerGrpc.METHOD_COMMIT,
            commitRequest,
            commitRequest.getSession(),
            Option.CHANNEL_HINT.getLong(options)));
  }

  @Override
  public void rollback(RollbackRequest request, @Nullable Map<Option, ?> options) {
    get(
        doUnaryCall(
            SpannerGrpc.METHOD_ROLLBACK,
            request,
            request.getSession(),
            Option.CHANNEL_HINT.getLong(options)));
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

  private <ReqT, RespT> Future<RespT> doUnaryCall(
      MethodDescriptor<ReqT, RespT> method,
      ReqT request,
      @Nullable String resource,
      @Nullable Long channelHint) {
    CallOptions callOptions =
        credentials == null
            ? CallOptions.DEFAULT
            : CallOptions.DEFAULT.withCallCredentials(credentials);
    final ClientCall<ReqT, RespT> call =
        new MetadataClientCall<>(
            pick(channelHint, channels).newCall(method, callOptions), newMetadata(resource));
    return ClientCalls.futureUnaryCall(call, request);
  }

  private <T> StreamingCall doStreamingCall(
      MethodDescriptor<T, PartialResultSet> method,
      T request,
      ResultStreamConsumer consumer,
      @Nullable String resource,
      @Nullable Long channelHint) {
    final Context context = Context.current();
    // TODO: Add deadline based on context.
    CallOptions callOptions =
        credentials == null
            ? CallOptions.DEFAULT
            : CallOptions.DEFAULT.withCallCredentials(credentials);
    final ClientCall<T, PartialResultSet> call =
        new MetadataClientCall<>(
            pick(channelHint, channels).newCall(method, callOptions), newMetadata(resource));
    ResultSetStreamObserver<T> observer = new ResultSetStreamObserver<T>(consumer, context, call);
    ClientCalls.asyncServerStreamingCall(call, request, observer);
    return observer;
  }

  @VisibleForTesting
  static class MetadataClientCall<ReqT, RespT>
      extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
    private final Metadata extraMetadata;

    MetadataClientCall(ClientCall<ReqT, RespT> call, Metadata extraMetadata) {
      super(call);
      this.extraMetadata = extraMetadata;
    }

    @Override
    public void start(Listener<RespT> responseListener, Metadata metadata) {
      metadata.merge(extraMetadata);
      super.start(responseListener, metadata);
    }
  }

  private Metadata newMetadata(String resource) {
    Metadata metadata = new Metadata();
    metadata.put(RESOURCE_PREFIX_KEY, extractHeader(resource));
    metadata.put(API_CLIENT_KEY, API_CLIENT);
    return metadata;
  }

  @VisibleForTesting
  String extractHeader(String resource) {
    Matcher m = DATABASE_PATTERN.matcher(resource);
    if (m.matches()) {
      return m.group("database");
    }
    m = INSTANCE_PATTERN.matcher(resource);
    return m.matches() ? m.group("instance") : projectName();
  }

  private <T> T pick(@Nullable Long hint, List<T> elements) {
    long hintVal = Math.abs(hint != null ? hint : random.nextLong());
    long index = hintVal % elements.size();
    return elements.get((int) index);
  }

  private static class ResultSetStreamObserver<T>
      implements ClientResponseObserver<T, PartialResultSet>, StreamingCall {
    private final ResultStreamConsumer consumer;
    private final Context context;
    private final ClientCall<T, PartialResultSet> call;
    private volatile ClientCallStreamObserver<T> requestStream;

    public ResultSetStreamObserver(
        ResultStreamConsumer consumer, Context context, ClientCall<T, PartialResultSet> call) {
      this.consumer = consumer;
      this.context = context;
      this.call = call;
    }

    @Override
    public void beforeStart(final ClientCallStreamObserver<T> requestStream) {
      this.requestStream = requestStream;
      requestStream.disableAutoInboundFlowControl();
    }

    @Override
    public void onNext(PartialResultSet value) {
      consumer.onPartialResultSet(value);
    }

    @Override
    public void onError(Throwable t) {
      consumer.onError(newSpannerException(context, t));
    }

    @Override
    public void onCompleted() {
      consumer.onCompleted();
    }

    @Override
    public void request(int numMessages) {
      requestStream.request(numMessages);
    }

    @Override
    public void cancel(@Nullable String message) {
      call.cancel(message, null);
    }
  }

  private static class LoggingInterceptor implements ClientInterceptor {
    private final Level level;

    LoggingInterceptor(Level level) {
      this.level = level;
    }

    private class CallLogger {
      private final MethodDescriptor<?, ?> method;

      CallLogger(MethodDescriptor<?, ?> method) {
        this.method = method;
      }

      void log(String message) {
        logger.log(
            level,
            "{0}[{1}]: {2}",
            new Object[] {
              method.getFullMethodName(),
              Integer.toHexString(System.identityHashCode(this)),
              message
            });
      }

      void logfmt(String message, Object... params) {
        log(String.format(message, params));
      }
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      if (!logger.isLoggable(level)) {
        return next.newCall(method, callOptions);
      }

      final CallLogger callLogger = new CallLogger(method);
      callLogger.log("Start");
      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
          next.newCall(method, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                  responseListener) {
                @Override
                public void onMessage(RespT message) {
                  callLogger.logfmt("Received:\n%s", message);
                  super.onMessage(message);
                }

                @Override
                public void onClose(Status status, Metadata trailers) {
                  callLogger.logfmt("Closed with status %s and trailers %s", status, trailers);
                  super.onClose(status, trailers);
                }
              },
              headers);
        }

        @Override
        public void sendMessage(ReqT message) {
          callLogger.logfmt("Send:\n%s", message);
          super.sendMessage(message);
        }

        @Override
        public void cancel(@Nullable String message, @Nullable Throwable cause) {
          callLogger.logfmt("Cancelled with message %s", message);
          super.cancel(message, cause);
        }
      };
    }
  }
}
