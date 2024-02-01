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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AnalyticsAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAnalyticsAdminServiceStub extends AnalyticsAdminServiceStub {
  private static final MethodDescriptor<GetAccountRequest, Account> getAccountMethodDescriptor =
      MethodDescriptor.<GetAccountRequest, Account>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListAccountsRequest, ListAccountsResponse>
      listAccountsMethodDescriptor =
          MethodDescriptor.<ListAccountsRequest, ListAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAccounts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccountRequest, Empty> deleteAccountMethodDescriptor =
      MethodDescriptor.<DeleteAccountRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAccountRequest, Account>
      updateAccountMethodDescriptor =
          MethodDescriptor.<UpdateAccountRequest, Account>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketMethodDescriptor =
          MethodDescriptor
              .<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ProvisionAccountTicket")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProvisionAccountTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ProvisionAccountTicketResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAccountSummariesRequest, ListAccountSummariesResponse>
      listAccountSummariesMethodDescriptor =
          MethodDescriptor.<ListAccountSummariesRequest, ListAccountSummariesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAccountSummaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountSummariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountSummariesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPropertyRequest, Property> getPropertyMethodDescriptor =
      MethodDescriptor.<GetPropertyRequest, Property>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetProperty")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPropertyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListPropertiesRequest, ListPropertiesResponse>
      listPropertiesMethodDescriptor =
          MethodDescriptor.<ListPropertiesRequest, ListPropertiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListProperties")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPropertiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPropertiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePropertyRequest, Property>
      createPropertyMethodDescriptor =
          MethodDescriptor.<CreatePropertyRequest, Property>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePropertyRequest, Property>
      deletePropertyMethodDescriptor =
          MethodDescriptor.<DeletePropertyRequest, Property>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePropertyRequest, Property>
      updatePropertyMethodDescriptor =
          MethodDescriptor.<UpdatePropertyRequest, Property>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFirebaseLinkRequest, FirebaseLink>
      createFirebaseLinkMethodDescriptor =
          MethodDescriptor.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateFirebaseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFirebaseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirebaseLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFirebaseLinkRequest, Empty>
      deleteFirebaseLinkMethodDescriptor =
          MethodDescriptor.<DeleteFirebaseLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteFirebaseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFirebaseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksMethodDescriptor =
          MethodDescriptor.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListFirebaseLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFirebaseLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFirebaseLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGlobalSiteTagRequest, GlobalSiteTag>
      getGlobalSiteTagMethodDescriptor =
          MethodDescriptor.<GetGlobalSiteTagRequest, GlobalSiteTag>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetGlobalSiteTag")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGlobalSiteTagRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlobalSiteTag.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkMethodDescriptor =
          MethodDescriptor.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateGoogleAdsLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGoogleAdsLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GoogleAdsLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkMethodDescriptor =
          MethodDescriptor.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateGoogleAdsLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGoogleAdsLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GoogleAdsLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGoogleAdsLinkRequest, Empty>
      deleteGoogleAdsLinkMethodDescriptor =
          MethodDescriptor.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteGoogleAdsLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGoogleAdsLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksMethodDescriptor =
          MethodDescriptor.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListGoogleAdsLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGoogleAdsLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGoogleAdsLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsMethodDescriptor =
          MethodDescriptor.<GetDataSharingSettingsRequest, DataSharingSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataSharingSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSharingSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataSharingSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretMethodDescriptor =
          MethodDescriptor
              .<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetMeasurementProtocolSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMeasurementProtocolSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MeasurementProtocolSecret.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
      listMeasurementProtocolSecretsMethodDescriptor =
          MethodDescriptor
              .<ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListMeasurementProtocolSecrets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMeasurementProtocolSecretsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMeasurementProtocolSecretsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretMethodDescriptor =
          MethodDescriptor
              .<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateMeasurementProtocolSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateMeasurementProtocolSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MeasurementProtocolSecret.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretMethodDescriptor =
          MethodDescriptor.<DeleteMeasurementProtocolSecretRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteMeasurementProtocolSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteMeasurementProtocolSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretMethodDescriptor =
          MethodDescriptor
              .<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateMeasurementProtocolSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateMeasurementProtocolSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MeasurementProtocolSecret.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionMethodDescriptor =
          MethodDescriptor
              .<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/AcknowledgeUserDataCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AcknowledgeUserDataCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AcknowledgeUserDataCollectionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaMethodDescriptor =
          MethodDescriptor
              .<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetSKAdNetworkConversionValueSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetSKAdNetworkConversionValueSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SKAdNetworkConversionValueSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaMethodDescriptor =
          MethodDescriptor
              .<CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSKAdNetworkConversionValueSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateSKAdNetworkConversionValueSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SKAdNetworkConversionValueSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaMethodDescriptor =
          MethodDescriptor.<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteSKAdNetworkConversionValueSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteSKAdNetworkConversionValueSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaMethodDescriptor =
          MethodDescriptor
              .<UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateSKAdNetworkConversionValueSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateSKAdNetworkConversionValueSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SKAdNetworkConversionValueSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse>
      listSKAdNetworkConversionValueSchemasMethodDescriptor =
          MethodDescriptor
              .<ListSKAdNetworkConversionValueSchemasRequest,
                  ListSKAdNetworkConversionValueSchemasResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListSKAdNetworkConversionValueSchemas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListSKAdNetworkConversionValueSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListSKAdNetworkConversionValueSchemasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsMethodDescriptor =
          MethodDescriptor
              .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/SearchChangeHistoryEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchChangeHistoryEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchChangeHistoryEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsMethodDescriptor =
          MethodDescriptor.<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetGoogleSignalsSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGoogleSignalsSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GoogleSignalsSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsMethodDescriptor =
          MethodDescriptor.<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateGoogleSignalsSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGoogleSignalsSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GoogleSignalsSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConversionEventRequest, ConversionEvent>
      createConversionEventMethodDescriptor =
          MethodDescriptor.<CreateConversionEventRequest, ConversionEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionEvent.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventMethodDescriptor =
          MethodDescriptor.<UpdateConversionEventRequest, ConversionEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionEvent.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversionEventRequest, ConversionEvent>
      getConversionEventMethodDescriptor =
          MethodDescriptor.<GetConversionEventRequest, ConversionEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionEvent.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversionEventRequest, Empty>
      deleteConversionEventMethodDescriptor =
          MethodDescriptor.<DeleteConversionEventRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsMethodDescriptor =
          MethodDescriptor.<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListConversionEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversionEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversionEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkMethodDescriptor =
          MethodDescriptor
              .<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDisplayVideo360AdvertiserLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DisplayVideo360AdvertiserLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
      listDisplayVideo360AdvertiserLinksMethodDescriptor =
          MethodDescriptor
              .<ListDisplayVideo360AdvertiserLinksRequest,
                  ListDisplayVideo360AdvertiserLinksResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListDisplayVideo360AdvertiserLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListDisplayVideo360AdvertiserLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListDisplayVideo360AdvertiserLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkMethodDescriptor =
          MethodDescriptor
              .<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateDisplayVideo360AdvertiserLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DisplayVideo360AdvertiserLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkMethodDescriptor =
          MethodDescriptor.<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteDisplayVideo360AdvertiserLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkMethodDescriptor =
          MethodDescriptor
              .<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDisplayVideo360AdvertiserLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateDisplayVideo360AdvertiserLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DisplayVideo360AdvertiserLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          MethodDescriptor
              .<GetDisplayVideo360AdvertiserLinkProposalRequest,
                  DisplayVideo360AdvertiserLinkProposal>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDisplayVideo360AdvertiserLinkProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetDisplayVideo360AdvertiserLinkProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DisplayVideo360AdvertiserLinkProposal.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse>
      listDisplayVideo360AdvertiserLinkProposalsMethodDescriptor =
          MethodDescriptor
              .<ListDisplayVideo360AdvertiserLinkProposalsRequest,
                  ListDisplayVideo360AdvertiserLinkProposalsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListDisplayVideo360AdvertiserLinkProposals")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListDisplayVideo360AdvertiserLinkProposalsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListDisplayVideo360AdvertiserLinkProposalsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          MethodDescriptor
              .<CreateDisplayVideo360AdvertiserLinkProposalRequest,
                  DisplayVideo360AdvertiserLinkProposal>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateDisplayVideo360AdvertiserLinkProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateDisplayVideo360AdvertiserLinkProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DisplayVideo360AdvertiserLinkProposal.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          MethodDescriptor.<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteDisplayVideo360AdvertiserLinkProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteDisplayVideo360AdvertiserLinkProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          MethodDescriptor
              .<ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                  ApproveDisplayVideo360AdvertiserLinkProposalResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ApproveDisplayVideo360AdvertiserLinkProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ApproveDisplayVideo360AdvertiserLinkProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ApproveDisplayVideo360AdvertiserLinkProposalResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          MethodDescriptor
              .<CancelDisplayVideo360AdvertiserLinkProposalRequest,
                  DisplayVideo360AdvertiserLinkProposal>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CancelDisplayVideo360AdvertiserLinkProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CancelDisplayVideo360AdvertiserLinkProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DisplayVideo360AdvertiserLinkProposal.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionMethodDescriptor =
          MethodDescriptor.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomDimension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionMethodDescriptor =
          MethodDescriptor.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomDimension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsMethodDescriptor =
          MethodDescriptor.<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListCustomDimensions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomDimensionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomDimensionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ArchiveCustomDimensionRequest, Empty>
      archiveCustomDimensionMethodDescriptor =
          MethodDescriptor.<ArchiveCustomDimensionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ArchiveCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ArchiveCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionMethodDescriptor =
          MethodDescriptor.<GetCustomDimensionRequest, CustomDimension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomDimension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCustomMetricRequest, CustomMetric>
      createCustomMetricMethodDescriptor =
          MethodDescriptor.<CreateCustomMetricRequest, CustomMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomMetricRequest, CustomMetric>
      updateCustomMetricMethodDescriptor =
          MethodDescriptor.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsMethodDescriptor =
          MethodDescriptor.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListCustomMetrics")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomMetricsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ArchiveCustomMetricRequest, Empty>
      archiveCustomMetricMethodDescriptor =
          MethodDescriptor.<ArchiveCustomMetricRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ArchiveCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ArchiveCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomMetricRequest, CustomMetric>
      getCustomMetricMethodDescriptor =
          MethodDescriptor.<GetCustomMetricRequest, CustomMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsMethodDescriptor =
          MethodDescriptor.<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataRetentionSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataRetentionSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataRetentionSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsMethodDescriptor =
          MethodDescriptor.<UpdateDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDataRetentionSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataRetentionSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataRetentionSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataStreamRequest, DataStream>
      createDataStreamMethodDescriptor =
          MethodDescriptor.<CreateDataStreamRequest, DataStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataStreamRequest, Empty>
      deleteDataStreamMethodDescriptor =
          MethodDescriptor.<DeleteDataStreamRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataStreamRequest, DataStream>
      updateDataStreamMethodDescriptor =
          MethodDescriptor.<UpdateDataStreamRequest, DataStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataStreamsRequest, ListDataStreamsResponse>
      listDataStreamsMethodDescriptor =
          MethodDescriptor.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListDataStreams")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataStreamsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataStreamRequest, DataStream>
      getDataStreamMethodDescriptor =
          MethodDescriptor.<GetDataStreamRequest, DataStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAudienceRequest, Audience> getAudienceMethodDescriptor =
      MethodDescriptor.<GetAudienceRequest, Audience>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetAudience")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAudienceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Audience.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListAudiencesRequest, ListAudiencesResponse>
      listAudiencesMethodDescriptor =
          MethodDescriptor.<ListAudiencesRequest, ListAudiencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAudiences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAudiencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAudiencesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAudienceRequest, Audience>
      createAudienceMethodDescriptor =
          MethodDescriptor.<CreateAudienceRequest, Audience>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateAudience")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAudienceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Audience.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAudienceRequest, Audience>
      updateAudienceMethodDescriptor =
          MethodDescriptor.<UpdateAudienceRequest, Audience>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAudience")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAudienceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Audience.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ArchiveAudienceRequest, Empty>
      archiveAudienceMethodDescriptor =
          MethodDescriptor.<ArchiveAudienceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ArchiveAudience")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ArchiveAudienceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSearchAds360LinkRequest, SearchAds360Link>
      getSearchAds360LinkMethodDescriptor =
          MethodDescriptor.<GetSearchAds360LinkRequest, SearchAds360Link>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetSearchAds360Link")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSearchAds360LinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchAds360Link.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
      listSearchAds360LinksMethodDescriptor =
          MethodDescriptor.<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListSearchAds360Links")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSearchAds360LinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSearchAds360LinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkMethodDescriptor =
          MethodDescriptor.<CreateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSearchAds360Link")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSearchAds360LinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchAds360Link.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSearchAds360LinkRequest, Empty>
      deleteSearchAds360LinkMethodDescriptor =
          MethodDescriptor.<DeleteSearchAds360LinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteSearchAds360Link")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSearchAds360LinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkMethodDescriptor =
          MethodDescriptor.<UpdateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateSearchAds360Link")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSearchAds360LinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchAds360Link.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsMethodDescriptor =
          MethodDescriptor.<GetAttributionSettingsRequest, AttributionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetAttributionSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAttributionSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AttributionSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsMethodDescriptor =
          MethodDescriptor.<UpdateAttributionSettingsRequest, AttributionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAttributionSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAttributionSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AttributionSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportMethodDescriptor =
          MethodDescriptor.<RunAccessReportRequest, RunAccessReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/RunAccessReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunAccessReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunAccessReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAccessBindingRequest, AccessBinding>
      createAccessBindingMethodDescriptor =
          MethodDescriptor.<CreateAccessBindingRequest, AccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAccessBindingRequest, AccessBinding>
      getAccessBindingMethodDescriptor =
          MethodDescriptor.<GetAccessBindingRequest, AccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAccessBindingRequest, AccessBinding>
      updateAccessBindingMethodDescriptor =
          MethodDescriptor.<UpdateAccessBindingRequest, AccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccessBindingRequest, Empty>
      deleteAccessBindingMethodDescriptor =
          MethodDescriptor.<DeleteAccessBindingRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAccessBindingsRequest, ListAccessBindingsResponse>
      listAccessBindingsMethodDescriptor =
          MethodDescriptor.<ListAccessBindingsRequest, ListAccessBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsMethodDescriptor =
          MethodDescriptor
              .<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchCreateAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateAccessBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsMethodDescriptor =
          MethodDescriptor
              .<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchGetAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetAccessBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsMethodDescriptor =
          MethodDescriptor
              .<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchUpdateAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchUpdateAccessBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsMethodDescriptor =
          MethodDescriptor.<BatchDeleteAccessBindingsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchDeleteAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExpandedDataSetRequest, ExpandedDataSet>
      getExpandedDataSetMethodDescriptor =
          MethodDescriptor.<GetExpandedDataSetRequest, ExpandedDataSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetExpandedDataSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExpandedDataSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExpandedDataSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
      listExpandedDataSetsMethodDescriptor =
          MethodDescriptor.<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListExpandedDataSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExpandedDataSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExpandedDataSetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetMethodDescriptor =
          MethodDescriptor.<CreateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateExpandedDataSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExpandedDataSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExpandedDataSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetMethodDescriptor =
          MethodDescriptor.<UpdateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateExpandedDataSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExpandedDataSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExpandedDataSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExpandedDataSetRequest, Empty>
      deleteExpandedDataSetMethodDescriptor =
          MethodDescriptor.<DeleteExpandedDataSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteExpandedDataSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExpandedDataSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelGroupRequest, ChannelGroup>
      getChannelGroupMethodDescriptor =
          MethodDescriptor.<GetChannelGroupRequest, ChannelGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetChannelGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetChannelGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListChannelGroupsRequest, ListChannelGroupsResponse>
      listChannelGroupsMethodDescriptor =
          MethodDescriptor.<ListChannelGroupsRequest, ListChannelGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListChannelGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChannelGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateChannelGroupRequest, ChannelGroup>
      createChannelGroupMethodDescriptor =
          MethodDescriptor.<CreateChannelGroupRequest, ChannelGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateChannelGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateChannelGroupRequest, ChannelGroup>
      updateChannelGroupMethodDescriptor =
          MethodDescriptor.<UpdateChannelGroupRequest, ChannelGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateChannelGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateChannelGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteChannelGroupRequest, Empty>
      deleteChannelGroupMethodDescriptor =
          MethodDescriptor.<DeleteChannelGroupRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteChannelGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteChannelGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutMethodDescriptor =
          MethodDescriptor
              .<SetAutomatedGa4ConfigurationOptOutRequest,
                  SetAutomatedGa4ConfigurationOptOutResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/SetAutomatedGa4ConfigurationOptOut")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SetAutomatedGa4ConfigurationOptOutRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SetAutomatedGa4ConfigurationOptOutResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutMethodDescriptor =
          MethodDescriptor
              .<FetchAutomatedGa4ConfigurationOptOutRequest,
                  FetchAutomatedGa4ConfigurationOptOutResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/FetchAutomatedGa4ConfigurationOptOut")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      FetchAutomatedGa4ConfigurationOptOutRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FetchAutomatedGa4ConfigurationOptOutResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBigQueryLinkRequest, BigQueryLink>
      getBigQueryLinkMethodDescriptor =
          MethodDescriptor.<GetBigQueryLinkRequest, BigQueryLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetBigQueryLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBigQueryLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksMethodDescriptor =
          MethodDescriptor.<ListBigQueryLinksRequest, ListBigQueryLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListBigQueryLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBigQueryLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBigQueryLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsMethodDescriptor =
          MethodDescriptor
              .<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetEnhancedMeasurementSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnhancedMeasurementSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EnhancedMeasurementSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsMethodDescriptor =
          MethodDescriptor
              .<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateEnhancedMeasurementSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateEnhancedMeasurementSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EnhancedMeasurementSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagMethodDescriptor =
          MethodDescriptor
              .<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateConnectedSiteTag")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectedSiteTagRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CreateConnectedSiteTagResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectedSiteTagRequest, Empty>
      deleteConnectedSiteTagMethodDescriptor =
          MethodDescriptor.<DeleteConnectedSiteTagRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteConnectedSiteTag")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectedSiteTagRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsMethodDescriptor =
          MethodDescriptor.<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListConnectedSiteTags")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectedSiteTagsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectedSiteTagsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertyMethodDescriptor =
          MethodDescriptor
              .<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/FetchConnectedGa4Property")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchConnectedGa4PropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchConnectedGa4PropertyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAdSenseLinkRequest, AdSenseLink>
      getAdSenseLinkMethodDescriptor =
          MethodDescriptor.<GetAdSenseLinkRequest, AdSenseLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetAdSenseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAdSenseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdSenseLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAdSenseLinkRequest, AdSenseLink>
      createAdSenseLinkMethodDescriptor =
          MethodDescriptor.<CreateAdSenseLinkRequest, AdSenseLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateAdSenseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAdSenseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdSenseLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAdSenseLinkRequest, Empty>
      deleteAdSenseLinkMethodDescriptor =
          MethodDescriptor.<DeleteAdSenseLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteAdSenseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAdSenseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
      listAdSenseLinksMethodDescriptor =
          MethodDescriptor.<ListAdSenseLinksRequest, ListAdSenseLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAdSenseLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAdSenseLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAdSenseLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEventCreateRuleRequest, EventCreateRule>
      getEventCreateRuleMethodDescriptor =
          MethodDescriptor.<GetEventCreateRuleRequest, EventCreateRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetEventCreateRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEventCreateRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EventCreateRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
      listEventCreateRulesMethodDescriptor =
          MethodDescriptor.<ListEventCreateRulesRequest, ListEventCreateRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListEventCreateRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEventCreateRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEventCreateRulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleMethodDescriptor =
          MethodDescriptor.<CreateEventCreateRuleRequest, EventCreateRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateEventCreateRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEventCreateRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EventCreateRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleMethodDescriptor =
          MethodDescriptor.<UpdateEventCreateRuleRequest, EventCreateRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateEventCreateRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEventCreateRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EventCreateRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEventCreateRuleRequest, Empty>
      deleteEventCreateRuleMethodDescriptor =
          MethodDescriptor.<DeleteEventCreateRuleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteEventCreateRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEventCreateRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsMethodDescriptor =
          MethodDescriptor.<UpdateDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDataRedactionSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataRedactionSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataRedactionSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsMethodDescriptor =
          MethodDescriptor.<GetDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataRedactionSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataRedactionSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataRedactionSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCalculatedMetricRequest, CalculatedMetric>
      getCalculatedMetricMethodDescriptor =
          MethodDescriptor.<GetCalculatedMetricRequest, CalculatedMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetCalculatedMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCalculatedMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CalculatedMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCalculatedMetricRequest, CalculatedMetric>
      createCalculatedMetricMethodDescriptor =
          MethodDescriptor.<CreateCalculatedMetricRequest, CalculatedMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateCalculatedMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCalculatedMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CalculatedMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
      listCalculatedMetricsMethodDescriptor =
          MethodDescriptor.<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListCalculatedMetrics")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCalculatedMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCalculatedMetricsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCalculatedMetricRequest, CalculatedMetric>
      updateCalculatedMetricMethodDescriptor =
          MethodDescriptor.<UpdateCalculatedMetricRequest, CalculatedMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateCalculatedMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCalculatedMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CalculatedMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCalculatedMetricRequest, Empty>
      deleteCalculatedMetricMethodDescriptor =
          MethodDescriptor.<DeleteCalculatedMetricRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteCalculatedMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCalculatedMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertyMethodDescriptor =
          MethodDescriptor.<CreateRollupPropertyRequest, CreateRollupPropertyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateRollupProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRollupPropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CreateRollupPropertyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkMethodDescriptor =
          MethodDescriptor
              .<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetRollupPropertySourceLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRollupPropertySourceLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RollupPropertySourceLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
      listRollupPropertySourceLinksMethodDescriptor =
          MethodDescriptor
              .<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListRollupPropertySourceLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRollupPropertySourceLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRollupPropertySourceLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkMethodDescriptor =
          MethodDescriptor
              .<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateRollupPropertySourceLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRollupPropertySourceLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RollupPropertySourceLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkMethodDescriptor =
          MethodDescriptor.<DeleteRollupPropertySourceLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteRollupPropertySourceLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRollupPropertySourceLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSubpropertyRequest, CreateSubpropertyResponse>
      createSubpropertyMethodDescriptor =
          MethodDescriptor.<CreateSubpropertyRequest, CreateSubpropertyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSubproperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSubpropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CreateSubpropertyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterMethodDescriptor =
          MethodDescriptor.<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSubpropertyEventFilter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSubpropertyEventFilterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SubpropertyEventFilter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterMethodDescriptor =
          MethodDescriptor.<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetSubpropertyEventFilter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSubpropertyEventFilterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SubpropertyEventFilter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
      listSubpropertyEventFiltersMethodDescriptor =
          MethodDescriptor
              .<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListSubpropertyEventFilters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubpropertyEventFiltersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubpropertyEventFiltersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterMethodDescriptor =
          MethodDescriptor.<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateSubpropertyEventFilter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSubpropertyEventFilterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SubpropertyEventFilter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterMethodDescriptor =
          MethodDescriptor.<DeleteSubpropertyEventFilterRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteSubpropertyEventFilter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSubpropertyEventFilterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAccountRequest, Account> getAccountCallable;
  private final UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable;
  private final UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse>
      listAccountsPagedCallable;
  private final UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable;
  private final UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable;
  private final UnaryCallable<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketCallable;
  private final UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesResponse>
      listAccountSummariesCallable;
  private final UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesPagedResponse>
      listAccountSummariesPagedCallable;
  private final UnaryCallable<GetPropertyRequest, Property> getPropertyCallable;
  private final UnaryCallable<ListPropertiesRequest, ListPropertiesResponse> listPropertiesCallable;
  private final UnaryCallable<ListPropertiesRequest, ListPropertiesPagedResponse>
      listPropertiesPagedCallable;
  private final UnaryCallable<CreatePropertyRequest, Property> createPropertyCallable;
  private final UnaryCallable<DeletePropertyRequest, Property> deletePropertyCallable;
  private final UnaryCallable<UpdatePropertyRequest, Property> updatePropertyCallable;
  private final UnaryCallable<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkCallable;
  private final UnaryCallable<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkCallable;
  private final UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksCallable;
  private final UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksPagedResponse>
      listFirebaseLinksPagedCallable;
  private final UnaryCallable<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagCallable;
  private final UnaryCallable<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkCallable;
  private final UnaryCallable<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkCallable;
  private final UnaryCallable<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkCallable;
  private final UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksCallable;
  private final UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksPagedCallable;
  private final UnaryCallable<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsCallable;
  private final UnaryCallable<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretCallable;
  private final UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
      listMeasurementProtocolSecretsCallable;
  private final UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsPagedCallable;
  private final UnaryCallable<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretCallable;
  private final UnaryCallable<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretCallable;
  private final UnaryCallable<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretCallable;
  private final UnaryCallable<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionCallable;
  private final UnaryCallable<
          GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaCallable;
  private final UnaryCallable<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaCallable;
  private final UnaryCallable<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaCallable;
  private final UnaryCallable<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaCallable;
  private final UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse>
      listSKAdNetworkConversionValueSchemasCallable;
  private final UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasPagedResponse>
      listSKAdNetworkConversionValueSchemasPagedCallable;
  private final UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsCallable;
  private final UnaryCallable<
          SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsPagedCallable;
  private final UnaryCallable<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsCallable;
  private final UnaryCallable<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsCallable;
  private final UnaryCallable<CreateConversionEventRequest, ConversionEvent>
      createConversionEventCallable;
  private final UnaryCallable<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventCallable;
  private final UnaryCallable<GetConversionEventRequest, ConversionEvent>
      getConversionEventCallable;
  private final UnaryCallable<DeleteConversionEventRequest, Empty> deleteConversionEventCallable;
  private final UnaryCallable<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsCallable;
  private final UnaryCallable<ListConversionEventsRequest, ListConversionEventsPagedResponse>
      listConversionEventsPagedCallable;
  private final UnaryCallable<
          GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkCallable;
  private final UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
      listDisplayVideo360AdvertiserLinksCallable;
  private final UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksPagedCallable;
  private final UnaryCallable<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkCallable;
  private final UnaryCallable<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkCallable;
  private final UnaryCallable<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkCallable;
  private final UnaryCallable<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalCallable;
  private final UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse>
      listDisplayVideo360AdvertiserLinkProposalsCallable;
  private final UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      listDisplayVideo360AdvertiserLinkProposalsPagedCallable;
  private final UnaryCallable<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalCallable;
  private final UnaryCallable<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalCallable;
  private final UnaryCallable<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalCallable;
  private final UnaryCallable<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalCallable;
  private final UnaryCallable<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionCallable;
  private final UnaryCallable<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionCallable;
  private final UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsCallable;
  private final UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsPagedResponse>
      listCustomDimensionsPagedCallable;
  private final UnaryCallable<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionCallable;
  private final UnaryCallable<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionCallable;
  private final UnaryCallable<CreateCustomMetricRequest, CustomMetric> createCustomMetricCallable;
  private final UnaryCallable<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricCallable;
  private final UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsCallable;
  private final UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsPagedResponse>
      listCustomMetricsPagedCallable;
  private final UnaryCallable<ArchiveCustomMetricRequest, Empty> archiveCustomMetricCallable;
  private final UnaryCallable<GetCustomMetricRequest, CustomMetric> getCustomMetricCallable;
  private final UnaryCallable<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsCallable;
  private final UnaryCallable<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsCallable;
  private final UnaryCallable<CreateDataStreamRequest, DataStream> createDataStreamCallable;
  private final UnaryCallable<DeleteDataStreamRequest, Empty> deleteDataStreamCallable;
  private final UnaryCallable<UpdateDataStreamRequest, DataStream> updateDataStreamCallable;
  private final UnaryCallable<ListDataStreamsRequest, ListDataStreamsResponse>
      listDataStreamsCallable;
  private final UnaryCallable<ListDataStreamsRequest, ListDataStreamsPagedResponse>
      listDataStreamsPagedCallable;
  private final UnaryCallable<GetDataStreamRequest, DataStream> getDataStreamCallable;
  private final UnaryCallable<GetAudienceRequest, Audience> getAudienceCallable;
  private final UnaryCallable<ListAudiencesRequest, ListAudiencesResponse> listAudiencesCallable;
  private final UnaryCallable<ListAudiencesRequest, ListAudiencesPagedResponse>
      listAudiencesPagedCallable;
  private final UnaryCallable<CreateAudienceRequest, Audience> createAudienceCallable;
  private final UnaryCallable<UpdateAudienceRequest, Audience> updateAudienceCallable;
  private final UnaryCallable<ArchiveAudienceRequest, Empty> archiveAudienceCallable;
  private final UnaryCallable<GetSearchAds360LinkRequest, SearchAds360Link>
      getSearchAds360LinkCallable;
  private final UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
      listSearchAds360LinksCallable;
  private final UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksPagedResponse>
      listSearchAds360LinksPagedCallable;
  private final UnaryCallable<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkCallable;
  private final UnaryCallable<DeleteSearchAds360LinkRequest, Empty> deleteSearchAds360LinkCallable;
  private final UnaryCallable<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkCallable;
  private final UnaryCallable<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsCallable;
  private final UnaryCallable<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsCallable;
  private final UnaryCallable<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportCallable;
  private final UnaryCallable<CreateAccessBindingRequest, AccessBinding>
      createAccessBindingCallable;
  private final UnaryCallable<GetAccessBindingRequest, AccessBinding> getAccessBindingCallable;
  private final UnaryCallable<UpdateAccessBindingRequest, AccessBinding>
      updateAccessBindingCallable;
  private final UnaryCallable<DeleteAccessBindingRequest, Empty> deleteAccessBindingCallable;
  private final UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsResponse>
      listAccessBindingsCallable;
  private final UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsPagedResponse>
      listAccessBindingsPagedCallable;
  private final UnaryCallable<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsCallable;
  private final UnaryCallable<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsCallable;
  private final UnaryCallable<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsCallable;
  private final UnaryCallable<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsCallable;
  private final UnaryCallable<GetExpandedDataSetRequest, ExpandedDataSet>
      getExpandedDataSetCallable;
  private final UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
      listExpandedDataSetsCallable;
  private final UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsPagedResponse>
      listExpandedDataSetsPagedCallable;
  private final UnaryCallable<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetCallable;
  private final UnaryCallable<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetCallable;
  private final UnaryCallable<DeleteExpandedDataSetRequest, Empty> deleteExpandedDataSetCallable;
  private final UnaryCallable<GetChannelGroupRequest, ChannelGroup> getChannelGroupCallable;
  private final UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsResponse>
      listChannelGroupsCallable;
  private final UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsPagedResponse>
      listChannelGroupsPagedCallable;
  private final UnaryCallable<CreateChannelGroupRequest, ChannelGroup> createChannelGroupCallable;
  private final UnaryCallable<UpdateChannelGroupRequest, ChannelGroup> updateChannelGroupCallable;
  private final UnaryCallable<DeleteChannelGroupRequest, Empty> deleteChannelGroupCallable;
  private final UnaryCallable<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutCallable;
  private final UnaryCallable<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutCallable;
  private final UnaryCallable<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkCallable;
  private final UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksCallable;
  private final UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksPagedResponse>
      listBigQueryLinksPagedCallable;
  private final UnaryCallable<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsCallable;
  private final UnaryCallable<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsCallable;
  private final UnaryCallable<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagCallable;
  private final UnaryCallable<DeleteConnectedSiteTagRequest, Empty> deleteConnectedSiteTagCallable;
  private final UnaryCallable<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsCallable;
  private final UnaryCallable<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertyCallable;
  private final UnaryCallable<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkCallable;
  private final UnaryCallable<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkCallable;
  private final UnaryCallable<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkCallable;
  private final UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
      listAdSenseLinksCallable;
  private final UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksPagedResponse>
      listAdSenseLinksPagedCallable;
  private final UnaryCallable<GetEventCreateRuleRequest, EventCreateRule>
      getEventCreateRuleCallable;
  private final UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
      listEventCreateRulesCallable;
  private final UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesPagedResponse>
      listEventCreateRulesPagedCallable;
  private final UnaryCallable<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleCallable;
  private final UnaryCallable<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleCallable;
  private final UnaryCallable<DeleteEventCreateRuleRequest, Empty> deleteEventCreateRuleCallable;
  private final UnaryCallable<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsCallable;
  private final UnaryCallable<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsCallable;
  private final UnaryCallable<GetCalculatedMetricRequest, CalculatedMetric>
      getCalculatedMetricCallable;
  private final UnaryCallable<CreateCalculatedMetricRequest, CalculatedMetric>
      createCalculatedMetricCallable;
  private final UnaryCallable<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
      listCalculatedMetricsCallable;
  private final UnaryCallable<ListCalculatedMetricsRequest, ListCalculatedMetricsPagedResponse>
      listCalculatedMetricsPagedCallable;
  private final UnaryCallable<UpdateCalculatedMetricRequest, CalculatedMetric>
      updateCalculatedMetricCallable;
  private final UnaryCallable<DeleteCalculatedMetricRequest, Empty> deleteCalculatedMetricCallable;
  private final UnaryCallable<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertyCallable;
  private final UnaryCallable<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkCallable;
  private final UnaryCallable<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
      listRollupPropertySourceLinksCallable;
  private final UnaryCallable<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksPagedResponse>
      listRollupPropertySourceLinksPagedCallable;
  private final UnaryCallable<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkCallable;
  private final UnaryCallable<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkCallable;
  private final UnaryCallable<CreateSubpropertyRequest, CreateSubpropertyResponse>
      createSubpropertyCallable;
  private final UnaryCallable<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterCallable;
  private final UnaryCallable<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterCallable;
  private final UnaryCallable<
          ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
      listSubpropertyEventFiltersCallable;
  private final UnaryCallable<
          ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersPagedResponse>
      listSubpropertyEventFiltersPagedCallable;
  private final UnaryCallable<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterCallable;
  private final UnaryCallable<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAnalyticsAdminServiceStub create(
      AnalyticsAdminServiceStubSettings settings) throws IOException {
    return new GrpcAnalyticsAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAnalyticsAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAnalyticsAdminServiceStub(
        AnalyticsAdminServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAnalyticsAdminServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAnalyticsAdminServiceStub(
        AnalyticsAdminServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAnalyticsAdminServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAnalyticsAdminServiceStub(
      AnalyticsAdminServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAnalyticsAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAnalyticsAdminServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAnalyticsAdminServiceStub(
      AnalyticsAdminServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAccountRequest, Account> getAccountTransportSettings =
        GrpcCallSettings.<GetAccountRequest, Account>newBuilder()
            .setMethodDescriptor(getAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAccountsRequest, ListAccountsResponse> listAccountsTransportSettings =
        GrpcCallSettings.<ListAccountsRequest, ListAccountsResponse>newBuilder()
            .setMethodDescriptor(listAccountsMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteAccountRequest, Empty> deleteAccountTransportSettings =
        GrpcCallSettings.<DeleteAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAccountRequest, Account> updateAccountTransportSettings =
        GrpcCallSettings.<UpdateAccountRequest, Account>newBuilder()
            .setMethodDescriptor(updateAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("account.name", String.valueOf(request.getAccount().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
        provisionAccountTicketTransportSettings =
            GrpcCallSettings
                .<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>newBuilder()
                .setMethodDescriptor(provisionAccountTicketMethodDescriptor)
                .build();
    GrpcCallSettings<ListAccountSummariesRequest, ListAccountSummariesResponse>
        listAccountSummariesTransportSettings =
            GrpcCallSettings.<ListAccountSummariesRequest, ListAccountSummariesResponse>newBuilder()
                .setMethodDescriptor(listAccountSummariesMethodDescriptor)
                .build();
    GrpcCallSettings<GetPropertyRequest, Property> getPropertyTransportSettings =
        GrpcCallSettings.<GetPropertyRequest, Property>newBuilder()
            .setMethodDescriptor(getPropertyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPropertiesRequest, ListPropertiesResponse>
        listPropertiesTransportSettings =
            GrpcCallSettings.<ListPropertiesRequest, ListPropertiesResponse>newBuilder()
                .setMethodDescriptor(listPropertiesMethodDescriptor)
                .build();
    GrpcCallSettings<CreatePropertyRequest, Property> createPropertyTransportSettings =
        GrpcCallSettings.<CreatePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(createPropertyMethodDescriptor)
            .build();
    GrpcCallSettings<DeletePropertyRequest, Property> deletePropertyTransportSettings =
        GrpcCallSettings.<DeletePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(deletePropertyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePropertyRequest, Property> updatePropertyTransportSettings =
        GrpcCallSettings.<UpdatePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(updatePropertyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("property.name", String.valueOf(request.getProperty().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkTransportSettings =
        GrpcCallSettings.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
            .setMethodDescriptor(createFirebaseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkTransportSettings =
        GrpcCallSettings.<DeleteFirebaseLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFirebaseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
        listFirebaseLinksTransportSettings =
            GrpcCallSettings.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
                .setMethodDescriptor(listFirebaseLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagTransportSettings =
        GrpcCallSettings.<GetGlobalSiteTagRequest, GlobalSiteTag>newBuilder()
            .setMethodDescriptor(getGlobalSiteTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkTransportSettings =
            GrpcCallSettings.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(createGoogleAdsLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkTransportSettings =
            GrpcCallSettings.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(updateGoogleAdsLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_ads_link.name",
                          String.valueOf(request.getGoogleAdsLink().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkTransportSettings =
        GrpcCallSettings.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGoogleAdsLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
        listGoogleAdsLinksTransportSettings =
            GrpcCallSettings.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
                .setMethodDescriptor(listGoogleAdsLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsTransportSettings =
            GrpcCallSettings.<GetDataSharingSettingsRequest, DataSharingSettings>newBuilder()
                .setMethodDescriptor(getDataSharingSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings
                .<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(getMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
        listMeasurementProtocolSecretsTransportSettings =
            GrpcCallSettings
                .<ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
                    newBuilder()
                .setMethodDescriptor(listMeasurementProtocolSecretsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings
                .<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(createMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings.<DeleteMeasurementProtocolSecretRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings
                .<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(updateMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "measurement_protocol_secret.name",
                          String.valueOf(request.getMeasurementProtocolSecret().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollectionTransportSettings =
            GrpcCallSettings
                .<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
                    newBuilder()
                .setMethodDescriptor(acknowledgeUserDataCollectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        getSKAdNetworkConversionValueSchemaTransportSettings =
            GrpcCallSettings
                .<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                    newBuilder()
                .setMethodDescriptor(getSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        createSKAdNetworkConversionValueSchemaTransportSettings =
            GrpcCallSettings
                .<CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                    newBuilder()
                .setMethodDescriptor(createSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
        deleteSKAdNetworkConversionValueSchemaTransportSettings =
            GrpcCallSettings.<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        updateSKAdNetworkConversionValueSchemaTransportSettings =
            GrpcCallSettings
                .<UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                    newBuilder()
                .setMethodDescriptor(updateSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "skadnetwork_conversion_value_schema.name",
                          String.valueOf(request.getSkadnetworkConversionValueSchema().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListSKAdNetworkConversionValueSchemasRequest,
            ListSKAdNetworkConversionValueSchemasResponse>
        listSKAdNetworkConversionValueSchemasTransportSettings =
            GrpcCallSettings
                .<ListSKAdNetworkConversionValueSchemasRequest,
                    ListSKAdNetworkConversionValueSchemasResponse>
                    newBuilder()
                .setMethodDescriptor(listSKAdNetworkConversionValueSchemasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
        searchChangeHistoryEventsTransportSettings =
            GrpcCallSettings
                .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
                .setMethodDescriptor(searchChangeHistoryEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("account", String.valueOf(request.getAccount()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        getGoogleSignalsSettingsTransportSettings =
            GrpcCallSettings.<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
                .setMethodDescriptor(getGoogleSignalsSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        updateGoogleSignalsSettingsTransportSettings =
            GrpcCallSettings.<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
                .setMethodDescriptor(updateGoogleSignalsSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_signals_settings.name",
                          String.valueOf(request.getGoogleSignalsSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateConversionEventRequest, ConversionEvent>
        createConversionEventTransportSettings =
            GrpcCallSettings.<CreateConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(createConversionEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateConversionEventRequest, ConversionEvent>
        updateConversionEventTransportSettings =
            GrpcCallSettings.<UpdateConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(updateConversionEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_event.name",
                          String.valueOf(request.getConversionEvent().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConversionEventRequest, ConversionEvent>
        getConversionEventTransportSettings =
            GrpcCallSettings.<GetConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(getConversionEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversionEventRequest, Empty> deleteConversionEventTransportSettings =
        GrpcCallSettings.<DeleteConversionEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversionEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConversionEventsRequest, ListConversionEventsResponse>
        listConversionEventsTransportSettings =
            GrpcCallSettings.<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
                .setMethodDescriptor(listConversionEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLinkTransportSettings =
            GrpcCallSettings
                .<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(getDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
        listDisplayVideo360AdvertiserLinksTransportSettings =
            GrpcCallSettings
                .<ListDisplayVideo360AdvertiserLinksRequest,
                    ListDisplayVideo360AdvertiserLinksResponse>
                    newBuilder()
                .setMethodDescriptor(listDisplayVideo360AdvertiserLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLinkTransportSettings =
            GrpcCallSettings
                .<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(createDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkTransportSettings =
            GrpcCallSettings.<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLinkTransportSettings =
            GrpcCallSettings
                .<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(updateDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "display_video_360_advertiser_link.name",
                          String.valueOf(request.getDisplayVideo360AdvertiserLink().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
        getDisplayVideo360AdvertiserLinkProposalTransportSettings =
            GrpcCallSettings
                .<GetDisplayVideo360AdvertiserLinkProposalRequest,
                    DisplayVideo360AdvertiserLinkProposal>
                    newBuilder()
                .setMethodDescriptor(getDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListDisplayVideo360AdvertiserLinkProposalsRequest,
            ListDisplayVideo360AdvertiserLinkProposalsResponse>
        listDisplayVideo360AdvertiserLinkProposalsTransportSettings =
            GrpcCallSettings
                .<ListDisplayVideo360AdvertiserLinkProposalsRequest,
                    ListDisplayVideo360AdvertiserLinkProposalsResponse>
                    newBuilder()
                .setMethodDescriptor(listDisplayVideo360AdvertiserLinkProposalsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            CreateDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        createDisplayVideo360AdvertiserLinkProposalTransportSettings =
            GrpcCallSettings
                .<CreateDisplayVideo360AdvertiserLinkProposalRequest,
                    DisplayVideo360AdvertiserLinkProposal>
                    newBuilder()
                .setMethodDescriptor(createDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkProposalTransportSettings =
            GrpcCallSettings.<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ApproveDisplayVideo360AdvertiserLinkProposalRequest,
            ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        approveDisplayVideo360AdvertiserLinkProposalTransportSettings =
            GrpcCallSettings
                .<ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                    ApproveDisplayVideo360AdvertiserLinkProposalResponse>
                    newBuilder()
                .setMethodDescriptor(approveDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            CancelDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        cancelDisplayVideo360AdvertiserLinkProposalTransportSettings =
            GrpcCallSettings
                .<CancelDisplayVideo360AdvertiserLinkProposalRequest,
                    DisplayVideo360AdvertiserLinkProposal>
                    newBuilder()
                .setMethodDescriptor(cancelDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionTransportSettings =
            GrpcCallSettings.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(createCustomDimensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionTransportSettings =
            GrpcCallSettings.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(updateCustomDimensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_dimension.name",
                          String.valueOf(request.getCustomDimension().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
        listCustomDimensionsTransportSettings =
            GrpcCallSettings.<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
                .setMethodDescriptor(listCustomDimensionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionTransportSettings =
        GrpcCallSettings.<ArchiveCustomDimensionRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveCustomDimensionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionTransportSettings =
            GrpcCallSettings.<GetCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(getCustomDimensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateCustomMetricRequest, CustomMetric> createCustomMetricTransportSettings =
        GrpcCallSettings.<CreateCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(createCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricTransportSettings =
        GrpcCallSettings.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(updateCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "custom_metric.name", String.valueOf(request.getCustomMetric().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCustomMetricsRequest, ListCustomMetricsResponse>
        listCustomMetricsTransportSettings =
            GrpcCallSettings.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
                .setMethodDescriptor(listCustomMetricsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricTransportSettings =
        GrpcCallSettings.<ArchiveCustomMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricTransportSettings =
        GrpcCallSettings.<GetCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(getCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsTransportSettings =
            GrpcCallSettings.<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(getDataRetentionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsTransportSettings =
            GrpcCallSettings.<UpdateDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(updateDataRetentionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_retention_settings.name",
                          String.valueOf(request.getDataRetentionSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateDataStreamRequest, DataStream> createDataStreamTransportSettings =
        GrpcCallSettings.<CreateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(createDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamTransportSettings =
        GrpcCallSettings.<DeleteDataStreamRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamTransportSettings =
        GrpcCallSettings.<UpdateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(updateDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_stream.name", String.valueOf(request.getDataStream().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataStreamsRequest, ListDataStreamsResponse>
        listDataStreamsTransportSettings =
            GrpcCallSettings.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
                .setMethodDescriptor(listDataStreamsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataStreamRequest, DataStream> getDataStreamTransportSettings =
        GrpcCallSettings.<GetDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(getDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAudienceRequest, Audience> getAudienceTransportSettings =
        GrpcCallSettings.<GetAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(getAudienceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAudiencesRequest, ListAudiencesResponse> listAudiencesTransportSettings =
        GrpcCallSettings.<ListAudiencesRequest, ListAudiencesResponse>newBuilder()
            .setMethodDescriptor(listAudiencesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAudienceRequest, Audience> createAudienceTransportSettings =
        GrpcCallSettings.<CreateAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(createAudienceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAudienceRequest, Audience> updateAudienceTransportSettings =
        GrpcCallSettings.<UpdateAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(updateAudienceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("audience.name", String.valueOf(request.getAudience().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ArchiveAudienceRequest, Empty> archiveAudienceTransportSettings =
        GrpcCallSettings.<ArchiveAudienceRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveAudienceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSearchAds360LinkRequest, SearchAds360Link>
        getSearchAds360LinkTransportSettings =
            GrpcCallSettings.<GetSearchAds360LinkRequest, SearchAds360Link>newBuilder()
                .setMethodDescriptor(getSearchAds360LinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
        listSearchAds360LinksTransportSettings =
            GrpcCallSettings
                .<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>newBuilder()
                .setMethodDescriptor(listSearchAds360LinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSearchAds360LinkRequest, SearchAds360Link>
        createSearchAds360LinkTransportSettings =
            GrpcCallSettings.<CreateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
                .setMethodDescriptor(createSearchAds360LinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSearchAds360LinkRequest, Empty> deleteSearchAds360LinkTransportSettings =
        GrpcCallSettings.<DeleteSearchAds360LinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSearchAds360LinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSearchAds360LinkRequest, SearchAds360Link>
        updateSearchAds360LinkTransportSettings =
            GrpcCallSettings.<UpdateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
                .setMethodDescriptor(updateSearchAds360LinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "search_ads_360_link.name",
                          String.valueOf(request.getSearchAds360Link().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAttributionSettingsRequest, AttributionSettings>
        getAttributionSettingsTransportSettings =
            GrpcCallSettings.<GetAttributionSettingsRequest, AttributionSettings>newBuilder()
                .setMethodDescriptor(getAttributionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAttributionSettingsRequest, AttributionSettings>
        updateAttributionSettingsTransportSettings =
            GrpcCallSettings.<UpdateAttributionSettingsRequest, AttributionSettings>newBuilder()
                .setMethodDescriptor(updateAttributionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "attribution_settings.name",
                          String.valueOf(request.getAttributionSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RunAccessReportRequest, RunAccessReportResponse>
        runAccessReportTransportSettings =
            GrpcCallSettings.<RunAccessReportRequest, RunAccessReportResponse>newBuilder()
                .setMethodDescriptor(runAccessReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("entity", String.valueOf(request.getEntity()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAccessBindingRequest, AccessBinding>
        createAccessBindingTransportSettings =
            GrpcCallSettings.<CreateAccessBindingRequest, AccessBinding>newBuilder()
                .setMethodDescriptor(createAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAccessBindingRequest, AccessBinding> getAccessBindingTransportSettings =
        GrpcCallSettings.<GetAccessBindingRequest, AccessBinding>newBuilder()
            .setMethodDescriptor(getAccessBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAccessBindingRequest, AccessBinding>
        updateAccessBindingTransportSettings =
            GrpcCallSettings.<UpdateAccessBindingRequest, AccessBinding>newBuilder()
                .setMethodDescriptor(updateAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "access_binding.name",
                          String.valueOf(request.getAccessBinding().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAccessBindingRequest, Empty> deleteAccessBindingTransportSettings =
        GrpcCallSettings.<DeleteAccessBindingRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccessBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAccessBindingsRequest, ListAccessBindingsResponse>
        listAccessBindingsTransportSettings =
            GrpcCallSettings.<ListAccessBindingsRequest, ListAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(listAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
        batchCreateAccessBindingsTransportSettings =
            GrpcCallSettings
                .<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(batchCreateAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
        batchGetAccessBindingsTransportSettings =
            GrpcCallSettings
                .<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(batchGetAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
        batchUpdateAccessBindingsTransportSettings =
            GrpcCallSettings
                .<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchDeleteAccessBindingsRequest, Empty>
        batchDeleteAccessBindingsTransportSettings =
            GrpcCallSettings.<BatchDeleteAccessBindingsRequest, Empty>newBuilder()
                .setMethodDescriptor(batchDeleteAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExpandedDataSetRequest, ExpandedDataSet>
        getExpandedDataSetTransportSettings =
            GrpcCallSettings.<GetExpandedDataSetRequest, ExpandedDataSet>newBuilder()
                .setMethodDescriptor(getExpandedDataSetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
        listExpandedDataSetsTransportSettings =
            GrpcCallSettings.<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>newBuilder()
                .setMethodDescriptor(listExpandedDataSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateExpandedDataSetRequest, ExpandedDataSet>
        createExpandedDataSetTransportSettings =
            GrpcCallSettings.<CreateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
                .setMethodDescriptor(createExpandedDataSetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateExpandedDataSetRequest, ExpandedDataSet>
        updateExpandedDataSetTransportSettings =
            GrpcCallSettings.<UpdateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
                .setMethodDescriptor(updateExpandedDataSetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "expanded_data_set.name",
                          String.valueOf(request.getExpandedDataSet().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteExpandedDataSetRequest, Empty> deleteExpandedDataSetTransportSettings =
        GrpcCallSettings.<DeleteExpandedDataSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExpandedDataSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetChannelGroupRequest, ChannelGroup> getChannelGroupTransportSettings =
        GrpcCallSettings.<GetChannelGroupRequest, ChannelGroup>newBuilder()
            .setMethodDescriptor(getChannelGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListChannelGroupsRequest, ListChannelGroupsResponse>
        listChannelGroupsTransportSettings =
            GrpcCallSettings.<ListChannelGroupsRequest, ListChannelGroupsResponse>newBuilder()
                .setMethodDescriptor(listChannelGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateChannelGroupRequest, ChannelGroup> createChannelGroupTransportSettings =
        GrpcCallSettings.<CreateChannelGroupRequest, ChannelGroup>newBuilder()
            .setMethodDescriptor(createChannelGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateChannelGroupRequest, ChannelGroup> updateChannelGroupTransportSettings =
        GrpcCallSettings.<UpdateChannelGroupRequest, ChannelGroup>newBuilder()
            .setMethodDescriptor(updateChannelGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "channel_group.name", String.valueOf(request.getChannelGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteChannelGroupRequest, Empty> deleteChannelGroupTransportSettings =
        GrpcCallSettings.<DeleteChannelGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteChannelGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<
            SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
        setAutomatedGa4ConfigurationOptOutTransportSettings =
            GrpcCallSettings
                .<SetAutomatedGa4ConfigurationOptOutRequest,
                    SetAutomatedGa4ConfigurationOptOutResponse>
                    newBuilder()
                .setMethodDescriptor(setAutomatedGa4ConfigurationOptOutMethodDescriptor)
                .build();
    GrpcCallSettings<
            FetchAutomatedGa4ConfigurationOptOutRequest,
            FetchAutomatedGa4ConfigurationOptOutResponse>
        fetchAutomatedGa4ConfigurationOptOutTransportSettings =
            GrpcCallSettings
                .<FetchAutomatedGa4ConfigurationOptOutRequest,
                    FetchAutomatedGa4ConfigurationOptOutResponse>
                    newBuilder()
                .setMethodDescriptor(fetchAutomatedGa4ConfigurationOptOutMethodDescriptor)
                .build();
    GrpcCallSettings<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkTransportSettings =
        GrpcCallSettings.<GetBigQueryLinkRequest, BigQueryLink>newBuilder()
            .setMethodDescriptor(getBigQueryLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
        listBigQueryLinksTransportSettings =
            GrpcCallSettings.<ListBigQueryLinksRequest, ListBigQueryLinksResponse>newBuilder()
                .setMethodDescriptor(listBigQueryLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
        getEnhancedMeasurementSettingsTransportSettings =
            GrpcCallSettings
                .<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
                .setMethodDescriptor(getEnhancedMeasurementSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
        updateEnhancedMeasurementSettingsTransportSettings =
            GrpcCallSettings
                .<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
                .setMethodDescriptor(updateEnhancedMeasurementSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "enhanced_measurement_settings.name",
                          String.valueOf(request.getEnhancedMeasurementSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
        createConnectedSiteTagTransportSettings =
            GrpcCallSettings
                .<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>newBuilder()
                .setMethodDescriptor(createConnectedSiteTagMethodDescriptor)
                .build();
    GrpcCallSettings<DeleteConnectedSiteTagRequest, Empty> deleteConnectedSiteTagTransportSettings =
        GrpcCallSettings.<DeleteConnectedSiteTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConnectedSiteTagMethodDescriptor)
            .build();
    GrpcCallSettings<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
        listConnectedSiteTagsTransportSettings =
            GrpcCallSettings
                .<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>newBuilder()
                .setMethodDescriptor(listConnectedSiteTagsMethodDescriptor)
                .build();
    GrpcCallSettings<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
        fetchConnectedGa4PropertyTransportSettings =
            GrpcCallSettings
                .<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>newBuilder()
                .setMethodDescriptor(fetchConnectedGa4PropertyMethodDescriptor)
                .build();
    GrpcCallSettings<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkTransportSettings =
        GrpcCallSettings.<GetAdSenseLinkRequest, AdSenseLink>newBuilder()
            .setMethodDescriptor(getAdSenseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkTransportSettings =
        GrpcCallSettings.<CreateAdSenseLinkRequest, AdSenseLink>newBuilder()
            .setMethodDescriptor(createAdSenseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkTransportSettings =
        GrpcCallSettings.<DeleteAdSenseLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAdSenseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
        listAdSenseLinksTransportSettings =
            GrpcCallSettings.<ListAdSenseLinksRequest, ListAdSenseLinksResponse>newBuilder()
                .setMethodDescriptor(listAdSenseLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEventCreateRuleRequest, EventCreateRule>
        getEventCreateRuleTransportSettings =
            GrpcCallSettings.<GetEventCreateRuleRequest, EventCreateRule>newBuilder()
                .setMethodDescriptor(getEventCreateRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
        listEventCreateRulesTransportSettings =
            GrpcCallSettings.<ListEventCreateRulesRequest, ListEventCreateRulesResponse>newBuilder()
                .setMethodDescriptor(listEventCreateRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateEventCreateRuleRequest, EventCreateRule>
        createEventCreateRuleTransportSettings =
            GrpcCallSettings.<CreateEventCreateRuleRequest, EventCreateRule>newBuilder()
                .setMethodDescriptor(createEventCreateRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEventCreateRuleRequest, EventCreateRule>
        updateEventCreateRuleTransportSettings =
            GrpcCallSettings.<UpdateEventCreateRuleRequest, EventCreateRule>newBuilder()
                .setMethodDescriptor(updateEventCreateRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "event_create_rule.name",
                          String.valueOf(request.getEventCreateRule().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEventCreateRuleRequest, Empty> deleteEventCreateRuleTransportSettings =
        GrpcCallSettings.<DeleteEventCreateRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEventCreateRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
        updateDataRedactionSettingsTransportSettings =
            GrpcCallSettings.<UpdateDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
                .setMethodDescriptor(updateDataRedactionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_redaction_settings.name",
                          String.valueOf(request.getDataRedactionSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataRedactionSettingsRequest, DataRedactionSettings>
        getDataRedactionSettingsTransportSettings =
            GrpcCallSettings.<GetDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
                .setMethodDescriptor(getDataRedactionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCalculatedMetricRequest, CalculatedMetric>
        getCalculatedMetricTransportSettings =
            GrpcCallSettings.<GetCalculatedMetricRequest, CalculatedMetric>newBuilder()
                .setMethodDescriptor(getCalculatedMetricMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateCalculatedMetricRequest, CalculatedMetric>
        createCalculatedMetricTransportSettings =
            GrpcCallSettings.<CreateCalculatedMetricRequest, CalculatedMetric>newBuilder()
                .setMethodDescriptor(createCalculatedMetricMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
        listCalculatedMetricsTransportSettings =
            GrpcCallSettings
                .<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>newBuilder()
                .setMethodDescriptor(listCalculatedMetricsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateCalculatedMetricRequest, CalculatedMetric>
        updateCalculatedMetricTransportSettings =
            GrpcCallSettings.<UpdateCalculatedMetricRequest, CalculatedMetric>newBuilder()
                .setMethodDescriptor(updateCalculatedMetricMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "calculated_metric.name",
                          String.valueOf(request.getCalculatedMetric().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCalculatedMetricRequest, Empty> deleteCalculatedMetricTransportSettings =
        GrpcCallSettings.<DeleteCalculatedMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCalculatedMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
        createRollupPropertyTransportSettings =
            GrpcCallSettings.<CreateRollupPropertyRequest, CreateRollupPropertyResponse>newBuilder()
                .setMethodDescriptor(createRollupPropertyMethodDescriptor)
                .build();
    GrpcCallSettings<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
        getRollupPropertySourceLinkTransportSettings =
            GrpcCallSettings
                .<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
                .setMethodDescriptor(getRollupPropertySourceLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
        listRollupPropertySourceLinksTransportSettings =
            GrpcCallSettings
                .<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
                    newBuilder()
                .setMethodDescriptor(listRollupPropertySourceLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
        createRollupPropertySourceLinkTransportSettings =
            GrpcCallSettings
                .<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
                .setMethodDescriptor(createRollupPropertySourceLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteRollupPropertySourceLinkRequest, Empty>
        deleteRollupPropertySourceLinkTransportSettings =
            GrpcCallSettings.<DeleteRollupPropertySourceLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteRollupPropertySourceLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSubpropertyRequest, CreateSubpropertyResponse>
        createSubpropertyTransportSettings =
            GrpcCallSettings.<CreateSubpropertyRequest, CreateSubpropertyResponse>newBuilder()
                .setMethodDescriptor(createSubpropertyMethodDescriptor)
                .build();
    GrpcCallSettings<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
        createSubpropertyEventFilterTransportSettings =
            GrpcCallSettings
                .<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
                .setMethodDescriptor(createSubpropertyEventFilterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
        getSubpropertyEventFilterTransportSettings =
            GrpcCallSettings.<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
                .setMethodDescriptor(getSubpropertyEventFilterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
        listSubpropertyEventFiltersTransportSettings =
            GrpcCallSettings
                .<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
                    newBuilder()
                .setMethodDescriptor(listSubpropertyEventFiltersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
        updateSubpropertyEventFilterTransportSettings =
            GrpcCallSettings
                .<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
                .setMethodDescriptor(updateSubpropertyEventFilterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "subproperty_event_filter.name",
                          String.valueOf(request.getSubpropertyEventFilter().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSubpropertyEventFilterRequest, Empty>
        deleteSubpropertyEventFilterTransportSettings =
            GrpcCallSettings.<DeleteSubpropertyEventFilterRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSubpropertyEventFilterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getAccountCallable =
        callableFactory.createUnaryCallable(
            getAccountTransportSettings, settings.getAccountSettings(), clientContext);
    this.listAccountsCallable =
        callableFactory.createUnaryCallable(
            listAccountsTransportSettings, settings.listAccountsSettings(), clientContext);
    this.listAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountsTransportSettings, settings.listAccountsSettings(), clientContext);
    this.deleteAccountCallable =
        callableFactory.createUnaryCallable(
            deleteAccountTransportSettings, settings.deleteAccountSettings(), clientContext);
    this.updateAccountCallable =
        callableFactory.createUnaryCallable(
            updateAccountTransportSettings, settings.updateAccountSettings(), clientContext);
    this.provisionAccountTicketCallable =
        callableFactory.createUnaryCallable(
            provisionAccountTicketTransportSettings,
            settings.provisionAccountTicketSettings(),
            clientContext);
    this.listAccountSummariesCallable =
        callableFactory.createUnaryCallable(
            listAccountSummariesTransportSettings,
            settings.listAccountSummariesSettings(),
            clientContext);
    this.listAccountSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listAccountSummariesTransportSettings,
            settings.listAccountSummariesSettings(),
            clientContext);
    this.getPropertyCallable =
        callableFactory.createUnaryCallable(
            getPropertyTransportSettings, settings.getPropertySettings(), clientContext);
    this.listPropertiesCallable =
        callableFactory.createUnaryCallable(
            listPropertiesTransportSettings, settings.listPropertiesSettings(), clientContext);
    this.listPropertiesPagedCallable =
        callableFactory.createPagedCallable(
            listPropertiesTransportSettings, settings.listPropertiesSettings(), clientContext);
    this.createPropertyCallable =
        callableFactory.createUnaryCallable(
            createPropertyTransportSettings, settings.createPropertySettings(), clientContext);
    this.deletePropertyCallable =
        callableFactory.createUnaryCallable(
            deletePropertyTransportSettings, settings.deletePropertySettings(), clientContext);
    this.updatePropertyCallable =
        callableFactory.createUnaryCallable(
            updatePropertyTransportSettings, settings.updatePropertySettings(), clientContext);
    this.createFirebaseLinkCallable =
        callableFactory.createUnaryCallable(
            createFirebaseLinkTransportSettings,
            settings.createFirebaseLinkSettings(),
            clientContext);
    this.deleteFirebaseLinkCallable =
        callableFactory.createUnaryCallable(
            deleteFirebaseLinkTransportSettings,
            settings.deleteFirebaseLinkSettings(),
            clientContext);
    this.listFirebaseLinksCallable =
        callableFactory.createUnaryCallable(
            listFirebaseLinksTransportSettings,
            settings.listFirebaseLinksSettings(),
            clientContext);
    this.listFirebaseLinksPagedCallable =
        callableFactory.createPagedCallable(
            listFirebaseLinksTransportSettings,
            settings.listFirebaseLinksSettings(),
            clientContext);
    this.getGlobalSiteTagCallable =
        callableFactory.createUnaryCallable(
            getGlobalSiteTagTransportSettings, settings.getGlobalSiteTagSettings(), clientContext);
    this.createGoogleAdsLinkCallable =
        callableFactory.createUnaryCallable(
            createGoogleAdsLinkTransportSettings,
            settings.createGoogleAdsLinkSettings(),
            clientContext);
    this.updateGoogleAdsLinkCallable =
        callableFactory.createUnaryCallable(
            updateGoogleAdsLinkTransportSettings,
            settings.updateGoogleAdsLinkSettings(),
            clientContext);
    this.deleteGoogleAdsLinkCallable =
        callableFactory.createUnaryCallable(
            deleteGoogleAdsLinkTransportSettings,
            settings.deleteGoogleAdsLinkSettings(),
            clientContext);
    this.listGoogleAdsLinksCallable =
        callableFactory.createUnaryCallable(
            listGoogleAdsLinksTransportSettings,
            settings.listGoogleAdsLinksSettings(),
            clientContext);
    this.listGoogleAdsLinksPagedCallable =
        callableFactory.createPagedCallable(
            listGoogleAdsLinksTransportSettings,
            settings.listGoogleAdsLinksSettings(),
            clientContext);
    this.getDataSharingSettingsCallable =
        callableFactory.createUnaryCallable(
            getDataSharingSettingsTransportSettings,
            settings.getDataSharingSettingsSettings(),
            clientContext);
    this.getMeasurementProtocolSecretCallable =
        callableFactory.createUnaryCallable(
            getMeasurementProtocolSecretTransportSettings,
            settings.getMeasurementProtocolSecretSettings(),
            clientContext);
    this.listMeasurementProtocolSecretsCallable =
        callableFactory.createUnaryCallable(
            listMeasurementProtocolSecretsTransportSettings,
            settings.listMeasurementProtocolSecretsSettings(),
            clientContext);
    this.listMeasurementProtocolSecretsPagedCallable =
        callableFactory.createPagedCallable(
            listMeasurementProtocolSecretsTransportSettings,
            settings.listMeasurementProtocolSecretsSettings(),
            clientContext);
    this.createMeasurementProtocolSecretCallable =
        callableFactory.createUnaryCallable(
            createMeasurementProtocolSecretTransportSettings,
            settings.createMeasurementProtocolSecretSettings(),
            clientContext);
    this.deleteMeasurementProtocolSecretCallable =
        callableFactory.createUnaryCallable(
            deleteMeasurementProtocolSecretTransportSettings,
            settings.deleteMeasurementProtocolSecretSettings(),
            clientContext);
    this.updateMeasurementProtocolSecretCallable =
        callableFactory.createUnaryCallable(
            updateMeasurementProtocolSecretTransportSettings,
            settings.updateMeasurementProtocolSecretSettings(),
            clientContext);
    this.acknowledgeUserDataCollectionCallable =
        callableFactory.createUnaryCallable(
            acknowledgeUserDataCollectionTransportSettings,
            settings.acknowledgeUserDataCollectionSettings(),
            clientContext);
    this.getSKAdNetworkConversionValueSchemaCallable =
        callableFactory.createUnaryCallable(
            getSKAdNetworkConversionValueSchemaTransportSettings,
            settings.getSKAdNetworkConversionValueSchemaSettings(),
            clientContext);
    this.createSKAdNetworkConversionValueSchemaCallable =
        callableFactory.createUnaryCallable(
            createSKAdNetworkConversionValueSchemaTransportSettings,
            settings.createSKAdNetworkConversionValueSchemaSettings(),
            clientContext);
    this.deleteSKAdNetworkConversionValueSchemaCallable =
        callableFactory.createUnaryCallable(
            deleteSKAdNetworkConversionValueSchemaTransportSettings,
            settings.deleteSKAdNetworkConversionValueSchemaSettings(),
            clientContext);
    this.updateSKAdNetworkConversionValueSchemaCallable =
        callableFactory.createUnaryCallable(
            updateSKAdNetworkConversionValueSchemaTransportSettings,
            settings.updateSKAdNetworkConversionValueSchemaSettings(),
            clientContext);
    this.listSKAdNetworkConversionValueSchemasCallable =
        callableFactory.createUnaryCallable(
            listSKAdNetworkConversionValueSchemasTransportSettings,
            settings.listSKAdNetworkConversionValueSchemasSettings(),
            clientContext);
    this.listSKAdNetworkConversionValueSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listSKAdNetworkConversionValueSchemasTransportSettings,
            settings.listSKAdNetworkConversionValueSchemasSettings(),
            clientContext);
    this.searchChangeHistoryEventsCallable =
        callableFactory.createUnaryCallable(
            searchChangeHistoryEventsTransportSettings,
            settings.searchChangeHistoryEventsSettings(),
            clientContext);
    this.searchChangeHistoryEventsPagedCallable =
        callableFactory.createPagedCallable(
            searchChangeHistoryEventsTransportSettings,
            settings.searchChangeHistoryEventsSettings(),
            clientContext);
    this.getGoogleSignalsSettingsCallable =
        callableFactory.createUnaryCallable(
            getGoogleSignalsSettingsTransportSettings,
            settings.getGoogleSignalsSettingsSettings(),
            clientContext);
    this.updateGoogleSignalsSettingsCallable =
        callableFactory.createUnaryCallable(
            updateGoogleSignalsSettingsTransportSettings,
            settings.updateGoogleSignalsSettingsSettings(),
            clientContext);
    this.createConversionEventCallable =
        callableFactory.createUnaryCallable(
            createConversionEventTransportSettings,
            settings.createConversionEventSettings(),
            clientContext);
    this.updateConversionEventCallable =
        callableFactory.createUnaryCallable(
            updateConversionEventTransportSettings,
            settings.updateConversionEventSettings(),
            clientContext);
    this.getConversionEventCallable =
        callableFactory.createUnaryCallable(
            getConversionEventTransportSettings,
            settings.getConversionEventSettings(),
            clientContext);
    this.deleteConversionEventCallable =
        callableFactory.createUnaryCallable(
            deleteConversionEventTransportSettings,
            settings.deleteConversionEventSettings(),
            clientContext);
    this.listConversionEventsCallable =
        callableFactory.createUnaryCallable(
            listConversionEventsTransportSettings,
            settings.listConversionEventsSettings(),
            clientContext);
    this.listConversionEventsPagedCallable =
        callableFactory.createPagedCallable(
            listConversionEventsTransportSettings,
            settings.listConversionEventsSettings(),
            clientContext);
    this.getDisplayVideo360AdvertiserLinkCallable =
        callableFactory.createUnaryCallable(
            getDisplayVideo360AdvertiserLinkTransportSettings,
            settings.getDisplayVideo360AdvertiserLinkSettings(),
            clientContext);
    this.listDisplayVideo360AdvertiserLinksCallable =
        callableFactory.createUnaryCallable(
            listDisplayVideo360AdvertiserLinksTransportSettings,
            settings.listDisplayVideo360AdvertiserLinksSettings(),
            clientContext);
    this.listDisplayVideo360AdvertiserLinksPagedCallable =
        callableFactory.createPagedCallable(
            listDisplayVideo360AdvertiserLinksTransportSettings,
            settings.listDisplayVideo360AdvertiserLinksSettings(),
            clientContext);
    this.createDisplayVideo360AdvertiserLinkCallable =
        callableFactory.createUnaryCallable(
            createDisplayVideo360AdvertiserLinkTransportSettings,
            settings.createDisplayVideo360AdvertiserLinkSettings(),
            clientContext);
    this.deleteDisplayVideo360AdvertiserLinkCallable =
        callableFactory.createUnaryCallable(
            deleteDisplayVideo360AdvertiserLinkTransportSettings,
            settings.deleteDisplayVideo360AdvertiserLinkSettings(),
            clientContext);
    this.updateDisplayVideo360AdvertiserLinkCallable =
        callableFactory.createUnaryCallable(
            updateDisplayVideo360AdvertiserLinkTransportSettings,
            settings.updateDisplayVideo360AdvertiserLinkSettings(),
            clientContext);
    this.getDisplayVideo360AdvertiserLinkProposalCallable =
        callableFactory.createUnaryCallable(
            getDisplayVideo360AdvertiserLinkProposalTransportSettings,
            settings.getDisplayVideo360AdvertiserLinkProposalSettings(),
            clientContext);
    this.listDisplayVideo360AdvertiserLinkProposalsCallable =
        callableFactory.createUnaryCallable(
            listDisplayVideo360AdvertiserLinkProposalsTransportSettings,
            settings.listDisplayVideo360AdvertiserLinkProposalsSettings(),
            clientContext);
    this.listDisplayVideo360AdvertiserLinkProposalsPagedCallable =
        callableFactory.createPagedCallable(
            listDisplayVideo360AdvertiserLinkProposalsTransportSettings,
            settings.listDisplayVideo360AdvertiserLinkProposalsSettings(),
            clientContext);
    this.createDisplayVideo360AdvertiserLinkProposalCallable =
        callableFactory.createUnaryCallable(
            createDisplayVideo360AdvertiserLinkProposalTransportSettings,
            settings.createDisplayVideo360AdvertiserLinkProposalSettings(),
            clientContext);
    this.deleteDisplayVideo360AdvertiserLinkProposalCallable =
        callableFactory.createUnaryCallable(
            deleteDisplayVideo360AdvertiserLinkProposalTransportSettings,
            settings.deleteDisplayVideo360AdvertiserLinkProposalSettings(),
            clientContext);
    this.approveDisplayVideo360AdvertiserLinkProposalCallable =
        callableFactory.createUnaryCallable(
            approveDisplayVideo360AdvertiserLinkProposalTransportSettings,
            settings.approveDisplayVideo360AdvertiserLinkProposalSettings(),
            clientContext);
    this.cancelDisplayVideo360AdvertiserLinkProposalCallable =
        callableFactory.createUnaryCallable(
            cancelDisplayVideo360AdvertiserLinkProposalTransportSettings,
            settings.cancelDisplayVideo360AdvertiserLinkProposalSettings(),
            clientContext);
    this.createCustomDimensionCallable =
        callableFactory.createUnaryCallable(
            createCustomDimensionTransportSettings,
            settings.createCustomDimensionSettings(),
            clientContext);
    this.updateCustomDimensionCallable =
        callableFactory.createUnaryCallable(
            updateCustomDimensionTransportSettings,
            settings.updateCustomDimensionSettings(),
            clientContext);
    this.listCustomDimensionsCallable =
        callableFactory.createUnaryCallable(
            listCustomDimensionsTransportSettings,
            settings.listCustomDimensionsSettings(),
            clientContext);
    this.listCustomDimensionsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomDimensionsTransportSettings,
            settings.listCustomDimensionsSettings(),
            clientContext);
    this.archiveCustomDimensionCallable =
        callableFactory.createUnaryCallable(
            archiveCustomDimensionTransportSettings,
            settings.archiveCustomDimensionSettings(),
            clientContext);
    this.getCustomDimensionCallable =
        callableFactory.createUnaryCallable(
            getCustomDimensionTransportSettings,
            settings.getCustomDimensionSettings(),
            clientContext);
    this.createCustomMetricCallable =
        callableFactory.createUnaryCallable(
            createCustomMetricTransportSettings,
            settings.createCustomMetricSettings(),
            clientContext);
    this.updateCustomMetricCallable =
        callableFactory.createUnaryCallable(
            updateCustomMetricTransportSettings,
            settings.updateCustomMetricSettings(),
            clientContext);
    this.listCustomMetricsCallable =
        callableFactory.createUnaryCallable(
            listCustomMetricsTransportSettings,
            settings.listCustomMetricsSettings(),
            clientContext);
    this.listCustomMetricsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomMetricsTransportSettings,
            settings.listCustomMetricsSettings(),
            clientContext);
    this.archiveCustomMetricCallable =
        callableFactory.createUnaryCallable(
            archiveCustomMetricTransportSettings,
            settings.archiveCustomMetricSettings(),
            clientContext);
    this.getCustomMetricCallable =
        callableFactory.createUnaryCallable(
            getCustomMetricTransportSettings, settings.getCustomMetricSettings(), clientContext);
    this.getDataRetentionSettingsCallable =
        callableFactory.createUnaryCallable(
            getDataRetentionSettingsTransportSettings,
            settings.getDataRetentionSettingsSettings(),
            clientContext);
    this.updateDataRetentionSettingsCallable =
        callableFactory.createUnaryCallable(
            updateDataRetentionSettingsTransportSettings,
            settings.updateDataRetentionSettingsSettings(),
            clientContext);
    this.createDataStreamCallable =
        callableFactory.createUnaryCallable(
            createDataStreamTransportSettings, settings.createDataStreamSettings(), clientContext);
    this.deleteDataStreamCallable =
        callableFactory.createUnaryCallable(
            deleteDataStreamTransportSettings, settings.deleteDataStreamSettings(), clientContext);
    this.updateDataStreamCallable =
        callableFactory.createUnaryCallable(
            updateDataStreamTransportSettings, settings.updateDataStreamSettings(), clientContext);
    this.listDataStreamsCallable =
        callableFactory.createUnaryCallable(
            listDataStreamsTransportSettings, settings.listDataStreamsSettings(), clientContext);
    this.listDataStreamsPagedCallable =
        callableFactory.createPagedCallable(
            listDataStreamsTransportSettings, settings.listDataStreamsSettings(), clientContext);
    this.getDataStreamCallable =
        callableFactory.createUnaryCallable(
            getDataStreamTransportSettings, settings.getDataStreamSettings(), clientContext);
    this.getAudienceCallable =
        callableFactory.createUnaryCallable(
            getAudienceTransportSettings, settings.getAudienceSettings(), clientContext);
    this.listAudiencesCallable =
        callableFactory.createUnaryCallable(
            listAudiencesTransportSettings, settings.listAudiencesSettings(), clientContext);
    this.listAudiencesPagedCallable =
        callableFactory.createPagedCallable(
            listAudiencesTransportSettings, settings.listAudiencesSettings(), clientContext);
    this.createAudienceCallable =
        callableFactory.createUnaryCallable(
            createAudienceTransportSettings, settings.createAudienceSettings(), clientContext);
    this.updateAudienceCallable =
        callableFactory.createUnaryCallable(
            updateAudienceTransportSettings, settings.updateAudienceSettings(), clientContext);
    this.archiveAudienceCallable =
        callableFactory.createUnaryCallable(
            archiveAudienceTransportSettings, settings.archiveAudienceSettings(), clientContext);
    this.getSearchAds360LinkCallable =
        callableFactory.createUnaryCallable(
            getSearchAds360LinkTransportSettings,
            settings.getSearchAds360LinkSettings(),
            clientContext);
    this.listSearchAds360LinksCallable =
        callableFactory.createUnaryCallable(
            listSearchAds360LinksTransportSettings,
            settings.listSearchAds360LinksSettings(),
            clientContext);
    this.listSearchAds360LinksPagedCallable =
        callableFactory.createPagedCallable(
            listSearchAds360LinksTransportSettings,
            settings.listSearchAds360LinksSettings(),
            clientContext);
    this.createSearchAds360LinkCallable =
        callableFactory.createUnaryCallable(
            createSearchAds360LinkTransportSettings,
            settings.createSearchAds360LinkSettings(),
            clientContext);
    this.deleteSearchAds360LinkCallable =
        callableFactory.createUnaryCallable(
            deleteSearchAds360LinkTransportSettings,
            settings.deleteSearchAds360LinkSettings(),
            clientContext);
    this.updateSearchAds360LinkCallable =
        callableFactory.createUnaryCallable(
            updateSearchAds360LinkTransportSettings,
            settings.updateSearchAds360LinkSettings(),
            clientContext);
    this.getAttributionSettingsCallable =
        callableFactory.createUnaryCallable(
            getAttributionSettingsTransportSettings,
            settings.getAttributionSettingsSettings(),
            clientContext);
    this.updateAttributionSettingsCallable =
        callableFactory.createUnaryCallable(
            updateAttributionSettingsTransportSettings,
            settings.updateAttributionSettingsSettings(),
            clientContext);
    this.runAccessReportCallable =
        callableFactory.createUnaryCallable(
            runAccessReportTransportSettings, settings.runAccessReportSettings(), clientContext);
    this.createAccessBindingCallable =
        callableFactory.createUnaryCallable(
            createAccessBindingTransportSettings,
            settings.createAccessBindingSettings(),
            clientContext);
    this.getAccessBindingCallable =
        callableFactory.createUnaryCallable(
            getAccessBindingTransportSettings, settings.getAccessBindingSettings(), clientContext);
    this.updateAccessBindingCallable =
        callableFactory.createUnaryCallable(
            updateAccessBindingTransportSettings,
            settings.updateAccessBindingSettings(),
            clientContext);
    this.deleteAccessBindingCallable =
        callableFactory.createUnaryCallable(
            deleteAccessBindingTransportSettings,
            settings.deleteAccessBindingSettings(),
            clientContext);
    this.listAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            listAccessBindingsTransportSettings,
            settings.listAccessBindingsSettings(),
            clientContext);
    this.listAccessBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listAccessBindingsTransportSettings,
            settings.listAccessBindingsSettings(),
            clientContext);
    this.batchCreateAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            batchCreateAccessBindingsTransportSettings,
            settings.batchCreateAccessBindingsSettings(),
            clientContext);
    this.batchGetAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            batchGetAccessBindingsTransportSettings,
            settings.batchGetAccessBindingsSettings(),
            clientContext);
    this.batchUpdateAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateAccessBindingsTransportSettings,
            settings.batchUpdateAccessBindingsSettings(),
            clientContext);
    this.batchDeleteAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteAccessBindingsTransportSettings,
            settings.batchDeleteAccessBindingsSettings(),
            clientContext);
    this.getExpandedDataSetCallable =
        callableFactory.createUnaryCallable(
            getExpandedDataSetTransportSettings,
            settings.getExpandedDataSetSettings(),
            clientContext);
    this.listExpandedDataSetsCallable =
        callableFactory.createUnaryCallable(
            listExpandedDataSetsTransportSettings,
            settings.listExpandedDataSetsSettings(),
            clientContext);
    this.listExpandedDataSetsPagedCallable =
        callableFactory.createPagedCallable(
            listExpandedDataSetsTransportSettings,
            settings.listExpandedDataSetsSettings(),
            clientContext);
    this.createExpandedDataSetCallable =
        callableFactory.createUnaryCallable(
            createExpandedDataSetTransportSettings,
            settings.createExpandedDataSetSettings(),
            clientContext);
    this.updateExpandedDataSetCallable =
        callableFactory.createUnaryCallable(
            updateExpandedDataSetTransportSettings,
            settings.updateExpandedDataSetSettings(),
            clientContext);
    this.deleteExpandedDataSetCallable =
        callableFactory.createUnaryCallable(
            deleteExpandedDataSetTransportSettings,
            settings.deleteExpandedDataSetSettings(),
            clientContext);
    this.getChannelGroupCallable =
        callableFactory.createUnaryCallable(
            getChannelGroupTransportSettings, settings.getChannelGroupSettings(), clientContext);
    this.listChannelGroupsCallable =
        callableFactory.createUnaryCallable(
            listChannelGroupsTransportSettings,
            settings.listChannelGroupsSettings(),
            clientContext);
    this.listChannelGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelGroupsTransportSettings,
            settings.listChannelGroupsSettings(),
            clientContext);
    this.createChannelGroupCallable =
        callableFactory.createUnaryCallable(
            createChannelGroupTransportSettings,
            settings.createChannelGroupSettings(),
            clientContext);
    this.updateChannelGroupCallable =
        callableFactory.createUnaryCallable(
            updateChannelGroupTransportSettings,
            settings.updateChannelGroupSettings(),
            clientContext);
    this.deleteChannelGroupCallable =
        callableFactory.createUnaryCallable(
            deleteChannelGroupTransportSettings,
            settings.deleteChannelGroupSettings(),
            clientContext);
    this.setAutomatedGa4ConfigurationOptOutCallable =
        callableFactory.createUnaryCallable(
            setAutomatedGa4ConfigurationOptOutTransportSettings,
            settings.setAutomatedGa4ConfigurationOptOutSettings(),
            clientContext);
    this.fetchAutomatedGa4ConfigurationOptOutCallable =
        callableFactory.createUnaryCallable(
            fetchAutomatedGa4ConfigurationOptOutTransportSettings,
            settings.fetchAutomatedGa4ConfigurationOptOutSettings(),
            clientContext);
    this.getBigQueryLinkCallable =
        callableFactory.createUnaryCallable(
            getBigQueryLinkTransportSettings, settings.getBigQueryLinkSettings(), clientContext);
    this.listBigQueryLinksCallable =
        callableFactory.createUnaryCallable(
            listBigQueryLinksTransportSettings,
            settings.listBigQueryLinksSettings(),
            clientContext);
    this.listBigQueryLinksPagedCallable =
        callableFactory.createPagedCallable(
            listBigQueryLinksTransportSettings,
            settings.listBigQueryLinksSettings(),
            clientContext);
    this.getEnhancedMeasurementSettingsCallable =
        callableFactory.createUnaryCallable(
            getEnhancedMeasurementSettingsTransportSettings,
            settings.getEnhancedMeasurementSettingsSettings(),
            clientContext);
    this.updateEnhancedMeasurementSettingsCallable =
        callableFactory.createUnaryCallable(
            updateEnhancedMeasurementSettingsTransportSettings,
            settings.updateEnhancedMeasurementSettingsSettings(),
            clientContext);
    this.createConnectedSiteTagCallable =
        callableFactory.createUnaryCallable(
            createConnectedSiteTagTransportSettings,
            settings.createConnectedSiteTagSettings(),
            clientContext);
    this.deleteConnectedSiteTagCallable =
        callableFactory.createUnaryCallable(
            deleteConnectedSiteTagTransportSettings,
            settings.deleteConnectedSiteTagSettings(),
            clientContext);
    this.listConnectedSiteTagsCallable =
        callableFactory.createUnaryCallable(
            listConnectedSiteTagsTransportSettings,
            settings.listConnectedSiteTagsSettings(),
            clientContext);
    this.fetchConnectedGa4PropertyCallable =
        callableFactory.createUnaryCallable(
            fetchConnectedGa4PropertyTransportSettings,
            settings.fetchConnectedGa4PropertySettings(),
            clientContext);
    this.getAdSenseLinkCallable =
        callableFactory.createUnaryCallable(
            getAdSenseLinkTransportSettings, settings.getAdSenseLinkSettings(), clientContext);
    this.createAdSenseLinkCallable =
        callableFactory.createUnaryCallable(
            createAdSenseLinkTransportSettings,
            settings.createAdSenseLinkSettings(),
            clientContext);
    this.deleteAdSenseLinkCallable =
        callableFactory.createUnaryCallable(
            deleteAdSenseLinkTransportSettings,
            settings.deleteAdSenseLinkSettings(),
            clientContext);
    this.listAdSenseLinksCallable =
        callableFactory.createUnaryCallable(
            listAdSenseLinksTransportSettings, settings.listAdSenseLinksSettings(), clientContext);
    this.listAdSenseLinksPagedCallable =
        callableFactory.createPagedCallable(
            listAdSenseLinksTransportSettings, settings.listAdSenseLinksSettings(), clientContext);
    this.getEventCreateRuleCallable =
        callableFactory.createUnaryCallable(
            getEventCreateRuleTransportSettings,
            settings.getEventCreateRuleSettings(),
            clientContext);
    this.listEventCreateRulesCallable =
        callableFactory.createUnaryCallable(
            listEventCreateRulesTransportSettings,
            settings.listEventCreateRulesSettings(),
            clientContext);
    this.listEventCreateRulesPagedCallable =
        callableFactory.createPagedCallable(
            listEventCreateRulesTransportSettings,
            settings.listEventCreateRulesSettings(),
            clientContext);
    this.createEventCreateRuleCallable =
        callableFactory.createUnaryCallable(
            createEventCreateRuleTransportSettings,
            settings.createEventCreateRuleSettings(),
            clientContext);
    this.updateEventCreateRuleCallable =
        callableFactory.createUnaryCallable(
            updateEventCreateRuleTransportSettings,
            settings.updateEventCreateRuleSettings(),
            clientContext);
    this.deleteEventCreateRuleCallable =
        callableFactory.createUnaryCallable(
            deleteEventCreateRuleTransportSettings,
            settings.deleteEventCreateRuleSettings(),
            clientContext);
    this.updateDataRedactionSettingsCallable =
        callableFactory.createUnaryCallable(
            updateDataRedactionSettingsTransportSettings,
            settings.updateDataRedactionSettingsSettings(),
            clientContext);
    this.getDataRedactionSettingsCallable =
        callableFactory.createUnaryCallable(
            getDataRedactionSettingsTransportSettings,
            settings.getDataRedactionSettingsSettings(),
            clientContext);
    this.getCalculatedMetricCallable =
        callableFactory.createUnaryCallable(
            getCalculatedMetricTransportSettings,
            settings.getCalculatedMetricSettings(),
            clientContext);
    this.createCalculatedMetricCallable =
        callableFactory.createUnaryCallable(
            createCalculatedMetricTransportSettings,
            settings.createCalculatedMetricSettings(),
            clientContext);
    this.listCalculatedMetricsCallable =
        callableFactory.createUnaryCallable(
            listCalculatedMetricsTransportSettings,
            settings.listCalculatedMetricsSettings(),
            clientContext);
    this.listCalculatedMetricsPagedCallable =
        callableFactory.createPagedCallable(
            listCalculatedMetricsTransportSettings,
            settings.listCalculatedMetricsSettings(),
            clientContext);
    this.updateCalculatedMetricCallable =
        callableFactory.createUnaryCallable(
            updateCalculatedMetricTransportSettings,
            settings.updateCalculatedMetricSettings(),
            clientContext);
    this.deleteCalculatedMetricCallable =
        callableFactory.createUnaryCallable(
            deleteCalculatedMetricTransportSettings,
            settings.deleteCalculatedMetricSettings(),
            clientContext);
    this.createRollupPropertyCallable =
        callableFactory.createUnaryCallable(
            createRollupPropertyTransportSettings,
            settings.createRollupPropertySettings(),
            clientContext);
    this.getRollupPropertySourceLinkCallable =
        callableFactory.createUnaryCallable(
            getRollupPropertySourceLinkTransportSettings,
            settings.getRollupPropertySourceLinkSettings(),
            clientContext);
    this.listRollupPropertySourceLinksCallable =
        callableFactory.createUnaryCallable(
            listRollupPropertySourceLinksTransportSettings,
            settings.listRollupPropertySourceLinksSettings(),
            clientContext);
    this.listRollupPropertySourceLinksPagedCallable =
        callableFactory.createPagedCallable(
            listRollupPropertySourceLinksTransportSettings,
            settings.listRollupPropertySourceLinksSettings(),
            clientContext);
    this.createRollupPropertySourceLinkCallable =
        callableFactory.createUnaryCallable(
            createRollupPropertySourceLinkTransportSettings,
            settings.createRollupPropertySourceLinkSettings(),
            clientContext);
    this.deleteRollupPropertySourceLinkCallable =
        callableFactory.createUnaryCallable(
            deleteRollupPropertySourceLinkTransportSettings,
            settings.deleteRollupPropertySourceLinkSettings(),
            clientContext);
    this.createSubpropertyCallable =
        callableFactory.createUnaryCallable(
            createSubpropertyTransportSettings,
            settings.createSubpropertySettings(),
            clientContext);
    this.createSubpropertyEventFilterCallable =
        callableFactory.createUnaryCallable(
            createSubpropertyEventFilterTransportSettings,
            settings.createSubpropertyEventFilterSettings(),
            clientContext);
    this.getSubpropertyEventFilterCallable =
        callableFactory.createUnaryCallable(
            getSubpropertyEventFilterTransportSettings,
            settings.getSubpropertyEventFilterSettings(),
            clientContext);
    this.listSubpropertyEventFiltersCallable =
        callableFactory.createUnaryCallable(
            listSubpropertyEventFiltersTransportSettings,
            settings.listSubpropertyEventFiltersSettings(),
            clientContext);
    this.listSubpropertyEventFiltersPagedCallable =
        callableFactory.createPagedCallable(
            listSubpropertyEventFiltersTransportSettings,
            settings.listSubpropertyEventFiltersSettings(),
            clientContext);
    this.updateSubpropertyEventFilterCallable =
        callableFactory.createUnaryCallable(
            updateSubpropertyEventFilterTransportSettings,
            settings.updateSubpropertyEventFilterSettings(),
            clientContext);
    this.deleteSubpropertyEventFilterCallable =
        callableFactory.createUnaryCallable(
            deleteSubpropertyEventFilterTransportSettings,
            settings.deleteSubpropertyEventFilterSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    return getAccountCallable;
  }

  @Override
  public UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable() {
    return listAccountsCallable;
  }

  @Override
  public UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse> listAccountsPagedCallable() {
    return listAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable() {
    return deleteAccountCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable() {
    return updateAccountCallable;
  }

  @Override
  public UnaryCallable<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketCallable() {
    return provisionAccountTicketCallable;
  }

  @Override
  public UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesResponse>
      listAccountSummariesCallable() {
    return listAccountSummariesCallable;
  }

  @Override
  public UnaryCallable<ListAccountSummariesRequest, ListAccountSummariesPagedResponse>
      listAccountSummariesPagedCallable() {
    return listAccountSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPropertyRequest, Property> getPropertyCallable() {
    return getPropertyCallable;
  }

  @Override
  public UnaryCallable<ListPropertiesRequest, ListPropertiesResponse> listPropertiesCallable() {
    return listPropertiesCallable;
  }

  @Override
  public UnaryCallable<ListPropertiesRequest, ListPropertiesPagedResponse>
      listPropertiesPagedCallable() {
    return listPropertiesPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePropertyRequest, Property> createPropertyCallable() {
    return createPropertyCallable;
  }

  @Override
  public UnaryCallable<DeletePropertyRequest, Property> deletePropertyCallable() {
    return deletePropertyCallable;
  }

  @Override
  public UnaryCallable<UpdatePropertyRequest, Property> updatePropertyCallable() {
    return updatePropertyCallable;
  }

  @Override
  public UnaryCallable<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkCallable() {
    return createFirebaseLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkCallable() {
    return deleteFirebaseLinkCallable;
  }

  @Override
  public UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksCallable() {
    return listFirebaseLinksCallable;
  }

  @Override
  public UnaryCallable<ListFirebaseLinksRequest, ListFirebaseLinksPagedResponse>
      listFirebaseLinksPagedCallable() {
    return listFirebaseLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagCallable() {
    return getGlobalSiteTagCallable;
  }

  @Override
  public UnaryCallable<CreateGoogleAdsLinkRequest, GoogleAdsLink> createGoogleAdsLinkCallable() {
    return createGoogleAdsLinkCallable;
  }

  @Override
  public UnaryCallable<UpdateGoogleAdsLinkRequest, GoogleAdsLink> updateGoogleAdsLinkCallable() {
    return updateGoogleAdsLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkCallable() {
    return deleteGoogleAdsLinkCallable;
  }

  @Override
  public UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksCallable() {
    return listGoogleAdsLinksCallable;
  }

  @Override
  public UnaryCallable<ListGoogleAdsLinksRequest, ListGoogleAdsLinksPagedResponse>
      listGoogleAdsLinksPagedCallable() {
    return listGoogleAdsLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsCallable() {
    return getDataSharingSettingsCallable;
  }

  @Override
  public UnaryCallable<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretCallable() {
    return getMeasurementProtocolSecretCallable;
  }

  @Override
  public UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
      listMeasurementProtocolSecretsCallable() {
    return listMeasurementProtocolSecretsCallable;
  }

  @Override
  public UnaryCallable<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsPagedResponse>
      listMeasurementProtocolSecretsPagedCallable() {
    return listMeasurementProtocolSecretsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretCallable() {
    return createMeasurementProtocolSecretCallable;
  }

  @Override
  public UnaryCallable<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretCallable() {
    return deleteMeasurementProtocolSecretCallable;
  }

  @Override
  public UnaryCallable<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretCallable() {
    return updateMeasurementProtocolSecretCallable;
  }

  @Override
  public UnaryCallable<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionCallable() {
    return acknowledgeUserDataCollectionCallable;
  }

  @Override
  public UnaryCallable<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaCallable() {
    return getSKAdNetworkConversionValueSchemaCallable;
  }

  @Override
  public UnaryCallable<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaCallable() {
    return createSKAdNetworkConversionValueSchemaCallable;
  }

  @Override
  public UnaryCallable<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaCallable() {
    return deleteSKAdNetworkConversionValueSchemaCallable;
  }

  @Override
  public UnaryCallable<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaCallable() {
    return updateSKAdNetworkConversionValueSchemaCallable;
  }

  @Override
  public UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse>
      listSKAdNetworkConversionValueSchemasCallable() {
    return listSKAdNetworkConversionValueSchemasCallable;
  }

  @Override
  public UnaryCallable<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasPagedResponse>
      listSKAdNetworkConversionValueSchemasPagedCallable() {
    return listSKAdNetworkConversionValueSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsCallable() {
    return searchChangeHistoryEventsCallable;
  }

  @Override
  public UnaryCallable<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsPagedResponse>
      searchChangeHistoryEventsPagedCallable() {
    return searchChangeHistoryEventsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsCallable() {
    return getGoogleSignalsSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsCallable() {
    return updateGoogleSignalsSettingsCallable;
  }

  @Override
  public UnaryCallable<CreateConversionEventRequest, ConversionEvent>
      createConversionEventCallable() {
    return createConversionEventCallable;
  }

  @Override
  public UnaryCallable<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventCallable() {
    return updateConversionEventCallable;
  }

  @Override
  public UnaryCallable<GetConversionEventRequest, ConversionEvent> getConversionEventCallable() {
    return getConversionEventCallable;
  }

  @Override
  public UnaryCallable<DeleteConversionEventRequest, Empty> deleteConversionEventCallable() {
    return deleteConversionEventCallable;
  }

  @Override
  public UnaryCallable<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsCallable() {
    return listConversionEventsCallable;
  }

  @Override
  public UnaryCallable<ListConversionEventsRequest, ListConversionEventsPagedResponse>
      listConversionEventsPagedCallable() {
    return listConversionEventsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkCallable() {
    return getDisplayVideo360AdvertiserLinkCallable;
  }

  @Override
  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
      listDisplayVideo360AdvertiserLinksCallable() {
    return listDisplayVideo360AdvertiserLinksCallable;
  }

  @Override
  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinksRequest,
          ListDisplayVideo360AdvertiserLinksPagedResponse>
      listDisplayVideo360AdvertiserLinksPagedCallable() {
    return listDisplayVideo360AdvertiserLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkCallable() {
    return createDisplayVideo360AdvertiserLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkCallable() {
    return deleteDisplayVideo360AdvertiserLinkCallable;
  }

  @Override
  public UnaryCallable<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkCallable() {
    return updateDisplayVideo360AdvertiserLinkCallable;
  }

  @Override
  public UnaryCallable<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalCallable() {
    return getDisplayVideo360AdvertiserLinkProposalCallable;
  }

  @Override
  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse>
      listDisplayVideo360AdvertiserLinkProposalsCallable() {
    return listDisplayVideo360AdvertiserLinkProposalsCallable;
  }

  @Override
  public UnaryCallable<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsPagedResponse>
      listDisplayVideo360AdvertiserLinkProposalsPagedCallable() {
    return listDisplayVideo360AdvertiserLinkProposalsPagedCallable;
  }

  @Override
  public UnaryCallable<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalCallable() {
    return createDisplayVideo360AdvertiserLinkProposalCallable;
  }

  @Override
  public UnaryCallable<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalCallable() {
    return deleteDisplayVideo360AdvertiserLinkProposalCallable;
  }

  @Override
  public UnaryCallable<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalCallable() {
    return approveDisplayVideo360AdvertiserLinkProposalCallable;
  }

  @Override
  public UnaryCallable<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalCallable() {
    return cancelDisplayVideo360AdvertiserLinkProposalCallable;
  }

  @Override
  public UnaryCallable<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionCallable() {
    return createCustomDimensionCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionCallable() {
    return updateCustomDimensionCallable;
  }

  @Override
  public UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsCallable() {
    return listCustomDimensionsCallable;
  }

  @Override
  public UnaryCallable<ListCustomDimensionsRequest, ListCustomDimensionsPagedResponse>
      listCustomDimensionsPagedCallable() {
    return listCustomDimensionsPagedCallable;
  }

  @Override
  public UnaryCallable<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionCallable() {
    return archiveCustomDimensionCallable;
  }

  @Override
  public UnaryCallable<GetCustomDimensionRequest, CustomDimension> getCustomDimensionCallable() {
    return getCustomDimensionCallable;
  }

  @Override
  public UnaryCallable<CreateCustomMetricRequest, CustomMetric> createCustomMetricCallable() {
    return createCustomMetricCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricCallable() {
    return updateCustomMetricCallable;
  }

  @Override
  public UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsCallable() {
    return listCustomMetricsCallable;
  }

  @Override
  public UnaryCallable<ListCustomMetricsRequest, ListCustomMetricsPagedResponse>
      listCustomMetricsPagedCallable() {
    return listCustomMetricsPagedCallable;
  }

  @Override
  public UnaryCallable<ArchiveCustomMetricRequest, Empty> archiveCustomMetricCallable() {
    return archiveCustomMetricCallable;
  }

  @Override
  public UnaryCallable<GetCustomMetricRequest, CustomMetric> getCustomMetricCallable() {
    return getCustomMetricCallable;
  }

  @Override
  public UnaryCallable<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsCallable() {
    return getDataRetentionSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsCallable() {
    return updateDataRetentionSettingsCallable;
  }

  @Override
  public UnaryCallable<CreateDataStreamRequest, DataStream> createDataStreamCallable() {
    return createDataStreamCallable;
  }

  @Override
  public UnaryCallable<DeleteDataStreamRequest, Empty> deleteDataStreamCallable() {
    return deleteDataStreamCallable;
  }

  @Override
  public UnaryCallable<UpdateDataStreamRequest, DataStream> updateDataStreamCallable() {
    return updateDataStreamCallable;
  }

  @Override
  public UnaryCallable<ListDataStreamsRequest, ListDataStreamsResponse> listDataStreamsCallable() {
    return listDataStreamsCallable;
  }

  @Override
  public UnaryCallable<ListDataStreamsRequest, ListDataStreamsPagedResponse>
      listDataStreamsPagedCallable() {
    return listDataStreamsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataStreamRequest, DataStream> getDataStreamCallable() {
    return getDataStreamCallable;
  }

  @Override
  public UnaryCallable<GetAudienceRequest, Audience> getAudienceCallable() {
    return getAudienceCallable;
  }

  @Override
  public UnaryCallable<ListAudiencesRequest, ListAudiencesResponse> listAudiencesCallable() {
    return listAudiencesCallable;
  }

  @Override
  public UnaryCallable<ListAudiencesRequest, ListAudiencesPagedResponse>
      listAudiencesPagedCallable() {
    return listAudiencesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAudienceRequest, Audience> createAudienceCallable() {
    return createAudienceCallable;
  }

  @Override
  public UnaryCallable<UpdateAudienceRequest, Audience> updateAudienceCallable() {
    return updateAudienceCallable;
  }

  @Override
  public UnaryCallable<ArchiveAudienceRequest, Empty> archiveAudienceCallable() {
    return archiveAudienceCallable;
  }

  @Override
  public UnaryCallable<GetSearchAds360LinkRequest, SearchAds360Link> getSearchAds360LinkCallable() {
    return getSearchAds360LinkCallable;
  }

  @Override
  public UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
      listSearchAds360LinksCallable() {
    return listSearchAds360LinksCallable;
  }

  @Override
  public UnaryCallable<ListSearchAds360LinksRequest, ListSearchAds360LinksPagedResponse>
      listSearchAds360LinksPagedCallable() {
    return listSearchAds360LinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkCallable() {
    return createSearchAds360LinkCallable;
  }

  @Override
  public UnaryCallable<DeleteSearchAds360LinkRequest, Empty> deleteSearchAds360LinkCallable() {
    return deleteSearchAds360LinkCallable;
  }

  @Override
  public UnaryCallable<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkCallable() {
    return updateSearchAds360LinkCallable;
  }

  @Override
  public UnaryCallable<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsCallable() {
    return getAttributionSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsCallable() {
    return updateAttributionSettingsCallable;
  }

  @Override
  public UnaryCallable<RunAccessReportRequest, RunAccessReportResponse> runAccessReportCallable() {
    return runAccessReportCallable;
  }

  @Override
  public UnaryCallable<CreateAccessBindingRequest, AccessBinding> createAccessBindingCallable() {
    return createAccessBindingCallable;
  }

  @Override
  public UnaryCallable<GetAccessBindingRequest, AccessBinding> getAccessBindingCallable() {
    return getAccessBindingCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessBindingRequest, AccessBinding> updateAccessBindingCallable() {
    return updateAccessBindingCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessBindingRequest, Empty> deleteAccessBindingCallable() {
    return deleteAccessBindingCallable;
  }

  @Override
  public UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsResponse>
      listAccessBindingsCallable() {
    return listAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<ListAccessBindingsRequest, ListAccessBindingsPagedResponse>
      listAccessBindingsPagedCallable() {
    return listAccessBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsCallable() {
    return batchCreateAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsCallable() {
    return batchGetAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsCallable() {
    return batchUpdateAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsCallable() {
    return batchDeleteAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<GetExpandedDataSetRequest, ExpandedDataSet> getExpandedDataSetCallable() {
    return getExpandedDataSetCallable;
  }

  @Override
  public UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
      listExpandedDataSetsCallable() {
    return listExpandedDataSetsCallable;
  }

  @Override
  public UnaryCallable<ListExpandedDataSetsRequest, ListExpandedDataSetsPagedResponse>
      listExpandedDataSetsPagedCallable() {
    return listExpandedDataSetsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetCallable() {
    return createExpandedDataSetCallable;
  }

  @Override
  public UnaryCallable<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetCallable() {
    return updateExpandedDataSetCallable;
  }

  @Override
  public UnaryCallable<DeleteExpandedDataSetRequest, Empty> deleteExpandedDataSetCallable() {
    return deleteExpandedDataSetCallable;
  }

  @Override
  public UnaryCallable<GetChannelGroupRequest, ChannelGroup> getChannelGroupCallable() {
    return getChannelGroupCallable;
  }

  @Override
  public UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsResponse>
      listChannelGroupsCallable() {
    return listChannelGroupsCallable;
  }

  @Override
  public UnaryCallable<ListChannelGroupsRequest, ListChannelGroupsPagedResponse>
      listChannelGroupsPagedCallable() {
    return listChannelGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateChannelGroupRequest, ChannelGroup> createChannelGroupCallable() {
    return createChannelGroupCallable;
  }

  @Override
  public UnaryCallable<UpdateChannelGroupRequest, ChannelGroup> updateChannelGroupCallable() {
    return updateChannelGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteChannelGroupRequest, Empty> deleteChannelGroupCallable() {
    return deleteChannelGroupCallable;
  }

  @Override
  public UnaryCallable<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutCallable() {
    return setAutomatedGa4ConfigurationOptOutCallable;
  }

  @Override
  public UnaryCallable<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutCallable() {
    return fetchAutomatedGa4ConfigurationOptOutCallable;
  }

  @Override
  public UnaryCallable<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkCallable() {
    return getBigQueryLinkCallable;
  }

  @Override
  public UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksCallable() {
    return listBigQueryLinksCallable;
  }

  @Override
  public UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksPagedResponse>
      listBigQueryLinksPagedCallable() {
    return listBigQueryLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsCallable() {
    return getEnhancedMeasurementSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsCallable() {
    return updateEnhancedMeasurementSettingsCallable;
  }

  @Override
  public UnaryCallable<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagCallable() {
    return createConnectedSiteTagCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectedSiteTagRequest, Empty> deleteConnectedSiteTagCallable() {
    return deleteConnectedSiteTagCallable;
  }

  @Override
  public UnaryCallable<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsCallable() {
    return listConnectedSiteTagsCallable;
  }

  @Override
  public UnaryCallable<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertyCallable() {
    return fetchConnectedGa4PropertyCallable;
  }

  @Override
  public UnaryCallable<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkCallable() {
    return getAdSenseLinkCallable;
  }

  @Override
  public UnaryCallable<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkCallable() {
    return createAdSenseLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkCallable() {
    return deleteAdSenseLinkCallable;
  }

  @Override
  public UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
      listAdSenseLinksCallable() {
    return listAdSenseLinksCallable;
  }

  @Override
  public UnaryCallable<ListAdSenseLinksRequest, ListAdSenseLinksPagedResponse>
      listAdSenseLinksPagedCallable() {
    return listAdSenseLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetEventCreateRuleRequest, EventCreateRule> getEventCreateRuleCallable() {
    return getEventCreateRuleCallable;
  }

  @Override
  public UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
      listEventCreateRulesCallable() {
    return listEventCreateRulesCallable;
  }

  @Override
  public UnaryCallable<ListEventCreateRulesRequest, ListEventCreateRulesPagedResponse>
      listEventCreateRulesPagedCallable() {
    return listEventCreateRulesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleCallable() {
    return createEventCreateRuleCallable;
  }

  @Override
  public UnaryCallable<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleCallable() {
    return updateEventCreateRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteEventCreateRuleRequest, Empty> deleteEventCreateRuleCallable() {
    return deleteEventCreateRuleCallable;
  }

  @Override
  public UnaryCallable<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsCallable() {
    return updateDataRedactionSettingsCallable;
  }

  @Override
  public UnaryCallable<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsCallable() {
    return getDataRedactionSettingsCallable;
  }

  @Override
  public UnaryCallable<GetCalculatedMetricRequest, CalculatedMetric> getCalculatedMetricCallable() {
    return getCalculatedMetricCallable;
  }

  @Override
  public UnaryCallable<CreateCalculatedMetricRequest, CalculatedMetric>
      createCalculatedMetricCallable() {
    return createCalculatedMetricCallable;
  }

  @Override
  public UnaryCallable<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
      listCalculatedMetricsCallable() {
    return listCalculatedMetricsCallable;
  }

  @Override
  public UnaryCallable<ListCalculatedMetricsRequest, ListCalculatedMetricsPagedResponse>
      listCalculatedMetricsPagedCallable() {
    return listCalculatedMetricsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCalculatedMetricRequest, CalculatedMetric>
      updateCalculatedMetricCallable() {
    return updateCalculatedMetricCallable;
  }

  @Override
  public UnaryCallable<DeleteCalculatedMetricRequest, Empty> deleteCalculatedMetricCallable() {
    return deleteCalculatedMetricCallable;
  }

  @Override
  public UnaryCallable<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertyCallable() {
    return createRollupPropertyCallable;
  }

  @Override
  public UnaryCallable<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkCallable() {
    return getRollupPropertySourceLinkCallable;
  }

  @Override
  public UnaryCallable<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
      listRollupPropertySourceLinksCallable() {
    return listRollupPropertySourceLinksCallable;
  }

  @Override
  public UnaryCallable<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksPagedResponse>
      listRollupPropertySourceLinksPagedCallable() {
    return listRollupPropertySourceLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkCallable() {
    return createRollupPropertySourceLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkCallable() {
    return deleteRollupPropertySourceLinkCallable;
  }

  @Override
  public UnaryCallable<CreateSubpropertyRequest, CreateSubpropertyResponse>
      createSubpropertyCallable() {
    return createSubpropertyCallable;
  }

  @Override
  public UnaryCallable<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterCallable() {
    return createSubpropertyEventFilterCallable;
  }

  @Override
  public UnaryCallable<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterCallable() {
    return getSubpropertyEventFilterCallable;
  }

  @Override
  public UnaryCallable<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
      listSubpropertyEventFiltersCallable() {
    return listSubpropertyEventFiltersCallable;
  }

  @Override
  public UnaryCallable<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersPagedResponse>
      listSubpropertyEventFiltersPagedCallable() {
    return listSubpropertyEventFiltersPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterCallable() {
    return updateSubpropertyEventFilterCallable;
  }

  @Override
  public UnaryCallable<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterCallable() {
    return deleteSubpropertyEventFilterCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
