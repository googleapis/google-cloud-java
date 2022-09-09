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

package com.google.cloud.gaming.v1beta.stub;

import static com.google.cloud.gaming.v1beta.GameServerConfigsServiceClient.ListGameServerConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1beta.CreateGameServerConfigRequest;
import com.google.cloud.gaming.v1beta.DeleteGameServerConfigRequest;
import com.google.cloud.gaming.v1beta.GameServerConfig;
import com.google.cloud.gaming.v1beta.GetGameServerConfigRequest;
import com.google.cloud.gaming.v1beta.ListGameServerConfigsRequest;
import com.google.cloud.gaming.v1beta.ListGameServerConfigsResponse;
import com.google.cloud.gaming.v1beta.OperationMetadata;
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
 * gRPC stub implementation for the GameServerConfigsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGameServerConfigsServiceStub extends GameServerConfigsServiceStub {
  private static final MethodDescriptor<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsMethodDescriptor =
          MethodDescriptor.<ListGameServerConfigsRequest, ListGameServerConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1beta.GameServerConfigsService/ListGameServerConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGameServerConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGameServerConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigMethodDescriptor =
          MethodDescriptor.<GetGameServerConfigRequest, GameServerConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1beta.GameServerConfigsService/GetGameServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGameServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GameServerConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGameServerConfigRequest, Operation>
      createGameServerConfigMethodDescriptor =
          MethodDescriptor.<CreateGameServerConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1beta.GameServerConfigsService/CreateGameServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGameServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigMethodDescriptor =
          MethodDescriptor.<DeleteGameServerConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1beta.GameServerConfigsService/DeleteGameServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGameServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsCallable;
  private final UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsPagedResponse>
      listGameServerConfigsPagedCallable;
  private final UnaryCallable<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigCallable;
  private final UnaryCallable<CreateGameServerConfigRequest, Operation>
      createGameServerConfigCallable;
  private final OperationCallable<
          CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationCallable;
  private final UnaryCallable<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigCallable;
  private final OperationCallable<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGameServerConfigsServiceStub create(
      GameServerConfigsServiceStubSettings settings) throws IOException {
    return new GrpcGameServerConfigsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGameServerConfigsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGameServerConfigsServiceStub(
        GameServerConfigsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGameServerConfigsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGameServerConfigsServiceStub(
        GameServerConfigsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGameServerConfigsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGameServerConfigsServiceStub(
      GameServerConfigsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGameServerConfigsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGameServerConfigsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGameServerConfigsServiceStub(
      GameServerConfigsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
        listGameServerConfigsTransportSettings =
            GrpcCallSettings
                .<ListGameServerConfigsRequest, ListGameServerConfigsResponse>newBuilder()
                .setMethodDescriptor(listGameServerConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetGameServerConfigRequest, GameServerConfig>
        getGameServerConfigTransportSettings =
            GrpcCallSettings.<GetGameServerConfigRequest, GameServerConfig>newBuilder()
                .setMethodDescriptor(getGameServerConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateGameServerConfigRequest, Operation>
        createGameServerConfigTransportSettings =
            GrpcCallSettings.<CreateGameServerConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createGameServerConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteGameServerConfigRequest, Operation>
        deleteGameServerConfigTransportSettings =
            GrpcCallSettings.<DeleteGameServerConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGameServerConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listGameServerConfigsCallable =
        callableFactory.createUnaryCallable(
            listGameServerConfigsTransportSettings,
            settings.listGameServerConfigsSettings(),
            clientContext);
    this.listGameServerConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listGameServerConfigsTransportSettings,
            settings.listGameServerConfigsSettings(),
            clientContext);
    this.getGameServerConfigCallable =
        callableFactory.createUnaryCallable(
            getGameServerConfigTransportSettings,
            settings.getGameServerConfigSettings(),
            clientContext);
    this.createGameServerConfigCallable =
        callableFactory.createUnaryCallable(
            createGameServerConfigTransportSettings,
            settings.createGameServerConfigSettings(),
            clientContext);
    this.createGameServerConfigOperationCallable =
        callableFactory.createOperationCallable(
            createGameServerConfigTransportSettings,
            settings.createGameServerConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGameServerConfigCallable =
        callableFactory.createUnaryCallable(
            deleteGameServerConfigTransportSettings,
            settings.deleteGameServerConfigSettings(),
            clientContext);
    this.deleteGameServerConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteGameServerConfigTransportSettings,
            settings.deleteGameServerConfigOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsCallable() {
    return listGameServerConfigsCallable;
  }

  @Override
  public UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsPagedResponse>
      listGameServerConfigsPagedCallable() {
    return listGameServerConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGameServerConfigRequest, GameServerConfig> getGameServerConfigCallable() {
    return getGameServerConfigCallable;
  }

  @Override
  public UnaryCallable<CreateGameServerConfigRequest, Operation> createGameServerConfigCallable() {
    return createGameServerConfigCallable;
  }

  @Override
  public OperationCallable<CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationCallable() {
    return createGameServerConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGameServerConfigRequest, Operation> deleteGameServerConfigCallable() {
    return deleteGameServerConfigCallable;
  }

  @Override
  public OperationCallable<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationCallable() {
    return deleteGameServerConfigOperationCallable;
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
