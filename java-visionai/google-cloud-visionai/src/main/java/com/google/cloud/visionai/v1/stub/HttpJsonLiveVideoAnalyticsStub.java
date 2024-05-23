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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListAnalysesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListOperatorsPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListProcessesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListPublicOperatorsPagedResponse;

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
import com.google.cloud.visionai.v1.Analysis;
import com.google.cloud.visionai.v1.BatchRunProcessRequest;
import com.google.cloud.visionai.v1.BatchRunProcessResponse;
import com.google.cloud.visionai.v1.CreateAnalysisRequest;
import com.google.cloud.visionai.v1.CreateOperatorRequest;
import com.google.cloud.visionai.v1.CreateProcessRequest;
import com.google.cloud.visionai.v1.DeleteAnalysisRequest;
import com.google.cloud.visionai.v1.DeleteOperatorRequest;
import com.google.cloud.visionai.v1.DeleteProcessRequest;
import com.google.cloud.visionai.v1.GetAnalysisRequest;
import com.google.cloud.visionai.v1.GetOperatorRequest;
import com.google.cloud.visionai.v1.GetProcessRequest;
import com.google.cloud.visionai.v1.ListAnalysesRequest;
import com.google.cloud.visionai.v1.ListAnalysesResponse;
import com.google.cloud.visionai.v1.ListOperatorsRequest;
import com.google.cloud.visionai.v1.ListOperatorsResponse;
import com.google.cloud.visionai.v1.ListProcessesRequest;
import com.google.cloud.visionai.v1.ListProcessesResponse;
import com.google.cloud.visionai.v1.ListPublicOperatorsRequest;
import com.google.cloud.visionai.v1.ListPublicOperatorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Operator;
import com.google.cloud.visionai.v1.Process;
import com.google.cloud.visionai.v1.ResolveOperatorInfoRequest;
import com.google.cloud.visionai.v1.ResolveOperatorInfoResponse;
import com.google.cloud.visionai.v1.UpdateAnalysisRequest;
import com.google.cloud.visionai.v1.UpdateOperatorRequest;
import com.google.cloud.visionai.v1.UpdateProcessRequest;
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
 * REST stub implementation for the LiveVideoAnalytics service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLiveVideoAnalyticsStub extends LiveVideoAnalyticsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Analysis.getDescriptor())
          .add(Empty.getDescriptor())
          .add(BatchRunProcessResponse.getDescriptor())
          .add(Operator.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Process.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsMethodDescriptor =
          ApiMethodDescriptor.<ListPublicOperatorsRequest, ListPublicOperatorsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListPublicOperators")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPublicOperatorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:listPublicOperators",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublicOperatorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublicOperatorsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPublicOperatorsResponse>newBuilder()
                      .setDefaultInstance(ListPublicOperatorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoMethodDescriptor =
          ApiMethodDescriptor.<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ResolveOperatorInfo")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResolveOperatorInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:resolveOperatorInfo",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResolveOperatorInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResolveOperatorInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResolveOperatorInfoResponse>newBuilder()
                      .setDefaultInstance(ResolveOperatorInfoResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListOperatorsRequest, ListOperatorsResponse>
      listOperatorsMethodDescriptor =
          ApiMethodDescriptor.<ListOperatorsRequest, ListOperatorsResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListOperators")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOperatorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/operators",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOperatorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOperatorsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOperatorsResponse>newBuilder()
                      .setDefaultInstance(ListOperatorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOperatorRequest, Operator>
      getOperatorMethodDescriptor =
          ApiMethodDescriptor.<GetOperatorRequest, Operator>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/GetOperator")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOperatorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/operators/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operator>newBuilder()
                      .setDefaultInstance(Operator.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOperatorRequest, Operation>
      createOperatorMethodDescriptor =
          ApiMethodDescriptor.<CreateOperatorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/CreateOperator")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOperatorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/operators",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "operatorId", request.getOperatorId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("operator", request.getOperator(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOperatorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateOperatorRequest, Operation>
      updateOperatorMethodDescriptor =
          ApiMethodDescriptor.<UpdateOperatorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/UpdateOperator")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOperatorRequest>newBuilder()
                      .setPath(
                          "/v1/{operator.name=projects/*/locations/*/operators/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "operator.name", request.getOperator().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("operator", request.getOperator(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateOperatorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteOperatorRequest, Operation>
      deleteOperatorMethodDescriptor =
          ApiMethodDescriptor.<DeleteOperatorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/DeleteOperator")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOperatorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/operators/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOperatorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOperatorRequest> serializer =
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
                  (DeleteOperatorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAnalysesRequest, ListAnalysesResponse>
      listAnalysesMethodDescriptor =
          ApiMethodDescriptor.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListAnalyses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnalysesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/analyses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalysesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalysesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAnalysesResponse>newBuilder()
                      .setDefaultInstance(ListAnalysesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAnalysisRequest, Analysis>
      getAnalysisMethodDescriptor =
          ApiMethodDescriptor.<GetAnalysisRequest, Analysis>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/GetAnalysis")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/analyses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Analysis>newBuilder()
                      .setDefaultInstance(Analysis.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAnalysisRequest, Operation>
      createAnalysisMethodDescriptor =
          ApiMethodDescriptor.<CreateAnalysisRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/CreateAnalysis")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/analyses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "analysisId", request.getAnalysisId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("analysis", request.getAnalysis(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAnalysisRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAnalysisRequest, Operation>
      updateAnalysisMethodDescriptor =
          ApiMethodDescriptor.<UpdateAnalysisRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/UpdateAnalysis")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{analysis.name=projects/*/locations/*/clusters/*/analyses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "analysis.name", request.getAnalysis().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("analysis", request.getAnalysis(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAnalysisRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAnalysisRequest, Operation>
      deleteAnalysisMethodDescriptor =
          ApiMethodDescriptor.<DeleteAnalysisRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/DeleteAnalysis")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/analyses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalysisRequest> serializer =
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
                  (DeleteAnalysisRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListProcessesRequest, ListProcessesResponse>
      listProcessesMethodDescriptor =
          ApiMethodDescriptor.<ListProcessesRequest, ListProcessesResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListProcesses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProcessesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/processes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProcessesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProcessesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListProcessesResponse>newBuilder()
                      .setDefaultInstance(ListProcessesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProcessRequest, Process> getProcessMethodDescriptor =
      ApiMethodDescriptor.<GetProcessRequest, Process>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/GetProcess")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProcessRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/clusters/*/processes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProcessRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProcessRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Process>newBuilder()
                  .setDefaultInstance(Process.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateProcessRequest, Operation>
      createProcessMethodDescriptor =
          ApiMethodDescriptor.<CreateProcessRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/CreateProcess")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/processes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "processId", request.getProcessId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("process", request.getProcess(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateProcessRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateProcessRequest, Operation>
      updateProcessMethodDescriptor =
          ApiMethodDescriptor.<UpdateProcessRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/UpdateProcess")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{process.name=projects/*/locations/*/clusters/*/processes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "process.name", request.getProcess().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("process", request.getProcess(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateProcessRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteProcessRequest, Operation>
      deleteProcessMethodDescriptor =
          ApiMethodDescriptor.<DeleteProcessRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/DeleteProcess")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/clusters/*/processes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProcessRequest> serializer =
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
                  (DeleteProcessRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchRunProcessRequest, Operation>
      batchRunProcessMethodDescriptor =
          ApiMethodDescriptor.<BatchRunProcessRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/BatchRunProcess")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRunProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/clusters/*}/processes:batchRun",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchRunProcessRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsCallable;
  private final UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsPagedResponse>
      listPublicOperatorsPagedCallable;
  private final UnaryCallable<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoCallable;
  private final UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> listOperatorsCallable;
  private final UnaryCallable<ListOperatorsRequest, ListOperatorsPagedResponse>
      listOperatorsPagedCallable;
  private final UnaryCallable<GetOperatorRequest, Operator> getOperatorCallable;
  private final UnaryCallable<CreateOperatorRequest, Operation> createOperatorCallable;
  private final OperationCallable<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationCallable;
  private final UnaryCallable<UpdateOperatorRequest, Operation> updateOperatorCallable;
  private final OperationCallable<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationCallable;
  private final UnaryCallable<DeleteOperatorRequest, Operation> deleteOperatorCallable;
  private final OperationCallable<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationCallable;
  private final UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable;
  private final UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse>
      listAnalysesPagedCallable;
  private final UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable;
  private final UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable;
  private final OperationCallable<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationCallable;
  private final UnaryCallable<UpdateAnalysisRequest, Operation> updateAnalysisCallable;
  private final OperationCallable<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationCallable;
  private final UnaryCallable<DeleteAnalysisRequest, Operation> deleteAnalysisCallable;
  private final OperationCallable<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable;
  private final UnaryCallable<GetProcessRequest, Process> getProcessCallable;
  private final UnaryCallable<CreateProcessRequest, Operation> createProcessCallable;
  private final OperationCallable<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationCallable;
  private final UnaryCallable<UpdateProcessRequest, Operation> updateProcessCallable;
  private final OperationCallable<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationCallable;
  private final UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable;
  private final OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable;
  private final UnaryCallable<BatchRunProcessRequest, Operation> batchRunProcessCallable;
  private final OperationCallable<
          BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLiveVideoAnalyticsStub create(LiveVideoAnalyticsStubSettings settings)
      throws IOException {
    return new HttpJsonLiveVideoAnalyticsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLiveVideoAnalyticsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLiveVideoAnalyticsStub(
        LiveVideoAnalyticsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLiveVideoAnalyticsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLiveVideoAnalyticsStub(
        LiveVideoAnalyticsStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLiveVideoAnalyticsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLiveVideoAnalyticsStub(
      LiveVideoAnalyticsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLiveVideoAnalyticsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLiveVideoAnalyticsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLiveVideoAnalyticsStub(
      LiveVideoAnalyticsStubSettings settings,
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
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/warehouseOperations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/assets/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/imageIndexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/corpora/*/indexes/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/corpora/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/indexEndpoints/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
        listPublicOperatorsTransportSettings =
            HttpJsonCallSettings
                .<ListPublicOperatorsRequest, ListPublicOperatorsResponse>newBuilder()
                .setMethodDescriptor(listPublicOperatorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
        resolveOperatorInfoTransportSettings =
            HttpJsonCallSettings
                .<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>newBuilder()
                .setMethodDescriptor(resolveOperatorInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOperatorsRequest, ListOperatorsResponse>
        listOperatorsTransportSettings =
            HttpJsonCallSettings.<ListOperatorsRequest, ListOperatorsResponse>newBuilder()
                .setMethodDescriptor(listOperatorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOperatorRequest, Operator> getOperatorTransportSettings =
        HttpJsonCallSettings.<GetOperatorRequest, Operator>newBuilder()
            .setMethodDescriptor(getOperatorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateOperatorRequest, Operation> createOperatorTransportSettings =
        HttpJsonCallSettings.<CreateOperatorRequest, Operation>newBuilder()
            .setMethodDescriptor(createOperatorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateOperatorRequest, Operation> updateOperatorTransportSettings =
        HttpJsonCallSettings.<UpdateOperatorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateOperatorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("operator.name", String.valueOf(request.getOperator().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteOperatorRequest, Operation> deleteOperatorTransportSettings =
        HttpJsonCallSettings.<DeleteOperatorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOperatorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        HttpJsonCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        HttpJsonCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        HttpJsonCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAnalysisRequest, Operation> updateAnalysisTransportSettings =
        HttpJsonCallSettings.<UpdateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("analysis.name", String.valueOf(request.getAnalysis().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAnalysisRequest, Operation> deleteAnalysisTransportSettings =
        HttpJsonCallSettings.<DeleteAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProcessesRequest, ListProcessesResponse>
        listProcessesTransportSettings =
            HttpJsonCallSettings.<ListProcessesRequest, ListProcessesResponse>newBuilder()
                .setMethodDescriptor(listProcessesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetProcessRequest, Process> getProcessTransportSettings =
        HttpJsonCallSettings.<GetProcessRequest, Process>newBuilder()
            .setMethodDescriptor(getProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateProcessRequest, Operation> createProcessTransportSettings =
        HttpJsonCallSettings.<CreateProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(createProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateProcessRequest, Operation> updateProcessTransportSettings =
        HttpJsonCallSettings.<UpdateProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(updateProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("process.name", String.valueOf(request.getProcess().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteProcessRequest, Operation> deleteProcessTransportSettings =
        HttpJsonCallSettings.<DeleteProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchRunProcessRequest, Operation> batchRunProcessTransportSettings =
        HttpJsonCallSettings.<BatchRunProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(batchRunProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.listPublicOperatorsCallable =
        callableFactory.createUnaryCallable(
            listPublicOperatorsTransportSettings,
            settings.listPublicOperatorsSettings(),
            clientContext);
    this.listPublicOperatorsPagedCallable =
        callableFactory.createPagedCallable(
            listPublicOperatorsTransportSettings,
            settings.listPublicOperatorsSettings(),
            clientContext);
    this.resolveOperatorInfoCallable =
        callableFactory.createUnaryCallable(
            resolveOperatorInfoTransportSettings,
            settings.resolveOperatorInfoSettings(),
            clientContext);
    this.listOperatorsCallable =
        callableFactory.createUnaryCallable(
            listOperatorsTransportSettings, settings.listOperatorsSettings(), clientContext);
    this.listOperatorsPagedCallable =
        callableFactory.createPagedCallable(
            listOperatorsTransportSettings, settings.listOperatorsSettings(), clientContext);
    this.getOperatorCallable =
        callableFactory.createUnaryCallable(
            getOperatorTransportSettings, settings.getOperatorSettings(), clientContext);
    this.createOperatorCallable =
        callableFactory.createUnaryCallable(
            createOperatorTransportSettings, settings.createOperatorSettings(), clientContext);
    this.createOperatorOperationCallable =
        callableFactory.createOperationCallable(
            createOperatorTransportSettings,
            settings.createOperatorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateOperatorCallable =
        callableFactory.createUnaryCallable(
            updateOperatorTransportSettings, settings.updateOperatorSettings(), clientContext);
    this.updateOperatorOperationCallable =
        callableFactory.createOperationCallable(
            updateOperatorTransportSettings,
            settings.updateOperatorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteOperatorCallable =
        callableFactory.createUnaryCallable(
            deleteOperatorTransportSettings, settings.deleteOperatorSettings(), clientContext);
    this.deleteOperatorOperationCallable =
        callableFactory.createOperationCallable(
            deleteOperatorTransportSettings,
            settings.deleteOperatorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAnalysesCallable =
        callableFactory.createUnaryCallable(
            listAnalysesTransportSettings, settings.listAnalysesSettings(), clientContext);
    this.listAnalysesPagedCallable =
        callableFactory.createPagedCallable(
            listAnalysesTransportSettings, settings.listAnalysesSettings(), clientContext);
    this.getAnalysisCallable =
        callableFactory.createUnaryCallable(
            getAnalysisTransportSettings, settings.getAnalysisSettings(), clientContext);
    this.createAnalysisCallable =
        callableFactory.createUnaryCallable(
            createAnalysisTransportSettings, settings.createAnalysisSettings(), clientContext);
    this.createAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            createAnalysisTransportSettings,
            settings.createAnalysisOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAnalysisCallable =
        callableFactory.createUnaryCallable(
            updateAnalysisTransportSettings, settings.updateAnalysisSettings(), clientContext);
    this.updateAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            updateAnalysisTransportSettings,
            settings.updateAnalysisOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAnalysisCallable =
        callableFactory.createUnaryCallable(
            deleteAnalysisTransportSettings, settings.deleteAnalysisSettings(), clientContext);
    this.deleteAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            deleteAnalysisTransportSettings,
            settings.deleteAnalysisOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listProcessesCallable =
        callableFactory.createUnaryCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.listProcessesPagedCallable =
        callableFactory.createPagedCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.getProcessCallable =
        callableFactory.createUnaryCallable(
            getProcessTransportSettings, settings.getProcessSettings(), clientContext);
    this.createProcessCallable =
        callableFactory.createUnaryCallable(
            createProcessTransportSettings, settings.createProcessSettings(), clientContext);
    this.createProcessOperationCallable =
        callableFactory.createOperationCallable(
            createProcessTransportSettings,
            settings.createProcessOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateProcessCallable =
        callableFactory.createUnaryCallable(
            updateProcessTransportSettings, settings.updateProcessSettings(), clientContext);
    this.updateProcessOperationCallable =
        callableFactory.createOperationCallable(
            updateProcessTransportSettings,
            settings.updateProcessOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteProcessCallable =
        callableFactory.createUnaryCallable(
            deleteProcessTransportSettings, settings.deleteProcessSettings(), clientContext);
    this.deleteProcessOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessTransportSettings,
            settings.deleteProcessOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchRunProcessCallable =
        callableFactory.createUnaryCallable(
            batchRunProcessTransportSettings, settings.batchRunProcessSettings(), clientContext);
    this.batchRunProcessOperationCallable =
        callableFactory.createOperationCallable(
            batchRunProcessTransportSettings,
            settings.batchRunProcessOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listPublicOperatorsMethodDescriptor);
    methodDescriptors.add(resolveOperatorInfoMethodDescriptor);
    methodDescriptors.add(listOperatorsMethodDescriptor);
    methodDescriptors.add(getOperatorMethodDescriptor);
    methodDescriptors.add(createOperatorMethodDescriptor);
    methodDescriptors.add(updateOperatorMethodDescriptor);
    methodDescriptors.add(deleteOperatorMethodDescriptor);
    methodDescriptors.add(listAnalysesMethodDescriptor);
    methodDescriptors.add(getAnalysisMethodDescriptor);
    methodDescriptors.add(createAnalysisMethodDescriptor);
    methodDescriptors.add(updateAnalysisMethodDescriptor);
    methodDescriptors.add(deleteAnalysisMethodDescriptor);
    methodDescriptors.add(listProcessesMethodDescriptor);
    methodDescriptors.add(getProcessMethodDescriptor);
    methodDescriptors.add(createProcessMethodDescriptor);
    methodDescriptors.add(updateProcessMethodDescriptor);
    methodDescriptors.add(deleteProcessMethodDescriptor);
    methodDescriptors.add(batchRunProcessMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsCallable() {
    return listPublicOperatorsCallable;
  }

  @Override
  public UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsPagedResponse>
      listPublicOperatorsPagedCallable() {
    return listPublicOperatorsPagedCallable;
  }

  @Override
  public UnaryCallable<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoCallable() {
    return resolveOperatorInfoCallable;
  }

  @Override
  public UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> listOperatorsCallable() {
    return listOperatorsCallable;
  }

  @Override
  public UnaryCallable<ListOperatorsRequest, ListOperatorsPagedResponse>
      listOperatorsPagedCallable() {
    return listOperatorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOperatorRequest, Operator> getOperatorCallable() {
    return getOperatorCallable;
  }

  @Override
  public UnaryCallable<CreateOperatorRequest, Operation> createOperatorCallable() {
    return createOperatorCallable;
  }

  @Override
  public OperationCallable<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationCallable() {
    return createOperatorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateOperatorRequest, Operation> updateOperatorCallable() {
    return updateOperatorCallable;
  }

  @Override
  public OperationCallable<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationCallable() {
    return updateOperatorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOperatorRequest, Operation> deleteOperatorCallable() {
    return deleteOperatorCallable;
  }

  @Override
  public OperationCallable<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationCallable() {
    return deleteOperatorOperationCallable;
  }

  @Override
  public UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    return listAnalysesCallable;
  }

  @Override
  public UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse> listAnalysesPagedCallable() {
    return listAnalysesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    return getAnalysisCallable;
  }

  @Override
  public UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    return createAnalysisCallable;
  }

  @Override
  public OperationCallable<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationCallable() {
    return createAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAnalysisRequest, Operation> updateAnalysisCallable() {
    return updateAnalysisCallable;
  }

  @Override
  public OperationCallable<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationCallable() {
    return updateAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalysisRequest, Operation> deleteAnalysisCallable() {
    return deleteAnalysisCallable;
  }

  @Override
  public OperationCallable<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationCallable() {
    return deleteAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    return listProcessesCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    return listProcessesPagedCallable;
  }

  @Override
  public UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    return getProcessCallable;
  }

  @Override
  public UnaryCallable<CreateProcessRequest, Operation> createProcessCallable() {
    return createProcessCallable;
  }

  @Override
  public OperationCallable<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationCallable() {
    return createProcessOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateProcessRequest, Operation> updateProcessCallable() {
    return updateProcessCallable;
  }

  @Override
  public OperationCallable<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationCallable() {
    return updateProcessOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    return deleteProcessCallable;
  }

  @Override
  public OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    return deleteProcessOperationCallable;
  }

  @Override
  public UnaryCallable<BatchRunProcessRequest, Operation> batchRunProcessCallable() {
    return batchRunProcessCallable;
  }

  @Override
  public OperationCallable<BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationCallable() {
    return batchRunProcessOperationCallable;
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
