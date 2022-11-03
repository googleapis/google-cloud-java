/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.enterpriseknowledgegraph.v1.stub;

import static com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient.ListEntityReconciliationJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob;
import com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EnterpriseKnowledgeGraphService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEnterpriseKnowledgeGraphServiceStub extends EnterpriseKnowledgeGraphServiceStub {
  private static final MethodDescriptor<
          CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobMethodDescriptor =
          MethodDescriptor
              .<CreateEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/CreateEntityReconciliationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntityReconciliationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EntityReconciliationJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobMethodDescriptor =
          MethodDescriptor.<GetEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/GetEntityReconciliationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEntityReconciliationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EntityReconciliationJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
      listEntityReconciliationJobsMethodDescriptor =
          MethodDescriptor
              .<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/ListEntityReconciliationJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntityReconciliationJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntityReconciliationJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobMethodDescriptor =
          MethodDescriptor.<CancelEntityReconciliationJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/CancelEntityReconciliationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelEntityReconciliationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobMethodDescriptor =
          MethodDescriptor.<DeleteEntityReconciliationJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/DeleteEntityReconciliationJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEntityReconciliationJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobCallable;
  private final UnaryCallable<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobCallable;
  private final UnaryCallable<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
      listEntityReconciliationJobsCallable;
  private final UnaryCallable<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsPagedCallable;
  private final UnaryCallable<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobCallable;
  private final UnaryCallable<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEnterpriseKnowledgeGraphServiceStub create(
      EnterpriseKnowledgeGraphServiceStubSettings settings) throws IOException {
    return new GrpcEnterpriseKnowledgeGraphServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEnterpriseKnowledgeGraphServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEnterpriseKnowledgeGraphServiceStub(
        EnterpriseKnowledgeGraphServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEnterpriseKnowledgeGraphServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEnterpriseKnowledgeGraphServiceStub(
        EnterpriseKnowledgeGraphServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcEnterpriseKnowledgeGraphServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcEnterpriseKnowledgeGraphServiceStub(
      EnterpriseKnowledgeGraphServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEnterpriseKnowledgeGraphServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEnterpriseKnowledgeGraphServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcEnterpriseKnowledgeGraphServiceStub(
      EnterpriseKnowledgeGraphServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
        createEntityReconciliationJobTransportSettings =
            GrpcCallSettings
                .<CreateEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
                .setMethodDescriptor(createEntityReconciliationJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEntityReconciliationJobRequest, EntityReconciliationJob>
        getEntityReconciliationJobTransportSettings =
            GrpcCallSettings
                .<GetEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
                .setMethodDescriptor(getEntityReconciliationJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
        listEntityReconciliationJobsTransportSettings =
            GrpcCallSettings
                .<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listEntityReconciliationJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CancelEntityReconciliationJobRequest, Empty>
        cancelEntityReconciliationJobTransportSettings =
            GrpcCallSettings.<CancelEntityReconciliationJobRequest, Empty>newBuilder()
                .setMethodDescriptor(cancelEntityReconciliationJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteEntityReconciliationJobRequest, Empty>
        deleteEntityReconciliationJobTransportSettings =
            GrpcCallSettings.<DeleteEntityReconciliationJobRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEntityReconciliationJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.createEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            createEntityReconciliationJobTransportSettings,
            settings.createEntityReconciliationJobSettings(),
            clientContext);
    this.getEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            getEntityReconciliationJobTransportSettings,
            settings.getEntityReconciliationJobSettings(),
            clientContext);
    this.listEntityReconciliationJobsCallable =
        callableFactory.createUnaryCallable(
            listEntityReconciliationJobsTransportSettings,
            settings.listEntityReconciliationJobsSettings(),
            clientContext);
    this.listEntityReconciliationJobsPagedCallable =
        callableFactory.createPagedCallable(
            listEntityReconciliationJobsTransportSettings,
            settings.listEntityReconciliationJobsSettings(),
            clientContext);
    this.cancelEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            cancelEntityReconciliationJobTransportSettings,
            settings.cancelEntityReconciliationJobSettings(),
            clientContext);
    this.deleteEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            deleteEntityReconciliationJobTransportSettings,
            settings.deleteEntityReconciliationJobSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobCallable() {
    return createEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobCallable() {
    return getEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
      listEntityReconciliationJobsCallable() {
    return listEntityReconciliationJobsCallable;
  }

  @Override
  public UnaryCallable<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsPagedCallable() {
    return listEntityReconciliationJobsPagedCallable;
  }

  @Override
  public UnaryCallable<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobCallable() {
    return cancelEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobCallable() {
    return deleteEntityReconciliationJobCallable;
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
