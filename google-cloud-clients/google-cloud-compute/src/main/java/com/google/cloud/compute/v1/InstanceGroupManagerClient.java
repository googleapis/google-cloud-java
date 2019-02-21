/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.compute.v1.stub.InstanceGroupManagerStub;
import com.google.cloud.compute.v1.stub.InstanceGroupManagerStubSettings;
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
 * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
 *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
 *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceGroupManagerClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of InstanceGroupManagerSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceGroupManagerSettings instanceGroupManagerSettings =
 *     InstanceGroupManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupManagerClient instanceGroupManagerClient =
 *     InstanceGroupManagerClient.create(instanceGroupManagerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceGroupManagerSettings instanceGroupManagerSettings =
 *     InstanceGroupManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupManagerClient instanceGroupManagerClient =
 *     InstanceGroupManagerClient.create(instanceGroupManagerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupManagerClient implements BackgroundResource {
  private final InstanceGroupManagerSettings settings;
  private final InstanceGroupManagerStub stub;

  /** Constructs an instance of InstanceGroupManagerClient with default settings. */
  public static final InstanceGroupManagerClient create() throws IOException {
    return create(InstanceGroupManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupManagerClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceGroupManagerClient create(InstanceGroupManagerSettings settings)
      throws IOException {
    return new InstanceGroupManagerClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupManagerClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use InstanceGroupManagerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceGroupManagerClient create(InstanceGroupManagerStub stub) {
    return new InstanceGroupManagerClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupManagerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InstanceGroupManagerClient(InstanceGroupManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceGroupManagerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceGroupManagerClient(InstanceGroupManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupManagerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersAbandonInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersAbandonInstancesRequest
          instanceGroupManagersAbandonInstancesRequestResource) {

    AbandonInstancesInstanceGroupManagerHttpRequest request =
        AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersAbandonInstancesRequestResource(
                instanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersAbandonInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersAbandonInstancesRequest
          instanceGroupManagersAbandonInstancesRequestResource) {

    AbandonInstancesInstanceGroupManagerHttpRequest request =
        AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersAbandonInstancesRequestResource(
                instanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesInstanceGroupManagerHttpRequest request = AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersAbandonInstancesRequestResource(instanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesInstanceGroupManager(
      AbandonInstancesInstanceGroupManagerHttpRequest request) {
    return abandonInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesInstanceGroupManagerHttpRequest request = AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersAbandonInstancesRequestResource(instanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.abandonInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesInstanceGroupManagerCallable() {
    return stub.abandonInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstanceGroupManagersScopedList element : instanceGroupManagerClient.aggregatedListInstanceGroupManagers(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupManagersPagedResponse aggregatedListInstanceGroupManagers(
      ProjectName project) {
    AggregatedListInstanceGroupManagersHttpRequest request =
        AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstanceGroupManagersScopedList element : instanceGroupManagerClient.aggregatedListInstanceGroupManagers(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupManagersPagedResponse aggregatedListInstanceGroupManagers(
      String project) {
    AggregatedListInstanceGroupManagersHttpRequest request =
        AggregatedListInstanceGroupManagersHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstanceGroupManagersHttpRequest request = AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (InstanceGroupManagersScopedList element : instanceGroupManagerClient.aggregatedListInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupManagersPagedResponse aggregatedListInstanceGroupManagers(
      AggregatedListInstanceGroupManagersHttpRequest request) {
    return aggregatedListInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstanceGroupManagersHttpRequest request = AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.aggregatedListInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManagersScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest,
          AggregatedListInstanceGroupManagersPagedResponse>
      aggregatedListInstanceGroupManagersPagedCallable() {
    return stub.aggregatedListInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstanceGroupManagersHttpRequest request = AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     InstanceGroupManagerAggregatedList response = instanceGroupManagerClient.aggregatedListInstanceGroupManagersCallable().call(request);
   *     for (InstanceGroupManagersScopedList element : response.getItemsMap()) {
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
          AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
      aggregatedListInstanceGroupManagersCallable() {
    return stub.aggregatedListInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.deleteInstanceGroupManager(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager) {

    DeleteInstanceGroupManagerHttpRequest request =
        DeleteInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return deleteInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.deleteInstanceGroupManager(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroupManager(String instanceGroupManager) {

    DeleteInstanceGroupManagerHttpRequest request =
        DeleteInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return deleteInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   DeleteInstanceGroupManagerHttpRequest request = DeleteInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   Operation response = instanceGroupManagerClient.deleteInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroupManager(DeleteInstanceGroupManagerHttpRequest request) {
    return deleteInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   DeleteInstanceGroupManagerHttpRequest request = DeleteInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.deleteInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstanceGroupManagerHttpRequest, Operation>
      deleteInstanceGroupManagerCallable() {
    return stub.deleteInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.deleteInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersDeleteInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersDeleteInstancesRequest
          instanceGroupManagersDeleteInstancesRequestResource) {

    DeleteInstancesInstanceGroupManagerHttpRequest request =
        DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersDeleteInstancesRequestResource(
                instanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.deleteInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersDeleteInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersDeleteInstancesRequest
          instanceGroupManagersDeleteInstancesRequestResource) {

    DeleteInstancesInstanceGroupManagerHttpRequest request =
        DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeleteInstancesRequestResource(
                instanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesInstanceGroupManagerHttpRequest request = DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersDeleteInstancesRequestResource(instanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.deleteInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesInstanceGroupManager(
      DeleteInstancesInstanceGroupManagerHttpRequest request) {
    return deleteInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesInstanceGroupManagerHttpRequest request = DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersDeleteInstancesRequestResource(instanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.deleteInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesInstanceGroupManagerCallable() {
    return stub.deleteInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager response = instanceGroupManagerClient.getInstanceGroupManager(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager) {

    GetInstanceGroupManagerHttpRequest request =
        GetInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return getInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager response = instanceGroupManagerClient.getInstanceGroupManager(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getInstanceGroupManager(String instanceGroupManager) {

    GetInstanceGroupManagerHttpRequest request =
        GetInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return getInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   GetInstanceGroupManagerHttpRequest request = GetInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   InstanceGroupManager response = instanceGroupManagerClient.getInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getInstanceGroupManager(
      GetInstanceGroupManagerHttpRequest request) {
    return getInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   GetInstanceGroupManagerHttpRequest request = GetInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;InstanceGroupManager&gt; future = instanceGroupManagerClient.getInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   InstanceGroupManager response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getInstanceGroupManagerCallable() {
    return stub.getInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.insertInstanceGroupManager(zone, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManagerResource An Instance Group Manager resource. (== resource_for
   *     beta.instanceGroupManagers ==) (== resource_for v1.instanceGroupManagers ==) (==
   *     resource_for beta.regionInstanceGroupManagers ==) (== resource_for
   *     v1.regionInstanceGroupManagers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroupManager(
      ProjectZoneName zone, InstanceGroupManager instanceGroupManagerResource) {

    InsertInstanceGroupManagerHttpRequest request =
        InsertInstanceGroupManagerHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.insertInstanceGroupManager(zone.toString(), instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManagerResource An Instance Group Manager resource. (== resource_for
   *     beta.instanceGroupManagers ==) (== resource_for v1.instanceGroupManagers ==) (==
   *     resource_for beta.regionInstanceGroupManagers ==) (== resource_for
   *     v1.regionInstanceGroupManagers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroupManager(
      String zone, InstanceGroupManager instanceGroupManagerResource) {

    InsertInstanceGroupManagerHttpRequest request =
        InsertInstanceGroupManagerHttpRequest.newBuilder()
            .setZone(zone)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   InsertInstanceGroupManagerHttpRequest request = InsertInstanceGroupManagerHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.insertInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroupManager(InsertInstanceGroupManagerHttpRequest request) {
    return insertInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   InsertInstanceGroupManagerHttpRequest request = InsertInstanceGroupManagerHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.insertInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertInstanceGroupManagerHttpRequest, Operation>
      insertInstanceGroupManagerCallable() {
    return stub.insertInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (InstanceGroupManager element : instanceGroupManagerClient.listInstanceGroupManagers(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the managed instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupManagersPagedResponse listInstanceGroupManagers(
      ProjectZoneName zone) {
    ListInstanceGroupManagersHttpRequest request =
        ListInstanceGroupManagersHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (InstanceGroupManager element : instanceGroupManagerClient.listInstanceGroupManagers(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the managed instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupManagersPagedResponse listInstanceGroupManagers(String zone) {
    ListInstanceGroupManagersHttpRequest request =
        ListInstanceGroupManagersHttpRequest.newBuilder().setZone(zone).build();
    return listInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupManagersHttpRequest request = ListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (InstanceGroupManager element : instanceGroupManagerClient.listInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupManagersPagedResponse listInstanceGroupManagers(
      ListInstanceGroupManagersHttpRequest request) {
    return listInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupManagersHttpRequest request = ListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.listInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManager element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListInstanceGroupManagersHttpRequest, ListInstanceGroupManagersPagedResponse>
      listInstanceGroupManagersPagedCallable() {
    return stub.listInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupManagersHttpRequest request = ListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     InstanceGroupManagerList response = instanceGroupManagerClient.listInstanceGroupManagersCallable().call(request);
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
  public final UnaryCallable<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>
      listInstanceGroupManagersCallable() {
    return stub.listInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersListManagedInstancesResponse response = instanceGroupManagerClient.listManagedInstancesInstanceGroupManagers(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManagersListManagedInstancesResponse
      listManagedInstancesInstanceGroupManagers(
          ProjectZoneInstanceGroupManagerName instanceGroupManager) {

    ListManagedInstancesInstanceGroupManagersHttpRequest request =
        ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return listManagedInstancesInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersListManagedInstancesResponse response = instanceGroupManagerClient.listManagedInstancesInstanceGroupManagers(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManagersListManagedInstancesResponse
      listManagedInstancesInstanceGroupManagers(String instanceGroupManager) {

    ListManagedInstancesInstanceGroupManagersHttpRequest request =
        ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listManagedInstancesInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesInstanceGroupManagersHttpRequest request = ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   InstanceGroupManagersListManagedInstancesResponse response = instanceGroupManagerClient.listManagedInstancesInstanceGroupManagers(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManagersListManagedInstancesResponse
      listManagedInstancesInstanceGroupManagers(
          ListManagedInstancesInstanceGroupManagersHttpRequest request) {
    return listManagedInstancesInstanceGroupManagersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesInstanceGroupManagersHttpRequest request = ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;InstanceGroupManagersListManagedInstancesResponse&gt; future = instanceGroupManagerClient.listManagedInstancesInstanceGroupManagersCallable().futureCall(request);
   *   // Do something
   *   InstanceGroupManagersListManagedInstancesResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesInstanceGroupManagersCallable() {
    return stub.listManagedInstancesInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = instanceGroupManagerClient.patchInstanceGroupManager(instanceGroupManager, instanceGroupManagerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource An Instance Group Manager resource. (== resource_for
   *     beta.instanceGroupManagers ==) (== resource_for v1.instanceGroupManagers ==) (==
   *     resource_for beta.regionInstanceGroupManagers ==) (== resource_for
   *     v1.regionInstanceGroupManagers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource,
      List<String> fieldMask) {

    PatchInstanceGroupManagerHttpRequest request =
        PatchInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = instanceGroupManagerClient.patchInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource An Instance Group Manager resource. (== resource_for
   *     beta.instanceGroupManagers ==) (== resource_for v1.instanceGroupManagers ==) (==
   *     resource_for beta.regionInstanceGroupManagers ==) (== resource_for
   *     v1.regionInstanceGroupManagers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource,
      List<String> fieldMask) {

    PatchInstanceGroupManagerHttpRequest request =
        PatchInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInstanceGroupManagerHttpRequest request = PatchInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = instanceGroupManagerClient.patchInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInstanceGroupManager(PatchInstanceGroupManagerHttpRequest request) {
    return patchInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInstanceGroupManagerHttpRequest request = PatchInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.patchInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchInstanceGroupManagerHttpRequest, Operation>
      patchInstanceGroupManagerCallable() {
    return stub.patchInstanceGroupManagerCallable();
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.recreateInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersRecreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersRecreateInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersRecreateInstancesRequest
          instanceGroupManagersRecreateInstancesRequestResource) {

    RecreateInstancesInstanceGroupManagerHttpRequest request =
        RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersRecreateInstancesRequestResource(
                instanceGroupManagersRecreateInstancesRequestResource)
            .build();
    return recreateInstancesInstanceGroupManager(request);
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.recreateInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersRecreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersRecreateInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersRecreateInstancesRequest
          instanceGroupManagersRecreateInstancesRequestResource) {

    RecreateInstancesInstanceGroupManagerHttpRequest request =
        RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersRecreateInstancesRequestResource(
                instanceGroupManagersRecreateInstancesRequestResource)
            .build();
    return recreateInstancesInstanceGroupManager(request);
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   RecreateInstancesInstanceGroupManagerHttpRequest request = RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersRecreateInstancesRequestResource(instanceGroupManagersRecreateInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.recreateInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesInstanceGroupManager(
      RecreateInstancesInstanceGroupManagerHttpRequest request) {
    return recreateInstancesInstanceGroupManagerCallable().call(request);
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
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   RecreateInstancesInstanceGroupManagerHttpRequest request = RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersRecreateInstancesRequestResource(instanceGroupManagersRecreateInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.recreateInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesInstanceGroupManagerCallable() {
    return stub.recreateInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.resizeInstanceGroupManager(size, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param size The number of running instances that the managed instance group should maintain at
   *     any given time. The group automatically adds or removes instances to maintain the number of
   *     instances specified by this parameter.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeInstanceGroupManager(
      Integer size, ProjectZoneInstanceGroupManagerName instanceGroupManager) {

    ResizeInstanceGroupManagerHttpRequest request =
        ResizeInstanceGroupManagerHttpRequest.newBuilder()
            .setSize(size)
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return resizeInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.resizeInstanceGroupManager(size, instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param size The number of running instances that the managed instance group should maintain at
   *     any given time. The group automatically adds or removes instances to maintain the number of
   *     instances specified by this parameter.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeInstanceGroupManager(Integer size, String instanceGroupManager) {

    ResizeInstanceGroupManagerHttpRequest request =
        ResizeInstanceGroupManagerHttpRequest.newBuilder()
            .setSize(size)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return resizeInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ResizeInstanceGroupManagerHttpRequest request = ResizeInstanceGroupManagerHttpRequest.newBuilder()
   *     .setSize(size)
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   Operation response = instanceGroupManagerClient.resizeInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeInstanceGroupManager(ResizeInstanceGroupManagerHttpRequest request) {
    return resizeInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ResizeInstanceGroupManagerHttpRequest request = ResizeInstanceGroupManagerHttpRequest.newBuilder()
   *     .setSize(size)
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.resizeInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResizeInstanceGroupManagerHttpRequest, Operation>
      resizeInstanceGroupManagerCallable() {
    return stub.resizeInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManager(instanceGroupManager, instanceGroupManagersSetInstanceTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetInstanceTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersSetInstanceTemplateRequest
          instanceGroupManagersSetInstanceTemplateRequestResource) {

    SetInstanceTemplateInstanceGroupManagerHttpRequest request =
        SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersSetInstanceTemplateRequestResource(
                instanceGroupManagersSetInstanceTemplateRequestResource)
            .build();
    return setInstanceTemplateInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersSetInstanceTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetInstanceTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersSetInstanceTemplateRequest
          instanceGroupManagersSetInstanceTemplateRequestResource) {

    SetInstanceTemplateInstanceGroupManagerHttpRequest request =
        SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetInstanceTemplateRequestResource(
                instanceGroupManagersSetInstanceTemplateRequestResource)
            .build();
    return setInstanceTemplateInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateInstanceGroupManagerHttpRequest request = SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersSetInstanceTemplateRequestResource(instanceGroupManagersSetInstanceTemplateRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateInstanceGroupManager(
      SetInstanceTemplateInstanceGroupManagerHttpRequest request) {
    return setInstanceTemplateInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateInstanceGroupManagerHttpRequest request = SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersSetInstanceTemplateRequestResource(instanceGroupManagersSetInstanceTemplateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateInstanceGroupManagerCallable() {
    return stub.setInstanceTemplateInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setTargetPoolsInstanceGroupManager(instanceGroupManager, instanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetTargetPoolsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersSetTargetPoolsRequest
          instanceGroupManagersSetTargetPoolsRequestResource) {

    SetTargetPoolsInstanceGroupManagerHttpRequest request =
        SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersSetTargetPoolsRequestResource(
                instanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setTargetPoolsInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetTargetPoolsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersSetTargetPoolsRequest
          instanceGroupManagersSetTargetPoolsRequestResource) {

    SetTargetPoolsInstanceGroupManagerHttpRequest request =
        SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetTargetPoolsRequestResource(
                instanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsInstanceGroupManagerHttpRequest request = SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersSetTargetPoolsRequestResource(instanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.setTargetPoolsInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsInstanceGroupManager(
      SetTargetPoolsInstanceGroupManagerHttpRequest request) {
    return setTargetPoolsInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsInstanceGroupManagerHttpRequest request = SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager.toString())
   *     .setInstanceGroupManagersSetTargetPoolsRequestResource(instanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.setTargetPoolsInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsInstanceGroupManagerCallable() {
    return stub.setTargetPoolsInstanceGroupManagerCallable();
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

  public static class AggregatedListInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          InstanceGroupManagersScopedList,
          AggregatedListInstanceGroupManagersPage,
          AggregatedListInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<AggregatedListInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      ApiFuture<AggregatedListInstanceGroupManagersPage> futurePage =
          AggregatedListInstanceGroupManagersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListInstanceGroupManagersPage,
              AggregatedListInstanceGroupManagersPagedResponse>() {
            @Override
            public AggregatedListInstanceGroupManagersPagedResponse apply(
                AggregatedListInstanceGroupManagersPage input) {
              return new AggregatedListInstanceGroupManagersPagedResponse(input);
            }
          });
    }

    private AggregatedListInstanceGroupManagersPagedResponse(
        AggregatedListInstanceGroupManagersPage page) {
      super(page, AggregatedListInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListInstanceGroupManagersPage
      extends AbstractPage<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          InstanceGroupManagersScopedList,
          AggregatedListInstanceGroupManagersPage> {

    private AggregatedListInstanceGroupManagersPage(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        InstanceGroupManagerAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListInstanceGroupManagersPage createEmptyPage() {
      return new AggregatedListInstanceGroupManagersPage(null, null);
    }

    @Override
    protected AggregatedListInstanceGroupManagersPage createPage(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        InstanceGroupManagerAggregatedList response) {
      return new AggregatedListInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListInstanceGroupManagersPage> createPageAsync(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          InstanceGroupManagersScopedList,
          AggregatedListInstanceGroupManagersPage,
          AggregatedListInstanceGroupManagersFixedSizeCollection> {

    private AggregatedListInstanceGroupManagersFixedSizeCollection(
        List<AggregatedListInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListInstanceGroupManagersFixedSizeCollection createEmptyCollection() {
      return new AggregatedListInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListInstanceGroupManagersFixedSizeCollection createCollection(
        List<AggregatedListInstanceGroupManagersPage> pages, int collectionSize) {
      return new AggregatedListInstanceGroupManagersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListInstanceGroupManagersPage,
          ListInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<ListInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
      ApiFuture<ListInstanceGroupManagersPage> futurePage =
          ListInstanceGroupManagersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstanceGroupManagersPage, ListInstanceGroupManagersPagedResponse>() {
            @Override
            public ListInstanceGroupManagersPagedResponse apply(
                ListInstanceGroupManagersPage input) {
              return new ListInstanceGroupManagersPagedResponse(input);
            }
          });
    }

    private ListInstanceGroupManagersPagedResponse(ListInstanceGroupManagersPage page) {
      super(page, ListInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstanceGroupManagersPage
      extends AbstractPage<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListInstanceGroupManagersPage> {

    private ListInstanceGroupManagersPage(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      super(context, response);
    }

    private static ListInstanceGroupManagersPage createEmptyPage() {
      return new ListInstanceGroupManagersPage(null, null);
    }

    @Override
    protected ListInstanceGroupManagersPage createPage(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      return new ListInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<ListInstanceGroupManagersPage> createPageAsync(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListInstanceGroupManagersPage,
          ListInstanceGroupManagersFixedSizeCollection> {

    private ListInstanceGroupManagersFixedSizeCollection(
        List<ListInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstanceGroupManagersFixedSizeCollection createEmptyCollection() {
      return new ListInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstanceGroupManagersFixedSizeCollection createCollection(
        List<ListInstanceGroupManagersPage> pages, int collectionSize) {
      return new ListInstanceGroupManagersFixedSizeCollection(pages, collectionSize);
    }
  }
}
