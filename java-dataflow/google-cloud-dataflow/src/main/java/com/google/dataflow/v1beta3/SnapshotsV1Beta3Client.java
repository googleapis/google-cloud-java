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

package com.google.dataflow.v1beta3;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.stub.SnapshotsV1Beta3Stub;
import com.google.dataflow.v1beta3.stub.SnapshotsV1Beta3StubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods to manage snapshots of Google Cloud Dataflow jobs.
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
 * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
 *   GetSnapshotRequest request =
 *       GetSnapshotRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setSnapshotId("snapshotId-1113817601")
 *           .setLocation("location1901043637")
 *           .build();
 *   Snapshot response = snapshotsV1Beta3Client.getSnapshot(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SnapshotsV1Beta3Client object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of SnapshotsV1Beta3Settings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SnapshotsV1Beta3Settings snapshotsV1Beta3Settings =
 *     SnapshotsV1Beta3Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SnapshotsV1Beta3Client snapshotsV1Beta3Client =
 *     SnapshotsV1Beta3Client.create(snapshotsV1Beta3Settings);
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
 * SnapshotsV1Beta3Settings snapshotsV1Beta3Settings =
 *     SnapshotsV1Beta3Settings.newBuilder().setEndpoint(myEndpoint).build();
 * SnapshotsV1Beta3Client snapshotsV1Beta3Client =
 *     SnapshotsV1Beta3Client.create(snapshotsV1Beta3Settings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SnapshotsV1Beta3Settings snapshotsV1Beta3Settings =
 *     SnapshotsV1Beta3Settings.newBuilder()
 *         .setTransportChannelProvider(
 *             SnapshotsV1Beta3Settings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * SnapshotsV1Beta3Client snapshotsV1Beta3Client =
 *     SnapshotsV1Beta3Client.create(snapshotsV1Beta3Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SnapshotsV1Beta3Client implements BackgroundResource {
  private final SnapshotsV1Beta3Settings settings;
  private final SnapshotsV1Beta3Stub stub;

  /** Constructs an instance of SnapshotsV1Beta3Client with default settings. */
  public static final SnapshotsV1Beta3Client create() throws IOException {
    return create(SnapshotsV1Beta3Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of SnapshotsV1Beta3Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SnapshotsV1Beta3Client create(SnapshotsV1Beta3Settings settings)
      throws IOException {
    return new SnapshotsV1Beta3Client(settings);
  }

  /**
   * Constructs an instance of SnapshotsV1Beta3Client, using the given stub for making calls. This
   * is for advanced usage - prefer using create(SnapshotsV1Beta3Settings).
   */
  public static final SnapshotsV1Beta3Client create(SnapshotsV1Beta3Stub stub) {
    return new SnapshotsV1Beta3Client(stub);
  }

  /**
   * Constructs an instance of SnapshotsV1Beta3Client, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SnapshotsV1Beta3Client(SnapshotsV1Beta3Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SnapshotsV1Beta3StubSettings) settings.getStubSettings()).createStub();
  }

  protected SnapshotsV1Beta3Client(SnapshotsV1Beta3Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SnapshotsV1Beta3Settings getSettings() {
    return settings;
  }

  public SnapshotsV1Beta3Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setSnapshotId("snapshotId-1113817601")
   *           .setLocation("location1901043637")
   *           .build();
   *   Snapshot response = snapshotsV1Beta3Client.getSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(GetSnapshotRequest request) {
    return getSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setSnapshotId("snapshotId-1113817601")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Snapshot> future = snapshotsV1Beta3Client.getSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return stub.getSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setSnapshotId("snapshotId-1113817601")
   *           .setLocation("location1901043637")
   *           .build();
   *   DeleteSnapshotResponse response = snapshotsV1Beta3Client.deleteSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteSnapshotResponse deleteSnapshot(DeleteSnapshotRequest request) {
    return deleteSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setSnapshotId("snapshotId-1113817601")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<DeleteSnapshotResponse> future =
   *       snapshotsV1Beta3Client.deleteSnapshotCallable().futureCall(request);
   *   // Do something.
   *   DeleteSnapshotResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSnapshotRequest, DeleteSnapshotResponse>
      deleteSnapshotCallable() {
    return stub.deleteSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .build();
   *   ListSnapshotsResponse response = snapshotsV1Beta3Client.listSnapshots(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsResponse listSnapshots(ListSnapshotsRequest request) {
    return listSnapshotsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobId("jobId101296568")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<ListSnapshotsResponse> future =
   *       snapshotsV1Beta3Client.listSnapshotsCallable().futureCall(request);
   *   // Do something.
   *   ListSnapshotsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return stub.listSnapshotsCallable();
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
}
