/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.workloadmanager.v1.stub;

import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListEvaluationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionResultsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListScannedResourcesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workloadmanager.v1.CreateEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteExecutionRequest;
import com.google.cloud.workloadmanager.v1.Evaluation;
import com.google.cloud.workloadmanager.v1.Execution;
import com.google.cloud.workloadmanager.v1.GetEvaluationRequest;
import com.google.cloud.workloadmanager.v1.GetExecutionRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionsResponse;
import com.google.cloud.workloadmanager.v1.ListRulesRequest;
import com.google.cloud.workloadmanager.v1.ListRulesResponse;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse;
import com.google.cloud.workloadmanager.v1.OperationMetadata;
import com.google.cloud.workloadmanager.v1.RunEvaluationRequest;
import com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest;
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
 * REST stub implementation for the WorkloadManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonWorkloadManagerStub extends WorkloadManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Execution.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Evaluation.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsMethodDescriptor =
          ApiMethodDescriptor.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/ListEvaluations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEvaluationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEvaluationsResponse>newBuilder()
                      .setDefaultInstance(ListEvaluationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEvaluationRequest, Evaluation>
      getEvaluationMethodDescriptor =
          ApiMethodDescriptor.<GetEvaluationRequest, Evaluation>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/GetEvaluation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Evaluation>newBuilder()
                      .setDefaultInstance(Evaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEvaluationRequest, Operation>
      createEvaluationMethodDescriptor =
          ApiMethodDescriptor.<CreateEvaluationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/CreateEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "evaluationId", request.getEvaluationId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("evaluation", request.getEvaluation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEvaluationRequest, Operation>
      updateEvaluationMethodDescriptor =
          ApiMethodDescriptor.<UpdateEvaluationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/UpdateEvaluation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1/{evaluation.name=projects/*/locations/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "evaluation.name", request.getEvaluation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("evaluation", request.getEvaluation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEvaluationRequest, Operation>
      deleteEvaluationMethodDescriptor =
          ApiMethodDescriptor.<DeleteEvaluationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/DeleteEvaluation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          ApiMethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/ListExecutions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExecutionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/evaluations/*}/executions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExecutionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExecutionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExecutionsResponse>newBuilder()
                      .setDefaultInstance(ListExecutionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          ApiMethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/GetExecution")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExecutionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/evaluations/*/executions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Execution>newBuilder()
                      .setDefaultInstance(Execution.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunEvaluationRequest, Operation>
      runEvaluationMethodDescriptor =
          ApiMethodDescriptor.<RunEvaluationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/RunEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunEvaluationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/evaluations/*}/executions:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunEvaluationRequest> serializer =
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
                  (RunEvaluationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteExecutionRequest, Operation>
      deleteExecutionMethodDescriptor =
          ApiMethodDescriptor.<DeleteExecutionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/DeleteExecution")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExecutionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/evaluations/*/executions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExecutionRequest> serializer =
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
                  (DeleteExecutionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsMethodDescriptor =
          ApiMethodDescriptor
              .<ListExecutionResultsRequest, ListExecutionResultsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.workloadmanager.v1.WorkloadManager/ListExecutionResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExecutionResultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/evaluations/*/executions/*}/results",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExecutionResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExecutionResultsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExecutionResultsResponse>newBuilder()
                      .setDefaultInstance(ListExecutionResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRulesRequest, ListRulesResponse>
      listRulesMethodDescriptor =
          ApiMethodDescriptor.<ListRulesRequest, ListRulesResponse>newBuilder()
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/ListRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/rules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "customRulesBucket", request.getCustomRulesBucket());
                            serializer.putQueryParam(
                                fields, "evaluationType", request.getEvaluationTypeValue());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRulesResponse>newBuilder()
                      .setDefaultInstance(ListRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesMethodDescriptor =
          ApiMethodDescriptor
              .<ListScannedResourcesRequest, ListScannedResourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.workloadmanager.v1.WorkloadManager/ListScannedResources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScannedResourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/evaluations/*/executions/*}/scannedResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScannedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScannedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "rule", request.getRule());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListScannedResourcesResponse>newBuilder()
                      .setDefaultInstance(ListScannedResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable;
  private final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable;
  private final UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable;
  private final OperationCallable<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationCallable;
  private final UnaryCallable<UpdateEvaluationRequest, Operation> updateEvaluationCallable;
  private final OperationCallable<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationCallable;
  private final UnaryCallable<DeleteEvaluationRequest, Operation> deleteEvaluationCallable;
  private final OperationCallable<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable;
  private final OperationCallable<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationCallable;
  private final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable;
  private final OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable;
  private final UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsCallable;
  private final UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsPagedResponse>
      listExecutionResultsPagedCallable;
  private final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable;
  private final UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesCallable;
  private final UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesPagedResponse>
      listScannedResourcesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWorkloadManagerStub create(WorkloadManagerStubSettings settings)
      throws IOException {
    return new HttpJsonWorkloadManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWorkloadManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWorkloadManagerStub(
        WorkloadManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWorkloadManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWorkloadManagerStub(
        WorkloadManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWorkloadManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWorkloadManagerStub(
      WorkloadManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonWorkloadManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWorkloadManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWorkloadManagerStub(
      WorkloadManagerStubSettings settings,
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

    HttpJsonCallSettings<ListEvaluationsRequest, ListEvaluationsResponse>
        listEvaluationsTransportSettings =
            HttpJsonCallSettings.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEvaluationRequest, Evaluation> getEvaluationTransportSettings =
        HttpJsonCallSettings.<GetEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(getEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEvaluationRequest, Operation> createEvaluationTransportSettings =
        HttpJsonCallSettings.<CreateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(createEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEvaluationRequest, Operation> updateEvaluationTransportSettings =
        HttpJsonCallSettings.<UpdateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("evaluation.name", String.valueOf(request.getEvaluation().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEvaluationRequest, Operation> deleteEvaluationTransportSettings =
        HttpJsonCallSettings.<DeleteEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            HttpJsonCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        HttpJsonCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunEvaluationRequest, Operation> runEvaluationTransportSettings =
        HttpJsonCallSettings.<RunEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(runEvaluationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteExecutionRequest, Operation> deleteExecutionTransportSettings =
        HttpJsonCallSettings.<DeleteExecutionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExecutionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExecutionResultsRequest, ListExecutionResultsResponse>
        listExecutionResultsTransportSettings =
            HttpJsonCallSettings
                .<ListExecutionResultsRequest, ListExecutionResultsResponse>newBuilder()
                .setMethodDescriptor(listExecutionResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListRulesRequest, ListRulesResponse> listRulesTransportSettings =
        HttpJsonCallSettings.<ListRulesRequest, ListRulesResponse>newBuilder()
            .setMethodDescriptor(listRulesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListScannedResourcesRequest, ListScannedResourcesResponse>
        listScannedResourcesTransportSettings =
            HttpJsonCallSettings
                .<ListScannedResourcesRequest, ListScannedResourcesResponse>newBuilder()
                .setMethodDescriptor(listScannedResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
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

    this.listEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.getEvaluationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationTransportSettings, settings.getEvaluationSettings(), clientContext);
    this.createEvaluationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationTransportSettings, settings.createEvaluationSettings(), clientContext);
    this.createEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createEvaluationTransportSettings,
            settings.createEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEvaluationCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationTransportSettings, settings.updateEvaluationSettings(), clientContext);
    this.updateEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            updateEvaluationTransportSettings,
            settings.updateEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEvaluationCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationTransportSettings, settings.deleteEvaluationSettings(), clientContext);
    this.deleteEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            deleteEvaluationTransportSettings,
            settings.deleteEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.runEvaluationCallable =
        callableFactory.createUnaryCallable(
            runEvaluationTransportSettings, settings.runEvaluationSettings(), clientContext);
    this.runEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            runEvaluationTransportSettings,
            settings.runEvaluationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteExecutionCallable =
        callableFactory.createUnaryCallable(
            deleteExecutionTransportSettings, settings.deleteExecutionSettings(), clientContext);
    this.deleteExecutionOperationCallable =
        callableFactory.createOperationCallable(
            deleteExecutionTransportSettings,
            settings.deleteExecutionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listExecutionResultsCallable =
        callableFactory.createUnaryCallable(
            listExecutionResultsTransportSettings,
            settings.listExecutionResultsSettings(),
            clientContext);
    this.listExecutionResultsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionResultsTransportSettings,
            settings.listExecutionResultsSettings(),
            clientContext);
    this.listRulesCallable =
        callableFactory.createUnaryCallable(
            listRulesTransportSettings, settings.listRulesSettings(), clientContext);
    this.listScannedResourcesCallable =
        callableFactory.createUnaryCallable(
            listScannedResourcesTransportSettings,
            settings.listScannedResourcesSettings(),
            clientContext);
    this.listScannedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listScannedResourcesTransportSettings,
            settings.listScannedResourcesSettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listEvaluationsMethodDescriptor);
    methodDescriptors.add(getEvaluationMethodDescriptor);
    methodDescriptors.add(createEvaluationMethodDescriptor);
    methodDescriptors.add(updateEvaluationMethodDescriptor);
    methodDescriptors.add(deleteEvaluationMethodDescriptor);
    methodDescriptors.add(listExecutionsMethodDescriptor);
    methodDescriptors.add(getExecutionMethodDescriptor);
    methodDescriptors.add(runEvaluationMethodDescriptor);
    methodDescriptors.add(deleteExecutionMethodDescriptor);
    methodDescriptors.add(listExecutionResultsMethodDescriptor);
    methodDescriptors.add(listRulesMethodDescriptor);
    methodDescriptors.add(listScannedResourcesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> listEvaluationsCallable() {
    return listEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return listEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return getEvaluationCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    return createEvaluationCallable;
  }

  @Override
  public OperationCallable<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationCallable() {
    return createEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationRequest, Operation> updateEvaluationCallable() {
    return updateEvaluationCallable;
  }

  @Override
  public OperationCallable<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationCallable() {
    return updateEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationRequest, Operation> deleteEvaluationCallable() {
    return deleteEvaluationCallable;
  }

  @Override
  public OperationCallable<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationCallable() {
    return deleteEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  @Override
  public UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    return runEvaluationCallable;
  }

  @Override
  public OperationCallable<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationCallable() {
    return runEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return deleteExecutionCallable;
  }

  @Override
  public OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    return deleteExecutionOperationCallable;
  }

  @Override
  public UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsCallable() {
    return listExecutionResultsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsPagedResponse>
      listExecutionResultsPagedCallable() {
    return listExecutionResultsPagedCallable;
  }

  @Override
  public UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return listRulesCallable;
  }

  @Override
  public UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesCallable() {
    return listScannedResourcesCallable;
  }

  @Override
  public UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesPagedResponse>
      listScannedResourcesPagedCallable() {
    return listScannedResourcesPagedCallable;
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
