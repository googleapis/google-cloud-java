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

package com.google.maps.solar.v1.stub;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.solar.v1.BuildingInsights;
import com.google.maps.solar.v1.DataLayers;
import com.google.maps.solar.v1.FindClosestBuildingInsightsRequest;
import com.google.maps.solar.v1.GetDataLayersRequest;
import com.google.maps.solar.v1.GetGeoTiffRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Solar service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSolarStub extends SolarStub {
  private static final MethodDescriptor<FindClosestBuildingInsightsRequest, BuildingInsights>
      findClosestBuildingInsightsMethodDescriptor =
          MethodDescriptor.<FindClosestBuildingInsightsRequest, BuildingInsights>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.solar.v1.Solar/FindClosestBuildingInsights")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FindClosestBuildingInsightsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BuildingInsights.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataLayersRequest, DataLayers>
      getDataLayersMethodDescriptor =
          MethodDescriptor.<GetDataLayersRequest, DataLayers>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.solar.v1.Solar/GetDataLayers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataLayersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataLayers.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGeoTiffRequest, HttpBody> getGeoTiffMethodDescriptor =
      MethodDescriptor.<GetGeoTiffRequest, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.maps.solar.v1.Solar/GetGeoTiff")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGeoTiffRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private final UnaryCallable<FindClosestBuildingInsightsRequest, BuildingInsights>
      findClosestBuildingInsightsCallable;
  private final UnaryCallable<GetDataLayersRequest, DataLayers> getDataLayersCallable;
  private final UnaryCallable<GetGeoTiffRequest, HttpBody> getGeoTiffCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSolarStub create(SolarStubSettings settings) throws IOException {
    return new GrpcSolarStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSolarStub create(ClientContext clientContext) throws IOException {
    return new GrpcSolarStub(SolarStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSolarStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSolarStub(
        SolarStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSolarStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSolarStub(SolarStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSolarCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSolarStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSolarStub(
      SolarStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<FindClosestBuildingInsightsRequest, BuildingInsights>
        findClosestBuildingInsightsTransportSettings =
            GrpcCallSettings.<FindClosestBuildingInsightsRequest, BuildingInsights>newBuilder()
                .setMethodDescriptor(findClosestBuildingInsightsMethodDescriptor)
                .build();
    GrpcCallSettings<GetDataLayersRequest, DataLayers> getDataLayersTransportSettings =
        GrpcCallSettings.<GetDataLayersRequest, DataLayers>newBuilder()
            .setMethodDescriptor(getDataLayersMethodDescriptor)
            .build();
    GrpcCallSettings<GetGeoTiffRequest, HttpBody> getGeoTiffTransportSettings =
        GrpcCallSettings.<GetGeoTiffRequest, HttpBody>newBuilder()
            .setMethodDescriptor(getGeoTiffMethodDescriptor)
            .build();

    this.findClosestBuildingInsightsCallable =
        callableFactory.createUnaryCallable(
            findClosestBuildingInsightsTransportSettings,
            settings.findClosestBuildingInsightsSettings(),
            clientContext);
    this.getDataLayersCallable =
        callableFactory.createUnaryCallable(
            getDataLayersTransportSettings, settings.getDataLayersSettings(), clientContext);
    this.getGeoTiffCallable =
        callableFactory.createUnaryCallable(
            getGeoTiffTransportSettings, settings.getGeoTiffSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<FindClosestBuildingInsightsRequest, BuildingInsights>
      findClosestBuildingInsightsCallable() {
    return findClosestBuildingInsightsCallable;
  }

  @Override
  public UnaryCallable<GetDataLayersRequest, DataLayers> getDataLayersCallable() {
    return getDataLayersCallable;
  }

  @Override
  public UnaryCallable<GetGeoTiffRequest, HttpBody> getGeoTiffCallable() {
    return getGeoTiffCallable;
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
