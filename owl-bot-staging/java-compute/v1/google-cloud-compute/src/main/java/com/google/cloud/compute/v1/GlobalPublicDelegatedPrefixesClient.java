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
import com.google.cloud.compute.v1.stub.GlobalPublicDelegatedPrefixesStub;
import com.google.cloud.compute.v1.stub.GlobalPublicDelegatedPrefixesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The GlobalPublicDelegatedPrefixes API.
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
 * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
 *     GlobalPublicDelegatedPrefixesClient.create()) {
 *   String project = "project-309310695";
 *   String publicDelegatedPrefix = "publicDelegatedPrefix-663003832";
 *   PublicDelegatedPrefix response =
 *       globalPublicDelegatedPrefixesClient.get(project, publicDelegatedPrefix);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GlobalPublicDelegatedPrefixesClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * GlobalPublicDelegatedPrefixesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GlobalPublicDelegatedPrefixesSettings globalPublicDelegatedPrefixesSettings =
 *     GlobalPublicDelegatedPrefixesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
 *     GlobalPublicDelegatedPrefixesClient.create(globalPublicDelegatedPrefixesSettings);
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
 * GlobalPublicDelegatedPrefixesSettings globalPublicDelegatedPrefixesSettings =
 *     GlobalPublicDelegatedPrefixesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
 *     GlobalPublicDelegatedPrefixesClient.create(globalPublicDelegatedPrefixesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GlobalPublicDelegatedPrefixesClient implements BackgroundResource {
  private final GlobalPublicDelegatedPrefixesSettings settings;
  private final GlobalPublicDelegatedPrefixesStub stub;

  /** Constructs an instance of GlobalPublicDelegatedPrefixesClient with default settings. */
  public static final GlobalPublicDelegatedPrefixesClient create() throws IOException {
    return create(GlobalPublicDelegatedPrefixesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalPublicDelegatedPrefixesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GlobalPublicDelegatedPrefixesClient create(
      GlobalPublicDelegatedPrefixesSettings settings) throws IOException {
    return new GlobalPublicDelegatedPrefixesClient(settings);
  }

  /**
   * Constructs an instance of GlobalPublicDelegatedPrefixesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GlobalPublicDelegatedPrefixesSettings).
   */
  public static final GlobalPublicDelegatedPrefixesClient create(
      GlobalPublicDelegatedPrefixesStub stub) {
    return new GlobalPublicDelegatedPrefixesClient(stub);
  }

  /**
   * Constructs an instance of GlobalPublicDelegatedPrefixesClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalPublicDelegatedPrefixesClient(GlobalPublicDelegatedPrefixesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((GlobalPublicDelegatedPrefixesStubSettings) settings.getStubSettings()).createStub();
  }

  protected GlobalPublicDelegatedPrefixesClient(GlobalPublicDelegatedPrefixesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalPublicDelegatedPrefixesSettings getSettings() {
    return settings;
  }

  public GlobalPublicDelegatedPrefixesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   String publicDelegatedPrefix = "publicDelegatedPrefix-663003832";
   *   Operation response =
   *       globalPublicDelegatedPrefixesClient.deleteAsync(project, publicDelegatedPrefix).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefix Name of the PublicDelegatedPrefix resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String publicDelegatedPrefix) {
    DeleteGlobalPublicDelegatedPrefixeRequest request =
        DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefix(publicDelegatedPrefix)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   DeleteGlobalPublicDelegatedPrefixeRequest request =
   *       DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalPublicDelegatedPrefixesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteGlobalPublicDelegatedPrefixeRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   DeleteGlobalPublicDelegatedPrefixeRequest request =
   *       DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalPublicDelegatedPrefixesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   DeleteGlobalPublicDelegatedPrefixeRequest request =
   *       DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalPublicDelegatedPrefixesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>
      deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global PublicDelegatedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   String publicDelegatedPrefix = "publicDelegatedPrefix-663003832";
   *   PublicDelegatedPrefix response =
   *       globalPublicDelegatedPrefixesClient.get(project, publicDelegatedPrefix);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefix Name of the PublicDelegatedPrefix resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicDelegatedPrefix get(String project, String publicDelegatedPrefix) {
    GetGlobalPublicDelegatedPrefixeRequest request =
        GetGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefix(publicDelegatedPrefix)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global PublicDelegatedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   GetGlobalPublicDelegatedPrefixeRequest request =
   *       GetGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .build();
   *   PublicDelegatedPrefix response = globalPublicDelegatedPrefixesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicDelegatedPrefix get(GetGlobalPublicDelegatedPrefixeRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified global PublicDelegatedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   GetGlobalPublicDelegatedPrefixeRequest request =
   *       GetGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .build();
   *   ApiFuture<PublicDelegatedPrefix> future =
   *       globalPublicDelegatedPrefixesClient.getCallable().futureCall(request);
   *   // Do something.
   *   PublicDelegatedPrefix response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource =
   *       PublicDelegatedPrefix.newBuilder().build();
   *   Operation response =
   *       globalPublicDelegatedPrefixesClient
   *           .insertAsync(project, publicDelegatedPrefixResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefixResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, PublicDelegatedPrefix publicDelegatedPrefixResource) {
    InsertGlobalPublicDelegatedPrefixeRequest request =
        InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   InsertGlobalPublicDelegatedPrefixeRequest request =
   *       InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefixResource(PublicDelegatedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalPublicDelegatedPrefixesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertGlobalPublicDelegatedPrefixeRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   InsertGlobalPublicDelegatedPrefixeRequest request =
   *       InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefixResource(PublicDelegatedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalPublicDelegatedPrefixesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   InsertGlobalPublicDelegatedPrefixeRequest request =
   *       InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefixResource(PublicDelegatedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalPublicDelegatedPrefixesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation>
      insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   for (PublicDelegatedPrefix element :
   *       globalPublicDelegatedPrefixesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalPublicDelegatedPrefixesRequest request =
        ListGlobalPublicDelegatedPrefixesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   ListGlobalPublicDelegatedPrefixesRequest request =
   *       ListGlobalPublicDelegatedPrefixesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (PublicDelegatedPrefix element :
   *       globalPublicDelegatedPrefixesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalPublicDelegatedPrefixesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   ListGlobalPublicDelegatedPrefixesRequest request =
   *       ListGlobalPublicDelegatedPrefixesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<PublicDelegatedPrefix> future =
   *       globalPublicDelegatedPrefixesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PublicDelegatedPrefix element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   ListGlobalPublicDelegatedPrefixesRequest request =
   *       ListGlobalPublicDelegatedPrefixesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     PublicDelegatedPrefixList response =
   *         globalPublicDelegatedPrefixesClient.listCallable().call(request);
   *     for (PublicDelegatedPrefix element : response.getItemsList()) {
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
  public final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   String publicDelegatedPrefix = "publicDelegatedPrefix-663003832";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource =
   *       PublicDelegatedPrefix.newBuilder().build();
   *   Operation response =
   *       globalPublicDelegatedPrefixesClient
   *           .patchAsync(project, publicDelegatedPrefix, publicDelegatedPrefixResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefix Name of the PublicDelegatedPrefix resource to patch.
   * @param publicDelegatedPrefixResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project,
      String publicDelegatedPrefix,
      PublicDelegatedPrefix publicDelegatedPrefixResource) {
    PatchGlobalPublicDelegatedPrefixeRequest request =
        PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefix(publicDelegatedPrefix)
            .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   PatchGlobalPublicDelegatedPrefixeRequest request =
   *       PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .setPublicDelegatedPrefixResource(PublicDelegatedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalPublicDelegatedPrefixesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchGlobalPublicDelegatedPrefixeRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   PatchGlobalPublicDelegatedPrefixeRequest request =
   *       PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .setPublicDelegatedPrefixResource(PublicDelegatedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalPublicDelegatedPrefixesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
   *     GlobalPublicDelegatedPrefixesClient.create()) {
   *   PatchGlobalPublicDelegatedPrefixeRequest request =
   *       PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicDelegatedPrefix("publicDelegatedPrefix-663003832")
   *           .setPublicDelegatedPrefixResource(PublicDelegatedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalPublicDelegatedPrefixesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
          ListGlobalPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixList,
          PublicDelegatedPrefix,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        ApiFuture<PublicDelegatedPrefixList> futureResponse) {
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
      extends AbstractPage<
          ListGlobalPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixList,
          PublicDelegatedPrefix,
          ListPage> {

    private ListPage(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        PublicDelegatedPrefixList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        PublicDelegatedPrefixList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        ApiFuture<PublicDelegatedPrefixList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixList,
          PublicDelegatedPrefix,
          ListPage,
          ListFixedSizeCollection> {

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
