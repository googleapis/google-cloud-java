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
import com.google.cloud.compute.v1.stub.RegionDisksStub;
import com.google.cloud.compute.v1.stub.RegionDisksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionDisks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String disk = "";
 *   RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource = RegionDisksAddResourcePoliciesRequest.newBuilder().build();
 *   Operation response = regionDisksClient.addResourcePolicies(project, region, disk, regionDisksAddResourcePoliciesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionDisksClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of RegionDisksSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionDisksSettings regionDisksSettings =
 *     RegionDisksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionDisksClient regionDisksClient =
 *     RegionDisksClient.create(regionDisksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionDisksSettings regionDisksSettings =
 *     RegionDisksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionDisksClient regionDisksClient =
 *     RegionDisksClient.create(regionDisksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionDisksClient implements BackgroundResource {
  private final RegionDisksSettings settings;
  private final RegionDisksStub stub;

  /** Constructs an instance of RegionDisksClient with default settings. */
  public static final RegionDisksClient create() throws IOException {
    return create(RegionDisksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionDisksClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionDisksClient create(RegionDisksSettings settings) throws IOException {
    return new RegionDisksClient(settings);
  }

  /**
   * Constructs an instance of RegionDisksClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use RegionDisksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionDisksClient create(RegionDisksStub stub) {
    return new RegionDisksClient(stub);
  }

  /**
   * Constructs an instance of RegionDisksClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionDisksClient(RegionDisksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionDisksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionDisksClient(RegionDisksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionDisksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionDisksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds existing resource policies to a regional disk. You can only add one policy which will be
   * applied to this disk for scheduling snapshot creation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String disk = "";
   *   RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource = RegionDisksAddResourcePoliciesRequest.newBuilder().build();
   *   Operation response = regionDisksClient.addResourcePolicies(project, region, disk, regionDisksAddResourcePoliciesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param disk The disk name for this request.
   * @param regionDisksAddResourcePoliciesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addResourcePolicies(
      String project,
      String region,
      String disk,
      RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource) {
    AddResourcePoliciesRegionDiskRequest request =
        AddResourcePoliciesRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDisk(disk)
            .setRegionDisksAddResourcePoliciesRequestResource(
                regionDisksAddResourcePoliciesRequestResource)
            .build();
    return addResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds existing resource policies to a regional disk. You can only add one policy which will be
   * applied to this disk for scheduling snapshot creation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource = RegionDisksAddResourcePoliciesRequest.newBuilder().build();
   *   AddResourcePoliciesRegionDiskRequest request = AddResourcePoliciesRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionDisksAddResourcePoliciesRequestResource(regionDisksAddResourcePoliciesRequestResource)
   *     .build();
   *   Operation response = regionDisksClient.addResourcePolicies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addResourcePolicies(AddResourcePoliciesRegionDiskRequest request) {
    return addResourcePoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds existing resource policies to a regional disk. You can only add one policy which will be
   * applied to this disk for scheduling snapshot creation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   RegionDisksAddResourcePoliciesRequest regionDisksAddResourcePoliciesRequestResource = RegionDisksAddResourcePoliciesRequest.newBuilder().build();
   *   AddResourcePoliciesRegionDiskRequest request = AddResourcePoliciesRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionDisksAddResourcePoliciesRequestResource(regionDisksAddResourcePoliciesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.addResourcePoliciesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable() {
    return stub.addResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String disk = "";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = regionDisksClient.createSnapshot(project, region, disk, snapshotResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param disk Name of the regional persistent disk to snapshot.
   * @param snapshotResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createSnapshot(
      String project, String region, String disk, Snapshot snapshotResource) {
    CreateSnapshotRegionDiskRequest request =
        CreateSnapshotRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDisk(disk)
            .setSnapshotResource(snapshotResource)
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   CreateSnapshotRegionDiskRequest request = CreateSnapshotRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSnapshotResource(snapshotResource)
   *     .build();
   *   Operation response = regionDisksClient.createSnapshot(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createSnapshot(CreateSnapshotRegionDiskRequest request) {
    return createSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   CreateSnapshotRegionDiskRequest request = CreateSnapshotRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSnapshotResource(snapshotResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.createSnapshotCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateSnapshotRegionDiskRequest, Operation> createSnapshotCallable() {
    return stub.createSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional persistent disk. Deleting a regional disk removes all the
   * replicas of its data permanently and is irreversible. However, deleting a disk does not delete
   * any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String disk = "";
   *   Operation response = regionDisksClient.delete(project, region, disk);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param disk Name of the regional persistent disk to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String disk) {
    DeleteRegionDiskRequest request =
        DeleteRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDisk(disk)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional persistent disk. Deleting a regional disk removes all the
   * replicas of its data permanently and is irreversible. However, deleting a disk does not delete
   * any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionDiskRequest request = DeleteRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionDisksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionDiskRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional persistent disk. Deleting a regional disk removes all the
   * replicas of its data permanently and is irreversible. However, deleting a disk does not delete
   * any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   DeleteRegionDiskRequest request = DeleteRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionDiskRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String disk = "";
   *   Disk response = regionDisksClient.get(project, region, disk);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param disk Name of the regional persistent disk to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Disk get(String project, String region, String disk) {
    GetRegionDiskRequest request =
        GetRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDisk(disk)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionDiskRequest request = GetRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Disk response = regionDisksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Disk get(GetRegionDiskRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   GetRegionDiskRequest request = GetRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Disk&gt; future = regionDisksClient.getCallable().futureCall(request);
   *   // Do something
   *   Disk response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionDiskRequest, Disk> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   Policy response = regionDisksClient.getIamPolicy(project, region, resource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicyRegionDiskRequest request =
        GetIamPolicyRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicyRegionDiskRequest request = GetIamPolicyRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   Policy response = regionDisksClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRegionDiskRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicyRegionDiskRequest request = GetIamPolicyRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = regionDisksClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Disk diskResource = Disk.newBuilder().build();
   *   Operation response = regionDisksClient.insert(project, region, diskResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param diskResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, Disk diskResource) {
    InsertRegionDiskRequest request =
        InsertRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDiskResource(diskResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   Disk diskResource = Disk.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionDiskRequest request = InsertRegionDiskRequest.newBuilder()
   *     .setDiskResource(diskResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = regionDisksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionDiskRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   Disk diskResource = Disk.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertRegionDiskRequest request = InsertRegionDiskRequest.newBuilder()
   *     .setDiskResource(diskResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionDiskRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (Disk element : regionDisksClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionDisksRequest request =
        ListRegionDisksRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionDisksRequest request = ListRegionDisksRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (Disk element : regionDisksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionDisksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionDisksRequest request = ListRegionDisksRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionDisksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Disk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionDisksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionDisksRequest request = ListRegionDisksRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     DiskList response = regionDisksClient.listCallable().call(request);
   *     for (Disk element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionDisksRequest, DiskList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes resource policies from a regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String disk = "";
   *   RegionDisksRemoveResourcePoliciesRequest regionDisksRemoveResourcePoliciesRequestResource = RegionDisksRemoveResourcePoliciesRequest.newBuilder().build();
   *   Operation response = regionDisksClient.removeResourcePolicies(project, region, disk, regionDisksRemoveResourcePoliciesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param disk The disk name for this request.
   * @param regionDisksRemoveResourcePoliciesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeResourcePolicies(
      String project,
      String region,
      String disk,
      RegionDisksRemoveResourcePoliciesRequest regionDisksRemoveResourcePoliciesRequestResource) {
    RemoveResourcePoliciesRegionDiskRequest request =
        RemoveResourcePoliciesRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDisk(disk)
            .setRegionDisksRemoveResourcePoliciesRequestResource(
                regionDisksRemoveResourcePoliciesRequestResource)
            .build();
    return removeResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes resource policies from a regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   RegionDisksRemoveResourcePoliciesRequest regionDisksRemoveResourcePoliciesRequestResource = RegionDisksRemoveResourcePoliciesRequest.newBuilder().build();
   *   RemoveResourcePoliciesRegionDiskRequest request = RemoveResourcePoliciesRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionDisksRemoveResourcePoliciesRequestResource(regionDisksRemoveResourcePoliciesRequestResource)
   *     .build();
   *   Operation response = regionDisksClient.removeResourcePolicies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeResourcePolicies(RemoveResourcePoliciesRegionDiskRequest request) {
    return removeResourcePoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes resource policies from a regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   RegionDisksRemoveResourcePoliciesRequest regionDisksRemoveResourcePoliciesRequestResource = RegionDisksRemoveResourcePoliciesRequest.newBuilder().build();
   *   RemoveResourcePoliciesRegionDiskRequest request = RemoveResourcePoliciesRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionDisksRemoveResourcePoliciesRequestResource(regionDisksRemoveResourcePoliciesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.removeResourcePoliciesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    return stub.removeResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String disk = "";
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   Operation response = regionDisksClient.resize(project, region, disk, regionDisksResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param project The project ID for this request.
   * @param region Name of the region for this request.
   * @param disk Name of the regional persistent disk.
   * @param regionDisksResizeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(
      String project,
      String region,
      String disk,
      RegionDisksResizeRequest regionDisksResizeRequestResource) {
    ResizeRegionDiskRequest request =
        ResizeRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setDisk(disk)
            .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
            .build();
    return resize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   ResizeRegionDiskRequest request = ResizeRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
   *     .build();
   *   Operation response = regionDisksClient.resize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(ResizeRegionDiskRequest request) {
    return resizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String region = "";
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   ResizeRegionDiskRequest request = ResizeRegionDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.resizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ResizeRegionDiskRequest, Operation> resizeCallable() {
    return stub.resizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = regionDisksClient.setIamPolicy(project, region, resource, regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String region,
      String resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {
    SetIamPolicyRegionDiskRequest request =
        SetIamPolicyRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicyRegionDiskRequest request = SetIamPolicyRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   Policy response = regionDisksClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRegionDiskRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicyRegionDiskRequest request = SetIamPolicyRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = regionDisksClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   Operation response = regionDisksClient.setLabels(project, region, resource, regionSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project,
      String region,
      String resource,
      RegionSetLabelsRequest regionSetLabelsRequestResource) {
    SetLabelsRegionDiskRequest request =
        SetLabelsRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   String resource = "";
   *   SetLabelsRegionDiskRequest request = SetLabelsRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .setResource(resource)
   *     .build();
   *   Operation response = regionDisksClient.setLabels(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsRegionDiskRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   String resource = "";
   *   SetLabelsRegionDiskRequest request = SetLabelsRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDisksClient.setLabelsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLabelsRegionDiskRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = regionDisksClient.testIamPermissions(project, region, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsRegionDiskRequest request =
        TestIamPermissionsRegionDiskRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsRegionDiskRequest request = TestIamPermissionsRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = regionDisksClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsRegionDiskRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDisksClient regionDisksClient = RegionDisksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsRegionDiskRequest request = TestIamPermissionsRegionDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = regionDisksClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionDisksRequest, DiskList, Disk, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionDisksRequest, DiskList, Disk> context,
        ApiFuture<DiskList> futureResponse) {
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
      extends AbstractPage<ListRegionDisksRequest, DiskList, Disk, ListPage> {

    private ListPage(
        PageContext<ListRegionDisksRequest, DiskList, Disk> context, DiskList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionDisksRequest, DiskList, Disk> context, DiskList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionDisksRequest, DiskList, Disk> context,
        ApiFuture<DiskList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionDisksRequest, DiskList, Disk, ListPage, ListFixedSizeCollection> {

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
}
