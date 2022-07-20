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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AzureClient;
import com.google.cloud.gkemulticloud.v1.AzureCluster;
import com.google.cloud.gkemulticloud.v1.AzureNodePool;
import com.google.cloud.gkemulticloud.v1.AzureServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AzureClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAzureClustersStub extends AzureClustersStub {
  private static final MethodDescriptor<CreateAzureClientRequest, Operation>
      createAzureClientMethodDescriptor =
          MethodDescriptor.<CreateAzureClientRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/CreateAzureClient")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAzureClientRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAzureClientRequest, AzureClient>
      getAzureClientMethodDescriptor =
          MethodDescriptor.<GetAzureClientRequest, AzureClient>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureClient")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAzureClientRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AzureClient.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsMethodDescriptor =
          MethodDescriptor.<ListAzureClientsRequest, ListAzureClientsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/ListAzureClients")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAzureClientsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAzureClientsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAzureClientRequest, Operation>
      deleteAzureClientMethodDescriptor =
          MethodDescriptor.<DeleteAzureClientRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/DeleteAzureClient")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAzureClientRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAzureClusterRequest, Operation>
      createAzureClusterMethodDescriptor =
          MethodDescriptor.<CreateAzureClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/CreateAzureCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAzureClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAzureClusterRequest, Operation>
      updateAzureClusterMethodDescriptor =
          MethodDescriptor.<UpdateAzureClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/UpdateAzureCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAzureClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAzureClusterRequest, AzureCluster>
      getAzureClusterMethodDescriptor =
          MethodDescriptor.<GetAzureClusterRequest, AzureCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAzureClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AzureCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersMethodDescriptor =
          MethodDescriptor.<ListAzureClustersRequest, ListAzureClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/ListAzureClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAzureClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAzureClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAzureClusterRequest, Operation>
      deleteAzureClusterMethodDescriptor =
          MethodDescriptor.<DeleteAzureClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/DeleteAzureCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAzureClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenMethodDescriptor =
          MethodDescriptor
              .<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AzureClusters/GenerateAzureAccessToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAzureAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateAzureAccessTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAzureNodePoolRequest, Operation>
      createAzureNodePoolMethodDescriptor =
          MethodDescriptor.<CreateAzureNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/CreateAzureNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAzureNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAzureNodePoolRequest, Operation>
      updateAzureNodePoolMethodDescriptor =
          MethodDescriptor.<UpdateAzureNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/UpdateAzureNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAzureNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAzureNodePoolRequest, AzureNodePool>
      getAzureNodePoolMethodDescriptor =
          MethodDescriptor.<GetAzureNodePoolRequest, AzureNodePool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAzureNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AzureNodePool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsMethodDescriptor =
          MethodDescriptor.<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/ListAzureNodePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAzureNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAzureNodePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAzureNodePoolRequest, Operation>
      deleteAzureNodePoolMethodDescriptor =
          MethodDescriptor.<DeleteAzureNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/DeleteAzureNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAzureNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigMethodDescriptor =
          MethodDescriptor.<GetAzureServerConfigRequest, AzureServerConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAzureServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AzureServerConfig.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable;
  private final OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable;
  private final UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable;
  private final UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable;
  private final UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable;
  private final UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable;
  private final OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable;
  private final UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable;
  private final OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable;
  private final UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable;
  private final OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable;
  private final UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable;
  private final UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable;
  private final UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable;
  private final UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable;
  private final OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable;
  private final UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable;
  private final UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable;
  private final OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable;
  private final UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable;
  private final OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable;
  private final UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable;
  private final UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable;
  private final UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable;
  private final UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable;
  private final OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable;
  private final UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAzureClustersStub create(AzureClustersStubSettings settings)
      throws IOException {
    return new GrpcAzureClustersStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAzureClustersStub create(ClientContext clientContext) throws IOException {
    return new GrpcAzureClustersStub(AzureClustersStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAzureClustersStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAzureClustersStub(
        AzureClustersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAzureClustersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAzureClustersStub(AzureClustersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAzureClustersCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAzureClustersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAzureClustersStub(
      AzureClustersStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAzureClientRequest, Operation> createAzureClientTransportSettings =
        GrpcCallSettings.<CreateAzureClientRequest, Operation>newBuilder()
            .setMethodDescriptor(createAzureClientMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAzureClientRequest, AzureClient> getAzureClientTransportSettings =
        GrpcCallSettings.<GetAzureClientRequest, AzureClient>newBuilder()
            .setMethodDescriptor(getAzureClientMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAzureClientsRequest, ListAzureClientsResponse>
        listAzureClientsTransportSettings =
            GrpcCallSettings.<ListAzureClientsRequest, ListAzureClientsResponse>newBuilder()
                .setMethodDescriptor(listAzureClientsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAzureClientRequest, Operation> deleteAzureClientTransportSettings =
        GrpcCallSettings.<DeleteAzureClientRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAzureClientMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAzureClusterRequest, Operation> createAzureClusterTransportSettings =
        GrpcCallSettings.<CreateAzureClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createAzureClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAzureClusterRequest, Operation> updateAzureClusterTransportSettings =
        GrpcCallSettings.<UpdateAzureClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAzureClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "azure_cluster.name", String.valueOf(request.getAzureCluster().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAzureClusterRequest, AzureCluster> getAzureClusterTransportSettings =
        GrpcCallSettings.<GetAzureClusterRequest, AzureCluster>newBuilder()
            .setMethodDescriptor(getAzureClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAzureClustersRequest, ListAzureClustersResponse>
        listAzureClustersTransportSettings =
            GrpcCallSettings.<ListAzureClustersRequest, ListAzureClustersResponse>newBuilder()
                .setMethodDescriptor(listAzureClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAzureClusterRequest, Operation> deleteAzureClusterTransportSettings =
        GrpcCallSettings.<DeleteAzureClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAzureClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
        generateAzureAccessTokenTransportSettings =
            GrpcCallSettings
                .<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAzureAccessTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("azure_cluster", String.valueOf(request.getAzureCluster()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateAzureNodePoolRequest, Operation> createAzureNodePoolTransportSettings =
        GrpcCallSettings.<CreateAzureNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createAzureNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolTransportSettings =
        GrpcCallSettings.<UpdateAzureNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAzureNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "azure_node_pool.name", String.valueOf(request.getAzureNodePool().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolTransportSettings =
        GrpcCallSettings.<GetAzureNodePoolRequest, AzureNodePool>newBuilder()
            .setMethodDescriptor(getAzureNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
        listAzureNodePoolsTransportSettings =
            GrpcCallSettings.<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>newBuilder()
                .setMethodDescriptor(listAzureNodePoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolTransportSettings =
        GrpcCallSettings.<DeleteAzureNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAzureNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAzureServerConfigRequest, AzureServerConfig>
        getAzureServerConfigTransportSettings =
            GrpcCallSettings.<GetAzureServerConfigRequest, AzureServerConfig>newBuilder()
                .setMethodDescriptor(getAzureServerConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.createAzureClientCallable =
        callableFactory.createUnaryCallable(
            createAzureClientTransportSettings,
            settings.createAzureClientSettings(),
            clientContext);
    this.createAzureClientOperationCallable =
        callableFactory.createOperationCallable(
            createAzureClientTransportSettings,
            settings.createAzureClientOperationSettings(),
            clientContext,
            operationsStub);
    this.getAzureClientCallable =
        callableFactory.createUnaryCallable(
            getAzureClientTransportSettings, settings.getAzureClientSettings(), clientContext);
    this.listAzureClientsCallable =
        callableFactory.createUnaryCallable(
            listAzureClientsTransportSettings, settings.listAzureClientsSettings(), clientContext);
    this.listAzureClientsPagedCallable =
        callableFactory.createPagedCallable(
            listAzureClientsTransportSettings, settings.listAzureClientsSettings(), clientContext);
    this.deleteAzureClientCallable =
        callableFactory.createUnaryCallable(
            deleteAzureClientTransportSettings,
            settings.deleteAzureClientSettings(),
            clientContext);
    this.deleteAzureClientOperationCallable =
        callableFactory.createOperationCallable(
            deleteAzureClientTransportSettings,
            settings.deleteAzureClientOperationSettings(),
            clientContext,
            operationsStub);
    this.createAzureClusterCallable =
        callableFactory.createUnaryCallable(
            createAzureClusterTransportSettings,
            settings.createAzureClusterSettings(),
            clientContext);
    this.createAzureClusterOperationCallable =
        callableFactory.createOperationCallable(
            createAzureClusterTransportSettings,
            settings.createAzureClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAzureClusterCallable =
        callableFactory.createUnaryCallable(
            updateAzureClusterTransportSettings,
            settings.updateAzureClusterSettings(),
            clientContext);
    this.updateAzureClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateAzureClusterTransportSettings,
            settings.updateAzureClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.getAzureClusterCallable =
        callableFactory.createUnaryCallable(
            getAzureClusterTransportSettings, settings.getAzureClusterSettings(), clientContext);
    this.listAzureClustersCallable =
        callableFactory.createUnaryCallable(
            listAzureClustersTransportSettings,
            settings.listAzureClustersSettings(),
            clientContext);
    this.listAzureClustersPagedCallable =
        callableFactory.createPagedCallable(
            listAzureClustersTransportSettings,
            settings.listAzureClustersSettings(),
            clientContext);
    this.deleteAzureClusterCallable =
        callableFactory.createUnaryCallable(
            deleteAzureClusterTransportSettings,
            settings.deleteAzureClusterSettings(),
            clientContext);
    this.deleteAzureClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteAzureClusterTransportSettings,
            settings.deleteAzureClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.generateAzureAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAzureAccessTokenTransportSettings,
            settings.generateAzureAccessTokenSettings(),
            clientContext);
    this.createAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            createAzureNodePoolTransportSettings,
            settings.createAzureNodePoolSettings(),
            clientContext);
    this.createAzureNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            createAzureNodePoolTransportSettings,
            settings.createAzureNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateAzureNodePoolTransportSettings,
            settings.updateAzureNodePoolSettings(),
            clientContext);
    this.updateAzureNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateAzureNodePoolTransportSettings,
            settings.updateAzureNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            getAzureNodePoolTransportSettings, settings.getAzureNodePoolSettings(), clientContext);
    this.listAzureNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listAzureNodePoolsTransportSettings,
            settings.listAzureNodePoolsSettings(),
            clientContext);
    this.listAzureNodePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listAzureNodePoolsTransportSettings,
            settings.listAzureNodePoolsSettings(),
            clientContext);
    this.deleteAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteAzureNodePoolTransportSettings,
            settings.deleteAzureNodePoolSettings(),
            clientContext);
    this.deleteAzureNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteAzureNodePoolTransportSettings,
            settings.deleteAzureNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getAzureServerConfigCallable =
        callableFactory.createUnaryCallable(
            getAzureServerConfigTransportSettings,
            settings.getAzureServerConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable() {
    return createAzureClientCallable;
  }

  @Override
  public OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable() {
    return createAzureClientOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable() {
    return getAzureClientCallable;
  }

  @Override
  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable() {
    return listAzureClientsCallable;
  }

  @Override
  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable() {
    return listAzureClientsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable() {
    return deleteAzureClientCallable;
  }

  @Override
  public OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable() {
    return deleteAzureClientOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable() {
    return createAzureClusterCallable;
  }

  @Override
  public OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable() {
    return createAzureClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable() {
    return updateAzureClusterCallable;
  }

  @Override
  public OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable() {
    return updateAzureClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable() {
    return getAzureClusterCallable;
  }

  @Override
  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable() {
    return listAzureClustersCallable;
  }

  @Override
  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable() {
    return listAzureClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable() {
    return deleteAzureClusterCallable;
  }

  @Override
  public OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable() {
    return deleteAzureClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable() {
    return generateAzureAccessTokenCallable;
  }

  @Override
  public UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable() {
    return createAzureNodePoolCallable;
  }

  @Override
  public OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable() {
    return createAzureNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable() {
    return updateAzureNodePoolCallable;
  }

  @Override
  public OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable() {
    return updateAzureNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable() {
    return getAzureNodePoolCallable;
  }

  @Override
  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable() {
    return listAzureNodePoolsCallable;
  }

  @Override
  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable() {
    return listAzureNodePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable() {
    return deleteAzureNodePoolCallable;
  }

  @Override
  public OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable() {
    return deleteAzureNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable() {
    return getAzureServerConfigCallable;
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
