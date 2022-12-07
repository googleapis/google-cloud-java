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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
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
          .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/GetAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListAccountsRequest, ListAccountsResponse>
      listAccountsMethodDescriptor =
          MethodDescriptor.<ListAccountsRequest, ListAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/ListAccounts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccountRequest, Empty> deleteAccountMethodDescriptor =
      MethodDescriptor.<DeleteAccountRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/DeleteAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAccountRequest, Account>
      updateAccountMethodDescriptor =
          MethodDescriptor.<UpdateAccountRequest, Account>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateAccount")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ProvisionAccountTicket")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListAccountSummaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountSummariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountSummariesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPropertyRequest, Property> getPropertyMethodDescriptor =
      MethodDescriptor.<GetPropertyRequest, Property>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.admin.v1beta.AnalyticsAdminService/GetProperty")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPropertyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListPropertiesRequest, ListPropertiesResponse>
      listPropertiesMethodDescriptor =
          MethodDescriptor.<ListPropertiesRequest, ListPropertiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListProperties")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePropertyRequest, Property>
      deletePropertyMethodDescriptor =
          MethodDescriptor.<DeletePropertyRequest, Property>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePropertyRequest, Property>
      updatePropertyMethodDescriptor =
          MethodDescriptor.<UpdatePropertyRequest, Property>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateProperty")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Property.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFirebaseLinkRequest, FirebaseLink>
      createFirebaseLinkMethodDescriptor =
          MethodDescriptor.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateFirebaseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFirebaseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FirebaseLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFirebaseLinkRequest, Empty>
      deleteFirebaseLinkMethodDescriptor =
          MethodDescriptor.<DeleteFirebaseLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteFirebaseLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFirebaseLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
      listFirebaseLinksMethodDescriptor =
          MethodDescriptor.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListFirebaseLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFirebaseLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFirebaseLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGoogleAdsLinkRequest, GoogleAdsLink>
      createGoogleAdsLinkMethodDescriptor =
          MethodDescriptor.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateGoogleAdsLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGoogleAdsLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GoogleAdsLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
      updateGoogleAdsLinkMethodDescriptor =
          MethodDescriptor.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateGoogleAdsLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGoogleAdsLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GoogleAdsLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGoogleAdsLinkRequest, Empty>
      deleteGoogleAdsLinkMethodDescriptor =
          MethodDescriptor.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteGoogleAdsLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGoogleAdsLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
      listGoogleAdsLinksMethodDescriptor =
          MethodDescriptor.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListGoogleAdsLinks")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetDataSharingSettings")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetMeasurementProtocolSecret")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListMeasurementProtocolSecrets")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateMeasurementProtocolSecret")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteMeasurementProtocolSecret")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateMeasurementProtocolSecret")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/AcknowledgeUserDataCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AcknowledgeUserDataCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AcknowledgeUserDataCollectionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
      searchChangeHistoryEventsMethodDescriptor =
          MethodDescriptor
              .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/SearchChangeHistoryEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchChangeHistoryEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchChangeHistoryEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConversionEventRequest, ConversionEvent>
      createConversionEventMethodDescriptor =
          MethodDescriptor.<CreateConversionEventRequest, ConversionEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionEvent.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversionEventRequest, ConversionEvent>
      getConversionEventMethodDescriptor =
          MethodDescriptor.<GetConversionEventRequest, ConversionEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversionEvent.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversionEventRequest, Empty>
      deleteConversionEventMethodDescriptor =
          MethodDescriptor.<DeleteConversionEventRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteConversionEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversionEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConversionEventsRequest, ListConversionEventsResponse>
      listConversionEventsMethodDescriptor =
          MethodDescriptor.<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListConversionEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversionEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversionEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCustomDimensionRequest, CustomDimension>
      createCustomDimensionMethodDescriptor =
          MethodDescriptor.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomDimension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomDimensionRequest, CustomDimension>
      updateCustomDimensionMethodDescriptor =
          MethodDescriptor.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomDimension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
      listCustomDimensionsMethodDescriptor =
          MethodDescriptor.<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListCustomDimensions")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ArchiveCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ArchiveCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomDimensionRequest, CustomDimension>
      getCustomDimensionMethodDescriptor =
          MethodDescriptor.<GetCustomDimensionRequest, CustomDimension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetCustomDimension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomDimensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomDimension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCustomMetricRequest, CustomMetric>
      createCustomMetricMethodDescriptor =
          MethodDescriptor.<CreateCustomMetricRequest, CustomMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomMetricRequest, CustomMetric>
      updateCustomMetricMethodDescriptor =
          MethodDescriptor.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomMetricsRequest, ListCustomMetricsResponse>
      listCustomMetricsMethodDescriptor =
          MethodDescriptor.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListCustomMetrics")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ArchiveCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ArchiveCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomMetricRequest, CustomMetric>
      getCustomMetricMethodDescriptor =
          MethodDescriptor.<GetCustomMetricRequest, CustomMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetCustomMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataRetentionSettingsRequest, DataRetentionSettings>
      getDataRetentionSettingsMethodDescriptor =
          MethodDescriptor.<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetDataRetentionSettings")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateDataRetentionSettings")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/CreateDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataStreamRequest, Empty>
      deleteDataStreamMethodDescriptor =
          MethodDescriptor.<DeleteDataStreamRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/DeleteDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataStreamRequest, DataStream>
      updateDataStreamMethodDescriptor =
          MethodDescriptor.<UpdateDataStreamRequest, DataStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/UpdateDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataStreamsRequest, ListDataStreamsResponse>
      listDataStreamsMethodDescriptor =
          MethodDescriptor.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.admin.v1beta.AnalyticsAdminService/ListDataStreams")
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
                  "google.analytics.admin.v1beta.AnalyticsAdminService/GetDataStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataStream.getDefaultInstance()))
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
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
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
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAccountRequest, Account> updateAccountTransportSettings =
        GrpcCallSettings.<UpdateAccountRequest, Account>newBuilder()
            .setMethodDescriptor(updateAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("account.name", String.valueOf(request.getAccount().getName()));
                  return params.build();
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
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
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
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePropertyRequest, Property> updatePropertyTransportSettings =
        GrpcCallSettings.<UpdatePropertyRequest, Property>newBuilder()
            .setMethodDescriptor(updatePropertyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("property.name", String.valueOf(request.getProperty().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkTransportSettings =
        GrpcCallSettings.<CreateFirebaseLinkRequest, FirebaseLink>newBuilder()
            .setMethodDescriptor(createFirebaseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkTransportSettings =
        GrpcCallSettings.<DeleteFirebaseLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFirebaseLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListFirebaseLinksRequest, ListFirebaseLinksResponse>
        listFirebaseLinksTransportSettings =
            GrpcCallSettings.<ListFirebaseLinksRequest, ListFirebaseLinksResponse>newBuilder()
                .setMethodDescriptor(listFirebaseLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateGoogleAdsLinkRequest, GoogleAdsLink>
        createGoogleAdsLinkTransportSettings =
            GrpcCallSettings.<CreateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(createGoogleAdsLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateGoogleAdsLinkRequest, GoogleAdsLink>
        updateGoogleAdsLinkTransportSettings =
            GrpcCallSettings.<UpdateGoogleAdsLinkRequest, GoogleAdsLink>newBuilder()
                .setMethodDescriptor(updateGoogleAdsLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "google_ads_link.name",
                          String.valueOf(request.getGoogleAdsLink().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteGoogleAdsLinkRequest, Empty> deleteGoogleAdsLinkTransportSettings =
        GrpcCallSettings.<DeleteGoogleAdsLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGoogleAdsLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>
        listGoogleAdsLinksTransportSettings =
            GrpcCallSettings.<ListGoogleAdsLinksRequest, ListGoogleAdsLinksResponse>newBuilder()
                .setMethodDescriptor(listGoogleAdsLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDataSharingSettingsRequest, DataSharingSettings>
        getDataSharingSettingsTransportSettings =
            GrpcCallSettings.<GetDataSharingSettingsRequest, DataSharingSettings>newBuilder()
                .setMethodDescriptor(getDataSharingSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        getMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings
                .<GetMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(getMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
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
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        createMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings
                .<CreateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(createMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteMeasurementProtocolSecretRequest, Empty>
        deleteMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings.<DeleteMeasurementProtocolSecretRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>
        updateMeasurementProtocolSecretTransportSettings =
            GrpcCallSettings
                .<UpdateMeasurementProtocolSecretRequest, MeasurementProtocolSecret>newBuilder()
                .setMethodDescriptor(updateMeasurementProtocolSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "measurement_protocol_secret.name",
                          String.valueOf(request.getMeasurementProtocolSecret().getName()));
                      return params.build();
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
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("property", String.valueOf(request.getProperty()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>
        searchChangeHistoryEventsTransportSettings =
            GrpcCallSettings
                .<SearchChangeHistoryEventsRequest, SearchChangeHistoryEventsResponse>newBuilder()
                .setMethodDescriptor(searchChangeHistoryEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("account", String.valueOf(request.getAccount()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateConversionEventRequest, ConversionEvent>
        createConversionEventTransportSettings =
            GrpcCallSettings.<CreateConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(createConversionEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConversionEventRequest, ConversionEvent>
        getConversionEventTransportSettings =
            GrpcCallSettings.<GetConversionEventRequest, ConversionEvent>newBuilder()
                .setMethodDescriptor(getConversionEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversionEventRequest, Empty> deleteConversionEventTransportSettings =
        GrpcCallSettings.<DeleteConversionEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversionEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListConversionEventsRequest, ListConversionEventsResponse>
        listConversionEventsTransportSettings =
            GrpcCallSettings.<ListConversionEventsRequest, ListConversionEventsResponse>newBuilder()
                .setMethodDescriptor(listConversionEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCustomDimensionRequest, CustomDimension>
        createCustomDimensionTransportSettings =
            GrpcCallSettings.<CreateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(createCustomDimensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCustomDimensionRequest, CustomDimension>
        updateCustomDimensionTransportSettings =
            GrpcCallSettings.<UpdateCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(updateCustomDimensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "custom_dimension.name",
                          String.valueOf(request.getCustomDimension().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCustomDimensionsRequest, ListCustomDimensionsResponse>
        listCustomDimensionsTransportSettings =
            GrpcCallSettings.<ListCustomDimensionsRequest, ListCustomDimensionsResponse>newBuilder()
                .setMethodDescriptor(listCustomDimensionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ArchiveCustomDimensionRequest, Empty> archiveCustomDimensionTransportSettings =
        GrpcCallSettings.<ArchiveCustomDimensionRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveCustomDimensionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCustomDimensionRequest, CustomDimension>
        getCustomDimensionTransportSettings =
            GrpcCallSettings.<GetCustomDimensionRequest, CustomDimension>newBuilder()
                .setMethodDescriptor(getCustomDimensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCustomMetricRequest, CustomMetric> createCustomMetricTransportSettings =
        GrpcCallSettings.<CreateCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(createCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCustomMetricRequest, CustomMetric> updateCustomMetricTransportSettings =
        GrpcCallSettings.<UpdateCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(updateCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "custom_metric.name", String.valueOf(request.getCustomMetric().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCustomMetricsRequest, ListCustomMetricsResponse>
        listCustomMetricsTransportSettings =
            GrpcCallSettings.<ListCustomMetricsRequest, ListCustomMetricsResponse>newBuilder()
                .setMethodDescriptor(listCustomMetricsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ArchiveCustomMetricRequest, Empty> archiveCustomMetricTransportSettings =
        GrpcCallSettings.<ArchiveCustomMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(archiveCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCustomMetricRequest, CustomMetric> getCustomMetricTransportSettings =
        GrpcCallSettings.<GetCustomMetricRequest, CustomMetric>newBuilder()
            .setMethodDescriptor(getCustomMetricMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDataRetentionSettingsRequest, DataRetentionSettings>
        getDataRetentionSettingsTransportSettings =
            GrpcCallSettings.<GetDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(getDataRetentionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateDataRetentionSettingsRequest, DataRetentionSettings>
        updateDataRetentionSettingsTransportSettings =
            GrpcCallSettings.<UpdateDataRetentionSettingsRequest, DataRetentionSettings>newBuilder()
                .setMethodDescriptor(updateDataRetentionSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "data_retention_settings.name",
                          String.valueOf(request.getDataRetentionSettings().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateDataStreamRequest, DataStream> createDataStreamTransportSettings =
        GrpcCallSettings.<CreateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(createDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDataStreamRequest, Empty> deleteDataStreamTransportSettings =
        GrpcCallSettings.<DeleteDataStreamRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDataStreamRequest, DataStream> updateDataStreamTransportSettings =
        GrpcCallSettings.<UpdateDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(updateDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("data_stream.name", String.valueOf(request.getDataStream().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDataStreamsRequest, ListDataStreamsResponse>
        listDataStreamsTransportSettings =
            GrpcCallSettings.<ListDataStreamsRequest, ListDataStreamsResponse>newBuilder()
                .setMethodDescriptor(listDataStreamsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDataStreamRequest, DataStream> getDataStreamTransportSettings =
        GrpcCallSettings.<GetDataStreamRequest, DataStream>newBuilder()
            .setMethodDescriptor(getDataStreamMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
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
