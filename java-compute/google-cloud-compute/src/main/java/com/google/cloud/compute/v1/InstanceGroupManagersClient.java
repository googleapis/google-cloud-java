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
import com.google.cloud.compute.v1.stub.InstanceGroupManagersStub;
import com.google.cloud.compute.v1.stub.InstanceGroupManagersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The InstanceGroupManagers API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String instanceGroupManager = "";
 *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupManagersClient.abandonInstances(project, zone, instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceGroupManagersClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of InstanceGroupManagersSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceGroupManagersSettings instanceGroupManagersSettings =
 *     InstanceGroupManagersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupManagersClient instanceGroupManagersClient =
 *     InstanceGroupManagersClient.create(instanceGroupManagersSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceGroupManagersSettings instanceGroupManagersSettings =
 *     InstanceGroupManagersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupManagersClient instanceGroupManagersClient =
 *     InstanceGroupManagersClient.create(instanceGroupManagersSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupManagersClient implements BackgroundResource {
  private final InstanceGroupManagersSettings settings;
  private final InstanceGroupManagersStub stub;

  /** Constructs an instance of InstanceGroupManagersClient with default settings. */
  public static final InstanceGroupManagersClient create() throws IOException {
    return create(InstanceGroupManagersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupManagersClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceGroupManagersClient create(InstanceGroupManagersSettings settings)
      throws IOException {
    return new InstanceGroupManagersClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupManagersClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use InstanceGroupManagersSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceGroupManagersClient create(InstanceGroupManagersStub stub) {
    return new InstanceGroupManagersClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupManagersClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InstanceGroupManagersClient(InstanceGroupManagersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceGroupManagersStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceGroupManagersClient(InstanceGroupManagersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupManagersSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupManagersStub getStub() {
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.abandonInstances(project, zone, instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersAbandonInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation abandonInstances(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersAbandonInstancesRequest
          instanceGroupManagersAbandonInstancesRequestResource) {
    AbandonInstancesInstanceGroupManagerRequest request =
        AbandonInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersAbandonInstancesRequestResource(
                instanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstances(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AbandonInstancesInstanceGroupManagerRequest request = AbandonInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersAbandonInstancesRequestResource(instanceGroupManagersAbandonInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.abandonInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation abandonInstances(AbandonInstancesInstanceGroupManagerRequest request) {
    return abandonInstancesCallable().call(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AbandonInstancesInstanceGroupManagerRequest request = AbandonInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersAbandonInstancesRequestResource(instanceGroupManagersAbandonInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.abandonInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    return stub.abandonInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, InstanceGroupManagersScopedList&gt; element : instanceGroupManagersClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListInstanceGroupManagersRequest request =
        AggregatedListInstanceGroupManagersRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   AggregatedListInstanceGroupManagersRequest request = AggregatedListInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, InstanceGroupManagersScopedList&gt; element : instanceGroupManagersClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListInstanceGroupManagersRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   AggregatedListInstanceGroupManagersRequest request = AggregatedListInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = instanceGroupManagersClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, InstanceGroupManagersScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   AggregatedListInstanceGroupManagersRequest request = AggregatedListInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagerAggregatedList response = instanceGroupManagersClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, InstanceGroupManagersScopedList&gt; element : response.getItemsMap()) {
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
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.applyUpdatesToInstances(project, zone, instanceGroupManager, instanceGroupManagersApplyUpdatesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. Should conform to
   *     RFC1035.
   * @param instanceGroupManager The name of the managed instance group, should conform to RFC1035.
   * @param instanceGroupManagersApplyUpdatesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation applyUpdatesToInstances(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource) {
    ApplyUpdatesToInstancesInstanceGroupManagerRequest request =
        ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersApplyUpdatesRequestResource(
                instanceGroupManagersApplyUpdatesRequestResource)
            .build();
    return applyUpdatesToInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ApplyUpdatesToInstancesInstanceGroupManagerRequest request = ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersApplyUpdatesRequestResource(instanceGroupManagersApplyUpdatesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.applyUpdatesToInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation applyUpdatesToInstances(
      ApplyUpdatesToInstancesInstanceGroupManagerRequest request) {
    return applyUpdatesToInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ApplyUpdatesToInstancesInstanceGroupManagerRequest request = ApplyUpdatesToInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersApplyUpdatesRequestResource(instanceGroupManagersApplyUpdatesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.applyUpdatesToInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    return stub.applyUpdatesToInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.createInstances(project, zone, instanceGroupManager, instanceGroupManagersCreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersCreateInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createInstances(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersCreateInstancesRequest
          instanceGroupManagersCreateInstancesRequestResource) {
    CreateInstancesInstanceGroupManagerRequest request =
        CreateInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersCreateInstancesRequestResource(
                instanceGroupManagersCreateInstancesRequestResource)
            .build();
    return createInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   CreateInstancesInstanceGroupManagerRequest request = CreateInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersCreateInstancesRequestResource(instanceGroupManagersCreateInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.createInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createInstances(CreateInstancesInstanceGroupManagerRequest request) {
    return createInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   CreateInstancesInstanceGroupManagerRequest request = CreateInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersCreateInstancesRequestResource(instanceGroupManagersCreateInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.createInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    return stub.createInstancesCallable();
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   Operation response = instanceGroupManagersClient.delete(project, zone, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String instanceGroupManager) {
    DeleteInstanceGroupManagerRequest request =
        DeleteInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return delete(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteInstanceGroupManagerRequest request = DeleteInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteInstanceGroupManagerRequest request) {
    return deleteCallable().call(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteInstanceGroupManagerRequest request = DeleteInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.deleteInstances(project, zone, instanceGroupManager, instanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersDeleteInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteInstances(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersDeleteInstancesRequest
          instanceGroupManagersDeleteInstancesRequestResource) {
    DeleteInstancesInstanceGroupManagerRequest request =
        DeleteInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeleteInstancesRequestResource(
                instanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstances(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   DeleteInstancesInstanceGroupManagerRequest request = DeleteInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersDeleteInstancesRequestResource(instanceGroupManagersDeleteInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.deleteInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteInstances(DeleteInstancesInstanceGroupManagerRequest request) {
    return deleteInstancesCallable().call(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   DeleteInstancesInstanceGroupManagerRequest request = DeleteInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersDeleteInstancesRequestResource(instanceGroupManagersDeleteInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.deleteInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.deletePerInstanceConfigs(project, zone, instanceGroupManager, instanceGroupManagersDeletePerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersDeletePerInstanceConfigsReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deletePerInstanceConfigs(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersDeletePerInstanceConfigsReq
          instanceGroupManagersDeletePerInstanceConfigsReqResource) {
    DeletePerInstanceConfigsInstanceGroupManagerRequest request =
        DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
                instanceGroupManagersDeletePerInstanceConfigsReqResource)
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   DeletePerInstanceConfigsInstanceGroupManagerRequest request = DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(instanceGroupManagersDeletePerInstanceConfigsReqResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.deletePerInstanceConfigs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deletePerInstanceConfigs(
      DeletePerInstanceConfigsInstanceGroupManagerRequest request) {
    return deletePerInstanceConfigsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   DeletePerInstanceConfigsInstanceGroupManagerRequest request = DeletePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(instanceGroupManagersDeletePerInstanceConfigsReqResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.deletePerInstanceConfigsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    return stub.deletePerInstanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManager response = instanceGroupManagersClient.get(project, zone, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManager get(String project, String zone, String instanceGroupManager) {
    GetInstanceGroupManagerRequest request =
        GetInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   GetInstanceGroupManagerRequest request = GetInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   InstanceGroupManager response = instanceGroupManagersClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroupManager get(GetInstanceGroupManagerRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   GetInstanceGroupManagerRequest request = GetInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;InstanceGroupManager&gt; future = instanceGroupManagersClient.getCallable().futureCall(request);
   *   // Do something
   *   InstanceGroupManager response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
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
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.insert(project, zone, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManagerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String zone, InstanceGroupManager instanceGroupManagerResource) {
    InsertInstanceGroupManagerRequest request =
        InsertInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertInstanceGroupManagerRequest request = InsertInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertInstanceGroupManagerRequest request) {
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
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertInstanceGroupManagerRequest request = InsertInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (InstanceGroupManager element : instanceGroupManagersClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListInstanceGroupManagersRequest request =
        ListInstanceGroupManagersRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListInstanceGroupManagersRequest request = ListInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (InstanceGroupManager element : instanceGroupManagersClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInstanceGroupManagersRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListInstanceGroupManagersRequest request = ListInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = instanceGroupManagersClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManager element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListInstanceGroupManagersRequest request = ListInstanceGroupManagersRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagerList response = instanceGroupManagersClient.listCallable().call(request);
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
  public final UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   for (InstanceManagedByIgmError element : instanceGroupManagersClient.listErrors(project, zone, instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It must be a string that
   *     meets the requirements in RFC1035, or an unsigned long integer: must match regexp pattern:
   *     (?:[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?)|[1-9][0-9]{0,19}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorsPagedResponse listErrors(
      String project, String zone, String instanceGroupManager) {
    ListErrorsInstanceGroupManagersRequest request =
        ListErrorsInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListErrorsInstanceGroupManagersRequest request = ListErrorsInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (InstanceManagedByIgmError element : instanceGroupManagersClient.listErrors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListErrorsPagedResponse listErrors(ListErrorsInstanceGroupManagersRequest request) {
    return listErrorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListErrorsInstanceGroupManagersRequest request = ListErrorsInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListErrorsPagedResponse&gt; future = instanceGroupManagersClient.listErrorsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceManagedByIgmError element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    return stub.listErrorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListErrorsInstanceGroupManagersRequest request = ListErrorsInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagersListErrorsResponse response = instanceGroupManagersClient.listErrorsCallable().call(request);
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
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    return stub.listErrorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   for (ManagedInstance element : instanceGroupManagersClient.listManagedInstances(project, zone, instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedInstancesPagedResponse listManagedInstances(
      String project, String zone, String instanceGroupManager) {
    ListManagedInstancesInstanceGroupManagersRequest request =
        ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listManagedInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListManagedInstancesInstanceGroupManagersRequest request = ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (ManagedInstance element : instanceGroupManagersClient.listManagedInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagedInstancesPagedResponse listManagedInstances(
      ListManagedInstancesInstanceGroupManagersRequest request) {
    return listManagedInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListManagedInstancesInstanceGroupManagersRequest request = ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListManagedInstancesPagedResponse&gt; future = instanceGroupManagersClient.listManagedInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ManagedInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    return stub.listManagedInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListManagedInstancesInstanceGroupManagersRequest request = ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagersListManagedInstancesResponse response = instanceGroupManagersClient.listManagedInstancesCallable().call(request);
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
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   for (PerInstanceConfig element : instanceGroupManagersClient.listPerInstanceConfigs(project, zone, instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPerInstanceConfigsPagedResponse listPerInstanceConfigs(
      String project, String zone, String instanceGroupManager) {
    ListPerInstanceConfigsInstanceGroupManagersRequest request =
        ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListPerInstanceConfigsInstanceGroupManagersRequest request = ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (PerInstanceConfig element : instanceGroupManagersClient.listPerInstanceConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPerInstanceConfigsPagedResponse listPerInstanceConfigs(
      ListPerInstanceConfigsInstanceGroupManagersRequest request) {
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListPerInstanceConfigsInstanceGroupManagersRequest request = ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPerInstanceConfigsPagedResponse&gt; future = instanceGroupManagersClient.listPerInstanceConfigsPagedCallable().futureCall(request);
   *   // Do something
   *   for (PerInstanceConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   String zone = "";
   *   ListPerInstanceConfigsInstanceGroupManagersRequest request = ListPerInstanceConfigsInstanceGroupManagersRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagersListPerInstanceConfigsResp response = instanceGroupManagersClient.listPerInstanceConfigsCallable().call(request);
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
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    return stub.listPerInstanceConfigsCallable();
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.patch(project, zone, instanceGroupManager, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource) {
    PatchInstanceGroupManagerRequest request =
        PatchInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   PatchInstanceGroupManagerRequest request = PatchInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchInstanceGroupManagerRequest request) {
    return patchCallable().call(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   PatchInstanceGroupManagerRequest request = PatchInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable() {
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.patchPerInstanceConfigs(project, zone, instanceGroupManager, instanceGroupManagersPatchPerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersPatchPerInstanceConfigsReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchPerInstanceConfigs(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersPatchPerInstanceConfigsReq
          instanceGroupManagersPatchPerInstanceConfigsReqResource) {
    PatchPerInstanceConfigsInstanceGroupManagerRequest request =
        PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
                instanceGroupManagersPatchPerInstanceConfigsReqResource)
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   PatchPerInstanceConfigsInstanceGroupManagerRequest request = PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(instanceGroupManagersPatchPerInstanceConfigsReqResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.patchPerInstanceConfigs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchPerInstanceConfigs(
      PatchPerInstanceConfigsInstanceGroupManagerRequest request) {
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   PatchPerInstanceConfigsInstanceGroupManagerRequest request = PatchPerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(instanceGroupManagersPatchPerInstanceConfigsReqResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.patchPerInstanceConfigsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.recreateInstances(project, zone, instanceGroupManager, instanceGroupManagersRecreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersRecreateInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation recreateInstances(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersRecreateInstancesRequest
          instanceGroupManagersRecreateInstancesRequestResource) {
    RecreateInstancesInstanceGroupManagerRequest request =
        RecreateInstancesInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersRecreateInstancesRequestResource(
                instanceGroupManagersRecreateInstancesRequestResource)
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   RecreateInstancesInstanceGroupManagerRequest request = RecreateInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersRecreateInstancesRequestResource(instanceGroupManagersRecreateInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.recreateInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation recreateInstances(RecreateInstancesInstanceGroupManagerRequest request) {
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   RecreateInstancesInstanceGroupManagerRequest request = RecreateInstancesInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersRecreateInstancesRequestResource(instanceGroupManagersRecreateInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.recreateInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    return stub.recreateInstancesCallable();
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   int size = 0;
   *   Operation response = instanceGroupManagersClient.resize(project, zone, instanceGroupManager, size);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param size The number of running instances that the managed instance group should maintain at
   *     any given time. The group automatically adds or removes instances to maintain the number of
   *     instances specified by this parameter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(
      String project, String zone, String instanceGroupManager, int size) {
    ResizeInstanceGroupManagerRequest request =
        ResizeInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setSize(size)
            .build();
    return resize(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   int size = 0;
   *   String zone = "";
   *   ResizeInstanceGroupManagerRequest request = ResizeInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setSize(size)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.resize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(ResizeInstanceGroupManagerRequest request) {
    return resizeCallable().call(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   String project = "";
   *   int size = 0;
   *   String zone = "";
   *   ResizeInstanceGroupManagerRequest request = ResizeInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setProject(project)
   *     .setSize(size)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.resizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable() {
    return stub.resizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.setInstanceTemplate(project, zone, instanceGroupManager, instanceGroupManagersSetInstanceTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetInstanceTemplateRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setInstanceTemplate(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersSetInstanceTemplateRequest
          instanceGroupManagersSetInstanceTemplateRequestResource) {
    SetInstanceTemplateInstanceGroupManagerRequest request =
        SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetInstanceTemplateRequestResource(
                instanceGroupManagersSetInstanceTemplateRequestResource)
            .build();
    return setInstanceTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   SetInstanceTemplateInstanceGroupManagerRequest request = SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersSetInstanceTemplateRequestResource(instanceGroupManagersSetInstanceTemplateRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.setInstanceTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setInstanceTemplate(
      SetInstanceTemplateInstanceGroupManagerRequest request) {
    return setInstanceTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you run recreateInstances, run
   * applyUpdatesToInstances, or set the group's updatePolicy.type to PROACTIVE.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   SetInstanceTemplateInstanceGroupManagerRequest request = SetInstanceTemplateInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersSetInstanceTemplateRequestResource(instanceGroupManagersSetInstanceTemplateRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.setInstanceTemplateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    return stub.setInstanceTemplateCallable();
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.setTargetPools(project, zone, instanceGroupManager, instanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located.
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetTargetPoolsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTargetPools(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersSetTargetPoolsRequest
          instanceGroupManagersSetTargetPoolsRequestResource) {
    SetTargetPoolsInstanceGroupManagerRequest request =
        SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetTargetPoolsRequestResource(
                instanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPools(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   SetTargetPoolsInstanceGroupManagerRequest request = SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersSetTargetPoolsRequestResource(instanceGroupManagersSetTargetPoolsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.setTargetPools(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTargetPools(SetTargetPoolsInstanceGroupManagerRequest request) {
    return setTargetPoolsCallable().call(request);
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   SetTargetPoolsInstanceGroupManagerRequest request = SetTargetPoolsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersSetTargetPoolsRequestResource(instanceGroupManagersSetTargetPoolsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.setTargetPoolsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagersClient.updatePerInstanceConfigs(project, zone, instanceGroupManager, instanceGroupManagersUpdatePerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the managed instance group is located. It should conform
   *     to RFC1035.
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersUpdatePerInstanceConfigsReqResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updatePerInstanceConfigs(
      String project,
      String zone,
      String instanceGroupManager,
      InstanceGroupManagersUpdatePerInstanceConfigsReq
          instanceGroupManagersUpdatePerInstanceConfigsReqResource) {
    UpdatePerInstanceConfigsInstanceGroupManagerRequest request =
        UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
                instanceGroupManagersUpdatePerInstanceConfigsReqResource)
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   UpdatePerInstanceConfigsInstanceGroupManagerRequest request = UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(instanceGroupManagersUpdatePerInstanceConfigsReqResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupManagersClient.updatePerInstanceConfigs(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updatePerInstanceConfigs(
      UpdatePerInstanceConfigsInstanceGroupManagerRequest request) {
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
   * try (InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create()) {
   *   String instanceGroupManager = "";
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   UpdatePerInstanceConfigsInstanceGroupManagerRequest request = UpdatePerInstanceConfigsInstanceGroupManagerRequest.newBuilder()
   *     .setInstanceGroupManager(instanceGroupManager)
   *     .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(instanceGroupManagersUpdatePerInstanceConfigsReqResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagersClient.updatePerInstanceConfigsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          Entry<String, InstanceGroupManagersScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Entry<String, InstanceGroupManagersScopedList>>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          Entry<String, InstanceGroupManagersScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Entry<String, InstanceGroupManagersScopedList>>
            context,
        InstanceGroupManagerAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Entry<String, InstanceGroupManagersScopedList>>
            context,
        InstanceGroupManagerAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListInstanceGroupManagersRequest,
                InstanceGroupManagerAggregatedList,
                Entry<String, InstanceGroupManagersScopedList>>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          Entry<String, InstanceGroupManagersScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListInstanceGroupManagersRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
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
          ListInstanceGroupManagersRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListPage> {

    private ListPage(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListInstanceGroupManagersRequest, InstanceGroupManagerList, InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupManagersRequest,
          InstanceGroupManagerList,
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
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage,
          ListErrorsFixedSizeCollection> {

    public static ApiFuture<ListErrorsPagedResponse> createAsync(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<InstanceGroupManagersListErrorsResponse> futureResponse) {
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
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsPage> {

    private ListErrorsPage(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        InstanceGroupManagersListErrorsResponse response) {
      super(context, response);
    }

    private static ListErrorsPage createEmptyPage() {
      return new ListErrorsPage(null, null);
    }

    @Override
    protected ListErrorsPage createPage(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        InstanceGroupManagersListErrorsResponse response) {
      return new ListErrorsPage(context, response);
    }

    @Override
    public ApiFuture<ListErrorsPage> createPageAsync(
        PageContext<
                ListErrorsInstanceGroupManagersRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<InstanceGroupManagersListErrorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListErrorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
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
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage,
          ListManagedInstancesFixedSizeCollection> {

    public static ApiFuture<ListManagedInstancesPagedResponse> createAsync(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<InstanceGroupManagersListManagedInstancesResponse> futureResponse) {
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
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesPage> {

    private ListManagedInstancesPage(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        InstanceGroupManagersListManagedInstancesResponse response) {
      super(context, response);
    }

    private static ListManagedInstancesPage createEmptyPage() {
      return new ListManagedInstancesPage(null, null);
    }

    @Override
    protected ListManagedInstancesPage createPage(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        InstanceGroupManagersListManagedInstancesResponse response) {
      return new ListManagedInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListManagedInstancesPage> createPageAsync(
        PageContext<
                ListManagedInstancesInstanceGroupManagersRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<InstanceGroupManagersListManagedInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagedInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
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
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage,
          ListPerInstanceConfigsFixedSizeCollection> {

    public static ApiFuture<ListPerInstanceConfigsPagedResponse> createAsync(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<InstanceGroupManagersListPerInstanceConfigsResp> futureResponse) {
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
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsPage> {

    private ListPerInstanceConfigsPage(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        InstanceGroupManagersListPerInstanceConfigsResp response) {
      super(context, response);
    }

    private static ListPerInstanceConfigsPage createEmptyPage() {
      return new ListPerInstanceConfigsPage(null, null);
    }

    @Override
    protected ListPerInstanceConfigsPage createPage(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        InstanceGroupManagersListPerInstanceConfigsResp response) {
      return new ListPerInstanceConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListPerInstanceConfigsPage> createPageAsync(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<InstanceGroupManagersListPerInstanceConfigsResp> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPerInstanceConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
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
