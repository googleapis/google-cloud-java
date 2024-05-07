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

package com.google.analytics.data.v1alpha.stub;

import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListRecurringAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListReportTasksPagedResponse;

import com.google.analytics.data.v1alpha.AudienceList;
import com.google.analytics.data.v1alpha.AudienceListMetadata;
import com.google.analytics.data.v1alpha.CreateAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateReportTaskRequest;
import com.google.analytics.data.v1alpha.GetAudienceListRequest;
import com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.GetReportTaskRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListReportTasksRequest;
import com.google.analytics.data.v1alpha.ListReportTasksResponse;
import com.google.analytics.data.v1alpha.QueryAudienceListRequest;
import com.google.analytics.data.v1alpha.QueryAudienceListResponse;
import com.google.analytics.data.v1alpha.QueryReportTaskRequest;
import com.google.analytics.data.v1alpha.QueryReportTaskResponse;
import com.google.analytics.data.v1alpha.RecurringAudienceList;
import com.google.analytics.data.v1alpha.ReportTask;
import com.google.analytics.data.v1alpha.ReportTaskMetadata;
import com.google.analytics.data.v1alpha.RunFunnelReportRequest;
import com.google.analytics.data.v1alpha.RunFunnelReportResponse;
import com.google.analytics.data.v1alpha.SheetExportAudienceListRequest;
import com.google.analytics.data.v1alpha.SheetExportAudienceListResponse;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the AlphaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAlphaAnalyticsDataStub extends AlphaAnalyticsDataStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(AudienceList.getDescriptor())
          .add(ReportTask.getDescriptor())
          .add(AudienceListMetadata.getDescriptor())
          .add(ReportTaskMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportMethodDescriptor =
          ApiMethodDescriptor.<RunFunnelReportRequest, RunFunnelReportResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/RunFunnelReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunFunnelReportRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{property=properties/*}:runFunnelReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunFunnelReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunFunnelReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunFunnelReportResponse>newBuilder()
                      .setDefaultInstance(RunFunnelReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAudienceListRequest, Operation>
      createAudienceListMethodDescriptor =
          ApiMethodDescriptor.<CreateAudienceListRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/CreateAudienceList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAudienceListRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/audienceLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("audienceList", request.getAudienceList(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAudienceListRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListMethodDescriptor =
          ApiMethodDescriptor.<QueryAudienceListRequest, QueryAudienceListResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/QueryAudienceList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryAudienceListRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/audienceLists/*}:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAudienceListRequest> serializer =
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
                  ProtoMessageResponseParser.<QueryAudienceListResponse>newBuilder()
                      .setDefaultInstance(QueryAudienceListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListMethodDescriptor =
          ApiMethodDescriptor
              .<SheetExportAudienceListRequest, SheetExportAudienceListResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/SheetExportAudienceList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SheetExportAudienceListRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/audienceLists/*}:exportSheet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SheetExportAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SheetExportAudienceListRequest> serializer =
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
                  ProtoMessageResponseParser.<SheetExportAudienceListResponse>newBuilder()
                      .setDefaultInstance(SheetExportAudienceListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAudienceListRequest, AudienceList>
      getAudienceListMethodDescriptor =
          ApiMethodDescriptor.<GetAudienceListRequest, AudienceList>newBuilder()
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/GetAudienceList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAudienceListRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/audienceLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AudienceList>newBuilder()
                      .setDefaultInstance(AudienceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsMethodDescriptor =
          ApiMethodDescriptor.<ListAudienceListsRequest, ListAudienceListsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/ListAudienceLists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAudienceListsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/audienceLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAudienceListsResponse>newBuilder()
                      .setDefaultInstance(ListAudienceListsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListMethodDescriptor =
          ApiMethodDescriptor
              .<CreateRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/CreateRecurringAudienceList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRecurringAudienceListRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/recurringAudienceLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRecurringAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRecurringAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "recurringAudienceList",
                                      request.getRecurringAudienceList(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecurringAudienceList>newBuilder()
                      .setDefaultInstance(RecurringAudienceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListMethodDescriptor =
          ApiMethodDescriptor.<GetRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/GetRecurringAudienceList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRecurringAudienceListRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/recurringAudienceLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecurringAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecurringAudienceListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecurringAudienceList>newBuilder()
                      .setDefaultInstance(RecurringAudienceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsMethodDescriptor =
          ApiMethodDescriptor
              .<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/ListRecurringAudienceLists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRecurringAudienceListsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/recurringAudienceLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecurringAudienceListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecurringAudienceListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRecurringAudienceListsResponse>newBuilder()
                      .setDefaultInstance(ListRecurringAudienceListsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReportTaskRequest, Operation>
      createReportTaskMethodDescriptor =
          ApiMethodDescriptor.<CreateReportTaskRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/CreateReportTask")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReportTaskRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/reportTasks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportTaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportTaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reportTask", request.getReportTask(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReportTaskRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskMethodDescriptor =
          ApiMethodDescriptor.<QueryReportTaskRequest, QueryReportTaskResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/QueryReportTask")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryReportTaskRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/reportTasks/*}:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryReportTaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryReportTaskRequest> serializer =
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
                  ProtoMessageResponseParser.<QueryReportTaskResponse>newBuilder()
                      .setDefaultInstance(QueryReportTaskResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReportTaskRequest, ReportTask>
      getReportTaskMethodDescriptor =
          ApiMethodDescriptor.<GetReportTaskRequest, ReportTask>newBuilder()
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/GetReportTask")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReportTaskRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/reportTasks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportTaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportTaskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportTask>newBuilder()
                      .setDefaultInstance(ReportTask.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReportTasksRequest, ListReportTasksResponse>
      listReportTasksMethodDescriptor =
          ApiMethodDescriptor.<ListReportTasksRequest, ListReportTasksResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/ListReportTasks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportTasksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/reportTasks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportTasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportTasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReportTasksResponse>newBuilder()
                      .setDefaultInstance(ListReportTasksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportCallable;
  private final UnaryCallable<CreateAudienceListRequest, Operation> createAudienceListCallable;
  private final OperationCallable<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationCallable;
  private final UnaryCallable<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListCallable;
  private final UnaryCallable<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListCallable;
  private final UnaryCallable<GetAudienceListRequest, AudienceList> getAudienceListCallable;
  private final UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsCallable;
  private final UnaryCallable<ListAudienceListsRequest, ListAudienceListsPagedResponse>
      listAudienceListsPagedCallable;
  private final UnaryCallable<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListCallable;
  private final UnaryCallable<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListCallable;
  private final UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsCallable;
  private final UnaryCallable<
          ListRecurringAudienceListsRequest, ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsPagedCallable;
  private final UnaryCallable<CreateReportTaskRequest, Operation> createReportTaskCallable;
  private final OperationCallable<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationCallable;
  private final UnaryCallable<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskCallable;
  private final UnaryCallable<GetReportTaskRequest, ReportTask> getReportTaskCallable;
  private final UnaryCallable<ListReportTasksRequest, ListReportTasksResponse>
      listReportTasksCallable;
  private final UnaryCallable<ListReportTasksRequest, ListReportTasksPagedResponse>
      listReportTasksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAlphaAnalyticsDataStub create(AlphaAnalyticsDataStubSettings settings)
      throws IOException {
    return new HttpJsonAlphaAnalyticsDataStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAlphaAnalyticsDataStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAlphaAnalyticsDataStub(
        AlphaAnalyticsDataStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAlphaAnalyticsDataStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAlphaAnalyticsDataStub(
        AlphaAnalyticsDataStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAlphaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAlphaAnalyticsDataStub(
      AlphaAnalyticsDataStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAlphaAnalyticsDataCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAlphaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAlphaAnalyticsDataStub(
      AlphaAnalyticsDataStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<RunFunnelReportRequest, RunFunnelReportResponse>
        runFunnelReportTransportSettings =
            HttpJsonCallSettings.<RunFunnelReportRequest, RunFunnelReportResponse>newBuilder()
                .setMethodDescriptor(runFunnelReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAudienceListRequest, Operation> createAudienceListTransportSettings =
        HttpJsonCallSettings.<CreateAudienceListRequest, Operation>newBuilder()
            .setMethodDescriptor(createAudienceListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<QueryAudienceListRequest, QueryAudienceListResponse>
        queryAudienceListTransportSettings =
            HttpJsonCallSettings.<QueryAudienceListRequest, QueryAudienceListResponse>newBuilder()
                .setMethodDescriptor(queryAudienceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
        sheetExportAudienceListTransportSettings =
            HttpJsonCallSettings
                .<SheetExportAudienceListRequest, SheetExportAudienceListResponse>newBuilder()
                .setMethodDescriptor(sheetExportAudienceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAudienceListRequest, AudienceList> getAudienceListTransportSettings =
        HttpJsonCallSettings.<GetAudienceListRequest, AudienceList>newBuilder()
            .setMethodDescriptor(getAudienceListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAudienceListsRequest, ListAudienceListsResponse>
        listAudienceListsTransportSettings =
            HttpJsonCallSettings.<ListAudienceListsRequest, ListAudienceListsResponse>newBuilder()
                .setMethodDescriptor(listAudienceListsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateRecurringAudienceListRequest, RecurringAudienceList>
        createRecurringAudienceListTransportSettings =
            HttpJsonCallSettings
                .<CreateRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
                .setMethodDescriptor(createRecurringAudienceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRecurringAudienceListRequest, RecurringAudienceList>
        getRecurringAudienceListTransportSettings =
            HttpJsonCallSettings
                .<GetRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
                .setMethodDescriptor(getRecurringAudienceListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
        listRecurringAudienceListsTransportSettings =
            HttpJsonCallSettings
                .<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>newBuilder()
                .setMethodDescriptor(listRecurringAudienceListsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateReportTaskRequest, Operation> createReportTaskTransportSettings =
        HttpJsonCallSettings.<CreateReportTaskRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<QueryReportTaskRequest, QueryReportTaskResponse>
        queryReportTaskTransportSettings =
            HttpJsonCallSettings.<QueryReportTaskRequest, QueryReportTaskResponse>newBuilder()
                .setMethodDescriptor(queryReportTaskMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReportTaskRequest, ReportTask> getReportTaskTransportSettings =
        HttpJsonCallSettings.<GetReportTaskRequest, ReportTask>newBuilder()
            .setMethodDescriptor(getReportTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReportTasksRequest, ListReportTasksResponse>
        listReportTasksTransportSettings =
            HttpJsonCallSettings.<ListReportTasksRequest, ListReportTasksResponse>newBuilder()
                .setMethodDescriptor(listReportTasksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.runFunnelReportCallable =
        callableFactory.createUnaryCallable(
            runFunnelReportTransportSettings, settings.runFunnelReportSettings(), clientContext);
    this.createAudienceListCallable =
        callableFactory.createUnaryCallable(
            createAudienceListTransportSettings,
            settings.createAudienceListSettings(),
            clientContext);
    this.createAudienceListOperationCallable =
        callableFactory.createOperationCallable(
            createAudienceListTransportSettings,
            settings.createAudienceListOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.queryAudienceListCallable =
        callableFactory.createUnaryCallable(
            queryAudienceListTransportSettings,
            settings.queryAudienceListSettings(),
            clientContext);
    this.sheetExportAudienceListCallable =
        callableFactory.createUnaryCallable(
            sheetExportAudienceListTransportSettings,
            settings.sheetExportAudienceListSettings(),
            clientContext);
    this.getAudienceListCallable =
        callableFactory.createUnaryCallable(
            getAudienceListTransportSettings, settings.getAudienceListSettings(), clientContext);
    this.listAudienceListsCallable =
        callableFactory.createUnaryCallable(
            listAudienceListsTransportSettings,
            settings.listAudienceListsSettings(),
            clientContext);
    this.listAudienceListsPagedCallable =
        callableFactory.createPagedCallable(
            listAudienceListsTransportSettings,
            settings.listAudienceListsSettings(),
            clientContext);
    this.createRecurringAudienceListCallable =
        callableFactory.createUnaryCallable(
            createRecurringAudienceListTransportSettings,
            settings.createRecurringAudienceListSettings(),
            clientContext);
    this.getRecurringAudienceListCallable =
        callableFactory.createUnaryCallable(
            getRecurringAudienceListTransportSettings,
            settings.getRecurringAudienceListSettings(),
            clientContext);
    this.listRecurringAudienceListsCallable =
        callableFactory.createUnaryCallable(
            listRecurringAudienceListsTransportSettings,
            settings.listRecurringAudienceListsSettings(),
            clientContext);
    this.listRecurringAudienceListsPagedCallable =
        callableFactory.createPagedCallable(
            listRecurringAudienceListsTransportSettings,
            settings.listRecurringAudienceListsSettings(),
            clientContext);
    this.createReportTaskCallable =
        callableFactory.createUnaryCallable(
            createReportTaskTransportSettings, settings.createReportTaskSettings(), clientContext);
    this.createReportTaskOperationCallable =
        callableFactory.createOperationCallable(
            createReportTaskTransportSettings,
            settings.createReportTaskOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.queryReportTaskCallable =
        callableFactory.createUnaryCallable(
            queryReportTaskTransportSettings, settings.queryReportTaskSettings(), clientContext);
    this.getReportTaskCallable =
        callableFactory.createUnaryCallable(
            getReportTaskTransportSettings, settings.getReportTaskSettings(), clientContext);
    this.listReportTasksCallable =
        callableFactory.createUnaryCallable(
            listReportTasksTransportSettings, settings.listReportTasksSettings(), clientContext);
    this.listReportTasksPagedCallable =
        callableFactory.createPagedCallable(
            listReportTasksTransportSettings, settings.listReportTasksSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(runFunnelReportMethodDescriptor);
    methodDescriptors.add(createAudienceListMethodDescriptor);
    methodDescriptors.add(queryAudienceListMethodDescriptor);
    methodDescriptors.add(sheetExportAudienceListMethodDescriptor);
    methodDescriptors.add(getAudienceListMethodDescriptor);
    methodDescriptors.add(listAudienceListsMethodDescriptor);
    methodDescriptors.add(createRecurringAudienceListMethodDescriptor);
    methodDescriptors.add(getRecurringAudienceListMethodDescriptor);
    methodDescriptors.add(listRecurringAudienceListsMethodDescriptor);
    methodDescriptors.add(createReportTaskMethodDescriptor);
    methodDescriptors.add(queryReportTaskMethodDescriptor);
    methodDescriptors.add(getReportTaskMethodDescriptor);
    methodDescriptors.add(listReportTasksMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse> runFunnelReportCallable() {
    return runFunnelReportCallable;
  }

  @Override
  public UnaryCallable<CreateAudienceListRequest, Operation> createAudienceListCallable() {
    return createAudienceListCallable;
  }

  @Override
  public OperationCallable<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationCallable() {
    return createAudienceListOperationCallable;
  }

  @Override
  public UnaryCallable<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListCallable() {
    return queryAudienceListCallable;
  }

  @Override
  public UnaryCallable<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListCallable() {
    return sheetExportAudienceListCallable;
  }

  @Override
  public UnaryCallable<GetAudienceListRequest, AudienceList> getAudienceListCallable() {
    return getAudienceListCallable;
  }

  @Override
  public UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsCallable() {
    return listAudienceListsCallable;
  }

  @Override
  public UnaryCallable<ListAudienceListsRequest, ListAudienceListsPagedResponse>
      listAudienceListsPagedCallable() {
    return listAudienceListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListCallable() {
    return createRecurringAudienceListCallable;
  }

  @Override
  public UnaryCallable<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListCallable() {
    return getRecurringAudienceListCallable;
  }

  @Override
  public UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsCallable() {
    return listRecurringAudienceListsCallable;
  }

  @Override
  public UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsPagedCallable() {
    return listRecurringAudienceListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateReportTaskRequest, Operation> createReportTaskCallable() {
    return createReportTaskCallable;
  }

  @Override
  public OperationCallable<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationCallable() {
    return createReportTaskOperationCallable;
  }

  @Override
  public UnaryCallable<QueryReportTaskRequest, QueryReportTaskResponse> queryReportTaskCallable() {
    return queryReportTaskCallable;
  }

  @Override
  public UnaryCallable<GetReportTaskRequest, ReportTask> getReportTaskCallable() {
    return getReportTaskCallable;
  }

  @Override
  public UnaryCallable<ListReportTasksRequest, ListReportTasksResponse> listReportTasksCallable() {
    return listReportTasksCallable;
  }

  @Override
  public UnaryCallable<ListReportTasksRequest, ListReportTasksPagedResponse>
      listReportTasksPagedCallable() {
    return listReportTasksPagedCallable;
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
