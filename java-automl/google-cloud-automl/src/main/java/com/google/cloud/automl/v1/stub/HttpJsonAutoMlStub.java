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

package com.google.cloud.automl.v1.stub;

import static com.google.cloud.automl.v1.AutoMlClient.ListDatasetsPagedResponse;
import static com.google.cloud.automl.v1.AutoMlClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.automl.v1.AutoMlClient.ListModelsPagedResponse;

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
import com.google.cloud.automl.v1.AnnotationSpec;
import com.google.cloud.automl.v1.CreateDatasetRequest;
import com.google.cloud.automl.v1.CreateModelRequest;
import com.google.cloud.automl.v1.Dataset;
import com.google.cloud.automl.v1.DeleteDatasetRequest;
import com.google.cloud.automl.v1.DeleteModelRequest;
import com.google.cloud.automl.v1.DeployModelRequest;
import com.google.cloud.automl.v1.ExportDataRequest;
import com.google.cloud.automl.v1.ExportModelRequest;
import com.google.cloud.automl.v1.GetAnnotationSpecRequest;
import com.google.cloud.automl.v1.GetDatasetRequest;
import com.google.cloud.automl.v1.GetModelEvaluationRequest;
import com.google.cloud.automl.v1.GetModelRequest;
import com.google.cloud.automl.v1.ImportDataRequest;
import com.google.cloud.automl.v1.ListDatasetsRequest;
import com.google.cloud.automl.v1.ListDatasetsResponse;
import com.google.cloud.automl.v1.ListModelEvaluationsRequest;
import com.google.cloud.automl.v1.ListModelEvaluationsResponse;
import com.google.cloud.automl.v1.ListModelsRequest;
import com.google.cloud.automl.v1.ListModelsResponse;
import com.google.cloud.automl.v1.Model;
import com.google.cloud.automl.v1.ModelEvaluation;
import com.google.cloud.automl.v1.OperationMetadata;
import com.google.cloud.automl.v1.UndeployModelRequest;
import com.google.cloud.automl.v1.UpdateDatasetRequest;
import com.google.cloud.automl.v1.UpdateModelRequest;
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
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAutoMlStub extends AutoMlStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Dataset.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Model.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1.AutoMl/CreateDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/datasets",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      ApiMethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setFullMethodName("google.cloud.automl.v1.AutoMl/GetDataset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDatasetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/datasets/*}",
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/ListDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/datasets",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/UpdateDataset")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{dataset.name=projects/*/locations/*/datasets/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), true))
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/DeleteDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasets/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/ImportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDataRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasets/*}:importData",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/ExportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDataRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasets/*}:exportData",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/GetAnnotationSpec")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnnotationSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasets/*/annotationSpecs/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<CreateModelRequest, Operation>
      createModelMethodDescriptor =
          ApiMethodDescriptor.<CreateModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1.AutoMl/CreateModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateModelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/models",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("model", request.getModel(), true))
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
          .setFullMethodName("google.cloud.automl.v1.AutoMl/GetModel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetModelRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/models/*}",
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/ListModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/models",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/DeleteModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/models/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<UpdateModelRequest, Model> updateModelMethodDescriptor =
      ApiMethodDescriptor.<UpdateModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.automl.v1.AutoMl/UpdateModel")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateModelRequest>newBuilder()
                  .setPath(
                      "/v1/{model.name=projects/*/locations/*/models/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "model.name", request.getModel().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("model", request.getModel(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeployModelRequest, Operation>
      deployModelMethodDescriptor =
          ApiMethodDescriptor.<DeployModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1.AutoMl/DeployModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/models/*}:deploy",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/UndeployModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/models/*}:undeploy",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/ExportModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/models/*}:export",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
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

  private static final ApiMethodDescriptor<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationMethodDescriptor =
          ApiMethodDescriptor.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
              .setFullMethodName("google.cloud.automl.v1.AutoMl/GetModelEvaluation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetModelEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/models/*/modelEvaluations/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName("google.cloud.automl.v1.AutoMl/ListModelEvaluations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/models/*}/modelEvaluations",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable;
  private final OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable;
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
  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable;
  private final UnaryCallable<UpdateModelRequest, Model> updateModelCallable;
  private final UnaryCallable<DeployModelRequest, Operation> deployModelCallable;
  private final OperationCallable<DeployModelRequest, Empty, OperationMetadata>
      deployModelOperationCallable;
  private final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable;
  private final OperationCallable<UndeployModelRequest, Empty, OperationMetadata>
      undeployModelOperationCallable;
  private final UnaryCallable<ExportModelRequest, Operation> exportModelCallable;
  private final OperationCallable<ExportModelRequest, Empty, OperationMetadata>
      exportModelOperationCallable;
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

    HttpJsonCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        HttpJsonCallSettings.<CreateDatasetRequest, Operation>newBuilder()
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
    HttpJsonCallSettings<UpdateModelRequest, Model> updateModelTransportSettings =
        HttpJsonCallSettings.<UpdateModelRequest, Model>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
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
    this.createDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetTransportSettings,
            settings.createDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
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
    methodDescriptors.add(createModelMethodDescriptor);
    methodDescriptors.add(getModelMethodDescriptor);
    methodDescriptors.add(listModelsMethodDescriptor);
    methodDescriptors.add(deleteModelMethodDescriptor);
    methodDescriptors.add(updateModelMethodDescriptor);
    methodDescriptors.add(deployModelMethodDescriptor);
    methodDescriptors.add(undeployModelMethodDescriptor);
    methodDescriptors.add(exportModelMethodDescriptor);
    methodDescriptors.add(getModelEvaluationMethodDescriptor);
    methodDescriptors.add(listModelEvaluationsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable() {
    return createDatasetOperationCallable;
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
  public UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return updateModelCallable;
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
