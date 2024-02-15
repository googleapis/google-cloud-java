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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListDocumentsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsMetadata;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsResponse;
import com.google.cloud.documentai.v1beta3.Dataset;
import com.google.cloud.documentai.v1beta3.DatasetSchema;
import com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest;
import com.google.cloud.documentai.v1beta3.GetDocumentRequest;
import com.google.cloud.documentai.v1beta3.GetDocumentResponse;
import com.google.cloud.documentai.v1beta3.ImportDocumentsMetadata;
import com.google.cloud.documentai.v1beta3.ImportDocumentsRequest;
import com.google.cloud.documentai.v1beta3.ImportDocumentsResponse;
import com.google.cloud.documentai.v1beta3.ListDocumentsRequest;
import com.google.cloud.documentai.v1beta3.ListDocumentsResponse;
import com.google.cloud.documentai.v1beta3.UpdateDatasetOperationMetadata;
import com.google.cloud.documentai.v1beta3.UpdateDatasetRequest;
import com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DocumentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDocumentServiceStub extends DocumentServiceStub {
  private static final MethodDescriptor<UpdateDatasetRequest, Operation>
      updateDatasetMethodDescriptor =
          MethodDescriptor.<UpdateDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.documentai.v1beta3.DocumentService/UpdateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          MethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.documentai.v1beta3.DocumentService/ImportDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDocumentRequest, GetDocumentResponse>
      getDocumentMethodDescriptor =
          MethodDescriptor.<GetDocumentRequest, GetDocumentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.documentai.v1beta3.DocumentService/GetDocument")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetDocumentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          MethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.documentai.v1beta3.DocumentService/ListDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDocumentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteDocumentsRequest, Operation>
      batchDeleteDocumentsMethodDescriptor =
          MethodDescriptor.<BatchDeleteDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentService/BatchDeleteDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetSchemaRequest, DatasetSchema>
      getDatasetSchemaMethodDescriptor =
          MethodDescriptor.<GetDatasetSchemaRequest, DatasetSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.documentai.v1beta3.DocumentService/GetDatasetSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDatasetSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DatasetSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDatasetSchemaRequest, DatasetSchema>
      updateDatasetSchemaMethodDescriptor =
          MethodDescriptor.<UpdateDatasetSchemaRequest, DatasetSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentService/UpdateDatasetSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DatasetSchema.getDefaultInstance()))
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

  private final UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable;
  private final OperationCallable<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable;
  private final UnaryCallable<GetDocumentRequest, GetDocumentResponse> getDocumentCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<BatchDeleteDocumentsRequest, Operation> batchDeleteDocumentsCallable;
  private final OperationCallable<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationCallable;
  private final UnaryCallable<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaCallable;
  private final UnaryCallable<UpdateDatasetSchemaRequest, DatasetSchema>
      updateDatasetSchemaCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentServiceStub create(DocumentServiceStubSettings settings)
      throws IOException {
    return new GrpcDocumentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentServiceStub(
        DocumentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentServiceStub(
        DocumentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDocumentServiceStub(
      DocumentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDocumentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDocumentServiceStub(
      DocumentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<UpdateDatasetRequest, Operation> updateDatasetTransportSettings =
        GrpcCallSettings.<UpdateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset.name", String.valueOf(request.getDataset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        GrpcCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDocumentRequest, GetDocumentResponse> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, GetDocumentResponse>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDocumentsRequest, ListDocumentsResponse> listDocumentsTransportSettings =
        GrpcCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
            .setMethodDescriptor(listDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteDocumentsRequest, Operation> batchDeleteDocumentsTransportSettings =
        GrpcCallSettings.<BatchDeleteDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaTransportSettings =
        GrpcCallSettings.<GetDatasetSchemaRequest, DatasetSchema>newBuilder()
            .setMethodDescriptor(getDatasetSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetSchemaRequest, DatasetSchema>
        updateDatasetSchemaTransportSettings =
            GrpcCallSettings.<UpdateDatasetSchemaRequest, DatasetSchema>newBuilder()
                .setMethodDescriptor(updateDatasetSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "dataset_schema.name",
                          String.valueOf(request.getDatasetSchema().getName()));
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

    this.updateDatasetCallable =
        callableFactory.createUnaryCallable(
            updateDatasetTransportSettings, settings.updateDatasetSettings(), clientContext);
    this.updateDatasetOperationCallable =
        callableFactory.createOperationCallable(
            updateDatasetTransportSettings,
            settings.updateDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.importDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            importDocumentsTransportSettings,
            settings.importDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.listDocumentsCallable =
        callableFactory.createUnaryCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.batchDeleteDocumentsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteDocumentsTransportSettings,
            settings.batchDeleteDocumentsSettings(),
            clientContext);
    this.batchDeleteDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteDocumentsTransportSettings,
            settings.batchDeleteDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.getDatasetSchemaCallable =
        callableFactory.createUnaryCallable(
            getDatasetSchemaTransportSettings, settings.getDatasetSchemaSettings(), clientContext);
    this.updateDatasetSchemaCallable =
        callableFactory.createUnaryCallable(
            updateDatasetSchemaTransportSettings,
            settings.updateDatasetSchemaSettings(),
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
  public UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    return updateDatasetCallable;
  }

  @Override
  public OperationCallable<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationCallable() {
    return updateDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  @Override
  public OperationCallable<ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return importDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, GetDocumentResponse> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return listDocumentsCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return listDocumentsPagedCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteDocumentsRequest, Operation> batchDeleteDocumentsCallable() {
    return batchDeleteDocumentsCallable;
  }

  @Override
  public OperationCallable<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationCallable() {
    return batchDeleteDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaCallable() {
    return getDatasetSchemaCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetSchemaRequest, DatasetSchema> updateDatasetSchemaCallable() {
    return updateDatasetSchemaCallable;
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
