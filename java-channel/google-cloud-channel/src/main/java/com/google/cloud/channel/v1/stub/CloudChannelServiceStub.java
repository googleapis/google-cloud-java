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

package com.google.cloud.channel.v1.stub;

import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerLinksPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListEntitlementsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListProductsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableSkusPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.channel.v1.ActivateEntitlementRequest;
import com.google.cloud.channel.v1.CancelEntitlementRequest;
import com.google.cloud.channel.v1.ChangeOfferRequest;
import com.google.cloud.channel.v1.ChangeParametersRequest;
import com.google.cloud.channel.v1.ChangeRenewalSettingsRequest;
import com.google.cloud.channel.v1.ChannelPartnerLink;
import com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest;
import com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse;
import com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest;
import com.google.cloud.channel.v1.CreateCustomerRequest;
import com.google.cloud.channel.v1.CreateEntitlementRequest;
import com.google.cloud.channel.v1.Customer;
import com.google.cloud.channel.v1.DeleteCustomerRequest;
import com.google.cloud.channel.v1.Entitlement;
import com.google.cloud.channel.v1.GetChannelPartnerLinkRequest;
import com.google.cloud.channel.v1.GetCustomerRequest;
import com.google.cloud.channel.v1.GetEntitlementRequest;
import com.google.cloud.channel.v1.ListChannelPartnerLinksRequest;
import com.google.cloud.channel.v1.ListChannelPartnerLinksResponse;
import com.google.cloud.channel.v1.ListCustomersRequest;
import com.google.cloud.channel.v1.ListCustomersResponse;
import com.google.cloud.channel.v1.ListEntitlementsRequest;
import com.google.cloud.channel.v1.ListEntitlementsResponse;
import com.google.cloud.channel.v1.ListOffersRequest;
import com.google.cloud.channel.v1.ListOffersResponse;
import com.google.cloud.channel.v1.ListProductsRequest;
import com.google.cloud.channel.v1.ListProductsResponse;
import com.google.cloud.channel.v1.ListPurchasableOffersRequest;
import com.google.cloud.channel.v1.ListPurchasableOffersResponse;
import com.google.cloud.channel.v1.ListPurchasableSkusRequest;
import com.google.cloud.channel.v1.ListPurchasableSkusResponse;
import com.google.cloud.channel.v1.ListSkusRequest;
import com.google.cloud.channel.v1.ListSkusResponse;
import com.google.cloud.channel.v1.ListTransferableOffersRequest;
import com.google.cloud.channel.v1.ListTransferableOffersResponse;
import com.google.cloud.channel.v1.ListTransferableSkusRequest;
import com.google.cloud.channel.v1.ListTransferableSkusResponse;
import com.google.cloud.channel.v1.OperationMetadata;
import com.google.cloud.channel.v1.ProvisionCloudIdentityRequest;
import com.google.cloud.channel.v1.StartPaidServiceRequest;
import com.google.cloud.channel.v1.SuspendEntitlementRequest;
import com.google.cloud.channel.v1.TransferEntitlementsRequest;
import com.google.cloud.channel.v1.TransferEntitlementsResponse;
import com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest;
import com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest;
import com.google.cloud.channel.v1.UpdateCustomerRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudChannelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudChannelServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomersPagedCallable()");
  }

  public UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomersCallable()");
  }

  public UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomerCallable()");
  }

  public UnaryCallable<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: checkCloudIdentityAccountsExistCallable()");
  }

  public UnaryCallable<CreateCustomerRequest, Customer> createCustomerCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomerCallable()");
  }

  public UnaryCallable<UpdateCustomerRequest, Customer> updateCustomerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomerCallable()");
  }

  public UnaryCallable<DeleteCustomerRequest, Empty> deleteCustomerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCustomerCallable()");
  }

  public OperationCallable<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
      provisionCloudIdentityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: provisionCloudIdentityOperationCallable()");
  }

  public UnaryCallable<ProvisionCloudIdentityRequest, Operation> provisionCloudIdentityCallable() {
    throw new UnsupportedOperationException("Not implemented: provisionCloudIdentityCallable()");
  }

  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitlementsPagedCallable()");
  }

  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitlementsCallable()");
  }

  public UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusPagedResponse>
      listTransferableSkusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferableSkusPagedCallable()");
  }

  public UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusResponse>
      listTransferableSkusCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferableSkusCallable()");
  }

  public UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersPagedResponse>
      listTransferableOffersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTransferableOffersPagedCallable()");
  }

  public UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferableOffersCallable()");
  }

  public UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntitlementCallable()");
  }

  public OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEntitlementOperationCallable()");
  }

  public UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntitlementCallable()");
  }

  public OperationCallable<ChangeParametersRequest, Entitlement, OperationMetadata>
      changeParametersOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: changeParametersOperationCallable()");
  }

  public UnaryCallable<ChangeParametersRequest, Operation> changeParametersCallable() {
    throw new UnsupportedOperationException("Not implemented: changeParametersCallable()");
  }

  public OperationCallable<ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
      changeRenewalSettingsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: changeRenewalSettingsOperationCallable()");
  }

  public UnaryCallable<ChangeRenewalSettingsRequest, Operation> changeRenewalSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: changeRenewalSettingsCallable()");
  }

  public OperationCallable<ChangeOfferRequest, Entitlement, OperationMetadata>
      changeOfferOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: changeOfferOperationCallable()");
  }

  public UnaryCallable<ChangeOfferRequest, Operation> changeOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: changeOfferCallable()");
  }

  public OperationCallable<StartPaidServiceRequest, Entitlement, OperationMetadata>
      startPaidServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startPaidServiceOperationCallable()");
  }

  public UnaryCallable<StartPaidServiceRequest, Operation> startPaidServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: startPaidServiceCallable()");
  }

  public OperationCallable<SuspendEntitlementRequest, Entitlement, OperationMetadata>
      suspendEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: suspendEntitlementOperationCallable()");
  }

  public UnaryCallable<SuspendEntitlementRequest, Operation> suspendEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: suspendEntitlementCallable()");
  }

  public OperationCallable<CancelEntitlementRequest, Empty, OperationMetadata>
      cancelEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cancelEntitlementOperationCallable()");
  }

  public UnaryCallable<CancelEntitlementRequest, Operation> cancelEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelEntitlementCallable()");
  }

  public OperationCallable<ActivateEntitlementRequest, Entitlement, OperationMetadata>
      activateEntitlementOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: activateEntitlementOperationCallable()");
  }

  public UnaryCallable<ActivateEntitlementRequest, Operation> activateEntitlementCallable() {
    throw new UnsupportedOperationException("Not implemented: activateEntitlementCallable()");
  }

  public OperationCallable<
          TransferEntitlementsRequest, TransferEntitlementsResponse, OperationMetadata>
      transferEntitlementsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: transferEntitlementsOperationCallable()");
  }

  public UnaryCallable<TransferEntitlementsRequest, Operation> transferEntitlementsCallable() {
    throw new UnsupportedOperationException("Not implemented: transferEntitlementsCallable()");
  }

  public OperationCallable<TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
      transferEntitlementsToGoogleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: transferEntitlementsToGoogleOperationCallable()");
  }

  public UnaryCallable<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: transferEntitlementsToGoogleCallable()");
  }

  public UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksPagedResponse>
      listChannelPartnerLinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listChannelPartnerLinksPagedCallable()");
  }

  public UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listChannelPartnerLinksCallable()");
  }

  public UnaryCallable<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getChannelPartnerLinkCallable()");
  }

  public UnaryCallable<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createChannelPartnerLinkCallable()");
  }

  public UnaryCallable<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChannelPartnerLinkCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsPagedCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusPagedCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusCallable()");
  }

  public UnaryCallable<ListOffersRequest, ListOffersPagedResponse> listOffersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOffersPagedCallable()");
  }

  public UnaryCallable<ListOffersRequest, ListOffersResponse> listOffersCallable() {
    throw new UnsupportedOperationException("Not implemented: listOffersCallable()");
  }

  public UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusPagedResponse>
      listPurchasableSkusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPurchasableSkusPagedCallable()");
  }

  public UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusCallable() {
    throw new UnsupportedOperationException("Not implemented: listPurchasableSkusCallable()");
  }

  public UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersPagedResponse>
      listPurchasableOffersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPurchasableOffersPagedCallable()");
  }

  public UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersCallable() {
    throw new UnsupportedOperationException("Not implemented: listPurchasableOffersCallable()");
  }

  @Override
  public abstract void close();
}
