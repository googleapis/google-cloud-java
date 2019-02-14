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
import com.google.cloud.compute.v1.stub.InstanceGroupStub;
import com.google.cloud.compute.v1.stub.InstanceGroupStubSettings;
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
 * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
 *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
 *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupClient.addInstancesInstanceGroup(instanceGroup, instanceGroupsAddInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceGroupClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of InstanceGroupSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceGroupSettings instanceGroupSettings =
 *     InstanceGroupSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupClient instanceGroupClient =
 *     InstanceGroupClient.create(instanceGroupSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceGroupSettings instanceGroupSettings =
 *     InstanceGroupSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupClient instanceGroupClient =
 *     InstanceGroupClient.create(instanceGroupSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupClient implements BackgroundResource {
  private final InstanceGroupSettings settings;
  private final InstanceGroupStub stub;

  /** Constructs an instance of InstanceGroupClient with default settings. */
  public static final InstanceGroupClient create() throws IOException {
    return create(InstanceGroupSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceGroupClient create(InstanceGroupSettings settings)
      throws IOException {
    return new InstanceGroupClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use InstanceGroupSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceGroupClient create(InstanceGroupStub stub) {
    return new InstanceGroupClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected InstanceGroupClient(InstanceGroupSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceGroupStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceGroupClient(InstanceGroupStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupStub getStub() {
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupClient.addInstancesInstanceGroup(instanceGroup, instanceGroupsAddInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group where you are adding instances.
   * @param instanceGroupsAddInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addInstancesInstanceGroup(
      ProjectZoneInstanceGroupName instanceGroup,
      InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource) {

    AddInstancesInstanceGroupHttpRequest request =
        AddInstancesInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
            .build();
    return addInstancesInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a list of instances to the specified instance group. All of the instances in the instance
   * group must be in the same network/subnetwork. Read Adding instances for more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupClient.addInstancesInstanceGroup(instanceGroup.toString(), instanceGroupsAddInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group where you are adding instances.
   * @param instanceGroupsAddInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addInstancesInstanceGroup(
      String instanceGroup,
      InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource) {

    AddInstancesInstanceGroupHttpRequest request =
        AddInstancesInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
            .build();
    return addInstancesInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a list of instances to the specified instance group. All of the instances in the instance
   * group must be in the same network/subnetwork. Read Adding instances for more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   AddInstancesInstanceGroupHttpRequest request = AddInstancesInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupClient.addInstancesInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addInstancesInstanceGroup(AddInstancesInstanceGroupHttpRequest request) {
    return addInstancesInstanceGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a list of instances to the specified instance group. All of the instances in the instance
   * group must be in the same network/subnetwork. Read Adding instances for more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsAddInstancesRequest instanceGroupsAddInstancesRequestResource = InstanceGroupsAddInstancesRequest.newBuilder().build();
   *   AddInstancesInstanceGroupHttpRequest request = AddInstancesInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsAddInstancesRequestResource(instanceGroupsAddInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupClient.addInstancesInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupCallable() {
    return stub.addInstancesInstanceGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstanceGroupsScopedList element : instanceGroupClient.aggregatedListInstanceGroups(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupsPagedResponse aggregatedListInstanceGroups(
      ProjectName project) {
    AggregatedListInstanceGroupsHttpRequest request =
        AggregatedListInstanceGroupsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstanceGroupsScopedList element : instanceGroupClient.aggregatedListInstanceGroups(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupsPagedResponse aggregatedListInstanceGroups(
      String project) {
    AggregatedListInstanceGroupsHttpRequest request =
        AggregatedListInstanceGroupsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstanceGroupsHttpRequest request = AggregatedListInstanceGroupsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (InstanceGroupsScopedList element : instanceGroupClient.aggregatedListInstanceGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupsPagedResponse aggregatedListInstanceGroups(
      AggregatedListInstanceGroupsHttpRequest request) {
    return aggregatedListInstanceGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstanceGroupsHttpRequest request = AggregatedListInstanceGroupsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListInstanceGroupsPagedResponse&gt; future = instanceGroupClient.aggregatedListInstanceGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListInstanceGroupsHttpRequest, AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsPagedCallable() {
    return stub.aggregatedListInstanceGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups and sorts them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstanceGroupsHttpRequest request = AggregatedListInstanceGroupsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     InstanceGroupAggregatedList response = instanceGroupClient.aggregatedListInstanceGroupsCallable().call(request);
   *     for (InstanceGroupsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
      aggregatedListInstanceGroupsCallable() {
    return stub.aggregatedListInstanceGroupsCallable();
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   Operation response = instanceGroupClient.deleteInstanceGroup(instanceGroup);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroup(ProjectZoneInstanceGroupName instanceGroup) {

    DeleteInstanceGroupHttpRequest request =
        DeleteInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .build();
    return deleteInstanceGroup(request);
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   Operation response = instanceGroupClient.deleteInstanceGroup(instanceGroup.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroup(String instanceGroup) {

    DeleteInstanceGroupHttpRequest request =
        DeleteInstanceGroupHttpRequest.newBuilder().setInstanceGroup(instanceGroup).build();
    return deleteInstanceGroup(request);
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   DeleteInstanceGroupHttpRequest request = DeleteInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .build();
   *   Operation response = instanceGroupClient.deleteInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroup(DeleteInstanceGroupHttpRequest request) {
    return deleteInstanceGroupCallable().call(request);
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   DeleteInstanceGroupHttpRequest request = DeleteInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupClient.deleteInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstanceGroupHttpRequest, Operation>
      deleteInstanceGroupCallable() {
    return stub.deleteInstanceGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group. Gets a list of available instance groups by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroup response = instanceGroupClient.getInstanceGroup(instanceGroup);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroup getInstanceGroup(ProjectZoneInstanceGroupName instanceGroup) {

    GetInstanceGroupHttpRequest request =
        GetInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .build();
    return getInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group. Gets a list of available instance groups by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroup response = instanceGroupClient.getInstanceGroup(instanceGroup.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroup getInstanceGroup(String instanceGroup) {

    GetInstanceGroupHttpRequest request =
        GetInstanceGroupHttpRequest.newBuilder().setInstanceGroup(instanceGroup).build();
    return getInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group. Gets a list of available instance groups by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   GetInstanceGroupHttpRequest request = GetInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .build();
   *   InstanceGroup response = instanceGroupClient.getInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroup getInstanceGroup(GetInstanceGroupHttpRequest request) {
    return getInstanceGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group. Gets a list of available instance groups by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   GetInstanceGroupHttpRequest request = GetInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .build();
   *   ApiFuture&lt;InstanceGroup&gt; future = instanceGroupClient.getInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   InstanceGroup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInstanceGroupHttpRequest, InstanceGroup>
      getInstanceGroupCallable() {
    return stub.getInstanceGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   Operation response = instanceGroupClient.insertInstanceGroup(zone, instanceGroupResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the instance group.
   * @param instanceGroupResource InstanceGroups (== resource_for beta.instanceGroups ==) (==
   *     resource_for v1.instanceGroups ==) (== resource_for beta.regionInstanceGroups ==) (==
   *     resource_for v1.regionInstanceGroups ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroup(
      ProjectZoneName zone, InstanceGroup instanceGroupResource) {

    InsertInstanceGroupHttpRequest request =
        InsertInstanceGroupHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setInstanceGroupResource(instanceGroupResource)
            .build();
    return insertInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   Operation response = instanceGroupClient.insertInstanceGroup(zone.toString(), instanceGroupResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the instance group.
   * @param instanceGroupResource InstanceGroups (== resource_for beta.instanceGroups ==) (==
   *     resource_for v1.instanceGroups ==) (== resource_for beta.regionInstanceGroups ==) (==
   *     resource_for v1.regionInstanceGroups ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroup(String zone, InstanceGroup instanceGroupResource) {

    InsertInstanceGroupHttpRequest request =
        InsertInstanceGroupHttpRequest.newBuilder()
            .setZone(zone)
            .setInstanceGroupResource(instanceGroupResource)
            .build();
    return insertInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   InsertInstanceGroupHttpRequest request = InsertInstanceGroupHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setInstanceGroupResource(instanceGroupResource)
   *     .build();
   *   Operation response = instanceGroupClient.insertInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroup(InsertInstanceGroupHttpRequest request) {
    return insertInstanceGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance group in the specified project using the parameters that are included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroup instanceGroupResource = InstanceGroup.newBuilder().build();
   *   InsertInstanceGroupHttpRequest request = InsertInstanceGroupHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setInstanceGroupResource(instanceGroupResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupClient.insertInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertInstanceGroupHttpRequest, Operation>
      insertInstanceGroupCallable() {
    return stub.insertInstanceGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups that are located in the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (InstanceGroup element : instanceGroupClient.listInstanceGroups(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupsPagedResponse listInstanceGroups(ProjectZoneName zone) {
    ListInstanceGroupsHttpRequest request =
        ListInstanceGroupsHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups that are located in the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (InstanceGroup element : instanceGroupClient.listInstanceGroups(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupsPagedResponse listInstanceGroups(String zone) {
    ListInstanceGroupsHttpRequest request =
        ListInstanceGroupsHttpRequest.newBuilder().setZone(zone).build();
    return listInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups that are located in the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupsHttpRequest request = ListInstanceGroupsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (InstanceGroup element : instanceGroupClient.listInstanceGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupsPagedResponse listInstanceGroups(
      ListInstanceGroupsHttpRequest request) {
    return listInstanceGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups that are located in the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupsHttpRequest request = ListInstanceGroupsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListInstanceGroupsPagedResponse&gt; future = instanceGroupClient.listInstanceGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListInstanceGroupsHttpRequest, ListInstanceGroupsPagedResponse>
      listInstanceGroupsPagedCallable() {
    return stub.listInstanceGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance groups that are located in the specified project and zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupsHttpRequest request = ListInstanceGroupsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     InstanceGroupList response = instanceGroupClient.listInstanceGroupsCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListInstanceGroupsHttpRequest, InstanceGroupList>
      listInstanceGroupsCallable() {
    return stub.listInstanceGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   for (InstanceWithNamedPorts element : instanceGroupClient.listInstancesInstanceGroups(instanceGroup, instanceGroupsListInstancesRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group from which you want to generate a list of
   *     included instances.
   * @param instanceGroupsListInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesInstanceGroupsPagedResponse listInstancesInstanceGroups(
      ProjectZoneInstanceGroupName instanceGroup,
      InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource) {
    ListInstancesInstanceGroupsHttpRequest request =
        ListInstancesInstanceGroupsHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .setInstanceGroupsListInstancesRequestResource(
                instanceGroupsListInstancesRequestResource)
            .build();
    return listInstancesInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   for (InstanceWithNamedPorts element : instanceGroupClient.listInstancesInstanceGroups(instanceGroup.toString(), instanceGroupsListInstancesRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group from which you want to generate a list of
   *     included instances.
   * @param instanceGroupsListInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesInstanceGroupsPagedResponse listInstancesInstanceGroups(
      String instanceGroup,
      InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource) {
    ListInstancesInstanceGroupsHttpRequest request =
        ListInstancesInstanceGroupsHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsListInstancesRequestResource(
                instanceGroupsListInstancesRequestResource)
            .build();
    return listInstancesInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   ListInstancesInstanceGroupsHttpRequest request = ListInstancesInstanceGroupsHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsListInstancesRequestResource(instanceGroupsListInstancesRequestResource)
   *     .build();
   *   for (InstanceWithNamedPorts element : instanceGroupClient.listInstancesInstanceGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesInstanceGroupsPagedResponse listInstancesInstanceGroups(
      ListInstancesInstanceGroupsHttpRequest request) {
    return listInstancesInstanceGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   ListInstancesInstanceGroupsHttpRequest request = ListInstancesInstanceGroupsHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsListInstancesRequestResource(instanceGroupsListInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;ListInstancesInstanceGroupsPagedResponse&gt; future = instanceGroupClient.listInstancesInstanceGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceWithNamedPorts element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListInstancesInstanceGroupsHttpRequest, ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsPagedCallable() {
    return stub.listInstancesInstanceGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsListInstancesRequest instanceGroupsListInstancesRequestResource = InstanceGroupsListInstancesRequest.newBuilder().build();
   *   ListInstancesInstanceGroupsHttpRequest request = ListInstancesInstanceGroupsHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsListInstancesRequestResource(instanceGroupsListInstancesRequestResource)
   *     .build();
   *   while (true) {
   *     InstanceGroupsListInstances response = instanceGroupClient.listInstancesInstanceGroupsCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
      listInstancesInstanceGroupsCallable() {
    return stub.listInstancesInstanceGroupsCallable();
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupClient.removeInstancesInstanceGroup(instanceGroup, instanceGroupsRemoveInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group where the specified instances will be
   *     removed.
   * @param instanceGroupsRemoveInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeInstancesInstanceGroup(
      ProjectZoneInstanceGroupName instanceGroup,
      InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource) {

    RemoveInstancesInstanceGroupHttpRequest request =
        RemoveInstancesInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .setInstanceGroupsRemoveInstancesRequestResource(
                instanceGroupsRemoveInstancesRequestResource)
            .build();
    return removeInstancesInstanceGroup(request);
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupClient.removeInstancesInstanceGroup(instanceGroup.toString(), instanceGroupsRemoveInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group where the specified instances will be
   *     removed.
   * @param instanceGroupsRemoveInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeInstancesInstanceGroup(
      String instanceGroup,
      InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource) {

    RemoveInstancesInstanceGroupHttpRequest request =
        RemoveInstancesInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsRemoveInstancesRequestResource(
                instanceGroupsRemoveInstancesRequestResource)
            .build();
    return removeInstancesInstanceGroup(request);
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   RemoveInstancesInstanceGroupHttpRequest request = RemoveInstancesInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsRemoveInstancesRequestResource(instanceGroupsRemoveInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupClient.removeInstancesInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeInstancesInstanceGroup(
      RemoveInstancesInstanceGroupHttpRequest request) {
    return removeInstancesInstanceGroupCallable().call(request);
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
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsRemoveInstancesRequest instanceGroupsRemoveInstancesRequestResource = InstanceGroupsRemoveInstancesRequest.newBuilder().build();
   *   RemoveInstancesInstanceGroupHttpRequest request = RemoveInstancesInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsRemoveInstancesRequestResource(instanceGroupsRemoveInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupClient.removeInstancesInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupCallable() {
    return stub.removeInstancesInstanceGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   Operation response = instanceGroupClient.setNamedPortsInstanceGroup(instanceGroup, instanceGroupsSetNamedPortsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group where the named ports are updated.
   * @param instanceGroupsSetNamedPortsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNamedPortsInstanceGroup(
      ProjectZoneInstanceGroupName instanceGroup,
      InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource) {

    SetNamedPortsInstanceGroupHttpRequest request =
        SetNamedPortsInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .setInstanceGroupsSetNamedPortsRequestResource(
                instanceGroupsSetNamedPortsRequestResource)
            .build();
    return setNamedPortsInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   Operation response = instanceGroupClient.setNamedPortsInstanceGroup(instanceGroup.toString(), instanceGroupsSetNamedPortsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the instance group where the named ports are updated.
   * @param instanceGroupsSetNamedPortsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNamedPortsInstanceGroup(
      String instanceGroup,
      InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource) {

    SetNamedPortsInstanceGroupHttpRequest request =
        SetNamedPortsInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup)
            .setInstanceGroupsSetNamedPortsRequestResource(
                instanceGroupsSetNamedPortsRequestResource)
            .build();
    return setNamedPortsInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   SetNamedPortsInstanceGroupHttpRequest request = SetNamedPortsInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsSetNamedPortsRequestResource(instanceGroupsSetNamedPortsRequestResource)
   *     .build();
   *   Operation response = instanceGroupClient.setNamedPortsInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNamedPortsInstanceGroup(SetNamedPortsInstanceGroupHttpRequest request) {
    return setNamedPortsInstanceGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupClient instanceGroupClient = InstanceGroupClient.create()) {
   *   ProjectZoneInstanceGroupName instanceGroup = ProjectZoneInstanceGroupName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP]");
   *   InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource = InstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   SetNamedPortsInstanceGroupHttpRequest request = SetNamedPortsInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setInstanceGroupsSetNamedPortsRequestResource(instanceGroupsSetNamedPortsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupClient.setNamedPortsInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupCallable() {
    return stub.setNamedPortsInstanceGroupCallable();
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

  public static class AggregatedListInstanceGroupsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListInstanceGroupsHttpRequest,
          InstanceGroupAggregatedList,
          InstanceGroupsScopedList,
          AggregatedListInstanceGroupsPage,
          AggregatedListInstanceGroupsFixedSizeCollection> {

    public static ApiFuture<AggregatedListInstanceGroupsPagedResponse> createAsync(
        PageContext<
                AggregatedListInstanceGroupsHttpRequest,
                InstanceGroupAggregatedList,
                InstanceGroupsScopedList>
            context,
        ApiFuture<InstanceGroupAggregatedList> futureResponse) {
      ApiFuture<AggregatedListInstanceGroupsPage> futurePage =
          AggregatedListInstanceGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListInstanceGroupsPage, AggregatedListInstanceGroupsPagedResponse>() {
            @Override
            public AggregatedListInstanceGroupsPagedResponse apply(
                AggregatedListInstanceGroupsPage input) {
              return new AggregatedListInstanceGroupsPagedResponse(input);
            }
          });
    }

    private AggregatedListInstanceGroupsPagedResponse(AggregatedListInstanceGroupsPage page) {
      super(page, AggregatedListInstanceGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListInstanceGroupsPage
      extends AbstractPage<
          AggregatedListInstanceGroupsHttpRequest,
          InstanceGroupAggregatedList,
          InstanceGroupsScopedList,
          AggregatedListInstanceGroupsPage> {

    private AggregatedListInstanceGroupsPage(
        PageContext<
                AggregatedListInstanceGroupsHttpRequest,
                InstanceGroupAggregatedList,
                InstanceGroupsScopedList>
            context,
        InstanceGroupAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListInstanceGroupsPage createEmptyPage() {
      return new AggregatedListInstanceGroupsPage(null, null);
    }

    @Override
    protected AggregatedListInstanceGroupsPage createPage(
        PageContext<
                AggregatedListInstanceGroupsHttpRequest,
                InstanceGroupAggregatedList,
                InstanceGroupsScopedList>
            context,
        InstanceGroupAggregatedList response) {
      return new AggregatedListInstanceGroupsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListInstanceGroupsPage> createPageAsync(
        PageContext<
                AggregatedListInstanceGroupsHttpRequest,
                InstanceGroupAggregatedList,
                InstanceGroupsScopedList>
            context,
        ApiFuture<InstanceGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListInstanceGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstanceGroupsHttpRequest,
          InstanceGroupAggregatedList,
          InstanceGroupsScopedList,
          AggregatedListInstanceGroupsPage,
          AggregatedListInstanceGroupsFixedSizeCollection> {

    private AggregatedListInstanceGroupsFixedSizeCollection(
        List<AggregatedListInstanceGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListInstanceGroupsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListInstanceGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListInstanceGroupsFixedSizeCollection createCollection(
        List<AggregatedListInstanceGroupsPage> pages, int collectionSize) {
      return new AggregatedListInstanceGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstanceGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListInstanceGroupsHttpRequest,
          InstanceGroupList,
          InstanceGroup,
          ListInstanceGroupsPage,
          ListInstanceGroupsFixedSizeCollection> {

    public static ApiFuture<ListInstanceGroupsPagedResponse> createAsync(
        PageContext<ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup> context,
        ApiFuture<InstanceGroupList> futureResponse) {
      ApiFuture<ListInstanceGroupsPage> futurePage =
          ListInstanceGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstanceGroupsPage, ListInstanceGroupsPagedResponse>() {
            @Override
            public ListInstanceGroupsPagedResponse apply(ListInstanceGroupsPage input) {
              return new ListInstanceGroupsPagedResponse(input);
            }
          });
    }

    private ListInstanceGroupsPagedResponse(ListInstanceGroupsPage page) {
      super(page, ListInstanceGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstanceGroupsPage
      extends AbstractPage<
          ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup, ListInstanceGroupsPage> {

    private ListInstanceGroupsPage(
        PageContext<ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup> context,
        InstanceGroupList response) {
      super(context, response);
    }

    private static ListInstanceGroupsPage createEmptyPage() {
      return new ListInstanceGroupsPage(null, null);
    }

    @Override
    protected ListInstanceGroupsPage createPage(
        PageContext<ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup> context,
        InstanceGroupList response) {
      return new ListInstanceGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListInstanceGroupsPage> createPageAsync(
        PageContext<ListInstanceGroupsHttpRequest, InstanceGroupList, InstanceGroup> context,
        ApiFuture<InstanceGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstanceGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupsHttpRequest,
          InstanceGroupList,
          InstanceGroup,
          ListInstanceGroupsPage,
          ListInstanceGroupsFixedSizeCollection> {

    private ListInstanceGroupsFixedSizeCollection(
        List<ListInstanceGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstanceGroupsFixedSizeCollection createEmptyCollection() {
      return new ListInstanceGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstanceGroupsFixedSizeCollection createCollection(
        List<ListInstanceGroupsPage> pages, int collectionSize) {
      return new ListInstanceGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstancesInstanceGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesInstanceGroupsHttpRequest,
          InstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesInstanceGroupsPage,
          ListInstancesInstanceGroupsFixedSizeCollection> {

    public static ApiFuture<ListInstancesInstanceGroupsPagedResponse> createAsync(
        PageContext<
                ListInstancesInstanceGroupsHttpRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<InstanceGroupsListInstances> futureResponse) {
      ApiFuture<ListInstancesInstanceGroupsPage> futurePage =
          ListInstancesInstanceGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListInstancesInstanceGroupsPage, ListInstancesInstanceGroupsPagedResponse>() {
            @Override
            public ListInstancesInstanceGroupsPagedResponse apply(
                ListInstancesInstanceGroupsPage input) {
              return new ListInstancesInstanceGroupsPagedResponse(input);
            }
          });
    }

    private ListInstancesInstanceGroupsPagedResponse(ListInstancesInstanceGroupsPage page) {
      super(page, ListInstancesInstanceGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesInstanceGroupsPage
      extends AbstractPage<
          ListInstancesInstanceGroupsHttpRequest,
          InstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesInstanceGroupsPage> {

    private ListInstancesInstanceGroupsPage(
        PageContext<
                ListInstancesInstanceGroupsHttpRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        InstanceGroupsListInstances response) {
      super(context, response);
    }

    private static ListInstancesInstanceGroupsPage createEmptyPage() {
      return new ListInstancesInstanceGroupsPage(null, null);
    }

    @Override
    protected ListInstancesInstanceGroupsPage createPage(
        PageContext<
                ListInstancesInstanceGroupsHttpRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        InstanceGroupsListInstances response) {
      return new ListInstancesInstanceGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesInstanceGroupsPage> createPageAsync(
        PageContext<
                ListInstancesInstanceGroupsHttpRequest,
                InstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<InstanceGroupsListInstances> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesInstanceGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesInstanceGroupsHttpRequest,
          InstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesInstanceGroupsPage,
          ListInstancesInstanceGroupsFixedSizeCollection> {

    private ListInstancesInstanceGroupsFixedSizeCollection(
        List<ListInstancesInstanceGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesInstanceGroupsFixedSizeCollection createEmptyCollection() {
      return new ListInstancesInstanceGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesInstanceGroupsFixedSizeCollection createCollection(
        List<ListInstancesInstanceGroupsPage> pages, int collectionSize) {
      return new ListInstancesInstanceGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
