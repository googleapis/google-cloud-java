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

package com.google.shopping.merchant.lfp.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.lfp.v1.stub.LfpMerchantStateServiceStub;
import com.google.shopping.merchant.lfp.v1.stub.LfpMerchantStateServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to get the state of a merchant.
 *
 * <p>For information about onboarding a retailer, see [How to onboard a
 * retailer](https://support.google.com/merchants/answer/15243706).
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
 * try (LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
 *     LfpMerchantStateServiceClient.create()) {
 *   LfpMerchantStateName name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]");
 *   LfpMerchantState response = lfpMerchantStateServiceClient.getLfpMerchantState(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LfpMerchantStateServiceClient object to clean up
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
 *      <td><p> GetLfpMerchantState</td>
 *      <td><p> Gets the LFP state of a merchant</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLfpMerchantState(GetLfpMerchantStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLfpMerchantState(LfpMerchantStateName name)
 *           <li><p> getLfpMerchantState(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLfpMerchantStateCallable()
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
 * LfpMerchantStateServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LfpMerchantStateServiceSettings lfpMerchantStateServiceSettings =
 *     LfpMerchantStateServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
 *     LfpMerchantStateServiceClient.create(lfpMerchantStateServiceSettings);
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
 * LfpMerchantStateServiceSettings lfpMerchantStateServiceSettings =
 *     LfpMerchantStateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
 *     LfpMerchantStateServiceClient.create(lfpMerchantStateServiceSettings);
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
 * LfpMerchantStateServiceSettings lfpMerchantStateServiceSettings =
 *     LfpMerchantStateServiceSettings.newHttpJsonBuilder().build();
 * LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
 *     LfpMerchantStateServiceClient.create(lfpMerchantStateServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LfpMerchantStateServiceClient implements BackgroundResource {
  private final LfpMerchantStateServiceSettings settings;
  private final LfpMerchantStateServiceStub stub;

  /** Constructs an instance of LfpMerchantStateServiceClient with default settings. */
  public static final LfpMerchantStateServiceClient create() throws IOException {
    return create(LfpMerchantStateServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LfpMerchantStateServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LfpMerchantStateServiceClient create(LfpMerchantStateServiceSettings settings)
      throws IOException {
    return new LfpMerchantStateServiceClient(settings);
  }

  /**
   * Constructs an instance of LfpMerchantStateServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LfpMerchantStateServiceSettings).
   */
  public static final LfpMerchantStateServiceClient create(LfpMerchantStateServiceStub stub) {
    return new LfpMerchantStateServiceClient(stub);
  }

  /**
   * Constructs an instance of LfpMerchantStateServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LfpMerchantStateServiceClient(LfpMerchantStateServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((LfpMerchantStateServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LfpMerchantStateServiceClient(LfpMerchantStateServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LfpMerchantStateServiceSettings getSettings() {
    return settings;
  }

  public LfpMerchantStateServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the LFP state of a merchant
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
   *     LfpMerchantStateServiceClient.create()) {
   *   LfpMerchantStateName name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]");
   *   LfpMerchantState response = lfpMerchantStateServiceClient.getLfpMerchantState(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the state to retrieve. Format:
   *     `accounts/{account}/lfpMerchantStates/{target_merchant}`. For example,
   *     `accounts/123456/lfpMerchantStates/567890`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpMerchantState getLfpMerchantState(LfpMerchantStateName name) {
    GetLfpMerchantStateRequest request =
        GetLfpMerchantStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLfpMerchantState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the LFP state of a merchant
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
   *     LfpMerchantStateServiceClient.create()) {
   *   String name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString();
   *   LfpMerchantState response = lfpMerchantStateServiceClient.getLfpMerchantState(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the state to retrieve. Format:
   *     `accounts/{account}/lfpMerchantStates/{target_merchant}`. For example,
   *     `accounts/123456/lfpMerchantStates/567890`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpMerchantState getLfpMerchantState(String name) {
    GetLfpMerchantStateRequest request =
        GetLfpMerchantStateRequest.newBuilder().setName(name).build();
    return getLfpMerchantState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the LFP state of a merchant
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
   *     LfpMerchantStateServiceClient.create()) {
   *   GetLfpMerchantStateRequest request =
   *       GetLfpMerchantStateRequest.newBuilder()
   *           .setName(LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString())
   *           .build();
   *   LfpMerchantState response = lfpMerchantStateServiceClient.getLfpMerchantState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpMerchantState getLfpMerchantState(GetLfpMerchantStateRequest request) {
    return getLfpMerchantStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the LFP state of a merchant
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpMerchantStateServiceClient lfpMerchantStateServiceClient =
   *     LfpMerchantStateServiceClient.create()) {
   *   GetLfpMerchantStateRequest request =
   *       GetLfpMerchantStateRequest.newBuilder()
   *           .setName(LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString())
   *           .build();
   *   ApiFuture<LfpMerchantState> future =
   *       lfpMerchantStateServiceClient.getLfpMerchantStateCallable().futureCall(request);
   *   // Do something.
   *   LfpMerchantState response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLfpMerchantStateRequest, LfpMerchantState>
      getLfpMerchantStateCallable() {
    return stub.getLfpMerchantStateCallable();
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
