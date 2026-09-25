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
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MarketingplatformAdminServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (marketingplatformadmin.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getOrganization:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MarketingplatformAdminServiceStubSettings.Builder marketingplatformAdminServiceSettingsBuilder =
 *     MarketingplatformAdminServiceStubSettings.newBuilder();
 * marketingplatformAdminServiceSettingsBuilder
 *     .getOrganizationSettings()
 *     .setRetrySettings(
 *         marketingplatformAdminServiceSettingsBuilder
 *             .getOrganizationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * MarketingplatformAdminServiceStubSettings marketingplatformAdminServiceSettings =
 *     marketingplatformAdminServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class MarketingplatformAdminServiceStubSettings
    extends StubSettings<MarketingplatformAdminServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/marketingplatformadmin.analytics.read")
          .add("https://www.googleapis.com/auth/marketingplatformadmin.analytics.update")
          .build();

  private final UnaryCallSettings<GetOrganizationRequest, Organization> getOrganizationSettings;
  private final PagedCallSettings<
          ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
      listOrganizationsSettings;
  private final UnaryCallSettings<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsSettings;
  private final PagedCallSettings<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksSettings;
  private final UnaryCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkSettings;
  private final UnaryCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkSettings;
  private final UnaryCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelSettings;
  private final UnaryCallSettings<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageSettings;
  private final UnaryCallSettings<GetUserGroupRequest, UserGroup> getUserGroupSettings;
  private final PagedCallSettings<
          ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
      listUserGroupsSettings;
  private final UnaryCallSettings<CreateUserGroupRequest, UserGroup> createUserGroupSettings;
  private final UnaryCallSettings<UpdateUserGroupRequest, UserGroup> updateUserGroupSettings;
  private final UnaryCallSettings<DeleteUserGroupRequest, Empty> deleteUserGroupSettings;
  private final UnaryCallSettings<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberSettings;
  private final PagedCallSettings<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          ListUserGroupMembersPagedResponse>
      listUserGroupMembersSettings;
  private final UnaryCallSettings<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberSettings;
  private final UnaryCallSettings<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberSettings;
  private final UnaryCallSettings<DeleteUserGroupMemberRequest, Empty>
      deleteUserGroupMemberSettings;
  private final UnaryCallSettings<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingSettings;
  private final PagedCallSettings<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsSettings;
  private final UnaryCallSettings<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingSettings;
  private final UnaryCallSettings<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingSettings;

  private static final PagedListDescriptor<
          ListOrganizationsRequest, ListOrganizationsResponse, Organization>
      LIST_ORGANIZATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrganizationsRequest, ListOrganizationsResponse, Organization>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrganizationsRequest injectToken(
                ListOrganizationsRequest payload, String token) {
              return ListOrganizationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrganizationsRequest injectPageSize(
                ListOrganizationsRequest payload, int pageSize) {
              return ListOrganizationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOrganizationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrganizationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Organization> extractResources(ListOrganizationsResponse payload) {
              return payload.getOrganizationsList();
            }
          };

  private static final PagedListDescriptor<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse, AnalyticsAccountLink>
      LIST_ANALYTICS_ACCOUNT_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnalyticsAccountLinksRequest,
              ListAnalyticsAccountLinksResponse,
              AnalyticsAccountLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnalyticsAccountLinksRequest injectToken(
                ListAnalyticsAccountLinksRequest payload, String token) {
              return ListAnalyticsAccountLinksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAnalyticsAccountLinksRequest injectPageSize(
                ListAnalyticsAccountLinksRequest payload, int pageSize) {
              return ListAnalyticsAccountLinksRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAnalyticsAccountLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnalyticsAccountLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnalyticsAccountLink> extractResources(
                ListAnalyticsAccountLinksResponse payload) {
              return payload.getAnalyticsAccountLinksList();
            }
          };

  private static final PagedListDescriptor<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup>
      LIST_USER_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserGroupsRequest injectToken(ListUserGroupsRequest payload, String token) {
              return ListUserGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUserGroupsRequest injectPageSize(
                ListUserGroupsRequest payload, int pageSize) {
              return ListUserGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUserGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserGroup> extractResources(ListUserGroupsResponse payload) {
              return payload.getUserGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>
      LIST_USER_GROUP_MEMBERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserGroupMembersRequest injectToken(
                ListUserGroupMembersRequest payload, String token) {
              return ListUserGroupMembersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUserGroupMembersRequest injectPageSize(
                ListUserGroupMembersRequest payload, int pageSize) {
              return ListUserGroupMembersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUserGroupMembersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserGroupMembersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserGroupMember> extractResources(
                ListUserGroupMembersResponse payload) {
              return payload.getUserGroupMembersList();
            }
          };

  private static final PagedListDescriptor<
          ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse, AdminAccessBinding>
      LIST_ADMIN_ACCESS_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAdminAccessBindingsRequest,
              ListAdminAccessBindingsResponse,
              AdminAccessBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdminAccessBindingsRequest injectToken(
                ListAdminAccessBindingsRequest payload, String token) {
              return ListAdminAccessBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdminAccessBindingsRequest injectPageSize(
                ListAdminAccessBindingsRequest payload, int pageSize) {
              return ListAdminAccessBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAdminAccessBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdminAccessBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdminAccessBinding> extractResources(
                ListAdminAccessBindingsResponse payload) {
              return payload.getAdminAccessBindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
      LIST_ORGANIZATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrganizationsRequest,
              ListOrganizationsResponse,
              ListOrganizationsPagedResponse>() {
            @Override
            public ApiFuture<ListOrganizationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrganizationsRequest, ListOrganizationsResponse> callable,
                ListOrganizationsRequest request,
                ApiCallContext context,
                ApiFuture<ListOrganizationsResponse> futureResponse) {
              PageContext<ListOrganizationsRequest, ListOrganizationsResponse, Organization>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ORGANIZATIONS_PAGE_STR_DESC, request, context);
              return ListOrganizationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          ListAnalyticsAccountLinksPagedResponse>
      LIST_ANALYTICS_ACCOUNT_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnalyticsAccountLinksRequest,
              ListAnalyticsAccountLinksResponse,
              ListAnalyticsAccountLinksPagedResponse>() {
            @Override
            public ApiFuture<ListAnalyticsAccountLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
                    callable,
                ListAnalyticsAccountLinksRequest request,
                ApiCallContext context,
                ApiFuture<ListAnalyticsAccountLinksResponse> futureResponse) {
              PageContext<
                      ListAnalyticsAccountLinksRequest,
                      ListAnalyticsAccountLinksResponse,
                      AnalyticsAccountLink>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANALYTICS_ACCOUNT_LINKS_PAGE_STR_DESC, request, context);
              return ListAnalyticsAccountLinksPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
      LIST_USER_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListUserGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserGroupsRequest, ListUserGroupsResponse> callable,
                ListUserGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListUserGroupsResponse> futureResponse) {
              PageContext<ListUserGroupsRequest, ListUserGroupsResponse, UserGroup> pageContext =
                  PageContext.create(callable, LIST_USER_GROUPS_PAGE_STR_DESC, request, context);
              return ListUserGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          ListUserGroupMembersPagedResponse>
      LIST_USER_GROUP_MEMBERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserGroupMembersRequest,
              ListUserGroupMembersResponse,
              ListUserGroupMembersPagedResponse>() {
            @Override
            public ApiFuture<ListUserGroupMembersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserGroupMembersRequest, ListUserGroupMembersResponse> callable,
                ListUserGroupMembersRequest request,
                ApiCallContext context,
                ApiFuture<ListUserGroupMembersResponse> futureResponse) {
              PageContext<
                      ListUserGroupMembersRequest, ListUserGroupMembersResponse, UserGroupMember>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USER_GROUP_MEMBERS_PAGE_STR_DESC, request, context);
              return ListUserGroupMembersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          ListAdminAccessBindingsPagedResponse>
      LIST_ADMIN_ACCESS_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdminAccessBindingsRequest,
              ListAdminAccessBindingsResponse,
              ListAdminAccessBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListAdminAccessBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdminAccessBindingsRequest, ListAdminAccessBindingsResponse>
                    callable,
                ListAdminAccessBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListAdminAccessBindingsResponse> futureResponse) {
              PageContext<
                      ListAdminAccessBindingsRequest,
                      ListAdminAccessBindingsResponse,
                      AdminAccessBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADMIN_ACCESS_BINDINGS_PAGE_STR_DESC, request, context);
              return ListAdminAccessBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getOrganization. */
  public UnaryCallSettings<GetOrganizationRequest, Organization> getOrganizationSettings() {
    return getOrganizationSettings;
  }

  /** Returns the object with the settings used for calls to listOrganizations. */
  public PagedCallSettings<
          ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
      listOrganizationsSettings() {
    return listOrganizationsSettings;
  }

  /** Returns the object with the settings used for calls to findSalesPartnerManagedClients. */
  public UnaryCallSettings<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsSettings() {
    return findSalesPartnerManagedClientsSettings;
  }

  /** Returns the object with the settings used for calls to listAnalyticsAccountLinks. */
  public PagedCallSettings<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksSettings() {
    return listAnalyticsAccountLinksSettings;
  }

  /** Returns the object with the settings used for calls to createAnalyticsAccountLink. */
  public UnaryCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkSettings() {
    return createAnalyticsAccountLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnalyticsAccountLink. */
  public UnaryCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkSettings() {
    return deleteAnalyticsAccountLinkSettings;
  }

  /** Returns the object with the settings used for calls to setPropertyServiceLevel. */
  public UnaryCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelSettings() {
    return setPropertyServiceLevelSettings;
  }

  /** Returns the object with the settings used for calls to reportPropertyUsage. */
  public UnaryCallSettings<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageSettings() {
    return reportPropertyUsageSettings;
  }

  /** Returns the object with the settings used for calls to getUserGroup. */
  public UnaryCallSettings<GetUserGroupRequest, UserGroup> getUserGroupSettings() {
    return getUserGroupSettings;
  }

  /** Returns the object with the settings used for calls to listUserGroups. */
  public PagedCallSettings<
          ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
      listUserGroupsSettings() {
    return listUserGroupsSettings;
  }

  /** Returns the object with the settings used for calls to createUserGroup. */
  public UnaryCallSettings<CreateUserGroupRequest, UserGroup> createUserGroupSettings() {
    return createUserGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateUserGroup. */
  public UnaryCallSettings<UpdateUserGroupRequest, UserGroup> updateUserGroupSettings() {
    return updateUserGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteUserGroup. */
  public UnaryCallSettings<DeleteUserGroupRequest, Empty> deleteUserGroupSettings() {
    return deleteUserGroupSettings;
  }

  /** Returns the object with the settings used for calls to getUserGroupMember. */
  public UnaryCallSettings<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberSettings() {
    return getUserGroupMemberSettings;
  }

  /** Returns the object with the settings used for calls to listUserGroupMembers. */
  public PagedCallSettings<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          ListUserGroupMembersPagedResponse>
      listUserGroupMembersSettings() {
    return listUserGroupMembersSettings;
  }

  /** Returns the object with the settings used for calls to createUserGroupMember. */
  public UnaryCallSettings<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberSettings() {
    return createUserGroupMemberSettings;
  }

  /** Returns the object with the settings used for calls to updateUserGroupMember. */
  public UnaryCallSettings<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberSettings() {
    return updateUserGroupMemberSettings;
  }

  /** Returns the object with the settings used for calls to deleteUserGroupMember. */
  public UnaryCallSettings<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberSettings() {
    return deleteUserGroupMemberSettings;
  }

  /** Returns the object with the settings used for calls to getAdminAccessBinding. */
  public UnaryCallSettings<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingSettings() {
    return getAdminAccessBindingSettings;
  }

  /** Returns the object with the settings used for calls to listAdminAccessBindings. */
  public PagedCallSettings<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsSettings() {
    return listAdminAccessBindingsSettings;
  }

  /** Returns the object with the settings used for calls to createAdminAccessBinding. */
  public UnaryCallSettings<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingSettings() {
    return createAdminAccessBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateAdminAccessBinding. */
  public UnaryCallSettings<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingSettings() {
    return updateAdminAccessBindingSettings;
  }

  public MarketingplatformAdminServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMarketingplatformAdminServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMarketingplatformAdminServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "marketingplatformadmin";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "marketingplatformadmin.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "marketingplatformadmin.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(MarketingplatformAdminServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(MarketingplatformAdminServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MarketingplatformAdminServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected MarketingplatformAdminServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getOrganizationSettings = settingsBuilder.getOrganizationSettings().build();
    listOrganizationsSettings = settingsBuilder.listOrganizationsSettings().build();
    findSalesPartnerManagedClientsSettings =
        settingsBuilder.findSalesPartnerManagedClientsSettings().build();
    listAnalyticsAccountLinksSettings = settingsBuilder.listAnalyticsAccountLinksSettings().build();
    createAnalyticsAccountLinkSettings =
        settingsBuilder.createAnalyticsAccountLinkSettings().build();
    deleteAnalyticsAccountLinkSettings =
        settingsBuilder.deleteAnalyticsAccountLinkSettings().build();
    setPropertyServiceLevelSettings = settingsBuilder.setPropertyServiceLevelSettings().build();
    reportPropertyUsageSettings = settingsBuilder.reportPropertyUsageSettings().build();
    getUserGroupSettings = settingsBuilder.getUserGroupSettings().build();
    listUserGroupsSettings = settingsBuilder.listUserGroupsSettings().build();
    createUserGroupSettings = settingsBuilder.createUserGroupSettings().build();
    updateUserGroupSettings = settingsBuilder.updateUserGroupSettings().build();
    deleteUserGroupSettings = settingsBuilder.deleteUserGroupSettings().build();
    getUserGroupMemberSettings = settingsBuilder.getUserGroupMemberSettings().build();
    listUserGroupMembersSettings = settingsBuilder.listUserGroupMembersSettings().build();
    createUserGroupMemberSettings = settingsBuilder.createUserGroupMemberSettings().build();
    updateUserGroupMemberSettings = settingsBuilder.updateUserGroupMemberSettings().build();
    deleteUserGroupMemberSettings = settingsBuilder.deleteUserGroupMemberSettings().build();
    getAdminAccessBindingSettings = settingsBuilder.getAdminAccessBindingSettings().build();
    listAdminAccessBindingsSettings = settingsBuilder.listAdminAccessBindingsSettings().build();
    createAdminAccessBindingSettings = settingsBuilder.createAdminAccessBindingSettings().build();
    updateAdminAccessBindingSettings = settingsBuilder.updateAdminAccessBindingSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.ads-marketingplatform:admin")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for MarketingplatformAdminServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<MarketingplatformAdminServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetOrganizationRequest, Organization>
        getOrganizationSettings;
    private final PagedCallSettings.Builder<
            ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
        listOrganizationsSettings;
    private final UnaryCallSettings.Builder<
            FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
        findSalesPartnerManagedClientsSettings;
    private final PagedCallSettings.Builder<
            ListAnalyticsAccountLinksRequest,
            ListAnalyticsAccountLinksResponse,
            ListAnalyticsAccountLinksPagedResponse>
        listAnalyticsAccountLinksSettings;
    private final UnaryCallSettings.Builder<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkSettings;
    private final UnaryCallSettings.Builder<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkSettings;
    private final UnaryCallSettings.Builder<
            SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelSettings;
    private final UnaryCallSettings.Builder<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
        reportPropertyUsageSettings;
    private final UnaryCallSettings.Builder<GetUserGroupRequest, UserGroup> getUserGroupSettings;
    private final PagedCallSettings.Builder<
            ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
        listUserGroupsSettings;
    private final UnaryCallSettings.Builder<CreateUserGroupRequest, UserGroup>
        createUserGroupSettings;
    private final UnaryCallSettings.Builder<UpdateUserGroupRequest, UserGroup>
        updateUserGroupSettings;
    private final UnaryCallSettings.Builder<DeleteUserGroupRequest, Empty> deleteUserGroupSettings;
    private final UnaryCallSettings.Builder<GetUserGroupMemberRequest, UserGroupMember>
        getUserGroupMemberSettings;
    private final PagedCallSettings.Builder<
            ListUserGroupMembersRequest,
            ListUserGroupMembersResponse,
            ListUserGroupMembersPagedResponse>
        listUserGroupMembersSettings;
    private final UnaryCallSettings.Builder<CreateUserGroupMemberRequest, UserGroupMember>
        createUserGroupMemberSettings;
    private final UnaryCallSettings.Builder<UpdateUserGroupMemberRequest, UserGroupMember>
        updateUserGroupMemberSettings;
    private final UnaryCallSettings.Builder<DeleteUserGroupMemberRequest, Empty>
        deleteUserGroupMemberSettings;
    private final UnaryCallSettings.Builder<GetAdminAccessBindingRequest, AdminAccessBinding>
        getAdminAccessBindingSettings;
    private final PagedCallSettings.Builder<
            ListAdminAccessBindingsRequest,
            ListAdminAccessBindingsResponse,
            ListAdminAccessBindingsPagedResponse>
        listAdminAccessBindingsSettings;
    private final UnaryCallSettings.Builder<CreateAdminAccessBindingRequest, AdminAccessBinding>
        createAdminAccessBindingSettings;
    private final UnaryCallSettings.Builder<UpdateAdminAccessBindingRequest, AdminAccessBinding>
        updateAdminAccessBindingSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNKNOWN)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getOrganizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOrganizationsSettings = PagedCallSettings.newBuilder(LIST_ORGANIZATIONS_PAGE_STR_FACT);
      findSalesPartnerManagedClientsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnalyticsAccountLinksSettings =
          PagedCallSettings.newBuilder(LIST_ANALYTICS_ACCOUNT_LINKS_PAGE_STR_FACT);
      createAnalyticsAccountLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAnalyticsAccountLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setPropertyServiceLevelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reportPropertyUsageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserGroupsSettings = PagedCallSettings.newBuilder(LIST_USER_GROUPS_PAGE_STR_FACT);
      createUserGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserGroupMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserGroupMembersSettings =
          PagedCallSettings.newBuilder(LIST_USER_GROUP_MEMBERS_PAGE_STR_FACT);
      createUserGroupMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserGroupMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserGroupMemberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAdminAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAdminAccessBindingsSettings =
          PagedCallSettings.newBuilder(LIST_ADMIN_ACCESS_BINDINGS_PAGE_STR_FACT);
      createAdminAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAdminAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOrganizationSettings,
              listOrganizationsSettings,
              findSalesPartnerManagedClientsSettings,
              listAnalyticsAccountLinksSettings,
              createAnalyticsAccountLinkSettings,
              deleteAnalyticsAccountLinkSettings,
              setPropertyServiceLevelSettings,
              reportPropertyUsageSettings,
              getUserGroupSettings,
              listUserGroupsSettings,
              createUserGroupSettings,
              updateUserGroupSettings,
              deleteUserGroupSettings,
              getUserGroupMemberSettings,
              listUserGroupMembersSettings,
              createUserGroupMemberSettings,
              updateUserGroupMemberSettings,
              deleteUserGroupMemberSettings,
              getAdminAccessBindingSettings,
              listAdminAccessBindingsSettings,
              createAdminAccessBindingSettings,
              updateAdminAccessBindingSettings);
      initDefaults(this);
    }

    protected Builder(MarketingplatformAdminServiceStubSettings settings) {
      super(settings);

      getOrganizationSettings = settings.getOrganizationSettings.toBuilder();
      listOrganizationsSettings = settings.listOrganizationsSettings.toBuilder();
      findSalesPartnerManagedClientsSettings =
          settings.findSalesPartnerManagedClientsSettings.toBuilder();
      listAnalyticsAccountLinksSettings = settings.listAnalyticsAccountLinksSettings.toBuilder();
      createAnalyticsAccountLinkSettings = settings.createAnalyticsAccountLinkSettings.toBuilder();
      deleteAnalyticsAccountLinkSettings = settings.deleteAnalyticsAccountLinkSettings.toBuilder();
      setPropertyServiceLevelSettings = settings.setPropertyServiceLevelSettings.toBuilder();
      reportPropertyUsageSettings = settings.reportPropertyUsageSettings.toBuilder();
      getUserGroupSettings = settings.getUserGroupSettings.toBuilder();
      listUserGroupsSettings = settings.listUserGroupsSettings.toBuilder();
      createUserGroupSettings = settings.createUserGroupSettings.toBuilder();
      updateUserGroupSettings = settings.updateUserGroupSettings.toBuilder();
      deleteUserGroupSettings = settings.deleteUserGroupSettings.toBuilder();
      getUserGroupMemberSettings = settings.getUserGroupMemberSettings.toBuilder();
      listUserGroupMembersSettings = settings.listUserGroupMembersSettings.toBuilder();
      createUserGroupMemberSettings = settings.createUserGroupMemberSettings.toBuilder();
      updateUserGroupMemberSettings = settings.updateUserGroupMemberSettings.toBuilder();
      deleteUserGroupMemberSettings = settings.deleteUserGroupMemberSettings.toBuilder();
      getAdminAccessBindingSettings = settings.getAdminAccessBindingSettings.toBuilder();
      listAdminAccessBindingsSettings = settings.listAdminAccessBindingsSettings.toBuilder();
      createAdminAccessBindingSettings = settings.createAdminAccessBindingSettings.toBuilder();
      updateAdminAccessBindingSettings = settings.updateAdminAccessBindingSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOrganizationSettings,
              listOrganizationsSettings,
              findSalesPartnerManagedClientsSettings,
              listAnalyticsAccountLinksSettings,
              createAnalyticsAccountLinkSettings,
              deleteAnalyticsAccountLinkSettings,
              setPropertyServiceLevelSettings,
              reportPropertyUsageSettings,
              getUserGroupSettings,
              listUserGroupsSettings,
              createUserGroupSettings,
              updateUserGroupSettings,
              deleteUserGroupSettings,
              getUserGroupMemberSettings,
              listUserGroupMembersSettings,
              createUserGroupMemberSettings,
              updateUserGroupMemberSettings,
              deleteUserGroupMemberSettings,
              getAdminAccessBindingSettings,
              listAdminAccessBindingsSettings,
              createAdminAccessBindingSettings,
              updateAdminAccessBindingSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getOrganizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOrganizationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .findSalesPartnerManagedClientsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAnalyticsAccountLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAnalyticsAccountLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAnalyticsAccountLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setPropertyServiceLevelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .reportPropertyUsageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getUserGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUserGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUserGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateUserGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteUserGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getUserGroupMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUserGroupMembersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUserGroupMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateUserGroupMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteUserGroupMemberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAdminAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAdminAccessBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAdminAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAdminAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getOrganization. */
    public UnaryCallSettings.Builder<GetOrganizationRequest, Organization>
        getOrganizationSettings() {
      return getOrganizationSettings;
    }

    /** Returns the builder for the settings used for calls to listOrganizations. */
    public PagedCallSettings.Builder<
            ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
        listOrganizationsSettings() {
      return listOrganizationsSettings;
    }

    /** Returns the builder for the settings used for calls to findSalesPartnerManagedClients. */
    public UnaryCallSettings.Builder<
            FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
        findSalesPartnerManagedClientsSettings() {
      return findSalesPartnerManagedClientsSettings;
    }

    /** Returns the builder for the settings used for calls to listAnalyticsAccountLinks. */
    public PagedCallSettings.Builder<
            ListAnalyticsAccountLinksRequest,
            ListAnalyticsAccountLinksResponse,
            ListAnalyticsAccountLinksPagedResponse>
        listAnalyticsAccountLinksSettings() {
      return listAnalyticsAccountLinksSettings;
    }

    /** Returns the builder for the settings used for calls to createAnalyticsAccountLink. */
    public UnaryCallSettings.Builder<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkSettings() {
      return createAnalyticsAccountLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnalyticsAccountLink. */
    public UnaryCallSettings.Builder<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkSettings() {
      return deleteAnalyticsAccountLinkSettings;
    }

    /** Returns the builder for the settings used for calls to setPropertyServiceLevel. */
    public UnaryCallSettings.Builder<
            SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelSettings() {
      return setPropertyServiceLevelSettings;
    }

    /** Returns the builder for the settings used for calls to reportPropertyUsage. */
    public UnaryCallSettings.Builder<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
        reportPropertyUsageSettings() {
      return reportPropertyUsageSettings;
    }

    /** Returns the builder for the settings used for calls to getUserGroup. */
    public UnaryCallSettings.Builder<GetUserGroupRequest, UserGroup> getUserGroupSettings() {
      return getUserGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listUserGroups. */
    public PagedCallSettings.Builder<
            ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
        listUserGroupsSettings() {
      return listUserGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to createUserGroup. */
    public UnaryCallSettings.Builder<CreateUserGroupRequest, UserGroup> createUserGroupSettings() {
      return createUserGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserGroup. */
    public UnaryCallSettings.Builder<UpdateUserGroupRequest, UserGroup> updateUserGroupSettings() {
      return updateUserGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUserGroup. */
    public UnaryCallSettings.Builder<DeleteUserGroupRequest, Empty> deleteUserGroupSettings() {
      return deleteUserGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getUserGroupMember. */
    public UnaryCallSettings.Builder<GetUserGroupMemberRequest, UserGroupMember>
        getUserGroupMemberSettings() {
      return getUserGroupMemberSettings;
    }

    /** Returns the builder for the settings used for calls to listUserGroupMembers. */
    public PagedCallSettings.Builder<
            ListUserGroupMembersRequest,
            ListUserGroupMembersResponse,
            ListUserGroupMembersPagedResponse>
        listUserGroupMembersSettings() {
      return listUserGroupMembersSettings;
    }

    /** Returns the builder for the settings used for calls to createUserGroupMember. */
    public UnaryCallSettings.Builder<CreateUserGroupMemberRequest, UserGroupMember>
        createUserGroupMemberSettings() {
      return createUserGroupMemberSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserGroupMember. */
    public UnaryCallSettings.Builder<UpdateUserGroupMemberRequest, UserGroupMember>
        updateUserGroupMemberSettings() {
      return updateUserGroupMemberSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUserGroupMember. */
    public UnaryCallSettings.Builder<DeleteUserGroupMemberRequest, Empty>
        deleteUserGroupMemberSettings() {
      return deleteUserGroupMemberSettings;
    }

    /** Returns the builder for the settings used for calls to getAdminAccessBinding. */
    public UnaryCallSettings.Builder<GetAdminAccessBindingRequest, AdminAccessBinding>
        getAdminAccessBindingSettings() {
      return getAdminAccessBindingSettings;
    }

    /** Returns the builder for the settings used for calls to listAdminAccessBindings. */
    public PagedCallSettings.Builder<
            ListAdminAccessBindingsRequest,
            ListAdminAccessBindingsResponse,
            ListAdminAccessBindingsPagedResponse>
        listAdminAccessBindingsSettings() {
      return listAdminAccessBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to createAdminAccessBinding. */
    public UnaryCallSettings.Builder<CreateAdminAccessBindingRequest, AdminAccessBinding>
        createAdminAccessBindingSettings() {
      return createAdminAccessBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateAdminAccessBinding. */
    public UnaryCallSettings.Builder<UpdateAdminAccessBindingRequest, AdminAccessBinding>
        updateAdminAccessBindingSettings() {
      return updateAdminAccessBindingSettings;
    }

    @Override
    public MarketingplatformAdminServiceStubSettings build() throws IOException {
      return new MarketingplatformAdminServiceStubSettings(this);
    }
  }
}
