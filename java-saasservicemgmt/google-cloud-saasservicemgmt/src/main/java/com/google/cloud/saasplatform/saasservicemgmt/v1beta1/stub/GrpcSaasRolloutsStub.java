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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SaasRollouts service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSaasRolloutsStub extends SaasRolloutsStub {
  private static final MethodDescriptor<ListRolloutsRequest, ListRolloutsResponse>
      listRolloutsMethodDescriptor =
          MethodDescriptor.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/ListRollouts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRolloutsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRolloutsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRolloutRequest, Rollout> getRolloutMethodDescriptor =
      MethodDescriptor.<GetRolloutRequest, Rollout>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/GetRollout")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRolloutRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Rollout.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateRolloutRequest, Rollout>
      createRolloutMethodDescriptor =
          MethodDescriptor.<CreateRolloutRequest, Rollout>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/CreateRollout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Rollout.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRolloutRequest, Rollout>
      updateRolloutMethodDescriptor =
          MethodDescriptor.<UpdateRolloutRequest, Rollout>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/UpdateRollout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Rollout.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRolloutRequest, Empty> deleteRolloutMethodDescriptor =
      MethodDescriptor.<DeleteRolloutRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/DeleteRollout")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRolloutRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsMethodDescriptor =
          MethodDescriptor.<ListRolloutKindsRequest, ListRolloutKindsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/ListRolloutKinds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRolloutKindsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRolloutKindsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRolloutKindRequest, RolloutKind>
      getRolloutKindMethodDescriptor =
          MethodDescriptor.<GetRolloutKindRequest, RolloutKind>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/GetRolloutKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRolloutKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RolloutKind.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRolloutKindRequest, RolloutKind>
      createRolloutKindMethodDescriptor =
          MethodDescriptor.<CreateRolloutKindRequest, RolloutKind>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/CreateRolloutKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRolloutKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RolloutKind.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRolloutKindRequest, RolloutKind>
      updateRolloutKindMethodDescriptor =
          MethodDescriptor.<UpdateRolloutKindRequest, RolloutKind>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/UpdateRolloutKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRolloutKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RolloutKind.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRolloutKindRequest, Empty>
      deleteRolloutKindMethodDescriptor =
          MethodDescriptor.<DeleteRolloutKindRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/DeleteRolloutKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRolloutKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable;
  private final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable;
  private final UnaryCallable<CreateRolloutRequest, Rollout> createRolloutCallable;
  private final UnaryCallable<UpdateRolloutRequest, Rollout> updateRolloutCallable;
  private final UnaryCallable<DeleteRolloutRequest, Empty> deleteRolloutCallable;
  private final UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsCallable;
  private final UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsPagedResponse>
      listRolloutKindsPagedCallable;
  private final UnaryCallable<GetRolloutKindRequest, RolloutKind> getRolloutKindCallable;
  private final UnaryCallable<CreateRolloutKindRequest, RolloutKind> createRolloutKindCallable;
  private final UnaryCallable<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindCallable;
  private final UnaryCallable<DeleteRolloutKindRequest, Empty> deleteRolloutKindCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSaasRolloutsStub create(SaasRolloutsStubSettings settings)
      throws IOException {
    return new GrpcSaasRolloutsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSaasRolloutsStub create(ClientContext clientContext) throws IOException {
    return new GrpcSaasRolloutsStub(SaasRolloutsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSaasRolloutsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSaasRolloutsStub(
        SaasRolloutsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSaasRolloutsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSaasRolloutsStub(SaasRolloutsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSaasRolloutsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSaasRolloutsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSaasRolloutsStub(
      SaasRolloutsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRolloutsRequest, ListRolloutsResponse> listRolloutsTransportSettings =
        GrpcCallSettings.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
            .setMethodDescriptor(listRolloutsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRolloutRequest, Rollout> getRolloutTransportSettings =
        GrpcCallSettings.<GetRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRolloutRequest, Rollout> createRolloutTransportSettings =
        GrpcCallSettings.<CreateRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(createRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRolloutRequest, Rollout> updateRolloutTransportSettings =
        GrpcCallSettings.<UpdateRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(updateRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("rollout.name", String.valueOf(request.getRollout().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRolloutRequest, Empty> deleteRolloutTransportSettings =
        GrpcCallSettings.<DeleteRolloutRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRolloutKindsRequest, ListRolloutKindsResponse>
        listRolloutKindsTransportSettings =
            GrpcCallSettings.<ListRolloutKindsRequest, ListRolloutKindsResponse>newBuilder()
                .setMethodDescriptor(listRolloutKindsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRolloutKindRequest, RolloutKind> getRolloutKindTransportSettings =
        GrpcCallSettings.<GetRolloutKindRequest, RolloutKind>newBuilder()
            .setMethodDescriptor(getRolloutKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRolloutKindRequest, RolloutKind> createRolloutKindTransportSettings =
        GrpcCallSettings.<CreateRolloutKindRequest, RolloutKind>newBuilder()
            .setMethodDescriptor(createRolloutKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindTransportSettings =
        GrpcCallSettings.<UpdateRolloutKindRequest, RolloutKind>newBuilder()
            .setMethodDescriptor(updateRolloutKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "rollout_kind.name", String.valueOf(request.getRolloutKind().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRolloutKindRequest, Empty> deleteRolloutKindTransportSettings =
        GrpcCallSettings.<DeleteRolloutKindRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRolloutKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listRolloutsCallable =
        callableFactory.createUnaryCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.listRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.getRolloutCallable =
        callableFactory.createUnaryCallable(
            getRolloutTransportSettings, settings.getRolloutSettings(), clientContext);
    this.createRolloutCallable =
        callableFactory.createUnaryCallable(
            createRolloutTransportSettings, settings.createRolloutSettings(), clientContext);
    this.updateRolloutCallable =
        callableFactory.createUnaryCallable(
            updateRolloutTransportSettings, settings.updateRolloutSettings(), clientContext);
    this.deleteRolloutCallable =
        callableFactory.createUnaryCallable(
            deleteRolloutTransportSettings, settings.deleteRolloutSettings(), clientContext);
    this.listRolloutKindsCallable =
        callableFactory.createUnaryCallable(
            listRolloutKindsTransportSettings, settings.listRolloutKindsSettings(), clientContext);
    this.listRolloutKindsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutKindsTransportSettings, settings.listRolloutKindsSettings(), clientContext);
    this.getRolloutKindCallable =
        callableFactory.createUnaryCallable(
            getRolloutKindTransportSettings, settings.getRolloutKindSettings(), clientContext);
    this.createRolloutKindCallable =
        callableFactory.createUnaryCallable(
            createRolloutKindTransportSettings,
            settings.createRolloutKindSettings(),
            clientContext);
    this.updateRolloutKindCallable =
        callableFactory.createUnaryCallable(
            updateRolloutKindTransportSettings,
            settings.updateRolloutKindSettings(),
            clientContext);
    this.deleteRolloutKindCallable =
        callableFactory.createUnaryCallable(
            deleteRolloutKindTransportSettings,
            settings.deleteRolloutKindSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return listRolloutsCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    return listRolloutsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return getRolloutCallable;
  }

  @Override
  public UnaryCallable<CreateRolloutRequest, Rollout> createRolloutCallable() {
    return createRolloutCallable;
  }

  @Override
  public UnaryCallable<UpdateRolloutRequest, Rollout> updateRolloutCallable() {
    return updateRolloutCallable;
  }

  @Override
  public UnaryCallable<DeleteRolloutRequest, Empty> deleteRolloutCallable() {
    return deleteRolloutCallable;
  }

  @Override
  public UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsCallable() {
    return listRolloutKindsCallable;
  }

  @Override
  public UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsPagedResponse>
      listRolloutKindsPagedCallable() {
    return listRolloutKindsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRolloutKindRequest, RolloutKind> getRolloutKindCallable() {
    return getRolloutKindCallable;
  }

  @Override
  public UnaryCallable<CreateRolloutKindRequest, RolloutKind> createRolloutKindCallable() {
    return createRolloutKindCallable;
  }

  @Override
  public UnaryCallable<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindCallable() {
    return updateRolloutKindCallable;
  }

  @Override
  public UnaryCallable<DeleteRolloutKindRequest, Empty> deleteRolloutKindCallable() {
    return deleteRolloutKindCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
