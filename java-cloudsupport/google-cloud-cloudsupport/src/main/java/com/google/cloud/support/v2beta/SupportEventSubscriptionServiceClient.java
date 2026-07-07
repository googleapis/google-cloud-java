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

package com.google.cloud.support.v2beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.stub.SupportEventSubscriptionServiceStub;
import com.google.cloud.support.v2beta.stub.SupportEventSubscriptionServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing customer support event subscriptions.
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
 * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
 *     SupportEventSubscriptionServiceClient.create()) {
 *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
 *   SupportEventSubscription supportEventSubscription =
 *       SupportEventSubscription.newBuilder().build();
 *   SupportEventSubscription response =
 *       supportEventSubscriptionServiceClient.createSupportEventSubscription(
 *           parent, supportEventSubscription);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SupportEventSubscriptionServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSupportEventSubscription</td>
 *      <td><p> Creates a support event subscription for an organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSupportEventSubscription(CreateSupportEventSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSupportEventSubscription(OrganizationName parent, SupportEventSubscription supportEventSubscription)
 *           <li><p> createSupportEventSubscription(String parent, SupportEventSubscription supportEventSubscription)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSupportEventSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSupportEventSubscription</td>
 *      <td><p> Gets a support event subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSupportEventSubscription(GetSupportEventSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSupportEventSubscription(SupportEventSubscriptionName name)
 *           <li><p> getSupportEventSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSupportEventSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSupportEventSubscriptions</td>
 *      <td><p> Lists support event subscriptions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSupportEventSubscriptions(ListSupportEventSubscriptionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSupportEventSubscriptions(OrganizationName parent)
 *           <li><p> listSupportEventSubscriptions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSupportEventSubscriptionsPagedCallable()
 *           <li><p> listSupportEventSubscriptionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSupportEventSubscription</td>
 *      <td><p> Updates a support event subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSupportEventSubscription(UpdateSupportEventSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSupportEventSubscription(SupportEventSubscription supportEventSubscription, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSupportEventSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSupportEventSubscription</td>
 *      <td><p> Soft deletes a support event subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSupportEventSubscription(DeleteSupportEventSubscriptionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSupportEventSubscription(SupportEventSubscriptionName name)
 *           <li><p> deleteSupportEventSubscription(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSupportEventSubscriptionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeleteSupportEventSubscription</td>
 *      <td><p> Undeletes a support event subscription.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeleteSupportEventSubscription(UndeleteSupportEventSubscriptionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeleteSupportEventSubscriptionCallable()
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
 * SupportEventSubscriptionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SupportEventSubscriptionServiceSettings supportEventSubscriptionServiceSettings =
 *     SupportEventSubscriptionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
 *     SupportEventSubscriptionServiceClient.create(supportEventSubscriptionServiceSettings);
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
 * SupportEventSubscriptionServiceSettings supportEventSubscriptionServiceSettings =
 *     SupportEventSubscriptionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
 *     SupportEventSubscriptionServiceClient.create(supportEventSubscriptionServiceSettings);
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
 * SupportEventSubscriptionServiceSettings supportEventSubscriptionServiceSettings =
 *     SupportEventSubscriptionServiceSettings.newHttpJsonBuilder().build();
 * SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
 *     SupportEventSubscriptionServiceClient.create(supportEventSubscriptionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SupportEventSubscriptionServiceClient implements BackgroundResource {
  private final SupportEventSubscriptionServiceSettings settings;
  private final SupportEventSubscriptionServiceStub stub;

  /** Constructs an instance of SupportEventSubscriptionServiceClient with default settings. */
  public static final SupportEventSubscriptionServiceClient create() throws IOException {
    return create(SupportEventSubscriptionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SupportEventSubscriptionServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final SupportEventSubscriptionServiceClient create(
      SupportEventSubscriptionServiceSettings settings) throws IOException {
    return new SupportEventSubscriptionServiceClient(settings);
  }

  /**
   * Constructs an instance of SupportEventSubscriptionServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(SupportEventSubscriptionServiceSettings).
   */
  public static final SupportEventSubscriptionServiceClient create(
      SupportEventSubscriptionServiceStub stub) {
    return new SupportEventSubscriptionServiceClient(stub);
  }

  /**
   * Constructs an instance of SupportEventSubscriptionServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SupportEventSubscriptionServiceClient(SupportEventSubscriptionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((SupportEventSubscriptionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SupportEventSubscriptionServiceClient(SupportEventSubscriptionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SupportEventSubscriptionServiceSettings getSettings() {
    return settings;
  }

  public SupportEventSubscriptionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a support event subscription for an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   SupportEventSubscription supportEventSubscription =
   *       SupportEventSubscription.newBuilder().build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.createSupportEventSubscription(
   *           parent, supportEventSubscription);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the support event subscription will be
   *     created. Format: organizations/{organization_id}
   * @param supportEventSubscription Required. The Pub/Sub configuration to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription createSupportEventSubscription(
      OrganizationName parent, SupportEventSubscription supportEventSubscription) {
    CreateSupportEventSubscriptionRequest request =
        CreateSupportEventSubscriptionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSupportEventSubscription(supportEventSubscription)
            .build();
    return createSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a support event subscription for an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   SupportEventSubscription supportEventSubscription =
   *       SupportEventSubscription.newBuilder().build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.createSupportEventSubscription(
   *           parent, supportEventSubscription);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the support event subscription will be
   *     created. Format: organizations/{organization_id}
   * @param supportEventSubscription Required. The Pub/Sub configuration to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription createSupportEventSubscription(
      String parent, SupportEventSubscription supportEventSubscription) {
    CreateSupportEventSubscriptionRequest request =
        CreateSupportEventSubscriptionRequest.newBuilder()
            .setParent(parent)
            .setSupportEventSubscription(supportEventSubscription)
            .build();
    return createSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a support event subscription for an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   CreateSupportEventSubscriptionRequest request =
   *       CreateSupportEventSubscriptionRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setSupportEventSubscription(SupportEventSubscription.newBuilder().build())
   *           .build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.createSupportEventSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription createSupportEventSubscription(
      CreateSupportEventSubscriptionRequest request) {
    return createSupportEventSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a support event subscription for an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   CreateSupportEventSubscriptionRequest request =
   *       CreateSupportEventSubscriptionRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setSupportEventSubscription(SupportEventSubscription.newBuilder().build())
   *           .build();
   *   ApiFuture<SupportEventSubscription> future =
   *       supportEventSubscriptionServiceClient
   *           .createSupportEventSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SupportEventSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionCallable() {
    return stub.createSupportEventSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   SupportEventSubscriptionName name =
   *       SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.getSupportEventSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the support event subscription to retrieve. Format:
   *     organizations/{organization_id}/supportEventSubscriptions/{subscription_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription getSupportEventSubscription(
      SupportEventSubscriptionName name) {
    GetSupportEventSubscriptionRequest request =
        GetSupportEventSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   String name =
   *       SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *           .toString();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.getSupportEventSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the support event subscription to retrieve. Format:
   *     organizations/{organization_id}/supportEventSubscriptions/{subscription_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription getSupportEventSubscription(String name) {
    GetSupportEventSubscriptionRequest request =
        GetSupportEventSubscriptionRequest.newBuilder().setName(name).build();
    return getSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   GetSupportEventSubscriptionRequest request =
   *       GetSupportEventSubscriptionRequest.newBuilder()
   *           .setName(
   *               SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.getSupportEventSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription getSupportEventSubscription(
      GetSupportEventSubscriptionRequest request) {
    return getSupportEventSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   GetSupportEventSubscriptionRequest request =
   *       GetSupportEventSubscriptionRequest.newBuilder()
   *           .setName(
   *               SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SupportEventSubscription> future =
   *       supportEventSubscriptionServiceClient
   *           .getSupportEventSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SupportEventSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionCallable() {
    return stub.getSupportEventSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists support event subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (SupportEventSubscription element :
   *       supportEventSubscriptionServiceClient
   *           .listSupportEventSubscriptions(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The fully qualified name of the Cloud resource to list support event
   *     subscriptions under. Format: organizations/{organization_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSupportEventSubscriptionsPagedResponse listSupportEventSubscriptions(
      OrganizationName parent) {
    ListSupportEventSubscriptionsRequest request =
        ListSupportEventSubscriptionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSupportEventSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists support event subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (SupportEventSubscription element :
   *       supportEventSubscriptionServiceClient
   *           .listSupportEventSubscriptions(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The fully qualified name of the Cloud resource to list support event
   *     subscriptions under. Format: organizations/{organization_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSupportEventSubscriptionsPagedResponse listSupportEventSubscriptions(
      String parent) {
    ListSupportEventSubscriptionsRequest request =
        ListSupportEventSubscriptionsRequest.newBuilder().setParent(parent).build();
    return listSupportEventSubscriptions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists support event subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   ListSupportEventSubscriptionsRequest request =
   *       ListSupportEventSubscriptionsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setShowDeleted(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SupportEventSubscription element :
   *       supportEventSubscriptionServiceClient
   *           .listSupportEventSubscriptions(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSupportEventSubscriptionsPagedResponse listSupportEventSubscriptions(
      ListSupportEventSubscriptionsRequest request) {
    return listSupportEventSubscriptionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists support event subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   ListSupportEventSubscriptionsRequest request =
   *       ListSupportEventSubscriptionsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setShowDeleted(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SupportEventSubscription> future =
   *       supportEventSubscriptionServiceClient
   *           .listSupportEventSubscriptionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SupportEventSubscription element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsPagedCallable() {
    return stub.listSupportEventSubscriptionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists support event subscriptions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   ListSupportEventSubscriptionsRequest request =
   *       ListSupportEventSubscriptionsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setShowDeleted(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSupportEventSubscriptionsResponse response =
   *         supportEventSubscriptionServiceClient
   *             .listSupportEventSubscriptionsCallable()
   *             .call(request);
   *     for (SupportEventSubscription element : response.getSupportEventSubscriptionsList()) {
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
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsCallable() {
    return stub.listSupportEventSubscriptionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   SupportEventSubscription supportEventSubscription =
   *       SupportEventSubscription.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.updateSupportEventSubscription(
   *           supportEventSubscription, updateMask);
   * }
   * }</pre>
   *
   * @param supportEventSubscription Required. The support event subscription to update. The `name`
   *     field is used to identify the configuration to update.
   * @param updateMask Optional. The list of fields to update. The only supported value is
   *     pub_sub_topic.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription updateSupportEventSubscription(
      SupportEventSubscription supportEventSubscription, FieldMask updateMask) {
    UpdateSupportEventSubscriptionRequest request =
        UpdateSupportEventSubscriptionRequest.newBuilder()
            .setSupportEventSubscription(supportEventSubscription)
            .setUpdateMask(updateMask)
            .build();
    return updateSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   UpdateSupportEventSubscriptionRequest request =
   *       UpdateSupportEventSubscriptionRequest.newBuilder()
   *           .setSupportEventSubscription(SupportEventSubscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.updateSupportEventSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription updateSupportEventSubscription(
      UpdateSupportEventSubscriptionRequest request) {
    return updateSupportEventSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   UpdateSupportEventSubscriptionRequest request =
   *       UpdateSupportEventSubscriptionRequest.newBuilder()
   *           .setSupportEventSubscription(SupportEventSubscription.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SupportEventSubscription> future =
   *       supportEventSubscriptionServiceClient
   *           .updateSupportEventSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SupportEventSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionCallable() {
    return stub.updateSupportEventSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Soft deletes a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   SupportEventSubscriptionName name =
   *       SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.deleteSupportEventSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the support event subscription to delete. Format:
   *     organizations/{organization_id}/supportEventSubscriptions/{subscription_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription deleteSupportEventSubscription(
      SupportEventSubscriptionName name) {
    DeleteSupportEventSubscriptionRequest request =
        DeleteSupportEventSubscriptionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Soft deletes a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   String name =
   *       SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *           .toString();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.deleteSupportEventSubscription(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the support event subscription to delete. Format:
   *     organizations/{organization_id}/supportEventSubscriptions/{subscription_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription deleteSupportEventSubscription(String name) {
    DeleteSupportEventSubscriptionRequest request =
        DeleteSupportEventSubscriptionRequest.newBuilder().setName(name).build();
    return deleteSupportEventSubscription(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Soft deletes a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   DeleteSupportEventSubscriptionRequest request =
   *       DeleteSupportEventSubscriptionRequest.newBuilder()
   *           .setName(
   *               SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.deleteSupportEventSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription deleteSupportEventSubscription(
      DeleteSupportEventSubscriptionRequest request) {
    return deleteSupportEventSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Soft deletes a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   DeleteSupportEventSubscriptionRequest request =
   *       DeleteSupportEventSubscriptionRequest.newBuilder()
   *           .setName(
   *               SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SupportEventSubscription> future =
   *       supportEventSubscriptionServiceClient
   *           .deleteSupportEventSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SupportEventSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionCallable() {
    return stub.deleteSupportEventSubscriptionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   UndeleteSupportEventSubscriptionRequest request =
   *       UndeleteSupportEventSubscriptionRequest.newBuilder()
   *           .setName(
   *               SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   SupportEventSubscription response =
   *       supportEventSubscriptionServiceClient.undeleteSupportEventSubscription(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportEventSubscription undeleteSupportEventSubscription(
      UndeleteSupportEventSubscriptionRequest request) {
    return undeleteSupportEventSubscriptionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a support event subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SupportEventSubscriptionServiceClient supportEventSubscriptionServiceClient =
   *     SupportEventSubscriptionServiceClient.create()) {
   *   UndeleteSupportEventSubscriptionRequest request =
   *       UndeleteSupportEventSubscriptionRequest.newBuilder()
   *           .setName(
   *               SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SupportEventSubscription> future =
   *       supportEventSubscriptionServiceClient
   *           .undeleteSupportEventSubscriptionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SupportEventSubscription response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionCallable() {
    return stub.undeleteSupportEventSubscriptionCallable();
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

  public static class ListSupportEventSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          SupportEventSubscription,
          ListSupportEventSubscriptionsPage,
          ListSupportEventSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListSupportEventSubscriptionsPagedResponse> createAsync(
        PageContext<
                ListSupportEventSubscriptionsRequest,
                ListSupportEventSubscriptionsResponse,
                SupportEventSubscription>
            context,
        ApiFuture<ListSupportEventSubscriptionsResponse> futureResponse) {
      ApiFuture<ListSupportEventSubscriptionsPage> futurePage =
          ListSupportEventSubscriptionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSupportEventSubscriptionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSupportEventSubscriptionsPagedResponse(ListSupportEventSubscriptionsPage page) {
      super(page, ListSupportEventSubscriptionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSupportEventSubscriptionsPage
      extends AbstractPage<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          SupportEventSubscription,
          ListSupportEventSubscriptionsPage> {

    private ListSupportEventSubscriptionsPage(
        PageContext<
                ListSupportEventSubscriptionsRequest,
                ListSupportEventSubscriptionsResponse,
                SupportEventSubscription>
            context,
        ListSupportEventSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListSupportEventSubscriptionsPage createEmptyPage() {
      return new ListSupportEventSubscriptionsPage(null, null);
    }

    @Override
    protected ListSupportEventSubscriptionsPage createPage(
        PageContext<
                ListSupportEventSubscriptionsRequest,
                ListSupportEventSubscriptionsResponse,
                SupportEventSubscription>
            context,
        ListSupportEventSubscriptionsResponse response) {
      return new ListSupportEventSubscriptionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSupportEventSubscriptionsPage> createPageAsync(
        PageContext<
                ListSupportEventSubscriptionsRequest,
                ListSupportEventSubscriptionsResponse,
                SupportEventSubscription>
            context,
        ApiFuture<ListSupportEventSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSupportEventSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSupportEventSubscriptionsRequest,
          ListSupportEventSubscriptionsResponse,
          SupportEventSubscription,
          ListSupportEventSubscriptionsPage,
          ListSupportEventSubscriptionsFixedSizeCollection> {

    private ListSupportEventSubscriptionsFixedSizeCollection(
        List<ListSupportEventSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSupportEventSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListSupportEventSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSupportEventSubscriptionsFixedSizeCollection createCollection(
        List<ListSupportEventSubscriptionsPage> pages, int collectionSize) {
      return new ListSupportEventSubscriptionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
