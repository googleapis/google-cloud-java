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

package com.google.apps.events.subscriptions.v1;

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
import com.google.apps.events.subscriptions.v1.stub.SubscriptionsServiceStub;
import com.google.apps.events.subscriptions.v1.stub.SubscriptionsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service that manages subscriptions to Google Workspace events.
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
 * try (SubscriptionsServiceClient subscriptionsServiceClient =
 *     SubscriptionsServiceClient.create()) {
 *   SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
 *   Subscription response = subscriptionsServiceClient.getSubscription(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SubscriptionsServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSubscription</td>
 *      <td><p> Creates a Google Workspace subscription. To learn how to use this method, see [Create a Google Workspace subscription](https://developers.google.com/workspace/events/guides/create-subscription).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSubscriptionAsync(CreateSubscriptionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSubscriptionAsync(Subscription subscription)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSubscriptionOperationCallable()
 *           <li><p> createSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSubscription</td>
 *      <td><p> Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google Workspace subscription](https://developers.google.com/workspace/events/guides/delete-subscription).</td>
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
 *      <td><p> GetSubscription</td>
 *      <td><p> Gets details about a Google Workspace subscription. To learn how to use this method, see [Get details about a Google Workspace subscription](https://developers.google.com/workspace/events/guides/get-subscription).</td>
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
 *      <td><p> Lists Google Workspace subscriptions. To learn how to use this method, see [List Google Workspace subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubscriptions(ListSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubscriptions(String filter)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubscriptionsPagedCallable()
 *           <li><p> listSubscriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSubscription</td>
 *      <td><p> Updates or renews a Google Workspace subscription. To learn how to use this method, see [Update or renew a Google Workspace subscription](https://developers.google.com/workspace/events/guides/update-subscription).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSubscriptionAsync(UpdateSubscriptionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSubscriptionAsync(Subscription subscription, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSubscriptionOperationCallable()
 *           <li><p> updateSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReactivateSubscription</td>
 *      <td><p> Reactivates a suspended Google Workspace subscription.
 * <p>  This method resets your subscription's `State` field to `ACTIVE`. Before you use this method, you must fix the error that suspended the subscription. To learn how to use this method, see [Reactivate a Google Workspace subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reactivateSubscriptionAsync(ReactivateSubscriptionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> reactivateSubscriptionAsync(SubscriptionName name)
 *           <li><p> reactivateSubscriptionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reactivateSubscriptionOperationCallable()
 *           <li><p> reactivateSubscriptionCallable()
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
 * <p>This class can be customized by passing in a custom instance of SubscriptionsServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SubscriptionsServiceSettings subscriptionsServiceSettings =
 *     SubscriptionsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SubscriptionsServiceClient subscriptionsServiceClient =
 *     SubscriptionsServiceClient.create(subscriptionsServiceSettings);
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
 * SubscriptionsServiceSettings subscriptionsServiceSettings =
 *     SubscriptionsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SubscriptionsServiceClient subscriptionsServiceClient =
 *     SubscriptionsServiceClient.create(subscriptionsServiceSettings);
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
 * SubscriptionsServiceSettings subscriptionsServiceSettings =
 *     SubscriptionsServiceSettings.newHttpJsonBuilder().build();
 * SubscriptionsServiceClient subscriptionsServiceClient =
 *     SubscriptionsServiceClient.create(subscriptionsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SubscriptionsServiceClient implements BackgroundResource {
  private final SubscriptionsServiceSettings settings;
  private final SubscriptionsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SubscriptionsServiceClient with default settings. */
  public static final SubscriptionsServiceClient create() throws IOException {
    return create(SubscriptionsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SubscriptionsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SubscriptionsServiceClient create(SubscriptionsServiceSettings settings)
      throws IOException {
    return new SubscriptionsServiceClient(settings);
  }

  /**
   * Constructs an instance of SubscriptionsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SubscriptionsServiceSettings).
   */
  public static final SubscriptionsServiceClient create(SubscriptionsServiceStub stub) {
    return new SubscriptionsServiceClient(stub);
  }

  /**
   * Constructs an instance of SubscriptionsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SubscriptionsServiceClient(SubscriptionsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SubscriptionsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SubscriptionsServiceClient(SubscriptionsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SubscriptionsServiceSettings getSettings() {
    return settings;
  }

  public SubscriptionsServiceStub getStub() {
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
   * Creates a Google Workspace subscription. To learn how to use this method, see [Create a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   Subscription subscription = Subscription.newBuilder().build();
   *   Subscription response =
   *       subscriptionsServiceClient.createSubscriptionAsync(subscription).get();
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, CreateSubscriptionMetadata> createSubscriptionAsync(
      Subscription subscription) {
    CreateSubscriptionRequest request =
        CreateSubscriptionRequest.newBuilder().setSubscription(subscription).build();
    return createSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Google Workspace subscription. To learn how to use this method, see [Create a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   CreateSubscriptionRequest request =
   *       CreateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Subscription response = subscriptionsServiceClient.createSubscriptionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, CreateSubscriptionMetadata> createSubscriptionAsync(
      CreateSubscriptionRequest request) {
    return createSubscriptionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Google Workspace subscription. To learn how to use this method, see [Create a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   CreateSubscriptionRequest request =
   *       CreateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Subscription, CreateSubscriptionMetadata> future =
   *       subscriptionsServiceClient.createSubscriptionOperationCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationCallable() {
    return stub.createSubscriptionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Google Workspace subscription. To learn how to use this method, see [Create a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/create-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   CreateSubscriptionRequest request =
   *       CreateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       subscriptionsServiceClient.createSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubscriptionRequest, Operation> createSubscriptionCallable() {
    return stub.createSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
   *   subscriptionsServiceClient.deleteSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription to delete.
   *     <p>Format: `subscriptions/{subscription}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSubscriptionMetadata> deleteSubscriptionAsync(
      SubscriptionName name) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   String name = SubscriptionName.of("[SUBSCRIPTION]").toString();
   *   subscriptionsServiceClient.deleteSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription to delete.
   *     <p>Format: `subscriptions/{subscription}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSubscriptionMetadata> deleteSubscriptionAsync(
      String name) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder().setName(name).build();
    return deleteSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   subscriptionsServiceClient.deleteSubscriptionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSubscriptionMetadata> deleteSubscriptionAsync(
      DeleteSubscriptionRequest request) {
    return deleteSubscriptionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, DeleteSubscriptionMetadata> future =
   *       subscriptionsServiceClient.deleteSubscriptionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationCallable() {
    return stub.deleteSubscriptionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Google Workspace subscription. To learn how to use this method, see [Delete a Google
   * Workspace
   * subscription](https://developers.google.com/workspace/events/guides/delete-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       subscriptionsServiceClient.deleteSubscriptionCallable().futureCall(request);
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
   * Gets details about a Google Workspace subscription. To learn how to use this method, see [Get
   * details about a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
   *   Subscription response = subscriptionsServiceClient.getSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription.
   *     <p>Format: `subscriptions/{subscription}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(SubscriptionName name) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Google Workspace subscription. To learn how to use this method, see [Get
   * details about a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   String name = SubscriptionName.of("[SUBSCRIPTION]").toString();
   *   Subscription response = subscriptionsServiceClient.getSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription.
   *     <p>Format: `subscriptions/{subscription}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription getSubscription(String name) {
    GetSubscriptionRequest request = GetSubscriptionRequest.newBuilder().setName(name).build();
    return getSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Google Workspace subscription. To learn how to use this method, see [Get
   * details about a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   GetSubscriptionRequest request =
   *       GetSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .build();
   *   Subscription response = subscriptionsServiceClient.getSubscription(request);
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
   * Gets details about a Google Workspace subscription. To learn how to use this method, see [Get
   * details about a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/get-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   GetSubscriptionRequest request =
   *       GetSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       subscriptionsServiceClient.getSubscriptionCallable().futureCall(request);
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
   * Lists Google Workspace subscriptions. To learn how to use this method, see [List Google
   * Workspace
   * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   String filter = "filter-1274492040";
   *   for (Subscription element :
   *       subscriptionsServiceClient.listSubscriptions(filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param filter Required. A query filter.
   *     <p>You can filter subscriptions by event type (`event_types`) and target resource
   *     (`target_resource`).
   *     <p>You must specify at least one event type in your query. To filter for multiple event
   *     types, use the `OR` operator.
   *     <p>To filter by both event type and target resource, use the `AND` operator and specify the
   *     full resource name, such as `//chat.googleapis.com/spaces/{space}`.
   *     <p>For example, the following queries are valid:
   *     <p>``` event_types:"google.workspace.chat.membership.v1.updated" OR
   *     event_types:"google.workspace.chat.message.v1.created"
   *     <p>event_types:"google.workspace.chat.message.v1.created" AND
   *     target_resource="//chat.googleapis.com/spaces/{space}"
   *     <p>( event_types:"google.workspace.chat.membership.v1.updated" OR
   *     event_types:"google.workspace.chat.message.v1.created" ) AND
   *     target_resource="//chat.googleapis.com/spaces/{space}" ```
   *     <p>The server rejects invalid queries with an `INVALID_ARGUMENT` error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(String filter) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder().setFilter(filter).build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Google Workspace subscriptions. To learn how to use this method, see [List Google
   * Workspace
   * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Subscription element :
   *       subscriptionsServiceClient.listSubscriptions(request).iterateAll()) {
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
   * Lists Google Workspace subscriptions. To learn how to use this method, see [List Google
   * Workspace
   * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Subscription> future =
   *       subscriptionsServiceClient.listSubscriptionsPagedCallable().futureCall(request);
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
   * Lists Google Workspace subscriptions. To learn how to use this method, see [List Google
   * Workspace
   * subscriptions](https://developers.google.com/workspace/events/guides/list-subscriptions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListSubscriptionsResponse response =
   *         subscriptionsServiceClient.listSubscriptionsCallable().call(request);
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
   * Updates or renews a Google Workspace subscription. To learn how to use this method, see [Update
   * or renew a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   Subscription subscription = Subscription.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Subscription response =
   *       subscriptionsServiceClient.updateSubscriptionAsync(subscription, updateMask).get();
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription to update.
   *     <p>The subscription's `name` field is used to identify the subscription to update.
   * @param updateMask Optional. Required. The field to update.
   *     <p>You can update one of the following fields in a subscription:
   *     <ul>
   *       <li>[`expire_time`][google.apps.events.subscriptions.v1.Subscription.expire_time]: The
   *           timestamp when the subscription expires.
   *       <li>[`ttl`][google.apps.events.subscriptions.v1.Subscription.ttl]: The time-to-live (TTL)
   *           or duration of the subscription.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, UpdateSubscriptionMetadata> updateSubscriptionAsync(
      Subscription subscription, FieldMask updateMask) {
    UpdateSubscriptionRequest request =
        UpdateSubscriptionRequest.newBuilder()
            .setSubscription(subscription)
            .setUpdateMask(updateMask)
            .build();
    return updateSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or renews a Google Workspace subscription. To learn how to use this method, see [Update
   * or renew a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Subscription response = subscriptionsServiceClient.updateSubscriptionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, UpdateSubscriptionMetadata> updateSubscriptionAsync(
      UpdateSubscriptionRequest request) {
    return updateSubscriptionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or renews a Google Workspace subscription. To learn how to use this method, see [Update
   * or renew a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Subscription, UpdateSubscriptionMetadata> future =
   *       subscriptionsServiceClient.updateSubscriptionOperationCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationCallable() {
    return stub.updateSubscriptionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or renews a Google Workspace subscription. To learn how to use this method, see [Update
   * or renew a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/update-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       subscriptionsServiceClient.updateSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubscriptionRequest, Operation> updateSubscriptionCallable() {
    return stub.updateSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates a suspended Google Workspace subscription.
   *
   * <p>This method resets your subscription's `State` field to `ACTIVE`. Before you use this
   * method, you must fix the error that suspended the subscription. To learn how to use this
   * method, see [Reactivate a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
   *   Subscription response = subscriptionsServiceClient.reactivateSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription.
   *     <p>Format: `subscriptions/{subscription}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionAsync(SubscriptionName name) {
    ReactivateSubscriptionRequest request =
        ReactivateSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return reactivateSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates a suspended Google Workspace subscription.
   *
   * <p>This method resets your subscription's `State` field to `ACTIVE`. Before you use this
   * method, you must fix the error that suspended the subscription. To learn how to use this
   * method, see [Reactivate a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   String name = SubscriptionName.of("[SUBSCRIPTION]").toString();
   *   Subscription response = subscriptionsServiceClient.reactivateSubscriptionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the subscription.
   *     <p>Format: `subscriptions/{subscription}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionAsync(String name) {
    ReactivateSubscriptionRequest request =
        ReactivateSubscriptionRequest.newBuilder().setName(name).build();
    return reactivateSubscriptionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates a suspended Google Workspace subscription.
   *
   * <p>This method resets your subscription's `State` field to `ACTIVE`. Before you use this
   * method, you must fix the error that suspended the subscription. To learn how to use this
   * method, see [Reactivate a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   ReactivateSubscriptionRequest request =
   *       ReactivateSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .build();
   *   Subscription response = subscriptionsServiceClient.reactivateSubscriptionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionAsync(ReactivateSubscriptionRequest request) {
    return reactivateSubscriptionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates a suspended Google Workspace subscription.
   *
   * <p>This method resets your subscription's `State` field to `ACTIVE`. Before you use this
   * method, you must fix the error that suspended the subscription. To learn how to use this
   * method, see [Reactivate a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   ReactivateSubscriptionRequest request =
   *       ReactivateSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .build();
   *   OperationFuture<Subscription, ReactivateSubscriptionMetadata> future =
   *       subscriptionsServiceClient.reactivateSubscriptionOperationCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationCallable() {
    return stub.reactivateSubscriptionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reactivates a suspended Google Workspace subscription.
   *
   * <p>This method resets your subscription's `State` field to `ACTIVE`. Before you use this
   * method, you must fix the error that suspended the subscription. To learn how to use this
   * method, see [Reactivate a Google Workspace
   * subscription](https://developers.google.com/workspace/events/guides/reactivate-subscription).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SubscriptionsServiceClient subscriptionsServiceClient =
   *     SubscriptionsServiceClient.create()) {
   *   ReactivateSubscriptionRequest request =
   *       ReactivateSubscriptionRequest.newBuilder()
   *           .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       subscriptionsServiceClient.reactivateSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionCallable() {
    return stub.reactivateSubscriptionCallable();
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
}
