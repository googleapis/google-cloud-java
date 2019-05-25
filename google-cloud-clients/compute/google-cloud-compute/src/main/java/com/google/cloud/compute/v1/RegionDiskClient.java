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
import com.google.cloud.compute.v1.stub.RegionDiskStub;
import com.google.cloud.compute.v1.stub.RegionDiskStubSettings;
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
 * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
 *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
 *   Snapshot snapshotResource = Snapshot.newBuilder().build();
 *   Operation response = regionDiskClient.createSnapshotRegionDisk(disk, snapshotResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionDiskClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of RegionDiskSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionDiskSettings regionDiskSettings =
 *     RegionDiskSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionDiskClient regionDiskClient =
 *     RegionDiskClient.create(regionDiskSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionDiskSettings regionDiskSettings =
 *     RegionDiskSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionDiskClient regionDiskClient =
 *     RegionDiskClient.create(regionDiskSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionDiskClient implements BackgroundResource {
  private final RegionDiskSettings settings;
  private final RegionDiskStub stub;

  /** Constructs an instance of RegionDiskClient with default settings. */
  public static final RegionDiskClient create() throws IOException {
    return create(RegionDiskSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionDiskClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionDiskClient create(RegionDiskSettings settings) throws IOException {
    return new RegionDiskClient(settings);
  }

  /**
   * Constructs an instance of RegionDiskClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use RegionDiskSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionDiskClient create(RegionDiskStub stub) {
    return new RegionDiskClient(stub);
  }

  /**
   * Constructs an instance of RegionDiskClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RegionDiskClient(RegionDiskSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionDiskStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionDiskClient(RegionDiskStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionDiskSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionDiskStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = regionDiskClient.createSnapshotRegionDisk(disk, snapshotResource);
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk to snapshot.
   * @param snapshotResource A persistent disk snapshot resource. (== resource_for beta.snapshots
   *     ==) (== resource_for v1.snapshots ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createSnapshotRegionDisk(
      ProjectRegionDiskName disk, Snapshot snapshotResource) {

    CreateSnapshotRegionDiskHttpRequest request =
        CreateSnapshotRegionDiskHttpRequest.newBuilder()
            .setDisk(disk == null ? null : disk.toString())
            .setSnapshotResource(snapshotResource)
            .build();
    return createSnapshotRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = regionDiskClient.createSnapshotRegionDisk(disk.toString(), snapshotResource);
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk to snapshot.
   * @param snapshotResource A persistent disk snapshot resource. (== resource_for beta.snapshots
   *     ==) (== resource_for v1.snapshots ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createSnapshotRegionDisk(String disk, Snapshot snapshotResource) {

    CreateSnapshotRegionDiskHttpRequest request =
        CreateSnapshotRegionDiskHttpRequest.newBuilder()
            .setDisk(disk)
            .setSnapshotResource(snapshotResource)
            .build();
    return createSnapshotRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   CreateSnapshotRegionDiskHttpRequest request = CreateSnapshotRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .setSnapshotResource(snapshotResource)
   *     .build();
   *   Operation response = regionDiskClient.createSnapshotRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createSnapshotRegionDisk(CreateSnapshotRegionDiskHttpRequest request) {
    return createSnapshotRegionDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of this regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   CreateSnapshotRegionDiskHttpRequest request = CreateSnapshotRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .setSnapshotResource(snapshotResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDiskClient.createSnapshotRegionDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskCallable() {
    return stub.createSnapshotRegionDiskCallable();
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
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   Operation response = regionDiskClient.deleteRegionDisk(disk);
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionDisk(ProjectRegionDiskName disk) {

    DeleteRegionDiskHttpRequest request =
        DeleteRegionDiskHttpRequest.newBuilder()
            .setDisk(disk == null ? null : disk.toString())
            .build();
    return deleteRegionDisk(request);
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
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   Operation response = regionDiskClient.deleteRegionDisk(disk.toString());
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionDisk(String disk) {

    DeleteRegionDiskHttpRequest request =
        DeleteRegionDiskHttpRequest.newBuilder().setDisk(disk).build();
    return deleteRegionDisk(request);
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
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   DeleteRegionDiskHttpRequest request = DeleteRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .build();
   *   Operation response = regionDiskClient.deleteRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionDisk(DeleteRegionDiskHttpRequest request) {
    return deleteRegionDiskCallable().call(request);
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
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   DeleteRegionDiskHttpRequest request = DeleteRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDiskClient.deleteRegionDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskCallable() {
    return stub.deleteRegionDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   Disk response = regionDiskClient.getRegionDisk(disk);
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Disk getRegionDisk(ProjectRegionDiskName disk) {

    GetRegionDiskHttpRequest request =
        GetRegionDiskHttpRequest.newBuilder()
            .setDisk(disk == null ? null : disk.toString())
            .build();
    return getRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   Disk response = regionDiskClient.getRegionDisk(disk.toString());
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Disk getRegionDisk(String disk) {

    GetRegionDiskHttpRequest request = GetRegionDiskHttpRequest.newBuilder().setDisk(disk).build();
    return getRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   GetRegionDiskHttpRequest request = GetRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .build();
   *   Disk response = regionDiskClient.getRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Disk getRegionDisk(GetRegionDiskHttpRequest request) {
    return getRegionDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   GetRegionDiskHttpRequest request = GetRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .build();
   *   ApiFuture&lt;Disk&gt; future = regionDiskClient.getRegionDiskCallable().futureCall(request);
   *   // Do something
   *   Disk response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionDiskHttpRequest, Disk> getRegionDiskCallable() {
    return stub.getRegionDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Disk diskResource = Disk.newBuilder().build();
   *   Operation response = regionDiskClient.insertRegionDisk(region, diskResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param diskResource A Disk resource. (== resource_for beta.disks ==) (== resource_for v1.disks
   *     ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionDisk(ProjectRegionName region, Disk diskResource) {

    InsertRegionDiskHttpRequest request =
        InsertRegionDiskHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setDiskResource(diskResource)
            .build();
    return insertRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Disk diskResource = Disk.newBuilder().build();
   *   Operation response = regionDiskClient.insertRegionDisk(region.toString(), diskResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param diskResource A Disk resource. (== resource_for beta.disks ==) (== resource_for v1.disks
   *     ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionDisk(String region, Disk diskResource) {

    InsertRegionDiskHttpRequest request =
        InsertRegionDiskHttpRequest.newBuilder()
            .setRegion(region)
            .setDiskResource(diskResource)
            .build();
    return insertRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   Disk diskResource = Disk.newBuilder().build();
   *   InsertRegionDiskHttpRequest request = InsertRegionDiskHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setDiskResource(diskResource)
   *     .build();
   *   Operation response = regionDiskClient.insertRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionDisk(InsertRegionDiskHttpRequest request) {
    return insertRegionDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent regional disk in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   Disk diskResource = Disk.newBuilder().build();
   *   InsertRegionDiskHttpRequest request = InsertRegionDiskHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setDiskResource(diskResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDiskClient.insertRegionDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionDiskHttpRequest, Operation> insertRegionDiskCallable() {
    return stub.insertRegionDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Disk element : regionDiskClient.listRegionDisks(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionDisksPagedResponse listRegionDisks(ProjectRegionName region) {
    ListRegionDisksHttpRequest request =
        ListRegionDisksHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionDisks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Disk element : regionDiskClient.listRegionDisks(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionDisksPagedResponse listRegionDisks(String region) {
    ListRegionDisksHttpRequest request =
        ListRegionDisksHttpRequest.newBuilder().setRegion(region).build();
    return listRegionDisks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionDisksHttpRequest request = ListRegionDisksHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (Disk element : regionDiskClient.listRegionDisks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionDisksPagedResponse listRegionDisks(ListRegionDisksHttpRequest request) {
    return listRegionDisksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionDisksHttpRequest request = ListRegionDisksHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionDisksPagedResponse&gt; future = regionDiskClient.listRegionDisksPagedCallable().futureCall(request);
   *   // Do something
   *   for (Disk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionDisksHttpRequest, ListRegionDisksPagedResponse>
      listRegionDisksPagedCallable() {
    return stub.listRegionDisksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of persistent disks contained within the specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionDisksHttpRequest request = ListRegionDisksHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     DiskList response = regionDiskClient.listRegionDisksCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListRegionDisksHttpRequest, DiskList> listRegionDisksCallable() {
    return stub.listRegionDisksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   Operation response = regionDiskClient.resizeRegionDisk(disk, regionDisksResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk.
   * @param regionDisksResizeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeRegionDisk(
      ProjectRegionDiskName disk, RegionDisksResizeRequest regionDisksResizeRequestResource) {

    ResizeRegionDiskHttpRequest request =
        ResizeRegionDiskHttpRequest.newBuilder()
            .setDisk(disk == null ? null : disk.toString())
            .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
            .build();
    return resizeRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskName disk = ProjectRegionDiskName.of("[PROJECT]", "[REGION]", "[DISK]");
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   Operation response = regionDiskClient.resizeRegionDisk(disk.toString(), regionDisksResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param disk Name of the regional persistent disk.
   * @param regionDisksResizeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeRegionDisk(
      String disk, RegionDisksResizeRequest regionDisksResizeRequestResource) {

    ResizeRegionDiskHttpRequest request =
        ResizeRegionDiskHttpRequest.newBuilder()
            .setDisk(disk)
            .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
            .build();
    return resizeRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   ResizeRegionDiskHttpRequest request = ResizeRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
   *     .build();
   *   Operation response = regionDiskClient.resizeRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeRegionDisk(ResizeRegionDiskHttpRequest request) {
    return resizeRegionDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified regional persistent disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedDisk = ProjectRegionDiskName.format("[PROJECT]", "[REGION]", "[DISK]");
   *   RegionDisksResizeRequest regionDisksResizeRequestResource = RegionDisksResizeRequest.newBuilder().build();
   *   ResizeRegionDiskHttpRequest request = ResizeRegionDiskHttpRequest.newBuilder()
   *     .setDisk(formattedDisk)
   *     .setRegionDisksResizeRequestResource(regionDisksResizeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDiskClient.resizeRegionDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskCallable() {
    return stub.resizeRegionDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskResourceName resource = ProjectRegionDiskResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   Operation response = regionDiskClient.setLabelsRegionDisk(resource, regionSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsRegionDisk(
      ProjectRegionDiskResourceName resource,
      RegionSetLabelsRequest regionSetLabelsRequestResource) {

    SetLabelsRegionDiskHttpRequest request =
        SetLabelsRegionDiskHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabelsRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskResourceName resource = ProjectRegionDiskResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   Operation response = regionDiskClient.setLabelsRegionDisk(resource.toString(), regionSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsRegionDisk(
      String resource, RegionSetLabelsRequest regionSetLabelsRequestResource) {

    SetLabelsRegionDiskHttpRequest request =
        SetLabelsRegionDiskHttpRequest.newBuilder()
            .setResource(resource)
            .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
            .build();
    return setLabelsRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedResource = ProjectRegionDiskResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   SetLabelsRegionDiskHttpRequest request = SetLabelsRegionDiskHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .build();
   *   Operation response = regionDiskClient.setLabelsRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsRegionDisk(SetLabelsRegionDiskHttpRequest request) {
    return setLabelsRegionDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on the target regional disk.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedResource = ProjectRegionDiskResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetLabelsRequest regionSetLabelsRequestResource = RegionSetLabelsRequest.newBuilder().build();
   *   SetLabelsRegionDiskHttpRequest request = SetLabelsRegionDiskHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setRegionSetLabelsRequestResource(regionSetLabelsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionDiskClient.setLabelsRegionDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetLabelsRegionDiskHttpRequest, Operation>
      setLabelsRegionDiskCallable() {
    return stub.setLabelsRegionDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskResourceName resource = ProjectRegionDiskResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = regionDiskClient.testIamPermissionsRegionDisk(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsRegionDisk(
      ProjectRegionDiskResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsRegionDiskHttpRequest request =
        TestIamPermissionsRegionDiskHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   ProjectRegionDiskResourceName resource = ProjectRegionDiskResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = regionDiskClient.testIamPermissionsRegionDisk(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsRegionDisk(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsRegionDiskHttpRequest request =
        TestIamPermissionsRegionDiskHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsRegionDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedResource = ProjectRegionDiskResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsRegionDiskHttpRequest request = TestIamPermissionsRegionDiskHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = regionDiskClient.testIamPermissionsRegionDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsRegionDisk(
      TestIamPermissionsRegionDiskHttpRequest request) {
    return testIamPermissionsRegionDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionDiskClient regionDiskClient = RegionDiskClient.create()) {
   *   String formattedResource = ProjectRegionDiskResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsRegionDiskHttpRequest request = TestIamPermissionsRegionDiskHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = regionDiskClient.testIamPermissionsRegionDiskCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskCallable() {
    return stub.testIamPermissionsRegionDiskCallable();
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

  public static class ListRegionDisksPagedResponse
      extends AbstractPagedListResponse<
          ListRegionDisksHttpRequest,
          DiskList,
          Disk,
          ListRegionDisksPage,
          ListRegionDisksFixedSizeCollection> {

    public static ApiFuture<ListRegionDisksPagedResponse> createAsync(
        PageContext<ListRegionDisksHttpRequest, DiskList, Disk> context,
        ApiFuture<DiskList> futureResponse) {
      ApiFuture<ListRegionDisksPage> futurePage =
          ListRegionDisksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionDisksPage, ListRegionDisksPagedResponse>() {
            @Override
            public ListRegionDisksPagedResponse apply(ListRegionDisksPage input) {
              return new ListRegionDisksPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionDisksPagedResponse(ListRegionDisksPage page) {
      super(page, ListRegionDisksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionDisksPage
      extends AbstractPage<ListRegionDisksHttpRequest, DiskList, Disk, ListRegionDisksPage> {

    private ListRegionDisksPage(
        PageContext<ListRegionDisksHttpRequest, DiskList, Disk> context, DiskList response) {
      super(context, response);
    }

    private static ListRegionDisksPage createEmptyPage() {
      return new ListRegionDisksPage(null, null);
    }

    @Override
    protected ListRegionDisksPage createPage(
        PageContext<ListRegionDisksHttpRequest, DiskList, Disk> context, DiskList response) {
      return new ListRegionDisksPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionDisksPage> createPageAsync(
        PageContext<ListRegionDisksHttpRequest, DiskList, Disk> context,
        ApiFuture<DiskList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionDisksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionDisksHttpRequest,
          DiskList,
          Disk,
          ListRegionDisksPage,
          ListRegionDisksFixedSizeCollection> {

    private ListRegionDisksFixedSizeCollection(
        List<ListRegionDisksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionDisksFixedSizeCollection createEmptyCollection() {
      return new ListRegionDisksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionDisksFixedSizeCollection createCollection(
        List<ListRegionDisksPage> pages, int collectionSize) {
      return new ListRegionDisksFixedSizeCollection(pages, collectionSize);
    }
  }
}
