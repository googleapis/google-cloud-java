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

package com.google.cloud.storageinsights.v1.stub;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListDatasetConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

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
import com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.CreateReportConfigRequest;
import com.google.cloud.storageinsights.v1.DatasetConfig;
import com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportDetailRequest;
import com.google.cloud.storageinsights.v1.LinkDatasetRequest;
import com.google.cloud.storageinsights.v1.LinkDatasetResponse;
import com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest;
import com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportConfigsRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportDetailsRequest;
import com.google.cloud.storageinsights.v1.ListReportDetailsResponse;
import com.google.cloud.storageinsights.v1.OperationMetadata;
import com.google.cloud.storageinsights.v1.ReportConfig;
import com.google.cloud.storageinsights.v1.ReportDetail;
import com.google.cloud.storageinsights.v1.UnlinkDatasetRequest;
import com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.UpdateReportConfigRequest;
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
 * REST stub implementation for the StorageInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonStorageInsightsStub extends StorageInsightsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DatasetConfig.getDescriptor())
          .add(Empty.getDescriptor())
          .add(LinkDatasetResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListReportConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reportConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReportConfigsResponse>newBuilder()
                      .setDefaultInstance(ListReportConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReportConfigRequest, ReportConfig>
      getReportConfigMethodDescriptor =
          ApiMethodDescriptor.<GetReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetReportConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReportConfigRequest, ReportConfig>
      createReportConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/CreateReportConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reportConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reportConfig", request.getReportConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReportConfigRequest, ReportConfig>
      updateReportConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/UpdateReportConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{reportConfig.name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "reportConfig.name", request.getReportConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reportConfig", request.getReportConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReportConfigRequest, Empty>
      deleteReportConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteReportConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/DeleteReportConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsMethodDescriptor =
          ApiMethodDescriptor.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListReportDetails")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportDetailsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/reportConfigs/*}/reportDetails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportDetailsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReportDetailsResponse>newBuilder()
                      .setDefaultInstance(ListReportDetailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReportDetailRequest, ReportDetail>
      getReportDetailMethodDescriptor =
          ApiMethodDescriptor.<GetReportDetailRequest, ReportDetail>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetReportDetail")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReportDetailRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*/reportDetails/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportDetailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportDetailRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportDetail>newBuilder()
                      .setDefaultInstance(ReportDetail.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
      listDatasetConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListDatasetConfigsRequest, ListDatasetConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListDatasetConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/datasetConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDatasetConfigsResponse>newBuilder()
                      .setDefaultInstance(ListDatasetConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDatasetConfigRequest, DatasetConfig>
      getDatasetConfigMethodDescriptor =
          ApiMethodDescriptor.<GetDatasetConfigRequest, DatasetConfig>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetDatasetConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDatasetConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasetConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DatasetConfig>newBuilder()
                      .setDefaultInstance(DatasetConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDatasetConfigRequest, Operation>
      createDatasetConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateDatasetConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/CreateDatasetConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatasetConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/datasetConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "datasetConfigId", request.getDatasetConfigId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("datasetConfig", request.getDatasetConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDatasetConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDatasetConfigRequest, Operation>
      updateDatasetConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateDatasetConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/UpdateDatasetConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDatasetConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{datasetConfig.name=projects/*/locations/*/datasetConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "datasetConfig.name", request.getDatasetConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("datasetConfig", request.getDatasetConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDatasetConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDatasetConfigRequest, Operation>
      deleteDatasetConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatasetConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/DeleteDatasetConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatasetConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasetConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetConfigRequest> serializer =
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
                  (DeleteDatasetConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<LinkDatasetRequest, Operation>
      linkDatasetMethodDescriptor =
          ApiMethodDescriptor.<LinkDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/LinkDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LinkDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasetConfigs/*}:linkDataset",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LinkDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LinkDatasetRequest> serializer =
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
                  (LinkDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UnlinkDatasetRequest, Operation>
      unlinkDatasetMethodDescriptor =
          ApiMethodDescriptor.<UnlinkDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/UnlinkDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnlinkDatasetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/datasetConfigs/*}:unlinkDataset",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnlinkDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnlinkDatasetRequest> serializer =
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
                  (UnlinkDatasetRequest request, Operation response) ->
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

  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable;
  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable;
  private final UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable;
  private final UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable;
  private final UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable;
  private final UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable;
  private final UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable;
  private final UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable;
  private final UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable;
  private final UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
      listDatasetConfigsCallable;
  private final UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsPagedResponse>
      listDatasetConfigsPagedCallable;
  private final UnaryCallable<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigCallable;
  private final UnaryCallable<CreateDatasetConfigRequest, Operation> createDatasetConfigCallable;
  private final OperationCallable<CreateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      createDatasetConfigOperationCallable;
  private final UnaryCallable<UpdateDatasetConfigRequest, Operation> updateDatasetConfigCallable;
  private final OperationCallable<UpdateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      updateDatasetConfigOperationCallable;
  private final UnaryCallable<DeleteDatasetConfigRequest, Operation> deleteDatasetConfigCallable;
  private final OperationCallable<DeleteDatasetConfigRequest, Empty, OperationMetadata>
      deleteDatasetConfigOperationCallable;
  private final UnaryCallable<LinkDatasetRequest, Operation> linkDatasetCallable;
  private final OperationCallable<LinkDatasetRequest, LinkDatasetResponse, OperationMetadata>
      linkDatasetOperationCallable;
  private final UnaryCallable<UnlinkDatasetRequest, Operation> unlinkDatasetCallable;
  private final OperationCallable<UnlinkDatasetRequest, Empty, OperationMetadata>
      unlinkDatasetOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonStorageInsightsStub create(StorageInsightsStubSettings settings)
      throws IOException {
    return new HttpJsonStorageInsightsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStorageInsightsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStorageInsightsStub(
        StorageInsightsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStorageInsightsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStorageInsightsStub(
        StorageInsightsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStorageInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageInsightsStub(
      StorageInsightsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStorageInsightsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStorageInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageInsightsStub(
      StorageInsightsStubSettings settings,
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

    HttpJsonCallSettings<ListReportConfigsRequest, ListReportConfigsResponse>
        listReportConfigsTransportSettings =
            HttpJsonCallSettings.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
                .setMethodDescriptor(listReportConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigTransportSettings =
        HttpJsonCallSettings.<GetReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(getReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReportConfigRequest, ReportConfig>
        createReportConfigTransportSettings =
            HttpJsonCallSettings.<CreateReportConfigRequest, ReportConfig>newBuilder()
                .setMethodDescriptor(createReportConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateReportConfigRequest, ReportConfig>
        updateReportConfigTransportSettings =
            HttpJsonCallSettings.<UpdateReportConfigRequest, ReportConfig>newBuilder()
                .setMethodDescriptor(updateReportConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "report_config.name",
                          String.valueOf(request.getReportConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigTransportSettings =
        HttpJsonCallSettings.<DeleteReportConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReportDetailsRequest, ListReportDetailsResponse>
        listReportDetailsTransportSettings =
            HttpJsonCallSettings.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
                .setMethodDescriptor(listReportDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailTransportSettings =
        HttpJsonCallSettings.<GetReportDetailRequest, ReportDetail>newBuilder()
            .setMethodDescriptor(getReportDetailMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
        listDatasetConfigsTransportSettings =
            HttpJsonCallSettings.<ListDatasetConfigsRequest, ListDatasetConfigsResponse>newBuilder()
                .setMethodDescriptor(listDatasetConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigTransportSettings =
        HttpJsonCallSettings.<GetDatasetConfigRequest, DatasetConfig>newBuilder()
            .setMethodDescriptor(getDatasetConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDatasetConfigRequest, Operation>
        createDatasetConfigTransportSettings =
            HttpJsonCallSettings.<CreateDatasetConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createDatasetConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDatasetConfigRequest, Operation>
        updateDatasetConfigTransportSettings =
            HttpJsonCallSettings.<UpdateDatasetConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDatasetConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "dataset_config.name",
                          String.valueOf(request.getDatasetConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDatasetConfigRequest, Operation>
        deleteDatasetConfigTransportSettings =
            HttpJsonCallSettings.<DeleteDatasetConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDatasetConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<LinkDatasetRequest, Operation> linkDatasetTransportSettings =
        HttpJsonCallSettings.<LinkDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(linkDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UnlinkDatasetRequest, Operation> unlinkDatasetTransportSettings =
        HttpJsonCallSettings.<UnlinkDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(unlinkDatasetMethodDescriptor)
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

    this.listReportConfigsCallable =
        callableFactory.createUnaryCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.listReportConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.getReportConfigCallable =
        callableFactory.createUnaryCallable(
            getReportConfigTransportSettings, settings.getReportConfigSettings(), clientContext);
    this.createReportConfigCallable =
        callableFactory.createUnaryCallable(
            createReportConfigTransportSettings,
            settings.createReportConfigSettings(),
            clientContext);
    this.updateReportConfigCallable =
        callableFactory.createUnaryCallable(
            updateReportConfigTransportSettings,
            settings.updateReportConfigSettings(),
            clientContext);
    this.deleteReportConfigCallable =
        callableFactory.createUnaryCallable(
            deleteReportConfigTransportSettings,
            settings.deleteReportConfigSettings(),
            clientContext);
    this.listReportDetailsCallable =
        callableFactory.createUnaryCallable(
            listReportDetailsTransportSettings,
            settings.listReportDetailsSettings(),
            clientContext);
    this.listReportDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listReportDetailsTransportSettings,
            settings.listReportDetailsSettings(),
            clientContext);
    this.getReportDetailCallable =
        callableFactory.createUnaryCallable(
            getReportDetailTransportSettings, settings.getReportDetailSettings(), clientContext);
    this.listDatasetConfigsCallable =
        callableFactory.createUnaryCallable(
            listDatasetConfigsTransportSettings,
            settings.listDatasetConfigsSettings(),
            clientContext);
    this.listDatasetConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetConfigsTransportSettings,
            settings.listDatasetConfigsSettings(),
            clientContext);
    this.getDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            getDatasetConfigTransportSettings, settings.getDatasetConfigSettings(), clientContext);
    this.createDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            createDatasetConfigTransportSettings,
            settings.createDatasetConfigSettings(),
            clientContext);
    this.createDatasetConfigOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetConfigTransportSettings,
            settings.createDatasetConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            updateDatasetConfigTransportSettings,
            settings.updateDatasetConfigSettings(),
            clientContext);
    this.updateDatasetConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateDatasetConfigTransportSettings,
            settings.updateDatasetConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetConfigTransportSettings,
            settings.deleteDatasetConfigSettings(),
            clientContext);
    this.deleteDatasetConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetConfigTransportSettings,
            settings.deleteDatasetConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.linkDatasetCallable =
        callableFactory.createUnaryCallable(
            linkDatasetTransportSettings, settings.linkDatasetSettings(), clientContext);
    this.linkDatasetOperationCallable =
        callableFactory.createOperationCallable(
            linkDatasetTransportSettings,
            settings.linkDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.unlinkDatasetCallable =
        callableFactory.createUnaryCallable(
            unlinkDatasetTransportSettings, settings.unlinkDatasetSettings(), clientContext);
    this.unlinkDatasetOperationCallable =
        callableFactory.createOperationCallable(
            unlinkDatasetTransportSettings,
            settings.unlinkDatasetOperationSettings(),
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
    methodDescriptors.add(listReportConfigsMethodDescriptor);
    methodDescriptors.add(getReportConfigMethodDescriptor);
    methodDescriptors.add(createReportConfigMethodDescriptor);
    methodDescriptors.add(updateReportConfigMethodDescriptor);
    methodDescriptors.add(deleteReportConfigMethodDescriptor);
    methodDescriptors.add(listReportDetailsMethodDescriptor);
    methodDescriptors.add(getReportDetailMethodDescriptor);
    methodDescriptors.add(listDatasetConfigsMethodDescriptor);
    methodDescriptors.add(getDatasetConfigMethodDescriptor);
    methodDescriptors.add(createDatasetConfigMethodDescriptor);
    methodDescriptors.add(updateDatasetConfigMethodDescriptor);
    methodDescriptors.add(deleteDatasetConfigMethodDescriptor);
    methodDescriptors.add(linkDatasetMethodDescriptor);
    methodDescriptors.add(unlinkDatasetMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    return listReportConfigsCallable;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    return listReportConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    return getReportConfigCallable;
  }

  @Override
  public UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable() {
    return createReportConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable() {
    return updateReportConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable() {
    return deleteReportConfigCallable;
  }

  @Override
  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable() {
    return listReportDetailsCallable;
  }

  @Override
  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable() {
    return listReportDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable() {
    return getReportDetailCallable;
  }

  @Override
  public UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
      listDatasetConfigsCallable() {
    return listDatasetConfigsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsPagedResponse>
      listDatasetConfigsPagedCallable() {
    return listDatasetConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigCallable() {
    return getDatasetConfigCallable;
  }

  @Override
  public UnaryCallable<CreateDatasetConfigRequest, Operation> createDatasetConfigCallable() {
    return createDatasetConfigCallable;
  }

  @Override
  public OperationCallable<CreateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      createDatasetConfigOperationCallable() {
    return createDatasetConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetConfigRequest, Operation> updateDatasetConfigCallable() {
    return updateDatasetConfigCallable;
  }

  @Override
  public OperationCallable<UpdateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      updateDatasetConfigOperationCallable() {
    return updateDatasetConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetConfigRequest, Operation> deleteDatasetConfigCallable() {
    return deleteDatasetConfigCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetConfigRequest, Empty, OperationMetadata>
      deleteDatasetConfigOperationCallable() {
    return deleteDatasetConfigOperationCallable;
  }

  @Override
  public UnaryCallable<LinkDatasetRequest, Operation> linkDatasetCallable() {
    return linkDatasetCallable;
  }

  @Override
  public OperationCallable<LinkDatasetRequest, LinkDatasetResponse, OperationMetadata>
      linkDatasetOperationCallable() {
    return linkDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<UnlinkDatasetRequest, Operation> unlinkDatasetCallable() {
    return unlinkDatasetCallable;
  }

  @Override
  public OperationCallable<UnlinkDatasetRequest, Empty, OperationMetadata>
      unlinkDatasetOperationCallable() {
    return unlinkDatasetOperationCallable;
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
