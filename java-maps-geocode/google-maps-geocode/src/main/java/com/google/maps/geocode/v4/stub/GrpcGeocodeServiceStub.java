/*
 * Copyright 2026 Google LLC
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

package com.google.maps.geocode.v4.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.geocode.v4.GeocodeAddressRequest;
import com.google.maps.geocode.v4.GeocodeAddressResponse;
import com.google.maps.geocode.v4.GeocodeLocationRequest;
import com.google.maps.geocode.v4.GeocodeLocationResponse;
import com.google.maps.geocode.v4.GeocodePlaceRequest;
import com.google.maps.geocode.v4.GeocodeResult;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GeocodeService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGeocodeServiceStub extends GeocodeServiceStub {
  private static final MethodDescriptor<GeocodeAddressRequest, GeocodeAddressResponse>
      geocodeAddressMethodDescriptor =
          MethodDescriptor.<GeocodeAddressRequest, GeocodeAddressResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.geocode.v4.GeocodeService/GeocodeAddress")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GeocodeAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GeocodeAddressResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GeocodeLocationRequest, GeocodeLocationResponse>
      geocodeLocationMethodDescriptor =
          MethodDescriptor.<GeocodeLocationRequest, GeocodeLocationResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.geocode.v4.GeocodeService/GeocodeLocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GeocodeLocationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GeocodeLocationResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GeocodePlaceRequest, GeocodeResult>
      geocodePlaceMethodDescriptor =
          MethodDescriptor.<GeocodePlaceRequest, GeocodeResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.geocode.v4.GeocodeService/GeocodePlace")
              .setRequestMarshaller(ProtoUtils.marshaller(GeocodePlaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GeocodeResult.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GeocodeAddressRequest, GeocodeAddressResponse> geocodeAddressCallable;
  private final UnaryCallable<GeocodeLocationRequest, GeocodeLocationResponse>
      geocodeLocationCallable;
  private final UnaryCallable<GeocodePlaceRequest, GeocodeResult> geocodePlaceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGeocodeServiceStub create(GeocodeServiceStubSettings settings)
      throws IOException {
    return new GrpcGeocodeServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGeocodeServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGeocodeServiceStub(
        GeocodeServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGeocodeServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGeocodeServiceStub(
        GeocodeServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGeocodeServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGeocodeServiceStub(GeocodeServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGeocodeServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGeocodeServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGeocodeServiceStub(
      GeocodeServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GeocodeAddressRequest, GeocodeAddressResponse>
        geocodeAddressTransportSettings =
            GrpcCallSettings.<GeocodeAddressRequest, GeocodeAddressResponse>newBuilder()
                .setMethodDescriptor(geocodeAddressMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("address_query", String.valueOf(request.getAddressQuery()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GeocodeLocationRequest, GeocodeLocationResponse>
        geocodeLocationTransportSettings =
            GrpcCallSettings.<GeocodeLocationRequest, GeocodeLocationResponse>newBuilder()
                .setMethodDescriptor(geocodeLocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location_query", String.valueOf(request.getLocationQuery()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GeocodePlaceRequest, GeocodeResult> geocodePlaceTransportSettings =
        GrpcCallSettings.<GeocodePlaceRequest, GeocodeResult>newBuilder()
            .setMethodDescriptor(geocodePlaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("place", String.valueOf(request.getPlace()));
                  return builder.build();
                })
            .build();

    this.geocodeAddressCallable =
        callableFactory.createUnaryCallable(
            geocodeAddressTransportSettings, settings.geocodeAddressSettings(), clientContext);
    this.geocodeLocationCallable =
        callableFactory.createUnaryCallable(
            geocodeLocationTransportSettings, settings.geocodeLocationSettings(), clientContext);
    this.geocodePlaceCallable =
        callableFactory.createUnaryCallable(
            geocodePlaceTransportSettings, settings.geocodePlaceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GeocodeAddressRequest, GeocodeAddressResponse> geocodeAddressCallable() {
    return geocodeAddressCallable;
  }

  @Override
  public UnaryCallable<GeocodeLocationRequest, GeocodeLocationResponse> geocodeLocationCallable() {
    return geocodeLocationCallable;
  }

  @Override
  public UnaryCallable<GeocodePlaceRequest, GeocodeResult> geocodePlaceCallable() {
    return geocodePlaceCallable;
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
