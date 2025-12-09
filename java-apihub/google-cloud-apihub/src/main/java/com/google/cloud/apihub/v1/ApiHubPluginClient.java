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
import com.google.cloud.apihub.v1.stub.ApiHubPluginStub;
import com.google.cloud.apihub.v1.stub.ApiHubPluginStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
 *      <td><p> Get an API Hub plugin.</td>
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
 *      <td><p> CreatePlugin</td>
 *      <td><p> Create an API Hub plugin resource in the API hub. Once a plugin is created, it can be used to create plugin instances.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPlugin(CreatePluginRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPlugin(LocationName parent, Plugin plugin, String pluginId)
 *           <li><p> createPlugin(String parent, Plugin plugin, String pluginId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPluginCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPlugins</td>
 *      <td><p> List all the plugins in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPlugins(ListPluginsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPlugins(LocationName parent)
 *           <li><p> listPlugins(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPluginsPagedCallable()
 *           <li><p> listPluginsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePlugin</td>
 *      <td><p> Delete a Plugin in API hub. Note, only user owned plugins can be deleted via this method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePluginAsync(DeletePluginRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePluginAsync(PluginName name)
 *           <li><p> deletePluginAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePluginOperationCallable()
 *           <li><p> deletePluginCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePluginInstance</td>
 *      <td><p> Creates a Plugin instance in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPluginInstanceAsync(CreatePluginInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPluginInstanceAsync(PluginName parent, PluginInstance pluginInstance, String pluginInstanceId)
 *           <li><p> createPluginInstanceAsync(String parent, PluginInstance pluginInstance, String pluginInstanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPluginInstanceOperationCallable()
 *           <li><p> createPluginInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExecutePluginInstanceAction</td>
 *      <td><p> Executes a plugin instance in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> executePluginInstanceActionAsync(ExecutePluginInstanceActionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> executePluginInstanceActionAsync(PluginInstanceName name, ActionExecutionDetail actionExecutionDetail)
 *           <li><p> executePluginInstanceActionAsync(String name, ActionExecutionDetail actionExecutionDetail)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> executePluginInstanceActionOperationCallable()
 *           <li><p> executePluginInstanceActionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPluginInstance</td>
 *      <td><p> Get an API Hub plugin instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPluginInstance(GetPluginInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPluginInstance(PluginInstanceName name)
 *           <li><p> getPluginInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPluginInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPluginInstances</td>
 *      <td><p> List all the plugins in a given project and location. `-` can be used as wildcard value for {plugin_id}</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPluginInstances(ListPluginInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPluginInstances(PluginName parent)
 *           <li><p> listPluginInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPluginInstancesPagedCallable()
 *           <li><p> listPluginInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnablePluginInstanceAction</td>
 *      <td><p> Enables a plugin instance in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enablePluginInstanceActionAsync(EnablePluginInstanceActionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> enablePluginInstanceActionAsync(PluginInstanceName name, String actionId)
 *           <li><p> enablePluginInstanceActionAsync(String name, String actionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enablePluginInstanceActionOperationCallable()
 *           <li><p> enablePluginInstanceActionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisablePluginInstanceAction</td>
 *      <td><p> Disables a plugin instance in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disablePluginInstanceActionAsync(DisablePluginInstanceActionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> disablePluginInstanceActionAsync(PluginInstanceName name, String actionId)
 *           <li><p> disablePluginInstanceActionAsync(String name, String actionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disablePluginInstanceActionOperationCallable()
 *           <li><p> disablePluginInstanceActionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePluginInstance</td>
 *      <td><p> Updates a plugin instance in the API hub. The following fields in the [plugin_instance][google.cloud.apihub.v1.PluginInstance] can be updated currently:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.PluginInstance.display_name]
 * <li>  [schedule_cron_expression][PluginInstance.actions.schedule_cron_expression]
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdatePluginInstanceRequest.update_mask] should be used to specify the fields being updated.
 * <p>  To update the [auth_config][google.cloud.apihub.v1.PluginInstance.auth_config] and [additional_config][google.cloud.apihub.v1.PluginInstance.additional_config] of the plugin instance, use the [ApplyPluginInstanceConfig][google.cloud.apihub.v1.ApiHubPlugin.ApplyPluginInstanceConfig] method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePluginInstance(UpdatePluginInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePluginInstance(PluginInstance pluginInstance, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePluginInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePluginInstance</td>
 *      <td><p> Deletes a plugin instance in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePluginInstanceAsync(DeletePluginInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePluginInstanceAsync(PluginInstanceName name)
 *           <li><p> deletePluginInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePluginInstanceOperationCallable()
 *           <li><p> deletePluginInstanceCallable()
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
  private final OperationsClient httpJsonOperationsClient;

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
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ApiHubPluginClient(ApiHubPluginStub stub) {
    this.settings = null;
    this.stub = stub;
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ApiHubPluginSettings getSettings() {
    return settings;
  }

  public ApiHubPluginStub getStub() {
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
   * Get an API Hub plugin.
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
   * Get an API Hub plugin.
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
   * Get an API Hub plugin.
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
   * Get an API Hub plugin.
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
   * Create an API Hub plugin resource in the API hub. Once a plugin is created, it can be used to
   * create plugin instances.
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
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Plugin plugin = Plugin.newBuilder().build();
   *   String pluginId = "pluginId-1859618898";
   *   Plugin response = apiHubPluginClient.createPlugin(parent, plugin, pluginId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this plugin will be created. Format:
   *     `projects/{project}/locations/{location}`.
   * @param plugin Required. The plugin to create.
   * @param pluginId Optional. The ID to use for the Plugin resource, which will become the final
   *     component of the Plugin's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another Plugin resource in the API hub instance.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-63 characters, overall resource name which will be of format
   *     `projects/{project}/locations/{location}/plugins/{plugin}`, its length is limited to 1000
   *     characters and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin createPlugin(LocationName parent, Plugin plugin, String pluginId) {
    CreatePluginRequest request =
        CreatePluginRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPlugin(plugin)
            .setPluginId(pluginId)
            .build();
    return createPlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API Hub plugin resource in the API hub. Once a plugin is created, it can be used to
   * create plugin instances.
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
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Plugin plugin = Plugin.newBuilder().build();
   *   String pluginId = "pluginId-1859618898";
   *   Plugin response = apiHubPluginClient.createPlugin(parent, plugin, pluginId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this plugin will be created. Format:
   *     `projects/{project}/locations/{location}`.
   * @param plugin Required. The plugin to create.
   * @param pluginId Optional. The ID to use for the Plugin resource, which will become the final
   *     component of the Plugin's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another Plugin resource in the API hub instance.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-63 characters, overall resource name which will be of format
   *     `projects/{project}/locations/{location}/plugins/{plugin}`, its length is limited to 1000
   *     characters and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin createPlugin(String parent, Plugin plugin, String pluginId) {
    CreatePluginRequest request =
        CreatePluginRequest.newBuilder()
            .setParent(parent)
            .setPlugin(plugin)
            .setPluginId(pluginId)
            .build();
    return createPlugin(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API Hub plugin resource in the API hub. Once a plugin is created, it can be used to
   * create plugin instances.
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
   *   CreatePluginRequest request =
   *       CreatePluginRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPluginId("pluginId-1859618898")
   *           .setPlugin(Plugin.newBuilder().build())
   *           .build();
   *   Plugin response = apiHubPluginClient.createPlugin(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Plugin createPlugin(CreatePluginRequest request) {
    return createPluginCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API Hub plugin resource in the API hub. Once a plugin is created, it can be used to
   * create plugin instances.
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
   *   CreatePluginRequest request =
   *       CreatePluginRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPluginId("pluginId-1859618898")
   *           .setPlugin(Plugin.newBuilder().build())
   *           .build();
   *   ApiFuture<Plugin> future = apiHubPluginClient.createPluginCallable().futureCall(request);
   *   // Do something.
   *   Plugin response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePluginRequest, Plugin> createPluginCallable() {
    return stub.createPluginCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location.
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
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Plugin element : apiHubPluginClient.listPlugins(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this plugin will be created. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluginsPagedResponse listPlugins(LocationName parent) {
    ListPluginsRequest request =
        ListPluginsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPlugins(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location.
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
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Plugin element : apiHubPluginClient.listPlugins(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this plugin will be created. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluginsPagedResponse listPlugins(String parent) {
    ListPluginsRequest request = ListPluginsRequest.newBuilder().setParent(parent).build();
    return listPlugins(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location.
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
   *   ListPluginsRequest request =
   *       ListPluginsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Plugin element : apiHubPluginClient.listPlugins(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluginsPagedResponse listPlugins(ListPluginsRequest request) {
    return listPluginsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location.
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
   *   ListPluginsRequest request =
   *       ListPluginsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Plugin> future = apiHubPluginClient.listPluginsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Plugin element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPluginsRequest, ListPluginsPagedResponse>
      listPluginsPagedCallable() {
    return stub.listPluginsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location.
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
   *   ListPluginsRequest request =
   *       ListPluginsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPluginsResponse response = apiHubPluginClient.listPluginsCallable().call(request);
   *     for (Plugin element : response.getPluginsList()) {
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
  public final UnaryCallable<ListPluginsRequest, ListPluginsResponse> listPluginsCallable() {
    return stub.listPluginsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Plugin in API hub. Note, only user owned plugins can be deleted via this method.
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
   *   apiHubPluginClient.deletePluginAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Plugin resource to delete. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePluginAsync(PluginName name) {
    DeletePluginRequest request =
        DeletePluginRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deletePluginAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Plugin in API hub. Note, only user owned plugins can be deleted via this method.
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
   *   apiHubPluginClient.deletePluginAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Plugin resource to delete. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePluginAsync(String name) {
    DeletePluginRequest request = DeletePluginRequest.newBuilder().setName(name).build();
    return deletePluginAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Plugin in API hub. Note, only user owned plugins can be deleted via this method.
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
   *   DeletePluginRequest request =
   *       DeletePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   apiHubPluginClient.deletePluginAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePluginAsync(
      DeletePluginRequest request) {
    return deletePluginOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Plugin in API hub. Note, only user owned plugins can be deleted via this method.
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
   *   DeletePluginRequest request =
   *       DeletePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       apiHubPluginClient.deletePluginOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationCallable() {
    return stub.deletePluginOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Plugin in API hub. Note, only user owned plugins can be deleted via this method.
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
   *   DeletePluginRequest request =
   *       DeletePluginRequest.newBuilder()
   *           .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .build();
   *   ApiFuture<Operation> future = apiHubPluginClient.deletePluginCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePluginRequest, Operation> deletePluginCallable() {
    return stub.deletePluginCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Plugin instance in the API hub.
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
   *   PluginName parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   PluginInstance pluginInstance = PluginInstance.newBuilder().build();
   *   String pluginInstanceId = "pluginInstanceId-1741818845";
   *   PluginInstance response =
   *       apiHubPluginClient
   *           .createPluginInstanceAsync(parent, pluginInstance, pluginInstanceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the plugin instance resource. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`
   * @param pluginInstance Required. The plugin instance to create.
   * @param pluginInstanceId Optional. The ID to use for the plugin instance, which will become the
   *     final component of the plugin instance's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another plugin instance in the plugin resource.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PluginInstance, OperationMetadata> createPluginInstanceAsync(
      PluginName parent, PluginInstance pluginInstance, String pluginInstanceId) {
    CreatePluginInstanceRequest request =
        CreatePluginInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPluginInstance(pluginInstance)
            .setPluginInstanceId(pluginInstanceId)
            .build();
    return createPluginInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Plugin instance in the API hub.
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
   *   String parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   PluginInstance pluginInstance = PluginInstance.newBuilder().build();
   *   String pluginInstanceId = "pluginInstanceId-1741818845";
   *   PluginInstance response =
   *       apiHubPluginClient
   *           .createPluginInstanceAsync(parent, pluginInstance, pluginInstanceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the plugin instance resource. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`
   * @param pluginInstance Required. The plugin instance to create.
   * @param pluginInstanceId Optional. The ID to use for the plugin instance, which will become the
   *     final component of the plugin instance's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another plugin instance in the plugin resource.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PluginInstance, OperationMetadata> createPluginInstanceAsync(
      String parent, PluginInstance pluginInstance, String pluginInstanceId) {
    CreatePluginInstanceRequest request =
        CreatePluginInstanceRequest.newBuilder()
            .setParent(parent)
            .setPluginInstance(pluginInstance)
            .setPluginInstanceId(pluginInstanceId)
            .build();
    return createPluginInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Plugin instance in the API hub.
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
   *   CreatePluginInstanceRequest request =
   *       CreatePluginInstanceRequest.newBuilder()
   *           .setParent(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .setPluginInstanceId("pluginInstanceId-1741818845")
   *           .setPluginInstance(PluginInstance.newBuilder().build())
   *           .build();
   *   PluginInstance response = apiHubPluginClient.createPluginInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PluginInstance, OperationMetadata> createPluginInstanceAsync(
      CreatePluginInstanceRequest request) {
    return createPluginInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Plugin instance in the API hub.
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
   *   CreatePluginInstanceRequest request =
   *       CreatePluginInstanceRequest.newBuilder()
   *           .setParent(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .setPluginInstanceId("pluginInstanceId-1741818845")
   *           .setPluginInstance(PluginInstance.newBuilder().build())
   *           .build();
   *   OperationFuture<PluginInstance, OperationMetadata> future =
   *       apiHubPluginClient.createPluginInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   PluginInstance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationCallable() {
    return stub.createPluginInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Plugin instance in the API hub.
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
   *   CreatePluginInstanceRequest request =
   *       CreatePluginInstanceRequest.newBuilder()
   *           .setParent(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .setPluginInstanceId("pluginInstanceId-1741818845")
   *           .setPluginInstance(PluginInstance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiHubPluginClient.createPluginInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePluginInstanceRequest, Operation>
      createPluginInstanceCallable() {
    return stub.createPluginInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a plugin instance in the API hub.
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
   *   PluginInstanceName name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
   *   ActionExecutionDetail actionExecutionDetail = ActionExecutionDetail.newBuilder().build();
   *   ExecutePluginInstanceActionResponse response =
   *       apiHubPluginClient.executePluginInstanceActionAsync(name, actionExecutionDetail).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to execute. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @param actionExecutionDetail Required. The execution details for the action to execute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExecutePluginInstanceActionResponse, OperationMetadata>
      executePluginInstanceActionAsync(
          PluginInstanceName name, ActionExecutionDetail actionExecutionDetail) {
    ExecutePluginInstanceActionRequest request =
        ExecutePluginInstanceActionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setActionExecutionDetail(actionExecutionDetail)
            .build();
    return executePluginInstanceActionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a plugin instance in the API hub.
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
   *   String name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]").toString();
   *   ActionExecutionDetail actionExecutionDetail = ActionExecutionDetail.newBuilder().build();
   *   ExecutePluginInstanceActionResponse response =
   *       apiHubPluginClient.executePluginInstanceActionAsync(name, actionExecutionDetail).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to execute. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @param actionExecutionDetail Required. The execution details for the action to execute.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExecutePluginInstanceActionResponse, OperationMetadata>
      executePluginInstanceActionAsync(String name, ActionExecutionDetail actionExecutionDetail) {
    ExecutePluginInstanceActionRequest request =
        ExecutePluginInstanceActionRequest.newBuilder()
            .setName(name)
            .setActionExecutionDetail(actionExecutionDetail)
            .build();
    return executePluginInstanceActionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a plugin instance in the API hub.
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
   *   ExecutePluginInstanceActionRequest request =
   *       ExecutePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionExecutionDetail(ActionExecutionDetail.newBuilder().build())
   *           .build();
   *   ExecutePluginInstanceActionResponse response =
   *       apiHubPluginClient.executePluginInstanceActionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExecutePluginInstanceActionResponse, OperationMetadata>
      executePluginInstanceActionAsync(ExecutePluginInstanceActionRequest request) {
    return executePluginInstanceActionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a plugin instance in the API hub.
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
   *   ExecutePluginInstanceActionRequest request =
   *       ExecutePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionExecutionDetail(ActionExecutionDetail.newBuilder().build())
   *           .build();
   *   OperationFuture<ExecutePluginInstanceActionResponse, OperationMetadata> future =
   *       apiHubPluginClient.executePluginInstanceActionOperationCallable().futureCall(request);
   *   // Do something.
   *   ExecutePluginInstanceActionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationCallable() {
    return stub.executePluginInstanceActionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Executes a plugin instance in the API hub.
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
   *   ExecutePluginInstanceActionRequest request =
   *       ExecutePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionExecutionDetail(ActionExecutionDetail.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiHubPluginClient.executePluginInstanceActionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionCallable() {
    return stub.executePluginInstanceActionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an API Hub plugin instance.
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
   *   PluginInstanceName name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
   *   PluginInstance response = apiHubPluginClient.getPluginInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to retrieve. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluginInstance getPluginInstance(PluginInstanceName name) {
    GetPluginInstanceRequest request =
        GetPluginInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPluginInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an API Hub plugin instance.
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
   *   String name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]").toString();
   *   PluginInstance response = apiHubPluginClient.getPluginInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to retrieve. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluginInstance getPluginInstance(String name) {
    GetPluginInstanceRequest request = GetPluginInstanceRequest.newBuilder().setName(name).build();
    return getPluginInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an API Hub plugin instance.
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
   *   GetPluginInstanceRequest request =
   *       GetPluginInstanceRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   PluginInstance response = apiHubPluginClient.getPluginInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluginInstance getPluginInstance(GetPluginInstanceRequest request) {
    return getPluginInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an API Hub plugin instance.
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
   *   GetPluginInstanceRequest request =
   *       GetPluginInstanceRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PluginInstance> future =
   *       apiHubPluginClient.getPluginInstanceCallable().futureCall(request);
   *   // Do something.
   *   PluginInstance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPluginInstanceRequest, PluginInstance> getPluginInstanceCallable() {
    return stub.getPluginInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location. `-` can be used as wildcard value for
   * {plugin_id}
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
   *   PluginName parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
   *   for (PluginInstance element : apiHubPluginClient.listPluginInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this plugin will be created. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`. To list plugin instances for
   *     multiple plugins, use the - character instead of the plugin ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluginInstancesPagedResponse listPluginInstances(PluginName parent) {
    ListPluginInstancesRequest request =
        ListPluginInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPluginInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location. `-` can be used as wildcard value for
   * {plugin_id}
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
   *   String parent = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString();
   *   for (PluginInstance element : apiHubPluginClient.listPluginInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this plugin will be created. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}`. To list plugin instances for
   *     multiple plugins, use the - character instead of the plugin ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluginInstancesPagedResponse listPluginInstances(String parent) {
    ListPluginInstancesRequest request =
        ListPluginInstancesRequest.newBuilder().setParent(parent).build();
    return listPluginInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location. `-` can be used as wildcard value for
   * {plugin_id}
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
   *   ListPluginInstancesRequest request =
   *       ListPluginInstancesRequest.newBuilder()
   *           .setParent(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PluginInstance element : apiHubPluginClient.listPluginInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluginInstancesPagedResponse listPluginInstances(
      ListPluginInstancesRequest request) {
    return listPluginInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location. `-` can be used as wildcard value for
   * {plugin_id}
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
   *   ListPluginInstancesRequest request =
   *       ListPluginInstancesRequest.newBuilder()
   *           .setParent(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PluginInstance> future =
   *       apiHubPluginClient.listPluginInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PluginInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesPagedResponse>
      listPluginInstancesPagedCallable() {
    return stub.listPluginInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the plugins in a given project and location. `-` can be used as wildcard value for
   * {plugin_id}
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
   *   ListPluginInstancesRequest request =
   *       ListPluginInstancesRequest.newBuilder()
   *           .setParent(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPluginInstancesResponse response =
   *         apiHubPluginClient.listPluginInstancesCallable().call(request);
   *     for (PluginInstance element : response.getPluginInstancesList()) {
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
  public final UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesResponse>
      listPluginInstancesCallable() {
    return stub.listPluginInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin instance in the API hub.
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
   *   PluginInstanceName name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
   *   String actionId = "actionId-1656172047";
   *   EnablePluginInstanceActionResponse response =
   *       apiHubPluginClient.enablePluginInstanceActionAsync(name, actionId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to enable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @param actionId Required. The action id to enable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionAsync(PluginInstanceName name, String actionId) {
    EnablePluginInstanceActionRequest request =
        EnablePluginInstanceActionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setActionId(actionId)
            .build();
    return enablePluginInstanceActionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin instance in the API hub.
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
   *   String name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]").toString();
   *   String actionId = "actionId-1656172047";
   *   EnablePluginInstanceActionResponse response =
   *       apiHubPluginClient.enablePluginInstanceActionAsync(name, actionId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to enable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @param actionId Required. The action id to enable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionAsync(String name, String actionId) {
    EnablePluginInstanceActionRequest request =
        EnablePluginInstanceActionRequest.newBuilder().setName(name).setActionId(actionId).build();
    return enablePluginInstanceActionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin instance in the API hub.
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
   *   EnablePluginInstanceActionRequest request =
   *       EnablePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionId("actionId-1656172047")
   *           .build();
   *   EnablePluginInstanceActionResponse response =
   *       apiHubPluginClient.enablePluginInstanceActionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionAsync(EnablePluginInstanceActionRequest request) {
    return enablePluginInstanceActionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin instance in the API hub.
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
   *   EnablePluginInstanceActionRequest request =
   *       EnablePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionId("actionId-1656172047")
   *           .build();
   *   OperationFuture<EnablePluginInstanceActionResponse, OperationMetadata> future =
   *       apiHubPluginClient.enablePluginInstanceActionOperationCallable().futureCall(request);
   *   // Do something.
   *   EnablePluginInstanceActionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationCallable() {
    return stub.enablePluginInstanceActionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a plugin instance in the API hub.
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
   *   EnablePluginInstanceActionRequest request =
   *       EnablePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionId("actionId-1656172047")
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiHubPluginClient.enablePluginInstanceActionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionCallable() {
    return stub.enablePluginInstanceActionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin instance in the API hub.
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
   *   PluginInstanceName name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
   *   String actionId = "actionId-1656172047";
   *   DisablePluginInstanceActionResponse response =
   *       apiHubPluginClient.disablePluginInstanceActionAsync(name, actionId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to disable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @param actionId Required. The action id to disable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisablePluginInstanceActionResponse, OperationMetadata>
      disablePluginInstanceActionAsync(PluginInstanceName name, String actionId) {
    DisablePluginInstanceActionRequest request =
        DisablePluginInstanceActionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setActionId(actionId)
            .build();
    return disablePluginInstanceActionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin instance in the API hub.
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
   *   String name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]").toString();
   *   String actionId = "actionId-1656172047";
   *   DisablePluginInstanceActionResponse response =
   *       apiHubPluginClient.disablePluginInstanceActionAsync(name, actionId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to disable. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`
   * @param actionId Required. The action id to disable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisablePluginInstanceActionResponse, OperationMetadata>
      disablePluginInstanceActionAsync(String name, String actionId) {
    DisablePluginInstanceActionRequest request =
        DisablePluginInstanceActionRequest.newBuilder().setName(name).setActionId(actionId).build();
    return disablePluginInstanceActionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin instance in the API hub.
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
   *   DisablePluginInstanceActionRequest request =
   *       DisablePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionId("actionId-1656172047")
   *           .build();
   *   DisablePluginInstanceActionResponse response =
   *       apiHubPluginClient.disablePluginInstanceActionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisablePluginInstanceActionResponse, OperationMetadata>
      disablePluginInstanceActionAsync(DisablePluginInstanceActionRequest request) {
    return disablePluginInstanceActionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin instance in the API hub.
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
   *   DisablePluginInstanceActionRequest request =
   *       DisablePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionId("actionId-1656172047")
   *           .build();
   *   OperationFuture<DisablePluginInstanceActionResponse, OperationMetadata> future =
   *       apiHubPluginClient.disablePluginInstanceActionOperationCallable().futureCall(request);
   *   // Do something.
   *   DisablePluginInstanceActionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationCallable() {
    return stub.disablePluginInstanceActionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a plugin instance in the API hub.
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
   *   DisablePluginInstanceActionRequest request =
   *       DisablePluginInstanceActionRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .setActionId("actionId-1656172047")
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiHubPluginClient.disablePluginInstanceActionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionCallable() {
    return stub.disablePluginInstanceActionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a plugin instance in the API hub. The following fields in the
   * [plugin_instance][google.cloud.apihub.v1.PluginInstance] can be updated currently:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.PluginInstance.display_name]
   *   <li>[schedule_cron_expression][PluginInstance.actions.schedule_cron_expression]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdatePluginInstanceRequest.update_mask] should be
   * used to specify the fields being updated.
   *
   * <p>To update the [auth_config][google.cloud.apihub.v1.PluginInstance.auth_config] and
   * [additional_config][google.cloud.apihub.v1.PluginInstance.additional_config] of the plugin
   * instance, use the
   * [ApplyPluginInstanceConfig][google.cloud.apihub.v1.ApiHubPlugin.ApplyPluginInstanceConfig]
   * method.
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
   *   PluginInstance pluginInstance = PluginInstance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PluginInstance response = apiHubPluginClient.updatePluginInstance(pluginInstance, updateMask);
   * }
   * }</pre>
   *
   * @param pluginInstance Required. The plugin instance to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluginInstance updatePluginInstance(
      PluginInstance pluginInstance, FieldMask updateMask) {
    UpdatePluginInstanceRequest request =
        UpdatePluginInstanceRequest.newBuilder()
            .setPluginInstance(pluginInstance)
            .setUpdateMask(updateMask)
            .build();
    return updatePluginInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a plugin instance in the API hub. The following fields in the
   * [plugin_instance][google.cloud.apihub.v1.PluginInstance] can be updated currently:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.PluginInstance.display_name]
   *   <li>[schedule_cron_expression][PluginInstance.actions.schedule_cron_expression]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdatePluginInstanceRequest.update_mask] should be
   * used to specify the fields being updated.
   *
   * <p>To update the [auth_config][google.cloud.apihub.v1.PluginInstance.auth_config] and
   * [additional_config][google.cloud.apihub.v1.PluginInstance.additional_config] of the plugin
   * instance, use the
   * [ApplyPluginInstanceConfig][google.cloud.apihub.v1.ApiHubPlugin.ApplyPluginInstanceConfig]
   * method.
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
   *   UpdatePluginInstanceRequest request =
   *       UpdatePluginInstanceRequest.newBuilder()
   *           .setPluginInstance(PluginInstance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PluginInstance response = apiHubPluginClient.updatePluginInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluginInstance updatePluginInstance(UpdatePluginInstanceRequest request) {
    return updatePluginInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a plugin instance in the API hub. The following fields in the
   * [plugin_instance][google.cloud.apihub.v1.PluginInstance] can be updated currently:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.PluginInstance.display_name]
   *   <li>[schedule_cron_expression][PluginInstance.actions.schedule_cron_expression]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdatePluginInstanceRequest.update_mask] should be
   * used to specify the fields being updated.
   *
   * <p>To update the [auth_config][google.cloud.apihub.v1.PluginInstance.auth_config] and
   * [additional_config][google.cloud.apihub.v1.PluginInstance.additional_config] of the plugin
   * instance, use the
   * [ApplyPluginInstanceConfig][google.cloud.apihub.v1.ApiHubPlugin.ApplyPluginInstanceConfig]
   * method.
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
   *   UpdatePluginInstanceRequest request =
   *       UpdatePluginInstanceRequest.newBuilder()
   *           .setPluginInstance(PluginInstance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PluginInstance> future =
   *       apiHubPluginClient.updatePluginInstanceCallable().futureCall(request);
   *   // Do something.
   *   PluginInstance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePluginInstanceRequest, PluginInstance>
      updatePluginInstanceCallable() {
    return stub.updatePluginInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a plugin instance in the API hub.
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
   *   PluginInstanceName name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]");
   *   apiHubPluginClient.deletePluginInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to delete. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePluginInstanceAsync(
      PluginInstanceName name) {
    DeletePluginInstanceRequest request =
        DeletePluginInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePluginInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a plugin instance in the API hub.
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
   *   String name =
   *       PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]").toString();
   *   apiHubPluginClient.deletePluginInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the plugin instance to delete. Format:
   *     `projects/{project}/locations/{location}/plugins/{plugin}/instances/{instance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePluginInstanceAsync(String name) {
    DeletePluginInstanceRequest request =
        DeletePluginInstanceRequest.newBuilder().setName(name).build();
    return deletePluginInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a plugin instance in the API hub.
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
   *   DeletePluginInstanceRequest request =
   *       DeletePluginInstanceRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   apiHubPluginClient.deletePluginInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePluginInstanceAsync(
      DeletePluginInstanceRequest request) {
    return deletePluginInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a plugin instance in the API hub.
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
   *   DeletePluginInstanceRequest request =
   *       DeletePluginInstanceRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       apiHubPluginClient.deletePluginInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationCallable() {
    return stub.deletePluginInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a plugin instance in the API hub.
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
   *   DeletePluginInstanceRequest request =
   *       DeletePluginInstanceRequest.newBuilder()
   *           .setName(
   *               PluginInstanceName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]", "[INSTANCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       apiHubPluginClient.deletePluginInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePluginInstanceRequest, Operation>
      deletePluginInstanceCallable() {
    return stub.deletePluginInstanceCallable();
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

  public static class ListPluginsPagedResponse
      extends AbstractPagedListResponse<
          ListPluginsRequest,
          ListPluginsResponse,
          Plugin,
          ListPluginsPage,
          ListPluginsFixedSizeCollection> {

    public static ApiFuture<ListPluginsPagedResponse> createAsync(
        PageContext<ListPluginsRequest, ListPluginsResponse, Plugin> context,
        ApiFuture<ListPluginsResponse> futureResponse) {
      ApiFuture<ListPluginsPage> futurePage =
          ListPluginsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPluginsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPluginsPagedResponse(ListPluginsPage page) {
      super(page, ListPluginsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPluginsPage
      extends AbstractPage<ListPluginsRequest, ListPluginsResponse, Plugin, ListPluginsPage> {

    private ListPluginsPage(
        PageContext<ListPluginsRequest, ListPluginsResponse, Plugin> context,
        ListPluginsResponse response) {
      super(context, response);
    }

    private static ListPluginsPage createEmptyPage() {
      return new ListPluginsPage(null, null);
    }

    @Override
    protected ListPluginsPage createPage(
        PageContext<ListPluginsRequest, ListPluginsResponse, Plugin> context,
        ListPluginsResponse response) {
      return new ListPluginsPage(context, response);
    }

    @Override
    public ApiFuture<ListPluginsPage> createPageAsync(
        PageContext<ListPluginsRequest, ListPluginsResponse, Plugin> context,
        ApiFuture<ListPluginsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPluginsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPluginsRequest,
          ListPluginsResponse,
          Plugin,
          ListPluginsPage,
          ListPluginsFixedSizeCollection> {

    private ListPluginsFixedSizeCollection(List<ListPluginsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPluginsFixedSizeCollection createEmptyCollection() {
      return new ListPluginsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPluginsFixedSizeCollection createCollection(
        List<ListPluginsPage> pages, int collectionSize) {
      return new ListPluginsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPluginInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListPluginInstancesRequest,
          ListPluginInstancesResponse,
          PluginInstance,
          ListPluginInstancesPage,
          ListPluginInstancesFixedSizeCollection> {

    public static ApiFuture<ListPluginInstancesPagedResponse> createAsync(
        PageContext<ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>
            context,
        ApiFuture<ListPluginInstancesResponse> futureResponse) {
      ApiFuture<ListPluginInstancesPage> futurePage =
          ListPluginInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPluginInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPluginInstancesPagedResponse(ListPluginInstancesPage page) {
      super(page, ListPluginInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPluginInstancesPage
      extends AbstractPage<
          ListPluginInstancesRequest,
          ListPluginInstancesResponse,
          PluginInstance,
          ListPluginInstancesPage> {

    private ListPluginInstancesPage(
        PageContext<ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>
            context,
        ListPluginInstancesResponse response) {
      super(context, response);
    }

    private static ListPluginInstancesPage createEmptyPage() {
      return new ListPluginInstancesPage(null, null);
    }

    @Override
    protected ListPluginInstancesPage createPage(
        PageContext<ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>
            context,
        ListPluginInstancesResponse response) {
      return new ListPluginInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListPluginInstancesPage> createPageAsync(
        PageContext<ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>
            context,
        ApiFuture<ListPluginInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPluginInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPluginInstancesRequest,
          ListPluginInstancesResponse,
          PluginInstance,
          ListPluginInstancesPage,
          ListPluginInstancesFixedSizeCollection> {

    private ListPluginInstancesFixedSizeCollection(
        List<ListPluginInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPluginInstancesFixedSizeCollection createEmptyCollection() {
      return new ListPluginInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPluginInstancesFixedSizeCollection createCollection(
        List<ListPluginInstancesPage> pages, int collectionSize) {
      return new ListPluginInstancesFixedSizeCollection(pages, collectionSize);
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
