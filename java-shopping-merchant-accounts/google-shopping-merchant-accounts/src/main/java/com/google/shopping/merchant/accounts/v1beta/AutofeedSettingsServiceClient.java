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
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.AutofeedSettingsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.AutofeedSettingsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support
 * [autofeed](https://support.google.com/merchants/answer/7538732) setting.
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
 * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
 *     AutofeedSettingsServiceClient.create()) {
 *   AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");
 *   AutofeedSettings response = autofeedSettingsServiceClient.getAutofeedSettings(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AutofeedSettingsServiceClient object to clean up
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
 *      <td><p> GetAutofeedSettings</td>
 *      <td><p> Retrieves the autofeed settings of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutofeedSettings(GetAutofeedSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutofeedSettings(AutofeedSettingsName name)
 *           <li><p> getAutofeedSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutofeedSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAutofeedSettings</td>
 *      <td><p> Updates the autofeed settings of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAutofeedSettings(UpdateAutofeedSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAutofeedSettings(AutofeedSettings autofeedSettings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAutofeedSettingsCallable()
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
 * AutofeedSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AutofeedSettingsServiceSettings autofeedSettingsServiceSettings =
 *     AutofeedSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutofeedSettingsServiceClient autofeedSettingsServiceClient =
 *     AutofeedSettingsServiceClient.create(autofeedSettingsServiceSettings);
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
 * AutofeedSettingsServiceSettings autofeedSettingsServiceSettings =
 *     AutofeedSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutofeedSettingsServiceClient autofeedSettingsServiceClient =
 *     AutofeedSettingsServiceClient.create(autofeedSettingsServiceSettings);
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
 * AutofeedSettingsServiceSettings autofeedSettingsServiceSettings =
 *     AutofeedSettingsServiceSettings.newHttpJsonBuilder().build();
 * AutofeedSettingsServiceClient autofeedSettingsServiceClient =
 *     AutofeedSettingsServiceClient.create(autofeedSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AutofeedSettingsServiceClient implements BackgroundResource {
  private final AutofeedSettingsServiceSettings settings;
  private final AutofeedSettingsServiceStub stub;

  /** Constructs an instance of AutofeedSettingsServiceClient with default settings. */
  public static final AutofeedSettingsServiceClient create() throws IOException {
    return create(AutofeedSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutofeedSettingsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AutofeedSettingsServiceClient create(AutofeedSettingsServiceSettings settings)
      throws IOException {
    return new AutofeedSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of AutofeedSettingsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AutofeedSettingsServiceSettings).
   */
  public static final AutofeedSettingsServiceClient create(AutofeedSettingsServiceStub stub) {
    return new AutofeedSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of AutofeedSettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AutofeedSettingsServiceClient(AutofeedSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AutofeedSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AutofeedSettingsServiceClient(AutofeedSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutofeedSettingsServiceSettings getSettings() {
    return settings;
  }

  public AutofeedSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");
   *   AutofeedSettings response = autofeedSettingsServiceClient.getAutofeedSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the autofeed settings. Format:
   *     `accounts/{account}/autofeedSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutofeedSettings getAutofeedSettings(AutofeedSettingsName name) {
    GetAutofeedSettingsRequest request =
        GetAutofeedSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAutofeedSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   String name = AutofeedSettingsName.of("[ACCOUNT]").toString();
   *   AutofeedSettings response = autofeedSettingsServiceClient.getAutofeedSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the autofeed settings. Format:
   *     `accounts/{account}/autofeedSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutofeedSettings getAutofeedSettings(String name) {
    GetAutofeedSettingsRequest request =
        GetAutofeedSettingsRequest.newBuilder().setName(name).build();
    return getAutofeedSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   GetAutofeedSettingsRequest request =
   *       GetAutofeedSettingsRequest.newBuilder()
   *           .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
   *           .build();
   *   AutofeedSettings response = autofeedSettingsServiceClient.getAutofeedSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutofeedSettings getAutofeedSettings(GetAutofeedSettingsRequest request) {
    return getAutofeedSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   GetAutofeedSettingsRequest request =
   *       GetAutofeedSettingsRequest.newBuilder()
   *           .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<AutofeedSettings> future =
   *       autofeedSettingsServiceClient.getAutofeedSettingsCallable().futureCall(request);
   *   // Do something.
   *   AutofeedSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutofeedSettingsRequest, AutofeedSettings>
      getAutofeedSettingsCallable() {
    return stub.getAutofeedSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   AutofeedSettings autofeedSettings = AutofeedSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AutofeedSettings response =
   *       autofeedSettingsServiceClient.updateAutofeedSettings(autofeedSettings, updateMask);
   * }
   * }</pre>
   *
   * @param autofeedSettings Required. The new version of the autofeed setting.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutofeedSettings updateAutofeedSettings(
      AutofeedSettings autofeedSettings, FieldMask updateMask) {
    UpdateAutofeedSettingsRequest request =
        UpdateAutofeedSettingsRequest.newBuilder()
            .setAutofeedSettings(autofeedSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateAutofeedSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   UpdateAutofeedSettingsRequest request =
   *       UpdateAutofeedSettingsRequest.newBuilder()
   *           .setAutofeedSettings(AutofeedSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AutofeedSettings response = autofeedSettingsServiceClient.updateAutofeedSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutofeedSettings updateAutofeedSettings(UpdateAutofeedSettingsRequest request) {
    return updateAutofeedSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the autofeed settings of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutofeedSettingsServiceClient autofeedSettingsServiceClient =
   *     AutofeedSettingsServiceClient.create()) {
   *   UpdateAutofeedSettingsRequest request =
   *       UpdateAutofeedSettingsRequest.newBuilder()
   *           .setAutofeedSettings(AutofeedSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AutofeedSettings> future =
   *       autofeedSettingsServiceClient.updateAutofeedSettingsCallable().futureCall(request);
   *   // Do something.
   *   AutofeedSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAutofeedSettingsRequest, AutofeedSettings>
      updateAutofeedSettingsCallable() {
    return stub.updateAutofeedSettingsCallable();
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
