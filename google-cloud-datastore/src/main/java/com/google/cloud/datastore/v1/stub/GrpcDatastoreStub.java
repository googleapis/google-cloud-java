/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.datastore.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Datastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDatastoreStub extends DatastoreStub {
  private static final MethodDescriptor<LookupRequest, LookupResponse> lookupMethodDescriptor =
      MethodDescriptor.<LookupRequest, LookupResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.datastore.v1.Datastore/Lookup")
          .setRequestMarshaller(ProtoUtils.marshaller(LookupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LookupResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RunQueryRequest, RunQueryResponse>
      runQueryMethodDescriptor =
          MethodDescriptor.<RunQueryRequest, RunQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.datastore.v1.Datastore/RunQuery")
              .setRequestMarshaller(ProtoUtils.marshaller(RunQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RunQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryMethodDescriptor =
          MethodDescriptor.<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.datastore.v1.Datastore/RunAggregationQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunAggregationQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunAggregationQueryResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionMethodDescriptor =
          MethodDescriptor.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.datastore.v1.Datastore/BeginTransaction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BeginTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BeginTransactionResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      MethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.datastore.v1.Datastore/Commit")
          .setRequestMarshaller(ProtoUtils.marshaller(CommitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CommitResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RollbackRequest, RollbackResponse>
      rollbackMethodDescriptor =
          MethodDescriptor.<RollbackRequest, RollbackResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.datastore.v1.Datastore/Rollback")
              .setRequestMarshaller(ProtoUtils.marshaller(RollbackRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RollbackResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AllocateIdsRequest, AllocateIdsResponse>
      allocateIdsMethodDescriptor =
          MethodDescriptor.<AllocateIdsRequest, AllocateIdsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.datastore.v1.Datastore/AllocateIds")
              .setRequestMarshaller(ProtoUtils.marshaller(AllocateIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AllocateIdsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ReserveIdsRequest, ReserveIdsResponse>
      reserveIdsMethodDescriptor =
          MethodDescriptor.<ReserveIdsRequest, ReserveIdsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.datastore.v1.Datastore/ReserveIds")
              .setRequestMarshaller(ProtoUtils.marshaller(ReserveIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReserveIdsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<LookupRequest, LookupResponse> lookupCallable;
  private final UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable;
  private final UnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable;
  private final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable;
  private final UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable;
  private final UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate LOOKUP_0_PATH_TEMPLATE = PathTemplate.create("{project_id=**}");
  private static final PathTemplate LOOKUP_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate RUN_QUERY_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate RUN_QUERY_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate RUN_AGGREGATION_QUERY_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate RUN_AGGREGATION_QUERY_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate BEGIN_TRANSACTION_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate BEGIN_TRANSACTION_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate COMMIT_0_PATH_TEMPLATE = PathTemplate.create("{project_id=**}");
  private static final PathTemplate COMMIT_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate ROLLBACK_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate ROLLBACK_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate ALLOCATE_IDS_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate ALLOCATE_IDS_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate RESERVE_IDS_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate RESERVE_IDS_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");

  public static final GrpcDatastoreStub create(DatastoreStubSettings settings) throws IOException {
    return new GrpcDatastoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDatastoreStub create(ClientContext clientContext) throws IOException {
    return new GrpcDatastoreStub(DatastoreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDatastoreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDatastoreStub(
        DatastoreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDatastoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatastoreStub(DatastoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDatastoreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDatastoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatastoreStub(
      DatastoreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<LookupRequest, LookupResponse> lookupTransportSettings =
        GrpcCallSettings.<LookupRequest, LookupResponse>newBuilder()
            .setMethodDescriptor(lookupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", LOOKUP_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", LOOKUP_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RunQueryRequest, RunQueryResponse> runQueryTransportSettings =
        GrpcCallSettings.<RunQueryRequest, RunQueryResponse>newBuilder()
            .setMethodDescriptor(runQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", RUN_QUERY_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", RUN_QUERY_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQueryTransportSettings =
            GrpcCallSettings.<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
                .setMethodDescriptor(runAggregationQueryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getProjectId(),
                          "project_id",
                          RUN_AGGREGATION_QUERY_0_PATH_TEMPLATE);
                      builder.add(
                          request.getDatabaseId(),
                          "database_id",
                          RUN_AGGREGATION_QUERY_1_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionTransportSettings =
            GrpcCallSettings.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
                .setMethodDescriptor(beginTransactionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getProjectId(), "project_id", BEGIN_TRANSACTION_0_PATH_TEMPLATE);
                      builder.add(
                          request.getDatabaseId(),
                          "database_id",
                          BEGIN_TRANSACTION_1_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        GrpcCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", COMMIT_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", COMMIT_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RollbackRequest, RollbackResponse> rollbackTransportSettings =
        GrpcCallSettings.<RollbackRequest, RollbackResponse>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", ROLLBACK_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", ROLLBACK_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AllocateIdsRequest, AllocateIdsResponse> allocateIdsTransportSettings =
        GrpcCallSettings.<AllocateIdsRequest, AllocateIdsResponse>newBuilder()
            .setMethodDescriptor(allocateIdsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", ALLOCATE_IDS_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", ALLOCATE_IDS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReserveIdsRequest, ReserveIdsResponse> reserveIdsTransportSettings =
        GrpcCallSettings.<ReserveIdsRequest, ReserveIdsResponse>newBuilder()
            .setMethodDescriptor(reserveIdsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", RESERVE_IDS_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", RESERVE_IDS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();

    this.lookupCallable =
        callableFactory.createUnaryCallable(
            lookupTransportSettings, settings.lookupSettings(), clientContext);
    this.runQueryCallable =
        callableFactory.createUnaryCallable(
            runQueryTransportSettings, settings.runQuerySettings(), clientContext);
    this.runAggregationQueryCallable =
        callableFactory.createUnaryCallable(
            runAggregationQueryTransportSettings,
            settings.runAggregationQuerySettings(),
            clientContext);
    this.beginTransactionCallable =
        callableFactory.createUnaryCallable(
            beginTransactionTransportSettings, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        callableFactory.createUnaryCallable(
            commitTransportSettings, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        callableFactory.createUnaryCallable(
            rollbackTransportSettings, settings.rollbackSettings(), clientContext);
    this.allocateIdsCallable =
        callableFactory.createUnaryCallable(
            allocateIdsTransportSettings, settings.allocateIdsSettings(), clientContext);
    this.reserveIdsCallable =
        callableFactory.createUnaryCallable(
            reserveIdsTransportSettings, settings.reserveIdsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<LookupRequest, LookupResponse> lookupCallable() {
    return lookupCallable;
  }

  @Override
  public UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return runQueryCallable;
  }

  @Override
  public UnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return runAggregationQueryCallable;
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return beginTransactionCallable;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return commitCallable;
  }

  @Override
  public UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable() {
    return rollbackCallable;
  }

  @Override
  public UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable() {
    return allocateIdsCallable;
  }

  @Override
  public UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable() {
    return reserveIdsCallable;
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
