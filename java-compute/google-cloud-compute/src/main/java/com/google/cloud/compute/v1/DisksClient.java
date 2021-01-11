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
import com.google.cloud.compute.v1.stub.DisksStub;
import com.google.cloud.compute.v1.stub.DisksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Disks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DisksClient disksClient = DisksClient.create()) {
 *   String project = "";
 *   String zone = "";
 *   String disk = "";
 *   DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource = DisksAddResourcePoliciesRequest.newBuilder().build();
 *   Operation response = disksClient.addResourcePolicies(project, zone, disk, disksAddResourcePoliciesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the disksClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DisksSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DisksSettings disksSettings =
 *     DisksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DisksClient disksClient =
 *     DisksClient.create(disksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DisksSettings disksSettings =
 *     DisksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DisksClient disksClient =
 *     DisksClient.create(disksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DisksClient implements BackgroundResource {
  private final DisksSettings settings;
  private final DisksStub stub;

  /** Constructs an instance of DisksClient with default settings. */
  public static final DisksClient create() throws IOException {
    return create(DisksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DisksClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DisksClient create(DisksSettings settings) throws IOException {
    return new DisksClient(settings);
  }

  /**
   * Constructs an instance of DisksClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use DisksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DisksClient create(DisksStub stub) {
    return new DisksClient(stub);
  }

  /**
   * Constructs an instance of DisksClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DisksClient(DisksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DisksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DisksClient(DisksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DisksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DisksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds existing resource policies to a disk. You can only add one policy which will be applied to
   * this disk for scheduling snapshot creation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String disk = "";
   *   DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource = DisksAddResourcePoliciesRequest.newBuilder().build();
   *   Operation response = disksClient.addResourcePolicies(project, zone, disk, disksAddResourcePoliciesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param disk The disk name for this request.
   * @param disksAddResourcePoliciesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addResourcePolicies(
      String project,
      String zone,
      String disk,
      DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource) {
    AddResourcePoliciesDiskRequest request =
        AddResourcePoliciesDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setDisk(disk)
            .setDisksAddResourcePoliciesRequestResource(disksAddResourcePoliciesRequestResource)
            .build();
    return addResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds existing resource policies to a disk. You can only add one policy which will be applied to
   * this disk for scheduling snapshot creation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource = DisksAddResourcePoliciesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AddResourcePoliciesDiskRequest request = AddResourcePoliciesDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setDisksAddResourcePoliciesRequestResource(disksAddResourcePoliciesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = disksClient.addResourcePolicies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addResourcePolicies(AddResourcePoliciesDiskRequest request) {
    return addResourcePoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds existing resource policies to a disk. You can only add one policy which will be applied to
   * this disk for scheduling snapshot creation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   DisksAddResourcePoliciesRequest disksAddResourcePoliciesRequestResource = DisksAddResourcePoliciesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   AddResourcePoliciesDiskRequest request = AddResourcePoliciesDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setDisksAddResourcePoliciesRequestResource(disksAddResourcePoliciesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.addResourcePoliciesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesCallable() {
    return stub.addResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, DisksScopedList&gt; element : disksClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListDisksRequest request =
        AggregatedListDisksRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   AggregatedListDisksRequest request = AggregatedListDisksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, DisksScopedList&gt; element : disksClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListDisksRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   AggregatedListDisksRequest request = AggregatedListDisksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = disksClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, DisksScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListDisksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   AggregatedListDisksRequest request = AggregatedListDisksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     DiskAggregatedList response = disksClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, DisksScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListDisksRequest, DiskAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String disk = "";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = disksClient.createSnapshot(project, zone, disk, snapshotResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param disk Name of the persistent disk to snapshot.
   * @param snapshotResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createSnapshot(
      String project, String zone, String disk, Snapshot snapshotResource) {
    CreateSnapshotDiskRequest request =
        CreateSnapshotDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setDisk(disk)
            .setSnapshotResource(snapshotResource)
            .build();
    return createSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   String zone = "";
   *   CreateSnapshotDiskRequest request = CreateSnapshotDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setSnapshotResource(snapshotResource)
   *     .setZone(zone)
   *     .build();
   *   Operation response = disksClient.createSnapshot(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createSnapshot(CreateSnapshotDiskRequest request) {
    return createSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   String zone = "";
   *   CreateSnapshotDiskRequest request = CreateSnapshotDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setSnapshotResource(snapshotResource)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.createSnapshotCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateSnapshotDiskRequest, Operation> createSnapshotCallable() {
    return stub.createSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is
   * irreversible. However, deleting a disk does not delete any snapshots previously made from the
   * disk. You must separately delete snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String disk = "";
   *   Operation response = disksClient.delete(project, zone, disk);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param disk Name of the persistent disk to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String zone, String disk) {
    DeleteDiskRequest request =
        DeleteDiskRequest.newBuilder().setProject(project).setZone(zone).setDisk(disk).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is
   * irreversible. However, deleting a disk does not delete any snapshots previously made from the
   * disk. You must separately delete snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteDiskRequest request = DeleteDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = disksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteDiskRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is
   * irreversible. However, deleting a disk does not delete any snapshots previously made from the
   * disk. You must separately delete snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String zone = "";
   *   DeleteDiskRequest request = DeleteDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteDiskRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Gets a list of available persistent disks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String disk = "";
   *   Disk response = disksClient.get(project, zone, disk);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param disk Name of the persistent disk to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Disk get(String project, String zone, String disk) {
    GetDiskRequest request =
        GetDiskRequest.newBuilder().setProject(project).setZone(zone).setDisk(disk).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Gets a list of available persistent disks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String zone = "";
   *   GetDiskRequest request = GetDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Disk response = disksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Disk get(GetDiskRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Gets a list of available persistent disks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   String project = "";
   *   String zone = "";
   *   GetDiskRequest request = GetDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Disk&gt; future = disksClient.getCallable().futureCall(request);
   *   // Do something
   *   Disk response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDiskRequest, Disk> getCallable() {
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
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String resource = "";
   *   Policy response = disksClient.getIamPolicy(project, zone, resource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String zone, String resource) {
    GetIamPolicyDiskRequest request =
        GetIamPolicyDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   String zone = "";
   *   GetIamPolicyDiskRequest request = GetIamPolicyDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setZone(zone)
   *     .build();
   *   Policy response = disksClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyDiskRequest request) {
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
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   String zone = "";
   *   GetIamPolicyDiskRequest request = GetIamPolicyDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = disksClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyDiskRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can
   * create a disk from a source (sourceImage, sourceSnapshot, or sourceDisk) or create an empty 500
   * GB data disk by omitting all properties. You can also create a disk that is larger than the
   * default size by specifying the sizeGb property.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   Disk diskResource = Disk.newBuilder().build();
   *   Operation response = disksClient.insert(project, zone, diskResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param diskResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String zone, Disk diskResource) {
    InsertDiskRequest request =
        InsertDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setDiskResource(diskResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can
   * create a disk from a source (sourceImage, sourceSnapshot, or sourceDisk) or create an empty 500
   * GB data disk by omitting all properties. You can also create a disk that is larger than the
   * default size by specifying the sizeGb property.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   Disk diskResource = Disk.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertDiskRequest request = InsertDiskRequest.newBuilder()
   *     .setDiskResource(diskResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = disksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertDiskRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can
   * create a disk from a source (sourceImage, sourceSnapshot, or sourceDisk) or create an empty 500
   * GB data disk by omitting all properties. You can also create a disk that is larger than the
   * default size by specifying the sizeGb property.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   Disk diskResource = Disk.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   InsertDiskRequest request = InsertDiskRequest.newBuilder()
   *     .setDiskResource(diskResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertDiskRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   for (Disk element : disksClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListDisksRequest request =
        ListDisksRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListDisksRequest request = ListDisksRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   for (Disk element : disksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListDisksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListDisksRequest request = ListDisksRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = disksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Disk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDisksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   ListDisksRequest request = ListDisksRequest.newBuilder()
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   while (true) {
   *     DiskList response = disksClient.listCallable().call(request);
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
  public final UnaryCallable<ListDisksRequest, DiskList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes resource policies from a disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String disk = "";
   *   DisksRemoveResourcePoliciesRequest disksRemoveResourcePoliciesRequestResource = DisksRemoveResourcePoliciesRequest.newBuilder().build();
   *   Operation response = disksClient.removeResourcePolicies(project, zone, disk, disksRemoveResourcePoliciesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param disk The disk name for this request.
   * @param disksRemoveResourcePoliciesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeResourcePolicies(
      String project,
      String zone,
      String disk,
      DisksRemoveResourcePoliciesRequest disksRemoveResourcePoliciesRequestResource) {
    RemoveResourcePoliciesDiskRequest request =
        RemoveResourcePoliciesDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setDisk(disk)
            .setDisksRemoveResourcePoliciesRequestResource(
                disksRemoveResourcePoliciesRequestResource)
            .build();
    return removeResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes resource policies from a disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   DisksRemoveResourcePoliciesRequest disksRemoveResourcePoliciesRequestResource = DisksRemoveResourcePoliciesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   RemoveResourcePoliciesDiskRequest request = RemoveResourcePoliciesDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setDisksRemoveResourcePoliciesRequestResource(disksRemoveResourcePoliciesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = disksClient.removeResourcePolicies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeResourcePolicies(RemoveResourcePoliciesDiskRequest request) {
    return removeResourcePoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes resource policies from a disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   DisksRemoveResourcePoliciesRequest disksRemoveResourcePoliciesRequestResource = DisksRemoveResourcePoliciesRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   RemoveResourcePoliciesDiskRequest request = RemoveResourcePoliciesDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setDisksRemoveResourcePoliciesRequestResource(disksRemoveResourcePoliciesRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.removeResourcePoliciesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    return stub.removeResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk. You can only increase the size of the disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String disk = "";
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   Operation response = disksClient.resize(project, zone, disk, disksResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param disk The name of the persistent disk.
   * @param disksResizeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(
      String project, String zone, String disk, DisksResizeRequest disksResizeRequestResource) {
    ResizeDiskRequest request =
        ResizeDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setDisk(disk)
            .setDisksResizeRequestResource(disksResizeRequestResource)
            .build();
    return resize(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk. You can only increase the size of the disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ResizeDiskRequest request = ResizeDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setDisksResizeRequestResource(disksResizeRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   Operation response = disksClient.resize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resize(ResizeDiskRequest request) {
    return resizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk. You can only increase the size of the disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String disk = "";
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   String project = "";
   *   String zone = "";
   *   ResizeDiskRequest request = ResizeDiskRequest.newBuilder()
   *     .setDisk(disk)
   *     .setDisksResizeRequestResource(disksResizeRequestResource)
   *     .setProject(project)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.resizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ResizeDiskRequest, Operation> resizeCallable() {
    return stub.resizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String resource = "";
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response = disksClient.setIamPolicy(project, zone, resource, zoneSetPolicyRequestResource);
   * }
   * </code></pre>
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
    SetIamPolicyDiskRequest request =
        SetIamPolicyDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
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
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   String zone = "";
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyDiskRequest request = SetIamPolicyDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setZone(zone)
   *     .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
   *     .build();
   *   Policy response = disksClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyDiskRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   String zone = "";
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyDiskRequest request = SetIamPolicyDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setZone(zone)
   *     .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = disksClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyDiskRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a disk. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String resource = "";
   *   ZoneSetLabelsRequest zoneSetLabelsRequestResource = ZoneSetLabelsRequest.newBuilder().build();
   *   Operation response = disksClient.setLabels(project, zone, resource, zoneSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param zoneSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project,
      String zone,
      String resource,
      ZoneSetLabelsRequest zoneSetLabelsRequestResource) {
    SetLabelsDiskRequest request =
        SetLabelsDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setZoneSetLabelsRequestResource(zoneSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a disk. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   String zone = "";
   *   ZoneSetLabelsRequest zoneSetLabelsRequestResource = ZoneSetLabelsRequest.newBuilder().build();
   *   SetLabelsDiskRequest request = SetLabelsDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setZone(zone)
   *     .setZoneSetLabelsRequestResource(zoneSetLabelsRequestResource)
   *     .build();
   *   Operation response = disksClient.setLabels(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsDiskRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a disk. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   String zone = "";
   *   ZoneSetLabelsRequest zoneSetLabelsRequestResource = ZoneSetLabelsRequest.newBuilder().build();
   *   SetLabelsDiskRequest request = SetLabelsDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setZone(zone)
   *     .setZoneSetLabelsRequestResource(zoneSetLabelsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = disksClient.setLabelsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLabelsDiskRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String zone = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = disksClient.testIamPermissions(project, zone, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
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
    TestIamPermissionsDiskRequest request =
        TestIamPermissionsDiskRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
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
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   String zone = "";
   *   TestIamPermissionsDiskRequest request = TestIamPermissionsDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .setZone(zone)
   *     .build();
   *   TestPermissionsResponse response = disksClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(TestIamPermissionsDiskRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DisksClient disksClient = DisksClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   String zone = "";
   *   TestIamPermissionsDiskRequest request = TestIamPermissionsDiskRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .setZone(zone)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = disksClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsDiskRequest, TestPermissionsResponse>
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListDisksRequest,
          DiskAggregatedList,
          Entry<String, DisksScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<AggregatedListDisksRequest, DiskAggregatedList, Entry<String, DisksScopedList>>
            context,
        ApiFuture<DiskAggregatedList> futureResponse) {
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
          AggregatedListDisksRequest,
          DiskAggregatedList,
          Entry<String, DisksScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<AggregatedListDisksRequest, DiskAggregatedList, Entry<String, DisksScopedList>>
            context,
        DiskAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<AggregatedListDisksRequest, DiskAggregatedList, Entry<String, DisksScopedList>>
            context,
        DiskAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<AggregatedListDisksRequest, DiskAggregatedList, Entry<String, DisksScopedList>>
            context,
        ApiFuture<DiskAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListDisksRequest,
          DiskAggregatedList,
          Entry<String, DisksScopedList>,
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
          ListDisksRequest, DiskList, Disk, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListDisksRequest, DiskList, Disk> context, ApiFuture<DiskList> futureResponse) {
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

  public static class ListPage extends AbstractPage<ListDisksRequest, DiskList, Disk, ListPage> {

    private ListPage(PageContext<ListDisksRequest, DiskList, Disk> context, DiskList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListDisksRequest, DiskList, Disk> context, DiskList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListDisksRequest, DiskList, Disk> context, ApiFuture<DiskList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDisksRequest, DiskList, Disk, ListPage, ListFixedSizeCollection> {

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
