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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.GeneratorsClient.ListGeneratorsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.GeneratorsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateGeneratorRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteGeneratorRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Generator;
import com.google.cloud.dialogflow.cx.v3beta1.GetGeneratorRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListGeneratorsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListGeneratorsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateGeneratorRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the Generators service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGeneratorsStub extends GeneratorsStub {
  private static final MethodDescriptor<ListGeneratorsRequest, ListGeneratorsResponse>
      listGeneratorsMethodDescriptor =
          MethodDescriptor.<ListGeneratorsRequest, ListGeneratorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Generators/ListGenerators")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGeneratorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGeneratorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGeneratorRequest, Generator>
      getGeneratorMethodDescriptor =
          MethodDescriptor.<GetGeneratorRequest, Generator>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Generators/GetGenerator")
              .setRequestMarshaller(ProtoUtils.marshaller(GetGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Generator.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGeneratorRequest, Generator>
      createGeneratorMethodDescriptor =
          MethodDescriptor.<CreateGeneratorRequest, Generator>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Generators/CreateGenerator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Generator.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGeneratorRequest, Generator>
      updateGeneratorMethodDescriptor =
          MethodDescriptor.<UpdateGeneratorRequest, Generator>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Generators/UpdateGenerator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Generator.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGeneratorRequest, Empty>
      deleteGeneratorMethodDescriptor =
          MethodDescriptor.<DeleteGeneratorRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Generators/DeleteGenerator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGeneratorRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListGeneratorsRequest, ListGeneratorsResponse> listGeneratorsCallable;
  private final UnaryCallable<ListGeneratorsRequest, ListGeneratorsPagedResponse>
      listGeneratorsPagedCallable;
  private final UnaryCallable<GetGeneratorRequest, Generator> getGeneratorCallable;
  private final UnaryCallable<CreateGeneratorRequest, Generator> createGeneratorCallable;
  private final UnaryCallable<UpdateGeneratorRequest, Generator> updateGeneratorCallable;
  private final UnaryCallable<DeleteGeneratorRequest, Empty> deleteGeneratorCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGeneratorsStub create(GeneratorsStubSettings settings)
      throws IOException {
    return new GrpcGeneratorsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGeneratorsStub create(ClientContext clientContext) throws IOException {
    return new GrpcGeneratorsStub(GeneratorsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGeneratorsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGeneratorsStub(
        GeneratorsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGeneratorsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGeneratorsStub(GeneratorsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGeneratorsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGeneratorsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGeneratorsStub(
      GeneratorsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListGeneratorsRequest, ListGeneratorsResponse>
        listGeneratorsTransportSettings =
            GrpcCallSettings.<ListGeneratorsRequest, ListGeneratorsResponse>newBuilder()
                .setMethodDescriptor(listGeneratorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGeneratorRequest, Generator> getGeneratorTransportSettings =
        GrpcCallSettings.<GetGeneratorRequest, Generator>newBuilder()
            .setMethodDescriptor(getGeneratorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGeneratorRequest, Generator> createGeneratorTransportSettings =
        GrpcCallSettings.<CreateGeneratorRequest, Generator>newBuilder()
            .setMethodDescriptor(createGeneratorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGeneratorRequest, Generator> updateGeneratorTransportSettings =
        GrpcCallSettings.<UpdateGeneratorRequest, Generator>newBuilder()
            .setMethodDescriptor(updateGeneratorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("generator.name", String.valueOf(request.getGenerator().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGeneratorRequest, Empty> deleteGeneratorTransportSettings =
        GrpcCallSettings.<DeleteGeneratorRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGeneratorMethodDescriptor)
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

    this.listGeneratorsCallable =
        callableFactory.createUnaryCallable(
            listGeneratorsTransportSettings, settings.listGeneratorsSettings(), clientContext);
    this.listGeneratorsPagedCallable =
        callableFactory.createPagedCallable(
            listGeneratorsTransportSettings, settings.listGeneratorsSettings(), clientContext);
    this.getGeneratorCallable =
        callableFactory.createUnaryCallable(
            getGeneratorTransportSettings, settings.getGeneratorSettings(), clientContext);
    this.createGeneratorCallable =
        callableFactory.createUnaryCallable(
            createGeneratorTransportSettings, settings.createGeneratorSettings(), clientContext);
    this.updateGeneratorCallable =
        callableFactory.createUnaryCallable(
            updateGeneratorTransportSettings, settings.updateGeneratorSettings(), clientContext);
    this.deleteGeneratorCallable =
        callableFactory.createUnaryCallable(
            deleteGeneratorTransportSettings, settings.deleteGeneratorSettings(), clientContext);
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
  public UnaryCallable<ListGeneratorsRequest, ListGeneratorsResponse> listGeneratorsCallable() {
    return listGeneratorsCallable;
  }

  @Override
  public UnaryCallable<ListGeneratorsRequest, ListGeneratorsPagedResponse>
      listGeneratorsPagedCallable() {
    return listGeneratorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGeneratorRequest, Generator> getGeneratorCallable() {
    return getGeneratorCallable;
  }

  @Override
  public UnaryCallable<CreateGeneratorRequest, Generator> createGeneratorCallable() {
    return createGeneratorCallable;
  }

  @Override
  public UnaryCallable<UpdateGeneratorRequest, Generator> updateGeneratorCallable() {
    return updateGeneratorCallable;
  }

  @Override
  public UnaryCallable<DeleteGeneratorRequest, Empty> deleteGeneratorCallable() {
    return deleteGeneratorCallable;
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
