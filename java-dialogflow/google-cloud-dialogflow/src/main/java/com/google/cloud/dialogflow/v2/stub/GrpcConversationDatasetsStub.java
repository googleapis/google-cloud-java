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

import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListConversationDatasetsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationDatasetsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ConversationDataset;
import com.google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.GetConversationDatasetRequest;
import com.google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata;
import com.google.cloud.dialogflow.v2.ImportConversationDataOperationResponse;
import com.google.cloud.dialogflow.v2.ImportConversationDataRequest;
import com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest;
import com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the ConversationDatasets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConversationDatasetsStub extends ConversationDatasetsStub {
  private static final MethodDescriptor<CreateConversationDatasetRequest, Operation>
      createConversationDatasetMethodDescriptor =
          MethodDescriptor.<CreateConversationDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/CreateConversationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetMethodDescriptor =
          MethodDescriptor.<GetConversationDatasetRequest, ConversationDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/GetConversationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversationDataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsMethodDescriptor =
          MethodDescriptor
              .<ListConversationDatasetsRequest, ListConversationDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/ListConversationDatasets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetMethodDescriptor =
          MethodDescriptor.<DeleteConversationDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/DeleteConversationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportConversationDataRequest, Operation>
      importConversationDataMethodDescriptor =
          MethodDescriptor.<ImportConversationDataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationDatasets/ImportConversationData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportConversationDataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<CreateConversationDatasetRequest, Operation>
      createConversationDatasetCallable;
  private final OperationCallable<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationCallable;
  private final UnaryCallable<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetCallable;
  private final UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsCallable;
  private final UnaryCallable<
          ListConversationDatasetsRequest, ListConversationDatasetsPagedResponse>
      listConversationDatasetsPagedCallable;
  private final UnaryCallable<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetCallable;
  private final OperationCallable<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationCallable;
  private final UnaryCallable<ImportConversationDataRequest, Operation>
      importConversationDataCallable;
  private final OperationCallable<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationDatasetsStub create(ConversationDatasetsStubSettings settings)
      throws IOException {
    return new GrpcConversationDatasetsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationDatasetsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConversationDatasetsStub(
        ConversationDatasetsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationDatasetsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationDatasetsStub(
        ConversationDatasetsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationDatasetsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationDatasetsStub(
      ConversationDatasetsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConversationDatasetsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationDatasetsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationDatasetsStub(
      ConversationDatasetsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConversationDatasetRequest, Operation>
        createConversationDatasetTransportSettings =
            GrpcCallSettings.<CreateConversationDatasetRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConversationDatasetRequest, ConversationDataset>
        getConversationDatasetTransportSettings =
            GrpcCallSettings.<GetConversationDatasetRequest, ConversationDataset>newBuilder()
                .setMethodDescriptor(getConversationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
        listConversationDatasetsTransportSettings =
            GrpcCallSettings
                .<ListConversationDatasetsRequest, ListConversationDatasetsResponse>newBuilder()
                .setMethodDescriptor(listConversationDatasetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversationDatasetRequest, Operation>
        deleteConversationDatasetTransportSettings =
            GrpcCallSettings.<DeleteConversationDatasetRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConversationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportConversationDataRequest, Operation>
        importConversationDataTransportSettings =
            GrpcCallSettings.<ImportConversationDataRequest, Operation>newBuilder()
                .setMethodDescriptor(importConversationDataMethodDescriptor)
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

    this.createConversationDatasetCallable =
        callableFactory.createUnaryCallable(
            createConversationDatasetTransportSettings,
            settings.createConversationDatasetSettings(),
            clientContext);
    this.createConversationDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createConversationDatasetTransportSettings,
            settings.createConversationDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.getConversationDatasetCallable =
        callableFactory.createUnaryCallable(
            getConversationDatasetTransportSettings,
            settings.getConversationDatasetSettings(),
            clientContext);
    this.listConversationDatasetsCallable =
        callableFactory.createUnaryCallable(
            listConversationDatasetsTransportSettings,
            settings.listConversationDatasetsSettings(),
            clientContext);
    this.listConversationDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationDatasetsTransportSettings,
            settings.listConversationDatasetsSettings(),
            clientContext);
    this.deleteConversationDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteConversationDatasetTransportSettings,
            settings.deleteConversationDatasetSettings(),
            clientContext);
    this.deleteConversationDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteConversationDatasetTransportSettings,
            settings.deleteConversationDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.importConversationDataCallable =
        callableFactory.createUnaryCallable(
            importConversationDataTransportSettings,
            settings.importConversationDataSettings(),
            clientContext);
    this.importConversationDataOperationCallable =
        callableFactory.createOperationCallable(
            importConversationDataTransportSettings,
            settings.importConversationDataOperationSettings(),
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
  public UnaryCallable<CreateConversationDatasetRequest, Operation>
      createConversationDatasetCallable() {
    return createConversationDatasetCallable;
  }

  @Override
  public OperationCallable<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationCallable() {
    return createConversationDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetCallable() {
    return getConversationDatasetCallable;
  }

  @Override
  public UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsCallable() {
    return listConversationDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsPagedResponse>
      listConversationDatasetsPagedCallable() {
    return listConversationDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetCallable() {
    return deleteConversationDatasetCallable;
  }

  @Override
  public OperationCallable<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationCallable() {
    return deleteConversationDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<ImportConversationDataRequest, Operation> importConversationDataCallable() {
    return importConversationDataCallable;
  }

  @Override
  public OperationCallable<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationCallable() {
    return importConversationDataOperationCallable;
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
