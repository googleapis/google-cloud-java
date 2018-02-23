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
package com.google.cloud.dataproc.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.stub.ClusterControllerStub;
import com.google.cloud.dataproc.v1.stub.ClusterControllerStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The ClusterControllerService provides methods to manage clusters of Google
 * Compute Engine instances.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
 *   String projectId = "";
 *   String region = "";
 *   String clusterName = "";
 *   Cluster response = clusterControllerClient.getCluster(projectId, region, clusterName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the clusterControllerClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ClusterControllerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ClusterControllerSettings clusterControllerSettings =
 *     ClusterControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ClusterControllerClient clusterControllerClient =
 *     ClusterControllerClient.create(clusterControllerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ClusterControllerSettings clusterControllerSettings =
 *     ClusterControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClusterControllerClient clusterControllerClient =
 *     ClusterControllerClient.create(clusterControllerSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class ClusterControllerClient implements BackgroundResource {
  private final ClusterControllerSettings settings;
  private final ClusterControllerStub stub;
  private final OperationsClient operationsClient;

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
   * is for advanced usage - prefer to use ClusterControllerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ClusterControllerClient(ClusterControllerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ClusterControllerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ClusterControllerStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Cluster response = clusterControllerClient.createClusterAsync(projectId, region, cluster).get();
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setCluster(cluster)
   *     .build();
   *   Cluster response = clusterControllerClient.createClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setCluster(cluster)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = clusterControllerClient.createClusterOperationCallable().futureCall(request);
   *   // Do something
   *   Cluster response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, ClusterOperationMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setCluster(cluster)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterControllerClient.createClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .setCluster(cluster)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Cluster response = clusterControllerClient.updateClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, ClusterOperationMetadata> updateClusterAsync(
      UpdateClusterRequest request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .setCluster(cluster)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = clusterControllerClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something
   *   Cluster response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<UpdateClusterRequest, Cluster, ClusterOperationMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .setCluster(cluster)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterControllerClient.updateClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   Empty response = clusterControllerClient.deleteClusterAsync(projectId, region, clusterName).get();
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   Empty response = clusterControllerClient.deleteClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ClusterOperationMetadata> deleteClusterAsync(
      DeleteClusterRequest request) {
    return deleteClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = clusterControllerClient.deleteClusterOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<DeleteClusterRequest, Empty, ClusterOperationMetadata>
      deleteClusterOperationCallable() {
    return stub.deleteClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterControllerClient.deleteClusterCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the resource representation for a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   Cluster response = clusterControllerClient.getCluster(projectId, region, clusterName);
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the resource representation for a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   Cluster response = clusterControllerClient.getCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the resource representation for a cluster in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   ApiFuture&lt;Cluster&gt; future = clusterControllerClient.getClusterCallable().futureCall(request);
   *   // Do something
   *   Cluster response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all regions/{region}/clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   for (Cluster element : clusterControllerClient.listClusters(projectId, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String projectId, String region) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder().setProjectId(projectId).setRegion(region).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all regions/{region}/clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .build();
   *   for (Cluster element : clusterControllerClient.listClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(ListClustersRequest request) {
    return listClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all regions/{region}/clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListClustersPagedResponse&gt; future = clusterControllerClient.listClustersPagedCallable().futureCall(request);
   *   // Do something
   *   for (Cluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable() {
    return stub.listClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all regions/{region}/clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     ListClustersResponse response = clusterControllerClient.listClustersCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets cluster diagnostic information. After the operation completes, the Operation.response
   * field contains `DiagnoseClusterOutputLocation`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   Empty response = clusterControllerClient.diagnoseClusterAsync(projectId, region, clusterName).get();
   * }
   * </code></pre>
   *
   * @param projectId Required. The ID of the Google Cloud Platform project that the cluster belongs
   *     to.
   * @param region Required. The Cloud Dataproc region in which to handle the request.
   * @param clusterName Required. The cluster name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DiagnoseClusterResults> diagnoseClusterAsync(
      String projectId, String region, String clusterName) {

    DiagnoseClusterRequest request =
        DiagnoseClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setRegion(region)
            .setClusterName(clusterName)
            .build();
    return diagnoseClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets cluster diagnostic information. After the operation completes, the Operation.response
   * field contains `DiagnoseClusterOutputLocation`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   DiagnoseClusterRequest request = DiagnoseClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   Empty response = clusterControllerClient.diagnoseClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DiagnoseClusterResults> diagnoseClusterAsync(
      DiagnoseClusterRequest request) {
    return diagnoseClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets cluster diagnostic information. After the operation completes, the Operation.response
   * field contains `DiagnoseClusterOutputLocation`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   DiagnoseClusterRequest request = DiagnoseClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = clusterControllerClient.diagnoseClusterOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<DiagnoseClusterRequest, Empty, DiagnoseClusterResults>
      diagnoseClusterOperationCallable() {
    return stub.diagnoseClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets cluster diagnostic information. After the operation completes, the Operation.response
   * field contains `DiagnoseClusterOutputLocation`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
   *   String projectId = "";
   *   String region = "";
   *   String clusterName = "";
   *   DiagnoseClusterRequest request = DiagnoseClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setRegion(region)
   *     .setClusterName(clusterName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterControllerClient.diagnoseClusterCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DiagnoseClusterRequest, Operation> diagnoseClusterCallable() {
    return stub.diagnoseClusterCallable();
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

  public static class ListClustersPagedResponse
      extends AbstractPagedListResponse<
          ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage,
          ListClustersFixedSizeCollection> {

    public static ApiFuture<ListClustersPagedResponse> createAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      ApiFuture<ListClustersPage> futurePage =
          ListClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListClustersPage, ListClustersPagedResponse>() {
            @Override
            public ListClustersPagedResponse apply(ListClustersPage input) {
              return new ListClustersPagedResponse(input);
            }
          });
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
          ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage,
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
