/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.v1.stub;

import static com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Spanner service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSpannerStub extends SpannerStub {
  private static final MethodDescriptor<CreateSessionRequest, Session>
      createSessionMethodDescriptor =
          MethodDescriptor.<CreateSessionRequest, Session>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/CreateSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsMethodDescriptor =
          MethodDescriptor.<BatchCreateSessionsRequest, BatchCreateSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/BatchCreateSessions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateSessionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSessionRequest, Session> getSessionMethodDescriptor =
      MethodDescriptor.<GetSessionRequest, Session>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/GetSession")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSessionsRequest, ListSessionsResponse>
      listSessionsMethodDescriptor =
          MethodDescriptor.<ListSessionsRequest, ListSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/ListSessions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSessionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSessionRequest, Empty> deleteSessionMethodDescriptor =
      MethodDescriptor.<DeleteSessionRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/DeleteSession")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ExecuteSqlRequest, ResultSet> executeSqlMethodDescriptor =
      MethodDescriptor.<ExecuteSqlRequest, ResultSet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/ExecuteSql")
          .setRequestMarshaller(ProtoUtils.marshaller(ExecuteSqlRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ResultSet.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlMethodDescriptor =
          MethodDescriptor.<ExecuteSqlRequest, PartialResultSet>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.spanner.v1.Spanner/ExecuteStreamingSql")
              .setRequestMarshaller(ProtoUtils.marshaller(ExecuteSqlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PartialResultSet.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
      executeBatchDmlMethodDescriptor =
          MethodDescriptor.<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/ExecuteBatchDml")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExecuteBatchDmlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExecuteBatchDmlResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ReadRequest, ResultSet> readMethodDescriptor =
      MethodDescriptor.<ReadRequest, ResultSet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/Read")
          .setRequestMarshaller(ProtoUtils.marshaller(ReadRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ResultSet.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ReadRequest, PartialResultSet>
      streamingReadMethodDescriptor =
          MethodDescriptor.<ReadRequest, PartialResultSet>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.spanner.v1.Spanner/StreamingRead")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PartialResultSet.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BeginTransactionRequest, Transaction>
      beginTransactionMethodDescriptor =
          MethodDescriptor.<BeginTransactionRequest, Transaction>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/BeginTransaction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BeginTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Transaction.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      MethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/Commit")
          .setRequestMarshaller(ProtoUtils.marshaller(CommitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CommitResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RollbackRequest, Empty> rollbackMethodDescriptor =
      MethodDescriptor.<RollbackRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/Rollback")
          .setRequestMarshaller(ProtoUtils.marshaller(RollbackRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<PartitionQueryRequest, PartitionResponse>
      partitionQueryMethodDescriptor =
          MethodDescriptor.<PartitionQueryRequest, PartitionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/PartitionQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PartitionQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PartitionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PartitionReadRequest, PartitionResponse>
      partitionReadMethodDescriptor =
          MethodDescriptor.<PartitionReadRequest, PartitionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.v1.Spanner/PartitionRead")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PartitionReadRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PartitionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchWriteRequest, BatchWriteResponse>
      batchWriteMethodDescriptor =
          MethodDescriptor.<BatchWriteRequest, BatchWriteResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.spanner.v1.Spanner/BatchWrite")
              .setRequestMarshaller(ProtoUtils.marshaller(BatchWriteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BatchWriteResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateSessionRequest, Session> createSessionCallable;
  private final UnaryCallable<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsCallable;
  private final UnaryCallable<GetSessionRequest, Session> getSessionCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable;
  private final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable;
  private final UnaryCallable<ExecuteSqlRequest, ResultSet> executeSqlCallable;
  private final ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlCallable;
  private final UnaryCallable<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
      executeBatchDmlCallable;
  private final UnaryCallable<ReadRequest, ResultSet> readCallable;
  private final ServerStreamingCallable<ReadRequest, PartialResultSet> streamingReadCallable;
  private final UnaryCallable<BeginTransactionRequest, Transaction> beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, Empty> rollbackCallable;
  private final UnaryCallable<PartitionQueryRequest, PartitionResponse> partitionQueryCallable;
  private final UnaryCallable<PartitionReadRequest, PartitionResponse> partitionReadCallable;
  private final ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSpannerStub create(SpannerStubSettings settings) throws IOException {
    return new GrpcSpannerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSpannerStub create(ClientContext clientContext) throws IOException {
    return new GrpcSpannerStub(SpannerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSpannerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSpannerStub(
        SpannerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSpannerStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSpannerStub(SpannerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSpannerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSpannerStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSpannerStub(
      SpannerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSessionRequest, Session> createSessionTransportSettings =
        GrpcCallSettings.<CreateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(createSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDatabase())
            .build();
    GrpcCallSettings<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
        batchCreateSessionsTransportSettings =
            GrpcCallSettings.<BatchCreateSessionsRequest, BatchCreateSessionsResponse>newBuilder()
                .setMethodDescriptor(batchCreateSessionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getDatabase())
                .build();
    GrpcCallSettings<GetSessionRequest, Session> getSessionTransportSettings =
        GrpcCallSettings.<GetSessionRequest, Session>newBuilder()
            .setMethodDescriptor(getSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSessionsRequest, ListSessionsResponse> listSessionsTransportSettings =
        GrpcCallSettings.<ListSessionsRequest, ListSessionsResponse>newBuilder()
            .setMethodDescriptor(listSessionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDatabase())
            .build();
    GrpcCallSettings<DeleteSessionRequest, Empty> deleteSessionTransportSettings =
        GrpcCallSettings.<DeleteSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ExecuteSqlRequest, ResultSet> executeSqlTransportSettings =
        GrpcCallSettings.<ExecuteSqlRequest, ResultSet>newBuilder()
            .setMethodDescriptor(executeSqlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<ExecuteSqlRequest, PartialResultSet> executeStreamingSqlTransportSettings =
        GrpcCallSettings.<ExecuteSqlRequest, PartialResultSet>newBuilder()
            .setMethodDescriptor(executeStreamingSqlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>
        executeBatchDmlTransportSettings =
            GrpcCallSettings.<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse>newBuilder()
                .setMethodDescriptor(executeBatchDmlMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("session", String.valueOf(request.getSession()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getSession())
                .build();
    GrpcCallSettings<ReadRequest, ResultSet> readTransportSettings =
        GrpcCallSettings.<ReadRequest, ResultSet>newBuilder()
            .setMethodDescriptor(readMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<ReadRequest, PartialResultSet> streamingReadTransportSettings =
        GrpcCallSettings.<ReadRequest, PartialResultSet>newBuilder()
            .setMethodDescriptor(streamingReadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<BeginTransactionRequest, Transaction> beginTransactionTransportSettings =
        GrpcCallSettings.<BeginTransactionRequest, Transaction>newBuilder()
            .setMethodDescriptor(beginTransactionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        GrpcCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<RollbackRequest, Empty> rollbackTransportSettings =
        GrpcCallSettings.<RollbackRequest, Empty>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<PartitionQueryRequest, PartitionResponse> partitionQueryTransportSettings =
        GrpcCallSettings.<PartitionQueryRequest, PartitionResponse>newBuilder()
            .setMethodDescriptor(partitionQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<PartitionReadRequest, PartitionResponse> partitionReadTransportSettings =
        GrpcCallSettings.<PartitionReadRequest, PartitionResponse>newBuilder()
            .setMethodDescriptor(partitionReadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();
    GrpcCallSettings<BatchWriteRequest, BatchWriteResponse> batchWriteTransportSettings =
        GrpcCallSettings.<BatchWriteRequest, BatchWriteResponse>newBuilder()
            .setMethodDescriptor(batchWriteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getSession())
            .build();

    this.createSessionCallable =
        callableFactory.createUnaryCallable(
            createSessionTransportSettings, settings.createSessionSettings(), clientContext);
    this.batchCreateSessionsCallable =
        callableFactory.createUnaryCallable(
            batchCreateSessionsTransportSettings,
            settings.batchCreateSessionsSettings(),
            clientContext);
    this.getSessionCallable =
        callableFactory.createUnaryCallable(
            getSessionTransportSettings, settings.getSessionSettings(), clientContext);
    this.listSessionsCallable =
        callableFactory.createUnaryCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.deleteSessionCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTransportSettings, settings.deleteSessionSettings(), clientContext);
    this.executeSqlCallable =
        callableFactory.createUnaryCallable(
            executeSqlTransportSettings, settings.executeSqlSettings(), clientContext);
    this.executeStreamingSqlCallable =
        callableFactory.createServerStreamingCallable(
            executeStreamingSqlTransportSettings,
            settings.executeStreamingSqlSettings(),
            clientContext);
    this.executeBatchDmlCallable =
        callableFactory.createUnaryCallable(
            executeBatchDmlTransportSettings, settings.executeBatchDmlSettings(), clientContext);
    this.readCallable =
        callableFactory.createUnaryCallable(
            readTransportSettings, settings.readSettings(), clientContext);
    this.streamingReadCallable =
        callableFactory.createServerStreamingCallable(
            streamingReadTransportSettings, settings.streamingReadSettings(), clientContext);
    this.beginTransactionCallable =
        callableFactory.createUnaryCallable(
            beginTransactionTransportSettings, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        callableFactory.createUnaryCallable(
            commitTransportSettings, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        callableFactory.createUnaryCallable(
            rollbackTransportSettings, settings.rollbackSettings(), clientContext);
    this.partitionQueryCallable =
        callableFactory.createUnaryCallable(
            partitionQueryTransportSettings, settings.partitionQuerySettings(), clientContext);
    this.partitionReadCallable =
        callableFactory.createUnaryCallable(
            partitionReadTransportSettings, settings.partitionReadSettings(), clientContext);
    this.batchWriteCallable =
        callableFactory.createServerStreamingCallable(
            batchWriteTransportSettings, settings.batchWriteSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return createSessionCallable;
  }

  @Override
  public UnaryCallable<BatchCreateSessionsRequest, BatchCreateSessionsResponse>
      batchCreateSessionsCallable() {
    return batchCreateSessionsCallable;
  }

  @Override
  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return getSessionCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return listSessionsCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    return listSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return deleteSessionCallable;
  }

  @Override
  public UnaryCallable<ExecuteSqlRequest, ResultSet> executeSqlCallable() {
    return executeSqlCallable;
  }

  @Override
  public ServerStreamingCallable<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlCallable() {
    return executeStreamingSqlCallable;
  }

  @Override
  public UnaryCallable<ExecuteBatchDmlRequest, ExecuteBatchDmlResponse> executeBatchDmlCallable() {
    return executeBatchDmlCallable;
  }

  @Override
  public UnaryCallable<ReadRequest, ResultSet> readCallable() {
    return readCallable;
  }

  @Override
  public ServerStreamingCallable<ReadRequest, PartialResultSet> streamingReadCallable() {
    return streamingReadCallable;
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, Transaction> beginTransactionCallable() {
    return beginTransactionCallable;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return commitCallable;
  }

  @Override
  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return rollbackCallable;
  }

  @Override
  public UnaryCallable<PartitionQueryRequest, PartitionResponse> partitionQueryCallable() {
    return partitionQueryCallable;
  }

  @Override
  public UnaryCallable<PartitionReadRequest, PartitionResponse> partitionReadCallable() {
    return partitionReadCallable;
  }

  @Override
  public ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable() {
    return batchWriteCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
