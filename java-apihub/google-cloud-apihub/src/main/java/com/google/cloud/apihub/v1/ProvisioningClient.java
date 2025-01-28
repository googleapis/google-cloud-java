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
import com.google.cloud.apihub.v1.stub.ProvisioningStub;
import com.google.cloud.apihub.v1.stub.ProvisioningStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is used for managing the data plane provisioning of the API
 * hub.
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
 * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
 *   ApiHubInstanceName name =
 *       ApiHubInstanceName.of("[PROJECT]", "[LOCATION]", "[API_HUB_INSTANCE]");
 *   ApiHubInstance response = provisioningClient.getApiHubInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProvisioningClient object to clean up resources such
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
 *      <td><p> CreateApiHubInstance</td>
 *      <td><p> Provisions instance resources for the API Hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApiHubInstanceAsync(CreateApiHubInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createApiHubInstanceAsync(LocationName parent, ApiHubInstance apiHubInstance, String apiHubInstanceId)
 *           <li><p> createApiHubInstanceAsync(String parent, ApiHubInstance apiHubInstance, String apiHubInstanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApiHubInstanceOperationCallable()
 *           <li><p> createApiHubInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApiHubInstance</td>
 *      <td><p> Gets details of a single API Hub instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApiHubInstance(GetApiHubInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApiHubInstance(ApiHubInstanceName name)
 *           <li><p> getApiHubInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApiHubInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupApiHubInstance</td>
 *      <td><p> Looks up an Api Hub instance in a given GCP project. There will always be only one Api Hub instance for a GCP project across all locations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupApiHubInstance(LookupApiHubInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lookupApiHubInstance(LocationName parent)
 *           <li><p> lookupApiHubInstance(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupApiHubInstanceCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProvisioningSettings to
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
 * ProvisioningSettings provisioningSettings =
 *     ProvisioningSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProvisioningClient provisioningClient = ProvisioningClient.create(provisioningSettings);
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
 * ProvisioningSettings provisioningSettings =
 *     ProvisioningSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProvisioningClient provisioningClient = ProvisioningClient.create(provisioningSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ProvisioningClient implements BackgroundResource {
  private final ProvisioningSettings settings;
  private final ProvisioningStub stub;
  private final OperationsClient httpJsonOperationsClient;

  /** Constructs an instance of ProvisioningClient with default settings. */
  public static final ProvisioningClient create() throws IOException {
    return create(ProvisioningSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProvisioningClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProvisioningClient create(ProvisioningSettings settings) throws IOException {
    return new ProvisioningClient(settings);
  }

  /**
   * Constructs an instance of ProvisioningClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProvisioningSettings).
   */
  public static final ProvisioningClient create(ProvisioningStub stub) {
    return new ProvisioningClient(stub);
  }

  /**
   * Constructs an instance of ProvisioningClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProvisioningClient(ProvisioningSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProvisioningStubSettings) settings.getStubSettings()).createStub();
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ProvisioningClient(ProvisioningStub stub) {
    this.settings = null;
    this.stub = stub;
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ProvisioningSettings getSettings() {
    return settings;
  }

  public ProvisioningStub getStub() {
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
   * Provisions instance resources for the API Hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ApiHubInstance apiHubInstance = ApiHubInstance.newBuilder().build();
   *   String apiHubInstanceId = "apiHubInstanceId-1318600853";
   *   ApiHubInstance response =
   *       provisioningClient
   *           .createApiHubInstanceAsync(parent, apiHubInstance, apiHubInstanceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the Api Hub instance resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param apiHubInstance Required. The ApiHub instance.
   * @param apiHubInstanceId Optional. Identifier to assign to the Api Hub instance. Must be unique
   *     within scope of the parent resource. If the field is not provided, system generated id will
   *     be used.
   *     <p>This value should be 4-40 characters, and valid characters are `/[a-z][A-Z][0-9]-_/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiHubInstance, OperationMetadata> createApiHubInstanceAsync(
      LocationName parent, ApiHubInstance apiHubInstance, String apiHubInstanceId) {
    CreateApiHubInstanceRequest request =
        CreateApiHubInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApiHubInstance(apiHubInstance)
            .setApiHubInstanceId(apiHubInstanceId)
            .build();
    return createApiHubInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions instance resources for the API Hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ApiHubInstance apiHubInstance = ApiHubInstance.newBuilder().build();
   *   String apiHubInstanceId = "apiHubInstanceId-1318600853";
   *   ApiHubInstance response =
   *       provisioningClient
   *           .createApiHubInstanceAsync(parent, apiHubInstance, apiHubInstanceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the Api Hub instance resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param apiHubInstance Required. The ApiHub instance.
   * @param apiHubInstanceId Optional. Identifier to assign to the Api Hub instance. Must be unique
   *     within scope of the parent resource. If the field is not provided, system generated id will
   *     be used.
   *     <p>This value should be 4-40 characters, and valid characters are `/[a-z][A-Z][0-9]-_/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiHubInstance, OperationMetadata> createApiHubInstanceAsync(
      String parent, ApiHubInstance apiHubInstance, String apiHubInstanceId) {
    CreateApiHubInstanceRequest request =
        CreateApiHubInstanceRequest.newBuilder()
            .setParent(parent)
            .setApiHubInstance(apiHubInstance)
            .setApiHubInstanceId(apiHubInstanceId)
            .build();
    return createApiHubInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions instance resources for the API Hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   CreateApiHubInstanceRequest request =
   *       CreateApiHubInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiHubInstanceId("apiHubInstanceId-1318600853")
   *           .setApiHubInstance(ApiHubInstance.newBuilder().build())
   *           .build();
   *   ApiHubInstance response = provisioningClient.createApiHubInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ApiHubInstance, OperationMetadata> createApiHubInstanceAsync(
      CreateApiHubInstanceRequest request) {
    return createApiHubInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions instance resources for the API Hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   CreateApiHubInstanceRequest request =
   *       CreateApiHubInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiHubInstanceId("apiHubInstanceId-1318600853")
   *           .setApiHubInstance(ApiHubInstance.newBuilder().build())
   *           .build();
   *   OperationFuture<ApiHubInstance, OperationMetadata> future =
   *       provisioningClient.createApiHubInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   ApiHubInstance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateApiHubInstanceRequest, ApiHubInstance, OperationMetadata>
      createApiHubInstanceOperationCallable() {
    return stub.createApiHubInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions instance resources for the API Hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   CreateApiHubInstanceRequest request =
   *       CreateApiHubInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiHubInstanceId("apiHubInstanceId-1318600853")
   *           .setApiHubInstance(ApiHubInstance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       provisioningClient.createApiHubInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiHubInstanceRequest, Operation>
      createApiHubInstanceCallable() {
    return stub.createApiHubInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single API Hub instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   ApiHubInstanceName name =
   *       ApiHubInstanceName.of("[PROJECT]", "[LOCATION]", "[API_HUB_INSTANCE]");
   *   ApiHubInstance response = provisioningClient.getApiHubInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Api Hub instance to retrieve. Format:
   *     `projects/{project}/locations/{location}/apiHubInstances/{apiHubInstance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiHubInstance getApiHubInstance(ApiHubInstanceName name) {
    GetApiHubInstanceRequest request =
        GetApiHubInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getApiHubInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single API Hub instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   String name =
   *       ApiHubInstanceName.of("[PROJECT]", "[LOCATION]", "[API_HUB_INSTANCE]").toString();
   *   ApiHubInstance response = provisioningClient.getApiHubInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Api Hub instance to retrieve. Format:
   *     `projects/{project}/locations/{location}/apiHubInstances/{apiHubInstance}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiHubInstance getApiHubInstance(String name) {
    GetApiHubInstanceRequest request = GetApiHubInstanceRequest.newBuilder().setName(name).build();
    return getApiHubInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single API Hub instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   GetApiHubInstanceRequest request =
   *       GetApiHubInstanceRequest.newBuilder()
   *           .setName(
   *               ApiHubInstanceName.of("[PROJECT]", "[LOCATION]", "[API_HUB_INSTANCE]").toString())
   *           .build();
   *   ApiHubInstance response = provisioningClient.getApiHubInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiHubInstance getApiHubInstance(GetApiHubInstanceRequest request) {
    return getApiHubInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single API Hub instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   GetApiHubInstanceRequest request =
   *       GetApiHubInstanceRequest.newBuilder()
   *           .setName(
   *               ApiHubInstanceName.of("[PROJECT]", "[LOCATION]", "[API_HUB_INSTANCE]").toString())
   *           .build();
   *   ApiFuture<ApiHubInstance> future =
   *       provisioningClient.getApiHubInstanceCallable().futureCall(request);
   *   // Do something.
   *   ApiHubInstance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiHubInstanceRequest, ApiHubInstance> getApiHubInstanceCallable() {
    return stub.getApiHubInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up an Api Hub instance in a given GCP project. There will always be only one Api Hub
   * instance for a GCP project across all locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LookupApiHubInstanceResponse response = provisioningClient.lookupApiHubInstance(parent);
   * }
   * }</pre>
   *
   * @param parent Required. There will always be only one Api Hub instance for a GCP project across
   *     all locations. The parent resource for the Api Hub instance resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupApiHubInstanceResponse lookupApiHubInstance(LocationName parent) {
    LookupApiHubInstanceRequest request =
        LookupApiHubInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return lookupApiHubInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up an Api Hub instance in a given GCP project. There will always be only one Api Hub
   * instance for a GCP project across all locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LookupApiHubInstanceResponse response = provisioningClient.lookupApiHubInstance(parent);
   * }
   * }</pre>
   *
   * @param parent Required. There will always be only one Api Hub instance for a GCP project across
   *     all locations. The parent resource for the Api Hub instance resource. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupApiHubInstanceResponse lookupApiHubInstance(String parent) {
    LookupApiHubInstanceRequest request =
        LookupApiHubInstanceRequest.newBuilder().setParent(parent).build();
    return lookupApiHubInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up an Api Hub instance in a given GCP project. There will always be only one Api Hub
   * instance for a GCP project across all locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   LookupApiHubInstanceRequest request =
   *       LookupApiHubInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   LookupApiHubInstanceResponse response = provisioningClient.lookupApiHubInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupApiHubInstanceResponse lookupApiHubInstance(
      LookupApiHubInstanceRequest request) {
    return lookupApiHubInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up an Api Hub instance in a given GCP project. There will always be only one Api Hub
   * instance for a GCP project across all locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   LookupApiHubInstanceRequest request =
   *       LookupApiHubInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<LookupApiHubInstanceResponse> future =
   *       provisioningClient.lookupApiHubInstanceCallable().futureCall(request);
   *   // Do something.
   *   LookupApiHubInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupApiHubInstanceRequest, LookupApiHubInstanceResponse>
      lookupApiHubInstanceCallable() {
    return stub.lookupApiHubInstanceCallable();
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
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : provisioningClient.listLocations(request).iterateAll()) {
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
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       provisioningClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = provisioningClient.listLocationsCallable().call(request);
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
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = provisioningClient.getLocation(request);
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
   * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = provisioningClient.getLocationCallable().futureCall(request);
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
