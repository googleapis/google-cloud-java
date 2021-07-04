/*
 * Copyright 2021 Google LLC
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
import com.google.cloud.compute.v1.stub.InstancesStub;
import com.google.cloud.compute.v1.stub.InstancesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Instances API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (InstancesClient instancesClient = InstancesClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String instance = "instance555127957";
 *   String networkInterface = "networkInterface-341981525";
 *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
 *   Operation response =
 *       instancesClient.addAccessConfig(
 *           project, zone, instance, networkInterface, accessConfigResource);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InstancesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of InstancesSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * InstancesSettings instancesSettings =
 *     InstancesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstancesClient instancesClient = InstancesClient.create(instancesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * InstancesSettings instancesSettings =
 *     InstancesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstancesClient instancesClient = InstancesClient.create(instancesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InstancesClient implements BackgroundResource {
  private final InstancesSettings settings;
  private final InstancesStub stub;

  /** Constructs an instance of InstancesClient with default settings. */
  public static final InstancesClient create() throws IOException {
    return create(InstancesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstancesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstancesClient create(InstancesSettings settings) throws IOException {
    return new InstancesClient(settings);
  }

  /**
   * Constructs an instance of InstancesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(InstancesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstancesClient create(InstancesStub stub) {
    return new InstancesClient(stub);
  }

  /**
   * Constructs an instance of InstancesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected InstancesClient(InstancesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstancesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstancesClient(InstancesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstancesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstancesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   String networkInterface = "networkInterface-341981525";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   Operation response =
   *       instancesClient.addAccessConfig(
   *           project, zone, instance, networkInterface, accessConfigResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface to add to this instance.
   * @param accessConfigResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addAccessConfig(
      String project,
      String zone,
      String instance,
      String networkInterface,
      AccessConfig accessConfigResource) {
    AddAccessConfigInstanceRequest request =
        AddAccessConfigInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setAccessConfigResource(accessConfigResource)
            .build();
    return addAccessConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AddAccessConfigInstanceRequest request =
   *       AddAccessConfigInstanceRequest.newBuilder()
   *           .setAccessConfigResource(AccessConfig.newBuilder().build())
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.addAccessConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addAccessConfig(AddAccessConfigInstanceRequest request) {
    return addAccessConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AddAccessConfigInstanceRequest request =
   *       AddAccessConfigInstanceRequest.newBuilder()
   *           .setAccessConfigResource(AccessConfig.newBuilder().build())
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.addAccessConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAccessConfigInstanceRequest, Operation> addAccessConfigCallable() {
    return stub.addAccessConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds existing resource policies to an instance. You can only add one policy right now which
   * will be applied to this instance for scheduling live migrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesAddResourcePoliciesRequest instancesAddResourcePoliciesRequestResource =
   *       InstancesAddResourcePoliciesRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.addResourcePolicies(
   *           project, zone, instance, instancesAddResourcePoliciesRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param instancesAddResourcePoliciesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addResourcePolicies(
      String project,
      String zone,
      String instance,
      InstancesAddResourcePoliciesRequest instancesAddResourcePoliciesRequestResource) {
    AddResourcePoliciesInstanceRequest request =
        AddResourcePoliciesInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesAddResourcePoliciesRequestResource(
                instancesAddResourcePoliciesRequestResource)
            .build();
    return addResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds existing resource policies to an instance. You can only add one policy right now which
   * will be applied to this instance for scheduling live migrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AddResourcePoliciesInstanceRequest request =
   *       AddResourcePoliciesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesAddResourcePoliciesRequestResource(
   *               InstancesAddResourcePoliciesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.addResourcePolicies(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addResourcePolicies(AddResourcePoliciesInstanceRequest request) {
    return addResourcePoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds existing resource policies to an instance. You can only add one policy right now which
   * will be applied to this instance for scheduling live migrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AddResourcePoliciesInstanceRequest request =
   *       AddResourcePoliciesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesAddResourcePoliciesRequestResource(
   *               InstancesAddResourcePoliciesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.addResourcePoliciesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesCallable() {
    return stub.addResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, InstancesScopedList> element :
   *       instancesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListInstancesRequest request =
        AggregatedListInstancesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AggregatedListInstancesRequest request =
   *       AggregatedListInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, InstancesScopedList> element :
   *       instancesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListInstancesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AggregatedListInstancesRequest request =
   *       AggregatedListInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, InstancesScopedList>> future =
   *       instancesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, InstancesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AggregatedListInstancesRequest request =
   *       AggregatedListInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     InstanceAggregatedList response = instancesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, InstancesScopedList> element : response.getResponsesList()) {
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
  public final UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   AttachedDisk attachedDiskResource = AttachedDisk.newBuilder().build();
   *   Operation response =
   *       instancesClient.attachDisk(project, zone, instance, attachedDiskResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param attachedDiskResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation attachDisk(
      String project, String zone, String instance, AttachedDisk attachedDiskResource) {
    AttachDiskInstanceRequest request =
        AttachDiskInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setAttachedDiskResource(attachedDiskResource)
            .build();
    return attachDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AttachDiskInstanceRequest request =
   *       AttachDiskInstanceRequest.newBuilder()
   *           .setAttachedDiskResource(AttachedDisk.newBuilder().build())
   *           .setForceAttach(true)
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.attachDisk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation attachDisk(AttachDiskInstanceRequest request) {
    return attachDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   AttachDiskInstanceRequest request =
   *       AttachDiskInstanceRequest.newBuilder()
   *           .setAttachedDiskResource(AttachedDisk.newBuilder().build())
   *           .setForceAttach(true)
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.attachDiskCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AttachDiskInstanceRequest, Operation> attachDiskCallable() {
    return stub.attachDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances. Count specifies the number of instances to create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   BulkInsertInstanceResource bulkInsertInstanceResourceResource =
   *       BulkInsertInstanceResource.newBuilder().build();
   *   Operation response =
   *       instancesClient.bulkInsert(project, zone, bulkInsertInstanceResourceResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param bulkInsertInstanceResourceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation bulkInsert(
      String project, String zone, BulkInsertInstanceResource bulkInsertInstanceResourceResource) {
    BulkInsertInstanceRequest request =
        BulkInsertInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setBulkInsertInstanceResourceResource(bulkInsertInstanceResourceResource)
            .build();
    return bulkInsert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances. Count specifies the number of instances to create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   BulkInsertInstanceRequest request =
   *       BulkInsertInstanceRequest.newBuilder()
   *           .setBulkInsertInstanceResourceResource(
   *               BulkInsertInstanceResource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.bulkInsert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation bulkInsert(BulkInsertInstanceRequest request) {
    return bulkInsertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances. Count specifies the number of instances to create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   BulkInsertInstanceRequest request =
   *       BulkInsertInstanceRequest.newBuilder()
   *           .setBulkInsertInstanceResourceResource(
   *               BulkInsertInstanceResource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.bulkInsertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkInsertInstanceRequest, Operation> bulkInsertCallable() {
    return stub.bulkInsertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Instance resource. For more information, see Deleting an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Operation response = instancesClient.delete(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String instance) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Instance resource. For more information, see Deleting an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteInstanceRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Instance resource. For more information, see Deleting an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   String accessConfig = "accessConfig1549765062";
   *   String networkInterface = "networkInterface-341981525";
   *   Operation response =
   *       instancesClient.deleteAccessConfig(
   *           project, zone, instance, accessConfig, networkInterface);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param accessConfig The name of the access config to delete.
   * @param networkInterface The name of the network interface.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteAccessConfig(
      String project, String zone, String instance, String accessConfig, String networkInterface) {
    DeleteAccessConfigInstanceRequest request =
        DeleteAccessConfigInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setAccessConfig(accessConfig)
            .setNetworkInterface(networkInterface)
            .build();
    return deleteAccessConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   DeleteAccessConfigInstanceRequest request =
   *       DeleteAccessConfigInstanceRequest.newBuilder()
   *           .setAccessConfig("accessConfig1549765062")
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.deleteAccessConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteAccessConfig(DeleteAccessConfigInstanceRequest request) {
    return deleteAccessConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   DeleteAccessConfigInstanceRequest request =
   *       DeleteAccessConfigInstanceRequest.newBuilder()
   *           .setAccessConfig("accessConfig1549765062")
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.deleteAccessConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigCallable() {
    return stub.deleteAccessConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   String deviceName = "deviceName780988929";
   *   Operation response = instancesClient.detachDisk(project, zone, instance, deviceName);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Instance name for this request.
   * @param deviceName The device name of the disk to detach. Make a get() request on the instance
   *     to view currently attached disks and device names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation detachDisk(
      String project, String zone, String instance, String deviceName) {
    DetachDiskInstanceRequest request =
        DetachDiskInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setDeviceName(deviceName)
            .build();
    return detachDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   DetachDiskInstanceRequest request =
   *       DetachDiskInstanceRequest.newBuilder()
   *           .setDeviceName("deviceName780988929")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.detachDisk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation detachDisk(DetachDiskInstanceRequest request) {
    return detachDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   DetachDiskInstanceRequest request =
   *       DetachDiskInstanceRequest.newBuilder()
   *           .setDeviceName("deviceName780988929")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.detachDiskCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachDiskInstanceRequest, Operation> detachDiskCallable() {
    return stub.detachDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Instance response = instancesClient.get(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance get(String project, String zone, String instance) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   Instance response = instancesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance get(GetInstanceRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Instance> future = instancesClient.getCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns effective firewalls applied to an interface of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   String networkInterface = "networkInterface-341981525";
   *   InstancesGetEffectiveFirewallsResponse response =
   *       instancesClient.getEffectiveFirewalls(project, zone, instance, networkInterface);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param networkInterface The name of the network interface to get the effective firewalls.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstancesGetEffectiveFirewallsResponse getEffectiveFirewalls(
      String project, String zone, String instance, String networkInterface) {
    GetEffectiveFirewallsInstanceRequest request =
        GetEffectiveFirewallsInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .build();
    return getEffectiveFirewalls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns effective firewalls applied to an interface of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetEffectiveFirewallsInstanceRequest request =
   *       GetEffectiveFirewallsInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   InstancesGetEffectiveFirewallsResponse response =
   *       instancesClient.getEffectiveFirewalls(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstancesGetEffectiveFirewallsResponse getEffectiveFirewalls(
      GetEffectiveFirewallsInstanceRequest request) {
    return getEffectiveFirewallsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns effective firewalls applied to an interface of the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetEffectiveFirewallsInstanceRequest request =
   *       GetEffectiveFirewallsInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<InstancesGetEffectiveFirewallsResponse> future =
   *       instancesClient.getEffectiveFirewallsCallable().futureCall(request);
   *   // Do something.
   *   InstancesGetEffectiveFirewallsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    return stub.getEffectiveFirewallsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified guest attributes entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   GuestAttributes response = instancesClient.getGuestAttributes(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GuestAttributes getGuestAttributes(String project, String zone, String instance) {
    GetGuestAttributesInstanceRequest request =
        GetGuestAttributesInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return getGuestAttributes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified guest attributes entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetGuestAttributesInstanceRequest request =
   *       GetGuestAttributesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setQueryPath("queryPath-1807004403")
   *           .setVariableKey("variableKey-1951698365")
   *           .setZone("zone3744684")
   *           .build();
   *   GuestAttributes response = instancesClient.getGuestAttributes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GuestAttributes getGuestAttributes(GetGuestAttributesInstanceRequest request) {
    return getGuestAttributesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified guest attributes entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetGuestAttributesInstanceRequest request =
   *       GetGuestAttributesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setQueryPath("queryPath-1807004403")
   *           .setVariableKey("variableKey-1951698365")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<GuestAttributes> future =
   *       instancesClient.getGuestAttributesCallable().futureCall(request);
   *   // Do something.
   *   GuestAttributes response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesCallable() {
    return stub.getGuestAttributesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   Policy response = instancesClient.getIamPolicy(project, zone, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String zone, String resource) {
    GetIamPolicyInstanceRequest request =
        GetIamPolicyInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetIamPolicyInstanceRequest request =
   *       GetIamPolicyInstanceRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   Policy response = instancesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyInstanceRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetIamPolicyInstanceRequest request =
   *       GetIamPolicyInstanceRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Policy> future = instancesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyInstanceRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the screenshot from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Screenshot response = instancesClient.getScreenshot(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Screenshot getScreenshot(String project, String zone, String instance) {
    GetScreenshotInstanceRequest request =
        GetScreenshotInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return getScreenshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the screenshot from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetScreenshotInstanceRequest request =
   *       GetScreenshotInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   Screenshot response = instancesClient.getScreenshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Screenshot getScreenshot(GetScreenshotInstanceRequest request) {
    return getScreenshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the screenshot from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetScreenshotInstanceRequest request =
   *       GetScreenshotInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Screenshot> future = instancesClient.getScreenshotCallable().futureCall(request);
   *   // Do something.
   *   Screenshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScreenshotInstanceRequest, Screenshot> getScreenshotCallable() {
    return stub.getScreenshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   SerialPortOutput response = instancesClient.getSerialPortOutput(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SerialPortOutput getSerialPortOutput(String project, String zone, String instance) {
    GetSerialPortOutputInstanceRequest request =
        GetSerialPortOutputInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return getSerialPortOutput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetSerialPortOutputInstanceRequest request =
   *       GetSerialPortOutputInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setPort(3446913)
   *           .setProject("project-309310695")
   *           .setStart(109757538)
   *           .setZone("zone3744684")
   *           .build();
   *   SerialPortOutput response = instancesClient.getSerialPortOutput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SerialPortOutput getSerialPortOutput(GetSerialPortOutputInstanceRequest request) {
    return getSerialPortOutputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetSerialPortOutputInstanceRequest request =
   *       GetSerialPortOutputInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setPort(3446913)
   *           .setProject("project-309310695")
   *           .setStart(109757538)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<SerialPortOutput> future =
   *       instancesClient.getSerialPortOutputCallable().futureCall(request);
   *   // Do something.
   *   SerialPortOutput response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputCallable() {
    return stub.getSerialPortOutputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Shielded Instance Identity of an instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   ShieldedInstanceIdentity response =
   *       instancesClient.getShieldedInstanceIdentity(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name or id of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShieldedInstanceIdentity getShieldedInstanceIdentity(
      String project, String zone, String instance) {
    GetShieldedInstanceIdentityInstanceRequest request =
        GetShieldedInstanceIdentityInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return getShieldedInstanceIdentity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Shielded Instance Identity of an instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetShieldedInstanceIdentityInstanceRequest request =
   *       GetShieldedInstanceIdentityInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ShieldedInstanceIdentity response = instancesClient.getShieldedInstanceIdentity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShieldedInstanceIdentity getShieldedInstanceIdentity(
      GetShieldedInstanceIdentityInstanceRequest request) {
    return getShieldedInstanceIdentityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Shielded Instance Identity of an instance
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   GetShieldedInstanceIdentityInstanceRequest request =
   *       GetShieldedInstanceIdentityInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<ShieldedInstanceIdentity> future =
   *       instancesClient.getShieldedInstanceIdentityCallable().futureCall(request);
   *   // Do something.
   *   ShieldedInstanceIdentity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityCallable() {
    return stub.getShieldedInstanceIdentityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   Instance instanceResource = Instance.newBuilder().build();
   *   Operation response = instancesClient.insert(project, zone, instanceResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instanceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String zone, Instance instanceResource) {
    InsertInstanceRequest request =
        InsertInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstanceResource(instanceResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   InsertInstanceRequest request =
   *       InsertInstanceRequest.newBuilder()
   *           .setInstanceResource(Instance.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSourceInstanceTemplate("sourceInstanceTemplate949712490")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertInstanceRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   InsertInstanceRequest request =
   *       InsertInstanceRequest.newBuilder()
   *           .setInstanceResource(Instance.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSourceInstanceTemplate("sourceInstanceTemplate949712490")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertInstanceRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (Instance element : instancesClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (Instance element : instancesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInstancesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Instance> future = instancesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceList response = instancesClient.listCallable().call(request);
   *     for (Instance element : response.getResponsesList()) {
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
  public final UnaryCallable<ListInstancesRequest, InstanceList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resources that refer to the VM instance specified in the request. For
   * example, if the VM instance is part of a managed or unmanaged instance group, the referrers
   * list includes the instance group. For more information, read Viewing referrers to VM instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   for (Reference element :
   *       instancesClient.listReferrers(project, zone, instance).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the target instance scoping this request, or '-' if the request should
   *     span over all instances in the container.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferrersPagedResponse listReferrers(
      String project, String zone, String instance) {
    ListReferrersInstancesRequest request =
        ListReferrersInstancesRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return listReferrers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resources that refer to the VM instance specified in the request. For
   * example, if the VM instance is part of a managed or unmanaged instance group, the referrers
   * list includes the instance group. For more information, read Viewing referrers to VM instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ListReferrersInstancesRequest request =
   *       ListReferrersInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (Reference element : instancesClient.listReferrers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferrersPagedResponse listReferrers(ListReferrersInstancesRequest request) {
    return listReferrersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resources that refer to the VM instance specified in the request. For
   * example, if the VM instance is part of a managed or unmanaged instance group, the referrers
   * list includes the instance group. For more information, read Viewing referrers to VM instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ListReferrersInstancesRequest request =
   *       ListReferrersInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Reference> future =
   *       instancesClient.listReferrersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Reference element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReferrersInstancesRequest, ListReferrersPagedResponse>
      listReferrersPagedCallable() {
    return stub.listReferrersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of resources that refer to the VM instance specified in the request. For
   * example, if the VM instance is part of a managed or unmanaged instance group, the referrers
   * list includes the instance group. For more information, read Viewing referrers to VM instances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ListReferrersInstancesRequest request =
   *       ListReferrersInstancesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setInstance("instance555127957")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     InstanceListReferrers response = instancesClient.listReferrersCallable().call(request);
   *     for (Reference element : response.getResponsesList()) {
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
  public final UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersCallable() {
    return stub.listReferrersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes resource policies from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesRemoveResourcePoliciesRequest instancesRemoveResourcePoliciesRequestResource =
   *       InstancesRemoveResourcePoliciesRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.removeResourcePolicies(
   *           project, zone, instance, instancesRemoveResourcePoliciesRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param instancesRemoveResourcePoliciesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeResourcePolicies(
      String project,
      String zone,
      String instance,
      InstancesRemoveResourcePoliciesRequest instancesRemoveResourcePoliciesRequestResource) {
    RemoveResourcePoliciesInstanceRequest request =
        RemoveResourcePoliciesInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesRemoveResourcePoliciesRequestResource(
                instancesRemoveResourcePoliciesRequestResource)
            .build();
    return removeResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes resource policies from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   RemoveResourcePoliciesInstanceRequest request =
   *       RemoveResourcePoliciesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesRemoveResourcePoliciesRequestResource(
   *               InstancesRemoveResourcePoliciesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.removeResourcePolicies(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeResourcePolicies(RemoveResourcePoliciesInstanceRequest request) {
    return removeResourcePoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes resource policies from an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   RemoveResourcePoliciesInstanceRequest request =
   *       RemoveResourcePoliciesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesRemoveResourcePoliciesRequestResource(
   *               InstancesRemoveResourcePoliciesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.removeResourcePoliciesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesCallable() {
    return stub.removeResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Operation response = instancesClient.reset(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation reset(String project, String zone, String instance) {
    ResetInstanceRequest request =
        ResetInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return reset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.reset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation reset(ResetInstanceRequest request) {
    return resetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.resetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetInstanceRequest, Operation> resetCallable() {
    return stub.resetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   Operation response = instancesClient.setDeletionProtection(project, zone, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setDeletionProtection(String project, String zone, String resource) {
    SetDeletionProtectionInstanceRequest request =
        SetDeletionProtectionInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .build();
    return setDeletionProtection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetDeletionProtectionInstanceRequest request =
   *       SetDeletionProtectionInstanceRequest.newBuilder()
   *           .setDeletionProtection(true)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setDeletionProtection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setDeletionProtection(SetDeletionProtectionInstanceRequest request) {
    return setDeletionProtectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetDeletionProtectionInstanceRequest request =
   *       SetDeletionProtectionInstanceRequest.newBuilder()
   *           .setDeletionProtection(true)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.setDeletionProtectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionCallable() {
    return stub.setDeletionProtectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   boolean autoDelete = true;
   *   String deviceName = "deviceName780988929";
   *   Operation response =
   *       instancesClient.setDiskAutoDelete(project, zone, instance, autoDelete, deviceName);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param autoDelete Whether to auto-delete the disk when the instance is deleted.
   * @param deviceName The device name of the disk to modify. Make a get() request on the instance
   *     to view currently attached disks and device names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setDiskAutoDelete(
      String project, String zone, String instance, boolean autoDelete, String deviceName) {
    SetDiskAutoDeleteInstanceRequest request =
        SetDiskAutoDeleteInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setAutoDelete(autoDelete)
            .setDeviceName(deviceName)
            .build();
    return setDiskAutoDelete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetDiskAutoDeleteInstanceRequest request =
   *       SetDiskAutoDeleteInstanceRequest.newBuilder()
   *           .setAutoDelete(true)
   *           .setDeviceName("deviceName780988929")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setDiskAutoDelete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setDiskAutoDelete(SetDiskAutoDeleteInstanceRequest request) {
    return setDiskAutoDeleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetDiskAutoDeleteInstanceRequest request =
   *       SetDiskAutoDeleteInstanceRequest.newBuilder()
   *           .setAutoDelete(true)
   *           .setDeviceName("deviceName780988929")
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setDiskAutoDeleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteCallable() {
    return stub.setDiskAutoDeleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       instancesClient.setIamPolicy(project, zone, resource, zoneSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String zone,
      String resource,
      ZoneSetPolicyRequest zoneSetPolicyRequestResource) {
    SetIamPolicyInstanceRequest request =
        SetIamPolicyInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetIamPolicyInstanceRequest request =
   *       SetIamPolicyInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetPolicyRequestResource(ZoneSetPolicyRequest.newBuilder().build())
   *           .build();
   *   Policy response = instancesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyInstanceRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetIamPolicyInstanceRequest request =
   *       SetIamPolicyInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetPolicyRequestResource(ZoneSetPolicyRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = instancesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyInstanceRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesSetLabelsRequest instancesSetLabelsRequestResource =
   *       InstancesSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.setLabels(project, zone, instance, instancesSetLabelsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param instancesSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project,
      String zone,
      String instance,
      InstancesSetLabelsRequest instancesSetLabelsRequestResource) {
    SetLabelsInstanceRequest request =
        SetLabelsInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesSetLabelsRequestResource(instancesSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetLabelsInstanceRequest request =
   *       SetLabelsInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetLabelsRequestResource(InstancesSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setLabels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsInstanceRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetLabelsInstanceRequest request =
   *       SetLabelsInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetLabelsRequestResource(InstancesSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsInstanceRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource =
   *       InstancesSetMachineResourcesRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.setMachineResources(
   *           project, zone, instance, instancesSetMachineResourcesRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMachineResourcesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMachineResources(
      String project,
      String zone,
      String instance,
      InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource) {
    SetMachineResourcesInstanceRequest request =
        SetMachineResourcesInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesSetMachineResourcesRequestResource(
                instancesSetMachineResourcesRequestResource)
            .build();
    return setMachineResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMachineResourcesInstanceRequest request =
   *       SetMachineResourcesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetMachineResourcesRequestResource(
   *               InstancesSetMachineResourcesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setMachineResources(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMachineResources(SetMachineResourcesInstanceRequest request) {
    return setMachineResourcesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMachineResourcesInstanceRequest request =
   *       SetMachineResourcesInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetMachineResourcesRequestResource(
   *               InstancesSetMachineResourcesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.setMachineResourcesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesCallable() {
    return stub.setMachineResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource =
   *       InstancesSetMachineTypeRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.setMachineType(
   *           project, zone, instance, instancesSetMachineTypeRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMachineTypeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMachineType(
      String project,
      String zone,
      String instance,
      InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource) {
    SetMachineTypeInstanceRequest request =
        SetMachineTypeInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesSetMachineTypeRequestResource(instancesSetMachineTypeRequestResource)
            .build();
    return setMachineType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMachineTypeInstanceRequest request =
   *       SetMachineTypeInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetMachineTypeRequestResource(
   *               InstancesSetMachineTypeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setMachineType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMachineType(SetMachineTypeInstanceRequest request) {
    return setMachineTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMachineTypeInstanceRequest request =
   *       SetMachineTypeInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetMachineTypeRequestResource(
   *               InstancesSetMachineTypeRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setMachineTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMachineTypeInstanceRequest, Operation> setMachineTypeCallable() {
    return stub.setMachineTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response = instancesClient.setMetadata(project, zone, instance, metadataResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param metadataResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMetadata(
      String project, String zone, String instance, Metadata metadataResource) {
    SetMetadataInstanceRequest request =
        SetMetadataInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setMetadataResource(metadataResource)
            .build();
    return setMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMetadataInstanceRequest request =
   *       SetMetadataInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setMetadataResource(Metadata.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMetadata(SetMetadataInstanceRequest request) {
    return setMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMetadataInstanceRequest request =
   *       SetMetadataInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setMetadataResource(Metadata.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMetadataInstanceRequest, Operation> setMetadataCallable() {
    return stub.setMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource =
   *       InstancesSetMinCpuPlatformRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.setMinCpuPlatform(
   *           project, zone, instance, instancesSetMinCpuPlatformRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMinCpuPlatformRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMinCpuPlatform(
      String project,
      String zone,
      String instance,
      InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource) {
    SetMinCpuPlatformInstanceRequest request =
        SetMinCpuPlatformInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesSetMinCpuPlatformRequestResource(instancesSetMinCpuPlatformRequestResource)
            .build();
    return setMinCpuPlatform(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMinCpuPlatformInstanceRequest request =
   *       SetMinCpuPlatformInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetMinCpuPlatformRequestResource(
   *               InstancesSetMinCpuPlatformRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setMinCpuPlatform(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMinCpuPlatform(SetMinCpuPlatformInstanceRequest request) {
    return setMinCpuPlatformCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetMinCpuPlatformInstanceRequest request =
   *       SetMinCpuPlatformInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetMinCpuPlatformRequestResource(
   *               InstancesSetMinCpuPlatformRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setMinCpuPlatformCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformCallable() {
    return stub.setMinCpuPlatformCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an instance's scheduling options. You can only call this method on a stopped instance,
   * that is, a VM instance that is in a `TERMINATED` state. See Instance Life Cycle for more
   * information on the possible instance states.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Scheduling schedulingResource = Scheduling.newBuilder().build();
   *   Operation response =
   *       instancesClient.setScheduling(project, zone, instance, schedulingResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Instance name for this request.
   * @param schedulingResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setScheduling(
      String project, String zone, String instance, Scheduling schedulingResource) {
    SetSchedulingInstanceRequest request =
        SetSchedulingInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setSchedulingResource(schedulingResource)
            .build();
    return setScheduling(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an instance's scheduling options. You can only call this method on a stopped instance,
   * that is, a VM instance that is in a `TERMINATED` state. See Instance Life Cycle for more
   * information on the possible instance states.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetSchedulingInstanceRequest request =
   *       SetSchedulingInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSchedulingResource(Scheduling.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setScheduling(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setScheduling(SetSchedulingInstanceRequest request) {
    return setSchedulingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an instance's scheduling options. You can only call this method on a stopped instance,
   * that is, a VM instance that is in a `TERMINATED` state. See Instance Life Cycle for more
   * information on the possible instance states.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetSchedulingInstanceRequest request =
   *       SetSchedulingInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSchedulingResource(Scheduling.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setSchedulingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetSchedulingInstanceRequest, Operation> setSchedulingCallable() {
    return stub.setSchedulingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource =
   *       InstancesSetServiceAccountRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.setServiceAccount(
   *           project, zone, instance, instancesSetServiceAccountRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to start.
   * @param instancesSetServiceAccountRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setServiceAccount(
      String project,
      String zone,
      String instance,
      InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource) {
    SetServiceAccountInstanceRequest request =
        SetServiceAccountInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesSetServiceAccountRequestResource(instancesSetServiceAccountRequestResource)
            .build();
    return setServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetServiceAccountInstanceRequest request =
   *       SetServiceAccountInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetServiceAccountRequestResource(
   *               InstancesSetServiceAccountRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setServiceAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setServiceAccount(SetServiceAccountInstanceRequest request) {
    return setServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetServiceAccountInstanceRequest request =
   *       SetServiceAccountInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesSetServiceAccountRequestResource(
   *               InstancesSetServiceAccountRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setServiceAccountCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountCallable() {
    return stub.setServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Shielded Instance integrity policy for an instance. You can only use this method on a
   * running instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicyResource =
   *       ShieldedInstanceIntegrityPolicy.newBuilder().build();
   *   Operation response =
   *       instancesClient.setShieldedInstanceIntegrityPolicy(
   *           project, zone, instance, shieldedInstanceIntegrityPolicyResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name or id of the instance scoping this request.
   * @param shieldedInstanceIntegrityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setShieldedInstanceIntegrityPolicy(
      String project,
      String zone,
      String instance,
      ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicyResource) {
    SetShieldedInstanceIntegrityPolicyInstanceRequest request =
        SetShieldedInstanceIntegrityPolicyInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setShieldedInstanceIntegrityPolicyResource(shieldedInstanceIntegrityPolicyResource)
            .build();
    return setShieldedInstanceIntegrityPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Shielded Instance integrity policy for an instance. You can only use this method on a
   * running instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetShieldedInstanceIntegrityPolicyInstanceRequest request =
   *       SetShieldedInstanceIntegrityPolicyInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setShieldedInstanceIntegrityPolicyResource(
   *               ShieldedInstanceIntegrityPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setShieldedInstanceIntegrityPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setShieldedInstanceIntegrityPolicy(
      SetShieldedInstanceIntegrityPolicyInstanceRequest request) {
    return setShieldedInstanceIntegrityPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Shielded Instance integrity policy for an instance. You can only use this method on a
   * running instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetShieldedInstanceIntegrityPolicyInstanceRequest request =
   *       SetShieldedInstanceIntegrityPolicyInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setShieldedInstanceIntegrityPolicyResource(
   *               ShieldedInstanceIntegrityPolicy.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.setShieldedInstanceIntegrityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyCallable() {
    return stub.setShieldedInstanceIntegrityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Tags tagsResource = Tags.newBuilder().build();
   *   Operation response = instancesClient.setTags(project, zone, instance, tagsResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param tagsResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTags(String project, String zone, String instance, Tags tagsResource) {
    SetTagsInstanceRequest request =
        SetTagsInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setTagsResource(tagsResource)
            .build();
    return setTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetTagsInstanceRequest request =
   *       SetTagsInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTagsResource(Tags.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.setTags(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setTags(SetTagsInstanceRequest request) {
    return setTagsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SetTagsInstanceRequest request =
   *       SetTagsInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setTagsResource(Tags.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.setTagsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetTagsInstanceRequest, Operation> setTagsCallable() {
    return stub.setTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Operation response = instancesClient.simulateMaintenanceEvent(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation simulateMaintenanceEvent(String project, String zone, String instance) {
    SimulateMaintenanceEventInstanceRequest request =
        SimulateMaintenanceEventInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return simulateMaintenanceEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SimulateMaintenanceEventInstanceRequest request =
   *       SimulateMaintenanceEventInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.simulateMaintenanceEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation simulateMaintenanceEvent(SimulateMaintenanceEventInstanceRequest request) {
    return simulateMaintenanceEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   SimulateMaintenanceEventInstanceRequest request =
   *       SimulateMaintenanceEventInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.simulateMaintenanceEventCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventCallable() {
    return stub.simulateMaintenanceEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Operation response = instancesClient.start(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to start.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation start(String project, String zone, String instance) {
    StartInstanceRequest request =
        StartInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return start(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.start(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation start(StartInstanceRequest request) {
    return startCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.startCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartInstanceRequest, Operation> startCallable() {
    return stub.startCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource =
   *       InstancesStartWithEncryptionKeyRequest.newBuilder().build();
   *   Operation response =
   *       instancesClient.startWithEncryptionKey(
   *           project, zone, instance, instancesStartWithEncryptionKeyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to start.
   * @param instancesStartWithEncryptionKeyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startWithEncryptionKey(
      String project,
      String zone,
      String instance,
      InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource) {
    StartWithEncryptionKeyInstanceRequest request =
        StartWithEncryptionKeyInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstancesStartWithEncryptionKeyRequestResource(
                instancesStartWithEncryptionKeyRequestResource)
            .build();
    return startWithEncryptionKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   StartWithEncryptionKeyInstanceRequest request =
   *       StartWithEncryptionKeyInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesStartWithEncryptionKeyRequestResource(
   *               InstancesStartWithEncryptionKeyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.startWithEncryptionKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startWithEncryptionKey(StartWithEncryptionKeyInstanceRequest request) {
    return startWithEncryptionKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   StartWithEncryptionKeyInstanceRequest request =
   *       StartWithEncryptionKeyInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstancesStartWithEncryptionKeyRequestResource(
   *               InstancesStartWithEncryptionKeyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.startWithEncryptionKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyCallable() {
    return stub.startWithEncryptionKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Operation response = instancesClient.stop(project, zone, instance);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to stop.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation stop(String project, String zone, String instance) {
    StopInstanceRequest request =
        StopInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .build();
    return stop(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.stop(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation stop(StopInstanceRequest request) {
    return stopCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.stopCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopInstanceRequest, Operation> stopCallable() {
    return stub.stopCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       instancesClient.testIamPermissions(
   *           project, zone, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String zone,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsInstanceRequest request =
        TestIamPermissionsInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   TestIamPermissionsInstanceRequest request =
   *       TestIamPermissionsInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   TestPermissionsResponse response = instancesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsInstanceRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   TestIamPermissionsInstanceRequest request =
   *       TestIamPermissionsInstanceRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       instancesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance only if the necessary resources are available. This method can update only
   * a specific set of instance properties. See Updating a running instance for a list of updatable
   * instance properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   Instance instanceResource = Instance.newBuilder().build();
   *   Operation response = instancesClient.update(project, zone, instance, instanceResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance resource to update.
   * @param instanceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String zone, String instance, Instance instanceResource) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setInstanceResource(instanceResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance only if the necessary resources are available. This method can update only
   * a specific set of instance properties. See Updating a running instance for a list of updatable
   * instance properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstanceResource(Instance.newBuilder().build())
   *           .setMinimalAction("minimalAction624261943")
   *           .setMostDisruptiveAllowedAction("mostDisruptiveAllowedAction-1597376488")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.update(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateInstanceRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance only if the necessary resources are available. This method can update only
   * a specific set of instance properties. See Updating a running instance for a list of updatable
   * instance properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setInstanceResource(Instance.newBuilder().build())
   *           .setMinimalAction("minimalAction624261943")
   *           .setMostDisruptiveAllowedAction("mostDisruptiveAllowedAction-1597376488")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = instancesClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateCallable() {
    return stub.updateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   String networkInterface = "networkInterface-341981525";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   Operation response =
   *       instancesClient.updateAccessConfig(
   *           project, zone, instance, networkInterface, accessConfigResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface where the access config is attached.
   * @param accessConfigResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateAccessConfig(
      String project,
      String zone,
      String instance,
      String networkInterface,
      AccessConfig accessConfigResource) {
    UpdateAccessConfigInstanceRequest request =
        UpdateAccessConfigInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setAccessConfigResource(accessConfigResource)
            .build();
    return updateAccessConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateAccessConfigInstanceRequest request =
   *       UpdateAccessConfigInstanceRequest.newBuilder()
   *           .setAccessConfigResource(AccessConfig.newBuilder().build())
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.updateAccessConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateAccessConfig(UpdateAccessConfigInstanceRequest request) {
    return updateAccessConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateAccessConfigInstanceRequest request =
   *       UpdateAccessConfigInstanceRequest.newBuilder()
   *           .setAccessConfigResource(AccessConfig.newBuilder().build())
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.updateAccessConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigCallable() {
    return stub.updateAccessConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Display config for a VM instance. You can only use this method on a stopped VM
   * instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   DisplayDevice displayDeviceResource = DisplayDevice.newBuilder().build();
   *   Operation response =
   *       instancesClient.updateDisplayDevice(project, zone, instance, displayDeviceResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name of the instance scoping this request.
   * @param displayDeviceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateDisplayDevice(
      String project, String zone, String instance, DisplayDevice displayDeviceResource) {
    UpdateDisplayDeviceInstanceRequest request =
        UpdateDisplayDeviceInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setDisplayDeviceResource(displayDeviceResource)
            .build();
    return updateDisplayDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Display config for a VM instance. You can only use this method on a stopped VM
   * instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateDisplayDeviceInstanceRequest request =
   *       UpdateDisplayDeviceInstanceRequest.newBuilder()
   *           .setDisplayDeviceResource(DisplayDevice.newBuilder().build())
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.updateDisplayDevice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateDisplayDevice(UpdateDisplayDeviceInstanceRequest request) {
    return updateDisplayDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Display config for a VM instance. You can only use this method on a stopped VM
   * instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateDisplayDeviceInstanceRequest request =
   *       UpdateDisplayDeviceInstanceRequest.newBuilder()
   *           .setDisplayDeviceResource(DisplayDevice.newBuilder().build())
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.updateDisplayDeviceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceCallable() {
    return stub.updateDisplayDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance's network interface. This method can only update an interface's alias IP
   * range and attached network. See Modifying alias IP ranges for an existing instance for
   * instructions on changing alias IP ranges. See Migrating a VM between networks for instructions
   * on migrating an interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   String networkInterface = "networkInterface-341981525";
   *   NetworkInterface networkInterfaceResource = NetworkInterface.newBuilder().build();
   *   Operation response =
   *       instancesClient.updateNetworkInterface(
   *           project, zone, instance, networkInterface, networkInterfaceResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface to update.
   * @param networkInterfaceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateNetworkInterface(
      String project,
      String zone,
      String instance,
      String networkInterface,
      NetworkInterface networkInterfaceResource) {
    UpdateNetworkInterfaceInstanceRequest request =
        UpdateNetworkInterfaceInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setNetworkInterfaceResource(networkInterfaceResource)
            .build();
    return updateNetworkInterface(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance's network interface. This method can only update an interface's alias IP
   * range and attached network. See Modifying alias IP ranges for an existing instance for
   * instructions on changing alias IP ranges. See Migrating a VM between networks for instructions
   * on migrating an interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateNetworkInterfaceInstanceRequest request =
   *       UpdateNetworkInterfaceInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setNetworkInterfaceResource(NetworkInterface.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.updateNetworkInterface(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateNetworkInterface(UpdateNetworkInterfaceInstanceRequest request) {
    return updateNetworkInterfaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an instance's network interface. This method can only update an interface's alias IP
   * range and attached network. See Modifying alias IP ranges for an existing instance for
   * instructions on changing alias IP ranges. See Migrating a VM between networks for instructions
   * on migrating an interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateNetworkInterfaceInstanceRequest request =
   *       UpdateNetworkInterfaceInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setNetworkInterface("networkInterface-341981525")
   *           .setNetworkInterfaceResource(NetworkInterface.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.updateNetworkInterfaceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceCallable() {
    return stub.updateNetworkInterfaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Shielded Instance config for an instance. You can only use this method on a stopped
   * instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String instance = "instance555127957";
   *   ShieldedInstanceConfig shieldedInstanceConfigResource =
   *       ShieldedInstanceConfig.newBuilder().build();
   *   Operation response =
   *       instancesClient.updateShieldedInstanceConfig(
   *           project, zone, instance, shieldedInstanceConfigResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param instance Name or id of the instance scoping this request.
   * @param shieldedInstanceConfigResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateShieldedInstanceConfig(
      String project,
      String zone,
      String instance,
      ShieldedInstanceConfig shieldedInstanceConfigResource) {
    UpdateShieldedInstanceConfigInstanceRequest request =
        UpdateShieldedInstanceConfigInstanceRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInstance(instance)
            .setShieldedInstanceConfigResource(shieldedInstanceConfigResource)
            .build();
    return updateShieldedInstanceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Shielded Instance config for an instance. You can only use this method on a stopped
   * instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateShieldedInstanceConfigInstanceRequest request =
   *       UpdateShieldedInstanceConfigInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setShieldedInstanceConfigResource(ShieldedInstanceConfig.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = instancesClient.updateShieldedInstanceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateShieldedInstanceConfig(
      UpdateShieldedInstanceConfigInstanceRequest request) {
    return updateShieldedInstanceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Shielded Instance config for an instance. You can only use this method on a stopped
   * instance. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InstancesClient instancesClient = InstancesClient.create()) {
   *   UpdateShieldedInstanceConfigInstanceRequest request =
   *       UpdateShieldedInstanceConfigInstanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setShieldedInstanceConfigResource(ShieldedInstanceConfig.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future =
   *       instancesClient.updateShieldedInstanceConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    return stub.updateShieldedInstanceConfigCallable();
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
          AggregatedListInstancesRequest,
          InstanceAggregatedList,
          Map.Entry<String, InstancesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListInstancesRequest,
                InstanceAggregatedList,
                Map.Entry<String, InstancesScopedList>>
            context,
        ApiFuture<InstanceAggregatedList> futureResponse) {
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
          AggregatedListInstancesRequest,
          InstanceAggregatedList,
          Map.Entry<String, InstancesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListInstancesRequest,
                InstanceAggregatedList,
                Map.Entry<String, InstancesScopedList>>
            context,
        InstanceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListInstancesRequest,
                InstanceAggregatedList,
                Map.Entry<String, InstancesScopedList>>
            context,
        InstanceAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListInstancesRequest,
                InstanceAggregatedList,
                Map.Entry<String, InstancesScopedList>>
            context,
        ApiFuture<InstanceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstancesRequest,
          InstanceAggregatedList,
          Map.Entry<String, InstancesScopedList>,
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
          ListInstancesRequest, InstanceList, Instance, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListInstancesRequest, InstanceList, Instance> context,
        ApiFuture<InstanceList> futureResponse) {
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
      extends AbstractPage<ListInstancesRequest, InstanceList, Instance, ListPage> {

    private ListPage(
        PageContext<ListInstancesRequest, InstanceList, Instance> context, InstanceList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListInstancesRequest, InstanceList, Instance> context, InstanceList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListInstancesRequest, InstanceList, Instance> context,
        ApiFuture<InstanceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest, InstanceList, Instance, ListPage, ListFixedSizeCollection> {

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

  public static class ListReferrersPagedResponse
      extends AbstractPagedListResponse<
          ListReferrersInstancesRequest,
          InstanceListReferrers,
          Reference,
          ListReferrersPage,
          ListReferrersFixedSizeCollection> {

    public static ApiFuture<ListReferrersPagedResponse> createAsync(
        PageContext<ListReferrersInstancesRequest, InstanceListReferrers, Reference> context,
        ApiFuture<InstanceListReferrers> futureResponse) {
      ApiFuture<ListReferrersPage> futurePage =
          ListReferrersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListReferrersPage, ListReferrersPagedResponse>() {
            @Override
            public ListReferrersPagedResponse apply(ListReferrersPage input) {
              return new ListReferrersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListReferrersPagedResponse(ListReferrersPage page) {
      super(page, ListReferrersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReferrersPage
      extends AbstractPage<
          ListReferrersInstancesRequest, InstanceListReferrers, Reference, ListReferrersPage> {

    private ListReferrersPage(
        PageContext<ListReferrersInstancesRequest, InstanceListReferrers, Reference> context,
        InstanceListReferrers response) {
      super(context, response);
    }

    private static ListReferrersPage createEmptyPage() {
      return new ListReferrersPage(null, null);
    }

    @Override
    protected ListReferrersPage createPage(
        PageContext<ListReferrersInstancesRequest, InstanceListReferrers, Reference> context,
        InstanceListReferrers response) {
      return new ListReferrersPage(context, response);
    }

    @Override
    public ApiFuture<ListReferrersPage> createPageAsync(
        PageContext<ListReferrersInstancesRequest, InstanceListReferrers, Reference> context,
        ApiFuture<InstanceListReferrers> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReferrersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReferrersInstancesRequest,
          InstanceListReferrers,
          Reference,
          ListReferrersPage,
          ListReferrersFixedSizeCollection> {

    private ListReferrersFixedSizeCollection(List<ListReferrersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReferrersFixedSizeCollection createEmptyCollection() {
      return new ListReferrersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReferrersFixedSizeCollection createCollection(
        List<ListReferrersPage> pages, int collectionSize) {
      return new ListReferrersFixedSizeCollection(pages, collectionSize);
    }
  }
}
