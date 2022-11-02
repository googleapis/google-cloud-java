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

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsNodePool;
import com.google.cloud.gkemulticloud.v1.AwsServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest;
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
 * gRPC stub implementation for the AwsClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAwsClustersStub extends AwsClustersStub {
  private static final MethodDescriptor<CreateAwsClusterRequest, Operation>
      createAwsClusterMethodDescriptor =
          MethodDescriptor.<CreateAwsClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/CreateAwsCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAwsClusterRequest, Operation>
      updateAwsClusterMethodDescriptor =
          MethodDescriptor.<UpdateAwsClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/UpdateAwsCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAwsClusterRequest, AwsCluster>
      getAwsClusterMethodDescriptor =
          MethodDescriptor.<GetAwsClusterRequest, AwsCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GetAwsCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AwsCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAwsClustersRequest, ListAwsClustersResponse>
      listAwsClustersMethodDescriptor =
          MethodDescriptor.<ListAwsClustersRequest, ListAwsClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/ListAwsClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAwsClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAwsClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAwsClusterRequest, Operation>
      deleteAwsClusterMethodDescriptor =
          MethodDescriptor.<DeleteAwsClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/DeleteAwsCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAwsClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenMethodDescriptor =
          MethodDescriptor
              .<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GenerateAwsAccessToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAwsAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateAwsAccessTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAwsNodePoolRequest, Operation>
      createAwsNodePoolMethodDescriptor =
          MethodDescriptor.<CreateAwsNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/CreateAwsNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAwsNodePoolRequest, Operation>
      updateAwsNodePoolMethodDescriptor =
          MethodDescriptor.<UpdateAwsNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/UpdateAwsNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAwsNodePoolRequest, AwsNodePool>
      getAwsNodePoolMethodDescriptor =
          MethodDescriptor.<GetAwsNodePoolRequest, AwsNodePool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GetAwsNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AwsNodePool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsMethodDescriptor =
          MethodDescriptor.<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/ListAwsNodePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAwsNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAwsNodePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAwsNodePoolRequest, Operation>
      deleteAwsNodePoolMethodDescriptor =
          MethodDescriptor.<DeleteAwsNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/DeleteAwsNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAwsNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigMethodDescriptor =
          MethodDescriptor.<GetAwsServerConfigRequest, AwsServerConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GetAwsServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAwsServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AwsServerConfig.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable;
  private final OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable;
  private final UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable;
  private final OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable;
  private final UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable;
  private final UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse>
      listAwsClustersCallable;
  private final UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable;
  private final UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable;
  private final OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable;
  private final UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable;
  private final UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable;
  private final OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable;
  private final UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable;
  private final OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable;
  private final UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable;
  private final UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable;
  private final UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable;
  private final UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable;
  private final OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable;
  private final UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAwsClustersStub create(AwsClustersStubSettings settings)
      throws IOException {
    return new GrpcAwsClustersStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAwsClustersStub create(ClientContext clientContext) throws IOException {
    return new GrpcAwsClustersStub(AwsClustersStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAwsClustersStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAwsClustersStub(
        AwsClustersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAwsClustersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAwsClustersStub(AwsClustersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAwsClustersCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAwsClustersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAwsClustersStub(
      AwsClustersStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAwsClusterRequest, Operation> createAwsClusterTransportSettings =
        GrpcCallSettings.<CreateAwsClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createAwsClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAwsClusterRequest, Operation> updateAwsClusterTransportSettings =
        GrpcCallSettings.<UpdateAwsClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAwsClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("aws_cluster.name", String.valueOf(request.getAwsCluster().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAwsClusterRequest, AwsCluster> getAwsClusterTransportSettings =
        GrpcCallSettings.<GetAwsClusterRequest, AwsCluster>newBuilder()
            .setMethodDescriptor(getAwsClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAwsClustersRequest, ListAwsClustersResponse>
        listAwsClustersTransportSettings =
            GrpcCallSettings.<ListAwsClustersRequest, ListAwsClustersResponse>newBuilder()
                .setMethodDescriptor(listAwsClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAwsClusterRequest, Operation> deleteAwsClusterTransportSettings =
        GrpcCallSettings.<DeleteAwsClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAwsClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
        generateAwsAccessTokenTransportSettings =
            GrpcCallSettings
                .<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAwsAccessTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("aws_cluster", String.valueOf(request.getAwsCluster()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateAwsNodePoolRequest, Operation> createAwsNodePoolTransportSettings =
        GrpcCallSettings.<CreateAwsNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createAwsNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolTransportSettings =
        GrpcCallSettings.<UpdateAwsNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAwsNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "aws_node_pool.name", String.valueOf(request.getAwsNodePool().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolTransportSettings =
        GrpcCallSettings.<GetAwsNodePoolRequest, AwsNodePool>newBuilder()
            .setMethodDescriptor(getAwsNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
        listAwsNodePoolsTransportSettings =
            GrpcCallSettings.<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>newBuilder()
                .setMethodDescriptor(listAwsNodePoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolTransportSettings =
        GrpcCallSettings.<DeleteAwsNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAwsNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAwsServerConfigRequest, AwsServerConfig>
        getAwsServerConfigTransportSettings =
            GrpcCallSettings.<GetAwsServerConfigRequest, AwsServerConfig>newBuilder()
                .setMethodDescriptor(getAwsServerConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.createAwsClusterCallable =
        callableFactory.createUnaryCallable(
            createAwsClusterTransportSettings, settings.createAwsClusterSettings(), clientContext);
    this.createAwsClusterOperationCallable =
        callableFactory.createOperationCallable(
            createAwsClusterTransportSettings,
            settings.createAwsClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAwsClusterCallable =
        callableFactory.createUnaryCallable(
            updateAwsClusterTransportSettings, settings.updateAwsClusterSettings(), clientContext);
    this.updateAwsClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateAwsClusterTransportSettings,
            settings.updateAwsClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.getAwsClusterCallable =
        callableFactory.createUnaryCallable(
            getAwsClusterTransportSettings, settings.getAwsClusterSettings(), clientContext);
    this.listAwsClustersCallable =
        callableFactory.createUnaryCallable(
            listAwsClustersTransportSettings, settings.listAwsClustersSettings(), clientContext);
    this.listAwsClustersPagedCallable =
        callableFactory.createPagedCallable(
            listAwsClustersTransportSettings, settings.listAwsClustersSettings(), clientContext);
    this.deleteAwsClusterCallable =
        callableFactory.createUnaryCallable(
            deleteAwsClusterTransportSettings, settings.deleteAwsClusterSettings(), clientContext);
    this.deleteAwsClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteAwsClusterTransportSettings,
            settings.deleteAwsClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.generateAwsAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAwsAccessTokenTransportSettings,
            settings.generateAwsAccessTokenSettings(),
            clientContext);
    this.createAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            createAwsNodePoolTransportSettings,
            settings.createAwsNodePoolSettings(),
            clientContext);
    this.createAwsNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            createAwsNodePoolTransportSettings,
            settings.createAwsNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateAwsNodePoolTransportSettings,
            settings.updateAwsNodePoolSettings(),
            clientContext);
    this.updateAwsNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateAwsNodePoolTransportSettings,
            settings.updateAwsNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            getAwsNodePoolTransportSettings, settings.getAwsNodePoolSettings(), clientContext);
    this.listAwsNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listAwsNodePoolsTransportSettings, settings.listAwsNodePoolsSettings(), clientContext);
    this.listAwsNodePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listAwsNodePoolsTransportSettings, settings.listAwsNodePoolsSettings(), clientContext);
    this.deleteAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteAwsNodePoolTransportSettings,
            settings.deleteAwsNodePoolSettings(),
            clientContext);
    this.deleteAwsNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteAwsNodePoolTransportSettings,
            settings.deleteAwsNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getAwsServerConfigCallable =
        callableFactory.createUnaryCallable(
            getAwsServerConfigTransportSettings,
            settings.getAwsServerConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable() {
    return createAwsClusterCallable;
  }

  @Override
  public OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable() {
    return createAwsClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable() {
    return updateAwsClusterCallable;
  }

  @Override
  public OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable() {
    return updateAwsClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable() {
    return getAwsClusterCallable;
  }

  @Override
  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse> listAwsClustersCallable() {
    return listAwsClustersCallable;
  }

  @Override
  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable() {
    return listAwsClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable() {
    return deleteAwsClusterCallable;
  }

  @Override
  public OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable() {
    return deleteAwsClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable() {
    return generateAwsAccessTokenCallable;
  }

  @Override
  public UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable() {
    return createAwsNodePoolCallable;
  }

  @Override
  public OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable() {
    return createAwsNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable() {
    return updateAwsNodePoolCallable;
  }

  @Override
  public OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable() {
    return updateAwsNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable() {
    return getAwsNodePoolCallable;
  }

  @Override
  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable() {
    return listAwsNodePoolsCallable;
  }

  @Override
  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable() {
    return listAwsNodePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable() {
    return deleteAwsNodePoolCallable;
  }

  @Override
  public OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable() {
    return deleteAwsNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig> getAwsServerConfigCallable() {
    return getAwsServerConfigCallable;
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
