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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListCloudControlsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListFrameworksPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CloudControl;
import com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.Framework;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest;
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
 * gRPC stub implementation for the Config service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConfigStub extends ConfigStub {
  private static final MethodDescriptor<ListFrameworksRequest, ListFrameworksResponse>
      listFrameworksMethodDescriptor =
          MethodDescriptor.<ListFrameworksRequest, ListFrameworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/ListFrameworks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFrameworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFrameworksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFrameworkRequest, Framework>
      getFrameworkMethodDescriptor =
          MethodDescriptor.<GetFrameworkRequest, Framework>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/GetFramework")
              .setRequestMarshaller(ProtoUtils.marshaller(GetFrameworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Framework.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFrameworkRequest, Framework>
      createFrameworkMethodDescriptor =
          MethodDescriptor.<CreateFrameworkRequest, Framework>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/CreateFramework")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFrameworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Framework.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFrameworkRequest, Framework>
      updateFrameworkMethodDescriptor =
          MethodDescriptor.<UpdateFrameworkRequest, Framework>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/UpdateFramework")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFrameworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Framework.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFrameworkRequest, Empty>
      deleteFrameworkMethodDescriptor =
          MethodDescriptor.<DeleteFrameworkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/DeleteFramework")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFrameworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsMethodDescriptor =
          MethodDescriptor.<ListCloudControlsRequest, ListCloudControlsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/ListCloudControls")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCloudControlsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCloudControlsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCloudControlRequest, CloudControl>
      getCloudControlMethodDescriptor =
          MethodDescriptor.<GetCloudControlRequest, CloudControl>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Config/GetCloudControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCloudControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudControl.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCloudControlRequest, CloudControl>
      createCloudControlMethodDescriptor =
          MethodDescriptor.<CreateCloudControlRequest, CloudControl>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Config/CreateCloudControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCloudControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudControl.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCloudControlRequest, CloudControl>
      updateCloudControlMethodDescriptor =
          MethodDescriptor.<UpdateCloudControlRequest, CloudControl>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Config/UpdateCloudControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCloudControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CloudControl.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCloudControlRequest, Empty>
      deleteCloudControlMethodDescriptor =
          MethodDescriptor.<DeleteCloudControlRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Config/DeleteCloudControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCloudControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListFrameworksRequest, ListFrameworksResponse> listFrameworksCallable;
  private final UnaryCallable<ListFrameworksRequest, ListFrameworksPagedResponse>
      listFrameworksPagedCallable;
  private final UnaryCallable<GetFrameworkRequest, Framework> getFrameworkCallable;
  private final UnaryCallable<CreateFrameworkRequest, Framework> createFrameworkCallable;
  private final UnaryCallable<UpdateFrameworkRequest, Framework> updateFrameworkCallable;
  private final UnaryCallable<DeleteFrameworkRequest, Empty> deleteFrameworkCallable;
  private final UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsCallable;
  private final UnaryCallable<ListCloudControlsRequest, ListCloudControlsPagedResponse>
      listCloudControlsPagedCallable;
  private final UnaryCallable<GetCloudControlRequest, CloudControl> getCloudControlCallable;
  private final UnaryCallable<CreateCloudControlRequest, CloudControl> createCloudControlCallable;
  private final UnaryCallable<UpdateCloudControlRequest, CloudControl> updateCloudControlCallable;
  private final UnaryCallable<DeleteCloudControlRequest, Empty> deleteCloudControlCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConfigStub create(ConfigStubSettings settings) throws IOException {
    return new GrpcConfigStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfigStub create(ClientContext clientContext) throws IOException {
    return new GrpcConfigStub(ConfigStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConfigStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConfigStub(
        ConfigStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConfigStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcConfigStub(ConfigStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConfigCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConfigStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcConfigStub(
      ConfigStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListFrameworksRequest, ListFrameworksResponse>
        listFrameworksTransportSettings =
            GrpcCallSettings.<ListFrameworksRequest, ListFrameworksResponse>newBuilder()
                .setMethodDescriptor(listFrameworksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFrameworkRequest, Framework> getFrameworkTransportSettings =
        GrpcCallSettings.<GetFrameworkRequest, Framework>newBuilder()
            .setMethodDescriptor(getFrameworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFrameworkRequest, Framework> createFrameworkTransportSettings =
        GrpcCallSettings.<CreateFrameworkRequest, Framework>newBuilder()
            .setMethodDescriptor(createFrameworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFrameworkRequest, Framework> updateFrameworkTransportSettings =
        GrpcCallSettings.<UpdateFrameworkRequest, Framework>newBuilder()
            .setMethodDescriptor(updateFrameworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("framework.name", String.valueOf(request.getFramework().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFrameworkRequest, Empty> deleteFrameworkTransportSettings =
        GrpcCallSettings.<DeleteFrameworkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFrameworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCloudControlsRequest, ListCloudControlsResponse>
        listCloudControlsTransportSettings =
            GrpcCallSettings.<ListCloudControlsRequest, ListCloudControlsResponse>newBuilder()
                .setMethodDescriptor(listCloudControlsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCloudControlRequest, CloudControl> getCloudControlTransportSettings =
        GrpcCallSettings.<GetCloudControlRequest, CloudControl>newBuilder()
            .setMethodDescriptor(getCloudControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCloudControlRequest, CloudControl> createCloudControlTransportSettings =
        GrpcCallSettings.<CreateCloudControlRequest, CloudControl>newBuilder()
            .setMethodDescriptor(createCloudControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCloudControlRequest, CloudControl> updateCloudControlTransportSettings =
        GrpcCallSettings.<UpdateCloudControlRequest, CloudControl>newBuilder()
            .setMethodDescriptor(updateCloudControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "cloud_control.name", String.valueOf(request.getCloudControl().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCloudControlRequest, Empty> deleteCloudControlTransportSettings =
        GrpcCallSettings.<DeleteCloudControlRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCloudControlMethodDescriptor)
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

    this.listFrameworksCallable =
        callableFactory.createUnaryCallable(
            listFrameworksTransportSettings, settings.listFrameworksSettings(), clientContext);
    this.listFrameworksPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworksTransportSettings, settings.listFrameworksSettings(), clientContext);
    this.getFrameworkCallable =
        callableFactory.createUnaryCallable(
            getFrameworkTransportSettings, settings.getFrameworkSettings(), clientContext);
    this.createFrameworkCallable =
        callableFactory.createUnaryCallable(
            createFrameworkTransportSettings, settings.createFrameworkSettings(), clientContext);
    this.updateFrameworkCallable =
        callableFactory.createUnaryCallable(
            updateFrameworkTransportSettings, settings.updateFrameworkSettings(), clientContext);
    this.deleteFrameworkCallable =
        callableFactory.createUnaryCallable(
            deleteFrameworkTransportSettings, settings.deleteFrameworkSettings(), clientContext);
    this.listCloudControlsCallable =
        callableFactory.createUnaryCallable(
            listCloudControlsTransportSettings,
            settings.listCloudControlsSettings(),
            clientContext);
    this.listCloudControlsPagedCallable =
        callableFactory.createPagedCallable(
            listCloudControlsTransportSettings,
            settings.listCloudControlsSettings(),
            clientContext);
    this.getCloudControlCallable =
        callableFactory.createUnaryCallable(
            getCloudControlTransportSettings, settings.getCloudControlSettings(), clientContext);
    this.createCloudControlCallable =
        callableFactory.createUnaryCallable(
            createCloudControlTransportSettings,
            settings.createCloudControlSettings(),
            clientContext);
    this.updateCloudControlCallable =
        callableFactory.createUnaryCallable(
            updateCloudControlTransportSettings,
            settings.updateCloudControlSettings(),
            clientContext);
    this.deleteCloudControlCallable =
        callableFactory.createUnaryCallable(
            deleteCloudControlTransportSettings,
            settings.deleteCloudControlSettings(),
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
  public UnaryCallable<ListFrameworksRequest, ListFrameworksResponse> listFrameworksCallable() {
    return listFrameworksCallable;
  }

  @Override
  public UnaryCallable<ListFrameworksRequest, ListFrameworksPagedResponse>
      listFrameworksPagedCallable() {
    return listFrameworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetFrameworkRequest, Framework> getFrameworkCallable() {
    return getFrameworkCallable;
  }

  @Override
  public UnaryCallable<CreateFrameworkRequest, Framework> createFrameworkCallable() {
    return createFrameworkCallable;
  }

  @Override
  public UnaryCallable<UpdateFrameworkRequest, Framework> updateFrameworkCallable() {
    return updateFrameworkCallable;
  }

  @Override
  public UnaryCallable<DeleteFrameworkRequest, Empty> deleteFrameworkCallable() {
    return deleteFrameworkCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsCallable() {
    return listCloudControlsCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlsRequest, ListCloudControlsPagedResponse>
      listCloudControlsPagedCallable() {
    return listCloudControlsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudControlRequest, CloudControl> getCloudControlCallable() {
    return getCloudControlCallable;
  }

  @Override
  public UnaryCallable<CreateCloudControlRequest, CloudControl> createCloudControlCallable() {
    return createCloudControlCallable;
  }

  @Override
  public UnaryCallable<UpdateCloudControlRequest, CloudControl> updateCloudControlCallable() {
    return updateCloudControlCallable;
  }

  @Override
  public UnaryCallable<DeleteCloudControlRequest, Empty> deleteCloudControlCallable() {
    return deleteCloudControlCallable;
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
