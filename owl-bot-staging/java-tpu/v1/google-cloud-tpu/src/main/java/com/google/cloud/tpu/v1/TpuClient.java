/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.tpu.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v1.stub.TpuStub;
import com.google.cloud.tpu.v1.stub.TpuStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages TPU nodes and other resources
 *
 * <p>TPU API v1
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
 * try (TpuClient tpuClient = TpuClient.create()) {
 *   NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
 *   Node response = tpuClient.getNode(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TpuClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of TpuSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TpuSettings tpuSettings =
 *     TpuSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TpuClient tpuClient = TpuClient.create(tpuSettings);
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
 * TpuSettings tpuSettings = TpuSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TpuClient tpuClient = TpuClient.create(tpuSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TpuClient implements BackgroundResource {
  private final TpuSettings settings;
  private final TpuStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of TpuClient with default settings. */
  public static final TpuClient create() throws IOException {
    return create(TpuSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TpuClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TpuClient create(TpuSettings settings) throws IOException {
    return new TpuClient(settings);
  }

  /**
   * Constructs an instance of TpuClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TpuSettings).
   */
  public static final TpuClient create(TpuStub stub) {
    return new TpuClient(stub);
  }

  /**
   * Constructs an instance of TpuClient, using the given settings. This is protected so that it is
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TpuClient(TpuSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TpuStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected TpuClient(TpuStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final TpuSettings getSettings() {
    return settings;
  }

  public TpuStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Node element : tpuClient.listNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(LocationName parent) {
    ListNodesRequest request =
        ListNodesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Node element : tpuClient.listNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(String parent) {
    ListNodesRequest request = ListNodesRequest.newBuilder().setParent(parent).build();
    return listNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListNodesRequest request =
   *       ListNodesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Node element : tpuClient.listNodes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(ListNodesRequest request) {
    return listNodesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListNodesRequest request =
   *       ListNodesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Node> future = tpuClient.listNodesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Node element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    return stub.listNodesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListNodesRequest request =
   *       ListNodesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNodesResponse response = tpuClient.listNodesCallable().call(request);
   *     for (Node element : response.getNodesList()) {
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
  public final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    return stub.listNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
   *   Node response = tpuClient.getNode(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Node getNode(NodeName name) {
    GetNodeRequest request =
        GetNodeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString();
   *   Node response = tpuClient.getNode(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Node getNode(String name) {
    GetNodeRequest request = GetNodeRequest.newBuilder().setName(name).build();
    return getNode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetNodeRequest request =
   *       GetNodeRequest.newBuilder()
   *           .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
   *           .build();
   *   Node response = tpuClient.getNode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Node getNode(GetNodeRequest request) {
    return getNodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetNodeRequest request =
   *       GetNodeRequest.newBuilder()
   *           .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
   *           .build();
   *   ApiFuture<Node> future = tpuClient.getNodeCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    return stub.getNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Node node = Node.newBuilder().build();
   *   String nodeId = "nodeId-1040171331";
   *   Node response = tpuClient.createNodeAsync(parent, node, nodeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @param node Required. The node.
   * @param nodeId The unqualified resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> createNodeAsync(
      LocationName parent, Node node, String nodeId) {
    CreateNodeRequest request =
        CreateNodeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNode(node)
            .setNodeId(nodeId)
            .build();
    return createNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Node node = Node.newBuilder().build();
   *   String nodeId = "nodeId-1040171331";
   *   Node response = tpuClient.createNodeAsync(parent, node, nodeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @param node Required. The node.
   * @param nodeId The unqualified resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> createNodeAsync(
      String parent, Node node, String nodeId) {
    CreateNodeRequest request =
        CreateNodeRequest.newBuilder().setParent(parent).setNode(node).setNodeId(nodeId).build();
    return createNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   CreateNodeRequest request =
   *       CreateNodeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNodeId("nodeId-1040171331")
   *           .setNode(Node.newBuilder().build())
   *           .build();
   *   Node response = tpuClient.createNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> createNodeAsync(CreateNodeRequest request) {
    return createNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   CreateNodeRequest request =
   *       CreateNodeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNodeId("nodeId-1040171331")
   *           .setNode(Node.newBuilder().build())
   *           .build();
   *   OperationFuture<Node, OperationMetadata> future =
   *       tpuClient.createNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable() {
    return stub.createNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   CreateNodeRequest request =
   *       CreateNodeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNodeId("nodeId-1040171331")
   *           .setNode(Node.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = tpuClient.createNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNodeRequest, Operation> createNodeCallable() {
    return stub.createNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
   *   Node response = tpuClient.deleteNodeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> deleteNodeAsync(NodeName name) {
    DeleteNodeRequest request =
        DeleteNodeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString();
   *   Node response = tpuClient.deleteNodeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> deleteNodeAsync(String name) {
    DeleteNodeRequest request = DeleteNodeRequest.newBuilder().setName(name).build();
    return deleteNodeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   DeleteNodeRequest request =
   *       DeleteNodeRequest.newBuilder()
   *           .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
   *           .build();
   *   Node response = tpuClient.deleteNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> deleteNodeAsync(DeleteNodeRequest request) {
    return deleteNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   DeleteNodeRequest request =
   *       DeleteNodeRequest.newBuilder()
   *           .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
   *           .build();
   *   OperationFuture<Node, OperationMetadata> future =
   *       tpuClient.deleteNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationCallable() {
    return stub.deleteNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   DeleteNodeRequest request =
   *       DeleteNodeRequest.newBuilder()
   *           .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = tpuClient.deleteNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable() {
    return stub.deleteNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reimages a node's OS.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ReimageNodeRequest request =
   *       ReimageNodeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setTensorflowVersion("tensorflowVersion-470125103")
   *           .build();
   *   Node response = tpuClient.reimageNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> reimageNodeAsync(
      ReimageNodeRequest request) {
    return reimageNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reimages a node's OS.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ReimageNodeRequest request =
   *       ReimageNodeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setTensorflowVersion("tensorflowVersion-470125103")
   *           .build();
   *   OperationFuture<Node, OperationMetadata> future =
   *       tpuClient.reimageNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReimageNodeRequest, Node, OperationMetadata>
      reimageNodeOperationCallable() {
    return stub.reimageNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reimages a node's OS.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ReimageNodeRequest request =
   *       ReimageNodeRequest.newBuilder()
   *           .setName("name3373707")
   *           .setTensorflowVersion("tensorflowVersion-470125103")
   *           .build();
   *   ApiFuture<Operation> future = tpuClient.reimageNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReimageNodeRequest, Operation> reimageNodeCallable() {
    return stub.reimageNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a node, this operation is only available with single TPU nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   StopNodeRequest request = StopNodeRequest.newBuilder().setName("name3373707").build();
   *   Node response = tpuClient.stopNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> stopNodeAsync(StopNodeRequest request) {
    return stopNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a node, this operation is only available with single TPU nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   StopNodeRequest request = StopNodeRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Node, OperationMetadata> future =
   *       tpuClient.stopNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationCallable() {
    return stub.stopNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a node, this operation is only available with single TPU nodes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   StopNodeRequest request = StopNodeRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = tpuClient.stopNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopNodeRequest, Operation> stopNodeCallable() {
    return stub.stopNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   StartNodeRequest request = StartNodeRequest.newBuilder().setName("name3373707").build();
   *   Node response = tpuClient.startNodeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Node, OperationMetadata> startNodeAsync(StartNodeRequest request) {
    return startNodeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   StartNodeRequest request = StartNodeRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Node, OperationMetadata> future =
   *       tpuClient.startNodeOperationCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationCallable() {
    return stub.startNodeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   StartNodeRequest request = StartNodeRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = tpuClient.startNodeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartNodeRequest, Operation> startNodeCallable() {
    return stub.startNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TensorFlow versions supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   TensorFlowVersionName parent =
   *       TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]");
   *   for (TensorFlowVersion element : tpuClient.listTensorFlowVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorFlowVersionsPagedResponse listTensorFlowVersions(
      TensorFlowVersionName parent) {
    ListTensorFlowVersionsRequest request =
        ListTensorFlowVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTensorFlowVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TensorFlow versions supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String parent =
   *       TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]").toString();
   *   for (TensorFlowVersion element : tpuClient.listTensorFlowVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorFlowVersionsPagedResponse listTensorFlowVersions(String parent) {
    ListTensorFlowVersionsRequest request =
        ListTensorFlowVersionsRequest.newBuilder().setParent(parent).build();
    return listTensorFlowVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TensorFlow versions supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListTensorFlowVersionsRequest request =
   *       ListTensorFlowVersionsRequest.newBuilder()
   *           .setParent(
   *               TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TensorFlowVersion element : tpuClient.listTensorFlowVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTensorFlowVersionsPagedResponse listTensorFlowVersions(
      ListTensorFlowVersionsRequest request) {
    return listTensorFlowVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TensorFlow versions supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListTensorFlowVersionsRequest request =
   *       ListTensorFlowVersionsRequest.newBuilder()
   *           .setParent(
   *               TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TensorFlowVersion> future =
   *       tpuClient.listTensorFlowVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TensorFlowVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsPagedResponse>
      listTensorFlowVersionsPagedCallable() {
    return stub.listTensorFlowVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List TensorFlow versions supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListTensorFlowVersionsRequest request =
   *       ListTensorFlowVersionsRequest.newBuilder()
   *           .setParent(
   *               TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTensorFlowVersionsResponse response =
   *         tpuClient.listTensorFlowVersionsCallable().call(request);
   *     for (TensorFlowVersion element : response.getTensorflowVersionsList()) {
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
  public final UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
      listTensorFlowVersionsCallable() {
    return stub.listTensorFlowVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets TensorFlow Version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   TensorFlowVersionName name =
   *       TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]");
   *   TensorFlowVersion response = tpuClient.getTensorFlowVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorFlowVersion getTensorFlowVersion(TensorFlowVersionName name) {
    GetTensorFlowVersionRequest request =
        GetTensorFlowVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTensorFlowVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets TensorFlow Version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String name =
   *       TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]").toString();
   *   TensorFlowVersion response = tpuClient.getTensorFlowVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorFlowVersion getTensorFlowVersion(String name) {
    GetTensorFlowVersionRequest request =
        GetTensorFlowVersionRequest.newBuilder().setName(name).build();
    return getTensorFlowVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets TensorFlow Version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetTensorFlowVersionRequest request =
   *       GetTensorFlowVersionRequest.newBuilder()
   *           .setName(
   *               TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
   *                   .toString())
   *           .build();
   *   TensorFlowVersion response = tpuClient.getTensorFlowVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TensorFlowVersion getTensorFlowVersion(GetTensorFlowVersionRequest request) {
    return getTensorFlowVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets TensorFlow Version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetTensorFlowVersionRequest request =
   *       GetTensorFlowVersionRequest.newBuilder()
   *           .setName(
   *               TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TensorFlowVersion> future =
   *       tpuClient.getTensorFlowVersionCallable().futureCall(request);
   *   // Do something.
   *   TensorFlowVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionCallable() {
    return stub.getTensorFlowVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accelerator types supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   AcceleratorTypeName parent =
   *       AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");
   *   for (AcceleratorType element : tpuClient.listAcceleratorTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAcceleratorTypesPagedResponse listAcceleratorTypes(AcceleratorTypeName parent) {
    ListAcceleratorTypesRequest request =
        ListAcceleratorTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAcceleratorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accelerator types supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String parent =
   *       AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]").toString();
   *   for (AcceleratorType element : tpuClient.listAcceleratorTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAcceleratorTypesPagedResponse listAcceleratorTypes(String parent) {
    ListAcceleratorTypesRequest request =
        ListAcceleratorTypesRequest.newBuilder().setParent(parent).build();
    return listAcceleratorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accelerator types supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListAcceleratorTypesRequest request =
   *       ListAcceleratorTypesRequest.newBuilder()
   *           .setParent(
   *               AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AcceleratorType element : tpuClient.listAcceleratorTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAcceleratorTypesPagedResponse listAcceleratorTypes(
      ListAcceleratorTypesRequest request) {
    return listAcceleratorTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accelerator types supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListAcceleratorTypesRequest request =
   *       ListAcceleratorTypesRequest.newBuilder()
   *           .setParent(
   *               AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AcceleratorType> future =
   *       tpuClient.listAcceleratorTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AcceleratorType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    return stub.listAcceleratorTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists accelerator types supported by this API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListAcceleratorTypesRequest request =
   *       ListAcceleratorTypesRequest.newBuilder()
   *           .setParent(
   *               AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAcceleratorTypesResponse response =
   *         tpuClient.listAcceleratorTypesCallable().call(request);
   *     for (AcceleratorType element : response.getAcceleratorTypesList()) {
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
  public final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable() {
    return stub.listAcceleratorTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets AcceleratorType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   AcceleratorTypeName name =
   *       AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");
   *   AcceleratorType response = tpuClient.getAcceleratorType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AcceleratorType getAcceleratorType(AcceleratorTypeName name) {
    GetAcceleratorTypeRequest request =
        GetAcceleratorTypeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAcceleratorType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets AcceleratorType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   String name =
   *       AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]").toString();
   *   AcceleratorType response = tpuClient.getAcceleratorType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AcceleratorType getAcceleratorType(String name) {
    GetAcceleratorTypeRequest request =
        GetAcceleratorTypeRequest.newBuilder().setName(name).build();
    return getAcceleratorType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets AcceleratorType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetAcceleratorTypeRequest request =
   *       GetAcceleratorTypeRequest.newBuilder()
   *           .setName(
   *               AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]")
   *                   .toString())
   *           .build();
   *   AcceleratorType response = tpuClient.getAcceleratorType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AcceleratorType getAcceleratorType(GetAcceleratorTypeRequest request) {
    return getAcceleratorTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets AcceleratorType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetAcceleratorTypeRequest request =
   *       GetAcceleratorTypeRequest.newBuilder()
   *           .setName(
   *               AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AcceleratorType> future =
   *       tpuClient.getAcceleratorTypeCallable().futureCall(request);
   *   // Do something.
   *   AcceleratorType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeCallable() {
    return stub.getAcceleratorTypeCallable();
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
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : tpuClient.listLocations(request).iterateAll()) {
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
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = tpuClient.listLocationsPagedCallable().futureCall(request);
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
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = tpuClient.listLocationsCallable().call(request);
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
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = tpuClient.getLocation(request);
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
   * try (TpuClient tpuClient = TpuClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = tpuClient.getLocationCallable().futureCall(request);
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

  public static class ListNodesPagedResponse
      extends AbstractPagedListResponse<
          ListNodesRequest, ListNodesResponse, Node, ListNodesPage, ListNodesFixedSizeCollection> {

    public static ApiFuture<ListNodesPagedResponse> createAsync(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ApiFuture<ListNodesResponse> futureResponse) {
      ApiFuture<ListNodesPage> futurePage =
          ListNodesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListNodesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListNodesPagedResponse(ListNodesPage page) {
      super(page, ListNodesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodesPage
      extends AbstractPage<ListNodesRequest, ListNodesResponse, Node, ListNodesPage> {

    private ListNodesPage(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ListNodesResponse response) {
      super(context, response);
    }

    private static ListNodesPage createEmptyPage() {
      return new ListNodesPage(null, null);
    }

    @Override
    protected ListNodesPage createPage(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ListNodesResponse response) {
      return new ListNodesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodesPage> createPageAsync(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ApiFuture<ListNodesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodesRequest, ListNodesResponse, Node, ListNodesPage, ListNodesFixedSizeCollection> {

    private ListNodesFixedSizeCollection(List<ListNodesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodesFixedSizeCollection createEmptyCollection() {
      return new ListNodesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodesFixedSizeCollection createCollection(
        List<ListNodesPage> pages, int collectionSize) {
      return new ListNodesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTensorFlowVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListTensorFlowVersionsRequest,
          ListTensorFlowVersionsResponse,
          TensorFlowVersion,
          ListTensorFlowVersionsPage,
          ListTensorFlowVersionsFixedSizeCollection> {

    public static ApiFuture<ListTensorFlowVersionsPagedResponse> createAsync(
        PageContext<
                ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse, TensorFlowVersion>
            context,
        ApiFuture<ListTensorFlowVersionsResponse> futureResponse) {
      ApiFuture<ListTensorFlowVersionsPage> futurePage =
          ListTensorFlowVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTensorFlowVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTensorFlowVersionsPagedResponse(ListTensorFlowVersionsPage page) {
      super(page, ListTensorFlowVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTensorFlowVersionsPage
      extends AbstractPage<
          ListTensorFlowVersionsRequest,
          ListTensorFlowVersionsResponse,
          TensorFlowVersion,
          ListTensorFlowVersionsPage> {

    private ListTensorFlowVersionsPage(
        PageContext<
                ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse, TensorFlowVersion>
            context,
        ListTensorFlowVersionsResponse response) {
      super(context, response);
    }

    private static ListTensorFlowVersionsPage createEmptyPage() {
      return new ListTensorFlowVersionsPage(null, null);
    }

    @Override
    protected ListTensorFlowVersionsPage createPage(
        PageContext<
                ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse, TensorFlowVersion>
            context,
        ListTensorFlowVersionsResponse response) {
      return new ListTensorFlowVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListTensorFlowVersionsPage> createPageAsync(
        PageContext<
                ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse, TensorFlowVersion>
            context,
        ApiFuture<ListTensorFlowVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTensorFlowVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTensorFlowVersionsRequest,
          ListTensorFlowVersionsResponse,
          TensorFlowVersion,
          ListTensorFlowVersionsPage,
          ListTensorFlowVersionsFixedSizeCollection> {

    private ListTensorFlowVersionsFixedSizeCollection(
        List<ListTensorFlowVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTensorFlowVersionsFixedSizeCollection createEmptyCollection() {
      return new ListTensorFlowVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTensorFlowVersionsFixedSizeCollection createCollection(
        List<ListTensorFlowVersionsPage> pages, int collectionSize) {
      return new ListTensorFlowVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAcceleratorTypesPagedResponse
      extends AbstractPagedListResponse<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          AcceleratorType,
          ListAcceleratorTypesPage,
          ListAcceleratorTypesFixedSizeCollection> {

    public static ApiFuture<ListAcceleratorTypesPagedResponse> createAsync(
        PageContext<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>
            context,
        ApiFuture<ListAcceleratorTypesResponse> futureResponse) {
      ApiFuture<ListAcceleratorTypesPage> futurePage =
          ListAcceleratorTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAcceleratorTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAcceleratorTypesPagedResponse(ListAcceleratorTypesPage page) {
      super(page, ListAcceleratorTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAcceleratorTypesPage
      extends AbstractPage<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          AcceleratorType,
          ListAcceleratorTypesPage> {

    private ListAcceleratorTypesPage(
        PageContext<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>
            context,
        ListAcceleratorTypesResponse response) {
      super(context, response);
    }

    private static ListAcceleratorTypesPage createEmptyPage() {
      return new ListAcceleratorTypesPage(null, null);
    }

    @Override
    protected ListAcceleratorTypesPage createPage(
        PageContext<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>
            context,
        ListAcceleratorTypesResponse response) {
      return new ListAcceleratorTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListAcceleratorTypesPage> createPageAsync(
        PageContext<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse, AcceleratorType>
            context,
        ApiFuture<ListAcceleratorTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAcceleratorTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAcceleratorTypesRequest,
          ListAcceleratorTypesResponse,
          AcceleratorType,
          ListAcceleratorTypesPage,
          ListAcceleratorTypesFixedSizeCollection> {

    private ListAcceleratorTypesFixedSizeCollection(
        List<ListAcceleratorTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAcceleratorTypesFixedSizeCollection createEmptyCollection() {
      return new ListAcceleratorTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAcceleratorTypesFixedSizeCollection createCollection(
        List<ListAcceleratorTypesPage> pages, int collectionSize) {
      return new ListAcceleratorTypesFixedSizeCollection(pages, collectionSize);
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
