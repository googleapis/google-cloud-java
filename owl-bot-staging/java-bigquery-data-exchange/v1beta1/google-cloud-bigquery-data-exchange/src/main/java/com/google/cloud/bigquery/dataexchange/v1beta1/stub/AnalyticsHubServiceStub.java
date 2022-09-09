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

package com.google.cloud.bigquery.dataexchange.v1beta1.stub;

import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.dataexchange.v1beta1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.CreateListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.DataExchange;
import com.google.cloud.bigquery.dataexchange.v1beta1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.DeleteListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.GetDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.GetListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListDataExchangesRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListDataExchangesResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListListingsRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListListingsResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.Listing;
import com.google.cloud.bigquery.dataexchange.v1beta1.SubscribeListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.SubscribeListingResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.UpdateListingRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AnalyticsHubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AnalyticsHubServiceStub implements BackgroundResource {

  public UnaryCallable<ListDataExchangesRequest, ListDataExchangesPagedResponse>
      listDataExchangesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataExchangesPagedCallable()");
  }

  public UnaryCallable<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataExchangesCallable()");
  }

  public UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrgDataExchangesPagedCallable()");
  }

  public UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
      listOrgDataExchangesCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrgDataExchangesCallable()");
  }

  public UnaryCallable<GetDataExchangeRequest, DataExchange> getDataExchangeCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataExchangeCallable()");
  }

  public UnaryCallable<CreateDataExchangeRequest, DataExchange> createDataExchangeCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataExchangeCallable()");
  }

  public UnaryCallable<UpdateDataExchangeRequest, DataExchange> updateDataExchangeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataExchangeCallable()");
  }

  public UnaryCallable<DeleteDataExchangeRequest, Empty> deleteDataExchangeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataExchangeCallable()");
  }

  public UnaryCallable<ListListingsRequest, ListListingsPagedResponse> listListingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listListingsPagedCallable()");
  }

  public UnaryCallable<ListListingsRequest, ListListingsResponse> listListingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listListingsCallable()");
  }

  public UnaryCallable<GetListingRequest, Listing> getListingCallable() {
    throw new UnsupportedOperationException("Not implemented: getListingCallable()");
  }

  public UnaryCallable<CreateListingRequest, Listing> createListingCallable() {
    throw new UnsupportedOperationException("Not implemented: createListingCallable()");
  }

  public UnaryCallable<UpdateListingRequest, Listing> updateListingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateListingCallable()");
  }

  public UnaryCallable<DeleteListingRequest, Empty> deleteListingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteListingCallable()");
  }

  public UnaryCallable<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingCallable() {
    throw new UnsupportedOperationException("Not implemented: subscribeListingCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
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
