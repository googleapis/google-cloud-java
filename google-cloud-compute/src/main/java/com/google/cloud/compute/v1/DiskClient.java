/*
 * Copyright 2018 Google LLC
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
import com.google.api.gax.paging.FixedSizeCollection;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.stub.DiskStub;
import com.google.cloud.compute.v1.stub.DiskStubSettings;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
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
 * try (DiskClient diskClient = DiskClient.create()) {
 *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
 *   Snapshot snapshotResource = Snapshot.newBuilder().build();
 *   Operation response = diskClient.createSnapshotDisk(disk, snapshotResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the diskClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * API callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of DiskSettings to
 * create(). For example:
 *
 * To customize credentials:
 *
 * <pre>
 * <code>
 * DiskSettings diskSettings =
 *     DiskSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DiskClient diskClient =
 *     DiskClient.create(diskSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DiskSettings diskSettings =
 *     DiskSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DiskClient diskClient =
 *     DiskClient.create(diskSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DiskClient implements BackgroundResource {
  private final DiskSettings settings;
  private final DiskStub stub;



  /**
   * Constructs an instance of DiskClient with default settings.
   */
  public static final DiskClient create() throws IOException {
    return create(DiskSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DiskClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final DiskClient create(DiskSettings settings) throws IOException {
    return new DiskClient(settings);
  }

  /**
   * Constructs an instance of DiskClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use DiskSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DiskClient create(DiskStub stub) {
    return new DiskClient(stub);
  }

  /**
   * Constructs an instance of DiskClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected DiskClient(DiskSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DiskStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DiskClient(DiskStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DiskSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DiskStub getStub() {
    return stub;
  }


  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (DisksScopedList element : diskClient.aggregatedListDisks(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListDisksPagedResponse aggregatedListDisks(ProjectName project) {
    AggregatedListDisksHttpRequest request =
        AggregatedListDisksHttpRequest.newBuilder()
        .setProject(project == null ? null : project.toString())
        .build();
    return aggregatedListDisks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (DisksScopedList element : diskClient.aggregatedListDisks(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListDisksPagedResponse aggregatedListDisks(String project) {
    AggregatedListDisksHttpRequest request =
        AggregatedListDisksHttpRequest.newBuilder()
        .setProject(project)
        .build();
    return aggregatedListDisks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListDisksHttpRequest request = AggregatedListDisksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (DisksScopedList element : diskClient.aggregatedListDisks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListDisksPagedResponse aggregatedListDisks(AggregatedListDisksHttpRequest request) {
    return aggregatedListDisksPagedCallable()
        .call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListDisksHttpRequest request = AggregatedListDisksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListDisksPagedResponse&gt; future = diskClient.aggregatedListDisksPagedCallable().futureCall(request);
   *   // Do something
   *   for (DisksScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AggregatedListDisksHttpRequest, AggregatedListDisksPagedResponse> aggregatedListDisksPagedCallable() {
    return stub.aggregatedListDisksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of persistent disks.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListDisksHttpRequest request = AggregatedListDisksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     DiskAggregatedList response = diskClient.aggregatedListDisksCallable().call(request);
   *     for (DisksScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListDisksHttpRequest, DiskAggregatedList> aggregatedListDisksCallable() {
    return stub.aggregatedListDisksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = diskClient.createSnapshotDisk(disk, snapshotResource);
   * }
   * </code></pre>
   *
   * @param disk Name of the persistent disk to snapshot.
   * @param snapshotResource A persistent disk snapshot resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createSnapshotDisk(DiskName disk, Snapshot snapshotResource) {

    CreateSnapshotDiskHttpRequest request =
        CreateSnapshotDiskHttpRequest.newBuilder()
        .setDisk(disk == null ? null : disk.toString())
        .setSnapshotResource(snapshotResource)
        .build();
    return createSnapshotDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = diskClient.createSnapshotDisk(disk.toString(), snapshotResource);
   * }
   * </code></pre>
   *
   * @param disk Name of the persistent disk to snapshot.
   * @param snapshotResource A persistent disk snapshot resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createSnapshotDisk(String disk, Snapshot snapshotResource) {

    CreateSnapshotDiskHttpRequest request =
        CreateSnapshotDiskHttpRequest.newBuilder()
        .setDisk(disk)
        .setSnapshotResource(snapshotResource)
        .build();
    return createSnapshotDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   CreateSnapshotDiskHttpRequest request = CreateSnapshotDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .setSnapshotResource(snapshotResource)
   *     .build();
   *   Operation response = diskClient.createSnapshotDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createSnapshotDisk(CreateSnapshotDiskHttpRequest request) {
    return createSnapshotDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a snapshot of a specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   CreateSnapshotDiskHttpRequest request = CreateSnapshotDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .setSnapshotResource(snapshotResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = diskClient.createSnapshotDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<CreateSnapshotDiskHttpRequest, Operation> createSnapshotDiskCallable() {
    return stub.createSnapshotDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is irreversible. However, deleting a disk does not delete any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Operation response = diskClient.deleteDisk(disk);
   * }
   * </code></pre>
   *
   * @param disk Name of the persistent disk to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteDisk(DiskName disk) {

    DeleteDiskHttpRequest request =
        DeleteDiskHttpRequest.newBuilder()
        .setDisk(disk == null ? null : disk.toString())
        .build();
    return deleteDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is irreversible. However, deleting a disk does not delete any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Operation response = diskClient.deleteDisk(disk.toString());
   * }
   * </code></pre>
   *
   * @param disk Name of the persistent disk to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteDisk(String disk) {

    DeleteDiskHttpRequest request =
        DeleteDiskHttpRequest.newBuilder()
        .setDisk(disk)
        .build();
    return deleteDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is irreversible. However, deleting a disk does not delete any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   DeleteDiskHttpRequest request = DeleteDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .build();
   *   Operation response = diskClient.deleteDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteDisk(DeleteDiskHttpRequest request) {
    return deleteDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified persistent disk. Deleting a disk removes its data permanently and is irreversible. However, deleting a disk does not delete any snapshots previously made from the disk. You must separately delete snapshots.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   DeleteDiskHttpRequest request = DeleteDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = diskClient.deleteDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteDiskHttpRequest, Operation> deleteDiskCallable() {
    return stub.deleteDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Get a list of available persistent disks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Disk response = diskClient.getDisk(disk);
   * }
   * </code></pre>
   *
   * @param disk Name of the persistent disk to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Disk getDisk(DiskName disk) {

    GetDiskHttpRequest request =
        GetDiskHttpRequest.newBuilder()
        .setDisk(disk == null ? null : disk.toString())
        .build();
    return getDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Get a list of available persistent disks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   Disk response = diskClient.getDisk(disk.toString());
   * }
   * </code></pre>
   *
   * @param disk Name of the persistent disk to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Disk getDisk(String disk) {

    GetDiskHttpRequest request =
        GetDiskHttpRequest.newBuilder()
        .setDisk(disk)
        .build();
    return getDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Get a list of available persistent disks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   GetDiskHttpRequest request = GetDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .build();
   *   Disk response = diskClient.getDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Disk getDisk(GetDiskHttpRequest request) {
    return getDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a specified persistent disk. Get a list of available persistent disks by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   GetDiskHttpRequest request = GetDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .build();
   *   ApiFuture&lt;Disk&gt; future = diskClient.getDiskCallable().futureCall(request);
   *   // Do something
   *   Disk response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetDiskHttpRequest, Disk> getDiskCallable() {
    return stub.getDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can create a disk with a sourceImage, a sourceSnapshot, or create an empty 500 GB data disk by omitting all properties. You can also create a disk that is larger than the default size by specifying the sizeGb property.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   String sourceImage = "";
   *   Disk diskResource = Disk.newBuilder().build();
   *   Operation response = diskClient.insertDisk(zone, sourceImage, diskResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @param sourceImage Optional. Source image to restore onto a disk.
   * @param diskResource A Disk resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertDisk(ZoneName zone, String sourceImage, Disk diskResource) {

    InsertDiskHttpRequest request =
        InsertDiskHttpRequest.newBuilder()
        .setZone(zone == null ? null : zone.toString())
        .setSourceImage(sourceImage)
        .setDiskResource(diskResource)
        .build();
    return insertDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can create a disk with a sourceImage, a sourceSnapshot, or create an empty 500 GB data disk by omitting all properties. You can also create a disk that is larger than the default size by specifying the sizeGb property.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   String sourceImage = "";
   *   Disk diskResource = Disk.newBuilder().build();
   *   Operation response = diskClient.insertDisk(zone.toString(), sourceImage, diskResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @param sourceImage Optional. Source image to restore onto a disk.
   * @param diskResource A Disk resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertDisk(String zone, String sourceImage, Disk diskResource) {

    InsertDiskHttpRequest request =
        InsertDiskHttpRequest.newBuilder()
        .setZone(zone)
        .setSourceImage(sourceImage)
        .setDiskResource(diskResource)
        .build();
    return insertDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can create a disk with a sourceImage, a sourceSnapshot, or create an empty 500 GB data disk by omitting all properties. You can also create a disk that is larger than the default size by specifying the sizeGb property.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   String sourceImage = "";
   *   Disk diskResource = Disk.newBuilder().build();
   *   InsertDiskHttpRequest request = InsertDiskHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setSourceImage(sourceImage)
   *     .setDiskResource(diskResource)
   *     .build();
   *   Operation response = diskClient.insertDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertDisk(InsertDiskHttpRequest request) {
    return insertDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a persistent disk in the specified project using the data in the request. You can create a disk with a sourceImage, a sourceSnapshot, or create an empty 500 GB data disk by omitting all properties. You can also create a disk that is larger than the default size by specifying the sizeGb property.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   String sourceImage = "";
   *   Disk diskResource = Disk.newBuilder().build();
   *   InsertDiskHttpRequest request = InsertDiskHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setSourceImage(sourceImage)
   *     .setDiskResource(diskResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = diskClient.insertDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertDiskHttpRequest, Operation> insertDiskCallable() {
    return stub.insertDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Disk element : diskClient.listDisks(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListDisksPagedResponse listDisks(ZoneName zone) {
    ListDisksHttpRequest request =
        ListDisksHttpRequest.newBuilder()
        .setZone(zone == null ? null : zone.toString())
        .build();
    return listDisks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Disk element : diskClient.listDisks(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListDisksPagedResponse listDisks(String zone) {
    ListDisksHttpRequest request =
        ListDisksHttpRequest.newBuilder()
        .setZone(zone)
        .build();
    return listDisks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   ListDisksHttpRequest request = ListDisksHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (Disk element : diskClient.listDisks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListDisksPagedResponse listDisks(ListDisksHttpRequest request) {
    return listDisksPagedCallable()
        .call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   ListDisksHttpRequest request = ListDisksHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListDisksPagedResponse&gt; future = diskClient.listDisksPagedCallable().futureCall(request);
   *   // Do something
   *   for (Disk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListDisksHttpRequest, ListDisksPagedResponse> listDisksPagedCallable() {
    return stub.listDisksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of persistent disks contained within the specified zone.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   ZoneName zone = ZoneName.of("[PROJECT]", "[ZONE]");
   *   ListDisksHttpRequest request = ListDisksHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     DiskList response = diskClient.listDisksCallable().call(request);
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
  public final UnaryCallable<ListDisksHttpRequest, DiskList> listDisksCallable() {
    return stub.listDisksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   Operation response = diskClient.resizeDisk(disk, disksResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param disk The name of the persistent disk.
   * @param disksResizeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeDisk(DiskName disk, DisksResizeRequest disksResizeRequestResource) {

    ResizeDiskHttpRequest request =
        ResizeDiskHttpRequest.newBuilder()
        .setDisk(disk == null ? null : disk.toString())
        .setDisksResizeRequestResource(disksResizeRequestResource)
        .build();
    return resizeDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   Operation response = diskClient.resizeDisk(disk.toString(), disksResizeRequestResource);
   * }
   * </code></pre>
   *
   * @param disk The name of the persistent disk.
   * @param disksResizeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeDisk(String disk, DisksResizeRequest disksResizeRequestResource) {

    ResizeDiskHttpRequest request =
        ResizeDiskHttpRequest.newBuilder()
        .setDisk(disk)
        .setDisksResizeRequestResource(disksResizeRequestResource)
        .build();
    return resizeDisk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   ResizeDiskHttpRequest request = ResizeDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .setDisksResizeRequestResource(disksResizeRequestResource)
   *     .build();
   *   Operation response = diskClient.resizeDisk(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeDisk(ResizeDiskHttpRequest request) {
    return resizeDiskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the specified persistent disk.
   *
   * Sample code:
   * <pre><code>
   * try (DiskClient diskClient = DiskClient.create()) {
   *   DiskName disk = DiskName.of("[PROJECT]", "[ZONE]", "[DISK]");
   *   DisksResizeRequest disksResizeRequestResource = DisksResizeRequest.newBuilder().build();
   *   ResizeDiskHttpRequest request = ResizeDiskHttpRequest.newBuilder()
   *     .setDisk(disk.toString())
   *     .setDisksResizeRequestResource(disksResizeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = diskClient.resizeDiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResizeDiskHttpRequest, Operation> resizeDiskCallable() {
    return stub.resizeDiskCallable();
  }

  @Override
  public final void close() throws Exception {
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

  public static class AggregatedListDisksPagedResponse extends AbstractPagedListResponse<
      AggregatedListDisksHttpRequest,
      DiskAggregatedList,
      DisksScopedList,
      AggregatedListDisksPage,
      AggregatedListDisksFixedSizeCollection> {

    public static ApiFuture<AggregatedListDisksPagedResponse> createAsync(
        PageContext<AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList> context,
        ApiFuture<DiskAggregatedList> futureResponse) {
      ApiFuture<AggregatedListDisksPage> futurePage =
          AggregatedListDisksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListDisksPage, AggregatedListDisksPagedResponse>() {
            @Override
            public AggregatedListDisksPagedResponse apply(AggregatedListDisksPage input) {
              return new AggregatedListDisksPagedResponse(input);
            }
          });
    }

    private AggregatedListDisksPagedResponse(AggregatedListDisksPage page) {
      super(page, AggregatedListDisksFixedSizeCollection.createEmptyCollection());
    }


  }

  public static class AggregatedListDisksPage extends AbstractPage<
      AggregatedListDisksHttpRequest,
      DiskAggregatedList,
      DisksScopedList,
      AggregatedListDisksPage> {

    private AggregatedListDisksPage(
        PageContext<AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList> context,
        DiskAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListDisksPage createEmptyPage() {
      return new AggregatedListDisksPage(null, null);
    }

    @Override
    protected AggregatedListDisksPage createPage(
        PageContext<AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList> context,
        DiskAggregatedList response) {
      return new AggregatedListDisksPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListDisksPage> createPageAsync(
        PageContext<AggregatedListDisksHttpRequest, DiskAggregatedList, DisksScopedList> context,
        ApiFuture<DiskAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }




  }

  public static class AggregatedListDisksFixedSizeCollection extends AbstractFixedSizeCollection<
      AggregatedListDisksHttpRequest,
      DiskAggregatedList,
      DisksScopedList,
      AggregatedListDisksPage,
      AggregatedListDisksFixedSizeCollection> {

    private AggregatedListDisksFixedSizeCollection(List<AggregatedListDisksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListDisksFixedSizeCollection createEmptyCollection() {
      return new AggregatedListDisksFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListDisksFixedSizeCollection createCollection(
        List<AggregatedListDisksPage> pages, int collectionSize) {
      return new AggregatedListDisksFixedSizeCollection(pages, collectionSize);
    }


  }
  public static class ListDisksPagedResponse extends AbstractPagedListResponse<
      ListDisksHttpRequest,
      DiskList,
      Disk,
      ListDisksPage,
      ListDisksFixedSizeCollection> {

    public static ApiFuture<ListDisksPagedResponse> createAsync(
        PageContext<ListDisksHttpRequest, DiskList, Disk> context,
        ApiFuture<DiskList> futureResponse) {
      ApiFuture<ListDisksPage> futurePage =
          ListDisksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDisksPage, ListDisksPagedResponse>() {
            @Override
            public ListDisksPagedResponse apply(ListDisksPage input) {
              return new ListDisksPagedResponse(input);
            }
          });
    }

    private ListDisksPagedResponse(ListDisksPage page) {
      super(page, ListDisksFixedSizeCollection.createEmptyCollection());
    }


  }

  public static class ListDisksPage extends AbstractPage<
      ListDisksHttpRequest,
      DiskList,
      Disk,
      ListDisksPage> {

    private ListDisksPage(
        PageContext<ListDisksHttpRequest, DiskList, Disk> context,
        DiskList response) {
      super(context, response);
    }

    private static ListDisksPage createEmptyPage() {
      return new ListDisksPage(null, null);
    }

    @Override
    protected ListDisksPage createPage(
        PageContext<ListDisksHttpRequest, DiskList, Disk> context,
        DiskList response) {
      return new ListDisksPage(context, response);
    }

    @Override
    public ApiFuture<ListDisksPage> createPageAsync(
        PageContext<ListDisksHttpRequest, DiskList, Disk> context,
        ApiFuture<DiskList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }




  }

  public static class ListDisksFixedSizeCollection extends AbstractFixedSizeCollection<
      ListDisksHttpRequest,
      DiskList,
      Disk,
      ListDisksPage,
      ListDisksFixedSizeCollection> {

    private ListDisksFixedSizeCollection(List<ListDisksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDisksFixedSizeCollection createEmptyCollection() {
      return new ListDisksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDisksFixedSizeCollection createCollection(
        List<ListDisksPage> pages, int collectionSize) {
      return new ListDisksFixedSizeCollection(pages, collectionSize);
    }


  }
}