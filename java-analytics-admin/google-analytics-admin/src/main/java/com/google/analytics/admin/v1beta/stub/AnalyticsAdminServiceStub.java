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

package com.google.analytics.admin.v1beta.stub;

import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListAccountSummariesPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListAccountsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListConversionEventsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListCustomDimensionsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListCustomMetricsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListDataStreamsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListMeasurementProtocolSecretsPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1beta.AnalyticsAdminServiceClient.SearchChangeHistoryEventsPagedResponse;

import com.google.analytics.admin.v1beta.Account;
import com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionRequest;
import com.google.analytics.admin.v1beta.AcknowledgeUserDataCollectionResponse;
import com.google.analytics.admin.v1beta.ArchiveCustomDimensionRequest;
import com.google.analytics.admin.v1beta.ArchiveCustomMetricRequest;
import com.google.analytics.admin.v1beta.ConversionEvent;
import com.google.analytics.admin.v1beta.CreateConversionEventRequest;
import com.google.analytics.admin.v1beta.CreateCustomDimensionRequest;
import com.google.analytics.admin.v1beta.CreateCustomMetricRequest;
import com.google.analytics.admin.v1beta.CreateDataStreamRequest;
import com.google.analytics.admin.v1beta.CreateFirebaseLinkRequest;
import com.google.analytics.admin.v1beta.CreateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1beta.CreateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1beta.CreatePropertyRequest;
import com.google.analytics.admin.v1beta.CustomDimension;
import com.google.analytics.admin.v1beta.CustomMetric;
import com.google.analytics.admin.v1beta.DataRetentionSettings;
import com.google.analytics.admin.v1beta.DataSharingSettings;
import com.google.analytics.admin.v1beta.DataStream;
import com.google.analytics.admin.v1beta.DeleteAccountRequest;
import com.google.analytics.admin.v1beta.DeleteConversionEventRequest;
import com.google.analytics.admin.v1beta.DeleteDataStreamRequest;
import com.google.analytics.admin.v1beta.DeleteFirebaseLinkRequest;
import com.google.analytics.admin.v1beta.DeleteGoogleAdsLinkRequest;
import com.google.analytics.admin.v1beta.DeleteMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1beta.DeletePropertyRequest;
import com.google.analytics.admin.v1beta.FirebaseLink;
import com.google.analytics.admin.v1beta.GetAccountRequest;
import com.google.analytics.admin.v1beta.GetConversionEventRequest;
import com.google.analytics.admin.v1beta.GetCustomDimensionRequest;
import com.google.analytics.admin.v1beta.GetCustomMetricRequest;
import com.google.analytics.admin.v1beta.GetDataRetentionSettingsRequest;
import com.google.analytics.admin.v1beta.GetDataSharingSettingsRequest;
import com.google.analytics.admin.v1beta.GetDataStreamRequest;
import com.google.analytics.admin.v1beta.GetMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1beta.GetPropertyRequest;
import com.google.analytics.admin.v1beta.GoogleAdsLink;
import com.google.analytics.admin.v1beta.ListAccountSummariesRequest;
import com.google.analytics.admin.v1beta.ListAccountSummariesResponse;
import com.google.analytics.admin.v1beta.ListAccountsRequest;
import com.google.analytics.admin.v1beta.ListAccountsResponse;
import com.google.analytics.admin.v1beta.ListConversionEventsRequest;
import com.google.analytics.admin.v1beta.ListConversionEventsResponse;
import com.google.analytics.admin.v1beta.ListCustomDimensionsRequest;
import com.google.analytics.admin.v1beta.ListCustomDimensionsResponse;
import com.google.analytics.admin.v1beta.ListCustomMetricsRequest;
import com.google.analytics.admin.v1beta.ListCustomMetricsResponse;
import com.google.analytics.admin.v1beta.ListDataStreamsRequest;
import com.google.analytics.admin.v1beta.ListDataStreamsResponse;
import com.google.analytics.admin.v1beta.ListFirebaseLinksRequest;
import com.google.analytics.admin.v1beta.ListFirebaseLinksResponse;
import com.google.analytics.admin.v1beta.ListGoogleAdsLinksRequest;
import com.google.analytics.admin.v1beta.ListGoogleAdsLinksResponse;
import com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsRequest;
import com.google.analytics.admin.v1beta.ListMeasurementProtocolSecretsResponse;
import com.google.analytics.admin.v1beta.ListPropertiesRequest;
import com.google.analytics.admin.v1beta.ListPropertiesResponse;
import com.google.analytics.admin.v1beta.MeasurementProtocolSecret;
import com.google.analytics.admin.v1beta.Property;
import com.google.analytics.admin.v1beta.ProvisionAccountTicketRequest;
import com.google.analytics.admin.v1beta.ProvisionAccountTicketResponse;
import com.google.analytics.admin.v1beta.SearchChangeHistoryEventsRequest;
import com.google.analytics.admin.v1beta.SearchChangeHistoryEventsResponse;
import com.google.analytics.admin.v1beta.UpdateAccountRequest;
import com.google.analytics.admin.v1beta.UpdateCustomDimensionRequest;
import com.google.analytics.admin.v1beta.UpdateCustomMetricRequest;
import com.google.analytics.admin.v1beta.UpdateDataRetentionSettingsRequest;
import com.google.analytics.admin.v1beta.UpdateDataStreamRequest;
import com.google.analytics.admin.v1beta.UpdateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1beta.UpdateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1beta.UpdatePropertyRequest;
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

  @Override
  public abstract void close();
}
