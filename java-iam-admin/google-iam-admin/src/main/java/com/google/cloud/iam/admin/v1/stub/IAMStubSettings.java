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

package com.google.cloud.iam.admin.v1.stub;

import static com.google.cloud.iam.admin.v1.IAMClient.ListRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.ListServiceAccountsPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryGrantableRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryTestablePermissionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.iam.admin.v1.CreateRoleRequest;
import com.google.iam.admin.v1.CreateServiceAccountKeyRequest;
import com.google.iam.admin.v1.CreateServiceAccountRequest;
import com.google.iam.admin.v1.DeleteRoleRequest;
import com.google.iam.admin.v1.DeleteServiceAccountKeyRequest;
import com.google.iam.admin.v1.DeleteServiceAccountRequest;
import com.google.iam.admin.v1.DisableServiceAccountKeyRequest;
import com.google.iam.admin.v1.DisableServiceAccountRequest;
import com.google.iam.admin.v1.EnableServiceAccountKeyRequest;
import com.google.iam.admin.v1.EnableServiceAccountRequest;
import com.google.iam.admin.v1.GetRoleRequest;
import com.google.iam.admin.v1.GetServiceAccountKeyRequest;
import com.google.iam.admin.v1.GetServiceAccountRequest;
import com.google.iam.admin.v1.LintPolicyRequest;
import com.google.iam.admin.v1.LintPolicyResponse;
import com.google.iam.admin.v1.ListRolesRequest;
import com.google.iam.admin.v1.ListRolesResponse;
import com.google.iam.admin.v1.ListServiceAccountKeysRequest;
import com.google.iam.admin.v1.ListServiceAccountKeysResponse;
import com.google.iam.admin.v1.ListServiceAccountsRequest;
import com.google.iam.admin.v1.ListServiceAccountsResponse;
import com.google.iam.admin.v1.PatchServiceAccountRequest;
import com.google.iam.admin.v1.Permission;
import com.google.iam.admin.v1.QueryAuditableServicesRequest;
import com.google.iam.admin.v1.QueryAuditableServicesResponse;
import com.google.iam.admin.v1.QueryGrantableRolesRequest;
import com.google.iam.admin.v1.QueryGrantableRolesResponse;
import com.google.iam.admin.v1.QueryTestablePermissionsRequest;
import com.google.iam.admin.v1.QueryTestablePermissionsResponse;
import com.google.iam.admin.v1.Role;
import com.google.iam.admin.v1.ServiceAccount;
import com.google.iam.admin.v1.ServiceAccountKey;
import com.google.iam.admin.v1.SignBlobRequest;
import com.google.iam.admin.v1.SignBlobResponse;
import com.google.iam.admin.v1.SignJwtRequest;
import com.google.iam.admin.v1.SignJwtResponse;
import com.google.iam.admin.v1.UndeleteRoleRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountResponse;
import com.google.iam.admin.v1.UpdateRoleRequest;
import com.google.iam.admin.v1.UploadServiceAccountKeyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IAMStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iam.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getServiceAccount to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IAMStubSettings.Builder iAMSettingsBuilder = IAMStubSettings.newBuilder();
 * iAMSettingsBuilder
 *     .getServiceAccountSettings()
 *     .setRetrySettings(
 *         iAMSettingsBuilder
 *             .getServiceAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IAMStubSettings iAMSettings = iAMSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IAMStubSettings extends StubSettings<IAMStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListServiceAccountsRequest, ListServiceAccountsResponse, ListServiceAccountsPagedResponse>
      listServiceAccountsSettings;
  private final UnaryCallSettings<GetServiceAccountRequest, ServiceAccount>
      getServiceAccountSettings;
  private final UnaryCallSettings<CreateServiceAccountRequest, ServiceAccount>
      createServiceAccountSettings;
  private final UnaryCallSettings<ServiceAccount, ServiceAccount> updateServiceAccountSettings;
  private final UnaryCallSettings<PatchServiceAccountRequest, ServiceAccount>
      patchServiceAccountSettings;
  private final UnaryCallSettings<DeleteServiceAccountRequest, Empty> deleteServiceAccountSettings;
  private final UnaryCallSettings<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountSettings;
  private final UnaryCallSettings<EnableServiceAccountRequest, Empty> enableServiceAccountSettings;
  private final UnaryCallSettings<DisableServiceAccountRequest, Empty>
      disableServiceAccountSettings;
  private final UnaryCallSettings<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysSettings;
  private final UnaryCallSettings<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeySettings;
  private final UnaryCallSettings<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeySettings;
  private final UnaryCallSettings<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeySettings;
  private final UnaryCallSettings<DeleteServiceAccountKeyRequest, Empty>
      deleteServiceAccountKeySettings;
  private final UnaryCallSettings<DisableServiceAccountKeyRequest, Empty>
      disableServiceAccountKeySettings;
  private final UnaryCallSettings<EnableServiceAccountKeyRequest, Empty>
      enableServiceAccountKeySettings;
  private final UnaryCallSettings<SignBlobRequest, SignBlobResponse> signBlobSettings;
  private final UnaryCallSettings<SignJwtRequest, SignJwtResponse> signJwtSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final PagedCallSettings<
          QueryGrantableRolesRequest, QueryGrantableRolesResponse, QueryGrantableRolesPagedResponse>
      queryGrantableRolesSettings;
  private final PagedCallSettings<ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
      listRolesSettings;
  private final UnaryCallSettings<GetRoleRequest, Role> getRoleSettings;
  private final UnaryCallSettings<CreateRoleRequest, Role> createRoleSettings;
  private final UnaryCallSettings<UpdateRoleRequest, Role> updateRoleSettings;
  private final UnaryCallSettings<DeleteRoleRequest, Role> deleteRoleSettings;
  private final UnaryCallSettings<UndeleteRoleRequest, Role> undeleteRoleSettings;
  private final PagedCallSettings<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsSettings;
  private final UnaryCallSettings<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesSettings;
  private final UnaryCallSettings<LintPolicyRequest, LintPolicyResponse> lintPolicySettings;

  private static final PagedListDescriptor<
          ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>
      LIST_SERVICE_ACCOUNTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceAccountsRequest injectToken(
                ListServiceAccountsRequest payload, String token) {
              return ListServiceAccountsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServiceAccountsRequest injectPageSize(
                ListServiceAccountsRequest payload, int pageSize) {
              return ListServiceAccountsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServiceAccountsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceAccountsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceAccount> extractResources(ListServiceAccountsResponse payload) {
              return payload.getAccountsList() == null
                  ? ImmutableList.<ServiceAccount>of()
                  : payload.getAccountsList();
            }
          };

  private static final PagedListDescriptor<
          QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role>
      QUERY_GRANTABLE_ROLES_PAGE_STR_DESC =
          new PagedListDescriptor<QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryGrantableRolesRequest injectToken(
                QueryGrantableRolesRequest payload, String token) {
              return QueryGrantableRolesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryGrantableRolesRequest injectPageSize(
                QueryGrantableRolesRequest payload, int pageSize) {
              return QueryGrantableRolesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryGrantableRolesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryGrantableRolesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Role> extractResources(QueryGrantableRolesResponse payload) {
              return payload.getRolesList() == null
                  ? ImmutableList.<Role>of()
                  : payload.getRolesList();
            }
          };

  private static final PagedListDescriptor<ListRolesRequest, ListRolesResponse, Role>
      LIST_ROLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRolesRequest, ListRolesResponse, Role>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRolesRequest injectToken(ListRolesRequest payload, String token) {
              return ListRolesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRolesRequest injectPageSize(ListRolesRequest payload, int pageSize) {
              return ListRolesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRolesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRolesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Role> extractResources(ListRolesResponse payload) {
              return payload.getRolesList() == null
                  ? ImmutableList.<Role>of()
                  : payload.getRolesList();
            }
          };

  private static final PagedListDescriptor<
          QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>
      QUERY_TESTABLE_PERMISSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryTestablePermissionsRequest injectToken(
                QueryTestablePermissionsRequest payload, String token) {
              return QueryTestablePermissionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public QueryTestablePermissionsRequest injectPageSize(
                QueryTestablePermissionsRequest payload, int pageSize) {
              return QueryTestablePermissionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryTestablePermissionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryTestablePermissionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Permission> extractResources(QueryTestablePermissionsResponse payload) {
              return payload.getPermissionsList() == null
                  ? ImmutableList.<Permission>of()
                  : payload.getPermissionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListServiceAccountsRequest, ListServiceAccountsResponse, ListServiceAccountsPagedResponse>
      LIST_SERVICE_ACCOUNTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceAccountsRequest,
              ListServiceAccountsResponse,
              ListServiceAccountsPagedResponse>() {
            @Override
            public ApiFuture<ListServiceAccountsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsResponse> callable,
                ListServiceAccountsRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceAccountsResponse> futureResponse) {
              PageContext<ListServiceAccountsRequest, ListServiceAccountsResponse, ServiceAccount>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVICE_ACCOUNTS_PAGE_STR_DESC, request, context);
              return ListServiceAccountsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryGrantableRolesRequest, QueryGrantableRolesResponse, QueryGrantableRolesPagedResponse>
      QUERY_GRANTABLE_ROLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryGrantableRolesRequest,
              QueryGrantableRolesResponse,
              QueryGrantableRolesPagedResponse>() {
            @Override
            public ApiFuture<QueryGrantableRolesPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesResponse> callable,
                QueryGrantableRolesRequest request,
                ApiCallContext context,
                ApiFuture<QueryGrantableRolesResponse> futureResponse) {
              PageContext<QueryGrantableRolesRequest, QueryGrantableRolesResponse, Role>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_GRANTABLE_ROLES_PAGE_STR_DESC, request, context);
              return QueryGrantableRolesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
      LIST_ROLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>() {
            @Override
            public ApiFuture<ListRolesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRolesRequest, ListRolesResponse> callable,
                ListRolesRequest request,
                ApiCallContext context,
                ApiFuture<ListRolesResponse> futureResponse) {
              PageContext<ListRolesRequest, ListRolesResponse, Role> pageContext =
                  PageContext.create(callable, LIST_ROLES_PAGE_STR_DESC, request, context);
              return ListRolesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          QueryTestablePermissionsPagedResponse>
      QUERY_TESTABLE_PERMISSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryTestablePermissionsRequest,
              QueryTestablePermissionsResponse,
              QueryTestablePermissionsPagedResponse>() {
            @Override
            public ApiFuture<QueryTestablePermissionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
                    callable,
                QueryTestablePermissionsRequest request,
                ApiCallContext context,
                ApiFuture<QueryTestablePermissionsResponse> futureResponse) {
              PageContext<
                      QueryTestablePermissionsRequest, QueryTestablePermissionsResponse, Permission>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_TESTABLE_PERMISSIONS_PAGE_STR_DESC, request, context);
              return QueryTestablePermissionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listServiceAccounts. */
  public PagedCallSettings<
          ListServiceAccountsRequest, ListServiceAccountsResponse, ListServiceAccountsPagedResponse>
      listServiceAccountsSettings() {
    return listServiceAccountsSettings;
  }

  /** Returns the object with the settings used for calls to getServiceAccount. */
  public UnaryCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountSettings() {
    return getServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to createServiceAccount. */
  public UnaryCallSettings<CreateServiceAccountRequest, ServiceAccount>
      createServiceAccountSettings() {
    return createServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to updateServiceAccount. */
  public UnaryCallSettings<ServiceAccount, ServiceAccount> updateServiceAccountSettings() {
    return updateServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to patchServiceAccount. */
  public UnaryCallSettings<PatchServiceAccountRequest, ServiceAccount>
      patchServiceAccountSettings() {
    return patchServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceAccount. */
  public UnaryCallSettings<DeleteServiceAccountRequest, Empty> deleteServiceAccountSettings() {
    return deleteServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to undeleteServiceAccount. */
  public UnaryCallSettings<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountSettings() {
    return undeleteServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to enableServiceAccount. */
  public UnaryCallSettings<EnableServiceAccountRequest, Empty> enableServiceAccountSettings() {
    return enableServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to disableServiceAccount. */
  public UnaryCallSettings<DisableServiceAccountRequest, Empty> disableServiceAccountSettings() {
    return disableServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to listServiceAccountKeys. */
  public UnaryCallSettings<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysSettings() {
    return listServiceAccountKeysSettings;
  }

  /** Returns the object with the settings used for calls to getServiceAccountKey. */
  public UnaryCallSettings<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeySettings() {
    return getServiceAccountKeySettings;
  }

  /** Returns the object with the settings used for calls to createServiceAccountKey. */
  public UnaryCallSettings<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeySettings() {
    return createServiceAccountKeySettings;
  }

  /** Returns the object with the settings used for calls to uploadServiceAccountKey. */
  public UnaryCallSettings<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeySettings() {
    return uploadServiceAccountKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceAccountKey. */
  public UnaryCallSettings<DeleteServiceAccountKeyRequest, Empty>
      deleteServiceAccountKeySettings() {
    return deleteServiceAccountKeySettings;
  }

  /** Returns the object with the settings used for calls to disableServiceAccountKey. */
  public UnaryCallSettings<DisableServiceAccountKeyRequest, Empty>
      disableServiceAccountKeySettings() {
    return disableServiceAccountKeySettings;
  }

  /** Returns the object with the settings used for calls to enableServiceAccountKey. */
  public UnaryCallSettings<EnableServiceAccountKeyRequest, Empty>
      enableServiceAccountKeySettings() {
    return enableServiceAccountKeySettings;
  }

  /**
   * Returns the object with the settings used for calls to signBlob.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SignBlobRequest, SignBlobResponse> signBlobSettings() {
    return signBlobSettings;
  }

  /**
   * Returns the object with the settings used for calls to signJwt.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SignJwtRequest, SignJwtResponse> signJwtSettings() {
    return signJwtSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to queryGrantableRoles. */
  public PagedCallSettings<
          QueryGrantableRolesRequest, QueryGrantableRolesResponse, QueryGrantableRolesPagedResponse>
      queryGrantableRolesSettings() {
    return queryGrantableRolesSettings;
  }

  /** Returns the object with the settings used for calls to listRoles. */
  public PagedCallSettings<ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
      listRolesSettings() {
    return listRolesSettings;
  }

  /** Returns the object with the settings used for calls to getRole. */
  public UnaryCallSettings<GetRoleRequest, Role> getRoleSettings() {
    return getRoleSettings;
  }

  /** Returns the object with the settings used for calls to createRole. */
  public UnaryCallSettings<CreateRoleRequest, Role> createRoleSettings() {
    return createRoleSettings;
  }

  /** Returns the object with the settings used for calls to updateRole. */
  public UnaryCallSettings<UpdateRoleRequest, Role> updateRoleSettings() {
    return updateRoleSettings;
  }

  /** Returns the object with the settings used for calls to deleteRole. */
  public UnaryCallSettings<DeleteRoleRequest, Role> deleteRoleSettings() {
    return deleteRoleSettings;
  }

  /** Returns the object with the settings used for calls to undeleteRole. */
  public UnaryCallSettings<UndeleteRoleRequest, Role> undeleteRoleSettings() {
    return undeleteRoleSettings;
  }

  /** Returns the object with the settings used for calls to queryTestablePermissions. */
  public PagedCallSettings<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsSettings() {
    return queryTestablePermissionsSettings;
  }

  /** Returns the object with the settings used for calls to queryAuditableServices. */
  public UnaryCallSettings<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesSettings() {
    return queryAuditableServicesSettings;
  }

  /** Returns the object with the settings used for calls to lintPolicy. */
  public UnaryCallSettings<LintPolicyRequest, LintPolicyResponse> lintPolicySettings() {
    return lintPolicySettings;
  }

  public IAMStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIAMStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "iam.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "iam.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(IAMStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected IAMStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listServiceAccountsSettings = settingsBuilder.listServiceAccountsSettings().build();
    getServiceAccountSettings = settingsBuilder.getServiceAccountSettings().build();
    createServiceAccountSettings = settingsBuilder.createServiceAccountSettings().build();
    updateServiceAccountSettings = settingsBuilder.updateServiceAccountSettings().build();
    patchServiceAccountSettings = settingsBuilder.patchServiceAccountSettings().build();
    deleteServiceAccountSettings = settingsBuilder.deleteServiceAccountSettings().build();
    undeleteServiceAccountSettings = settingsBuilder.undeleteServiceAccountSettings().build();
    enableServiceAccountSettings = settingsBuilder.enableServiceAccountSettings().build();
    disableServiceAccountSettings = settingsBuilder.disableServiceAccountSettings().build();
    listServiceAccountKeysSettings = settingsBuilder.listServiceAccountKeysSettings().build();
    getServiceAccountKeySettings = settingsBuilder.getServiceAccountKeySettings().build();
    createServiceAccountKeySettings = settingsBuilder.createServiceAccountKeySettings().build();
    uploadServiceAccountKeySettings = settingsBuilder.uploadServiceAccountKeySettings().build();
    deleteServiceAccountKeySettings = settingsBuilder.deleteServiceAccountKeySettings().build();
    disableServiceAccountKeySettings = settingsBuilder.disableServiceAccountKeySettings().build();
    enableServiceAccountKeySettings = settingsBuilder.enableServiceAccountKeySettings().build();
    signBlobSettings = settingsBuilder.signBlobSettings().build();
    signJwtSettings = settingsBuilder.signJwtSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    queryGrantableRolesSettings = settingsBuilder.queryGrantableRolesSettings().build();
    listRolesSettings = settingsBuilder.listRolesSettings().build();
    getRoleSettings = settingsBuilder.getRoleSettings().build();
    createRoleSettings = settingsBuilder.createRoleSettings().build();
    updateRoleSettings = settingsBuilder.updateRoleSettings().build();
    deleteRoleSettings = settingsBuilder.deleteRoleSettings().build();
    undeleteRoleSettings = settingsBuilder.undeleteRoleSettings().build();
    queryTestablePermissionsSettings = settingsBuilder.queryTestablePermissionsSettings().build();
    queryAuditableServicesSettings = settingsBuilder.queryAuditableServicesSettings().build();
    lintPolicySettings = settingsBuilder.lintPolicySettings().build();
  }

  /** Builder for IAMStubSettings. */
  public static class Builder extends StubSettings.Builder<IAMStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListServiceAccountsRequest,
            ListServiceAccountsResponse,
            ListServiceAccountsPagedResponse>
        listServiceAccountsSettings;
    private final UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings;
    private final UnaryCallSettings.Builder<CreateServiceAccountRequest, ServiceAccount>
        createServiceAccountSettings;
    private final UnaryCallSettings.Builder<ServiceAccount, ServiceAccount>
        updateServiceAccountSettings;
    private final UnaryCallSettings.Builder<PatchServiceAccountRequest, ServiceAccount>
        patchServiceAccountSettings;
    private final UnaryCallSettings.Builder<DeleteServiceAccountRequest, Empty>
        deleteServiceAccountSettings;
    private final UnaryCallSettings.Builder<
            UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
        undeleteServiceAccountSettings;
    private final UnaryCallSettings.Builder<EnableServiceAccountRequest, Empty>
        enableServiceAccountSettings;
    private final UnaryCallSettings.Builder<DisableServiceAccountRequest, Empty>
        disableServiceAccountSettings;
    private final UnaryCallSettings.Builder<
            ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
        listServiceAccountKeysSettings;
    private final UnaryCallSettings.Builder<GetServiceAccountKeyRequest, ServiceAccountKey>
        getServiceAccountKeySettings;
    private final UnaryCallSettings.Builder<CreateServiceAccountKeyRequest, ServiceAccountKey>
        createServiceAccountKeySettings;
    private final UnaryCallSettings.Builder<UploadServiceAccountKeyRequest, ServiceAccountKey>
        uploadServiceAccountKeySettings;
    private final UnaryCallSettings.Builder<DeleteServiceAccountKeyRequest, Empty>
        deleteServiceAccountKeySettings;
    private final UnaryCallSettings.Builder<DisableServiceAccountKeyRequest, Empty>
        disableServiceAccountKeySettings;
    private final UnaryCallSettings.Builder<EnableServiceAccountKeyRequest, Empty>
        enableServiceAccountKeySettings;
    private final UnaryCallSettings.Builder<SignBlobRequest, SignBlobResponse> signBlobSettings;
    private final UnaryCallSettings.Builder<SignJwtRequest, SignJwtResponse> signJwtSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final PagedCallSettings.Builder<
            QueryGrantableRolesRequest,
            QueryGrantableRolesResponse,
            QueryGrantableRolesPagedResponse>
        queryGrantableRolesSettings;
    private final PagedCallSettings.Builder<
            ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
        listRolesSettings;
    private final UnaryCallSettings.Builder<GetRoleRequest, Role> getRoleSettings;
    private final UnaryCallSettings.Builder<CreateRoleRequest, Role> createRoleSettings;
    private final UnaryCallSettings.Builder<UpdateRoleRequest, Role> updateRoleSettings;
    private final UnaryCallSettings.Builder<DeleteRoleRequest, Role> deleteRoleSettings;
    private final UnaryCallSettings.Builder<UndeleteRoleRequest, Role> undeleteRoleSettings;
    private final PagedCallSettings.Builder<
            QueryTestablePermissionsRequest,
            QueryTestablePermissionsResponse,
            QueryTestablePermissionsPagedResponse>
        queryTestablePermissionsSettings;
    private final UnaryCallSettings.Builder<
            QueryAuditableServicesRequest, QueryAuditableServicesResponse>
        queryAuditableServicesSettings;
    private final UnaryCallSettings.Builder<LintPolicyRequest, LintPolicyResponse>
        lintPolicySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listServiceAccountsSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_ACCOUNTS_PAGE_STR_FACT);
      getServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServiceAccountKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getServiceAccountKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceAccountKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      uploadServiceAccountKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceAccountKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableServiceAccountKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableServiceAccountKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      signBlobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      signJwtSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryGrantableRolesSettings =
          PagedCallSettings.newBuilder(QUERY_GRANTABLE_ROLES_PAGE_STR_FACT);
      listRolesSettings = PagedCallSettings.newBuilder(LIST_ROLES_PAGE_STR_FACT);
      getRoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteRoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryTestablePermissionsSettings =
          PagedCallSettings.newBuilder(QUERY_TESTABLE_PERMISSIONS_PAGE_STR_FACT);
      queryAuditableServicesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lintPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServiceAccountsSettings,
              getServiceAccountSettings,
              createServiceAccountSettings,
              updateServiceAccountSettings,
              patchServiceAccountSettings,
              deleteServiceAccountSettings,
              undeleteServiceAccountSettings,
              enableServiceAccountSettings,
              disableServiceAccountSettings,
              listServiceAccountKeysSettings,
              getServiceAccountKeySettings,
              createServiceAccountKeySettings,
              uploadServiceAccountKeySettings,
              deleteServiceAccountKeySettings,
              disableServiceAccountKeySettings,
              enableServiceAccountKeySettings,
              signBlobSettings,
              signJwtSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              queryGrantableRolesSettings,
              listRolesSettings,
              getRoleSettings,
              createRoleSettings,
              updateRoleSettings,
              deleteRoleSettings,
              undeleteRoleSettings,
              queryTestablePermissionsSettings,
              queryAuditableServicesSettings,
              lintPolicySettings);
      initDefaults(this);
    }

    protected Builder(IAMStubSettings settings) {
      super(settings);

      listServiceAccountsSettings = settings.listServiceAccountsSettings.toBuilder();
      getServiceAccountSettings = settings.getServiceAccountSettings.toBuilder();
      createServiceAccountSettings = settings.createServiceAccountSettings.toBuilder();
      updateServiceAccountSettings = settings.updateServiceAccountSettings.toBuilder();
      patchServiceAccountSettings = settings.patchServiceAccountSettings.toBuilder();
      deleteServiceAccountSettings = settings.deleteServiceAccountSettings.toBuilder();
      undeleteServiceAccountSettings = settings.undeleteServiceAccountSettings.toBuilder();
      enableServiceAccountSettings = settings.enableServiceAccountSettings.toBuilder();
      disableServiceAccountSettings = settings.disableServiceAccountSettings.toBuilder();
      listServiceAccountKeysSettings = settings.listServiceAccountKeysSettings.toBuilder();
      getServiceAccountKeySettings = settings.getServiceAccountKeySettings.toBuilder();
      createServiceAccountKeySettings = settings.createServiceAccountKeySettings.toBuilder();
      uploadServiceAccountKeySettings = settings.uploadServiceAccountKeySettings.toBuilder();
      deleteServiceAccountKeySettings = settings.deleteServiceAccountKeySettings.toBuilder();
      disableServiceAccountKeySettings = settings.disableServiceAccountKeySettings.toBuilder();
      enableServiceAccountKeySettings = settings.enableServiceAccountKeySettings.toBuilder();
      signBlobSettings = settings.signBlobSettings.toBuilder();
      signJwtSettings = settings.signJwtSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      queryGrantableRolesSettings = settings.queryGrantableRolesSettings.toBuilder();
      listRolesSettings = settings.listRolesSettings.toBuilder();
      getRoleSettings = settings.getRoleSettings.toBuilder();
      createRoleSettings = settings.createRoleSettings.toBuilder();
      updateRoleSettings = settings.updateRoleSettings.toBuilder();
      deleteRoleSettings = settings.deleteRoleSettings.toBuilder();
      undeleteRoleSettings = settings.undeleteRoleSettings.toBuilder();
      queryTestablePermissionsSettings = settings.queryTestablePermissionsSettings.toBuilder();
      queryAuditableServicesSettings = settings.queryAuditableServicesSettings.toBuilder();
      lintPolicySettings = settings.lintPolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServiceAccountsSettings,
              getServiceAccountSettings,
              createServiceAccountSettings,
              updateServiceAccountSettings,
              patchServiceAccountSettings,
              deleteServiceAccountSettings,
              undeleteServiceAccountSettings,
              enableServiceAccountSettings,
              disableServiceAccountSettings,
              listServiceAccountKeysSettings,
              getServiceAccountKeySettings,
              createServiceAccountKeySettings,
              uploadServiceAccountKeySettings,
              deleteServiceAccountKeySettings,
              disableServiceAccountKeySettings,
              enableServiceAccountKeySettings,
              signBlobSettings,
              signJwtSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              queryGrantableRolesSettings,
              listRolesSettings,
              getRoleSettings,
              createRoleSettings,
              updateRoleSettings,
              deleteRoleSettings,
              undeleteRoleSettings,
              queryTestablePermissionsSettings,
              queryAuditableServicesSettings,
              lintPolicySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listServiceAccountsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listServiceAccountKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServiceAccountKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceAccountKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .uploadServiceAccountKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteServiceAccountKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .disableServiceAccountKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableServiceAccountKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .signBlobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .signJwtSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .queryGrantableRolesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRolesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createRoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateRoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteRoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .undeleteRoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryTestablePermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryAuditableServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .lintPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to listServiceAccounts. */
    public PagedCallSettings.Builder<
            ListServiceAccountsRequest,
            ListServiceAccountsResponse,
            ListServiceAccountsPagedResponse>
        listServiceAccountsSettings() {
      return listServiceAccountsSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceAccount. */
    public UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings() {
      return getServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceAccount. */
    public UnaryCallSettings.Builder<CreateServiceAccountRequest, ServiceAccount>
        createServiceAccountSettings() {
      return createServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to updateServiceAccount. */
    public UnaryCallSettings.Builder<ServiceAccount, ServiceAccount>
        updateServiceAccountSettings() {
      return updateServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to patchServiceAccount. */
    public UnaryCallSettings.Builder<PatchServiceAccountRequest, ServiceAccount>
        patchServiceAccountSettings() {
      return patchServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceAccount. */
    public UnaryCallSettings.Builder<DeleteServiceAccountRequest, Empty>
        deleteServiceAccountSettings() {
      return deleteServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteServiceAccount. */
    public UnaryCallSettings.Builder<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
        undeleteServiceAccountSettings() {
      return undeleteServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to enableServiceAccount. */
    public UnaryCallSettings.Builder<EnableServiceAccountRequest, Empty>
        enableServiceAccountSettings() {
      return enableServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to disableServiceAccount. */
    public UnaryCallSettings.Builder<DisableServiceAccountRequest, Empty>
        disableServiceAccountSettings() {
      return disableServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to listServiceAccountKeys. */
    public UnaryCallSettings.Builder<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
        listServiceAccountKeysSettings() {
      return listServiceAccountKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceAccountKey. */
    public UnaryCallSettings.Builder<GetServiceAccountKeyRequest, ServiceAccountKey>
        getServiceAccountKeySettings() {
      return getServiceAccountKeySettings;
    }

    /** Returns the builder for the settings used for calls to createServiceAccountKey. */
    public UnaryCallSettings.Builder<CreateServiceAccountKeyRequest, ServiceAccountKey>
        createServiceAccountKeySettings() {
      return createServiceAccountKeySettings;
    }

    /** Returns the builder for the settings used for calls to uploadServiceAccountKey. */
    public UnaryCallSettings.Builder<UploadServiceAccountKeyRequest, ServiceAccountKey>
        uploadServiceAccountKeySettings() {
      return uploadServiceAccountKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceAccountKey. */
    public UnaryCallSettings.Builder<DeleteServiceAccountKeyRequest, Empty>
        deleteServiceAccountKeySettings() {
      return deleteServiceAccountKeySettings;
    }

    /** Returns the builder for the settings used for calls to disableServiceAccountKey. */
    public UnaryCallSettings.Builder<DisableServiceAccountKeyRequest, Empty>
        disableServiceAccountKeySettings() {
      return disableServiceAccountKeySettings;
    }

    /** Returns the builder for the settings used for calls to enableServiceAccountKey. */
    public UnaryCallSettings.Builder<EnableServiceAccountKeyRequest, Empty>
        enableServiceAccountKeySettings() {
      return enableServiceAccountKeySettings;
    }

    /**
     * Returns the builder for the settings used for calls to signBlob.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SignBlobRequest, SignBlobResponse> signBlobSettings() {
      return signBlobSettings;
    }

    /**
     * Returns the builder for the settings used for calls to signJwt.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SignJwtRequest, SignJwtResponse> signJwtSettings() {
      return signJwtSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to queryGrantableRoles. */
    public PagedCallSettings.Builder<
            QueryGrantableRolesRequest,
            QueryGrantableRolesResponse,
            QueryGrantableRolesPagedResponse>
        queryGrantableRolesSettings() {
      return queryGrantableRolesSettings;
    }

    /** Returns the builder for the settings used for calls to listRoles. */
    public PagedCallSettings.Builder<ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
        listRolesSettings() {
      return listRolesSettings;
    }

    /** Returns the builder for the settings used for calls to getRole. */
    public UnaryCallSettings.Builder<GetRoleRequest, Role> getRoleSettings() {
      return getRoleSettings;
    }

    /** Returns the builder for the settings used for calls to createRole. */
    public UnaryCallSettings.Builder<CreateRoleRequest, Role> createRoleSettings() {
      return createRoleSettings;
    }

    /** Returns the builder for the settings used for calls to updateRole. */
    public UnaryCallSettings.Builder<UpdateRoleRequest, Role> updateRoleSettings() {
      return updateRoleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRole. */
    public UnaryCallSettings.Builder<DeleteRoleRequest, Role> deleteRoleSettings() {
      return deleteRoleSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteRole. */
    public UnaryCallSettings.Builder<UndeleteRoleRequest, Role> undeleteRoleSettings() {
      return undeleteRoleSettings;
    }

    /** Returns the builder for the settings used for calls to queryTestablePermissions. */
    public PagedCallSettings.Builder<
            QueryTestablePermissionsRequest,
            QueryTestablePermissionsResponse,
            QueryTestablePermissionsPagedResponse>
        queryTestablePermissionsSettings() {
      return queryTestablePermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to queryAuditableServices. */
    public UnaryCallSettings.Builder<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
        queryAuditableServicesSettings() {
      return queryAuditableServicesSettings;
    }

    /** Returns the builder for the settings used for calls to lintPolicy. */
    public UnaryCallSettings.Builder<LintPolicyRequest, LintPolicyResponse> lintPolicySettings() {
      return lintPolicySettings;
    }

    @Override
    public IAMStubSettings build() throws IOException {
      return new IAMStubSettings(this);
    }
  }
}
