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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.ApiHubAddonStub;
import com.google.cloud.apihub.v1.stub.ApiHubAddonStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is used for managing addons inside the API Hub.
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
 * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
 *   AddonName name = AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]");
 *   Addon response = apiHubAddonClient.getAddon(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiHubAddonClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetAddon</td>
 *      <td><p> Get an addon.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAddon(GetAddonRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAddon(AddonName name)
 *           <li><p> getAddon(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAddonCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ManageAddonConfig</td>
 *      <td><p> Manage addon config. This RPC is used for managing the config of the addon. Calling this RPC moves the addon into an updating state until the long-running operation succeeds.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> manageAddonConfigAsync(ManageAddonConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> manageAddonConfigAsync(AddonName name, AddonConfig config)
 *           <li><p> manageAddonConfigAsync(String name, AddonConfig config)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> manageAddonConfigOperationCallable()
 *           <li><p> manageAddonConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAddons</td>
 *      <td><p> List addons.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAddons(ListAddonsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAddons(LocationName parent)
 *           <li><p> listAddons(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAddonsPagedCallable()
 *           <li><p> listAddonsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of ApiHubAddonSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubAddonSettings apiHubAddonSettings =
 *     ApiHubAddonSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create(apiHubAddonSettings);
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
 * ApiHubAddonSettings apiHubAddonSettings =
 *     ApiHubAddonSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create(apiHubAddonSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ApiHubAddonClient implements BackgroundResource {
  private final @Nullable ApiHubAddonSettings settings;
  private final ApiHubAddonStub stub;
  private final OperationsClient httpJsonOperationsClient;

  /** Constructs an instance of ApiHubAddonClient with default settings. */
  public static final ApiHubAddonClient create() throws IOException {
    return create(ApiHubAddonSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiHubAddonClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiHubAddonClient create(ApiHubAddonSettings settings) throws IOException {
    return new ApiHubAddonClient(settings);
  }

  /**
   * Constructs an instance of ApiHubAddonClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ApiHubAddonSettings).
   */
  public static final ApiHubAddonClient create(ApiHubAddonStub stub) {
    return new ApiHubAddonClient(stub);
  }

  /**
   * Constructs an instance of ApiHubAddonClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApiHubAddonClient(ApiHubAddonSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiHubAddonStubSettings) settings.getStubSettings()).createStub();
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ApiHubAddonClient(ApiHubAddonStub stub) {
    this.settings = null;
    this.stub = stub;
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable ApiHubAddonSettings getSettings() {
    return settings;
  }

  public ApiHubAddonStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an addon.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   AddonName name = AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]");
   *   Addon response = apiHubAddonClient.getAddon(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the addon to get. Format:
   *     `projects/{project}/locations/{location}/addons/{addon}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Addon getAddon(@Nullable AddonName name) {
    GetAddonRequest request =
        GetAddonRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAddon(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an addon.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   String name = AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString();
   *   Addon response = apiHubAddonClient.getAddon(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the addon to get. Format:
   *     `projects/{project}/locations/{location}/addons/{addon}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Addon getAddon(String name) {
    GetAddonRequest request = GetAddonRequest.newBuilder().setName(name).build();
    return getAddon(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an addon.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   GetAddonRequest request =
   *       GetAddonRequest.newBuilder()
   *           .setName(AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString())
   *           .build();
   *   Addon response = apiHubAddonClient.getAddon(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Addon getAddon(GetAddonRequest request) {
    return getAddonCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an addon.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   GetAddonRequest request =
   *       GetAddonRequest.newBuilder()
   *           .setName(AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString())
   *           .build();
   *   ApiFuture<Addon> future = apiHubAddonClient.getAddonCallable().futureCall(request);
   *   // Do something.
   *   Addon response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAddonRequest, Addon> getAddonCallable() {
    return stub.getAddonCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manage addon config. This RPC is used for managing the config of the addon. Calling this RPC
   * moves the addon into an updating state until the long-running operation succeeds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   AddonName name = AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]");
   *   AddonConfig config = AddonConfig.newBuilder().build();
   *   Addon response = apiHubAddonClient.manageAddonConfigAsync(name, config).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the addon for which the config is to be managed. Format:
   *     `projects/{project}/locations/{location}/addons/{addon}`.
   * @param config Required. The config of the addon to be managed. This config will replace the
   *     config present in the addon. The type of the config should match the config type already
   *     present in the addon.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Addon, OperationMetadata> manageAddonConfigAsync(
      @Nullable AddonName name, AddonConfig config) {
    ManageAddonConfigRequest request =
        ManageAddonConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setConfig(config)
            .build();
    return manageAddonConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manage addon config. This RPC is used for managing the config of the addon. Calling this RPC
   * moves the addon into an updating state until the long-running operation succeeds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   String name = AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString();
   *   AddonConfig config = AddonConfig.newBuilder().build();
   *   Addon response = apiHubAddonClient.manageAddonConfigAsync(name, config).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the addon for which the config is to be managed. Format:
   *     `projects/{project}/locations/{location}/addons/{addon}`.
   * @param config Required. The config of the addon to be managed. This config will replace the
   *     config present in the addon. The type of the config should match the config type already
   *     present in the addon.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Addon, OperationMetadata> manageAddonConfigAsync(
      String name, AddonConfig config) {
    ManageAddonConfigRequest request =
        ManageAddonConfigRequest.newBuilder().setName(name).setConfig(config).build();
    return manageAddonConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manage addon config. This RPC is used for managing the config of the addon. Calling this RPC
   * moves the addon into an updating state until the long-running operation succeeds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ManageAddonConfigRequest request =
   *       ManageAddonConfigRequest.newBuilder()
   *           .setName(AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString())
   *           .setConfig(AddonConfig.newBuilder().build())
   *           .build();
   *   Addon response = apiHubAddonClient.manageAddonConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Addon, OperationMetadata> manageAddonConfigAsync(
      ManageAddonConfigRequest request) {
    return manageAddonConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manage addon config. This RPC is used for managing the config of the addon. Calling this RPC
   * moves the addon into an updating state until the long-running operation succeeds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ManageAddonConfigRequest request =
   *       ManageAddonConfigRequest.newBuilder()
   *           .setName(AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString())
   *           .setConfig(AddonConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Addon, OperationMetadata> future =
   *       apiHubAddonClient.manageAddonConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   Addon response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ManageAddonConfigRequest, Addon, OperationMetadata>
      manageAddonConfigOperationCallable() {
    return stub.manageAddonConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Manage addon config. This RPC is used for managing the config of the addon. Calling this RPC
   * moves the addon into an updating state until the long-running operation succeeds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ManageAddonConfigRequest request =
   *       ManageAddonConfigRequest.newBuilder()
   *           .setName(AddonName.of("[PROJECT]", "[LOCATION]", "[ADDON]").toString())
   *           .setConfig(AddonConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiHubAddonClient.manageAddonConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ManageAddonConfigRequest, Operation> manageAddonConfigCallable() {
    return stub.manageAddonConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Addon element : apiHubAddonClient.listAddons(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this addon will be created. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddonsPagedResponse listAddons(@Nullable LocationName parent) {
    ListAddonsRequest request =
        ListAddonsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAddons(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Addon element : apiHubAddonClient.listAddons(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this addon will be created. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddonsPagedResponse listAddons(String parent) {
    ListAddonsRequest request = ListAddonsRequest.newBuilder().setParent(parent).build();
    return listAddons(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ListAddonsRequest request =
   *       ListAddonsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Addon element : apiHubAddonClient.listAddons(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAddonsPagedResponse listAddons(ListAddonsRequest request) {
    return listAddonsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ListAddonsRequest request =
   *       ListAddonsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Addon> future = apiHubAddonClient.listAddonsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Addon element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAddonsRequest, ListAddonsPagedResponse> listAddonsPagedCallable() {
    return stub.listAddonsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List addons.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ListAddonsRequest request =
   *       ListAddonsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAddonsResponse response = apiHubAddonClient.listAddonsCallable().call(request);
   *     for (Addon element : response.getAddonsList()) {
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
  public final UnaryCallable<ListAddonsRequest, ListAddonsResponse> listAddonsCallable() {
    return stub.listAddonsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : apiHubAddonClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       apiHubAddonClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = apiHubAddonClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = apiHubAddonClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubAddonClient apiHubAddonClient = ApiHubAddonClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = apiHubAddonClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListAddonsPagedResponse
      extends AbstractPagedListResponse<
          ListAddonsRequest,
          ListAddonsResponse,
          Addon,
          ListAddonsPage,
          ListAddonsFixedSizeCollection> {

    public static ApiFuture<ListAddonsPagedResponse> createAsync(
        PageContext<ListAddonsRequest, ListAddonsResponse, Addon> context,
        ApiFuture<ListAddonsResponse> futureResponse) {
      ApiFuture<ListAddonsPage> futurePage =
          ListAddonsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAddonsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAddonsPagedResponse(ListAddonsPage page) {
      super(page, ListAddonsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAddonsPage
      extends AbstractPage<ListAddonsRequest, ListAddonsResponse, Addon, ListAddonsPage> {

    private ListAddonsPage(
        @Nullable PageContext<ListAddonsRequest, ListAddonsResponse, Addon> context,
        @Nullable ListAddonsResponse response) {
      super(context, response);
    }

    private static ListAddonsPage createEmptyPage() {
      return new ListAddonsPage(null, null);
    }

    @Override
    protected ListAddonsPage createPage(
        @Nullable PageContext<ListAddonsRequest, ListAddonsResponse, Addon> context,
        @Nullable ListAddonsResponse response) {
      return new ListAddonsPage(context, response);
    }

    @Override
    public ApiFuture<ListAddonsPage> createPageAsync(
        @Nullable PageContext<ListAddonsRequest, ListAddonsResponse, Addon> context,
        ApiFuture<ListAddonsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAddonsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAddonsRequest,
          ListAddonsResponse,
          Addon,
          ListAddonsPage,
          ListAddonsFixedSizeCollection> {

    private ListAddonsFixedSizeCollection(
        @Nullable List<ListAddonsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAddonsFixedSizeCollection createEmptyCollection() {
      return new ListAddonsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAddonsFixedSizeCollection createCollection(
        @Nullable List<ListAddonsPage> pages, int collectionSize) {
      return new ListAddonsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
