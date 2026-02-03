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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.CmEnrollmentServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse;
import com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest;
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
 * gRPC stub implementation for the CmEnrollmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCmEnrollmentServiceStub extends CmEnrollmentServiceStub {
  private static final MethodDescriptor<UpdateCmEnrollmentRequest, CmEnrollment>
      updateCmEnrollmentMethodDescriptor =
          MethodDescriptor.<UpdateCmEnrollmentRequest, CmEnrollment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.CmEnrollmentService/UpdateCmEnrollment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCmEnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CmEnrollment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
      calculateEffectiveCmEnrollmentMethodDescriptor =
          MethodDescriptor
              .<CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.CmEnrollmentService/CalculateEffectiveCmEnrollment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CalculateEffectiveCmEnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      CalculateEffectiveCmEnrollmentResponse.getDefaultInstance()))
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

  private final UnaryCallable<UpdateCmEnrollmentRequest, CmEnrollment> updateCmEnrollmentCallable;
  private final UnaryCallable<
          CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
      calculateEffectiveCmEnrollmentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCmEnrollmentServiceStub create(CmEnrollmentServiceStubSettings settings)
      throws IOException {
    return new GrpcCmEnrollmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCmEnrollmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCmEnrollmentServiceStub(
        CmEnrollmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCmEnrollmentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCmEnrollmentServiceStub(
        CmEnrollmentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCmEnrollmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCmEnrollmentServiceStub(
      CmEnrollmentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCmEnrollmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCmEnrollmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCmEnrollmentServiceStub(
      CmEnrollmentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<UpdateCmEnrollmentRequest, CmEnrollment> updateCmEnrollmentTransportSettings =
        GrpcCallSettings.<UpdateCmEnrollmentRequest, CmEnrollment>newBuilder()
            .setMethodDescriptor(updateCmEnrollmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "cm_enrollment.name", String.valueOf(request.getCmEnrollment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
        calculateEffectiveCmEnrollmentTransportSettings =
            GrpcCallSettings
                .<CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
                    newBuilder()
                .setMethodDescriptor(calculateEffectiveCmEnrollmentMethodDescriptor)
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

    this.updateCmEnrollmentCallable =
        callableFactory.createUnaryCallable(
            updateCmEnrollmentTransportSettings,
            settings.updateCmEnrollmentSettings(),
            clientContext);
    this.calculateEffectiveCmEnrollmentCallable =
        callableFactory.createUnaryCallable(
            calculateEffectiveCmEnrollmentTransportSettings,
            settings.calculateEffectiveCmEnrollmentSettings(),
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
  public UnaryCallable<UpdateCmEnrollmentRequest, CmEnrollment> updateCmEnrollmentCallable() {
    return updateCmEnrollmentCallable;
  }

  @Override
  public UnaryCallable<
          CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
      calculateEffectiveCmEnrollmentCallable() {
    return calculateEffectiveCmEnrollmentCallable;
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
