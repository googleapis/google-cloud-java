/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.RegionInstanceGroupsStub;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionInstanceGroups API.
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
 * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
 *     RegionInstanceGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String instanceGroup = "instanceGroup-1404696854";
 *   InstanceGroup response = regionInstanceGroupsClient.get(project, region, instanceGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionInstanceGroupsClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of RegionInstanceGroupsSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionInstanceGroupsSettings regionInstanceGroupsSettings =
 *     RegionInstanceGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstanceGroupsClient regionInstanceGroupsClient =
 *     RegionInstanceGroupsClient.create(regionInstanceGroupsSettings);
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
 * RegionInstanceGroupsSettings regionInstanceGroupsSettings =
 *     RegionInstanceGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstanceGroupsClient regionInstanceGroupsClient =
 *     RegionInstanceGroupsClient.create(regionInstanceGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionInstanceGroupsClient implements BackgroundResource {
  private final RegionInstanceGroupsSettings settings;
  private final RegionInstanceGroupsStub stub;

  /** Constructs an instance of RegionInstanceGroupsClient with default settings. */
  public static final RegionInstanceGroupsClient create() throws IOException {
    return create(RegionInstanceGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstanceGroupsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionInstanceGroupsClient create(RegionInstanceGroupsSettings settings)
      throws IOException {
    return new RegionInstanceGroupsClient(settings);
  }

  /**
   * Constructs an instance of RegionInstanceGroupsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionInstanceGroupsSettings).
   */
  public static final RegionInstanceGroupsClient create(RegionInstanceGroupsStub stub) {
    return new RegionInstanceGroupsClient(stub);
  }

  /**
   * Constructs an instance of RegionInstanceGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionInstanceGroupsClient(RegionInstanceGroupsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstanceGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionInstanceGroupsClient(RegionInstanceGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstanceGroupsSettings getSettings() {
    return settings;
  }

  public RegionInstanceGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroup = "instanceGroup-1404696854";
   *   InstanceGroup response = regionInstanceGroupsClient.get(project, region, instanceGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroup Name of the instance group resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroup get(String project, String region, String instanceGroup) {
    GetRegionInstanceGroupRequest request =
        GetRegionInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroup(instanceGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   GetRegionInstanceGroupRequest request =
   *       GetRegionInstanceGroupRequest.newBuilder()
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   InstanceGroup response = regionInstanceGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceGroup get(GetRegionInstanceGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   GetRegionInstanceGroupRequest request =
   *       GetRegionInstanceGroupRequest.newBuilder()
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<InstanceGroup> future =
   *       regionInstanceGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstanceGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionInstanceGroupRequest, InstanceGroup> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (InstanceGroup element : regionInstanceGroupsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionInstanceGroupsRequest request =
        ListRegionInstanceGroupsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   ListRegionInstanceGroupsRequest request =
   *       ListRegionInstanceGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InstanceGroup element : regionInstanceGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionInstanceGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   ListRegionInstanceGroupsRequest request =
   *       ListRegionInstanceGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InstanceGroup> future =
   *       regionInstanceGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionInstanceGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   ListRegionInstanceGroupsRequest request =
   *       ListRegionInstanceGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     RegionInstanceGroupList response = regionInstanceGroupsClient.listCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListRegionInstanceGroupsRequest, RegionInstanceGroupList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running. The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroup = "instanceGroup-1404696854";
   *   RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource =
   *       RegionInstanceGroupsListInstancesRequest.newBuilder().build();
   *   for (InstanceWithNamedPorts element :
   *       regionInstanceGroupsClient
   *           .listInstances(
   *               project, region, instanceGroup, regionInstanceGroupsListInstancesRequestResource)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroup Name of the regional instance group for which we want to list the
   *     instances.
   * @param regionInstanceGroupsListInstancesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(
      String project,
      String region,
      String instanceGroup,
      RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource) {
    ListInstancesRegionInstanceGroupsRequest request =
        ListInstancesRegionInstanceGroupsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroup(instanceGroup)
            .setRegionInstanceGroupsListInstancesRequestResource(
                regionInstanceGroupsListInstancesRequestResource)
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running. The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   ListInstancesRegionInstanceGroupsRequest request =
   *       ListInstancesRegionInstanceGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionInstanceGroupsListInstancesRequestResource(
   *               RegionInstanceGroupsListInstancesRequest.newBuilder().build())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InstanceWithNamedPorts element :
   *       regionInstanceGroupsClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(
      ListInstancesRegionInstanceGroupsRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running. The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   ListInstancesRegionInstanceGroupsRequest request =
   *       ListInstancesRegionInstanceGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionInstanceGroupsListInstancesRequestResource(
   *               RegionInstanceGroupsListInstancesRequest.newBuilder().build())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InstanceWithNamedPorts> future =
   *       regionInstanceGroupsClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceWithNamedPorts element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRegionInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running. The orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   ListInstancesRegionInstanceGroupsRequest request =
   *       ListInstancesRegionInstanceGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionInstanceGroupsListInstancesRequestResource(
   *               RegionInstanceGroupsListInstancesRequest.newBuilder().build())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     RegionInstanceGroupsListInstances response =
   *         regionInstanceGroupsClient.listInstancesCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<
          ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
      listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceGroup = "instanceGroup-1404696854";
   *   RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource =
   *       RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   Operation response =
   *       regionInstanceGroupsClient
   *           .setNamedPortsAsync(
   *               project, region, instanceGroup, regionInstanceGroupsSetNamedPortsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param instanceGroup The name of the regional instance group where the named ports are updated.
   * @param regionInstanceGroupsSetNamedPortsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setNamedPortsAsync(
      String project,
      String region,
      String instanceGroup,
      RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource) {
    SetNamedPortsRegionInstanceGroupRequest request =
        SetNamedPortsRegionInstanceGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceGroup(instanceGroup)
            .setRegionInstanceGroupsSetNamedPortsRequestResource(
                regionInstanceGroupsSetNamedPortsRequestResource)
            .build();
    return setNamedPortsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   SetNamedPortsRegionInstanceGroupRequest request =
   *       SetNamedPortsRegionInstanceGroupRequest.newBuilder()
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionInstanceGroupsSetNamedPortsRequestResource(
   *               RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionInstanceGroupsClient.setNamedPortsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setNamedPortsAsync(
      SetNamedPortsRegionInstanceGroupRequest request) {
    return setNamedPortsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   SetNamedPortsRegionInstanceGroupRequest request =
   *       SetNamedPortsRegionInstanceGroupRequest.newBuilder()
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionInstanceGroupsSetNamedPortsRequestResource(
   *               RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstanceGroupsClient.setNamedPortsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationCallable() {
    return stub.setNamedPortsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceGroupsClient regionInstanceGroupsClient =
   *     RegionInstanceGroupsClient.create()) {
   *   SetNamedPortsRegionInstanceGroupRequest request =
   *       SetNamedPortsRegionInstanceGroupRequest.newBuilder()
   *           .setInstanceGroup("instanceGroup-1404696854")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionInstanceGroupsSetNamedPortsRequestResource(
   *               RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstanceGroupsClient.setNamedPortsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetNamedPortsRegionInstanceGroupRequest, Operation>
      setNamedPortsCallable() {
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionInstanceGroupsRequest,
          RegionInstanceGroupList,
          InstanceGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        ApiFuture<RegionInstanceGroupList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup, ListPage> {

    private ListPage(
        PageContext<ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        RegionInstanceGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        RegionInstanceGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionInstanceGroupsRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        ApiFuture<RegionInstanceGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstanceGroupsRequest,
          RegionInstanceGroupList,
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
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<
                ListInstancesRegionInstanceGroupsRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<RegionInstanceGroupsListInstances> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesPage> {

    private ListInstancesPage(
        PageContext<
                ListInstancesRegionInstanceGroupsRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        RegionInstanceGroupsListInstances response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<
                ListInstancesRegionInstanceGroupsRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        RegionInstanceGroupsListInstances response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<
                ListInstancesRegionInstanceGroupsRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<RegionInstanceGroupsListInstances> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
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
