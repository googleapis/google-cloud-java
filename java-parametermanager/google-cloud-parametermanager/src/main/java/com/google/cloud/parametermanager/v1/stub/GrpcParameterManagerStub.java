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

package com.google.cloud.parametermanager.v1.stub;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.parametermanager.v1.CreateParameterRequest;
import com.google.cloud.parametermanager.v1.CreateParameterVersionRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterRequest;
import com.google.cloud.parametermanager.v1.DeleteParameterVersionRequest;
import com.google.cloud.parametermanager.v1.GetParameterRequest;
import com.google.cloud.parametermanager.v1.GetParameterVersionRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsRequest;
import com.google.cloud.parametermanager.v1.ListParameterVersionsResponse;
import com.google.cloud.parametermanager.v1.ListParametersRequest;
import com.google.cloud.parametermanager.v1.ListParametersResponse;
import com.google.cloud.parametermanager.v1.Parameter;
import com.google.cloud.parametermanager.v1.ParameterVersion;
import com.google.cloud.parametermanager.v1.RenderParameterVersionRequest;
import com.google.cloud.parametermanager.v1.RenderParameterVersionResponse;
import com.google.cloud.parametermanager.v1.UpdateParameterRequest;
import com.google.cloud.parametermanager.v1.UpdateParameterVersionRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ParameterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcParameterManagerStub extends ParameterManagerStub {
  private static final MethodDescriptor<ListParametersRequest, ListParametersResponse>
      listParametersMethodDescriptor =
          MethodDescriptor.<ListParametersRequest, ListParametersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/ListParameters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParametersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetParameterRequest, Parameter>
      getParameterMethodDescriptor =
          MethodDescriptor.<GetParameterRequest, Parameter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.parametermanager.v1.ParameterManager/GetParameter")
              .setRequestMarshaller(ProtoUtils.marshaller(GetParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Parameter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateParameterRequest, Parameter>
      createParameterMethodDescriptor =
          MethodDescriptor.<CreateParameterRequest, Parameter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateParameter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Parameter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateParameterRequest, Parameter>
      updateParameterMethodDescriptor =
          MethodDescriptor.<UpdateParameterRequest, Parameter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateParameter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Parameter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteParameterRequest, Empty>
      deleteParameterMethodDescriptor =
          MethodDescriptor.<DeleteParameterRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteParameter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteParameterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsMethodDescriptor =
          MethodDescriptor.<ListParameterVersionsRequest, ListParameterVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/ListParameterVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParameterVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParameterVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionMethodDescriptor =
          MethodDescriptor.<GetParameterVersionRequest, ParameterVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/GetParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParameterVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionMethodDescriptor =
          MethodDescriptor
              .<RenderParameterVersionRequest, RenderParameterVersionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/RenderParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenderParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RenderParameterVersionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionMethodDescriptor =
          MethodDescriptor.<CreateParameterVersionRequest, ParameterVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/CreateParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParameterVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionMethodDescriptor =
          MethodDescriptor.<UpdateParameterVersionRequest, ParameterVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/UpdateParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateParameterVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParameterVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteParameterVersionRequest, Empty>
      deleteParameterVersionMethodDescriptor =
          MethodDescriptor.<DeleteParameterVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.parametermanager.v1.ParameterManager/DeleteParameterVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteParameterVersionRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable;
  private final UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable;
  private final UnaryCallable<GetParameterRequest, Parameter> getParameterCallable;
  private final UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable;
  private final UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable;
  private final UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable;
  private final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable;
  private final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable;
  private final UnaryCallable<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionCallable;
  private final UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable;
  private final UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable;
  private final UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable;
  private final UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcParameterManagerStub create(ParameterManagerStubSettings settings)
      throws IOException {
    return new GrpcParameterManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcParameterManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcParameterManagerStub(
        ParameterManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcParameterManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcParameterManagerStub(
        ParameterManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcParameterManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcParameterManagerStub(
      ParameterManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcParameterManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcParameterManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcParameterManagerStub(
      ParameterManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListParametersRequest, ListParametersResponse>
        listParametersTransportSettings =
            GrpcCallSettings.<ListParametersRequest, ListParametersResponse>newBuilder()
                .setMethodDescriptor(listParametersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetParameterRequest, Parameter> getParameterTransportSettings =
        GrpcCallSettings.<GetParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(getParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateParameterRequest, Parameter> createParameterTransportSettings =
        GrpcCallSettings.<CreateParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(createParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateParameterRequest, Parameter> updateParameterTransportSettings =
        GrpcCallSettings.<UpdateParameterRequest, Parameter>newBuilder()
            .setMethodDescriptor(updateParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parameter.name", String.valueOf(request.getParameter().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteParameterRequest, Empty> deleteParameterTransportSettings =
        GrpcCallSettings.<DeleteParameterRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteParameterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListParameterVersionsRequest, ListParameterVersionsResponse>
        listParameterVersionsTransportSettings =
            GrpcCallSettings
                .<ListParameterVersionsRequest, ListParameterVersionsResponse>newBuilder()
                .setMethodDescriptor(listParameterVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetParameterVersionRequest, ParameterVersion>
        getParameterVersionTransportSettings =
            GrpcCallSettings.<GetParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(getParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RenderParameterVersionRequest, RenderParameterVersionResponse>
        renderParameterVersionTransportSettings =
            GrpcCallSettings
                .<RenderParameterVersionRequest, RenderParameterVersionResponse>newBuilder()
                .setMethodDescriptor(renderParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateParameterVersionRequest, ParameterVersion>
        createParameterVersionTransportSettings =
            GrpcCallSettings.<CreateParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(createParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateParameterVersionRequest, ParameterVersion>
        updateParameterVersionTransportSettings =
            GrpcCallSettings.<UpdateParameterVersionRequest, ParameterVersion>newBuilder()
                .setMethodDescriptor(updateParameterVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "parameter_version.name",
                          String.valueOf(request.getParameterVersion().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteParameterVersionRequest, Empty> deleteParameterVersionTransportSettings =
        GrpcCallSettings.<DeleteParameterVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteParameterVersionMethodDescriptor)
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

    this.listParametersCallable =
        callableFactory.createUnaryCallable(
            listParametersTransportSettings, settings.listParametersSettings(), clientContext);
    this.listParametersPagedCallable =
        callableFactory.createPagedCallable(
            listParametersTransportSettings, settings.listParametersSettings(), clientContext);
    this.getParameterCallable =
        callableFactory.createUnaryCallable(
            getParameterTransportSettings, settings.getParameterSettings(), clientContext);
    this.createParameterCallable =
        callableFactory.createUnaryCallable(
            createParameterTransportSettings, settings.createParameterSettings(), clientContext);
    this.updateParameterCallable =
        callableFactory.createUnaryCallable(
            updateParameterTransportSettings, settings.updateParameterSettings(), clientContext);
    this.deleteParameterCallable =
        callableFactory.createUnaryCallable(
            deleteParameterTransportSettings, settings.deleteParameterSettings(), clientContext);
    this.listParameterVersionsCallable =
        callableFactory.createUnaryCallable(
            listParameterVersionsTransportSettings,
            settings.listParameterVersionsSettings(),
            clientContext);
    this.listParameterVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listParameterVersionsTransportSettings,
            settings.listParameterVersionsSettings(),
            clientContext);
    this.getParameterVersionCallable =
        callableFactory.createUnaryCallable(
            getParameterVersionTransportSettings,
            settings.getParameterVersionSettings(),
            clientContext);
    this.renderParameterVersionCallable =
        callableFactory.createUnaryCallable(
            renderParameterVersionTransportSettings,
            settings.renderParameterVersionSettings(),
            clientContext);
    this.createParameterVersionCallable =
        callableFactory.createUnaryCallable(
            createParameterVersionTransportSettings,
            settings.createParameterVersionSettings(),
            clientContext);
    this.updateParameterVersionCallable =
        callableFactory.createUnaryCallable(
            updateParameterVersionTransportSettings,
            settings.updateParameterVersionSettings(),
            clientContext);
    this.deleteParameterVersionCallable =
        callableFactory.createUnaryCallable(
            deleteParameterVersionTransportSettings,
            settings.deleteParameterVersionSettings(),
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
  public UnaryCallable<ListParametersRequest, ListParametersResponse> listParametersCallable() {
    return listParametersCallable;
  }

  @Override
  public UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable() {
    return listParametersPagedCallable;
  }

  @Override
  public UnaryCallable<GetParameterRequest, Parameter> getParameterCallable() {
    return getParameterCallable;
  }

  @Override
  public UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable() {
    return createParameterCallable;
  }

  @Override
  public UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable() {
    return updateParameterCallable;
  }

  @Override
  public UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable() {
    return deleteParameterCallable;
  }

  @Override
  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable() {
    return listParameterVersionsCallable;
  }

  @Override
  public UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable() {
    return listParameterVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetParameterVersionRequest, ParameterVersion> getParameterVersionCallable() {
    return getParameterVersionCallable;
  }

  @Override
  public UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable() {
    return renderParameterVersionCallable;
  }

  @Override
  public UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable() {
    return createParameterVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable() {
    return updateParameterVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteParameterVersionRequest, Empty> deleteParameterVersionCallable() {
    return deleteParameterVersionCallable;
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
