/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.LocationName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for creating, configuring, and deleting Cloud Bigtable Instances and
 * Clusters. Provides access to the Instance and Cluster schemas only, not the tables' metadata or
 * data stored in those tables.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
 *   Instance response = bigtableInstanceAdminClient.getInstance(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the bigtableInstanceAdminClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of BigtableInstanceAdminSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * BigtableInstanceAdminSettings bigtableInstanceAdminSettings =
 *     BigtableInstanceAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BigtableInstanceAdminClient bigtableInstanceAdminClient =
 *     BigtableInstanceAdminClient.create(bigtableInstanceAdminSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * BigtableInstanceAdminSettings bigtableInstanceAdminSettings =
 *     BigtableInstanceAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BigtableInstanceAdminClient bigtableInstanceAdminClient =
 *     BigtableInstanceAdminClient.create(bigtableInstanceAdminSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class BigtableInstanceAdminClient implements BackgroundResource {
  private final BigtableInstanceAdminSettings settings;
  private final BigtableInstanceAdminStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of BigtableInstanceAdminClient with default settings. */
  public static final BigtableInstanceAdminClient create() throws IOException {
    return create(BigtableInstanceAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BigtableInstanceAdminClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BigtableInstanceAdminClient create(BigtableInstanceAdminSettings settings)
      throws IOException {
    return new BigtableInstanceAdminClient(settings);
  }

  /**
   * Constructs an instance of BigtableInstanceAdminClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use BigtableInstanceAdminSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BigtableInstanceAdminClient create(BigtableInstanceAdminStub stub) {
    return new BigtableInstanceAdminClient(stub);
  }

  /**
   * Constructs an instance of BigtableInstanceAdminClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BigtableInstanceAdminClient(BigtableInstanceAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = settings.createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BigtableInstanceAdminClient(BigtableInstanceAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final BigtableInstanceAdminSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigtableInstanceAdminStub getStub() {
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
   * Create an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String instanceId = "";
   *   Instance instance = Instance.newBuilder().build();
   *   Map&lt;String, Cluster&gt; clusters = new HashMap&lt;&gt;();
   *   Instance response = bigtableInstanceAdminClient.createInstanceAsync(parent, instanceId, instance, clusters).get();
   * }
   * </code></pre>
   *
   * @param parent The unique name of the project in which to create the new instance. Values are of
   *     the form `projects/&lt;project&gt;`.
   * @param instanceId The ID to be used when referring to the new instance within its project,
   *     e.g., just `myinstance` rather than `projects/myproject/instances/myinstance`.
   * @param instance The instance to create. Fields marked `OutputOnly` must be left blank.
   * @param clusters The clusters to be created within the instance, mapped by desired cluster ID,
   *     e.g., just `mycluster` rather than
   *     `projects/myproject/instances/myinstance/clusters/mycluster`. Fields marked `OutputOnly`
   *     must be left blank. Currently exactly one cluster must be specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, CreateInstanceMetadata> createInstanceAsync(
      ProjectName parent, String instanceId, Instance instance, Map<String, Cluster> clusters) {

    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParentWithProjectName(parent)
            .setInstanceId(instanceId)
            .setInstance(instance)
            .putAllClusters(clusters)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String instanceId = "";
   *   Instance instance = Instance.newBuilder().build();
   *   Map&lt;String, Cluster&gt; clusters = new HashMap&lt;&gt;();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParentWithProjectName(parent)
   *     .setInstanceId(instanceId)
   *     .setInstance(instance)
   *     .putAllClusters(clusters)
   *     .build();
   *   Instance response = bigtableInstanceAdminClient.createInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, CreateInstanceMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String instanceId = "";
   *   Instance instance = Instance.newBuilder().build();
   *   Map&lt;String, Cluster&gt; clusters = new HashMap&lt;&gt;();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParentWithProjectName(parent)
   *     .setInstanceId(instanceId)
   *     .setInstance(instance)
   *     .putAllClusters(clusters)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String instanceId = "";
   *   Instance instance = Instance.newBuilder().build();
   *   Map&lt;String, Cluster&gt; clusters = new HashMap&lt;&gt;();
   *   CreateInstanceRequest request = CreateInstanceRequest.newBuilder()
   *     .setParentWithProjectName(parent)
   *     .setInstanceId(instanceId)
   *     .setInstance(instance)
   *     .putAllClusters(clusters)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.createInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   Instance response = bigtableInstanceAdminClient.getInstance(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested instance. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {

    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setNameWithInstanceName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder()
   *     .setNameWithInstanceName(name)
   *     .build();
   *   Instance response = bigtableInstanceAdminClient.getInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information about an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder()
   *     .setNameWithInstanceName(name)
   *     .build();
   *   ApiFuture&lt;Instance&gt; future = bigtableInstanceAdminClient.getInstanceCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListInstancesResponse response = bigtableInstanceAdminClient.listInstances(parent);
   * }
   * </code></pre>
   *
   * @param parent The unique name of the project for which a list of instances is requested. Values
   *     are of the form `projects/&lt;project&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesResponse listInstances(ProjectName parent) {

    ListInstancesRequest request =
        ListInstancesRequest.newBuilder().setParentWithProjectName(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParentWithProjectName(parent)
   *     .build();
   *   ListInstancesResponse response = bigtableInstanceAdminClient.listInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesResponse listInstances(ListInstancesRequest request) {
    return listInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists information about instances in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListInstancesRequest request = ListInstancesRequest.newBuilder()
   *     .setParentWithProjectName(parent)
   *     .build();
   *   ApiFuture&lt;ListInstancesResponse&gt; future = bigtableInstanceAdminClient.listInstancesCallable().futureCall(request);
   *   // Do something
   *   ListInstancesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String displayName = "";
   *   Instance.Type type = Instance.Type.TYPE_UNSPECIFIED;
   *   Instance response = bigtableInstanceAdminClient.updateInstance(name, displayName, type);
   * }
   * </code></pre>
   *
   * @param name (`OutputOnly`) The unique name of the instance. Values are of the form
   *     `projects/&lt;project&gt;/instances/[a-z][a-z0-9\\-]+[a-z0-9]`.
   * @param displayName The descriptive name for this instance as it appears in UIs. Can be changed
   *     at any time, but should be kept globally unique to avoid confusion.
   * @param type The type of the instance. Defaults to `PRODUCTION`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance updateInstance(InstanceName name, String displayName, Instance.Type type) {

    Instance request =
        Instance.newBuilder()
            .setNameWithInstanceName(name)
            .setDisplayName(displayName)
            .setType(type)
            .build();
    return updateInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String displayName = "";
   *   Instance.Type type = Instance.Type.TYPE_UNSPECIFIED;
   *   Instance request = Instance.newBuilder()
   *     .setNameWithInstanceName(name)
   *     .setDisplayName(displayName)
   *     .setType(type)
   *     .build();
   *   Instance response = bigtableInstanceAdminClient.updateInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance updateInstance(Instance request) {
    return updateInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String displayName = "";
   *   Instance.Type type = Instance.Type.TYPE_UNSPECIFIED;
   *   Instance request = Instance.newBuilder()
   *     .setNameWithInstanceName(name)
   *     .setDisplayName(displayName)
   *     .setType(type)
   *     .build();
   *   ApiFuture&lt;Instance&gt; future = bigtableInstanceAdminClient.updateInstanceCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<Instance, Instance> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   bigtableInstanceAdminClient.deleteInstance(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the instance to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstance(InstanceName name) {

    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setNameWithInstanceName(name).build();
    deleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder()
   *     .setNameWithInstanceName(name)
   *     .build();
   *   bigtableInstanceAdminClient.deleteInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteInstance(DeleteInstanceRequest request) {
    deleteInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Delete an instance from a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder()
   *     .setNameWithInstanceName(name)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = bigtableInstanceAdminClient.deleteInstanceCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String clusterId = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Cluster response = bigtableInstanceAdminClient.createClusterAsync(parent, clusterId, cluster).get();
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance in which to create the new cluster. Values are of
   *     the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param clusterId The ID to be used when referring to the new cluster within its instance, e.g.,
   *     just `mycluster` rather than `projects/myproject/instances/myinstance/clusters/mycluster`.
   * @param cluster The cluster to be created. Fields marked `OutputOnly` must be left blank.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, CreateClusterMetadata> createClusterAsync(
      InstanceName parent, String clusterId, Cluster cluster) {

    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParentWithInstanceName(parent)
            .setClusterId(clusterId)
            .setCluster(cluster)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String clusterId = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .setClusterId(clusterId)
   *     .setCluster(cluster)
   *     .build();
   *   Cluster response = bigtableInstanceAdminClient.createClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, CreateClusterMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String clusterId = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .setClusterId(clusterId)
   *     .setCluster(cluster)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.createClusterOperationCallable().futureCall(request);
   *   // Do something
   *   Cluster response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String clusterId = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .setClusterId(clusterId)
   *     .setCluster(cluster)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.createClusterCallable().futureCall(request);
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
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   Cluster response = bigtableInstanceAdminClient.getCluster(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested cluster. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(ClusterName name) {

    GetClusterRequest request = GetClusterRequest.newBuilder().setNameWithClusterName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setNameWithClusterName(name)
   *     .build();
   *   Cluster response = bigtableInstanceAdminClient.getCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information about a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setNameWithClusterName(name)
   *     .build();
   *   ApiFuture&lt;Cluster&gt; future = bigtableInstanceAdminClient.getClusterCallable().futureCall(request);
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
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListClustersResponse response = bigtableInstanceAdminClient.listClusters(parent);
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance for which a list of clusters is requested. Values
   *     are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`. Use
   *     `&lt;instance&gt; = '-'` to list Clusters for all Instances in a project, e.g.,
   *     `projects/myproject/instances/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(InstanceName parent) {

    ListClustersRequest request =
        ListClustersRequest.newBuilder().setParentWithInstanceName(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .build();
   *   ListClustersResponse response = bigtableInstanceAdminClient.listClusters(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(ListClustersRequest request) {
    return listClustersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists information about clusters in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setParentWithInstanceName(parent)
   *     .build();
   *   ApiFuture&lt;ListClustersResponse&gt; future = bigtableInstanceAdminClient.listClustersCallable().futureCall(request);
   *   // Do something
   *   ListClustersResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   int serveNodes = 0;
   *   StorageType defaultStorageType = StorageType.STORAGE_TYPE_UNSPECIFIED;
   *   Cluster response = bigtableInstanceAdminClient.updateClusterAsync(name, location, serveNodes, defaultStorageType).get();
   * }
   * </code></pre>
   *
   * @param name (`OutputOnly`) The unique name of the cluster. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/[a-z][-a-z0-9]&#42;`.
   * @param location (`CreationOnly`) The location where this cluster's nodes and storage reside.
   *     For best performance, clients should be located as close as possible to this cluster.
   *     Currently only zones are supported, so values should be of the form
   *     `projects/&lt;project&gt;/locations/&lt;zone&gt;`.
   * @param serveNodes The number of nodes allocated to this cluster. More nodes enable higher
   *     throughput and more consistent performance.
   * @param defaultStorageType (`CreationOnly`) The type of storage used by this cluster to serve
   *     its parent instance's tables, unless explicitly overridden.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, UpdateClusterMetadata> updateClusterAsync(
      ClusterName name, LocationName location, int serveNodes, StorageType defaultStorageType) {

    Cluster request =
        Cluster.newBuilder()
            .setNameWithClusterName(name)
            .setLocationWithLocationName(location)
            .setServeNodes(serveNodes)
            .setDefaultStorageType(defaultStorageType)
            .build();
    return updateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   int serveNodes = 0;
   *   StorageType defaultStorageType = StorageType.STORAGE_TYPE_UNSPECIFIED;
   *   Cluster request = Cluster.newBuilder()
   *     .setNameWithClusterName(name)
   *     .setLocationWithLocationName(location)
   *     .setServeNodes(serveNodes)
   *     .setDefaultStorageType(defaultStorageType)
   *     .build();
   *   Cluster response = bigtableInstanceAdminClient.updateClusterAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, UpdateClusterMetadata> updateClusterAsync(Cluster request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   int serveNodes = 0;
   *   StorageType defaultStorageType = StorageType.STORAGE_TYPE_UNSPECIFIED;
   *   Cluster request = Cluster.newBuilder()
   *     .setNameWithClusterName(name)
   *     .setLocationWithLocationName(location)
   *     .setServeNodes(serveNodes)
   *     .setDefaultStorageType(defaultStorageType)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something
   *   Cluster response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a cluster within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   int serveNodes = 0;
   *   StorageType defaultStorageType = StorageType.STORAGE_TYPE_UNSPECIFIED;
   *   Cluster request = Cluster.newBuilder()
   *     .setNameWithClusterName(name)
   *     .setLocationWithLocationName(location)
   *     .setServeNodes(serveNodes)
   *     .setDefaultStorageType(defaultStorageType)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.updateClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<Cluster, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   bigtableInstanceAdminClient.deleteCluster(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the cluster to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCluster(ClusterName name) {

    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setNameWithClusterName(name).build();
    deleteCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setNameWithClusterName(name)
   *     .build();
   *   bigtableInstanceAdminClient.deleteCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteCluster(DeleteClusterRequest request) {
    deleteClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a cluster from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setNameWithClusterName(name)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = bigtableInstanceAdminClient.deleteClusterCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable() {
    return stub.deleteClusterCallable();
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
