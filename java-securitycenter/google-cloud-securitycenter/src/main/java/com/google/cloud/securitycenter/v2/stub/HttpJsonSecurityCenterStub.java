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

package com.google.cloud.securitycenter.v2.stub;

import static com.google.cloud.securitycenter.v2.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListAttackPathsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListMuteConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListResourceValueConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListSourcesPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListValuedResourcesPagedResponse;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.BigQueryExport;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsResponse;
import com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.CreateFindingRequest;
import com.google.cloud.securitycenter.v2.CreateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.CreateSourceRequest;
import com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.ExternalSystem;
import com.google.cloud.securitycenter.v2.Finding;
import com.google.cloud.securitycenter.v2.GetBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.GetMuteConfigRequest;
import com.google.cloud.securitycenter.v2.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.GetSimulationRequest;
import com.google.cloud.securitycenter.v2.GetSourceRequest;
import com.google.cloud.securitycenter.v2.GetValuedResourceRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsResponse;
import com.google.cloud.securitycenter.v2.ListAttackPathsRequest;
import com.google.cloud.securitycenter.v2.ListAttackPathsResponse;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse;
import com.google.cloud.securitycenter.v2.ListFindingsRequest;
import com.google.cloud.securitycenter.v2.ListFindingsResponse;
import com.google.cloud.securitycenter.v2.ListMuteConfigsRequest;
import com.google.cloud.securitycenter.v2.ListMuteConfigsResponse;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.ListSourcesRequest;
import com.google.cloud.securitycenter.v2.ListSourcesResponse;
import com.google.cloud.securitycenter.v2.ListValuedResourcesRequest;
import com.google.cloud.securitycenter.v2.ListValuedResourcesResponse;
import com.google.cloud.securitycenter.v2.MuteConfig;
import com.google.cloud.securitycenter.v2.NotificationConfig;
import com.google.cloud.securitycenter.v2.ResourceValueConfig;
import com.google.cloud.securitycenter.v2.SecurityMarks;
import com.google.cloud.securitycenter.v2.SetFindingStateRequest;
import com.google.cloud.securitycenter.v2.SetMuteRequest;
import com.google.cloud.securitycenter.v2.Simulation;
import com.google.cloud.securitycenter.v2.Source;
import com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest;
import com.google.cloud.securitycenter.v2.UpdateFindingRequest;
import com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v2.UpdateSourceRequest;
import com.google.cloud.securitycenter.v2.ValuedResource;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the SecurityCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSecurityCenterStub extends SecurityCenterStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(BulkMuteFindingsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/BatchCreateResourceValueConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateResourceValueConfigsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/resourceValueConfigs:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateResourceValueConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateResourceValueConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateResourceValueConfigsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateResourceValueConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BulkMuteFindingsRequest, Operation>
      bulkMuteFindingsMethodDescriptor =
          ApiMethodDescriptor.<BulkMuteFindingsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/BulkMuteFindings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkMuteFindingsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/findings:bulkMute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkMuteFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/findings:bulkMute",
                          "/v2/{parent=folders/*}/findings:bulkMute",
                          "/v2/{parent=folders/*/locations/*}/findings:bulkMute",
                          "/v2/{parent=projects/*}/findings:bulkMute",
                          "/v2/{parent=projects/*/locations/*}/findings:bulkMute")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkMuteFindingsRequest> serializer =
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
                  (BulkMuteFindingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<CreateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/CreateBigQueryExport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/locations/*}/bigQueryExports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*/locations/*}/bigQueryExports",
                          "/v2/{parent=projects/*/locations/*}/bigQueryExports")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "bigQueryExportId", request.getBigQueryExportId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bigQueryExport", request.getBigQueryExport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryExport>newBuilder()
                      .setDefaultInstance(BigQueryExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFindingRequest, Finding>
      createFindingMethodDescriptor =
          ApiMethodDescriptor.<CreateFindingRequest, Finding>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/CreateFinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFindingRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/sources/*/locations/*}/findings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=organizations/*/sources/*}/findings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "findingId", request.getFindingId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("finding", request.getFinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Finding>newBuilder()
                      .setDefaultInstance(Finding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMuteConfigRequest, MuteConfig>
      createMuteConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateMuteConfigRequest, MuteConfig>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/CreateMuteConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMuteConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/locations/*}/muteConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*/locations/*}/muteConfigs",
                          "/v2/{parent=projects/*/locations/*}/muteConfigs",
                          "/v2/{parent=organizations/*}/muteConfigs",
                          "/v2/{parent=folders/*}/muteConfigs",
                          "/v2/{parent=projects/*}/muteConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "muteConfigId", request.getMuteConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("muteConfig", request.getMuteConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MuteConfig>newBuilder()
                      .setDefaultInstance(MuteConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/CreateNotificationConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/locations/*}/notificationConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*/locations/*}/notificationConfigs",
                          "/v2/{parent=projects/*/locations/*}/notificationConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "configId", request.getConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "notificationConfig", request.getNotificationConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationConfig>newBuilder()
                      .setDefaultInstance(NotificationConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSourceRequest, Source>
      createSourceMethodDescriptor =
          ApiMethodDescriptor.<CreateSourceRequest, Source>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/CreateSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSourceRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/sources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Source>newBuilder()
                      .setDefaultInstance(Source.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBigQueryExportRequest, Empty>
      deleteBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<DeleteBigQueryExportRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/DeleteBigQueryExport")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/locations/*/bigQueryExports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=folders/*/locations/*/bigQueryExports/*}",
                          "/v2/{name=projects/*/locations/*/bigQueryExports/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<DeleteMuteConfigRequest, Empty>
      deleteMuteConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteMuteConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/DeleteMuteConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMuteConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/muteConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/muteConfigs/*}",
                          "/v2/{name=folders/*/muteConfigs/*}",
                          "/v2/{name=folders/*/locations/*/muteConfigs/*}",
                          "/v2/{name=projects/*/muteConfigs/*}",
                          "/v2/{name=projects/*/locations/*/muteConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteNotificationConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/DeleteNotificationConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/locations/*/notificationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=folders/*/locations/*/notificationConfigs/*}",
                          "/v2/{name=projects/*/locations/*/notificationConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteResourceValueConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/DeleteResourceValueConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteResourceValueConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/resourceValueConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteResourceValueConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteResourceValueConfigRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<GetBigQueryExportRequest, BigQueryExport>
      getBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetBigQueryExport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/locations/*/bigQueryExports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=folders/*/locations/*/bigQueryExports/*}",
                          "/v2/{name=projects/*/locations/*/bigQueryExports/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryExport>newBuilder()
                      .setDefaultInstance(BigQueryExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSimulationRequest, Simulation>
      getSimulationMethodDescriptor =
          ApiMethodDescriptor.<GetSimulationRequest, Simulation>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetSimulation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSimulationRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/simulations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSimulationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSimulationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Simulation>newBuilder()
                      .setDefaultInstance(Simulation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetValuedResourceRequest, ValuedResource>
      getValuedResourceMethodDescriptor =
          ApiMethodDescriptor.<GetValuedResourceRequest, ValuedResource>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetValuedResource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetValuedResourceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/simulations/*/valuedResources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetValuedResourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetValuedResourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ValuedResource>newBuilder()
                      .setDefaultInstance(ValuedResource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=organizations/*/sources/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMuteConfigRequest, MuteConfig>
      getMuteConfigMethodDescriptor =
          ApiMethodDescriptor.<GetMuteConfigRequest, MuteConfig>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetMuteConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMuteConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/muteConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/locations/*/muteConfigs/*}",
                          "/v2/{name=folders/*/muteConfigs/*}",
                          "/v2/{name=folders/*/locations/*/muteConfigs/*}",
                          "/v2/{name=projects/*/muteConfigs/*}",
                          "/v2/{name=projects/*/locations/*/muteConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MuteConfig>newBuilder()
                      .setDefaultInstance(MuteConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/GetNotificationConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/locations/*/notificationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=folders/*/locations/*/notificationConfigs/*}",
                          "/v2/{name=projects/*/locations/*/notificationConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationConfig>newBuilder()
                      .setDefaultInstance(NotificationConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigMethodDescriptor =
          ApiMethodDescriptor.<GetResourceValueConfigRequest, ResourceValueConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/GetResourceValueConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourceValueConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/resourceValueConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceValueConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceValueConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceValueConfig>newBuilder()
                      .setDefaultInstance(ResourceValueConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      ApiMethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetSource")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSourceRequest>newBuilder()
                  .setPath(
                      "/v2/{name=organizations/*/sources/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSourceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSourceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Source>newBuilder()
                  .setDefaultInstance(Source.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GroupFindingsRequest, GroupFindingsResponse>
      groupFindingsMethodDescriptor =
          ApiMethodDescriptor.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GroupFindings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GroupFindingsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/sources/*}/findings:group",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GroupFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/sources/*/locations/*}/findings:group",
                          "/v2/{parent=folders/*/sources/*}/findings:group",
                          "/v2/{parent=folders/*/sources/*/locations/*}/findings:group",
                          "/v2/{parent=projects/*/sources/*}/findings:group",
                          "/v2/{parent=projects/*/sources/*/locations/*}/findings:group")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GroupFindingsRequest> serializer =
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
                  ProtoMessageResponseParser.<GroupFindingsResponse>newBuilder()
                      .setDefaultInstance(GroupFindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAttackPathsRequest, ListAttackPathsResponse>
      listAttackPathsMethodDescriptor =
          ApiMethodDescriptor.<ListAttackPathsRequest, ListAttackPathsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListAttackPaths")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAttackPathsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/simulations/*}/attackPaths",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttackPathsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/simulations/*/valuedResources/*}/attackPaths",
                          "/v2/{parent=organizations/*/simulations/*/attackExposureResults/*}/attackPaths")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttackPathsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAttackPathsResponse>newBuilder()
                      .setDefaultInstance(ListAttackPathsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsMethodDescriptor =
          ApiMethodDescriptor.<ListBigQueryExportsRequest, ListBigQueryExportsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListBigQueryExports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBigQueryExportsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/locations/*}/bigQueryExports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBigQueryExportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*/locations/*}/bigQueryExports",
                          "/v2/{parent=projects/*/locations/*}/bigQueryExports")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBigQueryExportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBigQueryExportsResponse>newBuilder()
                      .setDefaultInstance(ListBigQueryExportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          ApiMethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListFindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/sources/*}/findings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/sources/*/locations/*}/findings",
                          "/v2/{parent=folders/*/sources/*}/findings",
                          "/v2/{parent=folders/*/sources/*/locations/*}/findings",
                          "/v2/{parent=projects/*/sources/*}/findings",
                          "/v2/{parent=projects/*/sources/*/locations/*}/findings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
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
                  ProtoMessageResponseParser.<ListFindingsResponse>newBuilder()
                      .setDefaultInstance(ListFindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMuteConfigsRequest, ListMuteConfigsResponse>
      listMuteConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListMuteConfigsRequest, ListMuteConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListMuteConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMuteConfigsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/muteConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMuteConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/locations/*}/muteConfigs",
                          "/v2/{parent=folders/*}/muteConfigs",
                          "/v2/{parent=folders/*/locations/*}/muteConfigs",
                          "/v2/{parent=projects/*}/muteConfigs",
                          "/v2/{parent=projects/*/locations/*}/muteConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMuteConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMuteConfigsResponse>newBuilder()
                      .setDefaultInstance(ListMuteConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListNotificationConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNotificationConfigsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/locations/*}/notificationConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*/locations/*}/notificationConfigs",
                          "/v2/{parent=projects/*/locations/*}/notificationConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNotificationConfigsResponse>newBuilder()
                      .setDefaultInstance(ListNotificationConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListResourceValueConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourceValueConfigsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/resourceValueConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceValueConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceValueConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListResourceValueConfigsResponse>newBuilder()
                      .setDefaultInstance(ListResourceValueConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSourcesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*}/sources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*}/sources", "/v2/{parent=projects/*}/sources")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSourcesResponse>newBuilder()
                      .setDefaultInstance(ListSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesMethodDescriptor =
          ApiMethodDescriptor.<ListValuedResourcesRequest, ListValuedResourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListValuedResources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListValuedResourcesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=organizations/*/simulations/*}/valuedResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListValuedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=organizations/*/simulations/*/attackExposureResults/*}/valuedResources")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListValuedResourcesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListValuedResourcesResponse>newBuilder()
                      .setDefaultInstance(ListValuedResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetFindingStateRequest, Finding>
      setFindingStateMethodDescriptor =
          ApiMethodDescriptor.<SetFindingStateRequest, Finding>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/SetFindingState")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetFindingStateRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/sources/*/findings/*}:setState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetFindingStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=organizations/*/sources/*/locations/*/findings/*}:setState",
                          "/v2/{name=folders/*/sources/*/findings/*}:setState",
                          "/v2/{name=folders/*/sources/*/locations/*/findings/*}:setState",
                          "/v2/{name=projects/*/sources/*/findings/*}:setState",
                          "/v2/{name=projects/*/sources/*/locations/*/findings/*}:setState")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetFindingStateRequest> serializer =
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
                  ProtoMessageResponseParser.<Finding>newBuilder()
                      .setDefaultInstance(Finding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=organizations/*/sources/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetMuteRequest, Finding> setMuteMethodDescriptor =
      ApiMethodDescriptor.<SetMuteRequest, Finding>newBuilder()
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/SetMute")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SetMuteRequest>newBuilder()
                  .setPath(
                      "/v2/{name=organizations/*/sources/*/findings/*}:setMute",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SetMuteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v2/{name=organizations/*/sources/*/locations/*/findings/*}:setMute",
                      "/v2/{name=folders/*/sources/*/findings/*}:setMute",
                      "/v2/{name=folders/*/sources/*/locations/*/findings/*}:setMute",
                      "/v2/{name=projects/*/sources/*/findings/*}:setMute",
                      "/v2/{name=projects/*/sources/*/locations/*/findings/*}:setMute")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SetMuteRequest> serializer =
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
              ProtoMessageResponseParser.<Finding>newBuilder()
                  .setDefaultInstance(Finding.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v2/{resource=organizations/*/sources/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportMethodDescriptor =
          ApiMethodDescriptor.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateBigQueryExport")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBigQueryExportRequest>newBuilder()
                      .setPath(
                          "/v2/{bigQueryExport.name=organizations/*/locations/*/bigQueryExports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "bigQueryExport.name",
                                request.getBigQueryExport().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{bigQueryExport.name=folders/*/locations/*/bigQueryExports/*}",
                          "/v2/{bigQueryExport.name=projects/*/locations/*/bigQueryExports/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBigQueryExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bigQueryExport", request.getBigQueryExport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryExport>newBuilder()
                      .setDefaultInstance(BigQueryExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemMethodDescriptor =
          ApiMethodDescriptor.<UpdateExternalSystemRequest, ExternalSystem>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateExternalSystem")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExternalSystemRequest>newBuilder()
                      .setPath(
                          "/v2/{externalSystem.name=organizations/*/sources/*/findings/*/externalSystems/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "externalSystem.name",
                                request.getExternalSystem().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{externalSystem.name=organizations/*/sources/*/locations/*/findings/*/externalSystems/*}",
                          "/v2/{externalSystem.name=folders/*/sources/*/findings/*/externalSystems/*}",
                          "/v2/{externalSystem.name=folders/*/sources/*/locations/*/findings/*/externalSystems/*}",
                          "/v2/{externalSystem.name=projects/*/sources/*/findings/*/externalSystems/*}",
                          "/v2/{externalSystem.name=projects/*/sources/*/locations/*/findings/*/externalSystems/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalSystemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("externalSystem", request.getExternalSystem(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalSystem>newBuilder()
                      .setDefaultInstance(ExternalSystem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFindingRequest, Finding>
      updateFindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateFindingRequest, Finding>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/UpdateFinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFindingRequest>newBuilder()
                      .setPath(
                          "/v2/{finding.name=organizations/*/sources/*/findings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "finding.name", request.getFinding().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{finding.name=organizations/*/sources/*/locations/*/findings/*}",
                          "/v2/{finding.name=folders/*/sources/*/findings/*}",
                          "/v2/{finding.name=folders/*/sources/*/locations/*/findings/*}",
                          "/v2/{finding.name=projects/*/sources/*/findings/*}",
                          "/v2/{finding.name=projects/*/sources/*/locations/*/findings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("finding", request.getFinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Finding>newBuilder()
                      .setDefaultInstance(Finding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateMuteConfigRequest, MuteConfig>
      updateMuteConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateMuteConfigRequest, MuteConfig>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/UpdateMuteConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMuteConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{muteConfig.name=organizations/*/muteConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "muteConfig.name", request.getMuteConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{muteConfig.name=organizations/*/locations/*/muteConfigs/*}",
                          "/v2/{muteConfig.name=folders/*/muteConfigs/*}",
                          "/v2/{muteConfig.name=folders/*/locations/*/muteConfigs/*}",
                          "/v2/{muteConfig.name=projects/*/muteConfigs/*}",
                          "/v2/{muteConfig.name=projects/*/locations/*/muteConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMuteConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("muteConfig", request.getMuteConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MuteConfig>newBuilder()
                      .setDefaultInstance(MuteConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateNotificationConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{notificationConfig.name=organizations/*/locations/*/notificationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "notificationConfig.name",
                                request.getNotificationConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{notificationConfig.name=folders/*/locations/*/notificationConfigs/*}",
                          "/v2/{notificationConfig.name=projects/*/locations/*/notificationConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "notificationConfig", request.getNotificationConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationConfig>newBuilder()
                      .setDefaultInstance(NotificationConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateResourceValueConfigRequest, ResourceValueConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateResourceValueConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateResourceValueConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{resourceValueConfig.name=organizations/*/resourceValueConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateResourceValueConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "resourceValueConfig.name",
                                request.getResourceValueConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateResourceValueConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "resourceValueConfig",
                                      request.getResourceValueConfig(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceValueConfig>newBuilder()
                      .setDefaultInstance(ResourceValueConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksMethodDescriptor =
          ApiMethodDescriptor.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateSecurityMarks")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSecurityMarksRequest>newBuilder()
                      .setPath(
                          "/v2/{securityMarks.name=organizations/*/sources/*/findings/*/securityMarks}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecurityMarksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityMarks.name", request.getSecurityMarks().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{securityMarks.name=organizations/*/assets/*/securityMarks}",
                          "/v2/{securityMarks.name=organizations/*/sources/*/locations/*/findings/*/securityMarks}",
                          "/v2/{securityMarks.name=folders/*/sources/*/findings/*/securityMarks}",
                          "/v2/{securityMarks.name=folders/*/assets/*/securityMarks}",
                          "/v2/{securityMarks.name=folders/*/sources/*/locations/*/findings/*/securityMarks}",
                          "/v2/{securityMarks.name=projects/*/sources/*/findings/*/securityMarks}",
                          "/v2/{securityMarks.name=projects/*/assets/*/securityMarks}",
                          "/v2/{securityMarks.name=projects/*/sources/*/locations/*/findings/*/securityMarks}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecurityMarksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("securityMarks", request.getSecurityMarks(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityMarks>newBuilder()
                      .setDefaultInstance(SecurityMarks.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSourceRequest, Source>
      updateSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateSourceRequest, Source>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/UpdateSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSourceRequest>newBuilder()
                      .setPath(
                          "/v2/{source.name=organizations/*/sources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "source.name", request.getSource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Source>newBuilder()
                      .setDefaultInstance(Source.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsCallable;
  private final UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable;
  private final OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable;
  private final UnaryCallable<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportCallable;
  private final UnaryCallable<CreateFindingRequest, Finding> createFindingCallable;
  private final UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable;
  private final UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable;
  private final UnaryCallable<CreateSourceRequest, Source> createSourceCallable;
  private final UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable;
  private final UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable;
  private final UnaryCallable<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigCallable;
  private final UnaryCallable<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigCallable;
  private final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable;
  private final UnaryCallable<GetSimulationRequest, Simulation> getSimulationCallable;
  private final UnaryCallable<GetValuedResourceRequest, ValuedResource> getValuedResourceCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable;
  private final UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable;
  private final UnaryCallable<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigCallable;
  private final UnaryCallable<GetSourceRequest, Source> getSourceCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable;
  private final UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse>
      listAttackPathsCallable;
  private final UnaryCallable<ListAttackPathsRequest, ListAttackPathsPagedResponse>
      listAttackPathsPagedCallable;
  private final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable;
  private final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable;
  private final UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse>
      listMuteConfigsCallable;
  private final UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsPagedResponse>
      listMuteConfigsPagedCallable;
  private final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable;
  private final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable;
  private final UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsCallable;
  private final UnaryCallable<
          ListResourceValueConfigsRequest, ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsPagedCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable;
  private final UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesCallable;
  private final UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesPagedResponse>
      listValuedResourcesPagedCallable;
  private final UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetMuteRequest, Finding> setMuteCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable;
  private final UnaryCallable<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemCallable;
  private final UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable;
  private final UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable;
  private final UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable;
  private final UnaryCallable<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigCallable;
  private final UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksCallable;
  private final UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");
  private static final PathTemplate CREATE_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}");
  private static final PathTemplate CREATE_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}");
  private static final PathTemplate DELETE_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate DELETE_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate DELETE_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate GET_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate GET_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate GET_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate LIST_MUTE_CONFIGS_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs");
  private static final PathTemplate LIST_MUTE_CONFIGS_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs");
  private static final PathTemplate LIST_MUTE_CONFIGS_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs");
  private static final PathTemplate UPDATE_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate UPDATE_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate UPDATE_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs/*");

  public static final HttpJsonSecurityCenterStub create(SecurityCenterStubSettings settings)
      throws IOException {
    return new HttpJsonSecurityCenterStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecurityCenterStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecurityCenterStub(
        SecurityCenterStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSecurityCenterStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecurityCenterStub(
        SecurityCenterStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecurityCenterStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityCenterStub(
      SecurityCenterStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSecurityCenterCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecurityCenterStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityCenterStub(
      SecurityCenterStubSettings settings,
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
                        .setPost("/v2/{name=organizations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v2/{name=organizations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder().setGet("/v2/{name=organizations/*/operations/*}").build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder().setGet("/v2/{name=organizations/*/operations}").build())
                .build());

    HttpJsonCallSettings<
            BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
        batchCreateResourceValueConfigsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateResourceValueConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BulkMuteFindingsRequest, Operation> bulkMuteFindingsTransportSettings =
        HttpJsonCallSettings.<BulkMuteFindingsRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkMuteFindingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBigQueryExportRequest, BigQueryExport>
        createBigQueryExportTransportSettings =
            HttpJsonCallSettings.<CreateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(createBigQueryExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateFindingRequest, Finding> createFindingTransportSettings =
        HttpJsonCallSettings.<CreateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(createFindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateMuteConfigRequest, MuteConfig> createMuteConfigTransportSettings =
        HttpJsonCallSettings.<CreateMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(createMuteConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "location", CREATE_MUTE_CONFIG_0_PATH_TEMPLATE);
                  builder.add(request.getParent(), "location", CREATE_MUTE_CONFIG_1_PATH_TEMPLATE);
                  builder.add(request.getParent(), "location", CREATE_MUTE_CONFIG_2_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigTransportSettings =
            HttpJsonCallSettings.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(createNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSourceRequest, Source> createSourceTransportSettings =
        HttpJsonCallSettings.<CreateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportTransportSettings =
        HttpJsonCallSettings.<DeleteBigQueryExportRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBigQueryExportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMuteConfigRequest, Empty> deleteMuteConfigTransportSettings =
        HttpJsonCallSettings.<DeleteMuteConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMuteConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", DELETE_MUTE_CONFIG_0_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", DELETE_MUTE_CONFIG_1_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", DELETE_MUTE_CONFIG_2_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigTransportSettings =
            HttpJsonCallSettings.<DeleteNotificationConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteResourceValueConfigRequest, Empty>
        deleteResourceValueConfigTransportSettings =
            HttpJsonCallSettings.<DeleteResourceValueConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteResourceValueConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBigQueryExportRequest, BigQueryExport>
        getBigQueryExportTransportSettings =
            HttpJsonCallSettings.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(getBigQueryExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSimulationRequest, Simulation> getSimulationTransportSettings =
        HttpJsonCallSettings.<GetSimulationRequest, Simulation>newBuilder()
            .setMethodDescriptor(getSimulationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetValuedResourceRequest, ValuedResource>
        getValuedResourceTransportSettings =
            HttpJsonCallSettings.<GetValuedResourceRequest, ValuedResource>newBuilder()
                .setMethodDescriptor(getValuedResourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetMuteConfigRequest, MuteConfig> getMuteConfigTransportSettings =
        HttpJsonCallSettings.<GetMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(getMuteConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", GET_MUTE_CONFIG_0_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", GET_MUTE_CONFIG_1_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", GET_MUTE_CONFIG_2_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigTransportSettings =
            HttpJsonCallSettings.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(getNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetResourceValueConfigRequest, ResourceValueConfig>
        getResourceValueConfigTransportSettings =
            HttpJsonCallSettings.<GetResourceValueConfigRequest, ResourceValueConfig>newBuilder()
                .setMethodDescriptor(getResourceValueConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        HttpJsonCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GroupFindingsRequest, GroupFindingsResponse>
        groupFindingsTransportSettings =
            HttpJsonCallSettings.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
                .setMethodDescriptor(groupFindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAttackPathsRequest, ListAttackPathsResponse>
        listAttackPathsTransportSettings =
            HttpJsonCallSettings.<ListAttackPathsRequest, ListAttackPathsResponse>newBuilder()
                .setMethodDescriptor(listAttackPathsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
        listBigQueryExportsTransportSettings =
            HttpJsonCallSettings
                .<ListBigQueryExportsRequest, ListBigQueryExportsResponse>newBuilder()
                .setMethodDescriptor(listBigQueryExportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        HttpJsonCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMuteConfigsRequest, ListMuteConfigsResponse>
        listMuteConfigsTransportSettings =
            HttpJsonCallSettings.<ListMuteConfigsRequest, ListMuteConfigsResponse>newBuilder()
                .setMethodDescriptor(listMuteConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "location", LIST_MUTE_CONFIGS_0_PATH_TEMPLATE);
                      builder.add(
                          request.getParent(), "location", LIST_MUTE_CONFIGS_1_PATH_TEMPLATE);
                      builder.add(
                          request.getParent(), "location", LIST_MUTE_CONFIGS_2_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
        listNotificationConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
                .setMethodDescriptor(listNotificationConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
        listResourceValueConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>newBuilder()
                .setMethodDescriptor(listResourceValueConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        HttpJsonCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListValuedResourcesRequest, ListValuedResourcesResponse>
        listValuedResourcesTransportSettings =
            HttpJsonCallSettings
                .<ListValuedResourcesRequest, ListValuedResourcesResponse>newBuilder()
                .setMethodDescriptor(listValuedResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetFindingStateRequest, Finding> setFindingStateTransportSettings =
        HttpJsonCallSettings.<SetFindingStateRequest, Finding>newBuilder()
            .setMethodDescriptor(setFindingStateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetMuteRequest, Finding> setMuteTransportSettings =
        HttpJsonCallSettings.<SetMuteRequest, Finding>newBuilder()
            .setMethodDescriptor(setMuteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportTransportSettings =
            HttpJsonCallSettings.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(updateBigQueryExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "big_query_export.name",
                          String.valueOf(request.getBigQueryExport().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateExternalSystemRequest, ExternalSystem>
        updateExternalSystemTransportSettings =
            HttpJsonCallSettings.<UpdateExternalSystemRequest, ExternalSystem>newBuilder()
                .setMethodDescriptor(updateExternalSystemMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "external_system.name",
                          String.valueOf(request.getExternalSystem().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateFindingRequest, Finding> updateFindingTransportSettings =
        HttpJsonCallSettings.<UpdateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(updateFindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("finding.name", String.valueOf(request.getFinding().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigTransportSettings =
        HttpJsonCallSettings.<UpdateMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(updateMuteConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getMuteConfig() != null) {
                    builder.add(
                        request.getMuteConfig().getName(),
                        "location",
                        UPDATE_MUTE_CONFIG_0_PATH_TEMPLATE);
                  }
                  if (request.getMuteConfig() != null) {
                    builder.add(
                        request.getMuteConfig().getName(),
                        "location",
                        UPDATE_MUTE_CONFIG_1_PATH_TEMPLATE);
                  }
                  if (request.getMuteConfig() != null) {
                    builder.add(
                        request.getMuteConfig().getName(),
                        "location",
                        UPDATE_MUTE_CONFIG_2_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigTransportSettings =
            HttpJsonCallSettings.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(updateNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "notification_config.name",
                          String.valueOf(request.getNotificationConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateResourceValueConfigRequest, ResourceValueConfig>
        updateResourceValueConfigTransportSettings =
            HttpJsonCallSettings.<UpdateResourceValueConfigRequest, ResourceValueConfig>newBuilder()
                .setMethodDescriptor(updateResourceValueConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "resource_value_config.name",
                          String.valueOf(request.getResourceValueConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksTransportSettings =
            HttpJsonCallSettings.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
                .setMethodDescriptor(updateSecurityMarksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "security_marks.name",
                          String.valueOf(request.getSecurityMarks().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSourceRequest, Source> updateSourceTransportSettings =
        HttpJsonCallSettings.<UpdateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("source.name", String.valueOf(request.getSource().getName()));
                  return builder.build();
                })
            .build();

    this.batchCreateResourceValueConfigsCallable =
        callableFactory.createUnaryCallable(
            batchCreateResourceValueConfigsTransportSettings,
            settings.batchCreateResourceValueConfigsSettings(),
            clientContext);
    this.bulkMuteFindingsCallable =
        callableFactory.createUnaryCallable(
            bulkMuteFindingsTransportSettings, settings.bulkMuteFindingsSettings(), clientContext);
    this.bulkMuteFindingsOperationCallable =
        callableFactory.createOperationCallable(
            bulkMuteFindingsTransportSettings,
            settings.bulkMuteFindingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            createBigQueryExportTransportSettings,
            settings.createBigQueryExportSettings(),
            clientContext);
    this.createFindingCallable =
        callableFactory.createUnaryCallable(
            createFindingTransportSettings, settings.createFindingSettings(), clientContext);
    this.createMuteConfigCallable =
        callableFactory.createUnaryCallable(
            createMuteConfigTransportSettings, settings.createMuteConfigSettings(), clientContext);
    this.createNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            createNotificationConfigTransportSettings,
            settings.createNotificationConfigSettings(),
            clientContext);
    this.createSourceCallable =
        callableFactory.createUnaryCallable(
            createSourceTransportSettings, settings.createSourceSettings(), clientContext);
    this.deleteBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            deleteBigQueryExportTransportSettings,
            settings.deleteBigQueryExportSettings(),
            clientContext);
    this.deleteMuteConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMuteConfigTransportSettings, settings.deleteMuteConfigSettings(), clientContext);
    this.deleteNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationConfigTransportSettings,
            settings.deleteNotificationConfigSettings(),
            clientContext);
    this.deleteResourceValueConfigCallable =
        callableFactory.createUnaryCallable(
            deleteResourceValueConfigTransportSettings,
            settings.deleteResourceValueConfigSettings(),
            clientContext);
    this.getBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            getBigQueryExportTransportSettings,
            settings.getBigQueryExportSettings(),
            clientContext);
    this.getSimulationCallable =
        callableFactory.createUnaryCallable(
            getSimulationTransportSettings, settings.getSimulationSettings(), clientContext);
    this.getValuedResourceCallable =
        callableFactory.createUnaryCallable(
            getValuedResourceTransportSettings,
            settings.getValuedResourceSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.getMuteConfigCallable =
        callableFactory.createUnaryCallable(
            getMuteConfigTransportSettings, settings.getMuteConfigSettings(), clientContext);
    this.getNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            getNotificationConfigTransportSettings,
            settings.getNotificationConfigSettings(),
            clientContext);
    this.getResourceValueConfigCallable =
        callableFactory.createUnaryCallable(
            getResourceValueConfigTransportSettings,
            settings.getResourceValueConfigSettings(),
            clientContext);
    this.getSourceCallable =
        callableFactory.createUnaryCallable(
            getSourceTransportSettings, settings.getSourceSettings(), clientContext);
    this.groupFindingsCallable =
        callableFactory.createUnaryCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.groupFindingsPagedCallable =
        callableFactory.createPagedCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.listAttackPathsCallable =
        callableFactory.createUnaryCallable(
            listAttackPathsTransportSettings, settings.listAttackPathsSettings(), clientContext);
    this.listAttackPathsPagedCallable =
        callableFactory.createPagedCallable(
            listAttackPathsTransportSettings, settings.listAttackPathsSettings(), clientContext);
    this.listBigQueryExportsCallable =
        callableFactory.createUnaryCallable(
            listBigQueryExportsTransportSettings,
            settings.listBigQueryExportsSettings(),
            clientContext);
    this.listBigQueryExportsPagedCallable =
        callableFactory.createPagedCallable(
            listBigQueryExportsTransportSettings,
            settings.listBigQueryExportsSettings(),
            clientContext);
    this.listFindingsCallable =
        callableFactory.createUnaryCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listMuteConfigsCallable =
        callableFactory.createUnaryCallable(
            listMuteConfigsTransportSettings, settings.listMuteConfigsSettings(), clientContext);
    this.listMuteConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMuteConfigsTransportSettings, settings.listMuteConfigsSettings(), clientContext);
    this.listNotificationConfigsCallable =
        callableFactory.createUnaryCallable(
            listNotificationConfigsTransportSettings,
            settings.listNotificationConfigsSettings(),
            clientContext);
    this.listNotificationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationConfigsTransportSettings,
            settings.listNotificationConfigsSettings(),
            clientContext);
    this.listResourceValueConfigsCallable =
        callableFactory.createUnaryCallable(
            listResourceValueConfigsTransportSettings,
            settings.listResourceValueConfigsSettings(),
            clientContext);
    this.listResourceValueConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listResourceValueConfigsTransportSettings,
            settings.listResourceValueConfigsSettings(),
            clientContext);
    this.listSourcesCallable =
        callableFactory.createUnaryCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listValuedResourcesCallable =
        callableFactory.createUnaryCallable(
            listValuedResourcesTransportSettings,
            settings.listValuedResourcesSettings(),
            clientContext);
    this.listValuedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listValuedResourcesTransportSettings,
            settings.listValuedResourcesSettings(),
            clientContext);
    this.setFindingStateCallable =
        callableFactory.createUnaryCallable(
            setFindingStateTransportSettings, settings.setFindingStateSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setMuteCallable =
        callableFactory.createUnaryCallable(
            setMuteTransportSettings, settings.setMuteSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.updateBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            updateBigQueryExportTransportSettings,
            settings.updateBigQueryExportSettings(),
            clientContext);
    this.updateExternalSystemCallable =
        callableFactory.createUnaryCallable(
            updateExternalSystemTransportSettings,
            settings.updateExternalSystemSettings(),
            clientContext);
    this.updateFindingCallable =
        callableFactory.createUnaryCallable(
            updateFindingTransportSettings, settings.updateFindingSettings(), clientContext);
    this.updateMuteConfigCallable =
        callableFactory.createUnaryCallable(
            updateMuteConfigTransportSettings, settings.updateMuteConfigSettings(), clientContext);
    this.updateNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            updateNotificationConfigTransportSettings,
            settings.updateNotificationConfigSettings(),
            clientContext);
    this.updateResourceValueConfigCallable =
        callableFactory.createUnaryCallable(
            updateResourceValueConfigTransportSettings,
            settings.updateResourceValueConfigSettings(),
            clientContext);
    this.updateSecurityMarksCallable =
        callableFactory.createUnaryCallable(
            updateSecurityMarksTransportSettings,
            settings.updateSecurityMarksSettings(),
            clientContext);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(batchCreateResourceValueConfigsMethodDescriptor);
    methodDescriptors.add(bulkMuteFindingsMethodDescriptor);
    methodDescriptors.add(createBigQueryExportMethodDescriptor);
    methodDescriptors.add(createFindingMethodDescriptor);
    methodDescriptors.add(createMuteConfigMethodDescriptor);
    methodDescriptors.add(createNotificationConfigMethodDescriptor);
    methodDescriptors.add(createSourceMethodDescriptor);
    methodDescriptors.add(deleteBigQueryExportMethodDescriptor);
    methodDescriptors.add(deleteMuteConfigMethodDescriptor);
    methodDescriptors.add(deleteNotificationConfigMethodDescriptor);
    methodDescriptors.add(deleteResourceValueConfigMethodDescriptor);
    methodDescriptors.add(getBigQueryExportMethodDescriptor);
    methodDescriptors.add(getSimulationMethodDescriptor);
    methodDescriptors.add(getValuedResourceMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(getMuteConfigMethodDescriptor);
    methodDescriptors.add(getNotificationConfigMethodDescriptor);
    methodDescriptors.add(getResourceValueConfigMethodDescriptor);
    methodDescriptors.add(getSourceMethodDescriptor);
    methodDescriptors.add(groupFindingsMethodDescriptor);
    methodDescriptors.add(listAttackPathsMethodDescriptor);
    methodDescriptors.add(listBigQueryExportsMethodDescriptor);
    methodDescriptors.add(listFindingsMethodDescriptor);
    methodDescriptors.add(listMuteConfigsMethodDescriptor);
    methodDescriptors.add(listNotificationConfigsMethodDescriptor);
    methodDescriptors.add(listResourceValueConfigsMethodDescriptor);
    methodDescriptors.add(listSourcesMethodDescriptor);
    methodDescriptors.add(listValuedResourcesMethodDescriptor);
    methodDescriptors.add(setFindingStateMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setMuteMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(updateBigQueryExportMethodDescriptor);
    methodDescriptors.add(updateExternalSystemMethodDescriptor);
    methodDescriptors.add(updateFindingMethodDescriptor);
    methodDescriptors.add(updateMuteConfigMethodDescriptor);
    methodDescriptors.add(updateNotificationConfigMethodDescriptor);
    methodDescriptors.add(updateResourceValueConfigMethodDescriptor);
    methodDescriptors.add(updateSecurityMarksMethodDescriptor);
    methodDescriptors.add(updateSourceMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsCallable() {
    return batchCreateResourceValueConfigsCallable;
  }

  @Override
  public UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable() {
    return bulkMuteFindingsCallable;
  }

  @Override
  public OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable() {
    return bulkMuteFindingsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBigQueryExportRequest, BigQueryExport> createBigQueryExportCallable() {
    return createBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<CreateFindingRequest, Finding> createFindingCallable() {
    return createFindingCallable;
  }

  @Override
  public UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable() {
    return createMuteConfigCallable;
  }

  @Override
  public UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable() {
    return createNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    return createSourceCallable;
  }

  @Override
  public UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable() {
    return deleteBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable() {
    return deleteMuteConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteNotificationConfigRequest, Empty> deleteNotificationConfigCallable() {
    return deleteNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigCallable() {
    return deleteResourceValueConfigCallable;
  }

  @Override
  public UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    return getBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<GetSimulationRequest, Simulation> getSimulationCallable() {
    return getSimulationCallable;
  }

  @Override
  public UnaryCallable<GetValuedResourceRequest, ValuedResource> getValuedResourceCallable() {
    return getValuedResourceCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable() {
    return getMuteConfigCallable;
  }

  @Override
  public UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable() {
    return getNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigCallable() {
    return getResourceValueConfigCallable;
  }

  @Override
  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return getSourceCallable;
  }

  @Override
  public UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable() {
    return groupFindingsCallable;
  }

  @Override
  public UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable() {
    return groupFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse> listAttackPathsCallable() {
    return listAttackPathsCallable;
  }

  @Override
  public UnaryCallable<ListAttackPathsRequest, ListAttackPathsPagedResponse>
      listAttackPathsPagedCallable() {
    return listAttackPathsPagedCallable;
  }

  @Override
  public UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable() {
    return listBigQueryExportsCallable;
  }

  @Override
  public UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable() {
    return listBigQueryExportsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return listFindingsCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    return listFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse> listMuteConfigsCallable() {
    return listMuteConfigsCallable;
  }

  @Override
  public UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsPagedResponse>
      listMuteConfigsPagedCallable() {
    return listMuteConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable() {
    return listNotificationConfigsCallable;
  }

  @Override
  public UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable() {
    return listNotificationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsCallable() {
    return listResourceValueConfigsCallable;
  }

  @Override
  public UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsPagedCallable() {
    return listResourceValueConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return listSourcesCallable;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    return listSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesCallable() {
    return listValuedResourcesCallable;
  }

  @Override
  public UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesPagedResponse>
      listValuedResourcesPagedCallable() {
    return listValuedResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable() {
    return setFindingStateCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetMuteRequest, Finding> setMuteCallable() {
    return setMuteCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport> updateBigQueryExportCallable() {
    return updateBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalSystemRequest, ExternalSystem> updateExternalSystemCallable() {
    return updateExternalSystemCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable() {
    return updateFindingCallable;
  }

  @Override
  public UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable() {
    return updateMuteConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable() {
    return updateNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigCallable() {
    return updateResourceValueConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks> updateSecurityMarksCallable() {
    return updateSecurityMarksCallable;
  }

  @Override
  public UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    return updateSourceCallable;
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
