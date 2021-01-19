/*
 * Copyright 2020 Google LLC
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

package com.google.analytics.admin.v1alpha;

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.AuditUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAndroidAppDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListIosAppDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListWebDataStreamsPagedResponse;

import com.google.analytics.admin.v1alpha.stub.AnalyticsAdminServiceStubSettings;
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
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AnalyticsAdminServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (analyticsadmin.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAccount to 30 seconds:
 *
 * <pre>{@code
 * AnalyticsAdminServiceSettings.Builder analyticsAdminServiceSettingsBuilder =
 *     AnalyticsAdminServiceSettings.newBuilder();
 * analyticsAdminServiceSettingsBuilder
 *     .getAccountSettings()
 *     .setRetrySettings(
 *         analyticsAdminServiceSettingsBuilder
 *             .getAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AnalyticsAdminServiceSettings analyticsAdminServiceSettings =
 *     analyticsAdminServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AnalyticsAdminServiceSettings extends ClientSettings<AnalyticsAdminServiceSettings> {

  /** Returns the object with the settings used for calls to getAccount. */
  public UnaryCallSettings<GetAccountRequest, Account> getAccountSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getAccountSettings();
  }

  /** Returns the object with the settings used for calls to listAccounts. */
  public PagedCallSettings<ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
      listAccountsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listAccountsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccount. */
  public UnaryCallSettings<DeleteAccountRequest, Empty> deleteAccountSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteAccountSettings();
  }

  /** Returns the object with the settings used for calls to updateAccount. */
  public UnaryCallSettings<UpdateAccountRequest, Account> updateAccountSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateAccountSettings();
  }

  /** Returns the object with the settings used for calls to provisionAccountTicket. */
  public UnaryCallSettings<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).provisionAccountTicketSettings();
  }

  /** Returns the object with the settings used for calls to listAccountSummaries. */
  public PagedCallSettings<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          ListAccountSummariesPagedResponse>
      listAccountSummariesSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listAccountSummariesSettings();
  }

  /** Returns the object with the settings used for calls to getProperty. */
  public UnaryCallSettings<GetPropertyRequest, Property> getPropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getPropertySettings();
  }

  /** Returns the object with the settings used for calls to listProperties. */
  public PagedCallSettings<
          ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
      listPropertiesSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listPropertiesSettings();
  }

  /** Returns the object with the settings used for calls to createProperty. */
  public UnaryCallSettings<CreatePropertyRequest, Property> createPropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createPropertySettings();
  }

  /** Returns the object with the settings used for calls to deleteProperty. */
  public UnaryCallSettings<DeletePropertyRequest, Empty> deletePropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deletePropertySettings();
  }

  /** Returns the object with the settings used for calls to updateProperty. */
  public UnaryCallSettings<UpdatePropertyRequest, Property> updatePropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updatePropertySettings();
  }

  /** Returns the object with the settings used for calls to getUserLink. */
  public UnaryCallSettings<GetUserLinkRequest, UserLink> getUserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getUserLinkSettings();
  }

  /** Returns the object with the settings used for calls to batchGetUserLinks. */
  public UnaryCallSettings<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).batchGetUserLinksSettings();
  }

  /** Returns the object with the settings used for calls to listUserLinks. */
  public PagedCallSettings<ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
      listUserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listUserLinksSettings();
  }

  /** Returns the object with the settings used for calls to auditUserLinks. */
  public PagedCallSettings<
          AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
      auditUserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).auditUserLinksSettings();
  }

  /** Returns the object with the settings used for calls to createUserLink. */
  public UnaryCallSettings<CreateUserLinkRequest, UserLink> createUserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createUserLinkSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateUserLinks. */
  public UnaryCallSettings<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).batchCreateUserLinksSettings();
  }

  /** Returns the object with the settings used for calls to updateUserLink. */
  public UnaryCallSettings<UpdateUserLinkRequest, UserLink> updateUserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateUserLinkSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateUserLinks. */
  public UnaryCallSettings<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).batchUpdateUserLinksSettings();
  }

  /** Returns the object with the settings used for calls to deleteUserLink. */
  public UnaryCallSettings<DeleteUserLinkRequest, Empty> deleteUserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteUserLinkSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteUserLinks. */
  public UnaryCallSettings<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).batchDeleteUserLinksSettings();
  }

  /** Returns the object with the settings used for calls to getWebDataStream. */
  public UnaryCallSettings<GetWebDataStreamRequest, WebDataStream> getWebDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getWebDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to deleteWebDataStream. */
  public UnaryCallSettings<DeleteWebDataStreamRequest, Empty> deleteWebDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteWebDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to updateWebDataStream. */
  public UnaryCallSettings<UpdateWebDataStreamRequest, WebDataStream>
      updateWebDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateWebDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to createWebDataStream. */
  public UnaryCallSettings<CreateWebDataStreamRequest, WebDataStream>
      createWebDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createWebDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to listWebDataStreams. */
  public PagedCallSettings<
          ListWebDataStreamsRequest, ListWebDataStreamsResponse, ListWebDataStreamsPagedResponse>
      listWebDataStreamsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listWebDataStreamsSettings();
  }

  /** Returns the object with the settings used for calls to getIosAppDataStream. */
  public UnaryCallSettings<GetIosAppDataStreamRequest, IosAppDataStream>
      getIosAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getIosAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to deleteIosAppDataStream. */
  public UnaryCallSettings<DeleteIosAppDataStreamRequest, Empty> deleteIosAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteIosAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to updateIosAppDataStream. */
  public UnaryCallSettings<UpdateIosAppDataStreamRequest, IosAppDataStream>
      updateIosAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateIosAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to createIosAppDataStream. */
  public UnaryCallSettings<CreateIosAppDataStreamRequest, IosAppDataStream>
      createIosAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createIosAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to listIosAppDataStreams. */
  public PagedCallSettings<
          ListIosAppDataStreamsRequest,
          ListIosAppDataStreamsResponse,
          ListIosAppDataStreamsPagedResponse>
      listIosAppDataStreamsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listIosAppDataStreamsSettings();
  }

  /** Returns the object with the settings used for calls to getAndroidAppDataStream. */
  public UnaryCallSettings<GetAndroidAppDataStreamRequest, AndroidAppDataStream>
      getAndroidAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getAndroidAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to deleteAndroidAppDataStream. */
  public UnaryCallSettings<DeleteAndroidAppDataStreamRequest, Empty>
      deleteAndroidAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteAndroidAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to updateAndroidAppDataStream. */
  public UnaryCallSettings<UpdateAndroidAppDataStreamRequest, AndroidAppDataStream>
      updateAndroidAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateAndroidAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to createAndroidAppDataStream. */
  public UnaryCallSettings<CreateAndroidAppDataStreamRequest, AndroidAppDataStream>
      createAndroidAppDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createAndroidAppDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to listAndroidAppDataStreams. */
  public PagedCallSettings<
          ListAndroidAppDataStreamsRequest,
          ListAndroidAppDataStreamsResponse,
          ListAndroidAppDataStreamsPagedResponse>
      listAndroidAppDataStreamsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listAndroidAppDataStreamsSettings();
  }

  /** Returns the object with the settings used for calls to getEnhancedMeasurementSettings. */
  public UnaryCallSettings<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getEnhancedMeasurementSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateEnhancedMeasurementSettings. */
  public UnaryCallSettings<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateEnhancedMeasurementSettingsSettings();
  }

  /** Returns the object with the settings used for calls to createFirebaseLink. */
  public UnaryCallSettings<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createFirebaseLinkSettings();
  }

  /** Returns the object with the settings used for calls to updateFirebaseLink. */
  public UnaryCallSettings<UpdateFirebaseLinkRequest, FirebaseLink> updateFirebaseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateFirebaseLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteFirebaseLink. */
  public UnaryCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteFirebaseLinkSettings();
  }

  /** Returns the object with the settings used for calls to listFirebaseLinks. */
  public PagedCallSettings<
          ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
      listFirebaseLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listFirebaseLinksSettings();
  }

  /** Returns the object with the settings used for calls to getGlobalSiteTag. */
  public UnaryCallSettings<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getGlobalSiteTagSettings();
  }

  /** Returns the object with the settings used for calls to createGoogleAdsLink. */
  public UnaryCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createGoogleAdsLinkSettings();
  }

  /** Returns the object with the settings used for calls to updateGoogleAdsLink. */
  public UnaryCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateGoogleAdsLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteGoogleAdsLink. */
  public UnaryCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteGoogleAdsLinkSettings();
  }

  /** Returns the object with the settings used for calls to listGoogleAdsLinks. */
  public PagedCallSettings<
          ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listGoogleAdsLinksSettings();
  }

  /** Returns the object with the settings used for calls to getDataSharingSettings. */
  public UnaryCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getDataSharingSettingsSettings();
  }

  public static final AnalyticsAdminServiceSettings create(AnalyticsAdminServiceStubSettings stub)
      throws IOException {
    return new AnalyticsAdminServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AnalyticsAdminServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AnalyticsAdminServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AnalyticsAdminServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AnalyticsAdminServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AnalyticsAdminServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AnalyticsAdminServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AnalyticsAdminServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AnalyticsAdminServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AnalyticsAdminServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AnalyticsAdminServiceStubSettings.newBuilder());
    }

    public AnalyticsAdminServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AnalyticsAdminServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getAccount. */
    public UnaryCallSettings.Builder<GetAccountRequest, Account> getAccountSettings() {
      return getStubSettingsBuilder().getAccountSettings();
    }

    /** Returns the builder for the settings used for calls to listAccounts. */
    public PagedCallSettings.Builder<
            ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
        listAccountsSettings() {
      return getStubSettingsBuilder().listAccountsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccount. */
    public UnaryCallSettings.Builder<DeleteAccountRequest, Empty> deleteAccountSettings() {
      return getStubSettingsBuilder().deleteAccountSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccount. */
    public UnaryCallSettings.Builder<UpdateAccountRequest, Account> updateAccountSettings() {
      return getStubSettingsBuilder().updateAccountSettings();
    }

    /** Returns the builder for the settings used for calls to provisionAccountTicket. */
    public UnaryCallSettings.Builder<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
        provisionAccountTicketSettings() {
      return getStubSettingsBuilder().provisionAccountTicketSettings();
    }

    /** Returns the builder for the settings used for calls to listAccountSummaries. */
    public PagedCallSettings.Builder<
            ListAccountSummariesRequest,
            ListAccountSummariesResponse,
            ListAccountSummariesPagedResponse>
        listAccountSummariesSettings() {
      return getStubSettingsBuilder().listAccountSummariesSettings();
    }

    /** Returns the builder for the settings used for calls to getProperty. */
    public UnaryCallSettings.Builder<GetPropertyRequest, Property> getPropertySettings() {
      return getStubSettingsBuilder().getPropertySettings();
    }

    /** Returns the builder for the settings used for calls to listProperties. */
    public PagedCallSettings.Builder<
            ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
        listPropertiesSettings() {
      return getStubSettingsBuilder().listPropertiesSettings();
    }

    /** Returns the builder for the settings used for calls to createProperty. */
    public UnaryCallSettings.Builder<CreatePropertyRequest, Property> createPropertySettings() {
      return getStubSettingsBuilder().createPropertySettings();
    }

    /** Returns the builder for the settings used for calls to deleteProperty. */
    public UnaryCallSettings.Builder<DeletePropertyRequest, Empty> deletePropertySettings() {
      return getStubSettingsBuilder().deletePropertySettings();
    }

    /** Returns the builder for the settings used for calls to updateProperty. */
    public UnaryCallSettings.Builder<UpdatePropertyRequest, Property> updatePropertySettings() {
      return getStubSettingsBuilder().updatePropertySettings();
    }

    /** Returns the builder for the settings used for calls to getUserLink. */
    public UnaryCallSettings.Builder<GetUserLinkRequest, UserLink> getUserLinkSettings() {
      return getStubSettingsBuilder().getUserLinkSettings();
    }

    /** Returns the builder for the settings used for calls to batchGetUserLinks. */
    public UnaryCallSettings.Builder<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
        batchGetUserLinksSettings() {
      return getStubSettingsBuilder().batchGetUserLinksSettings();
    }

    /** Returns the builder for the settings used for calls to listUserLinks. */
    public PagedCallSettings.Builder<
            ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
        listUserLinksSettings() {
      return getStubSettingsBuilder().listUserLinksSettings();
    }

    /** Returns the builder for the settings used for calls to auditUserLinks. */
    public PagedCallSettings.Builder<
            AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
        auditUserLinksSettings() {
      return getStubSettingsBuilder().auditUserLinksSettings();
    }

    /** Returns the builder for the settings used for calls to createUserLink. */
    public UnaryCallSettings.Builder<CreateUserLinkRequest, UserLink> createUserLinkSettings() {
      return getStubSettingsBuilder().createUserLinkSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateUserLinks. */
    public UnaryCallSettings.Builder<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
        batchCreateUserLinksSettings() {
      return getStubSettingsBuilder().batchCreateUserLinksSettings();
    }

    /** Returns the builder for the settings used for calls to updateUserLink. */
    public UnaryCallSettings.Builder<UpdateUserLinkRequest, UserLink> updateUserLinkSettings() {
      return getStubSettingsBuilder().updateUserLinkSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateUserLinks. */
    public UnaryCallSettings.Builder<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
        batchUpdateUserLinksSettings() {
      return getStubSettingsBuilder().batchUpdateUserLinksSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUserLink. */
    public UnaryCallSettings.Builder<DeleteUserLinkRequest, Empty> deleteUserLinkSettings() {
      return getStubSettingsBuilder().deleteUserLinkSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteUserLinks. */
    public UnaryCallSettings.Builder<BatchDeleteUserLinksRequest, Empty>
        batchDeleteUserLinksSettings() {
      return getStubSettingsBuilder().batchDeleteUserLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getWebDataStream. */
    public UnaryCallSettings.Builder<GetWebDataStreamRequest, WebDataStream>
        getWebDataStreamSettings() {
      return getStubSettingsBuilder().getWebDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWebDataStream. */
    public UnaryCallSettings.Builder<DeleteWebDataStreamRequest, Empty>
        deleteWebDataStreamSettings() {
      return getStubSettingsBuilder().deleteWebDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to updateWebDataStream. */
    public UnaryCallSettings.Builder<UpdateWebDataStreamRequest, WebDataStream>
        updateWebDataStreamSettings() {
      return getStubSettingsBuilder().updateWebDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createWebDataStream. */
    public UnaryCallSettings.Builder<CreateWebDataStreamRequest, WebDataStream>
        createWebDataStreamSettings() {
      return getStubSettingsBuilder().createWebDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to listWebDataStreams. */
    public PagedCallSettings.Builder<
            ListWebDataStreamsRequest, ListWebDataStreamsResponse, ListWebDataStreamsPagedResponse>
        listWebDataStreamsSettings() {
      return getStubSettingsBuilder().listWebDataStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to getIosAppDataStream. */
    public UnaryCallSettings.Builder<GetIosAppDataStreamRequest, IosAppDataStream>
        getIosAppDataStreamSettings() {
      return getStubSettingsBuilder().getIosAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIosAppDataStream. */
    public UnaryCallSettings.Builder<DeleteIosAppDataStreamRequest, Empty>
        deleteIosAppDataStreamSettings() {
      return getStubSettingsBuilder().deleteIosAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to updateIosAppDataStream. */
    public UnaryCallSettings.Builder<UpdateIosAppDataStreamRequest, IosAppDataStream>
        updateIosAppDataStreamSettings() {
      return getStubSettingsBuilder().updateIosAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createIosAppDataStream. */
    public UnaryCallSettings.Builder<CreateIosAppDataStreamRequest, IosAppDataStream>
        createIosAppDataStreamSettings() {
      return getStubSettingsBuilder().createIosAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to listIosAppDataStreams. */
    public PagedCallSettings.Builder<
            ListIosAppDataStreamsRequest,
            ListIosAppDataStreamsResponse,
            ListIosAppDataStreamsPagedResponse>
        listIosAppDataStreamsSettings() {
      return getStubSettingsBuilder().listIosAppDataStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to getAndroidAppDataStream. */
    public UnaryCallSettings.Builder<GetAndroidAppDataStreamRequest, AndroidAppDataStream>
        getAndroidAppDataStreamSettings() {
      return getStubSettingsBuilder().getAndroidAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAndroidAppDataStream. */
    public UnaryCallSettings.Builder<DeleteAndroidAppDataStreamRequest, Empty>
        deleteAndroidAppDataStreamSettings() {
      return getStubSettingsBuilder().deleteAndroidAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to updateAndroidAppDataStream. */
    public UnaryCallSettings.Builder<UpdateAndroidAppDataStreamRequest, AndroidAppDataStream>
        updateAndroidAppDataStreamSettings() {
      return getStubSettingsBuilder().updateAndroidAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createAndroidAppDataStream. */
    public UnaryCallSettings.Builder<CreateAndroidAppDataStreamRequest, AndroidAppDataStream>
        createAndroidAppDataStreamSettings() {
      return getStubSettingsBuilder().createAndroidAppDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to listAndroidAppDataStreams. */
    public PagedCallSettings.Builder<
            ListAndroidAppDataStreamsRequest,
            ListAndroidAppDataStreamsResponse,
            ListAndroidAppDataStreamsPagedResponse>
        listAndroidAppDataStreamsSettings() {
      return getStubSettingsBuilder().listAndroidAppDataStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to getEnhancedMeasurementSettings. */
    public UnaryCallSettings.Builder<
            GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
        getEnhancedMeasurementSettingsSettings() {
      return getStubSettingsBuilder().getEnhancedMeasurementSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateEnhancedMeasurementSettings. */
    public UnaryCallSettings.Builder<
            UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
        updateEnhancedMeasurementSettingsSettings() {
      return getStubSettingsBuilder().updateEnhancedMeasurementSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to createFirebaseLink. */
    public UnaryCallSettings.Builder<CreateFirebaseLinkRequest, FirebaseLink>
        createFirebaseLinkSettings() {
      return getStubSettingsBuilder().createFirebaseLinkSettings();
    }

    /** Returns the builder for the settings used for calls to updateFirebaseLink. */
    public UnaryCallSettings.Builder<UpdateFirebaseLinkRequest, FirebaseLink>
        updateFirebaseLinkSettings() {
      return getStubSettingsBuilder().updateFirebaseLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFirebaseLink. */
    public UnaryCallSettings.Builder<DeleteFirebaseLinkRequest, Empty>
        deleteFirebaseLinkSettings() {
      return getStubSettingsBuilder().deleteFirebaseLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listFirebaseLinks. */
    public PagedCallSettings.Builder<
            ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
        listFirebaseLinksSettings() {
      return getStubSettingsBuilder().listFirebaseLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getGlobalSiteTag. */
    public UnaryCallSettings.Builder<GetGlobalSiteTagRequest, GlobalSiteTag>
        getGlobalSiteTagSettings() {
      return getStubSettingsBuilder().getGlobalSiteTagSettings();
    }

    /** Returns the builder for the settings used for calls to createGoogleAdsLink. */
    public UnaryCallSettings.Builder<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkSettings() {
      return getStubSettingsBuilder().createGoogleAdsLinkSettings();
    }

    /** Returns the builder for the settings used for calls to updateGoogleAdsLink. */
    public UnaryCallSettings.Builder<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkSettings() {
      return getStubSettingsBuilder().updateGoogleAdsLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGoogleAdsLink. */
    public UnaryCallSettings.Builder<DeleteGoogleAdsLinkRequest, Empty>
        deleteGoogleAdsLinkSettings() {
      return getStubSettingsBuilder().deleteGoogleAdsLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listGoogleAdsLinks. */
    public PagedCallSettings.Builder<
            ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
        listGoogleAdsLinksSettings() {
      return getStubSettingsBuilder().listGoogleAdsLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getDataSharingSettings. */
    public UnaryCallSettings.Builder<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsSettings() {
      return getStubSettingsBuilder().getDataSharingSettingsSettings();
    }

    @Override
    public AnalyticsAdminServiceSettings build() throws IOException {
      return new AnalyticsAdminServiceSettings(this);
    }
  }
}
