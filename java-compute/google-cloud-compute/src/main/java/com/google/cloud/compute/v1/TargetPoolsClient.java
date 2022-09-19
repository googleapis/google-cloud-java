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
import com.google.cloud.compute.v1.stub.TargetPoolsStub;
import com.google.cloud.compute.v1.stub.TargetPoolsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The TargetPools API.
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
 * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String targetPool = "targetPool486493517";
 *   TargetPool response = targetPoolsClient.get(project, region, targetPool);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetPoolsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of TargetPoolsSettings to
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
 * TargetPoolsSettings targetPoolsSettings =
 *     TargetPoolsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetPoolsClient targetPoolsClient = TargetPoolsClient.create(targetPoolsSettings);
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
 * TargetPoolsSettings targetPoolsSettings =
 *     TargetPoolsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetPoolsClient targetPoolsClient = TargetPoolsClient.create(targetPoolsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TargetPoolsClient implements BackgroundResource {
  private final TargetPoolsSettings settings;
  private final TargetPoolsStub stub;

  /** Constructs an instance of TargetPoolsClient with default settings. */
  public static final TargetPoolsClient create() throws IOException {
    return create(TargetPoolsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetPoolsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetPoolsClient create(TargetPoolsSettings settings) throws IOException {
    return new TargetPoolsClient(settings);
  }

  /**
   * Constructs an instance of TargetPoolsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TargetPoolsSettings).
   */
  public static final TargetPoolsClient create(TargetPoolsStub stub) {
    return new TargetPoolsClient(stub);
  }

  /**
   * Constructs an instance of TargetPoolsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetPoolsClient(TargetPoolsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetPoolsStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetPoolsClient(TargetPoolsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetPoolsSettings getSettings() {
    return settings;
  }

  public TargetPoolsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource =
   *       TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   Operation response =
   *       targetPoolsClient
   *           .addHealthCheckAsync(
   *               project, region, targetPool, targetPoolsAddHealthCheckRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the target pool to add a health check to.
   * @param targetPoolsAddHealthCheckRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addHealthCheckAsync(
      String project,
      String region,
      String targetPool,
      TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource) {
    AddHealthCheckTargetPoolRequest request =
        AddHealthCheckTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
            .build();
    return addHealthCheckAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AddHealthCheckTargetPoolRequest request =
   *       AddHealthCheckTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsAddHealthCheckRequestResource(
   *               TargetPoolsAddHealthCheckRequest.newBuilder().build())
   *           .build();
   *   Operation response = targetPoolsClient.addHealthCheckAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addHealthCheckAsync(
      AddHealthCheckTargetPoolRequest request) {
    return addHealthCheckOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AddHealthCheckTargetPoolRequest request =
   *       AddHealthCheckTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsAddHealthCheckRequestResource(
   *               TargetPoolsAddHealthCheckRequest.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.addHealthCheckOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationCallable() {
    return stub.addHealthCheckOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AddHealthCheckTargetPoolRequest request =
   *       AddHealthCheckTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsAddHealthCheckRequestResource(
   *               TargetPoolsAddHealthCheckRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetPoolsClient.addHealthCheckCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable() {
    return stub.addHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource =
   *       TargetPoolsAddInstanceRequest.newBuilder().build();
   *   Operation response =
   *       targetPoolsClient
   *           .addInstanceAsync(project, region, targetPool, targetPoolsAddInstanceRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to add instances to.
   * @param targetPoolsAddInstanceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addInstanceAsync(
      String project,
      String region,
      String targetPool,
      TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource) {
    AddInstanceTargetPoolRequest request =
        AddInstanceTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
            .build();
    return addInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AddInstanceTargetPoolRequest request =
   *       AddInstanceTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsAddInstanceRequestResource(
   *               TargetPoolsAddInstanceRequest.newBuilder().build())
   *           .build();
   *   Operation response = targetPoolsClient.addInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addInstanceAsync(
      AddInstanceTargetPoolRequest request) {
    return addInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AddInstanceTargetPoolRequest request =
   *       AddInstanceTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsAddInstanceRequestResource(
   *               TargetPoolsAddInstanceRequest.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.addInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationCallable() {
    return stub.addInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AddInstanceTargetPoolRequest request =
   *       AddInstanceTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsAddInstanceRequestResource(
   *               TargetPoolsAddInstanceRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetPoolsClient.addInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable() {
    return stub.addInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, TargetPoolsScopedList> element :
   *       targetPoolsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetPoolsRequest request =
        AggregatedListTargetPoolsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AggregatedListTargetPoolsRequest request =
   *       AggregatedListTargetPoolsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, TargetPoolsScopedList> element :
   *       targetPoolsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetPoolsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AggregatedListTargetPoolsRequest request =
   *       AggregatedListTargetPoolsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, TargetPoolsScopedList>> future =
   *       targetPoolsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, TargetPoolsScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   AggregatedListTargetPoolsRequest request =
   *       AggregatedListTargetPoolsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetPoolAggregatedList response =
   *         targetPoolsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, TargetPoolsScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   Operation response = targetPoolsClient.deleteAsync(project, region, targetPool).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String targetPool) {
    DeleteTargetPoolRequest request =
        DeleteTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   DeleteTargetPoolRequest request =
   *       DeleteTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   Operation response = targetPoolsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteTargetPoolRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   DeleteTargetPoolRequest request =
   *       DeleteTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   DeleteTargetPoolRequest request =
   *       DeleteTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   ApiFuture<Operation> future = targetPoolsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   TargetPool response = targetPoolsClient.get(project, region, targetPool);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetPool get(String project, String region, String targetPool) {
    GetTargetPoolRequest request =
        GetTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   GetTargetPoolRequest request =
   *       GetTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   TargetPool response = targetPoolsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetPool get(GetTargetPoolRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   GetTargetPoolRequest request =
   *       GetTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   ApiFuture<TargetPool> future = targetPoolsClient.getCallable().futureCall(request);
   *   // Do something.
   *   TargetPool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   TargetPoolInstanceHealth response =
   *       targetPoolsClient.getHealth(project, region, targetPool, instanceReferenceResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to which the queried instance belongs.
   * @param instanceReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetPoolInstanceHealth getHealth(
      String project,
      String region,
      String targetPool,
      InstanceReference instanceReferenceResource) {
    GetHealthTargetPoolRequest request =
        GetHealthTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setInstanceReferenceResource(instanceReferenceResource)
            .build();
    return getHealth(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   GetHealthTargetPoolRequest request =
   *       GetHealthTargetPoolRequest.newBuilder()
   *           .setInstanceReferenceResource(InstanceReference.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   TargetPoolInstanceHealth response = targetPoolsClient.getHealth(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetPoolInstanceHealth getHealth(GetHealthTargetPoolRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   GetHealthTargetPoolRequest request =
   *       GetHealthTargetPoolRequest.newBuilder()
   *           .setInstanceReferenceResource(InstanceReference.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setTargetPool("targetPool486493517")
   *           .build();
   *   ApiFuture<TargetPoolInstanceHealth> future =
   *       targetPoolsClient.getHealthCallable().futureCall(request);
   *   // Do something.
   *   TargetPoolInstanceHealth response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthCallable() {
    return stub.getHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target pool in the specified project and region using the data included in the
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   Operation response = targetPoolsClient.insertAsync(project, region, targetPoolResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPoolResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, TargetPool targetPoolResource) {
    InsertTargetPoolRequest request =
        InsertTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPoolResource(targetPoolResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target pool in the specified project and region using the data included in the
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   InsertTargetPoolRequest request =
   *       InsertTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPoolResource(TargetPool.newBuilder().build())
   *           .build();
   *   Operation response = targetPoolsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(InsertTargetPoolRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target pool in the specified project and region using the data included in the
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   InsertTargetPoolRequest request =
   *       InsertTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPoolResource(TargetPool.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertTargetPoolRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a target pool in the specified project and region using the data included in the
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
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   InsertTargetPoolRequest request =
   *       InsertTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPoolResource(TargetPool.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetPoolsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (TargetPool element : targetPoolsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListTargetPoolsRequest request =
        ListTargetPoolsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   ListTargetPoolsRequest request =
   *       ListTargetPoolsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (TargetPool element : targetPoolsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetPoolsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   ListTargetPoolsRequest request =
   *       ListTargetPoolsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<TargetPool> future = targetPoolsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetPool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   ListTargetPoolsRequest request =
   *       ListTargetPoolsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     TargetPoolList response = targetPoolsClient.listCallable().call(request);
   *     for (TargetPool element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource =
   *       TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   Operation response =
   *       targetPoolsClient
   *           .removeHealthCheckAsync(
   *               project, region, targetPool, targetPoolsRemoveHealthCheckRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetPool Name of the target pool to remove health checks from.
   * @param targetPoolsRemoveHealthCheckRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeHealthCheckAsync(
      String project,
      String region,
      String targetPool,
      TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource) {
    RemoveHealthCheckTargetPoolRequest request =
        RemoveHealthCheckTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setTargetPoolsRemoveHealthCheckRequestResource(
                targetPoolsRemoveHealthCheckRequestResource)
            .build();
    return removeHealthCheckAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   RemoveHealthCheckTargetPoolRequest request =
   *       RemoveHealthCheckTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsRemoveHealthCheckRequestResource(
   *               TargetPoolsRemoveHealthCheckRequest.newBuilder().build())
   *           .build();
   *   Operation response = targetPoolsClient.removeHealthCheckAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeHealthCheckAsync(
      RemoveHealthCheckTargetPoolRequest request) {
    return removeHealthCheckOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   RemoveHealthCheckTargetPoolRequest request =
   *       RemoveHealthCheckTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsRemoveHealthCheckRequestResource(
   *               TargetPoolsRemoveHealthCheckRequest.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.removeHealthCheckOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationCallable() {
    return stub.removeHealthCheckOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   RemoveHealthCheckTargetPoolRequest request =
   *       RemoveHealthCheckTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsRemoveHealthCheckRequestResource(
   *               TargetPoolsRemoveHealthCheckRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       targetPoolsClient.removeHealthCheckCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckCallable() {
    return stub.removeHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource =
   *       TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   Operation response =
   *       targetPoolsClient
   *           .removeInstanceAsync(
   *               project, region, targetPool, targetPoolsRemoveInstanceRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to remove instances from.
   * @param targetPoolsRemoveInstanceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeInstanceAsync(
      String project,
      String region,
      String targetPool,
      TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource) {
    RemoveInstanceTargetPoolRequest request =
        RemoveInstanceTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
            .build();
    return removeInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   RemoveInstanceTargetPoolRequest request =
   *       RemoveInstanceTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsRemoveInstanceRequestResource(
   *               TargetPoolsRemoveInstanceRequest.newBuilder().build())
   *           .build();
   *   Operation response = targetPoolsClient.removeInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeInstanceAsync(
      RemoveInstanceTargetPoolRequest request) {
    return removeInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   RemoveInstanceTargetPoolRequest request =
   *       RemoveInstanceTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsRemoveInstanceRequestResource(
   *               TargetPoolsRemoveInstanceRequest.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.removeInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationCallable() {
    return stub.removeInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   RemoveInstanceTargetPoolRequest request =
   *       RemoveInstanceTargetPoolRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetPoolsRemoveInstanceRequestResource(
   *               TargetPoolsRemoveInstanceRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetPoolsClient.removeInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable() {
    return stub.removeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String targetPool = "targetPool486493517";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response =
   *       targetPoolsClient
   *           .setBackupAsync(project, region, targetPool, targetReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to set a backup pool for.
   * @param targetReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setBackupAsync(
      String project, String region, String targetPool, TargetReference targetReferenceResource) {
    SetBackupTargetPoolRequest request =
        SetBackupTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   SetBackupTargetPoolRequest request =
   *       SetBackupTargetPoolRequest.newBuilder()
   *           .setFailoverRatio(-861074818)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetReferenceResource(TargetReference.newBuilder().build())
   *           .build();
   *   Operation response = targetPoolsClient.setBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setBackupAsync(
      SetBackupTargetPoolRequest request) {
    return setBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   SetBackupTargetPoolRequest request =
   *       SetBackupTargetPoolRequest.newBuilder()
   *           .setFailoverRatio(-861074818)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetReferenceResource(TargetReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       targetPoolsClient.setBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationCallable() {
    return stub.setBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   SetBackupTargetPoolRequest request =
   *       SetBackupTargetPoolRequest.newBuilder()
   *           .setFailoverRatio(-861074818)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setTargetPool("targetPool486493517")
   *           .setTargetReferenceResource(TargetReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = targetPoolsClient.setBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetBackupTargetPoolRequest, Operation> setBackupCallable() {
    return stub.setBackupCallable();
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
          AggregatedListTargetPoolsRequest,
          TargetPoolAggregatedList,
          Map.Entry<String, TargetPoolsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Map.Entry<String, TargetPoolsScopedList>>
            context,
        ApiFuture<TargetPoolAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListTargetPoolsRequest,
          TargetPoolAggregatedList,
          Map.Entry<String, TargetPoolsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Map.Entry<String, TargetPoolsScopedList>>
            context,
        TargetPoolAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Map.Entry<String, TargetPoolsScopedList>>
            context,
        TargetPoolAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Map.Entry<String, TargetPoolsScopedList>>
            context,
        ApiFuture<TargetPoolAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetPoolsRequest,
          TargetPoolAggregatedList,
          Map.Entry<String, TargetPoolsScopedList>,
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
          ListTargetPoolsRequest, TargetPoolList, TargetPool, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetPoolsRequest, TargetPoolList, TargetPool> context,
        ApiFuture<TargetPoolList> futureResponse) {
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
      extends AbstractPage<ListTargetPoolsRequest, TargetPoolList, TargetPool, ListPage> {

    private ListPage(
        PageContext<ListTargetPoolsRequest, TargetPoolList, TargetPool> context,
        TargetPoolList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetPoolsRequest, TargetPoolList, TargetPool> context,
        TargetPoolList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetPoolsRequest, TargetPoolList, TargetPool> context,
        ApiFuture<TargetPoolList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetPoolsRequest, TargetPoolList, TargetPool, ListPage, ListFixedSizeCollection> {

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
