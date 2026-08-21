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

package com.google.cloud.blockchainnodeengine.v1;

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
import com.google.cloud.blockchainnodeengine.v1.stub.BlockchainNodeEngineStub;
import com.google.cloud.blockchainnodeengine.v1.stub.BlockchainNodeEngineStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is the control plane API for Blockchain Node Engine, and can be
 * used to create, read, and delete blockchain nodes.
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
 * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
 *     BlockchainNodeEngineClient.create()) {
 *   BlockchainNodeName name =
 *       BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");
 *   BlockchainNode response = blockchainNodeEngineClient.getBlockchainNode(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BlockchainNodeEngineClient object to clean up
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
 *      <td><p> ListBlockchainNodes</td>
 *      <td><p> Lists blockchain nodes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBlockchainNodes(ListBlockchainNodesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBlockchainNodes(LocationName parent)
 *           <li><p> listBlockchainNodes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBlockchainNodesPagedCallable()
 *           <li><p> listBlockchainNodesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBlockchainNode</td>
 *      <td><p> Gets details of a single blockchain node.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBlockchainNode(GetBlockchainNodeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBlockchainNode(BlockchainNodeName name)
 *           <li><p> getBlockchainNode(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBlockchainNodeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBlockchainNode</td>
 *      <td><p> Creates a new blockchain node in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBlockchainNodeAsync(CreateBlockchainNodeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBlockchainNodeAsync(LocationName parent, BlockchainNode blockchainNode, String blockchainNodeId)
 *           <li><p> createBlockchainNodeAsync(String parent, BlockchainNode blockchainNode, String blockchainNodeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBlockchainNodeOperationCallable()
 *           <li><p> createBlockchainNodeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBlockchainNode</td>
 *      <td><p> Updates the parameters of a single blockchain node.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBlockchainNodeAsync(UpdateBlockchainNodeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBlockchainNodeAsync(BlockchainNode blockchainNode, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBlockchainNodeOperationCallable()
 *           <li><p> updateBlockchainNodeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBlockchainNode</td>
 *      <td><p> Deletes a single blockchain node.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBlockchainNodeAsync(DeleteBlockchainNodeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBlockchainNodeAsync(BlockchainNodeName name)
 *           <li><p> deleteBlockchainNodeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBlockchainNodeOperationCallable()
 *           <li><p> deleteBlockchainNodeCallable()
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
 * <p>This class can be customized by passing in a custom instance of BlockchainNodeEngineSettings
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
 * BlockchainNodeEngineSettings blockchainNodeEngineSettings =
 *     BlockchainNodeEngineSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BlockchainNodeEngineClient blockchainNodeEngineClient =
 *     BlockchainNodeEngineClient.create(blockchainNodeEngineSettings);
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
 * BlockchainNodeEngineSettings blockchainNodeEngineSettings =
 *     BlockchainNodeEngineSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BlockchainNodeEngineClient blockchainNodeEngineClient =
 *     BlockchainNodeEngineClient.create(blockchainNodeEngineSettings);
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
 * BlockchainNodeEngineSettings blockchainNodeEngineSettings =
 *     BlockchainNodeEngineSettings.newHttpJsonBuilder().build();
 * BlockchainNodeEngineClient blockchainNodeEngineClient =
 *     BlockchainNodeEngineClient.create(blockchainNodeEngineSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class BlockchainNodeEngineClient implements BackgroundResource {
  private final @Nullable BlockchainNodeEngineSettings settings;
  private final BlockchainNodeEngineStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BlockchainNodeEngineClient with default settings. */
  public static final BlockchainNodeEngineClient create() throws IOException {
    return create(BlockchainNodeEngineSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BlockchainNodeEngineClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BlockchainNodeEngineClient create(BlockchainNodeEngineSettings settings)
      throws IOException {
    return new BlockchainNodeEngineClient(settings);
  }

  /**
   * Constructs an instance of BlockchainNodeEngineClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BlockchainNodeEngineSettings).
   */
  public static final BlockchainNodeEngineClient create(BlockchainNodeEngineStub stub) {
    return new BlockchainNodeEngineClient(stub);
  }

  /**
   * Constructs an instance of BlockchainNodeEngineClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BlockchainNodeEngineClient(BlockchainNodeEngineSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BlockchainNodeEngineStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BlockchainNodeEngineClient(BlockchainNodeEngineStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable BlockchainNodeEngineSettings getSettings() {
    return settings;
  }

  public BlockchainNodeEngineStub getStub() {
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
   * Lists blockchain nodes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BlockchainNode element :
   *       blockchainNodeEngineClient.listBlockchainNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListNodesRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlockchainNodesPagedResponse listBlockchainNodes(@Nullable LocationName parent) {
    ListBlockchainNodesRequest request =
        ListBlockchainNodesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBlockchainNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists blockchain nodes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BlockchainNode element :
   *       blockchainNodeEngineClient.listBlockchainNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for `ListNodesRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlockchainNodesPagedResponse listBlockchainNodes(String parent) {
    ListBlockchainNodesRequest request =
        ListBlockchainNodesRequest.newBuilder().setParent(parent).build();
    return listBlockchainNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists blockchain nodes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   ListBlockchainNodesRequest request =
   *       ListBlockchainNodesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BlockchainNode element :
   *       blockchainNodeEngineClient.listBlockchainNodes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBlockchainNodesPagedResponse listBlockchainNodes(
      ListBlockchainNodesRequest request) {
    return listBlockchainNodesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists blockchain nodes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   ListBlockchainNodesRequest request =
   *       ListBlockchainNodesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BlockchainNode> future =
   *       blockchainNodeEngineClient.listBlockchainNodesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BlockchainNode element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesPagedResponse>
      listBlockchainNodesPagedCallable() {
    return stub.listBlockchainNodesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists blockchain nodes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   ListBlockchainNodesRequest request =
   *       ListBlockchainNodesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBlockchainNodesResponse response =
   *         blockchainNodeEngineClient.listBlockchainNodesCallable().call(request);
   *     for (BlockchainNode element : response.getBlockchainNodesList()) {
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
  public final UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesCallable() {
    return stub.listBlockchainNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   BlockchainNodeName name =
   *       BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");
   *   BlockchainNode response = blockchainNodeEngineClient.getBlockchainNode(name);
   * }
   * }</pre>
   *
   * @param name Required. The fully qualified name of the blockchain node to fetch. e.g.
   *     `projects/my-project/locations/us-central1/blockchainNodes/my-node`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BlockchainNode getBlockchainNode(@Nullable BlockchainNodeName name) {
    GetBlockchainNodeRequest request =
        GetBlockchainNodeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBlockchainNode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   String name =
   *       BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString();
   *   BlockchainNode response = blockchainNodeEngineClient.getBlockchainNode(name);
   * }
   * }</pre>
   *
   * @param name Required. The fully qualified name of the blockchain node to fetch. e.g.
   *     `projects/my-project/locations/us-central1/blockchainNodes/my-node`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BlockchainNode getBlockchainNode(String name) {
    GetBlockchainNodeRequest request = GetBlockchainNodeRequest.newBuilder().setName(name).build();
    return getBlockchainNode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   GetBlockchainNodeRequest request =
   *       GetBlockchainNodeRequest.newBuilder()
   *           .setName(
   *               BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
   *           .build();
   *   BlockchainNode response = blockchainNodeEngineClient.getBlockchainNode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BlockchainNode getBlockchainNode(GetBlockchainNodeRequest request) {
    return getBlockchainNodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   GetBlockchainNodeRequest request =
   *       GetBlockchainNodeRequest.newBuilder()
   *           .setName(
   *               BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
   *           .build();
   *   ApiFuture<BlockchainNode> future =
   *       blockchainNodeEngineClient.getBlockchainNodeCallable().futureCall(request);
   *   // Do something.
   *   BlockchainNode response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeCallable() {
    return stub.getBlockchainNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new blockchain node in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
   *   String blockchainNodeId = "blockchainNodeId-2023686607";
   *   BlockchainNode response =
   *       blockchainNodeEngineClient
   *           .createBlockchainNodeAsync(parent, blockchainNode, blockchainNodeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param blockchainNode Required. The resource being created.
   * @param blockchainNodeId Required. ID of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BlockchainNode, OperationMetadata> createBlockchainNodeAsync(
      @Nullable LocationName parent, BlockchainNode blockchainNode, String blockchainNodeId) {
    CreateBlockchainNodeRequest request =
        CreateBlockchainNodeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBlockchainNode(blockchainNode)
            .setBlockchainNodeId(blockchainNodeId)
            .build();
    return createBlockchainNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new blockchain node in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
   *   String blockchainNodeId = "blockchainNodeId-2023686607";
   *   BlockchainNode response =
   *       blockchainNodeEngineClient
   *           .createBlockchainNodeAsync(parent, blockchainNode, blockchainNodeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param blockchainNode Required. The resource being created.
   * @param blockchainNodeId Required. ID of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BlockchainNode, OperationMetadata> createBlockchainNodeAsync(
      String parent, BlockchainNode blockchainNode, String blockchainNodeId) {
    CreateBlockchainNodeRequest request =
        CreateBlockchainNodeRequest.newBuilder()
            .setParent(parent)
            .setBlockchainNode(blockchainNode)
            .setBlockchainNodeId(blockchainNodeId)
            .build();
    return createBlockchainNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new blockchain node in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   CreateBlockchainNodeRequest request =
   *       CreateBlockchainNodeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBlockchainNodeId("blockchainNodeId-2023686607")
   *           .setBlockchainNode(BlockchainNode.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BlockchainNode response = blockchainNodeEngineClient.createBlockchainNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BlockchainNode, OperationMetadata> createBlockchainNodeAsync(
      CreateBlockchainNodeRequest request) {
    return createBlockchainNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new blockchain node in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   CreateBlockchainNodeRequest request =
   *       CreateBlockchainNodeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBlockchainNodeId("blockchainNodeId-2023686607")
   *           .setBlockchainNode(BlockchainNode.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BlockchainNode, OperationMetadata> future =
   *       blockchainNodeEngineClient.createBlockchainNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   BlockchainNode response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      createBlockchainNodeOperationCallable() {
    return stub.createBlockchainNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new blockchain node in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   CreateBlockchainNodeRequest request =
   *       CreateBlockchainNodeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBlockchainNodeId("blockchainNodeId-2023686607")
   *           .setBlockchainNode(BlockchainNode.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       blockchainNodeEngineClient.createBlockchainNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBlockchainNodeRequest, Operation>
      createBlockchainNodeCallable() {
    return stub.createBlockchainNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BlockchainNode response =
   *       blockchainNodeEngineClient.updateBlockchainNodeAsync(blockchainNode, updateMask).get();
   * }
   * }</pre>
   *
   * @param blockchainNode Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Blockchain node resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BlockchainNode, OperationMetadata> updateBlockchainNodeAsync(
      BlockchainNode blockchainNode, FieldMask updateMask) {
    UpdateBlockchainNodeRequest request =
        UpdateBlockchainNodeRequest.newBuilder()
            .setBlockchainNode(blockchainNode)
            .setUpdateMask(updateMask)
            .build();
    return updateBlockchainNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   UpdateBlockchainNodeRequest request =
   *       UpdateBlockchainNodeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBlockchainNode(BlockchainNode.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BlockchainNode response = blockchainNodeEngineClient.updateBlockchainNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BlockchainNode, OperationMetadata> updateBlockchainNodeAsync(
      UpdateBlockchainNodeRequest request) {
    return updateBlockchainNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   UpdateBlockchainNodeRequest request =
   *       UpdateBlockchainNodeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBlockchainNode(BlockchainNode.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BlockchainNode, OperationMetadata> future =
   *       blockchainNodeEngineClient.updateBlockchainNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   BlockchainNode response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      updateBlockchainNodeOperationCallable() {
    return stub.updateBlockchainNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   UpdateBlockchainNodeRequest request =
   *       UpdateBlockchainNodeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBlockchainNode(BlockchainNode.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       blockchainNodeEngineClient.updateBlockchainNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBlockchainNodeRequest, Operation>
      updateBlockchainNodeCallable() {
    return stub.updateBlockchainNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   BlockchainNodeName name =
   *       BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");
   *   blockchainNodeEngineClient.deleteBlockchainNodeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The fully qualified name of the blockchain node to delete. e.g.
   *     `projects/my-project/locations/us-central1/blockchainNodes/my-node`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBlockchainNodeAsync(
      @Nullable BlockchainNodeName name) {
    DeleteBlockchainNodeRequest request =
        DeleteBlockchainNodeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBlockchainNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   String name =
   *       BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString();
   *   blockchainNodeEngineClient.deleteBlockchainNodeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The fully qualified name of the blockchain node to delete. e.g.
   *     `projects/my-project/locations/us-central1/blockchainNodes/my-node`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBlockchainNodeAsync(String name) {
    DeleteBlockchainNodeRequest request =
        DeleteBlockchainNodeRequest.newBuilder().setName(name).build();
    return deleteBlockchainNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   DeleteBlockchainNodeRequest request =
   *       DeleteBlockchainNodeRequest.newBuilder()
   *           .setName(
   *               BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   blockchainNodeEngineClient.deleteBlockchainNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBlockchainNodeAsync(
      DeleteBlockchainNodeRequest request) {
    return deleteBlockchainNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   DeleteBlockchainNodeRequest request =
   *       DeleteBlockchainNodeRequest.newBuilder()
   *           .setName(
   *               BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       blockchainNodeEngineClient.deleteBlockchainNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
      deleteBlockchainNodeOperationCallable() {
    return stub.deleteBlockchainNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single blockchain node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   DeleteBlockchainNodeRequest request =
   *       DeleteBlockchainNodeRequest.newBuilder()
   *           .setName(
   *               BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       blockchainNodeEngineClient.deleteBlockchainNodeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBlockchainNodeRequest, Operation>
      deleteBlockchainNodeCallable() {
    return stub.deleteBlockchainNodeCallable();
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
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : blockchainNodeEngineClient.listLocations(request).iterateAll()) {
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
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       blockchainNodeEngineClient.listLocationsPagedCallable().futureCall(request);
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
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         blockchainNodeEngineClient.listLocationsCallable().call(request);
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
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = blockchainNodeEngineClient.getLocation(request);
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
   * try (BlockchainNodeEngineClient blockchainNodeEngineClient =
   *     BlockchainNodeEngineClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       blockchainNodeEngineClient.getLocationCallable().futureCall(request);
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

  public static class ListBlockchainNodesPagedResponse
      extends AbstractPagedListResponse<
          ListBlockchainNodesRequest,
          ListBlockchainNodesResponse,
          BlockchainNode,
          ListBlockchainNodesPage,
          ListBlockchainNodesFixedSizeCollection> {

    public static ApiFuture<ListBlockchainNodesPagedResponse> createAsync(
        PageContext<ListBlockchainNodesRequest, ListBlockchainNodesResponse, BlockchainNode>
            context,
        ApiFuture<ListBlockchainNodesResponse> futureResponse) {
      ApiFuture<ListBlockchainNodesPage> futurePage =
          ListBlockchainNodesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBlockchainNodesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBlockchainNodesPagedResponse(ListBlockchainNodesPage page) {
      super(page, ListBlockchainNodesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBlockchainNodesPage
      extends AbstractPage<
          ListBlockchainNodesRequest,
          ListBlockchainNodesResponse,
          BlockchainNode,
          ListBlockchainNodesPage> {

    private ListBlockchainNodesPage(
        @Nullable
            PageContext<ListBlockchainNodesRequest, ListBlockchainNodesResponse, BlockchainNode>
            context,
        @Nullable ListBlockchainNodesResponse response) {
      super(context, response);
    }

    private static ListBlockchainNodesPage createEmptyPage() {
      return new ListBlockchainNodesPage(null, null);
    }

    @Override
    protected ListBlockchainNodesPage createPage(
        @Nullable
            PageContext<ListBlockchainNodesRequest, ListBlockchainNodesResponse, BlockchainNode>
            context,
        @Nullable ListBlockchainNodesResponse response) {
      return new ListBlockchainNodesPage(context, response);
    }

    @Override
    public ApiFuture<ListBlockchainNodesPage> createPageAsync(
        @Nullable
            PageContext<ListBlockchainNodesRequest, ListBlockchainNodesResponse, BlockchainNode>
            context,
        ApiFuture<ListBlockchainNodesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBlockchainNodesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBlockchainNodesRequest,
          ListBlockchainNodesResponse,
          BlockchainNode,
          ListBlockchainNodesPage,
          ListBlockchainNodesFixedSizeCollection> {

    private ListBlockchainNodesFixedSizeCollection(
        @Nullable List<ListBlockchainNodesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBlockchainNodesFixedSizeCollection createEmptyCollection() {
      return new ListBlockchainNodesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBlockchainNodesFixedSizeCollection createCollection(
        @Nullable List<ListBlockchainNodesPage> pages, int collectionSize) {
      return new ListBlockchainNodesFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
