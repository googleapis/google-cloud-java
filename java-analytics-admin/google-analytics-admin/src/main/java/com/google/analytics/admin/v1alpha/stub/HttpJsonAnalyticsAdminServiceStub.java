/*
 * Copyright 2025 Google LLC
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
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListEventEditRulesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListExpandedDataSetsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListFirebaseLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListKeyEventsPagedResponse;
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
import com.google.analytics.admin.v1alpha.CreateBigQueryLinkRequest;
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
import com.google.analytics.admin.v1alpha.CreateEventEditRuleRequest;
import com.google.analytics.admin.v1alpha.CreateExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.CreateKeyEventRequest;
import com.google.analytics.admin.v1alpha.CreateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.CreatePropertyRequest;
import com.google.analytics.admin.v1alpha.CreateRollupPropertyRequest;
import com.google.analytics.admin.v1alpha.CreateRollupPropertyResponse;
import com.google.analytics.admin.v1alpha.CreateRollupPropertySourceLinkRequest;
import com.google.analytics.admin.v1alpha.CreateSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.CreateSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.CreateSubpropertyEventFilterRequest;
import com.google.analytics.admin.v1alpha.CustomDimension;
import com.google.analytics.admin.v1alpha.CustomMetric;
import com.google.analytics.admin.v1alpha.DataRedactionSettings;
import com.google.analytics.admin.v1alpha.DataRetentionSettings;
import com.google.analytics.admin.v1alpha.DataSharingSettings;
import com.google.analytics.admin.v1alpha.DataStream;
import com.google.analytics.admin.v1alpha.DeleteAccessBindingRequest;
import com.google.analytics.admin.v1alpha.DeleteAccountRequest;
import com.google.analytics.admin.v1alpha.DeleteAdSenseLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteBigQueryLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteCalculatedMetricRequest;
import com.google.analytics.admin.v1alpha.DeleteChannelGroupRequest;
import com.google.analytics.admin.v1alpha.DeleteConnectedSiteTagRequest;
import com.google.analytics.admin.v1alpha.DeleteConversionEventRequest;
import com.google.analytics.admin.v1alpha.DeleteDataStreamRequest;
import com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkProposalRequest;
import com.google.analytics.admin.v1alpha.DeleteDisplayVideo360AdvertiserLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteEventCreateRuleRequest;
import com.google.analytics.admin.v1alpha.DeleteEventEditRuleRequest;
import com.google.analytics.admin.v1alpha.DeleteExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteKeyEventRequest;
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
import com.google.analytics.admin.v1alpha.EventEditRule;
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
import com.google.analytics.admin.v1alpha.GetEventEditRuleRequest;
import com.google.analytics.admin.v1alpha.GetExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest;
import com.google.analytics.admin.v1alpha.GetGoogleSignalsSettingsRequest;
import com.google.analytics.admin.v1alpha.GetKeyEventRequest;
import com.google.analytics.admin.v1alpha.GetMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.GetPropertyRequest;
import com.google.analytics.admin.v1alpha.GetRollupPropertySourceLinkRequest;
import com.google.analytics.admin.v1alpha.GetSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.GetSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.GetSubpropertyEventFilterRequest;
import com.google.analytics.admin.v1alpha.GlobalSiteTag;
import com.google.analytics.admin.v1alpha.GoogleAdsLink;
import com.google.analytics.admin.v1alpha.GoogleSignalsSettings;
import com.google.analytics.admin.v1alpha.KeyEvent;
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
import com.google.analytics.admin.v1alpha.ListEventEditRulesRequest;
import com.google.analytics.admin.v1alpha.ListEventEditRulesResponse;
import com.google.analytics.admin.v1alpha.ListExpandedDataSetsRequest;
import com.google.analytics.admin.v1alpha.ListExpandedDataSetsResponse;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse;
import com.google.analytics.admin.v1alpha.ListKeyEventsRequest;
import com.google.analytics.admin.v1alpha.ListKeyEventsResponse;
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
import com.google.analytics.admin.v1alpha.ProvisionSubpropertyRequest;
import com.google.analytics.admin.v1alpha.ProvisionSubpropertyResponse;
import com.google.analytics.admin.v1alpha.ReorderEventEditRulesRequest;
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
import com.google.analytics.admin.v1alpha.UpdateBigQueryLinkRequest;
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
import com.google.analytics.admin.v1alpha.UpdateEventEditRuleRequest;
import com.google.analytics.admin.v1alpha.UpdateExpandedDataSetRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleSignalsSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateKeyEventRequest;
import com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest;
import com.google.analytics.admin.v1alpha.UpdatePropertyRequest;
import com.google.analytics.admin.v1alpha.UpdateSKAdNetworkConversionValueSchemaRequest;
import com.google.analytics.admin.v1alpha.UpdateSearchAds360LinkRequest;
import com.google.analytics.admin.v1alpha.UpdateSubpropertyEventFilterRequest;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AnalyticsAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAnalyticsAdminServiceStub extends AnalyticsAdminServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAccountRequest, Account> getAccountMethodDescriptor =
      ApiMethodDescriptor.<GetAccountRequest, Account>newBuilder()
          .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetAccount")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAccountRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=accounts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAccountRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAccountRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Account>newBuilder()
                  .setDefaultInstance(Account.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAccountsRequest, ListAccountsResponse>
      listAccountsMethodDescriptor =
          ApiMethodDescriptor.<ListAccountsRequest, ListAccountsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/accounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccountsResponse>newBuilder()
                      .setDefaultInstance(ListAccountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAccountRequest, Empty>
      deleteAccountMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccountRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteAccount")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccountRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=accounts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAccountRequest, Account>
      updateAccountMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccountRequest, Account>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAccount")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{account.name=accounts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "account.name", request.getAccount().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("account", request.getAccount(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Account>newBuilder()
                      .setDefaultInstance(Account.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
      provisionAccountTicketMethodDescriptor =
          ApiMethodDescriptor
              .<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ProvisionAccountTicket")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProvisionAccountTicketRequest>newBuilder()
                      .setPath(
                          "/v1alpha/accounts:provisionAccountTicket",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionAccountTicketRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionAccountTicketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProvisionAccountTicketResponse>newBuilder()
                      .setDefaultInstance(ProvisionAccountTicketResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAccountSummariesRequest, ListAccountSummariesResponse>
      listAccountSummariesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAccountSummariesRequest, ListAccountSummariesResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAccountSummaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountSummariesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/accountSummaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccountSummariesResponse>newBuilder()
                      .setDefaultInstance(ListAccountSummariesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPropertyRequest, Property>
      getPropertyMethodDescriptor =
          ApiMethodDescriptor.<GetPropertyRequest, Property>newBuilder()
              .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetProperty")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Property>newBuilder()
                      .setDefaultInstance(Property.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPropertiesRequest, ListPropertiesResponse>
      listPropertiesMethodDescriptor =
          ApiMethodDescriptor.<ListPropertiesRequest, ListPropertiesResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListProperties")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPropertiesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPropertiesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPropertiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPropertiesResponse>newBuilder()
                      .setDefaultInstance(ListPropertiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePropertyRequest, Property>
      createPropertyMethodDescriptor =
          ApiMethodDescriptor.<CreatePropertyRequest, Property>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateProperty")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("property", request.getProperty(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Property>newBuilder()
                      .setDefaultInstance(Property.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePropertyRequest, Property>
      deletePropertyMethodDescriptor =
          ApiMethodDescriptor.<DeletePropertyRequest, Property>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteProperty")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Property>newBuilder()
                      .setDefaultInstance(Property.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePropertyRequest, Property>
      updatePropertyMethodDescriptor =
          ApiMethodDescriptor.<UpdatePropertyRequest, Property>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateProperty")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{property.name=properties/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "property.name", request.getProperty().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("property", request.getProperty(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Property>newBuilder()
                      .setDefaultInstance(Property.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFirebaseLinkRequest, FirebaseLink>
      createFirebaseLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateFirebaseLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFirebaseLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/firebaseLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFirebaseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFirebaseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("firebaseLink", request.getFirebaseLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirebaseLink>newBuilder()
                      .setDefaultInstance(FirebaseLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteFirebaseLinkRequest, Empty>
      deleteFirebaseLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteFirebaseLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteFirebaseLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFirebaseLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/firebaseLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFirebaseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFirebaseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksMethodDescriptor =
          ApiMethodDescriptor.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListFirebaseLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFirebaseLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/firebaseLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFirebaseLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFirebaseLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFirebaseLinksResponse>newBuilder()
                      .setDefaultInstance(ListFirebaseLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGlobalSiteTagRequest, GlobalSiteTag>
      getGlobalSiteTagMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalSiteTagRequest, GlobalSiteTag>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetGlobalSiteTag")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalSiteTagRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/globalSiteTag}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalSiteTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalSiteTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlobalSiteTag>newBuilder()
                      .setDefaultInstance(GlobalSiteTag.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateGoogleAdsLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGoogleAdsLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/googleAdsLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGoogleAdsLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGoogleAdsLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("googleAdsLink", request.getGoogleAdsLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleAdsLink>newBuilder()
                      .setDefaultInstance(GoogleAdsLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkMethodDescriptor =
          ApiMethodDescriptor.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateGoogleAdsLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGoogleAdsLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{googleAdsLink.name=properties/*/googleAdsLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleAdsLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "googleAdsLink.name", request.getGoogleAdsLink().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleAdsLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("googleAdsLink", request.getGoogleAdsLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleAdsLink>newBuilder()
                      .setDefaultInstance(GoogleAdsLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGoogleAdsLinkRequest, Empty>
      deleteGoogleAdsLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteGoogleAdsLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGoogleAdsLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/googleAdsLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGoogleAdsLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGoogleAdsLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksMethodDescriptor =
          ApiMethodDescriptor.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListGoogleAdsLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGoogleAdsLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/googleAdsLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGoogleAdsLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGoogleAdsLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGoogleAdsLinksResponse>newBuilder()
                      .setDefaultInstance(ListGoogleAdsLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataSharingSettingsRequest, DataSharingSettings>
      getDataSharingSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetDataSharingSettingsRequest, DataSharingSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataSharingSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataSharingSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=accounts/*/dataSharingSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSharingSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataSharingSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataSharingSettings>newBuilder()
                      .setDefaultInstance(DataSharingSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      getMeasurementProtocolSecretMethodDescriptor =
          ApiMethodDescriptor
              .<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetMeasurementProtocolSecret")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/measurementProtocolSecrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MeasurementProtocolSecret>newBuilder()
                      .setDefaultInstance(MeasurementProtocolSecret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
      listMeasurementProtocolSecretsMethodDescriptor =
          ApiMethodDescriptor
              .<ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListMeasurementProtocolSecrets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMeasurementProtocolSecretsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/measurementProtocolSecrets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMeasurementProtocolSecretsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMeasurementProtocolSecretsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMeasurementProtocolSecretsResponse>newBuilder()
                      .setDefaultInstance(
                          ListMeasurementProtocolSecretsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      createMeasurementProtocolSecretMethodDescriptor =
          ApiMethodDescriptor
              .<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateMeasurementProtocolSecret")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/measurementProtocolSecrets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "measurementProtocolSecret",
                                      request.getMeasurementProtocolSecret(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MeasurementProtocolSecret>newBuilder()
                      .setDefaultInstance(MeasurementProtocolSecret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMeasurementProtocolSecretRequest, Empty>
      deleteMeasurementProtocolSecretMethodDescriptor =
          ApiMethodDescriptor.<DeleteMeasurementProtocolSecretRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteMeasurementProtocolSecret")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/measurementProtocolSecrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
      updateMeasurementProtocolSecretMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateMeasurementProtocolSecret")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{measurementProtocolSecret.name=properties/*/dataStreams/*/measurementProtocolSecrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "measurementProtocolSecret.name",
                                request.getMeasurementProtocolSecret().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMeasurementProtocolSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "measurementProtocolSecret",
                                      request.getMeasurementProtocolSecret(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MeasurementProtocolSecret>newBuilder()
                      .setDefaultInstance(MeasurementProtocolSecret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
      acknowledgeUserDataCollectionMethodDescriptor =
          ApiMethodDescriptor
              .<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/AcknowledgeUserDataCollection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AcknowledgeUserDataCollectionRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{property=properties/*}:acknowledgeUserDataCollection",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AcknowledgeUserDataCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AcknowledgeUserDataCollectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AcknowledgeUserDataCollectionResponse>newBuilder()
                      .setDefaultInstance(
                          AcknowledgeUserDataCollectionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      getSKAdNetworkConversionValueSchemaMethodDescriptor =
          ApiMethodDescriptor
              .<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetSKAdNetworkConversionValueSchema")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetSKAdNetworkConversionValueSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/sKAdNetworkConversionValueSchema/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SKAdNetworkConversionValueSchema>newBuilder()
                      .setDefaultInstance(SKAdNetworkConversionValueSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      createSKAdNetworkConversionValueSchemaMethodDescriptor =
          ApiMethodDescriptor
              .<CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSKAdNetworkConversionValueSchema")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateSKAdNetworkConversionValueSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/sKAdNetworkConversionValueSchema",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "skadnetworkConversionValueSchema",
                                      request.getSkadnetworkConversionValueSchema(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SKAdNetworkConversionValueSchema>newBuilder()
                      .setDefaultInstance(SKAdNetworkConversionValueSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
      deleteSKAdNetworkConversionValueSchemaMethodDescriptor =
          ApiMethodDescriptor.<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteSKAdNetworkConversionValueSchema")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteSKAdNetworkConversionValueSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/sKAdNetworkConversionValueSchema/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
      updateSKAdNetworkConversionValueSchemaMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateSKAdNetworkConversionValueSchema")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateSKAdNetworkConversionValueSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{skadnetworkConversionValueSchema.name=properties/*/dataStreams/*/sKAdNetworkConversionValueSchema/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "skadnetworkConversionValueSchema.name",
                                request.getSkadnetworkConversionValueSchema().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSKAdNetworkConversionValueSchemaRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "skadnetworkConversionValueSchema",
                                      request.getSkadnetworkConversionValueSchema(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SKAdNetworkConversionValueSchema>newBuilder()
                      .setDefaultInstance(SKAdNetworkConversionValueSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSKAdNetworkConversionValueSchemasRequest,
          ListSKAdNetworkConversionValueSchemasResponse>
      listSKAdNetworkConversionValueSchemasMethodDescriptor =
          ApiMethodDescriptor
              .<ListSKAdNetworkConversionValueSchemasRequest,
                  ListSKAdNetworkConversionValueSchemasResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListSKAdNetworkConversionValueSchemas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListSKAdNetworkConversionValueSchemasRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/sKAdNetworkConversionValueSchema",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSKAdNetworkConversionValueSchemasRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSKAdNetworkConversionValueSchemasRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListSKAdNetworkConversionValueSchemasResponse>newBuilder()
                      .setDefaultInstance(
                          ListSKAdNetworkConversionValueSchemasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/SearchChangeHistoryEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchChangeHistoryEventsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{account=accounts/*}:searchChangeHistoryEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchChangeHistoryEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "account", request.getAccount());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchChangeHistoryEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearAccount().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchChangeHistoryEventsResponse>newBuilder()
                      .setDefaultInstance(SearchChangeHistoryEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      getGoogleSignalsSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetGoogleSignalsSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGoogleSignalsSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/googleSignalsSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGoogleSignalsSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGoogleSignalsSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleSignalsSettings>newBuilder()
                      .setDefaultInstance(GoogleSignalsSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
      updateGoogleSignalsSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateGoogleSignalsSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGoogleSignalsSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{googleSignalsSettings.name=properties/*/googleSignalsSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleSignalsSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "googleSignalsSettings.name",
                                request.getGoogleSignalsSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGoogleSignalsSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "googleSignalsSettings",
                                      request.getGoogleSignalsSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GoogleSignalsSettings>newBuilder()
                      .setDefaultInstance(GoogleSignalsSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConversionEventRequest, ConversionEvent>
      createConversionEventMethodDescriptor =
          ApiMethodDescriptor.<CreateConversionEventRequest, ConversionEvent>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateConversionEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/conversionEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversionEvent", request.getConversionEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionEvent>newBuilder()
                      .setDefaultInstance(ConversionEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateConversionEventRequest, ConversionEvent>
      updateConversionEventMethodDescriptor =
          ApiMethodDescriptor.<UpdateConversionEventRequest, ConversionEvent>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateConversionEvent")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{conversionEvent.name=properties/*/conversionEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "conversionEvent.name",
                                request.getConversionEvent().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversionEvent", request.getConversionEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionEvent>newBuilder()
                      .setDefaultInstance(ConversionEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConversionEventRequest, ConversionEvent>
      getConversionEventMethodDescriptor =
          ApiMethodDescriptor.<GetConversionEventRequest, ConversionEvent>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetConversionEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/conversionEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversionEvent>newBuilder()
                      .setDefaultInstance(ConversionEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversionEventRequest, Empty>
      deleteConversionEventMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversionEventRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteConversionEvent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/conversionEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversionEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListConversionEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversionEventsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/conversionEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversionEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversionEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversionEventsResponse>newBuilder()
                      .setDefaultInstance(ListConversionEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateKeyEventRequest, KeyEvent>
      createKeyEventMethodDescriptor =
          ApiMethodDescriptor.<CreateKeyEventRequest, KeyEvent>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateKeyEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateKeyEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/keyEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("keyEvent", request.getKeyEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KeyEvent>newBuilder()
                      .setDefaultInstance(KeyEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateKeyEventRequest, KeyEvent>
      updateKeyEventMethodDescriptor =
          ApiMethodDescriptor.<UpdateKeyEventRequest, KeyEvent>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateKeyEvent")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateKeyEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{keyEvent.name=properties/*/keyEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "keyEvent.name", request.getKeyEvent().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("keyEvent", request.getKeyEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KeyEvent>newBuilder()
                      .setDefaultInstance(KeyEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetKeyEventRequest, KeyEvent>
      getKeyEventMethodDescriptor =
          ApiMethodDescriptor.<GetKeyEventRequest, KeyEvent>newBuilder()
              .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetKeyEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetKeyEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/keyEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KeyEvent>newBuilder()
                      .setDefaultInstance(KeyEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteKeyEventRequest, Empty>
      deleteKeyEventMethodDescriptor =
          ApiMethodDescriptor.<DeleteKeyEventRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteKeyEvent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteKeyEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/keyEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteKeyEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListKeyEventsRequest, ListKeyEventsResponse>
      listKeyEventsMethodDescriptor =
          ApiMethodDescriptor.<ListKeyEventsRequest, ListKeyEventsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListKeyEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListKeyEventsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/keyEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListKeyEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListKeyEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListKeyEventsResponse>newBuilder()
                      .setDefaultInstance(ListKeyEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      getDisplayVideo360AdvertiserLinkMethodDescriptor =
          ApiMethodDescriptor
              .<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDisplayVideo360AdvertiserLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDisplayVideo360AdvertiserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/displayVideo360AdvertiserLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DisplayVideo360AdvertiserLink>newBuilder()
                      .setDefaultInstance(DisplayVideo360AdvertiserLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
      listDisplayVideo360AdvertiserLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListDisplayVideo360AdvertiserLinksRequest,
                  ListDisplayVideo360AdvertiserLinksResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListDisplayVideo360AdvertiserLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListDisplayVideo360AdvertiserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/displayVideo360AdvertiserLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDisplayVideo360AdvertiserLinksRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDisplayVideo360AdvertiserLinksRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListDisplayVideo360AdvertiserLinksResponse>newBuilder()
                      .setDefaultInstance(
                          ListDisplayVideo360AdvertiserLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      createDisplayVideo360AdvertiserLinkMethodDescriptor =
          ApiMethodDescriptor
              .<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateDisplayVideo360AdvertiserLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateDisplayVideo360AdvertiserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/displayVideo360AdvertiserLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "displayVideo360AdvertiserLink",
                                      request.getDisplayVideo360AdvertiserLink(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DisplayVideo360AdvertiserLink>newBuilder()
                      .setDefaultInstance(DisplayVideo360AdvertiserLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteDisplayVideo360AdvertiserLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteDisplayVideo360AdvertiserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/displayVideo360AdvertiserLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
      updateDisplayVideo360AdvertiserLinkMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDisplayVideo360AdvertiserLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateDisplayVideo360AdvertiserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{displayVideo360AdvertiserLink.name=properties/*/displayVideo360AdvertiserLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "displayVideo360AdvertiserLink.name",
                                request.getDisplayVideo360AdvertiserLink().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDisplayVideo360AdvertiserLinkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "displayVideo360AdvertiserLink",
                                      request.getDisplayVideo360AdvertiserLink(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DisplayVideo360AdvertiserLink>newBuilder()
                      .setDefaultInstance(DisplayVideo360AdvertiserLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      getDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          ApiMethodDescriptor
              .<GetDisplayVideo360AdvertiserLinkProposalRequest,
                  DisplayVideo360AdvertiserLinkProposal>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDisplayVideo360AdvertiserLinkProposal")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetDisplayVideo360AdvertiserLinkProposalRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/displayVideo360AdvertiserLinkProposals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DisplayVideo360AdvertiserLinkProposal>newBuilder()
                      .setDefaultInstance(
                          DisplayVideo360AdvertiserLinkProposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDisplayVideo360AdvertiserLinkProposalsRequest,
          ListDisplayVideo360AdvertiserLinkProposalsResponse>
      listDisplayVideo360AdvertiserLinkProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDisplayVideo360AdvertiserLinkProposalsRequest,
                  ListDisplayVideo360AdvertiserLinkProposalsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListDisplayVideo360AdvertiserLinkProposals")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListDisplayVideo360AdvertiserLinkProposalsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/displayVideo360AdvertiserLinkProposals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDisplayVideo360AdvertiserLinkProposalsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDisplayVideo360AdvertiserLinkProposalsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListDisplayVideo360AdvertiserLinkProposalsResponse>newBuilder()
                      .setDefaultInstance(
                          ListDisplayVideo360AdvertiserLinkProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      createDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          ApiMethodDescriptor
              .<CreateDisplayVideo360AdvertiserLinkProposalRequest,
                  DisplayVideo360AdvertiserLinkProposal>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateDisplayVideo360AdvertiserLinkProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateDisplayVideo360AdvertiserLinkProposalRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/displayVideo360AdvertiserLinkProposals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "displayVideo360AdvertiserLinkProposal",
                                      request.getDisplayVideo360AdvertiserLinkProposal(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DisplayVideo360AdvertiserLinkProposal>newBuilder()
                      .setDefaultInstance(
                          DisplayVideo360AdvertiserLinkProposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
      deleteDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteDisplayVideo360AdvertiserLinkProposal")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteDisplayVideo360AdvertiserLinkProposalRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/displayVideo360AdvertiserLinkProposals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ApproveDisplayVideo360AdvertiserLinkProposalRequest,
          ApproveDisplayVideo360AdvertiserLinkProposalResponse>
      approveDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          ApiMethodDescriptor
              .<ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                  ApproveDisplayVideo360AdvertiserLinkProposalResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ApproveDisplayVideo360AdvertiserLinkProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ApproveDisplayVideo360AdvertiserLinkProposalRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/displayVideo360AdvertiserLinkProposals/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ApproveDisplayVideo360AdvertiserLinkProposalResponse>newBuilder()
                      .setDefaultInstance(
                          ApproveDisplayVideo360AdvertiserLinkProposalResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CancelDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
      cancelDisplayVideo360AdvertiserLinkProposalMethodDescriptor =
          ApiMethodDescriptor
              .<CancelDisplayVideo360AdvertiserLinkProposalRequest,
                  DisplayVideo360AdvertiserLinkProposal>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CancelDisplayVideo360AdvertiserLinkProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CancelDisplayVideo360AdvertiserLinkProposalRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/displayVideo360AdvertiserLinkProposals/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDisplayVideo360AdvertiserLinkProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DisplayVideo360AdvertiserLinkProposal>newBuilder()
                      .setDefaultInstance(
                          DisplayVideo360AdvertiserLinkProposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateCustomDimension")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/customDimensions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customDimension", request.getCustomDimension(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomDimension>newBuilder()
                      .setDefaultInstance(CustomDimension.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateCustomDimension")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{customDimension.name=properties/*/customDimensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "customDimension.name",
                                request.getCustomDimension().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customDimension", request.getCustomDimension(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomDimension>newBuilder()
                      .setDefaultInstance(CustomDimension.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListCustomDimensions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomDimensionsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/customDimensions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomDimensionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomDimensionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomDimensionsResponse>newBuilder()
                      .setDefaultInstance(ListCustomDimensionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ArchiveCustomDimensionRequest, Empty>
      archiveCustomDimensionMethodDescriptor =
          ApiMethodDescriptor.<ArchiveCustomDimensionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ArchiveCustomDimension")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ArchiveCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/customDimensions/*}:archive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ArchiveCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ArchiveCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionMethodDescriptor =
          ApiMethodDescriptor.<GetCustomDimensionRequest, CustomDimension>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetCustomDimension")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/customDimensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomDimensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomDimension>newBuilder()
                      .setDefaultInstance(CustomDimension.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomMetricRequest, CustomMetric>
      createCustomMetricMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomMetricRequest, CustomMetric>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateCustomMetric")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/customMetrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customMetric", request.getCustomMetric(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomMetric>newBuilder()
                      .setDefaultInstance(CustomMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomMetricRequest, CustomMetric>
      updateCustomMetricMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateCustomMetric")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{customMetric.name=properties/*/customMetrics/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "customMetric.name", request.getCustomMetric().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customMetric", request.getCustomMetric(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomMetric>newBuilder()
                      .setDefaultInstance(CustomMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsMethodDescriptor =
          ApiMethodDescriptor.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListCustomMetrics")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomMetricsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/customMetrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomMetricsResponse>newBuilder()
                      .setDefaultInstance(ListCustomMetricsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ArchiveCustomMetricRequest, Empty>
      archiveCustomMetricMethodDescriptor =
          ApiMethodDescriptor.<ArchiveCustomMetricRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ArchiveCustomMetric")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ArchiveCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/customMetrics/*}:archive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ArchiveCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ArchiveCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomMetricRequest, CustomMetric>
      getCustomMetricMethodDescriptor =
          ApiMethodDescriptor.<GetCustomMetricRequest, CustomMetric>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetCustomMetric")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/customMetrics/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomMetric>newBuilder()
                      .setDefaultInstance(CustomMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataRetentionSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataRetentionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataRetentionSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataRetentionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataRetentionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataRetentionSettings>newBuilder()
                      .setDefaultInstance(DataRetentionSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateDataRetentionSettingsRequest, DataRetentionSettings>
      updateDataRetentionSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDataRetentionSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataRetentionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{dataRetentionSettings.name=properties/*/dataRetentionSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataRetentionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "dataRetentionSettings.name",
                                request.getDataRetentionSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataRetentionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "dataRetentionSettings",
                                      request.getDataRetentionSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataRetentionSettings>newBuilder()
                      .setDefaultInstance(DataRetentionSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDataStreamRequest, DataStream>
      createDataStreamMethodDescriptor =
          ApiMethodDescriptor.<CreateDataStreamRequest, DataStream>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateDataStream")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/dataStreams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataStream", request.getDataStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataStream>newBuilder()
                      .setDefaultInstance(DataStream.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataStreamRequest, Empty>
      deleteDataStreamMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataStreamRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteDataStream")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataStreamRequest, DataStream>
      updateDataStreamMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataStreamRequest, DataStream>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDataStream")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{dataStream.name=properties/*/dataStreams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataStream.name", request.getDataStream().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataStream", request.getDataStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataStream>newBuilder()
                      .setDefaultInstance(DataStream.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataStreamsRequest, ListDataStreamsResponse>
      listDataStreamsMethodDescriptor =
          ApiMethodDescriptor.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListDataStreams")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataStreamsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/dataStreams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataStreamsResponse>newBuilder()
                      .setDefaultInstance(ListDataStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataStreamRequest, DataStream>
      getDataStreamMethodDescriptor =
          ApiMethodDescriptor.<GetDataStreamRequest, DataStream>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataStream")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataStream>newBuilder()
                      .setDefaultInstance(DataStream.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAudienceRequest, Audience>
      getAudienceMethodDescriptor =
          ApiMethodDescriptor.<GetAudienceRequest, Audience>newBuilder()
              .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetAudience")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAudienceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/audiences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Audience>newBuilder()
                      .setDefaultInstance(Audience.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAudiencesRequest, ListAudiencesResponse>
      listAudiencesMethodDescriptor =
          ApiMethodDescriptor.<ListAudiencesRequest, ListAudiencesResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAudiences")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAudiencesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/audiences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudiencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudiencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAudiencesResponse>newBuilder()
                      .setDefaultInstance(ListAudiencesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAudienceRequest, Audience>
      createAudienceMethodDescriptor =
          ApiMethodDescriptor.<CreateAudienceRequest, Audience>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateAudience")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAudienceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/audiences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("audience", request.getAudience(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Audience>newBuilder()
                      .setDefaultInstance(Audience.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAudienceRequest, Audience>
      updateAudienceMethodDescriptor =
          ApiMethodDescriptor.<UpdateAudienceRequest, Audience>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAudience")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAudienceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{audience.name=properties/*/audiences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "audience.name", request.getAudience().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("audience", request.getAudience(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Audience>newBuilder()
                      .setDefaultInstance(Audience.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ArchiveAudienceRequest, Empty>
      archiveAudienceMethodDescriptor =
          ApiMethodDescriptor.<ArchiveAudienceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ArchiveAudience")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ArchiveAudienceRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/audiences/*}:archive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ArchiveAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ArchiveAudienceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSearchAds360LinkRequest, SearchAds360Link>
      getSearchAds360LinkMethodDescriptor =
          ApiMethodDescriptor.<GetSearchAds360LinkRequest, SearchAds360Link>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetSearchAds360Link")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSearchAds360LinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/searchAds360Links/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAds360Link>newBuilder()
                      .setDefaultInstance(SearchAds360Link.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
      listSearchAds360LinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListSearchAds360Links")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSearchAds360LinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/searchAds360Links",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSearchAds360LinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSearchAds360LinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSearchAds360LinksResponse>newBuilder()
                      .setDefaultInstance(ListSearchAds360LinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSearchAds360LinkRequest, SearchAds360Link>
      createSearchAds360LinkMethodDescriptor =
          ApiMethodDescriptor.<CreateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSearchAds360Link")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSearchAds360LinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/searchAds360Links",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("searchAds360Link", request.getSearchAds360Link(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAds360Link>newBuilder()
                      .setDefaultInstance(SearchAds360Link.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSearchAds360LinkRequest, Empty>
      deleteSearchAds360LinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteSearchAds360LinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteSearchAds360Link")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSearchAds360LinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/searchAds360Links/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSearchAds360LinkRequest, SearchAds360Link>
      updateSearchAds360LinkMethodDescriptor =
          ApiMethodDescriptor.<UpdateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateSearchAds360Link")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSearchAds360LinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{searchAds360Link.name=properties/*/searchAds360Links/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "searchAds360Link.name",
                                request.getSearchAds360Link().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSearchAds360LinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("searchAds360Link", request.getSearchAds360Link(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAds360Link>newBuilder()
                      .setDefaultInstance(SearchAds360Link.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetAttributionSettingsRequest, AttributionSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetAttributionSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttributionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/attributionSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttributionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttributionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributionSettings>newBuilder()
                      .setDefaultInstance(AttributionSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateAttributionSettingsRequest, AttributionSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAttributionSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAttributionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{attributionSettings.name=properties/*/attributionSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttributionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "attributionSettings.name",
                                request.getAttributionSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttributionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "attributionSettings",
                                      request.getAttributionSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttributionSettings>newBuilder()
                      .setDefaultInstance(AttributionSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportMethodDescriptor =
          ApiMethodDescriptor.<RunAccessReportRequest, RunAccessReportResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/RunAccessReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunAccessReportRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{entity=properties/*}:runAccessReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunAccessReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "entity", request.getEntity());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{entity=accounts/*}:runAccessReport")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunAccessReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEntity().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunAccessReportResponse>newBuilder()
                      .setDefaultInstance(RunAccessReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAccessBindingRequest, AccessBinding>
      createAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateAccessBindingRequest, AccessBinding>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateAccessBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/accessBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/accessBindings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accessBinding", request.getAccessBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessBinding>newBuilder()
                      .setDefaultInstance(AccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAccessBindingRequest, AccessBinding>
      getAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<GetAccessBindingRequest, AccessBinding>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetAccessBinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=accounts/*/accessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{name=properties/*/accessBindings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessBinding>newBuilder()
                      .setDefaultInstance(AccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAccessBindingRequest, AccessBinding>
      updateAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccessBindingRequest, AccessBinding>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateAccessBinding")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{accessBinding.name=accounts/*/accessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "accessBinding.name", request.getAccessBinding().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{accessBinding.name=properties/*/accessBindings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("accessBinding", request.getAccessBinding(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessBinding>newBuilder()
                      .setDefaultInstance(AccessBinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAccessBindingRequest, Empty>
      deleteAccessBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessBindingRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteAccessBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessBindingRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=accounts/*/accessBindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{name=properties/*/accessBindings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAccessBindingsRequest, ListAccessBindingsResponse>
      listAccessBindingsMethodDescriptor =
          ApiMethodDescriptor.<ListAccessBindingsRequest, ListAccessBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAccessBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/accessBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/accessBindings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccessBindingsResponse>newBuilder()
                      .setDefaultInstance(ListAccessBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
      batchCreateAccessBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchCreateAccessBindings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/accessBindings:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=properties/*}/accessBindings:batchCreate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateAccessBindingsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateAccessBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
      batchGetAccessBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchGetAccessBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/accessBindings:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/accessBindings:batchGet")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetAccessBindingsResponse>newBuilder()
                      .setDefaultInstance(BatchGetAccessBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
      batchUpdateAccessBindingsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchUpdateAccessBindings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/accessBindings:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=properties/*}/accessBindings:batchUpdate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateAccessBindingsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateAccessBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteAccessBindingsRequest, Empty>
      batchDeleteAccessBindingsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteAccessBindingsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchDeleteAccessBindings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteAccessBindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/accessBindings:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=properties/*}/accessBindings:batchDelete")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteAccessBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExpandedDataSetRequest, ExpandedDataSet>
      getExpandedDataSetMethodDescriptor =
          ApiMethodDescriptor.<GetExpandedDataSetRequest, ExpandedDataSet>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetExpandedDataSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExpandedDataSetRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/expandedDataSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExpandedDataSet>newBuilder()
                      .setDefaultInstance(ExpandedDataSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
      listExpandedDataSetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListExpandedDataSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExpandedDataSetsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/expandedDataSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExpandedDataSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExpandedDataSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListExpandedDataSetsResponse>newBuilder()
                      .setDefaultInstance(ListExpandedDataSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExpandedDataSetRequest, ExpandedDataSet>
      createExpandedDataSetMethodDescriptor =
          ApiMethodDescriptor.<CreateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateExpandedDataSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExpandedDataSetRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/expandedDataSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("expandedDataSet", request.getExpandedDataSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExpandedDataSet>newBuilder()
                      .setDefaultInstance(ExpandedDataSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateExpandedDataSetRequest, ExpandedDataSet>
      updateExpandedDataSetMethodDescriptor =
          ApiMethodDescriptor.<UpdateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateExpandedDataSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExpandedDataSetRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{expandedDataSet.name=properties/*/expandedDataSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "expandedDataSet.name",
                                request.getExpandedDataSet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("expandedDataSet", request.getExpandedDataSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExpandedDataSet>newBuilder()
                      .setDefaultInstance(ExpandedDataSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteExpandedDataSetRequest, Empty>
      deleteExpandedDataSetMethodDescriptor =
          ApiMethodDescriptor.<DeleteExpandedDataSetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteExpandedDataSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExpandedDataSetRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/expandedDataSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExpandedDataSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetChannelGroupRequest, ChannelGroup>
      getChannelGroupMethodDescriptor =
          ApiMethodDescriptor.<GetChannelGroupRequest, ChannelGroup>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetChannelGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChannelGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/channelGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelGroup>newBuilder()
                      .setDefaultInstance(ChannelGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListChannelGroupsRequest, ListChannelGroupsResponse>
      listChannelGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListChannelGroupsRequest, ListChannelGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListChannelGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChannelGroupsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/channelGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListChannelGroupsResponse>newBuilder()
                      .setDefaultInstance(ListChannelGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateChannelGroupRequest, ChannelGroup>
      createChannelGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateChannelGroupRequest, ChannelGroup>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateChannelGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateChannelGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/channelGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("channelGroup", request.getChannelGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelGroup>newBuilder()
                      .setDefaultInstance(ChannelGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateChannelGroupRequest, ChannelGroup>
      updateChannelGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateChannelGroupRequest, ChannelGroup>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateChannelGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateChannelGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{channelGroup.name=properties/*/channelGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "channelGroup.name", request.getChannelGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("channelGroup", request.getChannelGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelGroup>newBuilder()
                      .setDefaultInstance(ChannelGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteChannelGroupRequest, Empty>
      deleteChannelGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteChannelGroupRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteChannelGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteChannelGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/channelGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
      setAutomatedGa4ConfigurationOptOutMethodDescriptor =
          ApiMethodDescriptor
              .<SetAutomatedGa4ConfigurationOptOutRequest,
                  SetAutomatedGa4ConfigurationOptOutResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/SetAutomatedGa4ConfigurationOptOut")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetAutomatedGa4ConfigurationOptOutRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:setAutomatedGa4ConfigurationOptOut",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetAutomatedGa4ConfigurationOptOutRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetAutomatedGa4ConfigurationOptOutRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<SetAutomatedGa4ConfigurationOptOutResponse>newBuilder()
                      .setDefaultInstance(
                          SetAutomatedGa4ConfigurationOptOutResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchAutomatedGa4ConfigurationOptOutRequest, FetchAutomatedGa4ConfigurationOptOutResponse>
      fetchAutomatedGa4ConfigurationOptOutMethodDescriptor =
          ApiMethodDescriptor
              .<FetchAutomatedGa4ConfigurationOptOutRequest,
                  FetchAutomatedGa4ConfigurationOptOutResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/FetchAutomatedGa4ConfigurationOptOut")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<FetchAutomatedGa4ConfigurationOptOutRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:fetchAutomatedGa4ConfigurationOptOut",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchAutomatedGa4ConfigurationOptOutRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchAutomatedGa4ConfigurationOptOutRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<FetchAutomatedGa4ConfigurationOptOutResponse>newBuilder()
                      .setDefaultInstance(
                          FetchAutomatedGa4ConfigurationOptOutResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBigQueryLinkRequest, BigQueryLink>
      createBigQueryLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateBigQueryLinkRequest, BigQueryLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateBigQueryLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBigQueryLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/bigQueryLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bigqueryLink", request.getBigqueryLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryLink>newBuilder()
                      .setDefaultInstance(BigQueryLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBigQueryLinkRequest, BigQueryLink>
      getBigQueryLinkMethodDescriptor =
          ApiMethodDescriptor.<GetBigQueryLinkRequest, BigQueryLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetBigQueryLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBigQueryLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/bigQueryLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryLink>newBuilder()
                      .setDefaultInstance(BigQueryLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksMethodDescriptor =
          ApiMethodDescriptor.<ListBigQueryLinksRequest, ListBigQueryLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListBigQueryLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBigQueryLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/bigQueryLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBigQueryLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBigQueryLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBigQueryLinksResponse>newBuilder()
                      .setDefaultInstance(ListBigQueryLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBigQueryLinkRequest, Empty>
      deleteBigQueryLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteBigQueryLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteBigQueryLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBigQueryLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/bigQueryLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBigQueryLinkRequest, BigQueryLink>
      updateBigQueryLinkMethodDescriptor =
          ApiMethodDescriptor.<UpdateBigQueryLinkRequest, BigQueryLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateBigQueryLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBigQueryLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{bigqueryLink.name=properties/*/bigQueryLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "bigqueryLink.name", request.getBigqueryLink().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBigQueryLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("bigqueryLink", request.getBigqueryLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BigQueryLink>newBuilder()
                      .setDefaultInstance(BigQueryLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      getEnhancedMeasurementSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetEnhancedMeasurementSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEnhancedMeasurementSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/enhancedMeasurementSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnhancedMeasurementSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnhancedMeasurementSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EnhancedMeasurementSettings>newBuilder()
                      .setDefaultInstance(EnhancedMeasurementSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
      updateEnhancedMeasurementSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateEnhancedMeasurementSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateEnhancedMeasurementSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{enhancedMeasurementSettings.name=properties/*/dataStreams/*/enhancedMeasurementSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnhancedMeasurementSettingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "enhancedMeasurementSettings.name",
                                request.getEnhancedMeasurementSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnhancedMeasurementSettingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "enhancedMeasurementSettings",
                                      request.getEnhancedMeasurementSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EnhancedMeasurementSettings>newBuilder()
                      .setDefaultInstance(EnhancedMeasurementSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
      createConnectedSiteTagMethodDescriptor =
          ApiMethodDescriptor
              .<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateConnectedSiteTag")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectedSiteTagRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:createConnectedSiteTag",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectedSiteTagRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectedSiteTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreateConnectedSiteTagResponse>newBuilder()
                      .setDefaultInstance(CreateConnectedSiteTagResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConnectedSiteTagRequest, Empty>
      deleteConnectedSiteTagMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectedSiteTagRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteConnectedSiteTag")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectedSiteTagRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:deleteConnectedSiteTag",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectedSiteTagRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectedSiteTagRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
      listConnectedSiteTagsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListConnectedSiteTags")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectedSiteTagsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:listConnectedSiteTags",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectedSiteTagsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectedSiteTagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConnectedSiteTagsResponse>newBuilder()
                      .setDefaultInstance(ListConnectedSiteTagsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
      fetchConnectedGa4PropertyMethodDescriptor =
          ApiMethodDescriptor
              .<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/FetchConnectedGa4Property")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchConnectedGa4PropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:fetchConnectedGa4Property",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchConnectedGa4PropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchConnectedGa4PropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "property", request.getProperty());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchConnectedGa4PropertyResponse>newBuilder()
                      .setDefaultInstance(FetchConnectedGa4PropertyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAdSenseLinkRequest, AdSenseLink>
      getAdSenseLinkMethodDescriptor =
          ApiMethodDescriptor.<GetAdSenseLinkRequest, AdSenseLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetAdSenseLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAdSenseLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/adSenseLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdSenseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdSenseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdSenseLink>newBuilder()
                      .setDefaultInstance(AdSenseLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdSenseLinkRequest, AdSenseLink>
      createAdSenseLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateAdSenseLinkRequest, AdSenseLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateAdSenseLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdSenseLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/adSenseLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdSenseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdSenseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adsenseLink", request.getAdsenseLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdSenseLink>newBuilder()
                      .setDefaultInstance(AdSenseLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAdSenseLinkRequest, Empty>
      deleteAdSenseLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteAdSenseLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteAdSenseLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAdSenseLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/adSenseLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdSenseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdSenseLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
      listAdSenseLinksMethodDescriptor =
          ApiMethodDescriptor.<ListAdSenseLinksRequest, ListAdSenseLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListAdSenseLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdSenseLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/adSenseLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdSenseLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdSenseLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAdSenseLinksResponse>newBuilder()
                      .setDefaultInstance(ListAdSenseLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEventCreateRuleRequest, EventCreateRule>
      getEventCreateRuleMethodDescriptor =
          ApiMethodDescriptor.<GetEventCreateRuleRequest, EventCreateRule>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetEventCreateRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEventCreateRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/eventCreateRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventCreateRule>newBuilder()
                      .setDefaultInstance(EventCreateRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEventCreateRulesRequest, ListEventCreateRulesResponse>
      listEventCreateRulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListEventCreateRulesRequest, ListEventCreateRulesResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListEventCreateRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEventCreateRulesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/eventCreateRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventCreateRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventCreateRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEventCreateRulesResponse>newBuilder()
                      .setDefaultInstance(ListEventCreateRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEventCreateRuleRequest, EventCreateRule>
      createEventCreateRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateEventCreateRuleRequest, EventCreateRule>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateEventCreateRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEventCreateRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/eventCreateRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("eventCreateRule", request.getEventCreateRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventCreateRule>newBuilder()
                      .setDefaultInstance(EventCreateRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEventCreateRuleRequest, EventCreateRule>
      updateEventCreateRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateEventCreateRuleRequest, EventCreateRule>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateEventCreateRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEventCreateRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{eventCreateRule.name=properties/*/dataStreams/*/eventCreateRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "eventCreateRule.name",
                                request.getEventCreateRule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("eventCreateRule", request.getEventCreateRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventCreateRule>newBuilder()
                      .setDefaultInstance(EventCreateRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEventCreateRuleRequest, Empty>
      deleteEventCreateRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteEventCreateRuleRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteEventCreateRule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEventCreateRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/eventCreateRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventCreateRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEventEditRuleRequest, EventEditRule>
      getEventEditRuleMethodDescriptor =
          ApiMethodDescriptor.<GetEventEditRuleRequest, EventEditRule>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetEventEditRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEventEditRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/eventEditRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventEditRule>newBuilder()
                      .setDefaultInstance(EventEditRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEventEditRulesRequest, ListEventEditRulesResponse>
      listEventEditRulesMethodDescriptor =
          ApiMethodDescriptor.<ListEventEditRulesRequest, ListEventEditRulesResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListEventEditRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEventEditRulesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/eventEditRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventEditRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventEditRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEventEditRulesResponse>newBuilder()
                      .setDefaultInstance(ListEventEditRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEventEditRuleRequest, EventEditRule>
      createEventEditRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateEventEditRuleRequest, EventEditRule>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateEventEditRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEventEditRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/eventEditRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("eventEditRule", request.getEventEditRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventEditRule>newBuilder()
                      .setDefaultInstance(EventEditRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEventEditRuleRequest, EventEditRule>
      updateEventEditRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateEventEditRuleRequest, EventEditRule>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateEventEditRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEventEditRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{eventEditRule.name=properties/*/dataStreams/*/eventEditRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "eventEditRule.name", request.getEventEditRule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("eventEditRule", request.getEventEditRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventEditRule>newBuilder()
                      .setDefaultInstance(EventEditRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEventEditRuleRequest, Empty>
      deleteEventEditRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteEventEditRuleRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteEventEditRule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEventEditRuleRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/eventEditRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventEditRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReorderEventEditRulesRequest, Empty>
      reorderEventEditRulesMethodDescriptor =
          ApiMethodDescriptor.<ReorderEventEditRulesRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ReorderEventEditRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReorderEventEditRulesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*/dataStreams/*}/eventEditRules:reorder",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReorderEventEditRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReorderEventEditRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateDataRedactionSettingsRequest, DataRedactionSettings>
      updateDataRedactionSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateDataRedactionSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataRedactionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{dataRedactionSettings.name=properties/*/dataStreams/*/dataRedactionSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataRedactionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "dataRedactionSettings.name",
                                request.getDataRedactionSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataRedactionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "dataRedactionSettings",
                                      request.getDataRedactionSettings(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataRedactionSettings>newBuilder()
                      .setDefaultInstance(DataRedactionSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataRedactionSettingsRequest, DataRedactionSettings>
      getDataRedactionSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetDataRedactionSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataRedactionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/dataStreams/*/dataRedactionSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataRedactionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataRedactionSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataRedactionSettings>newBuilder()
                      .setDefaultInstance(DataRedactionSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCalculatedMetricRequest, CalculatedMetric>
      getCalculatedMetricMethodDescriptor =
          ApiMethodDescriptor.<GetCalculatedMetricRequest, CalculatedMetric>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetCalculatedMetric")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCalculatedMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/calculatedMetrics/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalculatedMetric>newBuilder()
                      .setDefaultInstance(CalculatedMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCalculatedMetricRequest, CalculatedMetric>
      createCalculatedMetricMethodDescriptor =
          ApiMethodDescriptor.<CreateCalculatedMetricRequest, CalculatedMetric>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateCalculatedMetric")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCalculatedMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/calculatedMetrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "calculatedMetricId", request.getCalculatedMetricId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("calculatedMetric", request.getCalculatedMetric(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalculatedMetric>newBuilder()
                      .setDefaultInstance(CalculatedMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
      listCalculatedMetricsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListCalculatedMetrics")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCalculatedMetricsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/calculatedMetrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCalculatedMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCalculatedMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCalculatedMetricsResponse>newBuilder()
                      .setDefaultInstance(ListCalculatedMetricsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCalculatedMetricRequest, CalculatedMetric>
      updateCalculatedMetricMethodDescriptor =
          ApiMethodDescriptor.<UpdateCalculatedMetricRequest, CalculatedMetric>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateCalculatedMetric")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCalculatedMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{calculatedMetric.name=properties/*/calculatedMetrics/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "calculatedMetric.name",
                                request.getCalculatedMetric().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("calculatedMetric", request.getCalculatedMetric(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalculatedMetric>newBuilder()
                      .setDefaultInstance(CalculatedMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCalculatedMetricRequest, Empty>
      deleteCalculatedMetricMethodDescriptor =
          ApiMethodDescriptor.<DeleteCalculatedMetricRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteCalculatedMetric")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCalculatedMetricRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/calculatedMetrics/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCalculatedMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateRollupPropertyRequest, CreateRollupPropertyResponse>
      createRollupPropertyMethodDescriptor =
          ApiMethodDescriptor
              .<CreateRollupPropertyRequest, CreateRollupPropertyResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateRollupProperty")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRollupPropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:createRollupProperty",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRollupPropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRollupPropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreateRollupPropertyResponse>newBuilder()
                      .setDefaultInstance(CreateRollupPropertyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      getRollupPropertySourceLinkMethodDescriptor =
          ApiMethodDescriptor
              .<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetRollupPropertySourceLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRollupPropertySourceLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/rollupPropertySourceLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRollupPropertySourceLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRollupPropertySourceLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RollupPropertySourceLink>newBuilder()
                      .setDefaultInstance(RollupPropertySourceLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
      listRollupPropertySourceLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListRollupPropertySourceLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRollupPropertySourceLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/rollupPropertySourceLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRollupPropertySourceLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRollupPropertySourceLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRollupPropertySourceLinksResponse>newBuilder()
                      .setDefaultInstance(
                          ListRollupPropertySourceLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
      createRollupPropertySourceLinkMethodDescriptor =
          ApiMethodDescriptor
              .<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateRollupPropertySourceLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRollupPropertySourceLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/rollupPropertySourceLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRollupPropertySourceLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRollupPropertySourceLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "rollupPropertySourceLink",
                                      request.getRollupPropertySourceLink(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RollupPropertySourceLink>newBuilder()
                      .setDefaultInstance(RollupPropertySourceLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRollupPropertySourceLinkRequest, Empty>
      deleteRollupPropertySourceLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteRollupPropertySourceLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteRollupPropertySourceLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRollupPropertySourceLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/rollupPropertySourceLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRollupPropertySourceLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRollupPropertySourceLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ProvisionSubpropertyRequest, ProvisionSubpropertyResponse>
      provisionSubpropertyMethodDescriptor =
          ApiMethodDescriptor
              .<ProvisionSubpropertyRequest, ProvisionSubpropertyResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ProvisionSubproperty")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProvisionSubpropertyRequest>newBuilder()
                      .setPath(
                          "/v1alpha/properties:provisionSubproperty",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionSubpropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionSubpropertyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProvisionSubpropertyResponse>newBuilder()
                      .setDefaultInstance(ProvisionSubpropertyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      createSubpropertyEventFilterMethodDescriptor =
          ApiMethodDescriptor
              .<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateSubpropertyEventFilter")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSubpropertyEventFilterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/subpropertyEventFilters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "subpropertyEventFilter",
                                      request.getSubpropertyEventFilter(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubpropertyEventFilter>newBuilder()
                      .setDefaultInstance(SubpropertyEventFilter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
      getSubpropertyEventFilterMethodDescriptor =
          ApiMethodDescriptor.<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/GetSubpropertyEventFilter")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSubpropertyEventFilterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/subpropertyEventFilters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubpropertyEventFilter>newBuilder()
                      .setDefaultInstance(SubpropertyEventFilter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
      listSubpropertyEventFiltersMethodDescriptor =
          ApiMethodDescriptor
              .<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListSubpropertyEventFilters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubpropertyEventFiltersRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=properties/*}/subpropertyEventFilters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubpropertyEventFiltersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubpropertyEventFiltersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSubpropertyEventFiltersResponse>newBuilder()
                      .setDefaultInstance(ListSubpropertyEventFiltersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
      updateSubpropertyEventFilterMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateSubpropertyEventFilter")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSubpropertyEventFilterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{subpropertyEventFilter.name=properties/*/subpropertyEventFilters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "subpropertyEventFilter.name",
                                request.getSubpropertyEventFilter().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "subpropertyEventFilter",
                                      request.getSubpropertyEventFilter(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubpropertyEventFilter>newBuilder()
                      .setDefaultInstance(SubpropertyEventFilter.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSubpropertyEventFilterRequest, Empty>
      deleteSubpropertyEventFilterMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubpropertyEventFilterRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteSubpropertyEventFilter")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSubpropertyEventFilterRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=properties/*/subpropertyEventFilters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubpropertyEventFilterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final UnaryCallable<CreateKeyEventRequest, KeyEvent> createKeyEventCallable;
  private final UnaryCallable<UpdateKeyEventRequest, KeyEvent> updateKeyEventCallable;
  private final UnaryCallable<GetKeyEventRequest, KeyEvent> getKeyEventCallable;
  private final UnaryCallable<DeleteKeyEventRequest, Empty> deleteKeyEventCallable;
  private final UnaryCallable<ListKeyEventsRequest, ListKeyEventsResponse> listKeyEventsCallable;
  private final UnaryCallable<ListKeyEventsRequest, ListKeyEventsPagedResponse>
      listKeyEventsPagedCallable;
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
  private final UnaryCallable<CreateBigQueryLinkRequest, BigQueryLink> createBigQueryLinkCallable;
  private final UnaryCallable<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkCallable;
  private final UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
      listBigQueryLinksCallable;
  private final UnaryCallable<ListBigQueryLinksRequest, ListBigQueryLinksPagedResponse>
      listBigQueryLinksPagedCallable;
  private final UnaryCallable<DeleteBigQueryLinkRequest, Empty> deleteBigQueryLinkCallable;
  private final UnaryCallable<UpdateBigQueryLinkRequest, BigQueryLink> updateBigQueryLinkCallable;
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
  private final UnaryCallable<GetEventEditRuleRequest, EventEditRule> getEventEditRuleCallable;
  private final UnaryCallable<ListEventEditRulesRequest, ListEventEditRulesResponse>
      listEventEditRulesCallable;
  private final UnaryCallable<ListEventEditRulesRequest, ListEventEditRulesPagedResponse>
      listEventEditRulesPagedCallable;
  private final UnaryCallable<CreateEventEditRuleRequest, EventEditRule>
      createEventEditRuleCallable;
  private final UnaryCallable<UpdateEventEditRuleRequest, EventEditRule>
      updateEventEditRuleCallable;
  private final UnaryCallable<DeleteEventEditRuleRequest, Empty> deleteEventEditRuleCallable;
  private final UnaryCallable<ReorderEventEditRulesRequest, Empty> reorderEventEditRulesCallable;
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
  private final UnaryCallable<ProvisionSubpropertyRequest, ProvisionSubpropertyResponse>
      provisionSubpropertyCallable;
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAnalyticsAdminServiceStub create(
      AnalyticsAdminServiceStubSettings settings) throws IOException {
    return new HttpJsonAnalyticsAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAnalyticsAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAnalyticsAdminServiceStub(
        AnalyticsAdminServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAnalyticsAdminServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAnalyticsAdminServiceStub(
        AnalyticsAdminServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAnalyticsAdminServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAnalyticsAdminServiceStub(
      AnalyticsAdminServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAnalyticsAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAnalyticsAdminServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAnalyticsAdminServiceStub(
      AnalyticsAdminServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAccountRequest, Account> getAccountTransportSettings =
        HttpJsonCallSettings.<GetAccountRequest, Account>newBuilder()
            .setMethodDescriptor(getAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAccountsRequest, ListAccountsResponse> listAccountsTransportSettings =
        HttpJsonCallSettings.<ListAccountsRequest, ListAccountsResponse>newBuilder()
            .setMethodDescriptor(listAccountsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAccountRequest, Empty> deleteAccountTransportSettings =
        HttpJsonCallSettings.<DeleteAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAccountRequest, Account> updateAccountTransportSettings =
        HttpJsonCallSettings.<UpdateAccountRequest, Account>newBuilder()
            .setMethodDescriptor(updateAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("account.name", String.valueOf(request.getAccount().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>
        provisionAccountTicketTransportSettings =
            HttpJsonCallSettings
                .<ProvisionAccountTicketRequest, ProvisionAccountTicketResponse>newBuilder()
                .setMethodDescriptor(provisionAccountTicketMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListAccountSummariesRequest, ListAccountSummariesResponse>
        listAccountSummariesTransportSettings =
            HttpJsonCallSettings
                .<ListAccountSummariesRequest, ListAccountSummariesResponse>newBuilder()
                .setMethodDescriptor(listAccountSummariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPropertyRequest, Property> getPropertyTransportSettings =
        HttpJsonCallSettings.<GetPropertyRequest, Property>newBuilder()
            .setMethodDescriptor(getPropertyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPropertiesRequest, ListPropertiesResponse>
        listPropertiesTransportSettings =
            HttpJsonCallSettings.<ListPropertiesRequest, ListPropertiesResponse>newBuilder()
                .setMethodDescriptor(listPropertiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreatePropertyRequest, Property> createPropertyTransportSettings =
        HttpJsonCallSettings.<CreatePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(createPropertyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePropertyRequest, Property> deletePropertyTransportSettings =
        HttpJsonCallSettings.<DeletePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(deletePropertyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePropertyRequest, Property> updatePropertyTransportSettings =
        HttpJsonCallSettings.<UpdatePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(updatePropertyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("property.name", String.valueOf(request.getProperty().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateFirebaseLinkRequest, FirebaseLink>
        createFirebaseLinkTransportSettings =
            HttpJsonCallSettings.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
                .setMethodDescriptor(createFirebaseLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkTransportSettings =
        HttpJsonCallSettings.<DeleteFirebaseLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFirebaseLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
        listFirebaseLinksTransportSettings =
            HttpJsonCallSettings.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
                .setMethodDescriptor(listFirebaseLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagTransportSettings =
        HttpJsonCallSettings.<GetGlobalSiteTagRequest, GlobalSiteTag>newBuilder()
            .setMethodDescriptor(getGlobalSiteTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkTransportSettings =
            HttpJsonCallSettings.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(createGoogleAdsLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkTransportSettings =
            HttpJsonCallSettings.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(updateGoogleAdsLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_ads_link.name",
                          String.valueOf(request.getGoogleAdsLink().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkTransportSettings =
        HttpJsonCallSettings.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGoogleAdsLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
        listGoogleAdsLinksTransportSettings =
            HttpJsonCallSettings.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
                .setMethodDescriptor(listGoogleAdsLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsTransportSettings =
            HttpJsonCallSettings.<GetDataSharingSettingsRequest, DataSharingSettings>newBuilder()
                .setMethodDescriptor(getDataSharingSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings
                .<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(getMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
        listMeasurementProtocolSecretsTransportSettings =
            HttpJsonCallSettings
                .<ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
                    newBuilder()
                .setMethodDescriptor(listMeasurementProtocolSecretsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings
                .<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(createMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings.<DeleteMeasurementProtocolSecretRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings
                .<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(updateMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "measurement_protocol_secret.name",
                          String.valueOf(request.getMeasurementProtocolSecret().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollectionTransportSettings =
            HttpJsonCallSettings
                .<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
                    newBuilder()
                .setMethodDescriptor(acknowledgeUserDataCollectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        getSKAdNetworkConversionValueSchemaTransportSettings =
            HttpJsonCallSettings
                .<GetSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                    newBuilder()
                .setMethodDescriptor(getSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        createSKAdNetworkConversionValueSchemaTransportSettings =
            HttpJsonCallSettings
                .<CreateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                    newBuilder()
                .setMethodDescriptor(createSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>
        deleteSKAdNetworkConversionValueSchemaTransportSettings =
            HttpJsonCallSettings.<DeleteSKAdNetworkConversionValueSchemaRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
        updateSKAdNetworkConversionValueSchemaTransportSettings =
            HttpJsonCallSettings
                .<UpdateSKAdNetworkConversionValueSchemaRequest, SKAdNetworkConversionValueSchema>
                    newBuilder()
                .setMethodDescriptor(updateSKAdNetworkConversionValueSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "skadnetwork_conversion_value_schema.name",
                          String.valueOf(request.getSkadnetworkConversionValueSchema().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListSKAdNetworkConversionValueSchemasRequest,
            ListSKAdNetworkConversionValueSchemasResponse>
        listSKAdNetworkConversionValueSchemasTransportSettings =
            HttpJsonCallSettings
                .<ListSKAdNetworkConversionValueSchemasRequest,
                    ListSKAdNetworkConversionValueSchemasResponse>
                    newBuilder()
                .setMethodDescriptor(listSKAdNetworkConversionValueSchemasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
        searchChangeHistoryEventsTransportSettings =
            HttpJsonCallSettings
                .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
                .setMethodDescriptor(searchChangeHistoryEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("account", String.valueOf(request.getAccount()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        getGoogleSignalsSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
                .setMethodDescriptor(getGoogleSignalsSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        updateGoogleSignalsSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
                .setMethodDescriptor(updateGoogleSignalsSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "google_signals_settings.name",
                          String.valueOf(request.getGoogleSignalsSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateConversionEventRequest, ConversionEvent>
        createConversionEventTransportSettings =
            HttpJsonCallSettings.<CreateConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(createConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateConversionEventRequest, ConversionEvent>
        updateConversionEventTransportSettings =
            HttpJsonCallSettings.<UpdateConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(updateConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversion_event.name",
                          String.valueOf(request.getConversionEvent().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConversionEventRequest, ConversionEvent>
        getConversionEventTransportSettings =
            HttpJsonCallSettings.<GetConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(getConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteConversionEventRequest, Empty>
        deleteConversionEventTransportSettings =
            HttpJsonCallSettings.<DeleteConversionEventRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListConversionEventsRequest, ListConversionEventsResponse>
        listConversionEventsTransportSettings =
            HttpJsonCallSettings
                .<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
                .setMethodDescriptor(listConversionEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateKeyEventRequest, KeyEvent> createKeyEventTransportSettings =
        HttpJsonCallSettings.<CreateKeyEventRequest, KeyEvent>newBuilder()
            .setMethodDescriptor(createKeyEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateKeyEventRequest, KeyEvent> updateKeyEventTransportSettings =
        HttpJsonCallSettings.<UpdateKeyEventRequest, KeyEvent>newBuilder()
            .setMethodDescriptor(updateKeyEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("key_event.name", String.valueOf(request.getKeyEvent().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetKeyEventRequest, KeyEvent> getKeyEventTransportSettings =
        HttpJsonCallSettings.<GetKeyEventRequest, KeyEvent>newBuilder()
            .setMethodDescriptor(getKeyEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteKeyEventRequest, Empty> deleteKeyEventTransportSettings =
        HttpJsonCallSettings.<DeleteKeyEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteKeyEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListKeyEventsRequest, ListKeyEventsResponse>
        listKeyEventsTransportSettings =
            HttpJsonCallSettings.<ListKeyEventsRequest, ListKeyEventsResponse>newBuilder()
                .setMethodDescriptor(listKeyEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings
                .<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(getDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListDisplayVideo360AdvertiserLinksRequest, ListDisplayVideo360AdvertiserLinksResponse>
        listDisplayVideo360AdvertiserLinksTransportSettings =
            HttpJsonCallSettings
                .<ListDisplayVideo360AdvertiserLinksRequest,
                    ListDisplayVideo360AdvertiserLinksResponse>
                    newBuilder()
                .setMethodDescriptor(listDisplayVideo360AdvertiserLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings
                .<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(createDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings.<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings
                .<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(updateDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "display_video_360_advertiser_link.name",
                          String.valueOf(request.getDisplayVideo360AdvertiserLink().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetDisplayVideo360AdvertiserLinkProposalRequest, DisplayVideo360AdvertiserLinkProposal>
        getDisplayVideo360AdvertiserLinkProposalTransportSettings =
            HttpJsonCallSettings
                .<GetDisplayVideo360AdvertiserLinkProposalRequest,
                    DisplayVideo360AdvertiserLinkProposal>
                    newBuilder()
                .setMethodDescriptor(getDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListDisplayVideo360AdvertiserLinkProposalsRequest,
            ListDisplayVideo360AdvertiserLinkProposalsResponse>
        listDisplayVideo360AdvertiserLinkProposalsTransportSettings =
            HttpJsonCallSettings
                .<ListDisplayVideo360AdvertiserLinkProposalsRequest,
                    ListDisplayVideo360AdvertiserLinkProposalsResponse>
                    newBuilder()
                .setMethodDescriptor(listDisplayVideo360AdvertiserLinkProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            CreateDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        createDisplayVideo360AdvertiserLinkProposalTransportSettings =
            HttpJsonCallSettings
                .<CreateDisplayVideo360AdvertiserLinkProposalRequest,
                    DisplayVideo360AdvertiserLinkProposal>
                    newBuilder()
                .setMethodDescriptor(createDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkProposalTransportSettings =
            HttpJsonCallSettings
                .<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ApproveDisplayVideo360AdvertiserLinkProposalRequest,
            ApproveDisplayVideo360AdvertiserLinkProposalResponse>
        approveDisplayVideo360AdvertiserLinkProposalTransportSettings =
            HttpJsonCallSettings
                .<ApproveDisplayVideo360AdvertiserLinkProposalRequest,
                    ApproveDisplayVideo360AdvertiserLinkProposalResponse>
                    newBuilder()
                .setMethodDescriptor(approveDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            CancelDisplayVideo360AdvertiserLinkProposalRequest,
            DisplayVideo360AdvertiserLinkProposal>
        cancelDisplayVideo360AdvertiserLinkProposalTransportSettings =
            HttpJsonCallSettings
                .<CancelDisplayVideo360AdvertiserLinkProposalRequest,
                    DisplayVideo360AdvertiserLinkProposal>
                    newBuilder()
                .setMethodDescriptor(cancelDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionTransportSettings =
            HttpJsonCallSettings.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(createCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionTransportSettings =
            HttpJsonCallSettings.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(updateCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_dimension.name",
                          String.valueOf(request.getCustomDimension().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
        listCustomDimensionsTransportSettings =
            HttpJsonCallSettings
                .<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
                .setMethodDescriptor(listCustomDimensionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ArchiveCustomDimensionRequest, Empty>
        archiveCustomDimensionTransportSettings =
            HttpJsonCallSettings.<ArchiveCustomDimensionRequest, Empty>newBuilder()
                .setMethodDescriptor(archiveCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionTransportSettings =
            HttpJsonCallSettings.<GetCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(getCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCustomMetricRequest, CustomMetric>
        createCustomMetricTransportSettings =
            HttpJsonCallSettings.<CreateCustomMetricRequest, CustomMetric>newBuilder()
                .setMethodDescriptor(createCustomMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCustomMetricRequest, CustomMetric>
        updateCustomMetricTransportSettings =
            HttpJsonCallSettings.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
                .setMethodDescriptor(updateCustomMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_metric.name",
                          String.valueOf(request.getCustomMetric().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCustomMetricsRequest, ListCustomMetricsResponse>
        listCustomMetricsTransportSettings =
            HttpJsonCallSettings.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
                .setMethodDescriptor(listCustomMetricsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricTransportSettings =
        HttpJsonCallSettings.<ArchiveCustomMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveCustomMetricMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricTransportSettings =
        HttpJsonCallSettings.<GetCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(getCustomMetricMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(getDataRetentionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(updateDataRetentionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_retention_settings.name",
                          String.valueOf(request.getDataRetentionSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDataStreamRequest, DataStream> createDataStreamTransportSettings =
        HttpJsonCallSettings.<CreateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(createDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamTransportSettings =
        HttpJsonCallSettings.<DeleteDataStreamRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamTransportSettings =
        HttpJsonCallSettings.<UpdateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(updateDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_stream.name", String.valueOf(request.getDataStream().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDataStreamsRequest, ListDataStreamsResponse>
        listDataStreamsTransportSettings =
            HttpJsonCallSettings.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
                .setMethodDescriptor(listDataStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataStreamRequest, DataStream> getDataStreamTransportSettings =
        HttpJsonCallSettings.<GetDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(getDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAudienceRequest, Audience> getAudienceTransportSettings =
        HttpJsonCallSettings.<GetAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(getAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAudiencesRequest, ListAudiencesResponse>
        listAudiencesTransportSettings =
            HttpJsonCallSettings.<ListAudiencesRequest, ListAudiencesResponse>newBuilder()
                .setMethodDescriptor(listAudiencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAudienceRequest, Audience> createAudienceTransportSettings =
        HttpJsonCallSettings.<CreateAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(createAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAudienceRequest, Audience> updateAudienceTransportSettings =
        HttpJsonCallSettings.<UpdateAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(updateAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("audience.name", String.valueOf(request.getAudience().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ArchiveAudienceRequest, Empty> archiveAudienceTransportSettings =
        HttpJsonCallSettings.<ArchiveAudienceRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSearchAds360LinkRequest, SearchAds360Link>
        getSearchAds360LinkTransportSettings =
            HttpJsonCallSettings.<GetSearchAds360LinkRequest, SearchAds360Link>newBuilder()
                .setMethodDescriptor(getSearchAds360LinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>
        listSearchAds360LinksTransportSettings =
            HttpJsonCallSettings
                .<ListSearchAds360LinksRequest, ListSearchAds360LinksResponse>newBuilder()
                .setMethodDescriptor(listSearchAds360LinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSearchAds360LinkRequest, SearchAds360Link>
        createSearchAds360LinkTransportSettings =
            HttpJsonCallSettings.<CreateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
                .setMethodDescriptor(createSearchAds360LinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSearchAds360LinkRequest, Empty>
        deleteSearchAds360LinkTransportSettings =
            HttpJsonCallSettings.<DeleteSearchAds360LinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSearchAds360LinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSearchAds360LinkRequest, SearchAds360Link>
        updateSearchAds360LinkTransportSettings =
            HttpJsonCallSettings.<UpdateSearchAds360LinkRequest, SearchAds360Link>newBuilder()
                .setMethodDescriptor(updateSearchAds360LinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "search_ads_360_link.name",
                          String.valueOf(request.getSearchAds360Link().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAttributionSettingsRequest, AttributionSettings>
        getAttributionSettingsTransportSettings =
            HttpJsonCallSettings.<GetAttributionSettingsRequest, AttributionSettings>newBuilder()
                .setMethodDescriptor(getAttributionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAttributionSettingsRequest, AttributionSettings>
        updateAttributionSettingsTransportSettings =
            HttpJsonCallSettings.<UpdateAttributionSettingsRequest, AttributionSettings>newBuilder()
                .setMethodDescriptor(updateAttributionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "attribution_settings.name",
                          String.valueOf(request.getAttributionSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RunAccessReportRequest, RunAccessReportResponse>
        runAccessReportTransportSettings =
            HttpJsonCallSettings.<RunAccessReportRequest, RunAccessReportResponse>newBuilder()
                .setMethodDescriptor(runAccessReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("entity", String.valueOf(request.getEntity()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAccessBindingRequest, AccessBinding>
        createAccessBindingTransportSettings =
            HttpJsonCallSettings.<CreateAccessBindingRequest, AccessBinding>newBuilder()
                .setMethodDescriptor(createAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAccessBindingRequest, AccessBinding> getAccessBindingTransportSettings =
        HttpJsonCallSettings.<GetAccessBindingRequest, AccessBinding>newBuilder()
            .setMethodDescriptor(getAccessBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAccessBindingRequest, AccessBinding>
        updateAccessBindingTransportSettings =
            HttpJsonCallSettings.<UpdateAccessBindingRequest, AccessBinding>newBuilder()
                .setMethodDescriptor(updateAccessBindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "access_binding.name",
                          String.valueOf(request.getAccessBinding().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAccessBindingRequest, Empty> deleteAccessBindingTransportSettings =
        HttpJsonCallSettings.<DeleteAccessBindingRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccessBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAccessBindingsRequest, ListAccessBindingsResponse>
        listAccessBindingsTransportSettings =
            HttpJsonCallSettings.<ListAccessBindingsRequest, ListAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(listAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>
        batchCreateAccessBindingsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateAccessBindingsRequest, BatchCreateAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(batchCreateAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>
        batchGetAccessBindingsTransportSettings =
            HttpJsonCallSettings
                .<BatchGetAccessBindingsRequest, BatchGetAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(batchGetAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>
        batchUpdateAccessBindingsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateAccessBindingsRequest, BatchUpdateAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchDeleteAccessBindingsRequest, Empty>
        batchDeleteAccessBindingsTransportSettings =
            HttpJsonCallSettings.<BatchDeleteAccessBindingsRequest, Empty>newBuilder()
                .setMethodDescriptor(batchDeleteAccessBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetExpandedDataSetRequest, ExpandedDataSet>
        getExpandedDataSetTransportSettings =
            HttpJsonCallSettings.<GetExpandedDataSetRequest, ExpandedDataSet>newBuilder()
                .setMethodDescriptor(getExpandedDataSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>
        listExpandedDataSetsTransportSettings =
            HttpJsonCallSettings
                .<ListExpandedDataSetsRequest, ListExpandedDataSetsResponse>newBuilder()
                .setMethodDescriptor(listExpandedDataSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateExpandedDataSetRequest, ExpandedDataSet>
        createExpandedDataSetTransportSettings =
            HttpJsonCallSettings.<CreateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
                .setMethodDescriptor(createExpandedDataSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateExpandedDataSetRequest, ExpandedDataSet>
        updateExpandedDataSetTransportSettings =
            HttpJsonCallSettings.<UpdateExpandedDataSetRequest, ExpandedDataSet>newBuilder()
                .setMethodDescriptor(updateExpandedDataSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "expanded_data_set.name",
                          String.valueOf(request.getExpandedDataSet().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteExpandedDataSetRequest, Empty>
        deleteExpandedDataSetTransportSettings =
            HttpJsonCallSettings.<DeleteExpandedDataSetRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteExpandedDataSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetChannelGroupRequest, ChannelGroup> getChannelGroupTransportSettings =
        HttpJsonCallSettings.<GetChannelGroupRequest, ChannelGroup>newBuilder()
            .setMethodDescriptor(getChannelGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListChannelGroupsRequest, ListChannelGroupsResponse>
        listChannelGroupsTransportSettings =
            HttpJsonCallSettings.<ListChannelGroupsRequest, ListChannelGroupsResponse>newBuilder()
                .setMethodDescriptor(listChannelGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateChannelGroupRequest, ChannelGroup>
        createChannelGroupTransportSettings =
            HttpJsonCallSettings.<CreateChannelGroupRequest, ChannelGroup>newBuilder()
                .setMethodDescriptor(createChannelGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateChannelGroupRequest, ChannelGroup>
        updateChannelGroupTransportSettings =
            HttpJsonCallSettings.<UpdateChannelGroupRequest, ChannelGroup>newBuilder()
                .setMethodDescriptor(updateChannelGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "channel_group.name",
                          String.valueOf(request.getChannelGroup().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteChannelGroupRequest, Empty> deleteChannelGroupTransportSettings =
        HttpJsonCallSettings.<DeleteChannelGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteChannelGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<
            SetAutomatedGa4ConfigurationOptOutRequest, SetAutomatedGa4ConfigurationOptOutResponse>
        setAutomatedGa4ConfigurationOptOutTransportSettings =
            HttpJsonCallSettings
                .<SetAutomatedGa4ConfigurationOptOutRequest,
                    SetAutomatedGa4ConfigurationOptOutResponse>
                    newBuilder()
                .setMethodDescriptor(setAutomatedGa4ConfigurationOptOutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            FetchAutomatedGa4ConfigurationOptOutRequest,
            FetchAutomatedGa4ConfigurationOptOutResponse>
        fetchAutomatedGa4ConfigurationOptOutTransportSettings =
            HttpJsonCallSettings
                .<FetchAutomatedGa4ConfigurationOptOutRequest,
                    FetchAutomatedGa4ConfigurationOptOutResponse>
                    newBuilder()
                .setMethodDescriptor(fetchAutomatedGa4ConfigurationOptOutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateBigQueryLinkRequest, BigQueryLink>
        createBigQueryLinkTransportSettings =
            HttpJsonCallSettings.<CreateBigQueryLinkRequest, BigQueryLink>newBuilder()
                .setMethodDescriptor(createBigQueryLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetBigQueryLinkRequest, BigQueryLink> getBigQueryLinkTransportSettings =
        HttpJsonCallSettings.<GetBigQueryLinkRequest, BigQueryLink>newBuilder()
            .setMethodDescriptor(getBigQueryLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBigQueryLinksRequest, ListBigQueryLinksResponse>
        listBigQueryLinksTransportSettings =
            HttpJsonCallSettings.<ListBigQueryLinksRequest, ListBigQueryLinksResponse>newBuilder()
                .setMethodDescriptor(listBigQueryLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteBigQueryLinkRequest, Empty> deleteBigQueryLinkTransportSettings =
        HttpJsonCallSettings.<DeleteBigQueryLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBigQueryLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBigQueryLinkRequest, BigQueryLink>
        updateBigQueryLinkTransportSettings =
            HttpJsonCallSettings.<UpdateBigQueryLinkRequest, BigQueryLink>newBuilder()
                .setMethodDescriptor(updateBigQueryLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "bigquery_link.name",
                          String.valueOf(request.getBigqueryLink().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
        getEnhancedMeasurementSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
                .setMethodDescriptor(getEnhancedMeasurementSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>
        updateEnhancedMeasurementSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateEnhancedMeasurementSettingsRequest, EnhancedMeasurementSettings>newBuilder()
                .setMethodDescriptor(updateEnhancedMeasurementSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "enhanced_measurement_settings.name",
                          String.valueOf(request.getEnhancedMeasurementSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>
        createConnectedSiteTagTransportSettings =
            HttpJsonCallSettings
                .<CreateConnectedSiteTagRequest, CreateConnectedSiteTagResponse>newBuilder()
                .setMethodDescriptor(createConnectedSiteTagMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConnectedSiteTagRequest, Empty>
        deleteConnectedSiteTagTransportSettings =
            HttpJsonCallSettings.<DeleteConnectedSiteTagRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConnectedSiteTagMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>
        listConnectedSiteTagsTransportSettings =
            HttpJsonCallSettings
                .<ListConnectedSiteTagsRequest, ListConnectedSiteTagsResponse>newBuilder()
                .setMethodDescriptor(listConnectedSiteTagsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>
        fetchConnectedGa4PropertyTransportSettings =
            HttpJsonCallSettings
                .<FetchConnectedGa4PropertyRequest, FetchConnectedGa4PropertyResponse>newBuilder()
                .setMethodDescriptor(fetchConnectedGa4PropertyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAdSenseLinkRequest, AdSenseLink> getAdSenseLinkTransportSettings =
        HttpJsonCallSettings.<GetAdSenseLinkRequest, AdSenseLink>newBuilder()
            .setMethodDescriptor(getAdSenseLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAdSenseLinkRequest, AdSenseLink> createAdSenseLinkTransportSettings =
        HttpJsonCallSettings.<CreateAdSenseLinkRequest, AdSenseLink>newBuilder()
            .setMethodDescriptor(createAdSenseLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAdSenseLinkRequest, Empty> deleteAdSenseLinkTransportSettings =
        HttpJsonCallSettings.<DeleteAdSenseLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAdSenseLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAdSenseLinksRequest, ListAdSenseLinksResponse>
        listAdSenseLinksTransportSettings =
            HttpJsonCallSettings.<ListAdSenseLinksRequest, ListAdSenseLinksResponse>newBuilder()
                .setMethodDescriptor(listAdSenseLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEventCreateRuleRequest, EventCreateRule>
        getEventCreateRuleTransportSettings =
            HttpJsonCallSettings.<GetEventCreateRuleRequest, EventCreateRule>newBuilder()
                .setMethodDescriptor(getEventCreateRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEventCreateRulesRequest, ListEventCreateRulesResponse>
        listEventCreateRulesTransportSettings =
            HttpJsonCallSettings
                .<ListEventCreateRulesRequest, ListEventCreateRulesResponse>newBuilder()
                .setMethodDescriptor(listEventCreateRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEventCreateRuleRequest, EventCreateRule>
        createEventCreateRuleTransportSettings =
            HttpJsonCallSettings.<CreateEventCreateRuleRequest, EventCreateRule>newBuilder()
                .setMethodDescriptor(createEventCreateRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEventCreateRuleRequest, EventCreateRule>
        updateEventCreateRuleTransportSettings =
            HttpJsonCallSettings.<UpdateEventCreateRuleRequest, EventCreateRule>newBuilder()
                .setMethodDescriptor(updateEventCreateRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "event_create_rule.name",
                          String.valueOf(request.getEventCreateRule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEventCreateRuleRequest, Empty>
        deleteEventCreateRuleTransportSettings =
            HttpJsonCallSettings.<DeleteEventCreateRuleRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEventCreateRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEventEditRuleRequest, EventEditRule> getEventEditRuleTransportSettings =
        HttpJsonCallSettings.<GetEventEditRuleRequest, EventEditRule>newBuilder()
            .setMethodDescriptor(getEventEditRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEventEditRulesRequest, ListEventEditRulesResponse>
        listEventEditRulesTransportSettings =
            HttpJsonCallSettings.<ListEventEditRulesRequest, ListEventEditRulesResponse>newBuilder()
                .setMethodDescriptor(listEventEditRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEventEditRuleRequest, EventEditRule>
        createEventEditRuleTransportSettings =
            HttpJsonCallSettings.<CreateEventEditRuleRequest, EventEditRule>newBuilder()
                .setMethodDescriptor(createEventEditRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEventEditRuleRequest, EventEditRule>
        updateEventEditRuleTransportSettings =
            HttpJsonCallSettings.<UpdateEventEditRuleRequest, EventEditRule>newBuilder()
                .setMethodDescriptor(updateEventEditRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "event_edit_rule.name",
                          String.valueOf(request.getEventEditRule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEventEditRuleRequest, Empty> deleteEventEditRuleTransportSettings =
        HttpJsonCallSettings.<DeleteEventEditRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEventEditRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ReorderEventEditRulesRequest, Empty>
        reorderEventEditRulesTransportSettings =
            HttpJsonCallSettings.<ReorderEventEditRulesRequest, Empty>newBuilder()
                .setMethodDescriptor(reorderEventEditRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDataRedactionSettingsRequest, DataRedactionSettings>
        updateDataRedactionSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
                .setMethodDescriptor(updateDataRedactionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_redaction_settings.name",
                          String.valueOf(request.getDataRedactionSettings().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDataRedactionSettingsRequest, DataRedactionSettings>
        getDataRedactionSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetDataRedactionSettingsRequest, DataRedactionSettings>newBuilder()
                .setMethodDescriptor(getDataRedactionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCalculatedMetricRequest, CalculatedMetric>
        getCalculatedMetricTransportSettings =
            HttpJsonCallSettings.<GetCalculatedMetricRequest, CalculatedMetric>newBuilder()
                .setMethodDescriptor(getCalculatedMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCalculatedMetricRequest, CalculatedMetric>
        createCalculatedMetricTransportSettings =
            HttpJsonCallSettings.<CreateCalculatedMetricRequest, CalculatedMetric>newBuilder()
                .setMethodDescriptor(createCalculatedMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>
        listCalculatedMetricsTransportSettings =
            HttpJsonCallSettings
                .<ListCalculatedMetricsRequest, ListCalculatedMetricsResponse>newBuilder()
                .setMethodDescriptor(listCalculatedMetricsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCalculatedMetricRequest, CalculatedMetric>
        updateCalculatedMetricTransportSettings =
            HttpJsonCallSettings.<UpdateCalculatedMetricRequest, CalculatedMetric>newBuilder()
                .setMethodDescriptor(updateCalculatedMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "calculated_metric.name",
                          String.valueOf(request.getCalculatedMetric().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCalculatedMetricRequest, Empty>
        deleteCalculatedMetricTransportSettings =
            HttpJsonCallSettings.<DeleteCalculatedMetricRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteCalculatedMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateRollupPropertyRequest, CreateRollupPropertyResponse>
        createRollupPropertyTransportSettings =
            HttpJsonCallSettings
                .<CreateRollupPropertyRequest, CreateRollupPropertyResponse>newBuilder()
                .setMethodDescriptor(createRollupPropertyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>
        getRollupPropertySourceLinkTransportSettings =
            HttpJsonCallSettings
                .<GetRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
                .setMethodDescriptor(getRollupPropertySourceLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
        listRollupPropertySourceLinksTransportSettings =
            HttpJsonCallSettings
                .<ListRollupPropertySourceLinksRequest, ListRollupPropertySourceLinksResponse>
                    newBuilder()
                .setMethodDescriptor(listRollupPropertySourceLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>
        createRollupPropertySourceLinkTransportSettings =
            HttpJsonCallSettings
                .<CreateRollupPropertySourceLinkRequest, RollupPropertySourceLink>newBuilder()
                .setMethodDescriptor(createRollupPropertySourceLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteRollupPropertySourceLinkRequest, Empty>
        deleteRollupPropertySourceLinkTransportSettings =
            HttpJsonCallSettings.<DeleteRollupPropertySourceLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteRollupPropertySourceLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ProvisionSubpropertyRequest, ProvisionSubpropertyResponse>
        provisionSubpropertyTransportSettings =
            HttpJsonCallSettings
                .<ProvisionSubpropertyRequest, ProvisionSubpropertyResponse>newBuilder()
                .setMethodDescriptor(provisionSubpropertyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>
        createSubpropertyEventFilterTransportSettings =
            HttpJsonCallSettings
                .<CreateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
                .setMethodDescriptor(createSubpropertyEventFilterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>
        getSubpropertyEventFilterTransportSettings =
            HttpJsonCallSettings
                .<GetSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
                .setMethodDescriptor(getSubpropertyEventFilterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
        listSubpropertyEventFiltersTransportSettings =
            HttpJsonCallSettings
                .<ListSubpropertyEventFiltersRequest, ListSubpropertyEventFiltersResponse>
                    newBuilder()
                .setMethodDescriptor(listSubpropertyEventFiltersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>
        updateSubpropertyEventFilterTransportSettings =
            HttpJsonCallSettings
                .<UpdateSubpropertyEventFilterRequest, SubpropertyEventFilter>newBuilder()
                .setMethodDescriptor(updateSubpropertyEventFilterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "subproperty_event_filter.name",
                          String.valueOf(request.getSubpropertyEventFilter().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSubpropertyEventFilterRequest, Empty>
        deleteSubpropertyEventFilterTransportSettings =
            HttpJsonCallSettings.<DeleteSubpropertyEventFilterRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSubpropertyEventFilterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    this.createKeyEventCallable =
        callableFactory.createUnaryCallable(
            createKeyEventTransportSettings, settings.createKeyEventSettings(), clientContext);
    this.updateKeyEventCallable =
        callableFactory.createUnaryCallable(
            updateKeyEventTransportSettings, settings.updateKeyEventSettings(), clientContext);
    this.getKeyEventCallable =
        callableFactory.createUnaryCallable(
            getKeyEventTransportSettings, settings.getKeyEventSettings(), clientContext);
    this.deleteKeyEventCallable =
        callableFactory.createUnaryCallable(
            deleteKeyEventTransportSettings, settings.deleteKeyEventSettings(), clientContext);
    this.listKeyEventsCallable =
        callableFactory.createUnaryCallable(
            listKeyEventsTransportSettings, settings.listKeyEventsSettings(), clientContext);
    this.listKeyEventsPagedCallable =
        callableFactory.createPagedCallable(
            listKeyEventsTransportSettings, settings.listKeyEventsSettings(), clientContext);
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
    this.createBigQueryLinkCallable =
        callableFactory.createUnaryCallable(
            createBigQueryLinkTransportSettings,
            settings.createBigQueryLinkSettings(),
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
    this.deleteBigQueryLinkCallable =
        callableFactory.createUnaryCallable(
            deleteBigQueryLinkTransportSettings,
            settings.deleteBigQueryLinkSettings(),
            clientContext);
    this.updateBigQueryLinkCallable =
        callableFactory.createUnaryCallable(
            updateBigQueryLinkTransportSettings,
            settings.updateBigQueryLinkSettings(),
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
    this.getEventEditRuleCallable =
        callableFactory.createUnaryCallable(
            getEventEditRuleTransportSettings, settings.getEventEditRuleSettings(), clientContext);
    this.listEventEditRulesCallable =
        callableFactory.createUnaryCallable(
            listEventEditRulesTransportSettings,
            settings.listEventEditRulesSettings(),
            clientContext);
    this.listEventEditRulesPagedCallable =
        callableFactory.createPagedCallable(
            listEventEditRulesTransportSettings,
            settings.listEventEditRulesSettings(),
            clientContext);
    this.createEventEditRuleCallable =
        callableFactory.createUnaryCallable(
            createEventEditRuleTransportSettings,
            settings.createEventEditRuleSettings(),
            clientContext);
    this.updateEventEditRuleCallable =
        callableFactory.createUnaryCallable(
            updateEventEditRuleTransportSettings,
            settings.updateEventEditRuleSettings(),
            clientContext);
    this.deleteEventEditRuleCallable =
        callableFactory.createUnaryCallable(
            deleteEventEditRuleTransportSettings,
            settings.deleteEventEditRuleSettings(),
            clientContext);
    this.reorderEventEditRulesCallable =
        callableFactory.createUnaryCallable(
            reorderEventEditRulesTransportSettings,
            settings.reorderEventEditRulesSettings(),
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
    this.provisionSubpropertyCallable =
        callableFactory.createUnaryCallable(
            provisionSubpropertyTransportSettings,
            settings.provisionSubpropertySettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAccountMethodDescriptor);
    methodDescriptors.add(listAccountsMethodDescriptor);
    methodDescriptors.add(deleteAccountMethodDescriptor);
    methodDescriptors.add(updateAccountMethodDescriptor);
    methodDescriptors.add(provisionAccountTicketMethodDescriptor);
    methodDescriptors.add(listAccountSummariesMethodDescriptor);
    methodDescriptors.add(getPropertyMethodDescriptor);
    methodDescriptors.add(listPropertiesMethodDescriptor);
    methodDescriptors.add(createPropertyMethodDescriptor);
    methodDescriptors.add(deletePropertyMethodDescriptor);
    methodDescriptors.add(updatePropertyMethodDescriptor);
    methodDescriptors.add(createFirebaseLinkMethodDescriptor);
    methodDescriptors.add(deleteFirebaseLinkMethodDescriptor);
    methodDescriptors.add(listFirebaseLinksMethodDescriptor);
    methodDescriptors.add(getGlobalSiteTagMethodDescriptor);
    methodDescriptors.add(createGoogleAdsLinkMethodDescriptor);
    methodDescriptors.add(updateGoogleAdsLinkMethodDescriptor);
    methodDescriptors.add(deleteGoogleAdsLinkMethodDescriptor);
    methodDescriptors.add(listGoogleAdsLinksMethodDescriptor);
    methodDescriptors.add(getDataSharingSettingsMethodDescriptor);
    methodDescriptors.add(getMeasurementProtocolSecretMethodDescriptor);
    methodDescriptors.add(listMeasurementProtocolSecretsMethodDescriptor);
    methodDescriptors.add(createMeasurementProtocolSecretMethodDescriptor);
    methodDescriptors.add(deleteMeasurementProtocolSecretMethodDescriptor);
    methodDescriptors.add(updateMeasurementProtocolSecretMethodDescriptor);
    methodDescriptors.add(acknowledgeUserDataCollectionMethodDescriptor);
    methodDescriptors.add(getSKAdNetworkConversionValueSchemaMethodDescriptor);
    methodDescriptors.add(createSKAdNetworkConversionValueSchemaMethodDescriptor);
    methodDescriptors.add(deleteSKAdNetworkConversionValueSchemaMethodDescriptor);
    methodDescriptors.add(updateSKAdNetworkConversionValueSchemaMethodDescriptor);
    methodDescriptors.add(listSKAdNetworkConversionValueSchemasMethodDescriptor);
    methodDescriptors.add(searchChangeHistoryEventsMethodDescriptor);
    methodDescriptors.add(getGoogleSignalsSettingsMethodDescriptor);
    methodDescriptors.add(updateGoogleSignalsSettingsMethodDescriptor);
    methodDescriptors.add(createConversionEventMethodDescriptor);
    methodDescriptors.add(updateConversionEventMethodDescriptor);
    methodDescriptors.add(getConversionEventMethodDescriptor);
    methodDescriptors.add(deleteConversionEventMethodDescriptor);
    methodDescriptors.add(listConversionEventsMethodDescriptor);
    methodDescriptors.add(createKeyEventMethodDescriptor);
    methodDescriptors.add(updateKeyEventMethodDescriptor);
    methodDescriptors.add(getKeyEventMethodDescriptor);
    methodDescriptors.add(deleteKeyEventMethodDescriptor);
    methodDescriptors.add(listKeyEventsMethodDescriptor);
    methodDescriptors.add(getDisplayVideo360AdvertiserLinkMethodDescriptor);
    methodDescriptors.add(listDisplayVideo360AdvertiserLinksMethodDescriptor);
    methodDescriptors.add(createDisplayVideo360AdvertiserLinkMethodDescriptor);
    methodDescriptors.add(deleteDisplayVideo360AdvertiserLinkMethodDescriptor);
    methodDescriptors.add(updateDisplayVideo360AdvertiserLinkMethodDescriptor);
    methodDescriptors.add(getDisplayVideo360AdvertiserLinkProposalMethodDescriptor);
    methodDescriptors.add(listDisplayVideo360AdvertiserLinkProposalsMethodDescriptor);
    methodDescriptors.add(createDisplayVideo360AdvertiserLinkProposalMethodDescriptor);
    methodDescriptors.add(deleteDisplayVideo360AdvertiserLinkProposalMethodDescriptor);
    methodDescriptors.add(approveDisplayVideo360AdvertiserLinkProposalMethodDescriptor);
    methodDescriptors.add(cancelDisplayVideo360AdvertiserLinkProposalMethodDescriptor);
    methodDescriptors.add(createCustomDimensionMethodDescriptor);
    methodDescriptors.add(updateCustomDimensionMethodDescriptor);
    methodDescriptors.add(listCustomDimensionsMethodDescriptor);
    methodDescriptors.add(archiveCustomDimensionMethodDescriptor);
    methodDescriptors.add(getCustomDimensionMethodDescriptor);
    methodDescriptors.add(createCustomMetricMethodDescriptor);
    methodDescriptors.add(updateCustomMetricMethodDescriptor);
    methodDescriptors.add(listCustomMetricsMethodDescriptor);
    methodDescriptors.add(archiveCustomMetricMethodDescriptor);
    methodDescriptors.add(getCustomMetricMethodDescriptor);
    methodDescriptors.add(getDataRetentionSettingsMethodDescriptor);
    methodDescriptors.add(updateDataRetentionSettingsMethodDescriptor);
    methodDescriptors.add(createDataStreamMethodDescriptor);
    methodDescriptors.add(deleteDataStreamMethodDescriptor);
    methodDescriptors.add(updateDataStreamMethodDescriptor);
    methodDescriptors.add(listDataStreamsMethodDescriptor);
    methodDescriptors.add(getDataStreamMethodDescriptor);
    methodDescriptors.add(getAudienceMethodDescriptor);
    methodDescriptors.add(listAudiencesMethodDescriptor);
    methodDescriptors.add(createAudienceMethodDescriptor);
    methodDescriptors.add(updateAudienceMethodDescriptor);
    methodDescriptors.add(archiveAudienceMethodDescriptor);
    methodDescriptors.add(getSearchAds360LinkMethodDescriptor);
    methodDescriptors.add(listSearchAds360LinksMethodDescriptor);
    methodDescriptors.add(createSearchAds360LinkMethodDescriptor);
    methodDescriptors.add(deleteSearchAds360LinkMethodDescriptor);
    methodDescriptors.add(updateSearchAds360LinkMethodDescriptor);
    methodDescriptors.add(getAttributionSettingsMethodDescriptor);
    methodDescriptors.add(updateAttributionSettingsMethodDescriptor);
    methodDescriptors.add(runAccessReportMethodDescriptor);
    methodDescriptors.add(createAccessBindingMethodDescriptor);
    methodDescriptors.add(getAccessBindingMethodDescriptor);
    methodDescriptors.add(updateAccessBindingMethodDescriptor);
    methodDescriptors.add(deleteAccessBindingMethodDescriptor);
    methodDescriptors.add(listAccessBindingsMethodDescriptor);
    methodDescriptors.add(batchCreateAccessBindingsMethodDescriptor);
    methodDescriptors.add(batchGetAccessBindingsMethodDescriptor);
    methodDescriptors.add(batchUpdateAccessBindingsMethodDescriptor);
    methodDescriptors.add(batchDeleteAccessBindingsMethodDescriptor);
    methodDescriptors.add(getExpandedDataSetMethodDescriptor);
    methodDescriptors.add(listExpandedDataSetsMethodDescriptor);
    methodDescriptors.add(createExpandedDataSetMethodDescriptor);
    methodDescriptors.add(updateExpandedDataSetMethodDescriptor);
    methodDescriptors.add(deleteExpandedDataSetMethodDescriptor);
    methodDescriptors.add(getChannelGroupMethodDescriptor);
    methodDescriptors.add(listChannelGroupsMethodDescriptor);
    methodDescriptors.add(createChannelGroupMethodDescriptor);
    methodDescriptors.add(updateChannelGroupMethodDescriptor);
    methodDescriptors.add(deleteChannelGroupMethodDescriptor);
    methodDescriptors.add(setAutomatedGa4ConfigurationOptOutMethodDescriptor);
    methodDescriptors.add(fetchAutomatedGa4ConfigurationOptOutMethodDescriptor);
    methodDescriptors.add(createBigQueryLinkMethodDescriptor);
    methodDescriptors.add(getBigQueryLinkMethodDescriptor);
    methodDescriptors.add(listBigQueryLinksMethodDescriptor);
    methodDescriptors.add(deleteBigQueryLinkMethodDescriptor);
    methodDescriptors.add(updateBigQueryLinkMethodDescriptor);
    methodDescriptors.add(getEnhancedMeasurementSettingsMethodDescriptor);
    methodDescriptors.add(updateEnhancedMeasurementSettingsMethodDescriptor);
    methodDescriptors.add(createConnectedSiteTagMethodDescriptor);
    methodDescriptors.add(deleteConnectedSiteTagMethodDescriptor);
    methodDescriptors.add(listConnectedSiteTagsMethodDescriptor);
    methodDescriptors.add(fetchConnectedGa4PropertyMethodDescriptor);
    methodDescriptors.add(getAdSenseLinkMethodDescriptor);
    methodDescriptors.add(createAdSenseLinkMethodDescriptor);
    methodDescriptors.add(deleteAdSenseLinkMethodDescriptor);
    methodDescriptors.add(listAdSenseLinksMethodDescriptor);
    methodDescriptors.add(getEventCreateRuleMethodDescriptor);
    methodDescriptors.add(listEventCreateRulesMethodDescriptor);
    methodDescriptors.add(createEventCreateRuleMethodDescriptor);
    methodDescriptors.add(updateEventCreateRuleMethodDescriptor);
    methodDescriptors.add(deleteEventCreateRuleMethodDescriptor);
    methodDescriptors.add(getEventEditRuleMethodDescriptor);
    methodDescriptors.add(listEventEditRulesMethodDescriptor);
    methodDescriptors.add(createEventEditRuleMethodDescriptor);
    methodDescriptors.add(updateEventEditRuleMethodDescriptor);
    methodDescriptors.add(deleteEventEditRuleMethodDescriptor);
    methodDescriptors.add(reorderEventEditRulesMethodDescriptor);
    methodDescriptors.add(updateDataRedactionSettingsMethodDescriptor);
    methodDescriptors.add(getDataRedactionSettingsMethodDescriptor);
    methodDescriptors.add(getCalculatedMetricMethodDescriptor);
    methodDescriptors.add(createCalculatedMetricMethodDescriptor);
    methodDescriptors.add(listCalculatedMetricsMethodDescriptor);
    methodDescriptors.add(updateCalculatedMetricMethodDescriptor);
    methodDescriptors.add(deleteCalculatedMetricMethodDescriptor);
    methodDescriptors.add(createRollupPropertyMethodDescriptor);
    methodDescriptors.add(getRollupPropertySourceLinkMethodDescriptor);
    methodDescriptors.add(listRollupPropertySourceLinksMethodDescriptor);
    methodDescriptors.add(createRollupPropertySourceLinkMethodDescriptor);
    methodDescriptors.add(deleteRollupPropertySourceLinkMethodDescriptor);
    methodDescriptors.add(provisionSubpropertyMethodDescriptor);
    methodDescriptors.add(createSubpropertyEventFilterMethodDescriptor);
    methodDescriptors.add(getSubpropertyEventFilterMethodDescriptor);
    methodDescriptors.add(listSubpropertyEventFiltersMethodDescriptor);
    methodDescriptors.add(updateSubpropertyEventFilterMethodDescriptor);
    methodDescriptors.add(deleteSubpropertyEventFilterMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<CreateKeyEventRequest, KeyEvent> createKeyEventCallable() {
    return createKeyEventCallable;
  }

  @Override
  public UnaryCallable<UpdateKeyEventRequest, KeyEvent> updateKeyEventCallable() {
    return updateKeyEventCallable;
  }

  @Override
  public UnaryCallable<GetKeyEventRequest, KeyEvent> getKeyEventCallable() {
    return getKeyEventCallable;
  }

  @Override
  public UnaryCallable<DeleteKeyEventRequest, Empty> deleteKeyEventCallable() {
    return deleteKeyEventCallable;
  }

  @Override
  public UnaryCallable<ListKeyEventsRequest, ListKeyEventsResponse> listKeyEventsCallable() {
    return listKeyEventsCallable;
  }

  @Override
  public UnaryCallable<ListKeyEventsRequest, ListKeyEventsPagedResponse>
      listKeyEventsPagedCallable() {
    return listKeyEventsPagedCallable;
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
  public UnaryCallable<CreateBigQueryLinkRequest, BigQueryLink> createBigQueryLinkCallable() {
    return createBigQueryLinkCallable;
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
  public UnaryCallable<DeleteBigQueryLinkRequest, Empty> deleteBigQueryLinkCallable() {
    return deleteBigQueryLinkCallable;
  }

  @Override
  public UnaryCallable<UpdateBigQueryLinkRequest, BigQueryLink> updateBigQueryLinkCallable() {
    return updateBigQueryLinkCallable;
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
  public UnaryCallable<GetEventEditRuleRequest, EventEditRule> getEventEditRuleCallable() {
    return getEventEditRuleCallable;
  }

  @Override
  public UnaryCallable<ListEventEditRulesRequest, ListEventEditRulesResponse>
      listEventEditRulesCallable() {
    return listEventEditRulesCallable;
  }

  @Override
  public UnaryCallable<ListEventEditRulesRequest, ListEventEditRulesPagedResponse>
      listEventEditRulesPagedCallable() {
    return listEventEditRulesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEventEditRuleRequest, EventEditRule> createEventEditRuleCallable() {
    return createEventEditRuleCallable;
  }

  @Override
  public UnaryCallable<UpdateEventEditRuleRequest, EventEditRule> updateEventEditRuleCallable() {
    return updateEventEditRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteEventEditRuleRequest, Empty> deleteEventEditRuleCallable() {
    return deleteEventEditRuleCallable;
  }

  @Override
  public UnaryCallable<ReorderEventEditRulesRequest, Empty> reorderEventEditRulesCallable() {
    return reorderEventEditRulesCallable;
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
  public UnaryCallable<ProvisionSubpropertyRequest, ProvisionSubpropertyResponse>
      provisionSubpropertyCallable() {
    return provisionSubpropertyCallable;
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
