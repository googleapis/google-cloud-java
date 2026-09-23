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

package com.google.ads.marketingplatform.admin.v1alpha;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAdminAccessBindingsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListOrganizationsPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupMembersPagedResponse;
import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListUserGroupsPagedResponse;

import com.google.ads.marketingplatform.admin.v1alpha.stub.MarketingplatformAdminServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MarketingplatformAdminServiceClient}.
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
 * MarketingplatformAdminServiceSettings.Builder marketingplatformAdminServiceSettingsBuilder =
 *     MarketingplatformAdminServiceSettings.newBuilder();
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
 * MarketingplatformAdminServiceSettings marketingplatformAdminServiceSettings =
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
public class MarketingplatformAdminServiceSettings
    extends ClientSettings<MarketingplatformAdminServiceSettings> {

  /** Returns the object with the settings used for calls to getOrganization. */
  public UnaryCallSettings<GetOrganizationRequest, Organization> getOrganizationSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .getOrganizationSettings();
  }

  /** Returns the object with the settings used for calls to listOrganizations. */
  public PagedCallSettings<
          ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
      listOrganizationsSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .listOrganizationsSettings();
  }

  /** Returns the object with the settings used for calls to findSalesPartnerManagedClients. */
  public UnaryCallSettings<
          FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
      findSalesPartnerManagedClientsSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .findSalesPartnerManagedClientsSettings();
  }

  /** Returns the object with the settings used for calls to listAnalyticsAccountLinks. */
  public PagedCallSettings<
          ListAnalyticsAccountLinksRequest,
          ListAnalyticsAccountLinksResponse,
          ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .listAnalyticsAccountLinksSettings();
  }

  /** Returns the object with the settings used for calls to createAnalyticsAccountLink. */
  public UnaryCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .createAnalyticsAccountLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnalyticsAccountLink. */
  public UnaryCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .deleteAnalyticsAccountLinkSettings();
  }

  /** Returns the object with the settings used for calls to setPropertyServiceLevel. */
  public UnaryCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .setPropertyServiceLevelSettings();
  }

  /** Returns the object with the settings used for calls to reportPropertyUsage. */
  public UnaryCallSettings<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
      reportPropertyUsageSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .reportPropertyUsageSettings();
  }

  /** Returns the object with the settings used for calls to getUserGroup. */
  public UnaryCallSettings<GetUserGroupRequest, UserGroup> getUserGroupSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings()).getUserGroupSettings();
  }

  /** Returns the object with the settings used for calls to listUserGroups. */
  public PagedCallSettings<
          ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
      listUserGroupsSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings()).listUserGroupsSettings();
  }

  /** Returns the object with the settings used for calls to createUserGroup. */
  public UnaryCallSettings<CreateUserGroupRequest, UserGroup> createUserGroupSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .createUserGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateUserGroup. */
  public UnaryCallSettings<UpdateUserGroupRequest, UserGroup> updateUserGroupSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .updateUserGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteUserGroup. */
  public UnaryCallSettings<DeleteUserGroupRequest, Empty> deleteUserGroupSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .deleteUserGroupSettings();
  }

  /** Returns the object with the settings used for calls to getUserGroupMember. */
  public UnaryCallSettings<GetUserGroupMemberRequest, UserGroupMember>
      getUserGroupMemberSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .getUserGroupMemberSettings();
  }

  /** Returns the object with the settings used for calls to listUserGroupMembers. */
  public PagedCallSettings<
          ListUserGroupMembersRequest,
          ListUserGroupMembersResponse,
          ListUserGroupMembersPagedResponse>
      listUserGroupMembersSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .listUserGroupMembersSettings();
  }

  /** Returns the object with the settings used for calls to createUserGroupMember. */
  public UnaryCallSettings<CreateUserGroupMemberRequest, UserGroupMember>
      createUserGroupMemberSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .createUserGroupMemberSettings();
  }

  /** Returns the object with the settings used for calls to updateUserGroupMember. */
  public UnaryCallSettings<UpdateUserGroupMemberRequest, UserGroupMember>
      updateUserGroupMemberSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .updateUserGroupMemberSettings();
  }

  /** Returns the object with the settings used for calls to deleteUserGroupMember. */
  public UnaryCallSettings<DeleteUserGroupMemberRequest, Empty> deleteUserGroupMemberSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .deleteUserGroupMemberSettings();
  }

  /** Returns the object with the settings used for calls to getAdminAccessBinding. */
  public UnaryCallSettings<GetAdminAccessBindingRequest, AdminAccessBinding>
      getAdminAccessBindingSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .getAdminAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to listAdminAccessBindings. */
  public PagedCallSettings<
          ListAdminAccessBindingsRequest,
          ListAdminAccessBindingsResponse,
          ListAdminAccessBindingsPagedResponse>
      listAdminAccessBindingsSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .listAdminAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to createAdminAccessBinding. */
  public UnaryCallSettings<CreateAdminAccessBindingRequest, AdminAccessBinding>
      createAdminAccessBindingSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .createAdminAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateAdminAccessBinding. */
  public UnaryCallSettings<UpdateAdminAccessBindingRequest, AdminAccessBinding>
      updateAdminAccessBindingSettings() {
    return ((MarketingplatformAdminServiceStubSettings) getStubSettings())
        .updateAdminAccessBindingSettings();
  }

  public static final MarketingplatformAdminServiceSettings create(
      MarketingplatformAdminServiceStubSettings stub) throws IOException {
    return new MarketingplatformAdminServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MarketingplatformAdminServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MarketingplatformAdminServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MarketingplatformAdminServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MarketingplatformAdminServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MarketingplatformAdminServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MarketingplatformAdminServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MarketingplatformAdminServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MarketingplatformAdminServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MarketingplatformAdminServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MarketingplatformAdminServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<MarketingplatformAdminServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(MarketingplatformAdminServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MarketingplatformAdminServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MarketingplatformAdminServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MarketingplatformAdminServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(MarketingplatformAdminServiceStubSettings.newHttpJsonBuilder());
    }

    public MarketingplatformAdminServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MarketingplatformAdminServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getOrganization. */
    public UnaryCallSettings.Builder<GetOrganizationRequest, Organization>
        getOrganizationSettings() {
      return getStubSettingsBuilder().getOrganizationSettings();
    }

    /** Returns the builder for the settings used for calls to listOrganizations. */
    public PagedCallSettings.Builder<
            ListOrganizationsRequest, ListOrganizationsResponse, ListOrganizationsPagedResponse>
        listOrganizationsSettings() {
      return getStubSettingsBuilder().listOrganizationsSettings();
    }

    /** Returns the builder for the settings used for calls to findSalesPartnerManagedClients. */
    public UnaryCallSettings.Builder<
            FindSalesPartnerManagedClientsRequest, FindSalesPartnerManagedClientsResponse>
        findSalesPartnerManagedClientsSettings() {
      return getStubSettingsBuilder().findSalesPartnerManagedClientsSettings();
    }

    /** Returns the builder for the settings used for calls to listAnalyticsAccountLinks. */
    public PagedCallSettings.Builder<
            ListAnalyticsAccountLinksRequest,
            ListAnalyticsAccountLinksResponse,
            ListAnalyticsAccountLinksPagedResponse>
        listAnalyticsAccountLinksSettings() {
      return getStubSettingsBuilder().listAnalyticsAccountLinksSettings();
    }

    /** Returns the builder for the settings used for calls to createAnalyticsAccountLink. */
    public UnaryCallSettings.Builder<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkSettings() {
      return getStubSettingsBuilder().createAnalyticsAccountLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnalyticsAccountLink. */
    public UnaryCallSettings.Builder<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkSettings() {
      return getStubSettingsBuilder().deleteAnalyticsAccountLinkSettings();
    }

    /** Returns the builder for the settings used for calls to setPropertyServiceLevel. */
    public UnaryCallSettings.Builder<
            SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelSettings() {
      return getStubSettingsBuilder().setPropertyServiceLevelSettings();
    }

    /** Returns the builder for the settings used for calls to reportPropertyUsage. */
    public UnaryCallSettings.Builder<ReportPropertyUsageRequest, ReportPropertyUsageResponse>
        reportPropertyUsageSettings() {
      return getStubSettingsBuilder().reportPropertyUsageSettings();
    }

    /** Returns the builder for the settings used for calls to getUserGroup. */
    public UnaryCallSettings.Builder<GetUserGroupRequest, UserGroup> getUserGroupSettings() {
      return getStubSettingsBuilder().getUserGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listUserGroups. */
    public PagedCallSettings.Builder<
            ListUserGroupsRequest, ListUserGroupsResponse, ListUserGroupsPagedResponse>
        listUserGroupsSettings() {
      return getStubSettingsBuilder().listUserGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to createUserGroup. */
    public UnaryCallSettings.Builder<CreateUserGroupRequest, UserGroup> createUserGroupSettings() {
      return getStubSettingsBuilder().createUserGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateUserGroup. */
    public UnaryCallSettings.Builder<UpdateUserGroupRequest, UserGroup> updateUserGroupSettings() {
      return getStubSettingsBuilder().updateUserGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUserGroup. */
    public UnaryCallSettings.Builder<DeleteUserGroupRequest, Empty> deleteUserGroupSettings() {
      return getStubSettingsBuilder().deleteUserGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getUserGroupMember. */
    public UnaryCallSettings.Builder<GetUserGroupMemberRequest, UserGroupMember>
        getUserGroupMemberSettings() {
      return getStubSettingsBuilder().getUserGroupMemberSettings();
    }

    /** Returns the builder for the settings used for calls to listUserGroupMembers. */
    public PagedCallSettings.Builder<
            ListUserGroupMembersRequest,
            ListUserGroupMembersResponse,
            ListUserGroupMembersPagedResponse>
        listUserGroupMembersSettings() {
      return getStubSettingsBuilder().listUserGroupMembersSettings();
    }

    /** Returns the builder for the settings used for calls to createUserGroupMember. */
    public UnaryCallSettings.Builder<CreateUserGroupMemberRequest, UserGroupMember>
        createUserGroupMemberSettings() {
      return getStubSettingsBuilder().createUserGroupMemberSettings();
    }

    /** Returns the builder for the settings used for calls to updateUserGroupMember. */
    public UnaryCallSettings.Builder<UpdateUserGroupMemberRequest, UserGroupMember>
        updateUserGroupMemberSettings() {
      return getStubSettingsBuilder().updateUserGroupMemberSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUserGroupMember. */
    public UnaryCallSettings.Builder<DeleteUserGroupMemberRequest, Empty>
        deleteUserGroupMemberSettings() {
      return getStubSettingsBuilder().deleteUserGroupMemberSettings();
    }

    /** Returns the builder for the settings used for calls to getAdminAccessBinding. */
    public UnaryCallSettings.Builder<GetAdminAccessBindingRequest, AdminAccessBinding>
        getAdminAccessBindingSettings() {
      return getStubSettingsBuilder().getAdminAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to listAdminAccessBindings. */
    public PagedCallSettings.Builder<
            ListAdminAccessBindingsRequest,
            ListAdminAccessBindingsResponse,
            ListAdminAccessBindingsPagedResponse>
        listAdminAccessBindingsSettings() {
      return getStubSettingsBuilder().listAdminAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to createAdminAccessBinding. */
    public UnaryCallSettings.Builder<CreateAdminAccessBindingRequest, AdminAccessBinding>
        createAdminAccessBindingSettings() {
      return getStubSettingsBuilder().createAdminAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateAdminAccessBinding. */
    public UnaryCallSettings.Builder<UpdateAdminAccessBindingRequest, AdminAccessBinding>
        updateAdminAccessBindingSettings() {
      return getStubSettingsBuilder().updateAdminAccessBindingSettings();
    }

    @Override
    public MarketingplatformAdminServiceSettings build() throws IOException {
      return new MarketingplatformAdminServiceSettings(this);
    }
  }
}
