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
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagerStub;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagerStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
 *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
 *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionInstanceGroupManagerClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * RegionInstanceGroupManagerSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupManagerSettings regionInstanceGroupManagerSettings =
 *     RegionInstanceGroupManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstanceGroupManagerClient regionInstanceGroupManagerClient =
 *     RegionInstanceGroupManagerClient.create(regionInstanceGroupManagerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupManagerSettings regionInstanceGroupManagerSettings =
 *     RegionInstanceGroupManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstanceGroupManagerClient regionInstanceGroupManagerClient =
 *     RegionInstanceGroupManagerClient.create(regionInstanceGroupManagerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionInstanceGroupManagerClient implements BackgroundResource {
  private final RegionInstanceGroupManagerSettings settings;
  private final RegionInstanceGroupManagerStub stub;

  /** Constructs an instance of RegionInstanceGroupManagerClient with default settings. */
  public static final RegionInstanceGroupManagerClient create() throws IOException {
    return create(RegionInstanceGroupManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagerClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionInstanceGroupManagerClient create(
      RegionInstanceGroupManagerSettings settings) throws IOException {
    return new RegionInstanceGroupManagerClient(settings);
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagerClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionInstanceGroupManagerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionInstanceGroupManagerClient create(RegionInstanceGroupManagerStub stub) {
    return new RegionInstanceGroupManagerClient(stub);
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionInstanceGroupManagerClient(RegionInstanceGroupManagerSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstanceGroupManagerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionInstanceGroupManagerClient(RegionInstanceGroupManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstanceGroupManagerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionInstanceGroupManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to remove the specified instances from the managed instance group.
   * Abandoning an instance does not delete the instance, but it does remove the instance from any
   * target pools that are applied by the managed instance group. This method reduces the targetSize
   * of the managed instance group by the number of instances that you abandon. This operation is
   * marked as DONE when the action is scheduled even if the instances have not yet been removed
   * from the group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersAbandonInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager,
      RegionInstanceGroupManagersAbandonInstancesRequest
          regionInstanceGroupManagersAbandonInstancesRequestResource) {

    AbandonInstancesRegionInstanceGroupManagerHttpRequest request =
        AbandonInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setRegionInstanceGroupManagersAbandonInstancesRequestResource(
                regionInstanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to remove the specified instances from the managed instance group.
   * Abandoning an instance does not delete the instance, but it does remove the instance from any
   * target pools that are applied by the managed instance group. This method reduces the targetSize
   * of the managed instance group by the number of instances that you abandon. This operation is
   * marked as DONE when the action is scheduled even if the instances have not yet been removed
   * from the group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManager(instanceGroupManager.toString(), regionInstanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersAbandonInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesRegionInstanceGroupManager(
      String instanceGroupManager,
      RegionInstanceGroupManagersAbandonInstancesRequest
          regionInstanceGroupManagersAbandonInstancesRequestResource) {

    AbandonInstancesRegionInstanceGroupManagerHttpRequest request =
        AbandonInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersAbandonInstancesRequestResource(
                regionInstanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to remove the specified instances from the managed instance group.
   * Abandoning an instance does not delete the instance, but it does remove the instance from any
   * target pools that are applied by the managed instance group. This method reduces the targetSize
   * of the managed instance group by the number of instances that you abandon. This operation is
   * marked as DONE when the action is scheduled even if the instances have not yet been removed
   * from the group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesRegionInstanceGroupManagerHttpRequest request = AbandonInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersAbandonInstancesRequestResource(regionInstanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesRegionInstanceGroupManager(
      AbandonInstancesRegionInstanceGroupManagerHttpRequest request) {
    return abandonInstancesRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to remove the specified instances from the managed instance group.
   * Abandoning an instance does not delete the instance, but it does remove the instance from any
   * target pools that are applied by the managed instance group. This method reduces the targetSize
   * of the managed instance group by the number of instances that you abandon. This operation is
   * marked as DONE when the action is scheduled even if the instances have not yet been removed
   * from the group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesRegionInstanceGroupManagerHttpRequest request = AbandonInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersAbandonInstancesRequestResource(regionInstanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.abandonInstancesRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AbandonInstancesRegionInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesRegionInstanceGroupManagerCallable() {
    return stub.abandonInstancesRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = regionInstanceGroupManagerClient.deleteRegionInstanceGroupManager(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager) {

    DeleteRegionInstanceGroupManagerHttpRequest request =
        DeleteRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return deleteRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = regionInstanceGroupManagerClient.deleteRegionInstanceGroupManager(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionInstanceGroupManager(String instanceGroupManager) {

    DeleteRegionInstanceGroupManagerHttpRequest request =
        DeleteRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return deleteRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   DeleteRegionInstanceGroupManagerHttpRequest request = DeleteRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.deleteRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionInstanceGroupManager(
      DeleteRegionInstanceGroupManagerHttpRequest request) {
    return deleteRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   DeleteRegionInstanceGroupManagerHttpRequest request = DeleteRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.deleteRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionInstanceGroupManagerHttpRequest, Operation>
      deleteRegionInstanceGroupManagerCallable() {
    return stub.deleteRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to delete the specified instances in the managed instance group. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.deleteInstancesRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersDeleteInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager,
      RegionInstanceGroupManagersDeleteInstancesRequest
          regionInstanceGroupManagersDeleteInstancesRequestResource) {

    DeleteInstancesRegionInstanceGroupManagerHttpRequest request =
        DeleteInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setRegionInstanceGroupManagersDeleteInstancesRequestResource(
                regionInstanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to delete the specified instances in the managed instance group. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.deleteInstancesRegionInstanceGroupManager(instanceGroupManager.toString(), regionInstanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersDeleteInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesRegionInstanceGroupManager(
      String instanceGroupManager,
      RegionInstanceGroupManagersDeleteInstancesRequest
          regionInstanceGroupManagersDeleteInstancesRequestResource) {

    DeleteInstancesRegionInstanceGroupManagerHttpRequest request =
        DeleteInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersDeleteInstancesRequestResource(
                regionInstanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to delete the specified instances in the managed instance group. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesRegionInstanceGroupManagerHttpRequest request = DeleteInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersDeleteInstancesRequestResource(regionInstanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.deleteInstancesRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesRegionInstanceGroupManager(
      DeleteInstancesRegionInstanceGroupManagerHttpRequest request) {
    return deleteInstancesRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to delete the specified instances in the managed instance group. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesRegionInstanceGroupManagerHttpRequest request = DeleteInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersDeleteInstancesRequestResource(regionInstanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.deleteInstancesRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstancesRegionInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesRegionInstanceGroupManagerCallable() {
    return stub.deleteInstancesRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager response = regionInstanceGroupManagerClient.getRegionInstanceGroupManager(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager) {

    GetRegionInstanceGroupManagerHttpRequest request =
        GetRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return getRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager response = regionInstanceGroupManagerClient.getRegionInstanceGroupManager(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getRegionInstanceGroupManager(String instanceGroupManager) {

    GetRegionInstanceGroupManagerHttpRequest request =
        GetRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return getRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   GetRegionInstanceGroupManagerHttpRequest request = GetRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   InstanceGroupManager response = regionInstanceGroupManagerClient.getRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getRegionInstanceGroupManager(
      GetRegionInstanceGroupManagerHttpRequest request) {
    return getRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   GetRegionInstanceGroupManagerHttpRequest request = GetRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;InstanceGroupManager&gt; future = regionInstanceGroupManagerClient.getRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   InstanceGroupManager response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getRegionInstanceGroupManagerCallable() {
    return stub.getRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, it schedules an action to create instances in the group using the
   * specified instance template. This operation is marked as DONE when the group is created even if
   * the instances in the group have not yet been created. You must separately verify the status of
   * the individual instances with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.insertRegionInstanceGroupManager(region, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param instanceGroupManagerResource An Instance Group Manager resource. (== resource_for
   *     beta.instanceGroupManagers ==) (== resource_for v1.instanceGroupManagers ==) (==
   *     resource_for beta.regionInstanceGroupManagers ==) (== resource_for
   *     v1.regionInstanceGroupManagers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionInstanceGroupManager(
      ProjectRegionName region, InstanceGroupManager instanceGroupManagerResource) {

    InsertRegionInstanceGroupManagerHttpRequest request =
        InsertRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, it schedules an action to create instances in the group using the
   * specified instance template. This operation is marked as DONE when the group is created even if
   * the instances in the group have not yet been created. You must separately verify the status of
   * the individual instances with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.insertRegionInstanceGroupManager(region.toString(), instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param instanceGroupManagerResource An Instance Group Manager resource. (== resource_for
   *     beta.instanceGroupManagers ==) (== resource_for v1.instanceGroupManagers ==) (==
   *     resource_for beta.regionInstanceGroupManagers ==) (== resource_for
   *     v1.regionInstanceGroupManagers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionInstanceGroupManager(
      String region, InstanceGroupManager instanceGroupManagerResource) {

    InsertRegionInstanceGroupManagerHttpRequest request =
        InsertRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setRegion(region)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, it schedules an action to create instances in the group using the
   * specified instance template. This operation is marked as DONE when the group is created even if
   * the instances in the group have not yet been created. You must separately verify the status of
   * the individual instances with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   InsertRegionInstanceGroupManagerHttpRequest request = InsertRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.insertRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionInstanceGroupManager(
      InsertRegionInstanceGroupManagerHttpRequest request) {
    return insertRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, it schedules an action to create instances in the group using the
   * specified instance template. This operation is marked as DONE when the group is created even if
   * the instances in the group have not yet been created. You must separately verify the status of
   * the individual instances with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   InsertRegionInstanceGroupManagerHttpRequest request = InsertRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.insertRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionInstanceGroupManagerHttpRequest, Operation>
      insertRegionInstanceGroupManagerCallable() {
    return stub.insertRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (InstanceGroupManager element : regionInstanceGroupManagerClient.listRegionInstanceGroupManagers(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionInstanceGroupManagersPagedResponse listRegionInstanceGroupManagers(
      ProjectRegionName region) {
    ListRegionInstanceGroupManagersHttpRequest request =
        ListRegionInstanceGroupManagersHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (InstanceGroupManager element : regionInstanceGroupManagerClient.listRegionInstanceGroupManagers(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionInstanceGroupManagersPagedResponse listRegionInstanceGroupManagers(
      String region) {
    ListRegionInstanceGroupManagersHttpRequest request =
        ListRegionInstanceGroupManagersHttpRequest.newBuilder().setRegion(region).build();
    return listRegionInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionInstanceGroupManagersHttpRequest request = ListRegionInstanceGroupManagersHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (InstanceGroupManager element : regionInstanceGroupManagerClient.listRegionInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionInstanceGroupManagersPagedResponse listRegionInstanceGroupManagers(
      ListRegionInstanceGroupManagersHttpRequest request) {
    return listRegionInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionInstanceGroupManagersHttpRequest request = ListRegionInstanceGroupManagersHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListRegionInstanceGroupManagersPagedResponse&gt; future = regionInstanceGroupManagerClient.listRegionInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManager element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionInstanceGroupManagersHttpRequest, ListRegionInstanceGroupManagersPagedResponse>
      listRegionInstanceGroupManagersPagedCallable() {
    return stub.listRegionInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionInstanceGroupManagersHttpRequest request = ListRegionInstanceGroupManagersHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupManagerList response = regionInstanceGroupManagerClient.listRegionInstanceGroupManagersCallable().call(request);
   *     for (InstanceGroupManager element : response.getItemsList()) {
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
  @BetaApi
  public final UnaryCallable<
          ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList>
      listRegionInstanceGroupManagersCallable() {
    return stub.listRegionInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersListInstancesResponse response = regionInstanceGroupManagerClient.listManagedInstancesRegionInstanceGroupManagers(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final RegionInstanceGroupManagersListInstancesResponse
      listManagedInstancesRegionInstanceGroupManagers(
          ProjectRegionInstanceGroupManagerName instanceGroupManager) {

    ListManagedInstancesRegionInstanceGroupManagersHttpRequest request =
        ListManagedInstancesRegionInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return listManagedInstancesRegionInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersListInstancesResponse response = regionInstanceGroupManagerClient.listManagedInstancesRegionInstanceGroupManagers(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final RegionInstanceGroupManagersListInstancesResponse
      listManagedInstancesRegionInstanceGroupManagers(String instanceGroupManager) {

    ListManagedInstancesRegionInstanceGroupManagersHttpRequest request =
        ListManagedInstancesRegionInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listManagedInstancesRegionInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesRegionInstanceGroupManagersHttpRequest request = ListManagedInstancesRegionInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   RegionInstanceGroupManagersListInstancesResponse response = regionInstanceGroupManagerClient.listManagedInstancesRegionInstanceGroupManagers(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final RegionInstanceGroupManagersListInstancesResponse
      listManagedInstancesRegionInstanceGroupManagers(
          ListManagedInstancesRegionInstanceGroupManagersHttpRequest request) {
    return listManagedInstancesRegionInstanceGroupManagersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesRegionInstanceGroupManagersHttpRequest request = ListManagedInstancesRegionInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;RegionInstanceGroupManagersListInstancesResponse&gt; future = regionInstanceGroupManagerClient.listManagedInstancesRegionInstanceGroupManagersCallable().futureCall(request);
   *   // Do something
   *   RegionInstanceGroupManagersListInstancesResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersHttpRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesRegionInstanceGroupManagersCallable() {
    return stub.listManagedInstancesRegionInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to recreate the specified instances in the managed instance group. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the action is scheduled even if the
   * instances have not yet been recreated. You must separately verify the status of the recreating
   * action with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.recreateInstancesRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersRecreateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersRecreateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager,
      RegionInstanceGroupManagersRecreateRequest
          regionInstanceGroupManagersRecreateRequestResource) {

    RecreateInstancesRegionInstanceGroupManagerHttpRequest request =
        RecreateInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setRegionInstanceGroupManagersRecreateRequestResource(
                regionInstanceGroupManagersRecreateRequestResource)
            .build();
    return recreateInstancesRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to recreate the specified instances in the managed instance group. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the action is scheduled even if the
   * instances have not yet been recreated. You must separately verify the status of the recreating
   * action with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.recreateInstancesRegionInstanceGroupManager(instanceGroupManager.toString(), regionInstanceGroupManagersRecreateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersRecreateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesRegionInstanceGroupManager(
      String instanceGroupManager,
      RegionInstanceGroupManagersRecreateRequest
          regionInstanceGroupManagersRecreateRequestResource) {

    RecreateInstancesRegionInstanceGroupManagerHttpRequest request =
        RecreateInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersRecreateRequestResource(
                regionInstanceGroupManagersRecreateRequestResource)
            .build();
    return recreateInstancesRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to recreate the specified instances in the managed instance group. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the action is scheduled even if the
   * instances have not yet been recreated. You must separately verify the status of the recreating
   * action with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   RecreateInstancesRegionInstanceGroupManagerHttpRequest request = RecreateInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersRecreateRequestResource(regionInstanceGroupManagersRecreateRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.recreateInstancesRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesRegionInstanceGroupManager(
      RecreateInstancesRegionInstanceGroupManagerHttpRequest request) {
    return recreateInstancesRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a group action to recreate the specified instances in the managed instance group. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the action is scheduled even if the
   * instances have not yet been recreated. You must separately verify the status of the recreating
   * action with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   RecreateInstancesRegionInstanceGroupManagerHttpRequest request = RecreateInstancesRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersRecreateRequestResource(regionInstanceGroupManagersRecreateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.recreateInstancesRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RecreateInstancesRegionInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesRegionInstanceGroupManagerCallable() {
    return stub.recreateInstancesRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size for the managed instance group. If you increase the size, the group
   * schedules actions to create new instances using the current instance template. If you decrease
   * the size, the group schedules delete actions on one or more instances. The resize operation is
   * marked DONE when the resize actions are scheduled even if the group has not yet added or
   * deleted any instances. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = regionInstanceGroupManagerClient.resizeRegionInstanceGroupManager(size, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param size Number of instances that should exist in this instance group manager.
   * @param instanceGroupManager Name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeRegionInstanceGroupManager(
      Integer size, ProjectRegionInstanceGroupManagerName instanceGroupManager) {

    ResizeRegionInstanceGroupManagerHttpRequest request =
        ResizeRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setSize(size)
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return resizeRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size for the managed instance group. If you increase the size, the group
   * schedules actions to create new instances using the current instance template. If you decrease
   * the size, the group schedules delete actions on one or more instances. The resize operation is
   * marked DONE when the resize actions are scheduled even if the group has not yet added or
   * deleted any instances. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = regionInstanceGroupManagerClient.resizeRegionInstanceGroupManager(size, instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param size Number of instances that should exist in this instance group manager.
   * @param instanceGroupManager Name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeRegionInstanceGroupManager(
      Integer size, String instanceGroupManager) {

    ResizeRegionInstanceGroupManagerHttpRequest request =
        ResizeRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setSize(size)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return resizeRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size for the managed instance group. If you increase the size, the group
   * schedules actions to create new instances using the current instance template. If you decrease
   * the size, the group schedules delete actions on one or more instances. The resize operation is
   * marked DONE when the resize actions are scheduled even if the group has not yet added or
   * deleted any instances. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   ResizeRegionInstanceGroupManagerHttpRequest request = ResizeRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setSize(size)
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.resizeRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeRegionInstanceGroupManager(
      ResizeRegionInstanceGroupManagerHttpRequest request) {
    return resizeRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size for the managed instance group. If you increase the size, the group
   * schedules actions to create new instances using the current instance template. If you decrease
   * the size, the group schedules delete actions on one or more instances. The resize operation is
   * marked DONE when the resize actions are scheduled even if the group has not yet added or
   * deleted any instances. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   ResizeRegionInstanceGroupManagerHttpRequest request = ResizeRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setSize(size)
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.resizeRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResizeRegionInstanceGroupManagerHttpRequest, Operation>
      resizeRegionInstanceGroupManagerCallable() {
    return stub.resizeRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.setInstanceTemplateRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersSetTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param regionInstanceGroupManagersSetTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager,
      RegionInstanceGroupManagersSetTemplateRequest
          regionInstanceGroupManagersSetTemplateRequestResource) {

    SetInstanceTemplateRegionInstanceGroupManagerHttpRequest request =
        SetInstanceTemplateRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setRegionInstanceGroupManagersSetTemplateRequestResource(
                regionInstanceGroupManagersSetTemplateRequestResource)
            .build();
    return setInstanceTemplateRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.setInstanceTemplateRegionInstanceGroupManager(instanceGroupManager.toString(), regionInstanceGroupManagersSetTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param regionInstanceGroupManagersSetTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateRegionInstanceGroupManager(
      String instanceGroupManager,
      RegionInstanceGroupManagersSetTemplateRequest
          regionInstanceGroupManagersSetTemplateRequestResource) {

    SetInstanceTemplateRegionInstanceGroupManagerHttpRequest request =
        SetInstanceTemplateRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersSetTemplateRequestResource(
                regionInstanceGroupManagersSetTemplateRequestResource)
            .build();
    return setInstanceTemplateRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateRegionInstanceGroupManagerHttpRequest request = SetInstanceTemplateRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersSetTemplateRequestResource(regionInstanceGroupManagersSetTemplateRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.setInstanceTemplateRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateRegionInstanceGroupManager(
      SetInstanceTemplateRegionInstanceGroupManagerHttpRequest request) {
    return setInstanceTemplateRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateRegionInstanceGroupManagerHttpRequest request = SetInstanceTemplateRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersSetTemplateRequestResource(regionInstanceGroupManagersSetTemplateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.setInstanceTemplateRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateRegionInstanceGroupManagerCallable() {
    return stub.setInstanceTemplateRegionInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.setTargetPoolsRegionInstanceGroupManager(instanceGroupManager, regionInstanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersSetTargetPoolsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsRegionInstanceGroupManager(
      ProjectRegionInstanceGroupManagerName instanceGroupManager,
      RegionInstanceGroupManagersSetTargetPoolsRequest
          regionInstanceGroupManagersSetTargetPoolsRequestResource) {

    SetTargetPoolsRegionInstanceGroupManagerHttpRequest request =
        SetTargetPoolsRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(
                regionInstanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagerClient.setTargetPoolsRegionInstanceGroupManager(instanceGroupManager.toString(), regionInstanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersSetTargetPoolsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsRegionInstanceGroupManager(
      String instanceGroupManager,
      RegionInstanceGroupManagersSetTargetPoolsRequest
          regionInstanceGroupManagersSetTargetPoolsRequestResource) {

    SetTargetPoolsRegionInstanceGroupManagerHttpRequest request =
        SetTargetPoolsRegionInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(
                regionInstanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsRegionInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsRegionInstanceGroupManagerHttpRequest request = SetTargetPoolsRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(regionInstanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagerClient.setTargetPoolsRegionInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsRegionInstanceGroupManager(
      SetTargetPoolsRegionInstanceGroupManagerHttpRequest request) {
    return setTargetPoolsRegionInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagerClient regionInstanceGroupManagerClient = RegionInstanceGroupManagerClient.create()) {
   *   ProjectRegionInstanceGroupManagerName instanceGroupManager = ProjectRegionInstanceGroupManagerName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP_MANAGER]");
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsRegionInstanceGroupManagerHttpRequest request = SetTargetPoolsRegionInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(regionInstanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagerClient.setTargetPoolsRegionInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsRegionInstanceGroupManagerCallable() {
    return stub.setTargetPoolsRegionInstanceGroupManagerCallable();
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

  public static class ListRegionInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
          InstanceGroupManager, ListRegionInstanceGroupManagersPage,
          ListRegionInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<ListRegionInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<RegionInstanceGroupManagerList> futureResponse) {
      ApiFuture<ListRegionInstanceGroupManagersPage> futurePage =
          ListRegionInstanceGroupManagersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListRegionInstanceGroupManagersPage, ListRegionInstanceGroupManagersPagedResponse>() {
            @Override
            public ListRegionInstanceGroupManagersPagedResponse apply(
                ListRegionInstanceGroupManagersPage input) {
              return new ListRegionInstanceGroupManagersPagedResponse(input);
            }
          });
    }

    private ListRegionInstanceGroupManagersPagedResponse(ListRegionInstanceGroupManagersPage page) {
      super(page, ListRegionInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionInstanceGroupManagersPage
      extends AbstractPage<
          ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
          InstanceGroupManager, ListRegionInstanceGroupManagersPage> {

    private ListRegionInstanceGroupManagersPage(
        PageContext<
                ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        RegionInstanceGroupManagerList response) {
      super(context, response);
    }

    private static ListRegionInstanceGroupManagersPage createEmptyPage() {
      return new ListRegionInstanceGroupManagersPage(null, null);
    }

    @Override
    protected ListRegionInstanceGroupManagersPage createPage(
        PageContext<
                ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        RegionInstanceGroupManagerList response) {
      return new ListRegionInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionInstanceGroupManagersPage> createPageAsync(
        PageContext<
                ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<RegionInstanceGroupManagerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstanceGroupManagersHttpRequest, RegionInstanceGroupManagerList,
          InstanceGroupManager, ListRegionInstanceGroupManagersPage,
          ListRegionInstanceGroupManagersFixedSizeCollection> {

    private ListRegionInstanceGroupManagersFixedSizeCollection(
        List<ListRegionInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionInstanceGroupManagersFixedSizeCollection createEmptyCollection() {
      return new ListRegionInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionInstanceGroupManagersFixedSizeCollection createCollection(
        List<ListRegionInstanceGroupManagersPage> pages, int collectionSize) {
      return new ListRegionInstanceGroupManagersFixedSizeCollection(pages, collectionSize);
    }
  }
}
