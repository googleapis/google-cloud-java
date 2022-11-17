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

package com.google.cloud.bigquery.datatransfer.v1.stub;

import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferRunsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataSource;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.bigquery.datatransfer.v1.TransferRun;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
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
 * REST stub implementation for the DataTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDataTransferServiceStub extends DataTransferServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          ApiMethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/GetDataSource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataSources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/dataSources/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSource>newBuilder()
                      .setDefaultInstance(DataSource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListDataSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataSourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*}/dataSources")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataSourcesResponse>newBuilder()
                      .setDefaultInstance(ListDataSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateTransferConfigRequest, TransferConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/CreateTransferConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTransferConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/transferConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*}/transferConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "authorizationCode", request.getAuthorizationCode());
                            serializer.putQueryParam(
                                fields, "serviceAccountName", request.getServiceAccountName());
                            serializer.putQueryParam(
                                fields, "versionInfo", request.getVersionInfo());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("transferConfig", request.getTransferConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferConfig>newBuilder()
                      .setDefaultInstance(TransferConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateTransferConfigRequest, TransferConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/UpdateTransferConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTransferConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{transferConfig.name=projects/*/locations/*/transferConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "transferConfig.name",
                                request.getTransferConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{transferConfig.name=projects/*/transferConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "authorizationCode", request.getAuthorizationCode());
                            serializer.putQueryParam(
                                fields, "serviceAccountName", request.getServiceAccountName());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "versionInfo", request.getVersionInfo());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("transferConfig", request.getTransferConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferConfig>newBuilder()
                      .setDefaultInstance(TransferConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTransferConfigRequest, Empty>
      deleteTransferConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteTransferConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/DeleteTransferConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTransferConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/transferConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/transferConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTransferConfigRequest, TransferConfig>
      getTransferConfigMethodDescriptor =
          ApiMethodDescriptor.<GetTransferConfigRequest, TransferConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/GetTransferConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTransferConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/transferConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/transferConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTransferConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferConfig>newBuilder()
                      .setDefaultInstance(TransferConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListTransferConfigsRequest, ListTransferConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListTransferConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTransferConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/transferConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*}/transferConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataSourceIds", request.getDataSourceIdsList());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTransferConfigsResponse>newBuilder()
                      .setDefaultInstance(ListTransferConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsMethodDescriptor =
          ApiMethodDescriptor
              .<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ScheduleTransferRuns")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ScheduleTransferRunsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/transferConfigs/*}:scheduleRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ScheduleTransferRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/transferConfigs/*}:scheduleRuns")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ScheduleTransferRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScheduleTransferRunsResponse>newBuilder()
                      .setDefaultInstance(ScheduleTransferRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsMethodDescriptor =
          ApiMethodDescriptor
              .<StartManualTransferRunsRequest, StartManualTransferRunsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/StartManualTransferRuns")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartManualTransferRunsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/transferConfigs/*}:startManualRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartManualTransferRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/transferConfigs/*}:startManualRuns")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartManualTransferRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StartManualTransferRunsResponse>newBuilder()
                      .setDefaultInstance(StartManualTransferRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTransferRunRequest, TransferRun>
      getTransferRunMethodDescriptor =
          ApiMethodDescriptor.<GetTransferRunRequest, TransferRun>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/GetTransferRun")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTransferRunRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/transferConfigs/*/runs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTransferRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/transferConfigs/*/runs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTransferRunRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferRun>newBuilder()
                      .setDefaultInstance(TransferRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTransferRunRequest, Empty>
      deleteTransferRunMethodDescriptor =
          ApiMethodDescriptor.<DeleteTransferRunRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/DeleteTransferRun")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTransferRunRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/transferConfigs/*/runs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTransferRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/transferConfigs/*/runs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTransferRunRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsMethodDescriptor =
          ApiMethodDescriptor.<ListTransferRunsRequest, ListTransferRunsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListTransferRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTransferRunsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/transferConfigs/*}/runs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/transferConfigs/*}/runs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "runAttempt", request.getRunAttemptValue());
                            serializer.putQueryParam(fields, "states", request.getStatesList());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTransferRunsResponse>newBuilder()
                      .setDefaultInstance(ListTransferRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsMethodDescriptor =
          ApiMethodDescriptor.<ListTransferLogsRequest, ListTransferLogsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListTransferLogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTransferLogsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/transferConfigs/*/runs/*}/transferLogs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferLogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/transferConfigs/*/runs/*}/transferLogs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferLogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "messageTypes", request.getMessageTypesList());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTransferLogsResponse>newBuilder()
                      .setDefaultInstance(ListTransferLogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsMethodDescriptor =
          ApiMethodDescriptor.<CheckValidCredsRequest, CheckValidCredsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/CheckValidCreds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckValidCredsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataSources/*}:checkValidCreds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckValidCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/dataSources/*}:checkValidCreds")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckValidCredsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckValidCredsResponse>newBuilder()
                      .setDefaultInstance(CheckValidCredsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnrollDataSourcesRequest, Empty>
      enrollDataSourcesMethodDescriptor =
          ApiMethodDescriptor.<EnrollDataSourcesRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/EnrollDataSources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnrollDataSourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}:enrollDataSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnrollDataSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*}:enrollDataSources")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnrollDataSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable;
  private final UnaryCallable<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigCallable;
  private final UnaryCallable<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigCallable;
  private final UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable;
  private final UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable;
  private final UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable;
  private final UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable;
  private final UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable;
  private final UnaryCallable<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsCallable;
  private final UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable;
  private final UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable;
  private final UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable;
  private final UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable;
  private final UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable;
  private final UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable;
  private final UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsCallable;
  private final UnaryCallable<EnrollDataSourcesRequest, Empty> enrollDataSourcesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataTransferServiceStub create(
      DataTransferServiceStubSettings settings) throws IOException {
    return new HttpJsonDataTransferServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataTransferServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataTransferServiceStub(
        DataTransferServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataTransferServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataTransferServiceStub(
        DataTransferServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataTransferServiceStub(
      DataTransferServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataTransferServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataTransferServiceStub(
      DataTransferServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDataSourceRequest, DataSource> getDataSourceTransportSettings =
        HttpJsonCallSettings.<GetDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(getDataSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            HttpJsonCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigTransportSettings =
            HttpJsonCallSettings.<CreateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(createTransferConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigTransportSettings =
            HttpJsonCallSettings.<UpdateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(updateTransferConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigTransportSettings =
        HttpJsonCallSettings.<DeleteTransferConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTransferConfigRequest, TransferConfig>
        getTransferConfigTransportSettings =
            HttpJsonCallSettings.<GetTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(getTransferConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTransferConfigsRequest, ListTransferConfigsResponse>
        listTransferConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListTransferConfigsRequest, ListTransferConfigsResponse>newBuilder()
                .setMethodDescriptor(listTransferConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsTransportSettings =
            HttpJsonCallSettings
                .<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>newBuilder()
                .setMethodDescriptor(scheduleTransferRunsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
        startManualTransferRunsTransportSettings =
            HttpJsonCallSettings
                .<StartManualTransferRunsRequest, StartManualTransferRunsResponse>newBuilder()
                .setMethodDescriptor(startManualTransferRunsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTransferRunRequest, TransferRun> getTransferRunTransportSettings =
        HttpJsonCallSettings.<GetTransferRunRequest, TransferRun>newBuilder()
            .setMethodDescriptor(getTransferRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunTransportSettings =
        HttpJsonCallSettings.<DeleteTransferRunRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTransferRunsRequest, ListTransferRunsResponse>
        listTransferRunsTransportSettings =
            HttpJsonCallSettings.<ListTransferRunsRequest, ListTransferRunsResponse>newBuilder()
                .setMethodDescriptor(listTransferRunsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTransferLogsRequest, ListTransferLogsResponse>
        listTransferLogsTransportSettings =
            HttpJsonCallSettings.<ListTransferLogsRequest, ListTransferLogsResponse>newBuilder()
                .setMethodDescriptor(listTransferLogsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsTransportSettings =
            HttpJsonCallSettings.<CheckValidCredsRequest, CheckValidCredsResponse>newBuilder()
                .setMethodDescriptor(checkValidCredsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<EnrollDataSourcesRequest, Empty> enrollDataSourcesTransportSettings =
        HttpJsonCallSettings.<EnrollDataSourcesRequest, Empty>newBuilder()
            .setMethodDescriptor(enrollDataSourcesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getDataSourceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.listDataSourcesCallable =
        callableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.createTransferConfigCallable =
        callableFactory.createUnaryCallable(
            createTransferConfigTransportSettings,
            settings.createTransferConfigSettings(),
            clientContext);
    this.updateTransferConfigCallable =
        callableFactory.createUnaryCallable(
            updateTransferConfigTransportSettings,
            settings.updateTransferConfigSettings(),
            clientContext);
    this.deleteTransferConfigCallable =
        callableFactory.createUnaryCallable(
            deleteTransferConfigTransportSettings,
            settings.deleteTransferConfigSettings(),
            clientContext);
    this.getTransferConfigCallable =
        callableFactory.createUnaryCallable(
            getTransferConfigTransportSettings,
            settings.getTransferConfigSettings(),
            clientContext);
    this.listTransferConfigsCallable =
        callableFactory.createUnaryCallable(
            listTransferConfigsTransportSettings,
            settings.listTransferConfigsSettings(),
            clientContext);
    this.listTransferConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferConfigsTransportSettings,
            settings.listTransferConfigsSettings(),
            clientContext);
    this.scheduleTransferRunsCallable =
        callableFactory.createUnaryCallable(
            scheduleTransferRunsTransportSettings,
            settings.scheduleTransferRunsSettings(),
            clientContext);
    this.startManualTransferRunsCallable =
        callableFactory.createUnaryCallable(
            startManualTransferRunsTransportSettings,
            settings.startManualTransferRunsSettings(),
            clientContext);
    this.getTransferRunCallable =
        callableFactory.createUnaryCallable(
            getTransferRunTransportSettings, settings.getTransferRunSettings(), clientContext);
    this.deleteTransferRunCallable =
        callableFactory.createUnaryCallable(
            deleteTransferRunTransportSettings,
            settings.deleteTransferRunSettings(),
            clientContext);
    this.listTransferRunsCallable =
        callableFactory.createUnaryCallable(
            listTransferRunsTransportSettings, settings.listTransferRunsSettings(), clientContext);
    this.listTransferRunsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferRunsTransportSettings, settings.listTransferRunsSettings(), clientContext);
    this.listTransferLogsCallable =
        callableFactory.createUnaryCallable(
            listTransferLogsTransportSettings, settings.listTransferLogsSettings(), clientContext);
    this.listTransferLogsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferLogsTransportSettings, settings.listTransferLogsSettings(), clientContext);
    this.checkValidCredsCallable =
        callableFactory.createUnaryCallable(
            checkValidCredsTransportSettings, settings.checkValidCredsSettings(), clientContext);
    this.enrollDataSourcesCallable =
        callableFactory.createUnaryCallable(
            enrollDataSourcesTransportSettings,
            settings.enrollDataSourcesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDataSourceMethodDescriptor);
    methodDescriptors.add(listDataSourcesMethodDescriptor);
    methodDescriptors.add(createTransferConfigMethodDescriptor);
    methodDescriptors.add(updateTransferConfigMethodDescriptor);
    methodDescriptors.add(deleteTransferConfigMethodDescriptor);
    methodDescriptors.add(getTransferConfigMethodDescriptor);
    methodDescriptors.add(listTransferConfigsMethodDescriptor);
    methodDescriptors.add(scheduleTransferRunsMethodDescriptor);
    methodDescriptors.add(startManualTransferRunsMethodDescriptor);
    methodDescriptors.add(getTransferRunMethodDescriptor);
    methodDescriptors.add(deleteTransferRunMethodDescriptor);
    methodDescriptors.add(listTransferRunsMethodDescriptor);
    methodDescriptors.add(listTransferLogsMethodDescriptor);
    methodDescriptors.add(checkValidCredsMethodDescriptor);
    methodDescriptors.add(enrollDataSourcesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTransferConfigRequest, TransferConfig> createTransferConfigCallable() {
    return createTransferConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateTransferConfigRequest, TransferConfig> updateTransferConfigCallable() {
    return updateTransferConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable() {
    return deleteTransferConfigCallable;
  }

  @Override
  public UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable() {
    return getTransferConfigCallable;
  }

  @Override
  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable() {
    return listTransferConfigsCallable;
  }

  @Override
  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable() {
    return listTransferConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable() {
    return scheduleTransferRunsCallable;
  }

  @Override
  public UnaryCallable<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsCallable() {
    return startManualTransferRunsCallable;
  }

  @Override
  public UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable() {
    return getTransferRunCallable;
  }

  @Override
  public UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable() {
    return deleteTransferRunCallable;
  }

  @Override
  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable() {
    return listTransferRunsCallable;
  }

  @Override
  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable() {
    return listTransferRunsPagedCallable;
  }

  @Override
  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable() {
    return listTransferLogsCallable;
  }

  @Override
  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable() {
    return listTransferLogsPagedCallable;
  }

  @Override
  public UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse> checkValidCredsCallable() {
    return checkValidCredsCallable;
  }

  @Override
  public UnaryCallable<EnrollDataSourcesRequest, Empty> enrollDataSourcesCallable() {
    return enrollDataSourcesCallable;
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
