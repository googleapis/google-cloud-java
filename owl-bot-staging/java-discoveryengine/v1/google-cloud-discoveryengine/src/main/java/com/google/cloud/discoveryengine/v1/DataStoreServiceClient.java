/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.discoveryengine.v1.stub.DataStoreServiceStub;
import com.google.cloud.discoveryengine.v1.stub.DataStoreServiceStubSettings;
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
 * Service Description: Service for managing [DataStore][google.cloud.discoveryengine.v1.DataStore]
 * configuration.
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
 * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
 *   DataStoreName name =
 *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
 *   DataStore response = dataStoreServiceClient.getDataStore(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataStoreServiceClient object to clean up resources
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
 *      <td><p> CreateDataStore</td>
 *      <td><p> Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
 * <p>  DataStore is for storing [Documents][google.cloud.discoveryengine.v1.Document]. To serve these documents for Search, or Recommendation use case, an [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created separately.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataStoreAsync(CreateDataStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDataStoreAsync(CollectionName parent, DataStore dataStore, String dataStoreId)
 *           <li><p> createDataStoreAsync(String parent, DataStore dataStore, String dataStoreId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataStoreOperationCallable()
 *           <li><p> createDataStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataStore</td>
 *      <td><p> Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataStore(GetDataStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataStore(DataStoreName name)
 *           <li><p> getDataStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataStores</td>
 *      <td><p> Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s associated with the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataStores(ListDataStoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataStores(CollectionName parent)
 *           <li><p> listDataStores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataStoresPagedCallable()
 *           <li><p> listDataStoresCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataStore</td>
 *      <td><p> Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataStoreAsync(DeleteDataStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDataStoreAsync(DataStoreName name)
 *           <li><p> deleteDataStoreAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataStoreOperationCallable()
 *           <li><p> deleteDataStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataStore</td>
 *      <td><p> Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataStore(UpdateDataStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataStore(DataStore dataStore, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataStoreCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataStoreServiceSettings to
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
 * DataStoreServiceSettings dataStoreServiceSettings =
 *     DataStoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataStoreServiceClient dataStoreServiceClient =
 *     DataStoreServiceClient.create(dataStoreServiceSettings);
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
 * DataStoreServiceSettings dataStoreServiceSettings =
 *     DataStoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataStoreServiceClient dataStoreServiceClient =
 *     DataStoreServiceClient.create(dataStoreServiceSettings);
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
 * DataStoreServiceSettings dataStoreServiceSettings =
 *     DataStoreServiceSettings.newHttpJsonBuilder().build();
 * DataStoreServiceClient dataStoreServiceClient =
 *     DataStoreServiceClient.create(dataStoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataStoreServiceClient implements BackgroundResource {
  private final DataStoreServiceSettings settings;
  private final DataStoreServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataStoreServiceClient with default settings. */
  public static final DataStoreServiceClient create() throws IOException {
    return create(DataStoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataStoreServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataStoreServiceClient create(DataStoreServiceSettings settings)
      throws IOException {
    return new DataStoreServiceClient(settings);
  }

  /**
   * Constructs an instance of DataStoreServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataStoreServiceSettings).
   */
  public static final DataStoreServiceClient create(DataStoreServiceStub stub) {
    return new DataStoreServiceClient(stub);
  }

  /**
   * Constructs an instance of DataStoreServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataStoreServiceClient(DataStoreServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataStoreServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataStoreServiceClient(DataStoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataStoreServiceSettings getSettings() {
    return settings;
  }

  public DataStoreServiceStub getStub() {
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
   * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>DataStore is for storing [Documents][google.cloud.discoveryengine.v1.Document]. To serve
   * these documents for Search, or Recommendation use case, an
   * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created separately.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   DataStore dataStore = DataStore.newBuilder().build();
   *   String dataStoreId = "dataStoreId929489618";
   *   DataStore response =
   *       dataStoreServiceClient.createDataStoreAsync(parent, dataStore, dataStoreId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}`.
   * @param dataStore Required. The [DataStore][google.cloud.discoveryengine.v1.DataStore] to
   *     create.
   * @param dataStoreId Required. The ID to use for the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], which will become the final
   *     component of the [DataStore][google.cloud.discoveryengine.v1.DataStore]'s resource name.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataStore, CreateDataStoreMetadata> createDataStoreAsync(
      CollectionName parent, DataStore dataStore, String dataStoreId) {
    CreateDataStoreRequest request =
        CreateDataStoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataStore(dataStore)
            .setDataStoreId(dataStoreId)
            .build();
    return createDataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>DataStore is for storing [Documents][google.cloud.discoveryengine.v1.Document]. To serve
   * these documents for Search, or Recommendation use case, an
   * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created separately.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   DataStore dataStore = DataStore.newBuilder().build();
   *   String dataStoreId = "dataStoreId929489618";
   *   DataStore response =
   *       dataStoreServiceClient.createDataStoreAsync(parent, dataStore, dataStoreId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}`.
   * @param dataStore Required. The [DataStore][google.cloud.discoveryengine.v1.DataStore] to
   *     create.
   * @param dataStoreId Required. The ID to use for the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], which will become the final
   *     component of the [DataStore][google.cloud.discoveryengine.v1.DataStore]'s resource name.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataStore, CreateDataStoreMetadata> createDataStoreAsync(
      String parent, DataStore dataStore, String dataStoreId) {
    CreateDataStoreRequest request =
        CreateDataStoreRequest.newBuilder()
            .setParent(parent)
            .setDataStore(dataStore)
            .setDataStoreId(dataStoreId)
            .build();
    return createDataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>DataStore is for storing [Documents][google.cloud.discoveryengine.v1.Document]. To serve
   * these documents for Search, or Recommendation use case, an
   * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created separately.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   CreateDataStoreRequest request =
   *       CreateDataStoreRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setDataStore(DataStore.newBuilder().build())
   *           .setDataStoreId("dataStoreId929489618")
   *           .setCreateAdvancedSiteSearch(true)
   *           .build();
   *   DataStore response = dataStoreServiceClient.createDataStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataStore, CreateDataStoreMetadata> createDataStoreAsync(
      CreateDataStoreRequest request) {
    return createDataStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>DataStore is for storing [Documents][google.cloud.discoveryengine.v1.Document]. To serve
   * these documents for Search, or Recommendation use case, an
   * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created separately.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   CreateDataStoreRequest request =
   *       CreateDataStoreRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setDataStore(DataStore.newBuilder().build())
   *           .setDataStoreId("dataStoreId929489618")
   *           .setCreateAdvancedSiteSearch(true)
   *           .build();
   *   OperationFuture<DataStore, CreateDataStoreMetadata> future =
   *       dataStoreServiceClient.createDataStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   DataStore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationCallable() {
    return stub.createDataStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>DataStore is for storing [Documents][google.cloud.discoveryengine.v1.Document]. To serve
   * these documents for Search, or Recommendation use case, an
   * [Engine][google.cloud.discoveryengine.v1.Engine] needs to be created separately.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   CreateDataStoreRequest request =
   *       CreateDataStoreRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setDataStore(DataStore.newBuilder().build())
   *           .setDataStoreId("dataStoreId929489618")
   *           .setCreateAdvancedSiteSearch(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataStoreServiceClient.createDataStoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataStoreRequest, Operation> createDataStoreCallable() {
    return stub.createDataStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   DataStoreName name =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   DataStore response = dataStoreServiceClient.getDataStore(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`.
   *     <p>If the caller does not have permission to access the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [DataStore][google.cloud.discoveryengine.v1.DataStore] does not exist,
   *     a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStore getDataStore(DataStoreName name) {
    GetDataStoreRequest request =
        GetDataStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   String name =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   DataStore response = dataStoreServiceClient.getDataStore(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`.
   *     <p>If the caller does not have permission to access the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [DataStore][google.cloud.discoveryengine.v1.DataStore] does not exist,
   *     a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStore getDataStore(String name) {
    GetDataStoreRequest request = GetDataStoreRequest.newBuilder().setName(name).build();
    return getDataStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   GetDataStoreRequest request =
   *       GetDataStoreRequest.newBuilder()
   *           .setName(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   DataStore response = dataStoreServiceClient.getDataStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStore getDataStore(GetDataStoreRequest request) {
    return getDataStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   GetDataStoreRequest request =
   *       GetDataStoreRequest.newBuilder()
   *           .setName(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataStore> future =
   *       dataStoreServiceClient.getDataStoreCallable().futureCall(request);
   *   // Do something.
   *   DataStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataStoreRequest, DataStore> getDataStoreCallable() {
    return stub.getDataStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   for (DataStore element : dataStoreServiceClient.listDataStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}`.
   *     <p>If the caller does not have permission to list
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore]s under this location, regardless of
   *     whether or not this data store exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataStoresPagedResponse listDataStores(CollectionName parent) {
    ListDataStoresRequest request =
        ListDataStoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   for (DataStore element : dataStoreServiceClient.listDataStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}`.
   *     <p>If the caller does not have permission to list
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore]s under this location, regardless of
   *     whether or not this data store exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataStoresPagedResponse listDataStores(String parent) {
    ListDataStoresRequest request = ListDataStoresRequest.newBuilder().setParent(parent).build();
    return listDataStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   ListDataStoresRequest request =
   *       ListDataStoresRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DataStore element : dataStoreServiceClient.listDataStores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataStoresPagedResponse listDataStores(ListDataStoresRequest request) {
    return listDataStoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   ListDataStoresRequest request =
   *       ListDataStoresRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DataStore> future =
   *       dataStoreServiceClient.listDataStoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataStore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataStoresRequest, ListDataStoresPagedResponse>
      listDataStoresPagedCallable() {
    return stub.listDataStoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [DataStore][google.cloud.discoveryengine.v1.DataStore]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   ListDataStoresRequest request =
   *       ListDataStoresRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDataStoresResponse response =
   *         dataStoreServiceClient.listDataStoresCallable().call(request);
   *     for (DataStore element : response.getDataStoresList()) {
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
  public final UnaryCallable<ListDataStoresRequest, ListDataStoresResponse>
      listDataStoresCallable() {
    return stub.listDataStoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   DataStoreName name =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   dataStoreServiceClient.deleteDataStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`.
   *     <p>If the caller does not have permission to delete the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [DataStore][google.cloud.discoveryengine.v1.DataStore] to delete does not exist,
   *     a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteDataStoreMetadata> deleteDataStoreAsync(
      DataStoreName name) {
    DeleteDataStoreRequest request =
        DeleteDataStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   String name =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   dataStoreServiceClient.deleteDataStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`.
   *     <p>If the caller does not have permission to delete the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [DataStore][google.cloud.discoveryengine.v1.DataStore] to delete does not exist,
   *     a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteDataStoreMetadata> deleteDataStoreAsync(String name) {
    DeleteDataStoreRequest request = DeleteDataStoreRequest.newBuilder().setName(name).build();
    return deleteDataStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   DeleteDataStoreRequest request =
   *       DeleteDataStoreRequest.newBuilder()
   *           .setName(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   dataStoreServiceClient.deleteDataStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteDataStoreMetadata> deleteDataStoreAsync(
      DeleteDataStoreRequest request) {
    return deleteDataStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   DeleteDataStoreRequest request =
   *       DeleteDataStoreRequest.newBuilder()
   *           .setName(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteDataStoreMetadata> future =
   *       dataStoreServiceClient.deleteDataStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationCallable() {
    return stub.deleteDataStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [DataStore][google.cloud.discoveryengine.v1.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   DeleteDataStoreRequest request =
   *       DeleteDataStoreRequest.newBuilder()
   *           .setName(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataStoreServiceClient.deleteDataStoreCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataStoreRequest, Operation> deleteDataStoreCallable() {
    return stub.deleteDataStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   DataStore dataStore = DataStore.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataStore response = dataStoreServiceClient.updateDataStore(dataStore, updateMask);
   * }
   * }</pre>
   *
   * @param dataStore Required. The [DataStore][google.cloud.discoveryengine.v1.DataStore] to
   *     update.
   *     <p>If the caller does not have permission to update the
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [DataStore][google.cloud.discoveryengine.v1.DataStore] to update does not exist,
   *     a NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore] to update.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStore updateDataStore(DataStore dataStore, FieldMask updateMask) {
    UpdateDataStoreRequest request =
        UpdateDataStoreRequest.newBuilder()
            .setDataStore(dataStore)
            .setUpdateMask(updateMask)
            .build();
    return updateDataStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   UpdateDataStoreRequest request =
   *       UpdateDataStoreRequest.newBuilder()
   *           .setDataStore(DataStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataStore response = dataStoreServiceClient.updateDataStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataStore updateDataStore(UpdateDataStoreRequest request) {
    return updateDataStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [DataStore][google.cloud.discoveryengine.v1.DataStore]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataStoreServiceClient dataStoreServiceClient = DataStoreServiceClient.create()) {
   *   UpdateDataStoreRequest request =
   *       UpdateDataStoreRequest.newBuilder()
   *           .setDataStore(DataStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataStore> future =
   *       dataStoreServiceClient.updateDataStoreCallable().futureCall(request);
   *   // Do something.
   *   DataStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataStoreRequest, DataStore> updateDataStoreCallable() {
    return stub.updateDataStoreCallable();
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

  public static class ListDataStoresPagedResponse
      extends AbstractPagedListResponse<
          ListDataStoresRequest,
          ListDataStoresResponse,
          DataStore,
          ListDataStoresPage,
          ListDataStoresFixedSizeCollection> {

    public static ApiFuture<ListDataStoresPagedResponse> createAsync(
        PageContext<ListDataStoresRequest, ListDataStoresResponse, DataStore> context,
        ApiFuture<ListDataStoresResponse> futureResponse) {
      ApiFuture<ListDataStoresPage> futurePage =
          ListDataStoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataStoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataStoresPagedResponse(ListDataStoresPage page) {
      super(page, ListDataStoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataStoresPage
      extends AbstractPage<
          ListDataStoresRequest, ListDataStoresResponse, DataStore, ListDataStoresPage> {

    private ListDataStoresPage(
        PageContext<ListDataStoresRequest, ListDataStoresResponse, DataStore> context,
        ListDataStoresResponse response) {
      super(context, response);
    }

    private static ListDataStoresPage createEmptyPage() {
      return new ListDataStoresPage(null, null);
    }

    @Override
    protected ListDataStoresPage createPage(
        PageContext<ListDataStoresRequest, ListDataStoresResponse, DataStore> context,
        ListDataStoresResponse response) {
      return new ListDataStoresPage(context, response);
    }

    @Override
    public ApiFuture<ListDataStoresPage> createPageAsync(
        PageContext<ListDataStoresRequest, ListDataStoresResponse, DataStore> context,
        ApiFuture<ListDataStoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataStoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataStoresRequest,
          ListDataStoresResponse,
          DataStore,
          ListDataStoresPage,
          ListDataStoresFixedSizeCollection> {

    private ListDataStoresFixedSizeCollection(List<ListDataStoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataStoresFixedSizeCollection createEmptyCollection() {
      return new ListDataStoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataStoresFixedSizeCollection createCollection(
        List<ListDataStoresPage> pages, int collectionSize) {
      return new ListDataStoresFixedSizeCollection(pages, collectionSize);
    }
  }
}
