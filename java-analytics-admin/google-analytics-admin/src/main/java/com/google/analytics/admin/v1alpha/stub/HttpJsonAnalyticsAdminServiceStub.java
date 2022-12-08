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

  private static final ApiMethodDescriptor<GetUserLinkRequest, UserLink>
      getUserLinkMethodDescriptor =
          ApiMethodDescriptor.<GetUserLinkRequest, UserLink>newBuilder()
              .setFullMethodName("google.analytics.admin.v1alpha.AnalyticsAdminService/GetUserLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=accounts/*/userLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{name=properties/*/userLinks/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserLink>newBuilder()
                      .setDefaultInstance(UserLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksMethodDescriptor =
          ApiMethodDescriptor.<BatchGetUserLinksRequest, BatchGetUserLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchGetUserLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetUserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks:batchGet")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetUserLinksResponse>newBuilder()
                      .setDefaultInstance(BatchGetUserLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUserLinksRequest, ListUserLinksResponse>
      listUserLinksMethodDescriptor =
          ApiMethodDescriptor.<ListUserLinksRequest, ListUserLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/ListUserLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserLinksResponse>newBuilder()
                      .setDefaultInstance(ListUserLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AuditUserLinksRequest, AuditUserLinksResponse>
      auditUserLinksMethodDescriptor =
          ApiMethodDescriptor.<AuditUserLinksRequest, AuditUserLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/AuditUserLinks")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AuditUserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks:audit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AuditUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks:audit")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AuditUserLinksRequest> serializer =
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
                  ProtoMessageResponseParser.<AuditUserLinksResponse>newBuilder()
                      .setDefaultInstance(AuditUserLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUserLinkRequest, UserLink>
      createUserLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateUserLinkRequest, UserLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/CreateUserLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "notifyNewUser", request.getNotifyNewUser());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userLink", request.getUserLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserLink>newBuilder()
                      .setDefaultInstance(UserLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchCreateUserLinks")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateUserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks:batchCreate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateUserLinksRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateUserLinksResponse>newBuilder()
                      .setDefaultInstance(BatchCreateUserLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserLinkRequest, UserLink>
      updateUserLinkMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserLinkRequest, UserLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/UpdateUserLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{userLink.name=accounts/*/userLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "userLink.name", request.getUserLink().getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{userLink.name=properties/*/userLinks/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userLink", request.getUserLink(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserLink>newBuilder()
                      .setDefaultInstance(UserLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchUpdateUserLinks")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateUserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks:batchUpdate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateUserLinksRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateUserLinksResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateUserLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserLinkRequest, Empty>
      deleteUserLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/DeleteUserLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=accounts/*/userLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{name=properties/*/userLinks/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserLinkRequest> serializer =
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

  private static final ApiMethodDescriptor<BatchDeleteUserLinksRequest, Empty>
      batchDeleteUserLinksMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteUserLinksRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1alpha.AnalyticsAdminService/BatchDeleteUserLinks")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteUserLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=accounts/*}/userLinks:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteUserLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1alpha/{parent=properties/*}/userLinks:batchDelete")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteUserLinksRequest> serializer =
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
  private final UnaryCallable<GetUserLinkRequest, UserLink> getUserLinkCallable;
  private final UnaryCallable<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksCallable;
  private final UnaryCallable<ListUserLinksRequest, ListUserLinksResponse> listUserLinksCallable;
  private final UnaryCallable<ListUserLinksRequest, ListUserLinksPagedResponse>
      listUserLinksPagedCallable;
  private final UnaryCallable<AuditUserLinksRequest, AuditUserLinksResponse> auditUserLinksCallable;
  private final UnaryCallable<AuditUserLinksRequest, AuditUserLinksPagedResponse>
      auditUserLinksPagedCallable;
  private final UnaryCallable<CreateUserLinkRequest, UserLink> createUserLinkCallable;
  private final UnaryCallable<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksCallable;
  private final UnaryCallable<UpdateUserLinkRequest, UserLink> updateUserLinkCallable;
  private final UnaryCallable<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksCallable;
  private final UnaryCallable<DeleteUserLinkRequest, Empty> deleteUserLinkCallable;
  private final UnaryCallable<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksCallable;
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
  private final UnaryCallable<GetAttributionSettingsRequest, AttributionSettings>
      getAttributionSettingsCallable;
  private final UnaryCallable<UpdateAttributionSettingsRequest, AttributionSettings>
      updateAttributionSettingsCallable;
  private final UnaryCallable<RunAccessReportRequest, RunAccessReportResponse>
      runAccessReportCallable;

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
            .build();
    HttpJsonCallSettings<UpdateAccountRequest, Account> updateAccountTransportSettings =
        HttpJsonCallSettings.<UpdateAccountRequest, Account>newBuilder()
            .setMethodDescriptor(updateAccountMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            .build();
    HttpJsonCallSettings<UpdatePropertyRequest, Property> updatePropertyTransportSettings =
        HttpJsonCallSettings.<UpdatePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(updatePropertyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetUserLinkRequest, UserLink> getUserLinkTransportSettings =
        HttpJsonCallSettings.<GetUserLinkRequest, UserLink>newBuilder()
            .setMethodDescriptor(getUserLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
        batchGetUserLinksTransportSettings =
            HttpJsonCallSettings.<BatchGetUserLinksRequest, BatchGetUserLinksResponse>newBuilder()
                .setMethodDescriptor(batchGetUserLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListUserLinksRequest, ListUserLinksResponse>
        listUserLinksTransportSettings =
            HttpJsonCallSettings.<ListUserLinksRequest, ListUserLinksResponse>newBuilder()
                .setMethodDescriptor(listUserLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AuditUserLinksRequest, AuditUserLinksResponse>
        auditUserLinksTransportSettings =
            HttpJsonCallSettings.<AuditUserLinksRequest, AuditUserLinksResponse>newBuilder()
                .setMethodDescriptor(auditUserLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateUserLinkRequest, UserLink> createUserLinkTransportSettings =
        HttpJsonCallSettings.<CreateUserLinkRequest, UserLink>newBuilder()
            .setMethodDescriptor(createUserLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
        batchCreateUserLinksTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>newBuilder()
                .setMethodDescriptor(batchCreateUserLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateUserLinkRequest, UserLink> updateUserLinkTransportSettings =
        HttpJsonCallSettings.<UpdateUserLinkRequest, UserLink>newBuilder()
            .setMethodDescriptor(updateUserLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
        batchUpdateUserLinksTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>newBuilder()
                .setMethodDescriptor(batchUpdateUserLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteUserLinkRequest, Empty> deleteUserLinkTransportSettings =
        HttpJsonCallSettings.<DeleteUserLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksTransportSettings =
        HttpJsonCallSettings.<BatchDeleteUserLinksRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteUserLinksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateFirebaseLinkRequest, FirebaseLink>
        createFirebaseLinkTransportSettings =
            HttpJsonCallSettings.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
                .setMethodDescriptor(createFirebaseLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkTransportSettings =
        HttpJsonCallSettings.<DeleteFirebaseLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFirebaseLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
        listFirebaseLinksTransportSettings =
            HttpJsonCallSettings.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
                .setMethodDescriptor(listFirebaseLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGlobalSiteTagRequest, GlobalSiteTag> getGlobalSiteTagTransportSettings =
        HttpJsonCallSettings.<GetGlobalSiteTagRequest, GlobalSiteTag>newBuilder()
            .setMethodDescriptor(getGlobalSiteTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkTransportSettings =
            HttpJsonCallSettings.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(createGoogleAdsLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkTransportSettings =
            HttpJsonCallSettings.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(updateGoogleAdsLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkTransportSettings =
        HttpJsonCallSettings.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGoogleAdsLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
        listGoogleAdsLinksTransportSettings =
            HttpJsonCallSettings.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
                .setMethodDescriptor(listGoogleAdsLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsTransportSettings =
            HttpJsonCallSettings.<GetDataSharingSettingsRequest, DataSharingSettings>newBuilder()
                .setMethodDescriptor(getDataSharingSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings
                .<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(getMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
        listMeasurementProtocolSecretsTransportSettings =
            HttpJsonCallSettings
                .<ListMeasurementProtocolSecretsRequest, ListMeasurementProtocolSecretsResponse>
                    newBuilder()
                .setMethodDescriptor(listMeasurementProtocolSecretsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings
                .<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(createMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings.<DeleteMeasurementProtocolSecretRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretTransportSettings =
            HttpJsonCallSettings
                .<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(updateMeasurementProtocolSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
        acknowledgeUserDataCollectionTransportSettings =
            HttpJsonCallSettings
                .<AcknowledgeUserDataCollectionRequest, AcknowledgeUserDataCollectionResponse>
                    newBuilder()
                .setMethodDescriptor(acknowledgeUserDataCollectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
        searchChangeHistoryEventsTransportSettings =
            HttpJsonCallSettings
                .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
                .setMethodDescriptor(searchChangeHistoryEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        getGoogleSignalsSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
                .setMethodDescriptor(getGoogleSignalsSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>
        updateGoogleSignalsSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateGoogleSignalsSettingsRequest, GoogleSignalsSettings>newBuilder()
                .setMethodDescriptor(updateGoogleSignalsSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateConversionEventRequest, ConversionEvent>
        createConversionEventTransportSettings =
            HttpJsonCallSettings.<CreateConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(createConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConversionEventRequest, ConversionEvent>
        getConversionEventTransportSettings =
            HttpJsonCallSettings.<GetConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(getConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConversionEventRequest, Empty>
        deleteConversionEventTransportSettings =
            HttpJsonCallSettings.<DeleteConversionEventRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConversionEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListConversionEventsRequest, ListConversionEventsResponse>
        listConversionEventsTransportSettings =
            HttpJsonCallSettings
                .<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
                .setMethodDescriptor(listConversionEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        getDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings
                .<GetDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(getDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
                .build();
    HttpJsonCallSettings<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        createDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings
                .<CreateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(createDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings.<DeleteDisplayVideo360AdvertiserLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
        updateDisplayVideo360AdvertiserLinkTransportSettings =
            HttpJsonCallSettings
                .<UpdateDisplayVideo360AdvertiserLinkRequest, DisplayVideo360AdvertiserLink>
                    newBuilder()
                .setMethodDescriptor(updateDisplayVideo360AdvertiserLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
                .build();
    HttpJsonCallSettings<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>
        deleteDisplayVideo360AdvertiserLinkProposalTransportSettings =
            HttpJsonCallSettings
                .<DeleteDisplayVideo360AdvertiserLinkProposalRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDisplayVideo360AdvertiserLinkProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
                .build();
    HttpJsonCallSettings<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionTransportSettings =
            HttpJsonCallSettings.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(createCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionTransportSettings =
            HttpJsonCallSettings.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(updateCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
        listCustomDimensionsTransportSettings =
            HttpJsonCallSettings
                .<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
                .setMethodDescriptor(listCustomDimensionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ArchiveCustomDimensionRequest, Empty>
        archiveCustomDimensionTransportSettings =
            HttpJsonCallSettings.<ArchiveCustomDimensionRequest, Empty>newBuilder()
                .setMethodDescriptor(archiveCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionTransportSettings =
            HttpJsonCallSettings.<GetCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(getCustomDimensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateCustomMetricRequest, CustomMetric>
        createCustomMetricTransportSettings =
            HttpJsonCallSettings.<CreateCustomMetricRequest, CustomMetric>newBuilder()
                .setMethodDescriptor(createCustomMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCustomMetricRequest, CustomMetric>
        updateCustomMetricTransportSettings =
            HttpJsonCallSettings.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
                .setMethodDescriptor(updateCustomMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListCustomMetricsRequest, ListCustomMetricsResponse>
        listCustomMetricsTransportSettings =
            HttpJsonCallSettings.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
                .setMethodDescriptor(listCustomMetricsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricTransportSettings =
        HttpJsonCallSettings.<ArchiveCustomMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveCustomMetricMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricTransportSettings =
        HttpJsonCallSettings.<GetCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(getCustomMetricMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(getDataRetentionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(updateDataRetentionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateDataStreamRequest, DataStream> createDataStreamTransportSettings =
        HttpJsonCallSettings.<CreateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(createDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamTransportSettings =
        HttpJsonCallSettings.<DeleteDataStreamRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamTransportSettings =
        HttpJsonCallSettings.<UpdateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(updateDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDataStreamsRequest, ListDataStreamsResponse>
        listDataStreamsTransportSettings =
            HttpJsonCallSettings.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
                .setMethodDescriptor(listDataStreamsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDataStreamRequest, DataStream> getDataStreamTransportSettings =
        HttpJsonCallSettings.<GetDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(getDataStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAudienceRequest, Audience> getAudienceTransportSettings =
        HttpJsonCallSettings.<GetAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(getAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAudiencesRequest, ListAudiencesResponse>
        listAudiencesTransportSettings =
            HttpJsonCallSettings.<ListAudiencesRequest, ListAudiencesResponse>newBuilder()
                .setMethodDescriptor(listAudiencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateAudienceRequest, Audience> createAudienceTransportSettings =
        HttpJsonCallSettings.<CreateAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(createAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAudienceRequest, Audience> updateAudienceTransportSettings =
        HttpJsonCallSettings.<UpdateAudienceRequest, Audience>newBuilder()
            .setMethodDescriptor(updateAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ArchiveAudienceRequest, Empty> archiveAudienceTransportSettings =
        HttpJsonCallSettings.<ArchiveAudienceRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveAudienceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAttributionSettingsRequest, AttributionSettings>
        getAttributionSettingsTransportSettings =
            HttpJsonCallSettings.<GetAttributionSettingsRequest, AttributionSettings>newBuilder()
                .setMethodDescriptor(getAttributionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAttributionSettingsRequest, AttributionSettings>
        updateAttributionSettingsTransportSettings =
            HttpJsonCallSettings.<UpdateAttributionSettingsRequest, AttributionSettings>newBuilder()
                .setMethodDescriptor(updateAttributionSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RunAccessReportRequest, RunAccessReportResponse>
        runAccessReportTransportSettings =
            HttpJsonCallSettings.<RunAccessReportRequest, RunAccessReportResponse>newBuilder()
                .setMethodDescriptor(runAccessReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    this.getUserLinkCallable =
        callableFactory.createUnaryCallable(
            getUserLinkTransportSettings, settings.getUserLinkSettings(), clientContext);
    this.batchGetUserLinksCallable =
        callableFactory.createUnaryCallable(
            batchGetUserLinksTransportSettings,
            settings.batchGetUserLinksSettings(),
            clientContext);
    this.listUserLinksCallable =
        callableFactory.createUnaryCallable(
            listUserLinksTransportSettings, settings.listUserLinksSettings(), clientContext);
    this.listUserLinksPagedCallable =
        callableFactory.createPagedCallable(
            listUserLinksTransportSettings, settings.listUserLinksSettings(), clientContext);
    this.auditUserLinksCallable =
        callableFactory.createUnaryCallable(
            auditUserLinksTransportSettings, settings.auditUserLinksSettings(), clientContext);
    this.auditUserLinksPagedCallable =
        callableFactory.createPagedCallable(
            auditUserLinksTransportSettings, settings.auditUserLinksSettings(), clientContext);
    this.createUserLinkCallable =
        callableFactory.createUnaryCallable(
            createUserLinkTransportSettings, settings.createUserLinkSettings(), clientContext);
    this.batchCreateUserLinksCallable =
        callableFactory.createUnaryCallable(
            batchCreateUserLinksTransportSettings,
            settings.batchCreateUserLinksSettings(),
            clientContext);
    this.updateUserLinkCallable =
        callableFactory.createUnaryCallable(
            updateUserLinkTransportSettings, settings.updateUserLinkSettings(), clientContext);
    this.batchUpdateUserLinksCallable =
        callableFactory.createUnaryCallable(
            batchUpdateUserLinksTransportSettings,
            settings.batchUpdateUserLinksSettings(),
            clientContext);
    this.deleteUserLinkCallable =
        callableFactory.createUnaryCallable(
            deleteUserLinkTransportSettings, settings.deleteUserLinkSettings(), clientContext);
    this.batchDeleteUserLinksCallable =
        callableFactory.createUnaryCallable(
            batchDeleteUserLinksTransportSettings,
            settings.batchDeleteUserLinksSettings(),
            clientContext);
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
    methodDescriptors.add(getUserLinkMethodDescriptor);
    methodDescriptors.add(batchGetUserLinksMethodDescriptor);
    methodDescriptors.add(listUserLinksMethodDescriptor);
    methodDescriptors.add(auditUserLinksMethodDescriptor);
    methodDescriptors.add(createUserLinkMethodDescriptor);
    methodDescriptors.add(batchCreateUserLinksMethodDescriptor);
    methodDescriptors.add(updateUserLinkMethodDescriptor);
    methodDescriptors.add(batchUpdateUserLinksMethodDescriptor);
    methodDescriptors.add(deleteUserLinkMethodDescriptor);
    methodDescriptors.add(batchDeleteUserLinksMethodDescriptor);
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
    methodDescriptors.add(searchChangeHistoryEventsMethodDescriptor);
    methodDescriptors.add(getGoogleSignalsSettingsMethodDescriptor);
    methodDescriptors.add(updateGoogleSignalsSettingsMethodDescriptor);
    methodDescriptors.add(createConversionEventMethodDescriptor);
    methodDescriptors.add(getConversionEventMethodDescriptor);
    methodDescriptors.add(deleteConversionEventMethodDescriptor);
    methodDescriptors.add(listConversionEventsMethodDescriptor);
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
    methodDescriptors.add(getAttributionSettingsMethodDescriptor);
    methodDescriptors.add(updateAttributionSettingsMethodDescriptor);
    methodDescriptors.add(runAccessReportMethodDescriptor);
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
  public UnaryCallable<GetUserLinkRequest, UserLink> getUserLinkCallable() {
    return getUserLinkCallable;
  }

  @Override
  public UnaryCallable<BatchGetUserLinksRequest, BatchGetUserLinksResponse>
      batchGetUserLinksCallable() {
    return batchGetUserLinksCallable;
  }

  @Override
  public UnaryCallable<ListUserLinksRequest, ListUserLinksResponse> listUserLinksCallable() {
    return listUserLinksCallable;
  }

  @Override
  public UnaryCallable<ListUserLinksRequest, ListUserLinksPagedResponse>
      listUserLinksPagedCallable() {
    return listUserLinksPagedCallable;
  }

  @Override
  public UnaryCallable<AuditUserLinksRequest, AuditUserLinksResponse> auditUserLinksCallable() {
    return auditUserLinksCallable;
  }

  @Override
  public UnaryCallable<AuditUserLinksRequest, AuditUserLinksPagedResponse>
      auditUserLinksPagedCallable() {
    return auditUserLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateUserLinkRequest, UserLink> createUserLinkCallable() {
    return createUserLinkCallable;
  }

  @Override
  public UnaryCallable<BatchCreateUserLinksRequest, BatchCreateUserLinksResponse>
      batchCreateUserLinksCallable() {
    return batchCreateUserLinksCallable;
  }

  @Override
  public UnaryCallable<UpdateUserLinkRequest, UserLink> updateUserLinkCallable() {
    return updateUserLinkCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateUserLinksRequest, BatchUpdateUserLinksResponse>
      batchUpdateUserLinksCallable() {
    return batchUpdateUserLinksCallable;
  }

  @Override
  public UnaryCallable<DeleteUserLinkRequest, Empty> deleteUserLinkCallable() {
    return deleteUserLinkCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteUserLinksRequest, Empty> batchDeleteUserLinksCallable() {
    return batchDeleteUserLinksCallable;
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
