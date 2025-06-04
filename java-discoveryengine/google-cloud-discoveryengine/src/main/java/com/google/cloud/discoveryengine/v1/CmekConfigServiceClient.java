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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.CmekConfigServiceStub;
import com.google.cloud.discoveryengine.v1.stub.CmekConfigServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing CMEK related tasks
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
 * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
 *   CmekConfigName name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
 *   CmekConfig response = cmekConfigServiceClient.getCmekConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CmekConfigServiceClient object to clean up resources
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
 *      <td><p> UpdateCmekConfig</td>
 *      <td><p> Provisions a CMEK key for use in a location of a customer's project. This method will also conduct location validation on the provided cmekConfig to make sure the key is valid and can be used in the selected location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCmekConfigAsync(UpdateCmekConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateCmekConfigAsync(CmekConfig config)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCmekConfigOperationCallable()
 *           <li><p> updateCmekConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCmekConfig</td>
 *      <td><p> Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCmekConfig(GetCmekConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCmekConfig(CmekConfigName name)
 *           <li><p> getCmekConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCmekConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCmekConfigs</td>
 *      <td><p> Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s with the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCmekConfigs(ListCmekConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCmekConfigs(LocationName parent)
 *           <li><p> listCmekConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCmekConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCmekConfig</td>
 *      <td><p> De-provisions a CmekConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCmekConfigAsync(DeleteCmekConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCmekConfigAsync(CmekConfigName name)
 *           <li><p> deleteCmekConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCmekConfigOperationCallable()
 *           <li><p> deleteCmekConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of CmekConfigServiceSettings to
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
 * CmekConfigServiceSettings cmekConfigServiceSettings =
 *     CmekConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CmekConfigServiceClient cmekConfigServiceClient =
 *     CmekConfigServiceClient.create(cmekConfigServiceSettings);
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
 * CmekConfigServiceSettings cmekConfigServiceSettings =
 *     CmekConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CmekConfigServiceClient cmekConfigServiceClient =
 *     CmekConfigServiceClient.create(cmekConfigServiceSettings);
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
 * CmekConfigServiceSettings cmekConfigServiceSettings =
 *     CmekConfigServiceSettings.newHttpJsonBuilder().build();
 * CmekConfigServiceClient cmekConfigServiceClient =
 *     CmekConfigServiceClient.create(cmekConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CmekConfigServiceClient implements BackgroundResource {
  private final CmekConfigServiceSettings settings;
  private final CmekConfigServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CmekConfigServiceClient with default settings. */
  public static final CmekConfigServiceClient create() throws IOException {
    return create(CmekConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CmekConfigServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CmekConfigServiceClient create(CmekConfigServiceSettings settings)
      throws IOException {
    return new CmekConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of CmekConfigServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CmekConfigServiceSettings).
   */
  public static final CmekConfigServiceClient create(CmekConfigServiceStub stub) {
    return new CmekConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of CmekConfigServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CmekConfigServiceClient(CmekConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CmekConfigServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CmekConfigServiceClient(CmekConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CmekConfigServiceSettings getSettings() {
    return settings;
  }

  public CmekConfigServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions a CMEK key for use in a location of a customer's project. This method will also
   * conduct location validation on the provided cmekConfig to make sure the key is valid and can be
   * used in the selected location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   CmekConfig config = CmekConfig.newBuilder().build();
   *   CmekConfig response = cmekConfigServiceClient.updateCmekConfigAsync(config).get();
   * }
   * }</pre>
   *
   * @param config Required. The CmekConfig resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CmekConfig, UpdateCmekConfigMetadata> updateCmekConfigAsync(
      CmekConfig config) {
    UpdateCmekConfigRequest request =
        UpdateCmekConfigRequest.newBuilder().setConfig(config).build();
    return updateCmekConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions a CMEK key for use in a location of a customer's project. This method will also
   * conduct location validation on the provided cmekConfig to make sure the key is valid and can be
   * used in the selected location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   UpdateCmekConfigRequest request =
   *       UpdateCmekConfigRequest.newBuilder()
   *           .setConfig(CmekConfig.newBuilder().build())
   *           .setSetDefault(true)
   *           .build();
   *   CmekConfig response = cmekConfigServiceClient.updateCmekConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CmekConfig, UpdateCmekConfigMetadata> updateCmekConfigAsync(
      UpdateCmekConfigRequest request) {
    return updateCmekConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions a CMEK key for use in a location of a customer's project. This method will also
   * conduct location validation on the provided cmekConfig to make sure the key is valid and can be
   * used in the selected location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   UpdateCmekConfigRequest request =
   *       UpdateCmekConfigRequest.newBuilder()
   *           .setConfig(CmekConfig.newBuilder().build())
   *           .setSetDefault(true)
   *           .build();
   *   OperationFuture<CmekConfig, UpdateCmekConfigMetadata> future =
   *       cmekConfigServiceClient.updateCmekConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   CmekConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationCallable() {
    return stub.updateCmekConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions a CMEK key for use in a location of a customer's project. This method will also
   * conduct location validation on the provided cmekConfig to make sure the key is valid and can be
   * used in the selected location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   UpdateCmekConfigRequest request =
   *       UpdateCmekConfigRequest.newBuilder()
   *           .setConfig(CmekConfig.newBuilder().build())
   *           .setSetDefault(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cmekConfigServiceClient.updateCmekConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCmekConfigRequest, Operation> updateCmekConfigCallable() {
    return stub.updateCmekConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   CmekConfigName name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   CmekConfig response = cmekConfigServiceClient.getCmekConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig], such as
   *     `projects/&#42;/locations/&#42;/cmekConfig` or
   *     `projects/&#42;/locations/&#42;/cmekConfigs/&#42;`.
   *     <p>If the caller does not have permission to access the
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmekConfig getCmekConfig(CmekConfigName name) {
    GetCmekConfigRequest request =
        GetCmekConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCmekConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   String name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   CmekConfig response = cmekConfigServiceClient.getCmekConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig], such as
   *     `projects/&#42;/locations/&#42;/cmekConfig` or
   *     `projects/&#42;/locations/&#42;/cmekConfigs/&#42;`.
   *     <p>If the caller does not have permission to access the
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmekConfig getCmekConfig(String name) {
    GetCmekConfigRequest request = GetCmekConfigRequest.newBuilder().setName(name).build();
    return getCmekConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   GetCmekConfigRequest request =
   *       GetCmekConfigRequest.newBuilder()
   *           .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   CmekConfig response = cmekConfigServiceClient.getCmekConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmekConfig getCmekConfig(GetCmekConfigRequest request) {
    return getCmekConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   GetCmekConfigRequest request =
   *       GetCmekConfigRequest.newBuilder()
   *           .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<CmekConfig> future =
   *       cmekConfigServiceClient.getCmekConfigCallable().futureCall(request);
   *   // Do something.
   *   CmekConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCmekConfigRequest, CmekConfig> getCmekConfigCallable() {
    return stub.getCmekConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListCmekConfigsResponse response = cmekConfigServiceClient.listCmekConfigs(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource name, such as
   *     `projects/{project}/locations/{location}`.
   *     <p>If the caller does not have permission to list
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s under this location, regardless
   *     of whether or not a CmekConfig exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmekConfigsResponse listCmekConfigs(LocationName parent) {
    ListCmekConfigsRequest request =
        ListCmekConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCmekConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListCmekConfigsResponse response = cmekConfigServiceClient.listCmekConfigs(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource name, such as
   *     `projects/{project}/locations/{location}`.
   *     <p>If the caller does not have permission to list
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s under this location, regardless
   *     of whether or not a CmekConfig exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmekConfigsResponse listCmekConfigs(String parent) {
    ListCmekConfigsRequest request = ListCmekConfigsRequest.newBuilder().setParent(parent).build();
    return listCmekConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   ListCmekConfigsRequest request =
   *       ListCmekConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ListCmekConfigsResponse response = cmekConfigServiceClient.listCmekConfigs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCmekConfigsResponse listCmekConfigs(ListCmekConfigsRequest request) {
    return listCmekConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   ListCmekConfigsRequest request =
   *       ListCmekConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ListCmekConfigsResponse> future =
   *       cmekConfigServiceClient.listCmekConfigsCallable().futureCall(request);
   *   // Do something.
   *   ListCmekConfigsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCmekConfigsRequest, ListCmekConfigsResponse>
      listCmekConfigsCallable() {
    return stub.listCmekConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-provisions a CmekConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   CmekConfigName name =
   *       CmekConfigName.ofProjectLocationCmekConfigName(
   *           "[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]");
   *   cmekConfigServiceClient.deleteCmekConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig] to delete, such as
   *     `projects/{project}/locations/{location}/cmekConfigs/{cmek_config}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCmekConfigMetadata> deleteCmekConfigAsync(
      CmekConfigName name) {
    DeleteCmekConfigRequest request =
        DeleteCmekConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCmekConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-provisions a CmekConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   String name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   cmekConfigServiceClient.deleteCmekConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig] to delete, such as
   *     `projects/{project}/locations/{location}/cmekConfigs/{cmek_config}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCmekConfigMetadata> deleteCmekConfigAsync(String name) {
    DeleteCmekConfigRequest request = DeleteCmekConfigRequest.newBuilder().setName(name).build();
    return deleteCmekConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-provisions a CmekConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   DeleteCmekConfigRequest request =
   *       DeleteCmekConfigRequest.newBuilder()
   *           .setName(
   *               CmekConfigName.ofProjectLocationCmekConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]")
   *                   .toString())
   *           .build();
   *   cmekConfigServiceClient.deleteCmekConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCmekConfigMetadata> deleteCmekConfigAsync(
      DeleteCmekConfigRequest request) {
    return deleteCmekConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-provisions a CmekConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   DeleteCmekConfigRequest request =
   *       DeleteCmekConfigRequest.newBuilder()
   *           .setName(
   *               CmekConfigName.ofProjectLocationCmekConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteCmekConfigMetadata> future =
   *       cmekConfigServiceClient.deleteCmekConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationCallable() {
    return stub.deleteCmekConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * De-provisions a CmekConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekConfigServiceClient cmekConfigServiceClient = CmekConfigServiceClient.create()) {
   *   DeleteCmekConfigRequest request =
   *       DeleteCmekConfigRequest.newBuilder()
   *           .setName(
   *               CmekConfigName.ofProjectLocationCmekConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cmekConfigServiceClient.deleteCmekConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCmekConfigRequest, Operation> deleteCmekConfigCallable() {
    return stub.deleteCmekConfigCallable();
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
