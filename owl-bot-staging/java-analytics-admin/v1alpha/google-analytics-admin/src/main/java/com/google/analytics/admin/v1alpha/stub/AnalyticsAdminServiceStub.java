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

package com.google.analytics.admin.v1alpha.stub;

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

import com.google.analytics.admin.v1alpha.AccessBinding;
import com.google.analytics.admin.v1alpha.Account;
import com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest;
import com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse;
import com.google.analytics.admin.v1alpha.AdSenseLink;
import com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse;
import com.google.analytics.admin.v1alpha.ArchiveAudienceRequest;
import com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest;
import com.google.analytics.admin.v1alpha.AttributionSettings;
import com.google.analytics.admin.v1alpha.Audience;
import com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.BatchCreateAccessBindingsResponse;
import com.google.analytics.admin.v1alpha.BatchDeleteAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.BatchGetAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.BatchGetAccessBindingsResponse;
import com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.BatchUpdateAccessBindingsResponse;
import com.google.analytics.admin.v1alpha.BigQueryLink;
import com.google.analytics.admin.v1alpha.CalculatedMetric;
import com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.ChannelGroup;
import com.google.analytics.admin.v1alpha.ConversionEvent;
import com.google.analytics.admin.v1alpha.CreateAccessBindingRequest;
import com.google.analytics.admin.v1alpha.CreateAdSenseLinkRequest;
import com.google.analytics.admin.v1alpha.CreateAudienceRequest;
import com.google.analytics.admin.v1alpha.CreateCalculatedMetricRequest;
import com.google.analytics.admin.v1alpha.CreateChannelGroupRequest;
import com.google.analytics.admin.v1alpha.CreateConnectedSiteTagRequest;
import com.google.analytics.admin.v1alpha.CreateConnectedSiteTagResponse;
import com.google.analytics.admin.v1alpha.CreateConversionEventRequest;
import com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.CreateCustomMetricRequest;
import com.google.analytics.admin.v1alpha.CreateDataStreamRequest;
import com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.CreateEventCreateRuleRequest;
import com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.CreatePropertyRequest;
import com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest;
import com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse;
import com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest;
import com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest;
import com.google.analytics.admin.v1alpha.CreateSubpropertyRequest;
import com.google.analytics.admin.v1alpha.CreateSubpropertyResponse;
import com.google.analytics.admin.v1alpha.CustomDimension;
import com.google.analytics.admin.v1alpha.CustomMetric;
import com.google.analytics.admin.v1alpha.DataRedactionSettings;
import com.google.analytics.admin.v1alpha.DataRetentionSettings;
import com.google.analytics.admin.v1alpha.DataSharingSettings;
import com.google.analytics.admin.v1alpha.DataStream;
import com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest;
import com.google.analytics.admin.v1alpha.DeleteAccountRequest;
import com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest;
import com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest;
import com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest;
import com.google.analytics.admin.v1alpha.DeleteConversionEventRequest;
import com.google.analytics.admin.v1alpha.DeleteDataStreamRequest;
import com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest;
import com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.DeletePropertyRequest;
import com.google.analytics.admin.v1alpha.DeleteRollupPropertySourceLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.DeleteSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.DeleteSubpropertyEventFilterRequest;
import com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink;
import com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal;
import com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings;
import com.google.analytics.admin.v1alpha.EventCreateRule;
import com.google.analytics.admin.v1alpha.ExpandedDataSet;
import com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutRequest;
import com.google.analytics.admin.v1alpha.FetchAutomatedGa4ConfigurationOptOutResponse;
import com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyRequest;
import com.google.analytics.admin.v1alpha.FetchConnectedGa4PropertyResponse;
import com.google.analytics.admin.v1alpha.FirebaseLink;
import com.google.analytics.admin.v1alpha.GetAccessBindingRequest;
import com.google.analytics.admin.v1alpha.GetAccountRequest;
import com.google.analytics.admin.v1alpha.GetAdSenseLinkRequest;
import com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest;
import com.google.analytics.admin.v1alpha.GetAudienceRequest;
import com.google.analytics.admin.v1alpha.GetBigQueryLinkRequest;
import com.google.analytics.admin.v1alpha.GetCalculatedMetricRequest;
import com.google.analytics.admin.v1alpha.GetChannelGroupRequest;
import com.google.analytics.admin.v1alpha.GetConversionEventRequest;
import com.google.analytics.admin.v1alpha.GetCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.GetCustomMetricRequest;
import com.google.analytics.admin.v1alpha.GetDataRedactionSettingsRequest;
import com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest;
import com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest;
import com.google.analytics.admin.v1alpha.GetDataStreamRequest;
import com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest;
import com.google.analytics.admin.v1alpha.GetEventCreateRuleRequest;
import com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest;
import com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest;
import com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.GetPropertyRequest;
import com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest;
import com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest;
import com.google.analytics.admin.v1alpha.GlobalSiteTag;
import com.google.analytics.admin.v1alpha.GoogleAdsLink;
import com.google.analytics.admin.v1alpha.GoogleSignalsSettings;
import com.google.analytics.admin.v1alpha.ListAccessBindingsRequest;
import com.google.analytics.admin.v1alpha.ListAccessBindingsResponse;
import com.google.analytics.admin.v1alpha.ListAccountSummariesRequest;
import com.google.analytics.admin.v1alpha.ListAccountSummariesResponse;
import com.google.analytics.admin.v1alpha.ListAccountsRequest;
import com.google.analytics.admin.v1alpha.ListAccountsResponse;
import com.google.analytics.admin.v1alpha.ListAdSenseLinksRequest;
import com.google.analytics.admin.v1alpha.ListAdSenseLinksResponse;
import com.google.analytics.admin.v1alpha.ListAudiencesRequest;
import com.google.analytics.admin.v1alpha.ListAudiencesResponse;
import com.google.analytics.admin.v1alpha.ListBigQueryLinksRequest;
import com.google.analytics.admin.v1alpha.ListBigQueryLinksResponse;
import com.google.analytics.admin.v1alpha.ListCalculatedMetricsRequest;
import com.google.analytics.admin.v1alpha.ListCalculatedMetricsResponse;
import com.google.analytics.admin.v1alpha.ListChannelGroupsRequest;
import com.google.analytics.admin.v1alpha.ListChannelGroupsResponse;
import com.google.analytics.admin.v1alpha.ListConnectedSiteTagsRequest;
import com.google.analytics.admin.v1alpha.ListConnectedSiteTagsResponse;
import com.google.analytics.admin.v1alpha.ListConversionEventsRequest;
import com.google.analytics.admin.v1alpha.ListConversionEventsResponse;
import com.google.analytics.admin.v1alpha.ListCustomDimensionsRequest;
import com.google.analytics.admin.v1alpha.ListCustomDimensionsResponse;
import com.google.analytics.admin.v1alpha.ListCustomMetricsRequest;
import com.google.analytics.admin.v1alpha.ListCustomMetricsResponse;
import com.google.analytics.admin.v1alpha.ListDataStreamsRequest;
import com.google.analytics.admin.v1alpha.ListDataStreamsResponse;
import com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsRequest;
import com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinkProposalsResponse;
import com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksRequest;
import com.google.analytics.admin.v1alpha.ListDisplayVideo360AdvertiserLinksResponse;
import com.google.analytics.admin.v1alpha.ListEventCreateRulesRequest;
import com.google.analytics.admin.v1alpha.ListEventCreateRulesResponse;
import com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest;
import com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse;
import com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest;
import com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse;
import com.google.analytics.admin.v1alpha.ListPropertiesRequest;
import com.google.analytics.admin.v1alpha.ListPropertiesResponse;
import com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksRequest;
import com.google.analytics.admin.v1alpha.ListRollupPropertySourceLinksResponse;
import com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasRequest;
import com.google.analytics.admin.v1alpha.ListSKAdNetworkConversionValueSchemasResponse;
import com.google.analytics.admin.v1alpha.ListSearchAds360LinksRequest;
import com.google.analytics.admin.v1alpha.ListSearchAds360LinksResponse;
import com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersRequest;
import com.google.analytics.admin.v1alpha.ListSubpropertyEventFiltersResponse;
import com.google.analytics.admin.v1alpha.MeasurementProtocolSecret;
import com.google.analytics.admin.v1alpha.Property;
import com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest;
import com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse;
import com.google.analytics.admin.v1alpha.RollupPropertySourceLink;
import com.google.analytics.admin.v1alpha.RunAccessReportRequest;
import com.google.analytics.admin.v1alpha.RunAccessReportResponse;
import com.google.analytics.admin.v1alpha.SKAdNetworkConversionValueSchema;
import com.google.analytics.admin.v1alpha.SearchAds360Link;
import com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest;
import com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse;
import com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutRequest;
import com.google.analytics.admin.v1alpha.SetAutomatedGa4ConfigurationOptOutResponse;
import com.google.analytics.admin.v1alpha.SubpropertyEventFilter;
import com.google.analytics.admin.v1alpha.UpdateAccessBindingRequest;
import com.google.analytics.admin.v1alpha.UpdateAccountRequest;
import com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateAudienceRequest;
import com.google.analytics.admin.v1alpha.UpdateCalculatedMetricRequest;
import com.google.analytics.admin.v1alpha.UpdateChannelGroupRequest;
import com.google.analytics.admin.v1alpha.UpdateConversionEventRequest;
import com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest;
import com.google.analytics.admin.v1alpha.UpdateDataRedactionSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateDataStreamRequest;
import com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateEventCreateRuleRequest;
import com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.UpdatePropertyRequest;
import com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AnalyticsAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AnalyticsAdminServiceStub implements BackgroundResource {

  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccountCallable()");
  }

  public UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse> listAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountsPagedCallable()");
  }

  public UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountsCallable()");
  }

  public UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccountCallable()");
  }

  public UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccountCallable()");
  }

  public UnaryCallable<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketCallable() {
    throw new UnsupportedOperationException("Not implemented: provisionAccountTicketCallable()");
  }

  public UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesPagedResponse>
      listAccountSummariesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountSummariesPagedCallable()");
  }

  public UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesResponse>
      listAccountSummariesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountSummariesCallable()");
  }

  public UnaryCallable<GetPropertyRequest, Property> getPropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: getPropertyCallable()");
  }

  public UnaryCallable<ListPropertiesRequest, ListPropertiesPagedResponse>
      listPropertiesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPropertiesPagedCallable()");
  }

  public UnaryCallable<ListPropertiesRequest, ListPropertiesResponse> listPropertiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPropertiesCallable()");
  }

  public UnaryCallable<CreatePropertyRequest, Property> createPropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: createPropertyCallable()");
  }

  public UnaryCallable<DeletePropertyRequest, Property> deletePropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePropertyCallable()");
  }

  public UnaryCallable<UpdatePropertyRequest, Property> updatePropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePropertyCallable()");
  }

  public UnaryCallable<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createFirebaseLinkCallable()");
  }

  public UnaryCallable<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFirebaseLinkCallable()");
  }

  public UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksPagedResponse>
      listFirebaseLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFirebaseLinksPagedCallable()");
  }

  public UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listFirebaseLinksCallable()");
  }

  public UnaryCallable<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagCallable() {
    throw new UnsupportedOperationException("Not implemented: getGlobalSiteTagCallable()");
  }

  public UnaryCallable<CreateGoogleAdsLinkRequest, GoogleAdsLink> createGoogleAdsLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createGoogleAdsLinkCallable()");
  }

  public UnaryCallable<UpdateGoogleAdsLinkRequest, GoogleAdsLink> updateGoogleAdsLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGoogleAdsLinkCallable()");
  }

  public UnaryCallable<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGoogleAdsLinkCallable()");
  }

  public UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGoogleAdsLinksPagedCallable()");
  }

  public UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listGoogleAdsLinksCallable()");
  }

  public UnaryCallable<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSharingSettingsCallable()");
  }

  public UnaryCallable<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getMeasurementProtocolSecretCallable()");
  }

  public UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMeasurementProtocolSecretsPagedCallable()");
  }

  public UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
      listMeasurementProtocolSecretsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMeasurementProtocolSecretsCallable()");
  }

  public UnaryCallable<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMeasurementProtocolSecretCallable()");
  }

  public UnaryCallable<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMeasurementProtocolSecretCallable()");
  }

  public UnaryCallable<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMeasurementProtocolSecretCallable()");
  }

  public UnaryCallable<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: acknowledgeUserDataCollectionCallable()");
  }

  public UnaryCallable<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getSKAdNetworkConversionValueSchemaCallable()");
  }

  public UnaryCallable<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSKAdNetworkConversionValueSchemaCallable()");
  }

  public UnaryCallable<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSKAdNetworkConversionValueSchemaCallable()");
  }

  public UnaryCallable<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSKAdNetworkConversionValueSchemaCallable()");
  }

  public UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasPagedResponse>
      listSKAdNetworkConversionValueSchemasPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSKAdNetworkConversionValueSchemasPagedCallable()");
  }

  public UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse>
      listSKAdNetworkConversionValueSchemasCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSKAdNetworkConversionValueSchemasCallable()");
  }

  public UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchChangeHistoryEventsPagedCallable()");
  }

  public UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchChangeHistoryEventsCallable()");
  }

  public UnaryCallable<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getGoogleSignalsSettingsCallable()");
  }

  public UnaryCallable<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGoogleSignalsSettingsCallable()");
  }

  public UnaryCallable<CreateConversionEventRequest, ConversionEvent>
      createConversionEventCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversionEventCallable()");
  }

  public UnaryCallable<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConversionEventCallable()");
  }

  public UnaryCallable<GetConversionEventRequest, ConversionEvent> getConversionEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversionEventCallable()");
  }

  public UnaryCallable<DeleteConversionEventRequest, Empty> deleteConversionEventCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversionEventCallable()");
  }

  public UnaryCallable<ListConversionEventsRequest, ListConversionEventsPagedResponse>
      listConversionEventsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversionEventsPagedCallable()");
  }

  public UnaryCallable<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversionEventsCallable()");
  }

  public UnaryCallable<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getDisplayVideo360AdvertiserLinkCallable()");
  }

  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDisplayVideo360AdvertiserLinksPagedCallable()");
  }

  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
      listDisplayVideo360AdvertiserLinksCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDisplayVideo360AdvertiserLinksCallable()");
  }

  public UnaryCallable<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDisplayVideo360AdvertiserLinkCallable()");
  }

  public UnaryCallable<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDisplayVideo360AdvertiserLinkCallable()");
  }

  public UnaryCallable<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDisplayVideo360AdvertiserLinkCallable()");
  }

  public UnaryCallable<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getDisplayVideo360AdvertiserLinkProposalCallable()");
  }

  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      listDisplayVideo360AdvertiserLinkProposalsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDisplayVideo360AdvertiserLinkProposalsPagedCallable()");
  }

  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse>
      listDisplayVideo360AdvertiserLinkProposalsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDisplayVideo360AdvertiserLinkProposalsCallable()");
  }

  public UnaryCallable<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDisplayVideo360AdvertiserLinkProposalCallable()");
  }

  public UnaryCallable<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDisplayVideo360AdvertiserLinkProposalCallable()");
  }

  public UnaryCallable<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: approveDisplayVideo360AdvertiserLinkProposalCallable()");
  }

  public UnaryCallable<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cancelDisplayVideo360AdvertiserLinkProposalCallable()");
  }

  public UnaryCallable<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomDimensionCallable()");
  }

  public UnaryCallable<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomDimensionCallable()");
  }

  public UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsPagedResponse>
      listCustomDimensionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomDimensionsPagedCallable()");
  }

  public UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomDimensionsCallable()");
  }

  public UnaryCallable<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionCallable() {
    throw new UnsupportedOperationException("Not implemented: archiveCustomDimensionCallable()");
  }

  public UnaryCallable<GetCustomDimensionRequest, CustomDimension> getCustomDimensionCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomDimensionCallable()");
  }

  public UnaryCallable<CreateCustomMetricRequest, CustomMetric> createCustomMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomMetricCallable()");
  }

  public UnaryCallable<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomMetricCallable()");
  }

  public UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsPagedResponse>
      listCustomMetricsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomMetricsPagedCallable()");
  }

  public UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomMetricsCallable()");
  }

  public UnaryCallable<ArchiveCustomMetricRequest, Empty> archiveCustomMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: archiveCustomMetricCallable()");
  }

  public UnaryCallable<GetCustomMetricRequest, CustomMetric> getCustomMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomMetricCallable()");
  }

  public UnaryCallable<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataRetentionSettingsCallable()");
  }

  public UnaryCallable<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataRetentionSettingsCallable()");
  }

  public UnaryCallable<CreateDataStreamRequest, DataStream> createDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataStreamCallable()");
  }

  public UnaryCallable<DeleteDataStreamRequest, Empty> deleteDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataStreamCallable()");
  }

  public UnaryCallable<UpdateDataStreamRequest, DataStream> updateDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataStreamCallable()");
  }

  public UnaryCallable<ListDataStreamsRequest, ListDataStreamsPagedResponse>
      listDataStreamsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataStreamsPagedCallable()");
  }

  public UnaryCallable<ListDataStreamsRequest, ListDataStreamsResponse> listDataStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataStreamsCallable()");
  }

  public UnaryCallable<GetDataStreamRequest, DataStream> getDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataStreamCallable()");
  }

  public UnaryCallable<GetAudienceRequest, Audience> getAudienceCallable() {
    throw new UnsupportedOperationException("Not implemented: getAudienceCallable()");
  }

  public UnaryCallable<ListAudiencesRequest, ListAudiencesPagedResponse>
      listAudiencesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAudiencesPagedCallable()");
  }

  public UnaryCallable<ListAudiencesRequest, ListAudiencesResponse> listAudiencesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAudiencesCallable()");
  }

  public UnaryCallable<CreateAudienceRequest, Audience> createAudienceCallable() {
    throw new UnsupportedOperationException("Not implemented: createAudienceCallable()");
  }

  public UnaryCallable<UpdateAudienceRequest, Audience> updateAudienceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAudienceCallable()");
  }

  public UnaryCallable<ArchiveAudienceRequest, Empty> archiveAudienceCallable() {
    throw new UnsupportedOperationException("Not implemented: archiveAudienceCallable()");
  }

  public UnaryCallable<GetSearchAds360LinkRequest, SearchAds360Link> getSearchAds360LinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getSearchAds360LinkCallable()");
  }

  public UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksPagedResponse>
      listSearchAds360LinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSearchAds360LinksPagedCallable()");
  }

  public UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
      listSearchAds360LinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchAds360LinksCallable()");
  }

  public UnaryCallable<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createSearchAds360LinkCallable()");
  }

  public UnaryCallable<DeleteSearchAds360LinkRequest, Empty> deleteSearchAds360LinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSearchAds360LinkCallable()");
  }

  public UnaryCallable<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSearchAds360LinkCallable()");
  }

  public UnaryCallable<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttributionSettingsCallable()");
  }

  public UnaryCallable<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAttributionSettingsCallable()");
  }

  public UnaryCallable<RunAccessReportRequest, RunAccessReportResponse> runAccessReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runAccessReportCallable()");
  }

  public UnaryCallable<CreateAccessBindingRequest, AccessBinding> createAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createAccessBindingCallable()");
  }

  public UnaryCallable<GetAccessBindingRequest, AccessBinding> getAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccessBindingCallable()");
  }

  public UnaryCallable<UpdateAccessBindingRequest, AccessBinding> updateAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccessBindingCallable()");
  }

  public UnaryCallable<DeleteAccessBindingRequest, Empty> deleteAccessBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccessBindingCallable()");
  }

  public UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsPagedResponse>
      listAccessBindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessBindingsPagedCallable()");
  }

  public UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsResponse>
      listAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccessBindingsCallable()");
  }

  public UnaryCallable<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateAccessBindingsCallable()");
  }

  public UnaryCallable<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetAccessBindingsCallable()");
  }

  public UnaryCallable<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateAccessBindingsCallable()");
  }

  public UnaryCallable<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteAccessBindingsCallable()");
  }

  public UnaryCallable<GetExpandedDataSetRequest, ExpandedDataSet> getExpandedDataSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getExpandedDataSetCallable()");
  }

  public UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsPagedResponse>
      listExpandedDataSetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExpandedDataSetsPagedCallable()");
  }

  public UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
      listExpandedDataSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExpandedDataSetsCallable()");
  }

  public UnaryCallable<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createExpandedDataSetCallable()");
  }

  public UnaryCallable<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExpandedDataSetCallable()");
  }

  public UnaryCallable<DeleteExpandedDataSetRequest, Empty> deleteExpandedDataSetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExpandedDataSetCallable()");
  }

  public UnaryCallable<GetChannelGroupRequest, ChannelGroup> getChannelGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getChannelGroupCallable()");
  }

  public UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsPagedResponse>
      listChannelGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelGroupsPagedCallable()");
  }

  public UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsResponse>
      listChannelGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelGroupsCallable()");
  }

  public UnaryCallable<CreateChannelGroupRequest, ChannelGroup> createChannelGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelGroupCallable()");
  }

  public UnaryCallable<UpdateChannelGroupRequest, ChannelGroup> updateChannelGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChannelGroupCallable()");
  }

  public UnaryCallable<DeleteChannelGroupRequest, Empty> deleteChannelGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteChannelGroupCallable()");
  }

  public UnaryCallable<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setAutomatedGa4ConfigurationOptOutCallable()");
  }

  public UnaryCallable<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchAutomatedGa4ConfigurationOptOutCallable()");
  }

  public UnaryCallable<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getBigQueryLinkCallable()");
  }

  public UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksPagedResponse>
      listBigQueryLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBigQueryLinksPagedCallable()");
  }

  public UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listBigQueryLinksCallable()");
  }

  public UnaryCallable<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getEnhancedMeasurementSettingsCallable()");
  }

  public UnaryCallable<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEnhancedMeasurementSettingsCallable()");
  }

  public UnaryCallable<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectedSiteTagCallable()");
  }

  public UnaryCallable<DeleteConnectedSiteTagRequest, Empty> deleteConnectedSiteTagCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectedSiteTagCallable()");
  }

  public UnaryCallable<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectedSiteTagsCallable()");
  }

  public UnaryCallable<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchConnectedGa4PropertyCallable()");
  }

  public UnaryCallable<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getAdSenseLinkCallable()");
  }

  public UnaryCallable<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createAdSenseLinkCallable()");
  }

  public UnaryCallable<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAdSenseLinkCallable()");
  }

  public UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksPagedResponse>
      listAdSenseLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdSenseLinksPagedCallable()");
  }

  public UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
      listAdSenseLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdSenseLinksCallable()");
  }

  public UnaryCallable<GetEventCreateRuleRequest, EventCreateRule> getEventCreateRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getEventCreateRuleCallable()");
  }

  public UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesPagedResponse>
      listEventCreateRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventCreateRulesPagedCallable()");
  }

  public UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
      listEventCreateRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventCreateRulesCallable()");
  }

  public UnaryCallable<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createEventCreateRuleCallable()");
  }

  public UnaryCallable<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEventCreateRuleCallable()");
  }

  public UnaryCallable<DeleteEventCreateRuleRequest, Empty> deleteEventCreateRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEventCreateRuleCallable()");
  }

  public UnaryCallable<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataRedactionSettingsCallable()");
  }

  public UnaryCallable<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataRedactionSettingsCallable()");
  }

  public UnaryCallable<GetCalculatedMetricRequest, CalculatedMetric> getCalculatedMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: getCalculatedMetricCallable()");
  }

  public UnaryCallable<CreateCalculatedMetricRequest, CalculatedMetric>
      createCalculatedMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: createCalculatedMetricCallable()");
  }

  public UnaryCallable<ListCalculatedMetricsRequest, ListCalculatedMetricsPagedResponse>
      listCalculatedMetricsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCalculatedMetricsPagedCallable()");
  }

  public UnaryCallable<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
      listCalculatedMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCalculatedMetricsCallable()");
  }

  public UnaryCallable<UpdateCalculatedMetricRequest, CalculatedMetric>
      updateCalculatedMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCalculatedMetricCallable()");
  }

  public UnaryCallable<DeleteCalculatedMetricRequest, Empty> deleteCalculatedMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCalculatedMetricCallable()");
  }

  public UnaryCallable<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: createRollupPropertyCallable()");
  }

  public UnaryCallable<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getRollupPropertySourceLinkCallable()");
  }

  public UnaryCallable<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksPagedResponse>
      listRollupPropertySourceLinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRollupPropertySourceLinksPagedCallable()");
  }

  public UnaryCallable<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
      listRollupPropertySourceLinksCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRollupPropertySourceLinksCallable()");
  }

  public UnaryCallable<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createRollupPropertySourceLinkCallable()");
  }

  public UnaryCallable<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRollupPropertySourceLinkCallable()");
  }

  public UnaryCallable<CreateSubpropertyRequest, CreateSubpropertyResponse>
      createSubpropertyCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubpropertyCallable()");
  }

  public UnaryCallable<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSubpropertyEventFilterCallable()");
  }

  public UnaryCallable<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterCallable() {
    throw new UnsupportedOperationException("Not implemented: getSubpropertyEventFilterCallable()");
  }

  public UnaryCallable<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersPagedResponse>
      listSubpropertyEventFiltersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSubpropertyEventFiltersPagedCallable()");
  }

  public UnaryCallable<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
      listSubpropertyEventFiltersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSubpropertyEventFiltersCallable()");
  }

  public UnaryCallable<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSubpropertyEventFilterCallable()");
  }

  public UnaryCallable<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSubpropertyEventFilterCallable()");
  }

  @Override
  public abstract void close();
}
