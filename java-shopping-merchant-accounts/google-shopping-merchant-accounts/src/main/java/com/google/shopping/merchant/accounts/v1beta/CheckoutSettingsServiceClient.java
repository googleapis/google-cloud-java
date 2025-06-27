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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.CheckoutSettingsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.CheckoutSettingsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for supporting [checkout
 * settings](https://support.google.com/merchants/answer/13945960).
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
 * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
 *     CheckoutSettingsServiceClient.create()) {
 *   CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
 *   CheckoutSettings response = checkoutSettingsServiceClient.getCheckoutSettings(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CheckoutSettingsServiceClient object to clean up
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
 *      <td><p> GetCheckoutSettings</td>
 *      <td><p> Gets `CheckoutSettings` for the given merchant. This includes information about review state, enrollment state and URL settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCheckoutSettings(GetCheckoutSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCheckoutSettings(CheckoutSettingsName name)
 *           <li><p> getCheckoutSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCheckoutSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCheckoutSettings</td>
 *      <td><p> Creates `CheckoutSettings` for the given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCheckoutSettings(CreateCheckoutSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCheckoutSettings(ProgramName parent, CheckoutSettings checkoutSettings)
 *           <li><p> createCheckoutSettings(String parent, CheckoutSettings checkoutSettings)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCheckoutSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCheckoutSettings</td>
 *      <td><p> Updates `CheckoutSettings` for the given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCheckoutSettings(UpdateCheckoutSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCheckoutSettings(CheckoutSettings checkoutSettings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCheckoutSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCheckoutSettings</td>
 *      <td><p> Deletes `CheckoutSettings` and unenrolls merchant from `Checkout` program.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCheckoutSettings(DeleteCheckoutSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCheckoutSettings(CheckoutSettingsName name)
 *           <li><p> deleteCheckoutSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCheckoutSettingsCallable()
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
 * CheckoutSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CheckoutSettingsServiceSettings checkoutSettingsServiceSettings =
 *     CheckoutSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CheckoutSettingsServiceClient checkoutSettingsServiceClient =
 *     CheckoutSettingsServiceClient.create(checkoutSettingsServiceSettings);
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
 * CheckoutSettingsServiceSettings checkoutSettingsServiceSettings =
 *     CheckoutSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CheckoutSettingsServiceClient checkoutSettingsServiceClient =
 *     CheckoutSettingsServiceClient.create(checkoutSettingsServiceSettings);
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
 * CheckoutSettingsServiceSettings checkoutSettingsServiceSettings =
 *     CheckoutSettingsServiceSettings.newHttpJsonBuilder().build();
 * CheckoutSettingsServiceClient checkoutSettingsServiceClient =
 *     CheckoutSettingsServiceClient.create(checkoutSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CheckoutSettingsServiceClient implements BackgroundResource {
  private final CheckoutSettingsServiceSettings settings;
  private final CheckoutSettingsServiceStub stub;

  /** Constructs an instance of CheckoutSettingsServiceClient with default settings. */
  public static final CheckoutSettingsServiceClient create() throws IOException {
    return create(CheckoutSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CheckoutSettingsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CheckoutSettingsServiceClient create(CheckoutSettingsServiceSettings settings)
      throws IOException {
    return new CheckoutSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of CheckoutSettingsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CheckoutSettingsServiceSettings).
   */
  public static final CheckoutSettingsServiceClient create(CheckoutSettingsServiceStub stub) {
    return new CheckoutSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of CheckoutSettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CheckoutSettingsServiceClient(CheckoutSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CheckoutSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CheckoutSettingsServiceClient(CheckoutSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CheckoutSettingsServiceSettings getSettings() {
    return settings;
  }

  public CheckoutSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets `CheckoutSettings` for the given merchant. This includes information about review state,
   * enrollment state and URL settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
   *   CheckoutSettings response = checkoutSettingsServiceClient.getCheckoutSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name/identifier of the merchant account. Format:
   *     `accounts/{account}/programs/{program}/checkoutSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings getCheckoutSettings(CheckoutSettingsName name) {
    GetCheckoutSettingsRequest request =
        GetCheckoutSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets `CheckoutSettings` for the given merchant. This includes information about review state,
   * enrollment state and URL settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   String name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString();
   *   CheckoutSettings response = checkoutSettingsServiceClient.getCheckoutSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name/identifier of the merchant account. Format:
   *     `accounts/{account}/programs/{program}/checkoutSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings getCheckoutSettings(String name) {
    GetCheckoutSettingsRequest request =
        GetCheckoutSettingsRequest.newBuilder().setName(name).build();
    return getCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets `CheckoutSettings` for the given merchant. This includes information about review state,
   * enrollment state and URL settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   GetCheckoutSettingsRequest request =
   *       GetCheckoutSettingsRequest.newBuilder()
   *           .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   CheckoutSettings response = checkoutSettingsServiceClient.getCheckoutSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings getCheckoutSettings(GetCheckoutSettingsRequest request) {
    return getCheckoutSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets `CheckoutSettings` for the given merchant. This includes information about review state,
   * enrollment state and URL settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   GetCheckoutSettingsRequest request =
   *       GetCheckoutSettingsRequest.newBuilder()
   *           .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   ApiFuture<CheckoutSettings> future =
   *       checkoutSettingsServiceClient.getCheckoutSettingsCallable().futureCall(request);
   *   // Do something.
   *   CheckoutSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCheckoutSettingsRequest, CheckoutSettings>
      getCheckoutSettingsCallable() {
    return stub.getCheckoutSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   ProgramName parent = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
   *   CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
   *   CheckoutSettings response =
   *       checkoutSettingsServiceClient.createCheckoutSettings(parent, checkoutSettings);
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account for which the `CheckoutSettings` will be created.
   * @param checkoutSettings Required. The `CheckoutSettings` object to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings createCheckoutSettings(
      ProgramName parent, CheckoutSettings checkoutSettings) {
    CreateCheckoutSettingsRequest request =
        CreateCheckoutSettingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCheckoutSettings(checkoutSettings)
            .build();
    return createCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   String parent = ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString();
   *   CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
   *   CheckoutSettings response =
   *       checkoutSettingsServiceClient.createCheckoutSettings(parent, checkoutSettings);
   * }
   * }</pre>
   *
   * @param parent Required. The merchant account for which the `CheckoutSettings` will be created.
   * @param checkoutSettings Required. The `CheckoutSettings` object to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings createCheckoutSettings(
      String parent, CheckoutSettings checkoutSettings) {
    CreateCheckoutSettingsRequest request =
        CreateCheckoutSettingsRequest.newBuilder()
            .setParent(parent)
            .setCheckoutSettings(checkoutSettings)
            .build();
    return createCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   CreateCheckoutSettingsRequest request =
   *       CreateCheckoutSettingsRequest.newBuilder()
   *           .setParent(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .setCheckoutSettings(CheckoutSettings.newBuilder().build())
   *           .build();
   *   CheckoutSettings response = checkoutSettingsServiceClient.createCheckoutSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings createCheckoutSettings(CreateCheckoutSettingsRequest request) {
    return createCheckoutSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   CreateCheckoutSettingsRequest request =
   *       CreateCheckoutSettingsRequest.newBuilder()
   *           .setParent(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .setCheckoutSettings(CheckoutSettings.newBuilder().build())
   *           .build();
   *   ApiFuture<CheckoutSettings> future =
   *       checkoutSettingsServiceClient.createCheckoutSettingsCallable().futureCall(request);
   *   // Do something.
   *   CheckoutSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCheckoutSettingsRequest, CheckoutSettings>
      createCheckoutSettingsCallable() {
    return stub.createCheckoutSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CheckoutSettings response =
   *       checkoutSettingsServiceClient.updateCheckoutSettings(checkoutSettings, updateMask);
   * }
   * }</pre>
   *
   * @param checkoutSettings Required. The updated version of the `CheckoutSettings`. The `name`
   *     field is used to identify the `CheckoutSettings`. Format:
   *     `accounts/{account}/programs/{program}/checkoutSettings`
   * @param updateMask Required. List of fields being updated. The following fields are supported
   *     (in both `snake_case` and `lowerCamelCase`):
   *     <p>- `eligible_destinations` - `uri_settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings updateCheckoutSettings(
      CheckoutSettings checkoutSettings, FieldMask updateMask) {
    UpdateCheckoutSettingsRequest request =
        UpdateCheckoutSettingsRequest.newBuilder()
            .setCheckoutSettings(checkoutSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   UpdateCheckoutSettingsRequest request =
   *       UpdateCheckoutSettingsRequest.newBuilder()
   *           .setCheckoutSettings(CheckoutSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CheckoutSettings response = checkoutSettingsServiceClient.updateCheckoutSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckoutSettings updateCheckoutSettings(UpdateCheckoutSettingsRequest request) {
    return updateCheckoutSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates `CheckoutSettings` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   UpdateCheckoutSettingsRequest request =
   *       UpdateCheckoutSettingsRequest.newBuilder()
   *           .setCheckoutSettings(CheckoutSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CheckoutSettings> future =
   *       checkoutSettingsServiceClient.updateCheckoutSettingsCallable().futureCall(request);
   *   // Do something.
   *   CheckoutSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCheckoutSettingsRequest, CheckoutSettings>
      updateCheckoutSettingsCallable() {
    return stub.updateCheckoutSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes `CheckoutSettings` and unenrolls merchant from `Checkout` program.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
   *   checkoutSettingsServiceClient.deleteCheckoutSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name/identifier of the merchant account. Format:
   *     `accounts/{account}/programs/{program}/checkoutSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCheckoutSettings(CheckoutSettingsName name) {
    DeleteCheckoutSettingsRequest request =
        DeleteCheckoutSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes `CheckoutSettings` and unenrolls merchant from `Checkout` program.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   String name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString();
   *   checkoutSettingsServiceClient.deleteCheckoutSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name/identifier of the merchant account. Format:
   *     `accounts/{account}/programs/{program}/checkoutSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCheckoutSettings(String name) {
    DeleteCheckoutSettingsRequest request =
        DeleteCheckoutSettingsRequest.newBuilder().setName(name).build();
    deleteCheckoutSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes `CheckoutSettings` and unenrolls merchant from `Checkout` program.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   DeleteCheckoutSettingsRequest request =
   *       DeleteCheckoutSettingsRequest.newBuilder()
   *           .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   checkoutSettingsServiceClient.deleteCheckoutSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCheckoutSettings(DeleteCheckoutSettingsRequest request) {
    deleteCheckoutSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes `CheckoutSettings` and unenrolls merchant from `Checkout` program.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
   *     CheckoutSettingsServiceClient.create()) {
   *   DeleteCheckoutSettingsRequest request =
   *       DeleteCheckoutSettingsRequest.newBuilder()
   *           .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       checkoutSettingsServiceClient.deleteCheckoutSettingsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCheckoutSettingsRequest, Empty>
      deleteCheckoutSettingsCallable() {
    return stub.deleteCheckoutSettingsCallable();
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
