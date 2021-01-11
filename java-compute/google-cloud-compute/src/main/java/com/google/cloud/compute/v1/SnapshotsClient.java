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
import com.google.cloud.compute.v1.stub.SnapshotsStub;
import com.google.cloud.compute.v1.stub.SnapshotsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Snapshots API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
 *   String project = "";
 *   String snapshot = "";
 *   Operation response = snapshotsClient.delete(project, snapshot);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the snapshotsClient object to clean up resources such as
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
 * <pre>
 * <code>
 * SnapshotsSettings snapshotsSettings =
 *     SnapshotsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SnapshotsClient snapshotsClient =
 *     SnapshotsClient.create(snapshotsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SnapshotsSettings snapshotsSettings =
 *     SnapshotsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SnapshotsClient snapshotsClient =
 *     SnapshotsClient.create(snapshotsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * advanced usage - prefer to use SnapshotsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SnapshotsClient(SnapshotsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SnapshotsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SnapshotsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot.
   *
   * <p>For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String snapshot = "";
   *   Operation response = snapshotsClient.delete(project, snapshot);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param snapshot Name of the Snapshot resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String snapshot) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder().setProject(project).setSnapshot(snapshot).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot.
   *
   * <p>For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String snapshot = "";
   *   DeleteSnapshotRequest request = DeleteSnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setSnapshot(snapshot)
   *     .build();
   *   Operation response = snapshotsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteSnapshotRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Snapshot resource. Keep in mind that deleting a single snapshot might not
   * necessarily delete all the data on that snapshot. If any data on the snapshot that is marked
   * for deletion is needed for subsequent snapshots, the data will be moved to the next
   * corresponding snapshot.
   *
   * <p>For more information, see Deleting snapshots.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String snapshot = "";
   *   DeleteSnapshotRequest request = DeleteSnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setSnapshot(snapshot)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = snapshotsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSnapshotRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Snapshot resource. Gets a list of available snapshots by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String snapshot = "";
   *   Snapshot response = snapshotsClient.get(project, snapshot);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Snapshot resource. Gets a list of available snapshots by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String snapshot = "";
   *   GetSnapshotRequest request = GetSnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setSnapshot(snapshot)
   *     .build();
   *   Snapshot response = snapshotsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot get(GetSnapshotRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Snapshot resource. Gets a list of available snapshots by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String snapshot = "";
   *   GetSnapshotRequest request = GetSnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setSnapshot(snapshot)
   *     .build();
   *   ApiFuture&lt;Snapshot&gt; future = snapshotsClient.getCallable().futureCall(request);
   *   // Do something
   *   Snapshot response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSnapshotRequest, Snapshot> getCallable() {
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
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   Policy response = snapshotsClient.getIamPolicy(project, resource);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GetIamPolicySnapshotRequest request = GetIamPolicySnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   Policy response = snapshotsClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicySnapshotRequest request) {
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
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GetIamPolicySnapshotRequest request = GetIamPolicySnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = snapshotsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicySnapshotRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   for (Snapshot element : snapshotsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Snapshot element : snapshotsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSnapshotsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = snapshotsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Snapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of Snapshot resources contained within the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, SnapshotList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response = snapshotsClient.setIamPolicy(project, resource, globalSetPolicyRequestResource);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetIamPolicySnapshotRequest request = SetIamPolicySnapshotRequest.newBuilder()
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   Policy response = snapshotsClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicySnapshotRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetIamPolicySnapshotRequest request = SetIamPolicySnapshotRequest.newBuilder()
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = snapshotsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicySnapshotRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response = snapshotsClient.setLabels(project, resource, globalSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(
      String project, String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {
    SetLabelsSnapshotRequest request =
        SetLabelsSnapshotRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetLabelsSnapshotRequest request = SetLabelsSnapshotRequest.newBuilder()
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   Operation response = snapshotsClient.setLabels(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsSnapshotRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the labels on a snapshot. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource = GlobalSetLabelsRequest.newBuilder().build();
   *   String project = "";
   *   String resource = "";
   *   SetLabelsSnapshotRequest request = SetLabelsSnapshotRequest.newBuilder()
   *     .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
   *     .setProject(project)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = snapshotsClient.setLabelsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLabelsSnapshotRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = snapshotsClient.testIamPermissions(project, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsSnapshotRequest request = TestIamPermissionsSnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = snapshotsClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsSnapshotRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SnapshotsClient snapshotsClient = SnapshotsClient.create()) {
   *   String project = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsSnapshotRequest request = TestIamPermissionsSnapshotRequest.newBuilder()
   *     .setProject(project)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = snapshotsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
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
