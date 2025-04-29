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

package com.google.cloud.bigquery.analyticshub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.bigquery.analyticshub.v1.stub.AnalyticsHubServiceStub;
import com.google.cloud.bigquery.analyticshub.v1.stub.AnalyticsHubServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The `AnalyticsHubService` API facilitates data sharing within and across
 * organizations. It allows data providers to publish listings that reference shared datasets. With
 * Analytics Hub, users can discover and search for listings that they have access to. Subscribers
 * can view and subscribe to listings. When you subscribe to a listing, Analytics Hub creates a
 * linked dataset in your project.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
 *   DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
 *   DataExchange response = analyticsHubServiceClient.getDataExchange(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AnalyticsHubServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataExchanges</td>
 *      <td><p> Lists all data exchanges in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataExchanges(ListDataExchangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataExchanges(LocationName parent)
 *           <li><p> listDataExchanges(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataExchangesPagedCallable()
 *           <li><p> listDataExchangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOrgDataExchanges</td>
 *      <td><p> Lists all data exchanges from projects in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrgDataExchanges(ListOrgDataExchangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOrgDataExchanges(String organization)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrgDataExchangesPagedCallable()
 *           <li><p> listOrgDataExchangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataExchange</td>
 *      <td><p> Gets the details of a data exchange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataExchange(GetDataExchangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataExchange(DataExchangeName name)
 *           <li><p> getDataExchange(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataExchangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataExchange</td>
 *      <td><p> Creates a new data exchange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataExchange(CreateDataExchangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataExchange(LocationName parent, DataExchange dataExchange)
 *           <li><p> createDataExchange(String parent, DataExchange dataExchange)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataExchangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataExchange</td>
 *      <td><p> Updates an existing data exchange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataExchange(UpdateDataExchangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataExchange(DataExchange dataExchange, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataExchangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataExchange</td>
 *      <td><p> Deletes an existing data exchange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataExchange(DeleteDataExchangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataExchange(DataExchangeName name)
 *           <li><p> deleteDataExchange(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataExchangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListListings</td>
 *      <td><p> Lists all listings in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listListings(ListListingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listListings(DataExchangeName parent)
 *           <li><p> listListings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listListingsPagedCallable()
 *           <li><p> listListingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetListing</td>
 *      <td><p> Gets the details of a listing.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getListing(GetListingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getListing(ListingName name)
 *           <li><p> getListing(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getListingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateListing</td>
 *      <td><p> Creates a new listing.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createListing(CreateListingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createListing(DataExchangeName parent, Listing listing)
 *           <li><p> createListing(String parent, Listing listing)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createListingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateListing</td>
 *      <td><p> Updates an existing listing.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateListing(UpdateListingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateListing(Listing listing, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateListingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteListing</td>
 *      <td><p> Deletes a listing.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteListing(DeleteListingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteListing(ListingName name)
 *           <li><p> deleteListing(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteListingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SubscribeListing</td>
 *      <td><p> Subscribes to a listing.
 * <p>  Currently, with Analytics Hub, you can create listings that reference only BigQuery datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked dataset in the subscriber's project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> subscribeListing(SubscribeListingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> subscribeListing(ListingName name)
 *           <li><p> subscribeListing(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> subscribeListingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SubscribeDataExchange</td>
 *      <td><p> Creates a Subscription to a Data Clean Room. This is a long-running operation as it will create one or more linked datasets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> subscribeDataExchangeAsync(SubscribeDataExchangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> subscribeDataExchangeAsync(DataExchangeName name)
 *           <li><p> subscribeDataExchangeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> subscribeDataExchangeOperationCallable()
 *           <li><p> subscribeDataExchangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RefreshSubscription</td>
 *      <td><p> Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher adds or removes data. This is a long-running operation as it may create many linked datasets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> refreshSubscriptionAsync(RefreshSubscriptionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> refreshSubscriptionAsync(SubscriptionName name)
 *           <li><p> refreshSubscriptionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> refreshSubscriptionOperationCallable()
 *           <li><p> refreshSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSubscription</td>
 *      <td><p> Gets the details of a Subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSubscription(GetSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSubscription(SubscriptionName name)
 *           <li><p> getSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubscriptions</td>
 *      <td><p> Lists all subscriptions in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubscriptions(ListSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubscriptions(LocationName parent)
 *           <li><p> listSubscriptions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubscriptionsPagedCallable()
 *           <li><p> listSubscriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSharedResourceSubscriptions</td>
 *      <td><p> Lists all subscriptions on a given Data Exchange or Listing.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSharedResourceSubscriptions(ListSharedResourceSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSharedResourceSubscriptions(ResourceName resource)
 *           <li><p> listSharedResourceSubscriptions(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSharedResourceSubscriptionsPagedCallable()
 *           <li><p> listSharedResourceSubscriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RevokeSubscription</td>
 *      <td><p> Revokes a given subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> revokeSubscription(RevokeSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> revokeSubscription(SubscriptionName name)
 *           <li><p> revokeSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> revokeSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSubscription</td>
 *      <td><p> Deletes a subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSubscriptionAsync(DeleteSubscriptionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSubscriptionAsync(SubscriptionName name)
 *           <li><p> deleteSubscriptionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSubscriptionOperationCallable()
 *           <li><p> deleteSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the IAM policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns the permissions that a caller has.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AnalyticsHubServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AnalyticsHubServiceSettings analyticsHubServiceSettings =
 *     AnalyticsHubServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AnalyticsHubServiceClient analyticsHubServiceClient =
 *     AnalyticsHubServiceClient.create(analyticsHubServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AnalyticsHubServiceSettings analyticsHubServiceSettings =
 *     AnalyticsHubServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AnalyticsHubServiceClient analyticsHubServiceClient =
 *     AnalyticsHubServiceClient.create(analyticsHubServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AnalyticsHubServiceSettings analyticsHubServiceSettings =
 *     AnalyticsHubServiceSettings.newHttpJsonBuilder().build();
 * AnalyticsHubServiceClient analyticsHubServiceClient =
 *     AnalyticsHubServiceClient.create(analyticsHubServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AnalyticsHubServiceClient implements BackgroundResource {
  private final AnalyticsHubServiceSettings settings;
  private final AnalyticsHubServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AnalyticsHubServiceClient with default settings. */
  public static final AnalyticsHubServiceClient create() throws IOException {
    return create(AnalyticsHubServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AnalyticsHubServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AnalyticsHubServiceClient create(AnalyticsHubServiceSettings settings)
      throws IOException {
    return new AnalyticsHubServiceClient(settings);
  }

  /**
   * Constructs an instance of AnalyticsHubServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AnalyticsHubServiceSettings).
   */
  public static final AnalyticsHubServiceClient create(AnalyticsHubServiceStub stub) {
    return new AnalyticsHubServiceClient(stub);
  }

  /**
   * Constructs an instance of AnalyticsHubServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AnalyticsHubServiceClient(AnalyticsHubServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AnalyticsHubServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AnalyticsHubServiceClient(AnalyticsHubServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AnalyticsHubServiceSettings getSettings() {
    return settings;
  }

  public AnalyticsHubServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataExchange element :
   *       analyticsHubServiceClient.listDataExchanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the data exchanges. e.g.
   *     `projects/myproject/locations/US`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataExchangesPagedResponse listDataExchanges(LocationName parent) {
    ListDataExchangesRequest request =
        ListDataExchangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataExchanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataExchange element :
   *       analyticsHubServiceClient.listDataExchanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the data exchanges. e.g.
   *     `projects/myproject/locations/US`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataExchangesPagedResponse listDataExchanges(String parent) {
    ListDataExchangesRequest request =
        ListDataExchangesRequest.newBuilder().setParent(parent).build();
    return listDataExchanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListDataExchangesRequest request =
   *       ListDataExchangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataExchange element :
   *       analyticsHubServiceClient.listDataExchanges(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataExchangesPagedResponse listDataExchanges(ListDataExchangesRequest request) {
    return listDataExchangesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListDataExchangesRequest request =
   *       ListDataExchangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataExchange> future =
   *       analyticsHubServiceClient.listDataExchangesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataExchange element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataExchangesRequest, ListDataExchangesPagedResponse>
      listDataExchangesPagedCallable() {
    return stub.listDataExchangesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListDataExchangesRequest request =
   *       ListDataExchangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDataExchangesResponse response =
   *         analyticsHubServiceClient.listDataExchangesCallable().call(request);
   *     for (DataExchange element : response.getDataExchangesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesCallable() {
    return stub.listDataExchangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges from projects in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String organization = "organization1178922291";
   *   for (DataExchange element :
   *       analyticsHubServiceClient.listOrgDataExchanges(organization).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param organization Required. The organization resource path of the projects containing
   *     DataExchanges. e.g. `organizations/myorg/locations/US`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgDataExchangesPagedResponse listOrgDataExchanges(String organization) {
    ListOrgDataExchangesRequest request =
        ListOrgDataExchangesRequest.newBuilder().setOrganization(organization).build();
    return listOrgDataExchanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges from projects in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListOrgDataExchangesRequest request =
   *       ListOrgDataExchangesRequest.newBuilder()
   *           .setOrganization("organization1178922291")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataExchange element :
   *       analyticsHubServiceClient.listOrgDataExchanges(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgDataExchangesPagedResponse listOrgDataExchanges(
      ListOrgDataExchangesRequest request) {
    return listOrgDataExchangesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges from projects in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListOrgDataExchangesRequest request =
   *       ListOrgDataExchangesRequest.newBuilder()
   *           .setOrganization("organization1178922291")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataExchange> future =
   *       analyticsHubServiceClient.listOrgDataExchangesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataExchange element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesPagedCallable() {
    return stub.listOrgDataExchangesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data exchanges from projects in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListOrgDataExchangesRequest request =
   *       ListOrgDataExchangesRequest.newBuilder()
   *           .setOrganization("organization1178922291")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOrgDataExchangesResponse response =
   *         analyticsHubServiceClient.listOrgDataExchangesCallable().call(request);
   *     for (DataExchange element : response.getDataExchangesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
      listOrgDataExchangesCallable() {
    return stub.listOrgDataExchangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
   *   DataExchange response = analyticsHubServiceClient.getDataExchange(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data exchange. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange getDataExchange(DataExchangeName name) {
    GetDataExchangeRequest request =
        GetDataExchangeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString();
   *   DataExchange response = analyticsHubServiceClient.getDataExchange(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data exchange. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange getDataExchange(String name) {
    GetDataExchangeRequest request = GetDataExchangeRequest.newBuilder().setName(name).build();
    return getDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetDataExchangeRequest request =
   *       GetDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .build();
   *   DataExchange response = analyticsHubServiceClient.getDataExchange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange getDataExchange(GetDataExchangeRequest request) {
    return getDataExchangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetDataExchangeRequest request =
   *       GetDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .build();
   *   ApiFuture<DataExchange> future =
   *       analyticsHubServiceClient.getDataExchangeCallable().futureCall(request);
   *   // Do something.
   *   DataExchange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataExchangeRequest, DataExchange> getDataExchangeCallable() {
    return stub.getDataExchangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataExchange dataExchange = DataExchange.newBuilder().build();
   *   DataExchange response = analyticsHubServiceClient.createDataExchange(parent, dataExchange);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the data exchange. e.g.
   *     `projects/myproject/locations/US`.
   * @param dataExchange Required. The data exchange to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange createDataExchange(LocationName parent, DataExchange dataExchange) {
    CreateDataExchangeRequest request =
        CreateDataExchangeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataExchange(dataExchange)
            .build();
    return createDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataExchange dataExchange = DataExchange.newBuilder().build();
   *   DataExchange response = analyticsHubServiceClient.createDataExchange(parent, dataExchange);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the data exchange. e.g.
   *     `projects/myproject/locations/US`.
   * @param dataExchange Required. The data exchange to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange createDataExchange(String parent, DataExchange dataExchange) {
    CreateDataExchangeRequest request =
        CreateDataExchangeRequest.newBuilder()
            .setParent(parent)
            .setDataExchange(dataExchange)
            .build();
    return createDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   CreateDataExchangeRequest request =
   *       CreateDataExchangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataExchangeId("dataExchangeId783243752")
   *           .setDataExchange(DataExchange.newBuilder().build())
   *           .build();
   *   DataExchange response = analyticsHubServiceClient.createDataExchange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange createDataExchange(CreateDataExchangeRequest request) {
    return createDataExchangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   CreateDataExchangeRequest request =
   *       CreateDataExchangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataExchangeId("dataExchangeId783243752")
   *           .setDataExchange(DataExchange.newBuilder().build())
   *           .build();
   *   ApiFuture<DataExchange> future =
   *       analyticsHubServiceClient.createDataExchangeCallable().futureCall(request);
   *   // Do something.
   *   DataExchange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataExchangeRequest, DataExchange> createDataExchangeCallable() {
    return stub.createDataExchangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DataExchange dataExchange = DataExchange.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataExchange response =
   *       analyticsHubServiceClient.updateDataExchange(dataExchange, updateMask);
   * }
   * }</pre>
   *
   * @param dataExchange Required. The data exchange to update.
   * @param updateMask Required. Field mask specifies the fields to update in the data exchange
   *     resource. The fields specified in the `updateMask` are relative to the resource and are not
   *     a full request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange updateDataExchange(DataExchange dataExchange, FieldMask updateMask) {
    UpdateDataExchangeRequest request =
        UpdateDataExchangeRequest.newBuilder()
            .setDataExchange(dataExchange)
            .setUpdateMask(updateMask)
            .build();
    return updateDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   UpdateDataExchangeRequest request =
   *       UpdateDataExchangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataExchange(DataExchange.newBuilder().build())
   *           .build();
   *   DataExchange response = analyticsHubServiceClient.updateDataExchange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataExchange updateDataExchange(UpdateDataExchangeRequest request) {
    return updateDataExchangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   UpdateDataExchangeRequest request =
   *       UpdateDataExchangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataExchange(DataExchange.newBuilder().build())
   *           .build();
   *   ApiFuture<DataExchange> future =
   *       analyticsHubServiceClient.updateDataExchangeCallable().futureCall(request);
   *   // Do something.
   *   DataExchange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataExchangeRequest, DataExchange> updateDataExchangeCallable() {
    return stub.updateDataExchangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
   *   analyticsHubServiceClient.deleteDataExchange(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the data exchange resource that you want to delete. For
   *     example, `projects/myproject/locations/US/dataExchanges/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataExchange(DataExchangeName name) {
    DeleteDataExchangeRequest request =
        DeleteDataExchangeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString();
   *   analyticsHubServiceClient.deleteDataExchange(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the data exchange resource that you want to delete. For
   *     example, `projects/myproject/locations/US/dataExchanges/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataExchange(String name) {
    DeleteDataExchangeRequest request =
        DeleteDataExchangeRequest.newBuilder().setName(name).build();
    deleteDataExchange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteDataExchangeRequest request =
   *       DeleteDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .build();
   *   analyticsHubServiceClient.deleteDataExchange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataExchange(DeleteDataExchangeRequest request) {
    deleteDataExchangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing data exchange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteDataExchangeRequest request =
   *       DeleteDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsHubServiceClient.deleteDataExchangeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataExchangeRequest, Empty> deleteDataExchangeCallable() {
    return stub.deleteDataExchangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all listings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
   *   for (Listing element : analyticsHubServiceClient.listListings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the listing. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListListingsPagedResponse listListings(DataExchangeName parent) {
    ListListingsRequest request =
        ListListingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listListings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all listings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString();
   *   for (Listing element : analyticsHubServiceClient.listListings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the listing. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListListingsPagedResponse listListings(String parent) {
    ListListingsRequest request = ListListingsRequest.newBuilder().setParent(parent).build();
    return listListings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all listings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListListingsRequest request =
   *       ListListingsRequest.newBuilder()
   *           .setParent(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Listing element : analyticsHubServiceClient.listListings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListListingsPagedResponse listListings(ListListingsRequest request) {
    return listListingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all listings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListListingsRequest request =
   *       ListListingsRequest.newBuilder()
   *           .setParent(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Listing> future =
   *       analyticsHubServiceClient.listListingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Listing element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListListingsRequest, ListListingsPagedResponse>
      listListingsPagedCallable() {
    return stub.listListingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all listings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListListingsRequest request =
   *       ListListingsRequest.newBuilder()
   *           .setParent(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListListingsResponse response =
   *         analyticsHubServiceClient.listListingsCallable().call(request);
   *     for (Listing element : response.getListingsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListListingsRequest, ListListingsResponse> listListingsCallable() {
    return stub.listListingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");
   *   Listing response = analyticsHubServiceClient.getListing(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the listing. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123/listings/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing getListing(ListingName name) {
    GetListingRequest request =
        GetListingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name =
   *       ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]").toString();
   *   Listing response = analyticsHubServiceClient.getListing(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the listing. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123/listings/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing getListing(String name) {
    GetListingRequest request = GetListingRequest.newBuilder().setName(name).build();
    return getListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetListingRequest request =
   *       GetListingRequest.newBuilder()
   *           .setName(
   *               ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
   *                   .toString())
   *           .build();
   *   Listing response = analyticsHubServiceClient.getListing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing getListing(GetListingRequest request) {
    return getListingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetListingRequest request =
   *       GetListingRequest.newBuilder()
   *           .setName(
   *               ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Listing> future =
   *       analyticsHubServiceClient.getListingCallable().futureCall(request);
   *   // Do something.
   *   Listing response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetListingRequest, Listing> getListingCallable() {
    return stub.getListingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DataExchangeName parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
   *   Listing listing = Listing.newBuilder().build();
   *   Listing response = analyticsHubServiceClient.createListing(parent, listing);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the listing. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123`.
   * @param listing Required. The listing to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing createListing(DataExchangeName parent, Listing listing) {
    CreateListingRequest request =
        CreateListingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setListing(listing)
            .build();
    return createListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String parent = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString();
   *   Listing listing = Listing.newBuilder().build();
   *   Listing response = analyticsHubServiceClient.createListing(parent, listing);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the listing. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123`.
   * @param listing Required. The listing to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing createListing(String parent, Listing listing) {
    CreateListingRequest request =
        CreateListingRequest.newBuilder().setParent(parent).setListing(listing).build();
    return createListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   CreateListingRequest request =
   *       CreateListingRequest.newBuilder()
   *           .setParent(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setListingId("listingId-1215024449")
   *           .setListing(Listing.newBuilder().build())
   *           .build();
   *   Listing response = analyticsHubServiceClient.createListing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing createListing(CreateListingRequest request) {
    return createListingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   CreateListingRequest request =
   *       CreateListingRequest.newBuilder()
   *           .setParent(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setListingId("listingId-1215024449")
   *           .setListing(Listing.newBuilder().build())
   *           .build();
   *   ApiFuture<Listing> future =
   *       analyticsHubServiceClient.createListingCallable().futureCall(request);
   *   // Do something.
   *   Listing response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateListingRequest, Listing> createListingCallable() {
    return stub.createListingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   Listing listing = Listing.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Listing response = analyticsHubServiceClient.updateListing(listing, updateMask);
   * }
   * }</pre>
   *
   * @param listing Required. The listing to update.
   * @param updateMask Required. Field mask specifies the fields to update in the listing resource.
   *     The fields specified in the `updateMask` are relative to the resource and are not a full
   *     request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing updateListing(Listing listing, FieldMask updateMask) {
    UpdateListingRequest request =
        UpdateListingRequest.newBuilder().setListing(listing).setUpdateMask(updateMask).build();
    return updateListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   UpdateListingRequest request =
   *       UpdateListingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setListing(Listing.newBuilder().build())
   *           .build();
   *   Listing response = analyticsHubServiceClient.updateListing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Listing updateListing(UpdateListingRequest request) {
    return updateListingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   UpdateListingRequest request =
   *       UpdateListingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setListing(Listing.newBuilder().build())
   *           .build();
   *   ApiFuture<Listing> future =
   *       analyticsHubServiceClient.updateListingCallable().futureCall(request);
   *   // Do something.
   *   Listing response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateListingRequest, Listing> updateListingCallable() {
    return stub.updateListingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");
   *   analyticsHubServiceClient.deleteListing(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the listing to delete. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123/listings/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteListing(ListingName name) {
    DeleteListingRequest request =
        DeleteListingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name =
   *       ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]").toString();
   *   analyticsHubServiceClient.deleteListing(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the listing to delete. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123/listings/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteListing(String name) {
    DeleteListingRequest request = DeleteListingRequest.newBuilder().setName(name).build();
    deleteListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteListingRequest request =
   *       DeleteListingRequest.newBuilder()
   *           .setName(
   *               ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
   *                   .toString())
   *           .build();
   *   analyticsHubServiceClient.deleteListing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteListing(DeleteListingRequest request) {
    deleteListingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteListingRequest request =
   *       DeleteListingRequest.newBuilder()
   *           .setName(
   *               ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       analyticsHubServiceClient.deleteListingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteListingRequest, Empty> deleteListingCallable() {
    return stub.deleteListingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Subscribes to a listing.
   *
   * <p>Currently, with Analytics Hub, you can create listings that reference only BigQuery
   * datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked
   * dataset in the subscriber's project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListingName name = ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]");
   *   SubscribeListingResponse response = analyticsHubServiceClient.subscribeListing(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the listing that you want to subscribe to. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123/listings/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubscribeListingResponse subscribeListing(ListingName name) {
    SubscribeListingRequest request =
        SubscribeListingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return subscribeListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Subscribes to a listing.
   *
   * <p>Currently, with Analytics Hub, you can create listings that reference only BigQuery
   * datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked
   * dataset in the subscriber's project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name =
   *       ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]").toString();
   *   SubscribeListingResponse response = analyticsHubServiceClient.subscribeListing(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the listing that you want to subscribe to. e.g.
   *     `projects/myproject/locations/US/dataExchanges/123/listings/456`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubscribeListingResponse subscribeListing(String name) {
    SubscribeListingRequest request = SubscribeListingRequest.newBuilder().setName(name).build();
    return subscribeListing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Subscribes to a listing.
   *
   * <p>Currently, with Analytics Hub, you can create listings that reference only BigQuery
   * datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked
   * dataset in the subscriber's project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscribeListingRequest request =
   *       SubscribeListingRequest.newBuilder()
   *           .setName(
   *               ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
   *                   .toString())
   *           .build();
   *   SubscribeListingResponse response = analyticsHubServiceClient.subscribeListing(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubscribeListingResponse subscribeListing(SubscribeListingRequest request) {
    return subscribeListingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Subscribes to a listing.
   *
   * <p>Currently, with Analytics Hub, you can create listings that reference only BigQuery
   * datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked
   * dataset in the subscriber's project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscribeListingRequest request =
   *       SubscribeListingRequest.newBuilder()
   *           .setName(
   *               ListingName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]", "[LISTING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SubscribeListingResponse> future =
   *       analyticsHubServiceClient.subscribeListingCallable().futureCall(request);
   *   // Do something.
   *   SubscribeListingResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingCallable() {
    return stub.subscribeListingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Subscription to a Data Clean Room. This is a long-running operation as it will create
   * one or more linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DataExchangeName name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
   *   SubscribeDataExchangeResponse response =
   *       analyticsHubServiceClient.subscribeDataExchangeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the Data Exchange. e.g.
   *     `projects/publisherproject/locations/US/dataExchanges/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeAsync(DataExchangeName name) {
    SubscribeDataExchangeRequest request =
        SubscribeDataExchangeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return subscribeDataExchangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Subscription to a Data Clean Room. This is a long-running operation as it will create
   * one or more linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString();
   *   SubscribeDataExchangeResponse response =
   *       analyticsHubServiceClient.subscribeDataExchangeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the Data Exchange. e.g.
   *     `projects/publisherproject/locations/US/dataExchanges/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeAsync(String name) {
    SubscribeDataExchangeRequest request =
        SubscribeDataExchangeRequest.newBuilder().setName(name).build();
    return subscribeDataExchangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Subscription to a Data Clean Room. This is a long-running operation as it will create
   * one or more linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscribeDataExchangeRequest request =
   *       SubscribeDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDestinationDataset(DestinationDataset.newBuilder().build())
   *           .setSubscription("subscription341203229")
   *           .setSubscriberContact("subscriberContact-847205736")
   *           .build();
   *   SubscribeDataExchangeResponse response =
   *       analyticsHubServiceClient.subscribeDataExchangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeAsync(SubscribeDataExchangeRequest request) {
    return subscribeDataExchangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Subscription to a Data Clean Room. This is a long-running operation as it will create
   * one or more linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscribeDataExchangeRequest request =
   *       SubscribeDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDestinationDataset(DestinationDataset.newBuilder().build())
   *           .setSubscription("subscription341203229")
   *           .setSubscriberContact("subscriberContact-847205736")
   *           .build();
   *   OperationFuture<SubscribeDataExchangeResponse, OperationMetadata> future =
   *       analyticsHubServiceClient.subscribeDataExchangeOperationCallable().futureCall(request);
   *   // Do something.
   *   SubscribeDataExchangeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationCallable() {
    return stub.subscribeDataExchangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Subscription to a Data Clean Room. This is a long-running operation as it will create
   * one or more linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscribeDataExchangeRequest request =
   *       SubscribeDataExchangeRequest.newBuilder()
   *           .setName(DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDestinationDataset(DestinationDataset.newBuilder().build())
   *           .setSubscription("subscription341203229")
   *           .setSubscriberContact("subscriberContact-847205736")
   *           .build();
   *   ApiFuture<Operation> future =
   *       analyticsHubServiceClient.subscribeDataExchangeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubscribeDataExchangeRequest, Operation>
      subscribeDataExchangeCallable() {
    return stub.subscribeDataExchangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher
   * adds or removes data. This is a long-running operation as it may create many linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
   *   RefreshSubscriptionResponse response =
   *       analyticsHubServiceClient.refreshSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the Subscription to refresh. e.g.
   *     `projects/subscriberproject/locations/US/subscriptions/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionAsync(SubscriptionName name) {
    RefreshSubscriptionRequest request =
        RefreshSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return refreshSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher
   * adds or removes data. This is a long-running operation as it may create many linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString();
   *   RefreshSubscriptionResponse response =
   *       analyticsHubServiceClient.refreshSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the Subscription to refresh. e.g.
   *     `projects/subscriberproject/locations/US/subscriptions/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionAsync(String name) {
    RefreshSubscriptionRequest request =
        RefreshSubscriptionRequest.newBuilder().setName(name).build();
    return refreshSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher
   * adds or removes data. This is a long-running operation as it may create many linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   RefreshSubscriptionRequest request =
   *       RefreshSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   RefreshSubscriptionResponse response =
   *       analyticsHubServiceClient.refreshSubscriptionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionAsync(RefreshSubscriptionRequest request) {
    return refreshSubscriptionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher
   * adds or removes data. This is a long-running operation as it may create many linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   RefreshSubscriptionRequest request =
   *       RefreshSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   OperationFuture<RefreshSubscriptionResponse, OperationMetadata> future =
   *       analyticsHubServiceClient.refreshSubscriptionOperationCallable().futureCall(request);
   *   // Do something.
   *   RefreshSubscriptionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationCallable() {
    return stub.refreshSubscriptionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher
   * adds or removes data. This is a long-running operation as it may create many linked datasets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   RefreshSubscriptionRequest request =
   *       RefreshSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       analyticsHubServiceClient.refreshSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RefreshSubscriptionRequest, Operation> refreshSubscriptionCallable() {
    return stub.refreshSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
   *   Subscription response = analyticsHubServiceClient.getSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription. e.g.
   *     projects/123/locations/US/subscriptions/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(SubscriptionName name) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString();
   *   Subscription response = analyticsHubServiceClient.getSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription. e.g.
   *     projects/123/locations/US/subscriptions/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(String name) {
    GetSubscriptionRequest request = GetSubscriptionRequest.newBuilder().setName(name).build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetSubscriptionRequest request =
   *       GetSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   Subscription response = analyticsHubServiceClient.getSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(GetSubscriptionRequest request) {
    return getSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetSubscriptionRequest request =
   *       GetSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       analyticsHubServiceClient.getSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return stub.getSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Subscription element :
   *       analyticsHubServiceClient.listSubscriptions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the subscription. e.g.
   *     projects/myproject/locations/US
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(LocationName parent) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Subscription element :
   *       analyticsHubServiceClient.listSubscriptions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource path of the subscription. e.g.
   *     projects/myproject/locations/US
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(String parent) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder().setParent(parent).build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subscription element :
   *       analyticsHubServiceClient.listSubscriptions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(ListSubscriptionsRequest request) {
    return listSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subscription> future =
   *       analyticsHubServiceClient.listSubscriptionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Subscription element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return stub.listSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubscriptionsResponse response =
   *         analyticsHubServiceClient.listSubscriptionsCallable().call(request);
   *     for (Subscription element : response.getSubscriptionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return stub.listSubscriptionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions on a given Data Exchange or Listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ResourceName resource = DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]");
   *   for (Subscription element :
   *       analyticsHubServiceClient.listSharedResourceSubscriptions(resource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param resource Required. Resource name of the requested target. This resource may be either a
   *     Listing or a DataExchange. e.g. projects/123/locations/US/dataExchanges/456 OR e.g.
   *     projects/123/locations/US/dataExchanges/456/listings/789
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedResourceSubscriptionsPagedResponse listSharedResourceSubscriptions(
      ResourceName resource) {
    ListSharedResourceSubscriptionsRequest request =
        ListSharedResourceSubscriptionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return listSharedResourceSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions on a given Data Exchange or Listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String resource =
   *       DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString();
   *   for (Subscription element :
   *       analyticsHubServiceClient.listSharedResourceSubscriptions(resource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param resource Required. Resource name of the requested target. This resource may be either a
   *     Listing or a DataExchange. e.g. projects/123/locations/US/dataExchanges/456 OR e.g.
   *     projects/123/locations/US/dataExchanges/456/listings/789
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedResourceSubscriptionsPagedResponse listSharedResourceSubscriptions(
      String resource) {
    ListSharedResourceSubscriptionsRequest request =
        ListSharedResourceSubscriptionsRequest.newBuilder().setResource(resource).build();
    return listSharedResourceSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions on a given Data Exchange or Listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListSharedResourceSubscriptionsRequest request =
   *       ListSharedResourceSubscriptionsRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setIncludeDeletedSubscriptions(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subscription element :
   *       analyticsHubServiceClient.listSharedResourceSubscriptions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedResourceSubscriptionsPagedResponse listSharedResourceSubscriptions(
      ListSharedResourceSubscriptionsRequest request) {
    return listSharedResourceSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions on a given Data Exchange or Listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListSharedResourceSubscriptionsRequest request =
   *       ListSharedResourceSubscriptionsRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setIncludeDeletedSubscriptions(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subscription> future =
   *       analyticsHubServiceClient
   *           .listSharedResourceSubscriptionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (Subscription element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsPagedCallable() {
    return stub.listSharedResourceSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscriptions on a given Data Exchange or Listing.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   ListSharedResourceSubscriptionsRequest request =
   *       ListSharedResourceSubscriptionsRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setIncludeDeletedSubscriptions(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSharedResourceSubscriptionsResponse response =
   *         analyticsHubServiceClient.listSharedResourceSubscriptionsCallable().call(request);
   *     for (Subscription element : response.getSharedResourceSubscriptionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
      listSharedResourceSubscriptionsCallable() {
    return stub.listSharedResourceSubscriptionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes a given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
   *   RevokeSubscriptionResponse response = analyticsHubServiceClient.revokeSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription to revoke. e.g.
   *     projects/123/locations/US/subscriptions/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RevokeSubscriptionResponse revokeSubscription(SubscriptionName name) {
    RevokeSubscriptionRequest request =
        RevokeSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return revokeSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes a given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString();
   *   RevokeSubscriptionResponse response = analyticsHubServiceClient.revokeSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription to revoke. e.g.
   *     projects/123/locations/US/subscriptions/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RevokeSubscriptionResponse revokeSubscription(String name) {
    RevokeSubscriptionRequest request =
        RevokeSubscriptionRequest.newBuilder().setName(name).build();
    return revokeSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes a given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   RevokeSubscriptionRequest request =
   *       RevokeSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   RevokeSubscriptionResponse response = analyticsHubServiceClient.revokeSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RevokeSubscriptionResponse revokeSubscription(RevokeSubscriptionRequest request) {
    return revokeSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes a given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   RevokeSubscriptionRequest request =
   *       RevokeSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<RevokeSubscriptionResponse> future =
   *       analyticsHubServiceClient.revokeSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   RevokeSubscriptionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionCallable() {
    return stub.revokeSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]");
   *   analyticsHubServiceClient.deleteSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription to delete. e.g.
   *     projects/123/locations/US/subscriptions/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSubscriptionAsync(
      SubscriptionName name) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString();
   *   analyticsHubServiceClient.deleteSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription to delete. e.g.
   *     projects/123/locations/US/subscriptions/456
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSubscriptionAsync(String name) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder().setName(name).build();
    return deleteSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   analyticsHubServiceClient.deleteSubscriptionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSubscriptionAsync(
      DeleteSubscriptionRequest request) {
    return deleteSubscriptionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       analyticsHubServiceClient.deleteSubscriptionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationCallable() {
    return stub.deleteSubscriptionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[PROJECT]", "[LOCATION]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       analyticsHubServiceClient.deleteSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable() {
    return stub.deleteSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = analyticsHubServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       analyticsHubServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = analyticsHubServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       analyticsHubServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = analyticsHubServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               DataExchangeName.of("[PROJECT]", "[LOCATION]", "[DATA_EXCHANGE]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       analyticsHubServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListDataExchangesPagedResponse
      extends AbstractPagedListResponse<
          ListDataExchangesRequest,
          ListDataExchangesResponse,
          DataExchange,
          ListDataExchangesPage,
          ListDataExchangesFixedSizeCollection> {

    public static ApiFuture<ListDataExchangesPagedResponse> createAsync(
        PageContext<ListDataExchangesRequest, ListDataExchangesResponse, DataExchange> context,
        ApiFuture<ListDataExchangesResponse> futureResponse) {
      ApiFuture<ListDataExchangesPage> futurePage =
          ListDataExchangesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataExchangesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataExchangesPagedResponse(ListDataExchangesPage page) {
      super(page, ListDataExchangesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataExchangesPage
      extends AbstractPage<
          ListDataExchangesRequest,
          ListDataExchangesResponse,
          DataExchange,
          ListDataExchangesPage> {

    private ListDataExchangesPage(
        PageContext<ListDataExchangesRequest, ListDataExchangesResponse, DataExchange> context,
        ListDataExchangesResponse response) {
      super(context, response);
    }

    private static ListDataExchangesPage createEmptyPage() {
      return new ListDataExchangesPage(null, null);
    }

    @Override
    protected ListDataExchangesPage createPage(
        PageContext<ListDataExchangesRequest, ListDataExchangesResponse, DataExchange> context,
        ListDataExchangesResponse response) {
      return new ListDataExchangesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataExchangesPage> createPageAsync(
        PageContext<ListDataExchangesRequest, ListDataExchangesResponse, DataExchange> context,
        ApiFuture<ListDataExchangesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataExchangesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataExchangesRequest,
          ListDataExchangesResponse,
          DataExchange,
          ListDataExchangesPage,
          ListDataExchangesFixedSizeCollection> {

    private ListDataExchangesFixedSizeCollection(
        List<ListDataExchangesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataExchangesFixedSizeCollection createEmptyCollection() {
      return new ListDataExchangesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataExchangesFixedSizeCollection createCollection(
        List<ListDataExchangesPage> pages, int collectionSize) {
      return new ListDataExchangesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOrgDataExchangesPagedResponse
      extends AbstractPagedListResponse<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          DataExchange,
          ListOrgDataExchangesPage,
          ListOrgDataExchangesFixedSizeCollection> {

    public static ApiFuture<ListOrgDataExchangesPagedResponse> createAsync(
        PageContext<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>
            context,
        ApiFuture<ListOrgDataExchangesResponse> futureResponse) {
      ApiFuture<ListOrgDataExchangesPage> futurePage =
          ListOrgDataExchangesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrgDataExchangesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrgDataExchangesPagedResponse(ListOrgDataExchangesPage page) {
      super(page, ListOrgDataExchangesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrgDataExchangesPage
      extends AbstractPage<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          DataExchange,
          ListOrgDataExchangesPage> {

    private ListOrgDataExchangesPage(
        PageContext<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>
            context,
        ListOrgDataExchangesResponse response) {
      super(context, response);
    }

    private static ListOrgDataExchangesPage createEmptyPage() {
      return new ListOrgDataExchangesPage(null, null);
    }

    @Override
    protected ListOrgDataExchangesPage createPage(
        PageContext<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>
            context,
        ListOrgDataExchangesResponse response) {
      return new ListOrgDataExchangesPage(context, response);
    }

    @Override
    public ApiFuture<ListOrgDataExchangesPage> createPageAsync(
        PageContext<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>
            context,
        ApiFuture<ListOrgDataExchangesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrgDataExchangesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          DataExchange,
          ListOrgDataExchangesPage,
          ListOrgDataExchangesFixedSizeCollection> {

    private ListOrgDataExchangesFixedSizeCollection(
        List<ListOrgDataExchangesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrgDataExchangesFixedSizeCollection createEmptyCollection() {
      return new ListOrgDataExchangesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrgDataExchangesFixedSizeCollection createCollection(
        List<ListOrgDataExchangesPage> pages, int collectionSize) {
      return new ListOrgDataExchangesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListListingsPagedResponse
      extends AbstractPagedListResponse<
          ListListingsRequest,
          ListListingsResponse,
          Listing,
          ListListingsPage,
          ListListingsFixedSizeCollection> {

    public static ApiFuture<ListListingsPagedResponse> createAsync(
        PageContext<ListListingsRequest, ListListingsResponse, Listing> context,
        ApiFuture<ListListingsResponse> futureResponse) {
      ApiFuture<ListListingsPage> futurePage =
          ListListingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListListingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListListingsPagedResponse(ListListingsPage page) {
      super(page, ListListingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListListingsPage
      extends AbstractPage<ListListingsRequest, ListListingsResponse, Listing, ListListingsPage> {

    private ListListingsPage(
        PageContext<ListListingsRequest, ListListingsResponse, Listing> context,
        ListListingsResponse response) {
      super(context, response);
    }

    private static ListListingsPage createEmptyPage() {
      return new ListListingsPage(null, null);
    }

    @Override
    protected ListListingsPage createPage(
        PageContext<ListListingsRequest, ListListingsResponse, Listing> context,
        ListListingsResponse response) {
      return new ListListingsPage(context, response);
    }

    @Override
    public ApiFuture<ListListingsPage> createPageAsync(
        PageContext<ListListingsRequest, ListListingsResponse, Listing> context,
        ApiFuture<ListListingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListListingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListListingsRequest,
          ListListingsResponse,
          Listing,
          ListListingsPage,
          ListListingsFixedSizeCollection> {

    private ListListingsFixedSizeCollection(List<ListListingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListListingsFixedSizeCollection createEmptyCollection() {
      return new ListListingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListListingsFixedSizeCollection createCollection(
        List<ListListingsPage> pages, int collectionSize) {
      return new ListListingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListSubscriptionsRequest,
          ListSubscriptionsResponse,
          Subscription,
          ListSubscriptionsPage,
          ListSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListSubscriptionsPagedResponse> createAsync(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ApiFuture<ListSubscriptionsResponse> futureResponse) {
      ApiFuture<ListSubscriptionsPage> futurePage =
          ListSubscriptionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSubscriptionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSubscriptionsPagedResponse(ListSubscriptionsPage page) {
      super(page, ListSubscriptionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubscriptionsPage
      extends AbstractPage<
          ListSubscriptionsRequest,
          ListSubscriptionsResponse,
          Subscription,
          ListSubscriptionsPage> {

    private ListSubscriptionsPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ListSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListSubscriptionsPage createEmptyPage() {
      return new ListSubscriptionsPage(null, null);
    }

    @Override
    protected ListSubscriptionsPage createPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ListSubscriptionsResponse response) {
      return new ListSubscriptionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSubscriptionsPage> createPageAsync(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ApiFuture<ListSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubscriptionsRequest,
          ListSubscriptionsResponse,
          Subscription,
          ListSubscriptionsPage,
          ListSubscriptionsFixedSizeCollection> {

    private ListSubscriptionsFixedSizeCollection(
        List<ListSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubscriptionsFixedSizeCollection createCollection(
        List<ListSubscriptionsPage> pages, int collectionSize) {
      return new ListSubscriptionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSharedResourceSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          Subscription,
          ListSharedResourceSubscriptionsPage,
          ListSharedResourceSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListSharedResourceSubscriptionsPagedResponse> createAsync(
        PageContext<
                ListSharedResourceSubscriptionsRequest,
                ListSharedResourceSubscriptionsResponse,
                Subscription>
            context,
        ApiFuture<ListSharedResourceSubscriptionsResponse> futureResponse) {
      ApiFuture<ListSharedResourceSubscriptionsPage> futurePage =
          ListSharedResourceSubscriptionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSharedResourceSubscriptionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSharedResourceSubscriptionsPagedResponse(ListSharedResourceSubscriptionsPage page) {
      super(page, ListSharedResourceSubscriptionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSharedResourceSubscriptionsPage
      extends AbstractPage<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          Subscription,
          ListSharedResourceSubscriptionsPage> {

    private ListSharedResourceSubscriptionsPage(
        PageContext<
                ListSharedResourceSubscriptionsRequest,
                ListSharedResourceSubscriptionsResponse,
                Subscription>
            context,
        ListSharedResourceSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListSharedResourceSubscriptionsPage createEmptyPage() {
      return new ListSharedResourceSubscriptionsPage(null, null);
    }

    @Override
    protected ListSharedResourceSubscriptionsPage createPage(
        PageContext<
                ListSharedResourceSubscriptionsRequest,
                ListSharedResourceSubscriptionsResponse,
                Subscription>
            context,
        ListSharedResourceSubscriptionsResponse response) {
      return new ListSharedResourceSubscriptionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSharedResourceSubscriptionsPage> createPageAsync(
        PageContext<
                ListSharedResourceSubscriptionsRequest,
                ListSharedResourceSubscriptionsResponse,
                Subscription>
            context,
        ApiFuture<ListSharedResourceSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSharedResourceSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          Subscription,
          ListSharedResourceSubscriptionsPage,
          ListSharedResourceSubscriptionsFixedSizeCollection> {

    private ListSharedResourceSubscriptionsFixedSizeCollection(
        List<ListSharedResourceSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSharedResourceSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListSharedResourceSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSharedResourceSubscriptionsFixedSizeCollection createCollection(
        List<ListSharedResourceSubscriptionsPage> pages, int collectionSize) {
      return new ListSharedResourceSubscriptionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
