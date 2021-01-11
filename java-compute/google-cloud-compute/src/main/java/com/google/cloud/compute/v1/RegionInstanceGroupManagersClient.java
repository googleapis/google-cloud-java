/*
 * Copyright 2020 Google LLC
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
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagersStub;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionInstanceGroupManagers API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String instanceGroupManager = "";
 *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = regionInstanceGroupManagersClient.abandonInstances(project, region, instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionInstanceGroupManagersClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * RegionInstanceGroupManagersSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupManagersSettings regionInstanceGroupManagersSettings =
 *     RegionInstanceGroupManagersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstanceGroupManagersClient regionInstanceGroupManagersClient =
 *     RegionInstanceGroupManagersClient.create(regionInstanceGroupManagersSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupManagersSettings regionInstanceGroupManagersSettings =
 *     RegionInstanceGroupManagersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstanceGroupManagersClient regionInstanceGroupManagersClient =
 *     RegionInstanceGroupManagersClient.create(regionInstanceGroupManagersSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionInstanceGroupManagersClient implements BackgroundResource {
  private final RegionInstanceGroupManagersSettings settings;
  private final RegionInstanceGroupManagersStub stub;

  /** Constructs an instance of RegionInstanceGroupManagersClient with default settings. */
  public static final RegionInstanceGroupManagersClient create() throws IOException {
    return create(RegionInstanceGroupManagersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagersClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionInstanceGroupManagersClient create(
      RegionInstanceGroupManagersSettings settings) throws IOException {
    return new RegionInstanceGroupManagersClient(settings);
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagersClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionInstanceGroupManagersSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionInstanceGroupManagersClient create(
      RegionInstanceGroupManagersStub stub) {
    return new RegionInstanceGroupManagersClient(stub);
  }

  /**
   * Constructs an instance of RegionInstanceGroupManagersClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionInstanceGroupManagersClient(RegionInstanceGroupManagersSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstanceGroupManagersStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionInstanceGroupManagersClient(RegionInstanceGroupManagersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstanceGroupManagersSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionInstanceGroupManagersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be immediately removed from the managed instance group.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.abandonInstances(project, region, instanceGroupManager, regionInstanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersAbandonInstancesRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation abandonInstances(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersAbandonInstancesRequest
          regionInstanceGroupManagersAbandonInstancesRequestResource) {
    AbandonInstancesRegionInstanceGroupManagerRequest request =
        AbandonInstancesRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersAbandonInstancesRequestResource(
                regionInstanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be immediately removed from the managed instance group.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesRegionInstanceGroupManagerRequest request = AbandonInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersAbandonInstancesRequestResource(regionInstanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.abandonInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation abandonInstances(
      AbandonInstancesRegionInstanceGroupManagerRequest request) {
    return abandonInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be immediately removed from the managed instance group.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersAbandonInstancesRequest regionInstanceGroupManagersAbandonInstancesRequestResource = RegionInstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesRegionInstanceGroupManagerRequest request = AbandonInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersAbandonInstancesRequestResource(regionInstanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.abandonInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return stub.abandonInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Apply updates to selected instances the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersApplyUpdatesRequest regionInstanceGroupManagersApplyUpdatesRequestResource = RegionInstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.applyUpdatesToInstances(project, region, instanceGroupManager, regionInstanceGroupManagersApplyUpdatesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request, should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group, should conform to RFC1035.
   * @param regionInstanceGroupManagersApplyUpdatesRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation applyUpdatesToInstances(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersApplyUpdatesRequest
          regionInstanceGroupManagersApplyUpdatesRequestResource) {
    ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request =
        ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersApplyUpdatesRequestResource(
                regionInstanceGroupManagersApplyUpdatesRequestResource)
            .build();
    return applyUpdatesToInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Apply updates to selected instances the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersApplyUpdatesRequest regionInstanceGroupManagersApplyUpdatesRequestResource = RegionInstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request = ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersApplyUpdatesRequestResource(regionInstanceGroupManagersApplyUpdatesRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.applyUpdatesToInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation applyUpdatesToInstances(
      ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request) {
    return applyUpdatesToInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Apply updates to selected instances the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersApplyUpdatesRequest regionInstanceGroupManagersApplyUpdatesRequestResource = RegionInstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest request = ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersApplyUpdatesRequestResource(regionInstanceGroupManagersApplyUpdatesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.applyUpdatesToInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return stub.applyUpdatesToInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this regional managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersCreateInstancesRequest regionInstanceGroupManagersCreateInstancesRequestResource = RegionInstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.createInstances(project, region, instanceGroupManager, regionInstanceGroupManagersCreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the managed instance group is located. It should
   *     conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param regionInstanceGroupManagersCreateInstancesRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createInstances(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersCreateInstancesRequest
          regionInstanceGroupManagersCreateInstancesRequestResource) {
    CreateInstancesRegionInstanceGroupManagerRequest request =
        CreateInstancesRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersCreateInstancesRequestResource(
                regionInstanceGroupManagersCreateInstancesRequestResource)
            .build();
    return createInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this regional managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersCreateInstancesRequest regionInstanceGroupManagersCreateInstancesRequestResource = RegionInstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   CreateInstancesRegionInstanceGroupManagerRequest request = CreateInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersCreateInstancesRequestResource(regionInstanceGroupManagersCreateInstancesRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.createInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createInstances(CreateInstancesRegionInstanceGroupManagerRequest request) {
    return createInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this regional managed instance group. Instances
   * are created using the current instance template. The create instances operation is marked DONE
   * if the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersCreateInstancesRequest regionInstanceGroupManagersCreateInstancesRequestResource = RegionInstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   CreateInstancesRegionInstanceGroupManagerRequest request = CreateInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersCreateInstancesRequestResource(regionInstanceGroupManagersCreateInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.createInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return stub.createInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   Operation response = regionInstanceGroupManagersClient.delete(project, region, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String instanceGroupManager) {
    DeleteRegionInstanceGroupManagerRequest request =
        DeleteRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionInstanceGroupManagerRequest request = DeleteRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionInstanceGroupManagerRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionInstanceGroupManagerRequest request = DeleteRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionInstanceGroupManagerRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately deleted. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. The deleteInstances operation is marked DONE if the deleteInstances request is
   * successful. The underlying actions take additional time. You must separately verify the status
   * of the deleting action with the listmanagedinstances method.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.deleteInstances(project, region, instanceGroupManager, regionInstanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersDeleteInstancesRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteInstances(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersDeleteInstancesRequest
          regionInstanceGroupManagersDeleteInstancesRequestResource) {
    DeleteInstancesRegionInstanceGroupManagerRequest request =
        DeleteInstancesRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersDeleteInstancesRequestResource(
                regionInstanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately deleted. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. The deleteInstances operation is marked DONE if the deleteInstances request is
   * successful. The underlying actions take additional time. You must separately verify the status
   * of the deleting action with the listmanagedinstances method.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesRegionInstanceGroupManagerRequest request = DeleteInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersDeleteInstancesRequestResource(regionInstanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.deleteInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteInstances(DeleteInstancesRegionInstanceGroupManagerRequest request) {
    return deleteInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately deleted. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. The deleteInstances operation is marked DONE if the deleteInstances request is
   * successful. The underlying actions take additional time. You must separately verify the status
   * of the deleting action with the listmanagedinstances method.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersDeleteInstancesRequest regionInstanceGroupManagersDeleteInstancesRequestResource = RegionInstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesRegionInstanceGroupManagerRequest request = DeleteInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersDeleteInstancesRequestResource(regionInstanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.deleteInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    return stub.deleteInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagerDeleteInstanceConfigReq regionInstanceGroupManagerDeleteInstanceConfigReqResource = RegionInstanceGroupManagerDeleteInstanceConfigReq.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.deletePerInstanceConfigs(project, region, instanceGroupManager, regionInstanceGroupManagerDeleteInstanceConfigReqResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request, should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param regionInstanceGroupManagerDeleteInstanceConfigReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deletePerInstanceConfigs(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagerDeleteInstanceConfigReq
          regionInstanceGroupManagerDeleteInstanceConfigReqResource) {
    DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request =
        DeletePerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagerDeleteInstanceConfigReqResource(
                regionInstanceGroupManagerDeleteInstanceConfigReqResource)
            .build();
    return deletePerInstanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagerDeleteInstanceConfigReq regionInstanceGroupManagerDeleteInstanceConfigReqResource = RegionInstanceGroupManagerDeleteInstanceConfigReq.newBuilder().build();
   *   DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request = DeletePerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagerDeleteInstanceConfigReqResource(regionInstanceGroupManagerDeleteInstanceConfigReqResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.deletePerInstanceConfigs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deletePerInstanceConfigs(
      DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
    return deletePerInstanceConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagerDeleteInstanceConfigReq regionInstanceGroupManagerDeleteInstanceConfigReqResource = RegionInstanceGroupManagerDeleteInstanceConfigReq.newBuilder().build();
   *   DeletePerInstanceConfigsRegionInstanceGroupManagerRequest request = DeletePerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagerDeleteInstanceConfigReqResource(regionInstanceGroupManagerDeleteInstanceConfigReqResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.deletePerInstanceConfigsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return stub.deletePerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManager response = regionInstanceGroupManagersClient.get(project, region, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManager get(
      String project, String region, String instanceGroupManager) {
    GetRegionInstanceGroupManagerRequest request =
        GetRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionInstanceGroupManagerRequest request = GetRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   InstanceGroupManager response = regionInstanceGroupManagersClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManager get(GetRegionInstanceGroupManagerRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionInstanceGroupManagerRequest request = GetRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;InstanceGroupManager&gt; future = regionInstanceGroupManagersClient.getCallable().futureCall(request);
   *   // Do something
   *   InstanceGroupManager response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.insert(project, region, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManagerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, InstanceGroupManager instanceGroupManagerResource) {
    InsertRegionInstanceGroupManagerRequest request =
        InsertRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionInstanceGroupManagerRequest request = InsertRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionInstanceGroupManagerRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A regional managed instance group can contain up to 2000 instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionInstanceGroupManagerRequest request = InsertRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionInstanceGroupManagerRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (InstanceGroupManager element : regionInstanceGroupManagersClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionInstanceGroupManagersRequest request =
        ListRegionInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionInstanceGroupManagersRequest request = ListRegionInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (InstanceGroupManager element : regionInstanceGroupManagersClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionInstanceGroupManagersRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionInstanceGroupManagersRequest request = ListRegionInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionInstanceGroupManagersClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManager element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups that are contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionInstanceGroupManagersRequest request = ListRegionInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupManagerList response = regionInstanceGroupManagersClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given regional managed instance group.
   * The filter and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   for (InstanceManagedByIgmError element : regionInstanceGroupManagersClient.listErrors(project, region, instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request. This should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It must be a string that
   *     meets the requirements in RFC1035, or an unsigned long integer: must match regexp pattern:
   *     (?:[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?)|[1-9][0-9]{0,19}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorsPagedResponse listErrors(
      String project, String region, String instanceGroupManager) {
    ListErrorsRegionInstanceGroupManagersRequest request =
        ListErrorsRegionInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given regional managed instance group.
   * The filter and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListErrorsRegionInstanceGroupManagersRequest request = ListErrorsRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (InstanceManagedByIgmError element : regionInstanceGroupManagersClient.listErrors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorsPagedResponse listErrors(
      ListErrorsRegionInstanceGroupManagersRequest request) {
    return listErrorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given regional managed instance group.
   * The filter and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListErrorsRegionInstanceGroupManagersRequest request = ListErrorsRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListErrorsPagedResponse&gt; future = regionInstanceGroupManagersClient.listErrorsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceManagedByIgmError element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListErrorsRegionInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return stub.listErrorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given regional managed instance group.
   * The filter and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListErrorsRegionInstanceGroupManagersRequest request = ListErrorsRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupManagersListErrorsResponse response = regionInstanceGroupManagersClient.listErrorsCallable().call(request);
   *     for (InstanceManagedByIgmError element : response.getItemsList()) {
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
  public final UnaryCallable<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return stub.listErrorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   * The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   for (ManagedInstance element : regionInstanceGroupManagersClient.listManagedInstances(project, region, instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedInstancesPagedResponse listManagedInstances(
      String project, String region, String instanceGroupManager) {
    ListManagedInstancesRegionInstanceGroupManagersRequest request =
        ListManagedInstancesRegionInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listManagedInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   * The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListManagedInstancesRegionInstanceGroupManagersRequest request = ListManagedInstancesRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (ManagedInstance element : regionInstanceGroupManagersClient.listManagedInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedInstancesPagedResponse listManagedInstances(
      ListManagedInstancesRegionInstanceGroupManagersRequest request) {
    return listManagedInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   * The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListManagedInstancesRegionInstanceGroupManagersRequest request = ListManagedInstancesRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListManagedInstancesPagedResponse&gt; future = regionInstanceGroupManagersClient.listManagedInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ManagedInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return stub.listManagedInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the managed instance group and instances that are scheduled to be
   * created. The list includes any current actions that the group has scheduled for its instances.
   * The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListManagedInstancesRegionInstanceGroupManagersRequest request = ListManagedInstancesRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupManagersListInstancesResponse response = regionInstanceGroupManagersClient.listManagedInstancesCallable().call(request);
   *     for (ManagedInstance element : response.getManagedInstancesList()) {
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
  public final UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesCallable() {
    return stub.listManagedInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   for (PerInstanceConfig element : regionInstanceGroupManagersClient.listPerInstanceConfigs(project, region, instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request, should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPerInstanceConfigsPagedResponse listPerInstanceConfigs(
      String project, String region, String instanceGroupManager) {
    ListPerInstanceConfigsRegionInstanceGroupManagersRequest request =
        ListPerInstanceConfigsRegionInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listPerInstanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListPerInstanceConfigsRegionInstanceGroupManagersRequest request = ListPerInstanceConfigsRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (PerInstanceConfig element : regionInstanceGroupManagersClient.listPerInstanceConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPerInstanceConfigsPagedResponse listPerInstanceConfigs(
      ListPerInstanceConfigsRegionInstanceGroupManagersRequest request) {
    return listPerInstanceConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListPerInstanceConfigsRegionInstanceGroupManagersRequest request = ListPerInstanceConfigsRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPerInstanceConfigsPagedResponse&gt; future = regionInstanceGroupManagersClient.listPerInstanceConfigsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PerInstanceConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    return stub.listPerInstanceConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   ListPerInstanceConfigsRegionInstanceGroupManagersRequest request = ListPerInstanceConfigsRegionInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupManagersListInstanceConfigsResp response = regionInstanceGroupManagersClient.listPerInstanceConfigsCallable().call(request);
   *     for (PerInstanceConfig element : response.getItemsList()) {
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
  public final UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return stub.listPerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listmanagedinstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.patch(project, region, instanceGroupManager, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project,
      String region,
      String instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource) {
    PatchRegionInstanceGroupManagerRequest request =
        PatchRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listmanagedinstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionInstanceGroupManagerRequest request = PatchRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchRegionInstanceGroupManagerRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listmanagedinstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   PatchRegionInstanceGroupManagerRequest request = PatchRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchRegionInstanceGroupManagerRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagerPatchInstanceConfigReq regionInstanceGroupManagerPatchInstanceConfigReqResource = RegionInstanceGroupManagerPatchInstanceConfigReq.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.patchPerInstanceConfigs(project, region, instanceGroupManager, regionInstanceGroupManagerPatchInstanceConfigReqResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request, should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param regionInstanceGroupManagerPatchInstanceConfigReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchPerInstanceConfigs(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagerPatchInstanceConfigReq
          regionInstanceGroupManagerPatchInstanceConfigReqResource) {
    PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request =
        PatchPerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagerPatchInstanceConfigReqResource(
                regionInstanceGroupManagerPatchInstanceConfigReqResource)
            .build();
    return patchPerInstanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagerPatchInstanceConfigReq regionInstanceGroupManagerPatchInstanceConfigReqResource = RegionInstanceGroupManagerPatchInstanceConfigReq.newBuilder().build();
   *   PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request = PatchPerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagerPatchInstanceConfigReqResource(regionInstanceGroupManagerPatchInstanceConfigReqResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.patchPerInstanceConfigs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchPerInstanceConfigs(
      PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request) {
    return patchPerInstanceConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagerPatchInstanceConfigReq regionInstanceGroupManagerPatchInstanceConfigReqResource = RegionInstanceGroupManagerPatchInstanceConfigReq.newBuilder().build();
   *   PatchPerInstanceConfigsRegionInstanceGroupManagerRequest request = PatchPerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagerPatchInstanceConfigReqResource(regionInstanceGroupManagerPatchInstanceConfigReqResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.patchPerInstanceConfigsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    return stub.patchPerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.recreateInstances(project, region, instanceGroupManager, regionInstanceGroupManagersRecreateRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersRecreateRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation recreateInstances(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersRecreateRequest
          regionInstanceGroupManagersRecreateRequestResource) {
    RecreateInstancesRegionInstanceGroupManagerRequest request =
        RecreateInstancesRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersRecreateRequestResource(
                regionInstanceGroupManagersRecreateRequestResource)
            .build();
    return recreateInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   RecreateInstancesRegionInstanceGroupManagerRequest request = RecreateInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersRecreateRequestResource(regionInstanceGroupManagersRecreateRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.recreateInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation recreateInstances(
      RecreateInstancesRegionInstanceGroupManagerRequest request) {
    return recreateInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
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
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersRecreateRequest regionInstanceGroupManagersRecreateRequestResource = RegionInstanceGroupManagersRecreateRequest.newBuilder().build();
   *   RecreateInstancesRegionInstanceGroupManagerRequest request = RecreateInstancesRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersRecreateRequestResource(regionInstanceGroupManagersRecreateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.recreateInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return stub.recreateInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size of the managed instance group. If you increase the size, the group
   * creates new instances using the current instance template. If you decrease the size, the group
   * deletes one or more instances.
   *
   * <p>The resize operation is marked DONE if the resize request is successful. The underlying
   * actions take additional time. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   int size = 0;
   *   Operation response = regionInstanceGroupManagersClient.resize(project, region, instanceGroupManager, size);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group.
   * @param size Number of instances that should exist in this instance group manager.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(
      String project, String region, String instanceGroupManager, int size) {
    ResizeRegionInstanceGroupManagerRequest request =
        ResizeRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setSize(size)
            .build();
    return resize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size of the managed instance group. If you increase the size, the group
   * creates new instances using the current instance template. If you decrease the size, the group
   * deletes one or more instances.
   *
   * <p>The resize operation is marked DONE if the resize request is successful. The underlying
   * actions take additional time. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   int size = 0;
   *   ResizeRegionInstanceGroupManagerRequest request = ResizeRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSize(size)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.resize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(ResizeRegionInstanceGroupManagerRequest request) {
    return resizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the intended size of the managed instance group. If you increase the size, the group
   * creates new instances using the current instance template. If you decrease the size, the group
   * deletes one or more instances.
   *
   * <p>The resize operation is marked DONE if the resize request is successful. The underlying
   * actions take additional time. You must separately verify the status of the creating or deleting
   * actions with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   int size = 0;
   *   ResizeRegionInstanceGroupManagerRequest request = ResizeRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSize(size)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.resizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ResizeRegionInstanceGroupManagerRequest, Operation> resizeCallable() {
    return stub.resizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.setInstanceTemplate(project, region, instanceGroupManager, regionInstanceGroupManagersSetTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager The name of the managed instance group.
   * @param regionInstanceGroupManagersSetTemplateRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setInstanceTemplate(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersSetTemplateRequest
          regionInstanceGroupManagersSetTemplateRequestResource) {
    SetInstanceTemplateRegionInstanceGroupManagerRequest request =
        SetInstanceTemplateRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersSetTemplateRequestResource(
                regionInstanceGroupManagersSetTemplateRequestResource)
            .build();
    return setInstanceTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateRegionInstanceGroupManagerRequest request = SetInstanceTemplateRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersSetTemplateRequestResource(regionInstanceGroupManagersSetTemplateRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.setInstanceTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setInstanceTemplate(
      SetInstanceTemplateRegionInstanceGroupManagerRequest request) {
    return setInstanceTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the instance template to use when creating new instances or recreating instances in this
   * group. Existing instances are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersSetTemplateRequest regionInstanceGroupManagersSetTemplateRequestResource = RegionInstanceGroupManagersSetTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateRegionInstanceGroupManagerRequest request = SetInstanceTemplateRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersSetTemplateRequestResource(regionInstanceGroupManagersSetTemplateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.setInstanceTemplateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return stub.setInstanceTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.setTargetPools(project, region, instanceGroupManager, regionInstanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroupManager Name of the managed instance group.
   * @param regionInstanceGroupManagersSetTargetPoolsRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTargetPools(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagersSetTargetPoolsRequest
          regionInstanceGroupManagersSetTargetPoolsRequestResource) {
    SetTargetPoolsRegionInstanceGroupManagerRequest request =
        SetTargetPoolsRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(
                regionInstanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsRegionInstanceGroupManagerRequest request = SetTargetPoolsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(regionInstanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.setTargetPools(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTargetPools(SetTargetPoolsRegionInstanceGroupManagerRequest request) {
    return setTargetPoolsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all new instances in this group are assigned. Existing
   * instances in the group are not affected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagersSetTargetPoolsRequest regionInstanceGroupManagersSetTargetPoolsRequestResource = RegionInstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsRegionInstanceGroupManagerRequest request = SetTargetPoolsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagersSetTargetPoolsRequestResource(regionInstanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.setTargetPoolsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    return stub.setTargetPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String instanceGroupManager = "";
   *   RegionInstanceGroupManagerUpdateInstanceConfigReq regionInstanceGroupManagerUpdateInstanceConfigReqResource = RegionInstanceGroupManagerUpdateInstanceConfigReq.newBuilder().build();
   *   Operation response = regionInstanceGroupManagersClient.updatePerInstanceConfigs(project, region, instanceGroupManager, regionInstanceGroupManagerUpdateInstanceConfigReqResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request, should conform to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param regionInstanceGroupManagerUpdateInstanceConfigReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updatePerInstanceConfigs(
      String project,
      String region,
      String instanceGroupManager,
      RegionInstanceGroupManagerUpdateInstanceConfigReq
          regionInstanceGroupManagerUpdateInstanceConfigReqResource) {
    UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request =
        UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroupManager(instanceGroupManager)
            .setRegionInstanceGroupManagerUpdateInstanceConfigReqResource(
                regionInstanceGroupManagerUpdateInstanceConfigReqResource)
            .build();
    return updatePerInstanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagerUpdateInstanceConfigReq regionInstanceGroupManagerUpdateInstanceConfigReqResource = RegionInstanceGroupManagerUpdateInstanceConfigReq.newBuilder().build();
   *   UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request = UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagerUpdateInstanceConfigReqResource(regionInstanceGroupManagerUpdateInstanceConfigReqResource)
   *     .build();
   *   Operation response = regionInstanceGroupManagersClient.updatePerInstanceConfigs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updatePerInstanceConfigs(
      UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request) {
    return updatePerInstanceConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupManagersClient regionInstanceGroupManagersClient = RegionInstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String region = "";
   *   RegionInstanceGroupManagerUpdateInstanceConfigReq regionInstanceGroupManagerUpdateInstanceConfigReqResource = RegionInstanceGroupManagerUpdateInstanceConfigReq.newBuilder().build();
   *   UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest request = UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionInstanceGroupManagerUpdateInstanceConfigReqResource(regionInstanceGroupManagerUpdateInstanceConfigReqResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupManagersClient.updatePerInstanceConfigsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    return stub.updatePerInstanceConfigsCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagerList,
          InstanceGroupManager,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<RegionInstanceGroupManagerList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagerList,
          InstanceGroupManager,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        RegionInstanceGroupManagerList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        RegionInstanceGroupManagerList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<RegionInstanceGroupManagerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagerList,
          InstanceGroupManager,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListErrorsPagedResponse
      extends AbstractPagedListResponse<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage,
          ListErrorsFixedSizeCollection> {

    public static ApiFuture<ListErrorsPagedResponse> createAsync(
        PageContext<
                ListErrorsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<RegionInstanceGroupManagersListErrorsResponse> futureResponse) {
      ApiFuture<ListErrorsPage> futurePage =
          ListErrorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListErrorsPage, ListErrorsPagedResponse>() {
            @Override
            public ListErrorsPagedResponse apply(ListErrorsPage input) {
              return new ListErrorsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListErrorsPagedResponse(ListErrorsPage page) {
      super(page, ListErrorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListErrorsPage
      extends AbstractPage<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage> {

    private ListErrorsPage(
        PageContext<
                ListErrorsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        RegionInstanceGroupManagersListErrorsResponse response) {
      super(context, response);
    }

    private static ListErrorsPage createEmptyPage() {
      return new ListErrorsPage(null, null);
    }

    @Override
    protected ListErrorsPage createPage(
        PageContext<
                ListErrorsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        RegionInstanceGroupManagersListErrorsResponse response) {
      return new ListErrorsPage(context, response);
    }

    @Override
    public ApiFuture<ListErrorsPage> createPageAsync(
        PageContext<
                ListErrorsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<RegionInstanceGroupManagersListErrorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListErrorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage,
          ListErrorsFixedSizeCollection> {

    private ListErrorsFixedSizeCollection(List<ListErrorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListErrorsFixedSizeCollection createEmptyCollection() {
      return new ListErrorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListErrorsFixedSizeCollection createCollection(
        List<ListErrorsPage> pages, int collectionSize) {
      return new ListErrorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListManagedInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage,
          ListManagedInstancesFixedSizeCollection> {

    public static ApiFuture<ListManagedInstancesPagedResponse> createAsync(
        PageContext<
                ListManagedInstancesRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<RegionInstanceGroupManagersListInstancesResponse> futureResponse) {
      ApiFuture<ListManagedInstancesPage> futurePage =
          ListManagedInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListManagedInstancesPage, ListManagedInstancesPagedResponse>() {
            @Override
            public ListManagedInstancesPagedResponse apply(ListManagedInstancesPage input) {
              return new ListManagedInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListManagedInstancesPagedResponse(ListManagedInstancesPage page) {
      super(page, ListManagedInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListManagedInstancesPage
      extends AbstractPage<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage> {

    private ListManagedInstancesPage(
        PageContext<
                ListManagedInstancesRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstancesResponse,
                ManagedInstance>
            context,
        RegionInstanceGroupManagersListInstancesResponse response) {
      super(context, response);
    }

    private static ListManagedInstancesPage createEmptyPage() {
      return new ListManagedInstancesPage(null, null);
    }

    @Override
    protected ListManagedInstancesPage createPage(
        PageContext<
                ListManagedInstancesRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstancesResponse,
                ManagedInstance>
            context,
        RegionInstanceGroupManagersListInstancesResponse response) {
      return new ListManagedInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListManagedInstancesPage> createPageAsync(
        PageContext<
                ListManagedInstancesRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<RegionInstanceGroupManagersListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagedInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage,
          ListManagedInstancesFixedSizeCollection> {

    private ListManagedInstancesFixedSizeCollection(
        List<ListManagedInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListManagedInstancesFixedSizeCollection createEmptyCollection() {
      return new ListManagedInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListManagedInstancesFixedSizeCollection createCollection(
        List<ListManagedInstancesPage> pages, int collectionSize) {
      return new ListManagedInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPerInstanceConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage,
          ListPerInstanceConfigsFixedSizeCollection> {

    public static ApiFuture<ListPerInstanceConfigsPagedResponse> createAsync(
        PageContext<
                ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<RegionInstanceGroupManagersListInstanceConfigsResp> futureResponse) {
      ApiFuture<ListPerInstanceConfigsPage> futurePage =
          ListPerInstanceConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPerInstanceConfigsPage, ListPerInstanceConfigsPagedResponse>() {
            @Override
            public ListPerInstanceConfigsPagedResponse apply(ListPerInstanceConfigsPage input) {
              return new ListPerInstanceConfigsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPerInstanceConfigsPagedResponse(ListPerInstanceConfigsPage page) {
      super(page, ListPerInstanceConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPerInstanceConfigsPage
      extends AbstractPage<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage> {

    private ListPerInstanceConfigsPage(
        PageContext<
                ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstanceConfigsResp,
                PerInstanceConfig>
            context,
        RegionInstanceGroupManagersListInstanceConfigsResp response) {
      super(context, response);
    }

    private static ListPerInstanceConfigsPage createEmptyPage() {
      return new ListPerInstanceConfigsPage(null, null);
    }

    @Override
    protected ListPerInstanceConfigsPage createPage(
        PageContext<
                ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstanceConfigsResp,
                PerInstanceConfig>
            context,
        RegionInstanceGroupManagersListInstanceConfigsResp response) {
      return new ListPerInstanceConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListPerInstanceConfigsPage> createPageAsync(
        PageContext<
                ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
                RegionInstanceGroupManagersListInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<RegionInstanceGroupManagersListInstanceConfigsResp> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPerInstanceConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage,
          ListPerInstanceConfigsFixedSizeCollection> {

    private ListPerInstanceConfigsFixedSizeCollection(
        List<ListPerInstanceConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPerInstanceConfigsFixedSizeCollection createEmptyCollection() {
      return new ListPerInstanceConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPerInstanceConfigsFixedSizeCollection createCollection(
        List<ListPerInstanceConfigsPage> pages, int collectionSize) {
      return new ListPerInstanceConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
