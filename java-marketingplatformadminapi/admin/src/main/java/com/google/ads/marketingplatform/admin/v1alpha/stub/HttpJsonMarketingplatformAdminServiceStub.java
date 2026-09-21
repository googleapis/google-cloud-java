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

package com.google.ads.marketingplatform.admin.v1alpha.stub;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAdminAccessBindingsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListOrganizationsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupMembersPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupsPagedResponse;

import com.google.ads.marketingplatform.admin.v1alpha.AdminAccessBinding;
import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.CreateUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.CreateUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.GetAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAdminAccessBindingsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAdminAccessBindingsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupMembersRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupMembersResponse;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupsRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListUserGroupsResponse;
import com.google.ads.marketingplatform.admin.v1alpha.Organization;
import com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse;
import com.google.ads.marketingplatform.admin.v1alpha.UpdateAdminAccessBindingRequest;
import com.google.ads.marketingplatform.admin.v1alpha.UpdateUserGroupMemberRequest;
import com.google.ads.marketingplatform.admin.v1alpha.UpdateUserGroupRequest;
import com.google.ads.marketingplatform.admin.v1alpha.UserGroup;
import com.google.ads.marketingplatform.admin.v1alpha.UserGroupMember;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the MarketingplatformAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMarketingplatformAdminServiceStub extends MarketingplatformAdminServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOrganizationRequest, Organization>
      getOrganizationMethodDescriptor =
          ApiMethodDescriptor.<GetOrganizationRequest, Organization>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetOrganization")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrganizationRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Organization>newBuilder()
                      .setDefaultInstance(Organization.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListOrganizationsRequest, ListOrganizationsResponse>
      listOrganizationsMethodDescriptor =
          ApiMethodDescriptor.<ListOrganizationsRequest, ListOrganizationsResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListOrganizations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrganizationsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/organizations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOrganizationsResponse>newBuilder()
                      .setDefaultInstance(ListOrganizationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsMethodDescriptor =
          ApiMethodDescriptor
              .<FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/FindSalesPartnerManagedClients")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FindSalesPartnerManagedClientsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{organization=organizations/*}:findSalesPartnerManagedClients",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FindSalesPartnerManagedClientsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "organization", request.getOrganization());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FindSalesPartnerManagedClientsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearOrganization().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindSalesPartnerManagedClientsResponse>newBuilder()
                      .setDefaultInstance(
                          FindSalesPartnerManagedClientsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListAnalyticsAccountLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnalyticsAccountLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/analyticsAccountLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalyticsAccountLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalyticsAccountLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAnalyticsAccountLinksResponse>newBuilder()
                      .setDefaultInstance(ListAnalyticsAccountLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateAnalyticsAccountLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnalyticsAccountLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/analyticsAccountLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalyticsAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalyticsAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "analyticsAccountLink",
                                      request.getAnalyticsAccountLink(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyticsAccountLink>newBuilder()
                      .setDefaultInstance(AnalyticsAccountLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteAnalyticsAccountLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAnalyticsAccountLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/analyticsAccountLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalyticsAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalyticsAccountLinkRequest> serializer =
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

  private static final ApiMethodDescriptor<
          SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelMethodDescriptor =
          ApiMethodDescriptor
              .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/SetPropertyServiceLevel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetPropertyServiceLevelRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{analyticsAccountLink=organizations/*/analyticsAccountLinks/*}:setPropertyServiceLevel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetPropertyServiceLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "analyticsAccountLink", request.getAnalyticsAccountLink());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetPropertyServiceLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearAnalyticsAccountLink().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SetPropertyServiceLevelResponse>newBuilder()
                      .setDefaultInstance(SetPropertyServiceLevelResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageMethodDescriptor =
          ApiMethodDescriptor.<ReportPropertyUsageRequest, ReportPropertyUsageResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ReportPropertyUsage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReportPropertyUsageRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{organization=organizations/*}:reportPropertyUsage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReportPropertyUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "organization", request.getOrganization());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReportPropertyUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearOrganization().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportPropertyUsageResponse>newBuilder()
                      .setDefaultInstance(ReportPropertyUsageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserGroupRequest, UserGroup>
      getUserGroupMethodDescriptor =
          ApiMethodDescriptor.<GetUserGroupRequest, UserGroup>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetUserGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/userGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserGroup>newBuilder()
                      .setDefaultInstance(UserGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUserGroupsRequest, ListUserGroupsResponse>
      listUserGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListUserGroupsRequest, ListUserGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListUserGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserGroupsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/userGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserGroupsResponse>newBuilder()
                      .setDefaultInstance(ListUserGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUserGroupRequest, UserGroup>
      createUserGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateUserGroupRequest, UserGroup>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateUserGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/userGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userGroup", request.getUserGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserGroup>newBuilder()
                      .setDefaultInstance(UserGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserGroupRequest, UserGroup>
      updateUserGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserGroupRequest, UserGroup>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/UpdateUserGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{userGroup.name=organizations/*/userGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "userGroup.name", request.getUserGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userGroup", request.getUserGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserGroup>newBuilder()
                      .setDefaultInstance(UserGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserGroupRequest, Empty>
      deleteUserGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserGroupRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteUserGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/userGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserGroupRequest> serializer =
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

  private static final ApiMethodDescriptor<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberMethodDescriptor =
          ApiMethodDescriptor.<GetUserGroupMemberRequest, UserGroupMember>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetUserGroupMember")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserGroupMemberRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/userGroups/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserGroupMember>newBuilder()
                      .setDefaultInstance(UserGroupMember.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUserGroupMembersRequest, ListUserGroupMembersResponse>
      listUserGroupMembersMethodDescriptor =
          ApiMethodDescriptor
              .<ListUserGroupMembersRequest, ListUserGroupMembersResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListUserGroupMembers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserGroupMembersRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*/userGroups/*}/members",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserGroupMembersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserGroupMembersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserGroupMembersResponse>newBuilder()
                      .setDefaultInstance(ListUserGroupMembersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberMethodDescriptor =
          ApiMethodDescriptor.<CreateUserGroupMemberRequest, UserGroupMember>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateUserGroupMember")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserGroupMemberRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*/userGroups/*}/members",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userGroupMember", request.getUserGroupMember(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserGroupMember>newBuilder()
                      .setDefaultInstance(UserGroupMember.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserGroupMemberRequest, UserGroupMember>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/UpdateUserGroupMember")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserGroupMemberRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{userGroupMember.name=organizations/*/userGroups/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "userGroupMember.name",
                                request.getUserGroupMember().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userGroupMember", request.getUserGroupMember(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserGroupMember>newBuilder()
                      .setDefaultInstance(UserGroupMember.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserGroupMemberRequest, Empty>
      deleteUserGroupMemberMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserGroupMemberRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteUserGroupMember")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserGroupMemberRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/userGroups/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserGroupMemberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserGroupMemberRequest> serializer =
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

  private static final ApiMethodDescriptor<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<GetAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetAdminAccessBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAdminAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/adminAccessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdminAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdminAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdminAccessBinding>newBuilder()
                      .setDefaultInstance(AdminAccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
      listAdminAccessBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListAdminAccessBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdminAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/adminAccessBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdminAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdminAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAdminAccessBindingsResponse>newBuilder()
                      .setDefaultInstance(ListAdminAccessBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateAdminAccessBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdminAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/adminAccessBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdminAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdminAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "adminAccessBinding", request.getAdminAccessBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdminAccessBinding>newBuilder()
                      .setDefaultInstance(AdminAccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/UpdateAdminAccessBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAdminAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{adminAccessBinding.name=organizations/*/adminAccessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdminAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "adminAccessBinding.name",
                                request.getAdminAccessBinding().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdminAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "adminAccessBinding", request.getAdminAccessBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdminAccessBinding>newBuilder()
                      .setDefaultInstance(AdminAccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable;
  private final UnaryCallable<ListOrganizationsRequest, ListOrganizationsResponse>
      listOrganizationsCallable;
  private final UnaryCallable<ListOrganizationsRequest, ListOrganizationsPagedResponse>
      listOrganizationsPagedCallable;
  private final UnaryCallable<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsCallable;
  private final UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable;
  private final UnaryCallable<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable;
  private final UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable;
  private final UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable;
  private final UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable;
  private final UnaryCallable<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageCallable;
  private final UnaryCallable<GetUserGroupRequest, UserGroup> getUserGroupCallable;
  private final UnaryCallable<ListUserGroupsRequest, ListUserGroupsResponse> listUserGroupsCallable;
  private final UnaryCallable<ListUserGroupsRequest, ListUserGroupsPagedResponse>
      listUserGroupsPagedCallable;
  private final UnaryCallable<CreateUserGroupRequest, UserGroup> createUserGroupCallable;
  private final UnaryCallable<UpdateUserGroupRequest, UserGroup> updateUserGroupCallable;
  private final UnaryCallable<DeleteUserGroupRequest, Empty> deleteUserGroupCallable;
  private final UnaryCallable<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberCallable;
  private final UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
      listUserGroupMembersCallable;
  private final UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersPagedResponse>
      listUserGroupMembersPagedCallable;
  private final UnaryCallable<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberCallable;
  private final UnaryCallable<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberCallable;
  private final UnaryCallable<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberCallable;
  private final UnaryCallable<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingCallable;
  private final UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
      listAdminAccessBindingsCallable;
  private final UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsPagedCallable;
  private final UnaryCallable<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingCallable;
  private final UnaryCallable<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMarketingplatformAdminServiceStub create(
      MarketingplatformAdminServiceStubSettings settings) throws IOException {
    return new HttpJsonMarketingplatformAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMarketingplatformAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMarketingplatformAdminServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMarketingplatformAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMarketingplatformAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMarketingplatformAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOrganizationRequest, Organization> getOrganizationTransportSettings =
        HttpJsonCallSettings.<GetOrganizationRequest, Organization>newBuilder()
            .setMethodDescriptor(getOrganizationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListOrganizationsRequest, ListOrganizationsResponse>
        listOrganizationsTransportSettings =
            HttpJsonCallSettings.<ListOrganizationsRequest, ListOrganizationsResponse>newBuilder()
                .setMethodDescriptor(listOrganizationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
        findSalesPartnerManagedClientsTransportSettings =
            HttpJsonCallSettings
                .<FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
                    newBuilder()
                .setMethodDescriptor(findSalesPartnerManagedClientsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("organization", String.valueOf(request.getOrganization()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getOrganization())
                .build();
    HttpJsonCallSettings<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
        listAnalyticsAccountLinksTransportSettings =
            HttpJsonCallSettings
                .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
                .setMethodDescriptor(listAnalyticsAccountLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkTransportSettings =
            HttpJsonCallSettings
                .<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
                .setMethodDescriptor(createAnalyticsAccountLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkTransportSettings =
            HttpJsonCallSettings.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAnalyticsAccountLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelTransportSettings =
            HttpJsonCallSettings
                .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
                .setMethodDescriptor(setPropertyServiceLevelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "analytics_account_link",
                          String.valueOf(request.getAnalyticsAccountLink()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getAnalyticsProperty())
                .build();
    HttpJsonCallSettings<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
        reportPropertyUsageTransportSettings =
            HttpJsonCallSettings
                .<ReportPropertyUsageRequest, ReportPropertyUsageResponse>newBuilder()
                .setMethodDescriptor(reportPropertyUsageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("organization", String.valueOf(request.getOrganization()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUserGroupRequest, UserGroup> getUserGroupTransportSettings =
        HttpJsonCallSettings.<GetUserGroupRequest, UserGroup>newBuilder()
            .setMethodDescriptor(getUserGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListUserGroupsRequest, ListUserGroupsResponse>
        listUserGroupsTransportSettings =
            HttpJsonCallSettings.<ListUserGroupsRequest, ListUserGroupsResponse>newBuilder()
                .setMethodDescriptor(listUserGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateUserGroupRequest, UserGroup> createUserGroupTransportSettings =
        HttpJsonCallSettings.<CreateUserGroupRequest, UserGroup>newBuilder()
            .setMethodDescriptor(createUserGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateUserGroupRequest, UserGroup> updateUserGroupTransportSettings =
        HttpJsonCallSettings.<UpdateUserGroupRequest, UserGroup>newBuilder()
            .setMethodDescriptor(updateUserGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user_group.name", String.valueOf(request.getUserGroup().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUserGroupRequest, Empty> deleteUserGroupTransportSettings =
        HttpJsonCallSettings.<DeleteUserGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetUserGroupMemberRequest, UserGroupMember>
        getUserGroupMemberTransportSettings =
            HttpJsonCallSettings.<GetUserGroupMemberRequest, UserGroupMember>newBuilder()
                .setMethodDescriptor(getUserGroupMemberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
        listUserGroupMembersTransportSettings =
            HttpJsonCallSettings
                .<ListUserGroupMembersRequest, ListUserGroupMembersResponse>newBuilder()
                .setMethodDescriptor(listUserGroupMembersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateUserGroupMemberRequest, UserGroupMember>
        createUserGroupMemberTransportSettings =
            HttpJsonCallSettings.<CreateUserGroupMemberRequest, UserGroupMember>newBuilder()
                .setMethodDescriptor(createUserGroupMemberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateUserGroupMemberRequest, UserGroupMember>
        updateUserGroupMemberTransportSettings =
            HttpJsonCallSettings.<UpdateUserGroupMemberRequest, UserGroupMember>newBuilder()
                .setMethodDescriptor(updateUserGroupMemberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_group_member.name",
                          String.valueOf(request.getUserGroupMember().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteUserGroupMemberRequest, Empty>
        deleteUserGroupMemberTransportSettings =
            HttpJsonCallSettings.<DeleteUserGroupMemberRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUserGroupMemberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetAdminAccessBindingRequest, AdminAccessBinding>
        getAdminAccessBindingTransportSettings =
            HttpJsonCallSettings.<GetAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
                .setMethodDescriptor(getAdminAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
        listAdminAccessBindingsTransportSettings =
            HttpJsonCallSettings
                .<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(listAdminAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateAdminAccessBindingRequest, AdminAccessBinding>
        createAdminAccessBindingTransportSettings =
            HttpJsonCallSettings.<CreateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
                .setMethodDescriptor(createAdminAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateAdminAccessBindingRequest, AdminAccessBinding>
        updateAdminAccessBindingTransportSettings =
            HttpJsonCallSettings.<UpdateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
                .setMethodDescriptor(updateAdminAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "admin_access_binding.name",
                          String.valueOf(request.getAdminAccessBinding().getName()));
                      return builder.build();
                    })
                .build();

    this.getOrganizationCallable =
        callableFactory.createUnaryCallable(
            getOrganizationTransportSettings, settings.getOrganizationSettings(), clientContext);
    this.listOrganizationsCallable =
        callableFactory.createUnaryCallable(
            listOrganizationsTransportSettings,
            settings.listOrganizationsSettings(),
            clientContext);
    this.listOrganizationsPagedCallable =
        callableFactory.createPagedCallable(
            listOrganizationsTransportSettings,
            settings.listOrganizationsSettings(),
            clientContext);
    this.findSalesPartnerManagedClientsCallable =
        callableFactory.createUnaryCallable(
            findSalesPartnerManagedClientsTransportSettings,
            settings.findSalesPartnerManagedClientsSettings(),
            clientContext);
    this.listAnalyticsAccountLinksCallable =
        callableFactory.createUnaryCallable(
            listAnalyticsAccountLinksTransportSettings,
            settings.listAnalyticsAccountLinksSettings(),
            clientContext);
    this.listAnalyticsAccountLinksPagedCallable =
        callableFactory.createPagedCallable(
            listAnalyticsAccountLinksTransportSettings,
            settings.listAnalyticsAccountLinksSettings(),
            clientContext);
    this.createAnalyticsAccountLinkCallable =
        callableFactory.createUnaryCallable(
            createAnalyticsAccountLinkTransportSettings,
            settings.createAnalyticsAccountLinkSettings(),
            clientContext);
    this.deleteAnalyticsAccountLinkCallable =
        callableFactory.createUnaryCallable(
            deleteAnalyticsAccountLinkTransportSettings,
            settings.deleteAnalyticsAccountLinkSettings(),
            clientContext);
    this.setPropertyServiceLevelCallable =
        callableFactory.createUnaryCallable(
            setPropertyServiceLevelTransportSettings,
            settings.setPropertyServiceLevelSettings(),
            clientContext);
    this.reportPropertyUsageCallable =
        callableFactory.createUnaryCallable(
            reportPropertyUsageTransportSettings,
            settings.reportPropertyUsageSettings(),
            clientContext);
    this.getUserGroupCallable =
        callableFactory.createUnaryCallable(
            getUserGroupTransportSettings, settings.getUserGroupSettings(), clientContext);
    this.listUserGroupsCallable =
        callableFactory.createUnaryCallable(
            listUserGroupsTransportSettings, settings.listUserGroupsSettings(), clientContext);
    this.listUserGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listUserGroupsTransportSettings, settings.listUserGroupsSettings(), clientContext);
    this.createUserGroupCallable =
        callableFactory.createUnaryCallable(
            createUserGroupTransportSettings, settings.createUserGroupSettings(), clientContext);
    this.updateUserGroupCallable =
        callableFactory.createUnaryCallable(
            updateUserGroupTransportSettings, settings.updateUserGroupSettings(), clientContext);
    this.deleteUserGroupCallable =
        callableFactory.createUnaryCallable(
            deleteUserGroupTransportSettings, settings.deleteUserGroupSettings(), clientContext);
    this.getUserGroupMemberCallable =
        callableFactory.createUnaryCallable(
            getUserGroupMemberTransportSettings,
            settings.getUserGroupMemberSettings(),
            clientContext);
    this.listUserGroupMembersCallable =
        callableFactory.createUnaryCallable(
            listUserGroupMembersTransportSettings,
            settings.listUserGroupMembersSettings(),
            clientContext);
    this.listUserGroupMembersPagedCallable =
        callableFactory.createPagedCallable(
            listUserGroupMembersTransportSettings,
            settings.listUserGroupMembersSettings(),
            clientContext);
    this.createUserGroupMemberCallable =
        callableFactory.createUnaryCallable(
            createUserGroupMemberTransportSettings,
            settings.createUserGroupMemberSettings(),
            clientContext);
    this.updateUserGroupMemberCallable =
        callableFactory.createUnaryCallable(
            updateUserGroupMemberTransportSettings,
            settings.updateUserGroupMemberSettings(),
            clientContext);
    this.deleteUserGroupMemberCallable =
        callableFactory.createUnaryCallable(
            deleteUserGroupMemberTransportSettings,
            settings.deleteUserGroupMemberSettings(),
            clientContext);
    this.getAdminAccessBindingCallable =
        callableFactory.createUnaryCallable(
            getAdminAccessBindingTransportSettings,
            settings.getAdminAccessBindingSettings(),
            clientContext);
    this.listAdminAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            listAdminAccessBindingsTransportSettings,
            settings.listAdminAccessBindingsSettings(),
            clientContext);
    this.listAdminAccessBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listAdminAccessBindingsTransportSettings,
            settings.listAdminAccessBindingsSettings(),
            clientContext);
    this.createAdminAccessBindingCallable =
        callableFactory.createUnaryCallable(
            createAdminAccessBindingTransportSettings,
            settings.createAdminAccessBindingSettings(),
            clientContext);
    this.updateAdminAccessBindingCallable =
        callableFactory.createUnaryCallable(
            updateAdminAccessBindingTransportSettings,
            settings.updateAdminAccessBindingSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOrganizationMethodDescriptor);
    methodDescriptors.add(listOrganizationsMethodDescriptor);
    methodDescriptors.add(findSalesPartnerManagedClientsMethodDescriptor);
    methodDescriptors.add(listAnalyticsAccountLinksMethodDescriptor);
    methodDescriptors.add(createAnalyticsAccountLinkMethodDescriptor);
    methodDescriptors.add(deleteAnalyticsAccountLinkMethodDescriptor);
    methodDescriptors.add(setPropertyServiceLevelMethodDescriptor);
    methodDescriptors.add(reportPropertyUsageMethodDescriptor);
    methodDescriptors.add(getUserGroupMethodDescriptor);
    methodDescriptors.add(listUserGroupsMethodDescriptor);
    methodDescriptors.add(createUserGroupMethodDescriptor);
    methodDescriptors.add(updateUserGroupMethodDescriptor);
    methodDescriptors.add(deleteUserGroupMethodDescriptor);
    methodDescriptors.add(getUserGroupMemberMethodDescriptor);
    methodDescriptors.add(listUserGroupMembersMethodDescriptor);
    methodDescriptors.add(createUserGroupMemberMethodDescriptor);
    methodDescriptors.add(updateUserGroupMemberMethodDescriptor);
    methodDescriptors.add(deleteUserGroupMemberMethodDescriptor);
    methodDescriptors.add(getAdminAccessBindingMethodDescriptor);
    methodDescriptors.add(listAdminAccessBindingsMethodDescriptor);
    methodDescriptors.add(createAdminAccessBindingMethodDescriptor);
    methodDescriptors.add(updateAdminAccessBindingMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    return getOrganizationCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationsRequest, ListOrganizationsResponse>
      listOrganizationsCallable() {
    return listOrganizationsCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationsRequest, ListOrganizationsPagedResponse>
      listOrganizationsPagedCallable() {
    return listOrganizationsPagedCallable;
  }

  @Override
  public UnaryCallable<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsCallable() {
    return findSalesPartnerManagedClientsCallable;
  }

  @Override
  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    return listAnalyticsAccountLinksCallable;
  }

  @Override
  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    return listAnalyticsAccountLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    return createAnalyticsAccountLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    return deleteAnalyticsAccountLinkCallable;
  }

  @Override
  public UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    return setPropertyServiceLevelCallable;
  }

  @Override
  public UnaryCallable<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageCallable() {
    return reportPropertyUsageCallable;
  }

  @Override
  public UnaryCallable<GetUserGroupRequest, UserGroup> getUserGroupCallable() {
    return getUserGroupCallable;
  }

  @Override
  public UnaryCallable<ListUserGroupsRequest, ListUserGroupsResponse> listUserGroupsCallable() {
    return listUserGroupsCallable;
  }

  @Override
  public UnaryCallable<ListUserGroupsRequest, ListUserGroupsPagedResponse>
      listUserGroupsPagedCallable() {
    return listUserGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateUserGroupRequest, UserGroup> createUserGroupCallable() {
    return createUserGroupCallable;
  }

  @Override
  public UnaryCallable<UpdateUserGroupRequest, UserGroup> updateUserGroupCallable() {
    return updateUserGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteUserGroupRequest, Empty> deleteUserGroupCallable() {
    return deleteUserGroupCallable;
  }

  @Override
  public UnaryCallable<GetUserGroupMemberRequest, UserGroupMember> getUserGroupMemberCallable() {
    return getUserGroupMemberCallable;
  }

  @Override
  public UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
      listUserGroupMembersCallable() {
    return listUserGroupMembersCallable;
  }

  @Override
  public UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersPagedResponse>
      listUserGroupMembersPagedCallable() {
    return listUserGroupMembersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberCallable() {
    return createUserGroupMemberCallable;
  }

  @Override
  public UnaryCallable<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberCallable() {
    return updateUserGroupMemberCallable;
  }

  @Override
  public UnaryCallable<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberCallable() {
    return deleteUserGroupMemberCallable;
  }

  @Override
  public UnaryCallable<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingCallable() {
    return getAdminAccessBindingCallable;
  }

  @Override
  public UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
      listAdminAccessBindingsCallable() {
    return listAdminAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsPagedCallable() {
    return listAdminAccessBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingCallable() {
    return createAdminAccessBindingCallable;
  }

  @Override
  public UnaryCallable<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingCallable() {
    return updateAdminAccessBindingCallable;
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
