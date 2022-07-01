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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.SessionEntityTypesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.CreateSessionEntityTypeRequest;
import com.google.cloud.dialogflow.v2.DeleteSessionEntityTypeRequest;
import com.google.cloud.dialogflow.v2.GetSessionEntityTypeRequest;
import com.google.cloud.dialogflow.v2.ListSessionEntityTypesRequest;
import com.google.cloud.dialogflow.v2.ListSessionEntityTypesResponse;
import com.google.cloud.dialogflow.v2.SessionEntityType;
import com.google.cloud.dialogflow.v2.UpdateSessionEntityTypeRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the SessionEntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSessionEntityTypesStub extends SessionEntityTypesStub {
  private static final MethodDescriptor<
          ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesMethodDescriptor =
          MethodDescriptor
              .<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.SessionEntityTypes/ListSessionEntityTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSessionEntityTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSessionEntityTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeMethodDescriptor =
          MethodDescriptor.<GetSessionEntityTypeRequest, SessionEntityType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.SessionEntityTypes/GetSessionEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SessionEntityType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeMethodDescriptor =
          MethodDescriptor.<CreateSessionEntityTypeRequest, SessionEntityType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.SessionEntityTypes/CreateSessionEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SessionEntityType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeMethodDescriptor =
          MethodDescriptor.<UpdateSessionEntityTypeRequest, SessionEntityType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.SessionEntityTypes/UpdateSessionEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSessionEntityTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SessionEntityType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSessionEntityTypeRequest, Empty>
      deleteSessionEntityTypeMethodDescriptor =
          MethodDescriptor.<DeleteSessionEntityTypeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.SessionEntityTypes/DeleteSessionEntityType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSessionEntityTypeRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesCallable;
  private final UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesPagedResponse>
      listSessionEntityTypesPagedCallable;
  private final UnaryCallable<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeCallable;
  private final UnaryCallable<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeCallable;
  private final UnaryCallable<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeCallable;
  private final UnaryCallable<DeleteSessionEntityTypeRequest, Empty>
      deleteSessionEntityTypeCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSessionEntityTypesStub create(SessionEntityTypesStubSettings settings)
      throws IOException {
    return new GrpcSessionEntityTypesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSessionEntityTypesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSessionEntityTypesStub(
        SessionEntityTypesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSessionEntityTypesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSessionEntityTypesStub(
        SessionEntityTypesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSessionEntityTypesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSessionEntityTypesStub(
      SessionEntityTypesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSessionEntityTypesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSessionEntityTypesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSessionEntityTypesStub(
      SessionEntityTypesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
        listSessionEntityTypesTransportSettings =
            GrpcCallSettings
                .<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>newBuilder()
                .setMethodDescriptor(listSessionEntityTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetSessionEntityTypeRequest, SessionEntityType>
        getSessionEntityTypeTransportSettings =
            GrpcCallSettings.<GetSessionEntityTypeRequest, SessionEntityType>newBuilder()
                .setMethodDescriptor(getSessionEntityTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateSessionEntityTypeRequest, SessionEntityType>
        createSessionEntityTypeTransportSettings =
            GrpcCallSettings.<CreateSessionEntityTypeRequest, SessionEntityType>newBuilder()
                .setMethodDescriptor(createSessionEntityTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateSessionEntityTypeRequest, SessionEntityType>
        updateSessionEntityTypeTransportSettings =
            GrpcCallSettings.<UpdateSessionEntityTypeRequest, SessionEntityType>newBuilder()
                .setMethodDescriptor(updateSessionEntityTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "session_entity_type.name",
                          String.valueOf(request.getSessionEntityType().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteSessionEntityTypeRequest, Empty>
        deleteSessionEntityTypeTransportSettings =
            GrpcCallSettings.<DeleteSessionEntityTypeRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSessionEntityTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listSessionEntityTypesCallable =
        callableFactory.createUnaryCallable(
            listSessionEntityTypesTransportSettings,
            settings.listSessionEntityTypesSettings(),
            clientContext);
    this.listSessionEntityTypesPagedCallable =
        callableFactory.createPagedCallable(
            listSessionEntityTypesTransportSettings,
            settings.listSessionEntityTypesSettings(),
            clientContext);
    this.getSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            getSessionEntityTypeTransportSettings,
            settings.getSessionEntityTypeSettings(),
            clientContext);
    this.createSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            createSessionEntityTypeTransportSettings,
            settings.createSessionEntityTypeSettings(),
            clientContext);
    this.updateSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            updateSessionEntityTypeTransportSettings,
            settings.updateSessionEntityTypeSettings(),
            clientContext);
    this.deleteSessionEntityTypeCallable =
        callableFactory.createUnaryCallable(
            deleteSessionEntityTypeTransportSettings,
            settings.deleteSessionEntityTypeSettings(),
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
  public UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesCallable() {
    return listSessionEntityTypesCallable;
  }

  @Override
  public UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesPagedResponse>
      listSessionEntityTypesPagedCallable() {
    return listSessionEntityTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeCallable() {
    return getSessionEntityTypeCallable;
  }

  @Override
  public UnaryCallable<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeCallable() {
    return createSessionEntityTypeCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeCallable() {
    return updateSessionEntityTypeCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionEntityTypeRequest, Empty> deleteSessionEntityTypeCallable() {
    return deleteSessionEntityTypeCallable;
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
