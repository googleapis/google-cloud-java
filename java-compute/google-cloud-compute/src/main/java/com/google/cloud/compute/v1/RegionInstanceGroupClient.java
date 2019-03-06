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
import com.google.cloud.compute.v1.stub.RegionInstanceGroupStub;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
 * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
 *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
 *   InstanceGroup response = regionInstanceGroupClient.getRegionInstanceGroup(instanceGroup);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionInstanceGroupClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of RegionInstanceGroupSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupSettings regionInstanceGroupSettings =
 *     RegionInstanceGroupSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstanceGroupClient regionInstanceGroupClient =
 *     RegionInstanceGroupClient.create(regionInstanceGroupSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupSettings regionInstanceGroupSettings =
 *     RegionInstanceGroupSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstanceGroupClient regionInstanceGroupClient =
 *     RegionInstanceGroupClient.create(regionInstanceGroupSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionInstanceGroupClient implements BackgroundResource {
  private final RegionInstanceGroupSettings settings;
  private final RegionInstanceGroupStub stub;

  /** Constructs an instance of RegionInstanceGroupClient with default settings. */
  public static final RegionInstanceGroupClient create() throws IOException {
    return create(RegionInstanceGroupSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstanceGroupClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionInstanceGroupClient create(RegionInstanceGroupSettings settings)
      throws IOException {
    return new RegionInstanceGroupClient(settings);
  }

  /**
   * Constructs an instance of RegionInstanceGroupClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use RegionInstanceGroupSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionInstanceGroupClient create(RegionInstanceGroupStub stub) {
    return new RegionInstanceGroupClient(stub);
  }

  /**
   * Constructs an instance of RegionInstanceGroupClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionInstanceGroupClient(RegionInstanceGroupSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstanceGroupStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionInstanceGroupClient(RegionInstanceGroupStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstanceGroupSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionInstanceGroupStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   InstanceGroup response = regionInstanceGroupClient.getRegionInstanceGroup(instanceGroup);
   * }
   * </code></pre>
   *
   * @param instanceGroup Name of the instance group resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroup getRegionInstanceGroup(ProjectRegionInstanceGroupName instanceGroup) {

    GetRegionInstanceGroupHttpRequest request =
        GetRegionInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .build();
    return getRegionInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   InstanceGroup response = regionInstanceGroupClient.getRegionInstanceGroup(instanceGroup.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroup Name of the instance group resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroup getRegionInstanceGroup(String instanceGroup) {

    GetRegionInstanceGroupHttpRequest request =
        GetRegionInstanceGroupHttpRequest.newBuilder().setInstanceGroup(instanceGroup).build();
    return getRegionInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   GetRegionInstanceGroupHttpRequest request = GetRegionInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .build();
   *   InstanceGroup response = regionInstanceGroupClient.getRegionInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroup getRegionInstanceGroup(GetRegionInstanceGroupHttpRequest request) {
    return getRegionInstanceGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified instance group resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   GetRegionInstanceGroupHttpRequest request = GetRegionInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .build();
   *   ApiFuture&lt;InstanceGroup&gt; future = regionInstanceGroupClient.getRegionInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   InstanceGroup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionInstanceGroupHttpRequest, InstanceGroup>
      getRegionInstanceGroupCallable() {
    return stub.getRegionInstanceGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (InstanceGroup element : regionInstanceGroupClient.listRegionInstanceGroups(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionInstanceGroupsPagedResponse listRegionInstanceGroups(
      ProjectRegionName region) {
    ListRegionInstanceGroupsHttpRequest request =
        ListRegionInstanceGroupsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (InstanceGroup element : regionInstanceGroupClient.listRegionInstanceGroups(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionInstanceGroupsPagedResponse listRegionInstanceGroups(String region) {
    ListRegionInstanceGroupsHttpRequest request =
        ListRegionInstanceGroupsHttpRequest.newBuilder().setRegion(region).build();
    return listRegionInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionInstanceGroupsHttpRequest request = ListRegionInstanceGroupsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (InstanceGroup element : regionInstanceGroupClient.listRegionInstanceGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionInstanceGroupsPagedResponse listRegionInstanceGroups(
      ListRegionInstanceGroupsHttpRequest request) {
    return listRegionInstanceGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionInstanceGroupsHttpRequest request = ListRegionInstanceGroupsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListRegionInstanceGroupsPagedResponse&gt; future = regionInstanceGroupClient.listRegionInstanceGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionInstanceGroupsHttpRequest, ListRegionInstanceGroupsPagedResponse>
      listRegionInstanceGroupsPagedCallable() {
    return stub.listRegionInstanceGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instance group resources contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListRegionInstanceGroupsHttpRequest request = ListRegionInstanceGroupsHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupList response = regionInstanceGroupClient.listRegionInstanceGroupsCallable().call(request);
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
  public final UnaryCallable<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList>
      listRegionInstanceGroupsCallable() {
    return stub.listRegionInstanceGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource = RegionInstanceGroupsListInstancesRequest.newBuilder().build();
   *   for (InstanceWithNamedPorts element : regionInstanceGroupClient.listInstancesRegionInstanceGroups(instanceGroup, regionInstanceGroupsListInstancesRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroup Name of the regional instance group for which we want to list the
   *     instances.
   * @param regionInstanceGroupsListInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesRegionInstanceGroupsPagedResponse listInstancesRegionInstanceGroups(
      ProjectRegionInstanceGroupName instanceGroup,
      RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource) {
    ListInstancesRegionInstanceGroupsHttpRequest request =
        ListInstancesRegionInstanceGroupsHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .setRegionInstanceGroupsListInstancesRequestResource(
                regionInstanceGroupsListInstancesRequestResource)
            .build();
    return listInstancesRegionInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource = RegionInstanceGroupsListInstancesRequest.newBuilder().build();
   *   for (InstanceWithNamedPorts element : regionInstanceGroupClient.listInstancesRegionInstanceGroups(instanceGroup.toString(), regionInstanceGroupsListInstancesRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroup Name of the regional instance group for which we want to list the
   *     instances.
   * @param regionInstanceGroupsListInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesRegionInstanceGroupsPagedResponse listInstancesRegionInstanceGroups(
      String instanceGroup,
      RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource) {
    ListInstancesRegionInstanceGroupsHttpRequest request =
        ListInstancesRegionInstanceGroupsHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup)
            .setRegionInstanceGroupsListInstancesRequestResource(
                regionInstanceGroupsListInstancesRequestResource)
            .build();
    return listInstancesRegionInstanceGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource = RegionInstanceGroupsListInstancesRequest.newBuilder().build();
   *   ListInstancesRegionInstanceGroupsHttpRequest request = ListInstancesRegionInstanceGroupsHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setRegionInstanceGroupsListInstancesRequestResource(regionInstanceGroupsListInstancesRequestResource)
   *     .build();
   *   for (InstanceWithNamedPorts element : regionInstanceGroupClient.listInstancesRegionInstanceGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesRegionInstanceGroupsPagedResponse listInstancesRegionInstanceGroups(
      ListInstancesRegionInstanceGroupsHttpRequest request) {
    return listInstancesRegionInstanceGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource = RegionInstanceGroupsListInstancesRequest.newBuilder().build();
   *   ListInstancesRegionInstanceGroupsHttpRequest request = ListInstancesRegionInstanceGroupsHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setRegionInstanceGroupsListInstancesRequestResource(regionInstanceGroupsListInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;ListInstancesRegionInstanceGroupsPagedResponse&gt; future = regionInstanceGroupClient.listInstancesRegionInstanceGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceWithNamedPorts element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListInstancesRegionInstanceGroupsHttpRequest,
          ListInstancesRegionInstanceGroupsPagedResponse>
      listInstancesRegionInstanceGroupsPagedCallable() {
    return stub.listInstancesRegionInstanceGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the instances in the specified instance group and displays information about the named
   * ports. Depending on the specified options, this method can list all instances or only the
   * instances that are running.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsListInstancesRequest regionInstanceGroupsListInstancesRequestResource = RegionInstanceGroupsListInstancesRequest.newBuilder().build();
   *   ListInstancesRegionInstanceGroupsHttpRequest request = ListInstancesRegionInstanceGroupsHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setRegionInstanceGroupsListInstancesRequestResource(regionInstanceGroupsListInstancesRequestResource)
   *     .build();
   *   while (true) {
   *     RegionInstanceGroupsListInstances response = regionInstanceGroupClient.listInstancesRegionInstanceGroupsCallable().call(request);
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
  public final UnaryCallable<
          ListInstancesRegionInstanceGroupsHttpRequest, RegionInstanceGroupsListInstances>
      listInstancesRegionInstanceGroupsCallable() {
    return stub.listInstancesRegionInstanceGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource = RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupClient.setNamedPortsRegionInstanceGroup(instanceGroup, regionInstanceGroupsSetNamedPortsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the regional instance group where the named ports are updated.
   * @param regionInstanceGroupsSetNamedPortsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNamedPortsRegionInstanceGroup(
      ProjectRegionInstanceGroupName instanceGroup,
      RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource) {

    SetNamedPortsRegionInstanceGroupHttpRequest request =
        SetNamedPortsRegionInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup == null ? null : instanceGroup.toString())
            .setRegionInstanceGroupsSetNamedPortsRequestResource(
                regionInstanceGroupsSetNamedPortsRequestResource)
            .build();
    return setNamedPortsRegionInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource = RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   Operation response = regionInstanceGroupClient.setNamedPortsRegionInstanceGroup(instanceGroup.toString(), regionInstanceGroupsSetNamedPortsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroup The name of the regional instance group where the named ports are updated.
   * @param regionInstanceGroupsSetNamedPortsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNamedPortsRegionInstanceGroup(
      String instanceGroup,
      RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource) {

    SetNamedPortsRegionInstanceGroupHttpRequest request =
        SetNamedPortsRegionInstanceGroupHttpRequest.newBuilder()
            .setInstanceGroup(instanceGroup)
            .setRegionInstanceGroupsSetNamedPortsRequestResource(
                regionInstanceGroupsSetNamedPortsRequestResource)
            .build();
    return setNamedPortsRegionInstanceGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource = RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   SetNamedPortsRegionInstanceGroupHttpRequest request = SetNamedPortsRegionInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setRegionInstanceGroupsSetNamedPortsRequestResource(regionInstanceGroupsSetNamedPortsRequestResource)
   *     .build();
   *   Operation response = regionInstanceGroupClient.setNamedPortsRegionInstanceGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNamedPortsRegionInstanceGroup(
      SetNamedPortsRegionInstanceGroupHttpRequest request) {
    return setNamedPortsRegionInstanceGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the named ports for the specified regional instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionInstanceGroupClient regionInstanceGroupClient = RegionInstanceGroupClient.create()) {
   *   ProjectRegionInstanceGroupName instanceGroup = ProjectRegionInstanceGroupName.of("[PROJECT]", "[REGION]", "[INSTANCE_GROUP]");
   *   RegionInstanceGroupsSetNamedPortsRequest regionInstanceGroupsSetNamedPortsRequestResource = RegionInstanceGroupsSetNamedPortsRequest.newBuilder().build();
   *   SetNamedPortsRegionInstanceGroupHttpRequest request = SetNamedPortsRegionInstanceGroupHttpRequest.newBuilder()
   *     .setInstanceGroup(instanceGroup.toString())
   *     .setRegionInstanceGroupsSetNamedPortsRequestResource(regionInstanceGroupsSetNamedPortsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionInstanceGroupClient.setNamedPortsRegionInstanceGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetNamedPortsRegionInstanceGroupHttpRequest, Operation>
      setNamedPortsRegionInstanceGroupCallable() {
    return stub.setNamedPortsRegionInstanceGroupCallable();
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

  public static class ListRegionInstanceGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupList,
          InstanceGroup,
          ListRegionInstanceGroupsPage,
          ListRegionInstanceGroupsFixedSizeCollection> {

    public static ApiFuture<ListRegionInstanceGroupsPagedResponse> createAsync(
        PageContext<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        ApiFuture<RegionInstanceGroupList> futureResponse) {
      ApiFuture<ListRegionInstanceGroupsPage> futurePage =
          ListRegionInstanceGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionInstanceGroupsPage, ListRegionInstanceGroupsPagedResponse>() {
            @Override
            public ListRegionInstanceGroupsPagedResponse apply(ListRegionInstanceGroupsPage input) {
              return new ListRegionInstanceGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionInstanceGroupsPagedResponse(ListRegionInstanceGroupsPage page) {
      super(page, ListRegionInstanceGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionInstanceGroupsPage
      extends AbstractPage<
          ListRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupList,
          InstanceGroup,
          ListRegionInstanceGroupsPage> {

    private ListRegionInstanceGroupsPage(
        PageContext<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        RegionInstanceGroupList response) {
      super(context, response);
    }

    private static ListRegionInstanceGroupsPage createEmptyPage() {
      return new ListRegionInstanceGroupsPage(null, null);
    }

    @Override
    protected ListRegionInstanceGroupsPage createPage(
        PageContext<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        RegionInstanceGroupList response) {
      return new ListRegionInstanceGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionInstanceGroupsPage> createPageAsync(
        PageContext<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList, InstanceGroup>
            context,
        ApiFuture<RegionInstanceGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionInstanceGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupList,
          InstanceGroup,
          ListRegionInstanceGroupsPage,
          ListRegionInstanceGroupsFixedSizeCollection> {

    private ListRegionInstanceGroupsFixedSizeCollection(
        List<ListRegionInstanceGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionInstanceGroupsFixedSizeCollection createEmptyCollection() {
      return new ListRegionInstanceGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionInstanceGroupsFixedSizeCollection createCollection(
        List<ListRegionInstanceGroupsPage> pages, int collectionSize) {
      return new ListRegionInstanceGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstancesRegionInstanceGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesRegionInstanceGroupsPage,
          ListInstancesRegionInstanceGroupsFixedSizeCollection> {

    public static ApiFuture<ListInstancesRegionInstanceGroupsPagedResponse> createAsync(
        PageContext<
                ListInstancesRegionInstanceGroupsHttpRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<RegionInstanceGroupsListInstances> futureResponse) {
      ApiFuture<ListInstancesRegionInstanceGroupsPage> futurePage =
          ListInstancesRegionInstanceGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListInstancesRegionInstanceGroupsPage,
              ListInstancesRegionInstanceGroupsPagedResponse>() {
            @Override
            public ListInstancesRegionInstanceGroupsPagedResponse apply(
                ListInstancesRegionInstanceGroupsPage input) {
              return new ListInstancesRegionInstanceGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstancesRegionInstanceGroupsPagedResponse(
        ListInstancesRegionInstanceGroupsPage page) {
      super(page, ListInstancesRegionInstanceGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesRegionInstanceGroupsPage
      extends AbstractPage<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesRegionInstanceGroupsPage> {

    private ListInstancesRegionInstanceGroupsPage(
        PageContext<
                ListInstancesRegionInstanceGroupsHttpRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        RegionInstanceGroupsListInstances response) {
      super(context, response);
    }

    private static ListInstancesRegionInstanceGroupsPage createEmptyPage() {
      return new ListInstancesRegionInstanceGroupsPage(null, null);
    }

    @Override
    protected ListInstancesRegionInstanceGroupsPage createPage(
        PageContext<
                ListInstancesRegionInstanceGroupsHttpRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        RegionInstanceGroupsListInstances response) {
      return new ListInstancesRegionInstanceGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesRegionInstanceGroupsPage> createPageAsync(
        PageContext<
                ListInstancesRegionInstanceGroupsHttpRequest,
                RegionInstanceGroupsListInstances,
                InstanceWithNamedPorts>
            context,
        ApiFuture<RegionInstanceGroupsListInstances> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesRegionInstanceGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRegionInstanceGroupsHttpRequest,
          RegionInstanceGroupsListInstances,
          InstanceWithNamedPorts,
          ListInstancesRegionInstanceGroupsPage,
          ListInstancesRegionInstanceGroupsFixedSizeCollection> {

    private ListInstancesRegionInstanceGroupsFixedSizeCollection(
        List<ListInstancesRegionInstanceGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesRegionInstanceGroupsFixedSizeCollection createEmptyCollection() {
      return new ListInstancesRegionInstanceGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesRegionInstanceGroupsFixedSizeCollection createCollection(
        List<ListInstancesRegionInstanceGroupsPage> pages, int collectionSize) {
      return new ListInstancesRegionInstanceGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
