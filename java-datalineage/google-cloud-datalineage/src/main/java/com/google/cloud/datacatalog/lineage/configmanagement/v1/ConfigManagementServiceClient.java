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

package com.google.cloud.datacatalog.lineage.configmanagement.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.lineage.configmanagement.v1.stub.ConfigManagementServiceStub;
import com.google.cloud.datacatalog.lineage.configmanagement.v1.stub.ConfigManagementServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Lineage Config Management service. Config Management service is used to
 * manage the configuration for Data Lineage. These Configs define different configuration options
 * for Lineage customers to control behaviour of lineage systems.
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
 * try (ConfigManagementServiceClient configManagementServiceClient =
 *     ConfigManagementServiceClient.create()) {
 *   ConfigName name = ConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
 *   Config response = configManagementServiceClient.getConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConfigManagementServiceClient object to clean up
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
 *      <td><p> GetConfig</td>
 *      <td><p> Get the Config for a given resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConfig(GetConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConfig(ConfigName name)
 *           <li><p> getConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConfig</td>
 *      <td><p> Update the Config for a given resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConfig(UpdateConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConfig(Config config)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConfigCallable()
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
 * ConfigManagementServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigManagementServiceSettings configManagementServiceSettings =
 *     ConfigManagementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigManagementServiceClient configManagementServiceClient =
 *     ConfigManagementServiceClient.create(configManagementServiceSettings);
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
 * ConfigManagementServiceSettings configManagementServiceSettings =
 *     ConfigManagementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConfigManagementServiceClient configManagementServiceClient =
 *     ConfigManagementServiceClient.create(configManagementServiceSettings);
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
 * ConfigManagementServiceSettings configManagementServiceSettings =
 *     ConfigManagementServiceSettings.newHttpJsonBuilder().build();
 * ConfigManagementServiceClient configManagementServiceClient =
 *     ConfigManagementServiceClient.create(configManagementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConfigManagementServiceClient implements BackgroundResource {
  private final ConfigManagementServiceSettings settings;
  private final ConfigManagementServiceStub stub;

  /** Constructs an instance of ConfigManagementServiceClient with default settings. */
  public static final ConfigManagementServiceClient create() throws IOException {
    return create(ConfigManagementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConfigManagementServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigManagementServiceClient create(ConfigManagementServiceSettings settings)
      throws IOException {
    return new ConfigManagementServiceClient(settings);
  }

  /**
   * Constructs an instance of ConfigManagementServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ConfigManagementServiceSettings).
   */
  public static final ConfigManagementServiceClient create(ConfigManagementServiceStub stub) {
    return new ConfigManagementServiceClient(stub);
  }

  /**
   * Constructs an instance of ConfigManagementServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConfigManagementServiceClient(ConfigManagementServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ConfigManagementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConfigManagementServiceClient(ConfigManagementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConfigManagementServiceSettings getSettings() {
    return settings;
  }

  public ConfigManagementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   ConfigName name = ConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   Config response = configManagementServiceClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. REQUIRED: The resource name of the config to be fetched. Format:
   *     `organizations/{organization_id}/locations/global/config`
   *     `folders/{folder_id}/locations/global/config`
   *     `projects/{project_id}/locations/global/config`
   *     `projects/{project_number}/locations/global/config`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(ConfigName name) {
    GetConfigRequest request =
        GetConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   String name = ConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   Config response = configManagementServiceClient.getConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. REQUIRED: The resource name of the config to be fetched. Format:
   *     `organizations/{organization_id}/locations/global/config`
   *     `folders/{folder_id}/locations/global/config`
   *     `projects/{project_id}/locations/global/config`
   *     `projects/{project_number}/locations/global/config`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(String name) {
    GetConfigRequest request = GetConfigRequest.newBuilder().setName(name).build();
    return getConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Config response = configManagementServiceClient.getConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config getConfig(GetConfigRequest request) {
    return getConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   GetConfigRequest request =
   *       GetConfigRequest.newBuilder()
   *           .setName(ConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Config> future =
   *       configManagementServiceClient.getConfigCallable().futureCall(request);
   *   // Do something.
   *   Config response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return stub.getConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   Config config = Config.newBuilder().build();
   *   Config response = configManagementServiceClient.updateConfig(config);
   * }
   * }</pre>
   *
   * @param config Required. REQUIRED: The config to be applied to the resource and all its
   *     descendants.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config updateConfig(Config config) {
    UpdateConfigRequest request = UpdateConfigRequest.newBuilder().setConfig(config).build();
    return updateConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   UpdateConfigRequest request =
   *       UpdateConfigRequest.newBuilder().setConfig(Config.newBuilder().build()).build();
   *   Config response = configManagementServiceClient.updateConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Config updateConfig(UpdateConfigRequest request) {
    return updateConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the Config for a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigManagementServiceClient configManagementServiceClient =
   *     ConfigManagementServiceClient.create()) {
   *   UpdateConfigRequest request =
   *       UpdateConfigRequest.newBuilder().setConfig(Config.newBuilder().build()).build();
   *   ApiFuture<Config> future =
   *       configManagementServiceClient.updateConfigCallable().futureCall(request);
   *   // Do something.
   *   Config response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable() {
    return stub.updateConfigCallable();
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
