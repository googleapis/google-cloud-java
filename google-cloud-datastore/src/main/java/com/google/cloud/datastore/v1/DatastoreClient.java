/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datastore.v1.stub.DatastoreStub;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitRequest.Mode;
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
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
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
 * <pre>
 * <code>
 * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
 *   String projectId = "";
 *   ReadOptions readOptions = ReadOptions.newBuilder().build();
 *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
 *   LookupResponse response = datastoreClient.lookup(projectId, readOptions, keys);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the datastoreClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
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
 * <pre>
 * <code>
 * DatastoreSettings datastoreSettings =
 *     DatastoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatastoreClient datastoreClient =
 *     DatastoreClient.create(datastoreSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DatastoreSettings datastoreSettings =
 *     DatastoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatastoreClient datastoreClient =
 *     DatastoreClient.create(datastoreSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
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
   * advanced usage - prefer to use DatastoreSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DatastoreClient(DatastoreStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DatastoreSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DatastoreStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up entities by key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   ReadOptions readOptions = ReadOptions.newBuilder().build();
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   LookupResponse response = datastoreClient.lookup(projectId, readOptions, keys);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
   * @param readOptions The options for this lookup request.
   * @param keys Keys of entities to look up.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up entities by key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   LookupRequest request = LookupRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .addAllKeys(keys)
   *     .build();
   *   LookupResponse response = datastoreClient.lookup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LookupResponse lookup(LookupRequest request) {
    return lookupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Looks up entities by key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   LookupRequest request = LookupRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .addAllKeys(keys)
   *     .build();
   *   ApiFuture&lt;LookupResponse&gt; future = datastoreClient.lookupCallable().futureCall(request);
   *   // Do something
   *   LookupResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<LookupRequest, LookupResponse> lookupCallable() {
    return stub.lookupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Queries for entities.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   PartitionId partitionId = PartitionId.newBuilder().build();
   *   RunQueryRequest request = RunQueryRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setPartitionId(partitionId)
   *     .build();
   *   RunQueryResponse response = datastoreClient.runQuery(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunQueryResponse runQuery(RunQueryRequest request) {
    return runQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Queries for entities.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   PartitionId partitionId = PartitionId.newBuilder().build();
   *   RunQueryRequest request = RunQueryRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setPartitionId(partitionId)
   *     .build();
   *   ApiFuture&lt;RunQueryResponse&gt; future = datastoreClient.runQueryCallable().futureCall(request);
   *   // Do something
   *   RunQueryResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return stub.runQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Begins a new transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   BeginTransactionResponse response = datastoreClient.beginTransaction(projectId);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(String projectId) {

    BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder().setProjectId(projectId).build();
    return beginTransaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Begins a new transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   BeginTransactionRequest request = BeginTransactionRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   BeginTransactionResponse response = datastoreClient.beginTransaction(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    return beginTransactionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Begins a new transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   BeginTransactionRequest request = BeginTransactionRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   ApiFuture&lt;BeginTransactionResponse&gt; future = datastoreClient.beginTransactionCallable().futureCall(request);
   *   // Do something
   *   BeginTransactionResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return stub.beginTransactionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   List&lt;Mutation&gt; mutations = new ArrayList&lt;&gt;();
   *   CommitResponse response = datastoreClient.commit(projectId, mode, transaction, mutations);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
   *   List&lt;Mutation&gt; mutations = new ArrayList&lt;&gt;();
   *   CommitResponse response = datastoreClient.commit(projectId, mode, mutations);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
   *   List&lt;Mutation&gt; mutations = new ArrayList&lt;&gt;();
   *   CommitRequest request = CommitRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setMode(mode)
   *     .addAllMutations(mutations)
   *     .build();
   *   CommitResponse response = datastoreClient.commit(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(CommitRequest request) {
    return commitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, optionally creating, deleting or modifying some entities.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   CommitRequest.Mode mode = CommitRequest.Mode.MODE_UNSPECIFIED;
   *   List&lt;Mutation&gt; mutations = new ArrayList&lt;&gt;();
   *   CommitRequest request = CommitRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setMode(mode)
   *     .addAllMutations(mutations)
   *     .build();
   *   ApiFuture&lt;CommitResponse&gt; future = datastoreClient.commitCallable().futureCall(request);
   *   // Do something
   *   CommitResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return stub.commitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   RollbackResponse response = datastoreClient.rollback(projectId, transaction);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
   * @param transaction The transaction identifier, returned by a call to
   *     [Datastore.BeginTransaction][google.datastore.v1.Datastore.BeginTransaction].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackResponse rollback(String projectId, ByteString transaction) {

    RollbackRequest request =
        RollbackRequest.newBuilder().setProjectId(projectId).setTransaction(transaction).build();
    return rollback(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   RollbackRequest request = RollbackRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTransaction(transaction)
   *     .build();
   *   RollbackResponse response = datastoreClient.rollback(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollbackResponse rollback(RollbackRequest request) {
    return rollbackCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   RollbackRequest request = RollbackRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTransaction(transaction)
   *     .build();
   *   ApiFuture&lt;RollbackResponse&gt; future = datastoreClient.rollbackCallable().futureCall(request);
   *   // Do something
   *   RollbackResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable() {
    return stub.rollbackCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Allocates IDs for the given keys, which is useful for referencing an entity before it is
   * inserted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   AllocateIdsResponse response = datastoreClient.allocateIds(projectId, keys);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
   * @param keys A list of keys with incomplete key paths for which to allocate IDs. No key may be
   *     reserved/read-only.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocateIdsResponse allocateIds(String projectId, List<Key> keys) {

    AllocateIdsRequest request =
        AllocateIdsRequest.newBuilder().setProjectId(projectId).addAllKeys(keys).build();
    return allocateIds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Allocates IDs for the given keys, which is useful for referencing an entity before it is
   * inserted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   AllocateIdsRequest request = AllocateIdsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .addAllKeys(keys)
   *     .build();
   *   AllocateIdsResponse response = datastoreClient.allocateIds(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    return allocateIdsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Allocates IDs for the given keys, which is useful for referencing an entity before it is
   * inserted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   AllocateIdsRequest request = AllocateIdsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .addAllKeys(keys)
   *     .build();
   *   ApiFuture&lt;AllocateIdsResponse&gt; future = datastoreClient.allocateIdsCallable().futureCall(request);
   *   // Do something
   *   AllocateIdsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable() {
    return stub.allocateIdsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   ReserveIdsResponse response = datastoreClient.reserveIds(projectId, keys);
   * }
   * </code></pre>
   *
   * @param projectId The ID of the project against which to make the request.
   * @param keys A list of keys with complete key paths whose numeric IDs should not be
   *     auto-allocated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReserveIdsResponse reserveIds(String projectId, List<Key> keys) {

    ReserveIdsRequest request =
        ReserveIdsRequest.newBuilder().setProjectId(projectId).addAllKeys(keys).build();
    return reserveIds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   ReserveIdsRequest request = ReserveIdsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .addAllKeys(keys)
   *     .build();
   *   ReserveIdsResponse response = datastoreClient.reserveIds(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    return reserveIdsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
   *   String projectId = "";
   *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
   *   ReserveIdsRequest request = ReserveIdsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .addAllKeys(keys)
   *     .build();
   *   ApiFuture&lt;ReserveIdsResponse&gt; future = datastoreClient.reserveIdsCallable().futureCall(request);
   *   // Do something
   *   ReserveIdsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable() {
    return stub.reserveIdsCallable();
  }

  @Override
  public final void close() throws Exception {
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
