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

package com.google.cloud.datastore.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datastore.v1.stub.DatastoreStub;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.Key;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.Mutation;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Each RPC normalizes the partition IDs of the keys in its input entities, and
 * always returns entities with keys with normalized partition IDs. This applies to all keys and
 * entities, including those in values, except keys with both an empty path and an empty or unset
 * partition ID. Normalization of input keys sets the project ID (if not already set) to the project
 * ID from the request.
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
 * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
 *   String projectId = "projectId-894832108";
 *   ReadOptions readOptions = ReadOptions.newBuilder().build();
 *   List<Key> keys = new ArrayList<>();
 *   LookupResponse response = datastoreClient.lookup(projectId, readOptions, keys);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DatastoreClient object to clean up resources such as
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
 *      <td><p> Lookup</td>
 *      <td><p> Looks up entities by key.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookup(LookupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> lookup(String projectId, ReadOptions readOptions, List&lt;Key&gt; keys)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunQuery</td>
 *      <td><p> Queries for entities.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runQuery(RunQueryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunAggregationQuery</td>
 *      <td><p> Runs an aggregation query.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runAggregationQuery(RunAggregationQueryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runAggregationQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BeginTransaction</td>
 *      <td><p> Begins a new transaction.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> beginTransaction(BeginTransactionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> beginTransaction(String projectId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> beginTransactionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Commit</td>
 *      <td><p> Commits a transaction, optionally creating, deleting or modifying some entities.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> commit(CommitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> commit(String projectId, CommitRequest.Mode mode, List&lt;Mutation&gt; mutations)
 *           <li><p> commit(String projectId, CommitRequest.Mode mode, ByteString transaction, List&lt;Mutation&gt; mutations)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> commitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Rollback</td>
 *      <td><p> Rolls back a transaction.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollback(RollbackRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rollback(String projectId, ByteString transaction)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollbackCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AllocateIds</td>
 *      <td><p> Allocates IDs for the given keys, which is useful for referencing an entity before it is inserted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> allocateIds(AllocateIdsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> allocateIds(String projectId, List&lt;Key&gt; keys)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> allocateIdsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReserveIds</td>
 *      <td><p> Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reserveIds(ReserveIdsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> reserveIds(String projectId, List&lt;Key&gt; keys)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reserveIdsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DatastoreSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatastoreSettings datastoreSettings =
 *     DatastoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatastoreClient datastoreClient = DatastoreClient.create(datastoreSettings);
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
 * DatastoreSettings datastoreSettings =
 *     DatastoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatastoreClient datastoreClient = DatastoreClient.create(datastoreSettings);
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
 * DatastoreSettings datastoreSettings = DatastoreSettings.newHttpJsonBuilder().build();
 * DatastoreClient datastoreClient = DatastoreClient.create(datastoreSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DatastoreClient implements BackgroundResource {
  private final DatastoreSettings settings;
  private final DatastoreStub stub;

  /** Constructs an instance of DatastoreClient with default settings. */
  public static final DatastoreClient create() throws IOException {
    return create(DatastoreSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatastoreClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatastoreClient create(DatastoreSettings settings) throws IOException {
    return new DatastoreClient(settings);
  }

  /**
   * Constructs an instance of DatastoreClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DatastoreSettings).
   */
  public static final DatastoreClient create(DatastoreStub stub) {
    return new DatastoreClient(stub);
  }

  /**
   * Constructs an instance of DatastoreClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DatastoreClient(DatastoreSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatastoreStubSettings) settings.getStubSettings()).createStub();
  }

  protected DatastoreClient(DatastoreStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DatastoreSettings getSettings() {
    return settings;
  }

  public DatastoreStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up entities by key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   ReadOptions readOptions = ReadOptions.newBuilder().build();
   *   List<Key> keys = new ArrayList<>();
   *   LookupResponse response = datastoreClient.lookup(projectId, readOptions, keys);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @param readOptions The options for this lookup request.
   * @param keys Required. Keys of entities to look up.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupResponse lookup(String projectId, ReadOptions readOptions, List<Key> keys) {
    LookupRequest request =
        LookupRequest.newBuilder()
            .setProjectId(projectId)
            .setReadOptions(readOptions)
            .addAllKeys(keys)
            .build();
    return lookup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up entities by key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   LookupRequest request =
   *       LookupRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setReadOptions(ReadOptions.newBuilder().build())
   *           .addAllKeys(new ArrayList<Key>())
   *           .setPropertyMask(PropertyMask.newBuilder().build())
   *           .build();
   *   LookupResponse response = datastoreClient.lookup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupResponse lookup(LookupRequest request) {
    return lookupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up entities by key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   LookupRequest request =
   *       LookupRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setReadOptions(ReadOptions.newBuilder().build())
   *           .addAllKeys(new ArrayList<Key>())
   *           .setPropertyMask(PropertyMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LookupResponse> future = datastoreClient.lookupCallable().futureCall(request);
   *   // Do something.
   *   LookupResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupRequest, LookupResponse> lookupCallable() {
    return stub.lookupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries for entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   RunQueryRequest request =
   *       RunQueryRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setPartitionId(PartitionId.newBuilder().build())
   *           .setReadOptions(ReadOptions.newBuilder().build())
   *           .setPropertyMask(PropertyMask.newBuilder().build())
   *           .setExplainOptions(ExplainOptions.newBuilder().build())
   *           .build();
   *   RunQueryResponse response = datastoreClient.runQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunQueryResponse runQuery(RunQueryRequest request) {
    return runQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries for entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   RunQueryRequest request =
   *       RunQueryRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setPartitionId(PartitionId.newBuilder().build())
   *           .setReadOptions(ReadOptions.newBuilder().build())
   *           .setPropertyMask(PropertyMask.newBuilder().build())
   *           .setExplainOptions(ExplainOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<RunQueryResponse> future = datastoreClient.runQueryCallable().futureCall(request);
   *   // Do something.
   *   RunQueryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return stub.runQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an aggregation query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   RunAggregationQueryRequest request =
   *       RunAggregationQueryRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setPartitionId(PartitionId.newBuilder().build())
   *           .setReadOptions(ReadOptions.newBuilder().build())
   *           .setExplainOptions(ExplainOptions.newBuilder().build())
   *           .build();
   *   RunAggregationQueryResponse response = datastoreClient.runAggregationQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    return runAggregationQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an aggregation query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   RunAggregationQueryRequest request =
   *       RunAggregationQueryRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setPartitionId(PartitionId.newBuilder().build())
   *           .setReadOptions(ReadOptions.newBuilder().build())
   *           .setExplainOptions(ExplainOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<RunAggregationQueryResponse> future =
   *       datastoreClient.runAggregationQueryCallable().futureCall(request);
   *   // Do something.
   *   RunAggregationQueryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return stub.runAggregationQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins a new transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   BeginTransactionResponse response = datastoreClient.beginTransaction(projectId);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(String projectId) {
    BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder().setProjectId(projectId).build();
    return beginTransaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins a new transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   BeginTransactionRequest request =
   *       BeginTransactionRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setTransactionOptions(TransactionOptions.newBuilder().build())
   *           .build();
   *   BeginTransactionResponse response = datastoreClient.beginTransaction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    return beginTransactionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins a new transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   BeginTransactionRequest request =
   *       BeginTransactionRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setTransactionOptions(TransactionOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<BeginTransactionResponse> future =
   *       datastoreClient.beginTransactionCallable().futureCall(request);
   *   // Do something.
   *   BeginTransactionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return stub.beginTransactionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
   *   List<Mutation> mutations = new ArrayList<>();
   *   CommitResponse response = datastoreClient.commit(projectId, mode, mutations);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @param mode The type of commit to perform. Defaults to `TRANSACTIONAL`.
   * @param mutations The mutations to perform.
   *     <p>When mode is `TRANSACTIONAL`, mutations affecting a single entity are applied in order.
   *     The following sequences of mutations affecting a single entity are not permitted in a
   *     single `Commit` request:
   *     <p>- `insert` followed by `insert` - `update` followed by `insert` - `upsert` followed by
   *     `insert` - `delete` followed by `update`
   *     <p>When mode is `NON_TRANSACTIONAL`, no two mutations may affect a single entity.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(
      String projectId, CommitRequest.Mode mode, List<Mutation> mutations) {
    CommitRequest request =
        CommitRequest.newBuilder()
            .setProjectId(projectId)
            .setMode(mode)
            .addAllMutations(mutations)
            .build();
    return commit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
   *   ByteString transaction = ByteString.EMPTY;
   *   List<Mutation> mutations = new ArrayList<>();
   *   CommitResponse response = datastoreClient.commit(projectId, mode, transaction, mutations);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @param mode The type of commit to perform. Defaults to `TRANSACTIONAL`.
   * @param transaction The identifier of the transaction associated with the commit. A transaction
   *     identifier is returned by a call to
   *     [Datastore.BeginTransaction][google.datastore.v1.Datastore.BeginTransaction].
   * @param mutations The mutations to perform.
   *     <p>When mode is `TRANSACTIONAL`, mutations affecting a single entity are applied in order.
   *     The following sequences of mutations affecting a single entity are not permitted in a
   *     single `Commit` request:
   *     <p>- `insert` followed by `insert` - `update` followed by `insert` - `upsert` followed by
   *     `insert` - `delete` followed by `update`
   *     <p>When mode is `NON_TRANSACTIONAL`, no two mutations may affect a single entity.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(
      String projectId, CommitRequest.Mode mode, ByteString transaction, List<Mutation> mutations) {
    CommitRequest request =
        CommitRequest.newBuilder()
            .setProjectId(projectId)
            .setMode(mode)
            .setTransaction(transaction)
            .addAllMutations(mutations)
            .build();
    return commit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   CommitRequest request =
   *       CommitRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .addAllMutations(new ArrayList<Mutation>())
   *           .build();
   *   CommitResponse response = datastoreClient.commit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(CommitRequest request) {
    return commitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   CommitRequest request =
   *       CommitRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .addAllMutations(new ArrayList<Mutation>())
   *           .build();
   *   ApiFuture<CommitResponse> future = datastoreClient.commitCallable().futureCall(request);
   *   // Do something.
   *   CommitResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return stub.commitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   ByteString transaction = ByteString.EMPTY;
   *   RollbackResponse response = datastoreClient.rollback(projectId, transaction);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @param transaction Required. The transaction identifier, returned by a call to
   *     [Datastore.BeginTransaction][google.datastore.v1.Datastore.BeginTransaction].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackResponse rollback(String projectId, ByteString transaction) {
    RollbackRequest request =
        RollbackRequest.newBuilder().setProjectId(projectId).setTransaction(transaction).build();
    return rollback(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   RollbackRequest request =
   *       RollbackRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setTransaction(ByteString.EMPTY)
   *           .build();
   *   RollbackResponse response = datastoreClient.rollback(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackResponse rollback(RollbackRequest request) {
    return rollbackCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   RollbackRequest request =
   *       RollbackRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .setTransaction(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<RollbackResponse> future = datastoreClient.rollbackCallable().futureCall(request);
   *   // Do something.
   *   RollbackResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable() {
    return stub.rollbackCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allocates IDs for the given keys, which is useful for referencing an entity before it is
   * inserted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   List<Key> keys = new ArrayList<>();
   *   AllocateIdsResponse response = datastoreClient.allocateIds(projectId, keys);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @param keys Required. A list of keys with incomplete key paths for which to allocate IDs. No
   *     key may be reserved/read-only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocateIdsResponse allocateIds(String projectId, List<Key> keys) {
    AllocateIdsRequest request =
        AllocateIdsRequest.newBuilder().setProjectId(projectId).addAllKeys(keys).build();
    return allocateIds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allocates IDs for the given keys, which is useful for referencing an entity before it is
   * inserted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   AllocateIdsRequest request =
   *       AllocateIdsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .addAllKeys(new ArrayList<Key>())
   *           .build();
   *   AllocateIdsResponse response = datastoreClient.allocateIds(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    return allocateIdsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Allocates IDs for the given keys, which is useful for referencing an entity before it is
   * inserted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   AllocateIdsRequest request =
   *       AllocateIdsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .addAllKeys(new ArrayList<Key>())
   *           .build();
   *   ApiFuture<AllocateIdsResponse> future =
   *       datastoreClient.allocateIdsCallable().futureCall(request);
   *   // Do something.
   *   AllocateIdsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable() {
    return stub.allocateIdsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "projectId-894832108";
   *   List<Key> keys = new ArrayList<>();
   *   ReserveIdsResponse response = datastoreClient.reserveIds(projectId, keys);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the project against which to make the request.
   * @param keys Required. A list of keys with complete key paths whose numeric IDs should not be
   *     auto-allocated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReserveIdsResponse reserveIds(String projectId, List<Key> keys) {
    ReserveIdsRequest request =
        ReserveIdsRequest.newBuilder().setProjectId(projectId).addAllKeys(keys).build();
    return reserveIds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   ReserveIdsRequest request =
   *       ReserveIdsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .addAllKeys(new ArrayList<Key>())
   *           .build();
   *   ReserveIdsResponse response = datastoreClient.reserveIds(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    return reserveIdsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   ReserveIdsRequest request =
   *       ReserveIdsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setDatabaseId("databaseId1688905718")
   *           .addAllKeys(new ArrayList<Key>())
   *           .build();
   *   ApiFuture<ReserveIdsResponse> future =
   *       datastoreClient.reserveIdsCallable().futureCall(request);
   *   // Do something.
   *   ReserveIdsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable() {
    return stub.reserveIdsCallable();
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
