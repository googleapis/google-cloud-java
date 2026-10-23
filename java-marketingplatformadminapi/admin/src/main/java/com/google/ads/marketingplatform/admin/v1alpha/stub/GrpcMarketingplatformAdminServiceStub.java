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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MarketingplatformAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMarketingplatformAdminServiceStub extends MarketingplatformAdminServiceStub {
  private static final MethodDescriptor<GetOrganizationRequest, Organization>
      getOrganizationMethodDescriptor =
          MethodDescriptor.<GetOrganizationRequest, Organization>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetOrganization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrganizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Organization.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListOrganizationsRequest, ListOrganizationsResponse>
      listOrganizationsMethodDescriptor =
          MethodDescriptor.<ListOrganizationsRequest, ListOrganizationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListOrganizations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOrganizationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOrganizationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsMethodDescriptor =
          MethodDescriptor
              .<FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/FindSalesPartnerManagedClients")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FindSalesPartnerManagedClientsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FindSalesPartnerManagedClientsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksMethodDescriptor =
          MethodDescriptor
              .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListAnalyticsAccountLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnalyticsAccountLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalyticsAccountLinksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkMethodDescriptor =
          MethodDescriptor.<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateAnalyticsAccountLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnalyticsAccountLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyticsAccountLink.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkMethodDescriptor =
          MethodDescriptor.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteAnalyticsAccountLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnalyticsAccountLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelMethodDescriptor =
          MethodDescriptor
              .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/SetPropertyServiceLevel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetPropertyServiceLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SetPropertyServiceLevelResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageMethodDescriptor =
          MethodDescriptor.<ReportPropertyUsageRequest, ReportPropertyUsageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ReportPropertyUsage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportPropertyUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReportPropertyUsageResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUserGroupRequest, UserGroup>
      getUserGroupMethodDescriptor =
          MethodDescriptor.<GetUserGroupRequest, UserGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetUserGroup")
              .setRequestMarshaller(ProtoUtils.marshaller(GetUserGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListUserGroupsRequest, ListUserGroupsResponse>
      listUserGroupsMethodDescriptor =
          MethodDescriptor.<ListUserGroupsRequest, ListUserGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListUserGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateUserGroupRequest, UserGroup>
      createUserGroupMethodDescriptor =
          MethodDescriptor.<CreateUserGroupRequest, UserGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateUserGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUserGroupRequest, UserGroup>
      updateUserGroupMethodDescriptor =
          MethodDescriptor.<UpdateUserGroupRequest, UserGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/UpdateUserGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteUserGroupRequest, Empty>
      deleteUserGroupMethodDescriptor =
          MethodDescriptor.<DeleteUserGroupRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteUserGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUserGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberMethodDescriptor =
          MethodDescriptor.<GetUserGroupMemberRequest, UserGroupMember>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetUserGroupMember")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUserGroupMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserGroupMember.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
      listUserGroupMembersMethodDescriptor =
          MethodDescriptor.<ListUserGroupMembersRequest, ListUserGroupMembersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListUserGroupMembers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserGroupMembersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserGroupMembersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberMethodDescriptor =
          MethodDescriptor.<CreateUserGroupMemberRequest, UserGroupMember>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateUserGroupMember")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserGroupMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserGroupMember.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberMethodDescriptor =
          MethodDescriptor.<UpdateUserGroupMemberRequest, UserGroupMember>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/UpdateUserGroupMember")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserGroupMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserGroupMember.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteUserGroupMemberRequest, Empty>
      deleteUserGroupMemberMethodDescriptor =
          MethodDescriptor.<DeleteUserGroupMemberRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteUserGroupMember")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUserGroupMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingMethodDescriptor =
          MethodDescriptor.<GetAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetAdminAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAdminAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdminAccessBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
      listAdminAccessBindingsMethodDescriptor =
          MethodDescriptor
              .<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListAdminAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAdminAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAdminAccessBindingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingMethodDescriptor =
          MethodDescriptor.<CreateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateAdminAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAdminAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdminAccessBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingMethodDescriptor =
          MethodDescriptor.<UpdateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/UpdateAdminAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAdminAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdminAccessBinding.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMarketingplatformAdminServiceStub create(
      MarketingplatformAdminServiceStubSettings settings) throws IOException {
    return new GrpcMarketingplatformAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMarketingplatformAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMarketingplatformAdminServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcMarketingplatformAdminServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMarketingplatformAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMarketingplatformAdminServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetOrganizationRequest, Organization> getOrganizationTransportSettings =
        GrpcCallSettings.<GetOrganizationRequest, Organization>newBuilder()
            .setMethodDescriptor(getOrganizationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListOrganizationsRequest, ListOrganizationsResponse>
        listOrganizationsTransportSettings =
            GrpcCallSettings.<ListOrganizationsRequest, ListOrganizationsResponse>newBuilder()
                .setMethodDescriptor(listOrganizationsMethodDescriptor)
                .build();
    GrpcCallSettings<FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
        findSalesPartnerManagedClientsTransportSettings =
            GrpcCallSettings
                .<FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
                    newBuilder()
                .setMethodDescriptor(findSalesPartnerManagedClientsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("organization", String.valueOf(request.getOrganization()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getOrganization())
                .build();
    GrpcCallSettings<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
        listAnalyticsAccountLinksTransportSettings =
            GrpcCallSettings
                .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
                .setMethodDescriptor(listAnalyticsAccountLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkTransportSettings =
            GrpcCallSettings.<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
                .setMethodDescriptor(createAnalyticsAccountLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkTransportSettings =
            GrpcCallSettings.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAnalyticsAccountLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelTransportSettings =
            GrpcCallSettings
                .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
                .setMethodDescriptor(setPropertyServiceLevelMethodDescriptor)
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
    GrpcCallSettings<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
        reportPropertyUsageTransportSettings =
            GrpcCallSettings.<ReportPropertyUsageRequest, ReportPropertyUsageResponse>newBuilder()
                .setMethodDescriptor(reportPropertyUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("organization", String.valueOf(request.getOrganization()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUserGroupRequest, UserGroup> getUserGroupTransportSettings =
        GrpcCallSettings.<GetUserGroupRequest, UserGroup>newBuilder()
            .setMethodDescriptor(getUserGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListUserGroupsRequest, ListUserGroupsResponse>
        listUserGroupsTransportSettings =
            GrpcCallSettings.<ListUserGroupsRequest, ListUserGroupsResponse>newBuilder()
                .setMethodDescriptor(listUserGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateUserGroupRequest, UserGroup> createUserGroupTransportSettings =
        GrpcCallSettings.<CreateUserGroupRequest, UserGroup>newBuilder()
            .setMethodDescriptor(createUserGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateUserGroupRequest, UserGroup> updateUserGroupTransportSettings =
        GrpcCallSettings.<UpdateUserGroupRequest, UserGroup>newBuilder()
            .setMethodDescriptor(updateUserGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user_group.name", String.valueOf(request.getUserGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUserGroupRequest, Empty> deleteUserGroupTransportSettings =
        GrpcCallSettings.<DeleteUserGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetUserGroupMemberRequest, UserGroupMember>
        getUserGroupMemberTransportSettings =
            GrpcCallSettings.<GetUserGroupMemberRequest, UserGroupMember>newBuilder()
                .setMethodDescriptor(getUserGroupMemberMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListUserGroupMembersRequest, ListUserGroupMembersResponse>
        listUserGroupMembersTransportSettings =
            GrpcCallSettings.<ListUserGroupMembersRequest, ListUserGroupMembersResponse>newBuilder()
                .setMethodDescriptor(listUserGroupMembersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateUserGroupMemberRequest, UserGroupMember>
        createUserGroupMemberTransportSettings =
            GrpcCallSettings.<CreateUserGroupMemberRequest, UserGroupMember>newBuilder()
                .setMethodDescriptor(createUserGroupMemberMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateUserGroupMemberRequest, UserGroupMember>
        updateUserGroupMemberTransportSettings =
            GrpcCallSettings.<UpdateUserGroupMemberRequest, UserGroupMember>newBuilder()
                .setMethodDescriptor(updateUserGroupMemberMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_group_member.name",
                          String.valueOf(request.getUserGroupMember().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberTransportSettings =
        GrpcCallSettings.<DeleteUserGroupMemberRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserGroupMemberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetAdminAccessBindingRequest, AdminAccessBinding>
        getAdminAccessBindingTransportSettings =
            GrpcCallSettings.<GetAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
                .setMethodDescriptor(getAdminAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
        listAdminAccessBindingsTransportSettings =
            GrpcCallSettings
                .<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(listAdminAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateAdminAccessBindingRequest, AdminAccessBinding>
        createAdminAccessBindingTransportSettings =
            GrpcCallSettings.<CreateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
                .setMethodDescriptor(createAdminAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateAdminAccessBindingRequest, AdminAccessBinding>
        updateAdminAccessBindingTransportSettings =
            GrpcCallSettings.<UpdateAdminAccessBindingRequest, AdminAccessBinding>newBuilder()
                .setMethodDescriptor(updateAdminAccessBindingMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
