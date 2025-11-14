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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListCollectionsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.Collection;
import com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.CreateIndexRequest;
import com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest;
import com.google.cloud.vectorsearch.v1beta.GetCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.GetIndexRequest;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsMetadata;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.Index;
import com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest;
import com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse;
import com.google.cloud.vectorsearch.v1beta.ListIndexesRequest;
import com.google.cloud.vectorsearch.v1beta.ListIndexesResponse;
import com.google.cloud.vectorsearch.v1beta.OperationMetadata;
import com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest;
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
 * gRPC stub implementation for the VectorSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcVectorSearchServiceStub extends VectorSearchServiceStub {
  private static final MethodDescriptor<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsMethodDescriptor =
          MethodDescriptor.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/ListCollections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCollectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCollectionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCollectionRequest, Collection>
      getCollectionMethodDescriptor =
          MethodDescriptor.<GetCollectionRequest, Collection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/GetCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Collection.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCollectionRequest, Operation>
      createCollectionMethodDescriptor =
          MethodDescriptor.<CreateCollectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/CreateCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCollectionRequest, Operation>
      updateCollectionMethodDescriptor =
          MethodDescriptor.<UpdateCollectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/UpdateCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCollectionRequest, Operation>
      deleteCollectionMethodDescriptor =
          MethodDescriptor.<DeleteCollectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/DeleteCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          MethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/ListIndexes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIndexesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIndexesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      MethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/GetIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Index.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateIndexRequest, Operation> createIndexMethodDescriptor =
      MethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/CreateIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteIndexRequest, Operation> deleteIndexMethodDescriptor =
      MethodDescriptor.<DeleteIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vectorsearch.v1beta.VectorSearchService/DeleteIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ImportDataObjectsRequest, Operation>
      importDataObjectsMethodDescriptor =
          MethodDescriptor.<ImportDataObjectsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.VectorSearchService/ImportDataObjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportDataObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<ListCollectionsRequest, ListCollectionsResponse>
      listCollectionsCallable;
  private final UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable;
  private final UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable;
  private final UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable;
  private final OperationCallable<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationCallable;
  private final UnaryCallable<UpdateCollectionRequest, Operation> updateCollectionCallable;
  private final OperationCallable<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationCallable;
  private final UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable;
  private final OperationCallable<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable;
  private final UnaryCallable<GetIndexRequest, Index> getIndexCallable;
  private final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable;
  private final OperationCallable<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationCallable;
  private final UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable;
  private final OperationCallable<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationCallable;
  private final UnaryCallable<ImportDataObjectsRequest, Operation> importDataObjectsCallable;
  private final OperationCallable<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVectorSearchServiceStub create(VectorSearchServiceStubSettings settings)
      throws IOException {
    return new GrpcVectorSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVectorSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVectorSearchServiceStub(
        VectorSearchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVectorSearchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVectorSearchServiceStub(
        VectorSearchServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVectorSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVectorSearchServiceStub(
      VectorSearchServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcVectorSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVectorSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVectorSearchServiceStub(
      VectorSearchServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCollectionsRequest, ListCollectionsResponse>
        listCollectionsTransportSettings =
            GrpcCallSettings.<ListCollectionsRequest, ListCollectionsResponse>newBuilder()
                .setMethodDescriptor(listCollectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCollectionRequest, Collection> getCollectionTransportSettings =
        GrpcCallSettings.<GetCollectionRequest, Collection>newBuilder()
            .setMethodDescriptor(getCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCollectionRequest, Operation> createCollectionTransportSettings =
        GrpcCallSettings.<CreateCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCollectionRequest, Operation> updateCollectionTransportSettings =
        GrpcCallSettings.<UpdateCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collection.name", String.valueOf(request.getCollection().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCollectionRequest, Operation> deleteCollectionTransportSettings =
        GrpcCallSettings.<DeleteCollectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCollectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIndexesRequest, ListIndexesResponse> listIndexesTransportSettings =
        GrpcCallSettings.<ListIndexesRequest, ListIndexesResponse>newBuilder()
            .setMethodDescriptor(listIndexesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIndexRequest, Index> getIndexTransportSettings =
        GrpcCallSettings.<GetIndexRequest, Index>newBuilder()
            .setMethodDescriptor(getIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateIndexRequest, Operation> createIndexTransportSettings =
        GrpcCallSettings.<CreateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIndexRequest, Operation> deleteIndexTransportSettings =
        GrpcCallSettings.<DeleteIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportDataObjectsRequest, Operation> importDataObjectsTransportSettings =
        GrpcCallSettings.<ImportDataObjectsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataObjectsMethodDescriptor)
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

    this.listCollectionsCallable =
        callableFactory.createUnaryCallable(
            listCollectionsTransportSettings, settings.listCollectionsSettings(), clientContext);
    this.listCollectionsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectionsTransportSettings, settings.listCollectionsSettings(), clientContext);
    this.getCollectionCallable =
        callableFactory.createUnaryCallable(
            getCollectionTransportSettings, settings.getCollectionSettings(), clientContext);
    this.createCollectionCallable =
        callableFactory.createUnaryCallable(
            createCollectionTransportSettings, settings.createCollectionSettings(), clientContext);
    this.createCollectionOperationCallable =
        callableFactory.createOperationCallable(
            createCollectionTransportSettings,
            settings.createCollectionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCollectionCallable =
        callableFactory.createUnaryCallable(
            updateCollectionTransportSettings, settings.updateCollectionSettings(), clientContext);
    this.updateCollectionOperationCallable =
        callableFactory.createOperationCallable(
            updateCollectionTransportSettings,
            settings.updateCollectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCollectionCallable =
        callableFactory.createUnaryCallable(
            deleteCollectionTransportSettings, settings.deleteCollectionSettings(), clientContext);
    this.deleteCollectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteCollectionTransportSettings,
            settings.deleteCollectionOperationSettings(),
            clientContext,
            operationsStub);
    this.listIndexesCallable =
        callableFactory.createUnaryCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.listIndexesPagedCallable =
        callableFactory.createPagedCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.getIndexCallable =
        callableFactory.createUnaryCallable(
            getIndexTransportSettings, settings.getIndexSettings(), clientContext);
    this.createIndexCallable =
        callableFactory.createUnaryCallable(
            createIndexTransportSettings, settings.createIndexSettings(), clientContext);
    this.createIndexOperationCallable =
        callableFactory.createOperationCallable(
            createIndexTransportSettings,
            settings.createIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteIndexCallable =
        callableFactory.createUnaryCallable(
            deleteIndexTransportSettings, settings.deleteIndexSettings(), clientContext);
    this.deleteIndexOperationCallable =
        callableFactory.createOperationCallable(
            deleteIndexTransportSettings,
            settings.deleteIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.importDataObjectsCallable =
        callableFactory.createUnaryCallable(
            importDataObjectsTransportSettings,
            settings.importDataObjectsSettings(),
            clientContext);
    this.importDataObjectsOperationCallable =
        callableFactory.createOperationCallable(
            importDataObjectsTransportSettings,
            settings.importDataObjectsOperationSettings(),
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
  public UnaryCallable<ListCollectionsRequest, ListCollectionsResponse> listCollectionsCallable() {
    return listCollectionsCallable;
  }

  @Override
  public UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable() {
    return listCollectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable() {
    return getCollectionCallable;
  }

  @Override
  public UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable() {
    return createCollectionCallable;
  }

  @Override
  public OperationCallable<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationCallable() {
    return createCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCollectionRequest, Operation> updateCollectionCallable() {
    return updateCollectionCallable;
  }

  @Override
  public OperationCallable<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationCallable() {
    return updateCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    return deleteCollectionCallable;
  }

  @Override
  public OperationCallable<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationCallable() {
    return deleteCollectionOperationCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return listIndexesCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    return listIndexesPagedCallable;
  }

  @Override
  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return getIndexCallable;
  }

  @Override
  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return createIndexCallable;
  }

  @Override
  public OperationCallable<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationCallable() {
    return createIndexOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    return deleteIndexCallable;
  }

  @Override
  public OperationCallable<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationCallable() {
    return deleteIndexOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDataObjectsRequest, Operation> importDataObjectsCallable() {
    return importDataObjectsCallable;
  }

  @Override
  public OperationCallable<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationCallable() {
    return importDataObjectsOperationCallable;
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
