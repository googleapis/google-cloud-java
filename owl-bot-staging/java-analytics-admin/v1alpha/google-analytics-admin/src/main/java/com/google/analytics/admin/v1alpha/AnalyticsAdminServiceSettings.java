/*
 * Copyright 2023 Google LLC
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

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccessBindingsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAdSenseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAudiencesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListBigQueryLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCalculatedMetricsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListChannelGroupsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListConversionEventsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomDimensionsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomMetricsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinkProposalsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListEventCreateRulesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListExpandedDataSetsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListMeasurementProtocolSecretsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListRollupPropertySourceLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListSKAdNetworkConversionValueSchemasPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListSearchAds360LinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListSubpropertyEventFiltersPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.SearchChangeHistoryEventsPagedResponse;

import com.google.analytics.admin.v1alpha.stub.AnalyticsAdminServiceStubSettings;
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
import com.google.api.gax.rpc.StubSettings;
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
  public UnaryCallSettings<DeletePropertyRequest, Property> deletePropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deletePropertySettings();
  }

  /** Returns the object with the settings used for calls to updateProperty. */
  public UnaryCallSettings<UpdatePropertyRequest, Property> updatePropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updatePropertySettings();
  }

  /** Returns the object with the settings used for calls to createFirebaseLink. */
  public UnaryCallSettings<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createFirebaseLinkSettings();
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

  /** Returns the object with the settings used for calls to getMeasurementProtocolSecret. */
  public UnaryCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getMeasurementProtocolSecretSettings();
  }

  /** Returns the object with the settings used for calls to listMeasurementProtocolSecrets. */
  public PagedCallSettings<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listMeasurementProtocolSecretsSettings();
  }

  /** Returns the object with the settings used for calls to createMeasurementProtocolSecret. */
  public UnaryCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createMeasurementProtocolSecretSettings();
  }

  /** Returns the object with the settings used for calls to deleteMeasurementProtocolSecret. */
  public UnaryCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteMeasurementProtocolSecretSettings();
  }

  /** Returns the object with the settings used for calls to updateMeasurementProtocolSecret. */
  public UnaryCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateMeasurementProtocolSecretSettings();
  }

  /** Returns the object with the settings used for calls to acknowledgeUserDataCollection. */
  public UnaryCallSettings<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .acknowledgeUserDataCollectionSettings();
  }

  /** Returns the object with the settings used for calls to getSKAdNetworkConversionValueSchema. */
  public UnaryCallSettings<
          GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getSKAdNetworkConversionValueSchemaSettings();
  }

  /**
   * Returns the object with the settings used for calls to createSKAdNetworkConversionValueSchema.
   */
  public UnaryCallSettings<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createSKAdNetworkConversionValueSchemaSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteSKAdNetworkConversionValueSchema.
   */
  public UnaryCallSettings<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteSKAdNetworkConversionValueSchemaSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateSKAdNetworkConversionValueSchema.
   */
  public UnaryCallSettings<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateSKAdNetworkConversionValueSchemaSettings();
  }

  /**
   * Returns the object with the settings used for calls to listSKAdNetworkConversionValueSchemas.
   */
  public PagedCallSettings<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse,
          ListSKAdNetworkConversionValueSchemasPagedResponse>
      listSKAdNetworkConversionValueSchemasSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listSKAdNetworkConversionValueSchemasSettings();
  }

  /** Returns the object with the settings used for calls to searchChangeHistoryEvents. */
  public PagedCallSettings<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .searchChangeHistoryEventsSettings();
  }

  /** Returns the object with the settings used for calls to getGoogleSignalsSettings. */
  public UnaryCallSettings<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getGoogleSignalsSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateGoogleSignalsSettings. */
  public UnaryCallSettings<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateGoogleSignalsSettingsSettings();
  }

  /** Returns the object with the settings used for calls to createConversionEvent. */
  public UnaryCallSettings<CreateConversionEventRequest, ConversionEvent>
      createConversionEventSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createConversionEventSettings();
  }

  /** Returns the object with the settings used for calls to updateConversionEvent. */
  public UnaryCallSettings<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateConversionEventSettings();
  }

  /** Returns the object with the settings used for calls to getConversionEvent. */
  public UnaryCallSettings<GetConversionEventRequest, ConversionEvent>
      getConversionEventSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getConversionEventSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversionEvent. */
  public UnaryCallSettings<DeleteConversionEventRequest, Empty> deleteConversionEventSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteConversionEventSettings();
  }

  /** Returns the object with the settings used for calls to listConversionEvents. */
  public PagedCallSettings<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ListConversionEventsPagedResponse>
      listConversionEventsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listConversionEventsSettings();
  }

  /** Returns the object with the settings used for calls to getDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getDisplayVideo360AdvertiserLinkSettings();
  }

  /** Returns the object with the settings used for calls to listDisplayVideo360AdvertiserLinks. */
  public PagedCallSettings<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listDisplayVideo360AdvertiserLinksSettings();
  }

  /** Returns the object with the settings used for calls to createDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createDisplayVideo360AdvertiserLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteDisplayVideo360AdvertiserLinkSettings();
  }

  /** Returns the object with the settings used for calls to updateDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateDisplayVideo360AdvertiserLinkSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * getDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getDisplayVideo360AdvertiserLinkProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listDisplayVideo360AdvertiserLinkProposals.
   */
  public PagedCallSettings<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      listDisplayVideo360AdvertiserLinkProposalsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listDisplayVideo360AdvertiserLinkProposalsSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * createDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createDisplayVideo360AdvertiserLinkProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * deleteDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteDisplayVideo360AdvertiserLinkProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * approveDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .approveDisplayVideo360AdvertiserLinkProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * cancelDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .cancelDisplayVideo360AdvertiserLinkProposalSettings();
  }

  /** Returns the object with the settings used for calls to createCustomDimension. */
  public UnaryCallSettings<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createCustomDimensionSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomDimension. */
  public UnaryCallSettings<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateCustomDimensionSettings();
  }

  /** Returns the object with the settings used for calls to listCustomDimensions. */
  public PagedCallSettings<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          ListCustomDimensionsPagedResponse>
      listCustomDimensionsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listCustomDimensionsSettings();
  }

  /** Returns the object with the settings used for calls to archiveCustomDimension. */
  public UnaryCallSettings<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).archiveCustomDimensionSettings();
  }

  /** Returns the object with the settings used for calls to getCustomDimension. */
  public UnaryCallSettings<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getCustomDimensionSettings();
  }

  /** Returns the object with the settings used for calls to createCustomMetric. */
  public UnaryCallSettings<CreateCustomMetricRequest, CustomMetric> createCustomMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createCustomMetricSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomMetric. */
  public UnaryCallSettings<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateCustomMetricSettings();
  }

  /** Returns the object with the settings used for calls to listCustomMetrics. */
  public PagedCallSettings<
          ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
      listCustomMetricsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listCustomMetricsSettings();
  }

  /** Returns the object with the settings used for calls to archiveCustomMetric. */
  public UnaryCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).archiveCustomMetricSettings();
  }

  /** Returns the object with the settings used for calls to getCustomMetric. */
  public UnaryCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getCustomMetricSettings();
  }

  /** Returns the object with the settings used for calls to getDataRetentionSettings. */
  public UnaryCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getDataRetentionSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateDataRetentionSettings. */
  public UnaryCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateDataRetentionSettingsSettings();
  }

  /** Returns the object with the settings used for calls to createDataStream. */
  public UnaryCallSettings<CreateDataStreamRequest, DataStream> createDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataStream. */
  public UnaryCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to updateDataStream. */
  public UnaryCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to listDataStreams. */
  public PagedCallSettings<
          ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
      listDataStreamsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listDataStreamsSettings();
  }

  /** Returns the object with the settings used for calls to getDataStream. */
  public UnaryCallSettings<GetDataStreamRequest, DataStream> getDataStreamSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getDataStreamSettings();
  }

  /** Returns the object with the settings used for calls to getAudience. */
  public UnaryCallSettings<GetAudienceRequest, Audience> getAudienceSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getAudienceSettings();
  }

  /** Returns the object with the settings used for calls to listAudiences. */
  public PagedCallSettings<ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
      listAudiencesSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listAudiencesSettings();
  }

  /** Returns the object with the settings used for calls to createAudience. */
  public UnaryCallSettings<CreateAudienceRequest, Audience> createAudienceSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createAudienceSettings();
  }

  /** Returns the object with the settings used for calls to updateAudience. */
  public UnaryCallSettings<UpdateAudienceRequest, Audience> updateAudienceSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateAudienceSettings();
  }

  /** Returns the object with the settings used for calls to archiveAudience. */
  public UnaryCallSettings<ArchiveAudienceRequest, Empty> archiveAudienceSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).archiveAudienceSettings();
  }

  /** Returns the object with the settings used for calls to getSearchAds360Link. */
  public UnaryCallSettings<GetSearchAds360LinkRequest, SearchAds360Link>
      getSearchAds360LinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getSearchAds360LinkSettings();
  }

  /** Returns the object with the settings used for calls to listSearchAds360Links. */
  public PagedCallSettings<
          ListSearchAds360LinksRequest,
          ListSearchAds360LinksResponse,
          ListSearchAds360LinksPagedResponse>
      listSearchAds360LinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listSearchAds360LinksSettings();
  }

  /** Returns the object with the settings used for calls to createSearchAds360Link. */
  public UnaryCallSettings<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createSearchAds360LinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteSearchAds360Link. */
  public UnaryCallSettings<DeleteSearchAds360LinkRequest, Empty> deleteSearchAds360LinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteSearchAds360LinkSettings();
  }

  /** Returns the object with the settings used for calls to updateSearchAds360Link. */
  public UnaryCallSettings<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateSearchAds360LinkSettings();
  }

  /** Returns the object with the settings used for calls to getAttributionSettings. */
  public UnaryCallSettings<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getAttributionSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateAttributionSettings. */
  public UnaryCallSettings<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateAttributionSettingsSettings();
  }

  /** Returns the object with the settings used for calls to runAccessReport. */
  public UnaryCallSettings<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).runAccessReportSettings();
  }

  /** Returns the object with the settings used for calls to createAccessBinding. */
  public UnaryCallSettings<CreateAccessBindingRequest, AccessBinding>
      createAccessBindingSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to getAccessBinding. */
  public UnaryCallSettings<GetAccessBindingRequest, AccessBinding> getAccessBindingSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessBinding. */
  public UnaryCallSettings<UpdateAccessBindingRequest, AccessBinding>
      updateAccessBindingSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessBinding. */
  public UnaryCallSettings<DeleteAccessBindingRequest, Empty> deleteAccessBindingSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteAccessBindingSettings();
  }

  /** Returns the object with the settings used for calls to listAccessBindings. */
  public PagedCallSettings<
          ListAccessBindingsRequest, ListAccessBindingsResponse, ListAccessBindingsPagedResponse>
      listAccessBindingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateAccessBindings. */
  public UnaryCallSettings<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .batchCreateAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to batchGetAccessBindings. */
  public UnaryCallSettings<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).batchGetAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateAccessBindings. */
  public UnaryCallSettings<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .batchUpdateAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteAccessBindings. */
  public UnaryCallSettings<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .batchDeleteAccessBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getExpandedDataSet. */
  public UnaryCallSettings<GetExpandedDataSetRequest, ExpandedDataSet>
      getExpandedDataSetSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getExpandedDataSetSettings();
  }

  /** Returns the object with the settings used for calls to listExpandedDataSets. */
  public PagedCallSettings<
          ListExpandedDataSetsRequest,
          ListExpandedDataSetsResponse,
          ListExpandedDataSetsPagedResponse>
      listExpandedDataSetsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listExpandedDataSetsSettings();
  }

  /** Returns the object with the settings used for calls to createExpandedDataSet. */
  public UnaryCallSettings<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createExpandedDataSetSettings();
  }

  /** Returns the object with the settings used for calls to updateExpandedDataSet. */
  public UnaryCallSettings<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateExpandedDataSetSettings();
  }

  /** Returns the object with the settings used for calls to deleteExpandedDataSet. */
  public UnaryCallSettings<DeleteExpandedDataSetRequest, Empty> deleteExpandedDataSetSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteExpandedDataSetSettings();
  }

  /** Returns the object with the settings used for calls to getChannelGroup. */
  public UnaryCallSettings<GetChannelGroupRequest, ChannelGroup> getChannelGroupSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getChannelGroupSettings();
  }

  /** Returns the object with the settings used for calls to listChannelGroups. */
  public PagedCallSettings<
          ListChannelGroupsRequest, ListChannelGroupsResponse, ListChannelGroupsPagedResponse>
      listChannelGroupsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listChannelGroupsSettings();
  }

  /** Returns the object with the settings used for calls to createChannelGroup. */
  public UnaryCallSettings<CreateChannelGroupRequest, ChannelGroup> createChannelGroupSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createChannelGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateChannelGroup. */
  public UnaryCallSettings<UpdateChannelGroupRequest, ChannelGroup> updateChannelGroupSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateChannelGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannelGroup. */
  public UnaryCallSettings<DeleteChannelGroupRequest, Empty> deleteChannelGroupSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteChannelGroupSettings();
  }

  /** Returns the object with the settings used for calls to setAutomatedGa4ConfigurationOptOut. */
  public UnaryCallSettings<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .setAutomatedGa4ConfigurationOptOutSettings();
  }

  /**
   * Returns the object with the settings used for calls to fetchAutomatedGa4ConfigurationOptOut.
   */
  public UnaryCallSettings<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .fetchAutomatedGa4ConfigurationOptOutSettings();
  }

  /** Returns the object with the settings used for calls to getBigQueryLink. */
  public UnaryCallSettings<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getBigQueryLinkSettings();
  }

  /** Returns the object with the settings used for calls to listBigQueryLinks. */
  public PagedCallSettings<
          ListBigQueryLinksRequest, ListBigQueryLinksResponse, ListBigQueryLinksPagedResponse>
      listBigQueryLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listBigQueryLinksSettings();
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

  /** Returns the object with the settings used for calls to createConnectedSiteTag. */
  public UnaryCallSettings<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createConnectedSiteTagSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnectedSiteTag. */
  public UnaryCallSettings<DeleteConnectedSiteTagRequest, Empty> deleteConnectedSiteTagSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteConnectedSiteTagSettings();
  }

  /** Returns the object with the settings used for calls to listConnectedSiteTags. */
  public UnaryCallSettings<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listConnectedSiteTagsSettings();
  }

  /** Returns the object with the settings used for calls to fetchConnectedGa4Property. */
  public UnaryCallSettings<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .fetchConnectedGa4PropertySettings();
  }

  /** Returns the object with the settings used for calls to getAdSenseLink. */
  public UnaryCallSettings<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getAdSenseLinkSettings();
  }

  /** Returns the object with the settings used for calls to createAdSenseLink. */
  public UnaryCallSettings<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createAdSenseLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteAdSenseLink. */
  public UnaryCallSettings<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteAdSenseLinkSettings();
  }

  /** Returns the object with the settings used for calls to listAdSenseLinks. */
  public PagedCallSettings<
          ListAdSenseLinksRequest, ListAdSenseLinksResponse, ListAdSenseLinksPagedResponse>
      listAdSenseLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listAdSenseLinksSettings();
  }

  /** Returns the object with the settings used for calls to getEventCreateRule. */
  public UnaryCallSettings<GetEventCreateRuleRequest, EventCreateRule>
      getEventCreateRuleSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getEventCreateRuleSettings();
  }

  /** Returns the object with the settings used for calls to listEventCreateRules. */
  public PagedCallSettings<
          ListEventCreateRulesRequest,
          ListEventCreateRulesResponse,
          ListEventCreateRulesPagedResponse>
      listEventCreateRulesSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listEventCreateRulesSettings();
  }

  /** Returns the object with the settings used for calls to createEventCreateRule. */
  public UnaryCallSettings<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createEventCreateRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateEventCreateRule. */
  public UnaryCallSettings<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateEventCreateRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteEventCreateRule. */
  public UnaryCallSettings<DeleteEventCreateRuleRequest, Empty> deleteEventCreateRuleSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteEventCreateRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateDataRedactionSettings. */
  public UnaryCallSettings<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateDataRedactionSettingsSettings();
  }

  /** Returns the object with the settings used for calls to getDataRedactionSettings. */
  public UnaryCallSettings<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getDataRedactionSettingsSettings();
  }

  /** Returns the object with the settings used for calls to getCalculatedMetric. */
  public UnaryCallSettings<GetCalculatedMetricRequest, CalculatedMetric>
      getCalculatedMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).getCalculatedMetricSettings();
  }

  /** Returns the object with the settings used for calls to createCalculatedMetric. */
  public UnaryCallSettings<CreateCalculatedMetricRequest, CalculatedMetric>
      createCalculatedMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createCalculatedMetricSettings();
  }

  /** Returns the object with the settings used for calls to listCalculatedMetrics. */
  public PagedCallSettings<
          ListCalculatedMetricsRequest,
          ListCalculatedMetricsResponse,
          ListCalculatedMetricsPagedResponse>
      listCalculatedMetricsSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).listCalculatedMetricsSettings();
  }

  /** Returns the object with the settings used for calls to updateCalculatedMetric. */
  public UnaryCallSettings<UpdateCalculatedMetricRequest, CalculatedMetric>
      updateCalculatedMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).updateCalculatedMetricSettings();
  }

  /** Returns the object with the settings used for calls to deleteCalculatedMetric. */
  public UnaryCallSettings<DeleteCalculatedMetricRequest, Empty> deleteCalculatedMetricSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).deleteCalculatedMetricSettings();
  }

  /** Returns the object with the settings used for calls to createRollupProperty. */
  public UnaryCallSettings<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createRollupPropertySettings();
  }

  /** Returns the object with the settings used for calls to getRollupPropertySourceLink. */
  public UnaryCallSettings<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getRollupPropertySourceLinkSettings();
  }

  /** Returns the object with the settings used for calls to listRollupPropertySourceLinks. */
  public PagedCallSettings<
          ListRollupPropertySourceLinksRequest,
          ListRollupPropertySourceLinksResponse,
          ListRollupPropertySourceLinksPagedResponse>
      listRollupPropertySourceLinksSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listRollupPropertySourceLinksSettings();
  }

  /** Returns the object with the settings used for calls to createRollupPropertySourceLink. */
  public UnaryCallSettings<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createRollupPropertySourceLinkSettings();
  }

  /** Returns the object with the settings used for calls to deleteRollupPropertySourceLink. */
  public UnaryCallSettings<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteRollupPropertySourceLinkSettings();
  }

  /** Returns the object with the settings used for calls to createSubproperty. */
  public UnaryCallSettings<CreateSubpropertyRequest, CreateSubpropertyResponse>
      createSubpropertySettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings()).createSubpropertySettings();
  }

  /** Returns the object with the settings used for calls to createSubpropertyEventFilter. */
  public UnaryCallSettings<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .createSubpropertyEventFilterSettings();
  }

  /** Returns the object with the settings used for calls to getSubpropertyEventFilter. */
  public UnaryCallSettings<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .getSubpropertyEventFilterSettings();
  }

  /** Returns the object with the settings used for calls to listSubpropertyEventFilters. */
  public PagedCallSettings<
          ListSubpropertyEventFiltersRequest,
          ListSubpropertyEventFiltersResponse,
          ListSubpropertyEventFiltersPagedResponse>
      listSubpropertyEventFiltersSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .listSubpropertyEventFiltersSettings();
  }

  /** Returns the object with the settings used for calls to updateSubpropertyEventFilter. */
  public UnaryCallSettings<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .updateSubpropertyEventFilterSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubpropertyEventFilter. */
  public UnaryCallSettings<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterSettings() {
    return ((AnalyticsAdminServiceStubSettings) getStubSettings())
        .deleteSubpropertyEventFilterSettings();
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AnalyticsAdminServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
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

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AnalyticsAdminServiceStubSettings.newHttpJsonBuilder());
    }

    public AnalyticsAdminServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AnalyticsAdminServiceStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<DeletePropertyRequest, Property> deletePropertySettings() {
      return getStubSettingsBuilder().deletePropertySettings();
    }

    /** Returns the builder for the settings used for calls to updateProperty. */
    public UnaryCallSettings.Builder<UpdatePropertyRequest, Property> updatePropertySettings() {
      return getStubSettingsBuilder().updatePropertySettings();
    }

    /** Returns the builder for the settings used for calls to createFirebaseLink. */
    public UnaryCallSettings.Builder<CreateFirebaseLinkRequest, FirebaseLink>
        createFirebaseLinkSettings() {
      return getStubSettingsBuilder().createFirebaseLinkSettings();
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

    /** Returns the builder for the settings used for calls to getMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretSettings() {
      return getStubSettingsBuilder().getMeasurementProtocolSecretSettings();
    }

    /** Returns the builder for the settings used for calls to listMeasurementProtocolSecrets. */
    public PagedCallSettings.Builder<
            ListMeasurementProtocolSecretsRequest,
            ListMeasurementProtocolSecretsResponse,
            ListMeasurementProtocolSecretsPagedResponse>
        listMeasurementProtocolSecretsSettings() {
      return getStubSettingsBuilder().listMeasurementProtocolSecretsSettings();
    }

    /** Returns the builder for the settings used for calls to createMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<
            CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretSettings() {
      return getStubSettingsBuilder().createMeasurementProtocolSecretSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretSettings() {
      return getStubSettingsBuilder().deleteMeasurementProtocolSecretSettings();
    }

    /** Returns the builder for the settings used for calls to updateMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<
            UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretSettings() {
      return getStubSettingsBuilder().updateMeasurementProtocolSecretSettings();
    }

    /** Returns the builder for the settings used for calls to acknowledgeUserDataCollection. */
    public UnaryCallSettings.Builder<
            AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollectionSettings() {
      return getStubSettingsBuilder().acknowledgeUserDataCollectionSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getSKAdNetworkConversionValueSchema.
     */
    public UnaryCallSettings.Builder<
            GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        getSKAdNetworkConversionValueSchemaSettings() {
      return getStubSettingsBuilder().getSKAdNetworkConversionValueSchemaSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createSKAdNetworkConversionValueSchema.
     */
    public UnaryCallSettings.Builder<
            CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        createSKAdNetworkConversionValueSchemaSettings() {
      return getStubSettingsBuilder().createSKAdNetworkConversionValueSchemaSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteSKAdNetworkConversionValueSchema.
     */
    public UnaryCallSettings.Builder<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
        deleteSKAdNetworkConversionValueSchemaSettings() {
      return getStubSettingsBuilder().deleteSKAdNetworkConversionValueSchemaSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateSKAdNetworkConversionValueSchema.
     */
    public UnaryCallSettings.Builder<
            UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        updateSKAdNetworkConversionValueSchemaSettings() {
      return getStubSettingsBuilder().updateSKAdNetworkConversionValueSchemaSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listSKAdNetworkConversionValueSchemas.
     */
    public PagedCallSettings.Builder<
            ListSKAdNetworkConversionValueSchemasRequest,
            ListSKAdNetworkConversionValueSchemasResponse,
            ListSKAdNetworkConversionValueSchemasPagedResponse>
        listSKAdNetworkConversionValueSchemasSettings() {
      return getStubSettingsBuilder().listSKAdNetworkConversionValueSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to searchChangeHistoryEvents. */
    public PagedCallSettings.Builder<
            SearchChangeHistoryEventsRequest,
            SearchChangeHistoryEventsResponse,
            SearchChangeHistoryEventsPagedResponse>
        searchChangeHistoryEventsSettings() {
      return getStubSettingsBuilder().searchChangeHistoryEventsSettings();
    }

    /** Returns the builder for the settings used for calls to getGoogleSignalsSettings. */
    public UnaryCallSettings.Builder<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        getGoogleSignalsSettingsSettings() {
      return getStubSettingsBuilder().getGoogleSignalsSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateGoogleSignalsSettings. */
    public UnaryCallSettings.Builder<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        updateGoogleSignalsSettingsSettings() {
      return getStubSettingsBuilder().updateGoogleSignalsSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to createConversionEvent. */
    public UnaryCallSettings.Builder<CreateConversionEventRequest, ConversionEvent>
        createConversionEventSettings() {
      return getStubSettingsBuilder().createConversionEventSettings();
    }

    /** Returns the builder for the settings used for calls to updateConversionEvent. */
    public UnaryCallSettings.Builder<UpdateConversionEventRequest, ConversionEvent>
        updateConversionEventSettings() {
      return getStubSettingsBuilder().updateConversionEventSettings();
    }

    /** Returns the builder for the settings used for calls to getConversionEvent. */
    public UnaryCallSettings.Builder<GetConversionEventRequest, ConversionEvent>
        getConversionEventSettings() {
      return getStubSettingsBuilder().getConversionEventSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversionEvent. */
    public UnaryCallSettings.Builder<DeleteConversionEventRequest, Empty>
        deleteConversionEventSettings() {
      return getStubSettingsBuilder().deleteConversionEventSettings();
    }

    /** Returns the builder for the settings used for calls to listConversionEvents. */
    public PagedCallSettings.Builder<
            ListConversionEventsRequest,
            ListConversionEventsResponse,
            ListConversionEventsPagedResponse>
        listConversionEventsSettings() {
      return getStubSettingsBuilder().listConversionEventsSettings();
    }

    /** Returns the builder for the settings used for calls to getDisplayVideo360AdvertiserLink. */
    public UnaryCallSettings.Builder<
            GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLinkSettings() {
      return getStubSettingsBuilder().getDisplayVideo360AdvertiserLinkSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listDisplayVideo360AdvertiserLinks.
     */
    public PagedCallSettings.Builder<
            ListDisplayVideo360AdvertiserLinksRequest,
            ListDisplayVideo360AdvertiserLinksResponse,
            ListDisplayVideo360AdvertiserLinksPagedResponse>
        listDisplayVideo360AdvertiserLinksSettings() {
      return getStubSettingsBuilder().listDisplayVideo360AdvertiserLinksSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createDisplayVideo360AdvertiserLink.
     */
    public UnaryCallSettings.Builder<
            CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLinkSettings() {
      return getStubSettingsBuilder().createDisplayVideo360AdvertiserLinkSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteDisplayVideo360AdvertiserLink.
     */
    public UnaryCallSettings.Builder<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkSettings() {
      return getStubSettingsBuilder().deleteDisplayVideo360AdvertiserLinkSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateDisplayVideo360AdvertiserLink.
     */
    public UnaryCallSettings.Builder<
            UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLinkSettings() {
      return getStubSettingsBuilder().updateDisplayVideo360AdvertiserLinkSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * getDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
        getDisplayVideo360AdvertiserLinkProposalSettings() {
      return getStubSettingsBuilder().getDisplayVideo360AdvertiserLinkProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listDisplayVideo360AdvertiserLinkProposals.
     */
    public PagedCallSettings.Builder<
            ListDisplayVideo360AdvertiserLinkProposalsRequest,
            ListDisplayVideo360AdvertiserLinkProposalsResponse,
            ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
        listDisplayVideo360AdvertiserLinkProposalsSettings() {
      return getStubSettingsBuilder().listDisplayVideo360AdvertiserLinkProposalsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            CreateDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        createDisplayVideo360AdvertiserLinkProposalSettings() {
      return getStubSettingsBuilder().createDisplayVideo360AdvertiserLinkProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkProposalSettings() {
      return getStubSettingsBuilder().deleteDisplayVideo360AdvertiserLinkProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * approveDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            ApproveDisplayVideo360AdvertiserLinkProposalRequest,
            ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        approveDisplayVideo360AdvertiserLinkProposalSettings() {
      return getStubSettingsBuilder().approveDisplayVideo360AdvertiserLinkProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * cancelDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            CancelDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        cancelDisplayVideo360AdvertiserLinkProposalSettings() {
      return getStubSettingsBuilder().cancelDisplayVideo360AdvertiserLinkProposalSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomDimension. */
    public UnaryCallSettings.Builder<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionSettings() {
      return getStubSettingsBuilder().createCustomDimensionSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomDimension. */
    public UnaryCallSettings.Builder<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionSettings() {
      return getStubSettingsBuilder().updateCustomDimensionSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomDimensions. */
    public PagedCallSettings.Builder<
            ListCustomDimensionsRequest,
            ListCustomDimensionsResponse,
            ListCustomDimensionsPagedResponse>
        listCustomDimensionsSettings() {
      return getStubSettingsBuilder().listCustomDimensionsSettings();
    }

    /** Returns the builder for the settings used for calls to archiveCustomDimension. */
    public UnaryCallSettings.Builder<ArchiveCustomDimensionRequest, Empty>
        archiveCustomDimensionSettings() {
      return getStubSettingsBuilder().archiveCustomDimensionSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomDimension. */
    public UnaryCallSettings.Builder<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionSettings() {
      return getStubSettingsBuilder().getCustomDimensionSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomMetric. */
    public UnaryCallSettings.Builder<CreateCustomMetricRequest, CustomMetric>
        createCustomMetricSettings() {
      return getStubSettingsBuilder().createCustomMetricSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomMetric. */
    public UnaryCallSettings.Builder<UpdateCustomMetricRequest, CustomMetric>
        updateCustomMetricSettings() {
      return getStubSettingsBuilder().updateCustomMetricSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomMetrics. */
    public PagedCallSettings.Builder<
            ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
        listCustomMetricsSettings() {
      return getStubSettingsBuilder().listCustomMetricsSettings();
    }

    /** Returns the builder for the settings used for calls to archiveCustomMetric. */
    public UnaryCallSettings.Builder<ArchiveCustomMetricRequest, Empty>
        archiveCustomMetricSettings() {
      return getStubSettingsBuilder().archiveCustomMetricSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomMetric. */
    public UnaryCallSettings.Builder<GetCustomMetricRequest, CustomMetric>
        getCustomMetricSettings() {
      return getStubSettingsBuilder().getCustomMetricSettings();
    }

    /** Returns the builder for the settings used for calls to getDataRetentionSettings. */
    public UnaryCallSettings.Builder<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsSettings() {
      return getStubSettingsBuilder().getDataRetentionSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataRetentionSettings. */
    public UnaryCallSettings.Builder<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsSettings() {
      return getStubSettingsBuilder().updateDataRetentionSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to createDataStream. */
    public UnaryCallSettings.Builder<CreateDataStreamRequest, DataStream>
        createDataStreamSettings() {
      return getStubSettingsBuilder().createDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataStream. */
    public UnaryCallSettings.Builder<DeleteDataStreamRequest, Empty> deleteDataStreamSettings() {
      return getStubSettingsBuilder().deleteDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataStream. */
    public UnaryCallSettings.Builder<UpdateDataStreamRequest, DataStream>
        updateDataStreamSettings() {
      return getStubSettingsBuilder().updateDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to listDataStreams. */
    public PagedCallSettings.Builder<
            ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
        listDataStreamsSettings() {
      return getStubSettingsBuilder().listDataStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataStream. */
    public UnaryCallSettings.Builder<GetDataStreamRequest, DataStream> getDataStreamSettings() {
      return getStubSettingsBuilder().getDataStreamSettings();
    }

    /** Returns the builder for the settings used for calls to getAudience. */
    public UnaryCallSettings.Builder<GetAudienceRequest, Audience> getAudienceSettings() {
      return getStubSettingsBuilder().getAudienceSettings();
    }

    /** Returns the builder for the settings used for calls to listAudiences. */
    public PagedCallSettings.Builder<
            ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
        listAudiencesSettings() {
      return getStubSettingsBuilder().listAudiencesSettings();
    }

    /** Returns the builder for the settings used for calls to createAudience. */
    public UnaryCallSettings.Builder<CreateAudienceRequest, Audience> createAudienceSettings() {
      return getStubSettingsBuilder().createAudienceSettings();
    }

    /** Returns the builder for the settings used for calls to updateAudience. */
    public UnaryCallSettings.Builder<UpdateAudienceRequest, Audience> updateAudienceSettings() {
      return getStubSettingsBuilder().updateAudienceSettings();
    }

    /** Returns the builder for the settings used for calls to archiveAudience. */
    public UnaryCallSettings.Builder<ArchiveAudienceRequest, Empty> archiveAudienceSettings() {
      return getStubSettingsBuilder().archiveAudienceSettings();
    }

    /** Returns the builder for the settings used for calls to getSearchAds360Link. */
    public UnaryCallSettings.Builder<GetSearchAds360LinkRequest, SearchAds360Link>
        getSearchAds360LinkSettings() {
      return getStubSettingsBuilder().getSearchAds360LinkSettings();
    }

    /** Returns the builder for the settings used for calls to listSearchAds360Links. */
    public PagedCallSettings.Builder<
            ListSearchAds360LinksRequest,
            ListSearchAds360LinksResponse,
            ListSearchAds360LinksPagedResponse>
        listSearchAds360LinksSettings() {
      return getStubSettingsBuilder().listSearchAds360LinksSettings();
    }

    /** Returns the builder for the settings used for calls to createSearchAds360Link. */
    public UnaryCallSettings.Builder<CreateSearchAds360LinkRequest, SearchAds360Link>
        createSearchAds360LinkSettings() {
      return getStubSettingsBuilder().createSearchAds360LinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSearchAds360Link. */
    public UnaryCallSettings.Builder<DeleteSearchAds360LinkRequest, Empty>
        deleteSearchAds360LinkSettings() {
      return getStubSettingsBuilder().deleteSearchAds360LinkSettings();
    }

    /** Returns the builder for the settings used for calls to updateSearchAds360Link. */
    public UnaryCallSettings.Builder<UpdateSearchAds360LinkRequest, SearchAds360Link>
        updateSearchAds360LinkSettings() {
      return getStubSettingsBuilder().updateSearchAds360LinkSettings();
    }

    /** Returns the builder for the settings used for calls to getAttributionSettings. */
    public UnaryCallSettings.Builder<GetAttributionSettingsRequest, AttributionSettings>
        getAttributionSettingsSettings() {
      return getStubSettingsBuilder().getAttributionSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateAttributionSettings. */
    public UnaryCallSettings.Builder<UpdateAttributionSettingsRequest, AttributionSettings>
        updateAttributionSettingsSettings() {
      return getStubSettingsBuilder().updateAttributionSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to runAccessReport. */
    public UnaryCallSettings.Builder<RunAccessReportRequest, RunAccessReportResponse>
        runAccessReportSettings() {
      return getStubSettingsBuilder().runAccessReportSettings();
    }

    /** Returns the builder for the settings used for calls to createAccessBinding. */
    public UnaryCallSettings.Builder<CreateAccessBindingRequest, AccessBinding>
        createAccessBindingSettings() {
      return getStubSettingsBuilder().createAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessBinding. */
    public UnaryCallSettings.Builder<GetAccessBindingRequest, AccessBinding>
        getAccessBindingSettings() {
      return getStubSettingsBuilder().getAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessBinding. */
    public UnaryCallSettings.Builder<UpdateAccessBindingRequest, AccessBinding>
        updateAccessBindingSettings() {
      return getStubSettingsBuilder().updateAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessBinding. */
    public UnaryCallSettings.Builder<DeleteAccessBindingRequest, Empty>
        deleteAccessBindingSettings() {
      return getStubSettingsBuilder().deleteAccessBindingSettings();
    }

    /** Returns the builder for the settings used for calls to listAccessBindings. */
    public PagedCallSettings.Builder<
            ListAccessBindingsRequest, ListAccessBindingsResponse, ListAccessBindingsPagedResponse>
        listAccessBindingsSettings() {
      return getStubSettingsBuilder().listAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateAccessBindings. */
    public UnaryCallSettings.Builder<
            BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
        batchCreateAccessBindingsSettings() {
      return getStubSettingsBuilder().batchCreateAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to batchGetAccessBindings. */
    public UnaryCallSettings.Builder<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
        batchGetAccessBindingsSettings() {
      return getStubSettingsBuilder().batchGetAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateAccessBindings. */
    public UnaryCallSettings.Builder<
            BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
        batchUpdateAccessBindingsSettings() {
      return getStubSettingsBuilder().batchUpdateAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteAccessBindings. */
    public UnaryCallSettings.Builder<BatchDeleteAccessBindingsRequest, Empty>
        batchDeleteAccessBindingsSettings() {
      return getStubSettingsBuilder().batchDeleteAccessBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getExpandedDataSet. */
    public UnaryCallSettings.Builder<GetExpandedDataSetRequest, ExpandedDataSet>
        getExpandedDataSetSettings() {
      return getStubSettingsBuilder().getExpandedDataSetSettings();
    }

    /** Returns the builder for the settings used for calls to listExpandedDataSets. */
    public PagedCallSettings.Builder<
            ListExpandedDataSetsRequest,
            ListExpandedDataSetsResponse,
            ListExpandedDataSetsPagedResponse>
        listExpandedDataSetsSettings() {
      return getStubSettingsBuilder().listExpandedDataSetsSettings();
    }

    /** Returns the builder for the settings used for calls to createExpandedDataSet. */
    public UnaryCallSettings.Builder<CreateExpandedDataSetRequest, ExpandedDataSet>
        createExpandedDataSetSettings() {
      return getStubSettingsBuilder().createExpandedDataSetSettings();
    }

    /** Returns the builder for the settings used for calls to updateExpandedDataSet. */
    public UnaryCallSettings.Builder<UpdateExpandedDataSetRequest, ExpandedDataSet>
        updateExpandedDataSetSettings() {
      return getStubSettingsBuilder().updateExpandedDataSetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExpandedDataSet. */
    public UnaryCallSettings.Builder<DeleteExpandedDataSetRequest, Empty>
        deleteExpandedDataSetSettings() {
      return getStubSettingsBuilder().deleteExpandedDataSetSettings();
    }

    /** Returns the builder for the settings used for calls to getChannelGroup. */
    public UnaryCallSettings.Builder<GetChannelGroupRequest, ChannelGroup>
        getChannelGroupSettings() {
      return getStubSettingsBuilder().getChannelGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listChannelGroups. */
    public PagedCallSettings.Builder<
            ListChannelGroupsRequest, ListChannelGroupsResponse, ListChannelGroupsPagedResponse>
        listChannelGroupsSettings() {
      return getStubSettingsBuilder().listChannelGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to createChannelGroup. */
    public UnaryCallSettings.Builder<CreateChannelGroupRequest, ChannelGroup>
        createChannelGroupSettings() {
      return getStubSettingsBuilder().createChannelGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateChannelGroup. */
    public UnaryCallSettings.Builder<UpdateChannelGroupRequest, ChannelGroup>
        updateChannelGroupSettings() {
      return getStubSettingsBuilder().updateChannelGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteChannelGroup. */
    public UnaryCallSettings.Builder<DeleteChannelGroupRequest, Empty>
        deleteChannelGroupSettings() {
      return getStubSettingsBuilder().deleteChannelGroupSettings();
    }

    /**
     * Returns the builder for the settings used for calls to setAutomatedGa4ConfigurationOptOut.
     */
    public UnaryCallSettings.Builder<
            SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
        setAutomatedGa4ConfigurationOptOutSettings() {
      return getStubSettingsBuilder().setAutomatedGa4ConfigurationOptOutSettings();
    }

    /**
     * Returns the builder for the settings used for calls to fetchAutomatedGa4ConfigurationOptOut.
     */
    public UnaryCallSettings.Builder<
            FetchAutomatedGa4ConfigurationOptOutRequest,
            FetchAutomatedGa4ConfigurationOptOutResponse>
        fetchAutomatedGa4ConfigurationOptOutSettings() {
      return getStubSettingsBuilder().fetchAutomatedGa4ConfigurationOptOutSettings();
    }

    /** Returns the builder for the settings used for calls to getBigQueryLink. */
    public UnaryCallSettings.Builder<GetBigQueryLinkRequest, BigQueryLink>
        getBigQueryLinkSettings() {
      return getStubSettingsBuilder().getBigQueryLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listBigQueryLinks. */
    public PagedCallSettings.Builder<
            ListBigQueryLinksRequest, ListBigQueryLinksResponse, ListBigQueryLinksPagedResponse>
        listBigQueryLinksSettings() {
      return getStubSettingsBuilder().listBigQueryLinksSettings();
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

    /** Returns the builder for the settings used for calls to createConnectedSiteTag. */
    public UnaryCallSettings.Builder<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
        createConnectedSiteTagSettings() {
      return getStubSettingsBuilder().createConnectedSiteTagSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnectedSiteTag. */
    public UnaryCallSettings.Builder<DeleteConnectedSiteTagRequest, Empty>
        deleteConnectedSiteTagSettings() {
      return getStubSettingsBuilder().deleteConnectedSiteTagSettings();
    }

    /** Returns the builder for the settings used for calls to listConnectedSiteTags. */
    public UnaryCallSettings.Builder<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
        listConnectedSiteTagsSettings() {
      return getStubSettingsBuilder().listConnectedSiteTagsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchConnectedGa4Property. */
    public UnaryCallSettings.Builder<
            FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
        fetchConnectedGa4PropertySettings() {
      return getStubSettingsBuilder().fetchConnectedGa4PropertySettings();
    }

    /** Returns the builder for the settings used for calls to getAdSenseLink. */
    public UnaryCallSettings.Builder<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkSettings() {
      return getStubSettingsBuilder().getAdSenseLinkSettings();
    }

    /** Returns the builder for the settings used for calls to createAdSenseLink. */
    public UnaryCallSettings.Builder<CreateAdSenseLinkRequest, AdSenseLink>
        createAdSenseLinkSettings() {
      return getStubSettingsBuilder().createAdSenseLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAdSenseLink. */
    public UnaryCallSettings.Builder<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkSettings() {
      return getStubSettingsBuilder().deleteAdSenseLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listAdSenseLinks. */
    public PagedCallSettings.Builder<
            ListAdSenseLinksRequest, ListAdSenseLinksResponse, ListAdSenseLinksPagedResponse>
        listAdSenseLinksSettings() {
      return getStubSettingsBuilder().listAdSenseLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getEventCreateRule. */
    public UnaryCallSettings.Builder<GetEventCreateRuleRequest, EventCreateRule>
        getEventCreateRuleSettings() {
      return getStubSettingsBuilder().getEventCreateRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listEventCreateRules. */
    public PagedCallSettings.Builder<
            ListEventCreateRulesRequest,
            ListEventCreateRulesResponse,
            ListEventCreateRulesPagedResponse>
        listEventCreateRulesSettings() {
      return getStubSettingsBuilder().listEventCreateRulesSettings();
    }

    /** Returns the builder for the settings used for calls to createEventCreateRule. */
    public UnaryCallSettings.Builder<CreateEventCreateRuleRequest, EventCreateRule>
        createEventCreateRuleSettings() {
      return getStubSettingsBuilder().createEventCreateRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateEventCreateRule. */
    public UnaryCallSettings.Builder<UpdateEventCreateRuleRequest, EventCreateRule>
        updateEventCreateRuleSettings() {
      return getStubSettingsBuilder().updateEventCreateRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEventCreateRule. */
    public UnaryCallSettings.Builder<DeleteEventCreateRuleRequest, Empty>
        deleteEventCreateRuleSettings() {
      return getStubSettingsBuilder().deleteEventCreateRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataRedactionSettings. */
    public UnaryCallSettings.Builder<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
        updateDataRedactionSettingsSettings() {
      return getStubSettingsBuilder().updateDataRedactionSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataRedactionSettings. */
    public UnaryCallSettings.Builder<GetDataRedactionSettingsRequest, DataRedactionSettings>
        getDataRedactionSettingsSettings() {
      return getStubSettingsBuilder().getDataRedactionSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to getCalculatedMetric. */
    public UnaryCallSettings.Builder<GetCalculatedMetricRequest, CalculatedMetric>
        getCalculatedMetricSettings() {
      return getStubSettingsBuilder().getCalculatedMetricSettings();
    }

    /** Returns the builder for the settings used for calls to createCalculatedMetric. */
    public UnaryCallSettings.Builder<CreateCalculatedMetricRequest, CalculatedMetric>
        createCalculatedMetricSettings() {
      return getStubSettingsBuilder().createCalculatedMetricSettings();
    }

    /** Returns the builder for the settings used for calls to listCalculatedMetrics. */
    public PagedCallSettings.Builder<
            ListCalculatedMetricsRequest,
            ListCalculatedMetricsResponse,
            ListCalculatedMetricsPagedResponse>
        listCalculatedMetricsSettings() {
      return getStubSettingsBuilder().listCalculatedMetricsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCalculatedMetric. */
    public UnaryCallSettings.Builder<UpdateCalculatedMetricRequest, CalculatedMetric>
        updateCalculatedMetricSettings() {
      return getStubSettingsBuilder().updateCalculatedMetricSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCalculatedMetric. */
    public UnaryCallSettings.Builder<DeleteCalculatedMetricRequest, Empty>
        deleteCalculatedMetricSettings() {
      return getStubSettingsBuilder().deleteCalculatedMetricSettings();
    }

    /** Returns the builder for the settings used for calls to createRollupProperty. */
    public UnaryCallSettings.Builder<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
        createRollupPropertySettings() {
      return getStubSettingsBuilder().createRollupPropertySettings();
    }

    /** Returns the builder for the settings used for calls to getRollupPropertySourceLink. */
    public UnaryCallSettings.Builder<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
        getRollupPropertySourceLinkSettings() {
      return getStubSettingsBuilder().getRollupPropertySourceLinkSettings();
    }

    /** Returns the builder for the settings used for calls to listRollupPropertySourceLinks. */
    public PagedCallSettings.Builder<
            ListRollupPropertySourceLinksRequest,
            ListRollupPropertySourceLinksResponse,
            ListRollupPropertySourceLinksPagedResponse>
        listRollupPropertySourceLinksSettings() {
      return getStubSettingsBuilder().listRollupPropertySourceLinksSettings();
    }

    /** Returns the builder for the settings used for calls to createRollupPropertySourceLink. */
    public UnaryCallSettings.Builder<
            CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
        createRollupPropertySourceLinkSettings() {
      return getStubSettingsBuilder().createRollupPropertySourceLinkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRollupPropertySourceLink. */
    public UnaryCallSettings.Builder<DeleteRollupPropertySourceLinkRequest, Empty>
        deleteRollupPropertySourceLinkSettings() {
      return getStubSettingsBuilder().deleteRollupPropertySourceLinkSettings();
    }

    /** Returns the builder for the settings used for calls to createSubproperty. */
    public UnaryCallSettings.Builder<CreateSubpropertyRequest, CreateSubpropertyResponse>
        createSubpropertySettings() {
      return getStubSettingsBuilder().createSubpropertySettings();
    }

    /** Returns the builder for the settings used for calls to createSubpropertyEventFilter. */
    public UnaryCallSettings.Builder<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
        createSubpropertyEventFilterSettings() {
      return getStubSettingsBuilder().createSubpropertyEventFilterSettings();
    }

    /** Returns the builder for the settings used for calls to getSubpropertyEventFilter. */
    public UnaryCallSettings.Builder<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
        getSubpropertyEventFilterSettings() {
      return getStubSettingsBuilder().getSubpropertyEventFilterSettings();
    }

    /** Returns the builder for the settings used for calls to listSubpropertyEventFilters. */
    public PagedCallSettings.Builder<
            ListSubpropertyEventFiltersRequest,
            ListSubpropertyEventFiltersResponse,
            ListSubpropertyEventFiltersPagedResponse>
        listSubpropertyEventFiltersSettings() {
      return getStubSettingsBuilder().listSubpropertyEventFiltersSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubpropertyEventFilter. */
    public UnaryCallSettings.Builder<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
        updateSubpropertyEventFilterSettings() {
      return getStubSettingsBuilder().updateSubpropertyEventFilterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubpropertyEventFilter. */
    public UnaryCallSettings.Builder<DeleteSubpropertyEventFilterRequest, Empty>
        deleteSubpropertyEventFilterSettings() {
      return getStubSettingsBuilder().deleteSubpropertyEventFilterSettings();
    }

    @Override
    public AnalyticsAdminServiceSettings build() throws IOException {
      return new AnalyticsAdminServiceSettings(this);
    }
  }
}
