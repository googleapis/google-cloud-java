/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.analyticshub.v1.stub;

import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSharedResourceSubscriptionsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DataExchange;
import com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse;
import com.google.cloud.bigquery.analyticshub.v1.Listing;
import com.google.cloud.bigquery.analyticshub.v1.OperationMetadata;
import com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionResponse;
import com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeResponse;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse;
import com.google.cloud.bigquery.analyticshub.v1.Subscription;
import com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AnalyticsHubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AnalyticsHubServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

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

  public OperationCallable<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: subscribeDataExchangeOperationCallable()");
  }

  public UnaryCallable<SubscribeDataExchangeRequest, Operation> subscribeDataExchangeCallable() {
    throw new UnsupportedOperationException("Not implemented: subscribeDataExchangeCallable()");
  }

  public OperationCallable<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: refreshSubscriptionOperationCallable()");
  }

  public UnaryCallable<RefreshSubscriptionRequest, Operation> refreshSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: refreshSubscriptionCallable()");
  }

  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSubscriptionCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsCallable()");
  }

  public UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSharedResourceSubscriptionsPagedCallable()");
  }

  public UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
      listSharedResourceSubscriptionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSharedResourceSubscriptionsCallable()");
  }

  public UnaryCallable<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: revokeSubscriptionCallable()");
  }

  public OperationCallable<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSubscriptionOperationCallable()");
  }

  public UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubscriptionCallable()");
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

  @Override
  public abstract void close();
}
