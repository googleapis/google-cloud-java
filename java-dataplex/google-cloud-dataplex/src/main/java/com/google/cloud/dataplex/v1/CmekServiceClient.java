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

package com.google.cloud.dataplex.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.stub.CmekServiceStub;
import com.google.cloud.dataplex.v1.stub.CmekServiceStubSettings;
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
 * Service Description: Dataplex Cmek Service
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
 * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
 *   EncryptionConfigName name =
 *       EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");
 *   EncryptionConfig response = cmekServiceClient.getEncryptionConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CmekServiceClient object to clean up resources such as
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
 *      <td><p> CreateEncryptionConfig</td>
 *      <td><p> Create an EncryptionConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEncryptionConfigAsync(CreateEncryptionConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEncryptionConfigAsync(OrganizationLocationName parent, EncryptionConfig encryptionConfig, String encryptionConfigId)
 *           <li><p> createEncryptionConfigAsync(String parent, EncryptionConfig encryptionConfig, String encryptionConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEncryptionConfigOperationCallable()
 *           <li><p> createEncryptionConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEncryptionConfig</td>
 *      <td><p> Update an EncryptionConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEncryptionConfigAsync(UpdateEncryptionConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEncryptionConfigAsync(EncryptionConfig encryptionConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEncryptionConfigOperationCallable()
 *           <li><p> updateEncryptionConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEncryptionConfig</td>
 *      <td><p> Delete an EncryptionConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEncryptionConfigAsync(DeleteEncryptionConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEncryptionConfigAsync(EncryptionConfigName name)
 *           <li><p> deleteEncryptionConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEncryptionConfigOperationCallable()
 *           <li><p> deleteEncryptionConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEncryptionConfigs</td>
 *      <td><p> List EncryptionConfigs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEncryptionConfigs(ListEncryptionConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEncryptionConfigs(OrganizationLocationName parent)
 *           <li><p> listEncryptionConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEncryptionConfigsPagedCallable()
 *           <li><p> listEncryptionConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEncryptionConfig</td>
 *      <td><p> Get an EncryptionConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEncryptionConfig(GetEncryptionConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEncryptionConfig(EncryptionConfigName name)
 *           <li><p> getEncryptionConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEncryptionConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of CmekServiceSettings to
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
 * CmekServiceSettings cmekServiceSettings =
 *     CmekServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CmekServiceClient cmekServiceClient = CmekServiceClient.create(cmekServiceSettings);
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
 * CmekServiceSettings cmekServiceSettings =
 *     CmekServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CmekServiceClient cmekServiceClient = CmekServiceClient.create(cmekServiceSettings);
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
 * CmekServiceSettings cmekServiceSettings = CmekServiceSettings.newHttpJsonBuilder().build();
 * CmekServiceClient cmekServiceClient = CmekServiceClient.create(cmekServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CmekServiceClient implements BackgroundResource {
  private final CmekServiceSettings settings;
  private final CmekServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CmekServiceClient with default settings. */
  public static final CmekServiceClient create() throws IOException {
    return create(CmekServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CmekServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CmekServiceClient create(CmekServiceSettings settings) throws IOException {
    return new CmekServiceClient(settings);
  }

  /**
   * Constructs an instance of CmekServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CmekServiceSettings).
   */
  public static final CmekServiceClient create(CmekServiceStub stub) {
    return new CmekServiceClient(stub);
  }

  /**
   * Constructs an instance of CmekServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CmekServiceClient(CmekServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CmekServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CmekServiceClient(CmekServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CmekServiceSettings getSettings() {
    return settings;
  }

  public CmekServiceStub getStub() {
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
   * Create an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
   *   String encryptionConfigId = "encryptionConfigId-1583151968";
   *   EncryptionConfig response =
   *       cmekServiceClient
   *           .createEncryptionConfigAsync(parent, encryptionConfig, encryptionConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The location at which the EncryptionConfig is to be created.
   * @param encryptionConfig Required. The EncryptionConfig to create.
   * @param encryptionConfigId Required. The ID of the EncryptionConfig to create. The ID must
   *     contain only letters (a-z, A-Z), numbers (0-9), and hyphens (-). The maximum size is 63
   *     characters. The first character must be a letter. The last character must be a letter or a
   *     number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EncryptionConfig, OperationMetadata> createEncryptionConfigAsync(
      OrganizationLocationName parent,
      EncryptionConfig encryptionConfig,
      String encryptionConfigId) {
    CreateEncryptionConfigRequest request =
        CreateEncryptionConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEncryptionConfig(encryptionConfig)
            .setEncryptionConfigId(encryptionConfigId)
            .build();
    return createEncryptionConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
   *   String encryptionConfigId = "encryptionConfigId-1583151968";
   *   EncryptionConfig response =
   *       cmekServiceClient
   *           .createEncryptionConfigAsync(parent, encryptionConfig, encryptionConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The location at which the EncryptionConfig is to be created.
   * @param encryptionConfig Required. The EncryptionConfig to create.
   * @param encryptionConfigId Required. The ID of the EncryptionConfig to create. The ID must
   *     contain only letters (a-z, A-Z), numbers (0-9), and hyphens (-). The maximum size is 63
   *     characters. The first character must be a letter. The last character must be a letter or a
   *     number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EncryptionConfig, OperationMetadata> createEncryptionConfigAsync(
      String parent, EncryptionConfig encryptionConfig, String encryptionConfigId) {
    CreateEncryptionConfigRequest request =
        CreateEncryptionConfigRequest.newBuilder()
            .setParent(parent)
            .setEncryptionConfig(encryptionConfig)
            .setEncryptionConfigId(encryptionConfigId)
            .build();
    return createEncryptionConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   CreateEncryptionConfigRequest request =
   *       CreateEncryptionConfigRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setEncryptionConfigId("encryptionConfigId-1583151968")
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .build();
   *   EncryptionConfig response = cmekServiceClient.createEncryptionConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EncryptionConfig, OperationMetadata> createEncryptionConfigAsync(
      CreateEncryptionConfigRequest request) {
    return createEncryptionConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   CreateEncryptionConfigRequest request =
   *       CreateEncryptionConfigRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setEncryptionConfigId("encryptionConfigId-1583151968")
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<EncryptionConfig, OperationMetadata> future =
   *       cmekServiceClient.createEncryptionConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   EncryptionConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationCallable() {
    return stub.createEncryptionConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   CreateEncryptionConfigRequest request =
   *       CreateEncryptionConfigRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setEncryptionConfigId("encryptionConfigId-1583151968")
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cmekServiceClient.createEncryptionConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigCallable() {
    return stub.createEncryptionConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EncryptionConfig response =
   *       cmekServiceClient.updateEncryptionConfigAsync(encryptionConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param encryptionConfig Required. The EncryptionConfig to update.
   * @param updateMask Optional. Mask of fields to update. The service treats an omitted field mask
   *     as an implied field mask equivalent to all fields that are populated (have a non-empty
   *     value).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EncryptionConfig, OperationMetadata> updateEncryptionConfigAsync(
      EncryptionConfig encryptionConfig, FieldMask updateMask) {
    UpdateEncryptionConfigRequest request =
        UpdateEncryptionConfigRequest.newBuilder()
            .setEncryptionConfig(encryptionConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateEncryptionConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   UpdateEncryptionConfigRequest request =
   *       UpdateEncryptionConfigRequest.newBuilder()
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EncryptionConfig response = cmekServiceClient.updateEncryptionConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EncryptionConfig, OperationMetadata> updateEncryptionConfigAsync(
      UpdateEncryptionConfigRequest request) {
    return updateEncryptionConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   UpdateEncryptionConfigRequest request =
   *       UpdateEncryptionConfigRequest.newBuilder()
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<EncryptionConfig, OperationMetadata> future =
   *       cmekServiceClient.updateEncryptionConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   EncryptionConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationCallable() {
    return stub.updateEncryptionConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   UpdateEncryptionConfigRequest request =
   *       UpdateEncryptionConfigRequest.newBuilder()
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cmekServiceClient.updateEncryptionConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigCallable() {
    return stub.updateEncryptionConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   EncryptionConfigName name =
   *       EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");
   *   cmekServiceClient.deleteEncryptionConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the EncryptionConfig to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEncryptionConfigAsync(
      EncryptionConfigName name) {
    DeleteEncryptionConfigRequest request =
        DeleteEncryptionConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEncryptionConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   String name =
   *       EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]").toString();
   *   cmekServiceClient.deleteEncryptionConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the EncryptionConfig to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEncryptionConfigAsync(String name) {
    DeleteEncryptionConfigRequest request =
        DeleteEncryptionConfigRequest.newBuilder().setName(name).build();
    return deleteEncryptionConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   DeleteEncryptionConfigRequest request =
   *       DeleteEncryptionConfigRequest.newBuilder()
   *           .setName(
   *               EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   cmekServiceClient.deleteEncryptionConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEncryptionConfigAsync(
      DeleteEncryptionConfigRequest request) {
    return deleteEncryptionConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   DeleteEncryptionConfigRequest request =
   *       DeleteEncryptionConfigRequest.newBuilder()
   *           .setName(
   *               EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cmekServiceClient.deleteEncryptionConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationCallable() {
    return stub.deleteEncryptionConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   DeleteEncryptionConfigRequest request =
   *       DeleteEncryptionConfigRequest.newBuilder()
   *           .setName(
   *               EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cmekServiceClient.deleteEncryptionConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigCallable() {
    return stub.deleteEncryptionConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List EncryptionConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (EncryptionConfig element :
   *       cmekServiceClient.listEncryptionConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location for which the EncryptionConfig is to be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEncryptionConfigsPagedResponse listEncryptionConfigs(
      OrganizationLocationName parent) {
    ListEncryptionConfigsRequest request =
        ListEncryptionConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEncryptionConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List EncryptionConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (EncryptionConfig element :
   *       cmekServiceClient.listEncryptionConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location for which the EncryptionConfig is to be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEncryptionConfigsPagedResponse listEncryptionConfigs(String parent) {
    ListEncryptionConfigsRequest request =
        ListEncryptionConfigsRequest.newBuilder().setParent(parent).build();
    return listEncryptionConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List EncryptionConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   ListEncryptionConfigsRequest request =
   *       ListEncryptionConfigsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EncryptionConfig element :
   *       cmekServiceClient.listEncryptionConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEncryptionConfigsPagedResponse listEncryptionConfigs(
      ListEncryptionConfigsRequest request) {
    return listEncryptionConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List EncryptionConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   ListEncryptionConfigsRequest request =
   *       ListEncryptionConfigsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EncryptionConfig> future =
   *       cmekServiceClient.listEncryptionConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EncryptionConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsPagedCallable() {
    return stub.listEncryptionConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List EncryptionConfigs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   ListEncryptionConfigsRequest request =
   *       ListEncryptionConfigsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEncryptionConfigsResponse response =
   *         cmekServiceClient.listEncryptionConfigsCallable().call(request);
   *     for (EncryptionConfig element : response.getEncryptionConfigsList()) {
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
  public final UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsCallable() {
    return stub.listEncryptionConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   EncryptionConfigName name =
   *       EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");
   *   EncryptionConfig response = cmekServiceClient.getEncryptionConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the EncryptionConfig to fetch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionConfig getEncryptionConfig(EncryptionConfigName name) {
    GetEncryptionConfigRequest request =
        GetEncryptionConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEncryptionConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   String name =
   *       EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]").toString();
   *   EncryptionConfig response = cmekServiceClient.getEncryptionConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the EncryptionConfig to fetch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionConfig getEncryptionConfig(String name) {
    GetEncryptionConfigRequest request =
        GetEncryptionConfigRequest.newBuilder().setName(name).build();
    return getEncryptionConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   GetEncryptionConfigRequest request =
   *       GetEncryptionConfigRequest.newBuilder()
   *           .setName(
   *               EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
   *                   .toString())
   *           .build();
   *   EncryptionConfig response = cmekServiceClient.getEncryptionConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionConfig getEncryptionConfig(GetEncryptionConfigRequest request) {
    return getEncryptionConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an EncryptionConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   GetEncryptionConfigRequest request =
   *       GetEncryptionConfigRequest.newBuilder()
   *           .setName(
   *               EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EncryptionConfig> future =
   *       cmekServiceClient.getEncryptionConfigCallable().futureCall(request);
   *   // Do something.
   *   EncryptionConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigCallable() {
    return stub.getEncryptionConfigCallable();
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
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : cmekServiceClient.listLocations(request).iterateAll()) {
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
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       cmekServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = cmekServiceClient.listLocationsCallable().call(request);
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
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = cmekServiceClient.getLocation(request);
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
   * try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = cmekServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListEncryptionConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          EncryptionConfig,
          ListEncryptionConfigsPage,
          ListEncryptionConfigsFixedSizeCollection> {

    public static ApiFuture<ListEncryptionConfigsPagedResponse> createAsync(
        PageContext<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>
            context,
        ApiFuture<ListEncryptionConfigsResponse> futureResponse) {
      ApiFuture<ListEncryptionConfigsPage> futurePage =
          ListEncryptionConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEncryptionConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEncryptionConfigsPagedResponse(ListEncryptionConfigsPage page) {
      super(page, ListEncryptionConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEncryptionConfigsPage
      extends AbstractPage<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          EncryptionConfig,
          ListEncryptionConfigsPage> {

    private ListEncryptionConfigsPage(
        PageContext<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>
            context,
        ListEncryptionConfigsResponse response) {
      super(context, response);
    }

    private static ListEncryptionConfigsPage createEmptyPage() {
      return new ListEncryptionConfigsPage(null, null);
    }

    @Override
    protected ListEncryptionConfigsPage createPage(
        PageContext<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>
            context,
        ListEncryptionConfigsResponse response) {
      return new ListEncryptionConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListEncryptionConfigsPage> createPageAsync(
        PageContext<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse, EncryptionConfig>
            context,
        ApiFuture<ListEncryptionConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEncryptionConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          EncryptionConfig,
          ListEncryptionConfigsPage,
          ListEncryptionConfigsFixedSizeCollection> {

    private ListEncryptionConfigsFixedSizeCollection(
        List<ListEncryptionConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEncryptionConfigsFixedSizeCollection createEmptyCollection() {
      return new ListEncryptionConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEncryptionConfigsFixedSizeCollection createCollection(
        List<ListEncryptionConfigsPage> pages, int collectionSize) {
      return new ListEncryptionConfigsFixedSizeCollection(pages, collectionSize);
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
