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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CmekServiceClient.ListEncryptionConfigsPagedResponse;
import static com.google.cloud.dataplex.v1.CmekServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.EncryptionConfig;
import com.google.cloud.dataplex.v1.GetEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest;
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
 * gRPC stub implementation for the CmekService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCmekServiceStub extends CmekServiceStub {
  private static final MethodDescriptor<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigMethodDescriptor =
          MethodDescriptor.<CreateEncryptionConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/CreateEncryptionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEncryptionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigMethodDescriptor =
          MethodDescriptor.<UpdateEncryptionConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/UpdateEncryptionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEncryptionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigMethodDescriptor =
          MethodDescriptor.<DeleteEncryptionConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/DeleteEncryptionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEncryptionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsMethodDescriptor =
          MethodDescriptor.<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/ListEncryptionConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEncryptionConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEncryptionConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigMethodDescriptor =
          MethodDescriptor.<GetEncryptionConfigRequest, EncryptionConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/GetEncryptionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEncryptionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EncryptionConfig.getDefaultInstance()))
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

  private final UnaryCallable<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigCallable;
  private final OperationCallable<
          CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationCallable;
  private final UnaryCallable<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigCallable;
  private final OperationCallable<
          UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationCallable;
  private final UnaryCallable<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigCallable;
  private final OperationCallable<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationCallable;
  private final UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsCallable;
  private final UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsPagedCallable;
  private final UnaryCallable<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCmekServiceStub create(CmekServiceStubSettings settings)
      throws IOException {
    return new GrpcCmekServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCmekServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcCmekServiceStub(CmekServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCmekServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCmekServiceStub(
        CmekServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCmekServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCmekServiceStub(CmekServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCmekServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCmekServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCmekServiceStub(
      CmekServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEncryptionConfigRequest, Operation>
        createEncryptionConfigTransportSettings =
            GrpcCallSettings.<CreateEncryptionConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createEncryptionConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEncryptionConfigRequest, Operation>
        updateEncryptionConfigTransportSettings =
            GrpcCallSettings.<UpdateEncryptionConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateEncryptionConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "encryption_config.name",
                          String.valueOf(request.getEncryptionConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEncryptionConfigRequest, Operation>
        deleteEncryptionConfigTransportSettings =
            GrpcCallSettings.<DeleteEncryptionConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteEncryptionConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
        listEncryptionConfigsTransportSettings =
            GrpcCallSettings
                .<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>newBuilder()
                .setMethodDescriptor(listEncryptionConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEncryptionConfigRequest, EncryptionConfig>
        getEncryptionConfigTransportSettings =
            GrpcCallSettings.<GetEncryptionConfigRequest, EncryptionConfig>newBuilder()
                .setMethodDescriptor(getEncryptionConfigMethodDescriptor)
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

    this.createEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            createEncryptionConfigTransportSettings,
            settings.createEncryptionConfigSettings(),
            clientContext);
    this.createEncryptionConfigOperationCallable =
        callableFactory.createOperationCallable(
            createEncryptionConfigTransportSettings,
            settings.createEncryptionConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            updateEncryptionConfigTransportSettings,
            settings.updateEncryptionConfigSettings(),
            clientContext);
    this.updateEncryptionConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateEncryptionConfigTransportSettings,
            settings.updateEncryptionConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            deleteEncryptionConfigTransportSettings,
            settings.deleteEncryptionConfigSettings(),
            clientContext);
    this.deleteEncryptionConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteEncryptionConfigTransportSettings,
            settings.deleteEncryptionConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listEncryptionConfigsCallable =
        callableFactory.createUnaryCallable(
            listEncryptionConfigsTransportSettings,
            settings.listEncryptionConfigsSettings(),
            clientContext);
    this.listEncryptionConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listEncryptionConfigsTransportSettings,
            settings.listEncryptionConfigsSettings(),
            clientContext);
    this.getEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            getEncryptionConfigTransportSettings,
            settings.getEncryptionConfigSettings(),
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
  public UnaryCallable<CreateEncryptionConfigRequest, Operation> createEncryptionConfigCallable() {
    return createEncryptionConfigCallable;
  }

  @Override
  public OperationCallable<CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationCallable() {
    return createEncryptionConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEncryptionConfigRequest, Operation> updateEncryptionConfigCallable() {
    return updateEncryptionConfigCallable;
  }

  @Override
  public OperationCallable<UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationCallable() {
    return updateEncryptionConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEncryptionConfigRequest, Operation> deleteEncryptionConfigCallable() {
    return deleteEncryptionConfigCallable;
  }

  @Override
  public OperationCallable<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationCallable() {
    return deleteEncryptionConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsCallable() {
    return listEncryptionConfigsCallable;
  }

  @Override
  public UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsPagedCallable() {
    return listEncryptionConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEncryptionConfigRequest, EncryptionConfig> getEncryptionConfigCallable() {
    return getEncryptionConfigCallable;
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
