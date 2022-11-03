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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AutoMl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAutoMlStub extends AutoMlStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Model.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateDatasetRequest, Dataset>
      createDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateDatasetRequest, Dataset>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/CreateDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dataset>newBuilder()
                      .setDefaultInstance(Dataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      ApiMethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetDataset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDatasetRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/datasets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Dataset>newBuilder()
                  .setDefaultInstance(Dataset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          ApiMethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDatasetRequest, Dataset>
      updateDatasetMethodDescriptor =
          ApiMethodDescriptor.<UpdateDatasetRequest, Dataset>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UpdateDataset")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{dataset.name=projects/*/locations/*/datasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataset.name", request.getDataset().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Dataset>newBuilder()
                      .setDefaultInstance(Dataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/DeleteDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatasetRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/datasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportDataRequest, Operation>
      importDataMethodDescriptor =
          ApiMethodDescriptor.<ImportDataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ImportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDataRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/datasets/*}:importData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportDataRequest, Operation>
      exportDataMethodDescriptor =
          ApiMethodDescriptor.<ExportDataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ExportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDataRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/datasets/*}:exportData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAnnotationSpecRequest, AnnotationSpec>
      getAnnotationSpecMethodDescriptor =
          ApiMethodDescriptor.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetAnnotationSpec")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnnotationSpecRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/datasets/*/annotationSpecs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnnotationSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnnotationSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnnotationSpec>newBuilder()
                      .setDefaultInstance(AnnotationSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTableSpecRequest, TableSpec>
      getTableSpecMethodDescriptor =
          ApiMethodDescriptor.<GetTableSpecRequest, TableSpec>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetTableSpec")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTableSpecRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/datasets/*/tableSpecs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTableSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTableSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TableSpec>newBuilder()
                      .setDefaultInstance(TableSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTableSpecsRequest, ListTableSpecsResponse>
      listTableSpecsMethodDescriptor =
          ApiMethodDescriptor.<ListTableSpecsRequest, ListTableSpecsResponse>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListTableSpecs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTableSpecsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/datasets/*}/tableSpecs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTableSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTableSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTableSpecsResponse>newBuilder()
                      .setDefaultInstance(ListTableSpecsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTableSpecRequest, TableSpec>
      updateTableSpecMethodDescriptor =
          ApiMethodDescriptor.<UpdateTableSpecRequest, TableSpec>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UpdateTableSpec")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTableSpecRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{tableSpec.name=projects/*/locations/*/datasets/*/tableSpecs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTableSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tableSpec.name", request.getTableSpec().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTableSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tableSpec", request.getTableSpec(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TableSpec>newBuilder()
                      .setDefaultInstance(TableSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetColumnSpecRequest, ColumnSpec>
      getColumnSpecMethodDescriptor =
          ApiMethodDescriptor.<GetColumnSpecRequest, ColumnSpec>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetColumnSpec")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetColumnSpecRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/datasets/*/tableSpecs/*/columnSpecs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetColumnSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetColumnSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ColumnSpec>newBuilder()
                      .setDefaultInstance(ColumnSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListColumnSpecsRequest, ListColumnSpecsResponse>
      listColumnSpecsMethodDescriptor =
          ApiMethodDescriptor.<ListColumnSpecsRequest, ListColumnSpecsResponse>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListColumnSpecs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListColumnSpecsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/datasets/*/tableSpecs/*}/columnSpecs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListColumnSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListColumnSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListColumnSpecsResponse>newBuilder()
                      .setDefaultInstance(ListColumnSpecsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateColumnSpecRequest, ColumnSpec>
      updateColumnSpecMethodDescriptor =
          ApiMethodDescriptor.<UpdateColumnSpecRequest, ColumnSpec>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UpdateColumnSpec")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateColumnSpecRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{columnSpec.name=projects/*/locations/*/datasets/*/tableSpecs/*/columnSpecs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateColumnSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "columnSpec.name", request.getColumnSpec().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateColumnSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("columnSpec", request.getColumnSpec(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ColumnSpec>newBuilder()
                      .setDefaultInstance(ColumnSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateModelRequest, Operation>
      createModelMethodDescriptor =
          ApiMethodDescriptor.<CreateModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/CreateModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateModelRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("model", request.getModel(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      ApiMethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetModel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetModelRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/models/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetModelRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          ApiMethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListModelsResponse>newBuilder()
                      .setDefaultInstance(ListModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteModelRequest, Operation>
      deleteModelMethodDescriptor =
          ApiMethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/DeleteModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteModelRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/models/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployModelRequest, Operation>
      deployModelMethodDescriptor =
          ApiMethodDescriptor.<DeployModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/DeployModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployModelRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/models/*}:deploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeployModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeployModelRequest, Operation>
      undeployModelMethodDescriptor =
          ApiMethodDescriptor.<UndeployModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/UndeployModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployModelRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/models/*}:undeploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeployModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportModelRequest, Operation>
      exportModelMethodDescriptor =
          ApiMethodDescriptor.<ExportModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ExportModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportModelRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/models/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportEvaluatedExamplesRequest, Operation>
      exportEvaluatedExamplesMethodDescriptor =
          ApiMethodDescriptor.<ExportEvaluatedExamplesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ExportEvaluatedExamples")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportEvaluatedExamplesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/models/*}:exportEvaluatedExamples",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportEvaluatedExamplesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportEvaluatedExamplesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportEvaluatedExamplesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationMethodDescriptor =
          ApiMethodDescriptor.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/GetModelEvaluation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetModelEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/models/*/modelEvaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetModelEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetModelEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ModelEvaluation>newBuilder()
                      .setDefaultInstance(ModelEvaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
              .setFullMethodName("google.cloud.automl.v1beta1.AutoMl/ListModelEvaluations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/models/*}/modelEvaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListModelEvaluationsResponse>newBuilder()
                      .setDefaultInstance(ListModelEvaluationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAutoMlStub create(AutoMlStubSettings settings) throws IOException {
    return new HttpJsonAutoMlStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAutoMlStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAutoMlStub(AutoMlStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAutoMlStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAutoMlStub(
        AutoMlStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAutoMlStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAutoMlStub(AutoMlStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAutoMlCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAutoMlStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAutoMlStub(
      AutoMlStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateDatasetRequest, Dataset> createDatasetTransportSettings =
        HttpJsonCallSettings.<CreateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        HttpJsonCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        HttpJsonCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDatasetRequest, Dataset> updateDatasetTransportSettings =
        HttpJsonCallSettings.<UpdateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        HttpJsonCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        HttpJsonCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        HttpJsonCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAnnotationSpecRequest, AnnotationSpec>
        getAnnotationSpecTransportSettings =
            HttpJsonCallSettings.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
                .setMethodDescriptor(getAnnotationSpecMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTableSpecRequest, TableSpec> getTableSpecTransportSettings =
        HttpJsonCallSettings.<GetTableSpecRequest, TableSpec>newBuilder()
            .setMethodDescriptor(getTableSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTableSpecsRequest, ListTableSpecsResponse>
        listTableSpecsTransportSettings =
            HttpJsonCallSettings.<ListTableSpecsRequest, ListTableSpecsResponse>newBuilder()
                .setMethodDescriptor(listTableSpecsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateTableSpecRequest, TableSpec> updateTableSpecTransportSettings =
        HttpJsonCallSettings.<UpdateTableSpecRequest, TableSpec>newBuilder()
            .setMethodDescriptor(updateTableSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetColumnSpecRequest, ColumnSpec> getColumnSpecTransportSettings =
        HttpJsonCallSettings.<GetColumnSpecRequest, ColumnSpec>newBuilder()
            .setMethodDescriptor(getColumnSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListColumnSpecsRequest, ListColumnSpecsResponse>
        listColumnSpecsTransportSettings =
            HttpJsonCallSettings.<ListColumnSpecsRequest, ListColumnSpecsResponse>newBuilder()
                .setMethodDescriptor(listColumnSpecsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateColumnSpecRequest, ColumnSpec> updateColumnSpecTransportSettings =
        HttpJsonCallSettings.<UpdateColumnSpecRequest, ColumnSpec>newBuilder()
            .setMethodDescriptor(updateColumnSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        HttpJsonCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetModelRequest, Model> getModelTransportSettings =
        HttpJsonCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        HttpJsonCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        HttpJsonCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeployModelRequest, Operation> deployModelTransportSettings =
        HttpJsonCallSettings.<DeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeployModelRequest, Operation> undeployModelTransportSettings =
        HttpJsonCallSettings.<UndeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportModelRequest, Operation> exportModelTransportSettings =
        HttpJsonCallSettings.<ExportModelRequest, Operation>newBuilder()
            .setMethodDescriptor(exportModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportEvaluatedExamplesRequest, Operation>
        exportEvaluatedExamplesTransportSettings =
            HttpJsonCallSettings.<ExportEvaluatedExamplesRequest, Operation>newBuilder()
                .setMethodDescriptor(exportEvaluatedExamplesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationTransportSettings =
            HttpJsonCallSettings.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
                .setMethodDescriptor(getModelEvaluationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
        listModelEvaluationsTransportSettings =
            HttpJsonCallSettings
                .<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listModelEvaluationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deployModelCallable =
        callableFactory.createUnaryCallable(
            deployModelTransportSettings, settings.deployModelSettings(), clientContext);
    this.deployModelOperationCallable =
        callableFactory.createOperationCallable(
            deployModelTransportSettings,
            settings.deployModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeployModelCallable =
        callableFactory.createUnaryCallable(
            undeployModelTransportSettings, settings.undeployModelSettings(), clientContext);
    this.undeployModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployModelTransportSettings,
            settings.undeployModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportModelCallable =
        callableFactory.createUnaryCallable(
            exportModelTransportSettings, settings.exportModelSettings(), clientContext);
    this.exportModelOperationCallable =
        callableFactory.createOperationCallable(
            exportModelTransportSettings,
            settings.exportModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDatasetMethodDescriptor);
    methodDescriptors.add(getDatasetMethodDescriptor);
    methodDescriptors.add(listDatasetsMethodDescriptor);
    methodDescriptors.add(updateDatasetMethodDescriptor);
    methodDescriptors.add(deleteDatasetMethodDescriptor);
    methodDescriptors.add(importDataMethodDescriptor);
    methodDescriptors.add(exportDataMethodDescriptor);
    methodDescriptors.add(getAnnotationSpecMethodDescriptor);
    methodDescriptors.add(getTableSpecMethodDescriptor);
    methodDescriptors.add(listTableSpecsMethodDescriptor);
    methodDescriptors.add(updateTableSpecMethodDescriptor);
    methodDescriptors.add(getColumnSpecMethodDescriptor);
    methodDescriptors.add(listColumnSpecsMethodDescriptor);
    methodDescriptors.add(updateColumnSpecMethodDescriptor);
    methodDescriptors.add(createModelMethodDescriptor);
    methodDescriptors.add(getModelMethodDescriptor);
    methodDescriptors.add(listModelsMethodDescriptor);
    methodDescriptors.add(deleteModelMethodDescriptor);
    methodDescriptors.add(deployModelMethodDescriptor);
    methodDescriptors.add(undeployModelMethodDescriptor);
    methodDescriptors.add(exportModelMethodDescriptor);
    methodDescriptors.add(exportEvaluatedExamplesMethodDescriptor);
    methodDescriptors.add(getModelEvaluationMethodDescriptor);
    methodDescriptors.add(listModelEvaluationsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
