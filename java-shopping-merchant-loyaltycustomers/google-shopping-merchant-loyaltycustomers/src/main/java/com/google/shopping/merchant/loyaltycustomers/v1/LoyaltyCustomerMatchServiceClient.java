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

package com.google.shopping.merchant.loyaltycustomers.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.loyaltycustomers.v1.stub.LoyaltyCustomerMatchServiceStub;
import com.google.shopping.merchant.loyaltycustomers.v1.stub.LoyaltyCustomerMatchServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages customer loyalty program memberships for merchants.
 *
 * <p>This service allows all merchants, including non-advertisers, to share their first-party
 * customer data of loyalty program members. Google uses this data to personalize organic free
 * listing shopping experiences, in compliance with the [Merchant Center Terms of
 * Service](https://support.google.com/merchants/answer/160173).
 *
 * <p>The service follows a non-standard, imperative pattern, exposing a single
 * `ManageLoyaltyCustomerMatch` method rather than conventional resource identifiers and CRUD
 * operations. This design protects user privacy by preventing the discovery of a customer's
 * presence or membership status through standard GET or LIST methods.
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
 * try (LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
 *     LoyaltyCustomerMatchServiceClient.create()) {
 *   ManageLoyaltyCustomerMatchRequest request =
 *       ManageLoyaltyCustomerMatchRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
 *           .build();
 *   ManageLoyaltyCustomerMatchResponse response =
 *       loyaltyCustomerMatchServiceClient.manageLoyaltyCustomerMatch(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LoyaltyCustomerMatchServiceClient object to clean up
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
 *      <td><p> ManageLoyaltyCustomerMatch</td>
 *      <td><p> Manages (inserts, updates, or removes) a customer's loyalty tier information.
 * <p>  This method serves as a single interface for all changes to a customer's loyalty status. The specific action (insert, update, or remove) is determined by the current state of the merchant-to-customer association and the `loyalty_tier` value provided in the request.
 * <p>  &#42;&#42;Operation Logic:&#42;&#42;
 * <ul>
 * <li>  &#42;&#42;Upsert (Insert/Update):&#42;&#42; Providing any valid tier other than `NON_MEMBER` will associate the customer with that tier. If an association already exists, it will be updated; otherwise, a new one will be created.
 * <li>  &#42;&#42;Removal:&#42;&#42; Setting `loyalty_tier` to `NON_MEMBER` will remove any existing loyalty association for the customer.
 * </ul>
 * <p>  &#42;&#42;Privacy Note:&#42;&#42; To protect user privacy, this method consistently returns a `200 OK` status with a default `LoyaltyCustomer` response if the customer's identifier cannot be matched to a Google account or if the user has not opted into loyalty personalization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> manageLoyaltyCustomerMatch(ManageLoyaltyCustomerMatchRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> manageLoyaltyCustomerMatchCallable()
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
 * LoyaltyCustomerMatchServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LoyaltyCustomerMatchServiceSettings loyaltyCustomerMatchServiceSettings =
 *     LoyaltyCustomerMatchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
 *     LoyaltyCustomerMatchServiceClient.create(loyaltyCustomerMatchServiceSettings);
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
 * LoyaltyCustomerMatchServiceSettings loyaltyCustomerMatchServiceSettings =
 *     LoyaltyCustomerMatchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
 *     LoyaltyCustomerMatchServiceClient.create(loyaltyCustomerMatchServiceSettings);
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
 * LoyaltyCustomerMatchServiceSettings loyaltyCustomerMatchServiceSettings =
 *     LoyaltyCustomerMatchServiceSettings.newHttpJsonBuilder().build();
 * LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
 *     LoyaltyCustomerMatchServiceClient.create(loyaltyCustomerMatchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LoyaltyCustomerMatchServiceClient implements BackgroundResource {
  private final @Nullable LoyaltyCustomerMatchServiceSettings settings;
  private final LoyaltyCustomerMatchServiceStub stub;

  /** Constructs an instance of LoyaltyCustomerMatchServiceClient with default settings. */
  public static final LoyaltyCustomerMatchServiceClient create() throws IOException {
    return create(LoyaltyCustomerMatchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LoyaltyCustomerMatchServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final LoyaltyCustomerMatchServiceClient create(
      LoyaltyCustomerMatchServiceSettings settings) throws IOException {
    return new LoyaltyCustomerMatchServiceClient(settings);
  }

  /**
   * Constructs an instance of LoyaltyCustomerMatchServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(LoyaltyCustomerMatchServiceSettings).
   */
  public static final LoyaltyCustomerMatchServiceClient create(
      LoyaltyCustomerMatchServiceStub stub) {
    return new LoyaltyCustomerMatchServiceClient(stub);
  }

  /**
   * Constructs an instance of LoyaltyCustomerMatchServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LoyaltyCustomerMatchServiceClient(LoyaltyCustomerMatchServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((LoyaltyCustomerMatchServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LoyaltyCustomerMatchServiceClient(LoyaltyCustomerMatchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable LoyaltyCustomerMatchServiceSettings getSettings() {
    return settings;
  }

  public LoyaltyCustomerMatchServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages (inserts, updates, or removes) a customer's loyalty tier information.
   *
   * <p>This method serves as a single interface for all changes to a customer's loyalty status. The
   * specific action (insert, update, or remove) is determined by the current state of the
   * merchant-to-customer association and the `loyalty_tier` value provided in the request.
   *
   * <p>&#42;&#42;Operation Logic:&#42;&#42;
   *
   * <ul>
   *   <li>&#42;&#42;Upsert (Insert/Update):&#42;&#42; Providing any valid tier other than
   *       `NON_MEMBER` will associate the customer with that tier. If an association already
   *       exists, it will be updated; otherwise, a new one will be created.
   *   <li>&#42;&#42;Removal:&#42;&#42; Setting `loyalty_tier` to `NON_MEMBER` will remove any
   *       existing loyalty association for the customer.
   * </ul>
   *
   * <p>&#42;&#42;Privacy Note:&#42;&#42; To protect user privacy, this method consistently returns
   * a `200 OK` status with a default `LoyaltyCustomer` response if the customer's identifier cannot
   * be matched to a Google account or if the user has not opted into loyalty personalization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
   *     LoyaltyCustomerMatchServiceClient.create()) {
   *   ManageLoyaltyCustomerMatchRequest request =
   *       ManageLoyaltyCustomerMatchRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
   *           .build();
   *   ManageLoyaltyCustomerMatchResponse response =
   *       loyaltyCustomerMatchServiceClient.manageLoyaltyCustomerMatch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManageLoyaltyCustomerMatchResponse manageLoyaltyCustomerMatch(
      ManageLoyaltyCustomerMatchRequest request) {
    return manageLoyaltyCustomerMatchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manages (inserts, updates, or removes) a customer's loyalty tier information.
   *
   * <p>This method serves as a single interface for all changes to a customer's loyalty status. The
   * specific action (insert, update, or remove) is determined by the current state of the
   * merchant-to-customer association and the `loyalty_tier` value provided in the request.
   *
   * <p>&#42;&#42;Operation Logic:&#42;&#42;
   *
   * <ul>
   *   <li>&#42;&#42;Upsert (Insert/Update):&#42;&#42; Providing any valid tier other than
   *       `NON_MEMBER` will associate the customer with that tier. If an association already
   *       exists, it will be updated; otherwise, a new one will be created.
   *   <li>&#42;&#42;Removal:&#42;&#42; Setting `loyalty_tier` to `NON_MEMBER` will remove any
   *       existing loyalty association for the customer.
   * </ul>
   *
   * <p>&#42;&#42;Privacy Note:&#42;&#42; To protect user privacy, this method consistently returns
   * a `200 OK` status with a default `LoyaltyCustomer` response if the customer's identifier cannot
   * be matched to a Google account or if the user has not opted into loyalty personalization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
   *     LoyaltyCustomerMatchServiceClient.create()) {
   *   ManageLoyaltyCustomerMatchRequest request =
   *       ManageLoyaltyCustomerMatchRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
   *           .build();
   *   ApiFuture<ManageLoyaltyCustomerMatchResponse> future =
   *       loyaltyCustomerMatchServiceClient
   *           .manageLoyaltyCustomerMatchCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ManageLoyaltyCustomerMatchResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ManageLoyaltyCustomerMatchRequest, ManageLoyaltyCustomerMatchResponse>
      manageLoyaltyCustomerMatchCallable() {
    return stub.manageLoyaltyCustomerMatchCallable();
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
}
