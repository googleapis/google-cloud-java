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

package com.google.cloud.iam.admin.v1;

import static com.google.cloud.iam.admin.v1.IAMClient.ListRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.ListServiceAccountsPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryGrantableRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryTestablePermissionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.iam.admin.v1.stub.IAMStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IAMClient}.
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
 * IAMSettings.Builder iAMSettingsBuilder = IAMSettings.newBuilder();
 * iAMSettingsBuilder
 *     .getServiceAccountSettings()
 *     .setRetrySettings(
 *         iAMSettingsBuilder.getServiceAccountSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IAMSettings iAMSettings = iAMSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IAMSettings extends ClientSettings<IAMSettings> {

  /** Returns the object with the settings used for calls to listServiceAccounts. */
  public PagedCallSettings<
          ListServiceAccountsRequest, ListServiceAccountsResponse, ListServiceAccountsPagedResponse>
      listServiceAccountsSettings() {
    return ((IAMStubSettings) getStubSettings()).listServiceAccountsSettings();
  }

  /** Returns the object with the settings used for calls to getServiceAccount. */
  public UnaryCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).getServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to createServiceAccount. */
  public UnaryCallSettings<CreateServiceAccountRequest, ServiceAccount>
      createServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).createServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceAccount. */
  public UnaryCallSettings<ServiceAccount, ServiceAccount> updateServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).updateServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to patchServiceAccount. */
  public UnaryCallSettings<PatchServiceAccountRequest, ServiceAccount>
      patchServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).patchServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceAccount. */
  public UnaryCallSettings<DeleteServiceAccountRequest, Empty> deleteServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).deleteServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to undeleteServiceAccount. */
  public UnaryCallSettings<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).undeleteServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to enableServiceAccount. */
  public UnaryCallSettings<EnableServiceAccountRequest, Empty> enableServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).enableServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to disableServiceAccount. */
  public UnaryCallSettings<DisableServiceAccountRequest, Empty> disableServiceAccountSettings() {
    return ((IAMStubSettings) getStubSettings()).disableServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to listServiceAccountKeys. */
  public UnaryCallSettings<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysSettings() {
    return ((IAMStubSettings) getStubSettings()).listServiceAccountKeysSettings();
  }

  /** Returns the object with the settings used for calls to getServiceAccountKey. */
  public UnaryCallSettings<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeySettings() {
    return ((IAMStubSettings) getStubSettings()).getServiceAccountKeySettings();
  }

  /** Returns the object with the settings used for calls to createServiceAccountKey. */
  public UnaryCallSettings<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeySettings() {
    return ((IAMStubSettings) getStubSettings()).createServiceAccountKeySettings();
  }

  /** Returns the object with the settings used for calls to uploadServiceAccountKey. */
  public UnaryCallSettings<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeySettings() {
    return ((IAMStubSettings) getStubSettings()).uploadServiceAccountKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceAccountKey. */
  public UnaryCallSettings<DeleteServiceAccountKeyRequest, Empty>
      deleteServiceAccountKeySettings() {
    return ((IAMStubSettings) getStubSettings()).deleteServiceAccountKeySettings();
  }

  /** Returns the object with the settings used for calls to disableServiceAccountKey. */
  public UnaryCallSettings<DisableServiceAccountKeyRequest, Empty>
      disableServiceAccountKeySettings() {
    return ((IAMStubSettings) getStubSettings()).disableServiceAccountKeySettings();
  }

  /** Returns the object with the settings used for calls to enableServiceAccountKey. */
  public UnaryCallSettings<EnableServiceAccountKeyRequest, Empty>
      enableServiceAccountKeySettings() {
    return ((IAMStubSettings) getStubSettings()).enableServiceAccountKeySettings();
  }

  /**
   * Returns the object with the settings used for calls to signBlob.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SignBlobRequest, SignBlobResponse> signBlobSettings() {
    return ((IAMStubSettings) getStubSettings()).signBlobSettings();
  }

  /**
   * Returns the object with the settings used for calls to signJwt.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SignJwtRequest, SignJwtResponse> signJwtSettings() {
    return ((IAMStubSettings) getStubSettings()).signJwtSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((IAMStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((IAMStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((IAMStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to queryGrantableRoles. */
  public PagedCallSettings<
          QueryGrantableRolesRequest, QueryGrantableRolesResponse, QueryGrantableRolesPagedResponse>
      queryGrantableRolesSettings() {
    return ((IAMStubSettings) getStubSettings()).queryGrantableRolesSettings();
  }

  /** Returns the object with the settings used for calls to listRoles. */
  public PagedCallSettings<ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
      listRolesSettings() {
    return ((IAMStubSettings) getStubSettings()).listRolesSettings();
  }

  /** Returns the object with the settings used for calls to getRole. */
  public UnaryCallSettings<GetRoleRequest, Role> getRoleSettings() {
    return ((IAMStubSettings) getStubSettings()).getRoleSettings();
  }

  /** Returns the object with the settings used for calls to createRole. */
  public UnaryCallSettings<CreateRoleRequest, Role> createRoleSettings() {
    return ((IAMStubSettings) getStubSettings()).createRoleSettings();
  }

  /** Returns the object with the settings used for calls to updateRole. */
  public UnaryCallSettings<UpdateRoleRequest, Role> updateRoleSettings() {
    return ((IAMStubSettings) getStubSettings()).updateRoleSettings();
  }

  /** Returns the object with the settings used for calls to deleteRole. */
  public UnaryCallSettings<DeleteRoleRequest, Role> deleteRoleSettings() {
    return ((IAMStubSettings) getStubSettings()).deleteRoleSettings();
  }

  /** Returns the object with the settings used for calls to undeleteRole. */
  public UnaryCallSettings<UndeleteRoleRequest, Role> undeleteRoleSettings() {
    return ((IAMStubSettings) getStubSettings()).undeleteRoleSettings();
  }

  /** Returns the object with the settings used for calls to queryTestablePermissions. */
  public PagedCallSettings<
          QueryTestablePermissionsRequest,
          QueryTestablePermissionsResponse,
          QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsSettings() {
    return ((IAMStubSettings) getStubSettings()).queryTestablePermissionsSettings();
  }

  /** Returns the object with the settings used for calls to queryAuditableServices. */
  public UnaryCallSettings<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesSettings() {
    return ((IAMStubSettings) getStubSettings()).queryAuditableServicesSettings();
  }

  /** Returns the object with the settings used for calls to lintPolicy. */
  public UnaryCallSettings<LintPolicyRequest, LintPolicyResponse> lintPolicySettings() {
    return ((IAMStubSettings) getStubSettings()).lintPolicySettings();
  }

  public static final IAMSettings create(IAMStubSettings stub) throws IOException {
    return new IAMSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IAMStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IAMStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IAMStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IAMStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IAMStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IAMStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IAMStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected IAMSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IAMSettings. */
  public static class Builder extends ClientSettings.Builder<IAMSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IAMStubSettings.newBuilder(clientContext));
    }

    protected Builder(IAMSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IAMStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IAMStubSettings.newBuilder());
    }

    public IAMStubSettings.Builder getStubSettingsBuilder() {
      return ((IAMStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listServiceAccounts. */
    public PagedCallSettings.Builder<
            ListServiceAccountsRequest,
            ListServiceAccountsResponse,
            ListServiceAccountsPagedResponse>
        listServiceAccountsSettings() {
      return getStubSettingsBuilder().listServiceAccountsSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceAccount. */
    public UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings() {
      return getStubSettingsBuilder().getServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceAccount. */
    public UnaryCallSettings.Builder<CreateServiceAccountRequest, ServiceAccount>
        createServiceAccountSettings() {
      return getStubSettingsBuilder().createServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceAccount. */
    public UnaryCallSettings.Builder<ServiceAccount, ServiceAccount>
        updateServiceAccountSettings() {
      return getStubSettingsBuilder().updateServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to patchServiceAccount. */
    public UnaryCallSettings.Builder<PatchServiceAccountRequest, ServiceAccount>
        patchServiceAccountSettings() {
      return getStubSettingsBuilder().patchServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceAccount. */
    public UnaryCallSettings.Builder<DeleteServiceAccountRequest, Empty>
        deleteServiceAccountSettings() {
      return getStubSettingsBuilder().deleteServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteServiceAccount. */
    public UnaryCallSettings.Builder<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
        undeleteServiceAccountSettings() {
      return getStubSettingsBuilder().undeleteServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to enableServiceAccount. */
    public UnaryCallSettings.Builder<EnableServiceAccountRequest, Empty>
        enableServiceAccountSettings() {
      return getStubSettingsBuilder().enableServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to disableServiceAccount. */
    public UnaryCallSettings.Builder<DisableServiceAccountRequest, Empty>
        disableServiceAccountSettings() {
      return getStubSettingsBuilder().disableServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceAccountKeys. */
    public UnaryCallSettings.Builder<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
        listServiceAccountKeysSettings() {
      return getStubSettingsBuilder().listServiceAccountKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceAccountKey. */
    public UnaryCallSettings.Builder<GetServiceAccountKeyRequest, ServiceAccountKey>
        getServiceAccountKeySettings() {
      return getStubSettingsBuilder().getServiceAccountKeySettings();
    }

    /** Returns the builder for the settings used for calls to createServiceAccountKey. */
    public UnaryCallSettings.Builder<CreateServiceAccountKeyRequest, ServiceAccountKey>
        createServiceAccountKeySettings() {
      return getStubSettingsBuilder().createServiceAccountKeySettings();
    }

    /** Returns the builder for the settings used for calls to uploadServiceAccountKey. */
    public UnaryCallSettings.Builder<UploadServiceAccountKeyRequest, ServiceAccountKey>
        uploadServiceAccountKeySettings() {
      return getStubSettingsBuilder().uploadServiceAccountKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceAccountKey. */
    public UnaryCallSettings.Builder<DeleteServiceAccountKeyRequest, Empty>
        deleteServiceAccountKeySettings() {
      return getStubSettingsBuilder().deleteServiceAccountKeySettings();
    }

    /** Returns the builder for the settings used for calls to disableServiceAccountKey. */
    public UnaryCallSettings.Builder<DisableServiceAccountKeyRequest, Empty>
        disableServiceAccountKeySettings() {
      return getStubSettingsBuilder().disableServiceAccountKeySettings();
    }

    /** Returns the builder for the settings used for calls to enableServiceAccountKey. */
    public UnaryCallSettings.Builder<EnableServiceAccountKeyRequest, Empty>
        enableServiceAccountKeySettings() {
      return getStubSettingsBuilder().enableServiceAccountKeySettings();
    }

    /**
     * Returns the builder for the settings used for calls to signBlob.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SignBlobRequest, SignBlobResponse> signBlobSettings() {
      return getStubSettingsBuilder().signBlobSettings();
    }

    /**
     * Returns the builder for the settings used for calls to signJwt.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SignJwtRequest, SignJwtResponse> signJwtSettings() {
      return getStubSettingsBuilder().signJwtSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to queryGrantableRoles. */
    public PagedCallSettings.Builder<
            QueryGrantableRolesRequest,
            QueryGrantableRolesResponse,
            QueryGrantableRolesPagedResponse>
        queryGrantableRolesSettings() {
      return getStubSettingsBuilder().queryGrantableRolesSettings();
    }

    /** Returns the builder for the settings used for calls to listRoles. */
    public PagedCallSettings.Builder<ListRolesRequest, ListRolesResponse, ListRolesPagedResponse>
        listRolesSettings() {
      return getStubSettingsBuilder().listRolesSettings();
    }

    /** Returns the builder for the settings used for calls to getRole. */
    public UnaryCallSettings.Builder<GetRoleRequest, Role> getRoleSettings() {
      return getStubSettingsBuilder().getRoleSettings();
    }

    /** Returns the builder for the settings used for calls to createRole. */
    public UnaryCallSettings.Builder<CreateRoleRequest, Role> createRoleSettings() {
      return getStubSettingsBuilder().createRoleSettings();
    }

    /** Returns the builder for the settings used for calls to updateRole. */
    public UnaryCallSettings.Builder<UpdateRoleRequest, Role> updateRoleSettings() {
      return getStubSettingsBuilder().updateRoleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRole. */
    public UnaryCallSettings.Builder<DeleteRoleRequest, Role> deleteRoleSettings() {
      return getStubSettingsBuilder().deleteRoleSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteRole. */
    public UnaryCallSettings.Builder<UndeleteRoleRequest, Role> undeleteRoleSettings() {
      return getStubSettingsBuilder().undeleteRoleSettings();
    }

    /** Returns the builder for the settings used for calls to queryTestablePermissions. */
    public PagedCallSettings.Builder<
            QueryTestablePermissionsRequest,
            QueryTestablePermissionsResponse,
            QueryTestablePermissionsPagedResponse>
        queryTestablePermissionsSettings() {
      return getStubSettingsBuilder().queryTestablePermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to queryAuditableServices. */
    public UnaryCallSettings.Builder<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
        queryAuditableServicesSettings() {
      return getStubSettingsBuilder().queryAuditableServicesSettings();
    }

    /** Returns the builder for the settings used for calls to lintPolicy. */
    public UnaryCallSettings.Builder<LintPolicyRequest, LintPolicyResponse> lintPolicySettings() {
      return getStubSettingsBuilder().lintPolicySettings();
    }

    @Override
    public IAMSettings build() throws IOException {
      return new IAMSettings(this);
    }
  }
}
