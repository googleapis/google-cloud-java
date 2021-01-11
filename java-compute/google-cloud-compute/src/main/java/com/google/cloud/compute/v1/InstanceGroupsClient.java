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
import com.google.cloud.compute.v1.stub.InstanceGroupsStub;
import com.google.cloud.compute.v1.stub.InstanceGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The InstanceGroups API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String instanceGroup = "";
 *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupsClient.addInstances(project, zone, instanceGroup, instanceGroupsAddInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceGroupsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of InstanceGroupsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceGroupsSettings instanceGroupsSettings =
 *     InstanceGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupsClient instanceGroupsClient =
 *     InstanceGroupsClient.create(instanceGroupsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceGroupsSettings instanceGroupsSettings =
 *     InstanceGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupsClient instanceGroupsClient =
 *     InstanceGroupsClient.create(instanceGroupsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupsClient implements BackgroundResource {
  private final InstanceGroupsSettings settings;
  private final InstanceGroupsStub stub;

  /** Constructs an instance of InstanceGroupsClient with default settings. */
  public static final InstanceGroupsClient create() throws IOException {
    return create(InstanceGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceGroupsClient create(InstanceGroupsSettings settings)
      throws IOException {
    return new InstanceGroupsClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupsClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use InstanceGroupsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceGroupsClient create(InstanceGroupsStub stub) {
    return new InstanceGroupsClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected InstanceGroupsClient(InstanceGroupsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceGroupsClient(InstanceGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a list of instances to the specified instance group. All of the instances in the instance
   * group must be in the same network/subnetwork. Read Adding instances for more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroup = "";
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupsClient.addInstances(project, zone, instanceGroup, instanceGroupsAddInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @param instanceGroup The name of the instance group where you are adding instances.
   * @param instanceGroupsAddInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addInstances(
      String project,
      String zone,
      String instanceGroup,
      InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource) {
    AddInstancesInstanceGroupRequest request =
        AddInstancesInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
            .build();
    return addInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a list of instances to the specified instance group. All of the instances in the instance
   * group must be in the same network/subnetwork. Read Adding instances for more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AddInstancesInstanceGroupRequest request = AddInstancesInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupsClient.addInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addInstances(AddInstancesInstanceGroupRequest request) {
    return addInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a list of instances to the specified instance group. All of the instances in the instance
   * group must be in the same network/subnetwork. Read Adding instances for more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AddInstancesInstanceGroupRequest request = AddInstancesInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupsClient.addInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddInstancesInstanceGroupRequest, Operation> addInstancesCallable() {
    return stub.addInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, InstanceGroupsScopedList&gt; element : instanceGroupsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListInstanceGroupsRequest request =
        AggregatedListInstanceGroupsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   AggregatedListInstanceGroupsRequest request = AggregatedListInstanceGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, InstanceGroupsScopedList&gt; element : instanceGroupsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListInstanceGroupsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   AggregatedListInstanceGroupsRequest request = AggregatedListInstanceGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = instanceGroupsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, InstanceGroupsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListInstanceGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   AggregatedListInstanceGroupsRequest request = AggregatedListInstanceGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     InstanceGroupAggregatedList response = instanceGroupsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, InstanceGroupsScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified instance group. The instances in the group are not deleted. Note that
   * instance group must not belong to a backend service. Read Deleting an instance group for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroup = "";
   *   Operation response = instanceGroupsClient.delete(project, zone, instanceGroup);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @param instanceGroup The name of the instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String instanceGroup) {
    DeleteInstanceGroupRequest request =
        DeleteInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroup(instanceGroup)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified instance group. The instances in the group are not deleted. Note that
   * instance group must not belong to a backend service. Read Deleting an instance group for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteInstanceGroupRequest request = DeleteInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteInstanceGroupRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified instance group. The instances in the group are not deleted. Note that
   * instance group must not belong to a backend service. Read Deleting an instance group for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteInstanceGroupRequest request = DeleteInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInstanceGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified zonal instance group. Get a list of available zonal instance groups by
   * making a list() request.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroup = "";
   *   InstanceGroup response = instanceGroupsClient.get(project, zone, instanceGroup);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @param instanceGroup The name of the instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroup get(String project, String zone, String instanceGroup) {
    GetInstanceGroupRequest request =
        GetInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroup(instanceGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified zonal instance group. Get a list of available zonal instance groups by
   * making a list() request.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   String project = "";
   *   String zone = "";
   *   GetInstanceGroupRequest request = GetInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   InstanceGroup response = instanceGroupsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroup get(GetInstanceGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified zonal instance group. Get a list of available zonal instance groups by
   * making a list() request.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   String project = "";
   *   String zone = "";
   *   GetInstanceGroupRequest request = GetInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;InstanceGroup&gt; future = instanceGroupsClient.getCallable().futureCall(request);
   *   // Do something
   *   InstanceGroup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInstanceGroupRequest, InstanceGroup> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   Operation response = instanceGroupsClient.insert(project, zone, instanceGroupResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where you want to create the instance group.
   * @param instanceGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String zone, InstanceGroup instanceGroupResource) {
    InsertInstanceGroupRequest request =
        InsertInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroupResource(instanceGroupResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertInstanceGroupRequest request = InsertInstanceGroupRequest.newBuilder()
   *     .setInstanceGroupResource(instanceGroupResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertInstanceGroupRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertInstanceGroupRequest request = InsertInstanceGroupRequest.newBuilder()
   *     .setInstanceGroupResource(instanceGroupResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertInstanceGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of zonal instance group resources contained within the specified zone.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (InstanceGroup element : instanceGroupsClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListInstanceGroupsRequest request =
        ListInstanceGroupsRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of zonal instance group resources contained within the specified zone.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListInstanceGroupsRequest request = ListInstanceGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (InstanceGroup element : instanceGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInstanceGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of zonal instance group resources contained within the specified zone.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListInstanceGroupsRequest request = ListInstanceGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = instanceGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstanceGroupsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of zonal instance group resources contained within the specified zone.
   *
   * <p>For managed instance groups, use the instanceGroupManagers or regionInstanceGroupManagers
   * methods instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListInstanceGroupsRequest request = ListInstanceGroupsRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     InstanceGroupList response = instanceGroupsClient.listCallable().call(request);
   *     for (InstanceGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group. The orderBy query parameter is not
   * supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroup = "";
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   for (InstanceWithNamedPorts element : instanceGroupsClient.listInstances(project, zone, instanceGroup, instanceGroupsListInstancesRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @param instanceGroup The name of the instance group from which you want to generate a list of
   *     included instances.
   * @param instanceGroupsListInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(
      String project,
      String zone,
      String instanceGroup,
      InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource) {
    ListInstancesInstanceGroupsRequest request =
        ListInstancesInstanceGroupsRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsListInstancesRequestResource(
                instanceGroupsListInstancesRequestResource)
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group. The orderBy query parameter is not
   * supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ListInstancesInstanceGroupsRequest request = ListInstancesInstanceGroupsRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsListInstancesRequestResource(instanceGroupsListInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (InstanceWithNamedPorts element : instanceGroupsClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(
      ListInstancesInstanceGroupsRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group. The orderBy query parameter is not
   * supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ListInstancesInstanceGroupsRequest request = ListInstancesInstanceGroupsRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsListInstancesRequestResource(instanceGroupsListInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListInstancesPagedResponse&gt; future = instanceGroupsClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceWithNamedPorts element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInstancesInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group. The orderBy query parameter is not
   * supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ListInstancesInstanceGroupsRequest request = ListInstancesInstanceGroupsRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsListInstancesRequestResource(instanceGroupsListInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     InstanceGroupsListInstances response = instanceGroupsClient.listInstancesCallable().call(request);
   *     for (InstanceWithNamedPorts element : response.getItemsList()) {
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
  public final UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes one or more instances from the specified instance group, but does not delete those
   * instances.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroup = "";
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupsClient.removeInstances(project, zone, instanceGroup, instanceGroupsRemoveInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @param instanceGroup The name of the instance group where the specified instances will be
   *     removed.
   * @param instanceGroupsRemoveInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeInstances(
      String project,
      String zone,
      String instanceGroup,
      InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource) {
    RemoveInstancesInstanceGroupRequest request =
        RemoveInstancesInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsRemoveInstancesRequestResource(
                instanceGroupsRemoveInstancesRequestResource)
            .build();
    return removeInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes one or more instances from the specified instance group, but does not delete those
   * instances.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   RemoveInstancesInstanceGroupRequest request = RemoveInstancesInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsRemoveInstancesRequestResource(instanceGroupsRemoveInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupsClient.removeInstances(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeInstances(RemoveInstancesInstanceGroupRequest request) {
    return removeInstancesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes one or more instances from the specified instance group, but does not delete those
   * instances.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration before the VM instance is removed or
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   RemoveInstancesInstanceGroupRequest request = RemoveInstancesInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsRemoveInstancesRequestResource(instanceGroupsRemoveInstancesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupsClient.removeInstancesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesCallable() {
    return stub.removeInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String instanceGroup = "";
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   Operation response = instanceGroupsClient.setNamedPorts(project, zone, instanceGroup, instanceGroupsSetNamedPortsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone where the instance group is located.
   * @param instanceGroup The name of the instance group where the named ports are updated.
   * @param instanceGroupsSetNamedPortsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNamedPorts(
      String project,
      String zone,
      String instanceGroup,
      InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource) {
    SetNamedPortsInstanceGroupRequest request =
        SetNamedPortsInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsSetNamedPortsRequestResource(
                instanceGroupsSetNamedPortsRequestResource)
            .build();
    return setNamedPorts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   SetNamedPortsInstanceGroupRequest request = SetNamedPortsInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsSetNamedPortsRequestResource(instanceGroupsSetNamedPortsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = instanceGroupsClient.setNamedPorts(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNamedPorts(SetNamedPortsInstanceGroupRequest request) {
    return setNamedPortsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupsClient instanceGroupsClient = InstanceGroupsClient.create()) {
   *   String instanceGroup = "";
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   SetNamedPortsInstanceGroupRequest request = SetNamedPortsInstanceGroupRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup)
   *     .setInstanceGroupsSetNamedPortsRequestResource(instanceGroupsSetNamedPortsRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupsClient.setNamedPortsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsCallable() {
    return stub.setNamedPortsCallable();
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
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          Entry<String, InstanceGroupsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListInstanceGroupsRequest,
                InstanceGroupAggregatedList,
                Entry<String, InstanceGroupsScopedList>>
            context,
        ApiFuture<InstanceGroupAggregatedList> futureResponse) {
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
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          Entry<String, InstanceGroupsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListInstanceGroupsRequest,
                InstanceGroupAggregatedList,
                Entry<String, InstanceGroupsScopedList>>
            context,
        InstanceGroupAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListInstanceGroupsRequest,
                InstanceGroupAggregatedList,
                Entry<String, InstanceGroupsScopedList>>
            context,
        InstanceGroupAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListInstanceGroupsRequest,
                InstanceGroupAggregatedList,
                Entry<String, InstanceGroupsScopedList>>
            context,
        ApiFuture<InstanceGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          Entry<String, InstanceGroupsScopedList>,
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
          ListInstanceGroupsRequest,
          InstanceGroupList,
          InstanceGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup> context,
        ApiFuture<InstanceGroupList> futureResponse) {
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
      extends AbstractPage<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup, ListPage> {

    private ListPage(
        PageContext<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup> context,
        InstanceGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup> context,
        InstanceGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListInstanceGroupsRequest, InstanceGroupList, InstanceGroup> context,
        ApiFuture<InstanceGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupsRequest,
          InstanceGroupList,
          InstanceGroup,
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<
                ListInstancesInstanceGroupsRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<InstanceGroupsListInstances> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstancesPage, ListInstancesPagedResponse>() {
            @Override
            public ListInstancesPagedResponse apply(ListInstancesPage input) {
              return new ListInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesPage> {

    private ListInstancesPage(
        PageContext<
                ListInstancesInstanceGroupsRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        InstanceGroupsListInstances response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<
                ListInstancesInstanceGroupsRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        InstanceGroupsListInstances response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<
                ListInstancesInstanceGroupsRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<InstanceGroupsListInstances> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }
}
