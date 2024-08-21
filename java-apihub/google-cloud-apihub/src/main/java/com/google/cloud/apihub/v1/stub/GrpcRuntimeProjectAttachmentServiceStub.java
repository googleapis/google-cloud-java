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

import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListRuntimeProjectAttachmentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest;
import com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse;
import com.google.cloud.apihub.v1.RuntimeProjectAttachment;
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
 * gRPC stub implementation for the RuntimeProjectAttachmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRuntimeProjectAttachmentServiceStub extends RuntimeProjectAttachmentServiceStub {
  private static final MethodDescriptor<
          CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentMethodDescriptor =
          MethodDescriptor
              .<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/CreateRuntimeProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRuntimeProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RuntimeProjectAttachment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentMethodDescriptor =
          MethodDescriptor
              .<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/GetRuntimeProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRuntimeProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RuntimeProjectAttachment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsMethodDescriptor =
          MethodDescriptor
              .<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/ListRuntimeProjectAttachments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRuntimeProjectAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuntimeProjectAttachmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentMethodDescriptor =
          MethodDescriptor.<DeleteRuntimeProjectAttachmentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/DeleteRuntimeProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRuntimeProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentMethodDescriptor =
          MethodDescriptor
              .<LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/LookupRuntimeProjectAttachment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LookupRuntimeProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      LookupRuntimeProjectAttachmentResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentCallable;
  private final UnaryCallable<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentCallable;
  private final UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsCallable;
  private final UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsPagedCallable;
  private final UnaryCallable<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentCallable;
  private final UnaryCallable<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRuntimeProjectAttachmentServiceStub create(
      RuntimeProjectAttachmentServiceStubSettings settings) throws IOException {
    return new GrpcRuntimeProjectAttachmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRuntimeProjectAttachmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRuntimeProjectAttachmentServiceStub(
        RuntimeProjectAttachmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRuntimeProjectAttachmentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRuntimeProjectAttachmentServiceStub(
        RuntimeProjectAttachmentServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcRuntimeProjectAttachmentServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcRuntimeProjectAttachmentServiceStub(
      RuntimeProjectAttachmentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRuntimeProjectAttachmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRuntimeProjectAttachmentServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcRuntimeProjectAttachmentServiceStub(
      RuntimeProjectAttachmentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        createRuntimeProjectAttachmentTransportSettings =
            GrpcCallSettings
                .<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
                .setMethodDescriptor(createRuntimeProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        getRuntimeProjectAttachmentTransportSettings =
            GrpcCallSettings
                .<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
                .setMethodDescriptor(getRuntimeProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
        listRuntimeProjectAttachmentsTransportSettings =
            GrpcCallSettings
                .<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
                    newBuilder()
                .setMethodDescriptor(listRuntimeProjectAttachmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteRuntimeProjectAttachmentRequest, Empty>
        deleteRuntimeProjectAttachmentTransportSettings =
            GrpcCallSettings.<DeleteRuntimeProjectAttachmentRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteRuntimeProjectAttachmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
        lookupRuntimeProjectAttachmentTransportSettings =
            GrpcCallSettings
                .<LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
                    newBuilder()
                .setMethodDescriptor(lookupRuntimeProjectAttachmentMethodDescriptor)
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

    this.createRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            createRuntimeProjectAttachmentTransportSettings,
            settings.createRuntimeProjectAttachmentSettings(),
            clientContext);
    this.getRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            getRuntimeProjectAttachmentTransportSettings,
            settings.getRuntimeProjectAttachmentSettings(),
            clientContext);
    this.listRuntimeProjectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listRuntimeProjectAttachmentsTransportSettings,
            settings.listRuntimeProjectAttachmentsSettings(),
            clientContext);
    this.listRuntimeProjectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listRuntimeProjectAttachmentsTransportSettings,
            settings.listRuntimeProjectAttachmentsSettings(),
            clientContext);
    this.deleteRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteRuntimeProjectAttachmentTransportSettings,
            settings.deleteRuntimeProjectAttachmentSettings(),
            clientContext);
    this.lookupRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            lookupRuntimeProjectAttachmentTransportSettings,
            settings.lookupRuntimeProjectAttachmentSettings(),
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
  public UnaryCallable<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentCallable() {
    return createRuntimeProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentCallable() {
    return getRuntimeProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsCallable() {
    return listRuntimeProjectAttachmentsCallable;
  }

  @Override
  public UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsPagedCallable() {
    return listRuntimeProjectAttachmentsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentCallable() {
    return deleteRuntimeProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentCallable() {
    return lookupRuntimeProjectAttachmentCallable;
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
