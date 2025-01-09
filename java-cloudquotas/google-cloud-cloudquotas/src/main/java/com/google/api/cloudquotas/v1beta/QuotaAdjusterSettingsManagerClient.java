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

package com.google.api.cloudquotas.v1beta;

import com.google.api.cloudquotas.v1beta.stub.QuotaAdjusterSettingsManagerStub;
import com.google.api.cloudquotas.v1beta.stub.QuotaAdjusterSettingsManagerStubSettings;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Quotas Adjuster Settings API is an infrastructure service for Google
 * Cloud that lets service consumers view and update their quota adjuster settings.
 *
 * <p>- Update quota adjuster settings. - Get the name of the configurations.
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
 * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
 *     QuotaAdjusterSettingsManagerClient.create()) {
 *   QuotaAdjusterSettings quotaAdjusterSettings = QuotaAdjusterSettings.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   QuotaAdjusterSettings response =
 *       quotaAdjusterSettingsManagerClient.updateQuotaAdjusterSettings(
 *           quotaAdjusterSettings, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the QuotaAdjusterSettingsManagerClient object to clean up
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
 *      <td><p> UpdateQuotaAdjusterSettings</td>
 *      <td><p> RPC Method for updating QuotaAdjusterSettings based on the request</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateQuotaAdjusterSettings(UpdateQuotaAdjusterSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateQuotaAdjusterSettings(QuotaAdjusterSettings quotaAdjusterSettings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateQuotaAdjusterSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetQuotaAdjusterSettings</td>
 *      <td><p> RPC Method for getting QuotaAdjusterSettings based on the request</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getQuotaAdjusterSettings(GetQuotaAdjusterSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getQuotaAdjusterSettings(QuotaAdjusterSettingsName name)
 *           <li><p> getQuotaAdjusterSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getQuotaAdjusterSettingsCallable()
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
 * QuotaAdjusterSettingsManagerSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * QuotaAdjusterSettingsManagerSettings quotaAdjusterSettingsManagerSettings =
 *     QuotaAdjusterSettingsManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
 *     QuotaAdjusterSettingsManagerClient.create(quotaAdjusterSettingsManagerSettings);
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
 * QuotaAdjusterSettingsManagerSettings quotaAdjusterSettingsManagerSettings =
 *     QuotaAdjusterSettingsManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
 *     QuotaAdjusterSettingsManagerClient.create(quotaAdjusterSettingsManagerSettings);
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
 * QuotaAdjusterSettingsManagerSettings quotaAdjusterSettingsManagerSettings =
 *     QuotaAdjusterSettingsManagerSettings.newHttpJsonBuilder().build();
 * QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
 *     QuotaAdjusterSettingsManagerClient.create(quotaAdjusterSettingsManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class QuotaAdjusterSettingsManagerClient implements BackgroundResource {
  private final QuotaAdjusterSettingsManagerSettings settings;
  private final QuotaAdjusterSettingsManagerStub stub;

  /** Constructs an instance of QuotaAdjusterSettingsManagerClient with default settings. */
  public static final QuotaAdjusterSettingsManagerClient create() throws IOException {
    return create(QuotaAdjusterSettingsManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of QuotaAdjusterSettingsManagerClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final QuotaAdjusterSettingsManagerClient create(
      QuotaAdjusterSettingsManagerSettings settings) throws IOException {
    return new QuotaAdjusterSettingsManagerClient(settings);
  }

  /**
   * Constructs an instance of QuotaAdjusterSettingsManagerClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(QuotaAdjusterSettingsManagerSettings).
   */
  public static final QuotaAdjusterSettingsManagerClient create(
      QuotaAdjusterSettingsManagerStub stub) {
    return new QuotaAdjusterSettingsManagerClient(stub);
  }

  /**
   * Constructs an instance of QuotaAdjusterSettingsManagerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected QuotaAdjusterSettingsManagerClient(QuotaAdjusterSettingsManagerSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((QuotaAdjusterSettingsManagerStubSettings) settings.getStubSettings()).createStub();
  }

  protected QuotaAdjusterSettingsManagerClient(QuotaAdjusterSettingsManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final QuotaAdjusterSettingsManagerSettings getSettings() {
    return settings;
  }

  public QuotaAdjusterSettingsManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for updating QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   QuotaAdjusterSettings quotaAdjusterSettings = QuotaAdjusterSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   QuotaAdjusterSettings response =
   *       quotaAdjusterSettingsManagerClient.updateQuotaAdjusterSettings(
   *           quotaAdjusterSettings, updateMask);
   * }
   * }</pre>
   *
   * @param quotaAdjusterSettings Required. The QuotaAdjusterSettings to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaAdjusterSettings updateQuotaAdjusterSettings(
      QuotaAdjusterSettings quotaAdjusterSettings, FieldMask updateMask) {
    UpdateQuotaAdjusterSettingsRequest request =
        UpdateQuotaAdjusterSettingsRequest.newBuilder()
            .setQuotaAdjusterSettings(quotaAdjusterSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateQuotaAdjusterSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for updating QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   UpdateQuotaAdjusterSettingsRequest request =
   *       UpdateQuotaAdjusterSettingsRequest.newBuilder()
   *           .setQuotaAdjusterSettings(QuotaAdjusterSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   QuotaAdjusterSettings response =
   *       quotaAdjusterSettingsManagerClient.updateQuotaAdjusterSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaAdjusterSettings updateQuotaAdjusterSettings(
      UpdateQuotaAdjusterSettingsRequest request) {
    return updateQuotaAdjusterSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for updating QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   UpdateQuotaAdjusterSettingsRequest request =
   *       UpdateQuotaAdjusterSettingsRequest.newBuilder()
   *           .setQuotaAdjusterSettings(QuotaAdjusterSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<QuotaAdjusterSettings> future =
   *       quotaAdjusterSettingsManagerClient
   *           .updateQuotaAdjusterSettingsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   QuotaAdjusterSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      updateQuotaAdjusterSettingsCallable() {
    return stub.updateQuotaAdjusterSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for getting QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   QuotaAdjusterSettingsName name = QuotaAdjusterSettingsName.of("[PROJECT]", "[LOCATION]");
   *   QuotaAdjusterSettings response =
   *       quotaAdjusterSettingsManagerClient.getQuotaAdjusterSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the config. Required to be “settings”, as only a single setting
   *     per container will be supported initially.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaAdjusterSettings getQuotaAdjusterSettings(QuotaAdjusterSettingsName name) {
    GetQuotaAdjusterSettingsRequest request =
        GetQuotaAdjusterSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getQuotaAdjusterSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for getting QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   String name = QuotaAdjusterSettingsName.of("[PROJECT]", "[LOCATION]").toString();
   *   QuotaAdjusterSettings response =
   *       quotaAdjusterSettingsManagerClient.getQuotaAdjusterSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the config. Required to be “settings”, as only a single setting
   *     per container will be supported initially.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaAdjusterSettings getQuotaAdjusterSettings(String name) {
    GetQuotaAdjusterSettingsRequest request =
        GetQuotaAdjusterSettingsRequest.newBuilder().setName(name).build();
    return getQuotaAdjusterSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for getting QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   GetQuotaAdjusterSettingsRequest request =
   *       GetQuotaAdjusterSettingsRequest.newBuilder()
   *           .setName(QuotaAdjusterSettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   QuotaAdjusterSettings response =
   *       quotaAdjusterSettingsManagerClient.getQuotaAdjusterSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaAdjusterSettings getQuotaAdjusterSettings(
      GetQuotaAdjusterSettingsRequest request) {
    return getQuotaAdjusterSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RPC Method for getting QuotaAdjusterSettings based on the request
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaAdjusterSettingsManagerClient quotaAdjusterSettingsManagerClient =
   *     QuotaAdjusterSettingsManagerClient.create()) {
   *   GetQuotaAdjusterSettingsRequest request =
   *       GetQuotaAdjusterSettingsRequest.newBuilder()
   *           .setName(QuotaAdjusterSettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<QuotaAdjusterSettings> future =
   *       quotaAdjusterSettingsManagerClient.getQuotaAdjusterSettingsCallable().futureCall(request);
   *   // Do something.
   *   QuotaAdjusterSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetQuotaAdjusterSettingsRequest, QuotaAdjusterSettings>
      getQuotaAdjusterSettingsCallable() {
    return stub.getQuotaAdjusterSettingsCallable();
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
