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
          .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/GetAccount")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAccountRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=accounts/*}",
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
              .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/ListAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountsRequest>newBuilder()
                      .setPath(
                          "/v1beta/accounts",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteAccount")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccountRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=accounts/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateAccount")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccountRequest>newBuilder()
                      .setPath(
                          "/v1beta/{account.name=accounts/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("account", request.getAccount(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ProvisionAccountTicket")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProvisionAccountTicketRequest>newBuilder()
                      .setPath(
                          "/v1beta/accounts:provisionAccountTicket",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListAccountSummaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountSummariesRequest>newBuilder()
                      .setPath(
                          "/v1beta/accountSummaries",
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
              .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/GetProperty")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPropertyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListProperties")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPropertiesRequest>newBuilder()
                      .setPath(
                          "/v1beta/properties",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateProperty")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePropertyRequest>newBuilder()
                      .setPath(
                          "/v1beta/properties",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("property", request.getProperty(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteProperty")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePropertyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateProperty")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePropertyRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property.name=properties/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("property", request.getProperty(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateFirebaseLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFirebaseLinkRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/firebaseLinks",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("firebaseLink", request.getFirebaseLink(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteFirebaseLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFirebaseLinkRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/firebaseLinks/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListFirebaseLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFirebaseLinksRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/firebaseLinks",
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

  private static final ApiMethodDescriptor<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateGoogleAdsLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGoogleAdsLinkRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/googleAdsLinks",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("googleAdsLink", request.getGoogleAdsLink(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateGoogleAdsLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGoogleAdsLinkRequest>newBuilder()
                      .setPath(
                          "/v1beta/{googleAdsLink.name=properties/*/googleAdsLinks/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("googleAdsLink", request.getGoogleAdsLink(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteGoogleAdsLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGoogleAdsLinkRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/googleAdsLinks/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListGoogleAdsLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGoogleAdsLinksRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/googleAdsLinks",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetDataSharingSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataSharingSettingsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=accounts/*/dataSharingSettings}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetMeasurementProtocolSecret")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/dataStreams/*/measurementProtocolSecrets/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListMeasurementProtocolSecrets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMeasurementProtocolSecretsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*/dataStreams/*}/measurementProtocolSecrets",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateMeasurementProtocolSecret")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*/dataStreams/*}/measurementProtocolSecrets",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "measurementProtocolSecret",
                                      request.getMeasurementProtocolSecret(),
                                      false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteMeasurementProtocolSecret")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/dataStreams/*/measurementProtocolSecrets/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateMeasurementProtocolSecret")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMeasurementProtocolSecretRequest>newBuilder()
                      .setPath(
                          "/v1beta/{measurementProtocolSecret.name=properties/*/dataStreams/*/measurementProtocolSecrets/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "measurementProtocolSecret",
                                      request.getMeasurementProtocolSecret(),
                                      false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/AcknowledgeUserDataCollection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AcknowledgeUserDataCollectionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:acknowledgeUserDataCollection",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/SearchChangeHistoryEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchChangeHistoryEventsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{account=accounts/*}:searchChangeHistoryEvents",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearAccount().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchChangeHistoryEventsResponse>newBuilder()
                      .setDefaultInstance(SearchChangeHistoryEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConversionEventRequest, ConversionEvent>
      createConversionEventMethodDescriptor =
          ApiMethodDescriptor.<CreateConversionEventRequest, ConversionEvent>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateConversionEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/conversionEvents",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversionEvent", request.getConversionEvent(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetConversionEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/conversionEvents/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteConversionEvent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversionEventRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/conversionEvents/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListConversionEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversionEventsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/conversionEvents",
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

  private static final ApiMethodDescriptor<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateCustomDimension")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/customDimensions",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customDimension", request.getCustomDimension(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateCustomDimension")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{customDimension.name=properties/*/customDimensions/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customDimension", request.getCustomDimension(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListCustomDimensions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomDimensionsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/customDimensions",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ArchiveCustomDimension")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ArchiveCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/customDimensions/*}:archive",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetCustomDimension")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomDimensionRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/customDimensions/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateCustomMetric")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/customMetrics",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customMetric", request.getCustomMetric(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateCustomMetric")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1beta/{customMetric.name=properties/*/customMetrics/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customMetric", request.getCustomMetric(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListCustomMetrics")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomMetricsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/customMetrics",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ArchiveCustomMetric")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ArchiveCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/customMetrics/*}:archive",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetCustomMetric")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomMetricRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/customMetrics/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetDataRetentionSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataRetentionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/dataRetentionSettings}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateDataRetentionSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataRetentionSettingsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{dataRetentionSettings.name=properties/*/dataRetentionSettings}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "dataRetentionSettings",
                                      request.getDataRetentionSettings(),
                                      false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateDataStream")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/dataStreams",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataStream", request.getDataStream(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteDataStream")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/dataStreams/*}",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateDataStream")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1beta/{dataStream.name=properties/*/dataStreams/*}",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataStream", request.getDataStream(), false))
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListDataStreams")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataStreamsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/dataStreams",
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetDataStream")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataStreamRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/dataStreams/*}",
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
  private final UnaryCallable<CreateConversionEventRequest, ConversionEvent>
      createConversionEventCallable;
  private final UnaryCallable<GetConversionEventRequest, ConversionEvent>
      getConversionEventCallable;
  private final UnaryCallable<DeleteConversionEventRequest, Empty> deleteConversionEventCallable;
  private final UnaryCallable<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsCallable;
  private final UnaryCallable<ListConversionEventsRequest, ListConversionEventsPagedResponse>
      listConversionEventsPagedCallable;
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
    methodDescriptors.add(createConversionEventMethodDescriptor);
    methodDescriptors.add(getConversionEventMethodDescriptor);
    methodDescriptors.add(deleteConversionEventMethodDescriptor);
    methodDescriptors.add(listConversionEventsMethodDescriptor);
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
