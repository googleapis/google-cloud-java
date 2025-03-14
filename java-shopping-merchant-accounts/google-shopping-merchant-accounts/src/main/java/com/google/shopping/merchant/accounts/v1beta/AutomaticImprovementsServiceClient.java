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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.AutomaticImprovementsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.AutomaticImprovementsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage the automatic improvements of an account. The automatic
 * improvements of the account can be used to automatically update products, improve images and
 * shipping.
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
 * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
 *     AutomaticImprovementsServiceClient.create()) {
 *   AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");
 *   AutomaticImprovements response =
 *       automaticImprovementsServiceClient.getAutomaticImprovements(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AutomaticImprovementsServiceClient object to clean up
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
 *      <td><p> GetAutomaticImprovements</td>
 *      <td><p> Retrieves the automatic improvements of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutomaticImprovements(GetAutomaticImprovementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutomaticImprovements(AutomaticImprovementsName name)
 *           <li><p> getAutomaticImprovements(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutomaticImprovementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAutomaticImprovements</td>
 *      <td><p> Updates the automatic improvements of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAutomaticImprovements(UpdateAutomaticImprovementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAutomaticImprovements(AutomaticImprovements automaticImprovements, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAutomaticImprovementsCallable()
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
 * AutomaticImprovementsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AutomaticImprovementsServiceSettings automaticImprovementsServiceSettings =
 *     AutomaticImprovementsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
 *     AutomaticImprovementsServiceClient.create(automaticImprovementsServiceSettings);
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
 * AutomaticImprovementsServiceSettings automaticImprovementsServiceSettings =
 *     AutomaticImprovementsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
 *     AutomaticImprovementsServiceClient.create(automaticImprovementsServiceSettings);
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
 * AutomaticImprovementsServiceSettings automaticImprovementsServiceSettings =
 *     AutomaticImprovementsServiceSettings.newHttpJsonBuilder().build();
 * AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
 *     AutomaticImprovementsServiceClient.create(automaticImprovementsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AutomaticImprovementsServiceClient implements BackgroundResource {
  private final AutomaticImprovementsServiceSettings settings;
  private final AutomaticImprovementsServiceStub stub;

  /** Constructs an instance of AutomaticImprovementsServiceClient with default settings. */
  public static final AutomaticImprovementsServiceClient create() throws IOException {
    return create(AutomaticImprovementsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutomaticImprovementsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AutomaticImprovementsServiceClient create(
      AutomaticImprovementsServiceSettings settings) throws IOException {
    return new AutomaticImprovementsServiceClient(settings);
  }

  /**
   * Constructs an instance of AutomaticImprovementsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(AutomaticImprovementsServiceSettings).
   */
  public static final AutomaticImprovementsServiceClient create(
      AutomaticImprovementsServiceStub stub) {
    return new AutomaticImprovementsServiceClient(stub);
  }

  /**
   * Constructs an instance of AutomaticImprovementsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AutomaticImprovementsServiceClient(AutomaticImprovementsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((AutomaticImprovementsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AutomaticImprovementsServiceClient(AutomaticImprovementsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutomaticImprovementsServiceSettings getSettings() {
    return settings;
  }

  public AutomaticImprovementsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");
   *   AutomaticImprovements response =
   *       automaticImprovementsServiceClient.getAutomaticImprovements(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the automatic improvements. Format:
   *     `accounts/{account}/automaticImprovements`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomaticImprovements getAutomaticImprovements(AutomaticImprovementsName name) {
    GetAutomaticImprovementsRequest request =
        GetAutomaticImprovementsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAutomaticImprovements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   String name = AutomaticImprovementsName.of("[ACCOUNT]").toString();
   *   AutomaticImprovements response =
   *       automaticImprovementsServiceClient.getAutomaticImprovements(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the automatic improvements. Format:
   *     `accounts/{account}/automaticImprovements`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomaticImprovements getAutomaticImprovements(String name) {
    GetAutomaticImprovementsRequest request =
        GetAutomaticImprovementsRequest.newBuilder().setName(name).build();
    return getAutomaticImprovements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   GetAutomaticImprovementsRequest request =
   *       GetAutomaticImprovementsRequest.newBuilder()
   *           .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
   *           .build();
   *   AutomaticImprovements response =
   *       automaticImprovementsServiceClient.getAutomaticImprovements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomaticImprovements getAutomaticImprovements(
      GetAutomaticImprovementsRequest request) {
    return getAutomaticImprovementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   GetAutomaticImprovementsRequest request =
   *       GetAutomaticImprovementsRequest.newBuilder()
   *           .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<AutomaticImprovements> future =
   *       automaticImprovementsServiceClient.getAutomaticImprovementsCallable().futureCall(request);
   *   // Do something.
   *   AutomaticImprovements response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsCallable() {
    return stub.getAutomaticImprovementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   AutomaticImprovements automaticImprovements = AutomaticImprovements.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AutomaticImprovements response =
   *       automaticImprovementsServiceClient.updateAutomaticImprovements(
   *           automaticImprovements, updateMask);
   * }
   * }</pre>
   *
   * @param automaticImprovements Required. The new version of the automatic imrovements.
   * @param updateMask Required. List of fields being updated. The following fields are supported
   *     (in both `snake_case` and `lowerCamelCase`):
   *     <p>- `item_updates` - `item_updates.account_level_settings` - `image_improvements` -
   *     `image_improvements.account_level_settings` - `shipping_improvements` -
   *     `shipping_improvements.allow_shipping_improvements`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomaticImprovements updateAutomaticImprovements(
      AutomaticImprovements automaticImprovements, FieldMask updateMask) {
    UpdateAutomaticImprovementsRequest request =
        UpdateAutomaticImprovementsRequest.newBuilder()
            .setAutomaticImprovements(automaticImprovements)
            .setUpdateMask(updateMask)
            .build();
    return updateAutomaticImprovements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   UpdateAutomaticImprovementsRequest request =
   *       UpdateAutomaticImprovementsRequest.newBuilder()
   *           .setAutomaticImprovements(AutomaticImprovements.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AutomaticImprovements response =
   *       automaticImprovementsServiceClient.updateAutomaticImprovements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutomaticImprovements updateAutomaticImprovements(
      UpdateAutomaticImprovementsRequest request) {
    return updateAutomaticImprovementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the automatic improvements of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutomaticImprovementsServiceClient automaticImprovementsServiceClient =
   *     AutomaticImprovementsServiceClient.create()) {
   *   UpdateAutomaticImprovementsRequest request =
   *       UpdateAutomaticImprovementsRequest.newBuilder()
   *           .setAutomaticImprovements(AutomaticImprovements.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AutomaticImprovements> future =
   *       automaticImprovementsServiceClient
   *           .updateAutomaticImprovementsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AutomaticImprovements response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsCallable() {
    return stub.updateAutomaticImprovementsCallable();
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
