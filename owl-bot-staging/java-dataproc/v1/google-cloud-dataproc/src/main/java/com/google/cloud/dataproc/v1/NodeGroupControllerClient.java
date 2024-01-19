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

package com.google.cloud.dataproc.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.stub.NodeGroupControllerStub;
import com.google.cloud.dataproc.v1.stub.NodeGroupControllerStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The `NodeGroupControllerService` provides methods to manage node groups of
 * Compute Engine managed instances.
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
 * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
 *   NodeGroupName name = NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]");
 *   NodeGroup response = nodeGroupControllerClient.getNodeGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NodeGroupControllerClient object to clean up resources
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
 *      <td><p> CreateNodeGroup</td>
 *      <td><p> Creates a node group in a cluster. The returned [Operation.metadata][google.longrunning.Operation.metadata] is [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNodeGroupAsync(CreateNodeGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createNodeGroupAsync(ClusterRegionName parent, NodeGroup nodeGroup, String nodeGroupId)
 *           <li><p> createNodeGroupAsync(String parent, NodeGroup nodeGroup, String nodeGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNodeGroupOperationCallable()
 *           <li><p> createNodeGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResizeNodeGroup</td>
 *      <td><p> Resizes a node group in a cluster. The returned [Operation.metadata][google.longrunning.Operation.metadata] is [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resizeNodeGroupAsync(ResizeNodeGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resizeNodeGroupAsync(String name, int size)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resizeNodeGroupOperationCallable()
 *           <li><p> resizeNodeGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNodeGroup</td>
 *      <td><p> Gets the resource representation for a node group in a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNodeGroup(GetNodeGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNodeGroup(NodeGroupName name)
 *           <li><p> getNodeGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNodeGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of NodeGroupControllerSettings to
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
 * NodeGroupControllerSettings nodeGroupControllerSettings =
 *     NodeGroupControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NodeGroupControllerClient nodeGroupControllerClient =
 *     NodeGroupControllerClient.create(nodeGroupControllerSettings);
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
 * NodeGroupControllerSettings nodeGroupControllerSettings =
 *     NodeGroupControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NodeGroupControllerClient nodeGroupControllerClient =
 *     NodeGroupControllerClient.create(nodeGroupControllerSettings);
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
 * NodeGroupControllerSettings nodeGroupControllerSettings =
 *     NodeGroupControllerSettings.newHttpJsonBuilder().build();
 * NodeGroupControllerClient nodeGroupControllerClient =
 *     NodeGroupControllerClient.create(nodeGroupControllerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NodeGroupControllerClient implements BackgroundResource {
  private final NodeGroupControllerSettings settings;
  private final NodeGroupControllerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of NodeGroupControllerClient with default settings. */
  public static final NodeGroupControllerClient create() throws IOException {
    return create(NodeGroupControllerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NodeGroupControllerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NodeGroupControllerClient create(NodeGroupControllerSettings settings)
      throws IOException {
    return new NodeGroupControllerClient(settings);
  }

  /**
   * Constructs an instance of NodeGroupControllerClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(NodeGroupControllerSettings).
   */
  public static final NodeGroupControllerClient create(NodeGroupControllerStub stub) {
    return new NodeGroupControllerClient(stub);
  }

  /**
   * Constructs an instance of NodeGroupControllerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NodeGroupControllerClient(NodeGroupControllerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NodeGroupControllerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected NodeGroupControllerClient(NodeGroupControllerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final NodeGroupControllerSettings getSettings() {
    return settings;
  }

  public NodeGroupControllerStub getStub() {
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
   * Creates a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   ClusterRegionName parent = ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]");
   *   NodeGroup nodeGroup = NodeGroup.newBuilder().build();
   *   String nodeGroupId = "nodeGroupId1097129880";
   *   NodeGroup response =
   *       nodeGroupControllerClient.createNodeGroupAsync(parent, nodeGroup, nodeGroupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this node group will be created. Format:
   *     `projects/{project}/regions/{region}/clusters/{cluster}`
   * @param nodeGroup Required. The node group to create.
   * @param nodeGroupId Optional. An optional node group ID. Generated if not specified.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens
   *     (-). Cannot begin or end with underscore or hyphen. Must consist of from 3 to 33
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NodeGroup, NodeGroupOperationMetadata> createNodeGroupAsync(
      ClusterRegionName parent, NodeGroup nodeGroup, String nodeGroupId) {
    CreateNodeGroupRequest request =
        CreateNodeGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNodeGroup(nodeGroup)
            .setNodeGroupId(nodeGroupId)
            .build();
    return createNodeGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   String parent = ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]").toString();
   *   NodeGroup nodeGroup = NodeGroup.newBuilder().build();
   *   String nodeGroupId = "nodeGroupId1097129880";
   *   NodeGroup response =
   *       nodeGroupControllerClient.createNodeGroupAsync(parent, nodeGroup, nodeGroupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this node group will be created. Format:
   *     `projects/{project}/regions/{region}/clusters/{cluster}`
   * @param nodeGroup Required. The node group to create.
   * @param nodeGroupId Optional. An optional node group ID. Generated if not specified.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens
   *     (-). Cannot begin or end with underscore or hyphen. Must consist of from 3 to 33
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NodeGroup, NodeGroupOperationMetadata> createNodeGroupAsync(
      String parent, NodeGroup nodeGroup, String nodeGroupId) {
    CreateNodeGroupRequest request =
        CreateNodeGroupRequest.newBuilder()
            .setParent(parent)
            .setNodeGroup(nodeGroup)
            .setNodeGroupId(nodeGroupId)
            .build();
    return createNodeGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   CreateNodeGroupRequest request =
   *       CreateNodeGroupRequest.newBuilder()
   *           .setParent(ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]").toString())
   *           .setNodeGroup(NodeGroup.newBuilder().build())
   *           .setNodeGroupId("nodeGroupId1097129880")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NodeGroup response = nodeGroupControllerClient.createNodeGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NodeGroup, NodeGroupOperationMetadata> createNodeGroupAsync(
      CreateNodeGroupRequest request) {
    return createNodeGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   CreateNodeGroupRequest request =
   *       CreateNodeGroupRequest.newBuilder()
   *           .setParent(ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]").toString())
   *           .setNodeGroup(NodeGroup.newBuilder().build())
   *           .setNodeGroupId("nodeGroupId1097129880")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NodeGroup, NodeGroupOperationMetadata> future =
   *       nodeGroupControllerClient.createNodeGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   NodeGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      createNodeGroupOperationCallable() {
    return stub.createNodeGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   CreateNodeGroupRequest request =
   *       CreateNodeGroupRequest.newBuilder()
   *           .setParent(ClusterRegionName.of("[PROJECT]", "[REGION]", "[CLUSTER]").toString())
   *           .setNodeGroup(NodeGroup.newBuilder().build())
   *           .setNodeGroupId("nodeGroupId1097129880")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       nodeGroupControllerClient.createNodeGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNodeGroupRequest, Operation> createNodeGroupCallable() {
    return stub.createNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   String name = "name3373707";
   *   int size = 3530753;
   *   NodeGroup response = nodeGroupControllerClient.resizeNodeGroupAsync(name, size).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the node group to resize. Format:
   *     `projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{nodeGroup}`
   * @param size Required. The number of running instances for the node group to maintain. The group
   *     adds or removes instances to maintain the number of instances specified by this parameter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NodeGroup, NodeGroupOperationMetadata> resizeNodeGroupAsync(
      String name, int size) {
    ResizeNodeGroupRequest request =
        ResizeNodeGroupRequest.newBuilder().setName(name).setSize(size).build();
    return resizeNodeGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   ResizeNodeGroupRequest request =
   *       ResizeNodeGroupRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSize(3530753)
   *           .setRequestId("requestId693933066")
   *           .setGracefulDecommissionTimeout(Duration.newBuilder().build())
   *           .build();
   *   NodeGroup response = nodeGroupControllerClient.resizeNodeGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NodeGroup, NodeGroupOperationMetadata> resizeNodeGroupAsync(
      ResizeNodeGroupRequest request) {
    return resizeNodeGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   ResizeNodeGroupRequest request =
   *       ResizeNodeGroupRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSize(3530753)
   *           .setRequestId("requestId693933066")
   *           .setGracefulDecommissionTimeout(Duration.newBuilder().build())
   *           .build();
   *   OperationFuture<NodeGroup, NodeGroupOperationMetadata> future =
   *       nodeGroupControllerClient.resizeNodeGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   NodeGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResizeNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      resizeNodeGroupOperationCallable() {
    return stub.resizeNodeGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resizes a node group in a cluster. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] is
   * [NodeGroupOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   ResizeNodeGroupRequest request =
   *       ResizeNodeGroupRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSize(3530753)
   *           .setRequestId("requestId693933066")
   *           .setGracefulDecommissionTimeout(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       nodeGroupControllerClient.resizeNodeGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResizeNodeGroupRequest, Operation> resizeNodeGroupCallable() {
    return stub.resizeNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a node group in a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   NodeGroupName name = NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]");
   *   NodeGroup response = nodeGroupControllerClient.getNodeGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the node group to retrieve. Format:
   *     `projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{nodeGroup}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeGroup getNodeGroup(NodeGroupName name) {
    GetNodeGroupRequest request =
        GetNodeGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a node group in a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   String name =
   *       NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString();
   *   NodeGroup response = nodeGroupControllerClient.getNodeGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the node group to retrieve. Format:
   *     `projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{nodeGroup}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeGroup getNodeGroup(String name) {
    GetNodeGroupRequest request = GetNodeGroupRequest.newBuilder().setName(name).build();
    return getNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a node group in a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   GetNodeGroupRequest request =
   *       GetNodeGroupRequest.newBuilder()
   *           .setName(
   *               NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
   *           .build();
   *   NodeGroup response = nodeGroupControllerClient.getNodeGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeGroup getNodeGroup(GetNodeGroupRequest request) {
    return getNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a node group in a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   GetNodeGroupRequest request =
   *       GetNodeGroupRequest.newBuilder()
   *           .setName(
   *               NodeGroupName.of("[PROJECT]", "[REGION]", "[CLUSTER]", "[NODE_GROUP]").toString())
   *           .build();
   *   ApiFuture<NodeGroup> future =
   *       nodeGroupControllerClient.getNodeGroupCallable().futureCall(request);
   *   // Do something.
   *   NodeGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodeGroupRequest, NodeGroup> getNodeGroupCallable() {
    return stub.getNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = nodeGroupControllerClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       nodeGroupControllerClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = nodeGroupControllerClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       nodeGroupControllerClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = nodeGroupControllerClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupControllerClient nodeGroupControllerClient = NodeGroupControllerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       nodeGroupControllerClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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
