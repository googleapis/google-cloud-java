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
import com.google.cloud.discoveryengine.v1.stub.IdentityMappingStoreServiceStub;
import com.google.cloud.discoveryengine.v1.stub.IdentityMappingStoreServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Identity Mapping Stores.
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
 * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
 *     IdentityMappingStoreServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
 *   String identityMappingStoreId = "identityMappingStoreId677904780";
 *   IdentityMappingStore response =
 *       identityMappingStoreServiceClient.createIdentityMappingStore(
 *           parent, identityMappingStore, identityMappingStoreId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IdentityMappingStoreServiceClient object to clean up
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
 *      <td><p> CreateIdentityMappingStore</td>
 *      <td><p> Creates a new Identity Mapping Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIdentityMappingStore(CreateIdentityMappingStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createIdentityMappingStore(LocationName parent, IdentityMappingStore identityMappingStore, String identityMappingStoreId)
 *           <li><p> createIdentityMappingStore(String parent, IdentityMappingStore identityMappingStore, String identityMappingStoreId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIdentityMappingStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIdentityMappingStore</td>
 *      <td><p> Gets the Identity Mapping Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIdentityMappingStore(GetIdentityMappingStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIdentityMappingStore(IdentityMappingStoreName name)
 *           <li><p> getIdentityMappingStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIdentityMappingStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIdentityMappingStore</td>
 *      <td><p> Deletes the Identity Mapping Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIdentityMappingStoreAsync(DeleteIdentityMappingStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIdentityMappingStoreAsync(IdentityMappingStoreName name)
 *           <li><p> deleteIdentityMappingStoreAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIdentityMappingStoreOperationCallable()
 *           <li><p> deleteIdentityMappingStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportIdentityMappings</td>
 *      <td><p> Imports a list of Identity Mapping Entries to an Identity Mapping Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importIdentityMappingsAsync(ImportIdentityMappingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importIdentityMappingsOperationCallable()
 *           <li><p> importIdentityMappingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PurgeIdentityMappings</td>
 *      <td><p> Purges specified or all Identity Mapping Entries from an Identity Mapping Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> purgeIdentityMappingsAsync(PurgeIdentityMappingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> purgeIdentityMappingsOperationCallable()
 *           <li><p> purgeIdentityMappingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIdentityMappings</td>
 *      <td><p> Lists Identity Mappings in an Identity Mapping Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIdentityMappings(ListIdentityMappingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIdentityMappingsPagedCallable()
 *           <li><p> listIdentityMappingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIdentityMappingStores</td>
 *      <td><p> Lists all Identity Mapping Stores.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIdentityMappingStores(ListIdentityMappingStoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIdentityMappingStores(LocationName parent)
 *           <li><p> listIdentityMappingStores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIdentityMappingStoresPagedCallable()
 *           <li><p> listIdentityMappingStoresCallable()
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
 * IdentityMappingStoreServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityMappingStoreServiceSettings identityMappingStoreServiceSettings =
 *     IdentityMappingStoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
 *     IdentityMappingStoreServiceClient.create(identityMappingStoreServiceSettings);
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
 * IdentityMappingStoreServiceSettings identityMappingStoreServiceSettings =
 *     IdentityMappingStoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
 *     IdentityMappingStoreServiceClient.create(identityMappingStoreServiceSettings);
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
 * IdentityMappingStoreServiceSettings identityMappingStoreServiceSettings =
 *     IdentityMappingStoreServiceSettings.newHttpJsonBuilder().build();
 * IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
 *     IdentityMappingStoreServiceClient.create(identityMappingStoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IdentityMappingStoreServiceClient implements BackgroundResource {
  private final IdentityMappingStoreServiceSettings settings;
  private final IdentityMappingStoreServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of IdentityMappingStoreServiceClient with default settings. */
  public static final IdentityMappingStoreServiceClient create() throws IOException {
    return create(IdentityMappingStoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IdentityMappingStoreServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final IdentityMappingStoreServiceClient create(
      IdentityMappingStoreServiceSettings settings) throws IOException {
    return new IdentityMappingStoreServiceClient(settings);
  }

  /**
   * Constructs an instance of IdentityMappingStoreServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(IdentityMappingStoreServiceSettings).
   */
  public static final IdentityMappingStoreServiceClient create(
      IdentityMappingStoreServiceStub stub) {
    return new IdentityMappingStoreServiceClient(stub);
  }

  /**
   * Constructs an instance of IdentityMappingStoreServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IdentityMappingStoreServiceClient(IdentityMappingStoreServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((IdentityMappingStoreServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected IdentityMappingStoreServiceClient(IdentityMappingStoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final IdentityMappingStoreServiceSettings getSettings() {
    return settings;
  }

  public IdentityMappingStoreServiceStub getStub() {
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
   * Creates a new Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
   *   String identityMappingStoreId = "identityMappingStoreId677904780";
   *   IdentityMappingStore response =
   *       identityMappingStoreServiceClient.createIdentityMappingStore(
   *           parent, identityMappingStore, identityMappingStoreId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param identityMappingStore Required. The Identity Mapping Store to create.
   * @param identityMappingStoreId Required. The ID of the Identity Mapping Store to create.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens
   *     (-). The maximum length is 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityMappingStore createIdentityMappingStore(
      LocationName parent,
      IdentityMappingStore identityMappingStore,
      String identityMappingStoreId) {
    CreateIdentityMappingStoreRequest request =
        CreateIdentityMappingStoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIdentityMappingStore(identityMappingStore)
            .setIdentityMappingStoreId(identityMappingStoreId)
            .build();
    return createIdentityMappingStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
   *   String identityMappingStoreId = "identityMappingStoreId677904780";
   *   IdentityMappingStore response =
   *       identityMappingStoreServiceClient.createIdentityMappingStore(
   *           parent, identityMappingStore, identityMappingStoreId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param identityMappingStore Required. The Identity Mapping Store to create.
   * @param identityMappingStoreId Required. The ID of the Identity Mapping Store to create.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens
   *     (-). The maximum length is 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityMappingStore createIdentityMappingStore(
      String parent, IdentityMappingStore identityMappingStore, String identityMappingStoreId) {
    CreateIdentityMappingStoreRequest request =
        CreateIdentityMappingStoreRequest.newBuilder()
            .setParent(parent)
            .setIdentityMappingStore(identityMappingStore)
            .setIdentityMappingStoreId(identityMappingStoreId)
            .build();
    return createIdentityMappingStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   CreateIdentityMappingStoreRequest request =
   *       CreateIdentityMappingStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIdentityMappingStoreId("identityMappingStoreId677904780")
   *           .setIdentityMappingStore(IdentityMappingStore.newBuilder().build())
   *           .build();
   *   IdentityMappingStore response =
   *       identityMappingStoreServiceClient.createIdentityMappingStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityMappingStore createIdentityMappingStore(
      CreateIdentityMappingStoreRequest request) {
    return createIdentityMappingStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   CreateIdentityMappingStoreRequest request =
   *       CreateIdentityMappingStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIdentityMappingStoreId("identityMappingStoreId677904780")
   *           .setIdentityMappingStore(IdentityMappingStore.newBuilder().build())
   *           .build();
   *   ApiFuture<IdentityMappingStore> future =
   *       identityMappingStoreServiceClient
   *           .createIdentityMappingStoreCallable()
   *           .futureCall(request);
   *   // Do something.
   *   IdentityMappingStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreCallable() {
    return stub.createIdentityMappingStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   IdentityMappingStoreName name =
   *       IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");
   *   IdentityMappingStore response =
   *       identityMappingStoreServiceClient.getIdentityMappingStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Identity Mapping Store to get. Format:
   *     `projects/{project}/locations/{location}/identityMappingStores/{identityMappingStore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityMappingStore getIdentityMappingStore(IdentityMappingStoreName name) {
    GetIdentityMappingStoreRequest request =
        GetIdentityMappingStoreRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getIdentityMappingStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   String name =
   *       IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *           .toString();
   *   IdentityMappingStore response =
   *       identityMappingStoreServiceClient.getIdentityMappingStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Identity Mapping Store to get. Format:
   *     `projects/{project}/locations/{location}/identityMappingStores/{identityMappingStore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityMappingStore getIdentityMappingStore(String name) {
    GetIdentityMappingStoreRequest request =
        GetIdentityMappingStoreRequest.newBuilder().setName(name).build();
    return getIdentityMappingStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   GetIdentityMappingStoreRequest request =
   *       GetIdentityMappingStoreRequest.newBuilder()
   *           .setName(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   IdentityMappingStore response =
   *       identityMappingStoreServiceClient.getIdentityMappingStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IdentityMappingStore getIdentityMappingStore(
      GetIdentityMappingStoreRequest request) {
    return getIdentityMappingStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   GetIdentityMappingStoreRequest request =
   *       GetIdentityMappingStoreRequest.newBuilder()
   *           .setName(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<IdentityMappingStore> future =
   *       identityMappingStoreServiceClient.getIdentityMappingStoreCallable().futureCall(request);
   *   // Do something.
   *   IdentityMappingStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreCallable() {
    return stub.getIdentityMappingStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   IdentityMappingStoreName name =
   *       IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");
   *   identityMappingStoreServiceClient.deleteIdentityMappingStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Identity Mapping Store to delete. Format:
   *     `projects/{project}/locations/{location}/identityMappingStores/{identityMappingStore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreAsync(IdentityMappingStoreName name) {
    DeleteIdentityMappingStoreRequest request =
        DeleteIdentityMappingStoreRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteIdentityMappingStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   String name =
   *       IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *           .toString();
   *   identityMappingStoreServiceClient.deleteIdentityMappingStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Identity Mapping Store to delete. Format:
   *     `projects/{project}/locations/{location}/identityMappingStores/{identityMappingStore}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreAsync(String name) {
    DeleteIdentityMappingStoreRequest request =
        DeleteIdentityMappingStoreRequest.newBuilder().setName(name).build();
    return deleteIdentityMappingStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   DeleteIdentityMappingStoreRequest request =
   *       DeleteIdentityMappingStoreRequest.newBuilder()
   *           .setName(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   identityMappingStoreServiceClient.deleteIdentityMappingStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreAsync(DeleteIdentityMappingStoreRequest request) {
    return deleteIdentityMappingStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   DeleteIdentityMappingStoreRequest request =
   *       DeleteIdentityMappingStoreRequest.newBuilder()
   *           .setName(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteIdentityMappingStoreMetadata> future =
   *       identityMappingStoreServiceClient
   *           .deleteIdentityMappingStoreOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationCallable() {
    return stub.deleteIdentityMappingStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   DeleteIdentityMappingStoreRequest request =
   *       DeleteIdentityMappingStoreRequest.newBuilder()
   *           .setName(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       identityMappingStoreServiceClient
   *           .deleteIdentityMappingStoreCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreCallable() {
    return stub.deleteIdentityMappingStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ImportIdentityMappingsRequest request =
   *       ImportIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   ImportIdentityMappingsResponse response =
   *       identityMappingStoreServiceClient.importIdentityMappingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ImportIdentityMappingsResponse, IdentityMappingEntryOperationMetadata>
      importIdentityMappingsAsync(ImportIdentityMappingsRequest request) {
    return importIdentityMappingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ImportIdentityMappingsRequest request =
   *       ImportIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<ImportIdentityMappingsResponse, IdentityMappingEntryOperationMetadata>
   *       future =
   *           identityMappingStoreServiceClient
   *               .importIdentityMappingsOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   ImportIdentityMappingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationCallable() {
    return stub.importIdentityMappingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ImportIdentityMappingsRequest request =
   *       ImportIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       identityMappingStoreServiceClient.importIdentityMappingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsCallable() {
    return stub.importIdentityMappingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges specified or all Identity Mapping Entries from an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   PurgeIdentityMappingsRequest request =
   *       PurgeIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   identityMappingStoreServiceClient.purgeIdentityMappingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsAsync(PurgeIdentityMappingsRequest request) {
    return purgeIdentityMappingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges specified or all Identity Mapping Entries from an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   PurgeIdentityMappingsRequest request =
   *       PurgeIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, IdentityMappingEntryOperationMetadata> future =
   *       identityMappingStoreServiceClient
   *           .purgeIdentityMappingsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationCallable() {
    return stub.purgeIdentityMappingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purges specified or all Identity Mapping Entries from an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   PurgeIdentityMappingsRequest request =
   *       PurgeIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       identityMappingStoreServiceClient.purgeIdentityMappingsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsCallable() {
    return stub.purgeIdentityMappingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Identity Mappings in an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ListIdentityMappingsRequest request =
   *       ListIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (IdentityMappingEntry element :
   *       identityMappingStoreServiceClient.listIdentityMappings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIdentityMappingsPagedResponse listIdentityMappings(
      ListIdentityMappingsRequest request) {
    return listIdentityMappingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Identity Mappings in an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ListIdentityMappingsRequest request =
   *       ListIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<IdentityMappingEntry> future =
   *       identityMappingStoreServiceClient.listIdentityMappingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IdentityMappingEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsPagedResponse>
      listIdentityMappingsPagedCallable() {
    return stub.listIdentityMappingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Identity Mappings in an Identity Mapping Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ListIdentityMappingsRequest request =
   *       ListIdentityMappingsRequest.newBuilder()
   *           .setIdentityMappingStore(
   *               IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIdentityMappingsResponse response =
   *         identityMappingStoreServiceClient.listIdentityMappingsCallable().call(request);
   *     for (IdentityMappingEntry element : response.getIdentityMappingEntriesList()) {
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
  public final UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
      listIdentityMappingsCallable() {
    return stub.listIdentityMappingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Identity Mapping Stores.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (IdentityMappingStore element :
   *       identityMappingStoreServiceClient.listIdentityMappingStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Identity Mapping Stores to list. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIdentityMappingStoresPagedResponse listIdentityMappingStores(
      LocationName parent) {
    ListIdentityMappingStoresRequest request =
        ListIdentityMappingStoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIdentityMappingStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Identity Mapping Stores.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (IdentityMappingStore element :
   *       identityMappingStoreServiceClient.listIdentityMappingStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the Identity Mapping Stores to list. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIdentityMappingStoresPagedResponse listIdentityMappingStores(String parent) {
    ListIdentityMappingStoresRequest request =
        ListIdentityMappingStoresRequest.newBuilder().setParent(parent).build();
    return listIdentityMappingStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Identity Mapping Stores.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ListIdentityMappingStoresRequest request =
   *       ListIdentityMappingStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (IdentityMappingStore element :
   *       identityMappingStoreServiceClient.listIdentityMappingStores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIdentityMappingStoresPagedResponse listIdentityMappingStores(
      ListIdentityMappingStoresRequest request) {
    return listIdentityMappingStoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Identity Mapping Stores.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ListIdentityMappingStoresRequest request =
   *       ListIdentityMappingStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<IdentityMappingStore> future =
   *       identityMappingStoreServiceClient
   *           .listIdentityMappingStoresPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (IdentityMappingStore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListIdentityMappingStoresRequest, ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresPagedCallable() {
    return stub.listIdentityMappingStoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Identity Mapping Stores.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityMappingStoreServiceClient identityMappingStoreServiceClient =
   *     IdentityMappingStoreServiceClient.create()) {
   *   ListIdentityMappingStoresRequest request =
   *       ListIdentityMappingStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIdentityMappingStoresResponse response =
   *         identityMappingStoreServiceClient.listIdentityMappingStoresCallable().call(request);
   *     for (IdentityMappingStore element : response.getIdentityMappingStoresList()) {
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
  public final UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
      listIdentityMappingStoresCallable() {
    return stub.listIdentityMappingStoresCallable();
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

  public static class ListIdentityMappingsPagedResponse
      extends AbstractPagedListResponse<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          IdentityMappingEntry,
          ListIdentityMappingsPage,
          ListIdentityMappingsFixedSizeCollection> {

    public static ApiFuture<ListIdentityMappingsPagedResponse> createAsync(
        PageContext<ListIdentityMappingsRequest, ListIdentityMappingsResponse, IdentityMappingEntry>
            context,
        ApiFuture<ListIdentityMappingsResponse> futureResponse) {
      ApiFuture<ListIdentityMappingsPage> futurePage =
          ListIdentityMappingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIdentityMappingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIdentityMappingsPagedResponse(ListIdentityMappingsPage page) {
      super(page, ListIdentityMappingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIdentityMappingsPage
      extends AbstractPage<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          IdentityMappingEntry,
          ListIdentityMappingsPage> {

    private ListIdentityMappingsPage(
        PageContext<ListIdentityMappingsRequest, ListIdentityMappingsResponse, IdentityMappingEntry>
            context,
        ListIdentityMappingsResponse response) {
      super(context, response);
    }

    private static ListIdentityMappingsPage createEmptyPage() {
      return new ListIdentityMappingsPage(null, null);
    }

    @Override
    protected ListIdentityMappingsPage createPage(
        PageContext<ListIdentityMappingsRequest, ListIdentityMappingsResponse, IdentityMappingEntry>
            context,
        ListIdentityMappingsResponse response) {
      return new ListIdentityMappingsPage(context, response);
    }

    @Override
    public ApiFuture<ListIdentityMappingsPage> createPageAsync(
        PageContext<ListIdentityMappingsRequest, ListIdentityMappingsResponse, IdentityMappingEntry>
            context,
        ApiFuture<ListIdentityMappingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIdentityMappingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          IdentityMappingEntry,
          ListIdentityMappingsPage,
          ListIdentityMappingsFixedSizeCollection> {

    private ListIdentityMappingsFixedSizeCollection(
        List<ListIdentityMappingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIdentityMappingsFixedSizeCollection createEmptyCollection() {
      return new ListIdentityMappingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIdentityMappingsFixedSizeCollection createCollection(
        List<ListIdentityMappingsPage> pages, int collectionSize) {
      return new ListIdentityMappingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIdentityMappingStoresPagedResponse
      extends AbstractPagedListResponse<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          IdentityMappingStore,
          ListIdentityMappingStoresPage,
          ListIdentityMappingStoresFixedSizeCollection> {

    public static ApiFuture<ListIdentityMappingStoresPagedResponse> createAsync(
        PageContext<
                ListIdentityMappingStoresRequest,
                ListIdentityMappingStoresResponse,
                IdentityMappingStore>
            context,
        ApiFuture<ListIdentityMappingStoresResponse> futureResponse) {
      ApiFuture<ListIdentityMappingStoresPage> futurePage =
          ListIdentityMappingStoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIdentityMappingStoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIdentityMappingStoresPagedResponse(ListIdentityMappingStoresPage page) {
      super(page, ListIdentityMappingStoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIdentityMappingStoresPage
      extends AbstractPage<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          IdentityMappingStore,
          ListIdentityMappingStoresPage> {

    private ListIdentityMappingStoresPage(
        PageContext<
                ListIdentityMappingStoresRequest,
                ListIdentityMappingStoresResponse,
                IdentityMappingStore>
            context,
        ListIdentityMappingStoresResponse response) {
      super(context, response);
    }

    private static ListIdentityMappingStoresPage createEmptyPage() {
      return new ListIdentityMappingStoresPage(null, null);
    }

    @Override
    protected ListIdentityMappingStoresPage createPage(
        PageContext<
                ListIdentityMappingStoresRequest,
                ListIdentityMappingStoresResponse,
                IdentityMappingStore>
            context,
        ListIdentityMappingStoresResponse response) {
      return new ListIdentityMappingStoresPage(context, response);
    }

    @Override
    public ApiFuture<ListIdentityMappingStoresPage> createPageAsync(
        PageContext<
                ListIdentityMappingStoresRequest,
                ListIdentityMappingStoresResponse,
                IdentityMappingStore>
            context,
        ApiFuture<ListIdentityMappingStoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIdentityMappingStoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          IdentityMappingStore,
          ListIdentityMappingStoresPage,
          ListIdentityMappingStoresFixedSizeCollection> {

    private ListIdentityMappingStoresFixedSizeCollection(
        List<ListIdentityMappingStoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIdentityMappingStoresFixedSizeCollection createEmptyCollection() {
      return new ListIdentityMappingStoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIdentityMappingStoresFixedSizeCollection createCollection(
        List<ListIdentityMappingStoresPage> pages, int collectionSize) {
      return new ListIdentityMappingStoresFixedSizeCollection(pages, collectionSize);
    }
  }
}
