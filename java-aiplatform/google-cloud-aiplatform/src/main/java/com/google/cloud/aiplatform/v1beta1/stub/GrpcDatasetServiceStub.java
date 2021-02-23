/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListAnnotationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AnnotationSpec;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.Dataset;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataResponse;
import com.google.cloud.aiplatform.v1beta1.GetAnnotationSpecRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataResponse;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsRequest;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * gRPC stub implementation for the DatasetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDatasetServiceStub extends DatasetServiceStub {
  private static final MethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateDatasetRequest, Dataset>
      updateDatasetMethodDescriptor =
          MethodDescriptor.<UpdateDatasetRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/UpdateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          MethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/DeleteDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportDataRequest, Operation> importDataMethodDescriptor =
      MethodDescriptor.<ImportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ImportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExportDataRequest, Operation> exportDataMethodDescriptor =
      MethodDescriptor.<ExportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ExportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDataItemsRequest, ListDataItemsResponse>
      listDataItemsMethodDescriptor =
          MethodDescriptor.<ListDataItemsRequest, ListDataItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListDataItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataItemsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAnnotationSpecRequest, AnnotationSpec>
      getAnnotationSpecMethodDescriptor =
          MethodDescriptor.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/GetAnnotationSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotationSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnnotationSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsMethodDescriptor =
          MethodDescriptor.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListAnnotations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnnotationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnnotationsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable;
  private final OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable;
  private final OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable;
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<
          ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<
          ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable;
  private final UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable;
  private final UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable;
  private final UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsCallable;
  private final UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDatasetServiceStub create(DatasetServiceStubSettings settings)
      throws IOException {
    return new GrpcDatasetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDatasetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDatasetServiceStub(
        DatasetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDatasetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDatasetServiceStub(
        DatasetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDatasetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatasetServiceStub(DatasetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDatasetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDatasetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatasetServiceStub(
      DatasetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(CreateDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(GetDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateDatasetRequest, Dataset> updateDatasetTransportSettings =
        GrpcCallSettings.<UpdateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("dataset.name", String.valueOf(request.getDataset().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDatasetsRequest>() {
                  @Override
                  public Map<String, String> extract(ListDatasetsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        GrpcCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ImportDataRequest>() {
                  @Override
                  public Map<String, String> extract(ImportDataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        GrpcCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportDataRequest>() {
                  @Override
                  public Map<String, String> extract(ExportDataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDataItemsRequest, ListDataItemsResponse> listDataItemsTransportSettings =
        GrpcCallSettings.<ListDataItemsRequest, ListDataItemsResponse>newBuilder()
            .setMethodDescriptor(listDataItemsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDataItemsRequest>() {
                  @Override
                  public Map<String, String> extract(ListDataItemsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecTransportSettings =
        GrpcCallSettings.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
            .setMethodDescriptor(getAnnotationSpecMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetAnnotationSpecRequest>() {
                  @Override
                  public Map<String, String> extract(GetAnnotationSpecRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListAnnotationsRequest, ListAnnotationsResponse>
        listAnnotationsTransportSettings =
            GrpcCallSettings.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
                .setMethodDescriptor(listAnnotationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListAnnotationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListAnnotationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.createDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetTransportSettings,
            settings.createDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.updateDatasetCallable =
        callableFactory.createUnaryCallable(
            updateDatasetTransportSettings, settings.updateDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.deleteDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetTransportSettings,
            settings.deleteDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            operationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            operationsStub);
    this.listDataItemsCallable =
        callableFactory.createUnaryCallable(
            listDataItemsTransportSettings, settings.listDataItemsSettings(), clientContext);
    this.listDataItemsPagedCallable =
        callableFactory.createPagedCallable(
            listDataItemsTransportSettings, settings.listDataItemsSettings(), clientContext);
    this.getAnnotationSpecCallable =
        callableFactory.createUnaryCallable(
            getAnnotationSpecTransportSettings,
            settings.getAnnotationSpecSettings(),
            clientContext);
    this.listAnnotationsCallable =
        callableFactory.createUnaryCallable(
            listAnnotationsTransportSettings, settings.listAnnotationsSettings(), clientContext);
    this.listAnnotationsPagedCallable =
        callableFactory.createPagedCallable(
            listAnnotationsTransportSettings, settings.listAnnotationsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return createDatasetCallable;
  }

  public OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable() {
    return createDatasetOperationCallable;
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  public UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    return updateDatasetCallable;
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  public OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable() {
    return deleteDatasetOperationCallable;
  }

  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  public OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  public OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    return listDataItemsCallable;
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    return listDataItemsPagedCallable;
  }

  public UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    return getAnnotationSpecCallable;
  }

  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> listAnnotationsCallable() {
    return listAnnotationsCallable;
  }

  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    return listAnnotationsPagedCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
