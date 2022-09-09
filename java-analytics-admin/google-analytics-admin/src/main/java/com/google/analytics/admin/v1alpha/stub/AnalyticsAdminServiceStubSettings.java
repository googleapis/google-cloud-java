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
import com.google.analytics.admin.v1alpha.AccountSummary;
import com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionRequest;
import com.google.analytics.admin.v1alpha.AcknowledgeUserDataCollectionResponse;
import com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.ApproveDisplayVideo360AdvertiserLinkProposalResponse;
import com.google.analytics.admin.v1alpha.ArchiveAudienceRequest;
import com.google.analytics.admin.v1alpha.ArchiveCustomDimensionRequest;
import com.google.analytics.admin.v1alpha.ArchiveCustomMetricRequest;
import com.google.analytics.admin.v1alpha.AttributionSettings;
import com.google.analytics.admin.v1alpha.Audience;
import com.google.analytics.admin.v1alpha.AuditUserLink;
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
import com.google.analytics.admin.v1alpha.ChangeHistoryEvent;
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
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AnalyticsAdminServiceStub}.
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
 * AnalyticsAdminServiceStubSettings.Builder analyticsAdminServiceSettingsBuilder =
 *     AnalyticsAdminServiceStubSettings.newBuilder();
 * analyticsAdminServiceSettingsBuilder
 *     .getAccountSettings()
 *     .setRetrySettings(
 *         analyticsAdminServiceSettingsBuilder.getAccountSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AnalyticsAdminServiceStubSettings analyticsAdminServiceSettings =
 *     analyticsAdminServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AnalyticsAdminServiceStubSettings
    extends StubSettings<AnalyticsAdminServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/analytics.edit")
          .add("https://www.googleapis.com/auth/analytics.manage.users")
          .add("https://www.googleapis.com/auth/analytics.manage.users.readonly")
          .add("https://www.googleapis.com/auth/analytics.readonly")
          .build();

  private final UnaryCallSettings<GetAccountRequest, Account> getAccountSettings;
  private final PagedCallSettings<
          ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
      listAccountsSettings;
  private final UnaryCallSettings<DeleteAccountRequest, Empty> deleteAccountSettings;
  private final UnaryCallSettings<UpdateAccountRequest, Account> updateAccountSettings;
  private final UnaryCallSettings<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketSettings;
  private final PagedCallSettings<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          ListAccountSummariesPagedResponse>
      listAccountSummariesSettings;
  private final UnaryCallSettings<GetPropertyRequest, Property> getPropertySettings;
  private final PagedCallSettings<
          ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
      listPropertiesSettings;
  private final UnaryCallSettings<CreatePropertyRequest, Property> createPropertySettings;
  private final UnaryCallSettings<DeletePropertyRequest, Property> deletePropertySettings;
  private final UnaryCallSettings<UpdatePropertyRequest, Property> updatePropertySettings;
  private final UnaryCallSettings<GetUserLinkRequest, UserLink> getUserLinkSettings;
  private final UnaryCallSettings<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksSettings;
  private final PagedCallSettings<
          ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
      listUserLinksSettings;
  private final PagedCallSettings<
          AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
      auditUserLinksSettings;
  private final UnaryCallSettings<CreateUserLinkRequest, UserLink> createUserLinkSettings;
  private final UnaryCallSettings<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksSettings;
  private final UnaryCallSettings<UpdateUserLinkRequest, UserLink> updateUserLinkSettings;
  private final UnaryCallSettings<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksSettings;
  private final UnaryCallSettings<DeleteUserLinkRequest, Empty> deleteUserLinkSettings;
  private final UnaryCallSettings<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksSettings;
  private final UnaryCallSettings<CreateFirebaseLinkRequest, FirebaseLink>
      createFirebaseLinkSettings;
  private final UnaryCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkSettings;
  private final PagedCallSettings<
          ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
      listFirebaseLinksSettings;
  private final UnaryCallSettings<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagSettings;
  private final UnaryCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkSettings;
  private final UnaryCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkSettings;
  private final UnaryCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkSettings;
  private final PagedCallSettings<
          ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksSettings;
  private final UnaryCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsSettings;
  private final UnaryCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretSettings;
  private final PagedCallSettings<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsSettings;
  private final UnaryCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretSettings;
  private final UnaryCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretSettings;
  private final UnaryCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretSettings;
  private final UnaryCallSettings<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionSettings;
  private final PagedCallSettings<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsSettings;
  private final UnaryCallSettings<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsSettings;
  private final UnaryCallSettings<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsSettings;
  private final UnaryCallSettings<CreateConversionEventRequest, ConversionEvent>
      createConversionEventSettings;
  private final UnaryCallSettings<GetConversionEventRequest, ConversionEvent>
      getConversionEventSettings;
  private final UnaryCallSettings<DeleteConversionEventRequest, Empty>
      deleteConversionEventSettings;
  private final PagedCallSettings<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ListConversionEventsPagedResponse>
      listConversionEventsSettings;
  private final UnaryCallSettings<
          GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkSettings;
  private final PagedCallSettings<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksSettings;
  private final UnaryCallSettings<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkSettings;
  private final UnaryCallSettings<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkSettings;
  private final UnaryCallSettings<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkSettings;
  private final UnaryCallSettings<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalSettings;
  private final PagedCallSettings<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      listDisplayVideo360AdvertiserLinkProposalsSettings;
  private final UnaryCallSettings<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalSettings;
  private final UnaryCallSettings<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalSettings;
  private final UnaryCallSettings<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalSettings;
  private final UnaryCallSettings<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalSettings;
  private final UnaryCallSettings<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionSettings;
  private final UnaryCallSettings<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionSettings;
  private final PagedCallSettings<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          ListCustomDimensionsPagedResponse>
      listCustomDimensionsSettings;
  private final UnaryCallSettings<ArchiveCustomDimensionRequest, Empty>
      archiveCustomDimensionSettings;
  private final UnaryCallSettings<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionSettings;
  private final UnaryCallSettings<CreateCustomMetricRequest, CustomMetric>
      createCustomMetricSettings;
  private final UnaryCallSettings<UpdateCustomMetricRequest, CustomMetric>
      updateCustomMetricSettings;
  private final PagedCallSettings<
          ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
      listCustomMetricsSettings;
  private final UnaryCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricSettings;
  private final UnaryCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricSettings;
  private final UnaryCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsSettings;
  private final UnaryCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsSettings;
  private final UnaryCallSettings<CreateDataStreamRequest, DataStream> createDataStreamSettings;
  private final UnaryCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamSettings;
  private final UnaryCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamSettings;
  private final PagedCallSettings<
          ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
      listDataStreamsSettings;
  private final UnaryCallSettings<GetDataStreamRequest, DataStream> getDataStreamSettings;
  private final UnaryCallSettings<GetAudienceRequest, Audience> getAudienceSettings;
  private final PagedCallSettings<
          ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
      listAudiencesSettings;
  private final UnaryCallSettings<CreateAudienceRequest, Audience> createAudienceSettings;
  private final UnaryCallSettings<UpdateAudienceRequest, Audience> updateAudienceSettings;
  private final UnaryCallSettings<ArchiveAudienceRequest, Empty> archiveAudienceSettings;
  private final UnaryCallSettings<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsSettings;
  private final UnaryCallSettings<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsSettings;
  private final UnaryCallSettings<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportSettings;

  private static final PagedListDescriptor<ListAccountsRequest, ListAccountsResponse, Account>
      LIST_ACCOUNTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAccountsRequest, ListAccountsResponse, Account>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccountsRequest injectToken(ListAccountsRequest payload, String token) {
              return ListAccountsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccountsRequest injectPageSize(ListAccountsRequest payload, int pageSize) {
              return ListAccountsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccountsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccountsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Account> extractResources(ListAccountsResponse payload) {
              return payload.getAccountsList() == null
                  ? ImmutableList.<Account>of()
                  : payload.getAccountsList();
            }
          };

  private static final PagedListDescriptor<
          ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>
      LIST_ACCOUNT_SUMMARIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccountSummariesRequest injectToken(
                ListAccountSummariesRequest payload, String token) {
              return ListAccountSummariesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccountSummariesRequest injectPageSize(
                ListAccountSummariesRequest payload, int pageSize) {
              return ListAccountSummariesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccountSummariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccountSummariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccountSummary> extractResources(ListAccountSummariesResponse payload) {
              return payload.getAccountSummariesList() == null
                  ? ImmutableList.<AccountSummary>of()
                  : payload.getAccountSummariesList();
            }
          };

  private static final PagedListDescriptor<ListPropertiesRequest, ListPropertiesResponse, Property>
      LIST_PROPERTIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPropertiesRequest, ListPropertiesResponse, Property>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPropertiesRequest injectToken(ListPropertiesRequest payload, String token) {
              return ListPropertiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPropertiesRequest injectPageSize(
                ListPropertiesRequest payload, int pageSize) {
              return ListPropertiesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPropertiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPropertiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Property> extractResources(ListPropertiesResponse payload) {
              return payload.getPropertiesList() == null
                  ? ImmutableList.<Property>of()
                  : payload.getPropertiesList();
            }
          };

  private static final PagedListDescriptor<ListUserLinksRequest, ListUserLinksResponse, UserLink>
      LIST_USER_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUserLinksRequest, ListUserLinksResponse, UserLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserLinksRequest injectToken(ListUserLinksRequest payload, String token) {
              return ListUserLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUserLinksRequest injectPageSize(ListUserLinksRequest payload, int pageSize) {
              return ListUserLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUserLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserLink> extractResources(ListUserLinksResponse payload) {
              return payload.getUserLinksList() == null
                  ? ImmutableList.<UserLink>of()
                  : payload.getUserLinksList();
            }
          };

  private static final PagedListDescriptor<
          AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink>
      AUDIT_USER_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AuditUserLinksRequest injectToken(AuditUserLinksRequest payload, String token) {
              return AuditUserLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AuditUserLinksRequest injectPageSize(
                AuditUserLinksRequest payload, int pageSize) {
              return AuditUserLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(AuditUserLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(AuditUserLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AuditUserLink> extractResources(AuditUserLinksResponse payload) {
              return payload.getUserLinksList() == null
                  ? ImmutableList.<AuditUserLink>of()
                  : payload.getUserLinksList();
            }
          };

  private static final PagedListDescriptor<
          ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink>
      LIST_FIREBASE_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFirebaseLinksRequest injectToken(
                ListFirebaseLinksRequest payload, String token) {
              return ListFirebaseLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFirebaseLinksRequest injectPageSize(
                ListFirebaseLinksRequest payload, int pageSize) {
              return ListFirebaseLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFirebaseLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFirebaseLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FirebaseLink> extractResources(ListFirebaseLinksResponse payload) {
              return payload.getFirebaseLinksList() == null
                  ? ImmutableList.<FirebaseLink>of()
                  : payload.getFirebaseLinksList();
            }
          };

  private static final PagedListDescriptor<
          ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink>
      LIST_GOOGLE_ADS_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGoogleAdsLinksRequest injectToken(
                ListGoogleAdsLinksRequest payload, String token) {
              return ListGoogleAdsLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGoogleAdsLinksRequest injectPageSize(
                ListGoogleAdsLinksRequest payload, int pageSize) {
              return ListGoogleAdsLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGoogleAdsLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGoogleAdsLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GoogleAdsLink> extractResources(ListGoogleAdsLinksResponse payload) {
              return payload.getGoogleAdsLinksList() == null
                  ? ImmutableList.<GoogleAdsLink>of()
                  : payload.getGoogleAdsLinksList();
            }
          };

  private static final PagedListDescriptor<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          MeasurementProtocolSecret>
      LIST_MEASUREMENT_PROTOCOL_SECRETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMeasurementProtocolSecretsRequest,
              ListMeasurementProtocolSecretsResponse,
              MeasurementProtocolSecret>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMeasurementProtocolSecretsRequest injectToken(
                ListMeasurementProtocolSecretsRequest payload, String token) {
              return ListMeasurementProtocolSecretsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMeasurementProtocolSecretsRequest injectPageSize(
                ListMeasurementProtocolSecretsRequest payload, int pageSize) {
              return ListMeasurementProtocolSecretsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMeasurementProtocolSecretsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMeasurementProtocolSecretsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MeasurementProtocolSecret> extractResources(
                ListMeasurementProtocolSecretsResponse payload) {
              return payload.getMeasurementProtocolSecretsList() == null
                  ? ImmutableList.<MeasurementProtocolSecret>of()
                  : payload.getMeasurementProtocolSecretsList();
            }
          };

  private static final PagedListDescriptor<
          SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse, ChangeHistoryEvent>
      SEARCH_CHANGE_HISTORY_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchChangeHistoryEventsRequest,
              SearchChangeHistoryEventsResponse,
              ChangeHistoryEvent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchChangeHistoryEventsRequest injectToken(
                SearchChangeHistoryEventsRequest payload, String token) {
              return SearchChangeHistoryEventsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchChangeHistoryEventsRequest injectPageSize(
                SearchChangeHistoryEventsRequest payload, int pageSize) {
              return SearchChangeHistoryEventsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchChangeHistoryEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchChangeHistoryEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ChangeHistoryEvent> extractResources(
                SearchChangeHistoryEventsResponse payload) {
              return payload.getChangeHistoryEventsList() == null
                  ? ImmutableList.<ChangeHistoryEvent>of()
                  : payload.getChangeHistoryEventsList();
            }
          };

  private static final PagedListDescriptor<
          ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>
      LIST_CONVERSION_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversionEventsRequest injectToken(
                ListConversionEventsRequest payload, String token) {
              return ListConversionEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversionEventsRequest injectPageSize(
                ListConversionEventsRequest payload, int pageSize) {
              return ListConversionEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConversionEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversionEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConversionEvent> extractResources(
                ListConversionEventsResponse payload) {
              return payload.getConversionEventsList() == null
                  ? ImmutableList.<ConversionEvent>of()
                  : payload.getConversionEventsList();
            }
          };

  private static final PagedListDescriptor<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          DisplayVideo360AdvertiserLink>
      LIST_DISPLAY_VIDEO360_ADVERTISER_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDisplayVideo360AdvertiserLinksRequest,
              ListDisplayVideo360AdvertiserLinksResponse,
              DisplayVideo360AdvertiserLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDisplayVideo360AdvertiserLinksRequest injectToken(
                ListDisplayVideo360AdvertiserLinksRequest payload, String token) {
              return ListDisplayVideo360AdvertiserLinksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDisplayVideo360AdvertiserLinksRequest injectPageSize(
                ListDisplayVideo360AdvertiserLinksRequest payload, int pageSize) {
              return ListDisplayVideo360AdvertiserLinksRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDisplayVideo360AdvertiserLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDisplayVideo360AdvertiserLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DisplayVideo360AdvertiserLink> extractResources(
                ListDisplayVideo360AdvertiserLinksResponse payload) {
              return payload.getDisplayVideo360AdvertiserLinksList() == null
                  ? ImmutableList.<DisplayVideo360AdvertiserLink>of()
                  : payload.getDisplayVideo360AdvertiserLinksList();
            }
          };

  private static final PagedListDescriptor<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          DisplayVideo360AdvertiserLinkProposal>
      LIST_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSALS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDisplayVideo360AdvertiserLinkProposalsRequest,
              ListDisplayVideo360AdvertiserLinkProposalsResponse,
              DisplayVideo360AdvertiserLinkProposal>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDisplayVideo360AdvertiserLinkProposalsRequest injectToken(
                ListDisplayVideo360AdvertiserLinkProposalsRequest payload, String token) {
              return ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDisplayVideo360AdvertiserLinkProposalsRequest injectPageSize(
                ListDisplayVideo360AdvertiserLinkProposalsRequest payload, int pageSize) {
              return ListDisplayVideo360AdvertiserLinkProposalsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListDisplayVideo360AdvertiserLinkProposalsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListDisplayVideo360AdvertiserLinkProposalsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DisplayVideo360AdvertiserLinkProposal> extractResources(
                ListDisplayVideo360AdvertiserLinkProposalsResponse payload) {
              return payload.getDisplayVideo360AdvertiserLinkProposalsList() == null
                  ? ImmutableList.<DisplayVideo360AdvertiserLinkProposal>of()
                  : payload.getDisplayVideo360AdvertiserLinkProposalsList();
            }
          };

  private static final PagedListDescriptor<
          ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>
      LIST_CUSTOM_DIMENSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomDimensionsRequest injectToken(
                ListCustomDimensionsRequest payload, String token) {
              return ListCustomDimensionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomDimensionsRequest injectPageSize(
                ListCustomDimensionsRequest payload, int pageSize) {
              return ListCustomDimensionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomDimensionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomDimensionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomDimension> extractResources(
                ListCustomDimensionsResponse payload) {
              return payload.getCustomDimensionsList() == null
                  ? ImmutableList.<CustomDimension>of()
                  : payload.getCustomDimensionsList();
            }
          };

  private static final PagedListDescriptor<
          ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric>
      LIST_CUSTOM_METRICS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomMetricsRequest injectToken(
                ListCustomMetricsRequest payload, String token) {
              return ListCustomMetricsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomMetricsRequest injectPageSize(
                ListCustomMetricsRequest payload, int pageSize) {
              return ListCustomMetricsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomMetricsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomMetricsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomMetric> extractResources(ListCustomMetricsResponse payload) {
              return payload.getCustomMetricsList() == null
                  ? ImmutableList.<CustomMetric>of()
                  : payload.getCustomMetricsList();
            }
          };

  private static final PagedListDescriptor<
          ListDataStreamsRequest, ListDataStreamsResponse, DataStream>
      LIST_DATA_STREAMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataStreamsRequest, ListDataStreamsResponse, DataStream>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataStreamsRequest injectToken(
                ListDataStreamsRequest payload, String token) {
              return ListDataStreamsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataStreamsRequest injectPageSize(
                ListDataStreamsRequest payload, int pageSize) {
              return ListDataStreamsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataStreamsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataStreamsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataStream> extractResources(ListDataStreamsResponse payload) {
              return payload.getDataStreamsList() == null
                  ? ImmutableList.<DataStream>of()
                  : payload.getDataStreamsList();
            }
          };

  private static final PagedListDescriptor<ListAudiencesRequest, ListAudiencesResponse, Audience>
      LIST_AUDIENCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAudiencesRequest, ListAudiencesResponse, Audience>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAudiencesRequest injectToken(ListAudiencesRequest payload, String token) {
              return ListAudiencesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAudiencesRequest injectPageSize(ListAudiencesRequest payload, int pageSize) {
              return ListAudiencesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAudiencesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAudiencesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Audience> extractResources(ListAudiencesResponse payload) {
              return payload.getAudiencesList() == null
                  ? ImmutableList.<Audience>of()
                  : payload.getAudiencesList();
            }
          };

  private static final PagedListResponseFactory<
          ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
      LIST_ACCOUNTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>() {
            @Override
            public ApiFuture<ListAccountsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccountsRequest, ListAccountsResponse> callable,
                ListAccountsRequest request,
                ApiCallContext context,
                ApiFuture<ListAccountsResponse> futureResponse) {
              PageContext<ListAccountsRequest, ListAccountsResponse, Account> pageContext =
                  PageContext.create(callable, LIST_ACCOUNTS_PAGE_STR_DESC, request, context);
              return ListAccountsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          ListAccountSummariesPagedResponse>
      LIST_ACCOUNT_SUMMARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccountSummariesRequest,
              ListAccountSummariesResponse,
              ListAccountSummariesPagedResponse>() {
            @Override
            public ApiFuture<ListAccountSummariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesResponse> callable,
                ListAccountSummariesRequest request,
                ApiCallContext context,
                ApiFuture<ListAccountSummariesResponse> futureResponse) {
              PageContext<ListAccountSummariesRequest, ListAccountSummariesResponse, AccountSummary>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCOUNT_SUMMARIES_PAGE_STR_DESC, request, context);
              return ListAccountSummariesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
      LIST_PROPERTIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>() {
            @Override
            public ApiFuture<ListPropertiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPropertiesRequest, ListPropertiesResponse> callable,
                ListPropertiesRequest request,
                ApiCallContext context,
                ApiFuture<ListPropertiesResponse> futureResponse) {
              PageContext<ListPropertiesRequest, ListPropertiesResponse, Property> pageContext =
                  PageContext.create(callable, LIST_PROPERTIES_PAGE_STR_DESC, request, context);
              return ListPropertiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
      LIST_USER_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>() {
            @Override
            public ApiFuture<ListUserLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserLinksRequest, ListUserLinksResponse> callable,
                ListUserLinksRequest request,
                ApiCallContext context,
                ApiFuture<ListUserLinksResponse> futureResponse) {
              PageContext<ListUserLinksRequest, ListUserLinksResponse, UserLink> pageContext =
                  PageContext.create(callable, LIST_USER_LINKS_PAGE_STR_DESC, request, context);
              return ListUserLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
      AUDIT_USER_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>() {
            @Override
            public ApiFuture<AuditUserLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<AuditUserLinksRequest, AuditUserLinksResponse> callable,
                AuditUserLinksRequest request,
                ApiCallContext context,
                ApiFuture<AuditUserLinksResponse> futureResponse) {
              PageContext<AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLink>
                  pageContext =
                      PageContext.create(
                          callable, AUDIT_USER_LINKS_PAGE_STR_DESC, request, context);
              return AuditUserLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
      LIST_FIREBASE_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFirebaseLinksRequest,
              ListFirebaseLinksResponse,
              ListFirebaseLinksPagedResponse>() {
            @Override
            public ApiFuture<ListFirebaseLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksResponse> callable,
                ListFirebaseLinksRequest request,
                ApiCallContext context,
                ApiFuture<ListFirebaseLinksResponse> futureResponse) {
              PageContext<ListFirebaseLinksRequest, ListFirebaseLinksResponse, FirebaseLink>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FIREBASE_LINKS_PAGE_STR_DESC, request, context);
              return ListFirebaseLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
      LIST_GOOGLE_ADS_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGoogleAdsLinksRequest,
              ListGoogleAdsLinksResponse,
              ListGoogleAdsLinksPagedResponse>() {
            @Override
            public ApiFuture<ListGoogleAdsLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse> callable,
                ListGoogleAdsLinksRequest request,
                ApiCallContext context,
                ApiFuture<ListGoogleAdsLinksResponse> futureResponse) {
              PageContext<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, GoogleAdsLink>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GOOGLE_ADS_LINKS_PAGE_STR_DESC, request, context);
              return ListGoogleAdsLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          ListMeasurementProtocolSecretsPagedResponse>
      LIST_MEASUREMENT_PROTOCOL_SECRETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMeasurementProtocolSecretsRequest,
              ListMeasurementProtocolSecretsResponse,
              ListMeasurementProtocolSecretsPagedResponse>() {
            @Override
            public ApiFuture<ListMeasurementProtocolSecretsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListMeasurementProtocolSecretsRequest,
                        ListMeasurementProtocolSecretsResponse>
                    callable,
                ListMeasurementProtocolSecretsRequest request,
                ApiCallContext context,
                ApiFuture<ListMeasurementProtocolSecretsResponse> futureResponse) {
              PageContext<
                      ListMeasurementProtocolSecretsRequest,
                      ListMeasurementProtocolSecretsResponse,
                      MeasurementProtocolSecret>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MEASUREMENT_PROTOCOL_SECRETS_PAGE_STR_DESC,
                          request,
                          context);
              return ListMeasurementProtocolSecretsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          SearchChangeHistoryEventsPagedResponse>
      SEARCH_CHANGE_HISTORY_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchChangeHistoryEventsRequest,
              SearchChangeHistoryEventsResponse,
              SearchChangeHistoryEventsPagedResponse>() {
            @Override
            public ApiFuture<SearchChangeHistoryEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
                    callable,
                SearchChangeHistoryEventsRequest request,
                ApiCallContext context,
                ApiFuture<SearchChangeHistoryEventsResponse> futureResponse) {
              PageContext<
                      SearchChangeHistoryEventsRequest,
                      SearchChangeHistoryEventsResponse,
                      ChangeHistoryEvent>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_CHANGE_HISTORY_EVENTS_PAGE_STR_DESC, request, context);
              return SearchChangeHistoryEventsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ListConversionEventsPagedResponse>
      LIST_CONVERSION_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversionEventsRequest,
              ListConversionEventsResponse,
              ListConversionEventsPagedResponse>() {
            @Override
            public ApiFuture<ListConversionEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversionEventsRequest, ListConversionEventsResponse> callable,
                ListConversionEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversionEventsResponse> futureResponse) {
              PageContext<
                      ListConversionEventsRequest, ListConversionEventsResponse, ConversionEvent>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSION_EVENTS_PAGE_STR_DESC, request, context);
              return ListConversionEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      LIST_DISPLAY_VIDEO360_ADVERTISER_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDisplayVideo360AdvertiserLinksRequest,
              ListDisplayVideo360AdvertiserLinksResponse,
              ListDisplayVideo360AdvertiserLinksPagedResponse>() {
            @Override
            public ApiFuture<ListDisplayVideo360AdvertiserLinksPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListDisplayVideo360AdvertiserLinksRequest,
                            ListDisplayVideo360AdvertiserLinksResponse>
                        callable,
                    ListDisplayVideo360AdvertiserLinksRequest request,
                    ApiCallContext context,
                    ApiFuture<ListDisplayVideo360AdvertiserLinksResponse> futureResponse) {
              PageContext<
                      ListDisplayVideo360AdvertiserLinksRequest,
                      ListDisplayVideo360AdvertiserLinksResponse,
                      DisplayVideo360AdvertiserLink>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_DISPLAY_VIDEO360_ADVERTISER_LINKS_PAGE_STR_DESC,
                          request,
                          context);
              return ListDisplayVideo360AdvertiserLinksPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      LIST_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSALS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDisplayVideo360AdvertiserLinkProposalsRequest,
              ListDisplayVideo360AdvertiserLinkProposalsResponse,
              ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>() {
            @Override
            public ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListDisplayVideo360AdvertiserLinkProposalsRequest,
                            ListDisplayVideo360AdvertiserLinkProposalsResponse>
                        callable,
                    ListDisplayVideo360AdvertiserLinkProposalsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListDisplayVideo360AdvertiserLinkProposalsResponse> futureResponse) {
              PageContext<
                      ListDisplayVideo360AdvertiserLinkProposalsRequest,
                      ListDisplayVideo360AdvertiserLinkProposalsResponse,
                      DisplayVideo360AdvertiserLinkProposal>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSALS_PAGE_STR_DESC,
                          request,
                          context);
              return ListDisplayVideo360AdvertiserLinkProposalsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          ListCustomDimensionsPagedResponse>
      LIST_CUSTOM_DIMENSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomDimensionsRequest,
              ListCustomDimensionsResponse,
              ListCustomDimensionsPagedResponse>() {
            @Override
            public ApiFuture<ListCustomDimensionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsResponse> callable,
                ListCustomDimensionsRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomDimensionsResponse> futureResponse) {
              PageContext<
                      ListCustomDimensionsRequest, ListCustomDimensionsResponse, CustomDimension>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_DIMENSIONS_PAGE_STR_DESC, request, context);
              return ListCustomDimensionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
      LIST_CUSTOM_METRICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomMetricsRequest,
              ListCustomMetricsResponse,
              ListCustomMetricsPagedResponse>() {
            @Override
            public ApiFuture<ListCustomMetricsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsResponse> callable,
                ListCustomMetricsRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomMetricsResponse> futureResponse) {
              PageContext<ListCustomMetricsRequest, ListCustomMetricsResponse, CustomMetric>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_METRICS_PAGE_STR_DESC, request, context);
              return ListCustomMetricsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
      LIST_DATA_STREAMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>() {
            @Override
            public ApiFuture<ListDataStreamsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataStreamsRequest, ListDataStreamsResponse> callable,
                ListDataStreamsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataStreamsResponse> futureResponse) {
              PageContext<ListDataStreamsRequest, ListDataStreamsResponse, DataStream> pageContext =
                  PageContext.create(callable, LIST_DATA_STREAMS_PAGE_STR_DESC, request, context);
              return ListDataStreamsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
      LIST_AUDIENCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>() {
            @Override
            public ApiFuture<ListAudiencesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAudiencesRequest, ListAudiencesResponse> callable,
                ListAudiencesRequest request,
                ApiCallContext context,
                ApiFuture<ListAudiencesResponse> futureResponse) {
              PageContext<ListAudiencesRequest, ListAudiencesResponse, Audience> pageContext =
                  PageContext.create(callable, LIST_AUDIENCES_PAGE_STR_DESC, request, context);
              return ListAudiencesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getAccount. */
  public UnaryCallSettings<GetAccountRequest, Account> getAccountSettings() {
    return getAccountSettings;
  }

  /** Returns the object with the settings used for calls to listAccounts. */
  public PagedCallSettings<ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
      listAccountsSettings() {
    return listAccountsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccount. */
  public UnaryCallSettings<DeleteAccountRequest, Empty> deleteAccountSettings() {
    return deleteAccountSettings;
  }

  /** Returns the object with the settings used for calls to updateAccount. */
  public UnaryCallSettings<UpdateAccountRequest, Account> updateAccountSettings() {
    return updateAccountSettings;
  }

  /** Returns the object with the settings used for calls to provisionAccountTicket. */
  public UnaryCallSettings<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketSettings() {
    return provisionAccountTicketSettings;
  }

  /** Returns the object with the settings used for calls to listAccountSummaries. */
  public PagedCallSettings<
          ListAccountSummariesRequest,
          ListAccountSummariesResponse,
          ListAccountSummariesPagedResponse>
      listAccountSummariesSettings() {
    return listAccountSummariesSettings;
  }

  /** Returns the object with the settings used for calls to getProperty. */
  public UnaryCallSettings<GetPropertyRequest, Property> getPropertySettings() {
    return getPropertySettings;
  }

  /** Returns the object with the settings used for calls to listProperties. */
  public PagedCallSettings<
          ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
      listPropertiesSettings() {
    return listPropertiesSettings;
  }

  /** Returns the object with the settings used for calls to createProperty. */
  public UnaryCallSettings<CreatePropertyRequest, Property> createPropertySettings() {
    return createPropertySettings;
  }

  /** Returns the object with the settings used for calls to deleteProperty. */
  public UnaryCallSettings<DeletePropertyRequest, Property> deletePropertySettings() {
    return deletePropertySettings;
  }

  /** Returns the object with the settings used for calls to updateProperty. */
  public UnaryCallSettings<UpdatePropertyRequest, Property> updatePropertySettings() {
    return updatePropertySettings;
  }

  /** Returns the object with the settings used for calls to getUserLink. */
  public UnaryCallSettings<GetUserLinkRequest, UserLink> getUserLinkSettings() {
    return getUserLinkSettings;
  }

  /** Returns the object with the settings used for calls to batchGetUserLinks. */
  public UnaryCallSettings<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksSettings() {
    return batchGetUserLinksSettings;
  }

  /** Returns the object with the settings used for calls to listUserLinks. */
  public PagedCallSettings<ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
      listUserLinksSettings() {
    return listUserLinksSettings;
  }

  /** Returns the object with the settings used for calls to auditUserLinks. */
  public PagedCallSettings<
          AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
      auditUserLinksSettings() {
    return auditUserLinksSettings;
  }

  /** Returns the object with the settings used for calls to createUserLink. */
  public UnaryCallSettings<CreateUserLinkRequest, UserLink> createUserLinkSettings() {
    return createUserLinkSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateUserLinks. */
  public UnaryCallSettings<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksSettings() {
    return batchCreateUserLinksSettings;
  }

  /** Returns the object with the settings used for calls to updateUserLink. */
  public UnaryCallSettings<UpdateUserLinkRequest, UserLink> updateUserLinkSettings() {
    return updateUserLinkSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateUserLinks. */
  public UnaryCallSettings<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksSettings() {
    return batchUpdateUserLinksSettings;
  }

  /** Returns the object with the settings used for calls to deleteUserLink. */
  public UnaryCallSettings<DeleteUserLinkRequest, Empty> deleteUserLinkSettings() {
    return deleteUserLinkSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteUserLinks. */
  public UnaryCallSettings<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksSettings() {
    return batchDeleteUserLinksSettings;
  }

  /** Returns the object with the settings used for calls to createFirebaseLink. */
  public UnaryCallSettings<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkSettings() {
    return createFirebaseLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteFirebaseLink. */
  public UnaryCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkSettings() {
    return deleteFirebaseLinkSettings;
  }

  /** Returns the object with the settings used for calls to listFirebaseLinks. */
  public PagedCallSettings<
          ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
      listFirebaseLinksSettings() {
    return listFirebaseLinksSettings;
  }

  /** Returns the object with the settings used for calls to getGlobalSiteTag. */
  public UnaryCallSettings<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagSettings() {
    return getGlobalSiteTagSettings;
  }

  /** Returns the object with the settings used for calls to createGoogleAdsLink. */
  public UnaryCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkSettings() {
    return createGoogleAdsLinkSettings;
  }

  /** Returns the object with the settings used for calls to updateGoogleAdsLink. */
  public UnaryCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkSettings() {
    return updateGoogleAdsLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteGoogleAdsLink. */
  public UnaryCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkSettings() {
    return deleteGoogleAdsLinkSettings;
  }

  /** Returns the object with the settings used for calls to listGoogleAdsLinks. */
  public PagedCallSettings<
          ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksSettings() {
    return listGoogleAdsLinksSettings;
  }

  /** Returns the object with the settings used for calls to getDataSharingSettings. */
  public UnaryCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsSettings() {
    return getDataSharingSettingsSettings;
  }

  /** Returns the object with the settings used for calls to getMeasurementProtocolSecret. */
  public UnaryCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretSettings() {
    return getMeasurementProtocolSecretSettings;
  }

  /** Returns the object with the settings used for calls to listMeasurementProtocolSecrets. */
  public PagedCallSettings<
          ListMeasurementProtocolSecretsRequest,
          ListMeasurementProtocolSecretsResponse,
          ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsSettings() {
    return listMeasurementProtocolSecretsSettings;
  }

  /** Returns the object with the settings used for calls to createMeasurementProtocolSecret. */
  public UnaryCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretSettings() {
    return createMeasurementProtocolSecretSettings;
  }

  /** Returns the object with the settings used for calls to deleteMeasurementProtocolSecret. */
  public UnaryCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretSettings() {
    return deleteMeasurementProtocolSecretSettings;
  }

  /** Returns the object with the settings used for calls to updateMeasurementProtocolSecret. */
  public UnaryCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretSettings() {
    return updateMeasurementProtocolSecretSettings;
  }

  /** Returns the object with the settings used for calls to acknowledgeUserDataCollection. */
  public UnaryCallSettings<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionSettings() {
    return acknowledgeUserDataCollectionSettings;
  }

  /** Returns the object with the settings used for calls to searchChangeHistoryEvents. */
  public PagedCallSettings<
          SearchChangeHistoryEventsRequest,
          SearchChangeHistoryEventsResponse,
          SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsSettings() {
    return searchChangeHistoryEventsSettings;
  }

  /** Returns the object with the settings used for calls to getGoogleSignalsSettings. */
  public UnaryCallSettings<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsSettings() {
    return getGoogleSignalsSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateGoogleSignalsSettings. */
  public UnaryCallSettings<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsSettings() {
    return updateGoogleSignalsSettingsSettings;
  }

  /** Returns the object with the settings used for calls to createConversionEvent. */
  public UnaryCallSettings<CreateConversionEventRequest, ConversionEvent>
      createConversionEventSettings() {
    return createConversionEventSettings;
  }

  /** Returns the object with the settings used for calls to getConversionEvent. */
  public UnaryCallSettings<GetConversionEventRequest, ConversionEvent>
      getConversionEventSettings() {
    return getConversionEventSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversionEvent. */
  public UnaryCallSettings<DeleteConversionEventRequest, Empty> deleteConversionEventSettings() {
    return deleteConversionEventSettings;
  }

  /** Returns the object with the settings used for calls to listConversionEvents. */
  public PagedCallSettings<
          ListConversionEventsRequest,
          ListConversionEventsResponse,
          ListConversionEventsPagedResponse>
      listConversionEventsSettings() {
    return listConversionEventsSettings;
  }

  /** Returns the object with the settings used for calls to getDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkSettings() {
    return getDisplayVideo360AdvertiserLinkSettings;
  }

  /** Returns the object with the settings used for calls to listDisplayVideo360AdvertiserLinks. */
  public PagedCallSettings<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksResponse,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksSettings() {
    return listDisplayVideo360AdvertiserLinksSettings;
  }

  /** Returns the object with the settings used for calls to createDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkSettings() {
    return createDisplayVideo360AdvertiserLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkSettings() {
    return deleteDisplayVideo360AdvertiserLinkSettings;
  }

  /** Returns the object with the settings used for calls to updateDisplayVideo360AdvertiserLink. */
  public UnaryCallSettings<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkSettings() {
    return updateDisplayVideo360AdvertiserLinkSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * getDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalSettings() {
    return getDisplayVideo360AdvertiserLinkProposalSettings;
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
    return listDisplayVideo360AdvertiserLinkProposalsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * createDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalSettings() {
    return createDisplayVideo360AdvertiserLinkProposalSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * deleteDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalSettings() {
    return deleteDisplayVideo360AdvertiserLinkProposalSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * approveDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalSettings() {
    return approveDisplayVideo360AdvertiserLinkProposalSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * cancelDisplayVideo360AdvertiserLinkProposal.
   */
  public UnaryCallSettings<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalSettings() {
    return cancelDisplayVideo360AdvertiserLinkProposalSettings;
  }

  /** Returns the object with the settings used for calls to createCustomDimension. */
  public UnaryCallSettings<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionSettings() {
    return createCustomDimensionSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomDimension. */
  public UnaryCallSettings<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionSettings() {
    return updateCustomDimensionSettings;
  }

  /** Returns the object with the settings used for calls to listCustomDimensions. */
  public PagedCallSettings<
          ListCustomDimensionsRequest,
          ListCustomDimensionsResponse,
          ListCustomDimensionsPagedResponse>
      listCustomDimensionsSettings() {
    return listCustomDimensionsSettings;
  }

  /** Returns the object with the settings used for calls to archiveCustomDimension. */
  public UnaryCallSettings<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionSettings() {
    return archiveCustomDimensionSettings;
  }

  /** Returns the object with the settings used for calls to getCustomDimension. */
  public UnaryCallSettings<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionSettings() {
    return getCustomDimensionSettings;
  }

  /** Returns the object with the settings used for calls to createCustomMetric. */
  public UnaryCallSettings<CreateCustomMetricRequest, CustomMetric> createCustomMetricSettings() {
    return createCustomMetricSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomMetric. */
  public UnaryCallSettings<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricSettings() {
    return updateCustomMetricSettings;
  }

  /** Returns the object with the settings used for calls to listCustomMetrics. */
  public PagedCallSettings<
          ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
      listCustomMetricsSettings() {
    return listCustomMetricsSettings;
  }

  /** Returns the object with the settings used for calls to archiveCustomMetric. */
  public UnaryCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricSettings() {
    return archiveCustomMetricSettings;
  }

  /** Returns the object with the settings used for calls to getCustomMetric. */
  public UnaryCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricSettings() {
    return getCustomMetricSettings;
  }

  /** Returns the object with the settings used for calls to getDataRetentionSettings. */
  public UnaryCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsSettings() {
    return getDataRetentionSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateDataRetentionSettings. */
  public UnaryCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsSettings() {
    return updateDataRetentionSettingsSettings;
  }

  /** Returns the object with the settings used for calls to createDataStream. */
  public UnaryCallSettings<CreateDataStreamRequest, DataStream> createDataStreamSettings() {
    return createDataStreamSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataStream. */
  public UnaryCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamSettings() {
    return deleteDataStreamSettings;
  }

  /** Returns the object with the settings used for calls to updateDataStream. */
  public UnaryCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamSettings() {
    return updateDataStreamSettings;
  }

  /** Returns the object with the settings used for calls to listDataStreams. */
  public PagedCallSettings<
          ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
      listDataStreamsSettings() {
    return listDataStreamsSettings;
  }

  /** Returns the object with the settings used for calls to getDataStream. */
  public UnaryCallSettings<GetDataStreamRequest, DataStream> getDataStreamSettings() {
    return getDataStreamSettings;
  }

  /** Returns the object with the settings used for calls to getAudience. */
  public UnaryCallSettings<GetAudienceRequest, Audience> getAudienceSettings() {
    return getAudienceSettings;
  }

  /** Returns the object with the settings used for calls to listAudiences. */
  public PagedCallSettings<ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
      listAudiencesSettings() {
    return listAudiencesSettings;
  }

  /** Returns the object with the settings used for calls to createAudience. */
  public UnaryCallSettings<CreateAudienceRequest, Audience> createAudienceSettings() {
    return createAudienceSettings;
  }

  /** Returns the object with the settings used for calls to updateAudience. */
  public UnaryCallSettings<UpdateAudienceRequest, Audience> updateAudienceSettings() {
    return updateAudienceSettings;
  }

  /** Returns the object with the settings used for calls to archiveAudience. */
  public UnaryCallSettings<ArchiveAudienceRequest, Empty> archiveAudienceSettings() {
    return archiveAudienceSettings;
  }

  /** Returns the object with the settings used for calls to getAttributionSettings. */
  public UnaryCallSettings<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsSettings() {
    return getAttributionSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateAttributionSettings. */
  public UnaryCallSettings<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsSettings() {
    return updateAttributionSettingsSettings;
  }

  /** Returns the object with the settings used for calls to runAccessReport. */
  public UnaryCallSettings<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportSettings() {
    return runAccessReportSettings;
  }

  public AnalyticsAdminServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAnalyticsAdminServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAnalyticsAdminServiceStub.create(this);
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
    return "analyticsadmin.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "analyticsadmin.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AnalyticsAdminServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AnalyticsAdminServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AnalyticsAdminServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AnalyticsAdminServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAccountSettings = settingsBuilder.getAccountSettings().build();
    listAccountsSettings = settingsBuilder.listAccountsSettings().build();
    deleteAccountSettings = settingsBuilder.deleteAccountSettings().build();
    updateAccountSettings = settingsBuilder.updateAccountSettings().build();
    provisionAccountTicketSettings = settingsBuilder.provisionAccountTicketSettings().build();
    listAccountSummariesSettings = settingsBuilder.listAccountSummariesSettings().build();
    getPropertySettings = settingsBuilder.getPropertySettings().build();
    listPropertiesSettings = settingsBuilder.listPropertiesSettings().build();
    createPropertySettings = settingsBuilder.createPropertySettings().build();
    deletePropertySettings = settingsBuilder.deletePropertySettings().build();
    updatePropertySettings = settingsBuilder.updatePropertySettings().build();
    getUserLinkSettings = settingsBuilder.getUserLinkSettings().build();
    batchGetUserLinksSettings = settingsBuilder.batchGetUserLinksSettings().build();
    listUserLinksSettings = settingsBuilder.listUserLinksSettings().build();
    auditUserLinksSettings = settingsBuilder.auditUserLinksSettings().build();
    createUserLinkSettings = settingsBuilder.createUserLinkSettings().build();
    batchCreateUserLinksSettings = settingsBuilder.batchCreateUserLinksSettings().build();
    updateUserLinkSettings = settingsBuilder.updateUserLinkSettings().build();
    batchUpdateUserLinksSettings = settingsBuilder.batchUpdateUserLinksSettings().build();
    deleteUserLinkSettings = settingsBuilder.deleteUserLinkSettings().build();
    batchDeleteUserLinksSettings = settingsBuilder.batchDeleteUserLinksSettings().build();
    createFirebaseLinkSettings = settingsBuilder.createFirebaseLinkSettings().build();
    deleteFirebaseLinkSettings = settingsBuilder.deleteFirebaseLinkSettings().build();
    listFirebaseLinksSettings = settingsBuilder.listFirebaseLinksSettings().build();
    getGlobalSiteTagSettings = settingsBuilder.getGlobalSiteTagSettings().build();
    createGoogleAdsLinkSettings = settingsBuilder.createGoogleAdsLinkSettings().build();
    updateGoogleAdsLinkSettings = settingsBuilder.updateGoogleAdsLinkSettings().build();
    deleteGoogleAdsLinkSettings = settingsBuilder.deleteGoogleAdsLinkSettings().build();
    listGoogleAdsLinksSettings = settingsBuilder.listGoogleAdsLinksSettings().build();
    getDataSharingSettingsSettings = settingsBuilder.getDataSharingSettingsSettings().build();
    getMeasurementProtocolSecretSettings =
        settingsBuilder.getMeasurementProtocolSecretSettings().build();
    listMeasurementProtocolSecretsSettings =
        settingsBuilder.listMeasurementProtocolSecretsSettings().build();
    createMeasurementProtocolSecretSettings =
        settingsBuilder.createMeasurementProtocolSecretSettings().build();
    deleteMeasurementProtocolSecretSettings =
        settingsBuilder.deleteMeasurementProtocolSecretSettings().build();
    updateMeasurementProtocolSecretSettings =
        settingsBuilder.updateMeasurementProtocolSecretSettings().build();
    acknowledgeUserDataCollectionSettings =
        settingsBuilder.acknowledgeUserDataCollectionSettings().build();
    searchChangeHistoryEventsSettings = settingsBuilder.searchChangeHistoryEventsSettings().build();
    getGoogleSignalsSettingsSettings = settingsBuilder.getGoogleSignalsSettingsSettings().build();
    updateGoogleSignalsSettingsSettings =
        settingsBuilder.updateGoogleSignalsSettingsSettings().build();
    createConversionEventSettings = settingsBuilder.createConversionEventSettings().build();
    getConversionEventSettings = settingsBuilder.getConversionEventSettings().build();
    deleteConversionEventSettings = settingsBuilder.deleteConversionEventSettings().build();
    listConversionEventsSettings = settingsBuilder.listConversionEventsSettings().build();
    getDisplayVideo360AdvertiserLinkSettings =
        settingsBuilder.getDisplayVideo360AdvertiserLinkSettings().build();
    listDisplayVideo360AdvertiserLinksSettings =
        settingsBuilder.listDisplayVideo360AdvertiserLinksSettings().build();
    createDisplayVideo360AdvertiserLinkSettings =
        settingsBuilder.createDisplayVideo360AdvertiserLinkSettings().build();
    deleteDisplayVideo360AdvertiserLinkSettings =
        settingsBuilder.deleteDisplayVideo360AdvertiserLinkSettings().build();
    updateDisplayVideo360AdvertiserLinkSettings =
        settingsBuilder.updateDisplayVideo360AdvertiserLinkSettings().build();
    getDisplayVideo360AdvertiserLinkProposalSettings =
        settingsBuilder.getDisplayVideo360AdvertiserLinkProposalSettings().build();
    listDisplayVideo360AdvertiserLinkProposalsSettings =
        settingsBuilder.listDisplayVideo360AdvertiserLinkProposalsSettings().build();
    createDisplayVideo360AdvertiserLinkProposalSettings =
        settingsBuilder.createDisplayVideo360AdvertiserLinkProposalSettings().build();
    deleteDisplayVideo360AdvertiserLinkProposalSettings =
        settingsBuilder.deleteDisplayVideo360AdvertiserLinkProposalSettings().build();
    approveDisplayVideo360AdvertiserLinkProposalSettings =
        settingsBuilder.approveDisplayVideo360AdvertiserLinkProposalSettings().build();
    cancelDisplayVideo360AdvertiserLinkProposalSettings =
        settingsBuilder.cancelDisplayVideo360AdvertiserLinkProposalSettings().build();
    createCustomDimensionSettings = settingsBuilder.createCustomDimensionSettings().build();
    updateCustomDimensionSettings = settingsBuilder.updateCustomDimensionSettings().build();
    listCustomDimensionsSettings = settingsBuilder.listCustomDimensionsSettings().build();
    archiveCustomDimensionSettings = settingsBuilder.archiveCustomDimensionSettings().build();
    getCustomDimensionSettings = settingsBuilder.getCustomDimensionSettings().build();
    createCustomMetricSettings = settingsBuilder.createCustomMetricSettings().build();
    updateCustomMetricSettings = settingsBuilder.updateCustomMetricSettings().build();
    listCustomMetricsSettings = settingsBuilder.listCustomMetricsSettings().build();
    archiveCustomMetricSettings = settingsBuilder.archiveCustomMetricSettings().build();
    getCustomMetricSettings = settingsBuilder.getCustomMetricSettings().build();
    getDataRetentionSettingsSettings = settingsBuilder.getDataRetentionSettingsSettings().build();
    updateDataRetentionSettingsSettings =
        settingsBuilder.updateDataRetentionSettingsSettings().build();
    createDataStreamSettings = settingsBuilder.createDataStreamSettings().build();
    deleteDataStreamSettings = settingsBuilder.deleteDataStreamSettings().build();
    updateDataStreamSettings = settingsBuilder.updateDataStreamSettings().build();
    listDataStreamsSettings = settingsBuilder.listDataStreamsSettings().build();
    getDataStreamSettings = settingsBuilder.getDataStreamSettings().build();
    getAudienceSettings = settingsBuilder.getAudienceSettings().build();
    listAudiencesSettings = settingsBuilder.listAudiencesSettings().build();
    createAudienceSettings = settingsBuilder.createAudienceSettings().build();
    updateAudienceSettings = settingsBuilder.updateAudienceSettings().build();
    archiveAudienceSettings = settingsBuilder.archiveAudienceSettings().build();
    getAttributionSettingsSettings = settingsBuilder.getAttributionSettingsSettings().build();
    updateAttributionSettingsSettings = settingsBuilder.updateAttributionSettingsSettings().build();
    runAccessReportSettings = settingsBuilder.runAccessReportSettings().build();
  }

  /** Builder for AnalyticsAdminServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AnalyticsAdminServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetAccountRequest, Account> getAccountSettings;
    private final PagedCallSettings.Builder<
            ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
        listAccountsSettings;
    private final UnaryCallSettings.Builder<DeleteAccountRequest, Empty> deleteAccountSettings;
    private final UnaryCallSettings.Builder<UpdateAccountRequest, Account> updateAccountSettings;
    private final UnaryCallSettings.Builder<
            ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
        provisionAccountTicketSettings;
    private final PagedCallSettings.Builder<
            ListAccountSummariesRequest,
            ListAccountSummariesResponse,
            ListAccountSummariesPagedResponse>
        listAccountSummariesSettings;
    private final UnaryCallSettings.Builder<GetPropertyRequest, Property> getPropertySettings;
    private final PagedCallSettings.Builder<
            ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
        listPropertiesSettings;
    private final UnaryCallSettings.Builder<CreatePropertyRequest, Property> createPropertySettings;
    private final UnaryCallSettings.Builder<DeletePropertyRequest, Property> deletePropertySettings;
    private final UnaryCallSettings.Builder<UpdatePropertyRequest, Property> updatePropertySettings;
    private final UnaryCallSettings.Builder<GetUserLinkRequest, UserLink> getUserLinkSettings;
    private final UnaryCallSettings.Builder<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
        batchGetUserLinksSettings;
    private final PagedCallSettings.Builder<
            ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
        listUserLinksSettings;
    private final PagedCallSettings.Builder<
            AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
        auditUserLinksSettings;
    private final UnaryCallSettings.Builder<CreateUserLinkRequest, UserLink> createUserLinkSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
        batchCreateUserLinksSettings;
    private final UnaryCallSettings.Builder<UpdateUserLinkRequest, UserLink> updateUserLinkSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
        batchUpdateUserLinksSettings;
    private final UnaryCallSettings.Builder<DeleteUserLinkRequest, Empty> deleteUserLinkSettings;
    private final UnaryCallSettings.Builder<BatchDeleteUserLinksRequest, Empty>
        batchDeleteUserLinksSettings;
    private final UnaryCallSettings.Builder<CreateFirebaseLinkRequest, FirebaseLink>
        createFirebaseLinkSettings;
    private final UnaryCallSettings.Builder<DeleteFirebaseLinkRequest, Empty>
        deleteFirebaseLinkSettings;
    private final PagedCallSettings.Builder<
            ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
        listFirebaseLinksSettings;
    private final UnaryCallSettings.Builder<GetGlobalSiteTagRequest, GlobalSiteTag>
        getGlobalSiteTagSettings;
    private final UnaryCallSettings.Builder<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkSettings;
    private final UnaryCallSettings.Builder<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkSettings;
    private final UnaryCallSettings.Builder<DeleteGoogleAdsLinkRequest, Empty>
        deleteGoogleAdsLinkSettings;
    private final PagedCallSettings.Builder<
            ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
        listGoogleAdsLinksSettings;
    private final UnaryCallSettings.Builder<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsSettings;
    private final UnaryCallSettings.Builder<
            GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretSettings;
    private final PagedCallSettings.Builder<
            ListMeasurementProtocolSecretsRequest,
            ListMeasurementProtocolSecretsResponse,
            ListMeasurementProtocolSecretsPagedResponse>
        listMeasurementProtocolSecretsSettings;
    private final UnaryCallSettings.Builder<
            CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretSettings;
    private final UnaryCallSettings.Builder<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretSettings;
    private final UnaryCallSettings.Builder<
            UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretSettings;
    private final UnaryCallSettings.Builder<
            AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollectionSettings;
    private final PagedCallSettings.Builder<
            SearchChangeHistoryEventsRequest,
            SearchChangeHistoryEventsResponse,
            SearchChangeHistoryEventsPagedResponse>
        searchChangeHistoryEventsSettings;
    private final UnaryCallSettings.Builder<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        getGoogleSignalsSettingsSettings;
    private final UnaryCallSettings.Builder<
            UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        updateGoogleSignalsSettingsSettings;
    private final UnaryCallSettings.Builder<CreateConversionEventRequest, ConversionEvent>
        createConversionEventSettings;
    private final UnaryCallSettings.Builder<GetConversionEventRequest, ConversionEvent>
        getConversionEventSettings;
    private final UnaryCallSettings.Builder<DeleteConversionEventRequest, Empty>
        deleteConversionEventSettings;
    private final PagedCallSettings.Builder<
            ListConversionEventsRequest,
            ListConversionEventsResponse,
            ListConversionEventsPagedResponse>
        listConversionEventsSettings;
    private final UnaryCallSettings.Builder<
            GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLinkSettings;
    private final PagedCallSettings.Builder<
            ListDisplayVideo360AdvertiserLinksRequest,
            ListDisplayVideo360AdvertiserLinksResponse,
            ListDisplayVideo360AdvertiserLinksPagedResponse>
        listDisplayVideo360AdvertiserLinksSettings;
    private final UnaryCallSettings.Builder<
            CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLinkSettings;
    private final UnaryCallSettings.Builder<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkSettings;
    private final UnaryCallSettings.Builder<
            UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLinkSettings;
    private final UnaryCallSettings.Builder<
            GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
        getDisplayVideo360AdvertiserLinkProposalSettings;
    private final PagedCallSettings.Builder<
            ListDisplayVideo360AdvertiserLinkProposalsRequest,
            ListDisplayVideo360AdvertiserLinkProposalsResponse,
            ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
        listDisplayVideo360AdvertiserLinkProposalsSettings;
    private final UnaryCallSettings.Builder<
            CreateDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        createDisplayVideo360AdvertiserLinkProposalSettings;
    private final UnaryCallSettings.Builder<
            DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkProposalSettings;
    private final UnaryCallSettings.Builder<
            ApproveDisplayVideo360AdvertiserLinkProposalRequest,
            ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        approveDisplayVideo360AdvertiserLinkProposalSettings;
    private final UnaryCallSettings.Builder<
            CancelDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        cancelDisplayVideo360AdvertiserLinkProposalSettings;
    private final UnaryCallSettings.Builder<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionSettings;
    private final UnaryCallSettings.Builder<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionSettings;
    private final PagedCallSettings.Builder<
            ListCustomDimensionsRequest,
            ListCustomDimensionsResponse,
            ListCustomDimensionsPagedResponse>
        listCustomDimensionsSettings;
    private final UnaryCallSettings.Builder<ArchiveCustomDimensionRequest, Empty>
        archiveCustomDimensionSettings;
    private final UnaryCallSettings.Builder<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionSettings;
    private final UnaryCallSettings.Builder<CreateCustomMetricRequest, CustomMetric>
        createCustomMetricSettings;
    private final UnaryCallSettings.Builder<UpdateCustomMetricRequest, CustomMetric>
        updateCustomMetricSettings;
    private final PagedCallSettings.Builder<
            ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
        listCustomMetricsSettings;
    private final UnaryCallSettings.Builder<ArchiveCustomMetricRequest, Empty>
        archiveCustomMetricSettings;
    private final UnaryCallSettings.Builder<GetCustomMetricRequest, CustomMetric>
        getCustomMetricSettings;
    private final UnaryCallSettings.Builder<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsSettings;
    private final UnaryCallSettings.Builder<
            UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsSettings;
    private final UnaryCallSettings.Builder<CreateDataStreamRequest, DataStream>
        createDataStreamSettings;
    private final UnaryCallSettings.Builder<DeleteDataStreamRequest, Empty>
        deleteDataStreamSettings;
    private final UnaryCallSettings.Builder<UpdateDataStreamRequest, DataStream>
        updateDataStreamSettings;
    private final PagedCallSettings.Builder<
            ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
        listDataStreamsSettings;
    private final UnaryCallSettings.Builder<GetDataStreamRequest, DataStream> getDataStreamSettings;
    private final UnaryCallSettings.Builder<GetAudienceRequest, Audience> getAudienceSettings;
    private final PagedCallSettings.Builder<
            ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
        listAudiencesSettings;
    private final UnaryCallSettings.Builder<CreateAudienceRequest, Audience> createAudienceSettings;
    private final UnaryCallSettings.Builder<UpdateAudienceRequest, Audience> updateAudienceSettings;
    private final UnaryCallSettings.Builder<ArchiveAudienceRequest, Empty> archiveAudienceSettings;
    private final UnaryCallSettings.Builder<GetAttributionSettingsRequest, AttributionSettings>
        getAttributionSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateAttributionSettingsRequest, AttributionSettings>
        updateAttributionSettingsSettings;
    private final UnaryCallSettings.Builder<RunAccessReportRequest, RunAccessReportResponse>
        runAccessReportSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAccountsSettings = PagedCallSettings.newBuilder(LIST_ACCOUNTS_PAGE_STR_FACT);
      deleteAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      provisionAccountTicketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAccountSummariesSettings =
          PagedCallSettings.newBuilder(LIST_ACCOUNT_SUMMARIES_PAGE_STR_FACT);
      getPropertySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPropertiesSettings = PagedCallSettings.newBuilder(LIST_PROPERTIES_PAGE_STR_FACT);
      createPropertySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePropertySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePropertySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchGetUserLinksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserLinksSettings = PagedCallSettings.newBuilder(LIST_USER_LINKS_PAGE_STR_FACT);
      auditUserLinksSettings = PagedCallSettings.newBuilder(AUDIT_USER_LINKS_PAGE_STR_FACT);
      createUserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateUserLinksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateUserLinksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteUserLinksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFirebaseLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFirebaseLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFirebaseLinksSettings = PagedCallSettings.newBuilder(LIST_FIREBASE_LINKS_PAGE_STR_FACT);
      getGlobalSiteTagSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGoogleAdsLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGoogleAdsLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGoogleAdsLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGoogleAdsLinksSettings =
          PagedCallSettings.newBuilder(LIST_GOOGLE_ADS_LINKS_PAGE_STR_FACT);
      getDataSharingSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getMeasurementProtocolSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMeasurementProtocolSecretsSettings =
          PagedCallSettings.newBuilder(LIST_MEASUREMENT_PROTOCOL_SECRETS_PAGE_STR_FACT);
      createMeasurementProtocolSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMeasurementProtocolSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMeasurementProtocolSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      acknowledgeUserDataCollectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchChangeHistoryEventsSettings =
          PagedCallSettings.newBuilder(SEARCH_CHANGE_HISTORY_EVENTS_PAGE_STR_FACT);
      getGoogleSignalsSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGoogleSignalsSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConversionEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConversionEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConversionEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversionEventsSettings =
          PagedCallSettings.newBuilder(LIST_CONVERSION_EVENTS_PAGE_STR_FACT);
      getDisplayVideo360AdvertiserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDisplayVideo360AdvertiserLinksSettings =
          PagedCallSettings.newBuilder(LIST_DISPLAY_VIDEO360_ADVERTISER_LINKS_PAGE_STR_FACT);
      createDisplayVideo360AdvertiserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDisplayVideo360AdvertiserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDisplayVideo360AdvertiserLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDisplayVideo360AdvertiserLinkProposalSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDisplayVideo360AdvertiserLinkProposalsSettings =
          PagedCallSettings.newBuilder(
              LIST_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSALS_PAGE_STR_FACT);
      createDisplayVideo360AdvertiserLinkProposalSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDisplayVideo360AdvertiserLinkProposalSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      approveDisplayVideo360AdvertiserLinkProposalSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelDisplayVideo360AdvertiserLinkProposalSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomDimensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomDimensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomDimensionsSettings =
          PagedCallSettings.newBuilder(LIST_CUSTOM_DIMENSIONS_PAGE_STR_FACT);
      archiveCustomDimensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCustomDimensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomMetricsSettings = PagedCallSettings.newBuilder(LIST_CUSTOM_METRICS_PAGE_STR_FACT);
      archiveCustomMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCustomMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataRetentionSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataRetentionSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataStreamsSettings = PagedCallSettings.newBuilder(LIST_DATA_STREAMS_PAGE_STR_FACT);
      getDataStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAudienceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAudiencesSettings = PagedCallSettings.newBuilder(LIST_AUDIENCES_PAGE_STR_FACT);
      createAudienceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAudienceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      archiveAudienceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAttributionSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAttributionSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runAccessReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAccountSettings,
              listAccountsSettings,
              deleteAccountSettings,
              updateAccountSettings,
              provisionAccountTicketSettings,
              listAccountSummariesSettings,
              getPropertySettings,
              listPropertiesSettings,
              createPropertySettings,
              deletePropertySettings,
              updatePropertySettings,
              getUserLinkSettings,
              batchGetUserLinksSettings,
              listUserLinksSettings,
              auditUserLinksSettings,
              createUserLinkSettings,
              batchCreateUserLinksSettings,
              updateUserLinkSettings,
              batchUpdateUserLinksSettings,
              deleteUserLinkSettings,
              batchDeleteUserLinksSettings,
              createFirebaseLinkSettings,
              deleteFirebaseLinkSettings,
              listFirebaseLinksSettings,
              getGlobalSiteTagSettings,
              createGoogleAdsLinkSettings,
              updateGoogleAdsLinkSettings,
              deleteGoogleAdsLinkSettings,
              listGoogleAdsLinksSettings,
              getDataSharingSettingsSettings,
              getMeasurementProtocolSecretSettings,
              listMeasurementProtocolSecretsSettings,
              createMeasurementProtocolSecretSettings,
              deleteMeasurementProtocolSecretSettings,
              updateMeasurementProtocolSecretSettings,
              acknowledgeUserDataCollectionSettings,
              searchChangeHistoryEventsSettings,
              getGoogleSignalsSettingsSettings,
              updateGoogleSignalsSettingsSettings,
              createConversionEventSettings,
              getConversionEventSettings,
              deleteConversionEventSettings,
              listConversionEventsSettings,
              getDisplayVideo360AdvertiserLinkSettings,
              listDisplayVideo360AdvertiserLinksSettings,
              createDisplayVideo360AdvertiserLinkSettings,
              deleteDisplayVideo360AdvertiserLinkSettings,
              updateDisplayVideo360AdvertiserLinkSettings,
              getDisplayVideo360AdvertiserLinkProposalSettings,
              listDisplayVideo360AdvertiserLinkProposalsSettings,
              createDisplayVideo360AdvertiserLinkProposalSettings,
              deleteDisplayVideo360AdvertiserLinkProposalSettings,
              approveDisplayVideo360AdvertiserLinkProposalSettings,
              cancelDisplayVideo360AdvertiserLinkProposalSettings,
              createCustomDimensionSettings,
              updateCustomDimensionSettings,
              listCustomDimensionsSettings,
              archiveCustomDimensionSettings,
              getCustomDimensionSettings,
              createCustomMetricSettings,
              updateCustomMetricSettings,
              listCustomMetricsSettings,
              archiveCustomMetricSettings,
              getCustomMetricSettings,
              getDataRetentionSettingsSettings,
              updateDataRetentionSettingsSettings,
              createDataStreamSettings,
              deleteDataStreamSettings,
              updateDataStreamSettings,
              listDataStreamsSettings,
              getDataStreamSettings,
              getAudienceSettings,
              listAudiencesSettings,
              createAudienceSettings,
              updateAudienceSettings,
              archiveAudienceSettings,
              getAttributionSettingsSettings,
              updateAttributionSettingsSettings,
              runAccessReportSettings);
      initDefaults(this);
    }

    protected Builder(AnalyticsAdminServiceStubSettings settings) {
      super(settings);

      getAccountSettings = settings.getAccountSettings.toBuilder();
      listAccountsSettings = settings.listAccountsSettings.toBuilder();
      deleteAccountSettings = settings.deleteAccountSettings.toBuilder();
      updateAccountSettings = settings.updateAccountSettings.toBuilder();
      provisionAccountTicketSettings = settings.provisionAccountTicketSettings.toBuilder();
      listAccountSummariesSettings = settings.listAccountSummariesSettings.toBuilder();
      getPropertySettings = settings.getPropertySettings.toBuilder();
      listPropertiesSettings = settings.listPropertiesSettings.toBuilder();
      createPropertySettings = settings.createPropertySettings.toBuilder();
      deletePropertySettings = settings.deletePropertySettings.toBuilder();
      updatePropertySettings = settings.updatePropertySettings.toBuilder();
      getUserLinkSettings = settings.getUserLinkSettings.toBuilder();
      batchGetUserLinksSettings = settings.batchGetUserLinksSettings.toBuilder();
      listUserLinksSettings = settings.listUserLinksSettings.toBuilder();
      auditUserLinksSettings = settings.auditUserLinksSettings.toBuilder();
      createUserLinkSettings = settings.createUserLinkSettings.toBuilder();
      batchCreateUserLinksSettings = settings.batchCreateUserLinksSettings.toBuilder();
      updateUserLinkSettings = settings.updateUserLinkSettings.toBuilder();
      batchUpdateUserLinksSettings = settings.batchUpdateUserLinksSettings.toBuilder();
      deleteUserLinkSettings = settings.deleteUserLinkSettings.toBuilder();
      batchDeleteUserLinksSettings = settings.batchDeleteUserLinksSettings.toBuilder();
      createFirebaseLinkSettings = settings.createFirebaseLinkSettings.toBuilder();
      deleteFirebaseLinkSettings = settings.deleteFirebaseLinkSettings.toBuilder();
      listFirebaseLinksSettings = settings.listFirebaseLinksSettings.toBuilder();
      getGlobalSiteTagSettings = settings.getGlobalSiteTagSettings.toBuilder();
      createGoogleAdsLinkSettings = settings.createGoogleAdsLinkSettings.toBuilder();
      updateGoogleAdsLinkSettings = settings.updateGoogleAdsLinkSettings.toBuilder();
      deleteGoogleAdsLinkSettings = settings.deleteGoogleAdsLinkSettings.toBuilder();
      listGoogleAdsLinksSettings = settings.listGoogleAdsLinksSettings.toBuilder();
      getDataSharingSettingsSettings = settings.getDataSharingSettingsSettings.toBuilder();
      getMeasurementProtocolSecretSettings =
          settings.getMeasurementProtocolSecretSettings.toBuilder();
      listMeasurementProtocolSecretsSettings =
          settings.listMeasurementProtocolSecretsSettings.toBuilder();
      createMeasurementProtocolSecretSettings =
          settings.createMeasurementProtocolSecretSettings.toBuilder();
      deleteMeasurementProtocolSecretSettings =
          settings.deleteMeasurementProtocolSecretSettings.toBuilder();
      updateMeasurementProtocolSecretSettings =
          settings.updateMeasurementProtocolSecretSettings.toBuilder();
      acknowledgeUserDataCollectionSettings =
          settings.acknowledgeUserDataCollectionSettings.toBuilder();
      searchChangeHistoryEventsSettings = settings.searchChangeHistoryEventsSettings.toBuilder();
      getGoogleSignalsSettingsSettings = settings.getGoogleSignalsSettingsSettings.toBuilder();
      updateGoogleSignalsSettingsSettings =
          settings.updateGoogleSignalsSettingsSettings.toBuilder();
      createConversionEventSettings = settings.createConversionEventSettings.toBuilder();
      getConversionEventSettings = settings.getConversionEventSettings.toBuilder();
      deleteConversionEventSettings = settings.deleteConversionEventSettings.toBuilder();
      listConversionEventsSettings = settings.listConversionEventsSettings.toBuilder();
      getDisplayVideo360AdvertiserLinkSettings =
          settings.getDisplayVideo360AdvertiserLinkSettings.toBuilder();
      listDisplayVideo360AdvertiserLinksSettings =
          settings.listDisplayVideo360AdvertiserLinksSettings.toBuilder();
      createDisplayVideo360AdvertiserLinkSettings =
          settings.createDisplayVideo360AdvertiserLinkSettings.toBuilder();
      deleteDisplayVideo360AdvertiserLinkSettings =
          settings.deleteDisplayVideo360AdvertiserLinkSettings.toBuilder();
      updateDisplayVideo360AdvertiserLinkSettings =
          settings.updateDisplayVideo360AdvertiserLinkSettings.toBuilder();
      getDisplayVideo360AdvertiserLinkProposalSettings =
          settings.getDisplayVideo360AdvertiserLinkProposalSettings.toBuilder();
      listDisplayVideo360AdvertiserLinkProposalsSettings =
          settings.listDisplayVideo360AdvertiserLinkProposalsSettings.toBuilder();
      createDisplayVideo360AdvertiserLinkProposalSettings =
          settings.createDisplayVideo360AdvertiserLinkProposalSettings.toBuilder();
      deleteDisplayVideo360AdvertiserLinkProposalSettings =
          settings.deleteDisplayVideo360AdvertiserLinkProposalSettings.toBuilder();
      approveDisplayVideo360AdvertiserLinkProposalSettings =
          settings.approveDisplayVideo360AdvertiserLinkProposalSettings.toBuilder();
      cancelDisplayVideo360AdvertiserLinkProposalSettings =
          settings.cancelDisplayVideo360AdvertiserLinkProposalSettings.toBuilder();
      createCustomDimensionSettings = settings.createCustomDimensionSettings.toBuilder();
      updateCustomDimensionSettings = settings.updateCustomDimensionSettings.toBuilder();
      listCustomDimensionsSettings = settings.listCustomDimensionsSettings.toBuilder();
      archiveCustomDimensionSettings = settings.archiveCustomDimensionSettings.toBuilder();
      getCustomDimensionSettings = settings.getCustomDimensionSettings.toBuilder();
      createCustomMetricSettings = settings.createCustomMetricSettings.toBuilder();
      updateCustomMetricSettings = settings.updateCustomMetricSettings.toBuilder();
      listCustomMetricsSettings = settings.listCustomMetricsSettings.toBuilder();
      archiveCustomMetricSettings = settings.archiveCustomMetricSettings.toBuilder();
      getCustomMetricSettings = settings.getCustomMetricSettings.toBuilder();
      getDataRetentionSettingsSettings = settings.getDataRetentionSettingsSettings.toBuilder();
      updateDataRetentionSettingsSettings =
          settings.updateDataRetentionSettingsSettings.toBuilder();
      createDataStreamSettings = settings.createDataStreamSettings.toBuilder();
      deleteDataStreamSettings = settings.deleteDataStreamSettings.toBuilder();
      updateDataStreamSettings = settings.updateDataStreamSettings.toBuilder();
      listDataStreamsSettings = settings.listDataStreamsSettings.toBuilder();
      getDataStreamSettings = settings.getDataStreamSettings.toBuilder();
      getAudienceSettings = settings.getAudienceSettings.toBuilder();
      listAudiencesSettings = settings.listAudiencesSettings.toBuilder();
      createAudienceSettings = settings.createAudienceSettings.toBuilder();
      updateAudienceSettings = settings.updateAudienceSettings.toBuilder();
      archiveAudienceSettings = settings.archiveAudienceSettings.toBuilder();
      getAttributionSettingsSettings = settings.getAttributionSettingsSettings.toBuilder();
      updateAttributionSettingsSettings = settings.updateAttributionSettingsSettings.toBuilder();
      runAccessReportSettings = settings.runAccessReportSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAccountSettings,
              listAccountsSettings,
              deleteAccountSettings,
              updateAccountSettings,
              provisionAccountTicketSettings,
              listAccountSummariesSettings,
              getPropertySettings,
              listPropertiesSettings,
              createPropertySettings,
              deletePropertySettings,
              updatePropertySettings,
              getUserLinkSettings,
              batchGetUserLinksSettings,
              listUserLinksSettings,
              auditUserLinksSettings,
              createUserLinkSettings,
              batchCreateUserLinksSettings,
              updateUserLinkSettings,
              batchUpdateUserLinksSettings,
              deleteUserLinkSettings,
              batchDeleteUserLinksSettings,
              createFirebaseLinkSettings,
              deleteFirebaseLinkSettings,
              listFirebaseLinksSettings,
              getGlobalSiteTagSettings,
              createGoogleAdsLinkSettings,
              updateGoogleAdsLinkSettings,
              deleteGoogleAdsLinkSettings,
              listGoogleAdsLinksSettings,
              getDataSharingSettingsSettings,
              getMeasurementProtocolSecretSettings,
              listMeasurementProtocolSecretsSettings,
              createMeasurementProtocolSecretSettings,
              deleteMeasurementProtocolSecretSettings,
              updateMeasurementProtocolSecretSettings,
              acknowledgeUserDataCollectionSettings,
              searchChangeHistoryEventsSettings,
              getGoogleSignalsSettingsSettings,
              updateGoogleSignalsSettingsSettings,
              createConversionEventSettings,
              getConversionEventSettings,
              deleteConversionEventSettings,
              listConversionEventsSettings,
              getDisplayVideo360AdvertiserLinkSettings,
              listDisplayVideo360AdvertiserLinksSettings,
              createDisplayVideo360AdvertiserLinkSettings,
              deleteDisplayVideo360AdvertiserLinkSettings,
              updateDisplayVideo360AdvertiserLinkSettings,
              getDisplayVideo360AdvertiserLinkProposalSettings,
              listDisplayVideo360AdvertiserLinkProposalsSettings,
              createDisplayVideo360AdvertiserLinkProposalSettings,
              deleteDisplayVideo360AdvertiserLinkProposalSettings,
              approveDisplayVideo360AdvertiserLinkProposalSettings,
              cancelDisplayVideo360AdvertiserLinkProposalSettings,
              createCustomDimensionSettings,
              updateCustomDimensionSettings,
              listCustomDimensionsSettings,
              archiveCustomDimensionSettings,
              getCustomDimensionSettings,
              createCustomMetricSettings,
              updateCustomMetricSettings,
              listCustomMetricsSettings,
              archiveCustomMetricSettings,
              getCustomMetricSettings,
              getDataRetentionSettingsSettings,
              updateDataRetentionSettingsSettings,
              createDataStreamSettings,
              deleteDataStreamSettings,
              updateDataStreamSettings,
              listDataStreamsSettings,
              getDataStreamSettings,
              getAudienceSettings,
              listAudiencesSettings,
              createAudienceSettings,
              updateAudienceSettings,
              archiveAudienceSettings,
              getAttributionSettingsSettings,
              updateAttributionSettingsSettings,
              runAccessReportSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAccountsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .provisionAccountTicketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAccountSummariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPropertySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPropertiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPropertySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePropertySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePropertySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getUserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchGetUserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listUserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .auditUserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchCreateUserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateUserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchUpdateUserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteUserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteUserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFirebaseLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFirebaseLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFirebaseLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGlobalSiteTagSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGoogleAdsLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGoogleAdsLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGoogleAdsLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGoogleAdsLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataSharingSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getMeasurementProtocolSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMeasurementProtocolSecretsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMeasurementProtocolSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMeasurementProtocolSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateMeasurementProtocolSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .acknowledgeUserDataCollectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchChangeHistoryEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGoogleSignalsSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGoogleSignalsSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConversionEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversionEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteConversionEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversionEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDisplayVideo360AdvertiserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDisplayVideo360AdvertiserLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDisplayVideo360AdvertiserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDisplayVideo360AdvertiserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDisplayVideo360AdvertiserLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDisplayVideo360AdvertiserLinkProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDisplayVideo360AdvertiserLinkProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDisplayVideo360AdvertiserLinkProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDisplayVideo360AdvertiserLinkProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .approveDisplayVideo360AdvertiserLinkProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelDisplayVideo360AdvertiserLinkProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCustomDimensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCustomDimensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCustomDimensionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .archiveCustomDimensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCustomDimensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCustomMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCustomMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCustomMetricsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .archiveCustomMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCustomMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataRetentionSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataRetentionSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDataStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDataStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAudienceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAudiencesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAudienceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAudienceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .archiveAudienceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAttributionSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAttributionSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .runAccessReportSettings()
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

    /** Returns the builder for the settings used for calls to getAccount. */
    public UnaryCallSettings.Builder<GetAccountRequest, Account> getAccountSettings() {
      return getAccountSettings;
    }

    /** Returns the builder for the settings used for calls to listAccounts. */
    public PagedCallSettings.Builder<
            ListAccountsRequest, ListAccountsResponse, ListAccountsPagedResponse>
        listAccountsSettings() {
      return listAccountsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccount. */
    public UnaryCallSettings.Builder<DeleteAccountRequest, Empty> deleteAccountSettings() {
      return deleteAccountSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccount. */
    public UnaryCallSettings.Builder<UpdateAccountRequest, Account> updateAccountSettings() {
      return updateAccountSettings;
    }

    /** Returns the builder for the settings used for calls to provisionAccountTicket. */
    public UnaryCallSettings.Builder<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
        provisionAccountTicketSettings() {
      return provisionAccountTicketSettings;
    }

    /** Returns the builder for the settings used for calls to listAccountSummaries. */
    public PagedCallSettings.Builder<
            ListAccountSummariesRequest,
            ListAccountSummariesResponse,
            ListAccountSummariesPagedResponse>
        listAccountSummariesSettings() {
      return listAccountSummariesSettings;
    }

    /** Returns the builder for the settings used for calls to getProperty. */
    public UnaryCallSettings.Builder<GetPropertyRequest, Property> getPropertySettings() {
      return getPropertySettings;
    }

    /** Returns the builder for the settings used for calls to listProperties. */
    public PagedCallSettings.Builder<
            ListPropertiesRequest, ListPropertiesResponse, ListPropertiesPagedResponse>
        listPropertiesSettings() {
      return listPropertiesSettings;
    }

    /** Returns the builder for the settings used for calls to createProperty. */
    public UnaryCallSettings.Builder<CreatePropertyRequest, Property> createPropertySettings() {
      return createPropertySettings;
    }

    /** Returns the builder for the settings used for calls to deleteProperty. */
    public UnaryCallSettings.Builder<DeletePropertyRequest, Property> deletePropertySettings() {
      return deletePropertySettings;
    }

    /** Returns the builder for the settings used for calls to updateProperty. */
    public UnaryCallSettings.Builder<UpdatePropertyRequest, Property> updatePropertySettings() {
      return updatePropertySettings;
    }

    /** Returns the builder for the settings used for calls to getUserLink. */
    public UnaryCallSettings.Builder<GetUserLinkRequest, UserLink> getUserLinkSettings() {
      return getUserLinkSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetUserLinks. */
    public UnaryCallSettings.Builder<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
        batchGetUserLinksSettings() {
      return batchGetUserLinksSettings;
    }

    /** Returns the builder for the settings used for calls to listUserLinks. */
    public PagedCallSettings.Builder<
            ListUserLinksRequest, ListUserLinksResponse, ListUserLinksPagedResponse>
        listUserLinksSettings() {
      return listUserLinksSettings;
    }

    /** Returns the builder for the settings used for calls to auditUserLinks. */
    public PagedCallSettings.Builder<
            AuditUserLinksRequest, AuditUserLinksResponse, AuditUserLinksPagedResponse>
        auditUserLinksSettings() {
      return auditUserLinksSettings;
    }

    /** Returns the builder for the settings used for calls to createUserLink. */
    public UnaryCallSettings.Builder<CreateUserLinkRequest, UserLink> createUserLinkSettings() {
      return createUserLinkSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateUserLinks. */
    public UnaryCallSettings.Builder<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
        batchCreateUserLinksSettings() {
      return batchCreateUserLinksSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserLink. */
    public UnaryCallSettings.Builder<UpdateUserLinkRequest, UserLink> updateUserLinkSettings() {
      return updateUserLinkSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateUserLinks. */
    public UnaryCallSettings.Builder<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
        batchUpdateUserLinksSettings() {
      return batchUpdateUserLinksSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUserLink. */
    public UnaryCallSettings.Builder<DeleteUserLinkRequest, Empty> deleteUserLinkSettings() {
      return deleteUserLinkSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteUserLinks. */
    public UnaryCallSettings.Builder<BatchDeleteUserLinksRequest, Empty>
        batchDeleteUserLinksSettings() {
      return batchDeleteUserLinksSettings;
    }

    /** Returns the builder for the settings used for calls to createFirebaseLink. */
    public UnaryCallSettings.Builder<CreateFirebaseLinkRequest, FirebaseLink>
        createFirebaseLinkSettings() {
      return createFirebaseLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFirebaseLink. */
    public UnaryCallSettings.Builder<DeleteFirebaseLinkRequest, Empty>
        deleteFirebaseLinkSettings() {
      return deleteFirebaseLinkSettings;
    }

    /** Returns the builder for the settings used for calls to listFirebaseLinks. */
    public PagedCallSettings.Builder<
            ListFirebaseLinksRequest, ListFirebaseLinksResponse, ListFirebaseLinksPagedResponse>
        listFirebaseLinksSettings() {
      return listFirebaseLinksSettings;
    }

    /** Returns the builder for the settings used for calls to getGlobalSiteTag. */
    public UnaryCallSettings.Builder<GetGlobalSiteTagRequest, GlobalSiteTag>
        getGlobalSiteTagSettings() {
      return getGlobalSiteTagSettings;
    }

    /** Returns the builder for the settings used for calls to createGoogleAdsLink. */
    public UnaryCallSettings.Builder<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkSettings() {
      return createGoogleAdsLinkSettings;
    }

    /** Returns the builder for the settings used for calls to updateGoogleAdsLink. */
    public UnaryCallSettings.Builder<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkSettings() {
      return updateGoogleAdsLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGoogleAdsLink. */
    public UnaryCallSettings.Builder<DeleteGoogleAdsLinkRequest, Empty>
        deleteGoogleAdsLinkSettings() {
      return deleteGoogleAdsLinkSettings;
    }

    /** Returns the builder for the settings used for calls to listGoogleAdsLinks. */
    public PagedCallSettings.Builder<
            ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse, ListGoogleAdsLinksPagedResponse>
        listGoogleAdsLinksSettings() {
      return listGoogleAdsLinksSettings;
    }

    /** Returns the builder for the settings used for calls to getDataSharingSettings. */
    public UnaryCallSettings.Builder<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsSettings() {
      return getDataSharingSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretSettings() {
      return getMeasurementProtocolSecretSettings;
    }

    /** Returns the builder for the settings used for calls to listMeasurementProtocolSecrets. */
    public PagedCallSettings.Builder<
            ListMeasurementProtocolSecretsRequest,
            ListMeasurementProtocolSecretsResponse,
            ListMeasurementProtocolSecretsPagedResponse>
        listMeasurementProtocolSecretsSettings() {
      return listMeasurementProtocolSecretsSettings;
    }

    /** Returns the builder for the settings used for calls to createMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<
            CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretSettings() {
      return createMeasurementProtocolSecretSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretSettings() {
      return deleteMeasurementProtocolSecretSettings;
    }

    /** Returns the builder for the settings used for calls to updateMeasurementProtocolSecret. */
    public UnaryCallSettings.Builder<
            UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretSettings() {
      return updateMeasurementProtocolSecretSettings;
    }

    /** Returns the builder for the settings used for calls to acknowledgeUserDataCollection. */
    public UnaryCallSettings.Builder<
            AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollectionSettings() {
      return acknowledgeUserDataCollectionSettings;
    }

    /** Returns the builder for the settings used for calls to searchChangeHistoryEvents. */
    public PagedCallSettings.Builder<
            SearchChangeHistoryEventsRequest,
            SearchChangeHistoryEventsResponse,
            SearchChangeHistoryEventsPagedResponse>
        searchChangeHistoryEventsSettings() {
      return searchChangeHistoryEventsSettings;
    }

    /** Returns the builder for the settings used for calls to getGoogleSignalsSettings. */
    public UnaryCallSettings.Builder<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        getGoogleSignalsSettingsSettings() {
      return getGoogleSignalsSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateGoogleSignalsSettings. */
    public UnaryCallSettings.Builder<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        updateGoogleSignalsSettingsSettings() {
      return updateGoogleSignalsSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to createConversionEvent. */
    public UnaryCallSettings.Builder<CreateConversionEventRequest, ConversionEvent>
        createConversionEventSettings() {
      return createConversionEventSettings;
    }

    /** Returns the builder for the settings used for calls to getConversionEvent. */
    public UnaryCallSettings.Builder<GetConversionEventRequest, ConversionEvent>
        getConversionEventSettings() {
      return getConversionEventSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversionEvent. */
    public UnaryCallSettings.Builder<DeleteConversionEventRequest, Empty>
        deleteConversionEventSettings() {
      return deleteConversionEventSettings;
    }

    /** Returns the builder for the settings used for calls to listConversionEvents. */
    public PagedCallSettings.Builder<
            ListConversionEventsRequest,
            ListConversionEventsResponse,
            ListConversionEventsPagedResponse>
        listConversionEventsSettings() {
      return listConversionEventsSettings;
    }

    /** Returns the builder for the settings used for calls to getDisplayVideo360AdvertiserLink. */
    public UnaryCallSettings.Builder<
            GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLinkSettings() {
      return getDisplayVideo360AdvertiserLinkSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listDisplayVideo360AdvertiserLinks.
     */
    public PagedCallSettings.Builder<
            ListDisplayVideo360AdvertiserLinksRequest,
            ListDisplayVideo360AdvertiserLinksResponse,
            ListDisplayVideo360AdvertiserLinksPagedResponse>
        listDisplayVideo360AdvertiserLinksSettings() {
      return listDisplayVideo360AdvertiserLinksSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createDisplayVideo360AdvertiserLink.
     */
    public UnaryCallSettings.Builder<
            CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLinkSettings() {
      return createDisplayVideo360AdvertiserLinkSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteDisplayVideo360AdvertiserLink.
     */
    public UnaryCallSettings.Builder<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkSettings() {
      return deleteDisplayVideo360AdvertiserLinkSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateDisplayVideo360AdvertiserLink.
     */
    public UnaryCallSettings.Builder<
            UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLinkSettings() {
      return updateDisplayVideo360AdvertiserLinkSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * getDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
        getDisplayVideo360AdvertiserLinkProposalSettings() {
      return getDisplayVideo360AdvertiserLinkProposalSettings;
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
      return listDisplayVideo360AdvertiserLinkProposalsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            CreateDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        createDisplayVideo360AdvertiserLinkProposalSettings() {
      return createDisplayVideo360AdvertiserLinkProposalSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkProposalSettings() {
      return deleteDisplayVideo360AdvertiserLinkProposalSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * approveDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            ApproveDisplayVideo360AdvertiserLinkProposalRequest,
            ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        approveDisplayVideo360AdvertiserLinkProposalSettings() {
      return approveDisplayVideo360AdvertiserLinkProposalSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * cancelDisplayVideo360AdvertiserLinkProposal.
     */
    public UnaryCallSettings.Builder<
            CancelDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        cancelDisplayVideo360AdvertiserLinkProposalSettings() {
      return cancelDisplayVideo360AdvertiserLinkProposalSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomDimension. */
    public UnaryCallSettings.Builder<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionSettings() {
      return createCustomDimensionSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomDimension. */
    public UnaryCallSettings.Builder<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionSettings() {
      return updateCustomDimensionSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomDimensions. */
    public PagedCallSettings.Builder<
            ListCustomDimensionsRequest,
            ListCustomDimensionsResponse,
            ListCustomDimensionsPagedResponse>
        listCustomDimensionsSettings() {
      return listCustomDimensionsSettings;
    }

    /** Returns the builder for the settings used for calls to archiveCustomDimension. */
    public UnaryCallSettings.Builder<ArchiveCustomDimensionRequest, Empty>
        archiveCustomDimensionSettings() {
      return archiveCustomDimensionSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomDimension. */
    public UnaryCallSettings.Builder<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionSettings() {
      return getCustomDimensionSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomMetric. */
    public UnaryCallSettings.Builder<CreateCustomMetricRequest, CustomMetric>
        createCustomMetricSettings() {
      return createCustomMetricSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomMetric. */
    public UnaryCallSettings.Builder<UpdateCustomMetricRequest, CustomMetric>
        updateCustomMetricSettings() {
      return updateCustomMetricSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomMetrics. */
    public PagedCallSettings.Builder<
            ListCustomMetricsRequest, ListCustomMetricsResponse, ListCustomMetricsPagedResponse>
        listCustomMetricsSettings() {
      return listCustomMetricsSettings;
    }

    /** Returns the builder for the settings used for calls to archiveCustomMetric. */
    public UnaryCallSettings.Builder<ArchiveCustomMetricRequest, Empty>
        archiveCustomMetricSettings() {
      return archiveCustomMetricSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomMetric. */
    public UnaryCallSettings.Builder<GetCustomMetricRequest, CustomMetric>
        getCustomMetricSettings() {
      return getCustomMetricSettings;
    }

    /** Returns the builder for the settings used for calls to getDataRetentionSettings. */
    public UnaryCallSettings.Builder<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsSettings() {
      return getDataRetentionSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataRetentionSettings. */
    public UnaryCallSettings.Builder<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsSettings() {
      return updateDataRetentionSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to createDataStream. */
    public UnaryCallSettings.Builder<CreateDataStreamRequest, DataStream>
        createDataStreamSettings() {
      return createDataStreamSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataStream. */
    public UnaryCallSettings.Builder<DeleteDataStreamRequest, Empty> deleteDataStreamSettings() {
      return deleteDataStreamSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataStream. */
    public UnaryCallSettings.Builder<UpdateDataStreamRequest, DataStream>
        updateDataStreamSettings() {
      return updateDataStreamSettings;
    }

    /** Returns the builder for the settings used for calls to listDataStreams. */
    public PagedCallSettings.Builder<
            ListDataStreamsRequest, ListDataStreamsResponse, ListDataStreamsPagedResponse>
        listDataStreamsSettings() {
      return listDataStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataStream. */
    public UnaryCallSettings.Builder<GetDataStreamRequest, DataStream> getDataStreamSettings() {
      return getDataStreamSettings;
    }

    /** Returns the builder for the settings used for calls to getAudience. */
    public UnaryCallSettings.Builder<GetAudienceRequest, Audience> getAudienceSettings() {
      return getAudienceSettings;
    }

    /** Returns the builder for the settings used for calls to listAudiences. */
    public PagedCallSettings.Builder<
            ListAudiencesRequest, ListAudiencesResponse, ListAudiencesPagedResponse>
        listAudiencesSettings() {
      return listAudiencesSettings;
    }

    /** Returns the builder for the settings used for calls to createAudience. */
    public UnaryCallSettings.Builder<CreateAudienceRequest, Audience> createAudienceSettings() {
      return createAudienceSettings;
    }

    /** Returns the builder for the settings used for calls to updateAudience. */
    public UnaryCallSettings.Builder<UpdateAudienceRequest, Audience> updateAudienceSettings() {
      return updateAudienceSettings;
    }

    /** Returns the builder for the settings used for calls to archiveAudience. */
    public UnaryCallSettings.Builder<ArchiveAudienceRequest, Empty> archiveAudienceSettings() {
      return archiveAudienceSettings;
    }

    /** Returns the builder for the settings used for calls to getAttributionSettings. */
    public UnaryCallSettings.Builder<GetAttributionSettingsRequest, AttributionSettings>
        getAttributionSettingsSettings() {
      return getAttributionSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateAttributionSettings. */
    public UnaryCallSettings.Builder<UpdateAttributionSettingsRequest, AttributionSettings>
        updateAttributionSettingsSettings() {
      return updateAttributionSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to runAccessReport. */
    public UnaryCallSettings.Builder<RunAccessReportRequest, RunAccessReportResponse>
        runAccessReportSettings() {
      return runAccessReportSettings;
    }

    @Override
    public AnalyticsAdminServiceStubSettings build() throws IOException {
      return new AnalyticsAdminServiceStubSettings(this);
    }
  }
}
