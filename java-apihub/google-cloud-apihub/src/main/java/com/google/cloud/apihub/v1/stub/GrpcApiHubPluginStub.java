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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.DisablePluginRequest;
import com.google.cloud.apihub.v1.EnablePluginRequest;
import com.google.cloud.apihub.v1.GetPluginRequest;
import com.google.cloud.apihub.v1.Plugin;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ApiHubPlugin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcApiHubPluginStub extends ApiHubPluginStub {
  private static final MethodDescriptor<GetPluginRequest, Plugin> getPluginMethodDescriptor =
      MethodDescriptor.<GetPluginRequest, Plugin>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/GetPlugin")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPluginRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Plugin.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<EnablePluginRequest, Plugin> enablePluginMethodDescriptor =
      MethodDescriptor.<EnablePluginRequest, Plugin>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/EnablePlugin")
          .setRequestMarshaller(ProtoUtils.marshaller(EnablePluginRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Plugin.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DisablePluginRequest, Plugin>
      disablePluginMethodDescriptor =
          MethodDescriptor.<DisablePluginRequest, Plugin>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHubPlugin/DisablePlugin")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisablePluginRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Plugin.getDefaultInstance()))
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

  private final UnaryCallable<GetPluginRequest, Plugin> getPluginCallable;
  private final UnaryCallable<EnablePluginRequest, Plugin> enablePluginCallable;
  private final UnaryCallable<DisablePluginRequest, Plugin> disablePluginCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApiHubPluginStub create(ApiHubPluginStubSettings settings)
      throws IOException {
    return new GrpcApiHubPluginStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApiHubPluginStub create(ClientContext clientContext) throws IOException {
    return new GrpcApiHubPluginStub(ApiHubPluginStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApiHubPluginStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApiHubPluginStub(
        ApiHubPluginStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApiHubPluginStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcApiHubPluginStub(ApiHubPluginStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcApiHubPluginCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApiHubPluginStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcApiHubPluginStub(
      ApiHubPluginStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetPluginRequest, Plugin> getPluginTransportSettings =
        GrpcCallSettings.<GetPluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(getPluginMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EnablePluginRequest, Plugin> enablePluginTransportSettings =
        GrpcCallSettings.<EnablePluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(enablePluginMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DisablePluginRequest, Plugin> disablePluginTransportSettings =
        GrpcCallSettings.<DisablePluginRequest, Plugin>newBuilder()
            .setMethodDescriptor(disablePluginMethodDescriptor)
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

    this.getPluginCallable =
        callableFactory.createUnaryCallable(
            getPluginTransportSettings, settings.getPluginSettings(), clientContext);
    this.enablePluginCallable =
        callableFactory.createUnaryCallable(
            enablePluginTransportSettings, settings.enablePluginSettings(), clientContext);
    this.disablePluginCallable =
        callableFactory.createUnaryCallable(
            disablePluginTransportSettings, settings.disablePluginSettings(), clientContext);
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
  public UnaryCallable<GetPluginRequest, Plugin> getPluginCallable() {
    return getPluginCallable;
  }

  @Override
  public UnaryCallable<EnablePluginRequest, Plugin> enablePluginCallable() {
    return enablePluginCallable;
  }

  @Override
  public UnaryCallable<DisablePluginRequest, Plugin> disablePluginCallable() {
    return disablePluginCallable;
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
