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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.DataConnectorServiceStub;
import com.google.cloud.discoveryengine.v1.stub.DataConnectorServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for data connector management.
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
 * try (DataConnectorServiceClient dataConnectorServiceClient =
 *     DataConnectorServiceClient.create()) {
 *   DataConnectorName name = DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
 *   DataConnector response = dataConnectorServiceClient.getDataConnector(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataConnectorServiceClient object to clean up
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
 *      <td><p> SetUpDataConnector</td>
 *      <td><p> Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets up the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for it. To stop a [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup, use the [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection] method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setUpDataConnectorAsync(SetUpDataConnectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setUpDataConnectorAsync(LocationName parent, String collectionId, String collectionDisplayName, DataConnector dataConnector)
 *           <li><p> setUpDataConnectorAsync(String parent, String collectionId, String collectionDisplayName, DataConnector dataConnector)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setUpDataConnectorOperationCallable()
 *           <li><p> setUpDataConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataConnector</td>
 *      <td><p> Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector]. [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource for each [Collection][google.cloud.discoveryengine.v1.Collection].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataConnector(GetDataConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataConnector(DataConnectorName name)
 *           <li><p> getDataConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataConnector</td>
 *      <td><p> Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataConnector(UpdateDataConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataConnector(DataConnector dataConnector, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataConnectorCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataConnectorServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataConnectorServiceSettings dataConnectorServiceSettings =
 *     DataConnectorServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataConnectorServiceClient dataConnectorServiceClient =
 *     DataConnectorServiceClient.create(dataConnectorServiceSettings);
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
 * DataConnectorServiceSettings dataConnectorServiceSettings =
 *     DataConnectorServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataConnectorServiceClient dataConnectorServiceClient =
 *     DataConnectorServiceClient.create(dataConnectorServiceSettings);
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
 * DataConnectorServiceSettings dataConnectorServiceSettings =
 *     DataConnectorServiceSettings.newHttpJsonBuilder().build();
 * DataConnectorServiceClient dataConnectorServiceClient =
 *     DataConnectorServiceClient.create(dataConnectorServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DataConnectorServiceClient implements BackgroundResource {
  private final @Nullable DataConnectorServiceSettings settings;
  private final DataConnectorServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataConnectorServiceClient with default settings. */
  public static final DataConnectorServiceClient create() throws IOException {
    return create(DataConnectorServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataConnectorServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataConnectorServiceClient create(DataConnectorServiceSettings settings)
      throws IOException {
    return new DataConnectorServiceClient(settings);
  }

  /**
   * Constructs an instance of DataConnectorServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DataConnectorServiceSettings).
   */
  public static final DataConnectorServiceClient create(DataConnectorServiceStub stub) {
    return new DataConnectorServiceClient(stub);
  }

  /**
   * Constructs an instance of DataConnectorServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataConnectorServiceClient(DataConnectorServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataConnectorServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataConnectorServiceClient(DataConnectorServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable DataConnectorServiceSettings getSettings() {
    return settings;
  }

  public DataConnectorServiceStub getStub() {
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
   * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets up the
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for it. To stop a
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup, use the
   * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
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
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String collectionId = "collectionId1636075609";
   *   String collectionDisplayName = "collectionDisplayName-330620689";
   *   DataConnector dataConnector = DataConnector.newBuilder().build();
   *   DataConnector response =
   *       dataConnectorServiceClient
   *           .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of [Collection][google.cloud.discoveryengine.v1.Collection],
   *     in the format of `projects/{project}/locations/{location}`.
   * @param collectionId Required. The ID to use for the
   *     [Collection][google.cloud.discoveryengine.v1.Collection], which will become the final
   *     component of the [Collection][google.cloud.discoveryengine.v1.Collection]'s resource name.
   *     A new [Collection][google.cloud.discoveryengine.v1.Collection] is created as part of the
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] setup.
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource
   *     under [Collection][google.cloud.discoveryengine.v1.Collection], managing all
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore]s of the
   *     [Collection][google.cloud.discoveryengine.v1.Collection].
   *     <p>Should conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length
   *     limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @param collectionDisplayName Required. The display name of the
   *     [Collection][google.cloud.discoveryengine.v1.Collection].
   *     <p>Should be human readable, used to display collections in the Console Dashboard. UTF-8
   *     encoded string with limit of 1024 characters.
   * @param dataConnector Required. The
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] to initialize in the newly
   *     created [Collection][google.cloud.discoveryengine.v1.Collection].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataConnector, SetUpDataConnectorMetadata> setUpDataConnectorAsync(
      @Nullable LocationName parent,
      String collectionId,
      String collectionDisplayName,
      DataConnector dataConnector) {
    SetUpDataConnectorRequest request =
        SetUpDataConnectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCollectionId(collectionId)
            .setCollectionDisplayName(collectionDisplayName)
            .setDataConnector(dataConnector)
            .build();
    return setUpDataConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets up the
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for it. To stop a
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup, use the
   * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
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
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String collectionId = "collectionId1636075609";
   *   String collectionDisplayName = "collectionDisplayName-330620689";
   *   DataConnector dataConnector = DataConnector.newBuilder().build();
   *   DataConnector response =
   *       dataConnectorServiceClient
   *           .setUpDataConnectorAsync(parent, collectionId, collectionDisplayName, dataConnector)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent of [Collection][google.cloud.discoveryengine.v1.Collection],
   *     in the format of `projects/{project}/locations/{location}`.
   * @param collectionId Required. The ID to use for the
   *     [Collection][google.cloud.discoveryengine.v1.Collection], which will become the final
   *     component of the [Collection][google.cloud.discoveryengine.v1.Collection]'s resource name.
   *     A new [Collection][google.cloud.discoveryengine.v1.Collection] is created as part of the
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] setup.
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource
   *     under [Collection][google.cloud.discoveryengine.v1.Collection], managing all
   *     [DataStore][google.cloud.discoveryengine.v1.DataStore]s of the
   *     [Collection][google.cloud.discoveryengine.v1.Collection].
   *     <p>Should conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length
   *     limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @param collectionDisplayName Required. The display name of the
   *     [Collection][google.cloud.discoveryengine.v1.Collection].
   *     <p>Should be human readable, used to display collections in the Console Dashboard. UTF-8
   *     encoded string with limit of 1024 characters.
   * @param dataConnector Required. The
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] to initialize in the newly
   *     created [Collection][google.cloud.discoveryengine.v1.Collection].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataConnector, SetUpDataConnectorMetadata> setUpDataConnectorAsync(
      String parent,
      String collectionId,
      String collectionDisplayName,
      DataConnector dataConnector) {
    SetUpDataConnectorRequest request =
        SetUpDataConnectorRequest.newBuilder()
            .setParent(parent)
            .setCollectionId(collectionId)
            .setCollectionDisplayName(collectionDisplayName)
            .setDataConnector(dataConnector)
            .build();
    return setUpDataConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets up the
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for it. To stop a
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup, use the
   * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
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
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   SetUpDataConnectorRequest request =
   *       SetUpDataConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCollectionId("collectionId1636075609")
   *           .setCollectionDisplayName("collectionDisplayName-330620689")
   *           .setDataConnector(DataConnector.newBuilder().build())
   *           .build();
   *   DataConnector response = dataConnectorServiceClient.setUpDataConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataConnector, SetUpDataConnectorMetadata> setUpDataConnectorAsync(
      SetUpDataConnectorRequest request) {
    return setUpDataConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets up the
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for it. To stop a
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup, use the
   * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
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
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   SetUpDataConnectorRequest request =
   *       SetUpDataConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCollectionId("collectionId1636075609")
   *           .setCollectionDisplayName("collectionDisplayName-330620689")
   *           .setDataConnector(DataConnector.newBuilder().build())
   *           .build();
   *   OperationFuture<DataConnector, SetUpDataConnectorMetadata> future =
   *       dataConnectorServiceClient.setUpDataConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   DataConnector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SetUpDataConnectorRequest, DataConnector, SetUpDataConnectorMetadata>
      setUpDataConnectorOperationCallable() {
    return stub.setUpDataConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Collection][google.cloud.discoveryengine.v1.Collection] and sets up the
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] for it. To stop a
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] after setup, use the
   * [CollectionService.DeleteCollection][google.cloud.discoveryengine.v1.CollectionService.DeleteCollection]
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
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   SetUpDataConnectorRequest request =
   *       SetUpDataConnectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCollectionId("collectionId1636075609")
   *           .setCollectionDisplayName("collectionDisplayName-330620689")
   *           .setDataConnector(DataConnector.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataConnectorServiceClient.setUpDataConnectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetUpDataConnectorRequest, Operation> setUpDataConnectorCallable() {
    return stub.setUpDataConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource for each
   * [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   DataConnectorName name = DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   DataConnector response = dataConnectorServiceClient.getDataConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataConnector`.
   *     <p>If the caller does not have permission to access the
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the requested [DataConnector][google.cloud.discoveryengine.v1.DataConnector] does not
   *     exist, a `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataConnector getDataConnector(@Nullable DataConnectorName name) {
    GetDataConnectorRequest request =
        GetDataConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource for each
   * [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   String name = DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   DataConnector response = dataConnectorServiceClient.getDataConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataConnector`.
   *     <p>If the caller does not have permission to access the
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the requested [DataConnector][google.cloud.discoveryengine.v1.DataConnector] does not
   *     exist, a `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataConnector getDataConnector(String name) {
    GetDataConnectorRequest request = GetDataConnectorRequest.newBuilder().setName(name).build();
    return getDataConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource for each
   * [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   GetDataConnectorRequest request =
   *       GetDataConnectorRequest.newBuilder()
   *           .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .build();
   *   DataConnector response = dataConnectorServiceClient.getDataConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataConnector getDataConnector(GetDataConnectorRequest request) {
    return getDataConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   * [DataConnector][google.cloud.discoveryengine.v1.DataConnector] is a singleton resource for each
   * [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   GetDataConnectorRequest request =
   *       GetDataConnectorRequest.newBuilder()
   *           .setName(DataConnectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .build();
   *   ApiFuture<DataConnector> future =
   *       dataConnectorServiceClient.getDataConnectorCallable().futureCall(request);
   *   // Do something.
   *   DataConnector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataConnectorRequest, DataConnector> getDataConnectorCallable() {
    return stub.getDataConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   DataConnector dataConnector = DataConnector.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataConnector response =
   *       dataConnectorServiceClient.updateDataConnector(dataConnector, updateMask);
   * }
   * }</pre>
   *
   * @param dataConnector Required. The
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] to update.
   *     <p>If the caller does not have permission to update the
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector], regardless of whether or
   *     not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [DataConnector][google.cloud.discoveryengine.v1.DataConnector] does not exist, a
   *     `NOT_FOUND` error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [DataConnector][google.cloud.discoveryengine.v1.DataConnector] to update.
   *     <p>Supported field paths include:
   *     <p>- `refresh_interval` - `params` - `auto_run_disabled` - `action_config` -
   *     `action_config.action_params` - `action_config.service_name` - `destination_configs` -
   *     `blocking_reasons` - `sync_mode` - `incremental_sync_disabled` -
   *     `incremental_refresh_interval` - `data_protection_policy`
   *     <p>Note: Support for these fields may vary depending on the connector type. For example,
   *     not all connectors support `destination_configs`.
   *     <p>If an unsupported or unknown field path is provided, the request will return an
   *     `INVALID_ARGUMENT` error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataConnector updateDataConnector(
      DataConnector dataConnector, FieldMask updateMask) {
    UpdateDataConnectorRequest request =
        UpdateDataConnectorRequest.newBuilder()
            .setDataConnector(dataConnector)
            .setUpdateMask(updateMask)
            .build();
    return updateDataConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   UpdateDataConnectorRequest request =
   *       UpdateDataConnectorRequest.newBuilder()
   *           .setDataConnector(DataConnector.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataConnector response = dataConnectorServiceClient.updateDataConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataConnector updateDataConnector(UpdateDataConnectorRequest request) {
    return updateDataConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [DataConnector][google.cloud.discoveryengine.v1.DataConnector].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataConnectorServiceClient dataConnectorServiceClient =
   *     DataConnectorServiceClient.create()) {
   *   UpdateDataConnectorRequest request =
   *       UpdateDataConnectorRequest.newBuilder()
   *           .setDataConnector(DataConnector.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataConnector> future =
   *       dataConnectorServiceClient.updateDataConnectorCallable().futureCall(request);
   *   // Do something.
   *   DataConnector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataConnectorRequest, DataConnector>
      updateDataConnectorCallable() {
    return stub.updateDataConnectorCallable();
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
