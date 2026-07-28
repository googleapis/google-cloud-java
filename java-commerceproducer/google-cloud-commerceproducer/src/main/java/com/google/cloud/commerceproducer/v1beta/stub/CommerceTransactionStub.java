/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.commerceproducer.v1beta.stub;

import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListLocationsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOfferDocumentsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOffersPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListServicesPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkuGroupsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkusPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListStandardOffersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.GetServiceRequest;
import com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest;
import com.google.cloud.commerceproducer.v1beta.GetSkuRequest;
import com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse;
import com.google.cloud.commerceproducer.v1beta.ListServicesRequest;
import com.google.cloud.commerceproducer.v1beta.ListServicesResponse;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse;
import com.google.cloud.commerceproducer.v1beta.ListSkusRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkusResponse;
import com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest;
import com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse;
import com.google.cloud.commerceproducer.v1beta.PrivateOffer;
import com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument;
import com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest;
import com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse;
import com.google.cloud.commerceproducer.v1beta.Service;
import com.google.cloud.commerceproducer.v1beta.Sku;
import com.google.cloud.commerceproducer.v1beta.SkuGroup;
import com.google.cloud.commerceproducer.v1beta.StandardOffer;
import com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CommerceTransaction service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CommerceTransactionStub implements BackgroundResource {

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersPagedResponse>
      listPrivateOffersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateOffersPagedCallable()");
  }

  public UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersResponse>
      listPrivateOffersCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateOffersCallable()");
  }

  public UnaryCallable<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateOfferCallable()");
  }

  public UnaryCallable<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
      resolveAmendmentTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: resolveAmendmentTargetCallable()");
  }

  public UnaryCallable<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateOfferCallable()");
  }

  public UnaryCallable<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePrivateOfferCallable()");
  }

  public UnaryCallable<PublishPrivateOfferRequest, PrivateOffer> publishPrivateOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: publishPrivateOfferCallable()");
  }

  public UnaryCallable<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelPrivateOfferCallable()");
  }

  public UnaryCallable<DeletePrivateOfferRequest, Empty> deletePrivateOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePrivateOfferCallable()");
  }

  public UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateOfferDocumentsPagedCallable()");
  }

  public UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
      listPrivateOfferDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateOfferDocumentsCallable()");
  }

  public UnaryCallable<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateOfferDocumentCallable()");
  }

  public UnaryCallable<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrivateOfferDocumentCallable()");
  }

  public UnaryCallable<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePrivateOfferDocumentCallable()");
  }

  public UnaryCallable<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrivateOfferDocumentCallable()");
  }

  public UnaryCallable<ListStandardOffersRequest, ListStandardOffersPagedResponse>
      listStandardOffersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listStandardOffersPagedCallable()");
  }

  public UnaryCallable<ListStandardOffersRequest, ListStandardOffersResponse>
      listStandardOffersCallable() {
    throw new UnsupportedOperationException("Not implemented: listStandardOffersCallable()");
  }

  public UnaryCallable<GetStandardOfferRequest, StandardOffer> getStandardOfferCallable() {
    throw new UnsupportedOperationException("Not implemented: getStandardOfferCallable()");
  }

  public UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    throw new UnsupportedOperationException("Not implemented: getSkuCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusPagedCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusCallable()");
  }

  public UnaryCallable<GetSkuGroupRequest, SkuGroup> getSkuGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getSkuGroupCallable()");
  }

  public UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsPagedResponse>
      listSkuGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkuGroupsPagedCallable()");
  }

  public UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsResponse> listSkuGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkuGroupsCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
