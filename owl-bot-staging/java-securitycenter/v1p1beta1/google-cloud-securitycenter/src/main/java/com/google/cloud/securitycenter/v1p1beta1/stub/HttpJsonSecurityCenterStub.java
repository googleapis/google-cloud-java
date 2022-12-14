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

package com.google.cloud.securitycenter.v1p1beta1.stub;

import static com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.GroupAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v1p1beta1.SecurityCenterClient.ListSourcesPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.v1p1beta1.CreateFindingRequest;
import com.google.cloud.securitycenter.v1p1beta1.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1p1beta1.CreateSourceRequest;
import com.google.cloud.securitycenter.v1p1beta1.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v1p1beta1.Finding;
import com.google.cloud.securitycenter.v1p1beta1.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v1p1beta1.GetOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1p1beta1.GetSourceRequest;
import com.google.cloud.securitycenter.v1p1beta1.GroupAssetsRequest;
import com.google.cloud.securitycenter.v1p1beta1.GroupAssetsResponse;
import com.google.cloud.securitycenter.v1p1beta1.GroupFindingsRequest;
import com.google.cloud.securitycenter.v1p1beta1.GroupFindingsResponse;
import com.google.cloud.securitycenter.v1p1beta1.ListAssetsRequest;
import com.google.cloud.securitycenter.v1p1beta1.ListAssetsResponse;
import com.google.cloud.securitycenter.v1p1beta1.ListFindingsRequest;
import com.google.cloud.securitycenter.v1p1beta1.ListFindingsResponse;
import com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v1p1beta1.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v1p1beta1.ListSourcesRequest;
import com.google.cloud.securitycenter.v1p1beta1.ListSourcesResponse;
import com.google.cloud.securitycenter.v1p1beta1.NotificationConfig;
import com.google.cloud.securitycenter.v1p1beta1.OrganizationSettings;
import com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryRequest;
import com.google.cloud.securitycenter.v1p1beta1.RunAssetDiscoveryResponse;
import com.google.cloud.securitycenter.v1p1beta1.SecurityMarks;
import com.google.cloud.securitycenter.v1p1beta1.SetFindingStateRequest;
import com.google.cloud.securitycenter.v1p1beta1.Source;
import com.google.cloud.securitycenter.v1p1beta1.UpdateFindingRequest;
import com.google.cloud.securitycenter.v1p1beta1.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1p1beta1.UpdateOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1p1beta1.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v1p1beta1.UpdateSourceRequest;
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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSecurityCenterStub extends SecurityCenterStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(RunAssetDiscoveryResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateSourceRequest, Source>
      createSourceMethodDescriptor =
          ApiMethodDescriptor.<CreateSourceRequest, Source>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/CreateSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSourceRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/sources",
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

  private static final ApiMethodDescriptor<CreateFindingRequest, Finding>
      createFindingMethodDescriptor =
          ApiMethodDescriptor.<CreateFindingRequest, Finding>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/CreateFinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFindingRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*/sources/*}/findings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/CreateNotificationConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/notificationConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteNotificationConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/DeleteNotificationConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{name=organizations/*/notificationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{resource=organizations/*/sources/*}:getIamPolicy",
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

  private static final ApiMethodDescriptor<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/GetNotificationConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{name=organizations/*/notificationConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetOrganizationSettingsRequest, OrganizationSettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/GetOrganizationSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrganizationSettingsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{name=organizations/*/organizationSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OrganizationSettings>newBuilder()
                      .setDefaultInstance(OrganizationSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      ApiMethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setFullMethodName("google.cloud.securitycenter.v1p1beta1.SecurityCenter/GetSource")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSourceRequest>newBuilder()
                  .setPath(
                      "/v1p1beta1/{name=organizations/*/sources/*}",
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

  private static final ApiMethodDescriptor<GroupAssetsRequest, GroupAssetsResponse>
      groupAssetsMethodDescriptor =
          ApiMethodDescriptor.<GroupAssetsRequest, GroupAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v1p1beta1.SecurityCenter/GroupAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GroupAssetsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/assets:group",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GroupAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{parent=folders/*}/assets:group",
                          "/v1p1beta1/{parent=projects/*}/assets:group")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GroupAssetsRequest> serializer =
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
                  ProtoMessageResponseParser.<GroupAssetsResponse>newBuilder()
                      .setDefaultInstance(GroupAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GroupFindingsRequest, GroupFindingsResponse>
      groupFindingsMethodDescriptor =
          ApiMethodDescriptor.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/GroupFindings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GroupFindingsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*/sources/*}/findings:group",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GroupFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{parent=folders/*/sources/*}/findings:group",
                          "/v1p1beta1/{parent=projects/*/sources/*}/findings:group")
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

  private static final ApiMethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          ApiMethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v1p1beta1.SecurityCenter/ListAssets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssetsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/assets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{parent=folders/*}/assets",
                          "/v1p1beta1/{parent=projects/*}/assets")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "compareDuration", request.getCompareDuration());
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readTime", request.getReadTime());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAssetsResponse>newBuilder()
                      .setDefaultInstance(ListAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          ApiMethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/ListFindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*/sources/*}/findings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{parent=folders/*/sources/*}/findings",
                          "/v1p1beta1/{parent=projects/*/sources/*}/findings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "compareDuration", request.getCompareDuration());
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readTime", request.getReadTime());
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

  private static final ApiMethodDescriptor<
          ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/ListNotificationConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNotificationConfigsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/notificationConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.securitycenter.v1p1beta1.SecurityCenter/ListSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSourcesRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/sources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{parent=folders/*}/sources",
                          "/v1p1beta1/{parent=projects/*}/sources")
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

  private static final ApiMethodDescriptor<RunAssetDiscoveryRequest, Operation>
      runAssetDiscoveryMethodDescriptor =
          ApiMethodDescriptor.<RunAssetDiscoveryRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/RunAssetDiscovery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunAssetDiscoveryRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{parent=organizations/*}/assets:runDiscovery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunAssetDiscoveryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunAssetDiscoveryRequest> serializer =
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
                  (RunAssetDiscoveryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SetFindingStateRequest, Finding>
      setFindingStateMethodDescriptor =
          ApiMethodDescriptor.<SetFindingStateRequest, Finding>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/SetFindingState")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetFindingStateRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{name=organizations/*/sources/*/findings/*}:setState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetFindingStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{name=folders/*/sources/*/findings/*}:setState",
                          "/v1p1beta1/{name=projects/*/sources/*/findings/*}:setState")
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
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{resource=organizations/*/sources/*}:setIamPolicy",
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{resource=organizations/*/sources/*}:testIamPermissions",
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

  private static final ApiMethodDescriptor<UpdateFindingRequest, Finding>
      updateFindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateFindingRequest, Finding>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/UpdateFinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFindingRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{finding.name=organizations/*/sources/*/findings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "finding.name", request.getFinding().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{finding.name=folders/*/sources/*/findings/*}",
                          "/v1p1beta1/{finding.name=projects/*/sources/*/findings/*}")
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

  private static final ApiMethodDescriptor<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/UpdateNotificationConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNotificationConfigRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{notificationConfig.name=organizations/*/notificationConfigs/*}",
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

  private static final ApiMethodDescriptor<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateOrganizationSettingsRequest, OrganizationSettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/UpdateOrganizationSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOrganizationSettingsRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{organizationSettings.name=organizations/*/organizationSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrganizationSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "organizationSettings.name",
                                request.getOrganizationSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrganizationSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "organizationSettings",
                                      request.getOrganizationSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OrganizationSettings>newBuilder()
                      .setDefaultInstance(OrganizationSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSourceRequest, Source>
      updateSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateSourceRequest, Source>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/UpdateSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSourceRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{source.name=organizations/*/sources/*}",
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

  private static final ApiMethodDescriptor<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksMethodDescriptor =
          ApiMethodDescriptor.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycenter.v1p1beta1.SecurityCenter/UpdateSecurityMarks")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSecurityMarksRequest>newBuilder()
                      .setPath(
                          "/v1p1beta1/{securityMarks.name=organizations/*/assets/*/securityMarks}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecurityMarksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityMarks.name", request.getSecurityMarks().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1p1beta1/{securityMarks.name=folders/*/assets/*/securityMarks}",
                          "/v1p1beta1/{securityMarks.name=projects/*/assets/*/securityMarks}",
                          "/v1p1beta1/{securityMarks.name=organizations/*/sources/*/findings/*/securityMarks}",
                          "/v1p1beta1/{securityMarks.name=folders/*/sources/*/findings/*/securityMarks}",
                          "/v1p1beta1/{securityMarks.name=projects/*/sources/*/findings/*/securityMarks}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecurityMarksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "startTime", request.getStartTime());
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

  private final UnaryCallable<CreateSourceRequest, Source> createSourceCallable;
  private final UnaryCallable<CreateFindingRequest, Finding> createFindingCallable;
  private final UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable;
  private final UnaryCallable<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable;
  private final UnaryCallable<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsCallable;
  private final UnaryCallable<GetSourceRequest, Source> getSourceCallable;
  private final UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> groupAssetsCallable;
  private final UnaryCallable<GroupAssetsRequest, GroupAssetsPagedResponse>
      groupAssetsPagedCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable;
  private final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable;
  private final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable;
  private final UnaryCallable<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryCallable;
  private final OperationCallable<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationCallable;
  private final UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable;
  private final UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable;
  private final UnaryCallable<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsCallable;
  private final UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable;
  private final UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

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
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateSourceRequest, Source> createSourceTransportSettings =
        HttpJsonCallSettings.<CreateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateFindingRequest, Finding> createFindingTransportSettings =
        HttpJsonCallSettings.<CreateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(createFindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigTransportSettings =
            HttpJsonCallSettings.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(createNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigTransportSettings =
            HttpJsonCallSettings.<DeleteNotificationConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigTransportSettings =
            HttpJsonCallSettings.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(getNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetOrganizationSettingsRequest, OrganizationSettings>
        getOrganizationSettingsTransportSettings =
            HttpJsonCallSettings.<GetOrganizationSettingsRequest, OrganizationSettings>newBuilder()
                .setMethodDescriptor(getOrganizationSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        HttpJsonCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GroupAssetsRequest, GroupAssetsResponse> groupAssetsTransportSettings =
        HttpJsonCallSettings.<GroupAssetsRequest, GroupAssetsResponse>newBuilder()
            .setMethodDescriptor(groupAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GroupFindingsRequest, GroupFindingsResponse>
        groupFindingsTransportSettings =
            HttpJsonCallSettings.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
                .setMethodDescriptor(groupFindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        HttpJsonCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        HttpJsonCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
        listNotificationConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
                .setMethodDescriptor(listNotificationConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        HttpJsonCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryTransportSettings =
        HttpJsonCallSettings.<RunAssetDiscoveryRequest, Operation>newBuilder()
            .setMethodDescriptor(runAssetDiscoveryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetFindingStateRequest, Finding> setFindingStateTransportSettings =
        HttpJsonCallSettings.<SetFindingStateRequest, Finding>newBuilder()
            .setMethodDescriptor(setFindingStateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateFindingRequest, Finding> updateFindingTransportSettings =
        HttpJsonCallSettings.<UpdateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(updateFindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigTransportSettings =
            HttpJsonCallSettings.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(updateNotificationConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateOrganizationSettingsRequest, OrganizationSettings>
        updateOrganizationSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateOrganizationSettingsRequest, OrganizationSettings>newBuilder()
                .setMethodDescriptor(updateOrganizationSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateSourceRequest, Source> updateSourceTransportSettings =
        HttpJsonCallSettings.<UpdateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksTransportSettings =
            HttpJsonCallSettings.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
                .setMethodDescriptor(updateSecurityMarksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createSourceCallable =
        callableFactory.createUnaryCallable(
            createSourceTransportSettings, settings.createSourceSettings(), clientContext);
    this.createFindingCallable =
        callableFactory.createUnaryCallable(
            createFindingTransportSettings, settings.createFindingSettings(), clientContext);
    this.createNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            createNotificationConfigTransportSettings,
            settings.createNotificationConfigSettings(),
            clientContext);
    this.deleteNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationConfigTransportSettings,
            settings.deleteNotificationConfigSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.getNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            getNotificationConfigTransportSettings,
            settings.getNotificationConfigSettings(),
            clientContext);
    this.getOrganizationSettingsCallable =
        callableFactory.createUnaryCallable(
            getOrganizationSettingsTransportSettings,
            settings.getOrganizationSettingsSettings(),
            clientContext);
    this.getSourceCallable =
        callableFactory.createUnaryCallable(
            getSourceTransportSettings, settings.getSourceSettings(), clientContext);
    this.groupAssetsCallable =
        callableFactory.createUnaryCallable(
            groupAssetsTransportSettings, settings.groupAssetsSettings(), clientContext);
    this.groupAssetsPagedCallable =
        callableFactory.createPagedCallable(
            groupAssetsTransportSettings, settings.groupAssetsSettings(), clientContext);
    this.groupFindingsCallable =
        callableFactory.createUnaryCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.groupFindingsPagedCallable =
        callableFactory.createPagedCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.listAssetsCallable =
        callableFactory.createUnaryCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listFindingsCallable =
        callableFactory.createUnaryCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
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
    this.listSourcesCallable =
        callableFactory.createUnaryCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.runAssetDiscoveryCallable =
        callableFactory.createUnaryCallable(
            runAssetDiscoveryTransportSettings,
            settings.runAssetDiscoverySettings(),
            clientContext);
    this.runAssetDiscoveryOperationCallable =
        callableFactory.createOperationCallable(
            runAssetDiscoveryTransportSettings,
            settings.runAssetDiscoveryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setFindingStateCallable =
        callableFactory.createUnaryCallable(
            setFindingStateTransportSettings, settings.setFindingStateSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.updateFindingCallable =
        callableFactory.createUnaryCallable(
            updateFindingTransportSettings, settings.updateFindingSettings(), clientContext);
    this.updateNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            updateNotificationConfigTransportSettings,
            settings.updateNotificationConfigSettings(),
            clientContext);
    this.updateOrganizationSettingsCallable =
        callableFactory.createUnaryCallable(
            updateOrganizationSettingsTransportSettings,
            settings.updateOrganizationSettingsSettings(),
            clientContext);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);
    this.updateSecurityMarksCallable =
        callableFactory.createUnaryCallable(
            updateSecurityMarksTransportSettings,
            settings.updateSecurityMarksSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSourceMethodDescriptor);
    methodDescriptors.add(createFindingMethodDescriptor);
    methodDescriptors.add(createNotificationConfigMethodDescriptor);
    methodDescriptors.add(deleteNotificationConfigMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(getNotificationConfigMethodDescriptor);
    methodDescriptors.add(getOrganizationSettingsMethodDescriptor);
    methodDescriptors.add(getSourceMethodDescriptor);
    methodDescriptors.add(groupAssetsMethodDescriptor);
    methodDescriptors.add(groupFindingsMethodDescriptor);
    methodDescriptors.add(listAssetsMethodDescriptor);
    methodDescriptors.add(listFindingsMethodDescriptor);
    methodDescriptors.add(listNotificationConfigsMethodDescriptor);
    methodDescriptors.add(listSourcesMethodDescriptor);
    methodDescriptors.add(runAssetDiscoveryMethodDescriptor);
    methodDescriptors.add(setFindingStateMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(updateFindingMethodDescriptor);
    methodDescriptors.add(updateNotificationConfigMethodDescriptor);
    methodDescriptors.add(updateOrganizationSettingsMethodDescriptor);
    methodDescriptors.add(updateSourceMethodDescriptor);
    methodDescriptors.add(updateSecurityMarksMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    return createSourceCallable;
  }

  @Override
  public UnaryCallable<CreateFindingRequest, Finding> createFindingCallable() {
    return createFindingCallable;
  }

  @Override
  public UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable() {
    return createNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteNotificationConfigRequest, Empty> deleteNotificationConfigCallable() {
    return deleteNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable() {
    return getNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsCallable() {
    return getOrganizationSettingsCallable;
  }

  @Override
  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return getSourceCallable;
  }

  @Override
  public UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> groupAssetsCallable() {
    return groupAssetsCallable;
  }

  @Override
  public UnaryCallable<GroupAssetsRequest, GroupAssetsPagedResponse> groupAssetsPagedCallable() {
    return groupAssetsPagedCallable;
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
  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return listAssetsCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return listAssetsPagedCallable;
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
  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return listSourcesCallable;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    return listSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryCallable() {
    return runAssetDiscoveryCallable;
  }

  @Override
  public OperationCallable<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationCallable() {
    return runAssetDiscoveryOperationCallable;
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
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable() {
    return updateFindingCallable;
  }

  @Override
  public UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable() {
    return updateNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsCallable() {
    return updateOrganizationSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    return updateSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks> updateSecurityMarksCallable() {
    return updateSecurityMarksCallable;
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
