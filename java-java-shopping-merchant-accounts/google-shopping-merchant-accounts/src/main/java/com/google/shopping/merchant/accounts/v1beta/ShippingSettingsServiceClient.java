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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1beta.stub.ShippingSettingsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.ShippingSettingsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to get method call shipping setting information per Merchant API
 * method.
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
 * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
 *     ShippingSettingsServiceClient.create()) {
 *   ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");
 *   ShippingSettings response = shippingSettingsServiceClient.getShippingSettings(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ShippingSettingsServiceClient object to clean up
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
 *      <td><p> GetShippingSettings</td>
 *      <td><p> Retrieve shipping setting information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getShippingSettings(GetShippingSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getShippingSettings(ShippingSettingsName name)
 *           <li><p> getShippingSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getShippingSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InsertShippingSettings</td>
 *      <td><p> Replace the shipping setting of a merchant with the request shipping setting. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertShippingSettings(InsertShippingSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertShippingSettingsCallable()
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
 * ShippingSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ShippingSettingsServiceSettings shippingSettingsServiceSettings =
 *     ShippingSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ShippingSettingsServiceClient shippingSettingsServiceClient =
 *     ShippingSettingsServiceClient.create(shippingSettingsServiceSettings);
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
 * ShippingSettingsServiceSettings shippingSettingsServiceSettings =
 *     ShippingSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ShippingSettingsServiceClient shippingSettingsServiceClient =
 *     ShippingSettingsServiceClient.create(shippingSettingsServiceSettings);
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
 * ShippingSettingsServiceSettings shippingSettingsServiceSettings =
 *     ShippingSettingsServiceSettings.newHttpJsonBuilder().build();
 * ShippingSettingsServiceClient shippingSettingsServiceClient =
 *     ShippingSettingsServiceClient.create(shippingSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ShippingSettingsServiceClient implements BackgroundResource {
  private final ShippingSettingsServiceSettings settings;
  private final ShippingSettingsServiceStub stub;

  /** Constructs an instance of ShippingSettingsServiceClient with default settings. */
  public static final ShippingSettingsServiceClient create() throws IOException {
    return create(ShippingSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ShippingSettingsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ShippingSettingsServiceClient create(ShippingSettingsServiceSettings settings)
      throws IOException {
    return new ShippingSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of ShippingSettingsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ShippingSettingsServiceSettings).
   */
  public static final ShippingSettingsServiceClient create(ShippingSettingsServiceStub stub) {
    return new ShippingSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of ShippingSettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ShippingSettingsServiceClient(ShippingSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ShippingSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ShippingSettingsServiceClient(ShippingSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ShippingSettingsServiceSettings getSettings() {
    return settings;
  }

  public ShippingSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve shipping setting information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
   *     ShippingSettingsServiceClient.create()) {
   *   ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");
   *   ShippingSettings response = shippingSettingsServiceClient.getShippingSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the shipping setting to retrieve. Format:
   *     `accounts/{account}/shippingsetting`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShippingSettings getShippingSettings(ShippingSettingsName name) {
    GetShippingSettingsRequest request =
        GetShippingSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getShippingSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve shipping setting information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
   *     ShippingSettingsServiceClient.create()) {
   *   String name = ShippingSettingsName.of("[ACCOUNT]").toString();
   *   ShippingSettings response = shippingSettingsServiceClient.getShippingSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the shipping setting to retrieve. Format:
   *     `accounts/{account}/shippingsetting`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShippingSettings getShippingSettings(String name) {
    GetShippingSettingsRequest request =
        GetShippingSettingsRequest.newBuilder().setName(name).build();
    return getShippingSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve shipping setting information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
   *     ShippingSettingsServiceClient.create()) {
   *   GetShippingSettingsRequest request =
   *       GetShippingSettingsRequest.newBuilder()
   *           .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
   *           .build();
   *   ShippingSettings response = shippingSettingsServiceClient.getShippingSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShippingSettings getShippingSettings(GetShippingSettingsRequest request) {
    return getShippingSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve shipping setting information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
   *     ShippingSettingsServiceClient.create()) {
   *   GetShippingSettingsRequest request =
   *       GetShippingSettingsRequest.newBuilder()
   *           .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<ShippingSettings> future =
   *       shippingSettingsServiceClient.getShippingSettingsCallable().futureCall(request);
   *   // Do something.
   *   ShippingSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetShippingSettingsRequest, ShippingSettings>
      getShippingSettingsCallable() {
    return stub.getShippingSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replace the shipping setting of a merchant with the request shipping setting. Executing this
   * method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
   *     ShippingSettingsServiceClient.create()) {
   *   InsertShippingSettingsRequest request =
   *       InsertShippingSettingsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setShippingSetting(ShippingSettings.newBuilder().build())
   *           .build();
   *   ShippingSettings response = shippingSettingsServiceClient.insertShippingSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShippingSettings insertShippingSettings(InsertShippingSettingsRequest request) {
    return insertShippingSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replace the shipping setting of a merchant with the request shipping setting. Executing this
   * method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ShippingSettingsServiceClient shippingSettingsServiceClient =
   *     ShippingSettingsServiceClient.create()) {
   *   InsertShippingSettingsRequest request =
   *       InsertShippingSettingsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setShippingSetting(ShippingSettings.newBuilder().build())
   *           .build();
   *   ApiFuture<ShippingSettings> future =
   *       shippingSettingsServiceClient.insertShippingSettingsCallable().futureCall(request);
   *   // Do something.
   *   ShippingSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertShippingSettingsRequest, ShippingSettings>
      insertShippingSettingsCallable() {
    return stub.insertShippingSettingsCallable();
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
