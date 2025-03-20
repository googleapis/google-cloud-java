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

package com.google.cloud.financialservices.v1.stub;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.financialservices.v1.BacktestResult;
import com.google.cloud.financialservices.v1.CreateBacktestResultRequest;
import com.google.cloud.financialservices.v1.CreateDatasetRequest;
import com.google.cloud.financialservices.v1.CreateEngineConfigRequest;
import com.google.cloud.financialservices.v1.CreateInstanceRequest;
import com.google.cloud.financialservices.v1.CreateModelRequest;
import com.google.cloud.financialservices.v1.CreatePredictionResultRequest;
import com.google.cloud.financialservices.v1.Dataset;
import com.google.cloud.financialservices.v1.DeleteBacktestResultRequest;
import com.google.cloud.financialservices.v1.DeleteDatasetRequest;
import com.google.cloud.financialservices.v1.DeleteEngineConfigRequest;
import com.google.cloud.financialservices.v1.DeleteInstanceRequest;
import com.google.cloud.financialservices.v1.DeleteModelRequest;
import com.google.cloud.financialservices.v1.DeletePredictionResultRequest;
import com.google.cloud.financialservices.v1.EngineConfig;
import com.google.cloud.financialservices.v1.EngineVersion;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataResponse;
import com.google.cloud.financialservices.v1.ExportModelMetadataRequest;
import com.google.cloud.financialservices.v1.ExportModelMetadataResponse;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.GetBacktestResultRequest;
import com.google.cloud.financialservices.v1.GetDatasetRequest;
import com.google.cloud.financialservices.v1.GetEngineConfigRequest;
import com.google.cloud.financialservices.v1.GetEngineVersionRequest;
import com.google.cloud.financialservices.v1.GetInstanceRequest;
import com.google.cloud.financialservices.v1.GetModelRequest;
import com.google.cloud.financialservices.v1.GetPredictionResultRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.Instance;
import com.google.cloud.financialservices.v1.ListBacktestResultsRequest;
import com.google.cloud.financialservices.v1.ListBacktestResultsResponse;
import com.google.cloud.financialservices.v1.ListDatasetsRequest;
import com.google.cloud.financialservices.v1.ListDatasetsResponse;
import com.google.cloud.financialservices.v1.ListEngineConfigsRequest;
import com.google.cloud.financialservices.v1.ListEngineConfigsResponse;
import com.google.cloud.financialservices.v1.ListEngineVersionsRequest;
import com.google.cloud.financialservices.v1.ListEngineVersionsResponse;
import com.google.cloud.financialservices.v1.ListInstancesRequest;
import com.google.cloud.financialservices.v1.ListInstancesResponse;
import com.google.cloud.financialservices.v1.ListModelsRequest;
import com.google.cloud.financialservices.v1.ListModelsResponse;
import com.google.cloud.financialservices.v1.ListPredictionResultsRequest;
import com.google.cloud.financialservices.v1.ListPredictionResultsResponse;
import com.google.cloud.financialservices.v1.Model;
import com.google.cloud.financialservices.v1.OperationMetadata;
import com.google.cloud.financialservices.v1.PredictionResult;
import com.google.cloud.financialservices.v1.UpdateBacktestResultRequest;
import com.google.cloud.financialservices.v1.UpdateDatasetRequest;
import com.google.cloud.financialservices.v1.UpdateEngineConfigRequest;
import com.google.cloud.financialservices.v1.UpdateInstanceRequest;
import com.google.cloud.financialservices.v1.UpdateModelRequest;
import com.google.cloud.financialservices.v1.UpdatePredictionResultRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the AML service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAMLStub extends AMLStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ExportModelMetadataResponse.getDescriptor())
          .add(ExportRegisteredPartiesResponse.getDescriptor())
          .add(Dataset.getDescriptor())
          .add(EngineConfig.getDescriptor())
          .add(ExportEngineConfigMetadataResponse.getDescriptor())
          .add(ExportBacktestResultMetadataResponse.getDescriptor())
          .add(ImportRegisteredPartiesResponse.getDescriptor())
          .add(ExportPredictionResultMetadataResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(PredictionResult.getDescriptor())
          .add(Instance.getDescriptor())
          .add(BacktestResult.getDescriptor())
          .add(Model.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "instanceId", request.getInstanceId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{instance.name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instance.name", request.getInstance().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesMethodDescriptor =
          ApiMethodDescriptor.<ImportRegisteredPartiesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ImportRegisteredParties")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportRegisteredPartiesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}:importRegisteredParties",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportRegisteredPartiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportRegisteredPartiesRequest> serializer =
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
                  (ImportRegisteredPartiesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesMethodDescriptor =
          ApiMethodDescriptor.<ExportRegisteredPartiesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ExportRegisteredParties")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportRegisteredPartiesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}:exportRegisteredParties",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportRegisteredPartiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportRegisteredPartiesRequest> serializer =
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
                  (ExportRegisteredPartiesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          ApiMethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/datasets",
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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

  private static final ApiMethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      ApiMethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setFullMethodName("google.cloud.financialservices.v1.AML/GetDataset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDatasetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/datasets/*}",
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

  private static final ApiMethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/datasets",
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
                            serializer.putQueryParam(fields, "datasetId", request.getDatasetId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<UpdateDatasetRequest, Operation>
      updateDatasetMethodDescriptor =
          ApiMethodDescriptor.<UpdateDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateDataset")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{dataset.name=projects/*/locations/*/instances/*/datasets/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/datasets/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          ApiMethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/models",
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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

  private static final ApiMethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      ApiMethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.financialservices.v1.AML/GetModel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetModelRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/models/*}",
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

  private static final ApiMethodDescriptor<CreateModelRequest, Operation>
      createModelMethodDescriptor =
          ApiMethodDescriptor.<CreateModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateModelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/models",
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
                            serializer.putQueryParam(fields, "modelId", request.getModelId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<UpdateModelRequest, Operation>
      updateModelMethodDescriptor =
          ApiMethodDescriptor.<UpdateModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateModel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateModelRequest>newBuilder()
                      .setPath(
                          "/v1/{model.name=projects/*/locations/*/instances/*/models/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "model.name", request.getModel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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
                  (UpdateModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportModelMetadataRequest, Operation>
      exportModelMetadataMethodDescriptor =
          ApiMethodDescriptor.<ExportModelMetadataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ExportModelMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportModelMetadataRequest>newBuilder()
                      .setPath(
                          "/v1/{model=projects/*/locations/*/instances/*/models/*}:exportMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportModelMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "model", request.getModel());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportModelMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearModel().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportModelMetadataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteModelRequest, Operation>
      deleteModelMethodDescriptor =
          ApiMethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/models/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListEngineConfigsRequest, ListEngineConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListEngineConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEngineConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/engineConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEngineConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEngineConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEngineConfigsResponse>newBuilder()
                      .setDefaultInstance(ListEngineConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEngineConfigRequest, EngineConfig>
      getEngineConfigMethodDescriptor =
          ApiMethodDescriptor.<GetEngineConfigRequest, EngineConfig>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetEngineConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEngineConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/engineConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EngineConfig>newBuilder()
                      .setDefaultInstance(EngineConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEngineConfigRequest, Operation>
      createEngineConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateEngineConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateEngineConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEngineConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/engineConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "engineConfigId", request.getEngineConfigId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("engineConfig", request.getEngineConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEngineConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEngineConfigRequest, Operation>
      updateEngineConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateEngineConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateEngineConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEngineConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{engineConfig.name=projects/*/locations/*/instances/*/engineConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "engineConfig.name", request.getEngineConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("engineConfig", request.getEngineConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEngineConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataMethodDescriptor =
          ApiMethodDescriptor.<ExportEngineConfigMetadataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ExportEngineConfigMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportEngineConfigMetadataRequest>newBuilder()
                      .setPath(
                          "/v1/{engineConfig=projects/*/locations/*/instances/*/engineConfigs/*}:exportMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportEngineConfigMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "engineConfig", request.getEngineConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportEngineConfigMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEngineConfig().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportEngineConfigMetadataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEngineConfigRequest, Operation>
      deleteEngineConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteEngineConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteEngineConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEngineConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/engineConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEngineConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteEngineConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetEngineVersionRequest, EngineVersion>
      getEngineVersionMethodDescriptor =
          ApiMethodDescriptor.<GetEngineVersionRequest, EngineVersion>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetEngineVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEngineVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/engineVersions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEngineVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEngineVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EngineVersion>newBuilder()
                      .setDefaultInstance(EngineVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListEngineVersionsRequest, ListEngineVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListEngineVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEngineVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/engineVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEngineVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEngineVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEngineVersionsResponse>newBuilder()
                      .setDefaultInstance(ListEngineVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPredictionResultsRequest, ListPredictionResultsResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListPredictionResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPredictionResultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/predictionResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPredictionResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPredictionResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPredictionResultsResponse>newBuilder()
                      .setDefaultInstance(ListPredictionResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPredictionResultRequest, PredictionResult>
      getPredictionResultMethodDescriptor =
          ApiMethodDescriptor.<GetPredictionResultRequest, PredictionResult>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetPredictionResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPredictionResultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/predictionResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PredictionResult>newBuilder()
                      .setDefaultInstance(PredictionResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePredictionResultRequest, Operation>
      createPredictionResultMethodDescriptor =
          ApiMethodDescriptor.<CreatePredictionResultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreatePredictionResult")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePredictionResultRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/predictionResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "predictionResultId", request.getPredictionResultId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("predictionResult", request.getPredictionResult(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePredictionResultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePredictionResultRequest, Operation>
      updatePredictionResultMethodDescriptor =
          ApiMethodDescriptor.<UpdatePredictionResultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdatePredictionResult")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePredictionResultRequest>newBuilder()
                      .setPath(
                          "/v1/{predictionResult.name=projects/*/locations/*/instances/*/predictionResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "predictionResult.name",
                                request.getPredictionResult().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("predictionResult", request.getPredictionResult(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePredictionResultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataMethodDescriptor =
          ApiMethodDescriptor.<ExportPredictionResultMetadataRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.financialservices.v1.AML/ExportPredictionResultMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportPredictionResultMetadataRequest>newBuilder()
                      .setPath(
                          "/v1/{predictionResult=projects/*/locations/*/instances/*/predictionResults/*}:exportMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportPredictionResultMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "predictionResult", request.getPredictionResult());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportPredictionResultMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearPredictionResult().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportPredictionResultMetadataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePredictionResultRequest, Operation>
      deletePredictionResultMethodDescriptor =
          ApiMethodDescriptor.<DeletePredictionResultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeletePredictionResult")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePredictionResultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/predictionResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePredictionResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeletePredictionResultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsMethodDescriptor =
          ApiMethodDescriptor.<ListBacktestResultsRequest, ListBacktestResultsResponse>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/ListBacktestResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBacktestResultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/backtestResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBacktestResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBacktestResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBacktestResultsResponse>newBuilder()
                      .setDefaultInstance(ListBacktestResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBacktestResultRequest, BacktestResult>
      getBacktestResultMethodDescriptor =
          ApiMethodDescriptor.<GetBacktestResultRequest, BacktestResult>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/GetBacktestResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBacktestResultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/backtestResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BacktestResult>newBuilder()
                      .setDefaultInstance(BacktestResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBacktestResultRequest, Operation>
      createBacktestResultMethodDescriptor =
          ApiMethodDescriptor.<CreateBacktestResultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/CreateBacktestResult")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBacktestResultRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/backtestResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "backtestResultId", request.getBacktestResultId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backtestResult", request.getBacktestResult(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBacktestResultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateBacktestResultRequest, Operation>
      updateBacktestResultMethodDescriptor =
          ApiMethodDescriptor.<UpdateBacktestResultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/UpdateBacktestResult")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBacktestResultRequest>newBuilder()
                      .setPath(
                          "/v1/{backtestResult.name=projects/*/locations/*/instances/*/backtestResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "backtestResult.name",
                                request.getBacktestResult().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backtestResult", request.getBacktestResult(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBacktestResultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataMethodDescriptor =
          ApiMethodDescriptor.<ExportBacktestResultMetadataRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.financialservices.v1.AML/ExportBacktestResultMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportBacktestResultMetadataRequest>newBuilder()
                      .setPath(
                          "/v1/{backtestResult=projects/*/locations/*/instances/*/backtestResults/*}:exportMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportBacktestResultMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backtestResult", request.getBacktestResult());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportBacktestResultMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearBacktestResult().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportBacktestResultMetadataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBacktestResultRequest, Operation>
      deleteBacktestResultMethodDescriptor =
          ApiMethodDescriptor.<DeleteBacktestResultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.financialservices.v1.AML/DeleteBacktestResult")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBacktestResultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/backtestResults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBacktestResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteBacktestResultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesCallable;
  private final OperationCallable<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationCallable;
  private final UnaryCallable<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesCallable;
  private final OperationCallable<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable;
  private final OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable;
  private final UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable;
  private final OperationCallable<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationCallable;
  private final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable;
  private final OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable;
  private final UnaryCallable<UpdateModelRequest, Operation> updateModelCallable;
  private final OperationCallable<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationCallable;
  private final UnaryCallable<ExportModelMetadataRequest, Operation> exportModelMetadataCallable;
  private final OperationCallable<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable;
  private final UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsCallable;
  private final UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsPagedResponse>
      listEngineConfigsPagedCallable;
  private final UnaryCallable<GetEngineConfigRequest, EngineConfig> getEngineConfigCallable;
  private final UnaryCallable<CreateEngineConfigRequest, Operation> createEngineConfigCallable;
  private final OperationCallable<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationCallable;
  private final UnaryCallable<UpdateEngineConfigRequest, Operation> updateEngineConfigCallable;
  private final OperationCallable<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationCallable;
  private final UnaryCallable<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataCallable;
  private final OperationCallable<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationCallable;
  private final UnaryCallable<DeleteEngineConfigRequest, Operation> deleteEngineConfigCallable;
  private final OperationCallable<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationCallable;
  private final UnaryCallable<GetEngineVersionRequest, EngineVersion> getEngineVersionCallable;
  private final UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsCallable;
  private final UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsPagedResponse>
      listEngineVersionsPagedCallable;
  private final UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsCallable;
  private final UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsPagedResponse>
      listPredictionResultsPagedCallable;
  private final UnaryCallable<GetPredictionResultRequest, PredictionResult>
      getPredictionResultCallable;
  private final UnaryCallable<CreatePredictionResultRequest, Operation>
      createPredictionResultCallable;
  private final OperationCallable<
          CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationCallable;
  private final UnaryCallable<UpdatePredictionResultRequest, Operation>
      updatePredictionResultCallable;
  private final OperationCallable<
          UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationCallable;
  private final UnaryCallable<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataCallable;
  private final OperationCallable<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationCallable;
  private final UnaryCallable<DeletePredictionResultRequest, Operation>
      deletePredictionResultCallable;
  private final OperationCallable<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationCallable;
  private final UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsCallable;
  private final UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsPagedResponse>
      listBacktestResultsPagedCallable;
  private final UnaryCallable<GetBacktestResultRequest, BacktestResult> getBacktestResultCallable;
  private final UnaryCallable<CreateBacktestResultRequest, Operation> createBacktestResultCallable;
  private final OperationCallable<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationCallable;
  private final UnaryCallable<UpdateBacktestResultRequest, Operation> updateBacktestResultCallable;
  private final OperationCallable<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationCallable;
  private final UnaryCallable<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataCallable;
  private final OperationCallable<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationCallable;
  private final UnaryCallable<DeleteBacktestResultRequest, Operation> deleteBacktestResultCallable;
  private final OperationCallable<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAMLStub create(AMLStubSettings settings) throws IOException {
    return new HttpJsonAMLStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAMLStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAMLStub(AMLStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAMLStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAMLStub(
        AMLStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAMLStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonAMLStub(AMLStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAMLCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAMLStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonAMLStub(
      AMLStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        HttpJsonCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportRegisteredPartiesRequest, Operation>
        importRegisteredPartiesTransportSettings =
            HttpJsonCallSettings.<ImportRegisteredPartiesRequest, Operation>newBuilder()
                .setMethodDescriptor(importRegisteredPartiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportRegisteredPartiesRequest, Operation>
        exportRegisteredPartiesTransportSettings =
            HttpJsonCallSettings.<ExportRegisteredPartiesRequest, Operation>newBuilder()
                .setMethodDescriptor(exportRegisteredPartiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        HttpJsonCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        HttpJsonCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        HttpJsonCallSettings.<CreateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDatasetRequest, Operation> updateDatasetTransportSettings =
        HttpJsonCallSettings.<UpdateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset.name", String.valueOf(request.getDataset().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        HttpJsonCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        HttpJsonCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetModelRequest, Model> getModelTransportSettings =
        HttpJsonCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        HttpJsonCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateModelRequest, Operation> updateModelTransportSettings =
        HttpJsonCallSettings.<UpdateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model.name", String.valueOf(request.getModel().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportModelMetadataRequest, Operation>
        exportModelMetadataTransportSettings =
            HttpJsonCallSettings.<ExportModelMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportModelMetadataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        HttpJsonCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEngineConfigsRequest, ListEngineConfigsResponse>
        listEngineConfigsTransportSettings =
            HttpJsonCallSettings.<ListEngineConfigsRequest, ListEngineConfigsResponse>newBuilder()
                .setMethodDescriptor(listEngineConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEngineConfigRequest, EngineConfig> getEngineConfigTransportSettings =
        HttpJsonCallSettings.<GetEngineConfigRequest, EngineConfig>newBuilder()
            .setMethodDescriptor(getEngineConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEngineConfigRequest, Operation> createEngineConfigTransportSettings =
        HttpJsonCallSettings.<CreateEngineConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createEngineConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEngineConfigRequest, Operation> updateEngineConfigTransportSettings =
        HttpJsonCallSettings.<UpdateEngineConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEngineConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "engine_config.name", String.valueOf(request.getEngineConfig().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportEngineConfigMetadataRequest, Operation>
        exportEngineConfigMetadataTransportSettings =
            HttpJsonCallSettings.<ExportEngineConfigMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportEngineConfigMetadataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("engine_config", String.valueOf(request.getEngineConfig()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEngineConfigRequest, Operation> deleteEngineConfigTransportSettings =
        HttpJsonCallSettings.<DeleteEngineConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEngineConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEngineVersionRequest, EngineVersion> getEngineVersionTransportSettings =
        HttpJsonCallSettings.<GetEngineVersionRequest, EngineVersion>newBuilder()
            .setMethodDescriptor(getEngineVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEngineVersionsRequest, ListEngineVersionsResponse>
        listEngineVersionsTransportSettings =
            HttpJsonCallSettings.<ListEngineVersionsRequest, ListEngineVersionsResponse>newBuilder()
                .setMethodDescriptor(listEngineVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPredictionResultsRequest, ListPredictionResultsResponse>
        listPredictionResultsTransportSettings =
            HttpJsonCallSettings
                .<ListPredictionResultsRequest, ListPredictionResultsResponse>newBuilder()
                .setMethodDescriptor(listPredictionResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPredictionResultRequest, PredictionResult>
        getPredictionResultTransportSettings =
            HttpJsonCallSettings.<GetPredictionResultRequest, PredictionResult>newBuilder()
                .setMethodDescriptor(getPredictionResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePredictionResultRequest, Operation>
        createPredictionResultTransportSettings =
            HttpJsonCallSettings.<CreatePredictionResultRequest, Operation>newBuilder()
                .setMethodDescriptor(createPredictionResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePredictionResultRequest, Operation>
        updatePredictionResultTransportSettings =
            HttpJsonCallSettings.<UpdatePredictionResultRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePredictionResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "prediction_result.name",
                          String.valueOf(request.getPredictionResult().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportPredictionResultMetadataRequest, Operation>
        exportPredictionResultMetadataTransportSettings =
            HttpJsonCallSettings.<ExportPredictionResultMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportPredictionResultMetadataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "prediction_result", String.valueOf(request.getPredictionResult()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePredictionResultRequest, Operation>
        deletePredictionResultTransportSettings =
            HttpJsonCallSettings.<DeletePredictionResultRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePredictionResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBacktestResultsRequest, ListBacktestResultsResponse>
        listBacktestResultsTransportSettings =
            HttpJsonCallSettings
                .<ListBacktestResultsRequest, ListBacktestResultsResponse>newBuilder()
                .setMethodDescriptor(listBacktestResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBacktestResultRequest, BacktestResult>
        getBacktestResultTransportSettings =
            HttpJsonCallSettings.<GetBacktestResultRequest, BacktestResult>newBuilder()
                .setMethodDescriptor(getBacktestResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateBacktestResultRequest, Operation>
        createBacktestResultTransportSettings =
            HttpJsonCallSettings.<CreateBacktestResultRequest, Operation>newBuilder()
                .setMethodDescriptor(createBacktestResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateBacktestResultRequest, Operation>
        updateBacktestResultTransportSettings =
            HttpJsonCallSettings.<UpdateBacktestResultRequest, Operation>newBuilder()
                .setMethodDescriptor(updateBacktestResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "backtest_result.name",
                          String.valueOf(request.getBacktestResult().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportBacktestResultMetadataRequest, Operation>
        exportBacktestResultMetadataTransportSettings =
            HttpJsonCallSettings.<ExportBacktestResultMetadataRequest, Operation>newBuilder()
                .setMethodDescriptor(exportBacktestResultMetadataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("backtest_result", String.valueOf(request.getBacktestResult()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteBacktestResultRequest, Operation>
        deleteBacktestResultTransportSettings =
            HttpJsonCallSettings.<DeleteBacktestResultRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBacktestResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importRegisteredPartiesCallable =
        callableFactory.createUnaryCallable(
            importRegisteredPartiesTransportSettings,
            settings.importRegisteredPartiesSettings(),
            clientContext);
    this.importRegisteredPartiesOperationCallable =
        callableFactory.createOperationCallable(
            importRegisteredPartiesTransportSettings,
            settings.importRegisteredPartiesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportRegisteredPartiesCallable =
        callableFactory.createUnaryCallable(
            exportRegisteredPartiesTransportSettings,
            settings.exportRegisteredPartiesSettings(),
            clientContext);
    this.exportRegisteredPartiesOperationCallable =
        callableFactory.createOperationCallable(
            exportRegisteredPartiesTransportSettings,
            settings.exportRegisteredPartiesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.createDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetTransportSettings,
            settings.createDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDatasetCallable =
        callableFactory.createUnaryCallable(
            updateDatasetTransportSettings, settings.updateDatasetSettings(), clientContext);
    this.updateDatasetOperationCallable =
        callableFactory.createOperationCallable(
            updateDatasetTransportSettings,
            settings.updateDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.deleteDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetTransportSettings,
            settings.deleteDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.createModelCallable =
        callableFactory.createUnaryCallable(
            createModelTransportSettings, settings.createModelSettings(), clientContext);
    this.createModelOperationCallable =
        callableFactory.createOperationCallable(
            createModelTransportSettings,
            settings.createModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
    this.updateModelOperationCallable =
        callableFactory.createOperationCallable(
            updateModelTransportSettings,
            settings.updateModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportModelMetadataCallable =
        callableFactory.createUnaryCallable(
            exportModelMetadataTransportSettings,
            settings.exportModelMetadataSettings(),
            clientContext);
    this.exportModelMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportModelMetadataTransportSettings,
            settings.exportModelMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.deleteModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelTransportSettings,
            settings.deleteModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEngineConfigsCallable =
        callableFactory.createUnaryCallable(
            listEngineConfigsTransportSettings,
            settings.listEngineConfigsSettings(),
            clientContext);
    this.listEngineConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listEngineConfigsTransportSettings,
            settings.listEngineConfigsSettings(),
            clientContext);
    this.getEngineConfigCallable =
        callableFactory.createUnaryCallable(
            getEngineConfigTransportSettings, settings.getEngineConfigSettings(), clientContext);
    this.createEngineConfigCallable =
        callableFactory.createUnaryCallable(
            createEngineConfigTransportSettings,
            settings.createEngineConfigSettings(),
            clientContext);
    this.createEngineConfigOperationCallable =
        callableFactory.createOperationCallable(
            createEngineConfigTransportSettings,
            settings.createEngineConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEngineConfigCallable =
        callableFactory.createUnaryCallable(
            updateEngineConfigTransportSettings,
            settings.updateEngineConfigSettings(),
            clientContext);
    this.updateEngineConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateEngineConfigTransportSettings,
            settings.updateEngineConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportEngineConfigMetadataCallable =
        callableFactory.createUnaryCallable(
            exportEngineConfigMetadataTransportSettings,
            settings.exportEngineConfigMetadataSettings(),
            clientContext);
    this.exportEngineConfigMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportEngineConfigMetadataTransportSettings,
            settings.exportEngineConfigMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEngineConfigCallable =
        callableFactory.createUnaryCallable(
            deleteEngineConfigTransportSettings,
            settings.deleteEngineConfigSettings(),
            clientContext);
    this.deleteEngineConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteEngineConfigTransportSettings,
            settings.deleteEngineConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getEngineVersionCallable =
        callableFactory.createUnaryCallable(
            getEngineVersionTransportSettings, settings.getEngineVersionSettings(), clientContext);
    this.listEngineVersionsCallable =
        callableFactory.createUnaryCallable(
            listEngineVersionsTransportSettings,
            settings.listEngineVersionsSettings(),
            clientContext);
    this.listEngineVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listEngineVersionsTransportSettings,
            settings.listEngineVersionsSettings(),
            clientContext);
    this.listPredictionResultsCallable =
        callableFactory.createUnaryCallable(
            listPredictionResultsTransportSettings,
            settings.listPredictionResultsSettings(),
            clientContext);
    this.listPredictionResultsPagedCallable =
        callableFactory.createPagedCallable(
            listPredictionResultsTransportSettings,
            settings.listPredictionResultsSettings(),
            clientContext);
    this.getPredictionResultCallable =
        callableFactory.createUnaryCallable(
            getPredictionResultTransportSettings,
            settings.getPredictionResultSettings(),
            clientContext);
    this.createPredictionResultCallable =
        callableFactory.createUnaryCallable(
            createPredictionResultTransportSettings,
            settings.createPredictionResultSettings(),
            clientContext);
    this.createPredictionResultOperationCallable =
        callableFactory.createOperationCallable(
            createPredictionResultTransportSettings,
            settings.createPredictionResultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePredictionResultCallable =
        callableFactory.createUnaryCallable(
            updatePredictionResultTransportSettings,
            settings.updatePredictionResultSettings(),
            clientContext);
    this.updatePredictionResultOperationCallable =
        callableFactory.createOperationCallable(
            updatePredictionResultTransportSettings,
            settings.updatePredictionResultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportPredictionResultMetadataCallable =
        callableFactory.createUnaryCallable(
            exportPredictionResultMetadataTransportSettings,
            settings.exportPredictionResultMetadataSettings(),
            clientContext);
    this.exportPredictionResultMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportPredictionResultMetadataTransportSettings,
            settings.exportPredictionResultMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePredictionResultCallable =
        callableFactory.createUnaryCallable(
            deletePredictionResultTransportSettings,
            settings.deletePredictionResultSettings(),
            clientContext);
    this.deletePredictionResultOperationCallable =
        callableFactory.createOperationCallable(
            deletePredictionResultTransportSettings,
            settings.deletePredictionResultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listBacktestResultsCallable =
        callableFactory.createUnaryCallable(
            listBacktestResultsTransportSettings,
            settings.listBacktestResultsSettings(),
            clientContext);
    this.listBacktestResultsPagedCallable =
        callableFactory.createPagedCallable(
            listBacktestResultsTransportSettings,
            settings.listBacktestResultsSettings(),
            clientContext);
    this.getBacktestResultCallable =
        callableFactory.createUnaryCallable(
            getBacktestResultTransportSettings,
            settings.getBacktestResultSettings(),
            clientContext);
    this.createBacktestResultCallable =
        callableFactory.createUnaryCallable(
            createBacktestResultTransportSettings,
            settings.createBacktestResultSettings(),
            clientContext);
    this.createBacktestResultOperationCallable =
        callableFactory.createOperationCallable(
            createBacktestResultTransportSettings,
            settings.createBacktestResultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateBacktestResultCallable =
        callableFactory.createUnaryCallable(
            updateBacktestResultTransportSettings,
            settings.updateBacktestResultSettings(),
            clientContext);
    this.updateBacktestResultOperationCallable =
        callableFactory.createOperationCallable(
            updateBacktestResultTransportSettings,
            settings.updateBacktestResultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportBacktestResultMetadataCallable =
        callableFactory.createUnaryCallable(
            exportBacktestResultMetadataTransportSettings,
            settings.exportBacktestResultMetadataSettings(),
            clientContext);
    this.exportBacktestResultMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportBacktestResultMetadataTransportSettings,
            settings.exportBacktestResultMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBacktestResultCallable =
        callableFactory.createUnaryCallable(
            deleteBacktestResultTransportSettings,
            settings.deleteBacktestResultSettings(),
            clientContext);
    this.deleteBacktestResultOperationCallable =
        callableFactory.createOperationCallable(
            deleteBacktestResultTransportSettings,
            settings.deleteBacktestResultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(createInstanceMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(deleteInstanceMethodDescriptor);
    methodDescriptors.add(importRegisteredPartiesMethodDescriptor);
    methodDescriptors.add(exportRegisteredPartiesMethodDescriptor);
    methodDescriptors.add(listDatasetsMethodDescriptor);
    methodDescriptors.add(getDatasetMethodDescriptor);
    methodDescriptors.add(createDatasetMethodDescriptor);
    methodDescriptors.add(updateDatasetMethodDescriptor);
    methodDescriptors.add(deleteDatasetMethodDescriptor);
    methodDescriptors.add(listModelsMethodDescriptor);
    methodDescriptors.add(getModelMethodDescriptor);
    methodDescriptors.add(createModelMethodDescriptor);
    methodDescriptors.add(updateModelMethodDescriptor);
    methodDescriptors.add(exportModelMetadataMethodDescriptor);
    methodDescriptors.add(deleteModelMethodDescriptor);
    methodDescriptors.add(listEngineConfigsMethodDescriptor);
    methodDescriptors.add(getEngineConfigMethodDescriptor);
    methodDescriptors.add(createEngineConfigMethodDescriptor);
    methodDescriptors.add(updateEngineConfigMethodDescriptor);
    methodDescriptors.add(exportEngineConfigMetadataMethodDescriptor);
    methodDescriptors.add(deleteEngineConfigMethodDescriptor);
    methodDescriptors.add(getEngineVersionMethodDescriptor);
    methodDescriptors.add(listEngineVersionsMethodDescriptor);
    methodDescriptors.add(listPredictionResultsMethodDescriptor);
    methodDescriptors.add(getPredictionResultMethodDescriptor);
    methodDescriptors.add(createPredictionResultMethodDescriptor);
    methodDescriptors.add(updatePredictionResultMethodDescriptor);
    methodDescriptors.add(exportPredictionResultMetadataMethodDescriptor);
    methodDescriptors.add(deletePredictionResultMethodDescriptor);
    methodDescriptors.add(listBacktestResultsMethodDescriptor);
    methodDescriptors.add(getBacktestResultMethodDescriptor);
    methodDescriptors.add(createBacktestResultMethodDescriptor);
    methodDescriptors.add(updateBacktestResultMethodDescriptor);
    methodDescriptors.add(exportBacktestResultMetadataMethodDescriptor);
    methodDescriptors.add(deleteBacktestResultMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesCallable() {
    return importRegisteredPartiesCallable;
  }

  @Override
  public OperationCallable<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationCallable() {
    return importRegisteredPartiesOperationCallable;
  }

  @Override
  public UnaryCallable<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesCallable() {
    return exportRegisteredPartiesCallable;
  }

  @Override
  public OperationCallable<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationCallable() {
    return exportRegisteredPartiesOperationCallable;
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
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
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
  public UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    return updateDatasetCallable;
  }

  @Override
  public OperationCallable<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationCallable() {
    return updateDatasetOperationCallable;
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
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
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
  public UnaryCallable<UpdateModelRequest, Operation> updateModelCallable() {
    return updateModelCallable;
  }

  @Override
  public OperationCallable<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationCallable() {
    return updateModelOperationCallable;
  }

  @Override
  public UnaryCallable<ExportModelMetadataRequest, Operation> exportModelMetadataCallable() {
    return exportModelMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationCallable() {
    return exportModelMetadataOperationCallable;
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
  public UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsCallable() {
    return listEngineConfigsCallable;
  }

  @Override
  public UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsPagedResponse>
      listEngineConfigsPagedCallable() {
    return listEngineConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEngineConfigRequest, EngineConfig> getEngineConfigCallable() {
    return getEngineConfigCallable;
  }

  @Override
  public UnaryCallable<CreateEngineConfigRequest, Operation> createEngineConfigCallable() {
    return createEngineConfigCallable;
  }

  @Override
  public OperationCallable<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationCallable() {
    return createEngineConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEngineConfigRequest, Operation> updateEngineConfigCallable() {
    return updateEngineConfigCallable;
  }

  @Override
  public OperationCallable<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationCallable() {
    return updateEngineConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataCallable() {
    return exportEngineConfigMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationCallable() {
    return exportEngineConfigMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEngineConfigRequest, Operation> deleteEngineConfigCallable() {
    return deleteEngineConfigCallable;
  }

  @Override
  public OperationCallable<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationCallable() {
    return deleteEngineConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetEngineVersionRequest, EngineVersion> getEngineVersionCallable() {
    return getEngineVersionCallable;
  }

  @Override
  public UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsCallable() {
    return listEngineVersionsCallable;
  }

  @Override
  public UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsPagedResponse>
      listEngineVersionsPagedCallable() {
    return listEngineVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsCallable() {
    return listPredictionResultsCallable;
  }

  @Override
  public UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsPagedResponse>
      listPredictionResultsPagedCallable() {
    return listPredictionResultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPredictionResultRequest, PredictionResult> getPredictionResultCallable() {
    return getPredictionResultCallable;
  }

  @Override
  public UnaryCallable<CreatePredictionResultRequest, Operation> createPredictionResultCallable() {
    return createPredictionResultCallable;
  }

  @Override
  public OperationCallable<CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationCallable() {
    return createPredictionResultOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePredictionResultRequest, Operation> updatePredictionResultCallable() {
    return updatePredictionResultCallable;
  }

  @Override
  public OperationCallable<UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationCallable() {
    return updatePredictionResultOperationCallable;
  }

  @Override
  public UnaryCallable<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataCallable() {
    return exportPredictionResultMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationCallable() {
    return exportPredictionResultMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePredictionResultRequest, Operation> deletePredictionResultCallable() {
    return deletePredictionResultCallable;
  }

  @Override
  public OperationCallable<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationCallable() {
    return deletePredictionResultOperationCallable;
  }

  @Override
  public UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsCallable() {
    return listBacktestResultsCallable;
  }

  @Override
  public UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsPagedResponse>
      listBacktestResultsPagedCallable() {
    return listBacktestResultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBacktestResultRequest, BacktestResult> getBacktestResultCallable() {
    return getBacktestResultCallable;
  }

  @Override
  public UnaryCallable<CreateBacktestResultRequest, Operation> createBacktestResultCallable() {
    return createBacktestResultCallable;
  }

  @Override
  public OperationCallable<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationCallable() {
    return createBacktestResultOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBacktestResultRequest, Operation> updateBacktestResultCallable() {
    return updateBacktestResultCallable;
  }

  @Override
  public OperationCallable<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationCallable() {
    return updateBacktestResultOperationCallable;
  }

  @Override
  public UnaryCallable<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataCallable() {
    return exportBacktestResultMetadataCallable;
  }

  @Override
  public OperationCallable<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationCallable() {
    return exportBacktestResultMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBacktestResultRequest, Operation> deleteBacktestResultCallable() {
    return deleteBacktestResultCallable;
  }

  @Override
  public OperationCallable<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationCallable() {
    return deleteBacktestResultOperationCallable;
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
