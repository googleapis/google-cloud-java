/*
 * Copyright 2020 Google LLC
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
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListAndroidAppDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListGoogleAdsLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListIosAppDataStreamsPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListPropertiesPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListUserLinksPagedResponse;
import static com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient.ListWebDataStreamsPagedResponse;

import com.google.analytics.admin.v1alpha.Account;
import com.google.analytics.admin.v1alpha.AndroidAppDataStream;
import com.google.analytics.admin.v1alpha.AuditUserLinksRequest;
import com.google.analytics.admin.v1alpha.AuditUserLinksResponse;
import com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse;
import com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse;
import com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest;
import com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse;
import com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.CreatePropertyRequest;
import com.google.analytics.admin.v1alpha.CreateUserLinkRequest;
import com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest;
import com.google.analytics.admin.v1alpha.DataSharingSettings;
import com.google.analytics.admin.v1alpha.DeleteAccountRequest;
import com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.DeletePropertyRequest;
import com.google.analytics.admin.v1alpha.DeleteUserLinkRequest;
import com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest;
import com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings;
import com.google.analytics.admin.v1alpha.FirebaseLink;
import com.google.analytics.admin.v1alpha.GetAccountRequest;
import com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest;
import com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest;
import com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest;
import com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.GetPropertyRequest;
import com.google.analytics.admin.v1alpha.GetUserLinkRequest;
import com.google.analytics.admin.v1alpha.GetWebDataStreamRequest;
import com.google.analytics.admin.v1alpha.GlobalSiteTag;
import com.google.analytics.admin.v1alpha.GoogleAdsLink;
import com.google.analytics.admin.v1alpha.IosAppDataStream;
import com.google.analytics.admin.v1alpha.ListAccountSummariesRequest;
import com.google.analytics.admin.v1alpha.ListAccountSummariesResponse;
import com.google.analytics.admin.v1alpha.ListAccountsRequest;
import com.google.analytics.admin.v1alpha.ListAccountsResponse;
import com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest;
import com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest;
import com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest;
import com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse;
import com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest;
import com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse;
import com.google.analytics.admin.v1alpha.ListPropertiesRequest;
import com.google.analytics.admin.v1alpha.ListPropertiesResponse;
import com.google.analytics.admin.v1alpha.ListUserLinksRequest;
import com.google.analytics.admin.v1alpha.ListUserLinksResponse;
import com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest;
import com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse;
import com.google.analytics.admin.v1alpha.Property;
import com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest;
import com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse;
import com.google.analytics.admin.v1alpha.UpdateAccountRequest;
import com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest;
import com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest;
import com.google.analytics.admin.v1alpha.UpdatePropertyRequest;
import com.google.analytics.admin.v1alpha.UpdateUserLinkRequest;
import com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest;
import com.google.analytics.admin.v1alpha.UserLink;
import com.google.analytics.admin.v1alpha.WebDataStream;
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

  public UnaryCallable<DeletePropertyRequest, Empty> deletePropertyCallable() {
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

  public UnaryCallable<GetWebDataStreamRequest, WebDataStream> getWebDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getWebDataStreamCallable()");
  }

  public UnaryCallable<DeleteWebDataStreamRequest, Empty> deleteWebDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWebDataStreamCallable()");
  }

  public UnaryCallable<UpdateWebDataStreamRequest, WebDataStream> updateWebDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWebDataStreamCallable()");
  }

  public UnaryCallable<CreateWebDataStreamRequest, WebDataStream> createWebDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createWebDataStreamCallable()");
  }

  public UnaryCallable<ListWebDataStreamsRequest, ListWebDataStreamsPagedResponse>
      listWebDataStreamsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWebDataStreamsPagedCallable()");
  }

  public UnaryCallable<ListWebDataStreamsRequest, ListWebDataStreamsResponse>
      listWebDataStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWebDataStreamsCallable()");
  }

  public UnaryCallable<GetIosAppDataStreamRequest, IosAppDataStream> getIosAppDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getIosAppDataStreamCallable()");
  }

  public UnaryCallable<DeleteIosAppDataStreamRequest, Empty> deleteIosAppDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIosAppDataStreamCallable()");
  }

  public UnaryCallable<UpdateIosAppDataStreamRequest, IosAppDataStream>
      updateIosAppDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIosAppDataStreamCallable()");
  }

  public UnaryCallable<CreateIosAppDataStreamRequest, IosAppDataStream>
      createIosAppDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createIosAppDataStreamCallable()");
  }

  public UnaryCallable<ListIosAppDataStreamsRequest, ListIosAppDataStreamsPagedResponse>
      listIosAppDataStreamsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listIosAppDataStreamsPagedCallable()");
  }

  public UnaryCallable<ListIosAppDataStreamsRequest, ListIosAppDataStreamsResponse>
      listIosAppDataStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIosAppDataStreamsCallable()");
  }

  public UnaryCallable<GetAndroidAppDataStreamRequest, AndroidAppDataStream>
      getAndroidAppDataStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getAndroidAppDataStreamCallable()");
  }

  public UnaryCallable<DeleteAndroidAppDataStreamRequest, Empty>
      deleteAndroidAppDataStreamCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAndroidAppDataStreamCallable()");
  }

  public UnaryCallable<UpdateAndroidAppDataStreamRequest, AndroidAppDataStream>
      updateAndroidAppDataStreamCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAndroidAppDataStreamCallable()");
  }

  public UnaryCallable<CreateAndroidAppDataStreamRequest, AndroidAppDataStream>
      createAndroidAppDataStreamCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAndroidAppDataStreamCallable()");
  }

  public UnaryCallable<ListAndroidAppDataStreamsRequest, ListAndroidAppDataStreamsPagedResponse>
      listAndroidAppDataStreamsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAndroidAppDataStreamsPagedCallable()");
  }

  public UnaryCallable<ListAndroidAppDataStreamsRequest, ListAndroidAppDataStreamsResponse>
      listAndroidAppDataStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAndroidAppDataStreamsCallable()");
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

  public UnaryCallable<CreateFirebaseLinkRequest, FirebaseLink> createFirebaseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createFirebaseLinkCallable()");
  }

  public UnaryCallable<UpdateFirebaseLinkRequest, FirebaseLink> updateFirebaseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFirebaseLinkCallable()");
  }

  public UnaryCallable<DeleteFirebaseLinkRequest, Empty> deleteFirebaseLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFirebaseLinkCallable()");
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

  @Override
  public abstract void close();
}
