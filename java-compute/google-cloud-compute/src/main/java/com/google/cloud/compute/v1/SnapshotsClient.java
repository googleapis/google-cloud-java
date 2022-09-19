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
import com.google.cloud.compute.v1.stub.SnapshotsStub;
import com.google.cloud.compute.v1.stub.SnapshotsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Snapshots API.
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
 * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
 *   String project = "project-309310695";
 *   String snapshot = "snapshot284874180";
 *   Snapshot response = snapshotsClient.get(project, snapshot);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SnapshotsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SnapshotsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SnapshotsSettings snapshotsSettings =
 *     SnapshotsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SnapshotsClient snapshotsClient = SnapshotsClient.create(snapshotsSettings);
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
 * SnapshotsSettings snapshotsSettings =
 *     SnapshotsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SnapshotsClient snapshotsClient = SnapshotsClient.create(snapshotsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SnapshotsClient implements BackgroundResource {
  private final SnapshotsSettings settings;
  private final SnapshotsStub stub;

  /** Constructs an instance of SnapshotsClient with default settings. */
  public static final SnapshotsClient create() throws IOException {
    return create(SnapshotsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SnapshotsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SnapshotsClient create(SnapshotsSettings settings) throws IOException {
    return new SnapshotsClient(settings);
  }

  /**
   * Constructs an instance of SnapshotsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SnapshotsSettings).
   */
  public static final SnapshotsClient create(SnapshotsStub stub) {
    return new SnapshotsClient(stub);
  }

  /**
   * Constructs an instance of SnapshotsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SnapshotsClient(SnapshotsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SnapshotsStubSettings) settings.getStubSettings()).createStub();
  }

  protected SnapshotsClient(SnapshotsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SnapshotsSettings getSettings() {
    return settings;
  }

  public SnapshotsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot. For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   String snapshot = "snapshot284874180";
   *   Operation response = snapshotsClient.deleteAsync(project, snapshot).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param snapshot Name of the Snapshot resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(String project, String snapshot) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder().setProject(project).setSnapshot(snapshot).build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot. For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshot("snapshot284874180")
   *           .build();
   *   Operation response = snapshotsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteSnapshotRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot. For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshot("snapshot284874180")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       snapshotsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSnapshotRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot. For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshot("snapshot284874180")
   *           .build();
   *   ApiFuture<Operation> future = snapshotsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSnapshotRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Snapshot resource. Gets a list of available snapshots by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   String snapshot = "snapshot284874180";
   *   Snapshot response = snapshotsClient.get(project, snapshot);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param snapshot Name of the Snapshot resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot get(String project, String snapshot) {
    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder().setProject(project).setSnapshot(snapshot).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Snapshot resource. Gets a list of available snapshots by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSnapshot("snapshot284874180")
   *           .build();
   *   Snapshot response = snapshotsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot get(GetSnapshotRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Snapshot resource. Gets a list of available snapshots by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSnapshot("snapshot284874180")
   *           .build();
   *   ApiFuture<Snapshot> future = snapshotsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnapshotRequest, Snapshot> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   Policy response = snapshotsClient.getIamPolicy(project, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String resource) {
    GetIamPolicySnapshotRequest request =
        GetIamPolicySnapshotRequest.newBuilder().setProject(project).setResource(resource).build();
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GetIamPolicySnapshotRequest request =
   *       GetIamPolicySnapshotRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = snapshotsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicySnapshotRequest request) {
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GetIamPolicySnapshotRequest request =
   *       GetIamPolicySnapshotRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = snapshotsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicySnapshotRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot in the specified project using the data included in the request. For regular
   * snapshot creation, consider using this method instead of disks.createSnapshot, as this method
   * supports more features, such as creating snapshots in a project different from the source disk
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   Snapshot snapshotResource = Snapshot.newBuilder().build();
   *   Operation response = snapshotsClient.insertAsync(project, snapshotResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param snapshotResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, Snapshot snapshotResource) {
    InsertSnapshotRequest request =
        InsertSnapshotRequest.newBuilder()
            .setProject(project)
            .setSnapshotResource(snapshotResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot in the specified project using the data included in the request. For regular
   * snapshot creation, consider using this method instead of disks.createSnapshot, as this method
   * supports more features, such as creating snapshots in a project different from the source disk
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   InsertSnapshotRequest request =
   *       InsertSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotResource(Snapshot.newBuilder().build())
   *           .build();
   *   Operation response = snapshotsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(InsertSnapshotRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot in the specified project using the data included in the request. For regular
   * snapshot creation, consider using this method instead of disks.createSnapshot, as this method
   * supports more features, such as creating snapshots in a project different from the source disk
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   InsertSnapshotRequest request =
   *       InsertSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotResource(Snapshot.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       snapshotsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertSnapshotRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot in the specified project using the data included in the request. For regular
   * snapshot creation, consider using this method instead of disks.createSnapshot, as this method
   * supports more features, such as creating snapshots in a project different from the source disk
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   InsertSnapshotRequest request =
   *       InsertSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSnapshotResource(Snapshot.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = snapshotsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertSnapshotRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   for (Snapshot element : snapshotsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Snapshot element : snapshotsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSnapshotsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Snapshot> future = snapshotsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Snapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     SnapshotList response = snapshotsClient.listCallable().call(request);
   *     for (Snapshot element : response.getItemsList()) {
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
  public final UnaryCallable<ListSnapshotsRequest, SnapshotList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource =
   *       GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       snapshotsClient.setIamPolicy(project, resource, globalSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {
    SetIamPolicySnapshotRequest request =
        SetIamPolicySnapshotRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   SetIamPolicySnapshotRequest request =
   *       SetIamPolicySnapshotRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = snapshotsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicySnapshotRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   SetIamPolicySnapshotRequest request =
   *       SetIamPolicySnapshotRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = snapshotsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicySnapshotRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource =
   *       GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       snapshotsClient.setLabelsAsync(project, resource, globalSetLabelsRequestResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      String project, String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {
    SetLabelsSnapshotRequest request =
        SetLabelsSnapshotRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   SetLabelsSnapshotRequest request =
   *       SetLabelsSnapshotRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Operation response = snapshotsClient.setLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      SetLabelsSnapshotRequest request) {
    return setLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   SetLabelsSnapshotRequest request =
   *       SetLabelsSnapshotRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       snapshotsClient.setLabelsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetLabelsSnapshotRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return stub.setLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   SetLabelsSnapshotRequest request =
   *       SetLabelsSnapshotRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Operation> future = snapshotsClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsSnapshotRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       snapshotsClient.testIamPermissions(project, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsSnapshotRequest request =
        TestIamPermissionsSnapshotRequest.newBuilder()
            .setProject(project)
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   TestIamPermissionsSnapshotRequest request =
   *       TestIamPermissionsSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = snapshotsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsSnapshotRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   TestIamPermissionsSnapshotRequest request =
   *       TestIamPermissionsSnapshotRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       snapshotsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsSnapshotRequest, TestPermissionsResponse>
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
          ListSnapshotsRequest, SnapshotList, Snapshot, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListSnapshotsRequest, SnapshotList, Snapshot> context,
        ApiFuture<SnapshotList> futureResponse) {
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
      extends AbstractPage<ListSnapshotsRequest, SnapshotList, Snapshot, ListPage> {

    private ListPage(
        PageContext<ListSnapshotsRequest, SnapshotList, Snapshot> context, SnapshotList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListSnapshotsRequest, SnapshotList, Snapshot> context, SnapshotList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListSnapshotsRequest, SnapshotList, Snapshot> context,
        ApiFuture<SnapshotList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnapshotsRequest, SnapshotList, Snapshot, ListPage, ListFixedSizeCollection> {

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
