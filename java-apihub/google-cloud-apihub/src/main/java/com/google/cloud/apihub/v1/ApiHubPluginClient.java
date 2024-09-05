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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.ApiHubPluginStub;
import com.google.cloud.apihub.v1.stub.ApiHubPluginStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is used for managing plugins inside the API Hub.
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
 * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
 *   PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
 *   Plugin response = apiHubPluginClient.getPlugin(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiHubPluginClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetPlugin</td>
 *      <td><p> Get details about an API Hub plugin.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPlugin(GetPluginRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPlugin(PluginName name)
 *           <li><p> getPlugin(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPluginCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnablePlugin</td>
 *      <td><p> Enables a plugin. The `state` of the plugin after enabling is `ENABLED`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enablePlugin(EnablePluginRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enablePlugin(PluginName name)
 *           <li><p> enablePlugin(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enablePluginCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisablePlugin</td>
 *      <td><p> Disables a plugin. The `state` of the plugin after disabling is `DISABLED`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disablePlugin(DisablePluginRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> disablePlugin(PluginName name)
 *           <li><p> disablePlugin(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disablePluginCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
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
 * <p>This class can be customized by passing in a custom instance of ApiHubPluginSettings to
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
 * ApiHubPluginSettings apiHubPluginSettings =
 *     ApiHubPluginSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create(apiHubPluginSettings);
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
 * ApiHubPluginSettings apiHubPluginSettings =
 *     ApiHubPluginSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create(apiHubPluginSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiHubPluginClient implements BackgroundResource {
  private final ApiHubPluginSettings settings;
  private final ApiHubPluginStub stub;

  /** Constructs an instance of ApiHubPluginClient with default settings. */
  public static final ApiHubPluginClient create() throws IOException {
    return create(ApiHubPluginSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiHubPluginClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiHubPluginClient create(ApiHubPluginSettings settings) throws IOException {
    return new ApiHubPluginClient(settings);
  }

  /**
   * Constructs an instance of ApiHubPluginClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ApiHubPluginSettings).
   */
  public static final ApiHubPluginClient create(ApiHubPluginStub stub) {
    return new ApiHubPluginClient(stub);
  }

  /**
   * Constructs an instance of ApiHubPluginClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApiHubPluginClient(ApiHubPluginSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiHubPluginStubSettings) settings.getStubSettings()).createStub();
  }

  protected ApiHubPluginClient(ApiHubPluginStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ApiHubPluginSettings getSettings() {
    return settings;
  }

  public ApiHubPluginStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an API Hub plugin.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   Plugin response = apiHubPluginClient.getPlugin(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin to retrieve. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin getPlugin(PluginName name) {
    GetPluginRequest request =
        GetPluginRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an API Hub plugin.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   String name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   Plugin response = apiHubPluginClient.getPlugin(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin to retrieve. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin getPlugin(String name) {
    GetPluginRequest request = GetPluginRequest.newBuilder().setName(name).build();
    return getPlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an API Hub plugin.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   GetPluginRequest request =
   *       GetPluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   Plugin response = apiHubPluginClient.getPlugin(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin getPlugin(GetPluginRequest request) {
    return getPluginCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an API Hub plugin.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   GetPluginRequest request =
   *       GetPluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   ApiFuture<Plugin> future = apiHubPluginClient.getPluginCallable().futureCall(request);
   *   // Do something.
   *   Plugin response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPluginRequest, Plugin> getPluginCallable() {
    return stub.getPluginCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin. The `state` of the plugin after enabling is `ENABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   Plugin response = apiHubPluginClient.enablePlugin(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin to enable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin enablePlugin(PluginName name) {
    EnablePluginRequest request =
        EnablePluginRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return enablePlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin. The `state` of the plugin after enabling is `ENABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   String name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   Plugin response = apiHubPluginClient.enablePlugin(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin to enable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin enablePlugin(String name) {
    EnablePluginRequest request = EnablePluginRequest.newBuilder().setName(name).build();
    return enablePlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin. The `state` of the plugin after enabling is `ENABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   EnablePluginRequest request =
   *       EnablePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   Plugin response = apiHubPluginClient.enablePlugin(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin enablePlugin(EnablePluginRequest request) {
    return enablePluginCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin. The `state` of the plugin after enabling is `ENABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   EnablePluginRequest request =
   *       EnablePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   ApiFuture<Plugin> future = apiHubPluginClient.enablePluginCallable().futureCall(request);
   *   // Do something.
   *   Plugin response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnablePluginRequest, Plugin> enablePluginCallable() {
    return stub.enablePluginCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin. The `state` of the plugin after disabling is `DISABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   Plugin response = apiHubPluginClient.disablePlugin(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin to disable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin disablePlugin(PluginName name) {
    DisablePluginRequest request =
        DisablePluginRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return disablePlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin. The `state` of the plugin after disabling is `DISABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   String name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   Plugin response = apiHubPluginClient.disablePlugin(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin to disable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin disablePlugin(String name) {
    DisablePluginRequest request = DisablePluginRequest.newBuilder().setName(name).build();
    return disablePlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin. The `state` of the plugin after disabling is `DISABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   DisablePluginRequest request =
   *       DisablePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   Plugin response = apiHubPluginClient.disablePlugin(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin disablePlugin(DisablePluginRequest request) {
    return disablePluginCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin. The `state` of the plugin after disabling is `DISABLED`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   DisablePluginRequest request =
   *       DisablePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   ApiFuture<Plugin> future = apiHubPluginClient.disablePluginCallable().futureCall(request);
   *   // Do something.
   *   Plugin response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisablePluginRequest, Plugin> disablePluginCallable() {
    return stub.disablePluginCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : apiHubPluginClient.listLocations(request).iterateAll()) {
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       apiHubPluginClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = apiHubPluginClient.listLocationsCallable().call(request);
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
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = apiHubPluginClient.getLocation(request);
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
   * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = apiHubPluginClient.getLocationCallable().futureCall(request);
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
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
