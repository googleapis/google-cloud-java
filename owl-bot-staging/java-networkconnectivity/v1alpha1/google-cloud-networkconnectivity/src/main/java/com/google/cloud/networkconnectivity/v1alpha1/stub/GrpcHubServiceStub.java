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

package com.google.cloud.networkconnectivity.v1alpha1.stub;

import static com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1alpha1.HubServiceClient.ListSpokesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest;
import com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest;
import com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest;
import com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest;
import com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest;
import com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest;
import com.google.cloud.networkconnectivity.v1alpha1.Hub;
import com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest;
import com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse;
import com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest;
import com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse;
import com.google.cloud.networkconnectivity.v1alpha1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1alpha1.Spoke;
import com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest;
import com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest;
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
 * gRPC stub implementation for the HubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcHubServiceStub extends HubServiceStub {
  private static final MethodDescriptor<ListHubsRequest, ListHubsResponse>
      listHubsMethodDescriptor =
          MethodDescriptor.<ListHubsRequest, ListHubsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/ListHubs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListHubsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListHubsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHubRequest, Hub> getHubMethodDescriptor =
      MethodDescriptor.<GetHubRequest, Hub>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/GetHub")
          .setRequestMarshaller(ProtoUtils.marshaller(GetHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Hub.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateHubRequest, Operation> createHubMethodDescriptor =
      MethodDescriptor.<CreateHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/CreateHub")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateHubRequest, Operation> updateHubMethodDescriptor =
      MethodDescriptor.<UpdateHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/UpdateHub")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteHubRequest, Operation> deleteHubMethodDescriptor =
      MethodDescriptor.<DeleteHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/DeleteHub")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSpokesRequest, ListSpokesResponse>
      listSpokesMethodDescriptor =
          MethodDescriptor.<ListSpokesRequest, ListSpokesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/ListSpokes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSpokesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSpokesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSpokeRequest, Spoke> getSpokeMethodDescriptor =
      MethodDescriptor.<GetSpokeRequest, Spoke>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/GetSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Spoke.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSpokeRequest, Operation> createSpokeMethodDescriptor =
      MethodDescriptor.<CreateSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/CreateSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSpokeRequest, Operation> updateSpokeMethodDescriptor =
      MethodDescriptor.<UpdateSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/UpdateSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSpokeRequest, Operation> deleteSpokeMethodDescriptor =
      MethodDescriptor.<DeleteSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1alpha1.HubService/DeleteSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable;
  private final UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable;
  private final UnaryCallable<GetHubRequest, Hub> getHubCallable;
  private final UnaryCallable<CreateHubRequest, Operation> createHubCallable;
  private final OperationCallable<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationCallable;
  private final UnaryCallable<UpdateHubRequest, Operation> updateHubCallable;
  private final OperationCallable<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationCallable;
  private final UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable;
  private final OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable;
  private final UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable;
  private final UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable;
  private final UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable;
  private final UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable;
  private final OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable;
  private final UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable;
  private final OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable;
  private final UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable;
  private final OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcHubServiceStub create(HubServiceStubSettings settings)
      throws IOException {
    return new GrpcHubServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHubServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcHubServiceStub(HubServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHubServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHubServiceStub(
        HubServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcHubServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHubServiceStub(HubServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcHubServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHubServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHubServiceStub(
      HubServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListHubsRequest, ListHubsResponse> listHubsTransportSettings =
        GrpcCallSettings.<ListHubsRequest, ListHubsResponse>newBuilder()
            .setMethodDescriptor(listHubsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetHubRequest, Hub> getHubTransportSettings =
        GrpcCallSettings.<GetHubRequest, Hub>newBuilder()
            .setMethodDescriptor(getHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateHubRequest, Operation> createHubTransportSettings =
        GrpcCallSettings.<CreateHubRequest, Operation>newBuilder()
            .setMethodDescriptor(createHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateHubRequest, Operation> updateHubTransportSettings =
        GrpcCallSettings.<UpdateHubRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("hub.name", String.valueOf(request.getHub().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteHubRequest, Operation> deleteHubTransportSettings =
        GrpcCallSettings.<DeleteHubRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSpokesRequest, ListSpokesResponse> listSpokesTransportSettings =
        GrpcCallSettings.<ListSpokesRequest, ListSpokesResponse>newBuilder()
            .setMethodDescriptor(listSpokesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSpokeRequest, Spoke> getSpokeTransportSettings =
        GrpcCallSettings.<GetSpokeRequest, Spoke>newBuilder()
            .setMethodDescriptor(getSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateSpokeRequest, Operation> createSpokeTransportSettings =
        GrpcCallSettings.<CreateSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(createSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSpokeRequest, Operation> updateSpokeTransportSettings =
        GrpcCallSettings.<UpdateSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("spoke.name", String.valueOf(request.getSpoke().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteSpokeRequest, Operation> deleteSpokeTransportSettings =
        GrpcCallSettings.<DeleteSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listHubsCallable =
        callableFactory.createUnaryCallable(
            listHubsTransportSettings, settings.listHubsSettings(), clientContext);
    this.listHubsPagedCallable =
        callableFactory.createPagedCallable(
            listHubsTransportSettings, settings.listHubsSettings(), clientContext);
    this.getHubCallable =
        callableFactory.createUnaryCallable(
            getHubTransportSettings, settings.getHubSettings(), clientContext);
    this.createHubCallable =
        callableFactory.createUnaryCallable(
            createHubTransportSettings, settings.createHubSettings(), clientContext);
    this.createHubOperationCallable =
        callableFactory.createOperationCallable(
            createHubTransportSettings,
            settings.createHubOperationSettings(),
            clientContext,
            operationsStub);
    this.updateHubCallable =
        callableFactory.createUnaryCallable(
            updateHubTransportSettings, settings.updateHubSettings(), clientContext);
    this.updateHubOperationCallable =
        callableFactory.createOperationCallable(
            updateHubTransportSettings,
            settings.updateHubOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteHubCallable =
        callableFactory.createUnaryCallable(
            deleteHubTransportSettings, settings.deleteHubSettings(), clientContext);
    this.deleteHubOperationCallable =
        callableFactory.createOperationCallable(
            deleteHubTransportSettings,
            settings.deleteHubOperationSettings(),
            clientContext,
            operationsStub);
    this.listSpokesCallable =
        callableFactory.createUnaryCallable(
            listSpokesTransportSettings, settings.listSpokesSettings(), clientContext);
    this.listSpokesPagedCallable =
        callableFactory.createPagedCallable(
            listSpokesTransportSettings, settings.listSpokesSettings(), clientContext);
    this.getSpokeCallable =
        callableFactory.createUnaryCallable(
            getSpokeTransportSettings, settings.getSpokeSettings(), clientContext);
    this.createSpokeCallable =
        callableFactory.createUnaryCallable(
            createSpokeTransportSettings, settings.createSpokeSettings(), clientContext);
    this.createSpokeOperationCallable =
        callableFactory.createOperationCallable(
            createSpokeTransportSettings,
            settings.createSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSpokeCallable =
        callableFactory.createUnaryCallable(
            updateSpokeTransportSettings, settings.updateSpokeSettings(), clientContext);
    this.updateSpokeOperationCallable =
        callableFactory.createOperationCallable(
            updateSpokeTransportSettings,
            settings.updateSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSpokeCallable =
        callableFactory.createUnaryCallable(
            deleteSpokeTransportSettings, settings.deleteSpokeSettings(), clientContext);
    this.deleteSpokeOperationCallable =
        callableFactory.createOperationCallable(
            deleteSpokeTransportSettings,
            settings.deleteSpokeOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable() {
    return listHubsCallable;
  }

  @Override
  public UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable() {
    return listHubsPagedCallable;
  }

  @Override
  public UnaryCallable<GetHubRequest, Hub> getHubCallable() {
    return getHubCallable;
  }

  @Override
  public UnaryCallable<CreateHubRequest, Operation> createHubCallable() {
    return createHubCallable;
  }

  @Override
  public OperationCallable<CreateHubRequest, Hub, OperationMetadata> createHubOperationCallable() {
    return createHubOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHubRequest, Operation> updateHubCallable() {
    return updateHubCallable;
  }

  @Override
  public OperationCallable<UpdateHubRequest, Hub, OperationMetadata> updateHubOperationCallable() {
    return updateHubOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable() {
    return deleteHubCallable;
  }

  @Override
  public OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable() {
    return deleteHubOperationCallable;
  }

  @Override
  public UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable() {
    return listSpokesCallable;
  }

  @Override
  public UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable() {
    return listSpokesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable() {
    return getSpokeCallable;
  }

  @Override
  public UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable() {
    return createSpokeCallable;
  }

  @Override
  public OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable() {
    return createSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable() {
    return updateSpokeCallable;
  }

  @Override
  public OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable() {
    return updateSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable() {
    return deleteSpokeCallable;
  }

  @Override
  public OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable() {
    return deleteSpokeOperationCallable;
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
