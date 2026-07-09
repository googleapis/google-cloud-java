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

package com.google.devicesandservices.health.v4;

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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devicesandservices.health.v4.stub.DataSubscriptionServiceStub;
import com.google.devicesandservices.health.v4.stub.DataSubscriptionServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Data Subscription Service that allows clients (e.g., Fitbit 3P applications,
 * internal Fitbit Services) to manage their subscriber endpoints. This service provides CRUD APIs
 * for subscribers, and also offers functionalities for subscriber verification and statistics.
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
 * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
 *     DataSubscriptionServiceClient.create()) {
 *   SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
 *   CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
 *   String subscriptionId = "subscriptionId1478790936";
 *   Subscription response =
 *       dataSubscriptionServiceClient.createSubscription(parent, subscription, subscriptionId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataSubscriptionServiceClient object to clean up
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
 *      <td><p> CreateSubscriber</td>
 *      <td><p> Registers a new subscriber endpoint to receive notifications. A subscriber represents an application or service that wishes to receive data change notifications for users who have granted consent.
 * <p>  &#42;&#42;Endpoint Verification:&#42;&#42; For a subscriber to be successfully created, the provided `endpoint_uri` must be a valid HTTPS endpoint and must pass an automated verification check. The backend will send two HTTP POST requests to the `endpoint_uri`:
 * <p>  1.  &#42;&#42;Verification with Authorization:&#42;&#42;     &#42;   &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json` and         `Authorization` (with the exact value from         `CreateSubscriberPayload.endpoint_authorization.secret`).     &#42;   &#42;&#42;Body:&#42;&#42; `{"type": "verification"}`     &#42;   &#42;&#42;Expected Response:&#42;&#42; HTTP `201 Created`.
 * <p>  2.  &#42;&#42;Verification without Authorization:&#42;&#42;     &#42;   &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json`. The         `Authorization` header is OMITTED.     &#42;   &#42;&#42;Body:&#42;&#42; `{"type": "verification"}`     &#42;   &#42;&#42;Expected Response:&#42;&#42; HTTP `401 Unauthorized` or `403 Forbidden`.
 * <p>  Both tests must pass for the subscriber creation to succeed. If verification fails, the operation will not be completed and an error will be returned. This process ensures the endpoint is reachable and correctly validates the `Authorization` header.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSubscriberAsync(CreateSubscriberRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSubscriberAsync(ProjectName parent, CreateSubscriberPayload subscriber, String subscriberId)
 *           <li><p> createSubscriberAsync(String parent, CreateSubscriberPayload subscriber, String subscriberId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSubscriberOperationCallable()
 *           <li><p> createSubscriberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubscribers</td>
 *      <td><p> Lists all subscribers registered within the owned Google Cloud Project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubscribers(ListSubscribersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubscribers(ProjectName parent)
 *           <li><p> listSubscribers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubscribersPagedCallable()
 *           <li><p> listSubscribersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSubscriber</td>
 *      <td><p> Updates the configuration of an existing subscriber, such as the endpoint URI or the data types it's interested in.
 * <p>  &#42;&#42;Endpoint Verification:&#42;&#42; If the `endpoint_uri` or `endpoint_authorization` field is included in the `update_mask`, the backend will re-verify the endpoint. The verification process is the same as described in `CreateSubscriber`:
 * <p>  1.  &#42;&#42;Verification with Authorization:&#42;&#42; POST to the new or existing     `endpoint_uri` with the new or existing `Authorization` secret. Expects     HTTP `201 Created`. 2.  &#42;&#42;Verification without Authorization:&#42;&#42; POST to the `endpoint_uri`     without the `Authorization` header. Expects HTTP `401 Unauthorized` or     `403 Forbidden`.
 * <p>  Both tests must pass using the potentially updated values for the subscriber update to succeed. If verification fails, the update will not be applied, and an error will be returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSubscriberAsync(UpdateSubscriberRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSubscriberAsync(Subscriber subscriber, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSubscriberOperationCallable()
 *           <li><p> updateSubscriberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSubscriber</td>
 *      <td><p> Deletes a subscriber registration. This will stop all notifications to the subscriber's endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSubscriberAsync(DeleteSubscriberRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSubscriberAsync(SubscriberName name)
 *           <li><p> deleteSubscriberAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSubscriberOperationCallable()
 *           <li><p> deleteSubscriberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSubscription</td>
 *      <td><p> Creates a subscription for a specific user to a specific subscriber. This method requires the subscriber to have a `SubscriptionCreatePolicy` set to `MANUAL` for the given data types.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSubscription(CreateSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSubscription(SubscriberName parent, CreateSubscriptionPayload subscription, String subscriptionId)
 *           <li><p> createSubscription(String parent, CreateSubscriptionPayload subscription, String subscriptionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubscriptions</td>
 *      <td><p> Lists all active subscriptions for a given subscriber. This can be filtered, for example, by user or data type.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubscriptions(ListSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubscriptions(SubscriberName parent)
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
 *      <td><p> UpdateSubscription</td>
 *      <td><p> Updates the data types for an existing user subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSubscription(UpdateSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSubscription(Subscription subscription, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSubscription</td>
 *      <td><p> Deletes a specific user subscription, stopping notifications for this user to this subscriber.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSubscription(DeleteSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSubscription(SubscriptionName name)
 *           <li><p> deleteSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSubscriptionCallable()
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
 * DataSubscriptionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSubscriptionServiceSettings dataSubscriptionServiceSettings =
 *     DataSubscriptionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataSubscriptionServiceClient dataSubscriptionServiceClient =
 *     DataSubscriptionServiceClient.create(dataSubscriptionServiceSettings);
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
 * DataSubscriptionServiceSettings dataSubscriptionServiceSettings =
 *     DataSubscriptionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataSubscriptionServiceClient dataSubscriptionServiceClient =
 *     DataSubscriptionServiceClient.create(dataSubscriptionServiceSettings);
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
 * DataSubscriptionServiceSettings dataSubscriptionServiceSettings =
 *     DataSubscriptionServiceSettings.newHttpJsonBuilder().build();
 * DataSubscriptionServiceClient dataSubscriptionServiceClient =
 *     DataSubscriptionServiceClient.create(dataSubscriptionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DataSubscriptionServiceClient implements BackgroundResource {
  private final DataSubscriptionServiceSettings settings;
  private final DataSubscriptionServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataSubscriptionServiceClient with default settings. */
  public static final DataSubscriptionServiceClient create() throws IOException {
    return create(DataSubscriptionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataSubscriptionServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataSubscriptionServiceClient create(DataSubscriptionServiceSettings settings)
      throws IOException {
    return new DataSubscriptionServiceClient(settings);
  }

  /**
   * Constructs an instance of DataSubscriptionServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataSubscriptionServiceSettings).
   */
  public static final DataSubscriptionServiceClient create(DataSubscriptionServiceStub stub) {
    return new DataSubscriptionServiceClient(stub);
  }

  /**
   * Constructs an instance of DataSubscriptionServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataSubscriptionServiceClient(DataSubscriptionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DataSubscriptionServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataSubscriptionServiceClient(DataSubscriptionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataSubscriptionServiceSettings getSettings() {
    return settings;
  }

  public DataSubscriptionServiceStub getStub() {
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
   * Registers a new subscriber endpoint to receive notifications. A subscriber represents an
   * application or service that wishes to receive data change notifications for users who have
   * granted consent.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; For a subscriber to be successfully created, the
   * provided `endpoint_uri` must be a valid HTTPS endpoint and must pass an automated verification
   * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; &#42; &#42;&#42;Headers:&#42;&#42;
   * Includes `Content-Type: application/json` and `Authorization` (with the exact value from
   * `CreateSubscriberPayload.endpoint_authorization.secret`). &#42; &#42;&#42;Body:&#42;&#42;
   * `{"type": "verification"}` &#42; &#42;&#42;Expected Response:&#42;&#42; HTTP `201 Created`.
   *
   * <p>2. &#42;&#42;Verification without Authorization:&#42;&#42; &#42;
   * &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json`. The `Authorization`
   * header is OMITTED. &#42; &#42;&#42;Body:&#42;&#42; `{"type": "verification"}` &#42;
   * &#42;&#42;Expected Response:&#42;&#42; HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass for the subscriber creation to succeed. If verification fails, the
   * operation will not be completed and an error will be returned. This process ensures the
   * endpoint is reachable and correctly validates the `Authorization` header.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
   *   String subscriberId = "subscriberId327834531";
   *   Subscriber response =
   *       dataSubscriptionServiceClient
   *           .createSubscriberAsync(parent, subscriber, subscriberId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this subscriber will be created. Format:
   *     projects/{project} Example: projects/my-project-123
   * @param subscriber Required. The subscriber to create.
   * @param subscriberId Optional. The ID to use for the subscriber, which will become the final
   *     component of the subscriber's resource name.
   *     <p>This value should be 4-36 characters, and valid characters are
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscriber, CreateSubscriberMetadata> createSubscriberAsync(
      ProjectName parent, CreateSubscriberPayload subscriber, String subscriberId) {
    CreateSubscriberRequest request =
        CreateSubscriberRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSubscriber(subscriber)
            .setSubscriberId(subscriberId)
            .build();
    return createSubscriberAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new subscriber endpoint to receive notifications. A subscriber represents an
   * application or service that wishes to receive data change notifications for users who have
   * granted consent.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; For a subscriber to be successfully created, the
   * provided `endpoint_uri` must be a valid HTTPS endpoint and must pass an automated verification
   * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; &#42; &#42;&#42;Headers:&#42;&#42;
   * Includes `Content-Type: application/json` and `Authorization` (with the exact value from
   * `CreateSubscriberPayload.endpoint_authorization.secret`). &#42; &#42;&#42;Body:&#42;&#42;
   * `{"type": "verification"}` &#42; &#42;&#42;Expected Response:&#42;&#42; HTTP `201 Created`.
   *
   * <p>2. &#42;&#42;Verification without Authorization:&#42;&#42; &#42;
   * &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json`. The `Authorization`
   * header is OMITTED. &#42; &#42;&#42;Body:&#42;&#42; `{"type": "verification"}` &#42;
   * &#42;&#42;Expected Response:&#42;&#42; HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass for the subscriber creation to succeed. If verification fails, the
   * operation will not be completed and an error will be returned. This process ensures the
   * endpoint is reachable and correctly validates the `Authorization` header.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
   *   String subscriberId = "subscriberId327834531";
   *   Subscriber response =
   *       dataSubscriptionServiceClient
   *           .createSubscriberAsync(parent, subscriber, subscriberId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this subscriber will be created. Format:
   *     projects/{project} Example: projects/my-project-123
   * @param subscriber Required. The subscriber to create.
   * @param subscriberId Optional. The ID to use for the subscriber, which will become the final
   *     component of the subscriber's resource name.
   *     <p>This value should be 4-36 characters, and valid characters are
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscriber, CreateSubscriberMetadata> createSubscriberAsync(
      String parent, CreateSubscriberPayload subscriber, String subscriberId) {
    CreateSubscriberRequest request =
        CreateSubscriberRequest.newBuilder()
            .setParent(parent)
            .setSubscriber(subscriber)
            .setSubscriberId(subscriberId)
            .build();
    return createSubscriberAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new subscriber endpoint to receive notifications. A subscriber represents an
   * application or service that wishes to receive data change notifications for users who have
   * granted consent.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; For a subscriber to be successfully created, the
   * provided `endpoint_uri` must be a valid HTTPS endpoint and must pass an automated verification
   * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; &#42; &#42;&#42;Headers:&#42;&#42;
   * Includes `Content-Type: application/json` and `Authorization` (with the exact value from
   * `CreateSubscriberPayload.endpoint_authorization.secret`). &#42; &#42;&#42;Body:&#42;&#42;
   * `{"type": "verification"}` &#42; &#42;&#42;Expected Response:&#42;&#42; HTTP `201 Created`.
   *
   * <p>2. &#42;&#42;Verification without Authorization:&#42;&#42; &#42;
   * &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json`. The `Authorization`
   * header is OMITTED. &#42; &#42;&#42;Body:&#42;&#42; `{"type": "verification"}` &#42;
   * &#42;&#42;Expected Response:&#42;&#42; HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass for the subscriber creation to succeed. If verification fails, the
   * operation will not be completed and an error will be returned. This process ensures the
   * endpoint is reachable and correctly validates the `Authorization` header.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   CreateSubscriberRequest request =
   *       CreateSubscriberRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSubscriber(CreateSubscriberPayload.newBuilder().build())
   *           .setSubscriberId("subscriberId327834531")
   *           .build();
   *   Subscriber response = dataSubscriptionServiceClient.createSubscriberAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscriber, CreateSubscriberMetadata> createSubscriberAsync(
      CreateSubscriberRequest request) {
    return createSubscriberOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new subscriber endpoint to receive notifications. A subscriber represents an
   * application or service that wishes to receive data change notifications for users who have
   * granted consent.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; For a subscriber to be successfully created, the
   * provided `endpoint_uri` must be a valid HTTPS endpoint and must pass an automated verification
   * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; &#42; &#42;&#42;Headers:&#42;&#42;
   * Includes `Content-Type: application/json` and `Authorization` (with the exact value from
   * `CreateSubscriberPayload.endpoint_authorization.secret`). &#42; &#42;&#42;Body:&#42;&#42;
   * `{"type": "verification"}` &#42; &#42;&#42;Expected Response:&#42;&#42; HTTP `201 Created`.
   *
   * <p>2. &#42;&#42;Verification without Authorization:&#42;&#42; &#42;
   * &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json`. The `Authorization`
   * header is OMITTED. &#42; &#42;&#42;Body:&#42;&#42; `{"type": "verification"}` &#42;
   * &#42;&#42;Expected Response:&#42;&#42; HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass for the subscriber creation to succeed. If verification fails, the
   * operation will not be completed and an error will be returned. This process ensures the
   * endpoint is reachable and correctly validates the `Authorization` header.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   CreateSubscriberRequest request =
   *       CreateSubscriberRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSubscriber(CreateSubscriberPayload.newBuilder().build())
   *           .setSubscriberId("subscriberId327834531")
   *           .build();
   *   OperationFuture<Subscriber, CreateSubscriberMetadata> future =
   *       dataSubscriptionServiceClient.createSubscriberOperationCallable().futureCall(request);
   *   // Do something.
   *   Subscriber response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationCallable() {
    return stub.createSubscriberOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new subscriber endpoint to receive notifications. A subscriber represents an
   * application or service that wishes to receive data change notifications for users who have
   * granted consent.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; For a subscriber to be successfully created, the
   * provided `endpoint_uri` must be a valid HTTPS endpoint and must pass an automated verification
   * check. The backend will send two HTTP POST requests to the `endpoint_uri`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; &#42; &#42;&#42;Headers:&#42;&#42;
   * Includes `Content-Type: application/json` and `Authorization` (with the exact value from
   * `CreateSubscriberPayload.endpoint_authorization.secret`). &#42; &#42;&#42;Body:&#42;&#42;
   * `{"type": "verification"}` &#42; &#42;&#42;Expected Response:&#42;&#42; HTTP `201 Created`.
   *
   * <p>2. &#42;&#42;Verification without Authorization:&#42;&#42; &#42;
   * &#42;&#42;Headers:&#42;&#42; Includes `Content-Type: application/json`. The `Authorization`
   * header is OMITTED. &#42; &#42;&#42;Body:&#42;&#42; `{"type": "verification"}` &#42;
   * &#42;&#42;Expected Response:&#42;&#42; HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass for the subscriber creation to succeed. If verification fails, the
   * operation will not be completed and an error will be returned. This process ensures the
   * endpoint is reachable and correctly validates the `Authorization` header.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   CreateSubscriberRequest request =
   *       CreateSubscriberRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSubscriber(CreateSubscriberPayload.newBuilder().build())
   *           .setSubscriberId("subscriberId327834531")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataSubscriptionServiceClient.createSubscriberCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubscriberRequest, Operation> createSubscriberCallable() {
    return stub.createSubscriberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscribers registered within the owned Google Cloud Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Subscriber element :
   *       dataSubscriptionServiceClient.listSubscribers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of subscribers. Format:
   *     projects/{project}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscribersPagedResponse listSubscribers(ProjectName parent) {
    ListSubscribersRequest request =
        ListSubscribersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubscribers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscribers registered within the owned Google Cloud Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Subscriber element :
   *       dataSubscriptionServiceClient.listSubscribers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of subscribers. Format:
   *     projects/{project}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscribersPagedResponse listSubscribers(String parent) {
    ListSubscribersRequest request = ListSubscribersRequest.newBuilder().setParent(parent).build();
    return listSubscribers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscribers registered within the owned Google Cloud Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ListSubscribersRequest request =
   *       ListSubscribersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subscriber element :
   *       dataSubscriptionServiceClient.listSubscribers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscribersPagedResponse listSubscribers(ListSubscribersRequest request) {
    return listSubscribersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscribers registered within the owned Google Cloud Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ListSubscribersRequest request =
   *       ListSubscribersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subscriber> future =
   *       dataSubscriptionServiceClient.listSubscribersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Subscriber element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable() {
    return stub.listSubscribersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all subscribers registered within the owned Google Cloud Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ListSubscribersRequest request =
   *       ListSubscribersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubscribersResponse response =
   *         dataSubscriptionServiceClient.listSubscribersCallable().call(request);
   *     for (Subscriber element : response.getSubscribersList()) {
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
  public final UnaryCallable<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersCallable() {
    return stub.listSubscribersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing subscriber, such as the endpoint URI or the data types
   * it's interested in.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; If the `endpoint_uri` or `endpoint_authorization`
   * field is included in the `update_mask`, the backend will re-verify the endpoint. The
   * verification process is the same as described in `CreateSubscriber`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; POST to the new or existing
   * `endpoint_uri` with the new or existing `Authorization` secret. Expects HTTP `201 Created`. 2.
   * &#42;&#42;Verification without Authorization:&#42;&#42; POST to the `endpoint_uri` without the
   * `Authorization` header. Expects HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass using the potentially updated values for the subscriber update to
   * succeed. If verification fails, the update will not be applied, and an error will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   Subscriber subscriber = Subscriber.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Subscriber response =
   *       dataSubscriptionServiceClient.updateSubscriberAsync(subscriber, updateMask).get();
   * }
   * }</pre>
   *
   * @param subscriber Required. The subscriber resource to update. Its 'name' field is mapped to
   *     the URI, and the value of the 'name' field should be of the form:
   *     "projects/{project}/subscribers/{subscriber_id}". The remaining fields of the Subscriber
   *     object represent the new values for the corresponding fields in the existing subscriber
   *     resource.
   * @param updateMask Optional. A field mask that specifies which fields of the Subscriber message
   *     are to be updated. This allows for partial updates. Supported fields: - endpoint_uri -
   *     subscriber_configs - endpoint_authorization
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscriber, UpdateSubscriberMetadata> updateSubscriberAsync(
      Subscriber subscriber, FieldMask updateMask) {
    UpdateSubscriberRequest request =
        UpdateSubscriberRequest.newBuilder()
            .setSubscriber(subscriber)
            .setUpdateMask(updateMask)
            .build();
    return updateSubscriberAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing subscriber, such as the endpoint URI or the data types
   * it's interested in.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; If the `endpoint_uri` or `endpoint_authorization`
   * field is included in the `update_mask`, the backend will re-verify the endpoint. The
   * verification process is the same as described in `CreateSubscriber`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; POST to the new or existing
   * `endpoint_uri` with the new or existing `Authorization` secret. Expects HTTP `201 Created`. 2.
   * &#42;&#42;Verification without Authorization:&#42;&#42; POST to the `endpoint_uri` without the
   * `Authorization` header. Expects HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass using the potentially updated values for the subscriber update to
   * succeed. If verification fails, the update will not be applied, and an error will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   UpdateSubscriberRequest request =
   *       UpdateSubscriberRequest.newBuilder()
   *           .setSubscriber(Subscriber.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Subscriber response = dataSubscriptionServiceClient.updateSubscriberAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subscriber, UpdateSubscriberMetadata> updateSubscriberAsync(
      UpdateSubscriberRequest request) {
    return updateSubscriberOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing subscriber, such as the endpoint URI or the data types
   * it's interested in.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; If the `endpoint_uri` or `endpoint_authorization`
   * field is included in the `update_mask`, the backend will re-verify the endpoint. The
   * verification process is the same as described in `CreateSubscriber`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; POST to the new or existing
   * `endpoint_uri` with the new or existing `Authorization` secret. Expects HTTP `201 Created`. 2.
   * &#42;&#42;Verification without Authorization:&#42;&#42; POST to the `endpoint_uri` without the
   * `Authorization` header. Expects HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass using the potentially updated values for the subscriber update to
   * succeed. If verification fails, the update will not be applied, and an error will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   UpdateSubscriberRequest request =
   *       UpdateSubscriberRequest.newBuilder()
   *           .setSubscriber(Subscriber.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Subscriber, UpdateSubscriberMetadata> future =
   *       dataSubscriptionServiceClient.updateSubscriberOperationCallable().futureCall(request);
   *   // Do something.
   *   Subscriber response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationCallable() {
    return stub.updateSubscriberOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the configuration of an existing subscriber, such as the endpoint URI or the data types
   * it's interested in.
   *
   * <p>&#42;&#42;Endpoint Verification:&#42;&#42; If the `endpoint_uri` or `endpoint_authorization`
   * field is included in the `update_mask`, the backend will re-verify the endpoint. The
   * verification process is the same as described in `CreateSubscriber`:
   *
   * <p>1. &#42;&#42;Verification with Authorization:&#42;&#42; POST to the new or existing
   * `endpoint_uri` with the new or existing `Authorization` secret. Expects HTTP `201 Created`. 2.
   * &#42;&#42;Verification without Authorization:&#42;&#42; POST to the `endpoint_uri` without the
   * `Authorization` header. Expects HTTP `401 Unauthorized` or `403 Forbidden`.
   *
   * <p>Both tests must pass using the potentially updated values for the subscriber update to
   * succeed. If verification fails, the update will not be applied, and an error will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   UpdateSubscriberRequest request =
   *       UpdateSubscriberRequest.newBuilder()
   *           .setSubscriber(Subscriber.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataSubscriptionServiceClient.updateSubscriberCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubscriberRequest, Operation> updateSubscriberCallable() {
    return stub.updateSubscriberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscriber registration. This will stop all notifications to the subscriber's
   * endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   SubscriberName name = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
   *   dataSubscriptionServiceClient.deleteSubscriberAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscriber to delete. Format:
   *     projects/{project}/subscribers/{subscriber} Example:
   *     projects/my-project/subscribers/my-subscriber-123 The {subscriber} ID is user-settable
   *     (4-36 characters, matching /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) or system-generated if not
   *     provided during creation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSubscriberMetadata> deleteSubscriberAsync(
      SubscriberName name) {
    DeleteSubscriberRequest request =
        DeleteSubscriberRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSubscriberAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscriber registration. This will stop all notifications to the subscriber's
   * endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   String name = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString();
   *   dataSubscriptionServiceClient.deleteSubscriberAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscriber to delete. Format:
   *     projects/{project}/subscribers/{subscriber} Example:
   *     projects/my-project/subscribers/my-subscriber-123 The {subscriber} ID is user-settable
   *     (4-36 characters, matching /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) or system-generated if not
   *     provided during creation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSubscriberMetadata> deleteSubscriberAsync(String name) {
    DeleteSubscriberRequest request = DeleteSubscriberRequest.newBuilder().setName(name).build();
    return deleteSubscriberAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscriber registration. This will stop all notifications to the subscriber's
   * endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   DeleteSubscriberRequest request =
   *       DeleteSubscriberRequest.newBuilder()
   *           .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setForce(true)
   *           .build();
   *   dataSubscriptionServiceClient.deleteSubscriberAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteSubscriberMetadata> deleteSubscriberAsync(
      DeleteSubscriberRequest request) {
    return deleteSubscriberOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscriber registration. This will stop all notifications to the subscriber's
   * endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   DeleteSubscriberRequest request =
   *       DeleteSubscriberRequest.newBuilder()
   *           .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, DeleteSubscriberMetadata> future =
   *       dataSubscriptionServiceClient.deleteSubscriberOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationCallable() {
    return stub.deleteSubscriberOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a subscriber registration. This will stop all notifications to the subscriber's
   * endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   DeleteSubscriberRequest request =
   *       DeleteSubscriberRequest.newBuilder()
   *           .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataSubscriptionServiceClient.deleteSubscriberCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSubscriberRequest, Operation> deleteSubscriberCallable() {
    return stub.deleteSubscriberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription for a specific user to a specific subscriber. This method requires the
   * subscriber to have a `SubscriptionCreatePolicy` set to `MANUAL` for the given data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
   *   CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
   *   String subscriptionId = "subscriptionId1478790936";
   *   Subscription response =
   *       dataSubscriptionServiceClient.createSubscription(parent, subscription, subscriptionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent subscriber. Format:
   *     projects/{project}/subscribers/{subscriber} The {subscriber} ID is user-settable (4-36
   *     characters, matching /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) if provided during creation, or
   *     system-generated otherwise.
   * @param subscription Required. The subscription to create.
   * @param subscriptionId Optional. The {subscription_id} is user-settable (4-36 chars, matching
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) or system-generated otherwise. If provided, the ID must
   *     be unique within the parent subscriber.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
      SubscriberName parent, CreateSubscriptionPayload subscription, String subscriptionId) {
    CreateSubscriptionRequest request =
        CreateSubscriptionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSubscription(subscription)
            .setSubscriptionId(subscriptionId)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription for a specific user to a specific subscriber. This method requires the
   * subscriber to have a `SubscriptionCreatePolicy` set to `MANUAL` for the given data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   String parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString();
   *   CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
   *   String subscriptionId = "subscriptionId1478790936";
   *   Subscription response =
   *       dataSubscriptionServiceClient.createSubscription(parent, subscription, subscriptionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent subscriber. Format:
   *     projects/{project}/subscribers/{subscriber} The {subscriber} ID is user-settable (4-36
   *     characters, matching /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) if provided during creation, or
   *     system-generated otherwise.
   * @param subscription Required. The subscription to create.
   * @param subscriptionId Optional. The {subscription_id} is user-settable (4-36 chars, matching
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) or system-generated otherwise. If provided, the ID must
   *     be unique within the parent subscriber.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(
      String parent, CreateSubscriptionPayload subscription, String subscriptionId) {
    CreateSubscriptionRequest request =
        CreateSubscriptionRequest.newBuilder()
            .setParent(parent)
            .setSubscription(subscription)
            .setSubscriptionId(subscriptionId)
            .build();
    return createSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription for a specific user to a specific subscriber. This method requires the
   * subscriber to have a `SubscriptionCreatePolicy` set to `MANUAL` for the given data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   CreateSubscriptionRequest request =
   *       CreateSubscriptionRequest.newBuilder()
   *           .setParent(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setSubscriptionId("subscriptionId1478790936")
   *           .setSubscription(CreateSubscriptionPayload.newBuilder().build())
   *           .build();
   *   Subscription response = dataSubscriptionServiceClient.createSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription createSubscription(CreateSubscriptionRequest request) {
    return createSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription for a specific user to a specific subscriber. This method requires the
   * subscriber to have a `SubscriptionCreatePolicy` set to `MANUAL` for the given data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   CreateSubscriptionRequest request =
   *       CreateSubscriptionRequest.newBuilder()
   *           .setParent(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setSubscriptionId("subscriptionId1478790936")
   *           .setSubscription(CreateSubscriptionPayload.newBuilder().build())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       dataSubscriptionServiceClient.createSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubscriptionRequest, Subscription> createSubscriptionCallable() {
    return stub.createSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all active subscriptions for a given subscriber. This can be filtered, for example, by
   * user or data type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
   *   for (Subscription element :
   *       dataSubscriptionServiceClient.listSubscriptions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent subscriber. Format:
   *     projects/{project}/subscribers/{subscriber} The {subscriber} ID is user-settable (4-36
   *     characters, matching /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) if provided during creation, or
   *     system-generated otherwise.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(SubscriberName parent) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all active subscriptions for a given subscriber. This can be filtered, for example, by
   * user or data type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   String parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString();
   *   for (Subscription element :
   *       dataSubscriptionServiceClient.listSubscriptions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent subscriber. Format:
   *     projects/{project}/subscribers/{subscriber} The {subscriber} ID is user-settable (4-36
   *     characters, matching /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) if provided during creation, or
   *     system-generated otherwise.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscriptionsPagedResponse listSubscriptions(String parent) {
    ListSubscriptionsRequest request =
        ListSubscriptionsRequest.newBuilder().setParent(parent).build();
    return listSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all active subscriptions for a given subscriber. This can be filtered, for example, by
   * user or data type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setParent(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subscription element :
   *       dataSubscriptionServiceClient.listSubscriptions(request).iterateAll()) {
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
   * Lists all active subscriptions for a given subscriber. This can be filtered, for example, by
   * user or data type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setParent(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subscription> future =
   *       dataSubscriptionServiceClient.listSubscriptionsPagedCallable().futureCall(request);
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
   * Lists all active subscriptions for a given subscriber. This can be filtered, for example, by
   * user or data type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   ListSubscriptionsRequest request =
   *       ListSubscriptionsRequest.newBuilder()
   *           .setParent(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubscriptionsResponse response =
   *         dataSubscriptionServiceClient.listSubscriptionsCallable().call(request);
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
   * Updates the data types for an existing user subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   Subscription subscription = Subscription.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Subscription response =
   *       dataSubscriptionServiceClient.updateSubscription(subscription, updateMask);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription to update. The subscription's `name` field is
   *     used to identify the subscription to update. Format:
   *     projects/{project}/subscribers/{subscriber}/subscriptions/{subscription}
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription updateSubscription(Subscription subscription, FieldMask updateMask) {
    UpdateSubscriptionRequest request =
        UpdateSubscriptionRequest.newBuilder()
            .setSubscription(subscription)
            .setUpdateMask(updateMask)
            .build();
    return updateSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the data types for an existing user subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Subscription response = dataSubscriptionServiceClient.updateSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subscription updateSubscription(UpdateSubscriptionRequest request) {
    return updateSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the data types for an existing user subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   UpdateSubscriptionRequest request =
   *       UpdateSubscriptionRequest.newBuilder()
   *           .setSubscription(Subscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Subscription> future =
   *       dataSubscriptionServiceClient.updateSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   Subscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    return stub.updateSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific user subscription, stopping notifications for this user to this subscriber.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]");
   *   dataSubscriptionServiceClient.deleteSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the subscription to delete. Format:
   *     `projects/{project}/subscribers/{subscriber}/subscriptions/{subscription}` Example:
   *     `projects/my-project/subscribers/my-subscriber-123/subscriptions/my-subscription-456` The
   *     {subscriber} ID is user-settable (4-36 characters, matching
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) if provided during creation, or system-generated
   *     otherwise. The {subscription} ID is user-settable (4-36 characters, matching
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) or system-generated if not provided during creation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(SubscriptionName name) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific user subscription, stopping notifications for this user to this subscriber.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   String name = SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString();
   *   dataSubscriptionServiceClient.deleteSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the subscription to delete. Format:
   *     `projects/{project}/subscribers/{subscriber}/subscriptions/{subscription}` Example:
   *     `projects/my-project/subscribers/my-subscriber-123/subscriptions/my-subscription-456` The
   *     {subscriber} ID is user-settable (4-36 characters, matching
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) if provided during creation, or system-generated
   *     otherwise. The {subscription} ID is user-settable (4-36 characters, matching
   *     /[a-z]([a-z0-9-]{2,34}[a-z0-9])/) or system-generated if not provided during creation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(String name) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder().setName(name).build();
    deleteSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific user subscription, stopping notifications for this user to this subscriber.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(
   *               SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   dataSubscriptionServiceClient.deleteSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSubscription(DeleteSubscriptionRequest request) {
    deleteSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific user subscription, stopping notifications for this user to this subscriber.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSubscriptionServiceClient dataSubscriptionServiceClient =
   *     DataSubscriptionServiceClient.create()) {
   *   DeleteSubscriptionRequest request =
   *       DeleteSubscriptionRequest.newBuilder()
   *           .setName(
   *               SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataSubscriptionServiceClient.deleteSubscriptionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    return stub.deleteSubscriptionCallable();
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

  public static class ListSubscribersPagedResponse
      extends AbstractPagedListResponse<
          ListSubscribersRequest,
          ListSubscribersResponse,
          Subscriber,
          ListSubscribersPage,
          ListSubscribersFixedSizeCollection> {

    public static ApiFuture<ListSubscribersPagedResponse> createAsync(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, Subscriber> context,
        ApiFuture<ListSubscribersResponse> futureResponse) {
      ApiFuture<ListSubscribersPage> futurePage =
          ListSubscribersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSubscribersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSubscribersPagedResponse(ListSubscribersPage page) {
      super(page, ListSubscribersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubscribersPage
      extends AbstractPage<
          ListSubscribersRequest, ListSubscribersResponse, Subscriber, ListSubscribersPage> {

    private ListSubscribersPage(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, Subscriber> context,
        ListSubscribersResponse response) {
      super(context, response);
    }

    private static ListSubscribersPage createEmptyPage() {
      return new ListSubscribersPage(null, null);
    }

    @Override
    protected ListSubscribersPage createPage(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, Subscriber> context,
        ListSubscribersResponse response) {
      return new ListSubscribersPage(context, response);
    }

    @Override
    public ApiFuture<ListSubscribersPage> createPageAsync(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, Subscriber> context,
        ApiFuture<ListSubscribersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubscribersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubscribersRequest,
          ListSubscribersResponse,
          Subscriber,
          ListSubscribersPage,
          ListSubscribersFixedSizeCollection> {

    private ListSubscribersFixedSizeCollection(
        List<ListSubscribersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubscribersFixedSizeCollection createEmptyCollection() {
      return new ListSubscribersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubscribersFixedSizeCollection createCollection(
        List<ListSubscribersPage> pages, int collectionSize) {
      return new ListSubscribersFixedSizeCollection(pages, collectionSize);
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
}
