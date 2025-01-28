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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListSipTrunksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse;
import com.google.cloud.dialogflow.v2beta1.SipTrunk;
import com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SipTrunks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSipTrunksStub extends SipTrunksStub {
  private static final MethodDescriptor<CreateSipTrunkRequest, SipTrunk>
      createSipTrunkMethodDescriptor =
          MethodDescriptor.<CreateSipTrunkRequest, SipTrunk>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/CreateSipTrunk")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSipTrunkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SipTrunk.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSipTrunkRequest, Empty>
      deleteSipTrunkMethodDescriptor =
          MethodDescriptor.<DeleteSipTrunkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/DeleteSipTrunk")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSipTrunkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSipTrunksRequest, ListSipTrunksResponse>
      listSipTrunksMethodDescriptor =
          MethodDescriptor.<ListSipTrunksRequest, ListSipTrunksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/ListSipTrunks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSipTrunksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSipTrunksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSipTrunkRequest, SipTrunk> getSipTrunkMethodDescriptor =
      MethodDescriptor.<GetSipTrunkRequest, SipTrunk>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/GetSipTrunk")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSipTrunkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SipTrunk.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSipTrunkRequest, SipTrunk>
      updateSipTrunkMethodDescriptor =
          MethodDescriptor.<UpdateSipTrunkRequest, SipTrunk>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.SipTrunks/UpdateSipTrunk")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSipTrunkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SipTrunk.getDefaultInstance()))
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

  private final UnaryCallable<CreateSipTrunkRequest, SipTrunk> createSipTrunkCallable;
  private final UnaryCallable<DeleteSipTrunkRequest, Empty> deleteSipTrunkCallable;
  private final UnaryCallable<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksCallable;
  private final UnaryCallable<ListSipTrunksRequest, ListSipTrunksPagedResponse>
      listSipTrunksPagedCallable;
  private final UnaryCallable<GetSipTrunkRequest, SipTrunk> getSipTrunkCallable;
  private final UnaryCallable<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSipTrunksStub create(SipTrunksStubSettings settings) throws IOException {
    return new GrpcSipTrunksStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSipTrunksStub create(ClientContext clientContext) throws IOException {
    return new GrpcSipTrunksStub(SipTrunksStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSipTrunksStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSipTrunksStub(
        SipTrunksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSipTrunksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSipTrunksStub(SipTrunksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSipTrunksCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSipTrunksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSipTrunksStub(
      SipTrunksStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSipTrunkRequest, SipTrunk> createSipTrunkTransportSettings =
        GrpcCallSettings.<CreateSipTrunkRequest, SipTrunk>newBuilder()
            .setMethodDescriptor(createSipTrunkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSipTrunkRequest, Empty> deleteSipTrunkTransportSettings =
        GrpcCallSettings.<DeleteSipTrunkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSipTrunkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksTransportSettings =
        GrpcCallSettings.<ListSipTrunksRequest, ListSipTrunksResponse>newBuilder()
            .setMethodDescriptor(listSipTrunksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSipTrunkRequest, SipTrunk> getSipTrunkTransportSettings =
        GrpcCallSettings.<GetSipTrunkRequest, SipTrunk>newBuilder()
            .setMethodDescriptor(getSipTrunkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkTransportSettings =
        GrpcCallSettings.<UpdateSipTrunkRequest, SipTrunk>newBuilder()
            .setMethodDescriptor(updateSipTrunkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("sip_trunk.name", String.valueOf(request.getSipTrunk().getName()));
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

    this.createSipTrunkCallable =
        callableFactory.createUnaryCallable(
            createSipTrunkTransportSettings, settings.createSipTrunkSettings(), clientContext);
    this.deleteSipTrunkCallable =
        callableFactory.createUnaryCallable(
            deleteSipTrunkTransportSettings, settings.deleteSipTrunkSettings(), clientContext);
    this.listSipTrunksCallable =
        callableFactory.createUnaryCallable(
            listSipTrunksTransportSettings, settings.listSipTrunksSettings(), clientContext);
    this.listSipTrunksPagedCallable =
        callableFactory.createPagedCallable(
            listSipTrunksTransportSettings, settings.listSipTrunksSettings(), clientContext);
    this.getSipTrunkCallable =
        callableFactory.createUnaryCallable(
            getSipTrunkTransportSettings, settings.getSipTrunkSettings(), clientContext);
    this.updateSipTrunkCallable =
        callableFactory.createUnaryCallable(
            updateSipTrunkTransportSettings, settings.updateSipTrunkSettings(), clientContext);
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
  public UnaryCallable<CreateSipTrunkRequest, SipTrunk> createSipTrunkCallable() {
    return createSipTrunkCallable;
  }

  @Override
  public UnaryCallable<DeleteSipTrunkRequest, Empty> deleteSipTrunkCallable() {
    return deleteSipTrunkCallable;
  }

  @Override
  public UnaryCallable<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksCallable() {
    return listSipTrunksCallable;
  }

  @Override
  public UnaryCallable<ListSipTrunksRequest, ListSipTrunksPagedResponse>
      listSipTrunksPagedCallable() {
    return listSipTrunksPagedCallable;
  }

  @Override
  public UnaryCallable<GetSipTrunkRequest, SipTrunk> getSipTrunkCallable() {
    return getSipTrunkCallable;
  }

  @Override
  public UnaryCallable<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkCallable() {
    return updateSipTrunkCallable;
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
