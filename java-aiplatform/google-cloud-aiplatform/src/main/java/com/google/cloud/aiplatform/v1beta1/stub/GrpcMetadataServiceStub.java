/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListArtifactsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListContextsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListMetadataSchemasPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListMetadataStoresPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest;
import com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse;
import com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest;
import com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse;
import com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest;
import com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse;
import com.google.cloud.aiplatform.v1beta1.Artifact;
import com.google.cloud.aiplatform.v1beta1.Context;
import com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest;
import com.google.cloud.aiplatform.v1beta1.CreateContextRequest;
import com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest;
import com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest;
import com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteContextRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Execution;
import com.google.cloud.aiplatform.v1beta1.GetArtifactRequest;
import com.google.cloud.aiplatform.v1beta1.GetContextRequest;
import com.google.cloud.aiplatform.v1beta1.GetExecutionRequest;
import com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest;
import com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest;
import com.google.cloud.aiplatform.v1beta1.LineageSubgraph;
import com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest;
import com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse;
import com.google.cloud.aiplatform.v1beta1.ListContextsRequest;
import com.google.cloud.aiplatform.v1beta1.ListContextsResponse;
import com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse;
import com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest;
import com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse;
import com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest;
import com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse;
import com.google.cloud.aiplatform.v1beta1.MetadataSchema;
import com.google.cloud.aiplatform.v1beta1.MetadataStore;
import com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest;
import com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest;
import com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateContextRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetadataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMetadataServiceStub extends MetadataServiceStub {
  private static final MethodDescriptor<CreateMetadataStoreRequest, Operation>
      createMetadataStoreMethodDescriptor =
          MethodDescriptor.<CreateMetadataStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/CreateMetadataStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMetadataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMetadataStoreRequest, MetadataStore>
      getMetadataStoreMethodDescriptor =
          MethodDescriptor.<GetMetadataStoreRequest, MetadataStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/GetMetadataStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMetadataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetadataStore.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMetadataStoresRequest, ListMetadataStoresResponse>
      listMetadataStoresMethodDescriptor =
          MethodDescriptor.<ListMetadataStoresRequest, ListMetadataStoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/ListMetadataStores")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMetadataStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMetadataStoresResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMetadataStoreRequest, Operation>
      deleteMetadataStoreMethodDescriptor =
          MethodDescriptor.<DeleteMetadataStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/DeleteMetadataStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMetadataStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateArtifactRequest, Artifact>
      createArtifactMethodDescriptor =
          MethodDescriptor.<CreateArtifactRequest, Artifact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/CreateArtifact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateArtifactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Artifact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetArtifactRequest, Artifact> getArtifactMethodDescriptor =
      MethodDescriptor.<GetArtifactRequest, Artifact>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/GetArtifact")
          .setRequestMarshaller(ProtoUtils.marshaller(GetArtifactRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Artifact.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListArtifactsRequest, ListArtifactsResponse>
      listArtifactsMethodDescriptor =
          MethodDescriptor.<ListArtifactsRequest, ListArtifactsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/ListArtifacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListArtifactsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListArtifactsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateArtifactRequest, Artifact>
      updateArtifactMethodDescriptor =
          MethodDescriptor.<UpdateArtifactRequest, Artifact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/UpdateArtifact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateArtifactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Artifact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateContextRequest, Context>
      createContextMethodDescriptor =
          MethodDescriptor.<CreateContextRequest, Context>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/CreateContext")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateContextRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Context.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetContextRequest, Context> getContextMethodDescriptor =
      MethodDescriptor.<GetContextRequest, Context>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/GetContext")
          .setRequestMarshaller(ProtoUtils.marshaller(GetContextRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Context.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListContextsRequest, ListContextsResponse>
      listContextsMethodDescriptor =
          MethodDescriptor.<ListContextsRequest, ListContextsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/ListContexts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListContextsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListContextsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateContextRequest, Context>
      updateContextMethodDescriptor =
          MethodDescriptor.<UpdateContextRequest, Context>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/UpdateContext")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateContextRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Context.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteContextRequest, Operation>
      deleteContextMethodDescriptor =
          MethodDescriptor.<DeleteContextRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/DeleteContext")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteContextRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
      addContextArtifactsAndExecutionsMethodDescriptor =
          MethodDescriptor
              .<AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/AddContextArtifactsAndExecutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      AddContextArtifactsAndExecutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      AddContextArtifactsAndExecutionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddContextChildrenRequest, AddContextChildrenResponse>
      addContextChildrenMethodDescriptor =
          MethodDescriptor.<AddContextChildrenRequest, AddContextChildrenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/AddContextChildren")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddContextChildrenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddContextChildrenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryContextLineageSubgraphRequest, LineageSubgraph>
      queryContextLineageSubgraphMethodDescriptor =
          MethodDescriptor.<QueryContextLineageSubgraphRequest, LineageSubgraph>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/QueryContextLineageSubgraph")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryContextLineageSubgraphRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LineageSubgraph.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExecutionRequest, Execution>
      createExecutionMethodDescriptor =
          MethodDescriptor.<CreateExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/CreateExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          MethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/GetExecution")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          MethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/ListExecutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExecutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExecutionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExecutionRequest, Execution>
      updateExecutionMethodDescriptor =
          MethodDescriptor.<UpdateExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MetadataService/UpdateExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddExecutionEventsRequest, AddExecutionEventsResponse>
      addExecutionEventsMethodDescriptor =
          MethodDescriptor.<AddExecutionEventsRequest, AddExecutionEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/AddExecutionEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddExecutionEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddExecutionEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
      queryExecutionInputsAndOutputsMethodDescriptor =
          MethodDescriptor.<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/QueryExecutionInputsAndOutputs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryExecutionInputsAndOutputsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LineageSubgraph.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMetadataSchemaRequest, MetadataSchema>
      createMetadataSchemaMethodDescriptor =
          MethodDescriptor.<CreateMetadataSchemaRequest, MetadataSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/CreateMetadataSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMetadataSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetadataSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMetadataSchemaRequest, MetadataSchema>
      getMetadataSchemaMethodDescriptor =
          MethodDescriptor.<GetMetadataSchemaRequest, MetadataSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/GetMetadataSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMetadataSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetadataSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMetadataSchemasRequest, ListMetadataSchemasResponse>
      listMetadataSchemasMethodDescriptor =
          MethodDescriptor.<ListMetadataSchemasRequest, ListMetadataSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/ListMetadataSchemas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMetadataSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMetadataSchemasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
      queryArtifactLineageSubgraphMethodDescriptor =
          MethodDescriptor.<QueryArtifactLineageSubgraphRequest, LineageSubgraph>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MetadataService/QueryArtifactLineageSubgraph")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryArtifactLineageSubgraphRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LineageSubgraph.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateMetadataStoreRequest, Operation> createMetadataStoreCallable;
  private final OperationCallable<
          CreateMetadataStoreRequest, MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreOperationCallable;
  private final UnaryCallable<GetMetadataStoreRequest, MetadataStore> getMetadataStoreCallable;
  private final UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresResponse>
      listMetadataStoresCallable;
  private final UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresPagedResponse>
      listMetadataStoresPagedCallable;
  private final UnaryCallable<DeleteMetadataStoreRequest, Operation> deleteMetadataStoreCallable;
  private final OperationCallable<
          DeleteMetadataStoreRequest, Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreOperationCallable;
  private final UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable;
  private final UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable;
  private final UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable;
  private final UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable;
  private final UnaryCallable<UpdateArtifactRequest, Artifact> updateArtifactCallable;
  private final UnaryCallable<CreateContextRequest, Context> createContextCallable;
  private final UnaryCallable<GetContextRequest, Context> getContextCallable;
  private final UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable;
  private final UnaryCallable<ListContextsRequest, ListContextsPagedResponse>
      listContextsPagedCallable;
  private final UnaryCallable<UpdateContextRequest, Context> updateContextCallable;
  private final UnaryCallable<DeleteContextRequest, Operation> deleteContextCallable;
  private final OperationCallable<DeleteContextRequest, Empty, DeleteOperationMetadata>
      deleteContextOperationCallable;
  private final UnaryCallable<
          AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
      addContextArtifactsAndExecutionsCallable;
  private final UnaryCallable<AddContextChildrenRequest, AddContextChildrenResponse>
      addContextChildrenCallable;
  private final UnaryCallable<QueryContextLineageSubgraphRequest, LineageSubgraph>
      queryContextLineageSubgraphCallable;
  private final UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable;
  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<UpdateExecutionRequest, Execution> updateExecutionCallable;
  private final UnaryCallable<AddExecutionEventsRequest, AddExecutionEventsResponse>
      addExecutionEventsCallable;
  private final UnaryCallable<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
      queryExecutionInputsAndOutputsCallable;
  private final UnaryCallable<CreateMetadataSchemaRequest, MetadataSchema>
      createMetadataSchemaCallable;
  private final UnaryCallable<GetMetadataSchemaRequest, MetadataSchema> getMetadataSchemaCallable;
  private final UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasResponse>
      listMetadataSchemasCallable;
  private final UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasPagedResponse>
      listMetadataSchemasPagedCallable;
  private final UnaryCallable<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
      queryArtifactLineageSubgraphCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetadataServiceStub create(MetadataServiceStubSettings settings)
      throws IOException {
    return new GrpcMetadataServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetadataServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetadataServiceStub(
        MetadataServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetadataServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetadataServiceStub(
        MetadataServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetadataServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetadataServiceStub(
      MetadataServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMetadataServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetadataServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetadataServiceStub(
      MetadataServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateMetadataStoreRequest, Operation> createMetadataStoreTransportSettings =
        GrpcCallSettings.<CreateMetadataStoreRequest, Operation>newBuilder()
            .setMethodDescriptor(createMetadataStoreMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateMetadataStoreRequest>() {
                  @Override
                  public Map<String, String> extract(CreateMetadataStoreRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetMetadataStoreRequest, MetadataStore> getMetadataStoreTransportSettings =
        GrpcCallSettings.<GetMetadataStoreRequest, MetadataStore>newBuilder()
            .setMethodDescriptor(getMetadataStoreMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetMetadataStoreRequest>() {
                  @Override
                  public Map<String, String> extract(GetMetadataStoreRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListMetadataStoresRequest, ListMetadataStoresResponse>
        listMetadataStoresTransportSettings =
            GrpcCallSettings.<ListMetadataStoresRequest, ListMetadataStoresResponse>newBuilder()
                .setMethodDescriptor(listMetadataStoresMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListMetadataStoresRequest>() {
                      @Override
                      public Map<String, String> extract(ListMetadataStoresRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteMetadataStoreRequest, Operation> deleteMetadataStoreTransportSettings =
        GrpcCallSettings.<DeleteMetadataStoreRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMetadataStoreMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteMetadataStoreRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteMetadataStoreRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateArtifactRequest, Artifact> createArtifactTransportSettings =
        GrpcCallSettings.<CreateArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(createArtifactMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateArtifactRequest>() {
                  @Override
                  public Map<String, String> extract(CreateArtifactRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetArtifactRequest, Artifact> getArtifactTransportSettings =
        GrpcCallSettings.<GetArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(getArtifactMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetArtifactRequest>() {
                  @Override
                  public Map<String, String> extract(GetArtifactRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListArtifactsRequest, ListArtifactsResponse> listArtifactsTransportSettings =
        GrpcCallSettings.<ListArtifactsRequest, ListArtifactsResponse>newBuilder()
            .setMethodDescriptor(listArtifactsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListArtifactsRequest>() {
                  @Override
                  public Map<String, String> extract(ListArtifactsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateArtifactRequest, Artifact> updateArtifactTransportSettings =
        GrpcCallSettings.<UpdateArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(updateArtifactMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateArtifactRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateArtifactRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("artifact.name", String.valueOf(request.getArtifact().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateContextRequest, Context> createContextTransportSettings =
        GrpcCallSettings.<CreateContextRequest, Context>newBuilder()
            .setMethodDescriptor(createContextMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateContextRequest>() {
                  @Override
                  public Map<String, String> extract(CreateContextRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetContextRequest, Context> getContextTransportSettings =
        GrpcCallSettings.<GetContextRequest, Context>newBuilder()
            .setMethodDescriptor(getContextMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetContextRequest>() {
                  @Override
                  public Map<String, String> extract(GetContextRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListContextsRequest, ListContextsResponse> listContextsTransportSettings =
        GrpcCallSettings.<ListContextsRequest, ListContextsResponse>newBuilder()
            .setMethodDescriptor(listContextsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListContextsRequest>() {
                  @Override
                  public Map<String, String> extract(ListContextsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateContextRequest, Context> updateContextTransportSettings =
        GrpcCallSettings.<UpdateContextRequest, Context>newBuilder()
            .setMethodDescriptor(updateContextMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateContextRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateContextRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("context.name", String.valueOf(request.getContext().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteContextRequest, Operation> deleteContextTransportSettings =
        GrpcCallSettings.<DeleteContextRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteContextMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteContextRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteContextRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<
            AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
        addContextArtifactsAndExecutionsTransportSettings =
            GrpcCallSettings
                .<AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
                    newBuilder()
                .setMethodDescriptor(addContextArtifactsAndExecutionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AddContextArtifactsAndExecutionsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          AddContextArtifactsAndExecutionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("context", String.valueOf(request.getContext()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<AddContextChildrenRequest, AddContextChildrenResponse>
        addContextChildrenTransportSettings =
            GrpcCallSettings.<AddContextChildrenRequest, AddContextChildrenResponse>newBuilder()
                .setMethodDescriptor(addContextChildrenMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AddContextChildrenRequest>() {
                      @Override
                      public Map<String, String> extract(AddContextChildrenRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("context", String.valueOf(request.getContext()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<QueryContextLineageSubgraphRequest, LineageSubgraph>
        queryContextLineageSubgraphTransportSettings =
            GrpcCallSettings.<QueryContextLineageSubgraphRequest, LineageSubgraph>newBuilder()
                .setMethodDescriptor(queryContextLineageSubgraphMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<QueryContextLineageSubgraphRequest>() {
                      @Override
                      public Map<String, String> extract(
                          QueryContextLineageSubgraphRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("context", String.valueOf(request.getContext()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateExecutionRequest, Execution> createExecutionTransportSettings =
        GrpcCallSettings.<CreateExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(createExecutionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateExecutionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateExecutionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        GrpcCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetExecutionRequest>() {
                  @Override
                  public Map<String, String> extract(GetExecutionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            GrpcCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListExecutionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListExecutionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateExecutionRequest, Execution> updateExecutionTransportSettings =
        GrpcCallSettings.<UpdateExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(updateExecutionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateExecutionRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateExecutionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("execution.name", String.valueOf(request.getExecution().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<AddExecutionEventsRequest, AddExecutionEventsResponse>
        addExecutionEventsTransportSettings =
            GrpcCallSettings.<AddExecutionEventsRequest, AddExecutionEventsResponse>newBuilder()
                .setMethodDescriptor(addExecutionEventsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AddExecutionEventsRequest>() {
                      @Override
                      public Map<String, String> extract(AddExecutionEventsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("execution", String.valueOf(request.getExecution()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
        queryExecutionInputsAndOutputsTransportSettings =
            GrpcCallSettings.<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>newBuilder()
                .setMethodDescriptor(queryExecutionInputsAndOutputsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<QueryExecutionInputsAndOutputsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          QueryExecutionInputsAndOutputsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("execution", String.valueOf(request.getExecution()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateMetadataSchemaRequest, MetadataSchema>
        createMetadataSchemaTransportSettings =
            GrpcCallSettings.<CreateMetadataSchemaRequest, MetadataSchema>newBuilder()
                .setMethodDescriptor(createMetadataSchemaMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateMetadataSchemaRequest>() {
                      @Override
                      public Map<String, String> extract(CreateMetadataSchemaRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetMetadataSchemaRequest, MetadataSchema> getMetadataSchemaTransportSettings =
        GrpcCallSettings.<GetMetadataSchemaRequest, MetadataSchema>newBuilder()
            .setMethodDescriptor(getMetadataSchemaMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetMetadataSchemaRequest>() {
                  @Override
                  public Map<String, String> extract(GetMetadataSchemaRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListMetadataSchemasRequest, ListMetadataSchemasResponse>
        listMetadataSchemasTransportSettings =
            GrpcCallSettings.<ListMetadataSchemasRequest, ListMetadataSchemasResponse>newBuilder()
                .setMethodDescriptor(listMetadataSchemasMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListMetadataSchemasRequest>() {
                      @Override
                      public Map<String, String> extract(ListMetadataSchemasRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
        queryArtifactLineageSubgraphTransportSettings =
            GrpcCallSettings.<QueryArtifactLineageSubgraphRequest, LineageSubgraph>newBuilder()
                .setMethodDescriptor(queryArtifactLineageSubgraphMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<QueryArtifactLineageSubgraphRequest>() {
                      @Override
                      public Map<String, String> extract(
                          QueryArtifactLineageSubgraphRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("artifact", String.valueOf(request.getArtifact()));
                        return params.build();
                      }
                    })
                .build();

    this.createMetadataStoreCallable =
        callableFactory.createUnaryCallable(
            createMetadataStoreTransportSettings,
            settings.createMetadataStoreSettings(),
            clientContext);
    this.createMetadataStoreOperationCallable =
        callableFactory.createOperationCallable(
            createMetadataStoreTransportSettings,
            settings.createMetadataStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.getMetadataStoreCallable =
        callableFactory.createUnaryCallable(
            getMetadataStoreTransportSettings, settings.getMetadataStoreSettings(), clientContext);
    this.listMetadataStoresCallable =
        callableFactory.createUnaryCallable(
            listMetadataStoresTransportSettings,
            settings.listMetadataStoresSettings(),
            clientContext);
    this.listMetadataStoresPagedCallable =
        callableFactory.createPagedCallable(
            listMetadataStoresTransportSettings,
            settings.listMetadataStoresSettings(),
            clientContext);
    this.deleteMetadataStoreCallable =
        callableFactory.createUnaryCallable(
            deleteMetadataStoreTransportSettings,
            settings.deleteMetadataStoreSettings(),
            clientContext);
    this.deleteMetadataStoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteMetadataStoreTransportSettings,
            settings.deleteMetadataStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.createArtifactCallable =
        callableFactory.createUnaryCallable(
            createArtifactTransportSettings, settings.createArtifactSettings(), clientContext);
    this.getArtifactCallable =
        callableFactory.createUnaryCallable(
            getArtifactTransportSettings, settings.getArtifactSettings(), clientContext);
    this.listArtifactsCallable =
        callableFactory.createUnaryCallable(
            listArtifactsTransportSettings, settings.listArtifactsSettings(), clientContext);
    this.listArtifactsPagedCallable =
        callableFactory.createPagedCallable(
            listArtifactsTransportSettings, settings.listArtifactsSettings(), clientContext);
    this.updateArtifactCallable =
        callableFactory.createUnaryCallable(
            updateArtifactTransportSettings, settings.updateArtifactSettings(), clientContext);
    this.createContextCallable =
        callableFactory.createUnaryCallable(
            createContextTransportSettings, settings.createContextSettings(), clientContext);
    this.getContextCallable =
        callableFactory.createUnaryCallable(
            getContextTransportSettings, settings.getContextSettings(), clientContext);
    this.listContextsCallable =
        callableFactory.createUnaryCallable(
            listContextsTransportSettings, settings.listContextsSettings(), clientContext);
    this.listContextsPagedCallable =
        callableFactory.createPagedCallable(
            listContextsTransportSettings, settings.listContextsSettings(), clientContext);
    this.updateContextCallable =
        callableFactory.createUnaryCallable(
            updateContextTransportSettings, settings.updateContextSettings(), clientContext);
    this.deleteContextCallable =
        callableFactory.createUnaryCallable(
            deleteContextTransportSettings, settings.deleteContextSettings(), clientContext);
    this.deleteContextOperationCallable =
        callableFactory.createOperationCallable(
            deleteContextTransportSettings,
            settings.deleteContextOperationSettings(),
            clientContext,
            operationsStub);
    this.addContextArtifactsAndExecutionsCallable =
        callableFactory.createUnaryCallable(
            addContextArtifactsAndExecutionsTransportSettings,
            settings.addContextArtifactsAndExecutionsSettings(),
            clientContext);
    this.addContextChildrenCallable =
        callableFactory.createUnaryCallable(
            addContextChildrenTransportSettings,
            settings.addContextChildrenSettings(),
            clientContext);
    this.queryContextLineageSubgraphCallable =
        callableFactory.createUnaryCallable(
            queryContextLineageSubgraphTransportSettings,
            settings.queryContextLineageSubgraphSettings(),
            clientContext);
    this.createExecutionCallable =
        callableFactory.createUnaryCallable(
            createExecutionTransportSettings, settings.createExecutionSettings(), clientContext);
    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.updateExecutionCallable =
        callableFactory.createUnaryCallable(
            updateExecutionTransportSettings, settings.updateExecutionSettings(), clientContext);
    this.addExecutionEventsCallable =
        callableFactory.createUnaryCallable(
            addExecutionEventsTransportSettings,
            settings.addExecutionEventsSettings(),
            clientContext);
    this.queryExecutionInputsAndOutputsCallable =
        callableFactory.createUnaryCallable(
            queryExecutionInputsAndOutputsTransportSettings,
            settings.queryExecutionInputsAndOutputsSettings(),
            clientContext);
    this.createMetadataSchemaCallable =
        callableFactory.createUnaryCallable(
            createMetadataSchemaTransportSettings,
            settings.createMetadataSchemaSettings(),
            clientContext);
    this.getMetadataSchemaCallable =
        callableFactory.createUnaryCallable(
            getMetadataSchemaTransportSettings,
            settings.getMetadataSchemaSettings(),
            clientContext);
    this.listMetadataSchemasCallable =
        callableFactory.createUnaryCallable(
            listMetadataSchemasTransportSettings,
            settings.listMetadataSchemasSettings(),
            clientContext);
    this.listMetadataSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listMetadataSchemasTransportSettings,
            settings.listMetadataSchemasSettings(),
            clientContext);
    this.queryArtifactLineageSubgraphCallable =
        callableFactory.createUnaryCallable(
            queryArtifactLineageSubgraphTransportSettings,
            settings.queryArtifactLineageSubgraphSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateMetadataStoreRequest, Operation> createMetadataStoreCallable() {
    return createMetadataStoreCallable;
  }

  @Override
  public OperationCallable<
          CreateMetadataStoreRequest, MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreOperationCallable() {
    return createMetadataStoreOperationCallable;
  }

  @Override
  public UnaryCallable<GetMetadataStoreRequest, MetadataStore> getMetadataStoreCallable() {
    return getMetadataStoreCallable;
  }

  @Override
  public UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresResponse>
      listMetadataStoresCallable() {
    return listMetadataStoresCallable;
  }

  @Override
  public UnaryCallable<ListMetadataStoresRequest, ListMetadataStoresPagedResponse>
      listMetadataStoresPagedCallable() {
    return listMetadataStoresPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteMetadataStoreRequest, Operation> deleteMetadataStoreCallable() {
    return deleteMetadataStoreCallable;
  }

  @Override
  public OperationCallable<DeleteMetadataStoreRequest, Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreOperationCallable() {
    return deleteMetadataStoreOperationCallable;
  }

  @Override
  public UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable() {
    return createArtifactCallable;
  }

  @Override
  public UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable() {
    return getArtifactCallable;
  }

  @Override
  public UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable() {
    return listArtifactsCallable;
  }

  @Override
  public UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable() {
    return listArtifactsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateArtifactRequest, Artifact> updateArtifactCallable() {
    return updateArtifactCallable;
  }

  @Override
  public UnaryCallable<CreateContextRequest, Context> createContextCallable() {
    return createContextCallable;
  }

  @Override
  public UnaryCallable<GetContextRequest, Context> getContextCallable() {
    return getContextCallable;
  }

  @Override
  public UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable() {
    return listContextsCallable;
  }

  @Override
  public UnaryCallable<ListContextsRequest, ListContextsPagedResponse> listContextsPagedCallable() {
    return listContextsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateContextRequest, Context> updateContextCallable() {
    return updateContextCallable;
  }

  @Override
  public UnaryCallable<DeleteContextRequest, Operation> deleteContextCallable() {
    return deleteContextCallable;
  }

  @Override
  public OperationCallable<DeleteContextRequest, Empty, DeleteOperationMetadata>
      deleteContextOperationCallable() {
    return deleteContextOperationCallable;
  }

  @Override
  public UnaryCallable<
          AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
      addContextArtifactsAndExecutionsCallable() {
    return addContextArtifactsAndExecutionsCallable;
  }

  @Override
  public UnaryCallable<AddContextChildrenRequest, AddContextChildrenResponse>
      addContextChildrenCallable() {
    return addContextChildrenCallable;
  }

  @Override
  public UnaryCallable<QueryContextLineageSubgraphRequest, LineageSubgraph>
      queryContextLineageSubgraphCallable() {
    return queryContextLineageSubgraphCallable;
  }

  @Override
  public UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable() {
    return createExecutionCallable;
  }

  @Override
  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateExecutionRequest, Execution> updateExecutionCallable() {
    return updateExecutionCallable;
  }

  @Override
  public UnaryCallable<AddExecutionEventsRequest, AddExecutionEventsResponse>
      addExecutionEventsCallable() {
    return addExecutionEventsCallable;
  }

  @Override
  public UnaryCallable<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
      queryExecutionInputsAndOutputsCallable() {
    return queryExecutionInputsAndOutputsCallable;
  }

  @Override
  public UnaryCallable<CreateMetadataSchemaRequest, MetadataSchema> createMetadataSchemaCallable() {
    return createMetadataSchemaCallable;
  }

  @Override
  public UnaryCallable<GetMetadataSchemaRequest, MetadataSchema> getMetadataSchemaCallable() {
    return getMetadataSchemaCallable;
  }

  @Override
  public UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasResponse>
      listMetadataSchemasCallable() {
    return listMetadataSchemasCallable;
  }

  @Override
  public UnaryCallable<ListMetadataSchemasRequest, ListMetadataSchemasPagedResponse>
      listMetadataSchemasPagedCallable() {
    return listMetadataSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
      queryArtifactLineageSubgraphCallable() {
    return queryArtifactLineageSubgraphCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
