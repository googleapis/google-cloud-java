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

package com.google.cloud.automl.v1beta1.stub;

import static com.google.cloud.automl.v1beta1.AutoMlClient.ListColumnSpecsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListDatasetsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListModelsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListTableSpecsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.automl.v1beta1.AnnotationSpec;
import com.google.cloud.automl.v1beta1.ColumnSpec;
import com.google.cloud.automl.v1beta1.CreateDatasetRequest;
import com.google.cloud.automl.v1beta1.CreateModelRequest;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.DeleteDatasetRequest;
import com.google.cloud.automl.v1beta1.DeleteModelRequest;
import com.google.cloud.automl.v1beta1.DeployModelRequest;
import com.google.cloud.automl.v1beta1.ExportDataRequest;
import com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest;
import com.google.cloud.automl.v1beta1.ExportModelRequest;
import com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest;
import com.google.cloud.automl.v1beta1.GetColumnSpecRequest;
import com.google.cloud.automl.v1beta1.GetDatasetRequest;
import com.google.cloud.automl.v1beta1.GetModelEvaluationRequest;
import com.google.cloud.automl.v1beta1.GetModelRequest;
import com.google.cloud.automl.v1beta1.GetTableSpecRequest;
import com.google.cloud.automl.v1beta1.ImportDataRequest;
import com.google.cloud.automl.v1beta1.ListColumnSpecsRequest;
import com.google.cloud.automl.v1beta1.ListColumnSpecsResponse;
import com.google.cloud.automl.v1beta1.ListDatasetsRequest;
import com.google.cloud.automl.v1beta1.ListDatasetsResponse;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse;
import com.google.cloud.automl.v1beta1.ListModelsRequest;
import com.google.cloud.automl.v1beta1.ListModelsResponse;
import com.google.cloud.automl.v1beta1.ListTableSpecsRequest;
import com.google.cloud.automl.v1beta1.ListTableSpecsResponse;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelEvaluation;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.cloud.automl.v1beta1.TableSpec;
import com.google.cloud.automl.v1beta1.UndeployModelRequest;
import com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest;
import com.google.cloud.automl.v1beta1.UpdateDatasetRequest;
import com.google.cloud.automl.v1beta1.UpdateTableSpecRequest;
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
 * gRPC stub implementation for the AutoMl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAutoMlStub extends AutoMlStub {
  private static final MethodDescriptor<CreateDatasetRequest, Dataset>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDatasetRequest, Dataset>
      updateDatasetMethodDescriptor =
          MethodDescriptor.<UpdateDatasetRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UpdateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          MethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/DeleteDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportDataRequest, Operation> importDataMethodDescriptor =
      MethodDescriptor.<ImportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ImportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExportDataRequest, Operation> exportDataMethodDescriptor =
      MethodDescriptor.<ExportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ExportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetAnnotationSpecRequest, AnnotationSpec>
      getAnnotationSpecMethodDescriptor =
          MethodDescriptor.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetAnnotationSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotationSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnnotationSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTableSpecRequest, TableSpec>
      getTableSpecMethodDescriptor =
          MethodDescriptor.<GetTableSpecRequest, TableSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetTableSpec")
              .setRequestMarshaller(ProtoUtils.marshaller(GetTableSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TableSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTableSpecsRequest, ListTableSpecsResponse>
      listTableSpecsMethodDescriptor =
          MethodDescriptor.<ListTableSpecsRequest, ListTableSpecsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListTableSpecs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTableSpecsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTableSpecsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTableSpecRequest, TableSpec>
      updateTableSpecMethodDescriptor =
          MethodDescriptor.<UpdateTableSpecRequest, TableSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UpdateTableSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTableSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TableSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetColumnSpecRequest, ColumnSpec>
      getColumnSpecMethodDescriptor =
          MethodDescriptor.<GetColumnSpecRequest, ColumnSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetColumnSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetColumnSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ColumnSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListColumnSpecsRequest, ListColumnSpecsResponse>
      listColumnSpecsMethodDescriptor =
          MethodDescriptor.<ListColumnSpecsRequest, ListColumnSpecsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListColumnSpecs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListColumnSpecsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListColumnSpecsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateColumnSpecRequest, ColumnSpec>
      updateColumnSpecMethodDescriptor =
          MethodDescriptor.<UpdateColumnSpecRequest, ColumnSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UpdateColumnSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateColumnSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ColumnSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateModelRequest, Operation> createModelMethodDescriptor =
      MethodDescriptor.<CreateModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/CreateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      MethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetModel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteModelRequest, Operation> deleteModelMethodDescriptor =
      MethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/DeleteModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeployModelRequest, Operation> deployModelMethodDescriptor =
      MethodDescriptor.<DeployModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/DeployModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeployModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeployModelRequest, Operation>
      undeployModelMethodDescriptor =
          MethodDescriptor.<UndeployModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UndeployModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportModelRequest, Operation> exportModelMethodDescriptor =
      MethodDescriptor.<ExportModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ExportModel")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExportEvaluatedExamplesRequest, Operation>
      exportEvaluatedExamplesMethodDescriptor =
          MethodDescriptor.<ExportEvaluatedExamplesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ExportEvaluatedExamples")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportEvaluatedExamplesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationMethodDescriptor =
          MethodDescriptor.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetModelEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelEvaluation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsMethodDescriptor =
          MethodDescriptor.<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListModelEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable;
  private final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable;
  private final OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable;
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<ImportDataRequest, Empty, OperationMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<ExportDataRequest, Empty, OperationMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable;
  private final UnaryCallable<GetTableSpecRequest, TableSpec> getTableSpecCallable;
  private final UnaryCallable<ListTableSpecsRequest, ListTableSpecsResponse> listTableSpecsCallable;
  private final UnaryCallable<ListTableSpecsRequest, ListTableSpecsPagedResponse>
      listTableSpecsPagedCallable;
  private final UnaryCallable<UpdateTableSpecRequest, TableSpec> updateTableSpecCallable;
  private final UnaryCallable<GetColumnSpecRequest, ColumnSpec> getColumnSpecCallable;
  private final UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsResponse>
      listColumnSpecsCallable;
  private final UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsPagedResponse>
      listColumnSpecsPagedCallable;
  private final UnaryCallable<UpdateColumnSpecRequest, ColumnSpec> updateColumnSpecCallable;
  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable;
  private final UnaryCallable<DeployModelRequest, Operation> deployModelCallable;
  private final OperationCallable<DeployModelRequest, Empty, OperationMetadata>
      deployModelOperationCallable;
  private final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable;
  private final OperationCallable<UndeployModelRequest, Empty, OperationMetadata>
      undeployModelOperationCallable;
  private final UnaryCallable<ExportModelRequest, Operation> exportModelCallable;
  private final OperationCallable<ExportModelRequest, Empty, OperationMetadata>
      exportModelOperationCallable;
  private final UnaryCallable<ExportEvaluatedExamplesRequest, Operation>
      exportEvaluatedExamplesCallable;
  private final OperationCallable<ExportEvaluatedExamplesRequest, Empty, OperationMetadata>
      exportEvaluatedExamplesOperationCallable;
  private final UnaryCallable<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationCallable;
  private final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable;
  private final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAutoMlStub create(AutoMlStubSettings settings) throws IOException {
    return new GrpcAutoMlStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAutoMlStub create(ClientContext clientContext) throws IOException {
    return new GrpcAutoMlStub(AutoMlStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAutoMlStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAutoMlStub(
        AutoMlStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAutoMlStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAutoMlStub(AutoMlStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAutoMlCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAutoMlStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAutoMlStub(
      AutoMlStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDatasetRequest, Dataset> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetRequest, Dataset> updateDatasetTransportSettings =
        GrpcCallSettings.<UpdateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("dataset.name", String.valueOf(request.getDataset().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        GrpcCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        GrpcCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecTransportSettings =
        GrpcCallSettings.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
            .setMethodDescriptor(getAnnotationSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetTableSpecRequest, TableSpec> getTableSpecTransportSettings =
        GrpcCallSettings.<GetTableSpecRequest, TableSpec>newBuilder()
            .setMethodDescriptor(getTableSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTableSpecsRequest, ListTableSpecsResponse>
        listTableSpecsTransportSettings =
            GrpcCallSettings.<ListTableSpecsRequest, ListTableSpecsResponse>newBuilder()
                .setMethodDescriptor(listTableSpecsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateTableSpecRequest, TableSpec> updateTableSpecTransportSettings =
        GrpcCallSettings.<UpdateTableSpecRequest, TableSpec>newBuilder()
            .setMethodDescriptor(updateTableSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("table_spec.name", String.valueOf(request.getTableSpec().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetColumnSpecRequest, ColumnSpec> getColumnSpecTransportSettings =
        GrpcCallSettings.<GetColumnSpecRequest, ColumnSpec>newBuilder()
            .setMethodDescriptor(getColumnSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListColumnSpecsRequest, ListColumnSpecsResponse>
        listColumnSpecsTransportSettings =
            GrpcCallSettings.<ListColumnSpecsRequest, ListColumnSpecsResponse>newBuilder()
                .setMethodDescriptor(listColumnSpecsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateColumnSpecRequest, ColumnSpec> updateColumnSpecTransportSettings =
        GrpcCallSettings.<UpdateColumnSpecRequest, ColumnSpec>newBuilder()
            .setMethodDescriptor(updateColumnSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("column_spec.name", String.valueOf(request.getColumnSpec().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        GrpcCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetModelRequest, Model> getModelTransportSettings =
        GrpcCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        GrpcCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        GrpcCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeployModelRequest, Operation> deployModelTransportSettings =
        GrpcCallSettings.<DeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeployModelRequest, Operation> undeployModelTransportSettings =
        GrpcCallSettings.<UndeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ExportModelRequest, Operation> exportModelTransportSettings =
        GrpcCallSettings.<ExportModelRequest, Operation>newBuilder()
            .setMethodDescriptor(exportModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ExportEvaluatedExamplesRequest, Operation>
        exportEvaluatedExamplesTransportSettings =
            GrpcCallSettings.<ExportEvaluatedExamplesRequest, Operation>newBuilder()
                .setMethodDescriptor(exportEvaluatedExamplesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationTransportSettings =
            GrpcCallSettings.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
                .setMethodDescriptor(getModelEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
        listModelEvaluationsTransportSettings =
            GrpcCallSettings.<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listModelEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.updateDatasetCallable =
        callableFactory.createUnaryCallable(
            updateDatasetTransportSettings, settings.updateDatasetSettings(), clientContext);
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
    this.getAnnotationSpecCallable =
        callableFactory.createUnaryCallable(
            getAnnotationSpecTransportSettings,
            settings.getAnnotationSpecSettings(),
            clientContext);
    this.getTableSpecCallable =
        callableFactory.createUnaryCallable(
            getTableSpecTransportSettings, settings.getTableSpecSettings(), clientContext);
    this.listTableSpecsCallable =
        callableFactory.createUnaryCallable(
            listTableSpecsTransportSettings, settings.listTableSpecsSettings(), clientContext);
    this.listTableSpecsPagedCallable =
        callableFactory.createPagedCallable(
            listTableSpecsTransportSettings, settings.listTableSpecsSettings(), clientContext);
    this.updateTableSpecCallable =
        callableFactory.createUnaryCallable(
            updateTableSpecTransportSettings, settings.updateTableSpecSettings(), clientContext);
    this.getColumnSpecCallable =
        callableFactory.createUnaryCallable(
            getColumnSpecTransportSettings, settings.getColumnSpecSettings(), clientContext);
    this.listColumnSpecsCallable =
        callableFactory.createUnaryCallable(
            listColumnSpecsTransportSettings, settings.listColumnSpecsSettings(), clientContext);
    this.listColumnSpecsPagedCallable =
        callableFactory.createPagedCallable(
            listColumnSpecsTransportSettings, settings.listColumnSpecsSettings(), clientContext);
    this.updateColumnSpecCallable =
        callableFactory.createUnaryCallable(
            updateColumnSpecTransportSettings, settings.updateColumnSpecSettings(), clientContext);
    this.createModelCallable =
        callableFactory.createUnaryCallable(
            createModelTransportSettings, settings.createModelSettings(), clientContext);
    this.createModelOperationCallable =
        callableFactory.createOperationCallable(
            createModelTransportSettings,
            settings.createModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.deleteModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelTransportSettings,
            settings.deleteModelOperationSettings(),
            clientContext,
            operationsStub);
    this.deployModelCallable =
        callableFactory.createUnaryCallable(
            deployModelTransportSettings, settings.deployModelSettings(), clientContext);
    this.deployModelOperationCallable =
        callableFactory.createOperationCallable(
            deployModelTransportSettings,
            settings.deployModelOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployModelCallable =
        callableFactory.createUnaryCallable(
            undeployModelTransportSettings, settings.undeployModelSettings(), clientContext);
    this.undeployModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployModelTransportSettings,
            settings.undeployModelOperationSettings(),
            clientContext,
            operationsStub);
    this.exportModelCallable =
        callableFactory.createUnaryCallable(
            exportModelTransportSettings, settings.exportModelSettings(), clientContext);
    this.exportModelOperationCallable =
        callableFactory.createOperationCallable(
            exportModelTransportSettings,
            settings.exportModelOperationSettings(),
            clientContext,
            operationsStub);
    this.exportEvaluatedExamplesCallable =
        callableFactory.createUnaryCallable(
            exportEvaluatedExamplesTransportSettings,
            settings.exportEvaluatedExamplesSettings(),
            clientContext);
    this.exportEvaluatedExamplesOperationCallable =
        callableFactory.createOperationCallable(
            exportEvaluatedExamplesTransportSettings,
            settings.exportEvaluatedExamplesOperationSettings(),
            clientContext,
            operationsStub);
    this.getModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            getModelEvaluationTransportSettings,
            settings.getModelEvaluationSettings(),
            clientContext);
    this.listModelEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listModelEvaluationsTransportSettings,
            settings.listModelEvaluationsSettings(),
            clientContext);
    this.listModelEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listModelEvaluationsTransportSettings,
            settings.listModelEvaluationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    return updateDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable() {
    return deleteDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  @Override
  public OperationCallable<ImportDataRequest, Empty, OperationMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  @Override
  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  @Override
  public OperationCallable<ExportDataRequest, Empty, OperationMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  @Override
  public UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    return getAnnotationSpecCallable;
  }

  @Override
  public UnaryCallable<GetTableSpecRequest, TableSpec> getTableSpecCallable() {
    return getTableSpecCallable;
  }

  @Override
  public UnaryCallable<ListTableSpecsRequest, ListTableSpecsResponse> listTableSpecsCallable() {
    return listTableSpecsCallable;
  }

  @Override
  public UnaryCallable<ListTableSpecsRequest, ListTableSpecsPagedResponse>
      listTableSpecsPagedCallable() {
    return listTableSpecsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateTableSpecRequest, TableSpec> updateTableSpecCallable() {
    return updateTableSpecCallable;
  }

  @Override
  public UnaryCallable<GetColumnSpecRequest, ColumnSpec> getColumnSpecCallable() {
    return getColumnSpecCallable;
  }

  @Override
  public UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsResponse> listColumnSpecsCallable() {
    return listColumnSpecsCallable;
  }

  @Override
  public UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsPagedResponse>
      listColumnSpecsPagedCallable() {
    return listColumnSpecsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateColumnSpecRequest, ColumnSpec> updateColumnSpecCallable() {
    return updateColumnSpecCallable;
  }

  @Override
  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return createModelCallable;
  }

  @Override
  public OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable() {
    return createModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return deleteModelCallable;
  }

  @Override
  public OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable() {
    return deleteModelOperationCallable;
  }

  @Override
  public UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    return deployModelCallable;
  }

  @Override
  public OperationCallable<DeployModelRequest, Empty, OperationMetadata>
      deployModelOperationCallable() {
    return deployModelOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    return undeployModelCallable;
  }

  @Override
  public OperationCallable<UndeployModelRequest, Empty, OperationMetadata>
      undeployModelOperationCallable() {
    return undeployModelOperationCallable;
  }

  @Override
  public UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    return exportModelCallable;
  }

  @Override
  public OperationCallable<ExportModelRequest, Empty, OperationMetadata>
      exportModelOperationCallable() {
    return exportModelOperationCallable;
  }

  @Override
  public UnaryCallable<ExportEvaluatedExamplesRequest, Operation>
      exportEvaluatedExamplesCallable() {
    return exportEvaluatedExamplesCallable;
  }

  @Override
  public OperationCallable<ExportEvaluatedExamplesRequest, Empty, OperationMetadata>
      exportEvaluatedExamplesOperationCallable() {
    return exportEvaluatedExamplesOperationCallable;
  }

  @Override
  public UnaryCallable<GetModelEvaluationRequest, ModelEvaluation> getModelEvaluationCallable() {
    return getModelEvaluationCallable;
  }

  @Override
  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable() {
    return listModelEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable() {
    return listModelEvaluationsPagedCallable;
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
