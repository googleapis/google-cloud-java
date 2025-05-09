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

package com.google.shopping.merchant.notifications.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.notifications.v1beta.stub.NotificationsApiServiceStub;
import com.google.shopping.merchant.notifications.v1beta.stub.NotificationsApiServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage notification subscriptions for merchants
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
 * try (NotificationsApiServiceClient notificationsApiServiceClient =
 *     NotificationsApiServiceClient.create()) {
 *   NotificationSubscriptionName name =
 *       NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
 *   NotificationSubscription response =
 *       notificationsApiServiceClient.getNotificationSubscription(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NotificationsApiServiceClient object to clean up
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
 *      <td><p> GetNotificationSubscription</td>
 *      <td><p> Gets notification subscriptions for an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNotificationSubscription(GetNotificationSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNotificationSubscription(NotificationSubscriptionName name)
 *           <li><p> getNotificationSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNotificationSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNotificationSubscription</td>
 *      <td><p> Creates a notification subscription for a merchant. We will allow the following types of notification subscriptions to exist together (per merchant as a subscriber per event type): 1. Subscription for all managed accounts + subscription for self 2. Multiple "partial" subscriptions for managed accounts + subscription for self
 * <p>  we will not allow (per merchant as a subscriber per event type): 1. multiple self subscriptions. 2. multiple "all managed accounts" subscriptions. 3. all and partial subscriptions at the same time. 4. multiple partial subscriptions for the same target account</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNotificationSubscription(CreateNotificationSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createNotificationSubscription(AccountName parent, NotificationSubscription notificationSubscription)
 *           <li><p> createNotificationSubscription(String parent, NotificationSubscription notificationSubscription)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNotificationSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNotificationSubscription</td>
 *      <td><p> Updates an existing notification subscription for a merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNotificationSubscription(UpdateNotificationSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateNotificationSubscription(NotificationSubscription notificationSubscription, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNotificationSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNotificationSubscription</td>
 *      <td><p> Deletes a notification subscription for a merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNotificationSubscription(DeleteNotificationSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteNotificationSubscription(NotificationSubscriptionName name)
 *           <li><p> deleteNotificationSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNotificationSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotificationSubscriptions</td>
 *      <td><p> Gets all the notification subscriptions for a merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotificationSubscriptions(ListNotificationSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotificationSubscriptions(AccountName parent)
 *           <li><p> listNotificationSubscriptions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotificationSubscriptionsPagedCallable()
 *           <li><p> listNotificationSubscriptionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * NotificationsApiServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NotificationsApiServiceSettings notificationsApiServiceSettings =
 *     NotificationsApiServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NotificationsApiServiceClient notificationsApiServiceClient =
 *     NotificationsApiServiceClient.create(notificationsApiServiceSettings);
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
 * NotificationsApiServiceSettings notificationsApiServiceSettings =
 *     NotificationsApiServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NotificationsApiServiceClient notificationsApiServiceClient =
 *     NotificationsApiServiceClient.create(notificationsApiServiceSettings);
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
 * NotificationsApiServiceSettings notificationsApiServiceSettings =
 *     NotificationsApiServiceSettings.newHttpJsonBuilder().build();
 * NotificationsApiServiceClient notificationsApiServiceClient =
 *     NotificationsApiServiceClient.create(notificationsApiServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class NotificationsApiServiceClient implements BackgroundResource {
  private final NotificationsApiServiceSettings settings;
  private final NotificationsApiServiceStub stub;

  /** Constructs an instance of NotificationsApiServiceClient with default settings. */
  public static final NotificationsApiServiceClient create() throws IOException {
    return create(NotificationsApiServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NotificationsApiServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NotificationsApiServiceClient create(NotificationsApiServiceSettings settings)
      throws IOException {
    return new NotificationsApiServiceClient(settings);
  }

  /**
   * Constructs an instance of NotificationsApiServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(NotificationsApiServiceSettings).
   */
  public static final NotificationsApiServiceClient create(NotificationsApiServiceStub stub) {
    return new NotificationsApiServiceClient(stub);
  }

  /**
   * Constructs an instance of NotificationsApiServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NotificationsApiServiceClient(NotificationsApiServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((NotificationsApiServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected NotificationsApiServiceClient(NotificationsApiServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NotificationsApiServiceSettings getSettings() {
    return settings;
  }

  public NotificationsApiServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets notification subscriptions for an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   NotificationSubscriptionName name =
   *       NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.getNotificationSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The `name` of the notification subscription.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription getNotificationSubscription(
      NotificationSubscriptionName name) {
    GetNotificationSubscriptionRequest request =
        GetNotificationSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets notification subscriptions for an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   String name =
   *       NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]").toString();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.getNotificationSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The `name` of the notification subscription.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription getNotificationSubscription(String name) {
    GetNotificationSubscriptionRequest request =
        GetNotificationSubscriptionRequest.newBuilder().setName(name).build();
    return getNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets notification subscriptions for an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   GetNotificationSubscriptionRequest request =
   *       GetNotificationSubscriptionRequest.newBuilder()
   *           .setName(
   *               NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.getNotificationSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription getNotificationSubscription(
      GetNotificationSubscriptionRequest request) {
    return getNotificationSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets notification subscriptions for an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   GetNotificationSubscriptionRequest request =
   *       GetNotificationSubscriptionRequest.newBuilder()
   *           .setName(
   *               NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NotificationSubscription> future =
   *       notificationsApiServiceClient.getNotificationSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   NotificationSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotificationSubscriptionRequest, NotificationSubscription>
      getNotificationSubscriptionCallable() {
    return stub.getNotificationSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a merchant. We will allow the following types of
   * notification subscriptions to exist together (per merchant as a subscriber per event type): 1.
   * Subscription for all managed accounts + subscription for self 2. Multiple "partial"
   * subscriptions for managed accounts + subscription for self
   *
   * <p>we will not allow (per merchant as a subscriber per event type): 1. multiple self
   * subscriptions. 2. multiple "all managed accounts" subscriptions. 3. all and partial
   * subscriptions at the same time. 4. multiple partial subscriptions for the same target account
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   NotificationSubscription notificationSubscription =
   *       NotificationSubscription.newBuilder().build();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.createNotificationSubscription(
   *           parent, notificationSubscription);
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account that owns the new notification subscription.
   *     Format: `accounts/{account}`
   * @param notificationSubscription Required. The notification subscription to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription createNotificationSubscription(
      AccountName parent, NotificationSubscription notificationSubscription) {
    CreateNotificationSubscriptionRequest request =
        CreateNotificationSubscriptionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotificationSubscription(notificationSubscription)
            .build();
    return createNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a merchant. We will allow the following types of
   * notification subscriptions to exist together (per merchant as a subscriber per event type): 1.
   * Subscription for all managed accounts + subscription for self 2. Multiple "partial"
   * subscriptions for managed accounts + subscription for self
   *
   * <p>we will not allow (per merchant as a subscriber per event type): 1. multiple self
   * subscriptions. 2. multiple "all managed accounts" subscriptions. 3. all and partial
   * subscriptions at the same time. 4. multiple partial subscriptions for the same target account
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   NotificationSubscription notificationSubscription =
   *       NotificationSubscription.newBuilder().build();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.createNotificationSubscription(
   *           parent, notificationSubscription);
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account that owns the new notification subscription.
   *     Format: `accounts/{account}`
   * @param notificationSubscription Required. The notification subscription to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription createNotificationSubscription(
      String parent, NotificationSubscription notificationSubscription) {
    CreateNotificationSubscriptionRequest request =
        CreateNotificationSubscriptionRequest.newBuilder()
            .setParent(parent)
            .setNotificationSubscription(notificationSubscription)
            .build();
    return createNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a merchant. We will allow the following types of
   * notification subscriptions to exist together (per merchant as a subscriber per event type): 1.
   * Subscription for all managed accounts + subscription for self 2. Multiple "partial"
   * subscriptions for managed accounts + subscription for self
   *
   * <p>we will not allow (per merchant as a subscriber per event type): 1. multiple self
   * subscriptions. 2. multiple "all managed accounts" subscriptions. 3. all and partial
   * subscriptions at the same time. 4. multiple partial subscriptions for the same target account
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   CreateNotificationSubscriptionRequest request =
   *       CreateNotificationSubscriptionRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setNotificationSubscription(NotificationSubscription.newBuilder().build())
   *           .build();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.createNotificationSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription createNotificationSubscription(
      CreateNotificationSubscriptionRequest request) {
    return createNotificationSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a notification subscription for a merchant. We will allow the following types of
   * notification subscriptions to exist together (per merchant as a subscriber per event type): 1.
   * Subscription for all managed accounts + subscription for self 2. Multiple "partial"
   * subscriptions for managed accounts + subscription for self
   *
   * <p>we will not allow (per merchant as a subscriber per event type): 1. multiple self
   * subscriptions. 2. multiple "all managed accounts" subscriptions. 3. all and partial
   * subscriptions at the same time. 4. multiple partial subscriptions for the same target account
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   CreateNotificationSubscriptionRequest request =
   *       CreateNotificationSubscriptionRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setNotificationSubscription(NotificationSubscription.newBuilder().build())
   *           .build();
   *   ApiFuture<NotificationSubscription> future =
   *       notificationsApiServiceClient
   *           .createNotificationSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   NotificationSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNotificationSubscriptionRequest, NotificationSubscription>
      createNotificationSubscriptionCallable() {
    return stub.createNotificationSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   NotificationSubscription notificationSubscription =
   *       NotificationSubscription.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.updateNotificationSubscription(
   *           notificationSubscription, updateMask);
   * }
   * }</pre>
   *
   * @param notificationSubscription Required. The new version of the notification subscription that
   *     should be updated.
   * @param updateMask List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription updateNotificationSubscription(
      NotificationSubscription notificationSubscription, FieldMask updateMask) {
    UpdateNotificationSubscriptionRequest request =
        UpdateNotificationSubscriptionRequest.newBuilder()
            .setNotificationSubscription(notificationSubscription)
            .setUpdateMask(updateMask)
            .build();
    return updateNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   UpdateNotificationSubscriptionRequest request =
   *       UpdateNotificationSubscriptionRequest.newBuilder()
   *           .setNotificationSubscription(NotificationSubscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   NotificationSubscription response =
   *       notificationsApiServiceClient.updateNotificationSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotificationSubscription updateNotificationSubscription(
      UpdateNotificationSubscriptionRequest request) {
    return updateNotificationSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   UpdateNotificationSubscriptionRequest request =
   *       UpdateNotificationSubscriptionRequest.newBuilder()
   *           .setNotificationSubscription(NotificationSubscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<NotificationSubscription> future =
   *       notificationsApiServiceClient
   *           .updateNotificationSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   NotificationSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNotificationSubscriptionRequest, NotificationSubscription>
      updateNotificationSubscriptionCallable() {
    return stub.updateNotificationSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   NotificationSubscriptionName name =
   *       NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
   *   notificationsApiServiceClient.deleteNotificationSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the notification subscription to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationSubscription(NotificationSubscriptionName name) {
    DeleteNotificationSubscriptionRequest request =
        DeleteNotificationSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   String name =
   *       NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]").toString();
   *   notificationsApiServiceClient.deleteNotificationSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the notification subscription to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationSubscription(String name) {
    DeleteNotificationSubscriptionRequest request =
        DeleteNotificationSubscriptionRequest.newBuilder().setName(name).build();
    deleteNotificationSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   DeleteNotificationSubscriptionRequest request =
   *       DeleteNotificationSubscriptionRequest.newBuilder()
   *           .setName(
   *               NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   notificationsApiServiceClient.deleteNotificationSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNotificationSubscription(DeleteNotificationSubscriptionRequest request) {
    deleteNotificationSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a notification subscription for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   DeleteNotificationSubscriptionRequest request =
   *       DeleteNotificationSubscriptionRequest.newBuilder()
   *           .setName(
   *               NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       notificationsApiServiceClient
   *           .deleteNotificationSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotificationSubscriptionRequest, Empty>
      deleteNotificationSubscriptionCallable() {
    return stub.deleteNotificationSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the notification subscriptions for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (NotificationSubscription element :
   *       notificationsApiServiceClient.listNotificationSubscriptions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account who owns the notification subscriptions. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationSubscriptionsPagedResponse listNotificationSubscriptions(
      AccountName parent) {
    ListNotificationSubscriptionsRequest request =
        ListNotificationSubscriptionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotificationSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the notification subscriptions for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (NotificationSubscription element :
   *       notificationsApiServiceClient.listNotificationSubscriptions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account who owns the notification subscriptions. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationSubscriptionsPagedResponse listNotificationSubscriptions(
      String parent) {
    ListNotificationSubscriptionsRequest request =
        ListNotificationSubscriptionsRequest.newBuilder().setParent(parent).build();
    return listNotificationSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the notification subscriptions for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   ListNotificationSubscriptionsRequest request =
   *       ListNotificationSubscriptionsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (NotificationSubscription element :
   *       notificationsApiServiceClient.listNotificationSubscriptions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotificationSubscriptionsPagedResponse listNotificationSubscriptions(
      ListNotificationSubscriptionsRequest request) {
    return listNotificationSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the notification subscriptions for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   ListNotificationSubscriptionsRequest request =
   *       ListNotificationSubscriptionsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<NotificationSubscription> future =
   *       notificationsApiServiceClient
   *           .listNotificationSubscriptionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (NotificationSubscription element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsPagedResponse>
      listNotificationSubscriptionsPagedCallable() {
    return stub.listNotificationSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the notification subscriptions for a merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotificationsApiServiceClient notificationsApiServiceClient =
   *     NotificationsApiServiceClient.create()) {
   *   ListNotificationSubscriptionsRequest request =
   *       ListNotificationSubscriptionsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNotificationSubscriptionsResponse response =
   *         notificationsApiServiceClient.listNotificationSubscriptionsCallable().call(request);
   *     for (NotificationSubscription element : response.getNotificationSubscriptionsList()) {
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
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
      listNotificationSubscriptionsCallable() {
    return stub.listNotificationSubscriptionsCallable();
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

  public static class ListNotificationSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListNotificationSubscriptionsRequest,
          ListNotificationSubscriptionsResponse,
          NotificationSubscription,
          ListNotificationSubscriptionsPage,
          ListNotificationSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListNotificationSubscriptionsPagedResponse> createAsync(
        PageContext<
                ListNotificationSubscriptionsRequest,
                ListNotificationSubscriptionsResponse,
                NotificationSubscription>
            context,
        ApiFuture<ListNotificationSubscriptionsResponse> futureResponse) {
      ApiFuture<ListNotificationSubscriptionsPage> futurePage =
          ListNotificationSubscriptionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNotificationSubscriptionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNotificationSubscriptionsPagedResponse(ListNotificationSubscriptionsPage page) {
      super(page, ListNotificationSubscriptionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotificationSubscriptionsPage
      extends AbstractPage<
          ListNotificationSubscriptionsRequest,
          ListNotificationSubscriptionsResponse,
          NotificationSubscription,
          ListNotificationSubscriptionsPage> {

    private ListNotificationSubscriptionsPage(
        PageContext<
                ListNotificationSubscriptionsRequest,
                ListNotificationSubscriptionsResponse,
                NotificationSubscription>
            context,
        ListNotificationSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListNotificationSubscriptionsPage createEmptyPage() {
      return new ListNotificationSubscriptionsPage(null, null);
    }

    @Override
    protected ListNotificationSubscriptionsPage createPage(
        PageContext<
                ListNotificationSubscriptionsRequest,
                ListNotificationSubscriptionsResponse,
                NotificationSubscription>
            context,
        ListNotificationSubscriptionsResponse response) {
      return new ListNotificationSubscriptionsPage(context, response);
    }

    @Override
    public ApiFuture<ListNotificationSubscriptionsPage> createPageAsync(
        PageContext<
                ListNotificationSubscriptionsRequest,
                ListNotificationSubscriptionsResponse,
                NotificationSubscription>
            context,
        ApiFuture<ListNotificationSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotificationSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotificationSubscriptionsRequest,
          ListNotificationSubscriptionsResponse,
          NotificationSubscription,
          ListNotificationSubscriptionsPage,
          ListNotificationSubscriptionsFixedSizeCollection> {

    private ListNotificationSubscriptionsFixedSizeCollection(
        List<ListNotificationSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotificationSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListNotificationSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotificationSubscriptionsFixedSizeCollection createCollection(
        List<ListNotificationSubscriptionsPage> pages, int collectionSize) {
      return new ListNotificationSubscriptionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
