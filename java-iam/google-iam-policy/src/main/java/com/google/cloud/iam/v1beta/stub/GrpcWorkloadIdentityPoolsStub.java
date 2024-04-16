/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta.stub;

import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolProvidersPagedResponse;
import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolOperationMetadata;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderOperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the WorkloadIdentityPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcWorkloadIdentityPoolsStub extends WorkloadIdentityPoolsStub {
  private static final MethodDescriptor<
          ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
      listWorkloadIdentityPoolsMethodDescriptor =
          MethodDescriptor
              .<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/ListWorkloadIdentityPools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkloadIdentityPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkloadIdentityPoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolMethodDescriptor =
          MethodDescriptor.<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1beta.WorkloadIdentityPools/GetWorkloadIdentityPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(WorkloadIdentityPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolMethodDescriptor =
          MethodDescriptor.<CreateWorkloadIdentityPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/CreateWorkloadIdentityPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolMethodDescriptor =
          MethodDescriptor.<UpdateWorkloadIdentityPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/UpdateWorkloadIdentityPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolMethodDescriptor =
          MethodDescriptor.<DeleteWorkloadIdentityPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/DeleteWorkloadIdentityPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolMethodDescriptor =
          MethodDescriptor.<UndeleteWorkloadIdentityPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/UndeleteWorkloadIdentityPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
      listWorkloadIdentityPoolProvidersMethodDescriptor =
          MethodDescriptor
              .<ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/ListWorkloadIdentityPoolProviders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListWorkloadIdentityPoolProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListWorkloadIdentityPoolProvidersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderMethodDescriptor =
          MethodDescriptor
              .<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/GetWorkloadIdentityPoolProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(WorkloadIdentityPoolProvider.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderMethodDescriptor =
          MethodDescriptor.<CreateWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/CreateWorkloadIdentityPoolProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderMethodDescriptor =
          MethodDescriptor.<UpdateWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/UpdateWorkloadIdentityPoolProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderMethodDescriptor =
          MethodDescriptor.<DeleteWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/DeleteWorkloadIdentityPoolProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderMethodDescriptor =
          MethodDescriptor.<UndeleteWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.iam.v1beta.WorkloadIdentityPools/UndeleteWorkloadIdentityPoolProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UndeleteWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
      listWorkloadIdentityPoolsCallable;
  private final UnaryCallable<
          ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsPagedCallable;
  private final UnaryCallable<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolCallable;
  private final UnaryCallable<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolCallable;
  private final OperationCallable<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationCallable;
  private final UnaryCallable<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolCallable;
  private final OperationCallable<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationCallable;
  private final UnaryCallable<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolCallable;
  private final OperationCallable<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationCallable;
  private final UnaryCallable<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolCallable;
  private final OperationCallable<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationCallable;
  private final UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
      listWorkloadIdentityPoolProvidersCallable;
  private final UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersPagedCallable;
  private final UnaryCallable<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderCallable;
  private final UnaryCallable<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderCallable;
  private final OperationCallable<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationCallable;
  private final UnaryCallable<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderCallable;
  private final OperationCallable<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationCallable;
  private final UnaryCallable<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderCallable;
  private final OperationCallable<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationCallable;
  private final UnaryCallable<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderCallable;
  private final OperationCallable<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWorkloadIdentityPoolsStub create(
      WorkloadIdentityPoolsStubSettings settings) throws IOException {
    return new GrpcWorkloadIdentityPoolsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWorkloadIdentityPoolsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcWorkloadIdentityPoolsStub(
        WorkloadIdentityPoolsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWorkloadIdentityPoolsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWorkloadIdentityPoolsStub(
        WorkloadIdentityPoolsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWorkloadIdentityPoolsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWorkloadIdentityPoolsStub(
      WorkloadIdentityPoolsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcWorkloadIdentityPoolsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWorkloadIdentityPoolsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWorkloadIdentityPoolsStub(
      WorkloadIdentityPoolsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
        listWorkloadIdentityPoolsTransportSettings =
            GrpcCallSettings
                .<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>newBuilder()
                .setMethodDescriptor(listWorkloadIdentityPoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
        getWorkloadIdentityPoolTransportSettings =
            GrpcCallSettings.<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>newBuilder()
                .setMethodDescriptor(getWorkloadIdentityPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWorkloadIdentityPoolRequest, Operation>
        createWorkloadIdentityPoolTransportSettings =
            GrpcCallSettings.<CreateWorkloadIdentityPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(createWorkloadIdentityPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkloadIdentityPoolRequest, Operation>
        updateWorkloadIdentityPoolTransportSettings =
            GrpcCallSettings.<UpdateWorkloadIdentityPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(updateWorkloadIdentityPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workload_identity_pool.name",
                          String.valueOf(request.getWorkloadIdentityPool().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkloadIdentityPoolRequest, Operation>
        deleteWorkloadIdentityPoolTransportSettings =
            GrpcCallSettings.<DeleteWorkloadIdentityPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWorkloadIdentityPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UndeleteWorkloadIdentityPoolRequest, Operation>
        undeleteWorkloadIdentityPoolTransportSettings =
            GrpcCallSettings.<UndeleteWorkloadIdentityPoolRequest, Operation>newBuilder()
                .setMethodDescriptor(undeleteWorkloadIdentityPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
        listWorkloadIdentityPoolProvidersTransportSettings =
            GrpcCallSettings
                .<ListWorkloadIdentityPoolProvidersRequest,
                    ListWorkloadIdentityPoolProvidersResponse>
                    newBuilder()
                .setMethodDescriptor(listWorkloadIdentityPoolProvidersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
        getWorkloadIdentityPoolProviderTransportSettings =
            GrpcCallSettings
                .<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>newBuilder()
                .setMethodDescriptor(getWorkloadIdentityPoolProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWorkloadIdentityPoolProviderRequest, Operation>
        createWorkloadIdentityPoolProviderTransportSettings =
            GrpcCallSettings.<CreateWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
                .setMethodDescriptor(createWorkloadIdentityPoolProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkloadIdentityPoolProviderRequest, Operation>
        updateWorkloadIdentityPoolProviderTransportSettings =
            GrpcCallSettings.<UpdateWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
                .setMethodDescriptor(updateWorkloadIdentityPoolProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workload_identity_pool_provider.name",
                          String.valueOf(request.getWorkloadIdentityPoolProvider().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkloadIdentityPoolProviderRequest, Operation>
        deleteWorkloadIdentityPoolProviderTransportSettings =
            GrpcCallSettings.<DeleteWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWorkloadIdentityPoolProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
        undeleteWorkloadIdentityPoolProviderTransportSettings =
            GrpcCallSettings.<UndeleteWorkloadIdentityPoolProviderRequest, Operation>newBuilder()
                .setMethodDescriptor(undeleteWorkloadIdentityPoolProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.listWorkloadIdentityPoolsCallable =
        callableFactory.createUnaryCallable(
            listWorkloadIdentityPoolsTransportSettings,
            settings.listWorkloadIdentityPoolsSettings(),
            clientContext);
    this.listWorkloadIdentityPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadIdentityPoolsTransportSettings,
            settings.listWorkloadIdentityPoolsSettings(),
            clientContext);
    this.getWorkloadIdentityPoolCallable =
        callableFactory.createUnaryCallable(
            getWorkloadIdentityPoolTransportSettings,
            settings.getWorkloadIdentityPoolSettings(),
            clientContext);
    this.createWorkloadIdentityPoolCallable =
        callableFactory.createUnaryCallable(
            createWorkloadIdentityPoolTransportSettings,
            settings.createWorkloadIdentityPoolSettings(),
            clientContext);
    this.createWorkloadIdentityPoolOperationCallable =
        callableFactory.createOperationCallable(
            createWorkloadIdentityPoolTransportSettings,
            settings.createWorkloadIdentityPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkloadIdentityPoolCallable =
        callableFactory.createUnaryCallable(
            updateWorkloadIdentityPoolTransportSettings,
            settings.updateWorkloadIdentityPoolSettings(),
            clientContext);
    this.updateWorkloadIdentityPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkloadIdentityPoolTransportSettings,
            settings.updateWorkloadIdentityPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkloadIdentityPoolCallable =
        callableFactory.createUnaryCallable(
            deleteWorkloadIdentityPoolTransportSettings,
            settings.deleteWorkloadIdentityPoolSettings(),
            clientContext);
    this.deleteWorkloadIdentityPoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkloadIdentityPoolTransportSettings,
            settings.deleteWorkloadIdentityPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteWorkloadIdentityPoolCallable =
        callableFactory.createUnaryCallable(
            undeleteWorkloadIdentityPoolTransportSettings,
            settings.undeleteWorkloadIdentityPoolSettings(),
            clientContext);
    this.undeleteWorkloadIdentityPoolOperationCallable =
        callableFactory.createOperationCallable(
            undeleteWorkloadIdentityPoolTransportSettings,
            settings.undeleteWorkloadIdentityPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.listWorkloadIdentityPoolProvidersCallable =
        callableFactory.createUnaryCallable(
            listWorkloadIdentityPoolProvidersTransportSettings,
            settings.listWorkloadIdentityPoolProvidersSettings(),
            clientContext);
    this.listWorkloadIdentityPoolProvidersPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadIdentityPoolProvidersTransportSettings,
            settings.listWorkloadIdentityPoolProvidersSettings(),
            clientContext);
    this.getWorkloadIdentityPoolProviderCallable =
        callableFactory.createUnaryCallable(
            getWorkloadIdentityPoolProviderTransportSettings,
            settings.getWorkloadIdentityPoolProviderSettings(),
            clientContext);
    this.createWorkloadIdentityPoolProviderCallable =
        callableFactory.createUnaryCallable(
            createWorkloadIdentityPoolProviderTransportSettings,
            settings.createWorkloadIdentityPoolProviderSettings(),
            clientContext);
    this.createWorkloadIdentityPoolProviderOperationCallable =
        callableFactory.createOperationCallable(
            createWorkloadIdentityPoolProviderTransportSettings,
            settings.createWorkloadIdentityPoolProviderOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkloadIdentityPoolProviderCallable =
        callableFactory.createUnaryCallable(
            updateWorkloadIdentityPoolProviderTransportSettings,
            settings.updateWorkloadIdentityPoolProviderSettings(),
            clientContext);
    this.updateWorkloadIdentityPoolProviderOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkloadIdentityPoolProviderTransportSettings,
            settings.updateWorkloadIdentityPoolProviderOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkloadIdentityPoolProviderCallable =
        callableFactory.createUnaryCallable(
            deleteWorkloadIdentityPoolProviderTransportSettings,
            settings.deleteWorkloadIdentityPoolProviderSettings(),
            clientContext);
    this.deleteWorkloadIdentityPoolProviderOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkloadIdentityPoolProviderTransportSettings,
            settings.deleteWorkloadIdentityPoolProviderOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteWorkloadIdentityPoolProviderCallable =
        callableFactory.createUnaryCallable(
            undeleteWorkloadIdentityPoolProviderTransportSettings,
            settings.undeleteWorkloadIdentityPoolProviderSettings(),
            clientContext);
    this.undeleteWorkloadIdentityPoolProviderOperationCallable =
        callableFactory.createOperationCallable(
            undeleteWorkloadIdentityPoolProviderTransportSettings,
            settings.undeleteWorkloadIdentityPoolProviderOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsResponse>
      listWorkloadIdentityPoolsCallable() {
    return listWorkloadIdentityPoolsCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadIdentityPoolsRequest, ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsPagedCallable() {
    return listWorkloadIdentityPoolsPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolCallable() {
    return getWorkloadIdentityPoolCallable;
  }

  @Override
  public UnaryCallable<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolCallable() {
    return createWorkloadIdentityPoolCallable;
  }

  @Override
  public OperationCallable<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationCallable() {
    return createWorkloadIdentityPoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolCallable() {
    return updateWorkloadIdentityPoolCallable;
  }

  @Override
  public OperationCallable<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationCallable() {
    return updateWorkloadIdentityPoolOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolCallable() {
    return deleteWorkloadIdentityPoolCallable;
  }

  @Override
  public OperationCallable<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationCallable() {
    return deleteWorkloadIdentityPoolOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolCallable() {
    return undeleteWorkloadIdentityPoolCallable;
  }

  @Override
  public OperationCallable<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationCallable() {
    return undeleteWorkloadIdentityPoolOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersResponse>
      listWorkloadIdentityPoolProvidersCallable() {
    return listWorkloadIdentityPoolProvidersCallable;
  }

  @Override
  public UnaryCallable<
          ListWorkloadIdentityPoolProvidersRequest, ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersPagedCallable() {
    return listWorkloadIdentityPoolProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderCallable() {
    return getWorkloadIdentityPoolProviderCallable;
  }

  @Override
  public UnaryCallable<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderCallable() {
    return createWorkloadIdentityPoolProviderCallable;
  }

  @Override
  public OperationCallable<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationCallable() {
    return createWorkloadIdentityPoolProviderOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderCallable() {
    return updateWorkloadIdentityPoolProviderCallable;
  }

  @Override
  public OperationCallable<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationCallable() {
    return updateWorkloadIdentityPoolProviderOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderCallable() {
    return deleteWorkloadIdentityPoolProviderCallable;
  }

  @Override
  public OperationCallable<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationCallable() {
    return deleteWorkloadIdentityPoolProviderOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderCallable() {
    return undeleteWorkloadIdentityPoolProviderCallable;
  }

  @Override
  public OperationCallable<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationCallable() {
    return undeleteWorkloadIdentityPoolProviderOperationCallable;
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
