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

package com.google.cloud.run.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.stub.RevisionsStub;
import com.google.cloud.run.v2.stub.RevisionsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Run Revision Control Plane API.
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
 * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
 *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]");
 *   Revision response = revisionsClient.getRevision(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RevisionsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of RevisionsSettings to create().
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
 * RevisionsSettings revisionsSettings =
 *     RevisionsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RevisionsClient revisionsClient = RevisionsClient.create(revisionsSettings);
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
 * RevisionsSettings revisionsSettings =
 *     RevisionsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RevisionsClient revisionsClient = RevisionsClient.create(revisionsSettings);
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
 * RevisionsSettings revisionsSettings =
 *     RevisionsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             RevisionsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * RevisionsClient revisionsClient = RevisionsClient.create(revisionsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RevisionsClient implements BackgroundResource {
  private final RevisionsSettings settings;
  private final RevisionsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of RevisionsClient with default settings. */
  public static final RevisionsClient create() throws IOException {
    return create(RevisionsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RevisionsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RevisionsClient create(RevisionsSettings settings) throws IOException {
    return new RevisionsClient(settings);
  }

  /**
   * Constructs an instance of RevisionsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(RevisionsSettings).
   */
  public static final RevisionsClient create(RevisionsStub stub) {
    return new RevisionsClient(stub);
  }

  /**
   * Constructs an instance of RevisionsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected RevisionsClient(RevisionsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RevisionsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected RevisionsClient(RevisionsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final RevisionsSettings getSettings() {
    return settings;
  }

  public RevisionsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]");
   *   Revision response = revisionsClient.getRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Revision. Format:
   *     projects/{project}/locations/{location}/services/{service}/revisions/{revision}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(RevisionName name) {
    GetRevisionRequest request =
        GetRevisionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   String name =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString();
   *   Revision response = revisionsClient.getRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Revision. Format:
   *     projects/{project}/locations/{location}/services/{service}/revisions/{revision}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(String name) {
    GetRevisionRequest request = GetRevisionRequest.newBuilder().setName(name).build();
    return getRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   GetRevisionRequest request =
   *       GetRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
   *           .build();
   *   Revision response = revisionsClient.getRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(GetRevisionRequest request) {
    return getRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   GetRevisionRequest request =
   *       GetRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
   *           .build();
   *   ApiFuture<Revision> future = revisionsClient.getRevisionCallable().futureCall(request);
   *   // Do something.
   *   Revision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return stub.getRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Revisions from a given Service, or from a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   for (Revision element : revisionsClient.listRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Service from which the Revisions should be listed. To list all
   *     Revisions across Services, use "-" instead of Service name. Format:
   *     projects/{project}/locations/{location}/services/{service}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(ServiceName parent) {
    ListRevisionsRequest request =
        ListRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Revisions from a given Service, or from a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   String parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   for (Revision element : revisionsClient.listRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Service from which the Revisions should be listed. To list all
   *     Revisions across Services, use "-" instead of Service name. Format:
   *     projects/{project}/locations/{location}/services/{service}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(String parent) {
    ListRevisionsRequest request = ListRevisionsRequest.newBuilder().setParent(parent).build();
    return listRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Revisions from a given Service, or from a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Revision element : revisionsClient.listRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(ListRevisionsRequest request) {
    return listRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Revisions from a given Service, or from a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Revision> future = revisionsClient.listRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Revision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return stub.listRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Revisions from a given Service, or from a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListRevisionsResponse response = revisionsClient.listRevisionsCallable().call(request);
   *     for (Revision element : response.getRevisionsList()) {
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
  public final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return stub.listRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]");
   *   Revision response = revisionsClient.deleteRevisionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Revision to delete. Format:
   *     projects/{project}/locations/{location}/services/{service}/revisions/{revision}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Revision, Revision> deleteRevisionAsync(RevisionName name) {
    DeleteRevisionRequest request =
        DeleteRevisionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   String name =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString();
   *   Revision response = revisionsClient.deleteRevisionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Revision to delete. Format:
   *     projects/{project}/locations/{location}/services/{service}/revisions/{revision}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Revision, Revision> deleteRevisionAsync(String name) {
    DeleteRevisionRequest request = DeleteRevisionRequest.newBuilder().setName(name).build();
    return deleteRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   DeleteRevisionRequest request =
   *       DeleteRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Revision response = revisionsClient.deleteRevisionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Revision, Revision> deleteRevisionAsync(
      DeleteRevisionRequest request) {
    return deleteRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   DeleteRevisionRequest request =
   *       DeleteRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Revision, Revision> future =
   *       revisionsClient.deleteRevisionOperationCallable().futureCall(request);
   *   // Do something.
   *   Revision response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationCallable() {
    return stub.deleteRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
   *   DeleteRevisionRequest request =
   *       DeleteRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = revisionsClient.deleteRevisionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRevisionRequest, Operation> deleteRevisionCallable() {
    return stub.deleteRevisionCallable();
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

  public static class ListRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListRevisionsRequest,
          ListRevisionsResponse,
          Revision,
          ListRevisionsPage,
          ListRevisionsFixedSizeCollection> {

    public static ApiFuture<ListRevisionsPagedResponse> createAsync(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ApiFuture<ListRevisionsResponse> futureResponse) {
      ApiFuture<ListRevisionsPage> futurePage =
          ListRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRevisionsPagedResponse(ListRevisionsPage page) {
      super(page, ListRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRevisionsPage
      extends AbstractPage<
          ListRevisionsRequest, ListRevisionsResponse, Revision, ListRevisionsPage> {

    private ListRevisionsPage(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ListRevisionsResponse response) {
      super(context, response);
    }

    private static ListRevisionsPage createEmptyPage() {
      return new ListRevisionsPage(null, null);
    }

    @Override
    protected ListRevisionsPage createPage(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ListRevisionsResponse response) {
      return new ListRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListRevisionsPage> createPageAsync(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ApiFuture<ListRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRevisionsRequest,
          ListRevisionsResponse,
          Revision,
          ListRevisionsPage,
          ListRevisionsFixedSizeCollection> {

    private ListRevisionsFixedSizeCollection(List<ListRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRevisionsFixedSizeCollection createCollection(
        List<ListRevisionsPage> pages, int collectionSize) {
      return new ListRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
