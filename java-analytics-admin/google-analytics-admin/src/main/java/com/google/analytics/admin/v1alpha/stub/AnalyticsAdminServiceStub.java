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

package com.google.analytics.admin.v1alpha.stub;

import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.AuditUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAudiencesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListConversionEventsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomDimensionsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListCustomMetricsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinkProposalsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListDisplayVideo360AdvertiserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListMeasurementProtocolSecretsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.SearchChangeHistoryEventsPagedResponse;

import com.google.analytics.admin.v1alpha.Account;
import com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest;
import com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse;
import com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse;
import com.google.analytics.admin.v1alpha.ArchiveAudienceRequest;
import com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest;
import com.google.analytics.admin.v1alpha.AttributionSettings;
import com.google.analytics.admin.v1alpha.Audience;
import com.google.analytics.admin.v1alpha.AuditUserLinksRequest;
import com.google.analytics.admin.v1alpha.AuditUserLinksResponse;
import com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse;
import com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse;
import com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse;
import com.google.analytics.admin.v1alpha.CancelDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.ConversionEvent;
import com.google.analytics.admin.v1alpha.CreateAudienceRequest;
import com.google.analytics.admin.v1alpha.CreateConversionEventRequest;
import com.google.analytics.admin.v1alpha.CreateCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.CreateCustomMetricRequest;
import com.google.analytics.admin.v1alpha.CreateDataStreamRequest;
import com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.CreateDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.CreatePropertyRequest;
import com.google.analytics.admin.v1alpha.CreateUserLinkRequest;
import com.google.analytics.admin.v1alpha.CustomDimension;
import com.google.analytics.admin.v1alpha.CustomMetric;
import com.google.analytics.admin.v1alpha.DataRetentionSettings;
import com.google.analytics.admin.v1alpha.DataSharingSettings;
import com.google.analytics.admin.v1alpha.DataStream;
import com.google.analytics.admin.v1alpha.DeleteAccountRequest;
import com.google.analytics.admin.v1alpha.DeleteConversionEventRequest;
import com.google.analytics.admin.v1alpha.DeleteDataStreamRequest;
import com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.DeletePropertyRequest;
import com.google.analytics.admin.v1alpha.DeleteUserLinkRequest;
import com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLink;
import com.google.analytics.admin.v1alpha.DisplayVideo360AdvertiserLinkProposal;
import com.google.analytics.admin.v1alpha.FirebaseLink;
import com.google.analytics.admin.v1alpha.GetAccountRequest;
import com.google.analytics.admin.v1alpha.GetAttributionSettingsRequest;
import com.google.analytics.admin.v1alpha.GetAudienceRequest;
import com.google.analytics.admin.v1alpha.GetConversionEventRequest;
import com.google.analytics.admin.v1alpha.GetCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.GetCustomMetricRequest;
import com.google.analytics.admin.v1alpha.GetDataRetentionSettingsRequest;
import com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest;
import com.google.analytics.admin.v1alpha.GetDataStreamRequest;
import com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.GetDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest;
import com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest;
import com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.GetPropertyRequest;
import com.google.analytics.admin.v1alpha.GetUserLinkRequest;
import com.google.analytics.admin.v1alpha.GlobalSiteTag;
import com.google.analytics.admin.v1alpha.GoogleAdsLink;
import com.google.analytics.admin.v1alpha.GoogleSignalsSettings;
import com.google.analytics.admin.v1alpha.ListAccountSummariesRequest;
import com.google.analytics.admin.v1alpha.ListAccountSummariesResponse;
import com.google.analytics.admin.v1alpha.ListAccountsRequest;
import com.google.analytics.admin.v1alpha.ListAccountsResponse;
import com.google.analytics.admin.v1alpha.ListAudiencesRequest;
import com.google.analytics.admin.v1alpha.ListAudiencesResponse;
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
import com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse;
import com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsRequest;
import com.google.analytics.admin.v1alpha.ListMeasurementProtocolSecretsResponse;
import com.google.analytics.admin.v1alpha.ListPropertiesRequest;
import com.google.analytics.admin.v1alpha.ListPropertiesResponse;
import com.google.analytics.admin.v1alpha.ListUserLinksRequest;
import com.google.analytics.admin.v1alpha.ListUserLinksResponse;
import com.google.analytics.admin.v1alpha.MeasurementProtocolSecret;
import com.google.analytics.admin.v1alpha.Property;
import com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest;
import com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse;
import com.google.analytics.admin.v1alpha.RunAccessReportRequest;
import com.google.analytics.admin.v1alpha.RunAccessReportResponse;
import com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsRequest;
import com.google.analytics.admin.v1alpha.SearchChangeHistoryEventsResponse;
import com.google.analytics.admin.v1alpha.UpdateAccountRequest;
import com.google.analytics.admin.v1alpha.UpdateAttributionSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateAudienceRequest;
import com.google.analytics.admin.v1alpha.UpdateCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.UpdateCustomMetricRequest;
import com.google.analytics.admin.v1alpha.UpdateDataRetentionSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateDataStreamRequest;
import com.google.analytics.admin.v1alpha.UpdateDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.UpdatePropertyRequest;
import com.google.analytics.admin.v1alpha.UpdateUserLinkRequest;
import com.google.analytics.admin.v1alpha.UserLink;
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

  public UnaryCallable<GetUserLinkRequest, UserLink> getUserLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserLinkCallable()");
  }

  public UnaryCallable<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetUserLinksCallable()");
  }

  public UnaryCallable<ListUserLinksRequest, ListUserLinksPagedResponse>
      listUserLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserLinksPagedCallable()");
  }

  public UnaryCallable<ListUserLinksRequest, ListUserLinksResponse> listUserLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserLinksCallable()");
  }

  public UnaryCallable<AuditUserLinksRequest, AuditUserLinksPagedResponse>
      auditUserLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: auditUserLinksPagedCallable()");
  }

  public UnaryCallable<AuditUserLinksRequest, AuditUserLinksResponse> auditUserLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: auditUserLinksCallable()");
  }

  public UnaryCallable<CreateUserLinkRequest, UserLink> createUserLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserLinkCallable()");
  }

  public UnaryCallable<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateUserLinksCallable()");
  }

  public UnaryCallable<UpdateUserLinkRequest, UserLink> updateUserLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserLinkCallable()");
  }

  public UnaryCallable<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateUserLinksCallable()");
  }

  public UnaryCallable<DeleteUserLinkRequest, Empty> deleteUserLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserLinkCallable()");
  }

  public UnaryCallable<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteUserLinksCallable()");
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

  @Override
  public abstract void close();
}
