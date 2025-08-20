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

import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.PhoneNumbersClient.ListPhoneNumbersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.DeletePhoneNumberRequest;
import com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersRequest;
import com.google.cloud.dialogflow.v2beta1.ListPhoneNumbersResponse;
import com.google.cloud.dialogflow.v2beta1.PhoneNumber;
import com.google.cloud.dialogflow.v2beta1.UndeletePhoneNumberRequest;
import com.google.cloud.dialogflow.v2beta1.UpdatePhoneNumberRequest;
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
 * gRPC stub implementation for the PhoneNumbers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPhoneNumbersStub extends PhoneNumbersStub {
  private static final MethodDescriptor<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersMethodDescriptor =
          MethodDescriptor.<ListPhoneNumbersRequest, ListPhoneNumbersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/ListPhoneNumbers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPhoneNumbersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPhoneNumbersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePhoneNumberRequest, PhoneNumber>
      updatePhoneNumberMethodDescriptor =
          MethodDescriptor.<UpdatePhoneNumberRequest, PhoneNumber>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/UpdatePhoneNumber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePhoneNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhoneNumber.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePhoneNumberRequest, PhoneNumber>
      deletePhoneNumberMethodDescriptor =
          MethodDescriptor.<DeletePhoneNumberRequest, PhoneNumber>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/DeletePhoneNumber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePhoneNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhoneNumber.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UndeletePhoneNumberRequest, PhoneNumber>
      undeletePhoneNumberMethodDescriptor =
          MethodDescriptor.<UndeletePhoneNumberRequest, PhoneNumber>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.PhoneNumbers/UndeletePhoneNumber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeletePhoneNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhoneNumber.getDefaultInstance()))
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

  private final UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersCallable;
  private final UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersPagedResponse>
      listPhoneNumbersPagedCallable;
  private final UnaryCallable<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberCallable;
  private final UnaryCallable<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberCallable;
  private final UnaryCallable<UndeletePhoneNumberRequest, PhoneNumber> undeletePhoneNumberCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPhoneNumbersStub create(PhoneNumbersStubSettings settings)
      throws IOException {
    return new GrpcPhoneNumbersStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPhoneNumbersStub create(ClientContext clientContext) throws IOException {
    return new GrpcPhoneNumbersStub(PhoneNumbersStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPhoneNumbersStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPhoneNumbersStub(
        PhoneNumbersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPhoneNumbersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPhoneNumbersStub(PhoneNumbersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPhoneNumbersCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPhoneNumbersStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPhoneNumbersStub(
      PhoneNumbersStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
        listPhoneNumbersTransportSettings =
            GrpcCallSettings.<ListPhoneNumbersRequest, ListPhoneNumbersResponse>newBuilder()
                .setMethodDescriptor(listPhoneNumbersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberTransportSettings =
        GrpcCallSettings.<UpdatePhoneNumberRequest, PhoneNumber>newBuilder()
            .setMethodDescriptor(updatePhoneNumberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "phone_number.name", String.valueOf(request.getPhoneNumber().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberTransportSettings =
        GrpcCallSettings.<DeletePhoneNumberRequest, PhoneNumber>newBuilder()
            .setMethodDescriptor(deletePhoneNumberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeletePhoneNumberRequest, PhoneNumber> undeletePhoneNumberTransportSettings =
        GrpcCallSettings.<UndeletePhoneNumberRequest, PhoneNumber>newBuilder()
            .setMethodDescriptor(undeletePhoneNumberMethodDescriptor)
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

    this.listPhoneNumbersCallable =
        callableFactory.createUnaryCallable(
            listPhoneNumbersTransportSettings, settings.listPhoneNumbersSettings(), clientContext);
    this.listPhoneNumbersPagedCallable =
        callableFactory.createPagedCallable(
            listPhoneNumbersTransportSettings, settings.listPhoneNumbersSettings(), clientContext);
    this.updatePhoneNumberCallable =
        callableFactory.createUnaryCallable(
            updatePhoneNumberTransportSettings,
            settings.updatePhoneNumberSettings(),
            clientContext);
    this.deletePhoneNumberCallable =
        callableFactory.createUnaryCallable(
            deletePhoneNumberTransportSettings,
            settings.deletePhoneNumberSettings(),
            clientContext);
    this.undeletePhoneNumberCallable =
        callableFactory.createUnaryCallable(
            undeletePhoneNumberTransportSettings,
            settings.undeletePhoneNumberSettings(),
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
  public UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersCallable() {
    return listPhoneNumbersCallable;
  }

  @Override
  public UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersPagedResponse>
      listPhoneNumbersPagedCallable() {
    return listPhoneNumbersPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberCallable() {
    return updatePhoneNumberCallable;
  }

  @Override
  public UnaryCallable<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberCallable() {
    return deletePhoneNumberCallable;
  }

  @Override
  public UnaryCallable<UndeletePhoneNumberRequest, PhoneNumber> undeletePhoneNumberCallable() {
    return undeletePhoneNumberCallable;
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
