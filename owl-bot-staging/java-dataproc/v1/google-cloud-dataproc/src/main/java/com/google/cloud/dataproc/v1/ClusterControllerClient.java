/*
 * Copyright 2024 Google LLC
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
import com.google.cloud.dataproc.v1.stub.ClusterControllerStub;
import com.google.cloud.dataproc.v1.stub.ClusterControllerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ClusterControllerService provides methods to manage clusters of Compute
 * Engine instances.
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
 * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
 *   String projectId = "projectId-894832108";
 *   String region = "region-934795532";
 *   String clusterName = "clusterName-1141738587";
 *   Cluster response = clusterControllerClient.getCluster(projectId, region, clusterName);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ClusterControllerClient object to clean up resources
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
 *      <td><p> CreateCluster</td>
 *      <td><p> Creates a cluster in a project. The returned [Operation.metadata][google.longrunning.Operation.metadata] will be [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createClusterAsync(CreateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createClusterAsync(String projectId, String region, Cluster cluster)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClusterOperationCallable()
 *           <li><p> createClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCluster</td>
 *      <td><p> Updates a cluster in a project. The returned [Operation.metadata][google.longrunning.Operation.metadata] will be [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata). The cluster must be in a [`RUNNING`][google.cloud.dataproc.v1.ClusterStatus.State] state or an error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(UpdateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(String projectId, String region, String clusterName, Cluster cluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateClusterOperationCallable()
 *           <li><p> updateClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopCluster</td>
 *      <td><p> Stops a cluster in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopClusterAsync(StopClusterRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopClusterOperationCallable()
 *           <li><p> stopClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartCluster</td>
 *      <td><p> Starts a cluster in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startClusterAsync(StartClusterRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startClusterOperationCallable()
 *           <li><p> startClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCluster</td>
 *      <td><p> Deletes a cluster in a project. The returned [Operation.metadata][google.longrunning.Operation.metadata] will be [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(DeleteClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(String projectId, String region, String clusterName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClusterOperationCallable()
 *           <li><p> deleteClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCluster</td>
 *      <td><p> Gets the resource representation for a cluster in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCluster(GetClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCluster(String projectId, String region, String clusterName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListClusters</td>
 *      <td><p> Lists all regions/{region}/clusters in a project alphabetically.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClusters(ListClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClusters(String projectId, String region)
 *           <li><p> listClusters(String projectId, String region, String filter)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClustersPagedCallable()
 *           <li><p> listClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DiagnoseCluster</td>
 *      <td><p> Gets cluster diagnostic information. The returned [Operation.metadata][google.longrunning.Operation.metadata] will be [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata). After the operation completes, [Operation.response][google.longrunning.Operation.response] contains [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> diagnoseClusterAsync(DiagnoseClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> diagnoseClusterAsync(String projectId, String region, String clusterName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> diagnoseClusterOperationCallable()
 *           <li><p> diagnoseClusterCallable()
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
 * <p>This class can be customized by passing in a custom instance of ClusterControllerSettings to
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
 * ClusterControllerSettings clusterControllerSettings =
 *     ClusterControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ClusterControllerClient clusterControllerClient =
 *     ClusterControllerClient.create(clusterControllerSettings);
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
 * ClusterControllerSettings clusterControllerSettings =
 *     ClusterControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClusterControllerClient clusterControllerClient =
 *     ClusterControllerClient.create(clusterControllerSettings);
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
 * ClusterControllerSettings clusterControllerSettings =
 *     ClusterControllerSettings.newHttpJsonBuilder().build();
 * ClusterControllerClient clusterControllerClient =
 *     ClusterControllerClient.create(clusterControllerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ClusterControllerClient implements BackgroundResource {
  private final ClusterControllerSettings settings;
  private final ClusterControllerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ClusterControllerClient with default settings. */
  public static final ClusterControllerClient create() throws IOException {
    return create(ClusterControllerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ClusterControllerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ClusterControllerClient create(ClusterControllerSettings settings)
      throws IOException {
    return new ClusterControllerClient(settings);
  }

  /**
   * Constructs an instance of ClusterControllerClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ClusterControllerSettings).
   */
  public static final ClusterControllerClient create(ClusterControllerStub stub) {
    return new ClusterControllerClient(stub);
  }

  /**
   * Constructs an instance of ClusterControllerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ClusterControllerClient(ClusterControllerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ClusterControllerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ClusterControllerClient(ClusterControllerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ClusterControllerSettings getSettings() {
    return settings;
  }

  public ClusterControllerStub getStub() {
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
   * Creates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Cluster response =
   *       clusterControllerClient.createClusterAsync(projectId, region, cluster).get();
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param cluster Required. The cluster to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> createClusterAsync(
      String projectId, String region, Cluster cluster) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setCluster(cluster)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setActionOnFailedPrimaryWorkers(FailureAction.forNumber(0))
   *           .build();
   *   Cluster response = clusterControllerClient.createClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setActionOnFailedPrimaryWorkers(FailureAction.forNumber(0))
   *           .build();
   *   OperationFuture<Cluster, ClusterOperationMetadata> future =
   *       clusterControllerClient.createClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, ClusterOperationMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setActionOnFailedPrimaryWorkers(FailureAction.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterControllerClient.createClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * The cluster must be in a [`RUNNING`][google.cloud.dataproc.v1.ClusterStatus.State] state or an
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String clusterName = "clusterName-1141738587";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response =
   *       clusterControllerClient
   *           .updateClusterAsync(projectId, region, clusterName, cluster, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project the cluster belongs to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param clusterName Required. The cluster name.
   * @param cluster Required. The changes to the cluster.
   * @param updateMask Required. Specifies the path, relative to `Cluster`, of the field to update.
   *     For example, to change the number of workers in a cluster to 5, the `update_mask` parameter
   *     would be specified as `config.worker_config.num_instances`, and the `PATCH` request body
   *     would specify the new value, as follows:
   *     <p>{ "config":{ "workerConfig":{ "numInstances":"5" } } } Similarly, to change the number
   *     of preemptible workers in a cluster to 5, the `update_mask` parameter would be
   *     `config.secondary_worker_config.num_instances`, and the `PATCH` request body would be set
   *     as follows:
   *     <p>{ "config":{ "secondaryWorkerConfig":{ "numInstances":"5" } } }
   *     &lt;strong&gt;Note:&lt;/strong&gt; Currently, only the following fields can be updated:
   *     <p>&lt;table&gt; &lt;tbody&gt; &lt;tr&gt;
   *     &lt;td&gt;&lt;strong&gt;Mask&lt;/strong&gt;&lt;/td&gt;
   *     &lt;td&gt;&lt;strong&gt;Purpose&lt;/strong&gt;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   *     &lt;td&gt;&lt;strong&gt;&lt;em&gt;labels&lt;/em&gt;&lt;/strong&gt;&lt;/td&gt;
   *     &lt;td&gt;Update labels&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   *     &lt;td&gt;&lt;strong&gt;&lt;em&gt;config.worker_config.num_instances&lt;/em&gt;&lt;/strong&gt;&lt;/td&gt;
   *     &lt;td&gt;Resize primary worker group&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   *     &lt;td&gt;&lt;strong&gt;&lt;em&gt;config.secondary_worker_config.num_instances&lt;/em&gt;&lt;/strong&gt;&lt;/td&gt;
   *     &lt;td&gt;Resize secondary worker group&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
   *     &lt;td&gt;config.autoscaling_config.policy_uri&lt;/td&gt;&lt;td&gt;Use, stop using, or
   *     change autoscaling policies&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> updateClusterAsync(
      String projectId, String region, String clusterName, Cluster cluster, FieldMask updateMask) {
    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setClusterName(clusterName)
            .setCluster(cluster)
            .setUpdateMask(updateMask)
            .build();
    return updateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * The cluster must be in a [`RUNNING`][google.cloud.dataproc.v1.ClusterStatus.State] state or an
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setGracefulDecommissionTimeout(Duration.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = clusterControllerClient.updateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> updateClusterAsync(
      UpdateClusterRequest request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * The cluster must be in a [`RUNNING`][google.cloud.dataproc.v1.ClusterStatus.State] state or an
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setGracefulDecommissionTimeout(Duration.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, ClusterOperationMetadata> future =
   *       clusterControllerClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateClusterRequest, Cluster, ClusterOperationMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * The cluster must be in a [`RUNNING`][google.cloud.dataproc.v1.ClusterStatus.State] state or an
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setGracefulDecommissionTimeout(Duration.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterControllerClient.updateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   StopClusterRequest request =
   *       StopClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = clusterControllerClient.stopClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> stopClusterAsync(
      StopClusterRequest request) {
    return stopClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   StopClusterRequest request =
   *       StopClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, ClusterOperationMetadata> future =
   *       clusterControllerClient.stopClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopClusterRequest, Cluster, ClusterOperationMetadata>
      stopClusterOperationCallable() {
    return stub.stopClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   StopClusterRequest request =
   *       StopClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterControllerClient.stopClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopClusterRequest, Operation> stopClusterCallable() {
    return stub.stopClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   StartClusterRequest request =
   *       StartClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = clusterControllerClient.startClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> startClusterAsync(
      StartClusterRequest request) {
    return startClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   StartClusterRequest request =
   *       StartClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, ClusterOperationMetadata> future =
   *       clusterControllerClient.startClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartClusterRequest, Cluster, ClusterOperationMetadata>
      startClusterOperationCallable() {
    return stub.startClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   StartClusterRequest request =
   *       StartClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterControllerClient.startClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartClusterRequest, Operation> startClusterCallable() {
    return stub.startClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String clusterName = "clusterName-1141738587";
   *   clusterControllerClient.deleteClusterAsync(projectId, region, clusterName).get();
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param clusterName Required. The cluster name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClusterOperationMetadata> deleteClusterAsync(
      String projectId, String region, String clusterName) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setClusterName(clusterName)
            .build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   clusterControllerClient.deleteClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClusterOperationMetadata> deleteClusterAsync(
      DeleteClusterRequest request) {
    return deleteClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, ClusterOperationMetadata> future =
   *       clusterControllerClient.deleteClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClusterRequest, Empty, ClusterOperationMetadata>
      deleteClusterOperationCallable() {
    return stub.deleteClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a cluster in a project. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setClusterUuid("clusterUuid-1141510955")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterControllerClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String clusterName = "clusterName-1141738587";
   *   Cluster response = clusterControllerClient.getCluster(projectId, region, clusterName);
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param clusterName Required. The cluster name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String projectId, String region, String clusterName) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setClusterName(clusterName)
            .build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .build();
   *   Cluster response = clusterControllerClient.getCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the resource representation for a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .build();
   *   ApiFuture<Cluster> future = clusterControllerClient.getClusterCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all regions/{region}/clusters in a project alphabetically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   for (Cluster element : clusterControllerClient.listClusters(projectId, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String projectId, String region) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder().setProjectId(projectId).setRegion(region).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all regions/{region}/clusters in a project alphabetically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String filter = "filter-1274492040";
   *   for (Cluster element :
   *       clusterControllerClient.listClusters(projectId, region, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param filter Optional. A filter constraining the clusters to list. Filters are case-sensitive
   *     and have the following syntax:
   *     <p>field = value [AND [field = value]] ...
   *     <p>where &#42;&#42;field&#42;&#42; is one of `status.state`, `clusterName`, or
   *     `labels.[KEY]`, and `[KEY]` is a label key. &#42;&#42;value&#42;&#42; can be `&#42;` to
   *     match all values. `status.state` can be one of the following: `ACTIVE`, `INACTIVE`,
   *     `CREATING`, `RUNNING`, `ERROR`, `DELETING`, or `UPDATING`. `ACTIVE` contains the
   *     `CREATING`, `UPDATING`, and `RUNNING` states. `INACTIVE` contains the `DELETING` and
   *     `ERROR` states. `clusterName` is the name of the cluster provided at creation time. Only
   *     the logical `AND` operator is supported; space-separated items are treated as having an
   *     implicit `AND` operator.
   *     <p>Example filter:
   *     <p>status.state = ACTIVE AND clusterName = mycluster AND labels.env = staging AND
   *     labels.starred = &#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(
      String projectId, String region, String filter) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setFilter(filter)
            .build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all regions/{region}/clusters in a project alphabetically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Cluster element : clusterControllerClient.listClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(ListClustersRequest request) {
    return listClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all regions/{region}/clusters in a project alphabetically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Cluster> future =
   *       clusterControllerClient.listClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Cluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable() {
    return stub.listClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all regions/{region}/clusters in a project alphabetically.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListClustersResponse response =
   *         clusterControllerClient.listClustersCallable().call(request);
   *     for (Cluster element : response.getClustersList()) {
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
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cluster diagnostic information. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * After the operation completes, [Operation.response][google.longrunning.Operation.response]
   * contains
   * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String region = "region-934795532";
   *   String clusterName = "clusterName-1141738587";
   *   DiagnoseClusterResults response =
   *       clusterControllerClient.diagnoseClusterAsync(projectId, region, clusterName).get();
   * }
   * }</pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Dataproc region in which to handle the request.
   * @param clusterName Required. The cluster name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiagnoseClusterResults, ClusterOperationMetadata>
      diagnoseClusterAsync(String projectId, String region, String clusterName) {
    DiagnoseClusterRequest request =
        DiagnoseClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setClusterName(clusterName)
            .build();
    return diagnoseClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cluster diagnostic information. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * After the operation completes, [Operation.response][google.longrunning.Operation.response]
   * contains
   * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   DiagnoseClusterRequest request =
   *       DiagnoseClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setTarballGcsDir("tarballGcsDir-1602093510")
   *           .setDiagnosisInterval(Interval.newBuilder().build())
   *           .addAllJobs(new ArrayList<String>())
   *           .addAllYarnApplicationIds(new ArrayList<String>())
   *           .build();
   *   DiagnoseClusterResults response = clusterControllerClient.diagnoseClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiagnoseClusterResults, ClusterOperationMetadata>
      diagnoseClusterAsync(DiagnoseClusterRequest request) {
    return diagnoseClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cluster diagnostic information. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * After the operation completes, [Operation.response][google.longrunning.Operation.response]
   * contains
   * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   DiagnoseClusterRequest request =
   *       DiagnoseClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setTarballGcsDir("tarballGcsDir-1602093510")
   *           .setDiagnosisInterval(Interval.newBuilder().build())
   *           .addAllJobs(new ArrayList<String>())
   *           .addAllYarnApplicationIds(new ArrayList<String>())
   *           .build();
   *   OperationFuture<DiagnoseClusterResults, ClusterOperationMetadata> future =
   *       clusterControllerClient.diagnoseClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   DiagnoseClusterResults response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DiagnoseClusterRequest, DiagnoseClusterResults, ClusterOperationMetadata>
      diagnoseClusterOperationCallable() {
    return stub.diagnoseClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cluster diagnostic information. The returned
   * [Operation.metadata][google.longrunning.Operation.metadata] will be
   * [ClusterOperationMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
   * After the operation completes, [Operation.response][google.longrunning.Operation.response]
   * contains
   * [DiagnoseClusterResults](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   DiagnoseClusterRequest request =
   *       DiagnoseClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setRegion("region-934795532")
   *           .setClusterName("clusterName-1141738587")
   *           .setTarballGcsDir("tarballGcsDir-1602093510")
   *           .setDiagnosisInterval(Interval.newBuilder().build())
   *           .addAllJobs(new ArrayList<String>())
   *           .addAllYarnApplicationIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterControllerClient.diagnoseClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiagnoseClusterRequest, Operation> diagnoseClusterCallable() {
    return stub.diagnoseClusterCallable();
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
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = clusterControllerClient.setIamPolicy(request);
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
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = clusterControllerClient.setIamPolicyCallable().futureCall(request);
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
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = clusterControllerClient.getIamPolicy(request);
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
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = clusterControllerClient.getIamPolicyCallable().futureCall(request);
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
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = clusterControllerClient.testIamPermissions(request);
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
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       clusterControllerClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListClustersPagedResponse
      extends AbstractPagedListResponse<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    public static ApiFuture<ListClustersPagedResponse> createAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      ApiFuture<ListClustersPage> futurePage =
          ListClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClustersPagedResponse(ListClustersPage page) {
      super(page, ListClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClustersPage
      extends AbstractPage<ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage> {

    private ListClustersPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      super(context, response);
    }

    private static ListClustersPage createEmptyPage() {
      return new ListClustersPage(null, null);
    }

    @Override
    protected ListClustersPage createPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      return new ListClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListClustersPage> createPageAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    private ListClustersFixedSizeCollection(List<ListClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClustersFixedSizeCollection createEmptyCollection() {
      return new ListClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClustersFixedSizeCollection createCollection(
        List<ListClustersPage> pages, int collectionSize) {
      return new ListClustersFixedSizeCollection(pages, collectionSize);
    }
  }
}
