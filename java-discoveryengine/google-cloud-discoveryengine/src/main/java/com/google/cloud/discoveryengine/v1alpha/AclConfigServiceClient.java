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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.stub.AclConfigServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.AclConfigServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Acl Configuration.
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
 * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
 *   UpdateAclConfigRequest request =
 *       UpdateAclConfigRequest.newBuilder().setAclConfig(AclConfig.newBuilder().build()).build();
 *   AclConfig response = aclConfigServiceClient.updateAclConfig(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AclConfigServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAclConfig</td>
 *      <td><p> Default Acl Configuration for use in a location of a customer's project. Updates will only reflect to new data stores. Existing data stores will still use the old value.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAclConfig(UpdateAclConfigRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAclConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAclConfig</td>
 *      <td><p> Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAclConfig(GetAclConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAclConfig(AclConfigName name)
 *           <li><p> getAclConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAclConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of AclConfigServiceSettings to
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
 * AclConfigServiceSettings aclConfigServiceSettings =
 *     AclConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AclConfigServiceClient aclConfigServiceClient =
 *     AclConfigServiceClient.create(aclConfigServiceSettings);
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
 * AclConfigServiceSettings aclConfigServiceSettings =
 *     AclConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AclConfigServiceClient aclConfigServiceClient =
 *     AclConfigServiceClient.create(aclConfigServiceSettings);
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
 * AclConfigServiceSettings aclConfigServiceSettings =
 *     AclConfigServiceSettings.newHttpJsonBuilder().build();
 * AclConfigServiceClient aclConfigServiceClient =
 *     AclConfigServiceClient.create(aclConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AclConfigServiceClient implements BackgroundResource {
  private final AclConfigServiceSettings settings;
  private final AclConfigServiceStub stub;

  /** Constructs an instance of AclConfigServiceClient with default settings. */
  public static final AclConfigServiceClient create() throws IOException {
    return create(AclConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AclConfigServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AclConfigServiceClient create(AclConfigServiceSettings settings)
      throws IOException {
    return new AclConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of AclConfigServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AclConfigServiceSettings).
   */
  public static final AclConfigServiceClient create(AclConfigServiceStub stub) {
    return new AclConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of AclConfigServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AclConfigServiceClient(AclConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AclConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AclConfigServiceClient(AclConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AclConfigServiceSettings getSettings() {
    return settings;
  }

  public AclConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Default Acl Configuration for use in a location of a customer's project. Updates will only
   * reflect to new data stores. Existing data stores will still use the old value.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
   *   UpdateAclConfigRequest request =
   *       UpdateAclConfigRequest.newBuilder().setAclConfig(AclConfig.newBuilder().build()).build();
   *   AclConfig response = aclConfigServiceClient.updateAclConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclConfig updateAclConfig(UpdateAclConfigRequest request) {
    return updateAclConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Default Acl Configuration for use in a location of a customer's project. Updates will only
   * reflect to new data stores. Existing data stores will still use the old value.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
   *   UpdateAclConfigRequest request =
   *       UpdateAclConfigRequest.newBuilder().setAclConfig(AclConfig.newBuilder().build()).build();
   *   ApiFuture<AclConfig> future =
   *       aclConfigServiceClient.updateAclConfigCallable().futureCall(request);
   *   // Do something.
   *   AclConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAclConfigRequest, AclConfig> updateAclConfigCallable() {
    return stub.updateAclConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
   *   AclConfigName name = AclConfigName.of("[PROJECT]", "[LOCATION]");
   *   AclConfig response = aclConfigServiceClient.getAclConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig], such as
   *     `projects/&#42;/locations/&#42;/aclConfig`.
   *     <p>If the caller does not have permission to access the
   *     [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig], regardless of whether or not
   *     it exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclConfig getAclConfig(AclConfigName name) {
    GetAclConfigRequest request =
        GetAclConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAclConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
   *   String name = AclConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   AclConfig response = aclConfigServiceClient.getAclConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig], such as
   *     `projects/&#42;/locations/&#42;/aclConfig`.
   *     <p>If the caller does not have permission to access the
   *     [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig], regardless of whether or not
   *     it exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclConfig getAclConfig(String name) {
    GetAclConfigRequest request = GetAclConfigRequest.newBuilder().setName(name).build();
    return getAclConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
   *   GetAclConfigRequest request =
   *       GetAclConfigRequest.newBuilder()
   *           .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   AclConfig response = aclConfigServiceClient.getAclConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclConfig getAclConfig(GetAclConfigRequest request) {
    return getAclConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [AclConfig][google.cloud.discoveryengine.v1alpha.AclConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AclConfigServiceClient aclConfigServiceClient = AclConfigServiceClient.create()) {
   *   GetAclConfigRequest request =
   *       GetAclConfigRequest.newBuilder()
   *           .setName(AclConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<AclConfig> future =
   *       aclConfigServiceClient.getAclConfigCallable().futureCall(request);
   *   // Do something.
   *   AclConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAclConfigRequest, AclConfig> getAclConfigCallable() {
    return stub.getAclConfigCallable();
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
