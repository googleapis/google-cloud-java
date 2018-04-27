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
package com.google.cloud.bigtable.admin.v2;

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
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
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
@Generated("by gapic-generator")
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
    this.stub = ((BigtableInstanceAdminStubSettings) settings.getStubSettings()).createStub();
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
            .setParent(parent == null ? null : parent.toString())
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
   *   Instance response = bigtableInstanceAdminClient.createInstanceAsync(parent.toString(), instanceId, instance, clusters).get();
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
      String parent, String instanceId, Instance instance, Map<String, Cluster> clusters) {

    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
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
   *     .setParent(parent.toString())
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
   *     .setParent(parent.toString())
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
   *     .setParent(parent.toString())
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
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
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
   *   Instance response = bigtableInstanceAdminClient.getInstance(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested instance. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {

    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
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
   *     .setName(name.toString())
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
   *     .setName(name.toString())
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
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
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
   *   ListInstancesResponse response = bigtableInstanceAdminClient.listInstances(parent.toString());
   * }
   * </code></pre>
   *
   * @param parent The unique name of the project for which a list of instances is requested. Values
   *     are of the form `projects/&lt;project&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesResponse listInstances(String parent) {

    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
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
   *     .setParent(parent.toString())
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
   *     .setParent(parent.toString())
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
   * Partially updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = bigtableInstanceAdminClient.partialUpdateInstanceAsync(instance, updateMask).get();
   * }
   * </code></pre>
   *
   * @param instance The Instance which will (partially) replace the current value.
   * @param updateMask The subset of Instance fields which should be replaced. Must be explicitly
   *     set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, UpdateInstanceMetadata> partialUpdateInstanceAsync(
      Instance instance, FieldMask updateMask) {

    PartialUpdateInstanceRequest request =
        PartialUpdateInstanceRequest.newBuilder()
            .setInstance(instance)
            .setUpdateMask(updateMask)
            .build();
    return partialUpdateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Partially updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PartialUpdateInstanceRequest request = PartialUpdateInstanceRequest.newBuilder()
   *     .setInstance(instance)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Instance response = bigtableInstanceAdminClient.partialUpdateInstanceAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, UpdateInstanceMetadata> partialUpdateInstanceAsync(
      PartialUpdateInstanceRequest request) {
    return partialUpdateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Partially updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PartialUpdateInstanceRequest request = PartialUpdateInstanceRequest.newBuilder()
   *     .setInstance(instance)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.partialUpdateInstanceOperationCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationCallable() {
    return stub.partialUpdateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Partially updates an instance within a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PartialUpdateInstanceRequest request = PartialUpdateInstanceRequest.newBuilder()
   *     .setInstance(instance)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.partialUpdateInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceCallable() {
    return stub.partialUpdateInstanceCallable();
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
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
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
   *   bigtableInstanceAdminClient.deleteInstance(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the instance to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteInstance(String name) {

    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
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
   *     .setName(name.toString())
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
   *     .setName(name.toString())
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
            .setParent(parent == null ? null : parent.toString())
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
   *   Cluster response = bigtableInstanceAdminClient.createClusterAsync(parent.toString(), clusterId, cluster).get();
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
      String parent, String clusterId, Cluster cluster) {

    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent)
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
   *     .setParent(parent.toString())
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
   *     .setParent(parent.toString())
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
   *     .setParent(parent.toString())
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

    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
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
   *   Cluster response = bigtableInstanceAdminClient.getCluster(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested cluster. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {

    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
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
   *     .setName(name.toString())
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
   *     .setName(name.toString())
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
        ListClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
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
   *   ListClustersResponse response = bigtableInstanceAdminClient.listClusters(parent.toString());
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance for which a list of clusters is requested. Values
   *     are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`. Use
   *     `&lt;instance&gt; = '-'` to list Clusters for all Instances in a project, e.g.,
   *     `projects/myproject/instances/-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(String parent) {

    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
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
   *     .setParent(parent.toString())
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
   *     .setParent(parent.toString())
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
   *   Cluster request = Cluster.newBuilder()
   *     .setName(name.toString())
   *     .setLocation(location.toString())
   *     .setServeNodes(serveNodes)
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
   *   Cluster request = Cluster.newBuilder()
   *     .setName(name.toString())
   *     .setLocation(location.toString())
   *     .setServeNodes(serveNodes)
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
   *   Cluster request = Cluster.newBuilder()
   *     .setName(name.toString())
   *     .setLocation(location.toString())
   *     .setServeNodes(serveNodes)
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
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
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
   *   bigtableInstanceAdminClient.deleteCluster(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the cluster to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/clusters/&lt;cluster&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCluster(String name) {

    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
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
   *     .setName(name.toString())
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
   *     .setName(name.toString())
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String appProfileId = "";
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   AppProfile response = bigtableInstanceAdminClient.createAppProfile(parent, appProfileId, appProfile);
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance in which to create the new app profile. Values
   *     are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param appProfileId The ID to be used when referring to the new app profile within its
   *     instance, e.g., just `myprofile` rather than
   *     `projects/myproject/instances/myinstance/appProfiles/myprofile`.
   * @param appProfile The app profile to be created. Fields marked `OutputOnly` will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile createAppProfile(
      InstanceName parent, String appProfileId, AppProfile appProfile) {

    CreateAppProfileRequest request =
        CreateAppProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppProfileId(appProfileId)
            .setAppProfile(appProfile)
            .build();
    return createAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String appProfileId = "";
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   AppProfile response = bigtableInstanceAdminClient.createAppProfile(parent.toString(), appProfileId, appProfile);
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance in which to create the new app profile. Values
   *     are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param appProfileId The ID to be used when referring to the new app profile within its
   *     instance, e.g., just `myprofile` rather than
   *     `projects/myproject/instances/myinstance/appProfiles/myprofile`.
   * @param appProfile The app profile to be created. Fields marked `OutputOnly` will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile createAppProfile(
      String parent, String appProfileId, AppProfile appProfile) {

    CreateAppProfileRequest request =
        CreateAppProfileRequest.newBuilder()
            .setParent(parent)
            .setAppProfileId(appProfileId)
            .setAppProfile(appProfile)
            .build();
    return createAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String appProfileId = "";
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   CreateAppProfileRequest request = CreateAppProfileRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setAppProfileId(appProfileId)
   *     .setAppProfile(appProfile)
   *     .build();
   *   AppProfile response = bigtableInstanceAdminClient.createAppProfile(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile createAppProfile(CreateAppProfileRequest request) {
    return createAppProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Creates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String appProfileId = "";
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   CreateAppProfileRequest request = CreateAppProfileRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setAppProfileId(appProfileId)
   *     .setAppProfile(appProfile)
   *     .build();
   *   ApiFuture&lt;AppProfile&gt; future = bigtableInstanceAdminClient.createAppProfileCallable().futureCall(request);
   *   // Do something
   *   AppProfile response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateAppProfileRequest, AppProfile> createAppProfileCallable() {
    return stub.createAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   AppProfile response = bigtableInstanceAdminClient.getAppProfile(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested app profile. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/appProfiles/&lt;app_profile&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile getAppProfile(AppProfileName name) {

    GetAppProfileRequest request =
        GetAppProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   AppProfile response = bigtableInstanceAdminClient.getAppProfile(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the requested app profile. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/appProfiles/&lt;app_profile&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppProfile getAppProfile(String name) {

    GetAppProfileRequest request = GetAppProfileRequest.newBuilder().setName(name).build();
    return getAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   GetAppProfileRequest request = GetAppProfileRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   AppProfile response = bigtableInstanceAdminClient.getAppProfile(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final AppProfile getAppProfile(GetAppProfileRequest request) {
    return getAppProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets information about an app profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   GetAppProfileRequest request = GetAppProfileRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;AppProfile&gt; future = bigtableInstanceAdminClient.getAppProfileCallable().futureCall(request);
   *   // Do something
   *   AppProfile response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAppProfileRequest, AppProfile> getAppProfileCallable() {
    return stub.getAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (AppProfile element : bigtableInstanceAdminClient.listAppProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance for which a list of app profiles is requested.
   *     Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppProfilesPagedResponse listAppProfiles(InstanceName parent) {
    ListAppProfilesRequest request =
        ListAppProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAppProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (AppProfile element : bigtableInstanceAdminClient.listAppProfiles(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The unique name of the instance for which a list of app profiles is requested.
   *     Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppProfilesPagedResponse listAppProfiles(String parent) {
    ListAppProfilesRequest request = ListAppProfilesRequest.newBuilder().setParent(parent).build();
    return listAppProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListAppProfilesRequest request = ListAppProfilesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (AppProfile element : bigtableInstanceAdminClient.listAppProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppProfilesPagedResponse listAppProfiles(ListAppProfilesRequest request) {
    return listAppProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListAppProfilesRequest request = ListAppProfilesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListAppProfilesPagedResponse&gt; future = bigtableInstanceAdminClient.listAppProfilesPagedCallable().futureCall(request);
   *   // Do something
   *   for (AppProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAppProfilesRequest, ListAppProfilesPagedResponse>
      listAppProfilesPagedCallable() {
    return stub.listAppProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Lists information about app profiles in an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   ListAppProfilesRequest request = ListAppProfilesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListAppProfilesResponse response = bigtableInstanceAdminClient.listAppProfilesCallable().call(request);
   *     for (AppProfile element : response.getAppProfilesList()) {
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
  public final UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse>
      listAppProfilesCallable() {
    return stub.listAppProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AppProfile response = bigtableInstanceAdminClient.updateAppProfileAsync(appProfile, updateMask).get();
   * }
   * </code></pre>
   *
   * @param appProfile The app profile which will (partially) replace the current value.
   * @param updateMask The subset of app profile fields which should be replaced. If unset, all
   *     fields will be replaced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppProfile, UpdateAppProfileMetadata> updateAppProfileAsync(
      AppProfile appProfile, FieldMask updateMask) {

    UpdateAppProfileRequest request =
        UpdateAppProfileRequest.newBuilder()
            .setAppProfile(appProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateAppProfileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateAppProfileRequest request = UpdateAppProfileRequest.newBuilder()
   *     .setAppProfile(appProfile)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   AppProfile response = bigtableInstanceAdminClient.updateAppProfileAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AppProfile, UpdateAppProfileMetadata> updateAppProfileAsync(
      UpdateAppProfileRequest request) {
    return updateAppProfileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateAppProfileRequest request = UpdateAppProfileRequest.newBuilder()
   *     .setAppProfile(appProfile)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.updateAppProfileOperationCallable().futureCall(request);
   *   // Do something
   *   AppProfile response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationCallable() {
    return stub.updateAppProfileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Updates an app profile within an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfile appProfile = AppProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateAppProfileRequest request = UpdateAppProfileRequest.newBuilder()
   *     .setAppProfile(appProfile)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = bigtableInstanceAdminClient.updateAppProfileCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateAppProfileRequest, Operation> updateAppProfileCallable() {
    return stub.updateAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   bigtableInstanceAdminClient.deleteAppProfile(name);
   * }
   * </code></pre>
   *
   * @param name The unique name of the app profile to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/appProfiles/&lt;app_profile&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(AppProfileName name) {

    DeleteAppProfileRequest request =
        DeleteAppProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   bigtableInstanceAdminClient.deleteAppProfile(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique name of the app profile to be deleted. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/appProfiles/&lt;app_profile&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(String name) {

    DeleteAppProfileRequest request = DeleteAppProfileRequest.newBuilder().setName(name).build();
    deleteAppProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   boolean ignoreWarnings = false;
   *   DeleteAppProfileRequest request = DeleteAppProfileRequest.newBuilder()
   *     .setName(name.toString())
   *     .setIgnoreWarnings(ignoreWarnings)
   *     .build();
   *   bigtableInstanceAdminClient.deleteAppProfile(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppProfile(DeleteAppProfileRequest request) {
    deleteAppProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable replication. This feature is not currently
   * available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Deletes an app profile from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   AppProfileName name = AppProfileName.of("[PROJECT]", "[INSTANCE]", "[APP_PROFILE]");
   *   boolean ignoreWarnings = false;
   *   DeleteAppProfileRequest request = DeleteAppProfileRequest.newBuilder()
   *     .setName(name.toString())
   *     .setIgnoreWarnings(ignoreWarnings)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = bigtableInstanceAdminClient.deleteAppProfileCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteAppProfileRequest, Empty> deleteAppProfileCallable() {
    return stub.deleteAppProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets the access control policy for an instance resource. Returns an empty policy if an
   * instance exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   Policy response = bigtableInstanceAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets the access control policy for an instance resource. Returns an empty policy if an
   * instance exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = bigtableInstanceAdminClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Gets the access control policy for an instance resource. Returns an empty policy if an
   * instance exists but does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = bigtableInstanceAdminClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = bigtableInstanceAdminClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = bigtableInstanceAdminClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Sets the access control policy on an instance resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = bigtableInstanceAdminClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = bigtableInstanceAdminClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = bigtableInstanceAdminClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * This is a private alpha release of Cloud Bigtable instance level permissions. This feature is
   * not currently available to most Cloud Bigtable customers. This feature might be changed in
   * backward-incompatible ways and is not recommended for production use. It is not subject to any
   * SLA or deprecation policy.
   *
   * <p>Returns permissions that the caller has on the specified instance resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
   *   String formattedResource = InstanceName.format("[PROJECT]", "[INSTANCE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = bigtableInstanceAdminClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
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

  public static class ListAppProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListAppProfilesRequest, ListAppProfilesResponse, AppProfile, ListAppProfilesPage,
          ListAppProfilesFixedSizeCollection> {

    public static ApiFuture<ListAppProfilesPagedResponse> createAsync(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ApiFuture<ListAppProfilesResponse> futureResponse) {
      ApiFuture<ListAppProfilesPage> futurePage =
          ListAppProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAppProfilesPage, ListAppProfilesPagedResponse>() {
            @Override
            public ListAppProfilesPagedResponse apply(ListAppProfilesPage input) {
              return new ListAppProfilesPagedResponse(input);
            }
          });
    }

    private ListAppProfilesPagedResponse(ListAppProfilesPage page) {
      super(page, ListAppProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppProfilesPage
      extends AbstractPage<
          ListAppProfilesRequest, ListAppProfilesResponse, AppProfile, ListAppProfilesPage> {

    private ListAppProfilesPage(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ListAppProfilesResponse response) {
      super(context, response);
    }

    private static ListAppProfilesPage createEmptyPage() {
      return new ListAppProfilesPage(null, null);
    }

    @Override
    protected ListAppProfilesPage createPage(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ListAppProfilesResponse response) {
      return new ListAppProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListAppProfilesPage> createPageAsync(
        PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> context,
        ApiFuture<ListAppProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppProfilesRequest, ListAppProfilesResponse, AppProfile, ListAppProfilesPage,
          ListAppProfilesFixedSizeCollection> {

    private ListAppProfilesFixedSizeCollection(
        List<ListAppProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppProfilesFixedSizeCollection createEmptyCollection() {
      return new ListAppProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppProfilesFixedSizeCollection createCollection(
        List<ListAppProfilesPage> pages, int collectionSize) {
      return new ListAppProfilesFixedSizeCollection(pages, collectionSize);
    }
  }
}
