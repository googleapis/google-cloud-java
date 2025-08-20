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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListInsightsConfigsPagedResponse;
import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.GetInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.InsightsConfig;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the InsightsConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcInsightsConfigServiceStub extends InsightsConfigServiceStub {
  private static final MethodDescriptor<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsMethodDescriptor =
          MethodDescriptor.<ListInsightsConfigsRequest, ListInsightsConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/ListInsightsConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInsightsConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInsightsConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInsightsConfigRequest, Operation>
      createInsightsConfigMethodDescriptor =
          MethodDescriptor.<CreateInsightsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/CreateInsightsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInsightsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInsightsConfigRequest, InsightsConfig>
      getInsightsConfigMethodDescriptor =
          MethodDescriptor.<GetInsightsConfigRequest, InsightsConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/GetInsightsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInsightsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InsightsConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInsightsConfigRequest, Operation>
      updateInsightsConfigMethodDescriptor =
          MethodDescriptor.<UpdateInsightsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/UpdateInsightsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInsightsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInsightsConfigRequest, Operation>
      deleteInsightsConfigMethodDescriptor =
          MethodDescriptor.<DeleteInsightsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/DeleteInsightsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInsightsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsCallable;
  private final UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsPagedResponse>
      listInsightsConfigsPagedCallable;
  private final UnaryCallable<CreateInsightsConfigRequest, Operation> createInsightsConfigCallable;
  private final OperationCallable<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationCallable;
  private final UnaryCallable<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigCallable;
  private final UnaryCallable<UpdateInsightsConfigRequest, Operation> updateInsightsConfigCallable;
  private final OperationCallable<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationCallable;
  private final UnaryCallable<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigCallable;
  private final OperationCallable<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcInsightsConfigServiceStub create(
      InsightsConfigServiceStubSettings settings) throws IOException {
    return new GrpcInsightsConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcInsightsConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcInsightsConfigServiceStub(
        InsightsConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcInsightsConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcInsightsConfigServiceStub(
        InsightsConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcInsightsConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcInsightsConfigServiceStub(
      InsightsConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcInsightsConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcInsightsConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcInsightsConfigServiceStub(
      InsightsConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
        listInsightsConfigsTransportSettings =
            GrpcCallSettings.<ListInsightsConfigsRequest, ListInsightsConfigsResponse>newBuilder()
                .setMethodDescriptor(listInsightsConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateInsightsConfigRequest, Operation> createInsightsConfigTransportSettings =
        GrpcCallSettings.<CreateInsightsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createInsightsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigTransportSettings =
        GrpcCallSettings.<GetInsightsConfigRequest, InsightsConfig>newBuilder()
            .setMethodDescriptor(getInsightsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateInsightsConfigRequest, Operation> updateInsightsConfigTransportSettings =
        GrpcCallSettings.<UpdateInsightsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInsightsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "insights_config.name",
                      String.valueOf(request.getInsightsConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigTransportSettings =
        GrpcCallSettings.<DeleteInsightsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInsightsConfigMethodDescriptor)
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

    this.listInsightsConfigsCallable =
        callableFactory.createUnaryCallable(
            listInsightsConfigsTransportSettings,
            settings.listInsightsConfigsSettings(),
            clientContext);
    this.listInsightsConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listInsightsConfigsTransportSettings,
            settings.listInsightsConfigsSettings(),
            clientContext);
    this.createInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            createInsightsConfigTransportSettings,
            settings.createInsightsConfigSettings(),
            clientContext);
    this.createInsightsConfigOperationCallable =
        callableFactory.createOperationCallable(
            createInsightsConfigTransportSettings,
            settings.createInsightsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.getInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            getInsightsConfigTransportSettings,
            settings.getInsightsConfigSettings(),
            clientContext);
    this.updateInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            updateInsightsConfigTransportSettings,
            settings.updateInsightsConfigSettings(),
            clientContext);
    this.updateInsightsConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateInsightsConfigTransportSettings,
            settings.updateInsightsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            deleteInsightsConfigTransportSettings,
            settings.deleteInsightsConfigSettings(),
            clientContext);
    this.deleteInsightsConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteInsightsConfigTransportSettings,
            settings.deleteInsightsConfigOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsCallable() {
    return listInsightsConfigsCallable;
  }

  @Override
  public UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsPagedResponse>
      listInsightsConfigsPagedCallable() {
    return listInsightsConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateInsightsConfigRequest, Operation> createInsightsConfigCallable() {
    return createInsightsConfigCallable;
  }

  @Override
  public OperationCallable<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationCallable() {
    return createInsightsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigCallable() {
    return getInsightsConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateInsightsConfigRequest, Operation> updateInsightsConfigCallable() {
    return updateInsightsConfigCallable;
  }

  @Override
  public OperationCallable<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationCallable() {
    return updateInsightsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigCallable() {
    return deleteInsightsConfigCallable;
  }

  @Override
  public OperationCallable<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationCallable() {
    return deleteInsightsConfigOperationCallable;
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
